package com.color.pscanvasfix.feature;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import com.color.pscanvasfix.compat.FlexibleTransitionCompat;
import com.color.pscanvasfix.compat.PanoramaModeCompat;
import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.PackageLoadContext;

import java.util.ArrayList;
import java.util.List;

/** Installs the behavior-preserving classic three-task bounds and canvas layout hooks. */
public final class ClassicLayoutFeature {
    public static final String HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE =
            "transition.launch_bounds.fix_bundle";
    public static final String HOOK_BOUNDS_SINGLE_RESTORE_502 =
            "bounds.single.restore_502";
    public static final String HOOK_BOUNDS_MULTI_RESTORE_502 =
            "bounds.multi.restore_502";
    public static final String HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS =
            "layout.three.equal_width_canvas";

    private static volatile boolean equalWidthCanvasLogged;

    private ClassicLayoutFeature() {
    }

    public static void declareLaunchHook(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,
                "SSTO_FLEXIBLE.launchBounds(List,int[]); after");
    }

    public static void declareBoundsAndLayoutHooks(HookRegistry hookRegistry) {
        hookRegistry.declare(HOOK_BOUNDS_SINGLE_RESTORE_502,
                "B1.l.o(Intent,int,int); before + after; normalize single bounds");
        hookRegistry.declare(HOOK_BOUNDS_MULTI_RESTORE_502,
                "B1.l.n(List,int,Bundle); before + after; normalize multi bounds");
        hookRegistry.declare(HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,
                "B1.l.M1(List,int,float); after; restore equal-width canvas");
    }

    public static void installLaunchBoundsHook(PackageLoadContext lpparam,
                                               HookRuntime hookRuntime,
                                               HookRegistry hookRegistry,
                                               String transitionClass,
                                               String launchBoundsMethod) {
        String detail = transitionClass + "." + launchBoundsMethod
                + "(List,int[]); after";
        try {
            hookRuntime.findAndHookMethod(HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,
                    transitionClass, lpparam.classLoader, launchBoundsMethod,
                    List.class, int[].class, new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            Object result = param.getResult();
                            if (result instanceof Bundle) {
                                Context context = com.color.pscanvasfix.compat.SplitPolicyCompat
                                        .findContext(param.thisObject);
                                param.setResult(FlexibleTransitionCompat.fixLaunchBoundsBundle(
                                        (Bundle) result, context));
                            }
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,
                    detail);
            PsCanvasLog.i("260608 SStoFlexible.H installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,
                    detail, throwable);
            PsCanvasLog.e("260608 SStoFlexible.H failed", throwable);
        }
    }

    public static void install(PackageLoadContext lpparam, HookRuntime hookRuntime,
                               HookRegistry hookRegistry, String utilityClass,
                               String singleBoundsMethod, String multiBoundsMethod,
                               String equalWidthLayoutMethod) {
        installBoundsHooks(lpparam, hookRuntime, hookRegistry, utilityClass,
                singleBoundsMethod, multiBoundsMethod);
        installLayoutHook(lpparam, hookRuntime, hookRegistry, utilityClass,
                equalWidthLayoutMethod);
    }

    private static void installBoundsHooks(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                           HookRegistry hookRegistry, String utilityClass,
                                           String singleBoundsMethod,
                                           String multiBoundsMethod) {
        try {
            hookRuntime.findAndHookMethod(HOOK_BOUNDS_SINGLE_RESTORE_502,
                    utilityClass, lpparam.classLoader, singleBoundsMethod,
                    Intent.class, Integer.TYPE, Integer.TYPE,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            Intent intent = (Intent) param.args[0];
                            if (intent != null && intent.getBooleanExtra(
                                    "isThreeSplitTogether", false)) {
                                intent.removeExtra("isThreeSplitTogether");
                                param.setObjectExtra("pscanvasfix_502_single_bounds", Boolean.TRUE);
                                PsCanvasLog.i("260608 B1.l.o: removed 700 "
                                        + "isThreeSplitTogether from single-task request");
                            }
                        }

                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            if (!Boolean.TRUE.equals(param.getObjectExtra(
                                    "pscanvasfix_502_single_bounds"))
                                    || !(param.getResult() instanceof Bundle)) {
                                return;
                            }
                            Bundle normalized = normalizeThreeTaskBounds(
                                    (Bundle) param.getResult());
                            param.setResult(normalized);
                            PsCanvasLog.i("260608 B1.l.o: normalized single-task bounds to "
                                    + normalized.getParcelable(
                                    "androidx.flexible.LaunchBounds", Rect.class));
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_BOUNDS_SINGLE_RESTORE_502,
                    "B1.l.o(Intent,int,int); before + after");
            PsCanvasLog.i("260608 B1.l.o 502 single-task bounds installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_BOUNDS_SINGLE_RESTORE_502,
                    "B1.l.o(Intent,int,int); before + after", throwable);
            PsCanvasLog.e("260608 B1.l.o single-task bounds install failed", throwable);
        }

        try {
            hookRuntime.findAndHookMethod(HOOK_BOUNDS_MULTI_RESTORE_502,
                    utilityClass, lpparam.classLoader, multiBoundsMethod,
                    List.class, Integer.TYPE, Bundle.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            if (!(param.args[0] instanceof List)
                                    || ((List<?>) param.args[0]).size() != 3
                                    || !Integer.valueOf(3).equals(param.args[1])
                                    || !(param.args[2] instanceof Bundle)) {
                                return;
                            }
                            Bundle request = (Bundle) param.args[2];
                            if (!request.getBoolean("isThreeSplitTogether", false)) {
                                return;
                            }
                            Bundle restored502Request = new Bundle(request);
                            restored502Request.remove("isThreeSplitTogether");
                            param.args[2] = restored502Request;
                            param.setObjectExtra("pscanvasfix_502_multi_bounds", Boolean.TRUE);
                            PsCanvasLog.i("260608 B1.l.n: removed 700 "
                                    + "isThreeSplitTogether bounds flag");
                        }

                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            if (!Boolean.TRUE.equals(param.getObjectExtra(
                                    "pscanvasfix_502_multi_bounds"))
                                    || !(param.getResult() instanceof Bundle)) {
                                return;
                            }
                            Bundle result = new Bundle((Bundle) param.getResult());
                            ArrayList<Bundle> taskBundles = result.getParcelableArrayList(
                                    "androidx.flexible.layout.info.list", Bundle.class);
                            if (taskBundles == null || taskBundles.size() != 3) {
                                return;
                            }
                            ArrayList<Bundle> normalizedTaskBundles = new ArrayList<>(3);
                            for (Bundle taskBundle : taskBundles) {
                                normalizedTaskBundles.add(normalizeThreeTaskBounds(taskBundle));
                            }
                            result.putParcelableArrayList(
                                    "androidx.flexible.layout.info.list", normalizedTaskBundles);
                            param.setResult(result);
                            PsCanvasLog.i("260608 B1.l.n: normalized initial three-task bounds "
                                    + "to 502 column width");
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_BOUNDS_MULTI_RESTORE_502,
                    "B1.l.n(List,int,Bundle); before + after");
            PsCanvasLog.i("260608 B1.l.n 502 bounds request installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_BOUNDS_MULTI_RESTORE_502,
                    "B1.l.n(List,int,Bundle); before + after", throwable);
            PsCanvasLog.e("260608 B1.l.n bounds request install failed", throwable);
        }
    }

    private static Bundle normalizeThreeTaskBounds(Bundle source) {
        Bundle normalized = new Bundle(source);
        Rect launchBounds = normalized.getParcelable(
                "androidx.flexible.LaunchBounds", Rect.class);
        if (launchBounds == null || launchBounds.height() <= 0) {
            return normalized;
        }
        if (!PanoramaModeCompat.isPortraitColumn(
                launchBounds.width(), launchBounds.height())) {
            return normalized;
        }
        int width = PanoramaModeCompat.equalColumnWidth(launchBounds.height());
        Rect columnBounds = new Rect(launchBounds.left, launchBounds.top,
                launchBounds.left + width, launchBounds.bottom);
        normalized.putParcelable("androidx.flexible.LaunchBounds", columnBounds);
        normalized.putParcelable("androidx.flexible.LaunchHorizontalBounds",
                new Rect(columnBounds));
        return normalized;
    }

    private static void installLayoutHook(PackageLoadContext lpparam, HookRuntime hookRuntime,
                                          HookRegistry hookRegistry, String utilityClass,
                                          String equalWidthLayoutMethod) {
        try {
            hookRuntime.findAndHookMethod(HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,
                    utilityClass, lpparam.classLoader, equalWidthLayoutMethod,
                    List.class, Integer.TYPE, Float.TYPE,
                    new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            Object rawResult = param.getResult();
                            if (!(rawResult instanceof List)
                                    || !(param.args[0] instanceof List)
                                    || ((List<?>) param.args[0]).size() != 3
                                    || !Integer.valueOf(3).equals(param.args[1])) {
                                return;
                            }
                            try {
                                List<?> original = (List<?>) rawResult;
                                if (original.size() != 3) {
                                    return;
                                }
                                int top = Integer.MAX_VALUE;
                                int height = 0;
                                for (Object item : original) {
                                    if (!(item instanceof Rect)) {
                                        return;
                                    }
                                    Rect rect = (Rect) item;
                                    top = Math.min(top, rect.top);
                                    height = Math.max(height, rect.height());
                                }
                                if (height <= 0 || top == Integer.MAX_VALUE) {
                                    return;
                                }
                                for (Object item : original) {
                                    Rect rect = (Rect) item;
                                    if (!PanoramaModeCompat.isPortraitColumn(
                                            rect.width(), rect.height())) {
                                        return;
                                    }
                                }
                                float density = ((Number) param.args[2]).floatValue();
                                int gap = Math.max(1, Math.round(density * 10.0f));
                                int width = PanoramaModeCompat.equalColumnWidth(height);
                                ArrayList<Rect> restored = new ArrayList<>(3);
                                int left = 0;
                                for (int index = 0; index < 3; index++) {
                                    restored.add(new Rect(left, top, left + width, top + height));
                                    left += width + gap;
                                }
                                param.setResult(restored);
                                if (!equalWidthCanvasLogged) {
                                    equalWidthCanvasLogged = true;
                                    PsCanvasLog.i("260608 B1.l.M1: restored 502 wide canvas "
                                            + "width=" + width + " height=" + height
                                            + " gap=" + gap + " rects=" + restored);
                                }
                            } catch (Throwable throwable) {
                                PsCanvasLog.e("260608 equal-width canvas callback failed", throwable);
                            }
                        }
                    });
            markHookInstalled(hookRegistry, HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,
                    "B1.l.M1(List,int,float); after");
            PsCanvasLog.i("260608 B1.l.M1 502 wide canvas installed");
        } catch (Throwable throwable) {
            markHookFailed(hookRegistry, HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,
                    "B1.l.M1(List,int,float); after", throwable);
            PsCanvasLog.e("260608 B1.l.M1 wide canvas install failed", throwable);
        }
    }

    private static void markHookInstalled(HookRegistry hookRegistry, String hookId,
                                          String detail) {
        try {
            hookRegistry.markInstalled(hookId, detail);
        } catch (Throwable throwable) {
            PsCanvasLog.e("HookRegistry INSTALLED update failed for " + hookId, throwable);
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
