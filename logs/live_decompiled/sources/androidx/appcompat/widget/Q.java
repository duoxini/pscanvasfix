package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: classes.dex */
public abstract class Q {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4009a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f4010b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f4011c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f4012d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f4013e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f4014f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f4015g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f4016h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f4017i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f4018j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(e.j.f11453y0);
        try {
            if (!obtainStyledAttributes.hasValue(e.j.f11267D0)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i3) {
        ColorStateList e3 = e(context, i3);
        if (e3 != null && e3.isStateful()) {
            return e3.getColorForState(f4010b, e3.getDefaultColor());
        }
        TypedValue f3 = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, f3, true);
        return d(context, i3, f3.getFloat());
    }

    public static int c(Context context, int i3) {
        int[] iArr = f4018j;
        iArr[0] = i3;
        V v3 = V.v(context, null, iArr);
        try {
            return v3.b(0, 0);
        } finally {
            v3.x();
        }
    }

    static int d(Context context, int i3, float f3) {
        return androidx.core.graphics.a.n(c(context, i3), Math.round(Color.alpha(r0) * f3));
    }

    public static ColorStateList e(Context context, int i3) {
        int[] iArr = f4018j;
        iArr[0] = i3;
        V v3 = V.v(context, null, iArr);
        try {
            return v3.c(0);
        } finally {
            v3.x();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f4009a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
