package com.coui.appcompat.button;

import M1.m;
import N1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class COUIButtonLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private int f7529e;

    /* renamed from: f, reason: collision with root package name */
    private int f7530f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7531g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f7532h;

    /* renamed from: i, reason: collision with root package name */
    private int f7533i;

    /* renamed from: j, reason: collision with root package name */
    private int f7534j;

    /* renamed from: k, reason: collision with root package name */
    private int f7535k;

    /* renamed from: l, reason: collision with root package name */
    private int f7536l;

    public COUIButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7531g = false;
        this.f7532h = false;
        a();
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, m.f1578s);
            this.f7533i = (int) obtainStyledAttributes.getDimension(m.f1582u, this.f7533i);
            this.f7534j = (int) obtainStyledAttributes.getDimension(m.f1584v, this.f7534j);
            this.f7536l = (int) obtainStyledAttributes.getDimension(m.f1580t, this.f7536l);
            obtainStyledAttributes.recycle();
        }
        setPaddingHorizontal(0);
    }

    private void a() {
        this.f7535k = getOrientation();
        this.f7533i = getResources().getDimensionPixelSize(a.f1620a);
        this.f7534j = getResources().getDimensionPixelSize(a.f1621b);
    }

    private void setPaddingHorizontal(int i3) {
        if (i3 == 0) {
            i3 = getOrientation() == 0 ? this.f7533i : this.f7534j;
        }
        setPaddingRelative(i3, getPaddingTop(), i3, getPaddingBottom());
    }

    public int getMaxHeight() {
        return this.f7530f;
    }

    public int getMaxWidth() {
        return this.f7529e;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int i5 = this.f7536l;
        if (i5 <= 0 || !(mode == Integer.MIN_VALUE || mode == 1073741824)) {
            this.f7529e = View.MeasureSpec.getSize(i3);
        } else {
            int min = Math.min(i5, View.MeasureSpec.getSize(i3));
            this.f7529e = min;
            i3 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        }
        this.f7530f = View.MeasureSpec.getSize(i4);
        super.onMeasure(i3, i4);
    }

    public void setHorizontalLayoutPadding(int i3) {
        this.f7533i = i3;
        if (getOrientation() == 0) {
            setPaddingHorizontal(this.f7533i);
        }
    }

    public void setLimitHeight(boolean z3) {
        this.f7531g = z3;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        super.setOrientation(i3);
        if (this.f7535k != i3) {
            setPaddingHorizontal(0);
            this.f7535k = i3;
        }
    }

    public void setVerticalLayoutPadding(int i3) {
        this.f7534j = i3;
        if (getOrientation() == 1) {
            setPaddingHorizontal(this.f7534j);
        }
    }
}
