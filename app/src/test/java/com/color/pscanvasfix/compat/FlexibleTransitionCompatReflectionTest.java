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

/** Source-contract regression for the legacy-backed reflection migration. */
public final class FlexibleTransitionCompatReflectionTest {
    @Test
    public void allTwentyFiveOperationsUseReflectionAccess() throws IOException {
        String source = source();

        assertFalse(source.contains("XposedHelpers"));
        assertEquals(9, occurrences(source, "reflectionAccess.callMethod("));
        assertEquals(5, occurrences(source, "reflectionAccess.callStaticMethod("));
        assertEquals(5, occurrences(source, "reflectionAccess.findClass("));
        assertEquals(3, occurrences(source, "reflectionAccess.getIntField("));
        assertEquals(3, occurrences(source, "reflectionAccess.getObjectField("));

        assertTrue(source.contains(
                "reflectionAccess.callStaticMethod(reflectionAccess.findClass("
                        + "\"android.app.ActivityThread\", classLoader), "
                        + "\"currentApplication\", new Object[0])"));
        assertTrue(source.contains(
                "reflectionAccess.callStaticMethod(reflectionAccess.findClass("
                        + "\"B1.l\", context.getClassLoader()), \"g\", "
                        + "new Object[]{Integer.valueOf(taskId), bounds, "
                        + "Float.valueOf(scale)})"));
        assertTrue(source.contains(
                "reflectionAccess.callMethod(target, methodName, args);"));
        assertTrue(source.contains(
                "reflectionAccess.callMethod(activity, \"E1\", true, 0);"));
    }

    @Test
    public void preservesTransitionAndCleanupOrder() throws IOException {
        String source = source();

        assertInOrder(source,
                "public static void beginEarlySplitZoom",
                "earlySplitZoomActive.getAndSet(true)",
                "lastZoomTaskIds = extractZoomTargetTaskIds(splitPolicy);",
                "lastTransitionSucceeded.set(true);",
                "usedZoomFallback.set(true);",
                "handler.post(() -> scheduleStaggeredZoom",
                "scheduleZoomCanvasDismiss(activity, classLoader);",
                "PsCanvasLog.d(\"early split zoom at pinch end");

        assertInOrder(source,
                "private static void invokeZoomForEntry",
                "lastZoomInvokeUptimeMs = SystemClock.uptimeMillis();",
                "reflectionAccess.callStaticMethod(reflectionAccess.findClass(\"B1.l\"",
                "PsCanvasLog.d(\"zoom taskId=\"",
                "catch (Throwable throwable)",
                "PsCanvasLog.e(\"zoom failed for taskId=\"");

        assertInOrder(source,
                "private static void dismissCanvasAfterSettle",
                "earlySplitZoomActive.set(false);",
                "reflectionAccess.callMethod(activity, \"u0\")",
                "detachEmbeddedTasksFromCanvas(classLoader, zoomTaskIds);",
                "AtmCompat.removeTask(classLoader, canvasTaskId)",
                "scheduleMaskClearAfterRemove(lastSplitPolicy);",
                "PsCanvasLog.i(\"removed canvas task after zoom settle");

        assertInOrder(source,
                "private static void finishContainer",
                "reflectionAccess.callMethod(activity, \"E1\", true, 0);",
                "activity.finish();",
                "PsCanvasLog.i(\"finish ContainerActivity after flexible verify\"");
    }

    @Test
    public void preservesAsyncAndLoggingBoundaries() throws IOException {
        String source = source();

        assertEquals(4, occurrences(source, "new AtomicBoolean("));
        assertEquals(11, occurrences(source, "new Handler("));
        assertEquals(8, occurrences(source, ".postDelayed("));
        assertEquals(2, occurrences(source, ".post("));
        assertEquals(1, occurrences(source, ".postAtFrontOfQueue("));
        assertEquals(35, occurrences(source, "PsCanvasLog."));
        assertTrue(source.contains("handler.postDelayed(new Runnable()"));
        assertTrue(source.contains("}, 16L);"));
        assertTrue(source.contains("}, 100L);"));
    }

    @Test
    public void keepsLegacyBackendAndIsolatedTestInjection() throws IOException {
        String source = source();

        assertTrue(source.contains(
                "private static final ReflectionAccess DEFAULT_REFLECTION_ACCESS ="));
        assertTrue(source.contains(
                "new ReflectionAccess(new JavaReflectionBackend());"));
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
                "app/src/main/java/com/color/pscanvasfix/compat/FlexibleTransitionCompat.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/compat/FlexibleTransitionCompat.java");
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
