package com.customer.feedback.sdk.util;

import D2.k;
import K2.e;
import android.content.Context;
import android.util.Log;
import com.customer.feedback.sdk.feedbacka;
import m2.AbstractC0468c;

/* loaded from: classes.dex */
public final class LogUtil {
    public static final LogUtil INSTANCE = new LogUtil();
    private static final String SEPRATEOR = "->";
    public static final String TAG = "feedbackSDK";
    private static boolean isDebugMode;
    private static final String special;

    static {
        Context context = feedbacka.feedbackf;
        special = "feedbackSDK16.1.4";
        isDebugMode = checkDebug();
    }

    private LogUtil() {
    }

    private static final boolean checkDebug() {
        return e.l(AbstractC0468c.e("persist.sys.assert.panic", "false"), "true", true) || e.l(AbstractC0468c.e("persist.sys.assert.enable", "false"), "true", true);
    }

    public static final void d(String str, String str2) {
        k.e(str2, "debugInfo");
        if (isDebugMode) {
            Log.d(str, special + SEPRATEOR + str2);
        }
    }

    public static final void e(String str, Throwable th) {
        k.e(th, "e");
        if (isDebugMode) {
            Log.e(str, special + SEPRATEOR + th);
        }
    }

    public static final void i(String str, String str2) {
        k.e(str2, "debugInfo");
        if (isDebugMode) {
            Log.i(str, special + SEPRATEOR + str2);
        }
    }

    public static final void setIsDebugMode(boolean z3) {
        isDebugMode = z3;
    }

    public static final void v(String str, String str2) {
        k.e(str2, "debugInfo");
        if (isDebugMode) {
            Log.v(str, special + SEPRATEOR + str2);
        }
    }

    public static final void w(String str, String str2) {
        k.e(str2, "debugInfo");
        if (isDebugMode) {
            Log.w(str, special + SEPRATEOR + str2);
        }
    }

    public final boolean isDebugMode() {
        return isDebugMode;
    }

    public final void setDebugMode(boolean z3) {
        isDebugMode = z3;
    }

    public static final void e(String str, String str2) {
        k.e(str2, "debugInfo");
        if (isDebugMode) {
            Log.e(str, special + SEPRATEOR + str2);
        }
    }

    public static final void e(String str, String str2, Exception exc) {
        k.e(str2, "debugInfo");
        if (isDebugMode) {
            Log.e(str, special + SEPRATEOR + str2, exc);
        }
    }
}
