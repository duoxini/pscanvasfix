package com.color.pscanvasfix.feature;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.compat.SplitPolicyCompat;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.InstanceStateKeys;
import com.color.pscanvasfix.runtime.InstanceStateStore;
import com.color.pscanvasfix.runtime.PackageLoadContext;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.util.ArrayList;
import java.util.List;

/** Installs behavior-preserving classic canvas entry and controller hooks. */
public final class ClassicCanvasController {
    public static final String HOOK_TRANSITION_INTENT_LIST_PATCH_IDS =
            "transition.intent_list.patch_ids";
    public static final String HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG =
            "controller.disable_three_together_flag";
    public static final String HOOK_ENTRY_DIRECT_THREE_ON_CREATE =
            "entry.direct_three.on_create";
    public static final String HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK =
            "entry.two_to_three.anchor_mark";
    public static final String HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT =
            "entry.two_to_three.anchor_redirect";

    private ClassicCanvasController() {
    }

    /**
     * Declares all controller hooks as one feature inventory.
     *
     * <p>Call the component declaration methods directly when the global inventory
     * interleaves these hooks with another feature's declarations.</p>
     */
    public static void declareHooks(HookRegistry hookRegistry,
                                    String controllerMethod,
                                    String containerActivityClass,
                                    String activityCreateMethod,
                                    String containerViewClass,
                                    String conversionMarkMethod,
                                    String anchorRedirectMethod) {
        declareTransitionHook(hookRegistry);
        declareControllerHook(hookRegistry, controllerMethod);
        declareEntryHooks(hookRegistry, containerActivityClass, activityCreateMethod,
                containerViewClass, conversionMarkMethod, anchorRedirectMethod);
    }

    public static void declareTransitionHook(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_TRANSITION_INTENT_LIST_PATCH_IDS,
                "SSTO_FLEXIBLE.intentList(); after");
    }

    public static void declareControllerHook(HookRegistry hookRegistry,
                                             String controllerMethod) {
        hookRegistry.declare(HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,
                "CANVAS_CONTROLLER." + controllerMethod + "(boolean); before; args[0]=false");
    }

    public static void declareEntryHooks(HookRegistry hookRegistry,
                                         String containerActivityClass,
                                         String activityCreateMethod,
                                         String containerViewClass,
                                         String conversionMarkMethod,
                                         String anchorRedirectMethod) {
        hookRegistry.declare(HOOK_ENTRY_DIRECT_THREE_ON_CREATE,
                simpleName(containerActivityClass) + "." + activityCreateMethod
                        + "(Bundle); before + after; direct-three entry");
        hookRegistry.declare(HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,
                simpleName(containerViewClass) + "." + conversionMarkMethod
                        + "(Context,List,int); after; mark new three-split");
        hookRegistry.declare(HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,
                simpleName(containerViewClass) + "." + anchorRedirectMethod
                        + "(int); before; consume one-time left anchor");
    }

    public static void installTransitionIntentPatch(PackageLoadContext lpparam,
                                                    HookRuntime hookRuntime,
                                                    HookRegistry hookRegistry,
                                                    String transitionClass,
                                                    String intentListMethod) {
        String detail = transitionClass + "." + intentListMethod + "(); after";
        try {
            FeatureHookInstaller.register(hookRuntime, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS,
                    transitionClass, lpparam.classLoader, intentListMethod,
                    new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            Object result = param.getResult();
                            if (result instanceof List) {
                                SplitPolicyCompat.patchIntentListTaskIds(param.thisObject,
                                        (List<?>) result);
                            }
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS, detail);
            PsCanvasLog.i("260608 SStoFlexible." + intentListMethod + " installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS,
                    detail, throwable);
            PsCanvasLog.e("260608 SStoFlexible." + intentListMethod + " failed", throwable);
        }
    }

    public static void markTransitionUnavailable(HookRegistry hookRegistry, String detail) {
        markHookSkipped(hookRegistry, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS, detail);
    }

    public static void installControllerFlagOverride(PackageLoadContext lpparam,
                                                     HookRuntime hookRuntime,
                                                     HookRegistry hookRegistry,
                                                     String controllerClass,
                                                     String controllerMethod) {
        String detail = controllerClass + "." + controllerMethod + "(boolean)";
        try {
            FeatureHookInstaller.register(hookRuntime,
                    HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,
                    controllerClass, lpparam.classLoader, controllerMethod,
                    Boolean.TYPE, new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            param.args[0] = false;
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,
                    detail);
            PsCanvasLog.i("260608 CanvasController." + controllerMethod + " installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,
                    detail, throwable);
            PsCanvasLog.e("260608 CanvasController." + controllerMethod + " failed", throwable);
        }
    }

    public static void markControllerUnavailable(HookRegistry hookRegistry, String detail) {
        markHookSkipped(hookRegistry, HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG, detail);
        PsCanvasLog.w("install: canvasController SKIPPED (no reliable class resolved)");
    }

    public static void installDirectEntryHook(PackageLoadContext lpparam,
                                              HookRuntime hookRuntime,
                                              HookRegistry hookRegistry,
                                              InstanceStateStore instanceStateStore,
                                              String containerActivityClass,
                                              String activityCreateMethod) {
        String detail = simpleName(containerActivityClass) + "." + activityCreateMethod
                + "(Bundle); before + after";
        try {
            FeatureHookInstaller.register(hookRuntime, HOOK_ENTRY_DIRECT_THREE_ON_CREATE,
                    containerActivityClass, lpparam.classLoader, activityCreateMethod,
                    Bundle.class, new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            Activity activity = (Activity) param.thisObject;
                            Intent intent = activity.getIntent();
                            Bundle extras = intent == null ? null : intent.getExtras();
                            if (!isDirectNewThreeSplit(extras)) {
                                return;
                            }

                            int oldFocus = extras.getInt(
                                    "androidx.flexible.focusIndex", -1);
                            int oldSide = extras.getInt("lineLayoutFocusSide", 0);
                            Bundle normalized = new Bundle(extras);
                            normalized.putInt("androidx.flexible.focusIndex", 0);
                            normalized.putInt("lineLayoutFocusSide", 0);
                            intent.replaceExtras(normalized);
                            instanceStateStore.put(param.thisObject,
                                    InstanceStateKeys.DIRECT_NEW_THREE_SPLIT_ENTRY,
                                    Boolean.TRUE);
                            PsCanvasLog.i("260608 direct new three-split entry: left anchor "
                                    + "focus=" + oldFocus + "->0 side=" + oldSide + "->0");
                        }

                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            if (!Boolean.TRUE.equals(
                                    instanceStateStore.get(param.thisObject,
                                            InstanceStateKeys.DIRECT_NEW_THREE_SPLIT_ENTRY))) {
                                return;
                            }
                            instanceStateStore.remove(param.thisObject,
                                    InstanceStateKeys.DIRECT_NEW_THREE_SPLIT_ENTRY);
                            ((Activity) param.thisObject).overridePendingTransition(0, 0);
                            PsCanvasLog.i("260608 direct new three-split entry animation disabled");
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_ENTRY_DIRECT_THREE_ON_CREATE, detail);
            PsCanvasLog.i("260608 direct new three-split entry hook installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_ENTRY_DIRECT_THREE_ON_CREATE, detail, throwable);
            PsCanvasLog.e("260608 direct new three-split entry hook failed", throwable);
        }
    }

    public static void installConversionAnchorHooks(PackageLoadContext lpparam,
                                                    HookRuntime hookRuntime,
                                                    HookRegistry hookRegistry,
                                                    ReflectionAccess reflectionAccess,
                                                    InstanceStateStore instanceStateStore,
                                                    String containerViewClass,
                                                    String conversionMarkMethod,
                                                    String anchorRedirectMethod,
                                                    String adapterGetterMethod,
                                                    String adapterCountMethod,
                                                    String adapterLayoutMethod,
                                                    String appEnterClassFragment,
                                                    String appEnterMethod) {
        String containerViewName = simpleName(containerViewClass);
        String markDetail = containerViewName + "." + conversionMarkMethod
                + "(Context,List,int); after";
        try {
            FeatureHookInstaller.register(hookRuntime, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,
                    containerViewClass, lpparam.classLoader, conversionMarkMethod,
                    Context.class, List.class, Integer.TYPE,
                    new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            int targetLayout = (Integer) param.args[2];
                            List<?> tasks = (List<?>) param.args[1];
                            if (!param.hasThrowable() && targetLayout == 3
                                    && tasks != null && tasks.size() == 3) {
                                instanceStateStore.put(param.thisObject,
                                        InstanceStateKeys.NEW_THREE_SPLIT_LEFT_ANCHOR,
                                        Boolean.TRUE);
                                PsCanvasLog.d(
                                        "260608 marked new 2-to-3 canvas for left anchor");
                            }
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,
                    markDetail);
            PsCanvasLog.i("260608 new three-split anchor marker installed on "
                    + containerViewName + "." + conversionMarkMethod);
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,
                    markDetail, throwable);
            PsCanvasLog.e("260608 new three-split anchor marker failed", throwable);
        }

        String redirectDetail = containerViewName + "." + anchorRedirectMethod
                + "(int); before";
        try {
            FeatureHookInstaller.register(hookRuntime, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,
                    containerViewClass, lpparam.classLoader, anchorRedirectMethod,
                    Integer.TYPE, new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            if ((Integer) param.args[0] != 2
                                    || !Boolean.TRUE.equals(
                                    instanceStateStore.get(param.thisObject,
                                            InstanceStateKeys.NEW_THREE_SPLIT_LEFT_ANCHOR))
                                    || !isNewTaskAppEnterAutoScale(
                                    appEnterClassFragment, appEnterMethod)) {
                                return;
                            }
                            Object adapter = reflectionAccess.callMethod(
                                    param.thisObject, adapterGetterMethod);
                            int count = (Integer) reflectionAccess.callMethod(
                                    adapter, adapterCountMethod);
                            int layout = (Integer) reflectionAccess.callMethod(
                                    adapter, adapterLayoutMethod);
                            if (count != 3 || layout != 3) {
                                instanceStateStore.remove(param.thisObject,
                                        InstanceStateKeys.NEW_THREE_SPLIT_LEFT_ANCHOR);
                                return;
                            }
                            param.args[0] = 0;
                            instanceStateStore.remove(param.thisObject,
                                    InstanceStateKeys.NEW_THREE_SPLIT_LEFT_ANCHOR);
                            PsCanvasLog.i("260608 redirected new three-split initial anchor "
                                    + "from right to left");
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,
                    redirectDetail);
            PsCanvasLog.i("260608 new three-split left anchor installed on "
                    + containerViewName + "." + anchorRedirectMethod);
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,
                    redirectDetail, throwable);
            PsCanvasLog.e("260608 new three-split left anchor failed", throwable);
        }
    }

    private static boolean isDirectNewThreeSplit(Bundle extras) {
        if (extras == null
                || extras.getInt("startCanvasFrom", 0) != 2
                || extras.getInt("androidx.flexible.layoutOrientation", 0) != 3) {
            return false;
        }
        int[] taskIds = extras.getIntArray("androidx.flexible.taskIdList");
        ArrayList<Intent> intents = extras.getParcelableArrayList(
                "androidx.flexible.intentList", Intent.class);
        return taskIds != null && taskIds.length == 3
                && intents != null && intents.size() == 3;
    }

    private static boolean isNewTaskAppEnterAutoScale(String classFragment,
                                                       String methodName) {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (int index = 0; index < Math.min(trace.length, 20); index++) {
            StackTraceElement frame = trace[index];
            if (frame.getClassName().contains(classFragment)
                    && methodName.equals(frame.getMethodName())) {
                return true;
            }
        }
        return false;
    }

    private static String simpleName(String className) {
        int separator = className.lastIndexOf('.');
        return separator < 0 ? className : className.substring(separator + 1);
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
