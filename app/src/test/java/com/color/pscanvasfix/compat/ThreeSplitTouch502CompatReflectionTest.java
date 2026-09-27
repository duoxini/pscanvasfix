package com.color.pscanvasfix.compat;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Source-contract regression for the three-task touch legacy reflection adapter. */
public final class ThreeSplitTouch502CompatReflectionTest {
    @Test
    public void twentyEightCallsUseReflectionAccessWithExactApiCounts() throws IOException {
        String source = source();

        assertFalse(source.contains("XposedHelpers"));
        assertEquals(23, occurrences(source, "reflectionAccess.callMethod("));
        assertEquals(2, occurrences(source, "reflectionAccess.callStaticMethod("));
        assertEquals(2, occurrences(source, "reflectionAccess.findClass("));
        assertEquals(1, occurrences(source, "reflectionAccess.getObjectField("));
    }

    @Test
    public void preservesStrictResizeSnapshotThenLegacyReflectionOrder() throws IOException {
        String source = source();

        assertInOrder(source,
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"getCount\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(\n                    containerView, \"getPanoramaModeManager\")",
                "reflectionAccess.callMethod(panoramaManager, \"M\")",
                "reflectionAccess.callMethod(containerView, \"i1\")",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"getCount\")",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(containerView, \"V\", index, 1)",
                "reflectionAccess.callMethod(activity, \"v0\")",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(\"B1.l\", context.getClass().getClassLoader())",
                "\"O1\", context",
                "reflectionAccess.callMethod(resolvedActivity, \"v0\")",
                "reflectionAccess.callMethod(containerView, \"setIsSwitchToZoomAnim\", false)",
                "reflectionAccess.callMethod(containerView, \"setIsSwitchToZoomAnim\", false)",
                "reflectionAccess.callMethod(adapter, \"getContext\")",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(\"B1.l\", adapter.getClass().getClassLoader())",
                "\"O1\", context",
                "reflectionAccess.callMethod(activity, \"v0\")",
                "reflectionAccess.callMethod(containerView, \"G1\", index)",
                "reflectionAccess.getObjectField(containerView, name)",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"H\", index)",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(adapter, \"i\")");
    }

    @Test
    public void preservesGesturePanoramaConditionsFallbacksAndLogs() throws IOException {
        String source = source();

        assertTrue(source.contains(
                "if (containerView == null || SplitPolicyCompat.inTransition())"));
        assertTrue(source.contains("return layout >= 4 && layout <= 7;"));
        assertTrue(source.contains("public static boolean shouldUseCanvasSyncPinch"));
        assertTrue(source.contains("public static boolean shouldUseCanvasSyncPinch(Object containerView) {\n        return false;\n    }"));
        assertTrue(source.contains("if (gestureOuter == null || gestureClass == null)"));
        assertTrue(source.contains(
                "if (gestureOuter == null || gestureClass == null || pointerCount <= 3)"));
        assertTrue(source.contains("if (pointerCount > 3)"));
        assertTrue(source.contains("return !splitFlag;"));
        assertTrue(source.contains(
                "return isPanoramaThreeSplit(containerView) || isPortraitPanorama(containerView);"));
        assertTrue(source.contains("catch (Throwable ignored)"));
        assertTrue(source.contains("catch (Throwable throwable)"));
        assertTrue(source.contains("PsCanvasLog.e(\"focusWithPan failed index=\""));
        assertTrue(source.contains("PsCanvasLog.d(\"3-app pinch prep pointers=\""));
        assertTrue(source.contains("PsCanvasLog.d(\"3-app force sync pinch pointers=\""));
        assertTrue(source.contains(
                "PsCanvasLog.d(\"blocked tap-to-enlarge in panorama index=\""));
        assertTrue(source.contains(
                "PsCanvasLog.e(\"redirectGestureFocusToPan failed index=\""));
    }

    @Test
    public void resizeSnapshotAcceptsOemDiscreteLayoutsOnlyWithInactiveManager() throws IOException {
        String source = source();

        assertTrue(source.contains("if (layout < 3 || layout > 7)"));
        assertTrue(source.contains("Boolean.TRUE.equals(panoramaActive)"));
        assertTrue(source.contains(
                "? ThreeTaskResizeState.BLOCKED : ThreeTaskResizeState.NORMAL"));
    }

    @Test
    public void preservesIsolatedTestInjection() throws IOException {
        String source = source();

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

    private static String source() throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve(
                "app/src/main/java/com/color/pscanvasfix/compat/ThreeSplitTouch502Compat.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/compat/ThreeSplitTouch502Compat.java");
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

    private static void assertInOrder(String source, String... fragments) {
        int offset = 0;
        for (String fragment : fragments) {
            int found = source.indexOf(fragment, offset);
            assertTrue("Missing or out-of-order fragment: " + fragment, found >= 0);
            offset = found + fragment.length();
        }
    }
}
