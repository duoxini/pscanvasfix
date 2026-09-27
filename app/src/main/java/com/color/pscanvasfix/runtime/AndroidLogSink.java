package com.color.pscanvasfix.runtime;

import android.util.Log;

/** Android logcat sink that preserves the original level mapping. */
public final class AndroidLogSink implements ModuleLogger.Sink {
    @Override
    public void log(ModuleLogger.Level level, String tag, String message,
                    Throwable throwable) {
        switch (level) {
            case DEBUG:
                Log.d(tag, message);
                break;
            case INFO:
                Log.i(tag, message);
                break;
            case WARN:
                Log.w(tag, message);
                break;
            case ERROR:
                Log.e(tag, message, throwable);
                break;
            default:
                throw new AssertionError("Unhandled log level " + level);
        }
    }
}
