package com.color.pscanvasfix.runtime;

import android.util.Log;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import io.github.libxposed.api.XposedInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

public final class ModernXposedLogSinkTest {
    @Test
    public void staysSilentUntilAttachedAndAfterDetach() {
        List<Object[]> calls = new ArrayList<>();
        ModernXposedLogSink sink = new ModernXposedLogSink();
        XposedInterface xposed = recordingInterface(calls);

        ModernXposedLogSink.detach();
        sink.log(ModuleLogger.Level.INFO, "Tag", "before", null);
        assertEquals(0, calls.size());

        ModernXposedLogSink.attach(xposed);
        sink.log(ModuleLogger.Level.INFO, "Tag", "attached", null);
        ModernXposedLogSink.detach();
        sink.log(ModuleLogger.Level.INFO, "Tag", "after", null);

        assertEquals(1, calls.size());
        assertEquals(Log.INFO, calls.get(0)[0]);
        assertEquals("Tag", calls.get(0)[1]);
        assertEquals("attached", calls.get(0)[2]);
    }

    @Test
    public void mapsEveryLevelAndUsesThrowableOverloadWhenPresent() {
        List<Object[]> calls = new ArrayList<>();
        ModernXposedLogSink sink = new ModernXposedLogSink();
        ModernXposedLogSink.attach(recordingInterface(calls));
        IllegalStateException failure = new IllegalStateException("boom");

        sink.log(ModuleLogger.Level.DEBUG, "Tag", "debug", null);
        sink.log(ModuleLogger.Level.INFO, "Tag", "info", null);
        sink.log(ModuleLogger.Level.WARN, "Tag", "warn", null);
        sink.log(ModuleLogger.Level.ERROR, "Tag", "error", failure);

        assertEquals(4, calls.size());
        assertEquals(Log.DEBUG, calls.get(0)[0]);
        assertEquals(Log.INFO, calls.get(1)[0]);
        assertEquals(Log.WARN, calls.get(2)[0]);
        assertEquals(Log.ERROR, calls.get(3)[0]);
        assertEquals(4, calls.get(3).length);
        assertSame(failure, calls.get(3)[3]);
        ModernXposedLogSink.detach();
    }

    @Test
    public void rejectsNullAttachment() {
        ModernXposedLogSink.detach();
        assertThrows(NullPointerException.class, () -> ModernXposedLogSink.attach(null));
    }

    private static XposedInterface recordingInterface(List<Object[]> calls) {
        return (XposedInterface) Proxy.newProxyInstance(
                ModernXposedLogSinkTest.class.getClassLoader(),
                new Class<?>[]{XposedInterface.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("log")) {
                        calls.add(args.clone());
                    }
                    return primitiveDefault(method.getReturnType());
                });
    }

    private static Object primitiveDefault(Class<?> type) {
        if (!type.isPrimitive() || type == void.class) return null;
        if (type == boolean.class) return false;
        if (type == char.class) return '\0';
        if (type == byte.class) return (byte) 0;
        if (type == short.class) return (short) 0;
        if (type == int.class) return 0;
        if (type == long.class) return 0L;
        if (type == float.class) return 0f;
        if (type == double.class) return 0d;
        throw new AssertionError(type);
    }
}
