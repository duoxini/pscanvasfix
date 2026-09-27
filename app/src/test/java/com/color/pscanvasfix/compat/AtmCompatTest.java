package com.color.pscanvasfix.compat;

import com.color.pscanvasfix.runtime.ReflectionAccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

public final class AtmCompatTest {
    private RecordingBackend backend;
    private ClassLoader classLoader;

    @Before
    public void setUp() {
        backend = new RecordingBackend();
        classLoader = new ClassLoader() { };
        FakeActivityTaskManager.instance = backend.service;
        FakeActivityTaskManager.service = backend.service;
        AtmCompat.setReflectionAccessForTests(new ReflectionAccess(backend));
    }

    @After
    public void tearDown() {
        FakeActivityTaskManager.instance = null;
        FakeActivityTaskManager.service = null;
        AtmCompat.resetReflectionAccessForTests();
    }

    @Test
    public void oneArgumentGetTasksFallsBackToTwoArgumentsInOrder() {
        backend.failOneArgumentGetTasks = true;
        backend.tasksResult = Arrays.asList("first", "second");

        List<?> result = AtmCompat.getTasks(classLoader, 8);

        assertEquals(backend.tasksResult, result);
        assertEquals(Arrays.asList(
                "find:android.app.ActivityTaskManager",
                "call:getTasks:[8]",
                "call:getTasks:[8, false]"), backend.calls);
    }

    @Test
    public void twoArgumentGetTasksFallbackFailureStillPropagates() {
        assertSame(backend.service, AtmCompat.getAtm(classLoader));
        backend.calls.clear();
        backend.failOneArgumentGetTasks = true;
        AssertionError fallbackFailure = new AssertionError("fallback failed");
        backend.failure = fallbackFailure;

        AssertionError actual = assertThrows(AssertionError.class,
                () -> AtmCompat.getTasks(classLoader, 8));

        assertSame(fallbackFailure, actual);
        assertEquals(Arrays.asList(
                "call:getTasks:[8]",
                "call:getTasks:[8, false]"), backend.calls);
    }

    @Test
    public void directTaskQueriesKeepArgumentsReturnsAndFailureBoundary() {
        backend.tasksResult = Collections.singletonList("task");

        assertEquals(backend.tasksResult, AtmCompat.getTasks(classLoader, 5, true));
        assertEquals(backend.tasksResult, AtmCompat.getRecentTasks(classLoader, 6, 7, 8));

        backend.failure = new AssertionError("query failed");
        AssertionError actual = assertThrows(AssertionError.class,
                () -> AtmCompat.getTasks(classLoader, 5, false));
        assertSame(backend.failure, actual);
    }

    @Test
    public void recentTasksFailureStillPropagates() {
        assertSame(backend.service, AtmCompat.getAtm(classLoader));
        backend.calls.clear();
        AssertionError failure = new AssertionError("recent query failed");
        backend.failure = failure;

        AssertionError actual = assertThrows(AssertionError.class,
                () -> AtmCompat.getRecentTasks(classLoader, 6, 7, 8));

        assertSame(failure, actual);
        assertEquals(Collections.singletonList("call:getRecentTasks:[6, 7, 8]"),
                backend.calls);
    }

    @Test
    public void actionMethodsKeepValidationSequenceAndCatchBoundary() {
        assertFalse(AtmCompat.setFocusedTask(classLoader, 0));
        assertFalse(AtmCompat.moveTaskToBack(classLoader, -1));
        assertFalse(AtmCompat.removeTask(classLoader, 0));
        assertTrue(backend.calls.isEmpty());

        assertTrue(AtmCompat.setFocusedTask(classLoader, 10));
        assertTrue(AtmCompat.moveTaskToBack(classLoader, 11));
        assertTrue(AtmCompat.removeTask(classLoader, 12));
        assertEquals(Arrays.asList(
                "find:android.app.ActivityTaskManager",
                "call:setFocusedTask:[10]",
                "find:android.app.OplusActivityTaskManager",
                "static:getInstance:[]",
                "call:moveTaskToBack:[11, true]",
                "find:android.app.ActivityTaskManager",
                "call:removeTask:[12]"), backend.calls);

        backend.failure = new AssertionError("action failed");
        assertFalse(AtmCompat.setFocusedTask(classLoader, 13));
    }

    @Test
    public void getAtmCachesPerClassLoaderAndFallsBackToDeclaredGetService() {
        FakeActivityTaskManager.instance = null;
        Object expected = backend.service;

        assertSame(expected, AtmCompat.getAtm(classLoader));
        assertSame(expected, AtmCompat.getAtm(classLoader));
        assertEquals(Collections.singletonList("find:android.app.ActivityTaskManager"),
                backend.calls);

        ClassLoader secondLoader = new ClassLoader() { };
        assertSame(expected, AtmCompat.getAtm(secondLoader));
        assertEquals(Arrays.asList(
                "find:android.app.ActivityTaskManager",
                "find:android.app.ActivityTaskManager"), backend.calls);
    }

    public static final class FakeActivityTaskManager {
        static Object instance;
        static Object service;

        public static Object getInstance() {
            return instance;
        }

        public static Object getService() {
            return service;
        }
    }

    private static final class RecordingBackend implements ReflectionAccess.Backend {
        final Object service = new Object();
        final Object manager = new Object();
        final List<String> calls = new ArrayList<>();
        List<?> tasksResult = Collections.emptyList();
        boolean failOneArgumentGetTasks;
        AssertionError failure;

        @Override
        public Class<?> findClass(String className, ClassLoader classLoader) {
            calls.add("find:" + className);
            maybeFail();
            return FakeActivityTaskManager.class;
        }

        @Override
        public Object callMethod(Object receiver, String methodName, Object... args) {
            calls.add("call:" + methodName + ":" + Arrays.toString(args));
            if (failOneArgumentGetTasks && "getTasks".equals(methodName)
                    && args.length == 1) {
                throw new AssertionError("one-argument getTasks failed");
            }
            maybeFail();
            if ("getTasks".equals(methodName) || "getRecentTasks".equals(methodName)) {
                return tasksResult;
            }
            return null;
        }

        @Override
        public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
            calls.add("static:" + methodName + ":" + Arrays.toString(args));
            maybeFail();
            return manager;
        }

        @Override
        public Object newInstance(Class<?> owner, Object... args) {
            throw new AssertionError("Unexpected constructor access");
        }

        @Override
        public boolean getBooleanField(Object target, String fieldName) {
            throw unexpectedFieldAccess();
        }

        @Override
        public void setBooleanField(Object target, String fieldName, boolean value) {
            throw unexpectedFieldAccess();
        }

        @Override
        public int getIntField(Object target, String fieldName) {
            throw unexpectedFieldAccess();
        }

        @Override
        public void setIntField(Object target, String fieldName, int value) {
            throw unexpectedFieldAccess();
        }

        @Override
        public float getFloatField(Object target, String fieldName) {
            throw unexpectedFieldAccess();
        }

        @Override
        public Object getObjectField(Object target, String fieldName) {
            throw unexpectedFieldAccess();
        }

        @Override
        public void setObjectField(Object target, String fieldName, Object value) {
            throw unexpectedFieldAccess();
        }

        @Override
        public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
            throw unexpectedFieldAccess();
        }

        @Override
        public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
            throw unexpectedFieldAccess();
        }

        private AssertionError unexpectedFieldAccess() {
            return new AssertionError("Unexpected field access");
        }

        private void maybeFail() {
            if (failure != null) {
                throw failure;
            }
        }
    }
}
