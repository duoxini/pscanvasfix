package z0;

import android.util.Log;
import com.oplus.os.OplusBuild;

/* renamed from: z0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0647b {

    /* renamed from: a, reason: collision with root package name */
    private static String f14668a;

    /* renamed from: b, reason: collision with root package name */
    private static String f14669b;

    private static boolean a() {
        try {
            Class.forName("com.oplus.os.OplusBuild");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(int i3, int i4) {
        if (c() > i3) {
            return true;
        }
        return c() == i3 && d() >= i4;
    }

    public static int c() {
        f14668a = a() ? "com.oplus.os.OplusBuild" : C0646a.b().c();
        f14669b = a() ? "getOplusOSVERSION" : C0646a.b().d();
        try {
            Class.forName(f14668a);
            return OplusBuild.VERSION.SDK_VERSION;
        } catch (Throwable th) {
            Log.e("COUIVersionUtil", "getOSVersionCode failed. error = " + th.getMessage());
            return 0;
        }
    }

    public static int d() {
        try {
            return OplusBuild.VERSION.SDK_SUB_VERSION;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean e() {
        return c() != 0;
    }
}
