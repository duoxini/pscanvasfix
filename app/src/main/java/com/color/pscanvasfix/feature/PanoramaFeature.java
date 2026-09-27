package com.color.pscanvasfix.feature;

import android.view.ScaleGestureDetector;

import com.color.pscanvasfix.compat.PinchTransition502Compat;
import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.compat.SplitPolicyCompat;
import com.color.pscanvasfix.compat.ThreeSplitTouch502Compat;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.PackageLoadContext;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.lang.reflect.Method;

/** Owns panorama state, directional entry/exit, and panorama transition guards. */
public final class PanoramaFeature {
    public static final String HOOK_LAUNCH_WHILE_ACTIVE_BLOCK =
            "panorama.launch_while_active.block";
    public static final String HOOK_TRANSITION_MASK_RECT_FIX =
            "transition.mask_rect.fix";
    public static final String HOOK_EXIT_DIRECTION_GUARD =
            "panorama.exit.direction_guard";

    private static final ThreadLocal<Boolean> DIRECTIONAL_EXIT_ALLOWED = new ThreadLocal<>();

    private PanoramaFeature() {
    }

    public static void declareLaunchGuard(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_LAUNCH_WHILE_ACTIVE_BLOCK,
                "SSTO_FLEXIBLE.L0(); before; block while panorama active");
    }

    public static void declareMaskFix(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_TRANSITION_MASK_RECT_FIX,
                "SSTO_FLEXIBLE.maskAnimation(...); after");
    }

    public static void declareExitGuard(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_EXIT_DIRECTION_GUARD,
                "PanoramaModeManager.A(boolean); before; directional exit guard");
    }

    public static void installLaunchGuard(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                          HookRegistry hookRegistry,
                                          ReflectionAccess reflectionAccess,
                                          String transitionClass, String launchMethod,
                                          String managerGetter, String activeMethod) {
        String detail = transitionClass + "." + launchMethod + "(); before";
        try {
            hookRuntime.findAndHookMethod(HOOK_LAUNCH_WHILE_ACTIVE_BLOCK,
                    transitionClass, lpparam.classLoader, launchMethod,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            if (isActive(param.thisObject, reflectionAccess,
                                    managerGetter, activeMethod)) {
                                param.setResult(false);
                                PsCanvasLog.i("260608 blocked SStoFlexible.L0 while "
                                        + "full panorama is active");
                                return;
                            }
                            PsCanvasLog.i("260608 trace SStoFlexible.L0 launch");
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_LAUNCH_WHILE_ACTIVE_BLOCK, detail);
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_LAUNCH_WHILE_ACTIVE_BLOCK, detail, throwable);
            PsCanvasLog.e("failed beforeHook " + transitionClass + "." + launchMethod + ":",
                    throwable);
        }
    }

    public static void installMaskFix(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                      HookRegistry hookRegistry,
                                      ReflectionAccess reflectionAccess,
                                      String transitionClass, String maskMethod,
                                      String embeddedDecorClass,
                                      String flexibleTaskViewClass) {
        String detail = transitionClass + "." + maskMethod + "(...); after";
        try {
            Class<?> embeddedDecor = reflectionAccess.findClass(
                    embeddedDecorClass, lpparam.classLoader);
            Class<?> flexibleTaskView = reflectionAccess.findClass(
                    flexibleTaskViewClass, lpparam.classLoader);
            hookRuntime.findAndHookMethod(HOOK_TRANSITION_MASK_RECT_FIX,
                    transitionClass, lpparam.classLoader, maskMethod,
                    android.view.SurfaceControl.Transaction.class,
                    android.view.SurfaceControl.class, android.view.SurfaceControl.class,
                    android.view.SurfaceControl.class, android.view.SurfaceControl.class,
                    embeddedDecor, Integer.TYPE, flexibleTaskView,
                    new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            PinchTransition502Compat.fixPanoramaMaskAnimRect(
                                    param.thisObject, param.args[5]);
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_TRANSITION_MASK_RECT_FIX, detail);
            PsCanvasLog.i("260608 SStoFlexible.Z installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_TRANSITION_MASK_RECT_FIX, detail, throwable);
            PsCanvasLog.e("260608 SStoFlexible.Z failed", throwable);
        }
    }

    public static void installExitGuard(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                        HookRegistry hookRegistry,
                                        ReflectionAccess reflectionAccess,
                                        String containerViewClass, String managerGetter,
                                        String exitMethod, String... managerFallbackClasses) {
        Class<?> managerClass = resolveManagerClass(lpparam, reflectionAccess,
                containerViewClass, managerGetter, managerFallbackClasses);
        if (managerClass == null) {
            markHookSkipped(hookRegistry, HOOK_EXIT_DIRECTION_GUARD,
                    "PanoramaModeManager class unresolved");
            PsCanvasLog.w("260608 panorama manager class missing for tap-exit hook");
            return;
        }
        try {
            hookRuntime.findAndHookMethod(HOOK_EXIT_DIRECTION_GUARD,
                    managerClass, exitMethod, Boolean.TYPE,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            if (!Boolean.TRUE.equals(DIRECTIONAL_EXIT_ALLOWED.get())
                                    && isCanvasGestureManagerCall()) {
                                param.setResult(null);
                                PsCanvasLog.i("260608 blocked single-tap panorama exit");
                            }
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_EXIT_DIRECTION_GUARD,
                    managerClass.getName() + "." + exitMethod + "(boolean); before");
            PsCanvasLog.i("260608 panorama single-tap exit hook installed on "
                    + managerClass.getName());
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_EXIT_DIRECTION_GUARD,
                    managerClass.getName() + "." + exitMethod + "(boolean); before", throwable);
            PsCanvasLog.e("260608 panorama single-tap exit hook failed", throwable);
        }
    }

    public static boolean handleDirectionalScale(Object containerView,
                                                 ScaleGestureDetector detector,
                                                 int pointerCount,
                                                 ReflectionAccess reflectionAccess,
                                                 String managerGetter,
                                                 String activeMethod,
                                                 String enterMethod,
                                                 String exitMethod) {
        if (pointerCount < 4 || containerView == null
                || !ThreeSplitTouch502Compat.isThreeAppCanvas(containerView)) {
            return false;
        }
        try {
            Object manager = reflectionAccess.callMethod(containerView, managerGetter);
            if (manager == null) {
                return false;
            }
            boolean active = Boolean.TRUE.equals(
                    reflectionAccess.callMethod(manager, activeMethod));
            float scaleFactor = detector.getScaleFactor();
            if (scaleFactor < 1.0f) {
                if (!active) {
                    reflectionAccess.callMethod(manager, enterMethod, true);
                    PsCanvasLog.i("260608 pinch entered full panorama; scale="
                            + scaleFactor + " pointers=" + pointerCount);
                }
            } else if (scaleFactor > 1.0f && active) {
                DIRECTIONAL_EXIT_ALLOWED.set(Boolean.TRUE);
                try {
                    reflectionAccess.callMethod(manager, exitMethod, true);
                    PsCanvasLog.i("260608 spread exited full panorama; scale="
                            + scaleFactor + " pointers=" + pointerCount);
                } finally {
                    DIRECTIONAL_EXIT_ALLOWED.remove();
                }
            }
            return true;
        } catch (Throwable throwable) {
            PsCanvasLog.e("260608 panorama directional gesture failed", throwable);
            return false;
        }
    }

    /** Executes an OEM panorama exit while satisfying the shared directional-exit guard. */
    static void exitDirectionally(Object manager, ReflectionAccess reflectionAccess,
                                  String exitMethod) {
        DIRECTIONAL_EXIT_ALLOWED.set(Boolean.TRUE);
        try {
            reflectionAccess.callMethod(manager, exitMethod, true);
        } finally {
            DIRECTIONAL_EXIT_ALLOWED.remove();
        }
    }

    private static boolean isActive(Object splitPolicy, ReflectionAccess reflectionAccess,
                                    String managerGetter, String activeMethod) {
        Object containerView = SplitPolicyCompat.findContainerView(splitPolicy);
        if (containerView == null) {
            return false;
        }
        try {
            Object manager = reflectionAccess.callMethod(
                    containerView, managerGetter);
            return manager != null
                    && Boolean.TRUE.equals(reflectionAccess.callMethod(manager, activeMethod));
        } catch (Throwable throwable) {
            PsCanvasLog.e("260608 panorama state lookup failed", throwable);
            return false;
        }
    }

    private static Class<?> resolveManagerClass(PackageLoadContext lpparam,
                                                ReflectionAccess reflectionAccess,
                                                String containerViewClass,
                                                String managerGetter,
                                                String... fallbackClasses) {
        try {
            Class<?> containerView = FeatureReflectionResolver.findClass(
                    reflectionAccess, containerViewClass, lpparam.classLoader);
            Method getter = containerView.getDeclaredMethod(managerGetter);
            getter.setAccessible(true);
            return getter.getReturnType();
        } catch (Throwable ignored) {
            for (int index = 0; index < fallbackClasses.length; index++) {
                String className = fallbackClasses[index];
                try {
                    Class<?> resolved = FeatureReflectionResolver.findClass(
                            reflectionAccess, className, lpparam.classLoader);
                    if (index > 0) {
                        PsCanvasLog.i("resolved " + fallbackClasses[0]
                                + " as " + className);
                    }
                    return resolved;
                } catch (Throwable nestedIgnored) {
                    // Try the next known structural fallback.
                }
            }
            return null;
        }
    }

    private static boolean isCanvasGestureManagerCall() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (int index = 0; index < Math.min(trace.length, 24); index++) {
            String className = trace[index].getClassName();
            if ((className.endsWith(".canvas.y")
                    || className.endsWith(".canvas.C0332y"))
                    && "T".equals(trace[index].getMethodName())) {
                return true;
            }
        }
        return false;
    }

    private static void markHookInstalled(HookRegistry hookRegistry, String hookId,
                                          String detail) {
        try {
            hookRegistry.markInstalled(hookId, detail);
        } catch (Throwable throwable) {
            PsCanvasLog.e("HookRegistry INSTALLED update failed for " + hookId, throwable);
        }
    }

    private static void markHookSkipped(HookRegistry hookRegistry, String hookId,
                                        String detail) {
        try {
            hookRegistry.markSkipped(hookId, detail);
        } catch (Throwable throwable) {
            PsCanvasLog.e("HookRegistry SKIPPED update failed for " + hookId, throwable);
        }
    }

    private static void markHookFailed(HookRegistry hookRegistry, String hookId,
                                       String detail, Throwable failure) {
        try {
            hookRegistry.markFailed(hookId, detail, failure);
        } catch (Throwable throwable) {
            PsCanvasLog.e("HookRegistry FAILED update failed for " + hookId, throwable);
        }
    }
}
