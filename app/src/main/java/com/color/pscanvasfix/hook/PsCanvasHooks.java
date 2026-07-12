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
import com.color.pscanvasfix.compat.ObfFieldCompat;
import com.color.pscanvasfix.compat.PinchTransition502Compat;
import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.compat.SplitPolicyCompat;
import com.color.pscanvasfix.compat.ThreeSplitTouch502Compat;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
    // Runtime dex name is "y" (jadx shows C0332y as rename).
    private static final String GESTURE_MGR = "com.oplus.pscanvas.canvasmode.canvas.y";
    private static final String CONTAINER_ACTIVITY = "com.oplus.pscanvas.canvasmode.canvas.ContainerActivity";
    private static final String CONTAINER_VIEW = "com.oplus.pscanvas.canvasmode.canvas.view.ContainerView";
    private static final String LAYOUT_CTRL = "com.oplus.pscanvas.canvasmode.canvas.C0327t";
    // Runtime dex name is u1.c (jadx shows C0600c as rename).
    private static final String ADAPTER = "u1.c";

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

    private static volatile boolean deferredHooksInstalled = false;

    public static void install(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!TARGET_PACKAGE.equals(lpparam.packageName)) {
            return;
        }
        XposedBridge.log(TAG + ": hooking " + lpparam.packageName
                + " v48 (502 3-app sync pinch fix)");
        PsCanvasLog.i("install v48 hooks for " + lpparam.packageName);

        // --- PinchTransitionHooks (502 S1.p core) ---
        hook502SplitToFlexibleRestore(lpparam);
        hookSplitToFlexibleTransition(lpparam);
        hook502ThreeSplitTouchRestore(lpparam);
        // --- PanoramaHooks (502 split display, do not touch during pinch) ---
        hook502BehaviorRestoreCore(lpparam);
        hookTwoColumnPanoramaRestoreCore(lpparam);
        // --- Shared infra ---
        hookWindowConfigUtils(lpparam);
        hookActivityTaskManagerCallers(lpparam);
        hookDirectWindowConfigurationAccess(lpparam);
        installDeferredHooksOnContainerStart(lpparam);
        XposedBridge.log(TAG + ": critical hooks installed");
    }

    private static void installDeferredHooksOnContainerStart(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            XposedHelpers.findAndHookMethod(CONTAINER_ACTIVITY, lpparam.classLoader, "onCreate",
                    Bundle.class, new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) {
                            if (deferredHooksInstalled) {
                                return;
                            }
                            deferredHooksInstalled = true;
                            XposedBridge.log(TAG + ": installing deferred hooks after ContainerActivity.onCreate");
                            hook502BehaviorRestoreDeferred(lpparam);
                            hookTwoColumnPanoramaRestoreDeferred(lpparam);
                        }
                    });
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": ContainerActivity.onCreate defer hook failed: " + throwable);
            hook502BehaviorRestoreDeferred(lpparam);
            hookTwoColumnPanoramaRestoreDeferred(lpparam);
        }
    }

    private static Class<?> findClassSafe(String className, ClassLoader classLoader) {
        try {
            return XposedHelpers.findClass(className, classLoader);
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": class not ready: " + className + " (" + throwable + ")");
            return null;
        }
    }

    private static Class<?> findClassFirst(ClassLoader classLoader, String... classNames) {
        for (String className : classNames) {
            Class<?> found = findClassSafe(className, classLoader);
            if (found != null) {
                if (!className.equals(classNames[0])) {
                    XposedBridge.log(TAG + ": resolved " + classNames[0] + " as " + className);
                }
                return found;
            }
        }
        return null;
    }

    /**
     * Restore 502 split-screen / five-finger pinch behavior on 700 (core, primary dex).
     */
    private static void hook502BehaviorRestoreCore(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, UTIL, "F0", new Class[]{Context.class}, param -> {
            try {
                Object activity = XposedHelpers.callStaticMethod(
                        XposedHelpers.findClass(UTIL, lpparam.classLoader),
                        "O1", param.args[0]);
                if (activity != null) {
                    Object containerView = XposedHelpers.callMethod(activity, "v0");
                    if (ThreeSplitTouch502Compat.isThreeAppCanvas(containerView)) {
                        PsCanvasLog.d("F0=false for 3-app canvas (502 sync pinch)");
                        return false;
                    }
                }
            } catch (Throwable ignored) {
            }
            return true;
        });
    }

    private static volatile Class<?> gestureManagerClass;

    private static void hook502BehaviorRestoreDeferred(XC_LoadPackage.LoadPackageParam lpparam) {
        Class<?> gestureClass = findClassFirst(lpparam.classLoader,
                GESTURE_MGR, "com.oplus.pscanvas.canvasmode.canvas.C0332y");
        if (gestureClass == null) {
            return;
        }
        gestureManagerClass = gestureClass;
        hookGestureThreeAppSync(lpparam, gestureClass);
        hookScaleListener502(lpparam, gestureClass);
    }

    /** Keep f10934L=false whenever canvas hosts 3 apps. */
    private static void hookGestureThreeAppSync(XC_LoadPackage.LoadPackageParam lpparam,
                                                Class<?> gestureClass) {
        Class<?> containerActivityClass = findClassFirst(lpparam.classLoader,
                CONTAINER_ACTIVITY, "com.oplus.pscanvas.canvasmode.canvas.ContainerActivity");
        if (containerActivityClass != null) {
            try {
                XposedHelpers.findAndHookConstructor(gestureClass, containerActivityClass,
                        new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) {
                                try {
                                    Object containerView = XposedHelpers.callMethod(param.args[0], "v0");
                                    ThreeSplitTouch502Compat.syncGestureSplitFlagForThreeApp(
                                            gestureClass, containerView);
                                } catch (Throwable ignored) {
                                }
                            }
                        });
            } catch (Throwable throwable) {
                PsCanvasLog.e("hookGestureThreeAppSync constructor failed", throwable);
            }
        }
        Class<?> draggableClass = findClassFirst(lpparam.classLoader,
                "com.oplus.pscanvas.canvasmode.canvas.view.DraggableCanvasViewGroup");
        Class<?> panoramaClass = findClassFirst(lpparam.classLoader,
                "com.oplus.pscanvas.canvasmode.canvas.A0");
        if (draggableClass != null && panoramaClass != null) {
            try {
                XposedHelpers.findAndHookMethod(gestureClass, "O",
                        draggableClass,
                        XposedHelpers.findClass(CONTAINER_VIEW, lpparam.classLoader),
                        panoramaClass,
                        new XC_MethodHook() {
                            @Override
                            protected void afterHookedMethod(MethodHookParam param) {
                                ThreeSplitTouch502Compat.syncGestureSplitFlagForThreeApp(
                                        gestureClass, param.args[1]);
                            }
                        });
                PsCanvasLog.i("hookGestureThreeAppSync installed on canvas.y.O");
            } catch (Throwable throwable) {
                PsCanvasLog.e("hookGestureThreeAppSync O failed", throwable);
            }
        }
    }

    /**
     * 700 sets mChangeToState=2 when entering three-split (ContainerActivity.F1).
     * f0() returns early when changeState is 0/2, so pinch never sets scaleMoved.
     * g0() then calls i0() reset -> desktop flash. 502 S1.p has none of this.
     *
     * 700 also renamed removeTask: 502 ContainerActivity.w1() -> 700 C1().
     */
    /** PinchTransitionHooks — 502 S1.p core (dummy prepare + layout-aware L/x). */
    private static void hook502SplitToFlexibleRestore(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, CONTAINER_ACTIVITY, "F1", new Class[0], param -> {
            XposedBridge.log(TAG + ": blocked F1 setChangeToState(2) for 502 pinch path");
            return null;
        });

        hookBeforeMethod(lpparam, SSTO_FLEX, "k0", new Class[]{Integer.TYPE}, param -> {
            int state = (Integer) param.args[0];
            if (state == 0 || state == 2) {
                param.args[0] = 1;
                XposedBridge.log(TAG + ": k0 remap changeState " + state + " -> 1");
            }
        });

        hookBeforeMethod(lpparam, SSTO_FLEX, "f0",
                new Class[]{ScaleGestureDetector.class, Integer.TYPE}, param -> {
                    Object containerView = SplitPolicyCompat.findContainerView(param.thisObject);
                    if (ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(containerView)) {
                        PsCanvasLog.d("blocked x1.r f0 in panorama 3-split (canvas sync pinch)");
                        param.setResult(null);
                        return;
                    }
                    Object splitPolicy = param.thisObject;
                    int changeState = ObfFieldCompat.getInt(splitPolicy, ObfFieldCompat.R_CHANGE_STATE, "f14152y");
                    if (changeState == 0 || changeState == 2) {
                        ObfFieldCompat.setInt(splitPolicy, ObfFieldCompat.R_CHANGE_STATE, "f14152y", 1);
                    }
                });

        hookBeforeMethod(lpparam, SSTO_FLEX, "J", new Class[0], param -> {
            Object containerView = SplitPolicyCompat.findContainerView(param.thisObject);
            if (ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(containerView)) {
                if (gestureManagerClass != null) {
                    ObfFieldCompat.setGestureSplitEnabled(gestureManagerClass, false);
                }
                PsCanvasLog.d("blocked x1.r J init in panorama 3-split");
                param.setResult(null);
            }
        });

        replaceMethod(lpparam, SSTO_FLEX, "L", new Class[]{ArrayList.class}, param -> {
            PinchTransition502Compat.apply502LayoutRemap(param.thisObject, (ArrayList<?>) param.args[0]);
            return null;
        });

        replaceMethod(lpparam, SSTO_FLEX, "e0", new Class[]{Boolean.TYPE}, param -> {
            Object splitPolicy = param.thisObject;
            boolean prepare = (Boolean) param.args[0];
            if (prepare && ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(
                    SplitPolicyCompat.findContainerView(splitPolicy))) {
                PsCanvasLog.d("blocked x1.r e0 prepare in 3-app canvas sync pinch");
                return null;
            }
            prepareSplitPolicyForNotify(splitPolicy);
            if (prepare) {
                PinchTransition502Compat.run502DummyPrepare(lpparam.classLoader);
                PsCanvasLog.trace("e0", "502 dummy prepare, skipped real e0(true)");
                return null;
            }
            try {
                List<?> intents = (List<?>) XposedHelpers.callMethod(splitPolicy, "C");
                if (intents != null) {
                    SplitPolicyCompat.patchIntentListTaskIds(splitPolicy, intents);
                }
            } catch (Throwable throwable) {
                PsCanvasLog.e("e0 intent patch failed", throwable);
            }
            return XposedBridge.invokeOriginalMethod(param.method, splitPolicy, param.args);
        });

        hookAfterMethod(lpparam, SSTO_FLEX, "C", new Class[0], param -> {
            Object result = param.getResult();
            if (result instanceof List) {
                SplitPolicyCompat.patchIntentListTaskIds(param.thisObject, (List<?>) result);
            }
        });

        hookBeforeMethod(lpparam, SSTO_FLEX, "W",
                new Class[]{Integer.TYPE, Boolean.TYPE, List.class, int[].class}, param -> {
                    if ((Boolean) param.args[1]) {
                        return;
                    }
                    Object splitPolicy = param.thisObject;
                    int size = (Integer) param.args[0];
                    List<?> intents = (List<?>) param.args[2];
                    if (intents != null) {
                        SplitPolicyCompat.patchIntentListTaskIds(splitPolicy, intents);
                    }
                    int[] taskIds = (int[]) param.args[3];
                    int[] before = taskIds != null ? taskIds.clone() : new int[0];
                    int[] fixed = SplitPolicyCompat.ensureTaskIds(splitPolicy, size, taskIds);
                    param.args[3] = fixed;
                    PsCanvasLog.trace("W", "prepare=" + false + " size=" + size
                            + " in=" + java.util.Arrays.toString(before)
                            + " out=" + java.util.Arrays.toString(fixed));
                });

        hookBeforeMethod(lpparam, SSTO_FLEX, "p0", new Class[0], param -> {
            Object splitPolicy = param.thisObject;
            SplitPolicyCompat.markTransitionActive(true);
            PinchTransition502Compat.syncLiveLayoutOrient(splitPolicy);
            prepareSplitPolicyForNotify(splitPolicy);
            schedulePinchEndFallback(splitPolicy);
        });

        hookBeforeMethod(lpparam, SSTO_FLEX, "q0", new Class[0], param -> {
            Object splitPolicy = param.thisObject;
            SplitPolicyCompat.markTransitionActive(true);
            PinchTransition502Compat.syncLiveLayoutOrient(splitPolicy);
            prepareSplitPolicyForNotify(splitPolicy);
        });

        hookAfterMethod(lpparam, SSTO_FLEX, "B",
                new Class[]{List.class, int[].class}, param -> {
                    Object result = param.getResult();
                    if (!(result instanceof Bundle)) {
                        return;
                    }
                    Context context = SplitPolicyCompat.findContext(param.thisObject);
                    param.setResult(FlexibleTransitionCompat.fixLaunchBoundsBundle((Bundle) result, context));
                });

        hookBeforeMethod(lpparam, SSTO_FLEX, "g0", new Class[0], param -> {
            Object containerView = SplitPolicyCompat.findContainerView(param.thisObject);
            if (ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(containerView)) {
                PsCanvasLog.d("blocked x1.r g0 split-to-flexible in panorama 3-split");
                param.setResult(null);
                return;
            }
            if (shouldBlockTouchMoveG0()) {
                PsCanvasLog.trace("g0", "BLOCKED touch ACTION_MOVE");
                param.setResult(null);
                return;
            }
            Object splitPolicy = param.thisObject;
            PinchTransition502Compat.syncLiveLayoutOrient(splitPolicy);
            prepareSplitPolicyForNotify(splitPolicy);
            boolean init = ObfFieldCompat.getBoolean(splitPolicy, ObfFieldCompat.R_INIT, "f14147t");
            boolean scaleEnd = ObfFieldCompat.getBoolean(splitPolicy, ObfFieldCompat.R_SCALE_END, "f14108B");
            int state = ObfFieldCompat.getInt(splitPolicy, ObfFieldCompat.R_STATE, "f14113G");
            PsCanvasLog.trace("g0", "init=" + init + " scaleEnd=" + scaleEnd + " state=" + state);
        });

        replaceMethod(lpparam, SSTO_FLEX, "i0", new Class[0], param -> {
            if (FlexibleTransitionCompat.isEarlySplitZoomActive()
                    || FlexibleTransitionCompat.wasZoomFallbackUsed()) {
                XposedBridge.log(TAG + ": blocked i0 reset during 502 zoom transition");
                return null;
            }
            Object splitPolicy = param.thisObject;
            boolean init = ObfFieldCompat.getBoolean(splitPolicy, ObfFieldCompat.R_INIT, "f14147t");
            int state = ObfFieldCompat.getInt(splitPolicy, ObfFieldCompat.R_STATE, "f14113G");
            boolean scaleMoved = ObfFieldCompat.getBoolean(splitPolicy, ObfFieldCompat.R_SCALE_MOVED, "f14110D");
            boolean scaleEnded = ObfFieldCompat.getBoolean(splitPolicy, ObfFieldCompat.R_SCALE_END, "f14108B");
            int embedded = SplitPolicyCompat.getEmbeddedCanvasTaskIds(splitPolicy).size();
            if (init && embedded >= 2) {
                if (state >= 1 && state <= 5
                        || scaleMoved
                        || SplitPolicyCompat.inTransition()) {
                    PsCanvasLog.d("blocked i0 reset init=true state=" + state
                            + " scaleMoved=" + scaleMoved + " embedded=" + embedded);
                    return null;
                }
            }
            if (scaleMoved && scaleEnded && embedded >= 2) {
                PsCanvasLog.d("blocked i0 reset after valid pinch");
                return null;
            }
            SplitPolicyCompat.clearTransitionActive();
            return XposedBridge.invokeOriginalMethod(param.method, splitPolicy, param.args);
        });

        hookPanoramaMaskAnimRectFix(lpparam);

        replaceMethod(lpparam, SSTO_FLEX, "c0", new Class[0], param -> {
            if (FlexibleTransitionCompat.wasZoomFallbackUsed()) {
                Activity activity = FlexibleTransitionCompat.getContainerActivity(
                        param.thisObject,
                        SplitPolicyCompat.findContext(param.thisObject));
                if (activity != null) {
                    FlexibleTransitionCompat.scheduleZoomCanvasDismiss(activity, lpparam.classLoader);
                }
                PsCanvasLog.d("c0 finish deferred to zoom settle (502 path)");
                return null;
            }
            Object splitPolicy = param.thisObject;
            Activity activity = FlexibleTransitionCompat.getContainerActivity(
                    splitPolicy, SplitPolicyCompat.findContext(splitPolicy));
            if (activity == null || activity.isFinishing()) {
                return null;
            }
            if (!FlexibleTransitionCompat.wasLastTransitionSucceeded()) {
                return XposedBridge.invokeOriginalMethod(param.method, splitPolicy, param.args);
            }
            safeCall(activity, "L1", true);
            try {
                Object tracker = XposedHelpers.callStaticMethod(
                        XposedHelpers.findClass("B1.h", lpparam.classLoader), "a", activity);
                XposedHelpers.callMethod(tracker, "e", "four_finger_to_zoom");
            } catch (Throwable throwable) {
                PsCanvasLog.e("c0 analytics failed", throwable);
            }
            FlexibleTransitionCompat.scheduleFinish502Style(activity, lpparam.classLoader);
            PsCanvasLog.d("c0 502-style finish scheduled");
            return null;
        });
    }

    private static final String EMBEDDED_VIEW_DECOR =
            "com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor";

    /** After createMaskLeash (x1.r.S): clamp peek mask anim rect to visible cell in layout 4. */
    private static void hookPanoramaMaskAnimRectFix(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            Class<?> embeddedDecorClass = findClassFirst(lpparam.classLoader,
                    EMBEDDED_VIEW_DECOR, "com.oplus.flexiblewindow.EmbeddedViewDecor");
            Class<?> flexibleTaskViewClass = findClassFirst(lpparam.classLoader,
                    "com.oplus.flexiblewindow.FlexibleTaskView");
            if (embeddedDecorClass == null || flexibleTaskViewClass == null) {
                PsCanvasLog.w("hookPanoramaMaskAnimRectFix failed: decor or task view class missing");
                return;
            }
            hookAfterMethod(lpparam, SSTO_FLEX, "S",
                    new Class[]{
                            android.view.SurfaceControl.Transaction.class,
                            android.view.SurfaceControl.class,
                            android.view.SurfaceControl.class,
                            android.view.SurfaceControl.class,
                            android.view.SurfaceControl.class,
                            embeddedDecorClass,
                            Integer.TYPE,
                            flexibleTaskViewClass
                    },
                    param -> PinchTransition502Compat.fixPanoramaMaskAnimRect(
                            param.thisObject, param.args[5]));
            PsCanvasLog.i("hookPanoramaMaskAnimRectFix installed on x1.r.S");
        } catch (Throwable throwable) {
            PsCanvasLog.e("hookPanoramaMaskAnimRectFix failed", throwable);
        }
    }

    /**
     * Section D — restore 502 tap behavior: no ThreeSplitAnimManager shrink/enlarge on single-finger
     * touch in panorama 3-split; five-finger pinch uses canvas sync-shrink (Section E).
     */
    private static void hook502ThreeSplitTouchRestore(XC_LoadPackage.LoadPackageParam lpparam) {
        Class<?> animManagerClass = findClassFirst(lpparam.classLoader, "x1.x", "X1.x");
        if (animManagerClass != null) {
            hookVoidWhenPanoramaTouch(animManagerClass, "H0", lpparam, "resetAll");
            hookVoidWhenPanoramaTouch(animManagerClass, "U0", lpparam, "startScaleDownAnim", Boolean.TYPE);
            hookVoidWhenPanoramaTouch(animManagerClass, "e0", lpparam, "checkIfNeedAnim",
                    Integer.TYPE, Integer.TYPE);
            hookVoidWhenPanoramaTouch(animManagerClass, "p0", lpparam, "onControlBarLongPress");
            try {
                replaceMethod(lpparam, animManagerClass.getName(), "y0", new Class[0], param -> {
                    if (ThreeSplitTouch502Compat.shouldBlockTouchAnim(param.thisObject)) {
                        PsCanvasLog.d("blocked ThreeSplitAnimManager initialDragAnimation in panorama");
                        return false;
                    }
                    return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
                });
            } catch (Throwable throwable) {
                PsCanvasLog.e("hook502ThreeSplitTouchRestore y0 failed", throwable);
            }
            PsCanvasLog.i("hook502ThreeSplitTouchRestore installed on x1.x");
        } else {
            PsCanvasLog.w("hook502ThreeSplitTouchRestore: x1.x missing");
        }

        Class<?> dragManagerClass = findClassFirst(lpparam.classLoader, "x1.y", "X1.y");
        if (dragManagerClass != null) {
            Class<?> dragStateClass = findClassFirst(lpparam.classLoader, "x1.a", "x1.C0631a");
            Class<?> motionEventClass = MotionEvent.class;
            if (dragStateClass != null) {
                hookVoidWhenPanoramaTouch(dragManagerClass, "b", lpparam, "handleThreeSplitDown",
                        dragStateClass, motionEventClass);
                hookVoidWhenPanoramaTouch(dragManagerClass, "c", lpparam, "handleThreeSplitMove",
                        dragStateClass, motionEventClass);
                hookVoidWhenPanoramaTouch(dragManagerClass, "d", lpparam, "handleThreeSplitUp",
                        dragStateClass);
            }
            Class<?> embeddedDecorClass = findClassFirst(lpparam.classLoader,
                    "com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor");
            if (embeddedDecorClass != null) {
                hookVoidWhenPanoramaTouch(dragManagerClass, "e", lpparam, "initThreeSplitDrag",
                        embeddedDecorClass);
            }
            PsCanvasLog.i("hook502ThreeSplitTouchRestore installed on x1.y");
        } else {
            PsCanvasLog.w("hook502ThreeSplitTouchRestore: x1.y missing");
        }

        hookPanoramaPeekFocusRestore(lpparam);
    }

    /** Peek slot tap: pan into view via ContainerView.V when 700 would only adapter.H. */
    private static void hookPanoramaPeekFocusRestore(XC_LoadPackage.LoadPackageParam lpparam) {
        try {
            XposedHelpers.findAndHookMethod(ADAPTER, lpparam.classLoader, "H",
                    Integer.TYPE, new XC_MethodHook() {
                        @Override
                        protected void beforeHookedMethod(MethodHookParam param) {
                            int index = (Integer) param.args[0];
                            if (ThreeSplitTouch502Compat.redirectGestureFocusToPan(param.thisObject, index)) {
                                param.setResult(null);
                            }
                        }
                    });
            PsCanvasLog.i("hookPanoramaPeekFocusRestore installed on u1.c.H");
        } catch (Throwable throwable) {
            PsCanvasLog.e("hookPanoramaPeekFocusRestore failed", throwable);
        }
    }

    private static void hookVoidWhenPanoramaTouch(Class<?> targetClass, String methodName,
                                                  XC_LoadPackage.LoadPackageParam lpparam,
                                                  String logLabel, Class<?>... parameterTypes) {
        try {
            XposedHelpers.findAndHookMethod(targetClass, methodName, buildBeforeHookArgs(
                    parameterTypes,
                    param -> {
                        Object holder = param.thisObject;
                        if (SplitPolicyCompat.inTransition()) {
                            if ("resetAll".equals(logLabel)) {
                                PsCanvasLog.d("blocked ThreeSplitAnimManager resetAll during pinch");
                                param.setResult(null);
                            }
                            return;
                        }
                        if (ThreeSplitTouch502Compat.shouldBlockTouchAnim(holder)) {
                            PsCanvasLog.d("blocked ThreeSplitAnimManager " + logLabel
                                    + " in panorama 3-split");
                            param.setResult(null);
                        }
                    }));
        } catch (Throwable throwable) {
            PsCanvasLog.e("hook502ThreeSplitTouchRestore " + targetClass.getName()
                    + "." + methodName + " failed", throwable);
        }
    }

    private static Object[] buildBeforeHookArgs(Class<?>[] parameterTypes, HookBefore body) {
        Object[] args = new Object[parameterTypes.length + 1];
        System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
        args[parameterTypes.length] = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                body.run(param);
            }
        };
        return args;
    }

    private static void prepareSplitPolicyForNotify(Object splitPolicy) {
        SplitPolicyCompat.markTransitionActive(true);
        FlexibleTransitionCompat.setActiveSplitPolicy(splitPolicy);
        SplitPolicyCompat.injectEmbeddedTaskIdsFromDecors(splitPolicy);
        SplitPolicyCompat.rememberEmbeddedTaskIds(splitPolicy);
        int changeState = ObfFieldCompat.getInt(
                splitPolicy, ObfFieldCompat.R_CHANGE_STATE, "f14152y");
        if (changeState == 0 || changeState == 2) {
            ObfFieldCompat.setInt(splitPolicy, ObfFieldCompat.R_CHANGE_STATE, "f14152y", 1);
            PsCanvasLog.d("remap changeState " + changeState + " -> 1");
        }
    }

    private static final ThreadLocal<Integer> lastGestureTouchAction = new ThreadLocal<>();

    private static void schedulePinchEndFallback(Object splitPolicy) {
        final Object policy = splitPolicy;
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (policy == null) {
                return;
            }
            boolean init = ObfFieldCompat.getBoolean(policy, ObfFieldCompat.R_INIT, "f14147t");
            boolean scaleEnded = ObfFieldCompat.getBoolean(policy, ObfFieldCompat.R_SCALE_END, "f14108B");
            int state = ObfFieldCompat.getInt(policy, ObfFieldCompat.R_STATE, "f14113G");
            if (init && !scaleEnded && state >= 2 && state <= 5) {
                PsCanvasLog.d("pinch end fallback: forcing g0 state=" + state);
                try {
                    prepareSplitPolicyForNotify(policy);
                    XposedHelpers.callMethod(policy, "g0");
                } catch (Throwable throwable) {
                    PsCanvasLog.e("pinch end fallback g0 failed", throwable);
                }
            } else if (init && scaleEnded && state >= 2 && state <= 4) {
                PsCanvasLog.d("stuck transition recovery: clearing animating flag state=" + state);
                SplitPolicyCompat.clearFlexibleAnimating(policy);
            }
        }, 800L);
    }

    private static boolean shouldBlockTouchMoveG0() {
        Integer action = lastGestureTouchAction.get();
        if (action == null || action != MotionEvent.ACTION_MOVE) {
            return false;
        }
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (int index = 0; index < Math.min(trace.length, 15); index++) {
            StackTraceElement frame = trace[index];
            if ("T".equals(frame.getMethodName())
                    && (frame.getClassName().contains(".canvas.y")
                    || frame.getClassName().contains("C0332y"))) {
                return true;
            }
        }
        return false;
    }

    /** PanoramaHooks — 502 split display (layout 3→4); independent of pinch transition. */
    private static void hookTwoColumnPanoramaRestoreCore(XC_LoadPackage.LoadPackageParam lpparam) {
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

        replaceMethod(lpparam, "com.oplus.pscanvas.canvasmode.canvas.r0", "O",
                new Class[]{boolean.class}, param -> {
                    param.args[0] = false;
                    return XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
                });

        hookAdapterLayoutMethods(lpparam);
    }

    /** u1.c is in primary dex — panorama layout remap only outside transition. */
    private static void hookAdapterLayoutMethods(XC_LoadPackage.LoadPackageParam lpparam) {
        replaceMethod(lpparam, ADAPTER, "n", new Class[0], param ->
                remapThreeSplitLayout(param.thisObject, (Integer) XposedBridge.invokeOriginalMethod(
                        param.method, param.thisObject, param.args)));
        replaceMethod(lpparam, ADAPTER, "t", new Class[0], param ->
                remapThreeSplitLayout(param.thisObject, (Integer) XposedBridge.invokeOriginalMethod(
                        param.method, param.thisObject, param.args)));
    }

    private static int remapThreeSplitLayout(Object adapter, int layout) {
        if (adapter == null || layout != 3) {
            return layout;
        }
        try {
            int count = (Integer) XposedHelpers.callMethod(adapter, "getCount");
            if (count == 3) {
                return 4;
            }
        } catch (Throwable ignored) {
        }
        return layout;
    }

    private static void hookTwoColumnPanoramaRestoreDeferred(XC_LoadPackage.LoadPackageParam lpparam) {
        Class<?> adapterClass = findClassFirst(lpparam.classLoader, ADAPTER, "u1.C0600c");
        if (adapterClass == null) {
            return;
        }

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

        hookBeforeMethod(lpparam, ADAPTER, "T",
                new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, param -> {
                    int count = (Integer) XposedHelpers.callMethod(param.thisObject, "getCount");
                    int layout = ObfFieldCompat.getInt(param.thisObject, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f");
                    if (count == 3 && layout == 3) {
                        ObfFieldCompat.setInt(param.thisObject, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f", 0);
                        XposedBridge.log(TAG + ": T() unblocked, layout 3 -> 0");
                    }
                });

        hookAfterMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            ensureTwoColumnLayout(param.thisObject, "f()");
        });

        try {
            hookAfterMethod(lpparam, "B1.e", "c",
                    new Class[]{adapterClass, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, param -> {
                        Object adapter = param.args[0];
                        int count = (Integer) XposedHelpers.callMethod(adapter, "getCount");
                        int layout = (Integer) param.getResult();
                        if (count == 3 && layout == 3) {
                            param.setResult(4);
                            XposedBridge.log(TAG + ": B1.e.c() remapped layout 3 -> 4");
                        }
                    });
        } catch (Throwable throwable) {
            XposedBridge.log(TAG + ": B1.e.c hook failed: " + throwable);
        }
    }

    private static void ensureTwoColumnLayout(Object adapter, String source) {
        int count = (Integer) XposedHelpers.callMethod(adapter, "getCount");
        if (count != 3) {
            return;
        }
        int layout = ObfFieldCompat.getInt(adapter, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f");
        if (layout == 3) {
            ObfFieldCompat.setInt(adapter, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f", 4);
            XposedBridge.log(TAG + ": " + source + " forced layout 3 -> 4");
        }
        if (gestureManagerClass != null) {
            try {
                Object context = XposedHelpers.callMethod(adapter, "getContext");
                Object activity = XposedHelpers.callStaticMethod(
                        XposedHelpers.findClass(UTIL, adapter.getClass().getClassLoader()),
                        "O1", context);
                Object containerView = activity != null
                        ? XposedHelpers.callMethod(activity, "v0") : null;
                ThreeSplitTouch502Compat.syncGestureSplitFlagForThreeApp(
                        gestureManagerClass, containerView);
            } catch (Throwable ignored) {
            }
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

    private static void hookScaleListener502(XC_LoadPackage.LoadPackageParam lpparam, Class<?> gestureClass) {
        XC_MethodHook touchPrepHook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                MotionEvent event = (MotionEvent) param.args[0];
                lastGestureTouchAction.set(event.getActionMasked());
                if (event.getPointerCount() > 3) {
                    ThreeSplitTouch502Compat.forceCanvasSyncPinch(
                            param.thisObject, gestureClass, event.getPointerCount());
                }
            }
        };
        try {
            XposedHelpers.findAndHookMethod(gestureClass, "T", MotionEvent.class, touchPrepHook);
            PsCanvasLog.i("hookScaleListener502 T prep installed on " + gestureClass.getName());
        } catch (Throwable throwable) {
            PsCanvasLog.e("hookScaleListener502 T failed", throwable);
        }

        XC_MethodHook scaleBeginHook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                Object outer = XposedHelpers.getObjectField(param.thisObject, "this$0");
                if (outer == null) {
                    return;
                }
                int pointers = ObfFieldCompat.getInt(outer,
                        ObfFieldCompat.GESTURE_POINTER_COUNT, "f10935A");
                ThreeSplitTouch502Compat.forceCanvasSyncPinch(outer, gestureClass, pointers);
                ThreeSplitTouch502Compat.prepareThreeAppCanvasPinch(outer, gestureClass);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                Object outer = XposedHelpers.getObjectField(param.thisObject, "this$0");
                if (outer == null) {
                    return;
                }
                Object containerView = ThreeSplitTouch502Compat.getGestureContainerView(outer);
                if (!ThreeSplitTouch502Compat.isThreeAppCanvas(containerView)) {
                    return;
                }
                Object splitPolicy = ObfFieldCompat.getObject(outer,
                        ObfFieldCompat.GESTURE_SPLIT_POLICY, "f10948c");
                if (Boolean.TRUE.equals(param.getResult()) && splitPolicy != null) {
                    ThreeSplitTouch502Compat.undoFlexiblePinchBegin(outer, gestureClass);
                    param.setResult(false);
                    PsCanvasLog.d("3-app onScaleBegin rejected x1.r branch");
                    return;
                }
                if (!Boolean.TRUE.equals(param.getResult())) {
                    ThreeSplitTouch502Compat.resetThreeAppPinchState(outer, gestureClass);
                    int pointers = ObfFieldCompat.getInt(outer,
                            ObfFieldCompat.GESTURE_POINTER_COUNT, "f10935A");
                    boolean scaling = ObfFieldCompat.getBoolean(outer,
                            ObfFieldCompat.GESTURE_SCALING, "f10936B");
                    PsCanvasLog.d("3-app onScaleBegin rejected pointers="
                            + pointers + " mScaling=" + scaling);
                }
            }
        };

        XC_MethodHook scaleHook = new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) {
                Object outer = XposedHelpers.getObjectField(param.thisObject, "this$0");
                if (outer == null) {
                    return;
                }
                ThreeSplitTouch502Compat.prepareThreeAppCanvasPinch(outer, gestureClass);
                int pointerCount = ObfFieldCompat.getInt(outer,
                        ObfFieldCompat.GESTURE_POINTER_COUNT, "f10935A");
                if (pointerCount <= 3) {
                    param.setResult(false);
                }
            }
        };

        XC_MethodHook scaleEndHook = new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) {
                Object outer = XposedHelpers.getObjectField(param.thisObject, "this$0");
                if (outer != null) {
                    ThreeSplitTouch502Compat.resetThreeAppPinchState(outer, gestureClass);
                }
            }
        };

        int hooked = 0;
        for (Class<?> inner : gestureClass.getDeclaredClasses()) {
            try {
                XposedHelpers.findAndHookMethod(inner, "onScaleBegin",
                        ScaleGestureDetector.class, scaleBeginHook);
                XposedHelpers.findAndHookMethod(inner, "onScale",
                        ScaleGestureDetector.class, scaleHook);
                XposedHelpers.findAndHookMethod(inner, "onScaleEnd",
                        ScaleGestureDetector.class, scaleEndHook);
                hooked++;
                PsCanvasLog.i("hookScaleListener502 scale hooks on " + inner.getName());
            } catch (Throwable ignored) {
            }
        }
        if (hooked == 0) {
            for (String suffix : new String[]{"$c", "$C", "$b"}) {
                try {
                    Class<?> listenerClass = XposedHelpers.findClass(
                            gestureClass.getName() + suffix, lpparam.classLoader);
                    XposedHelpers.findAndHookMethod(listenerClass, "onScaleBegin",
                            ScaleGestureDetector.class, scaleBeginHook);
                    XposedHelpers.findAndHookMethod(listenerClass, "onScale",
                            ScaleGestureDetector.class, scaleHook);
                    XposedHelpers.findAndHookMethod(listenerClass, "onScaleEnd",
                            ScaleGestureDetector.class, scaleEndHook);
                    hooked++;
                    PsCanvasLog.i("hookScaleListener502 scale hooks on " + listenerClass.getName());
                    break;
                } catch (Throwable ignored) {
                }
            }
        }
        if (hooked == 0) {
            PsCanvasLog.e("hookScaleListener502 no scale listener inner class found", null);
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
            List<?> intents = (List<?>) param.args[0];
            Bundle bundle = (Bundle) param.args[2];
            if (bundle != null && bundle.getBoolean("isThreeSplitTogether", false)) {
                PsCanvasLog.d("blocked isThreeSplitTogether in calculateFlexibleWindowBounds");
                param.args[2] = null;
            }
            Context context = extractContext(param.thisObject, param.args);
            FlexibleTransitionCompat.injectDisplayBoundsIntoIntents(intents, context);
            Object result = XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            if (result instanceof Bundle) {
                return FlexibleTransitionCompat.fixLaunchBoundsBundle((Bundle) result, context);
            }
            return result;
        });

        replaceMethod(lpparam, SSTO_FLEX, "J", new Class[0], param -> {
            FlexibleTransitionCompat.resetEarlySplitZoom();
            Object result = XposedBridge.invokeOriginalMethod(param.method, param.thisObject, param.args);
            PinchTransition502Compat.syncLiveLayoutOrient(param.thisObject);
            SplitPolicyCompat.rememberEmbeddedTaskIds(param.thisObject);
            return result;
        });

        replaceMethod(lpparam, SSTO_FLEX, "s0", new Class[0], param -> {
            Object splitPolicy = param.thisObject;
            Context context = SplitPolicyCompat.findContext(splitPolicy);
            if (context == null) {
                context = FlexibleTransitionCompat.resolveContext(splitPolicy, param.args, lpparam.classLoader);
            }
            PinchTransition502Compat.syncLiveLayoutOrient(splitPolicy);
            SplitPolicyCompat.sanitizeTransitionEntries(splitPolicy, context);
            try {
                boolean toggleReturned = (Boolean) XposedBridge.invokeOriginalMethod(
                        param.method, param.thisObject, param.args);
                return FlexibleTransitionCompat.evaluateTransitionResult(
                        param.thisObject, toggleReturned, lpparam.classLoader);
            } catch (Throwable throwable) {
                XposedBridge.log(TAG + ": x1.r.s0 original failed: " + throwable);
                FlexibleTransitionCompat.markTransitionSucceeded(false);
                return false;
            }
        });

        replaceMethod(lpparam, UTIL, "t0",
                new Class[]{int[].class, List.class, float[].class, Bundle.class},
                param -> {
                    Bundle bundle = (Bundle) param.args[3];
                    int[] taskIds = (int[]) param.args[0];
                    List<?> launchBounds = (List<?>) param.args[1];
                    int expectedSize = launchBounds != null ? launchBounds.size()
                            : taskIds != null ? taskIds.length : 0;
                    Object splitPolicy = FlexibleTransitionCompat.getActiveSplitPolicy();
                    if (FlexibleTransitionCompat.isPrepareSwitchCall(bundle)) {
                        if (taskIds == null || taskIds.length != 1 || taskIds[0] != 0) {
                            param.args[0] = new int[]{0};
                            PsCanvasLog.d("t0 dummy prepare kept taskIds=[0]");
                        }
                        PsCanvasLog.d("prepare_switch_to_flexible_window t0 taskIds="
                                + java.util.Arrays.toString((int[]) param.args[0]));
                    } else {
                        int[] fixedTaskIds = SplitPolicyCompat.fixTaskIdsForToggle(
                                taskIds, expectedSize, splitPolicy);
                        if (fixedTaskIds != taskIds) {
                            param.args[0] = fixedTaskIds;
                            PsCanvasLog.d("t0 fixed taskIds -> "
                                    + java.util.Arrays.toString(fixedTaskIds));
                        }
                    }
                    Context context = FlexibleTransitionCompat.resolveContext(
                            param.thisObject, param.args, lpparam.classLoader);
                    FlexibleTransitionCompat.sanitizeLaunchBounds((List<?>) param.args[1], context);
                    if (FlexibleTransitionCompat.isPrepareSwitchCall(bundle)) {
                        PsCanvasLog.d("prepare_switch_to_flexible_window t0 taskIds="
                                + java.util.Arrays.toString((int[]) param.args[0]));
                    }
                    try {
                        Object result = XposedBridge.invokeOriginalMethod(
                                param.method, param.thisObject, param.args);
                        PsCanvasLog.d("toggleMultiFlexibleWindowFromCanvas returned " + result);
                        return result;
                    } catch (Throwable throwable) {
                        PsCanvasLog.e("toggleMultiFlexibleWindowFromCanvas failed", throwable);
                        return false;
                    }
                });

        hookCanvasTaskRemoval(lpparam, "C1");
        hookCanvasTaskRemoval(lpparam, "w1");
    }

    /** 700 uses C1() for canvas removeTask; 502 used w1(). Hook both. */
    private static void hookCanvasTaskRemoval(XC_LoadPackage.LoadPackageParam lpparam, String methodName) {
        replaceMethod(lpparam, CONTAINER_ACTIVITY, methodName, new Class[0], param -> {
            if (!FlexibleTransitionCompat.wasLastTransitionSucceeded()) {
                XposedBridge.log(TAG + ": " + methodName + " removeTask skipped, transition not verified");
                return null;
            }
            if (FlexibleTransitionCompat.wasZoomFallbackUsed()) {
                XposedBridge.log(TAG + ": " + methodName + " removeTask skipped, zoom settle handles it");
                return null;
            }
            final int taskId = (Integer) XposedHelpers.callMethod(param.thisObject, "u0");
            final ClassLoader classLoader = lpparam.classLoader;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (!AtmCompat.removeTask(classLoader, taskId)) {
                    XposedBridge.log(TAG + ": " + methodName + " removeTask skipped, ATM unavailable");
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
