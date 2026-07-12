package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    final b f9629a;

    /* renamed from: b, reason: collision with root package name */
    final b f9630b;

    /* renamed from: c, reason: collision with root package name */
    final b f9631c;

    /* renamed from: d, reason: collision with root package name */
    final b f9632d;

    /* renamed from: e, reason: collision with root package name */
    final b f9633e;

    /* renamed from: f, reason: collision with root package name */
    final b f9634f;

    /* renamed from: g, reason: collision with root package name */
    final b f9635g;

    /* renamed from: h, reason: collision with root package name */
    final Paint f9636h;

    c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R0.b.c(context, H0.a.f491w, h.class.getCanonicalName()), H0.j.j3);
        this.f9629a = b.a(context, obtainStyledAttributes.getResourceId(H0.j.m3, 0));
        this.f9635g = b.a(context, obtainStyledAttributes.getResourceId(H0.j.k3, 0));
        this.f9630b = b.a(context, obtainStyledAttributes.getResourceId(H0.j.l3, 0));
        this.f9631c = b.a(context, obtainStyledAttributes.getResourceId(H0.j.n3, 0));
        ColorStateList a3 = R0.c.a(context, obtainStyledAttributes, H0.j.o3);
        this.f9632d = b.a(context, obtainStyledAttributes.getResourceId(H0.j.q3, 0));
        this.f9633e = b.a(context, obtainStyledAttributes.getResourceId(H0.j.p3, 0));
        this.f9634f = b.a(context, obtainStyledAttributes.getResourceId(H0.j.r3, 0));
        Paint paint = new Paint();
        this.f9636h = paint;
        paint.setColor(a3.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
