package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public final class InstanceStateStoreTest {
    private static final InstanceStateStore.Key<Boolean> BOOLEAN_KEY =
            InstanceStateStore.Key.of("boolean", Boolean.class);
    private static final InstanceStateStore.Key<String> STRING_KEY =
            InstanceStateStore.Key.of("string", String.class);

    @Test
    public void keepsStateIsolatedByInstanceAndKey() {
        InstanceStateStore store = new InstanceStateStore(new FakeBackend());
        Object first = new Object();
        Object second = new Object();

        store.put(first, BOOLEAN_KEY, Boolean.TRUE);
        store.put(first, STRING_KEY, "first");
        store.put(second, BOOLEAN_KEY, Boolean.FALSE);

        assertTrue(store.get(first, BOOLEAN_KEY));
        assertEquals("first", store.get(first, STRING_KEY));
        assertFalse(store.get(second, BOOLEAN_KEY));
        assertNull(store.get(second, STRING_KEY));
    }

    @Test
    public void removeReturnsTypedValueAndClearsOnlySelectedState() {
        InstanceStateStore store = new InstanceStateStore(new FakeBackend());
        Object first = new Object();
        Object second = new Object();

        store.put(first, BOOLEAN_KEY, Boolean.TRUE);
        store.put(second, BOOLEAN_KEY, Boolean.FALSE);

        assertTrue(store.remove(first, BOOLEAN_KEY));
        assertNull(store.get(first, BOOLEAN_KEY));
        assertFalse(store.get(second, BOOLEAN_KEY));
        assertNull(store.remove(first, BOOLEAN_KEY));
    }

    @Test(expected = ClassCastException.class)
    public void rejectsValueThatDoesNotMatchKeyType() {
        FakeBackend backend = new FakeBackend();
        InstanceStateStore store = new InstanceStateStore(backend);
        Object instance = new Object();

        backend.put(instance, "boolean", "not-a-boolean");
        store.get(instance, BOOLEAN_KEY);
    }

    private static final class FakeBackend implements InstanceStateStore.Backend {
        private final Map<Object, Map<String, Object>> values = new IdentityHashMap<>();

        @Override
        public Object get(Object instance, String key) {
            Map<String, Object> state = values.get(instance);
            return state == null ? null : state.get(key);
        }

        @Override
        public void put(Object instance, String key, Object value) {
            values.computeIfAbsent(instance, ignored -> new HashMap<>()).put(key, value);
        }

        @Override
        public Object remove(Object instance, String key) {
            Map<String, Object> state = values.get(instance);
            if (state == null) {
                return null;
            }
            Object removed = state.remove(key);
            if (state.isEmpty()) {
                values.remove(instance);
            }
            return removed;
        }
    }
}
