package com.color.pscanvasfix.runtime;

import java.util.Objects;

/** Framework-neutral logger that forwards each event to ordered sinks. */
public final class ModuleLogger {
    public enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public interface Sink {
        void log(Level level, String tag, String message, Throwable throwable);
    }

    private final String tag;
    private final Sink[] sinks;

    public ModuleLogger(String tag, Sink... sinks) {
        this.tag = Objects.requireNonNull(tag, "tag");
        this.sinks = Objects.requireNonNull(sinks, "sinks").clone();
        for (Sink sink : this.sinks) {
            Objects.requireNonNull(sink, "sink");
        }
    }

    public void d(String message) {
        log(Level.DEBUG, message, null);
    }

    public void i(String message) {
        log(Level.INFO, message, null);
    }

    public void w(String message) {
        log(Level.WARN, message, null);
    }

    public void e(String message, Throwable throwable) {
        log(Level.ERROR, message, throwable);
    }

    private void log(Level level, String message, Throwable throwable) {
        for (Sink sink : sinks) {
            sink.log(level, tag, message, throwable);
        }
    }
}
