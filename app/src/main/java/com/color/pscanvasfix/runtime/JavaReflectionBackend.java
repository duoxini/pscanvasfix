package com.color.pscanvasfix.runtime;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Framework-independent reflection backend used after the modern API cutover.
 *
 * <p>Member resolution is cached by owner, operation and runtime argument types so hook hot
 * paths only scan a class hierarchy on their first distinct call shape.</p>
 */
public final class JavaReflectionBackend implements ReflectionAccess.Backend {
    private static final Object[] NO_ARGS = new Object[0];

    private static final ConcurrentMap<ClassLookupKey, Optional<Class<?>>> CLASS_CACHE =
            new ConcurrentHashMap<>();
    private static final ConcurrentMap<MethodLookupKey, Optional<Method>> METHOD_CACHE =
            new ConcurrentHashMap<>();
    private static final ConcurrentMap<ConstructorLookupKey, Optional<Constructor<?>>> CONSTRUCTOR_CACHE =
            new ConcurrentHashMap<>();
    private static final ConcurrentMap<FieldLookupKey, Optional<Field>> FIELD_CACHE =
            new ConcurrentHashMap<>();

    @Override
    public Class<?> findClass(String className, ClassLoader classLoader) {
        Objects.requireNonNull(className, "className");
        ClassLookupKey key = new ClassLookupKey(className, classLoader);
        Optional<Class<?>> resolved = CLASS_CACHE.computeIfAbsent(
                key, ignored -> loadClass(className, classLoader));
        if (resolved.isPresent()) {
            return resolved.get();
        }
        throw rethrow(new ClassNotFoundException(className));
    }

    @Override
    public Object callMethod(Object receiver, String methodName, Object... args) {
        Objects.requireNonNull(receiver, "receiver");
        Object[] actualArgs = normalizeArgs(args);
        Method method = findMethod(receiver.getClass(), methodName, actualArgs, false);
        return invoke(method, receiver, actualArgs);
    }

    @Override
    public Object callStaticMethod(Class<?> owner, String methodName, Object... args) {
        Objects.requireNonNull(owner, "owner");
        Object[] actualArgs = normalizeArgs(args);
        Method method = findMethod(owner, methodName, actualArgs, true);
        return invoke(method, null, actualArgs);
    }

    @Override
    public Object newInstance(Class<?> owner, Object... args) {
        Objects.requireNonNull(owner, "owner");
        Object[] actualArgs = normalizeArgs(args);
        ConstructorLookupKey key = new ConstructorLookupKey(owner, argumentTypes(actualArgs));
        Optional<Constructor<?>> resolved = CONSTRUCTOR_CACHE.computeIfAbsent(
                key, ignored -> resolveConstructor(owner, actualArgs));
        Constructor<?> constructor = resolved.orElseThrow(
                () -> rethrow(new NoSuchMethodException(constructorDescription(owner, actualArgs))));
        try {
            return constructor.newInstance(actualArgs);
        } catch (InvocationTargetException failure) {
            throw rethrow(rootCause(failure));
        } catch (ReflectiveOperationException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public boolean getBooleanField(Object target, String fieldName) {
        Objects.requireNonNull(target, "target");
        try {
            return findField(target.getClass(), fieldName, false).getBoolean(target);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public void setBooleanField(Object target, String fieldName, boolean value) {
        Objects.requireNonNull(target, "target");
        try {
            findField(target.getClass(), fieldName, false).setBoolean(target, value);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public int getIntField(Object target, String fieldName) {
        Objects.requireNonNull(target, "target");
        try {
            return findField(target.getClass(), fieldName, false).getInt(target);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public void setIntField(Object target, String fieldName, int value) {
        Objects.requireNonNull(target, "target");
        try {
            findField(target.getClass(), fieldName, false).setInt(target, value);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public float getFloatField(Object target, String fieldName) {
        Objects.requireNonNull(target, "target");
        try {
            return findField(target.getClass(), fieldName, false).getFloat(target);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public Object getObjectField(Object target, String fieldName) {
        Objects.requireNonNull(target, "target");
        try {
            return findField(target.getClass(), fieldName, false).get(target);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public void setObjectField(Object target, String fieldName, Object value) {
        Objects.requireNonNull(target, "target");
        try {
            findField(target.getClass(), fieldName, false).set(target, value);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public boolean getStaticBooleanField(Class<?> owner, String fieldName) {
        Objects.requireNonNull(owner, "owner");
        try {
            return findField(owner, fieldName, true).getBoolean(null);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    @Override
    public void setStaticBooleanField(Class<?> owner, String fieldName, boolean value) {
        Objects.requireNonNull(owner, "owner");
        try {
            findField(owner, fieldName, true).setBoolean(null, value);
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    private static Optional<Class<?>> loadClass(String className, ClassLoader classLoader) {
        Class<?> primitive = primitiveClass(className);
        if (primitive != null) {
            return Optional.of(primitive);
        }
        if (className.endsWith("[]")) {
            String componentName = className.substring(0, className.length() - 2);
            Class<?> component = loadClass(componentName, classLoader).orElse(null);
            return component == null
                    ? Optional.empty()
                    : Optional.of(Array.newInstance(component, 0).getClass());
        }
        try {
            return Optional.of(Class.forName(className, false, classLoader));
        } catch (ClassNotFoundException ignored) {
            return Optional.empty();
        }
    }

    private static Method findMethod(Class<?> owner, String methodName, Object[] args,
                                     boolean requireStatic) {
        Objects.requireNonNull(methodName, "methodName");
        MethodLookupKey key = new MethodLookupKey(
                owner, methodName, requireStatic, argumentTypes(args));
        Optional<Method> resolved = METHOD_CACHE.computeIfAbsent(
                key, ignored -> resolveMethod(owner, methodName, args, requireStatic));
        return resolved.orElseThrow(() -> rethrow(new NoSuchMethodException(
                methodDescription(owner, methodName, args))));
    }

    private static Optional<Method> resolveMethod(Class<?> owner, String methodName,
                                                  Object[] args, boolean requireStatic) {
        List<ScoredExecutable<Method>> candidates = new ArrayList<>();
        int declaringDistance = 0;
        for (Class<?> current = owner; current != null;
             current = current.getSuperclass(), declaringDistance++) {
            collectMethods(current, methodName, args, requireStatic, declaringDistance, candidates);
        }

        Set<Class<?>> visitedInterfaces = new HashSet<>();
        declaringDistance = 1;
        for (Class<?> current = owner; current != null; current = current.getSuperclass()) {
            for (Class<?> implemented : current.getInterfaces()) {
                collectInterfaceMethods(implemented, methodName, args, requireStatic,
                        declaringDistance, visitedInterfaces, candidates);
            }
            declaringDistance++;
        }

        ScoredExecutable<Method> best = chooseBest(candidates);
        if (best == null) {
            return Optional.empty();
        }
        makeAccessible(best.executable);
        return Optional.of(best.executable);
    }

    private static void collectMethods(Class<?> owner, String methodName, Object[] args,
                                       boolean requireStatic, int declaringDistance,
                                       List<ScoredExecutable<Method>> candidates) {
        for (Method method : owner.getDeclaredMethods()) {
            if (!method.getName().equals(methodName)
                    || Modifier.isStatic(method.getModifiers()) != requireStatic) {
                continue;
            }
            int score = compatibilityScore(method.getParameterTypes(), args);
            if (score >= 0) {
                candidates.add(new ScoredExecutable<>(method, score, declaringDistance));
            }
        }
    }

    private static void collectInterfaceMethods(
            Class<?> owner, String methodName, Object[] args, boolean requireStatic,
            int declaringDistance, Set<Class<?>> visited,
            List<ScoredExecutable<Method>> candidates) {
        if (!visited.add(owner)) {
            return;
        }
        collectMethods(owner, methodName, args, requireStatic, declaringDistance, candidates);
        for (Class<?> parent : owner.getInterfaces()) {
            collectInterfaceMethods(parent, methodName, args, requireStatic,
                    declaringDistance + 1, visited, candidates);
        }
    }

    private static Optional<Constructor<?>> resolveConstructor(Class<?> owner, Object[] args) {
        List<ScoredExecutable<Constructor<?>>> candidates = new ArrayList<>();
        for (Constructor<?> constructor : owner.getDeclaredConstructors()) {
            int score = compatibilityScore(constructor.getParameterTypes(), args);
            if (score >= 0) {
                candidates.add(new ScoredExecutable<>(constructor, score, 0));
            }
        }
        ScoredExecutable<Constructor<?>> best = chooseBest(candidates);
        if (best == null) {
            return Optional.empty();
        }
        makeAccessible(best.executable);
        return Optional.of(best.executable);
    }

    private static <T extends Executable> ScoredExecutable<T> chooseBest(
            List<ScoredExecutable<T>> candidates) {
        ScoredExecutable<T> best = null;
        for (ScoredExecutable<T> candidate : candidates) {
            if (best == null || compare(candidate, best) < 0) {
                best = candidate;
            }
        }
        return best;
    }

    private static int compare(ScoredExecutable<?> left, ScoredExecutable<?> right) {
        int result = Integer.compare(left.score, right.score);
        if (result != 0) {
            return result;
        }
        boolean leftMoreSpecific = moreSpecific(
                left.executable.getParameterTypes(), right.executable.getParameterTypes());
        boolean rightMoreSpecific = moreSpecific(
                right.executable.getParameterTypes(), left.executable.getParameterTypes());
        if (leftMoreSpecific != rightMoreSpecific) {
            return leftMoreSpecific ? -1 : 1;
        }
        result = Integer.compare(left.declaringDistance, right.declaringDistance);
        if (result != 0) {
            return result;
        }
        result = Boolean.compare(left.executable.isSynthetic(), right.executable.isSynthetic());
        if (result != 0) {
            return result;
        }
        if (left.executable instanceof Method && right.executable instanceof Method) {
            result = Boolean.compare(
                    ((Method) left.executable).isBridge(), ((Method) right.executable).isBridge());
            if (result != 0) {
                return result;
            }
        }
        return left.executable.toGenericString().compareTo(right.executable.toGenericString());
    }

    private static boolean moreSpecific(Class<?>[] left, Class<?>[] right) {
        boolean strict = false;
        for (int index = 0; index < left.length; index++) {
            Class<?> leftType = boxed(left[index]);
            Class<?> rightType = boxed(right[index]);
            if (!rightType.isAssignableFrom(leftType)) {
                return false;
            }
            strict |= leftType != rightType;
        }
        return strict;
    }

    private static int compatibilityScore(Class<?>[] parameterTypes, Object[] args) {
        if (parameterTypes.length != args.length) {
            return -1;
        }
        int total = 0;
        for (int index = 0; index < parameterTypes.length; index++) {
            int score = parameterScore(parameterTypes[index], args[index]);
            if (score < 0) {
                return -1;
            }
            total += score;
        }
        return total;
    }

    private static int parameterScore(Class<?> parameterType, Object argument) {
        if (argument == null) {
            return parameterType.isPrimitive() ? -1 : 40 - Math.min(30, typeDepth(parameterType));
        }

        Class<?> argumentType = argument.getClass();
        if (parameterType == argumentType) {
            return 0;
        }
        if (parameterType.isPrimitive()) {
            Class<?> argumentPrimitive = unboxed(argumentType);
            if (argumentPrimitive == null) {
                return -1;
            }
            int wideningDistance = primitiveWideningDistance(argumentPrimitive, parameterType);
            return wideningDistance < 0 ? -1 : 1 + wideningDistance;
        }
        if (parameterType.isAssignableFrom(argumentType)) {
            return 10 + inheritanceDistance(argumentType, parameterType);
        }
        return -1;
    }

    private static int inheritanceDistance(Class<?> from, Class<?> to) {
        if (from == to) {
            return 0;
        }
        Queue<Class<?>> pending = new ArrayDeque<>();
        Queue<Integer> distances = new ArrayDeque<>();
        Set<Class<?>> visited = new HashSet<>();
        pending.add(from);
        distances.add(0);
        visited.add(from);
        while (!pending.isEmpty()) {
            Class<?> current = pending.remove();
            int distance = distances.remove();
            if (current == to) {
                return distance;
            }
            Class<?> parent = current.getSuperclass();
            if (parent != null && visited.add(parent)) {
                pending.add(parent);
                distances.add(distance + 1);
            }
            for (Class<?> implemented : current.getInterfaces()) {
                if (visited.add(implemented)) {
                    pending.add(implemented);
                    distances.add(distance + 1);
                }
            }
        }
        return 100;
    }

    private static int typeDepth(Class<?> type) {
        if (type.isInterface()) {
            return 1;
        }
        int depth = 0;
        for (Class<?> current = type; current != null; current = current.getSuperclass()) {
            depth++;
        }
        return depth;
    }

    private static int primitiveWideningDistance(Class<?> from, Class<?> to) {
        if (from == to) {
            return 0;
        }
        if (from == boolean.class || to == boolean.class) {
            return -1;
        }
        if (from == byte.class) {
            return numericDistance(to, short.class, int.class, long.class, float.class, double.class);
        }
        if (from == short.class) {
            return numericDistance(to, int.class, long.class, float.class, double.class);
        }
        if (from == char.class) {
            return numericDistance(to, int.class, long.class, float.class, double.class);
        }
        if (from == int.class) {
            return numericDistance(to, long.class, float.class, double.class);
        }
        if (from == long.class) {
            return numericDistance(to, float.class, double.class);
        }
        if (from == float.class) {
            return numericDistance(to, double.class);
        }
        return -1;
    }

    private static int numericDistance(Class<?> target, Class<?>... path) {
        for (int index = 0; index < path.length; index++) {
            if (path[index] == target) {
                return index + 1;
            }
        }
        return -1;
    }

    private static Object invoke(Method method, Object receiver, Object[] args) {
        try {
            return method.invoke(receiver, args);
        } catch (InvocationTargetException failure) {
            throw rethrow(rootCause(failure));
        } catch (IllegalAccessException failure) {
            throw rethrow(failure);
        }
    }

    private static Throwable rootCause(InvocationTargetException failure) {
        return failure.getCause() == null ? failure : failure.getCause();
    }

    private static Field findField(Class<?> owner, String fieldName, boolean requireStatic) {
        Objects.requireNonNull(fieldName, "fieldName");
        FieldLookupKey key = new FieldLookupKey(owner, fieldName, requireStatic);
        Optional<Field> resolved = FIELD_CACHE.computeIfAbsent(
                key, ignored -> resolveField(owner, fieldName, requireStatic));
        return resolved.orElseThrow(() -> rethrow(
                new NoSuchFieldException(owner.getName() + '#' + fieldName)));
    }

    private static Optional<Field> resolveField(Class<?> owner, String fieldName,
                                                boolean requireStatic) {
        for (Class<?> current = owner; current != null; current = current.getSuperclass()) {
            try {
                Field field = current.getDeclaredField(fieldName);
                if (Modifier.isStatic(field.getModifiers()) != requireStatic) {
                    continue;
                }
                makeAccessible(field);
                return Optional.of(field);
            } catch (NoSuchFieldException ignored) {
                // Continue up the hierarchy.
            }
        }
        return findInterfaceField(owner, fieldName, requireStatic, new HashSet<>());
    }

    private static Optional<Field> findInterfaceField(Class<?> owner, String fieldName,
                                                      boolean requireStatic,
                                                      Set<Class<?>> visited) {
        for (Class<?> implemented : owner.getInterfaces()) {
            if (!visited.add(implemented)) {
                continue;
            }
            try {
                Field field = implemented.getDeclaredField(fieldName);
                if (Modifier.isStatic(field.getModifiers()) == requireStatic) {
                    makeAccessible(field);
                    return Optional.of(field);
                }
            } catch (NoSuchFieldException ignored) {
                // Continue through parent interfaces.
            }
            Optional<Field> inherited = findInterfaceField(
                    implemented, fieldName, requireStatic, visited);
            if (inherited.isPresent()) {
                return inherited;
            }
        }
        Class<?> parent = owner.getSuperclass();
        return parent == null
                ? Optional.empty()
                : findInterfaceField(parent, fieldName, requireStatic, visited);
    }

    private static void makeAccessible(java.lang.reflect.AccessibleObject member) {
        member.setAccessible(true);
    }

    private static Class<?>[] argumentTypes(Object[] args) {
        Class<?>[] types = new Class<?>[args.length];
        for (int index = 0; index < args.length; index++) {
            types[index] = args[index] == null ? NullArgument.class : args[index].getClass();
        }
        return types;
    }

    private static Object[] normalizeArgs(Object[] args) {
        return args == null ? NO_ARGS : args;
    }

    private static String methodDescription(Class<?> owner, String name, Object[] args) {
        return owner.getName() + '#' + name + Arrays.toString(argumentTypes(args));
    }

    private static String constructorDescription(Class<?> owner, Object[] args) {
        return owner.getName() + Arrays.toString(argumentTypes(args));
    }

    private static Class<?> primitiveClass(String name) {
        switch (name) {
            case "boolean": return boolean.class;
            case "byte": return byte.class;
            case "char": return char.class;
            case "short": return short.class;
            case "int": return int.class;
            case "long": return long.class;
            case "float": return float.class;
            case "double": return double.class;
            case "void": return void.class;
            default: return null;
        }
    }

    private static Class<?> boxed(Class<?> type) {
        if (!type.isPrimitive()) {
            return type;
        }
        if (type == boolean.class) return Boolean.class;
        if (type == byte.class) return Byte.class;
        if (type == char.class) return Character.class;
        if (type == short.class) return Short.class;
        if (type == int.class) return Integer.class;
        if (type == long.class) return Long.class;
        if (type == float.class) return Float.class;
        if (type == double.class) return Double.class;
        if (type == void.class) return Void.class;
        throw new AssertionError(type);
    }

    private static Class<?> unboxed(Class<?> type) {
        if (type == Boolean.class) return boolean.class;
        if (type == Byte.class) return byte.class;
        if (type == Character.class) return char.class;
        if (type == Short.class) return short.class;
        if (type == Integer.class) return int.class;
        if (type == Long.class) return long.class;
        if (type == Float.class) return float.class;
        if (type == Double.class) return double.class;
        if (type == Void.class) return void.class;
        return null;
    }

    private static RuntimeException rethrow(Throwable throwable) {
        JavaReflectionBackend.<RuntimeException>throwUnchecked(throwable);
        throw new AssertionError("unreachable");
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void throwUnchecked(Throwable throwable) throws T {
        throw (T) throwable;
    }

    private static final class NullArgument {
        private NullArgument() { }
    }

    private static final class ScoredExecutable<T extends Executable> {
        final T executable;
        final int score;
        final int declaringDistance;

        ScoredExecutable(T executable, int score, int declaringDistance) {
            this.executable = executable;
            this.score = score;
            this.declaringDistance = declaringDistance;
        }
    }

    private static final class ClassLookupKey {
        final String className;
        final ClassLoader classLoader;

        ClassLookupKey(String className, ClassLoader classLoader) {
            this.className = className;
            this.classLoader = classLoader;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof ClassLookupKey)) return false;
            ClassLookupKey that = (ClassLookupKey) other;
            return classLoader == that.classLoader && className.equals(that.className);
        }

        @Override
        public int hashCode() {
            return 31 * className.hashCode() + System.identityHashCode(classLoader);
        }
    }

    private static final class MethodLookupKey {
        final Class<?> owner;
        final String name;
        final boolean requireStatic;
        final Class<?>[] argumentTypes;

        MethodLookupKey(Class<?> owner, String name, boolean requireStatic,
                        Class<?>[] argumentTypes) {
            this.owner = owner;
            this.name = name;
            this.requireStatic = requireStatic;
            this.argumentTypes = argumentTypes;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof MethodLookupKey)) return false;
            MethodLookupKey that = (MethodLookupKey) other;
            return owner == that.owner
                    && requireStatic == that.requireStatic
                    && name.equals(that.name)
                    && Arrays.equals(argumentTypes, that.argumentTypes);
        }

        @Override
        public int hashCode() {
            int result = System.identityHashCode(owner);
            result = 31 * result + name.hashCode();
            result = 31 * result + Boolean.hashCode(requireStatic);
            result = 31 * result + Arrays.hashCode(argumentTypes);
            return result;
        }
    }

    private static final class ConstructorLookupKey {
        final Class<?> owner;
        final Class<?>[] argumentTypes;

        ConstructorLookupKey(Class<?> owner, Class<?>[] argumentTypes) {
            this.owner = owner;
            this.argumentTypes = argumentTypes;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof ConstructorLookupKey)) return false;
            ConstructorLookupKey that = (ConstructorLookupKey) other;
            return owner == that.owner && Arrays.equals(argumentTypes, that.argumentTypes);
        }

        @Override
        public int hashCode() {
            return 31 * System.identityHashCode(owner) + Arrays.hashCode(argumentTypes);
        }
    }

    private static final class FieldLookupKey {
        final Class<?> owner;
        final String fieldName;
        final boolean requireStatic;

        FieldLookupKey(Class<?> owner, String fieldName, boolean requireStatic) {
            this.owner = owner;
            this.fieldName = fieldName;
            this.requireStatic = requireStatic;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof FieldLookupKey)) return false;
            FieldLookupKey that = (FieldLookupKey) other;
            return owner == that.owner
                    && requireStatic == that.requireStatic
                    && fieldName.equals(that.fieldName);
        }

        @Override
        public int hashCode() {
            int result = System.identityHashCode(owner);
            result = 31 * result + fieldName.hashCode();
            result = 31 * result + Boolean.hashCode(requireStatic);
            return result;
        }
    }
}
