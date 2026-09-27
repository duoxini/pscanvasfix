package com.color.pscanvasfix.runtime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public final class ModuleLoggerTest {
    @Test
    public void forwardsAllLevelsWithTagAndMessage() {
        RecordingSink sink = new RecordingSink("only", new ArrayList<>());
        ModuleLogger logger = new ModuleLogger("PsCanvasFix", sink);

        logger.d("debug");
        logger.i("info");
        logger.w("warn");
        logger.e("error", null);

        assertEquals(4, sink.entries.size());
        assertEntry(sink.entries.get(0), ModuleLogger.Level.DEBUG, "debug", null);
        assertEntry(sink.entries.get(1), ModuleLogger.Level.INFO, "info", null);
        assertEntry(sink.entries.get(2), ModuleLogger.Level.WARN, "warn", null);
        assertEntry(sink.entries.get(3), ModuleLogger.Level.ERROR, "error", null);
    }

    @Test
    public void invokesSinksInConfiguredOrderForEveryEvent() {
        List<String> calls = new ArrayList<>();
        ModuleLogger logger = new ModuleLogger(
                "PsCanvasFix",
                new RecordingSink("framework", calls),
                new RecordingSink("android", calls));

        logger.i("first");
        logger.w("second");

        assertEquals(Arrays.asList(
                "framework:INFO:first",
                "android:INFO:first",
                "framework:WARN:second",
                "android:WARN:second"), calls);
    }

    @Test
    public void passesSameThrowableInstanceToEverySink() {
        RecordingSink framework = new RecordingSink("framework", new ArrayList<>());
        RecordingSink android = new RecordingSink("android", new ArrayList<>());
        ModuleLogger logger = new ModuleLogger("PsCanvasFix", framework, android);
        IllegalStateException failure = new IllegalStateException("boom");

        logger.e("failed", failure);

        assertSame(failure, framework.entries.get(0).throwable);
        assertSame(failure, android.entries.get(0).throwable);
    }

    private static void assertEntry(Entry entry, ModuleLogger.Level level,
                                    String message, Throwable throwable) {
        assertEquals(level, entry.level);
        assertEquals("PsCanvasFix", entry.tag);
        assertEquals(message, entry.message);
        if (throwable == null) {
            assertNull(entry.throwable);
        } else {
            assertSame(throwable, entry.throwable);
        }
    }

    private static final class RecordingSink implements ModuleLogger.Sink {
        private final String name;
        private final List<String> calls;
        private final List<Entry> entries = new ArrayList<>();

        RecordingSink(String name, List<String> calls) {
            this.name = name;
            this.calls = calls;
        }

        @Override
        public void log(ModuleLogger.Level level, String tag, String message,
                        Throwable throwable) {
            calls.add(name + ":" + level + ":" + message);
            entries.add(new Entry(level, tag, message, throwable));
        }
    }

    private static final class Entry {
        final ModuleLogger.Level level;
        final String tag;
        final String message;
        final Throwable throwable;

        Entry(ModuleLogger.Level level, String tag, String message, Throwable throwable) {
            this.level = level;
            this.tag = tag;
            this.message = message;
            this.throwable = throwable;
        }
    }
}
