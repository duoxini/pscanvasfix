package L0;

import R0.b;
import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public abstract class a {
    public static int a(int i3, int i4) {
        return androidx.core.graphics.a.n(i3, (Color.alpha(i3) * i4) / 255);
    }

    public static int b(Context context, int i3, int i4) {
        TypedValue a3 = b.a(context, i3);
        return a3 != null ? a3.data : i4;
    }

    public static int c(Context context, int i3, String str) {
        return b.c(context, i3, str);
    }

    public static int d(View view, int i3) {
        return b.d(view, i3);
    }

    public static int e(View view, int i3, int i4) {
        return b(view.getContext(), i3, i4);
    }

    public static boolean f(int i3) {
        return i3 != 0 && androidx.core.graphics.a.e(i3) > 0.5d;
    }

    public static int g(int i3, int i4) {
        return androidx.core.graphics.a.i(i4, i3);
    }

    public static int h(int i3, int i4, float f3) {
        return g(i3, androidx.core.graphics.a.n(i4, Math.round(Color.alpha(i4) * f3)));
    }

    public static int i(View view, int i3, int i4, float f3) {
        return h(d(view, i3), d(view, i4), f3);
    }
}
