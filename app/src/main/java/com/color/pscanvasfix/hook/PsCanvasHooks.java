package com.color.pscanvasfix.hook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.color.pscanvasfix.compat.AtmCompat;
import com.color.pscanvasfix.compat.ConfigCompat;
import com.color.pscanvasfix.compat.FlexibleTransitionCompat;
import com.color.pscanvasfix.compat.I0Compat;
import com.color.pscanvasfix.compat.SplitPolicyCompat;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public final class PsCanvasHooks {
    private static final String TAG = "PsCanvasFix";
    private static final String TARGET_PACKAGE = "com.oplus.pscanvas";

    // 700 obfuscated class names
    private static final String UTIL = "B1.l";
    private static final String CONFIG = "B1.s";
    private static final String SSTO_FLEX = "x1.r";
    private static final String GESTURE_MGR = "com.oplus.pscanvas.canvasmode.canvas.C0332y";
    private static final String CONTAINER_ACTIVITY = "com.oplus.pscanvas.canvasmode.canvas.ContainerActivity";
    private static final String CONTAINER_VIEW = "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView";
    private static final String LAYOUT_CTRL = "com.oplus.pscanvas.canvasmode.canvas.C0327t";
    private static final String ADAPTER = "u1.C0600c";

    private interface HookBody {
        Object run(XC_MethodHook.MethodHookParam param) throws Throwable;
    }

    private interface HookBefore {
        void run(XC_MethodHook.MethodHookParam param) throws Throwable;
    }

    private interface HookAfter {
        void run(XC_MethodHook.MethodHookParam param) throws Throwable;
    }

    private PsCanvasHooks() {
    }

    public static void install(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!TARGET_PACKAGE.equals(lpparam.packageName)) {
            return;
        }
        XposedBridge.log(TAG + ": hooking " + lpparam.packageName + " build=12.0.0-700 (502 two-column panorama)");
        hook502BehaviorRestore(lpparam);
        hookTwoColumnPanoramaRestore(lpparam);
        hookWindowConfigUtils(lpparam);
        hookActivityTaskManagerCallers(lpparam);
        hookDirectWindowConfigurationAccess(lpparam);
        hookSplitToFlexibleTransition(lpparam);
    }

    /**
     * Restore 502 split-screen / five-finger pinch behavior on 700.
     */
    private static void hook502BehaviorRestore(XC_LoadPackage.LoadPackageParam lpparam) {
        // Enable panorama workstation (502 u0/temp_panorama_settings), not three-column layout
        replaceMethod(lpparam, UTIL, "F0", new Class[]{Context.class}, param -> true);

        // Force split-to-flexible path enabled (502 f11086L via u0)
        try {
            XposedHelpers.findAndHookConstructor(GESTURE_MGR, lpparam.classLoader, CONTAINER_ACTIVITY,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            XposedHelpers.setStaticBooleanField(
                                    XposedHelpers.findClass(GESTURE_MGR, lpparam.classLoader),
                                    "f10934L",
                                    true
                            );
                            XposedBridge.log(TAG + ": forced f10934L=true (502 split-to-flexible)");
                        }
                    });
        } catch (Throwable t) {
            XposedBridge.log(TAG + ": C0332y ctor hook failed: " + t);
        }

        // Restore 502 finger count: onScale requires >3 fingers (4+), not >=3
        hookScaleListener502(lpparam);
    }

    /**
     * Restore 502 three-app two-column panorama (2+1 peek + horizontal scroll).
     * Layout 3 = three columns visible at once; 502 uses 4/5/6/7 instead.
     */
    private static void hookTwoColumnPanoramaRestore(XC_LoadPackage.LoadPackageParam lpparam) {
        // 502 has no isThreeSplitTogether; 700 o0() injects it and FWM returns 3-column bounds.
        try {
            XposedHelpers.findAndHookMethod(Intent.class, "putExtra", String.class, boolean.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            if ("isThreeSplitTogether".equals(param.args[0])
                                    && Boolean.TRUE.equals(param.args[1])) {
                                param.setResult(param.thisObject);
                                XposedBridge.log(TAG + ": blocked Intent isThreeSplitTogether");
                            }
                        }
                    });
        } catch (Throwable t) {
            XposedBridge.log(TAG + ": Intent.putExtra hook failed: " + t);
        }

        replaceMethod(lpparam, UTIL, "n",
                new Class[]{List.class, Integer.TYPE, Bundle.class}, param -> {
                    Bundle bundle = (Bundle) param.args[2];
                    if (bundle != null && bundle.getBoolean("isThreeSplitTogether", false)) {
                        XposedBridge.log(TAG + ": blocked isThreeSplitTogether in calculateFlexibleWindowBounds");
                        param.args[2] = null;
                    }
                    return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
                });

        hookBeforeMethod(lpparam, UTIL, "o0",
                new Class[]{Context.class, List.class, Integer.TYPE}, param -> {
                    List<?> intents = (List<?>) param.args[1];
                    int layout = (Integer) param.args[2];
                    if (intents != null && intents.size() >= 3 && layout == 3) {
                        param.args[2] = 0;
                        XposedBridge.log(TAG + ": o0 layout 3 -> 0 for " + intents.size() + " apps");
                    }
                });

        // B1.e.c(): when A()==true and count==3, layout becomes 3 (three columns).
        replaceMethod(lpparam, ADAPTER, "A", new Class[0], param -> {
            int count = (Integer) XposedHelpers.callMethod(param.thisObject, "getCount");
            if (count == 3) {
                return false;
            }
            return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
        });

        hookBeforeMethod(lpparam, ADAPTER, "M", new Class[]{Integer.TYPE}, param -> {
            int count = (Integer) XposedHelpers.callMethod(param.thisObject, "getCount");
            if (count == 3 && (Integer) param.args[0] == 3) {
                param.args[0] = 0;
                XposedBridge.log(TAG + ": M(3) -> M(0) for 3-app layout");
            }
        });

        // T() skips relayout when f13788f==3; unblock before it runs.
        hookBeforeMethod(lpparam, ADAPTER, "T",
                new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, param -> {
                    int count = (Integer) XposedHelpers.callMethod(param.thisObject, "getCount");
                    int layout = XposedHelpers.getIntField(param.thisObject, "f13788f");
                    if (count == 3 && layout == 3) {
                        XposedHelpers.setIntField(param.thisObject, "f13788f", 0);
                        XposedBridge.log(TAG + ": T() unblocked, f13788f 3 -> 0");
                    }
                });

        hookAfterMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            ensureTwoColumnLayout(param.thisObject, "f()");
        });

        hookAfterMethod(lpparam, "B1.e", "c",
                new Class[]{
                        XposedHelpers.findClass(ADAPTER, lpparam.classLoader),
                        Integer.TYPE,
                        Integer.TYPE,
                        Boolean.TYPE
                }, param -> {
                    Object adapter = param.args[0];
                    int count = (Integer) XposedHelpers.callMethod(adapter, "getCount");
                    int layout = (Integer) param.getResult();
                    if (count == 3 && layout == 3) {
                        param.setResult(4);
                        XposedBridge.log(TAG + ": B1.e.c() remapped layout 3 -> 4");
                    }
                });

        // 502 l0.N() -> T(false,false); 700 r0.O(3apps) -> T(false,false,true).
        replaceMethod(lpparam, "com.oplus.pscanvas.canvasmode.canvas.r0", "O",
                new Class[]{boolean.class}, param -> {
                    param.args[0] = false;
                    return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
                });
    }

    private static void ensureTwoColumnLayout(Object adapter, String source) {
        int count = (Integer) XposedHelpers.callMethod(adapter, "getCount");
        if (count != 3) {
            return;
        }
        int layout = XposedHelpers.getIntField(adapter, "f13788f");
        if (layout == 3) {
            XposedHelpers.setIntField(adapter, "f13788f", 4);
            XposedBridge.log(TAG + ": " + source + " forced f13788f 3 -> 4");
        }
    }

    private static void hookBeforeMethod(XC_LoadPackage.LoadPackageParam lpparam, String className,
                                         String methodName, Class<?>[] parameterTypes,
                                         HookBefore body) {
        try {
            Object[] args = new Object[parameterTypes.length + 1];
            System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
            args[parameterTypes.length] = new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    body.run(param);
                }
            };
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, args);
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": failed beforeHook " + className + "." + methodName + ": " + throwable);
        }
    }

    private static void hookAfterMethod(XC_LoadPackage.LoadPackageParam lpparam, String className,
                                        String methodName, Class<?>[] parameterTypes,
                                        HookAfter body) {
        try {
            Object[] args = new Object[parameterTypes.length + 1];
            System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
            args[parameterTypes.length] = new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    body.run(param);
                }
            };
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName, args);
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": failed afterHook " + className + "." + methodName + ": " + throwable);
        }
    }

    private static void hookScaleListener502(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            Class<?> gestureClass = XposedHelpers.findClass(GESTURE_MGR, lpparam.classLoader);
            Class<?> listenerClass = XposedHelpers.findClass(GESTURE_MGR + "$c", lpparam.classLoader);

            XposedHelpers.findAndHookMethod(listenerClass, "onScale",
                    ScaleGestureDetector.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            Object outer = XposedHelpers.getObjectField(param.thisObject, "this$0");
                            if (outer == null) {
                                return;
                            }
                            int pointerCount = XposedHelpers.getIntField(outer, "f10935A");
                            // 502 requires 4+ fingers; 700 changed to 3+
                            if (pointerCount <= 3) {
                                param.setResult(false);
                            }
                        }
                    });

            XposedHelpers.findAndHookMethod(listenerClass, "onScaleEnd",
                    ScaleGestureDetector.class,
                    new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            Object outer = XposedHelpers.getObjectField(param.thisObject, "this$0");
                            if (outer == null) {
                                return;
                            }
                            int pointerCount = XposedHelpers.getIntField(outer, "f10935A");
                            boolean enabled = XposedHelpers.getStaticBooleanField(gestureClass, "f10934L");
                            Object splitPolicy = XposedHelpers.getObjectField(outer, "f10948c");
                            // 502: end split-to-flexible only when finger count <= 4
                            if (!enabled || pointerCount > 4 || splitPolicy == null) {
                                return;
                            }
                            XposedHelpers.callMethod(splitPolicy, "g0");
                            param.setResult(null);
                        }
                    });

            // Fix onTouchEvent finger threshold: 502 triggers onScaleEnd at <=4, 700 at <3
            XposedHelpers.findAndHookMethod(gestureClass, "T",
                    MotionEvent.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            Object outer = param.thisObject;
                            Object splitPolicy = XposedHelpers.getObjectField(outer, "f10948c");
                            if (splitPolicy == null) {
                                return;
                            }
                            boolean active = (Boolean) XposedHelpers.callMethod(splitPolicy, "P");
                            MotionEvent event = (MotionEvent) param.args[0];
                            int pointerCount = XposedHelpers.getIntField(outer, "f10935A");
                            int action = event.getAction();
                            int masked = event.getActionMasked();
                            if (active && (action == MotionEvent.ACTION_UP || masked == MotionEvent.ACTION_POINTER_UP)
                                    && pointerCount <= 4) {
                                XposedHelpers.callMethod(splitPolicy, "g0");
                            }
                        }
                    });
        } catch (Throwable t) {
            XposedBridge.log(TAG + ": scale listener 502 restore failed: " + t);
        }
    }

    private static void hookWindowConfigUtils(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, CONFIG, "h", new Class[]{Context.class},
                param -> ConfigCompat.getMaxHeight((Context) param.args[0]));
        replaceMethod(lpparam, CONFIG, "j", new Class[]{Context.class},
                param -> ConfigCompat.getMaxWidth((Context) param.args[0]));
    }

    private static void hookActivityTaskManagerCallers(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, UTIL, "E", new Class[]{Integer.TYPE}, param -> {
            int taskId = (Integer) param.args[0];
            for (Object task : AtmCompat.getTasks(lpparam.classLoader, 5, true)) {
                if (XposedHelpers.getIntField(task, "taskId") == taskId) {
                    return task;
                }
            }
            return null;
        });
        hookWithAtmFallback(lpparam, "r1.f", "p");
        hookWithAtmFallback(lpparam, UTIL, "i", List.class);
    }

    private static void hookWithAtmFallback(XC_LoadPackage.LoadPackageParam lpparam,
                                            String className, String methodName, Class<?>... parameterTypes) {
        replaceMethod(lpparam, className, methodName, parameterTypes, param -> {
            try {
                return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            } catch (Throwable throwable) {
                if (!isAtmCompatError(throwable)) {
                    throw throwable;
                }
                XposedBridge.log(TAG + ": ATM compat fallback for " + className + "." + methodName);
                if ("r1.f".equals(className) && "p".equals(methodName)) {
                    XposedHelpers.setBooleanField(param.thisObject, "c", false);
                }
                return defaultValue(asMethod(param.method));
            }
        });
    }

    private static void hookSplitToFlexibleTransition(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, UTIL, "n", new Class[]{List.class, Integer.TYPE, Bundle.class}, param -> {
            Context context = extractContext(param.thisObject, param.args);
            List<?> intents = (List<?>) param.args[0];
            FlexibleTransitionCompat.injectDisplayBoundsIntoIntents(intents, context);
            Object result = XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            if (result instanceof Bundle) {
                return FlexibleTransitionCompat.fixLaunchBoundsBundle((Bundle) result, context);
            }
            return result;
        });

        replaceMethod(lpparam, SSTO_FLEX, "J", new Class[0], param -> {
            FlexibleTransitionCompat.resetEarlySplitZoom();
            return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
        });

        replaceMethod(lpparam, SSTO_FLEX, "p0", new Class[0], param -> {
            if (SplitPolicyCompat.getEmbeddedCanvasTaskIds(param.thisObject).size() >= 2) {
                if (!FlexibleTransitionCompat.isEarlySplitZoomActive()) {
                    FlexibleTransitionCompat.beginEarlySplitZoom(param.thisObject, lpparam.classLoader);
                }
                XposedBridge.log(TAG + ": skip p0 positionChange animation (502 path)");
                return null;
            }
            return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
        });

        replaceMethod(lpparam, SSTO_FLEX, "s0", new Class[0], param -> {
            if (FlexibleTransitionCompat.isEarlySplitZoomActive()) {
                XposedBridge.log(TAG + ": s0 skipped, early split zoom active");
                return true;
            }
            Context context = SplitPolicyCompat.findContext(param.thisObject);
            if (context == null) {
                context = FlexibleTransitionCompat.resolveContext(param.thisObject, param.args, lpparam.classLoader);
            }
            SplitPolicyCompat.sanitizeTransitionEntries(param.thisObject, context);
            try {
                boolean toggleReturned = (Boolean) XposedBridge.invokeOriginalMethod(
                        param.method, param.thisObject, param.args);
                if (toggleReturned) {
                    return FlexibleTransitionCompat.evaluateTransitionResult(
                            param.thisObject, true, lpparam.classLoader);
                }
            } catch (Throwable throwable) {
                XposedBridge.log(TAG + ": x1.r.s0 original failed: " + throwable);
            }
            if (SplitPolicyCompat.getTransitionEntries(param.thisObject).size() >= 2) {
                XposedBridge.log(TAG + ": split zoom fallback after s0 failure");
                boolean zoomStarted = FlexibleTransitionCompat.runSplitZoomTransition(
                        param.thisObject, context, lpparam.classLoader);
                if (!zoomStarted) {
                    SplitPolicyCompat.restoreCanvasVisibility(param.thisObject);
                    FlexibleTransitionCompat.resetEarlySplitZoom();
                }
                return zoomStarted;
            }
            SplitPolicyCompat.restoreCanvasVisibility(param.thisObject);
            FlexibleTransitionCompat.markTransitionSucceeded(false);
            return false;
        });

        replaceMethod(lpparam, UTIL, "t0",
                new Class[]{int[].class, List.class, float[].class, Bundle.class},
                param -> {
                    Bundle bundle = (Bundle) param.args[3];
                    if (FlexibleTransitionCompat.isPrepareSwitchCall(bundle)) {
                        XposedBridge.log(TAG + ": skip prepare_switch_to_flexible_window t0");
                        return true;
                    }
                    Context context = FlexibleTransitionCompat.resolveContext(
                            param.thisObject, param.args, lpparam.classLoader);
                    FlexibleTransitionCompat.sanitizeLaunchBounds((List<?>) param.args[1], context);
                    try {
                        Object result = XposedBridge.invokeOriginalMethod(
                                param.method, param.thisObject, param.args);
                        XposedBridge.log(TAG + ": toggleMultiFlexibleWindowFromCanvas returned " + result);
                        return result;
                    } catch (Throwable throwable) {
                        XposedBridge.log(TAG + ": toggleMultiFlexibleWindowFromCanvas failed: " + throwable);
                        return false;
                    }
                });

        replaceMethod(lpparam, CONTAINER_ACTIVITY, "w1", new Class[0], param -> {
            if (!FlexibleTransitionCompat.wasLastTransitionSucceeded()) {
                XposedBridge.log(TAG + ": w1 removeTask skipped, transition not verified");
                return null;
            }
            if (FlexibleTransitionCompat.wasZoomFallbackUsed()) {
                XposedBridge.log(TAG + ": w1 removeTask skipped, canvas kept hidden");
                return null;
            }
            final int taskId = (Integer) XposedHelpers.callMethod(param.thisObject, "u0");
            final ClassLoader classLoader = lpparam.classLoader;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (!AtmCompat.removeTask(classLoader, taskId)) {
                    XposedBridge.log(TAG + ": w1 removeTask skipped, ATM unavailable");
                }
            }, 600L);
            return null;
        });
    }

    private static void hookDirectWindowConfigurationAccess(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, UTIL, "o0",
                new Class[]{Context.class, List.class, Integer.TYPE},
                param -> {
                    try {
                        return XposedBridge.invokeOriginalMethod(
                                param.method, param.thisObject, param.args);
                    } catch (Throwable throwable) {
                        if (!isWindowConfigError(throwable)) {
                            throw throwable;
                        }
                        Context context = (Context) param.args[0];
                        XposedBridge.log(TAG + ": o0 windowConfiguration compat fallback");
                        return I0Compat.run(
                                context,
                                (List<?>) param.args[1],
                                (Integer) param.args[2],
                                resolveClassLoader(context, lpparam.classLoader));
                    }
                });

        hookWithConfigFallback(lpparam, CONTAINER_ACTIVITY, "K1", Bundle.class);
        hookWithConfigFallback(lpparam, CONTAINER_ACTIVITY, "onCreate", Bundle.class);
        hookWithConfigFallback(lpparam, CONTAINER_ACTIVITY, "onConfigurationChanged", Configuration.class);
        hookWithConfigFallback(lpparam, LAYOUT_CTRL, "F0");
        hookWithConfigFallback(lpparam, CONTAINER_VIEW, "H2", Boolean.TYPE);
    }

    private static void hookWithConfigFallback(XC_LoadPackage.LoadPackageParam lpparam,
                                               String className, String methodName, Object... parameterTypes) {
        Class<?>[] paramTypes = new Class[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Object type = parameterTypes[i];
            if (type instanceof Class) {
                paramTypes[i] = (Class<?>) type;
            } else {
                paramTypes[i] = XposedHelpers.findClass((String) type, lpparam.classLoader);
            }
        }
        replaceMethod(lpparam, className, methodName, paramTypes, param -> {
            try {
                return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            } catch (Throwable throwable) {
                if (!isWindowConfigError(throwable)) {
                    throw throwable;
                }
                XposedBridge.log(TAG + ": windowConfiguration compat for " + className + "." + methodName);
                return handleConfigFallback(className, methodName, param, lpparam.classLoader);
            }
        });
    }

    private static Object handleConfigFallback(String className, String methodName,
                                               XC_MethodHook.MethodHookParam param, ClassLoader classLoader) {
        Context context = extractContext(param.thisObject, param.args);
        if (CONTAINER_ACTIVITY.equals(className) && "onCreate".equals(methodName)) {
            finishContainerActivityOnCreateTail(param.thisObject, context);
            return null;
        }
        if (CONTAINER_ACTIVITY.equals(className) && "onConfigurationChanged".equals(methodName)) {
            finishOnConfigurationChanged(param.thisObject, (Configuration) param.args[0], context);
            return null;
        }
        if (LAYOUT_CTRL.equals(className) && "F0".equals(methodName)) {
            finishPanoramaF0(param.thisObject, context);
            return null;
        }
        if (CONTAINER_VIEW.equals(className) && "H2".equals(methodName)) {
            return null;
        }
        return defaultValue(asMethod(param.method));
    }

    private static void finishContainerActivityOnCreateTail(Object activity, Context context) {
        if (context == null) {
            return;
        }
        Configuration configuration = context.getResources().getConfiguration();
        setRectField(activity, "f10263l", ConfigCompat.getBounds(configuration, context));
        XposedHelpers.setIntField(activity, "f10231M", configuration.densityDpi);
        ClassLoader classLoader = context.getClassLoader();
        try {
            XposedHelpers.setObjectField(activity, "f10267n",
                    XposedHelpers.callStaticMethod(
                            XposedHelpers.findClass(
                                    "com.oplus.flexiblewindow.FlexibleWindowManager", classLoader),
                            "getInstance"));
            Class<?> callbackClass = XposedHelpers.findClass(
                    CONTAINER_ACTIVITY + "$EmbeddedWindowCallback", classLoader);
            XposedHelpers.setObjectField(activity, "f10269o",
                    XposedHelpers.newInstance(callbackClass, activity));
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": onCreate tail init failed: " + throwable);
        }
        safeCall(activity, "b2");
        safeCall(activity, "P1");
        safeCall(activity, "y1");
        safeCall(activity, "S1");
        safeCall(activity, "H1", false);
        safeCall(activity, "s1");
    }

    private static void finishOnConfigurationChanged(Object activity, Configuration configuration, Context context) {
        if (context == null || configuration == null) {
            return;
        }
        setRectField(activity, "f10263l", ConfigCompat.getBounds(configuration, context));
        XposedHelpers.setIntField(activity, "f10231M", configuration.densityDpi);
        XposedHelpers.setBooleanField(activity, "f10245a0", false);
    }

    private static ClassLoader resolveClassLoader(Context context, ClassLoader fallback) {
        if (context != null && context.getClassLoader() != null) {
            return context.getClassLoader();
        }
        return fallback;
    }

    private static void finishPanoramaF0(Object controller, Context context) {
        if (context == null) {
            return;
        }
        int width = ConfigCompat.getMaxWidth(context);
        int height = ConfigCompat.getMaxHeight(context);
        XposedHelpers.setIntField(controller, "f10629G", width);
        XposedHelpers.setIntField(controller, "f10630H", height);
    }

    private static void replaceMethod(XC_LoadPackage.LoadPackageParam lpparam, String className,
                                      String methodName, Class<?>[] parameterTypes, HookBody body) {
        try {
            XposedHelpers.findAndHookMethod(className, lpparam.classLoader, methodName,
                    buildHookArgs(parameterTypes, body));
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": failed to hook " + className + "." + methodName + ": " + throwable);
        }
    }

    private static Object[] buildHookArgs(Class<?>[] parameterTypes, HookBody body) {
        Object[] args = new Object[parameterTypes.length + 1];
        System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
        args[parameterTypes.length] = new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return body.run(param);
            }
        };
        return args;
    }

    private static void safeCall(Object target, String methodName, Object... args) {
        try {
            XposedHelpers.callMethod(target, methodName, args);
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": " + methodName + "() failed: " + throwable);
        }
    }

    private static void setRectField(Object target, String fieldName, Rect bounds) {
        Object rectField = XposedHelpers.getObjectField(target, fieldName);
        if (rectField instanceof Rect) {
            ((Rect) rectField).set(bounds);
        } else {
            XposedHelpers.setObjectField(target, fieldName, new Rect(bounds));
        }
    }

    private static Context extractContext(Object instance, Object[] args) {
        if (instance instanceof Context) {
            return (Context) instance;
        }
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof Context) {
                    return (Context) arg;
                }
            }
        }
        if (instance instanceof Activity) {
            return (Activity) instance;
        }
        return null;
    }

    private static Method asMethod(Member member) {
        return member instanceof Method ? (Method) member : null;
    }

    private static Object defaultValue(Method method) {
        if (method == null) {
            return null;
        }
        Class<?> returnType = method.getReturnType();
        if (returnType == boolean.class) {
            return false;
        }
        if (returnType == int.class) {
            return 0;
        }
        if (returnType == long.class) {
            return 0L;
        }
        if (returnType == float.class) {
            return 0f;
        }
        if (returnType == double.class) {
            return 0d;
        }
        return null;
    }

    private static boolean isAtmCompatError(Throwable throwable) {
        return containsError(throwable, "ActivityTaskManager", "getInstance");
    }

    private static boolean isWindowConfigError(Throwable throwable) {
        return containsError(throwable, "windowConfiguration", "NoSuchFieldError");
    }

    private static boolean containsError(Throwable throwable, String... needles) {
        Throwable current = throwable;
        while (current != null) {
            String message = String.valueOf(current);
            for (String needle : needles) {
                if (message.contains(needle)) {
                    return true;
                }
            }
            current = current.getCause();
        }
        return false;
    }
}
