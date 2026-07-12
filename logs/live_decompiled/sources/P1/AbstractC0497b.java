package p1;

import android.util.Log;

/* renamed from: p1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0497b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f12795a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12796b = false;

    public static boolean a() {
        return f12796b;
    }

    public static boolean b() {
        return f12795a;
    }

    public static void c(String str) {
        d("PhysicsWorld", str);
    }

    public static void d(String str, String str2) {
        Log.d(str, str2);
    }
}
