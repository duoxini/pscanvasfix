package com.color.pscanvasfix.runtime;

import android.util.Log;

import java.util.Objects;

import io.github.libxposed.api.XposedInterface;

/** Framework log sink whose modern API process context is attached by the module entry point. */
public final class ModernXposedLogSink implements ModuleLogger.Sink {
    private static volatile XposedInterface xposed;

    public static void attach(XposedInterface xposed) {
        ModernXposedLogSink.xposed = Objects.requireNonNull(xposed, "xposed");
    }

    public static void detach() {
        xposed = null;
    }

    @Override
    public void log(ModuleLogger.Level level, String tag, String message,
                    Throwable throwable) {
        XposedInterface attached = xposed;
        if (attached == null) {
            return;
        }
        int priority = priorityOf(level);
        if (throwable == null) {
            attached.log(priority, tag, message);
        } else {
            attached.log(priority, tag, message, throwable);
        }
    }

    private static int priorityOf(ModuleLogger.Level level) {
        switch (level) {
            case DEBUG:
                return Log.DEBUG;
            case INFO:
                return Log.INFO;
            case WARN:
                return Log.WARN;
            case ERROR:
                return Log.ERROR;
            default:
                throw new AssertionError("Unhandled log level " + level);
        }
    }
}
