package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public final class WeakIdentityInstanceStateBackendTest {
    @Test
    public void isolatesEqualInstancesByIdentityAndKeys() {
        WeakIdentityInstanceStateBackend backend = new WeakIdentityInstanceStateBackend();
        EqualFixture first = new EqualFixture(1);
        EqualFixture second = new EqualFixture(1);

        backend.put(first, "state", "first");
        backend.put(second, "state", "second");
        backend.put(first, "other", Integer.valueOf(7));

        assertEquals("first", backend.get(first, "state"));
        assertEquals("second", backend.get(second, "state"));
        assertEquals(Integer.valueOf(7), backend.get(first, "other"));
        assertEquals("first", backend.remove(first, "state"));
        assertNull(backend.get(first, "state"));
        assertEquals("second", backend.get(second, "state"));
    }

    @Test
    public void drainsEnqueuedWeakIdentityKeysOnNextOperation() throws Exception {
        WeakIdentityInstanceStateBackend backend = new WeakIdentityInstanceStateBackend();
        Object instance = new Object();
        backend.put(instance, "state", "value");

        Map<?, ?> values = valuesByInstance(backend);
        assertEquals(1, values.size());
        Reference<?> tracked = (Reference<?>) values.keySet().iterator().next();
        tracked.clear();
        assertTrue(tracked.enqueue());

        backend.get(new Object(), "missing");
        assertTrue(values.isEmpty());
    }

    @Test
    public void serializesConcurrentUpdatesWithoutLosingIndependentKeys() throws Exception {
        WeakIdentityInstanceStateBackend backend = new WeakIdentityInstanceStateBackend();
        Object instance = new Object();
        int workers = 6;
        ExecutorService executor = Executors.newFixedThreadPool(workers);
        CountDownLatch start = new CountDownLatch(1);
        Future<?>[] futures = new Future<?>[workers];
        try {
            for (int worker = 0; worker < workers; worker++) {
                final int index = worker;
                futures[worker] = executor.submit(() -> {
                    start.await();
                    for (int iteration = 0; iteration < 500; iteration++) {
                        backend.put(instance, "key-" + index, Integer.valueOf(iteration));
                    }
                    return null;
                });
            }
            start.countDown();
            for (Future<?> future : futures) {
                future.get();
            }
            for (int worker = 0; worker < workers; worker++) {
                assertEquals(Integer.valueOf(499), backend.get(instance, "key-" + worker));
            }
        } finally {
            executor.shutdownNow();
        }
    }

    @SuppressWarnings("unchecked")
    private static Map<?, ?> valuesByInstance(WeakIdentityInstanceStateBackend backend)
            throws Exception {
        Field field = WeakIdentityInstanceStateBackend.class
                .getDeclaredField("valuesByInstance");
        field.setAccessible(true);
        return (Map<?, ?>) field.get(backend);
    }

    private static final class EqualFixture {
        private final int value;

        EqualFixture(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof EqualFixture && value == ((EqualFixture) other).value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
