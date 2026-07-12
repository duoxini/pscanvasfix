package com.coui.appcompat.statement;

import D2.k;
import H2.d;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import d2.AbstractC0338a;

/* loaded from: classes.dex */
public final class COUIComponentMaxHeightScrollView extends COUIMaxHeightScrollView {

    /* renamed from: d0, reason: collision with root package name */
    private boolean f9229d0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public COUIComponentMaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.e(context, "context");
    }

    @Override // com.coui.appcompat.statement.COUIMaxHeightScrollView, com.coui.appcompat.scrollview.COUIScrollView, android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (getMaxHeight() > 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(d.c(getMaxHeight(), View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        if (this.f9229d0 && getChildCount() > 0) {
            measureChild(getChildAt(0), i3, i4);
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getChildAt(0).getMeasuredHeight() > View.MeasureSpec.getSize(i4) - getPaddingTop() ? getContext().getResources().getDimensionPixelOffset(AbstractC0338a.f11071a) : 0);
        }
        super.onMeasure(i3, i4);
    }

    public final void setProtocolFixed(boolean z3) {
        this.f9229d0 = z3;
    }
}
