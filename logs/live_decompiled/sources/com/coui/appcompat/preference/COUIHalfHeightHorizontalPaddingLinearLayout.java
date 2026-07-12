package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class COUIHalfHeightHorizontalPaddingLinearLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private int f8529e;

    /* renamed from: f, reason: collision with root package name */
    private View f8530f;

    /* renamed from: g, reason: collision with root package name */
    private View f8531g;

    public COUIHalfHeightHorizontalPaddingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8529e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2827x);
        this.f8529e = obtainStyledAttributes.getDimensionPixelSize(W1.h.f2829y, this.f8529e);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (getChildCount() == 2) {
            this.f8530f = getChildAt(0);
            this.f8531g = getChildAt(1);
            if (this.f8530f.getMeasuredHeight() < this.f8531g.getMeasuredHeight()) {
                setPadding(getPaddingStart(), 0, getPaddingEnd(), 0);
            }
            int measuredHeight = getMeasuredHeight() / 2;
            if (measuredHeight >= this.f8529e) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            int dimensionPixelSize = getResources().getDimensionPixelSize(W1.c.f2621L);
            if (measuredHeight != getPaddingStart() || measuredHeight != getPaddingEnd() || layoutParams.getMarginEnd() == dimensionPixelSize || layoutParams.getMarginEnd() == 0) {
                setPadding(measuredHeight, getPaddingTop(), measuredHeight, getPaddingBottom());
                if (measuredHeight < this.f8529e) {
                    layoutParams.setMarginEnd((layoutParams.getMarginEnd() + this.f8529e) - measuredHeight);
                    setLayoutParams(layoutParams);
                }
                super.onMeasure(i3, i4);
            }
        }
    }
}
