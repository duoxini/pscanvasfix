package com.color.pscanvasfix.compat;

import com.color.pscanvasfix.runtime.ReflectionAccess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public final class ObfFieldCompatTest {
    private RecordingBackend backend;
    private Object target;

    @Before
    public void setUp() {
        backend = new RecordingBackend();
        target = new Object();
        ObfFieldCompat.setReflectionAccessForTests(new ReflectionAccess(backend));
    }

    @After
    public void tearDown() {
        ObfFieldCompat.resetReflectionAccessForTests();
    }

    @Test
    public void usesPrimaryThenFallbackWithoutChangingTypedValues() {
        AssertionError missingPrimary = new AssertionError("missing primary");
        backend.enqueue("getBoolean:primary", missingPrimary);
        backend.enqueue("getBoolean:fallback", Boolean.FALSE);
        backend.enqueue("setInt:primary", missingPrimary);

        assertFalse(ObfFieldCompat.getBoolean(target, "primary", "fallback", true));
        ObfFieldCompat.setInt(target, "primary", "fallback", 9);

        assertEquals(Arrays.asList(
                "getBoolean:primary",
                "getBoolean:fallback",
                "setInt:primary:9",
                "setInt:fallback:9"), backend.calls);
    }

    @Test
    public void preservesPrimaryAndFallbackExceptionBoundaries() {
        AssertionError primaryFailure = new AssertionError("primary");
        backend.enqueue("getInt:primary", primaryFailure);

        AssertionError actualPrimary = assertThrows(AssertionError.class,
                () -> ObfFieldCompat.getInt(target, "primary", null));
        assertSame(primaryFailure, actualPrimary);

        AssertionError firstFailure = new AssertionError("first");
        AssertionError fallbackFailure = new AssertionError("fallback");
        backend.enqueue("setObject:primary", firstFailure);
        backend.enqueue("setObject:fallback", fallbackFailure);

        AssertionError actualFallback = assertThrows(AssertionError.class,
                () -> ObfFieldCompat.setObject(
                        target, "primary", "fallback", new Object()));
        assertSame(fallbackFailure, actualFallback);
    }

    @Test
    public void staticBooleanSetterKeepsQuietFallbackAndTerminalException() {
        backend.enqueue("setStaticBoolean:primary", new AssertionError("primary"));

        ObfFieldCompat.setStaticBoolean(Object.class, "primary", "fallback", true);
        assertEquals(Arrays.asList(
                "setStaticBoolean:primary:true",
                "setStaticBoolean:fallback:true"), backend.calls);

        backend.calls.clear();
        backend.enqueue("setStaticBoolean:primary", new AssertionError("primary"));
        backend.enqueue("setStaticBoolean:fallback", new AssertionError("fallback"));
        IllegalStateException failure = assertThrows(IllegalStateException.class,
                () -> ObfFieldCompat.setStaticBoolean(
                        Object.class, "primary", "fallback", false));
        assertEquals("setStaticBoolean failed for primary/fallback", failure.getMessage());
    }

    @Test
    public void gestureAccessKeepsNamedFieldOrderAndRepeatedFallback() {
        backend.enqueue("setStaticBoolean:f10934L", new AssertionError("jadx missing"));

        ObfFieldCompat.setGestureSplitEnabled(Object.class, true);
        assertEquals(Arrays.asList(
                "setStaticBoolean:f10934L:true",
                "setStaticBoolean:L:true"), backend.calls);

        backend.calls.clear();
        backend.enqueue("getStaticBoolean:f10934L",
                new AssertionError("first jadx read missing"), Boolean.TRUE);
        backend.enqueue("getStaticBoolean:L", new AssertionError("short name missing"));

        assertTrue(ObfFieldCompat.getGestureSplitEnabled(Object.class, false));
        assertEquals(Arrays.asList(
                "getStaticBoolean:f10934L",
                "getStaticBoolean:L",
                "getStaticBoolean:f10934L"), backend.calls);
    }

    @Test
    public void nullGestureClassReturnsDefaultWithoutBackendCalls() {
        assertTrue(ObfFieldCompat.getGestureSplitEnabled(null, true));
        ObfFieldCompat.setGestureSplitEnabled(null, false);
        assertTrue(backend.calls.isEmpty());
    }

    private static final class RecordingBackend implements ReflectionAccess.Backend {
        final List<String> calls = new ArrayList<>();
        final Map<String, Deque<Object>> outcomes = new HashMap<>();

        void enqueue(String key, Object... values) {
            outcomes.computeIfAbsent(key, ignored -> new ArrayDeque<>())
                    .addAll(Arrays.asList(values));
        }

        @Override
        public Class<?> findClass(String className, ClassLoader classLoader) {
            throw new AssertionError("Unexpected class lookup");
        }

        @Override
        public Object callMethod(Object receiver, String methodName, Object... args) {
            throw new AssertionError("Unexpected method call");
        }

        @Override
        public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
            throw new AssertionError("Unexpected static method call");
        }

        @Override
        public Object newInstance(Class<?> owner, Object... args) {
            throw new AssertionError("Unexpected constructor access");
        }

        @Override
        public boolean getBooleanField(Object target, String fieldName) {
            calls.add("getBoolean:" + fieldName);
            return (Boolean) outcome("getBoolean:" + fieldName, Boolean.TRUE);
        }

        @Override
        public void setBooleanField(Object target, String fieldName, boolean value) {
            calls.add("setBoolean:" + fieldName + ":" + value);
            outcome("setBoolean:" + fieldName, null);
        }

        @Override
        public int getIntField(Object target, String fieldName) {
            calls.add("getInt:" + fieldName);
            return (Integer) outcome("getInt:" + fieldName, Integer.valueOf(7));
        }

        @Override
        public void setIntField(Object target, String fieldName, int value) {
            calls.add("setInt:" + fieldName + ":" + value);
            outcome("setInt:" + fieldName, null);
        }

        @Override
        public float getFloatField(Object target, String fieldName) {
            calls.add("getFloat:" + fieldName);
            return (Float) outcome("getFloat:" + fieldName, Float.valueOf(1.5f));
        }

        @Override
        public Object getObjectField(Object target, String fieldName) {
            calls.add("getObject:" + fieldName);
            return outcome("getObject:" + fieldName, target);
        }

        @Override
        public void setObjectField(Object target, String fieldName, Object value) {
            calls.add("setObject:" + fieldName);
            outcome("setObject:" + fieldName, null);
        }

        @Override
        public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
            calls.add("getStaticBoolean:" + fieldName);
            return (Boolean) outcome("getStaticBoolean:" + fieldName, Boolean.TRUE);
        }

        @Override
        public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
            calls.add("setStaticBoolean:" + fieldName + ":" + value);
            outcome("setStaticBoolean:" + fieldName, null);
        }

        private Object outcome(String key, Object defaultValue) {
            Deque<Object> values = outcomes.get(key);
            Object value = values == null || values.isEmpty()
                    ? defaultValue : values.removeFirst();
            if (value instanceof Error) {
                throw (Error) value;
            }
            if (value instanceof RuntimeException) {
                throw (RuntimeException) value;
            }
            return value;
        }
    }
}
