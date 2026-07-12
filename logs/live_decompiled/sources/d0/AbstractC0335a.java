package d0;

import M1.c;
import M1.m;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;

/* renamed from: d0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0335a {
    public static int a(Context context, int i3) {
        return (i3 == c.f1366k || i3 == c.f1362g) ? l(b(context, i3, 0), b(context, c.f1360e, 0)) : i3 == c.f1367l ? l(b(context, i3, 0), b(context, c.f1371p, 0)) : b(context, i3, 0);
    }

    public static int b(Context context, int i3, int i4) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i3});
        int color = obtainStyledAttributes.getColor(0, i4);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static int c(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i3});
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static float d(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i3});
        float dimension = obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
        return dimension;
    }

    public static float e(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i3});
        float f3 = obtainStyledAttributes.getFloat(0, 0.0f);
        obtainStyledAttributes.recycle();
        return f3;
    }

    public static int f(Context context, int i3, int i4) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i3});
        int resourceId = obtainStyledAttributes.getResourceId(0, i4);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static String g(Context context, int i3) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i3});
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        return string;
    }

    public static int h(Context context, int i3) {
        return context.getColor(i3);
    }

    public static float i(Context context, int i3) {
        TypedValue typedValue = new TypedValue();
        try {
            context.getResources().getValue(i3, typedValue, true);
            return typedValue.getFloat();
        } catch (Resources.NotFoundException | NumberFormatException e3) {
            Log.e("COUIContextUtil", "getFloat: failed error=" + e3);
            return 0.0f;
        }
    }

    public static boolean j(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(m.f1518E0);
        boolean z3 = obtainStyledAttributes.getBoolean(m.f1520F0, false);
        obtainStyledAttributes.recycle();
        return z3;
    }

    public static boolean k(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(m.f1518E0);
        boolean z3 = obtainStyledAttributes.getBoolean(m.f1522G0, false);
        obtainStyledAttributes.recycle();
        return z3;
    }

    private static int l(int i3, int i4) {
        return androidx.core.graphics.a.n(i4, Color.alpha(i3));
    }
}
