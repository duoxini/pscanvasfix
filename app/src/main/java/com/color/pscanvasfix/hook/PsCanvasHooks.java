package com.color.pscanvasfix.hook;

import android.app.Activity;
import android.content.ComponentName;
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
import com.color.pscanvasfix.compat.PanoramaModeCompat;
import com.color.pscanvasfix.compat.PinchTransition502Compat;
import com.color.pscanvasfix.compat.PsCanvasLog;
import com.color.pscanvasfix.compat.SplitBar502Compat;
import com.color.pscanvasfix.compat.SplitPolicyCompat;
import com.color.pscanvasfix.compat.ThreeSplitTouch502Compat;
import com.color.pscanvasfix.BuildConfig;
import com.color.pscanvasfix.core.CapabilitySet;
import com.color.pscanvasfix.core.FeatureManager;
import com.color.pscanvasfix.feature.ClassicLayoutFeature;
import com.color.pscanvasfix.feature.ClassicCanvasController;
import com.color.pscanvasfix.feature.FourTaskTraceFeature;
import com.color.pscanvasfix.feature.PanoramaFeature;
import com.color.pscanvasfix.feature.PinchGestureFeature;
import com.color.pscanvasfix.feature.SplitBarFeature;
import com.color.pscanvasfix.feature.resize.SavedSplitLayoutFeature;
import com.color.pscanvasfix.runtime.HookRegistry;
import com.color.pscanvasfix.runtime.AndroidLogSink;
import com.color.pscanvasfix.runtime.InstanceStateKeys;
import com.color.pscanvasfix.runtime.InstanceStateStore;
import com.color.pscanvasfix.runtime.WeakIdentityInstanceStateBackend;
import com.color.pscanvasfix.runtime.JavaReflectionBackend;
import com.color.pscanvasfix.runtime.ModernXposedLogSink;
import com.color.pscanvasfix.runtime.ModuleLogger;
import com.color.pscanvasfix.runtime.ReflectionAccess;

import java.io.File;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.color.pscanvasfix.runtime.HookCallback;
import com.color.pscanvasfix.runtime.HookReplacement;
import com.color.pscanvasfix.runtime.HookCall;
import com.color.pscanvasfix.runtime.HookRuntime;
import com.color.pscanvasfix.runtime.PackageLoadContext;

public final class PsCanvasHooks {
    private static final String TAG = "PsCanvasFix";
    private static final String TARGET_PACKAGE = "com.oplus.pscanvas";
    // Legacy 260403 symbols. They remain only in unused legacy helpers; the
    // active 260608 installation path is selected through the APK profile.
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
        Object run(HookCall param) throws Throwable;
    }

    private interface HookBefore {
        void run(HookCall param) throws Throwable;
    }

    private interface HookAfter {
        void run(HookCall param) throws Throwable;
    }

    private PsCanvasHooks() {
    }

    private static volatile boolean deferredHooksInstalled = false;
    private static volatile PsCanvasCompatibilityProfile activeProfile;
    private static volatile HookRegistry activeHookRegistry = new HookRegistry();
    private static final InstanceStateStore INSTANCE_STATE_STORE =
            new InstanceStateStore(new WeakIdentityInstanceStateBackend());
    private static final ReflectionAccess DEFAULT_REFLECTION_ACCESS =
            new ReflectionAccess(new JavaReflectionBackend());
    private static volatile ReflectionAccess reflectionAccess = DEFAULT_REFLECTION_ACCESS;
    private static volatile HookRuntime hookRuntime;
    public static void install(PackageLoadContext lpparam, HookRuntime runtime) {
        if (!TARGET_PACKAGE.equals(lpparam.packageName)) {
            return;
        }
        hookRuntime = Objects.requireNonNull(runtime, "runtime");
        HookRegistry hookRegistry = new HookRegistry();
        PinchGestureFeature.declareLifecycleHooks(hookRegistry);
        PanoramaFeature.declareLaunchGuard(hookRegistry);
        PinchGestureFeature.declareScaleHook(hookRegistry);
        ClassicCanvasController.declareTransitionHook(hookRegistry);
        ClassicLayoutFeature.declareLaunchHook(hookRegistry);
        PanoramaFeature.declareMaskFix(hookRegistry);
        PinchGestureFeature.declareTouchHooks(hookRegistry);
        ClassicCanvasController.declareControllerHook(hookRegistry, "O");
        PanoramaFeature.declareExitGuard(hookRegistry);
        ClassicLayoutFeature.declareBoundsAndLayoutHooks(hookRegistry);
        ClassicCanvasController.declareEntryHooks(hookRegistry,
                CONTAINER_ACTIVITY, "onCreate", CONTAINER_VIEW, "e3", "R");
        SplitBarFeature.declareHooks(hookRegistry);
        SavedSplitLayoutFeature.declareHooks(hookRegistry);
        activeHookRegistry = hookRegistry;
        String apkPath = lpparam.appInfo == null ? null : lpparam.appInfo.sourceDir;

        // SHA-256 is diagnostics only now: it is logged but never gates install().
        // A null / unknown profile must NOT disable the module.
        ApkFingerprint.ApkInfo apkInfo = ApkFingerprint.collect(apkPath);
        PsCanvasLog.i("install target=" + lpparam.packageName
                + " (diagnostic only, not gating) " + apkInfo.brief());

        // Structural symbol resolution, run once per process and cached.
        File apkFile = apkPath == null ? null : new File(apkPath);
        PsCanvasSymbols symbols = PsCanvasSymbolResolver.resolveCached(apkFile);
        PsCanvasLog.i(CapabilityReport.render(
                apkInfo, PsCanvasSymbolResolver.dexClassCount(), symbols));

        PsCanvasSymbols.RoleSymbol savedLayout =
                symbols.role(PsCanvasSymbols.Role.SAVED_SPLIT_LAYOUT);
        PsCanvasSymbols.RoleSymbol threeTaskResize =
                symbols.role(PsCanvasSymbols.Role.THREE_TASK_RESIZE);
        CapabilitySet.State savedLayoutCapability =
                savedLayout.available() && threeTaskResize.available()
                        ? CapabilitySet.State.READY
                        : savedLayout.status == PsCanvasSymbols.Status.AMBIGUOUS
                        || threeTaskResize.status == PsCanvasSymbols.Status.AMBIGUOUS
                        ? CapabilitySet.State.AMBIGUOUS : CapabilitySet.State.MISSING;
        FeatureManager featureManager = new FeatureManager(
                lpparam.preferences, CapabilitySet.of(
                        savedLayoutCapability, CapabilitySet.State.UNVERIFIED));
        PsCanvasLog.i("feature adjustable_window_size="
                + featureManager.status(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE)
                + " four_task_canvas="
                + featureManager.status(FeatureManager.Feature.FOUR_TASK_CANVAS));

        SavedSplitLayoutFeature.install(lpparam, hookRuntime, hookRegistry,
                reflectionAccess,
                savedLayout,
                featureManager.isEnabled(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE));

        if (BuildConfig.DEBUG) {
            installFourTaskTrace(lpparam, symbols, hookRegistry);
        }

        // Keep the exact profile around for diagnostics / known-symbol hints.
        // It must never gate anything.
        PsCanvasCompatibilityProfile profile = PsCanvasCompatibilityProfile.find(apkInfo.sha256);
        if (profile != null) {
            activeProfile = profile;
        }

        // Install per capability group. A missing role only SKIPs its own group.
        if (symbols.role(PsCanvasSymbols.Role.SSTO_FLEXIBLE).available()) {
            PsCanvasSymbols.RoleSymbol ssto =
                    symbols.role(PsCanvasSymbols.Role.SSTO_FLEXIBLE);
            String transitionClass = ssto.className;
            String scaleMethod = ssto.scaleMethod != null ? ssto.scaleMethod
                    : (profile == null ? null : profile.scaleMethod());
            String intentListMethod = ssto.intentListMethod != null ? ssto.intentListMethod
                    : (profile == null ? null : profile.intentListMethod());
            String launchBoundsMethod = ssto.launchBoundsMethod != null
                    ? ssto.launchBoundsMethod
                    : (profile == null ? null : profile.launchBoundsMethod());
            String maskMethod = ssto.maskAnimMethod != null ? ssto.maskAnimMethod
                    : (profile == null ? null : profile.maskAnimationMethod());
            PinchGestureFeature.installLifecycleHooks(lpparam, hookRuntime, hookRegistry,
                    transitionClass, "Q", "u0", "I0");
            PanoramaFeature.installLaunchGuard(lpparam, hookRuntime, hookRegistry,
                    reflectionAccess, transitionClass, "L0",
                    "getPanoramaModeManager", "M");
            PsCanvasSymbols.RoleSymbol panoramaManager =
                    symbols.role(PsCanvasSymbols.Role.PANORAMA_MANAGER);
            boolean twoTaskPanoramaCapability = panoramaManager.available()
                    && panoramaManager.twoTaskPredicateMethod != null;
            String panoramaActiveMethod = twoTaskPanoramaCapability
                    ? panoramaManager.panoramaActiveMethod : "M";
            String panoramaEnterMethod = twoTaskPanoramaCapability
                    ? panoramaManager.panoramaEnterMethod : "z";
            String panoramaExitMethod = twoTaskPanoramaCapability
                    ? panoramaManager.panoramaExitMethod : "A";
            PinchGestureFeature.installScaleHook(lpparam, hookRuntime, hookRegistry,
                    reflectionAccess, transitionClass, scaleMethod,
                    "getPanoramaModeManager", panoramaActiveMethod,
                    panoramaEnterMethod, panoramaExitMethod,
                    twoTaskPanoramaCapability);
            ClassicCanvasController.installTransitionIntentPatch(
                    lpparam, hookRuntime, hookRegistry, transitionClass, intentListMethod);
            ClassicLayoutFeature.installLaunchBoundsHook(lpparam, hookRuntime, hookRegistry,
                    transitionClass, launchBoundsMethod);
            PanoramaFeature.installMaskFix(lpparam, hookRuntime, hookRegistry,
                    reflectionAccess, transitionClass, maskMethod, EMBEDDED_VIEW_DECOR,
                    "com.oplus.flexiblewindow.FlexibleTaskView");
        } else {
            String unavailable = "SSTO_FLEXIBLE role unavailable";
            PinchGestureFeature.markLifecycleAndScaleUnavailable(hookRegistry, unavailable);
            markHookSkipped(hookRegistry,
                    PanoramaFeature.HOOK_LAUNCH_WHILE_ACTIVE_BLOCK, unavailable);
            ClassicCanvasController.markTransitionUnavailable(hookRegistry, unavailable);
            markHookSkipped(hookRegistry,
                    ClassicLayoutFeature.HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,
                    unavailable);
            markHookSkipped(hookRegistry,
                    PanoramaFeature.HOOK_TRANSITION_MASK_RECT_FIX, unavailable);
            PsCanvasLog.w("install: sstoFlexible SKIPPED (no reliable class resolved)");
        }

        boolean anim = symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_ANIM).available();
        boolean drag = symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_DRAG).available();
        if (anim && drag) {
            HookRuntime.Group touchGroup = hookRuntime.beginGroup("three_split_touch_composite");
            boolean committed = false;
            try {
                String animationClass =
                        symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_ANIM).className;
                if (animationClass == null && profile != null) {
                    animationClass = profile.threeSplitAnimClass();
                }
                String dragClass =
                        symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_DRAG).className;
                if (dragClass == null && profile != null) {
                    dragClass = profile.threeSplitDragClass();
                }
                PinchGestureFeature.installTouchHooks(lpparam, hookRuntime, hookRegistry,
                        reflectionAccess, animationClass, dragClass, "x1.a",
                        EMBEDDED_VIEW_DECOR, "H0", "U0", "e0", "p0", "y0",
                        "b", "c", "d", "e");
                if (PinchGestureFeature.allTouchHooksInstalled(hookRegistry)) {
                    committed = hookRuntime.commitGroup(touchGroup);
                }
            } finally {
                if (!touchGroup.isClosed()) {
                    hookRuntime.rollbackGroup(touchGroup);
                }
            }
            if (!committed) {
                PinchGestureFeature.markTouchRolledBack(hookRegistry);
                PsCanvasLog.e("install: threeSplitTouch composite rolled back", null);
            }
        } else {
            String compositeUnavailable = "THREE_SPLIT_ANIM && THREE_SPLIT_DRAG unavailable"
                    + " (anim=" + anim + " drag=" + drag + ")";
            PinchGestureFeature.markTouchUnavailable(hookRegistry, compositeUnavailable);
            PsCanvasLog.w("install: threeSplitTouch SKIPPED"
                    + " (anim=" + anim + " drag=" + drag + ")");
        }

        if (symbols.role(PsCanvasSymbols.Role.CANVAS_CONTROLLER).available()) {
            String controllerClass =
                    symbols.role(PsCanvasSymbols.Role.CANVAS_CONTROLLER).className;
            if (controllerClass == null && profile != null) {
                controllerClass = profile.canvasControllerClass();
            }
            ClassicCanvasController.installControllerFlagOverride(
                    lpparam, hookRuntime, hookRegistry, controllerClass, "O");
        } else {
            ClassicCanvasController.markControllerUnavailable(
                    hookRegistry, "CANVAS_CONTROLLER role unavailable");
        }

        // The remaining groups are independent capabilities: let them run and each
        // one logs its own install / failure. They no longer depend on a profile.
        PanoramaFeature.installExitGuard(lpparam, hookRuntime, hookRegistry,
                reflectionAccess, CONTAINER_VIEW, "getPanoramaModeManager", "A",
                "com.oplus.pscanvas.canvasmode.canvas.B0",
                "com.oplus.pscanvas.canvasmode.canvas.A0");
        ClassicLayoutFeature.install(lpparam, hookRuntime, hookRegistry,
                UTIL, "o", "n", "M1");
        ClassicCanvasController.installDirectEntryHook(lpparam, hookRuntime, hookRegistry,
                INSTANCE_STATE_STORE, CONTAINER_ACTIVITY, "onCreate");
        ClassicCanvasController.installConversionAnchorHooks(lpparam, hookRuntime,
                hookRegistry, reflectionAccess, INSTANCE_STATE_STORE, CONTAINER_VIEW,
                "e3", "R", "getAdapter", "getCount", "n",
                ".canvasmode.canvas.ContainerActivity$", "c");
        SplitBarFeature.install(lpparam, hookRuntime, hookRegistry, reflectionAccess,
                threeTaskResize.className, threeTaskResize.threeTaskResizeSpringClass,
                threeTaskResize.threeTaskResizeSpringStateClass,
                threeTaskResize.threeTaskResizeRectUpdateMethod,
                threeTaskResize.threeTaskResizeScrollStartMethod,
                threeTaskResize.threeTaskResizeEnlargeMethod,
                threeTaskResize.threeTaskResizeSpringDragMethod,
                threeTaskResize.threeTaskResizeSpringInitMethod,
                featureManager.isEnabled(FeatureManager.Feature.ADJUSTABLE_WINDOW_SIZE));

        logHookRegistrySnapshot(hookRegistry);
        PsCanvasLog.i("install: capability-driven install complete;"
                + " enabled=" + symbols.enabledCapabilities());
    }

    private static void installFourTaskTrace(PackageLoadContext lpparam,
                                             PsCanvasSymbols symbols,
                                             HookRegistry hookRegistry) {
        PsCanvasSymbols.RoleSymbol trace =
                symbols.role(PsCanvasSymbols.Role.P4_TRACE_CHAIN);
        if (!trace.available()) {
            PsCanvasLog.w("[FourTask][Trace] TRACE_DISABLED resolver=" + trace.status);
            return;
        }
        try {
            Class<?> controller = reflectionAccess.findClass(
                    trace.className, lpparam.classLoader);
            Class<?> adapter = reflectionAccess.findClass(
                    trace.p4AdapterClass, lpparam.classLoader);
            Class<?> taskData = reflectionAccess.findClass(
                    descriptorToClassName(trace.p4TaskDataDescriptor), lpparam.classLoader);
            Class<?> decor = reflectionAccess.findClass(
                    trace.p4EmbeddedViewDecorClass, lpparam.classLoader);
            Class<?> callback = reflectionAccess.findClass(
                    trace.p4TaskCreatedCallbackClass, lpparam.classLoader);
            Class<?> flexibleTaskView = reflectionAccess.findClass(
                    trace.p4FlexibleTaskViewClass, lpparam.classLoader);
            FourTaskTraceFeature.Config config = new FourTaskTraceFeature.Config(
                    controller, trace.p4ControllerAppendMethod,
                    trace.p4ControllerRemoveMethod, trace.p4ControllerFocusMethod,
                    adapter, trace.p4AdapterAddMethod, trace.p4AdapterRemoveMethod,
                    taskData,
                    decor, trace.p4EmbeddedBindMethod, trace.p4EmbeddedAttachedMethod,
                    callback, trace.p4TaskCreatedMethod,
                    flexibleTaskView, trace.p4FlexibleResizeMethod,
                    trace.p4FlexibleReleaseMethod,
                    Rect.class, ComponentName.class);
            FourTaskTraceFeature.declareHooks(hookRegistry, config);
            ModuleLogger logger = new ModuleLogger(TAG,
                    new AndroidLogSink(), new ModernXposedLogSink());
            boolean installed = FourTaskTraceFeature.install(
                    hookRuntime, hookRegistry, logger,
                    new FourTaskTraceSnapshotReader(reflectionAccess, trace), config);
            PsCanvasLog.i("[FourTask][Trace] state="
                    + (installed ? "TRACE_READY" : "TRACE_DISABLED"));
        } catch (Throwable throwable) {
            PsCanvasLog.e("[FourTask][Trace] TRACE_DISABLED setup failed", throwable);
        }
    }

    private static String descriptorToClassName(String descriptor) {
        if (descriptor == null || descriptor.length() < 3
                || descriptor.charAt(0) != 'L'
                || descriptor.charAt(descriptor.length() - 1) != ';') {
            throw new IllegalArgumentException("Invalid object descriptor: " + descriptor);
        }
        return descriptor.substring(1, descriptor.length() - 1).replace('/', '.');
    }

    public static List<HookRegistry.Entry> hookRegistrySnapshot() {
        return activeHookRegistry.snapshot();
    }

    private static void logHookRegistrySnapshot(HookRegistry hookRegistry) {
        for (HookRegistry.Entry entry : hookRegistry.snapshot()) {
            PsCanvasLog.i("hook-registry id=" + entry.id()
                    + " status=" + entry.status()
                    + " detail=" + entry.detail());
        }
    }

    static synchronized void setReflectionAccessForTests(ReflectionAccess access) {
        reflectionAccess = Objects.requireNonNull(access, "access");
    }

    static synchronized void resetReflectionAccessForTests() {
        reflectionAccess = DEFAULT_REFLECTION_ACCESS;
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

    /**
     * A launcher-created three split is delivered as a fresh canvas activity
     * (startCanvasFrom=2), not through ContainerView.e3. Keep that entry on the
     * 502 left anchor and suppress only its activity-open transition.
     */
    /** Keep a normal single tap from exiting the full panorama overview. */
    private static void installDeferredHooksOnContainerStart(PackageLoadContext lpparam) {
        try {
            hookRuntime.findAndHookMethod(CONTAINER_ACTIVITY, lpparam.classLoader, "onCreate",
                    Bundle.class, new HookCallback() {
                        @Override
                        protected void afterHookedMethod(HookCall param) {
                            if (deferredHooksInstalled) {
                                return;
                            }
                            deferredHooksInstalled = true;
                            PsCanvasLog.i("installing deferred hooks after ContainerActivity.onCreate");
                            hook502BehaviorRestoreDeferred(lpparam);
                            hookTwoColumnPanoramaRestoreDeferred(lpparam);
                        }
                    });
        } catch (Throwable throwable) {
            PsCanvasLog.e("ContainerActivity.onCreate defer hook failed:", throwable);
            hook502BehaviorRestoreDeferred(lpparam);
            hookTwoColumnPanoramaRestoreDeferred(lpparam);
        }
    }

    private static Class<?> findClassSafe(String className, ClassLoader classLoader) {
        try {
            return reflectionAccess.findClass(className, classLoader);
        } catch (Throwable throwable) {
            PsCanvasLog.d("class not ready: " + className + " (" + throwable + ")");
            return null;
        }
    }

    private static Class<?> findClassFirst(ClassLoader classLoader, String... classNames) {
        for (String className : classNames) {
            Class<?> found = findClassSafe(className, classLoader);
            if (found != null) {
                if (!className.equals(classNames[0])) {
                    PsCanvasLog.i("resolved " + classNames[0] + " as " + className);
                }
                return found;
            }
        }
        return null;
    }

    /**
     * The 260608 manager is exposed by ContainerView. B0.z(true) is the native
     * panorama entry path; B0.A(...) exits and must not be used here.
     */
    private static boolean enter260608PanoramaFromPinch(Object splitPolicy, Object containerView) {
        if (containerView == null) {
            PsCanvasLog.d("260608 panorama gate: ContainerView missing");
            return false;
        }
        if (!ThreeSplitTouch502Compat.isThreeAppCanvas(containerView)) {
            PsCanvasLog.d("260608 panorama gate: not a three-app canvas");
            return false;
        }
        try {
            Object adapter = reflectionAccess.callMethod(containerView, "getAdapter");
            Object rawLayout = adapter == null ? null : reflectionAccess.callMethod(adapter, "n");
            PsCanvasLog.i("260608 panorama gate: layout=" + rawLayout);
            if (!(rawLayout instanceof Integer)
                    || !PanoramaModeCompat.shouldEnterFromPinch(3, (Integer) rawLayout)) {
                return false;
            }
            Object manager = reflectionAccess.callMethod(containerView, "getPanoramaModeManager");
            if (manager == null) {
                PsCanvasLog.w("260608 panorama manager missing");
                return false;
            }
            Object active = reflectionAccess.callMethod(manager, "M");
            if (!Boolean.TRUE.equals(active)) {
                reflectionAccess.callMethod(manager, "z", true);
                PsCanvasLog.i("260608 entered full panorama mode from layout=" + rawLayout);
            } else {
                PsCanvasLog.d("260608 kept full panorama mode from layout=" + rawLayout);
            }
            return true;
        } catch (Throwable throwable) {
            PsCanvasLog.e("260608 panorama entry failed", throwable);
            return false;
        }
    }

    /**
     * Restore 502 split-screen / five-finger pinch behavior on 700 (core, primary dex).
     */
    private static void hook502BehaviorRestoreCore(PackageLoadContext lpparam) {
        replaceMethod(lpparam, UTIL, "F0", new Class[]{Context.class}, param -> {
            try {
                Object activity = reflectionAccess.callStaticMethod(
                        reflectionAccess.findClass(UTIL, lpparam.classLoader),
                        "O1", param.args[0]);
                if (activity != null) {
                    Object containerView = reflectionAccess.callMethod(activity, "v0");
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

    private static void hook502BehaviorRestoreDeferred(PackageLoadContext lpparam) {
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
    private static void hookGestureThreeAppSync(PackageLoadContext lpparam,
                                                Class<?> gestureClass) {
        Class<?> containerActivityClass = findClassFirst(lpparam.classLoader,
                CONTAINER_ACTIVITY, "com.oplus.pscanvas.canvasmode.canvas.ContainerActivity");
        if (containerActivityClass != null) {
            try {
                hookRuntime.findAndHookConstructor(gestureClass, containerActivityClass,
                        new HookCallback() {
                            @Override
                            protected void afterHookedMethod(HookCall param) {
                                try {
                                    Object containerView = reflectionAccess.callMethod(param.args[0], "v0");
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
                hookRuntime.findAndHookMethod(gestureClass, "O",
                        draggableClass,
                        reflectionAccess.findClass(CONTAINER_VIEW, lpparam.classLoader),
                        panoramaClass,
                        new HookCallback() {
                            @Override
                            protected void afterHookedMethod(HookCall param) {
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
    private static void hook502SplitToFlexibleRestore(PackageLoadContext lpparam) {
        replaceMethod(lpparam, CONTAINER_ACTIVITY, "F1", new Class[0], param -> {
            PsCanvasLog.d("blocked F1 setChangeToState(2) for 502 pinch path");
            return null;
        });

        hookBeforeMethod(lpparam, SSTO_FLEX, "k0", new Class[]{Integer.TYPE}, param -> {
            int state = (Integer) param.args[0];
            if (state == 0 || state == 2) {
                param.args[0] = 1;
                PsCanvasLog.d("k0 remap changeState " + state + " -> 1");
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
                List<?> intents = (List<?>) reflectionAccess.callMethod(splitPolicy, "C");
                if (intents != null) {
                    SplitPolicyCompat.patchIntentListTaskIds(splitPolicy, intents);
                }
            } catch (Throwable throwable) {
                PsCanvasLog.e("e0 intent patch failed", throwable);
            }
            return hookRuntime.invokeOriginalMethod(param.method, splitPolicy, param.args);
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
                PsCanvasLog.d("blocked i0 reset during 502 zoom transition");
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
            return hookRuntime.invokeOriginalMethod(param.method, splitPolicy, param.args);
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
                return hookRuntime.invokeOriginalMethod(param.method, splitPolicy, param.args);
            }
            safeCall(activity, "L1", true);
            try {
                Object tracker = reflectionAccess.callStaticMethod(
                        reflectionAccess.findClass("B1.h", lpparam.classLoader), "a", activity);
                reflectionAccess.callMethod(tracker, "e", "four_finger_to_zoom");
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
    private static void hookPanoramaMaskAnimRectFix(PackageLoadContext lpparam) {
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
    private static void hook502ThreeSplitTouchRestore(PackageLoadContext lpparam) {
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
                    return hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
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
    private static void hookPanoramaPeekFocusRestore(PackageLoadContext lpparam) {
        try {
            hookRuntime.findAndHookMethod(ADAPTER, lpparam.classLoader, "H",
                    Integer.TYPE, new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
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
                                                   PackageLoadContext lpparam,
                                                   String logLabel, Class<?>... parameterTypes) {
        hookVoidWhenPanoramaTouchCore(targetClass, methodName, lpparam, logLabel,
                null, null, null, parameterTypes);
    }

    private static void hookVoidWhenPanoramaTouch(Class<?> targetClass, String methodName,
                                                   PackageLoadContext lpparam,
                                                   String logLabel, HookRegistry hookRegistry,
                                                   String hookId, String detail,
                                                   Class<?>... parameterTypes) {
        hookVoidWhenPanoramaTouchCore(targetClass, methodName, lpparam, logLabel,
                hookRegistry, hookId, detail, parameterTypes);
    }

    private static void hookVoidWhenPanoramaTouchCore(Class<?> targetClass, String methodName,
                                                       PackageLoadContext lpparam,
                                                       String logLabel,
                                                       HookRegistry hookRegistry,
                                                       String hookId, String detail,
                                                       Class<?>[] parameterTypes) {
        try {
            Object[] hookArgs = buildBeforeHookArgs(parameterTypes,
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
                    });
            hookRuntime.findAndHookMethod(hookId, targetClass, methodName, hookArgs);
            if (hookRegistry != null) {
                markHookInstalled(hookRegistry, hookId, detail);
            }
        } catch (Throwable throwable) {
            if (hookRegistry != null) {
                markHookFailed(hookRegistry, hookId, detail, throwable);
            }
            PsCanvasLog.e("hook502ThreeSplitTouchRestore " + targetClass.getName()
                    + "." + methodName + " failed", throwable);
        }
    }

    private static Object[] buildBeforeHookArgs(Class<?>[] parameterTypes, HookBefore body) {
        Object[] args = new Object[parameterTypes.length + 1];
        System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
        args[parameterTypes.length] = new HookCallback() {
            @Override
            protected void beforeHookedMethod(HookCall param) throws Throwable {
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
                    reflectionAccess.callMethod(policy, "g0");
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
    private static void hookTwoColumnPanoramaRestoreCore(PackageLoadContext lpparam) {
        try {
            hookRuntime.findAndHookMethod(Intent.class, "putExtra", String.class, boolean.class,
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            if ("isThreeSplitTogether".equals(param.args[0])
                                    && Boolean.TRUE.equals(param.args[1])) {
                                param.setResult(param.thisObject);
                                PsCanvasLog.d("blocked Intent isThreeSplitTogether");
                            }
                        }
                    });
        } catch (Throwable t) {
            PsCanvasLog.e("Intent.putExtra hook failed:", t);
        }

        replaceMethod(lpparam, "com.oplus.pscanvas.canvasmode.canvas.r0", "O",
                new Class[]{boolean.class}, param -> {
                    param.args[0] = false;
                    return hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
                });

        hookAdapterLayoutMethods(lpparam);
    }

    /** u1.c is in primary dex — panorama layout remap only outside transition. */
    private static void hookAdapterLayoutMethods(PackageLoadContext lpparam) {
        replaceMethod(lpparam, ADAPTER, "n", new Class[0], param ->
                remapThreeSplitLayout(param.thisObject, (Integer) hookRuntime.invokeOriginalMethod(
                        param.method, param.thisObject, param.args)));
        replaceMethod(lpparam, ADAPTER, "t", new Class[0], param ->
                remapThreeSplitLayout(param.thisObject, (Integer) hookRuntime.invokeOriginalMethod(
                        param.method, param.thisObject, param.args)));
    }

    private static int remapThreeSplitLayout(Object adapter, int layout) {
        if (adapter == null || layout != 3) {
            return layout;
        }
        try {
            int count = (Integer) reflectionAccess.callMethod(adapter, "getCount");
            if (count == 3) {
                // Layout 3 = three side-by-side (700 three-split-together).
                // e3(i3=3) callback is blocked separately to prevent equal-column
                // setup; panorama mode (F0=true) provides wide canvas for peek.
                return 3;
            }
        } catch (Throwable ignored) {
        }
        return layout;
    }

    private static void hookTwoColumnPanoramaRestoreDeferred(PackageLoadContext lpparam) {
        Class<?> adapterClass = findClassFirst(lpparam.classLoader, ADAPTER, "u1.C0600c");
        if (adapterClass == null) {
            return;
        }

        replaceMethod(lpparam, ADAPTER, "A", new Class[0], param -> {
            int count = (Integer) reflectionAccess.callMethod(param.thisObject, "getCount");
            if (count == 3) {
                return false;
            }
            return hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
        });

        hookBeforeMethod(lpparam, ADAPTER, "M", new Class[]{Integer.TYPE}, param -> {
            int count = (Integer) reflectionAccess.callMethod(param.thisObject, "getCount");
            if (count == 3 && (Integer) param.args[0] == 3) {
                param.args[0] = 0;
                PsCanvasLog.d("M(3) -> M(0) for 3-app layout");
            }
        });

        hookBeforeMethod(lpparam, ADAPTER, "T",
                new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE}, param -> {
                    int count = (Integer) reflectionAccess.callMethod(param.thisObject, "getCount");
                    int layout = ObfFieldCompat.getInt(param.thisObject, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f");
                    if (count == 3 && layout == 3) {
                        ObfFieldCompat.setInt(param.thisObject, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f", 0);
                        PsCanvasLog.d("T() unblocked, layout 3 -> 0");
                    }
                });

        // P3: beforeHook on f() — null out f13801s (r0.b callback) BEFORE
        // layout calculation so onEnterThreeSplitTogether never fires.
        hookBeforeMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            try {
                Object callback = reflectionAccess.getObjectField(param.thisObject, "f13801s");
                if (callback != null) {
                    reflectionAccess.setObjectField(param.thisObject, "f13801s", null);
                    PsCanvasLog.d("f() beforeHook: nulled three-split callback f13801s");
                }
            } catch (Throwable ignored) {
            }
        });

        hookAfterMethod(lpparam, ADAPTER, "f", new Class[]{Boolean.TYPE}, param -> {
            ensureTwoColumnLayout(param.thisObject, "f() afterHook");
        });

        try {
            hookAfterMethod(lpparam, "B1.e", "c",
                    new Class[]{adapterClass, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, param -> {
                        Object adapter = param.args[0];
                        int count = (Integer) reflectionAccess.callMethod(adapter, "getCount");
                        int layout = (Integer) param.getResult();
                        if (count == 3 && layout == 3) {
                            // Keep layout 3 — panorama mode (F0=true) handles peek effect
                            // e3(i3=3) callback is blocked separately
                            PsCanvasLog.d("B1.e.c() layout 3 kept (e3 blocked)");
                        }
                    });
        } catch (Throwable throwable) {
            PsCanvasLog.e("B1.e.c hook failed:", throwable);
        }
    }

    private static void ensureTwoColumnLayout(Object adapter, String source) {
        int count = (Integer) reflectionAccess.callMethod(adapter, "getCount");
        if (count != 3) {
            return;
        }
        int layout = ObfFieldCompat.getInt(adapter, ObfFieldCompat.ADAPTER_LAYOUT, "f13788f");
        if (layout == 3) {
            // Keep layout 3 — e3 callback blocks equal-column setup,
            // panorama F0=true handles wide canvas for peek effect
            PsCanvasLog.d(source + " layout 3 kept (panorama peek)");
        }
        if (gestureManagerClass != null) {
            try {
                Object context = reflectionAccess.callMethod(adapter, "getContext");
                Object activity = reflectionAccess.callStaticMethod(
                        reflectionAccess.findClass(UTIL, adapter.getClass().getClassLoader()),
                        "O1", context);
                Object containerView = activity != null
                        ? reflectionAccess.callMethod(activity, "v0") : null;
                ThreeSplitTouch502Compat.syncGestureSplitFlagForThreeApp(
                        gestureManagerClass, containerView);
            } catch (Throwable ignored) {
            }
        }
    }

    private static void hookBeforeMethod(PackageLoadContext lpparam, String className,
                                         String methodName, Class<?>[] parameterTypes,
                                         HookBefore body) {
        hookBeforeMethod(lpparam, className, methodName, parameterTypes, body,
                null, null, null);
    }

    private static void hookBeforeMethod(PackageLoadContext lpparam, String className,
                                         String methodName, Class<?>[] parameterTypes,
                                         HookBefore body, HookRegistry hookRegistry,
                                         String hookId, String detail) {
        try {
            Object[] args = new Object[parameterTypes.length + 1];
            System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
            args[parameterTypes.length] = new HookCallback() {
                @Override
                protected void beforeHookedMethod(HookCall param) throws Throwable {
                    body.run(param);
                }
            };
            hookRuntime.findAndHookMethod(
                    hookId, className, lpparam.classLoader, methodName, args);
            if (hookRegistry != null) {
                markHookInstalled(hookRegistry, hookId, detail);
            }
        } catch (Throwable throwable) {
            if (hookRegistry != null) {
                markHookFailed(hookRegistry, hookId, detail, throwable);
            }
            PsCanvasLog.e("failed beforeHook " + className + "." + methodName + ":", throwable);
        }
    }

    private static void hookAfterMethod(PackageLoadContext lpparam, String className,
                                        String methodName, Class<?>[] parameterTypes,
                                        HookAfter body) {
        try {
            Object[] args = new Object[parameterTypes.length + 1];
            System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
            args[parameterTypes.length] = new HookCallback() {
                @Override
                protected void afterHookedMethod(HookCall param) throws Throwable {
                    body.run(param);
                }
            };
            hookRuntime.findAndHookMethod(className, lpparam.classLoader, methodName, args);
        } catch (Throwable throwable) {
            PsCanvasLog.e("failed afterHook " + className + "." + methodName + ":", throwable);
        }
    }

    private static void hookScaleListener502(PackageLoadContext lpparam, Class<?> gestureClass) {
        HookCallback touchPrepHook = new HookCallback() {
            @Override
            protected void beforeHookedMethod(HookCall param) {
                MotionEvent event = (MotionEvent) param.args[0];
                lastGestureTouchAction.set(event.getActionMasked());
                if (event.getPointerCount() > 3) {
                    ThreeSplitTouch502Compat.forceCanvasSyncPinch(
                            param.thisObject, gestureClass, event.getPointerCount());
                }
            }
        };
        try {
            hookRuntime.findAndHookMethod(gestureClass, "T", MotionEvent.class, touchPrepHook);
            PsCanvasLog.i("hookScaleListener502 T prep installed on " + gestureClass.getName());
        } catch (Throwable throwable) {
            PsCanvasLog.e("hookScaleListener502 T failed", throwable);
        }

        HookCallback scaleBeginHook = new HookCallback() {
            @Override
            protected void beforeHookedMethod(HookCall param) {
                Object outer = reflectionAccess.getObjectField(param.thisObject, "this$0");
                if (outer == null) {
                    return;
                }
                int pointers = ObfFieldCompat.getInt(outer,
                        ObfFieldCompat.GESTURE_POINTER_COUNT, "f10935A");
                ThreeSplitTouch502Compat.forceCanvasSyncPinch(outer, gestureClass, pointers);
                ThreeSplitTouch502Compat.prepareThreeAppCanvasPinch(outer, gestureClass);
            }

            @Override
            protected void afterHookedMethod(HookCall param) {
                Object outer = reflectionAccess.getObjectField(param.thisObject, "this$0");
                if (outer == null) {
                    return;
                }
                Object containerView = ThreeSplitTouch502Compat.getGestureContainerView(outer);
                if (!ThreeSplitTouch502Compat.isThreeAppCanvas(containerView)) {
                    return;
                }
                // When canvas sync pinch is disabled, let x1.r path handle the scale normally
                if (!ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(containerView)) {
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

        HookCallback scaleHook = new HookCallback() {
            @Override
            protected void beforeHookedMethod(HookCall param) {
                Object outer = reflectionAccess.getObjectField(param.thisObject, "this$0");
                if (outer == null) {
                    return;
                }
                Object containerView = ThreeSplitTouch502Compat.getGestureContainerView(outer);
                // Only interfere when canvas sync pinch is enabled
                if (!ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(containerView)) {
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

        HookCallback scaleEndHook = new HookCallback() {
            @Override
            protected void afterHookedMethod(HookCall param) {
                Object outer = reflectionAccess.getObjectField(param.thisObject, "this$0");
                if (outer != null) {
                    Object containerView = ThreeSplitTouch502Compat.getGestureContainerView(outer);
                    if (!ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(containerView)) {
                        return;
                    }
                    ThreeSplitTouch502Compat.resetThreeAppPinchState(outer, gestureClass);
                }
            }
        };

        int hooked = 0;
        for (Class<?> inner : gestureClass.getDeclaredClasses()) {
            try {
                hookRuntime.findAndHookMethod(inner, "onScaleBegin",
                        ScaleGestureDetector.class, scaleBeginHook);
                hookRuntime.findAndHookMethod(inner, "onScale",
                        ScaleGestureDetector.class, scaleHook);
                hookRuntime.findAndHookMethod(inner, "onScaleEnd",
                        ScaleGestureDetector.class, scaleEndHook);
                hooked++;
                PsCanvasLog.i("hookScaleListener502 scale hooks on " + inner.getName());
            } catch (Throwable ignored) {
            }
        }
        if (hooked == 0) {
            for (String suffix : new String[]{"$c", "$C", "$b"}) {
                try {
                    Class<?> listenerClass = reflectionAccess.findClass(
                            gestureClass.getName() + suffix, lpparam.classLoader);
                    hookRuntime.findAndHookMethod(listenerClass, "onScaleBegin",
                            ScaleGestureDetector.class, scaleBeginHook);
                    hookRuntime.findAndHookMethod(listenerClass, "onScale",
                            ScaleGestureDetector.class, scaleHook);
                    hookRuntime.findAndHookMethod(listenerClass, "onScaleEnd",
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

    private static void hookWindowConfigUtils(PackageLoadContext lpparam) {
        replaceMethod(lpparam, CONFIG, "h", new Class[]{Context.class},
                param -> ConfigCompat.getMaxHeight((Context) param.args[0]));
        replaceMethod(lpparam, CONFIG, "j", new Class[]{Context.class},
                param -> ConfigCompat.getMaxWidth((Context) param.args[0]));
    }

    private static void hookActivityTaskManagerCallers(PackageLoadContext lpparam) {
        replaceMethod(lpparam, UTIL, "E", new Class[]{Integer.TYPE}, param -> {
            int taskId = (Integer) param.args[0];
            for (Object task : AtmCompat.getTasks(lpparam.classLoader, 5, true)) {
                if (reflectionAccess.getIntField(task, "taskId") == taskId) {
                    return task;
                }
            }
            return null;
        });
        hookWithAtmFallback(lpparam, "r1.f", "p");
        hookWithAtmFallback(lpparam, UTIL, "i", List.class);
    }

    private static void hookWithAtmFallback(PackageLoadContext lpparam,
                                            String className, String methodName, Class<?>... parameterTypes) {
        replaceMethod(lpparam, className, methodName, parameterTypes, param -> {
            try {
                return hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
            } catch (Throwable throwable) {
                if (!isAtmCompatError(throwable)) {
                    throw throwable;
                }
                PsCanvasLog.d("ATM compat fallback for " + className + "." + methodName);
                if ("r1.f".equals(className) && "p".equals(methodName)) {
                    reflectionAccess.setBooleanField(param.thisObject, "c", false);
                }
                return defaultValue(asMethod(param.method));
            }
        });
    }

    private static void hookSplitToFlexibleTransition(PackageLoadContext lpparam) {
        replaceMethod(lpparam, UTIL, "n", new Class[]{List.class, Integer.TYPE, Bundle.class}, param -> {
            List<?> intents = (List<?>) param.args[0];
            Bundle bundle = (Bundle) param.args[2];
            if (bundle != null && bundle.getBoolean("isThreeSplitTogether", false)) {
                PsCanvasLog.d("blocked isThreeSplitTogether in calculateFlexibleWindowBounds");
                param.args[2] = null;
            }
            Context context = extractContext(param.thisObject, param.args);
            FlexibleTransitionCompat.injectDisplayBoundsIntoIntents(intents, context);
            Object result = hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
            if (result instanceof Bundle) {
                return FlexibleTransitionCompat.fixLaunchBoundsBundle((Bundle) result, context);
            }
            return result;
        });

        replaceMethod(lpparam, SSTO_FLEX, "J", new Class[0], param -> {
            FlexibleTransitionCompat.resetEarlySplitZoom();
            Object result = hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
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
                boolean toggleReturned = (Boolean) hookRuntime.invokeOriginalMethod(
                        param.method, param.thisObject, param.args);
                return FlexibleTransitionCompat.evaluateTransitionResult(
                        param.thisObject, toggleReturned, lpparam.classLoader);
            } catch (Throwable throwable) {
                PsCanvasLog.e("x1.r.s0 original failed:", throwable);
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
                        Object result = hookRuntime.invokeOriginalMethod(
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
    private static void hookCanvasTaskRemoval(PackageLoadContext lpparam, String methodName) {
        replaceMethod(lpparam, CONTAINER_ACTIVITY, methodName, new Class[0], param -> {
            if (!FlexibleTransitionCompat.wasLastTransitionSucceeded()) {
                PsCanvasLog.w(methodName + " removeTask skipped, transition not verified");
                return null;
            }
            if (FlexibleTransitionCompat.wasZoomFallbackUsed()) {
                PsCanvasLog.d(methodName + " removeTask skipped, zoom settle handles it");
                return null;
            }
            final int taskId = (Integer) reflectionAccess.callMethod(param.thisObject, "u0");
            final ClassLoader classLoader = lpparam.classLoader;
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                if (!AtmCompat.removeTask(classLoader, taskId)) {
                    PsCanvasLog.w(methodName + " removeTask skipped, ATM unavailable");
                }
            }, 600L);
            return null;
        });
    }

    private static void hookDirectWindowConfigurationAccess(PackageLoadContext lpparam) {
        replaceMethod(lpparam, UTIL, "o0",
                new Class[]{Context.class, List.class, Integer.TYPE},
                param -> {
                    try {
                        return hookRuntime.invokeOriginalMethod(
                                param.method, param.thisObject, param.args);
                    } catch (Throwable throwable) {
                        if (!isWindowConfigError(throwable)) {
                            throw throwable;
                        }
                        Context context = (Context) param.args[0];
                        PsCanvasLog.d("o0 windowConfiguration compat fallback");
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

    private static void hookWithConfigFallback(PackageLoadContext lpparam,
                                               String className, String methodName, Object... parameterTypes) {
        Class<?>[] paramTypes = new Class[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            Object type = parameterTypes[i];
            if (type instanceof Class) {
                paramTypes[i] = (Class<?>) type;
            } else {
                paramTypes[i] = reflectionAccess.findClass((String) type, lpparam.classLoader);
            }
        }
        replaceMethod(lpparam, className, methodName, paramTypes, param -> {
            try {
                return hookRuntime.invokeOriginalMethod(param.method, param.thisObject, param.args);
            } catch (Throwable throwable) {
                if (!isWindowConfigError(throwable)) {
                    throw throwable;
                }
                PsCanvasLog.d("windowConfiguration compat for " + className + "." + methodName);
                return handleConfigFallback(className, methodName, param, lpparam.classLoader);
            }
        });
    }

    private static Object handleConfigFallback(String className, String methodName,
                                               HookCall param, ClassLoader classLoader) {
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
        reflectionAccess.setIntField(activity, "f10231M", configuration.densityDpi);
        ClassLoader classLoader = context.getClassLoader();
        try {
            reflectionAccess.setObjectField(activity, "f10267n",
                    reflectionAccess.callStaticMethod(
                            reflectionAccess.findClass(
                                    "com.oplus.flexiblewindow.FlexibleWindowManager", classLoader),
                            "getInstance"));
            Class<?> callbackClass = reflectionAccess.findClass(
                    CONTAINER_ACTIVITY + "$EmbeddedWindowCallback", classLoader);
            reflectionAccess.setObjectField(activity, "f10269o",
                    reflectionAccess.newInstance(callbackClass, activity));
        } catch (Throwable throwable) {
            PsCanvasLog.e("onCreate tail init failed:", throwable);
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
        reflectionAccess.setIntField(activity, "f10231M", configuration.densityDpi);
        reflectionAccess.setBooleanField(activity, "f10245a0", false);
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
        reflectionAccess.setIntField(controller, "f10629G", width);
        reflectionAccess.setIntField(controller, "f10630H", height);
    }

    private static void replaceMethod(PackageLoadContext lpparam, String className,
                                      String methodName, Class<?>[] parameterTypes, HookBody body) {
        replaceMethodCore(lpparam, className, methodName, parameterTypes, body,
                null, null, null);
    }

    private static void replaceMethod(PackageLoadContext lpparam, String className,
                                      String methodName, Class<?>[] parameterTypes, HookBody body,
                                      HookRegistry hookRegistry, String hookId, String detail) {
        replaceMethodCore(lpparam, className, methodName, parameterTypes, body,
                hookRegistry, hookId, detail);
    }

    private static void replaceMethodCore(PackageLoadContext lpparam,
                                          String className, String methodName,
                                          Class<?>[] parameterTypes, HookBody body,
                                          HookRegistry hookRegistry, String hookId,
                                          String detail) {
        try {
            Object[] hookArgs = buildHookArgs(parameterTypes, body);
            hookRuntime.findAndHookMethod(
                    hookId, className, lpparam.classLoader, methodName, hookArgs);
            if (hookRegistry != null) {
                markHookInstalled(hookRegistry, hookId, detail);
            }
        } catch (Throwable throwable) {
            if (hookRegistry != null) {
                markHookFailed(hookRegistry, hookId, detail, throwable);
            }
            PsCanvasLog.e("failed to hook " + className + "." + methodName + ":", throwable);
        }
    }

    private static Object[] buildHookArgs(Class<?>[] parameterTypes, HookBody body) {
        Object[] args = new Object[parameterTypes.length + 1];
        System.arraycopy(parameterTypes, 0, args, 0, parameterTypes.length);
        args[parameterTypes.length] = new HookReplacement() {
            @Override
            protected Object replaceHookedMethod(HookCall param) throws Throwable {
                return body.run(param);
            }
        };
        return args;
    }

    private static void safeCall(Object target, String methodName, Object... args) {
        try {
            reflectionAccess.callMethod(target, methodName, args);
        } catch (Throwable throwable) {
            PsCanvasLog.e(methodName + "() failed:", throwable);
        }
    }

    private static void setRectField(Object target, String fieldName, Rect bounds) {
        Object rectField = reflectionAccess.getObjectField(target, fieldName);
        if (rectField instanceof Rect) {
            ((Rect) rectField).set(bounds);
        } else {
            reflectionAccess.setObjectField(target, fieldName, new Rect(bounds));
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

    // ============================================================
    // P0: Block 700 three-split-together callback chain
    // ============================================================

    /**
     * P0 — Keep only the useful part of the 700 three-split callback chain.
     *
     * ContainerView.e3(..., 3) must run when a newly-created two-split becomes
     * a three-split. It synchronously replaces all three TaskData bounds using
     * the B1.l.n result normalized by hook260608ThreeSplitBoundsRequest().
     * Blocking e3 leaves the original two-split width in every task and causes
     * aspect-fit letterboxing. The later 700-only layout/drag paths remain
     * blocked so they cannot override the 502 panorama behavior.
     */
    // ============================================================
    // P1: Block 700 SplitBar three-split drag
    // ============================================================

    /**
     * P1 — Block 700 SplitBar three-split drag handlers.
     * 502 uses direction-switch methods (C/D/E/F/G in C0328z)
     * which were replaced by unified spring drag (E.u0) in 700.
     * Block both u0() and its spring init R().
     */
    // ============================================================
    // P2: Z-Order + getLaunchRect panorama fix
    // ============================================================

    /**
     * P2 — Block three-split-together z-order branch.
     * Hook B1.s.z(int, View) to always return false so
     * ContainerView.setLayerOrder() takes the simple (502-compatible)
     * branch instead of the 700 three-split-together sub-surface path.
     *
     * The live dex may use different parameter types than the decompiled
     * APK — try multiple signatures to find the right one.
     */
    private static void hookBlockThreeSplitZOrder(PackageLoadContext lpparam) {
        boolean hooked = false;
        // Try exact signature from decompiled APK: z(int, View)
        try {
            hookRuntime.findAndHookMethod(CONFIG, lpparam.classLoader, "z",
                    Integer.TYPE, android.view.View.class,
                    new HookReplacement() {
                        @Override
                        protected Object replaceHookedMethod(HookCall param) {
                            return false;
                        }
                    });
            hooked = true;
            PsCanvasLog.i("P2: hookBlockThreeSplitZOrder installed via z(int, View)");
        } catch (Throwable t) {
            PsCanvasLog.d("P2: B1.s.z(int, View) not found, trying alternatives");
        }

        // Try: z(int, Object) — live dex may erase generics
        if (!hooked) {
            try {
                hookRuntime.findAndHookMethod(CONFIG, lpparam.classLoader, "z",
                        Integer.TYPE, Object.class,
                        new HookReplacement() {
                            @Override
                            protected Object replaceHookedMethod(HookCall param) {
                                return false;
                            }
                        });
                hooked = true;
                PsCanvasLog.i("P2: hookBlockThreeSplitZOrder installed via z(int, Object)");
            } catch (Throwable t) {
                PsCanvasLog.d("P2: B1.s.z(int, Object) not found either");
            }
        }

        if (!hooked) {
            PsCanvasLog.w("P2: hookBlockThreeSplitZOrder — B1.s.z not found on this device, skipping");
        }
    }

    /**
     * P2 — Fix panorama getLaunchRect() override in EmbeddedViewDecor.
     * 700 adds: if (B1.s.H() && item.B()) return item.i() (match-parent rect).
     * 502 never does this — always return normal rect item.n() in panorama.
     */
    private static void hookFixPanoramaLaunchRect(PackageLoadContext lpparam) {
        try {
            String EMBEDDED_DECOR =
                    "com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor";
            hookRuntime.findAndHookMethod(EMBEDDED_DECOR, lpparam.classLoader,
                    "getLaunchRect",
                    new HookCallback() {
                        @Override
                        protected void beforeHookedMethod(HookCall param) {
                            SplitBar502Compat.blockPanoramaLaunchRectOverride(param);
                        }
                    });
            PsCanvasLog.i("P2: hookFixPanoramaLaunchRect installed on EmbeddedViewDecor.getLaunchRect");
        } catch (Throwable t) {
            PsCanvasLog.e("P2: hookFixPanoramaLaunchRect failed", t);
        }
    }
}
