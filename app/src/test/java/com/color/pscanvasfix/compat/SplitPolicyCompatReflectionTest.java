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

/** Source-contract regression for SplitPolicyCompat's legacy reflection adapter. */
public final class SplitPolicyCompatReflectionTest {
    @Test
    public void eighteenCallsUseReflectionAccessWithOriginalArgumentShapes() throws IOException {
        String source = source();

        assertFalse(source.contains("XposedHelpers"));
        assertEquals(18, occurrences(source, "reflectionAccess.callMethod("));
        assertEquals(10, occurrences(source, "new Object[0]"));
        assertEquals(1, occurrences(source, "new Object[]{false}"));
        assertTrue(source.contains(
                "reflectionAccess.callMethod(containerView, "
                        + "\"setIsToFlexibleAnimating\", new Object[]{false})"));
    }

    @Test
    public void preservesElevenReflectionRegionsInOriginalOrder() throws IOException {
        String source = source();

        assertInOrder(source,
                "reflectionAccess.callMethod(containerView, \"getChildEmbeddedViewList\", new Object[0])",
                "reflectionAccess.callMethod(embeddedView, \"getTaskData\", new Object[0])",
                "reflectionAccess.callMethod(taskData, \"s\", new Object[0])",
                "reflectionAccess.callMethod(containerView, \"Q2\", context)",
                "reflectionAccess.callMethod(activity, \"u0\")",
                "reflectionAccess.callMethod(\n                        containerView, \"getChildEmbeddedViewList\")",
                "reflectionAccess.callMethod(splitPolicy, \"G\", index)",
                "reflectionAccess.callMethod(splitPolicy, \"E\", decor)",
                "reflectionAccess.callMethod(decor, \"getTaskData\")",
                "reflectionAccess.callMethod(taskData, \"s\")",
                "reflectionAccess.callMethod(containerView, \"getChildEmbeddedViewList\", new Object[0])",
                "reflectionAccess.callMethod(embeddedView, \"getTaskData\", new Object[0])",
                "reflectionAccess.callMethod(taskData, \"s\", new Object[0])",
                "reflectionAccess.callMethod(decor, \"getInitialized\", new Object[0])",
                "reflectionAccess.callMethod(containerView, \"getChildEmbeddedViewList\", new Object[0])",
                "reflectionAccess.callMethod(containerView, \"setIsToFlexibleAnimating\", new Object[]{false})",
                "reflectionAccess.callMethod(decor, \"getTaskData\", new Object[0])",
                "reflectionAccess.callMethod(taskData, \"s\", new Object[0])");
    }

    @Test
    public void preservesEarlyReturnsCatchBoundariesAndCurrentLogging() throws IOException {
        String source = source();

        assertTrue(source.contains("if (containerView == null) {\n            return taskIds;\n        }"));
        assertTrue(source.contains("if (embeddedViews == null) {\n            return taskIds;\n        }"));
        assertTrue(source.contains("return 0;"));
        assertTrue(source.contains("return null;"));
        assertTrue(source.contains("catch (Throwable ignored)"));
        assertTrue(source.contains("catch (Throwable throwable)"));
        assertTrue(source.contains(
                "PsCanvasLog.e(\"getEmbeddedCanvasTaskIds failed:\", throwable);"));
        assertTrue(source.contains(
                "PsCanvasLog.e(\"resolveContainerTaskId failed:\", throwable);"));
        assertTrue(source.contains(
                "PsCanvasLog.e(\"findEmbeddedDecorByTaskId failed:\", throwable);"));
        assertTrue(source.contains("PsCanvasLog.e(\"hideEmbeddedViews failed:\", throwable);"));
        assertTrue(source.contains(
                "PsCanvasLog.e(\"getTaskId from decor failed:\", throwable);"));
        assertTrue(source.contains(
                "PsCanvasLog.d(\"sanitized transition entry bounds from \""));
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
                "app/src/main/java/com/color/pscanvasfix/compat/SplitPolicyCompat.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/compat/SplitPolicyCompat.java");
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
