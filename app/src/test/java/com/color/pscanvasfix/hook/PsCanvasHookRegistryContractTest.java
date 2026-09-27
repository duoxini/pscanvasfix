package com.color.pscanvasfix.hook;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Source contract for the behavior-neutral Feature extraction and HookRegistry sidecar. */
public final class PsCanvasHookRegistryContractTest {
    private static final String[] STABLE_IDS = {
            "pinch.lifecycle.init.trace",
            "pinch.lifecycle.scale_end.trace",
            "pinch.lifecycle.animation_start.trace",
            "panorama.launch_while_active.block",
            "pinch.scale.panorama_dispatch",
            "transition.intent_list.patch_ids",
            "transition.launch_bounds.fix_bundle",
            "transition.mask_rect.fix",
            "touch_anim.reset_all.block",
            "touch_anim.scale_down_start.block",
            "touch_anim.need_anim_check.block",
            "touch_anim.control_bar_long_press.block",
            "touch_anim.initial_drag.guard",
            "touch_drag.pointer_down.block",
            "touch_drag.pointer_move.block",
            "touch_drag.pointer_up.block",
            "touch_drag.initialize.block",
            "controller.disable_three_together_flag",
            "panorama.exit.direction_guard",
            "bounds.single.restore_502",
            "bounds.multi.restore_502",
            "layout.three.equal_width_canvas",
            "entry.direct_three.on_create",
            "entry.two_to_three.anchor_mark",
            "entry.two_to_three.anchor_redirect",
            "splitbar.resizable_rect_update.block",
            "splitbar.three_split_scroll_start.block",
            "splitbar.three_split_enlarge.block",
            "splitbar.spring_drag_handler.block",
            "splitbar.spring_animation_init.block"
    };

    @Test
    public void declaresThirtyUniqueStableIdsInExactGlobalFacadeOrder() throws IOException {
        String facade = facade();
        String features = featureSources();
        String aggregate = facade + features;

        assertEquals(30, STABLE_IDS.length);
        for (String stableId : STABLE_IDS) {
            assertEquals("Stable ID must have one production owner: " + stableId,
                    1, occurrences(aggregate, "\"" + stableId + "\""));
        }
        assertEquals(30, occurrences(features, "hookRegistry.declare("));

        String install = installMethod(facade);
        assertInOrder(install,
                "HookRegistry hookRegistry = new HookRegistry();",
                "PinchGestureFeature.declareLifecycleHooks(hookRegistry);",
                "PanoramaFeature.declareLaunchGuard(hookRegistry);",
                "PinchGestureFeature.declareScaleHook(hookRegistry);",
                "ClassicCanvasController.declareTransitionHook(hookRegistry);",
                "ClassicLayoutFeature.declareLaunchHook(hookRegistry);",
                "PanoramaFeature.declareMaskFix(hookRegistry);",
                "PinchGestureFeature.declareTouchHooks(hookRegistry);",
                "ClassicCanvasController.declareControllerHook(hookRegistry, \"O\");",
                "PanoramaFeature.declareExitGuard(hookRegistry);",
                "ClassicLayoutFeature.declareBoundsAndLayoutHooks(hookRegistry);",
                "ClassicCanvasController.declareEntryHooks(hookRegistry,",
                "SplitBarFeature.declareHooks(hookRegistry);",
                "activeHookRegistry = hookRegistry;");

        assertInOrder(pinch(),
                "hookRegistry.declare(HOOK_LIFECYCLE_INIT_TRACE,",
                "hookRegistry.declare(HOOK_LIFECYCLE_SCALE_END_TRACE,",
                "hookRegistry.declare(HOOK_LIFECYCLE_ANIMATION_START_TRACE,",
                "hookRegistry.declare(HOOK_SCALE_PANORAMA_DISPATCH,",
                "hookRegistry.declare(HOOK_ANIM_RESET_ALL_BLOCK,",
                "hookRegistry.declare(HOOK_ANIM_SCALE_DOWN_START_BLOCK,",
                "hookRegistry.declare(HOOK_ANIM_NEED_ANIM_CHECK_BLOCK,",
                "hookRegistry.declare(HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK,",
                "hookRegistry.declare(HOOK_ANIM_INITIAL_DRAG_GUARD,",
                "hookRegistry.declare(HOOK_DRAG_POINTER_DOWN_BLOCK,",
                "hookRegistry.declare(HOOK_DRAG_POINTER_MOVE_BLOCK,",
                "hookRegistry.declare(HOOK_DRAG_POINTER_UP_BLOCK,",
                "hookRegistry.declare(HOOK_DRAG_INITIALIZE_BLOCK,");
        assertInOrder(panorama(),
                "hookRegistry.declare(HOOK_LAUNCH_WHILE_ACTIVE_BLOCK,",
                "hookRegistry.declare(HOOK_TRANSITION_MASK_RECT_FIX,",
                "hookRegistry.declare(HOOK_EXIT_DIRECTION_GUARD,");
        assertInOrder(controller(),
                "hookRegistry.declare(HOOK_TRANSITION_INTENT_LIST_PATCH_IDS,",
                "hookRegistry.declare(HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,",
                "hookRegistry.declare(HOOK_ENTRY_DIRECT_THREE_ON_CREATE,",
                "hookRegistry.declare(HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,",
                "hookRegistry.declare(HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,");
        assertInOrder(layout(),
                "hookRegistry.declare(HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,",
                "hookRegistry.declare(HOOK_BOUNDS_SINGLE_RESTORE_502,",
                "hookRegistry.declare(HOOK_BOUNDS_MULTI_RESTORE_502,",
                "hookRegistry.declare(HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,");
        assertInOrder(splitBar(),
                "hookRegistry.declare(HOOK_RESIZABLE_RECT_UPDATE_BLOCK,",
                "hookRegistry.declare(HOOK_THREE_SPLIT_SCROLL_START_BLOCK,",
                "hookRegistry.declare(HOOK_THREE_SPLIT_ENLARGE_BLOCK,",
                "hookRegistry.declare(HOOK_SPRING_DRAG_HANDLER_BLOCK,",
                "hookRegistry.declare(HOOK_SPRING_ANIMATION_INIT_BLOCK,");

        assertTrue(facade.contains("private static volatile HookRegistry activeHookRegistry = "
                + "new HookRegistry();"));
        assertTrue(facade.contains("return activeHookRegistry.snapshot();"));
    }

    @Test
    public void sstoCapabilityOwnsEightHooksAndUnavailablePathSkipsAllEight()
            throws IOException {
        String install = installMethod(facade());
        String ssto = section(install,
                "if (symbols.role(PsCanvasSymbols.Role.SSTO_FLEXIBLE).available())",
                "boolean anim = symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_ANIM).available();");

        assertInOrder(ssto,
                "PinchGestureFeature.installLifecycleHooks(",
                "PanoramaFeature.installLaunchGuard(",
                "PinchGestureFeature.installScaleHook(",
                "ClassicCanvasController.installTransitionIntentPatch(",
                "ClassicLayoutFeature.installLaunchBoundsHook(",
                "PanoramaFeature.installMaskFix(",
                "} else {",
                "PinchGestureFeature.markLifecycleAndScaleUnavailable(hookRegistry, unavailable);",
                "PanoramaFeature.HOOK_LAUNCH_WHILE_ACTIVE_BLOCK",
                "ClassicCanvasController.markTransitionUnavailable(hookRegistry, unavailable);",
                "ClassicLayoutFeature.HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE",
                "PanoramaFeature.HOOK_TRANSITION_MASK_RECT_FIX",
                "PsCanvasLog.w(\"install: sstoFlexible SKIPPED");

        String unavailable = section(pinch(),
                "public static void markLifecycleAndScaleUnavailable(",
                "public static void markTouchUnavailable(");
        assertInOrder(unavailable,
                "markHookSkipped(hookRegistry, HOOK_LIFECYCLE_INIT_TRACE, detail);",
                "markHookSkipped(hookRegistry, HOOK_LIFECYCLE_SCALE_END_TRACE, detail);",
                "markHookSkipped(hookRegistry, HOOK_LIFECYCLE_ANIMATION_START_TRACE, detail);",
                "markHookSkipped(hookRegistry, HOOK_SCALE_PANORAMA_DISPATCH, detail);");
        assertEquals(4, occurrences(unavailable, "markHookSkipped("));
        assertEquals(8,
                occurrences(unavailable, "markHookSkipped(")
                        + occurrences(ssto, "markHookSkipped(hookRegistry,")
                        + occurrences(ssto,
                        "ClassicCanvasController.markTransitionUnavailable("));
    }

    @Test
    public void touchCompositeRemainsAtomicAndKeepsNineHookOrder() throws IOException {
        String install = installMethod(facade());
        String composite = section(install,
                "boolean anim = symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_ANIM).available();",
                "if (symbols.role(PsCanvasSymbols.Role.CANVAS_CONTROLLER).available())");
        assertInOrder(composite,
                "boolean drag = symbols.role(PsCanvasSymbols.Role.THREE_SPLIT_DRAG).available();",
                "if (anim && drag)",
                "HookRuntime.Group touchGroup = hookRuntime.beginGroup(\"three_split_touch_composite\");",
                "PinchGestureFeature.installTouchHooks(",
                "if (PinchGestureFeature.allTouchHooksInstalled(hookRegistry))",
                "committed = hookRuntime.commitGroup(touchGroup);",
                "} finally {",
                "if (!touchGroup.isClosed())",
                "hookRuntime.rollbackGroup(touchGroup);",
                "if (!committed)",
                "PinchGestureFeature.markTouchRolledBack(hookRegistry);",
                "} else {",
                "PinchGestureFeature.markTouchUnavailable(hookRegistry, compositeUnavailable);");

        String pinch = pinch();
        String touchIds = section(pinch,
                "private static String[] touchHookIds()",
                "private static void markHookInstalled(");
        assertInOrder(touchIds,
                "HOOK_ANIM_RESET_ALL_BLOCK,",
                "HOOK_ANIM_SCALE_DOWN_START_BLOCK,",
                "HOOK_ANIM_NEED_ANIM_CHECK_BLOCK,",
                "HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK,",
                "HOOK_ANIM_INITIAL_DRAG_GUARD,",
                "HOOK_DRAG_POINTER_DOWN_BLOCK,",
                "HOOK_DRAG_POINTER_MOVE_BLOCK,",
                "HOOK_DRAG_POINTER_UP_BLOCK,",
                "HOOK_DRAG_INITIALIZE_BLOCK");
        assertEquals(9, occurrences(touchIds, "HOOK_"));

        String installer = section(pinch,
                "public static void installTouchHooks(",
                "public static void markLifecycleAndScaleUnavailable(");
        assertInOrder(installer,
                "installVoidGuard(hookRuntime, hookRegistry, animationManager,",
                "resetAllMethod,",
                "HOOK_ANIM_RESET_ALL_BLOCK",
                "installVoidGuard(hookRuntime, hookRegistry, animationManager,",
                "scaleDownStartMethod,",
                "HOOK_ANIM_SCALE_DOWN_START_BLOCK",
                "installVoidGuard(hookRuntime, hookRegistry, animationManager,",
                "needAnimationCheckMethod,",
                "HOOK_ANIM_NEED_ANIM_CHECK_BLOCK",
                "installVoidGuard(hookRuntime, hookRegistry, animationManager,",
                "controlBarLongPressMethod,",
                "HOOK_ANIM_CONTROL_BAR_LONG_PRESS_BLOCK",
                "installInitialDragGuard(hookRuntime, hookRegistry, animationManager,",
                "initialDragMethod,",
                "installVoidGuard(hookRuntime, hookRegistry, dragManager, pointerDownMethod,",
                "HOOK_DRAG_POINTER_DOWN_BLOCK",
                "installVoidGuard(hookRuntime, hookRegistry, dragManager, pointerMoveMethod,",
                "HOOK_DRAG_POINTER_MOVE_BLOCK",
                "installVoidGuard(hookRuntime, hookRegistry, dragManager, pointerUpMethod,",
                "HOOK_DRAG_POINTER_UP_BLOCK",
                "installVoidGuard(hookRuntime, hookRegistry, dragManager, dragInitializeMethod,",
                "HOOK_DRAG_INITIALIZE_BLOCK");
        assertTrue(installer.contains("THREE_SPLIT_ANIM runtime class missing"));
        assertTrue(installer.contains("THREE_SPLIT_DRAG runtime class missing"));
        assertTrue(installer.contains("THREE_SPLIT_DRAG state class missing"));
        assertTrue(installer.contains("EmbeddedViewDecor class missing"));

        String replacement = section(pinch,
                "private static void installInitialDragGuard(",
                "private static Class<?> findClassSafe(");
        assertTrue(replacement.contains("new HookReplacement()"));
        assertTrue(replacement.contains("return false;"));
        assertEquals(1, occurrences(replacement, "hookRuntime.invokeOriginalMethod("));
        assertOutcome(replacement, "HOOK_ANIM_INITIAL_DRAG_GUARD");
    }

    @Test
    public void panoramaFeatureOwnsCallbacksAndAllOutcomeBoundaries() throws IOException {
        String source = panorama();
        String launch = section(source,
                "public static void installLaunchGuard(",
                "public static void installMaskFix(");
        assertInOrder(launch,
                "hookRuntime.findAndHookMethod(HOOK_LAUNCH_WHILE_ACTIVE_BLOCK,",
                "protected void beforeHookedMethod(HookCall param)",
                "param.setResult(false);",
                "markHookInstalled(hookRegistry, HOOK_LAUNCH_WHILE_ACTIVE_BLOCK, detail);",
                "markHookFailed(hookRegistry, HOOK_LAUNCH_WHILE_ACTIVE_BLOCK, detail, throwable);");

        String mask = section(source,
                "public static void installMaskFix(",
                "public static void installExitGuard(");
        assertInOrder(mask,
                "hookRuntime.findAndHookMethod(HOOK_TRANSITION_MASK_RECT_FIX,",
                "protected void afterHookedMethod(HookCall param)",
                "PinchTransition502Compat.fixPanoramaMaskAnimRect(",
                "markHookInstalled(hookRegistry, HOOK_TRANSITION_MASK_RECT_FIX, detail);",
                "markHookFailed(hookRegistry, HOOK_TRANSITION_MASK_RECT_FIX, detail, throwable);");

        String exit = section(source,
                "public static void installExitGuard(",
                "public static boolean handleDirectionalScale(");
        assertInOrder(exit,
                "if (managerClass == null)",
                "markHookSkipped(hookRegistry, HOOK_EXIT_DIRECTION_GUARD,",
                "return;",
                "hookRuntime.findAndHookMethod(HOOK_EXIT_DIRECTION_GUARD,",
                "protected void beforeHookedMethod(HookCall param)",
                "DIRECTIONAL_EXIT_ALLOWED.get()",
                "param.setResult(null);",
                "markHookInstalled(hookRegistry, HOOK_EXIT_DIRECTION_GUARD,",
                "markHookFailed(hookRegistry, HOOK_EXIT_DIRECTION_GUARD,");

        String directional = section(source,
                "public static boolean handleDirectionalScale(",
                "private static boolean isActive(");
        assertInOrder(directional,
                "if (pointerCount < 4",
                "if (scaleFactor < 1.0f)",
                "reflectionAccess.callMethod(manager, enterMethod, true);",
                "else if (scaleFactor > 1.0f && active)",
                "DIRECTIONAL_EXIT_ALLOWED.set(Boolean.TRUE);",
                "reflectionAccess.callMethod(manager, exitMethod, true);",
                "DIRECTIONAL_EXIT_ALLOWED.remove();");
    }

    @Test
    public void layoutFeatureOwnsLaunchBoundsAndClassicLayoutOutcomes() throws IOException {
        String source = layout();
        String launch = section(source,
                "public static void installLaunchBoundsHook(",
                "public static void install(");
        assertInOrder(launch,
                "hookRuntime.findAndHookMethod(HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,",
                "protected void afterHookedMethod(HookCall param)",
                "FlexibleTransitionCompat.fixLaunchBoundsBundle(",
                "markHookInstalled(hookRegistry, HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,",
                "markHookFailed(hookRegistry, HOOK_TRANSITION_LAUNCH_BOUNDS_FIX_BUNDLE,");

        String bounds = section(source,
                "private static void installBoundsHooks(",
                "private static Bundle normalizeThreeTaskBounds(");
        assertEquals(2, occurrences(bounds, "protected void beforeHookedMethod"));
        assertEquals(2, occurrences(bounds, "protected void afterHookedMethod"));
        assertInOrder(bounds,
                "hookRuntime.findAndHookMethod(HOOK_BOUNDS_SINGLE_RESTORE_502,",
                "pscanvasfix_502_single_bounds",
                "markHookInstalled(hookRegistry, HOOK_BOUNDS_SINGLE_RESTORE_502,",
                "markHookFailed(hookRegistry, HOOK_BOUNDS_SINGLE_RESTORE_502,",
                "hookRuntime.findAndHookMethod(HOOK_BOUNDS_MULTI_RESTORE_502,",
                "param.args[2] = restored502Request;",
                "pscanvasfix_502_multi_bounds",
                "markHookInstalled(hookRegistry, HOOK_BOUNDS_MULTI_RESTORE_502,",
                "markHookFailed(hookRegistry, HOOK_BOUNDS_MULTI_RESTORE_502,");

        String canvas = section(source,
                "private static void installLayoutHook(",
                "private static void markHookInstalled(");
        assertEquals(0, occurrences(canvas, "protected void beforeHookedMethod"));
        assertEquals(1, occurrences(canvas, "protected void afterHookedMethod"));
        assertInOrder(canvas,
                "hookRuntime.findAndHookMethod(HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,",
                "param.setResult(restored);",
                "markHookInstalled(hookRegistry, HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,",
                "markHookFailed(hookRegistry, HOOK_LAYOUT_THREE_EQUAL_WIDTH_CANVAS,");
    }

    @Test
    public void controllerAndEntryFeatureOwnCallbacksAndOutcomeBoundaries()
            throws IOException {
        String source = controller();
        String transition = section(source,
                "public static void installTransitionIntentPatch(",
                "public static void markTransitionUnavailable(");
        assertInOrder(transition,
                "FeatureHookInstaller.register(hookRuntime, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS,",
                "protected void afterHookedMethod(HookCall param)",
                "SplitPolicyCompat.patchIntentListTaskIds(",
                "markHookInstalled(hookRegistry, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS, detail);",
                "markHookFailed(hookRegistry, HOOK_TRANSITION_INTENT_LIST_PATCH_IDS,");
        assertTrue(source.contains("markHookSkipped(hookRegistry, "
                + "HOOK_TRANSITION_INTENT_LIST_PATCH_IDS, detail);"));

        String controller = section(source,
                "public static void installControllerFlagOverride(",
                "public static void markControllerUnavailable(");
        assertInOrder(controller,
                "HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,",
                "protected void beforeHookedMethod(HookCall param)",
                "param.args[0] = false;",
                "markHookInstalled(hookRegistry, HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,",
                "markHookFailed(hookRegistry, HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG,");
        assertTrue(source.contains("markHookSkipped(hookRegistry, "
                + "HOOK_CONTROLLER_DISABLE_THREE_TOGETHER_FLAG, detail);"));

        String direct = section(source,
                "public static void installDirectEntryHook(",
                "public static void installConversionAnchorHooks(");
        assertEquals(1, occurrences(direct, "protected void beforeHookedMethod"));
        assertEquals(1, occurrences(direct, "protected void afterHookedMethod"));
        assertInOrder(direct,
                "if (!isDirectNewThreeSplit(extras))",
                "intent.replaceExtras(normalized);",
                "instanceStateStore.put(param.thisObject,",
                "protected void afterHookedMethod",
                "instanceStateStore.get(param.thisObject,",
                "instanceStateStore.remove(param.thisObject,",
                "overridePendingTransition(0, 0);",
                "markHookInstalled(hookRegistry, HOOK_ENTRY_DIRECT_THREE_ON_CREATE, detail);",
                "markHookFailed(hookRegistry, HOOK_ENTRY_DIRECT_THREE_ON_CREATE, detail, throwable);");

        String anchors = section(source,
                "public static void installConversionAnchorHooks(",
                "private static boolean isDirectNewThreeSplit(");
        assertInOrder(anchors,
                "HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,",
                "protected void afterHookedMethod(HookCall param)",
                "InstanceStateKeys.NEW_THREE_SPLIT_LEFT_ANCHOR",
                "markHookInstalled(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,",
                "markHookFailed(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_MARK,",
                "HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,",
                "protected void beforeHookedMethod(HookCall param)",
                "param.args[0] = 0;",
                "instanceStateStore.remove(param.thisObject,",
                "markHookInstalled(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,",
                "markHookFailed(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,");
    }

    @Test
    public void splitBarFeatureKeepsFiveCompatCallbacksAndOutcomeBoundaries()
            throws IOException {
        String source = splitBar();
        String container = section(source,
                "private static void installContainerSuppressionHooks(",
                "private static void installSpringSuppressionHooks(");
        assertInOrder(container,
                "HOOK_RESIZABLE_RECT_UPDATE_BLOCK,",
                "SplitBar502Compat.blockF3(param, allowThreeTaskResize);",
                "markHookInstalled(hookRegistry, HOOK_RESIZABLE_RECT_UPDATE_BLOCK,",
                "markHookFailed(hookRegistry, HOOK_RESIZABLE_RECT_UPDATE_BLOCK,",
                "HOOK_THREE_SPLIT_SCROLL_START_BLOCK,",
                "SplitBar502Compat.blockE2Entry(param, allowThreeTaskResize);",
                "markHookInstalled(hookRegistry, HOOK_THREE_SPLIT_SCROLL_START_BLOCK,",
                "markHookFailed(hookRegistry, HOOK_THREE_SPLIT_SCROLL_START_BLOCK,",
                "if (springController == null)",
                "markHookSkipped(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,",
                "if (springState == null)",
                "markHookSkipped(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,",
                "HOOK_THREE_SPLIT_ENLARGE_BLOCK,",
                "SplitBar502Compat.blockI2(param, allowThreeTaskResize);",
                "markHookInstalled(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,",
                "markHookFailed(hookRegistry, HOOK_THREE_SPLIT_ENLARGE_BLOCK,");

        String spring = section(source,
                "private static void installSpringSuppressionHooks(",
                "private static Class<?> findInnerClass(");
        assertInOrder(spring,
                "if (springController == null)",
                "markHookSkipped(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,",
                "markHookSkipped(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,",
                "HOOK_SPRING_DRAG_HANDLER_BLOCK,",
                "SplitBar502Compat.blockEU0(param, allowThreeTaskResize);",
                "markHookInstalled(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,",
                "markHookSkipped(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,",
                "markHookFailed(hookRegistry, HOOK_SPRING_DRAG_HANDLER_BLOCK,",
                "HOOK_SPRING_ANIMATION_INIT_BLOCK,",
                "SplitBar502Compat.blockER(param, allowThreeTaskResize);",
                "markHookInstalled(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,",
                "markHookSkipped(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,",
                "markHookFailed(hookRegistry, HOOK_SPRING_ANIMATION_INIT_BLOCK,");
        assertEquals(5, occurrences(source, "protected void beforeHookedMethod"));
        assertEquals(0, occurrences(source, "param.setResult("));
    }

    @Test
    public void facadePreservesFeatureInstallOrderRegistryLogAndDormantBoundary()
            throws IOException {
        String facade = facade();
        String install = installMethod(facade);
        assertInOrder(install,
                "PinchGestureFeature.installLifecycleHooks(",
                "PanoramaFeature.installLaunchGuard(",
                "PinchGestureFeature.installScaleHook(",
                "ClassicCanvasController.installTransitionIntentPatch(",
                "ClassicLayoutFeature.installLaunchBoundsHook(",
                "PanoramaFeature.installMaskFix(",
                "PinchGestureFeature.installTouchHooks(",
                "ClassicCanvasController.installControllerFlagOverride(",
                "PanoramaFeature.installExitGuard(",
                "ClassicLayoutFeature.install(",
                "ClassicCanvasController.installDirectEntryHook(",
                "ClassicCanvasController.installConversionAnchorHooks(",
                "SplitBarFeature.install(",
                "logHookRegistrySnapshot(hookRegistry);",
                "PsCanvasLog.i(\"install: capability-driven install complete;");

        String logger = section(facade,
                "private static void logHookRegistrySnapshot(",
                "static synchronized void setReflectionAccessForTests(");
        assertInOrder(logger,
                "for (HookRegistry.Entry entry : hookRegistry.snapshot())",
                "PsCanvasLog.i(\"hook-registry id=\" + entry.id()",
                "+ \" status=\" + entry.status()",
                "+ \" detail=\" + entry.detail());");
        assertEquals(1, occurrences(logger, "PsCanvasLog.i("));

        assertFalse(install.contains("installDeferredHooksOnContainerStart("));
        assertFalse(install.contains("hook502BehaviorRestoreCore("));
        assertFalse(install.contains("hook502BehaviorRestoreDeferred("));
        assertFalse(install.contains("hookPanoramaPeekFocusRestore("));
        assertFalse(install.contains("hook502ThreeSplitTouchRestore("));
        assertFalse(install.contains("hookTwoColumnPanoramaRestoreCore("));
        assertFalse(install.contains("hookTwoColumnPanoramaRestoreDeferred("));
        assertFalse(install.contains("hookScaleListener502("));
        assertFalse(install.contains("hookBlockThreeSplitZOrder("));
        assertFalse(install.contains("hookFixPanoramaLaunchRect("));
    }

    @Test
    public void aggregateProductionSourcesKeepFrozenModernRuntimeCounts() throws IOException {
        String source = facade() + featureSources() + featureInstaller();
        assertEquals(35, occurrences(source, "hookRuntime.findAndHookMethod("));
        assertEquals(1, occurrences(source, "hookRuntime.findAndHookConstructor("));
        assertEquals(16, occurrences(source, "hookRuntime.invokeOriginalMethod("));
        assertEquals(0, occurrences(source, "de.robv.android.xposed"));
        assertEquals(0, occurrences(source, "XposedHelpers.findAndHookMethod("));
        assertEquals(0, occurrences(source, "XposedHelpers.findAndHookConstructor("));
        assertEquals(0, occurrences(source, "XposedBridge.invokeOriginalMethod("));
        assertEquals(0, occurrences(source, "XC_MethodHook"));
        assertEquals(0, occurrences(source, "XC_MethodReplacement"));
    }

    private static void assertOutcome(String source, String hookId) {
        assertInOrder(source,
                "markHookInstalled(hookRegistry, " + hookId,
                "markHookFailed(hookRegistry, " + hookId);
    }

    private static String installMethod(String source) {
        return section(source,
                "public static void install(",
                "public static List<HookRegistry.Entry> hookRegistrySnapshot()");
    }

    private static String facade() throws IOException {
        return source("hook/PsCanvasHooks.java");
    }

    private static String pinch() throws IOException {
        return source("feature/PinchGestureFeature.java");
    }

    private static String panorama() throws IOException {
        return source("feature/PanoramaFeature.java");
    }

    private static String controller() throws IOException {
        return source("feature/ClassicCanvasController.java");
    }

    private static String layout() throws IOException {
        return source("feature/ClassicLayoutFeature.java");
    }

    private static String splitBar() throws IOException {
        return source("feature/SplitBarFeature.java");
    }

    private static String featureInstaller() throws IOException {
        return source("feature/FeatureHookInstaller.java");
    }

    private static String featureSources() throws IOException {
        return pinch() + panorama() + controller() + layout() + splitBar();
    }

    private static String source(String relativePath) throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve("app/src/main/java/com/color/pscanvasfix/")
                .resolve(relativePath);
        if (!Files.isRegularFile(source)) {
            source = root.resolve("src/main/java/com/color/pscanvasfix/")
                    .resolve(relativePath);
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8);
    }

    private static String section(String source, String startMarker, String endMarker) {
        int start = source.indexOf(startMarker);
        int end = source.indexOf(endMarker, start);
        assertTrue("Section start missing: " + startMarker, start >= 0);
        assertTrue("Section end missing: " + endMarker, end > start);
        return source.substring(start, end);
    }

    private static int occurrences(String source, String target) {
        int count = 0;
        int offset = 0;
        while ((offset = source.indexOf(target, offset)) >= 0) {
            count++;
            offset += target.length();
        }
        return count;
    }

    private static void assertInOrder(String source, String... fragments) {
        int offset = 0;
        for (String fragment : fragments) {
            int found = source.indexOf(fragment, offset);
            assertTrue("Missing or out-of-order fragment: " + fragment, found >= 0);
            offset = found + fragment.length();
        }
    }
}
