package com.coui.appcompat.statement;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import c2.AbstractC0299a;
import com.coui.appcompat.scrollview.COUIScrollView;

/* loaded from: classes.dex */
public class COUIMaxHeightScrollView extends COUIScrollView {

    /* renamed from: b0, reason: collision with root package name */
    private int f9230b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f9231c0;

    public COUIMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getMaxHeight() {
        return this.f9230b0;
    }

    public int getMinHeight() {
        return this.f9231c0;
    }

    @Override // com.coui.appcompat.scrollview.COUIScrollView, android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int size = View.MeasureSpec.getSize(i4);
        int i5 = this.f9230b0;
        if (i5 > 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, size), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
        int measuredHeight = getMeasuredHeight();
        int i6 = this.f9231c0;
        if (measuredHeight < i6) {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
        }
    }

    public void setMaxHeight(int i3) {
        this.f9230b0 = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        this.f9231c0 = i3;
        requestLayout();
    }

    public COUIMaxHeightScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0299a.f7437b);
        this.f9230b0 = obtainStyledAttributes.getDimensionPixelOffset(AbstractC0299a.f7438c, 0);
        this.f9231c0 = obtainStyledAttributes.getDimensionPixelOffset(AbstractC0299a.f7439d, 0);
        obtainStyledAttributes.recycle();
    }
}
