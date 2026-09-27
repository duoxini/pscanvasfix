package com.color.pscanvasfix.runtime;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/** Thread-safe weak identity map for module-private state attached to target instances. */
public final class WeakIdentityInstanceStateBackend implements InstanceStateStore.Backend {
    private final Object lock = new Object();
    private final ReferenceQueue<Object> staleInstances = new ReferenceQueue<>();
    private final Map<IdentityWeakReference, Map<String, Object>> valuesByInstance =
            new HashMap<>();

    @Override
    public Object get(Object instance, String key) {
        Objects.requireNonNull(instance, "instance");
        Objects.requireNonNull(key, "key");
        synchronized (lock) {
            removeStaleInstances();
            Map<String, Object> values = valuesByInstance.get(IdentityWeakReference.lookup(instance));
            return values == null ? null : values.get(key);
        }
    }

    @Override
    public void put(Object instance, String key, Object value) {
        Objects.requireNonNull(instance, "instance");
        Objects.requireNonNull(key, "key");
        synchronized (lock) {
            removeStaleInstances();
            IdentityWeakReference lookup = IdentityWeakReference.lookup(instance);
            Map<String, Object> values = valuesByInstance.get(lookup);
            if (values == null) {
                values = new HashMap<>();
                valuesByInstance.put(
                        new IdentityWeakReference(instance, staleInstances), values);
            }
            values.put(key, value);
        }
    }

    @Override
    public Object remove(Object instance, String key) {
        Objects.requireNonNull(instance, "instance");
        Objects.requireNonNull(key, "key");
        synchronized (lock) {
            removeStaleInstances();
            IdentityWeakReference lookup = IdentityWeakReference.lookup(instance);
            Map<String, Object> values = valuesByInstance.get(lookup);
            if (values == null) {
                return null;
            }
            Object removed = values.remove(key);
            if (values.isEmpty()) {
                valuesByInstance.remove(lookup);
            }
            return removed;
        }
    }

    private void removeStaleInstances() {
        IdentityWeakReference stale;
        while ((stale = (IdentityWeakReference) staleInstances.poll()) != null) {
            valuesByInstance.remove(stale);
        }
    }

    private static final class IdentityWeakReference extends WeakReference<Object> {
        private final int identityHash;

        IdentityWeakReference(Object referent, ReferenceQueue<Object> queue) {
            super(referent, queue);
            identityHash = System.identityHashCode(referent);
        }

        private IdentityWeakReference(Object referent) {
            super(referent);
            identityHash = System.identityHashCode(referent);
        }

        static IdentityWeakReference lookup(Object instance) {
            return new IdentityWeakReference(instance);
        }

        @Override
        public int hashCode() {
            return identityHash;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof IdentityWeakReference)) {
                return false;
            }
            Object instance = get();
            return instance != null && instance == ((IdentityWeakReference) other).get();
        }
    }
}
