package com.google.android.material.internal;

import H0.e;
import H0.j;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.AbstractC0259h;
import androidx.core.view.y;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(Context context) {
        this(context, null);
    }

    private static int getMeasuredDimension(int i3, int i4, int i5) {
        return i4 != Integer.MIN_VALUE ? i4 != 1073741824 ? i5 : i3 : Math.min(i5, i3);
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, j.f774d2, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(j.f782f2, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(j.f778e2, 0);
        obtainStyledAttributes.recycle();
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    protected int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(View view) {
        Object tag = view.getTag(e.f555E);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        this.rowCount = 1;
        boolean z4 = y.x(this) == 1;
        int paddingRight = z4 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z4 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i9 = (i5 - i3) - paddingLeft;
        int i10 = paddingRight;
        int i11 = paddingTop;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(e.f555E, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = AbstractC0259h.b(marginLayoutParams);
                    i7 = AbstractC0259h.a(marginLayoutParams);
                } else {
                    i7 = 0;
                    i8 = 0;
                }
                int measuredWidth = i10 + i8 + childAt.getMeasuredWidth();
                if (!this.singleLine && measuredWidth > i9) {
                    i11 = this.lineSpacing + paddingTop;
                    this.rowCount++;
                    i10 = paddingRight;
                }
                childAt.setTag(e.f555E, Integer.valueOf(this.rowCount - 1));
                int i13 = i10 + i8;
                int measuredWidth2 = childAt.getMeasuredWidth() + i13;
                int measuredHeight = childAt.getMeasuredHeight() + i11;
                if (z4) {
                    childAt.layout(i9 - measuredWidth2, i11, (i9 - i10) - i8, measuredHeight);
                } else {
                    childAt.layout(i13, i11, measuredWidth2, measuredHeight);
                }
                i10 += i8 + i7 + childAt.getMeasuredWidth() + this.itemSpacing;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i4);
        int i8 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Preference.DEFAULT_ORDER;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i8 - getPaddingRight();
        int i9 = paddingTop;
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i3, i4);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i5 = marginLayoutParams.leftMargin;
                    i6 = marginLayoutParams.rightMargin;
                } else {
                    i5 = 0;
                    i6 = 0;
                }
                int i12 = paddingLeft;
                if (paddingLeft + i5 + childAt.getMeasuredWidth() <= paddingRight || isSingleLine()) {
                    i7 = i12;
                } else {
                    i7 = getPaddingLeft();
                    i9 = this.lineSpacing + paddingTop;
                }
                int measuredWidth = i7 + i5 + childAt.getMeasuredWidth();
                int measuredHeight = i9 + childAt.getMeasuredHeight();
                if (measuredWidth > i10) {
                    i10 = measuredWidth;
                }
                paddingLeft = i7 + i5 + i6 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i11 == getChildCount() - 1) {
                    i10 += i6;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i10 + getPaddingRight()), getMeasuredDimension(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i3) {
        this.itemSpacing = i3;
    }

    protected void setLineSpacing(int i3) {
        this.lineSpacing = i3;
    }

    public void setSingleLine(boolean z3) {
        this.singleLine = z3;
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    @TargetApi(21)
    public FlowLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }
}
