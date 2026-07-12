package com.google.android.material.timepicker;

import H0.e;
import H0.j;
import U0.g;
import U0.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import androidx.core.view.y;

/* loaded from: classes.dex */
abstract class b extends ConstraintLayout {

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f10014e;

    /* renamed from: f, reason: collision with root package name */
    private int f10015f;

    /* renamed from: g, reason: collision with root package name */
    private g f10016g;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.r();
        }
    }

    public b(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(H0.g.f607l, this);
        y.n0(this, k());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.w4, i3, 0);
        this.f10015f = obtainStyledAttributes.getDimensionPixelSize(j.x4, 0);
        this.f10014e = new a();
        obtainStyledAttributes.recycle();
    }

    private Drawable k() {
        g gVar = new g();
        this.f10016g = gVar;
        gVar.S(new i(0.5f));
        this.f10016g.U(ColorStateList.valueOf(-1));
        return this.f10016g;
    }

    private static boolean q(View view) {
        return "skip".equals(view.getTag());
    }

    private void s() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f10014e);
            handler.post(this.f10014e);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            view.setId(y.i());
        }
        s();
    }

    public int l() {
        return this.f10015f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        r();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        s();
    }

    public void p(int i3) {
        this.f10015f = i3;
        r();
    }

    protected void r() {
        int childCount = getChildCount();
        int i3 = 1;
        for (int i4 = 0; i4 < childCount; i4++) {
            if (q(getChildAt(i4))) {
                i3++;
            }
        }
        d dVar = new d();
        dVar.g(this);
        float f3 = 0.0f;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getId() != e.f569b && !q(childAt)) {
                dVar.h(childAt.getId(), e.f569b, this.f10015f, f3);
                f3 += 360.0f / (childCount - i3);
            }
        }
        dVar.c(this);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f10016g.U(ColorStateList.valueOf(i3));
    }
}
