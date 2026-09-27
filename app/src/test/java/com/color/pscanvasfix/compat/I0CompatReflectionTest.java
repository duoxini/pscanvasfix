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

/** Source-contract regression for I0 task-data construction and population. */
public final class I0CompatReflectionTest {
    @Test
    public void allTwentyThreeOperationsUseReflectionAccess() throws IOException {
        String source = source();

        assertFalse(source.contains("XposedHelpers"));
        assertEquals(19, occurrences(source, "reflectionAccess.callMethod("));
        assertEquals(1, occurrences(source, "reflectionAccess.callStaticMethod("));
        assertEquals(2, occurrences(source, "reflectionAccess.findClass("));
        assertEquals(1, occurrences(source, "reflectionAccess.newInstance("));

        assertInOrder(source,
                "public static List<?> run",
                "injectDisplayBounds(context, intents);",
                "reflectionAccess.callStaticMethod(",
                "reflectionAccess.findClass(UTIL, loader)",
                "\"n\",",
                "intents,",
                "layoutOrientation,",
                "null",
                "clearDisplayBounds(intents);",
                "parseTaskDataList(context, intents, bundle, loader);",
                "catch (Throwable throwable)",
                "PsCanvasLog.e(\"o0 compat failed:\", throwable);",
                "return null;");

        assertTrue(source.contains(
                "reflectionAccess.newInstance(taskDataClass, launchBounds, 0, intent);"));
    }

    @Test
    public void preservesParseAndPopulationOrder() throws IOException {
        String source = source();

        assertInOrder(source,
                "private static List<?> parseTaskDataList",
                "bundle == null",
                "resolveTaskDataClass(classLoader);",
                "PsCanvasLog.w(\"task data class not found\");",
                "for (int index = 0; index < layoutInfoList.size(); index++)",
                "item.getInt(\"androidx.flexible.ResizeMode\", 0)",
                "if (resizeMode == 0)",
                "PsCanvasLog.e(\"app does not support pocket studio\", null);",
                "item.getParcelable(\"androidx.flexible.LaunchBounds\", Rect.class)",
                "reflectionAccess.newInstance(taskDataClass, launchBounds, 0, intent);",
                "populateTaskData(taskData, item, launchBounds);",
                "result.add(taskData);");

        assertInOrder(source,
                "private static void populateTaskData",
                "reflectionAccess.callMethod(taskData, \"h0\"",
                "reflectionAccess.callMethod(taskData, \"Y\"",
                "reflectionAccess.callMethod(taskData, \"L\"",
                "reflectionAccess.callMethod(taskData, \"Q\"",
                "reflectionAccess.callMethod(taskData, \"b0\"",
                "reflectionAccess.callMethod(taskData, \"a0\"",
                "reflectionAccess.callMethod(taskData, \"Z\"",
                "reflectionAccess.callMethod(taskData, \"U\"",
                "reflectionAccess.callMethod(taskData, \"V\"",
                "bundle.get(\"androidx.flexible.LaunchPredictResizeableMode\") != null",
                "reflectionAccess.callMethod(taskData, \"c0\"",
                "if (launchBounds == null || launchBounds.isEmpty())",
                "return;",
                "reflectionAccess.callMethod(taskData, \"g0\"",
                "if (resizeMode == 2)",
                "bundle.get(\"androidx.flexible.CompatRatio\")",
                "if (ratio instanceof Float)",
                "reflectionAccess.callMethod(taskData, \"e0\"",
                "reflectionAccess.callMethod(taskData, \"K\"",
                "reflectionAccess.callMethod(taskData, \"W\"",
                "bundle.getParcelable(\"androidx.flexible.LaunchPreferredBounds\", Rect.class)",
                "if ((resizeMode == 1 || resizeMode == 3)",
                "reflectionAccess.callMethod(taskData, \"P\"",
                "reflectionAccess.callMethod(taskData, \"X\"",
                "reflectionAccess.callMethod(taskData, \"i0\"",
                "reflectionAccess.callMethod(taskData, \"s0\"",
                "reflectionAccess.callMethod(taskData, \"R\"");
    }

    @Test
    public void preservesBundleKeysDefaultsAndClassFallback() throws IOException {
        String source = source();

        assertTrue(source.contains(
                "bundle.getInt(\"key_single_app_split_disable_resize\", 0)"));
        assertTrue(source.contains(
                "bundle.getBoolean(\"key_single_app_split_is_package_has_inner_task\", false)"));
        assertTrue(source.contains(
                "bundle.getBoolean(\"androidx.flexible.IsOriginalResizable\", false)"));
        assertTrue(source.contains(
                "bundle.getInt(\"androidx.flexible.ScreenOrientation\", -2)"));
        assertTrue(source.contains(
                "bundle.getBoolean(\"androidx.activity.ParallelWindowMode\", false)"));

        assertInOrder(source,
                "private static Class<?> resolveTaskDataClass",
                "String[] candidates = {TASK_DATA, \"u1.d\"};",
                "Class.forName(name, false, classLoader);",
                "catch (Throwable ignored)",
                "reflectionAccess.findClass(name, classLoader);",
                "catch (Throwable ignored)",
                "return null;");
        assertEquals(2, occurrences(source, "catch (Throwable ignored)"));
        assertEquals(3, occurrences(source, "PsCanvasLog."));
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
                "app/src/main/java/com/color/pscanvasfix/compat/I0Compat.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve("src/main/java/com/color/pscanvasfix/compat/I0Compat.java");
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
