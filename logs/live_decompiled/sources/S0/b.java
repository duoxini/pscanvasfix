package S0;

import android.R;
import android.content.res.ColorStateList;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2070a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2071b = {R.attr.state_pressed};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f2072c = {R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f2073d = {R.attr.state_focused};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f2074e = {R.attr.state_hovered};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f2075f = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f2076g = {R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f2077h = {R.attr.state_selected, R.attr.state_focused};

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f2078i = {R.attr.state_selected, R.attr.state_hovered};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f2079j = {R.attr.state_selected};

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f2080k = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: l, reason: collision with root package name */
    static final String f2081l = b.class.getSimpleName();

    public static ColorStateList a(ColorStateList colorStateList) {
        return colorStateList != null ? colorStateList : ColorStateList.valueOf(0);
    }

    public static boolean b(int[] iArr) {
        boolean z3 = false;
        boolean z4 = false;
        for (int i3 : iArr) {
            if (i3 == 16842910) {
                z3 = true;
            } else if (i3 == 16842908 || i3 == 16842919 || i3 == 16843623) {
                z4 = true;
            }
        }
        return z3 && z4;
    }
}
