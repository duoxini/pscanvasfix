package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.view.y;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f9623a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f9624b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f9625c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f9626d;

    /* renamed from: e, reason: collision with root package name */
    private final int f9627e;

    /* renamed from: f, reason: collision with root package name */
    private final U0.k f9628f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, U0.k kVar, Rect rect) {
        androidx.core.util.h.b(rect.left);
        androidx.core.util.h.b(rect.top);
        androidx.core.util.h.b(rect.right);
        androidx.core.util.h.b(rect.bottom);
        this.f9623a = rect;
        this.f9624b = colorStateList2;
        this.f9625c = colorStateList;
        this.f9626d = colorStateList3;
        this.f9627e = i3;
        this.f9628f = kVar;
    }

    static b a(Context context, int i3) {
        androidx.core.util.h.a(i3 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, H0.j.s3);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(H0.j.t3, 0), obtainStyledAttributes.getDimensionPixelOffset(H0.j.v3, 0), obtainStyledAttributes.getDimensionPixelOffset(H0.j.u3, 0), obtainStyledAttributes.getDimensionPixelOffset(H0.j.w3, 0));
        ColorStateList a3 = R0.c.a(context, obtainStyledAttributes, H0.j.x3);
        ColorStateList a4 = R0.c.a(context, obtainStyledAttributes, H0.j.C3);
        ColorStateList a5 = R0.c.a(context, obtainStyledAttributes, H0.j.A3);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(H0.j.B3, 0);
        U0.k m3 = U0.k.b(context, obtainStyledAttributes.getResourceId(H0.j.y3, 0), obtainStyledAttributes.getResourceId(H0.j.z3, 0)).m();
        obtainStyledAttributes.recycle();
        return new b(a3, a4, a5, dimensionPixelSize, m3, rect);
    }

    void b(TextView textView) {
        U0.g gVar = new U0.g();
        U0.g gVar2 = new U0.g();
        gVar.setShapeAppearanceModel(this.f9628f);
        gVar2.setShapeAppearanceModel(this.f9628f);
        gVar.U(this.f9625c);
        gVar.a0(this.f9627e, this.f9626d);
        textView.setTextColor(this.f9624b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f9624b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f9623a;
        y.n0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
