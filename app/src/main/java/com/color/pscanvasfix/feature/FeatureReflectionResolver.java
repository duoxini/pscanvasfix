package com.color.pscanvasfix.feature;

import com.color.pscanvasfix.runtime.ReflectionAccess;

/** Package-local class lookup bridge shared by behavior features. */
final class FeatureReflectionResolver {
    private FeatureReflectionResolver() {
    }

    static Class<?> findClass(ReflectionAccess reflectionAccess, String className,
                              ClassLoader classLoader) {
        return reflectionAccess.findClass(className, classLoader);
    }
}
