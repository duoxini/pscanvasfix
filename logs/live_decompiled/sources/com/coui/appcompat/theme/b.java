package com.coui.appcompat.theme;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f9279a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f9280b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f9281c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f9282d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f9283e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f9284f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f9285g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f9286h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f9287i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f9288j = new int[1];

    public static int a(Context context, int i3) {
        int[] iArr = f9288j;
        iArr[0] = i3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
