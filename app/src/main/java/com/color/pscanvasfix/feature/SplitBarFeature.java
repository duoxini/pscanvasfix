package com.color.pscanvasfix.feature;

import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.compat.SplitBar502Compat;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.PackageLoadContext;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.util.List;

/** Installs the behavior-preserving three-task split-bar suppression hooks. */
public final class SplitBarFeature {
    public static final String HOOK_RESIZABLE_RECT_UPDATE_BLOCK =
            "splitbar.resizable_rect_update.block";
    public static final String HOOK_THREE_SPLIT_SCROLL_START_BLOCK =
            "splitbar.three_split_scroll_start.block";
    public static final String HOOK_THREE_SPLIT_ENLARGE_BLOCK =
            "splitbar.three_split_enlarge.block";
    public static final String HOOK_SPRING_DRAG_HANDLER_BLOCK =
            "splitbar.spring_drag_handler.block";
    public static final String HOOK_SPRING_ANIMATION_INIT_BLOCK =
            "splitbar.spring_animation_init.block";

    private SplitBarFeature() {
    }

    public static void declareHooks(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_RESIZABLE_RECT_UPDATE_BLOCK,
                "ContainerView.f3(List); before; block resizable rect update");
        hookRegistry.declare(HOOK_THREE_SPLIT_SCROLL_START_BLOCK,
                "ContainerView.E2(); before; block three-split scroll start");
        hookRegistry.declare(HOOK_THREE_SPLIT_ENLARGE_BLOCK,
                "ContainerView.i2(List,float,float,E$c); before; block enlarge");
        hookRegistry.declare(HOOK_SPRING_DRAG_HANDLER_BLOCK,
                "E.v0(E$c,float,float,float,float); before; block spring drag");
        hookRegistry.declare(HOOK_SPRING_ANIMATION_INIT_BLOCK,
                "E.R(); before; block spring animation init");
    }

    public static void install(PackageLoadContext lpparam, HookRuntime hookRuntime,
                               HookRegistry hookRegistry, ReflectionAccess reflectionAccess,
                               String containerViewClass,
                               String springControllerClass, String springStateInnerClass,
                               String resizableRectUpdateMethod,
                               String threeSplitScrollStartMethod,
                               String threeSplitEnlargeMethod,
                               String springDragHandlerMethod,
                               String springAnimationInitMethod,
                               boolean allowThreeTaskResize) {
        installContainerSuppressionHooks(lpparam, hookRuntime, hookRegistry,
                reflectionAccess, containerViewClass, springControllerClass,
                springStateInnerClass,
                resizableRectUpdateMethod, threeSplitScrollStartMethod,
                threeSplitEnlargeMethod, allowThreeTaskResize);
        installSpringSuppressionHooks(lpparam, hookRuntime, hookRegistry,
                reflectionAccess, springControllerClass, springStateInnerClass,
                springDragHandlerMethod, springAnimationInitMethod,
                allowThreeTaskResize);
    }

    private static void installContainerSuppressionHooks(
            PackageLoadContext lpparam, HookRuntime hookRuntime, HookRegistry hookRegistry,
            ReflectionAccess reflectionAccess, String containerViewClass,
            String springControllerClass,
            String springStateInnerClass, String resizableRectUpdateMethod,
            String threeSplitScrollStartMethod, String threeSplitEnlargeMethod,
            boolean allowThreeTaskResize) {
        try {
            hookRuntime.findAndHookMethod(
                    HOOK_RESIZABLE_RECT_UPDATE_BLOCK,
                    containerViewClass, lpparam.classLoader, resizableRectUpdateMethod,
                    List.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            SplitBar502Compat.blockF3(param, allowThreeTaskResize);
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_RESIZABLE_RECT_UPDATE_BLOCK,
                    "ContainerView.f3(List); before");
            PsCanvasLog.i("P0: hookBlockThreeSplitTogether f3 installed on ContainerView");
        } catch (Throwable t) {
            markHookFailed(hookRegistry, HOOK_RESIZABLE_RECT_UPDATE_BLOCK,
                    "ContainerView.f3(List); before", t);
            PsCanvasLog.e("P0: hookBlockThreeSplitTogether f3 failed", t);
        }

        try {
            hookRuntime.findAndHookMethod(
                    HOOK_THREE_SPLIT_SCROLL_START_BLOCK,
                    containerViewClass, lpparam.classLoader, threeSplitScrollStartMethod,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            SplitBar502Compat.blockE2Entry(param, allowThreeTaskResize);
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_THREE_SPLIT_SCROLL_START_BLOCK,
                    "ContainerView.E2(); before");
            PsCanvasLog.i("P0: hookBlockThreeSplitTogether E2 installed on ContainerView");
        } catch (Throwable t) {
            markHookFailed(hookRegistry, HOOK_THREE_SPLIT_SCROLL_START_BLOCK,
                    "ContainerView.E2(); before", t);
            PsCanvasLog.e("P0: hookBlockThreeSplitTogether E2 failed", t);
        }

        try {
            Class<?> springController = findClassFirst(
                    reflectionAccess, lpparam.classLoader, springControllerClass);
            if (springController == null) {
                markHookSkipped(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,
                        "E class not found");
                PsCanvasLog.w("P0: i2 hook skipped, E class not found");
                return;
            }
            Class<?> springState = findInnerClass(
                    springController, springStateInnerClass);
            if (springState == null) {
                markHookSkipped(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,
                        "E.c inner class not found");
                PsCanvasLog.w("P0: i2 hook skipped, E.c inner class not found");
            } else {
                hookRuntime.findAndHookMethod(
                        HOOK_THREE_SPLIT_ENLARGE_BLOCK,
                        containerViewClass, lpparam.classLoader, threeSplitEnlargeMethod,
                        List.class, Float.TYPE, Float.TYPE, springState,
                        new HookCallback() {
                            @Override
                            protected void beforeHookedMethod(HookCall param) {
                                SplitBar502Compat.blockI2(param, allowThreeTaskResize);
                            }
                        });
                markHookInstalled(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,
                        "ContainerView.i2(List,float,float,E$c); before");
                PsCanvasLog.i(
                        "P0: hookBlockThreeSplitTogether i2 installed on ContainerView");
            }
        } catch (Throwable t) {
            markHookFailed(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,
                    "ContainerView.i2(List,float,float,E$c); before", t);
            PsCanvasLog.e("P0: hookBlockThreeSplitTogether i2 failed", t);
        }
    }

    private static void installSpringSuppressionHooks(
            PackageLoadContext lpparam, HookRuntime hookRuntime, HookRegistry hookRegistry,
            ReflectionAccess reflectionAccess, String springControllerClass,
            String springStateInnerClass,
            String springDragHandlerMethod, String springAnimationInitMethod,
            boolean allowThreeTaskResize) {
        try {
            Class<?> springController = findClassFirst(
                    reflectionAccess, lpparam.classLoader, springControllerClass);
            if (springController == null) {
                markHookSkipped(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,
                        "E class not found");
                markHookSkipped(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,
                        "E class not found before spring-drag pair");
                PsCanvasLog.w("P1: E.u0 hook skipped, E class not found");
                return;
            }
            Class<?> springState = findInnerClass(
                    springController, springStateInnerClass);
            if (springState != null) {
                hookRuntime.findAndHookMethod(HOOK_SPRING_DRAG_HANDLER_BLOCK,
                        springController, springDragHandlerMethod,
                        springState, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE,
                        new HookCallback() {
                            @Override
                            protected void beforeHookedMethod(HookCall param) {
                                SplitBar502Compat.blockEU0(param, allowThreeTaskResize);
                            }
                        });
                markHookInstalled(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,
                        "E.v0(E$c,float,float,float,float); before");
                PsCanvasLog.i(
                        "260608 P1: hookBlockSplitBarThreeSplitDrag v0 installed on E");
            } else {
                markHookSkipped(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,
                        "E.c inner class not found");
                PsCanvasLog.w("260608 P1: E.v0 hook skipped, E.c inner class not found");
            }
        } catch (Throwable t) {
            markHookFailed(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,
                    "E.v0(E$c,float,float,float,float); before", t);
            PsCanvasLog.e("260608 P1: hookBlockSplitBarThreeSplitDrag v0 failed", t);
        }

        try {
            Class<?> springController = findClassFirst(
                    reflectionAccess, lpparam.classLoader, springControllerClass);
            if (springController != null) {
                hookRuntime.findAndHookMethod(HOOK_SPRING_ANIMATION_INIT_BLOCK,
                        springController, springAnimationInitMethod,
                        new HookCallback() {
                            @Override
                            protected void beforeHookedMethod(HookCall param) {
                                SplitBar502Compat.blockER(param, allowThreeTaskResize);
                            }
                        });
                markHookInstalled(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,
                        "E.R(); before");
                PsCanvasLog.i("P1: hookBlockSplitBarThreeSplitDrag R installed on E");
            } else {
                markHookSkipped(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,
                        "E class not found for spring animation init");
            }
        } catch (Throwable t) {
            markHookFailed(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,
                    "E.R(); before", t);
            PsCanvasLog.e("P1: hookBlockSplitBarThreeSplitDrag R failed", t);
        }
    }

    private static Class<?> findInnerClass(Class<?> outerClass, String simpleName) {
        for (Class<?> innerClass : outerClass.getDeclaredClasses()) {
            if (innerClass.getSimpleName().equals(simpleName)) {
                return innerClass;
            }
        }
        return null;
    }

    private static Class<?> findClassSafe(ReflectionAccess reflectionAccess,
                                          String className, ClassLoader classLoader) {
        try {
            return FeatureReflectionResolver.findClass(
                    reflectionAccess, className, classLoader);
        } catch (Throwable throwable) {
            PsCanvasLog.d("class not ready: " + className + " (" + throwable + ")");
            return null;
        }
    }

    private static Class<?> findClassFirst(ReflectionAccess reflectionAccess,
                                           ClassLoader classLoader, String... classNames) {
        for (String className : classNames) {
            Class<?> found = findClassSafe(reflectionAccess, className, classLoader);
            if (found != null) {
                if (!className.equals(classNames[0])) {
                    PsCanvasLog.i("resolved " + classNames[0] + " as " + className);
                }
                return found;
            }
        }
        return null;
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
