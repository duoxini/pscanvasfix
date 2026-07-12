package z1;

import android.util.Log;

/* renamed from: z1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0652e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f14682a = false;

    /* renamed from: b, reason: collision with root package name */
    private static int f14683b = 2;

    static {
        Log.i("OShare LogMsg", "true");
        f14683b = 2;
        f14682a = true;
    }

    public static void a(String str) {
        if (f14683b <= 3) {
            Log.d("ZoomAppController", str);
        }
    }

    public static void b(String str, String str2) {
        if (f14683b <= 3) {
            Log.d("ZoomAppController" + str, str2);
        }
    }

    public static void c(String str) {
        if (f14683b <= 6) {
            Log.e("ZoomAppController", str);
        }
    }

    public static void d(String str, String str2) {
        if (f14683b <= 6) {
            Log.e("ZoomAppController" + str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f14683b <= 6) {
            Log.e(str, str2, th);
        }
    }

    public static void f(String str) {
        if (f14683b <= 4) {
            Log.i("ZoomAppController", str);
        }
    }

    public static void g(String str, String str2) {
        if (f14683b <= 4) {
            Log.i("ZoomAppController" + str, str2);
        }
    }

    public static void h(String str, String str2) {
        if (f14683b <= 2) {
            Log.v("ZoomAppController" + str, str2);
        }
    }

    public static void i(String str) {
        if (f14683b <= 5) {
            Log.w("ZoomAppController", str);
        }
    }

    public static void j(String str, String str2) {
        if (f14683b <= 5) {
            Log.w("ZoomAppController" + str, str2);
        }
    }
}
