package com.oplus.backup.sdk.common.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class BRLog {
    private static final String DOT = ".";
    private static final String HIDE = "*";
    private static final String HIDE_MULTI = "*****";
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final Pattern PACKAGE_PATTERN = Pattern.compile("([a-z_][a-z0-9_]*(\\.[a-z_][a-z0-9_]*)+)");
    private static final Pattern PATH_PATTERN = Pattern.compile("/((\\w|\\.|-|\\*|#)+/?)+");
    private static final String SEPARATOR = "/";
    private static final String TAG = "BRLog";
    private static int sLevel = 5;

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static String getModifiedFile(File file) {
        return file == null ? "" : getModifiedPath(file.toString());
    }

    public static String getModifiedInfo(Object obj) {
        if (obj == null) {
            return "";
        }
        String obj2 = obj.toString();
        try {
            Matcher matcher = PATH_PATTERN.matcher(obj2);
            while (matcher.find()) {
                obj2 = obj2.replace(matcher.group(0), getModifiedPath(matcher.group(0)));
            }
            Matcher matcher2 = PACKAGE_PATTERN.matcher(obj2);
            while (matcher2.find()) {
                obj2 = obj2.replace(matcher2.group(0), getModifiedPkg(matcher2.group(0)));
            }
            return obj2;
        } catch (Exception unused) {
            return HIDE_MULTI;
        }
    }

    public static String getModifiedPath(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(SEPARATOR)) {
            return str;
        }
        String[] split = str.split(SEPARATOR);
        StringBuilder sb = new StringBuilder();
        if (split.length <= 3) {
            return str;
        }
        sb.append(SEPARATOR);
        sb.append(split[1]);
        sb.append(SEPARATOR);
        sb.append(HIDE_MULTI);
        sb.append(SEPARATOR);
        sb.append(split[split.length - 2]);
        sb.append(SEPARATOR);
        sb.append(split[split.length - 1]);
        return sb.toString();
    }

    public static String getModifiedPkg(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(DOT)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] split = str.split("\\.");
        if (split.length > 1) {
            sb.append(split[0]);
            sb.append(DOT);
            sb.append(HIDE_MULTI);
            for (int i3 = 2; i3 < split.length; i3++) {
                sb.append(DOT);
                sb.append(split[i3]);
            }
        }
        return sb.toString();
    }

    public static void i(String str, String str2) {
        if (sLevel <= 4) {
            Log.i(str, str2);
        }
    }

    public static void setLogLevel(int i3) {
        sLevel = i3;
        Log.i(TAG, "setLogLevel:" + i3);
    }

    public static void v(String str, String str2) {
        if (sLevel <= 2) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (sLevel <= 5) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (sLevel <= 3) {
            if (th == null) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (sLevel <= 6) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (sLevel <= 3) {
            if (th == null) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, th);
            }
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (sLevel <= 3) {
            if (th == null) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (sLevel <= 6) {
            if (th == null) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, th);
            }
        }
    }
}
