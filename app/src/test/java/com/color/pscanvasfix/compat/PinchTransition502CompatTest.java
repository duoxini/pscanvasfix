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

/** Source-contract regression for the legacy compileOnly reflection adapter. */
public final class PinchTransition502CompatTest {
    @Test
    public void seventeenCallsUseReflectionAccessWithExactApiCounts() throws IOException {
        String source = source();

        assertFalse(source.contains("XposedHelpers"));
        assertEquals(13, occurrences(source, "reflectionAccess.callMethod("));
        assertEquals(1, occurrences(source, "reflectionAccess.callStaticMethod("));
        assertEquals(1, occurrences(source, "reflectionAccess.findClass("));
        assertEquals(2, occurrences(source, "reflectionAccess.getObjectField("));
    }

    @Test
    public void preservesSixCallRegionsInOriginalOrder() throws IOException {
        String source = source();

        assertInOrder(source,
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(UTIL, classLoader)",
                "new int[]{0}",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(adapter, \"getItem\", 0)",
                "reflectionAccess.callMethod(item, \"B\")",
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(containerView, \"getRectListUnion\")",
                "reflectionAccess.callMethod(embeddedDecor, \"getLaunchRect\")",
                "reflectionAccess.getObjectField(mask, \"f14169f\")",
                "reflectionAccess.getObjectField(mask, \"f14170g\")",
                "reflectionAccess.callMethod(embeddedDecor, \"getTaskData\")",
                "reflectionAccess.callMethod(taskData, \"s\")",
                "reflectionAccess.callMethod(splitPolicy, \"K\", mask, bundle, entry)");
    }

    @Test
    public void preservesArgumentsBranchesCatchBoundariesAndLogs() throws IOException {
        String source = source();

        assertTrue(source.contains("\"t0\",\n                        new int[]{0},\n"
                + "                        launchBounds,\n                        scales,\n"
                + "                        bundle);"));
        assertTrue(source.contains("reflectionAccess.callMethod(item, \"B\")"));
        assertTrue(source.contains(
                "if (adapter == null || ((Integer) reflectionAccess.callMethod(adapter, \"n\")) != 4)"));
        assertTrue(source.contains("if (maskDecor != embeddedDecor)"));
        assertTrue(source.contains("animRect.set(launchRect);"));
        assertEquals(5, occurrences(source, "catch (Throwable throwable)"));
        assertTrue(source.contains("PsCanvasLog.e(\"syncLiveLayoutOrient failed\", throwable);"));
        assertTrue(source.contains("PsCanvasLog.e(\"502 dummy prepare failed\", throwable);"));
        assertTrue(source.contains("PsCanvasLog.e(\"502 layout remap failed\", throwable);"));
        assertTrue(source.contains("PsCanvasLog.e(\"fixPanoramaMaskAnimRect failed\", throwable);"));
    }

    @Test
    public void preservesPublicApiAndIsolatedTestInjection() throws IOException {
        String source = source();

        assertEquals(4, occurrences(source, "public static void "));
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
                "app/src/main/java/com/color/pscanvasfix/compat/PinchTransition502Compat.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/compat/PinchTransition502Compat.java");
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8);
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
