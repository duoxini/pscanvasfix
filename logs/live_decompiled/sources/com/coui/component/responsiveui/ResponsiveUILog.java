package com.coui.component.responsiveui;

import D2.k;
import K2.e;
import android.util.Log;

/* loaded from: classes.dex */
public final class ResponsiveUILog {
    public static final ResponsiveUILog INSTANCE = new ResponsiveUILog();

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f9321a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f9322b;

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f9323c;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f9324d;

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f9325e;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f9326f;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f9327g;

    static {
        boolean isLoggable = Log.isLoggable("COUI", 2);
        f9321a = isLoggable;
        boolean isLoggable2 = Log.isLoggable("COUI", 3);
        f9322b = isLoggable2;
        boolean isLoggable3 = Log.isLoggable("COUI", 4);
        f9323c = isLoggable3;
        boolean isLoggable4 = Log.isLoggable("COUI", 5);
        f9324d = isLoggable4;
        boolean isLoggable5 = Log.isLoggable("COUI", 6);
        f9325e = isLoggable5;
        boolean isLoggable6 = Log.isLoggable("COUI", 7);
        f9326f = isLoggable6;
        f9327g = (isLoggable || isLoggable2 || isLoggable3 || isLoggable4 || isLoggable5 || isLoggable6) ? false : true;
    }

    private ResponsiveUILog() {
    }

    public final boolean getLOG_ASSERT() {
        return f9326f;
    }

    public final boolean getLOG_DEBUG() {
        return f9322b;
    }

    public final boolean getLOG_ERROR() {
        return f9325e;
    }

    public final boolean getLOG_INFO() {
        return f9323c;
    }

    public final boolean getLOG_SILENT() {
        return f9327g;
    }

    public final boolean getLOG_VERBOSE() {
        return f9321a;
    }

    public final boolean getLOG_WARN() {
        return f9324d;
    }

    public final boolean isLoggable(String str, int i3) {
        return Log.isLoggable(str, i3);
    }

    public final void logStatus(String str) {
        k.e(str, "tag");
        boolean isLoggable = k.a(str, "COUI") ? f9321a : Log.isLoggable(str, 2);
        boolean isLoggable2 = k.a(str, "COUI") ? f9322b : Log.isLoggable(str, 3);
        boolean isLoggable3 = k.a(str, "COUI") ? f9323c : Log.isLoggable(str, 2);
        boolean isLoggable4 = k.a(str, "COUI") ? f9324d : Log.isLoggable(str, 2);
        boolean isLoggable5 = k.a(str, "COUI") ? f9325e : Log.isLoggable(str, 2);
        boolean isLoggable6 = k.a(str, "COUI") ? f9326f : Log.isLoggable(str, 2);
        Log.println(7, "COUI", e.e("\n            Log status for tag: " + str + "\n            VERBOSE: " + isLoggable + "\n            DEBUG: " + isLoggable2 + "\n            INFO: " + isLoggable3 + "\n            WARN: " + isLoggable4 + "\n            ERROR: " + isLoggable5 + "\n            ASSERT: " + isLoggable6 + "\n            SILENT: " + (k.a(str, "COUI") ? f9327g : (isLoggable || isLoggable2 || isLoggable3 || isLoggable4 || isLoggable5 || isLoggable6) ? false : true) + "\n            "));
    }

    public final void logStatus() {
        logStatus("COUI");
    }
}
