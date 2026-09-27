package com.color.pscanvasfix.runtime;

import java.util.Objects;

/**
 * Typed access to module-private state attached to target-process instances.
 *
 * <p>The backend is isolated so object-attached state keeps weak identity
 * semantics while business code remains independent of framework APIs.</p>
 */
public final class InstanceStateStore {
    public interface Backend {
        Object get(Object instance, String key);

        void put(Object instance, String key, Object value);

        Object remove(Object instance, String key);
    }

    public static final class Key<T> {
        private final String name;
        private final Class<T> type;

        private Key(String name, Class<T> type) {
            this.name = Objects.requireNonNull(name, "name");
            this.type = Objects.requireNonNull(type, "type");
        }

        public static <T> Key<T> of(String name, Class<T> type) {
            return new Key<>(name, type);
        }

        String name() {
            return name;
        }

        T cast(Object value) {
            return value == null ? null : type.cast(value);
        }
    }

    private final Backend backend;

    public InstanceStateStore(Backend backend) {
        this.backend = Objects.requireNonNull(backend, "backend");
    }

    public <T> T get(Object instance, Key<T> key) {
        return key.cast(backend.get(instance, key.name()));
    }

    public <T> void put(Object instance, Key<T> key, T value) {
        backend.put(instance, key.name(), value);
    }

    public <T> T remove(Object instance, Key<T> key) {
        return key.cast(backend.remove(instance, key.name()));
    }
}
