package A0;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import z0.C0646a;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f43a = true;

    /* renamed from: b, reason: collision with root package name */
    private static String f44b;

    private static boolean a() {
        try {
            Class.forName("com.oplus.inner.view.ViewWrapper");
            return true;
        } catch (Exception e3) {
            Log.d("ViewNative", e3.toString());
            return false;
        }
    }

    public static void b(View view, int i3) {
        String f3 = a() ? "com.oplus.inner.view.ViewWrapper" : C0646a.b().f();
        f44b = f3;
        try {
            if (f43a) {
                Class.forName(f3).getDeclaredMethod("setScrollXForColor", View.class, Integer.TYPE).invoke(null, view, Integer.valueOf(i3));
            } else {
                Field declaredField = View.class.getDeclaredField("mScrollX");
                declaredField.setAccessible(true);
                declaredField.setInt(view, i3);
            }
        } catch (Exception e3) {
            Log.d("ViewNative", e3.toString());
        }
    }

    public static void c(View view, int i3) {
        String f3 = a() ? "com.oplus.inner.view.ViewWrapper" : C0646a.b().f();
        f44b = f3;
        try {
            if (f43a) {
                Class.forName(f3).getDeclaredMethod("setScrollYForColor", View.class, Integer.TYPE).invoke(null, view, Integer.valueOf(i3));
            } else {
                Field declaredField = View.class.getDeclaredField("mScrollY");
                declaredField.setAccessible(true);
                declaredField.setInt(view, i3);
            }
        } catch (Exception e3) {
            Log.d("ViewNative", e3.toString());
        }
    }
}
