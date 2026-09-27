package com.color.pscanvasfix.feature;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import com.color.pscanvasfix.compat.ObfFieldCompat;
import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.compat.SplitPolicyCompat;
import com.color.pscanvasfix.compat.ThreeSplitTouch502Compat;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookReplacement;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.PackageLoadContext;
import com.color.pscanvasfix.runtime.ReflectionAccess;

/** Installs pinch lifecycle, directional scale dispatch, and atomic touch guards. */
public final class PinchGestureFeature {
    public static final String HOOK_LIFECYCLE_INIT_TRACE =
            "pinch.lifecycle.init.trace";
    public static final String HOOK_LIFECYCLE_SCALE_END_TRACE =
            "pinch.lifecycle.scale_end.trace";
    public static final String HOOK_LIFECYCLE_ANIMATION_START_TRACE =
            "pinch.lifecycle.animation_start.trace";
    public static final String HOOK_SCALE_PANORAMA_DISPATCH =
            "pinch.scale.panorama_dispatch";
    public static final String HOOK_ANIM_RESET_ALL_BLOCK =
            "touch_anim.reset_all.block";
    public static final String HOOK_ANIM_SCALE_DOWN_START_BLOCK =
            "touch_anim.scale_down_start.block";
    public static final String HOOK_ANIM_NEED_ANIM_CHECK_BLOCK =
            "touch_anim.need_anim_check.block";
    public static final String HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK =
            "touch_anim.control_bar_long_press.block";
    public static final String HOOK_ANIM_INITIAL_DRAG_GUARD =
            "touch_anim.initial_drag.guard";
    public static final String HOOK_DRAG_POINTER_DOWN_BLOCK =
            "touch_drag.pointer_down.block";
    public static final String HOOK_DRAG_POINTER_MOVE_BLOCK =
            "touch_drag.pointer_move.block";
    public static final String HOOK_DRAG_POINTER_UP_BLOCK =
            "touch_drag.pointer_up.block";
    public static final String HOOK_DRAG_INITIALIZE_BLOCK =
            "touch_drag.initialize.block";

    private PinchGestureFeature() {
    }

    public static void declareLifecycleHooks(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_LIFECYCLE_INIT_TRACE,
                "SSTO_FLEXIBLE.Q(); before; trace only");
        hookRegistry.declare(HOOK_LIFECYCLE_SCALE_END_TRACE,
                "SSTO_FLEXIBLE.u0(); before; trace only");
        hookRegistry.declare(HOOK_LIFECYCLE_ANIMATION_START_TRACE,
                "SSTO_FLEXIBLE.I0(); before; trace only");
    }

    public static void declareScaleHook(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_SCALE_PANORAMA_DISPATCH,
                "SSTO_FLEXIBLE.scale(ScaleGestureDetector,int); before");
    }

    public static void declareTouchHooks(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_ANIM_RESET_ALL_BLOCK,
                "THREE_SPLIT_ANIM.H0(); before; conditional short-circuit");
        hookRegistry.declare(HOOK_ANIM_SCALE_DOWN_START_BLOCK,
                "THREE_SPLIT_ANIM.U0(boolean); before; conditional short-circuit");
        hookRegistry.declare(HOOK_ANIM_NEED_ANIM_CHECK_BLOCK,
                "THREE_SPLIT_ANIM.e0(int,int); before; conditional short-circuit");
        hookRegistry.declare(HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK,
                "THREE_SPLIT_ANIM.p0(); before; conditional short-circuit");
        hookRegistry.declare(HOOK_ANIM_INITIAL_DRAG_GUARD,
                "THREE_SPLIT_ANIM.y0(); replace; block or call origin once");
        hookRegistry.declare(HOOK_DRAG_POINTER_DOWN_BLOCK,
                "THREE_SPLIT_DRAG.b(state,MotionEvent); before; conditional short-circuit");
        hookRegistry.declare(HOOK_DRAG_POINTER_MOVE_BLOCK,
                "THREE_SPLIT_DRAG.c(state,MotionEvent); before; conditional short-circuit");
        hookRegistry.declare(HOOK_DRAG_POINTER_UP_BLOCK,
                "THREE_SPLIT_DRAG.d(state); before; conditional short-circuit");
        hookRegistry.declare(HOOK_DRAG_INITIALIZE_BLOCK,
                "THREE_SPLIT_DRAG.e(EmbeddedViewDecor); before; conditional short-circuit");
    }

    public static void installLifecycleHooks(PackageLoadContext lpparam,
                                             HookRuntime hookRuntime,
                                             HookRegistry hookRegistry,
                                             String transitionClass,
                                             String initMethod,
                                             String scaleEndMethod,
                                             String animationStartMethod) {
        installTraceHook(lpparam, hookRuntime, hookRegistry, transitionClass, initMethod,
                HOOK_LIFECYCLE_INIT_TRACE, "260608 trace SStoFlexible.Q init");
        installTraceHook(lpparam, hookRuntime, hookRegistry, transitionClass, scaleEndMethod,
                HOOK_LIFECYCLE_SCALE_END_TRACE, "260608 trace SStoFlexible.u0 scaleEnd");
        installTraceHook(lpparam, hookRuntime, hookRegistry, transitionClass,
                animationStartMethod, HOOK_LIFECYCLE_ANIMATION_START_TRACE,
                "260608 trace SStoFlexible.I0 startAnimation");
    }

    public static void installScaleHook(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                        HookRegistry hookRegistry,
                                        ReflectionAccess reflectionAccess,
                                        String transitionClass, String scaleMethod,
                                        String managerGetter, String panoramaActiveMethod,
                                        String panoramaEnterMethod,
                                        String panoramaExitMethod,
                                        boolean twoTaskPanoramaCapability) {
        String detail = transitionClass + "." + scaleMethod
                + "(ScaleGestureDetector,int); before";
        try {
            hookRuntime.findAndHookMethod(HOOK_SCALE_PANORAMA_DISPATCH,
                    transitionClass, lpparam.classLoader, scaleMethod,
                    ScaleGestureDetector.class, Integer.TYPE,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            PsCanvasLog.i("260608 trace SStoFlexible.t0 scale pointerCount="
                                    + param.args[1]);
                            Object containerView = SplitPolicyCompat.findContainerView(
                                    param.thisObject);
                            if (PanoramaFeature.handleDirectionalScale(containerView,
                                    (ScaleGestureDetector) param.args[0],
                                    (Integer) param.args[1], reflectionAccess,
                                    managerGetter, panoramaActiveMethod,
                                    panoramaEnterMethod, panoramaExitMethod)) {
                                param.setResult(null);
                                return;
                            }
                            ScaleGestureDetector detector =
                                    (ScaleGestureDetector) param.args[0];
                            if (TwoTaskPanoramaFeature.handleDirectionalScale(
                                    containerView, detector.getScaleFactor(),
                                    (Integer) param.args[1], twoTaskPanoramaCapability,
                                    reflectionAccess, managerGetter, panoramaActiveMethod,
                                    panoramaEnterMethod, panoramaExitMethod)) {
                                param.setResult(null);
                                return;
                            }
                            if (ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(
                                    containerView)) {
                                param.setResult(null);
                                PsCanvasLog.d("260608 blocked x1.x.t0 in panorama 3-split");
                                return;
                            }
                            int state = ObfFieldCompat.getInt(param.thisObject,
                                    ObfFieldCompat.R_CHANGE_STATE, "f14152y");
                            if (state == 0 || state == 2) {
                                ObfFieldCompat.setInt(param.thisObject,
                                        ObfFieldCompat.R_CHANGE_STATE, "f14152y", 1);
                            }
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_SCALE_PANORAMA_DISPATCH, detail);
            PsCanvasLog.i("260608 SStoFlexible.t0 installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_SCALE_PANORAMA_DISPATCH, detail, throwable);
            PsCanvasLog.e("260608 SStoFlexible.t0 failed", throwable);
        }
    }

    public static void installTouchHooks(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                         HookRegistry hookRegistry,
                                         ReflectionAccess reflectionAccess,
                                         String animationClass, String dragClass,
                                         String dragStateClass, String embeddedDecorClass,
                                         String resetAllMethod,
                                         String scaleDownStartMethod,
                                         String needAnimationCheckMethod,
                                         String controlBarLongPressMethod,
                                         String initialDragMethod,
                                         String pointerDownMethod,
                                         String pointerMoveMethod,
                                         String pointerUpMethod,
                                         String dragInitializeMethod) {
        Class<?> animationManager = findClassSafe(
                reflectionAccess, animationClass, lpparam.classLoader);
        if (animationManager == null) {
            String detail = "THREE_SPLIT_ANIM runtime class missing";
            markHookSkipped(hookRegistry, HOOK_ANIM_RESET_ALL_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_ANIM_SCALE_DOWN_START_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_ANIM_NEED_ANIM_CHECK_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_ANIM_INITIAL_DRAG_GUARD, detail);
            PsCanvasLog.e("260608 ThreeSplitAnim class missing", null);
        } else {
            String target = animationManager.getName();
            installVoidGuard(hookRuntime, hookRegistry, animationManager,
                    resetAllMethod, "resetAll",
                    HOOK_ANIM_RESET_ALL_BLOCK, target + "." + resetAllMethod + "(); before");
            installVoidGuard(hookRuntime, hookRegistry, animationManager,
                    scaleDownStartMethod,
                    "startScaleDownAnim", HOOK_ANIM_SCALE_DOWN_START_BLOCK,
                    target + "." + scaleDownStartMethod + "(boolean); before", Boolean.TYPE);
            installVoidGuard(hookRuntime, hookRegistry, animationManager,
                    needAnimationCheckMethod,
                    "checkIfNeedAnim", HOOK_ANIM_NEED_ANIM_CHECK_BLOCK,
                    target + "." + needAnimationCheckMethod + "(int,int); before",
                    Integer.TYPE, Integer.TYPE);
            installVoidGuard(hookRuntime, hookRegistry, animationManager,
                    controlBarLongPressMethod,
                    "onControlBarLongPress", HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK,
                    target + "." + controlBarLongPressMethod + "(); before");
            installInitialDragGuard(hookRuntime, hookRegistry, animationManager,
                    initialDragMethod, target + "." + initialDragMethod
                            + "(); replace; origin once when allowed");
            PsCanvasLog.i("260608 ThreeSplitAnim installed on " + target);
        }

        Class<?> dragManager = findClassSafe(reflectionAccess, dragClass, lpparam.classLoader);
        if (dragManager == null) {
            String detail = "THREE_SPLIT_DRAG runtime class missing";
            markHookSkipped(hookRegistry, HOOK_DRAG_POINTER_DOWN_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_DRAG_POINTER_MOVE_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_DRAG_POINTER_UP_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_DRAG_INITIALIZE_BLOCK, detail);
            PsCanvasLog.e("260608 ThreeSplitDrag class missing", null);
            return;
        }
        String target = dragManager.getName();
        Class<?> dragState = findClassSafe(
                reflectionAccess, dragStateClass, lpparam.classLoader);
        if (dragState != null) {
            installVoidGuard(hookRuntime, hookRegistry, dragManager, pointerDownMethod,
                    "handleThreeSplitDown", HOOK_DRAG_POINTER_DOWN_BLOCK,
                    target + "." + pointerDownMethod + "(state,MotionEvent); before",
                    dragState, MotionEvent.class);
            installVoidGuard(hookRuntime, hookRegistry, dragManager, pointerMoveMethod,
                    "handleThreeSplitMove", HOOK_DRAG_POINTER_MOVE_BLOCK,
                    target + "." + pointerMoveMethod + "(state,MotionEvent); before",
                    dragState, MotionEvent.class);
            installVoidGuard(hookRuntime, hookRegistry, dragManager, pointerUpMethod,
                    "handleThreeSplitUp", HOOK_DRAG_POINTER_UP_BLOCK,
                    target + "." + pointerUpMethod + "(state); before", dragState);
        } else {
            String detail = "THREE_SPLIT_DRAG state class missing";
            markHookSkipped(hookRegistry, HOOK_DRAG_POINTER_DOWN_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_DRAG_POINTER_MOVE_BLOCK, detail);
            markHookSkipped(hookRegistry, HOOK_DRAG_POINTER_UP_BLOCK, detail);
        }
        Class<?> embeddedDecor = findClassSafe(
                reflectionAccess, embeddedDecorClass, lpparam.classLoader);
        if (embeddedDecor != null) {
            installVoidGuard(hookRuntime, hookRegistry, dragManager, dragInitializeMethod,
                    "initThreeSplitDrag", HOOK_DRAG_INITIALIZE_BLOCK,
                    target + "." + dragInitializeMethod
                            + "(EmbeddedViewDecor); before", embeddedDecor);
        } else {
            markHookSkipped(hookRegistry, HOOK_DRAG_INITIALIZE_BLOCK,
                    "EmbeddedViewDecor class missing");
        }
        PsCanvasLog.i("260608 ThreeSplitDrag installed on " + target);
    }

    public static void markLifecycleAndScaleUnavailable(HookRegistry hookRegistry,
                                                        String detail) {
        markHookSkipped(hookRegistry, HOOK_LIFECYCLE_INIT_TRACE, detail);
        markHookSkipped(hookRegistry, HOOK_LIFECYCLE_SCALE_END_TRACE, detail);
        markHookSkipped(hookRegistry, HOOK_LIFECYCLE_ANIMATION_START_TRACE, detail);
        markHookSkipped(hookRegistry, HOOK_SCALE_PANORAMA_DISPATCH, detail);
    }

    public static void markTouchUnavailable(HookRegistry hookRegistry, String detail) {
        for (String hookId : touchHookIds()) {
            markHookSkipped(hookRegistry, hookId, detail);
        }
    }

    public static boolean allTouchHooksInstalled(HookRegistry hookRegistry) {
        int installed = 0;
        for (HookRegistry.Entry entry : hookRegistry.snapshot()) {
            if (isTouchHookId(entry.id())
                    && entry.status() == HookRegistry.Status.INSTALLED) {
                installed++;
            }
        }
        return installed == touchHookIds().length;
    }

    public static void markTouchRolledBack(HookRegistry hookRegistry) {
        IllegalStateException failure = new IllegalStateException(
                "THREE_SPLIT_ANIM && THREE_SPLIT_DRAG composite rolled back");
        for (HookRegistry.Entry entry : hookRegistry.snapshot()) {
            if (isTouchHookId(entry.id())) {
                hookRegistry.markRolledBack(entry.id(),
                        "composite rollback; previous=" + entry.status(), failure);
            }
        }
    }

    private static void installTraceHook(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                         HookRegistry hookRegistry, String targetClass,
                                         String methodName, String hookId, String message) {
        String detail = targetClass + "." + methodName + "(); before";
        try {
            hookRuntime.findAndHookMethod(hookId, targetClass, lpparam.classLoader,
                    methodName, new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            PsCanvasLog.i(message);
                        }
                    });
            markHookInstalled(hookRegistry, hookId, detail);
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, hookId, detail, throwable);
            PsCanvasLog.e("failed beforeHook " + targetClass + "." + methodName + ":",
                    throwable);
        }
    }

    private static void installVoidGuard(HookRuntime hookRuntime, HookRegistry hookRegistry,
                                         Class<?> targetClass, String methodName,
                                         String logLabel, String hookId, String detail,
                                         Class<?>... parameterTypes) {
        try {
            Object[] hookArgs = new Object[parameterTypes.length + 1];
            System.arraycopy(parameterTypes, 0, hookArgs, 0, parameterTypes.length);
            hookArgs[parameterTypes.length] = new HookCallback() {
                @Override
                protected void beforeHookedMethod(HookCall param) {
                    Object holder = param.thisObject;
                    if (SplitPolicyCompat.inTransition()) {
                        if ("resetAll".equals(logLabel)) {
                            PsCanvasLog.d(
                                    "blocked ThreeSplitAnimManager resetAll during pinch");
                            param.setResult(null);
                        }
                        return;
                    }
                    if (ThreeSplitTouch502Compat.shouldBlockTouchAnim(holder)) {
                        PsCanvasLog.d("blocked ThreeSplitAnimManager " + logLabel
                                + " in panorama 3-split");
                        param.setResult(null);
                    }
                }
            };
            hookRuntime.findAndHookMethod(hookId, targetClass, methodName, hookArgs);
            markHookInstalled(hookRegistry, hookId, detail);
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, hookId, detail, throwable);
            PsCanvasLog.e("hook502ThreeSplitTouchRestore " + targetClass.getName()
                    + "." + methodName + " failed", throwable);
        }
    }

    private static void installInitialDragGuard(HookRuntime hookRuntime,
                                                HookRegistry hookRegistry,
                                                Class<?> targetClass,
                                                String methodName, String detail) {
        try {
            hookRuntime.findAndHookMethod(HOOK_ANIM_INITIAL_DRAG_GUARD,
                    targetClass, methodName, new HookReplacement() {
                        @Override
                        protected Object replaceHookedMethod(HookCall param) throws Throwable {
                            if (ThreeSplitTouch502Compat.shouldBlockTouchAnim(
                                    param.thisObject)) {
                                return false;
                            }
                            return hookRuntime.invokeOriginalMethod(
                                    param.method, param.thisObject, param.args);
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_ANIM_INITIAL_DRAG_GUARD, detail);
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_ANIM_INITIAL_DRAG_GUARD, detail, throwable);
            PsCanvasLog.e("failed to hook " + targetClass.getName() + "." + methodName + ":",
                    throwable);
        }
    }

    private static Class<?> findClassSafe(ReflectionAccess reflectionAccess,
                                          String className, ClassLoader classLoader) {
        if (className == null) {
            return null;
        }
        try {
            return FeatureReflectionResolver.findClass(
                    reflectionAccess, className, classLoader);
        } catch (Throwable throwable) {
            PsCanvasLog.d("class not ready: " + className + " (" + throwable + ")");
            return null;
        }
    }

    private static boolean isTouchHookId(String hookId) {
        for (String candidate : touchHookIds()) {
            if (candidate.equals(hookId)) {
                return true;
            }
        }
        return false;
    }

    private static String[] touchHookIds() {
        return new String[]{
                HOOK_ANIM_RESET_ALL_BLOCK,
                HOOK_ANIM_SCALE_DOWN_START_BLOCK,
                HOOK_ANIM_NEED_ANIM_CHECK_BLOCK,
                HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK,
                HOOK_ANIM_INITIAL_DRAG_GUARD,
                HOOK_DRAG_POINTER_DOWN_BLOCK,
                HOOK_DRAG_POINTER_MOVE_BLOCK,
                HOOK_DRAG_POINTER_UP_BLOCK,
                HOOK_DRAG_INITIALIZE_BLOCK
        };
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
