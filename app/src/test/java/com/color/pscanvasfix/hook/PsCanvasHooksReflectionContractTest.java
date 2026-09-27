package com.color.pscanvasfix.hook;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Source-contract regression for the staged PsCanvasHooks reflection consolidation. */
public final class PsCanvasHooksReflectionContractTest {
    @Test
    public void allReflectionCallsStayBehindProjectOwnedFacade() throws IOException {
        String source = productionSource();

        assertEquals(35, occurrences(source, "reflectionAccess.callMethod("));
        assertEquals(4, occurrences(source, "reflectionAccess.callStaticMethod("));
        assertEquals(18, occurrences(source, "reflectionAccess.findClass("));
        assertEquals(1, occurrences(source, "reflectionAccess.getIntField("));
        assertEquals(6, occurrences(source, "reflectionAccess.getObjectField("));
        assertEquals(1, occurrences(source, "reflectionAccess.newInstance("));
        assertEquals(2, occurrences(source, "reflectionAccess.setBooleanField("));
        assertEquals(4, occurrences(source, "reflectionAccess.setIntField("));
        assertEquals(4, occurrences(source, "reflectionAccess.setObjectField("));

        assertEquals(0, occurrences(source, "XposedHelpers.callMethod("));
        assertEquals(0, occurrences(source, "XposedHelpers.callStaticMethod("));
        assertEquals(0, occurrences(source, "XposedHelpers.findClass("));
        assertEquals(0, occurrences(source, "XposedHelpers.getIntField("));
        assertEquals(0, occurrences(source, "XposedHelpers.getObjectField("));
        assertEquals(0, occurrences(source, "XposedHelpers.newInstance("));
        assertEquals(0, occurrences(source, "XposedHelpers.setBooleanField("));
        assertEquals(0, occurrences(source, "XposedHelpers.setIntField("));
        assertEquals(0, occurrences(source, "XposedHelpers.setObjectField("));
        assertEquals(0, directXposedReflectionCalls(source));
    }

    @Test
    public void firstSlicePreservesMethodLocalCallOrder() throws IOException {
        String source = facadeSource();

        assertRegionOrder(source,
                "private static Class<?> findClassSafe(",
                "private static Class<?> findClassFirst(",
                "reflectionAccess.findClass(className, classLoader)");
        assertRegionOrder(source,
                "private static boolean enter260608PanoramaFromPinch(",
                "private static void hook502BehaviorRestoreCore(",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(containerView, \"getPanoramaModeManager\")",
                "reflectionAccess.callMethod(manager, \"M\")",
                "reflectionAccess.callMethod(manager, \"z\", true)");
        assertRegionOrder(source,
                "private static void hook502BehaviorRestoreCore(",
                "private static volatile Class<?> gestureManagerClass;",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(UTIL, lpparam.classLoader)",
                "reflectionAccess.callMethod(activity, \"v0\")");
        assertRegionOrder(source,
                "private static void hookGestureThreeAppSync(",
                "private static void hook502SplitToFlexibleRestore(",
                "reflectionAccess.callMethod(param.args[0], \"v0\")",
                "reflectionAccess.findClass(CONTAINER_VIEW, lpparam.classLoader)");
        assertRegionOrder(source,
                "private static void hook502SplitToFlexibleRestore(",
                "private static void hookPanoramaMaskAnimRectFix(",
                "reflectionAccess.callMethod(splitPolicy, \"C\")",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(\"B1.h\", lpparam.classLoader)",
                "reflectionAccess.callMethod(tracker, \"e\", \"four_finger_to_zoom\")");
        assertRegionOrder(source,
                "private static void schedulePinchEndFallback(",
                "private static boolean shouldBlockTouchMoveG0(",
                "reflectionAccess.callMethod(policy, \"g0\")");

        String panorama = featureSource("PanoramaFeature.java");
        assertRegionOrder(panorama,
                "public static boolean handleDirectionalScale(",
                "private static boolean isActive(",
                "reflectionAccess.callMethod(containerView, managerGetter)",
                "reflectionAccess.callMethod(manager, activeMethod)",
                "reflectionAccess.callMethod(manager, enterMethod, true)",
                "DIRECTIONAL_EXIT_ALLOWED.set(Boolean.TRUE)",
                "reflectionAccess.callMethod(manager, exitMethod, true)",
                "DIRECTIONAL_EXIT_ALLOWED.remove()");
        assertRegionOrder(panorama,
                "private static boolean isActive(",
                "private static Class<?> resolveManagerClass(",
                "reflectionAccess.callMethod(\n                    containerView, managerGetter)",
                "reflectionAccess.callMethod(manager, activeMethod)");
        assertRegionOrder(panorama,
                "private static Class<?> resolveManagerClass(",
                "private static boolean isCanvasGestureManagerCall(",
                "FeatureReflectionResolver.findClass(\n                    reflectionAccess, containerViewClass, lpparam.classLoader)",
                "FeatureReflectionResolver.findClass(\n                            reflectionAccess, className, lpparam.classLoader)");
        String featureResolver = featureSource("FeatureReflectionResolver.java");
        assertRegionOrder(featureResolver,
                "static Class<?> findClass(",
                "\n    }\n}",
                "reflectionAccess.findClass(className, classLoader)");

        String pinch = featureSource("PinchGestureFeature.java");
        assertRegionOrder(pinch,
                "public static void installScaleHook(",
                "public static void installTouchHooks(",
                "PanoramaFeature.handleDirectionalScale(containerView,",
                "managerGetter, panoramaActiveMethod,",
                "panoramaEnterMethod, panoramaExitMethod",
                "TwoTaskPanoramaFeature.handleDirectionalScale(",
                "ThreeSplitTouch502Compat.shouldUseCanvasSyncPinch(");

        assertRegionOrder(source,
                "PanoramaFeature.installLaunchGuard(",
                "ClassicCanvasController.installTransitionIntentPatch(",
                "reflectionAccess, transitionClass, \"L0\",",
                "\"getPanoramaModeManager\", \"M\")",
                "symbols.role(PsCanvasSymbols.Role.PANORAMA_MANAGER)",
                "panoramaManager.available()",
                "panoramaManager.twoTaskPredicateMethod != null",
                "panoramaManager.panoramaActiveMethod : \"M\"",
                "panoramaManager.panoramaEnterMethod : \"z\"",
                "panoramaManager.panoramaExitMethod : \"A\"",
                "PinchGestureFeature.installScaleHook(",
                "reflectionAccess, transitionClass, scaleMethod,",
                "\"getPanoramaModeManager\", panoramaActiveMethod,",
                "panoramaEnterMethod, panoramaExitMethod,",
                "twoTaskPanoramaCapability);");
    }

    @Test
    public void secondSliceMigratesEighteenCallsWithinFiveMethodRegions() throws IOException {
        String source = facadeSource();

        String remap = region(source,
                "private static int remapThreeSplitLayout(",
                "private static void hookTwoColumnPanoramaRestoreDeferred(");
        assertEquals(1, occurrences(remap, "reflectionAccess.callMethod("));
        assertTrue(remap.contains(
                "reflectionAccess.callMethod(adapter, \"getCount\")"));

        String deferred = region(source,
                "private static void hookTwoColumnPanoramaRestoreDeferred(",
                "private static void ensureTwoColumnLayout(");
        assertEquals(4, occurrences(deferred, "reflectionAccess.callMethod("));
        assertEquals(1, occurrences(deferred, "reflectionAccess.getObjectField("));
        assertEquals(1, occurrences(deferred, "reflectionAccess.setObjectField("));
        assertRegionOrder(source,
                "private static void hookTwoColumnPanoramaRestoreDeferred(",
                "private static void ensureTwoColumnLayout(",
                "reflectionAccess.callMethod(param.thisObject, \"getCount\")",
                "reflectionAccess.callMethod(param.thisObject, \"getCount\")",
                "reflectionAccess.callMethod(param.thisObject, \"getCount\")",
                "reflectionAccess.getObjectField(param.thisObject, \"f13801s\")",
                "reflectionAccess.setObjectField(param.thisObject, \"f13801s\", null)",
                "reflectionAccess.callMethod(adapter, \"getCount\")");

        String ensure = region(source,
                "private static void ensureTwoColumnLayout(",
                "private static void hookBeforeMethod(");
        assertEquals(3, occurrences(ensure, "reflectionAccess.callMethod("));
        assertEquals(1, occurrences(ensure, "reflectionAccess.callStaticMethod("));
        assertEquals(1, occurrences(ensure, "reflectionAccess.findClass("));
        assertRegionOrder(source,
                "private static void ensureTwoColumnLayout(",
                "private static void hookBeforeMethod(",
                "reflectionAccess.callMethod(adapter, \"getCount\")",
                "reflectionAccess.callMethod(adapter, \"getContext\")",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(UTIL, adapter.getClass().getClassLoader())",
                "reflectionAccess.callMethod(activity, \"v0\")");

        String gesture = region(source,
                "private static void hookScaleListener502(",
                "private static void hookWindowConfigUtils(");
        assertEquals(4, occurrences(gesture, "reflectionAccess.getObjectField("));
        assertEquals(1, occurrences(gesture, "reflectionAccess.findClass("));
        assertEquals(4, occurrences(gesture,
                "reflectionAccess.getObjectField(param.thisObject, \"this$0\")"));

        String atm = region(source,
                "private static void hookActivityTaskManagerCallers(",
                "private static void hookWithAtmFallback(");
        assertEquals(1, occurrences(atm, "reflectionAccess.getIntField("));
        assertTrue(atm.contains(
                "reflectionAccess.getIntField(task, \"taskId\") == taskId"));
    }

    @Test
    public void thirdSliceMigratesSeventeenCallsWithinEightMethodRegions() throws IOException {
        String source = facadeSource();

        String atmFallback = region(source,
                "private static void hookWithAtmFallback(",
                "private static void hookSplitToFlexibleTransition(");
        assertEquals(1, occurrences(atmFallback, "reflectionAccess.setBooleanField("));
        assertTrue(atmFallback.contains(
                "reflectionAccess.setBooleanField(param.thisObject, \"c\", false)"));

        String taskRemoval = region(source,
                "private static void hookCanvasTaskRemoval(",
                "private static void hookDirectWindowConfigurationAccess(");
        assertEquals(1, occurrences(taskRemoval, "reflectionAccess.callMethod("));
        assertTrue(taskRemoval.contains(
                "reflectionAccess.callMethod(param.thisObject, \"u0\")"));

        String configFallback = region(source,
                "private static void hookWithConfigFallback(",
                "private static Object handleConfigFallback(");
        assertEquals(1, occurrences(configFallback, "reflectionAccess.findClass("));
        assertTrue(configFallback.contains(
                "reflectionAccess.findClass((String) type, lpparam.classLoader)"));

        String activityTail = region(source,
                "private static void finishContainerActivityOnCreateTail(",
                "private static void finishOnConfigurationChanged(");
        assertEquals(1, occurrences(activityTail, "reflectionAccess.setIntField("));
        assertEquals(2, occurrences(activityTail, "reflectionAccess.setObjectField("));
        assertEquals(1, occurrences(activityTail, "reflectionAccess.callStaticMethod("));
        assertEquals(2, occurrences(activityTail, "reflectionAccess.findClass("));
        assertEquals(1, occurrences(activityTail, "reflectionAccess.newInstance("));
        assertRegionOrder(source,
                "private static void finishContainerActivityOnCreateTail(",
                "private static void finishOnConfigurationChanged(",
                "reflectionAccess.setIntField(activity, \"f10231M\", configuration.densityDpi)",
                "reflectionAccess.setObjectField(activity, \"f10267n\"",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(",
                "reflectionAccess.findClass(\n                    CONTAINER_ACTIVITY + \"$EmbeddedWindowCallback\"",
                "reflectionAccess.setObjectField(activity, \"f10269o\"",
                "reflectionAccess.newInstance(callbackClass, activity)");

        String configurationChanged = region(source,
                "private static void finishOnConfigurationChanged(",
                "private static ClassLoader resolveClassLoader(");
        assertEquals(1, occurrences(configurationChanged, "reflectionAccess.setIntField("));
        assertEquals(1, occurrences(configurationChanged, "reflectionAccess.setBooleanField("));

        String panorama = region(source,
                "private static void finishPanoramaF0(",
                "private static void replaceMethod(");
        assertEquals(2, occurrences(panorama, "reflectionAccess.setIntField("));

        String safeCall = region(source,
                "private static void safeCall(",
                "private static void setRectField(");
        assertEquals(1, occurrences(safeCall, "reflectionAccess.callMethod("));
        assertTrue(safeCall.contains(
                "reflectionAccess.callMethod(target, methodName, args);"));

        String rectField = region(source,
                "private static void setRectField(",
                "private static Context extractContext(");
        assertEquals(1, occurrences(rectField, "reflectionAccess.getObjectField("));
        assertEquals(1, occurrences(rectField, "reflectionAccess.setObjectField("));
    }

    @Test
    public void fourthSlicePreservesAnchorRedirectGuardReadAndConsumeOrder() throws IOException {
        String source = featureSource("ClassicCanvasController.java");
        String start = "FeatureHookInstaller.register(hookRuntime, "
                + "HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,";
        String end = "markHookInstalled(hookRegistry, HOOK_ENTRY_TWO_TO_THREE_ANCHOR_REDIRECT,";
        String anchorRedirect = region(source, start, end);

        assertEquals(3, occurrences(anchorRedirect, "reflectionAccess.callMethod("));
        assertEquals(0, occurrences(anchorRedirect, "XposedHelpers.callMethod("));
        assertRegionOrder(source, start, end,
                "if ((Integer) param.args[0] != 2",
                "instanceStateStore.get(param.thisObject,",
                "|| !isNewTaskAppEnterAutoScale(",
                "reflectionAccess.callMethod(\n                                    param.thisObject, adapterGetterMethod)",
                "reflectionAccess.callMethod(\n                                    adapter, adapterCountMethod)",
                "reflectionAccess.callMethod(\n                                    adapter, adapterLayoutMethod)",
                "if (count != 3 || layout != 3)",
                "instanceStateStore.remove(param.thisObject,",
                "return;",
                "param.args[0] = 0;",
                "instanceStateStore.remove(param.thisObject,");
    }

    @Test
    public void keepsModernRegistrationsRegistryCallbacksOriginAndStateUnchanged()
            throws IOException {
        String source = productionSource();

        assertEquals(35, occurrences(source, "hookRuntime.findAndHookMethod("));
        assertEquals(1, occurrences(source, "hookRuntime.findAndHookConstructor("));
        assertEquals(30, occurrences(source, "hookRegistry.declare("));
        assertEquals(30, occurrences(source, "markHookInstalled("));
        assertEquals(35, occurrences(source, "markHookSkipped("));
        assertEquals(30, occurrences(source, "markHookFailed("));
        assertEquals(23, occurrences(source, "protected void beforeHookedMethod("));
        assertEquals(14, occurrences(source, "protected void afterHookedMethod("));
        assertEquals(4, occurrences(source, "protected Object replaceHookedMethod("));
        assertEquals(16, occurrences(source, "hookRuntime.invokeOriginalMethod("));
        assertEquals(7, occurrences(source, "instanceStateStore."));
        assertEquals(0, occurrences(source, "INSTANCE_STATE_STORE."));

        String facade = facadeSource();
        assertTrue(facade.contains(
                "public static void install(PackageLoadContext lpparam, HookRuntime runtime)"));
        assertTrue(source.contains("new HookCallback()"));
        assertTrue(source.contains("new HookReplacement()"));
        assertEquals(0, occurrences(source, "de.robv.android.xposed"));
        assertEquals(0, occurrences(source, "XposedHelpers.findAndHookMethod("));
        assertEquals(0, occurrences(source, "XposedHelpers.findAndHookConstructor("));
        assertEquals(0, occurrences(source, "XposedBridge.invokeOriginalMethod("));
        assertEquals(0, occurrences(source, "XC_MethodHook"));
        assertEquals(0, occurrences(source, "XC_MethodReplacement"));
        assertEquals(0, occurrences(source, "MethodHookParam"));
    }

    @Test
    public void usesIsolatedDefaultReflectionFacadeAndTestInjection() throws IOException {
        String source = facadeSource();

        assertTrue(source.contains(
                "private static final ReflectionAccess DEFAULT_REFLECTION_ACCESS ="));
        assertTrue(source.contains(
                "private static volatile ReflectionAccess reflectionAccess = "
                        + "DEFAULT_REFLECTION_ACCESS;"));
        assertTrue(source.contains(
                "static synchronized void setReflectionAccessForTests(ReflectionAccess access)"));
        assertTrue(source.contains(
                "reflectionAccess = Objects.requireNonNull(access, \"access\");"));
        assertTrue(source.contains(
                "static synchronized void resetReflectionAccessForTests()"));
        assertTrue(source.contains("reflectionAccess = DEFAULT_REFLECTION_ACCESS;"));
    }

    @Test
    public void p4TraceIsDebugOnlyAndDoesNotEnableTheProductFeature() throws IOException {
        String source = facadeSource();
        String traceSetup = region(source,
                "private static void installFourTaskTrace(",
                "public static List<HookRegistry.Entry> hookRegistrySnapshot()");

        assertTrue(source.contains(
                "if (BuildConfig.DEBUG) {\n            installFourTaskTrace("));
        assertEquals(1, occurrences(source, "FourTaskTraceFeature.install("));
        assertEquals(6, occurrences(traceSetup, "reflectionAccess.findClass("));
        assertEquals(0, occurrences(traceSetup, "FOUR_TASK_CANVAS"));
        assertEquals(0, occurrences(traceSetup, "CapabilitySet.State.READY"));
        assertTrue(source.contains(
                "lpparam.preferences, CapabilitySet.of("));
    }

    private static int directXposedReflectionCalls(String source) {
        int total = 0;
        String[] methods = {
                "callMethod", "callStaticMethod", "findClass", "getIntField",
                "getObjectField", "newInstance", "setBooleanField", "setIntField",
                "setObjectField"
        };
        for (String method : methods) {
            total += occurrences(source, "XposedHelpers." + method + "(");
        }
        return total;
    }

    private static void assertRegionOrder(String source, String start, String end,
                                          String... fragments) {
        String region = region(source, start, end);
        int offset = 0;
        for (String fragment : fragments) {
            int found = region.indexOf(fragment, offset);
            assertTrue("Missing or out-of-order fragment: " + fragment, found >= 0);
            offset = found + fragment.length();
        }
    }

    private static String region(String source, String start, String end) {
        int startOffset = source.indexOf(start);
        assertTrue("Missing region start: " + start, startOffset >= 0);
        int endOffset = source.indexOf(end, startOffset + start.length());
        assertTrue("Missing region end: " + end, endOffset > startOffset);
        return source.substring(startOffset, endOffset);
    }

    private static String productionSource() throws IOException {
        StringBuilder source = new StringBuilder(facadeSource());
        String[] featureFiles = {
                "ClassicCanvasController.java",
                "ClassicLayoutFeature.java",
                "FeatureHookInstaller.java",
                "FeatureReflectionResolver.java",
                "PanoramaFeature.java",
                "PinchGestureFeature.java",
                "SplitBarFeature.java",
                "TwoTaskPanoramaFeature.java"
        };
        for (String featureFile : featureFiles) {
            source.append('\n').append(featureSource(featureFile));
        }
        return source.toString();
    }

    private static String facadeSource() throws IOException {
        return javaSource("com/color/pscanvasfix/hook/PsCanvasHooks.java");
    }

    private static String featureSource(String fileName) throws IOException {
        return javaSource("com/color/pscanvasfix/feature/" + fileName);
    }

    private static String javaSource(String relativePath) throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve("app/src/main/java").resolve(relativePath);
        if (!Files.isRegularFile(source)) {
            source = root.resolve("src/main/java").resolve(relativePath);
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8)
                .replace("\r\n", "\n");
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
}
