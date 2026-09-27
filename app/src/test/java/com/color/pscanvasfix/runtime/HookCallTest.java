package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public final class HookCallTest {
    @Test
    public void ownsArgumentsExtrasAndOriginalCallCopies() throws Throwable {
        Method method = Fixture.class.getDeclaredMethod("join", String.class, int.class);
        Object[] frameworkArgs = new Object[]{"a", 1};
        AtomicReference<Object[]> originArgs = new AtomicReference<>();
        HookCall call = new HookCall(method, new Fixture(), frameworkArgs,
                (executable, receiver, args) -> {
                    originArgs.set(args.clone());
                    args[0] = "origin-mutated";
                    return "origin";
                });

        frameworkArgs[0] = "framework-mutated";
        call.args[1] = 2;
        call.setObjectExtra("key", "value");

        assertArrayEquals(new Object[]{"a", 2}, call.args);
        assertEquals("value", call.getObjectExtra("key"));
        assertNull(call.getObjectExtra("missing"));
        assertEquals("origin", call.invokeOriginal());
        assertArrayEquals(new Object[]{"a", 2}, originArgs.get());
        assertArrayEquals(new Object[]{"a", 2}, call.args);
    }

    @Test
    public void resultAndThrowableReplaceEachOtherIncludingNullResult() throws Exception {
        Method method = Fixture.class.getDeclaredMethod("join", String.class, int.class);
        HookCall call = new HookCall(method, new Fixture(), new Object[]{"a", 1},
                (executable, receiver, args) -> null);
        RuntimeException failure = new RuntimeException("oem");

        call.setThrowable(failure);
        assertTrue(call.hasThrowable());
        assertSame(failure, call.getThrowable());

        call.setResult(null);
        assertFalse(call.hasThrowable());
        assertNull(call.getThrowable());
        assertNull(call.getResult());
        assertTrue(call.shouldReturnEarly());
    }

    private static final class Fixture {
        @SuppressWarnings("unused")
        private String join(String value, int number) {
            return value + number;
        }
    }
}
