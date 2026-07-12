package com.color.pscanvasfix.compat;

import android.util.Log;
import de.robv.android.xposed.XposedBridge;

public final class PsCanvasLog {
    private static final String TAG = "PsCanvasFix";

    private PsCanvasLog() {
    }

    public static void d(String message) {
        XposedBridge.log(TAG + ": " + message);
        Log.d(TAG, message);
    }

    public static void i(String message) {
        XposedBridge.log(TAG + ": " + message);
        Log.i(TAG, message);
    }

    public static void w(String message) {
        XposedBridge.log(TAG + ": " + message);
        Log.w(TAG, message);
    }

    public static void e(String message, Throwable throwable) {
        XposedBridge.log(TAG + ": " + message + " " + throwable);
        Log.e(TAG, message, throwable);
    }

    /** Short caller chain for pinch/transition debugging. */
    public static void trace(String tag, String detail) {
        StringBuilder message = new StringBuilder(tag);
        if (detail != null && !detail.isEmpty()) {
            message.append(' ').append(detail);
        }
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        message.append(" @");
        int printed = 0;
        for (int index = 0; index < trace.length && printed < 3; index++) {
            StackTraceElement frame = trace[index];
            String className = frame.getClassName();
            if (className.contains("PsCanvasFix")
                    || className.contains("Xposed")
                    || className.contains("java.lang.Thread")) {
                continue;
            }
            message.append(' ').append(frame.getClassName())
                    .append('.').append(frame.getMethodName())
                    .append(':').append(frame.getLineNumber());
            printed++;
        }
        d(message.toString());
    }
}
