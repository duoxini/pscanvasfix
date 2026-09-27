package com.color.pscanvasfix.compat;

import com.color.pscanvasfix.runtime.ReflectionAccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** Source-contract regression for the project-owned modern hook callback adapter. */
public final class SplitBar502CompatTest {
    private ResizeStateBackend backend;
    private FakeContainerView containerView;

    @Before
    public void setUp() {
        backend = new ResizeStateBackend();
        containerView = new FakeContainerView();
        ThreeSplitTouch502Compat.setReflectionAccessForTests(new ReflectionAccess(backend));
        SplitPolicyCompat.clearTransitionActive();
    }

    @After
    public void tearDown() {
        SplitPolicyCompat.clearTransitionActive();
        ThreeSplitTouch502Compat.resetReflectionAccessForTests();
    }

    @Test
    public void sevenCallsUseReflectionAccessInOriginalOrder() throws IOException {
        String source = source();

        assertFalse(source.contains("XposedHelpers"));
        assertEquals(7, occurrences(source, "reflectionAccess.callMethod("));
        assertInOrder(source,
                "reflectionAccess.callMethod(containerView, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(decor, \"getParent\")",
                "reflectionAccess.callMethod(parent, \"getAdapter\")",
                "reflectionAccess.callMethod(adapter, \"n\")",
                "reflectionAccess.callMethod(decor, \"getTaskData\")",
                "reflectionAccess.callMethod(taskData, \"n\")");
    }

    @Test
    public void preservesBranchesEarlyReturnsResultsAndCatchBoundaries() throws IOException {
        String source = source();

        assertTrue(source.contains("if (adapter != null)"));
        assertEquals(2, occurrences(source, "if (layout >= 4 && layout <= 7)"));
        assertTrue(source.contains("if (parent == null) return;"));
        assertTrue(source.contains("if (adapter == null) return;"));
        assertTrue(source.contains("if (taskData != null)"));
        assertTrue(source.contains("param.setResult(normalRect);"));
        assertEquals(5, occurrences(source, "param.setResult(null);"));
        assertTrue(source.contains("catch (Throwable ignored)"));
        assertTrue(source.contains("catch (Throwable t)"));
        assertTrue(source.contains(
                "PsCanvasLog.e(\"blockPanoramaLaunchRectOverride failed\", t);"));
    }

    @Test
    public void preservesPublicHookApiAndIsolatedTestInjection() throws IOException {
        String source = source();

        assertEquals(7, occurrences(source, "public static void block"));
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
        assertTrue(source.contains("import com.color.pscanvasfix.runtime.HookCall;"));
        assertEquals(7, occurrences(source, "HookCall param"));
        assertEquals(0, occurrences(source, "de.robv.android.xposed"));
        assertEquals(0, occurrences(source, "XC_MethodHook"));
    }

    @Test
    public void equalAndHorizontalVerticalEnlargedLayoutsReleaseResizeWhenPanoramaInactive() {
        backend.panoramaActive = false;

        for (int layout : new int[]{3, 4, 5, 6, 7}) {
            backend.layout = layout;
            backend.calls.clear();
            assertEquals("layout=" + layout,
                    ThreeSplitTouch502Compat.ThreeTaskResizeState.NORMAL,
                    ThreeSplitTouch502Compat.resolveThreeTaskResizeState(containerView));
            assertTrue("manager must decide layout=" + layout,
                    backend.calls.contains("call:M"));
            assertTrue("layout=" + layout,
                    SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, true));
            assertFalse("preference disabled layout=" + layout,
                    SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, false));
        }
    }

    @Test
    public void panoramaManagerActiveBlocksEveryThreeTaskLayout() {
        backend.panoramaActive = true;

        for (int layout : new int[]{3, 4, 5, 6, 7}) {
            backend.layout = layout;
            assertEquals("layout=" + layout,
                    ThreeSplitTouch502Compat.ThreeTaskResizeState.BLOCKED,
                    ThreeSplitTouch502Compat.resolveThreeTaskResizeState(containerView));
            assertFalse("layout=" + layout,
                    SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, true));
        }
    }

    @Test
    public void transitionBlocksBeforeAnyResizeStateReflection() {
        SplitPolicyCompat.markTransitionActive(true);

        for (int layout : new int[]{3, 4, 5, 6, 7}) {
            backend.layout = layout;
            backend.calls.clear();
            assertFalse("layout=" + layout,
                    SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, true));
            assertTrue("layout=" + layout, backend.calls.isEmpty());
        }
    }

    @Test
    public void unknownOrFailedCountLayoutAndPanoramaStateFailClosed() {
        for (String method : Arrays.asList(
                "getAdapter", "getCount", "n", "getPanoramaModeManager", "M")) {
            backend.failureMethod = method;
            assertEquals("failure at " + method,
                    ThreeSplitTouch502Compat.ThreeTaskResizeState.UNKNOWN,
                    ThreeSplitTouch502Compat.resolveThreeTaskResizeState(containerView));
            assertFalse("failure at " + method,
                    SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, true));
        }

        backend.failureMethod = null;
        backend.adapter = null;
        assertUnknownAndBlocked();
        backend.adapter = new Object();
        backend.count = "unknown";
        assertUnknownAndBlocked();
        backend.count = 3;
        backend.layout = "unknown";
        assertUnknownAndBlocked();
        backend.layout = 3;
        backend.panoramaManager = null;
        assertUnknownAndBlocked();
        backend.panoramaManager = new Object();
        backend.panoramaActive = "unknown";
        assertUnknownAndBlocked();

        backend.panoramaActive = false;
        backend.count = 2;
        assertEquals(ThreeSplitTouch502Compat.ThreeTaskResizeState.BLOCKED,
                ThreeSplitTouch502Compat.resolveThreeTaskResizeState(containerView));
        assertFalse(SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, true));

        backend.count = 3;
        for (int invalidLayout : new int[]{2, 8}) {
            backend.layout = invalidLayout;
            assertUnknownAndBlocked();
        }
    }

    private void assertUnknownAndBlocked() {
        assertEquals(ThreeSplitTouch502Compat.ThreeTaskResizeState.UNKNOWN,
                ThreeSplitTouch502Compat.resolveThreeTaskResizeState(containerView));
        assertFalse(SplitBar502Compat.shouldPreserveOemThreeTaskResize(containerView, true));
    }

    private static final class FakeContainerView {
    }

    private static final class ResizeStateBackend implements ReflectionAccess.Backend {
        Object adapter = new Object();
        Object panoramaManager = new Object();
        final List<String> calls = new ArrayList<>();
        Object count = 3;
        Object layout = 3;
        Object panoramaActive = false;
        String failureMethod;

        @Override
        public Class<?> findClass(String className, ClassLoader classLoader) {
            throw unexpected("findClass");
        }

        @Override
        public Object callMethod(Object receiver, String methodName, Object... args) {
            calls.add("call:" + methodName);
            if (methodName.equals(failureMethod)) {
                throw new IllegalStateException("failed " + methodName);
            }
            if ("getAdapter".equals(methodName)) {
                return adapter;
            }
            if ("getCount".equals(methodName)) {
                return count;
            }
            if ("n".equals(methodName)) {
                return layout;
            }
            if ("getPanoramaModeManager".equals(methodName)) {
                return panoramaManager;
            }
            if ("M".equals(methodName)) {
                return panoramaActive;
            }
            throw unexpected(methodName);
        }

        @Override
        public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
            throw unexpected("callStaticMethod");
        }

        @Override
        public Object newInstance(Class<?> owner, Object... args) {
            throw unexpected("newInstance");
        }

        @Override
        public boolean getBooleanField(Object target, String fieldName) {
            throw unexpected("getBooleanField");
        }

        @Override
        public void setBooleanField(Object target, String fieldName, boolean value) {
            throw unexpected("setBooleanField");
        }

        @Override
        public int getIntField(Object target, String fieldName) {
            throw unexpected("getIntField");
        }

        @Override
        public void setIntField(Object target, String fieldName, int value) {
            throw unexpected("setIntField");
        }

        @Override
        public float getFloatField(Object target, String fieldName) {
            throw unexpected("getFloatField");
        }

        @Override
        public Object getObjectField(Object target, String fieldName) {
            throw unexpected("getObjectField");
        }

        @Override
        public void setObjectField(Object target, String fieldName, Object value) {
            throw unexpected("setObjectField");
        }

        @Override
        public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
            throw unexpected("getStaticBooleanField");
        }

        @Override
        public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
            throw unexpected("setStaticBooleanField");
        }

        private AssertionError unexpected(String operation) {
            return new AssertionError("Unexpected reflection operation: " + operation);
        }
    }

    private static String source() throws IOException {
        Path root = Paths.get(System.getProperty("user.dir"));
        Path source = root.resolve(
                "app/src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java");
        if (!Files.isRegularFile(source)) {
            source = root.resolve(
                    "src/main/java/com/color/pscanvasfix/compat/SplitBar502Compat.java");
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
