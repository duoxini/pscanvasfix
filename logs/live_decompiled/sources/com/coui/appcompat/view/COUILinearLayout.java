package com.coui.appcompat.view;

import M1.m;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class COUILinearLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private int f9311e;

    /* renamed from: f, reason: collision with root package name */
    private int f9312f;

    public COUILinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getMaxHeight() {
        return this.f9312f;
    }

    public int getMaxWidth() {
        return this.f9311e;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (getOrientation() == 0 && this.f9311e >= 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), this.f9311e), Integer.MIN_VALUE);
        } else if (getOrientation() == 1 && this.f9312f >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i4), this.f9312f), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
    }

    public void setMaxHeight(int i3) {
        this.f9312f = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        this.f9311e = i3;
        requestLayout();
    }

    public COUILinearLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUILinearLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1538W);
        this.f9311e = obtainStyledAttributes.getDimensionPixelOffset(m.f1540Y, -1);
        this.f9312f = obtainStyledAttributes.getDimensionPixelOffset(m.f1539X, -1);
        obtainStyledAttributes.recycle();
    }
}
