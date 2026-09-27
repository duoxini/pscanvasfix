package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public final class ReflectionAccessTest {
    @Test
    public void forwardsReceiversOwnersArgumentsAndResultsWithoutRewriting() {
        RecordingBackend backend = new RecordingBackend();
        ReflectionAccess access = new ReflectionAccess(backend);
        ClassLoader loader = new ClassLoader() { };
        Object receiver = new Object();

        assertSame(String.class, access.findClass("target.Type", loader));
        assertSame(backend.instanceResult,
                access.callMethod(receiver, "instance", Integer.valueOf(7), Boolean.TRUE));
        assertSame(backend.staticResult,
                access.callStaticMethod(Long.class, "staticMethod", new Object[0]));
        assertSame(backend.constructorResult,
                access.newInstance(ArrayList.class, Integer.valueOf(3), "seed"));

        assertEquals("target.Type", backend.className);
        assertSame(loader, backend.classLoader);
        assertSame(receiver, backend.receiver);
        assertEquals("instance", backend.instanceMethodName);
        assertArrayEquals(new Object[]{Integer.valueOf(7), Boolean.TRUE}, backend.instanceArgs);
        assertSame(Long.class, backend.owner);
        assertEquals("staticMethod", backend.staticMethodName);
        assertEquals(0, backend.staticArgs.length);
        assertSame(ArrayList.class, backend.constructorOwner);
        assertArrayEquals(new Object[]{Integer.valueOf(3), "seed"},
                backend.constructorArgs);

        assertTrue(access.getBooleanField(receiver, "booleanField"));
        access.setBooleanField(receiver, "booleanField", false);
        assertEquals(7, access.getIntField(receiver, "intField"));
        access.setIntField(receiver, "intField", 8);
        assertEquals(1.5f, access.getFloatField(receiver, "floatField"), 0f);
        assertSame(backend.objectFieldResult,
                access.getObjectField(receiver, "objectField"));
        access.setObjectField(receiver, "objectField", backend.objectFieldValue);
        assertTrue(access.getStaticBooleanField(Long.class, "staticBooleanField"));
        access.setStaticBooleanField(Long.class, "staticBooleanField", false);
        assertEquals(Arrays.asList(
                "getBoolean:booleanField",
                "setBoolean:booleanField:false",
                "getInt:intField",
                "setInt:intField:8",
                "getFloat:floatField",
                "getObject:objectField",
                "setObject:objectField",
                "getStaticBoolean:staticBooleanField",
                "setStaticBoolean:staticBooleanField:false"), backend.fieldCalls);
    }

    @Test
    public void propagatesBackendErrorsWithoutWrapping() {
        AssertionError failure = new AssertionError("failure");
        ReflectionAccess access = new ReflectionAccess(new ThrowingBackend(failure));

        AssertionError findFailure = assertThrows(AssertionError.class,
                () -> access.findClass("target.Type", getClass().getClassLoader()));
        AssertionError instanceFailure = assertThrows(AssertionError.class,
                () -> access.callMethod(new Object(), "method", Integer.valueOf(1)));
        AssertionError staticFailure = assertThrows(AssertionError.class,
                () -> access.callStaticMethod(Long.class, "staticMethod"));
        AssertionError constructorFailure = assertThrows(AssertionError.class,
                () -> access.newInstance(ArrayList.class, Integer.valueOf(2)));

        assertSame(failure, findFailure);
        assertSame(failure, instanceFailure);
        assertSame(failure, staticFailure);
        assertSame(failure, constructorFailure);
    }

    private static final class RecordingBackend implements ReflectionAccess.Backend {
        final Object instanceResult = new Object();
        final Object staticResult = new Object();
        final Object constructorResult = new Object();
        final Object objectFieldResult = new Object();
        final Object objectFieldValue = new Object();
        final List<String> fieldCalls = new ArrayList<>();
        String className;
        ClassLoader classLoader;
        Object receiver;
        String instanceMethodName;
        Object[] instanceArgs;
        Class<?> owner;
        String staticMethodName;
        Object[] staticArgs;
        Class<?> constructorOwner;
        Object[] constructorArgs;

        @Override
        public Class<?> findClass(String className, ClassLoader classLoader) {
            this.className = className;
            this.classLoader = classLoader;
            return String.class;
        }

        @Override
        public Object callMethod(Object receiver, String methodName, Object... args) {
            this.receiver = receiver;
            this.instanceMethodName = methodName;
            this.instanceArgs = args;
            return instanceResult;
        }

        @Override
        public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
            this.owner = owner;
            this.staticMethodName = methodName;
            this.staticArgs = args;
            return staticResult;
        }

        @Override
        public Object newInstance(Class<?> owner, Object... args) {
            this.constructorOwner = owner;
            this.constructorArgs = args;
            return constructorResult;
        }

        @Override
        public boolean getBooleanField(Object target, String fieldName) {
            fieldCalls.add("getBoolean:" + fieldName);
            return true;
        }

        @Override
        public void setBooleanField(Object target, String fieldName, boolean value) {
            fieldCalls.add("setBoolean:" + fieldName + ":" + value);
        }

        @Override
        public int getIntField(Object target, String fieldName) {
            fieldCalls.add("getInt:" + fieldName);
            return 7;
        }

        @Override
        public void setIntField(Object target, String fieldName, int value) {
            fieldCalls.add("setInt:" + fieldName + ":" + value);
        }

        @Override
        public float getFloatField(Object target, String fieldName) {
            fieldCalls.add("getFloat:" + fieldName);
            return 1.5f;
        }

        @Override
        public Object getObjectField(Object target, String fieldName) {
            fieldCalls.add("getObject:" + fieldName);
            return objectFieldResult;
        }

        @Override
        public void setObjectField(Object target, String fieldName, Object value) {
            assertSame(objectFieldValue, value);
            fieldCalls.add("setObject:" + fieldName);
        }

        @Override
        public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
            assertSame(Long.class, owner);
            fieldCalls.add("getStaticBoolean:" + fieldName);
            return true;
        }

        @Override
        public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
            assertSame(Long.class, owner);
            fieldCalls.add("setStaticBoolean:" + fieldName + ":" + value);
        }
    }

    private static final class ThrowingBackend implements ReflectionAccess.Backend {
        private final AssertionError failure;

        ThrowingBackend(AssertionError failure) {
            this.failure = failure;
        }

        @Override
        public Class<?> findClass(String className, ClassLoader classLoader) {
            throw failure;
        }

        @Override
        public Object callMethod(Object receiver, String methodName, Object... args) {
            throw failure;
        }

        @Override
        public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
            throw failure;
        }

        @Override
        public Object newInstance(Class<?> owner, Object... args) {
            throw failure;
        }

        @Override
        public boolean getBooleanField(Object target, String fieldName) {
            throw failure;
        }

        @Override
        public void setBooleanField(Object target, String fieldName, boolean value) {
            throw failure;
        }

        @Override
        public int getIntField(Object target, String fieldName) {
            throw failure;
        }

        @Override
        public void setIntField(Object target, String fieldName, int value) {
            throw failure;
        }

        @Override
        public float getFloatField(Object target, String fieldName) {
            throw failure;
        }

        @Override
        public Object getObjectField(Object target, String fieldName) {
            throw failure;
        }

        @Override
        public void setObjectField(Object target, String fieldName, Object value) {
            throw failure;
        }

        @Override
        public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
            throw failure;
        }

        @Override
        public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
            throw failure;
        }
    }
}
