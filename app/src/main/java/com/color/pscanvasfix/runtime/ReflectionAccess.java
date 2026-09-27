package com.color.pscanvasfix.runtime;

import java.util.Objects;

/** Injectable access to reflection operations used by compatibility code. */
public final class ReflectionAccess {
    public interface Backend {
        Class<?> findClass(String className, ClassLoader classLoader);

        Object callMethod(Object receiver, String methodName, Object... args);

        Object callStaticMethod(Class<?> owner, String methodName, Object... args);

        Object newInstance(Class<?> owner, Object... args);

        boolean getBooleanField(Object target, String fieldName);

        void setBooleanField(Object target, String fieldName, boolean value);

        int getIntField(Object target, String fieldName);

        void setIntField(Object target, String fieldName, int value);

        float getFloatField(Object target, String fieldName);

        Object getObjectField(Object target, String fieldName);

        void setObjectField(Object target, String fieldName, Object value);

        boolean getStaticBooleanField(Class<?> owner, String fieldName);

        void setStaticBooleanField(Class<?> owner, String fieldName, boolean value);
    }

    private final Backend backend;

    public ReflectionAccess(Backend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    public Class<?> findClass(String className, ClassLoader classLoader) {
        return backend.findClass(className, classLoader);
    }

    public Object callMethod(Object receiver, String methodName, Object... args) {
        return backend.callMethod(receiver, methodName, args);
    }

    public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
        return backend.callStaticMethod(owner, methodName, args);
    }

    public Object newInstance(Class<?> owner, Object... args) {
        return backend.newInstance(owner, args);
    }

    public boolean getBooleanField(Object target, String fieldName) {
        return backend.getBooleanField(target, fieldName);
    }

    public void setBooleanField(Object target, String fieldName, boolean value) {
        backend.setBooleanField(target, fieldName, value);
    }

    public int getIntField(Object target, String fieldName) {
        return backend.getIntField(target, fieldName);
    }

    public void setIntField(Object target, String fieldName, int value) {
        backend.setIntField(target, fieldName, value);
    }

    public float getFloatField(Object target, String fieldName) {
        return backend.getFloatField(target, fieldName);
    }

    public Object getObjectField(Object target, String fieldName) {
        return backend.getObjectField(target, fieldName);
    }

    public void setObjectField(Object target, String fieldName, Object value) {
        backend.setObjectField(target, fieldName, value);
    }

    public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
        return backend.getStaticBooleanField(owner, fieldName);
    }

    public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
        backend.setStaticBooleanField(owner, fieldName, value);
    }
}
