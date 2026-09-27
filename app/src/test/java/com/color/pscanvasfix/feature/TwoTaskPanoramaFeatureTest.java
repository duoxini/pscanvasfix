package com.color.pscanvasfix.feature;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.color.pscanvasfix.runtime.ReflectionAccess;

import static com.color.pscanvasfix.feature.TwoTaskPanoramaFeature.Decision.CONSUME_NOOP;
import static com.color.pscanvasfix.feature.TwoTaskPanoramaFeature.Decision.ENTER;
import static com.color.pscanvasfix.feature.TwoTaskPanoramaFeature.Decision.EXIT;
import static com.color.pscanvasfix.feature.TwoTaskPanoramaFeature.Decision.NOT_HANDLED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public final class TwoTaskPanoramaFeatureTest {
    @Test
    public void exactTwoTaskFramesHaveDirectionalStateSemantics() {
        int[] pointers = {4, 5, 8};
        for (int pointerCount : pointers) {
            assertDecision(ENTER, 2, pointerCount, 0.75f, false);
            assertDecision(CONSUME_NOOP, 2, pointerCount, 0.75f, true);
            assertDecision(CONSUME_NOOP, 2, pointerCount, 1.0f, false);
            assertDecision(CONSUME_NOOP, 2, pointerCount, 1.0f, true);
            assertDecision(CONSUME_NOOP, 2, pointerCount, 1.25f, false);
            assertDecision(EXIT, 2, pointerCount, 1.25f, true);
        }
    }

    @Test
    public void taskCountsOneThreeAndFourAreNeverClaimed() {
        int[] taskCounts = {1, 3, 4};
        float[] scales = {0.75f, 1.0f, 1.25f};
        for (int taskCount : taskCounts) {
            for (int pointerCount : new int[]{4, 5}) {
                for (float scaleFactor : scales) {
                    for (boolean active : new boolean[]{false, true}) {
                        assertDecision(NOT_HANDLED, taskCount, pointerCount,
                                scaleFactor, active);
                    }
                }
            }
        }
    }

    @Test
    public void pointerCountsOneThroughThreeAreNeverClaimed() {
        for (int pointerCount = 1; pointerCount <= 3; pointerCount++) {
            for (float scaleFactor : new float[]{0.75f, 1.0f, 1.25f}) {
                for (boolean active : new boolean[]{false, true}) {
                    assertDecision(NOT_HANDLED, 2, pointerCount, scaleFactor, active);
                }
            }
        }
    }

    @Test
    public void nonFiniteZeroAndNegativeScalesAreNeverClaimed() {
        float[] invalidScales = {
                Float.NaN,
                Float.POSITIVE_INFINITY,
                Float.NEGATIVE_INFINITY,
                0.0f,
                -0.0f,
                -0.25f,
                -Float.MAX_VALUE
        };
        for (float scaleFactor : invalidScales) {
            for (boolean active : new boolean[]{false, true}) {
                assertDecision(NOT_HANDLED, 2, 4, scaleFactor, active);
            }
        }
    }

    @Test
    public void unavailableCapabilityOrManagerIsNeverClaimed() {
        for (boolean capabilityAvailable : new boolean[]{false, true}) {
            for (boolean managerAvailable : new boolean[]{false, true}) {
                TwoTaskPanoramaFeature.Decision expected =
                        capabilityAvailable && managerAvailable ? ENTER : NOT_HANDLED;
                assertEquals(expected, TwoTaskPanoramaFeature.decide(
                        capabilityAvailable, managerAvailable, 2, 4, 0.75f, false));
            }
        }
    }

    @Test
    public void enterActionRemainsHandledWhenPostActionStateReadFails() {
        ScriptedBackend backend = new ScriptedBackend(false);
        backend.failActiveReadNumber = 2;

        boolean handled = handle(backend, 0.75f);

        assertTrue(handled);
        assertEquals(Arrays.asList(
                "getAdapter", "getCount", "manager", "active", "enter:true", "active"),
                backend.calls);
        assertEquals(1, backend.enterCalls);
        assertEquals(0, backend.exitCalls);
    }

    @Test
    public void exitActionRemainsHandledAndAlwaysClearsDirectionalGuardWhenDiagnosticFails()
            throws Exception {
        ThreadLocal<Boolean> directionalExitAllowed = directionalExitAllowed();
        assertNull(directionalExitAllowed.get());
        ScriptedBackend backend = new ScriptedBackend(true);
        backend.failActiveReadNumber = 2;
        backend.directionalExitAllowed = directionalExitAllowed;

        boolean handled = handle(backend, 1.25f);

        assertTrue(handled);
        assertEquals(Arrays.asList(
                "getAdapter", "getCount", "manager", "active", "exit:true", "active"),
                backend.calls);
        assertEquals(0, backend.enterCalls);
        assertEquals(1, backend.exitCalls);
        assertTrue(backend.directionalGuardSeenDuringExit);
        assertNull(directionalExitAllowed.get());
    }

    @Test
    public void enterActionFailureFallsBackWithoutPostActionRead() {
        ScriptedBackend backend = new ScriptedBackend(false);
        backend.failEnter = true;

        boolean handled = handle(backend, 0.75f);

        assertFalse(handled);
        assertEquals(Arrays.asList(
                "getAdapter", "getCount", "manager", "active", "enter:true"),
                backend.calls);
        assertEquals(1, backend.enterCalls);
        assertEquals(0, backend.exitCalls);
    }

    @Test
    public void exitActionFailureFallsBackAndStillClearsDirectionalGuard() throws Exception {
        ThreadLocal<Boolean> directionalExitAllowed = directionalExitAllowed();
        assertNull(directionalExitAllowed.get());
        ScriptedBackend backend = new ScriptedBackend(true);
        backend.failExit = true;
        backend.directionalExitAllowed = directionalExitAllowed;

        boolean handled = handle(backend, 1.25f);

        assertFalse(handled);
        assertEquals(Arrays.asList(
                "getAdapter", "getCount", "manager", "active", "exit:true"),
                backend.calls);
        assertEquals(0, backend.enterCalls);
        assertEquals(1, backend.exitCalls);
        assertTrue(backend.directionalGuardSeenDuringExit);
        assertNull(directionalExitAllowed.get());
    }

    @Test
    public void runtimeSourceUsesOnlyBehaviorNamedOemPathWithoutDeclaringHooks()
            throws IOException {
        String source = source();

        assertTrue(source.contains(
                "reflectionAccess.callMethod(containerView, \"getAdapter\")"));
        assertTrue(source.contains(
                "reflectionAccess.callMethod(adapter, \"getCount\")"));
        assertTrue(source.contains(
                "reflectionAccess.callMethod(containerView, managerGetter)"));
        assertTrue(source.contains(
                "reflectionAccess.callMethod(manager, enterMethod, true)"));
        assertTrue(source.contains(
                "PanoramaFeature.exitDirectionally(manager, reflectionAccess, exitMethod)"));
        assertTrue(source.contains("[TwoTaskPanorama]"));
        assertFalse(source.contains("hookRegistry.declare("));
        assertFalse(source.contains("findAndHookMethod("));
        assertFalse(source.contains("502"));
        assertFalse(source.matches("(?s).*260\\d{3}.*"));
    }

    private static void assertDecision(TwoTaskPanoramaFeature.Decision expected,
                                       int taskCount, int pointerCount,
                                       float scaleFactor, boolean active) {
        assertEquals(expected, TwoTaskPanoramaFeature.decide(
                true, true, taskCount, pointerCount, scaleFactor, active));
    }

    private static boolean handle(ScriptedBackend backend, float scaleFactor) {
        return TwoTaskPanoramaFeature.handleDirectionalScale(
                backend.container, scaleFactor, 4, true,
                new ReflectionAccess(backend), "manager", "active", "enter", "exit");
    }

    @SuppressWarnings("unchecked")
    private static ThreadLocal<Boolean> directionalExitAllowed() throws Exception {
        Field field = PanoramaFeature.class.getDeclaredField("DIRECTIONAL_EXIT_ALLOWED");
        field.setAccessible(true);
        return (ThreadLocal<Boolean>) field.get(null);
    }

    private static String source() throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve(
                "app/src/main/java/com/color/pscanvasfix/feature/TwoTaskPanoramaFeature.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/feature/TwoTaskPanoramaFeature.java");
        }
        return new String(Files.readAllBytes(source), StandardCharsets.UTF_8)
                .replace("\r\n", "\n");
    }

    private static final class ScriptedBackend implements ReflectionAccess.Backend {
        final Object container = new Object();
        final Object adapter = new Object();
        final Object manager = new Object();
        final List<String> calls = new ArrayList<>();
        boolean active;
        int activeReads;
        int failActiveReadNumber;
        int enterCalls;
        int exitCalls;
        boolean failEnter;
        boolean failExit;
        boolean directionalGuardSeenDuringExit;
        ThreadLocal<Boolean> directionalExitAllowed;

        ScriptedBackend(boolean active) {
            this.active = active;
        }

        @Override
        public Object callMethod(Object receiver, String methodName, Object... args) {
            if (receiver == container && "getAdapter".equals(methodName)) {
                calls.add("getAdapter");
                return adapter;
            }
            if (receiver == adapter && "getCount".equals(methodName)) {
                calls.add("getCount");
                return Integer.valueOf(2);
            }
            if (receiver == container && "manager".equals(methodName)) {
                calls.add("manager");
                return manager;
            }
            if (receiver == manager && "active".equals(methodName)) {
                calls.add("active");
                activeReads++;
                if (activeReads == failActiveReadNumber) {
                    throw new IllegalStateException("active read failure " + activeReads);
                }
                return Boolean.valueOf(active);
            }
            if (receiver == manager && "enter".equals(methodName)) {
                calls.add("enter:" + args[0]);
                enterCalls++;
                if (failEnter) {
                    throw new IllegalStateException("enter failure");
                }
                active = true;
                return null;
            }
            if (receiver == manager && "exit".equals(methodName)) {
                calls.add("exit:" + args[0]);
                exitCalls++;
                directionalGuardSeenDuringExit = directionalExitAllowed != null
                        && Boolean.TRUE.equals(directionalExitAllowed.get());
                if (failExit) {
                    throw new IllegalStateException("exit failure");
                }
                active = false;
                return null;
            }
            throw new AssertionError("Unexpected call " + methodName);
        }

        @Override
        public Class<?> findClass(String className, ClassLoader classLoader) {
            throw new AssertionError("Unexpected findClass");
        }

        @Override
        public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
            throw new AssertionError("Unexpected callStaticMethod");
        }

        @Override
        public Object newInstance(Class<?> owner, Object... args) {
            throw new AssertionError("Unexpected newInstance");
        }

        @Override
        public boolean getBooleanField(Object target, String fieldName) {
            throw new AssertionError("Unexpected getBooleanField");
        }

        @Override
        public void setBooleanField(Object target, String fieldName, boolean value) {
            throw new AssertionError("Unexpected setBooleanField");
        }

        @Override
        public int getIntField(Object target, String fieldName) {
            throw new AssertionError("Unexpected getIntField");
        }

        @Override
        public void setIntField(Object target, String fieldName, int value) {
            throw new AssertionError("Unexpected setIntField");
        }

        @Override
        public float getFloatField(Object target, String fieldName) {
            throw new AssertionError("Unexpected getFloatField");
        }

        @Override
        public Object getObjectField(Object target, String fieldName) {
            throw new AssertionError("Unexpected getObjectField");
        }

        @Override
        public void setObjectField(Object target, String fieldName, Object value) {
            throw new AssertionError("Unexpected setObjectField");
        }

        @Override
        public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
            throw new AssertionError("Unexpected getStaticBooleanField");
        }

        @Override
        public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
            throw new AssertionError("Unexpected setStaticBooleanField");
        }
    }
}
