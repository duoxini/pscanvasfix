package h0;

import android.util.Log;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0371a {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f11872a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f11873b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f11874c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f11875d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f11876e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f11877f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f11878g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f11879h;

    /* renamed from: i, reason: collision with root package name */
    private static int f11880i;

    static {
        boolean e3 = e("COUI", 2);
        f11872a = e3;
        boolean e4 = e("COUI", 3);
        f11873b = e4;
        boolean e5 = e("COUI", 4);
        f11874c = e5;
        boolean e6 = e("COUI", 5);
        f11875d = e6;
        boolean e7 = e("COUI", 6);
        f11876e = e7;
        boolean e8 = e("COUI", 7);
        f11877f = e8;
        f11878g = (e3 || e4 || e5 || e6 || e7 || e8) ? false : true;
        f11879h = null;
        f11880i = 4;
    }

    public static void a(String str, String str2) {
        if (f11880i <= 3 || Log.isLoggable(str, 3) || f11873b) {
            Log.d(str, str2);
        }
    }

    public static void b(boolean z3, String str, String str2) {
        if (z3) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f11880i <= 6 || Log.isLoggable(str, 6) || f11876e) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (f11880i <= 4 || Log.isLoggable(str, 4) || f11874c) {
            Log.i(str, str2);
        }
    }

    public static boolean e(String str, int i3) {
        return Log.isLoggable(str, i3);
    }

    public static void f(String str, String str2) {
        if (f11880i <= 2 || Log.isLoggable(str, 2) || f11872a) {
            Log.v(str, str2);
        }
    }

    public static void g(String str, String str2) {
        if (f11880i <= 5 || Log.isLoggable(str, 5) || f11875d) {
            Log.w(str, str2);
        }
    }
}
