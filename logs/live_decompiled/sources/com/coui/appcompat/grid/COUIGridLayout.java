package com.coui.appcompat.grid;

import Q1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import y0.j;

/* loaded from: classes.dex */
public class COUIGridLayout extends GridLayout {
    public static final int GRID_MODE = 0;
    private static final int LARGE_MARGIN = 0;
    private static final int SMALL_MARGIN = 1;
    public static final int SPECIFIC_GAP_MODE = 1;
    public static final int SPECIFIC_SIZE_MODE = 2;
    private int[] mBottomMargin;
    private int mChildGridNumber;
    private float mChildHeight;
    private float mChildMinHeight;
    private float mChildMinWidth;
    private float mChildWidth;
    private int mColumn;
    private int[] mEndMargin;
    private int mGridMargin;
    private int mGridMarginType;
    private float[] mGridModeColumnWidth;
    private float mHorizontalGap;
    private boolean mIsIgnoreChildMargin;
    private int[] mMaxHorizontalMargin;
    private int[] mMaxVerticalMargin;
    private float mMinHorizontalGap;
    private ResponsiveUIModel mResponsiveUIModel;
    private int[] mStartMargin;
    private int[] mTopMargin;
    private int mType;
    private float mVerticalGap;

    public COUIGridLayout(Context context) {
        this(context, null);
    }

    private int adjustHorizontalMargin() {
        if (this.mIsIgnoreChildMargin) {
            return 0;
        }
        this.mMaxHorizontalMargin = new int[this.mColumn + 1];
        int i3 = 0;
        for (int i4 = 0; i4 <= this.mColumn; i4++) {
            int i5 = i4;
            while (true) {
                int[] iArr = this.mStartMargin;
                if (i5 < iArr.length) {
                    int i6 = this.mColumn;
                    if (i4 < i6) {
                        int[] iArr2 = this.mMaxHorizontalMargin;
                        int i7 = iArr2[i4];
                        int i8 = iArr[i5];
                        if (i7 < i8) {
                            iArr2[i4] = i8;
                        }
                    }
                    if (i4 > 0 && i5 > 0) {
                        int[] iArr3 = this.mEndMargin;
                        if (i5 <= iArr3.length) {
                            int[] iArr4 = this.mMaxHorizontalMargin;
                            int i9 = iArr4[i4];
                            int i10 = iArr3[i5 - 1];
                            if (i9 < i10) {
                                iArr4[i4] = i10;
                            }
                        }
                    }
                    i5 += i6;
                }
            }
            i3 += this.mMaxHorizontalMargin[i4];
        }
        return i3;
    }

    private float calculateChildHeight() {
        float f3 = this.mChildHeight;
        if (f3 != 0.0f) {
            return f3;
        }
        float f4 = this.mChildMinHeight;
        if (f4 == 0.0f) {
            return 0.0f;
        }
        return (f4 / this.mChildMinWidth) * this.mChildWidth;
    }

    private int calculateHorizontalMargin() {
        int i3;
        int i4;
        if (this.mIsIgnoreChildMargin) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 <= this.mColumn; i6++) {
            int i7 = i6;
            int i8 = 0;
            while (true) {
                int[] iArr = this.mStartMargin;
                if (i7 < iArr.length) {
                    int i9 = this.mColumn;
                    if (i6 < i9 && i8 < (i4 = iArr[i7])) {
                        i8 = i4;
                    }
                    if (i6 > 0 && i7 > 0) {
                        int[] iArr2 = this.mEndMargin;
                        if (i7 <= iArr2.length && i8 < (i3 = iArr2[i7 - 1])) {
                            i8 = i3;
                        }
                    }
                    i7 += i9;
                }
            }
            i5 += i8;
        }
        return i5;
    }

    private void calculateInGridMode() {
        if (getContext() == null) {
            return;
        }
        this.mResponsiveUIModel.rebuild(getMeasuredWidth(), j.j(getContext())).chooseMargin(this.mGridMarginType == 1 ? MarginType.MARGIN_SMALL : MarginType.MARGIN_LARGE);
        this.mGridMargin = this.mResponsiveUIModel.margin();
        this.mHorizontalGap = this.mResponsiveUIModel.gutter();
        this.mColumn = this.mResponsiveUIModel.columnCount() / this.mChildGridNumber;
        int i3 = 0;
        this.mChildWidth = this.mResponsiveUIModel.width(0, r2 - 1);
        this.mGridModeColumnWidth = new float[this.mChildGridNumber];
        while (true) {
            int i4 = this.mColumn;
            if (i3 >= i4) {
                this.mMaxHorizontalMargin = new int[i4 + 1];
                return;
            }
            float[] fArr = this.mGridModeColumnWidth;
            ResponsiveUIModel responsiveUIModel = this.mResponsiveUIModel;
            int i5 = this.mChildGridNumber;
            fArr[i3] = responsiveUIModel.width(i3 * i5, (i5 * r6) - 1);
            i3++;
        }
    }

    private void calculateInSpecificGapMode() {
        float widthWithoutPadding = getWidthWithoutPadding();
        float f3 = this.mHorizontalGap;
        this.mColumn = Math.max(1, (int) ((widthWithoutPadding + f3) / (f3 + this.mChildMinWidth)));
        float widthWithoutPadding2 = getWidthWithoutPadding() - calculateHorizontalMargin();
        float f4 = this.mHorizontalGap;
        this.mColumn = Math.max(1, (int) ((widthWithoutPadding2 + f4) / (f4 + this.mChildMinWidth)));
        float widthWithoutPadding3 = getWidthWithoutPadding() - adjustHorizontalMargin();
        float f5 = this.mHorizontalGap;
        this.mChildWidth = Math.max(0.0f, (widthWithoutPadding3 - (f5 * (r2 - 1))) / this.mColumn);
        this.mChildHeight = calculateChildHeight();
    }

    private void calculateInSpecificSizeMode() {
        float widthWithoutPadding = getWidthWithoutPadding();
        float f3 = this.mMinHorizontalGap;
        this.mColumn = Math.max(1, (int) ((widthWithoutPadding + f3) / (f3 + this.mChildWidth)));
        float widthWithoutPadding2 = getWidthWithoutPadding() - calculateHorizontalMargin();
        float f4 = this.mMinHorizontalGap;
        this.mColumn = Math.max(1, (int) ((widthWithoutPadding2 + f4) / (f4 + this.mChildWidth)));
        this.mHorizontalGap = Math.max(0.0f, ((getWidthWithoutPadding() - adjustHorizontalMargin()) - (this.mChildWidth * this.mColumn)) / (r3 - 1));
    }

    private void calculateMargins() {
        int childCount = getChildCount();
        this.mTopMargin = new int[childCount];
        this.mBottomMargin = new int[childCount];
        this.mStartMargin = new int[childCount];
        this.mEndMargin = new int[childCount];
        if (this.mIsIgnoreChildMargin) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8) {
                this.mTopMargin[i3] = marginLayoutParams.topMargin;
                this.mBottomMargin[i3] = marginLayoutParams.bottomMargin;
                this.mStartMargin[i3] = marginLayoutParams.getMarginStart();
                this.mEndMargin[i3] = marginLayoutParams.getMarginEnd();
                i3++;
            }
        }
    }

    private int calculateVerticalMargin(int i3) {
        int i4;
        int i5 = 0;
        if (this.mIsIgnoreChildMargin) {
            return 0;
        }
        this.mMaxVerticalMargin = new int[i3 + 1];
        int i6 = 0;
        while (i5 <= i3) {
            int i7 = this.mColumn * i5;
            while (true) {
                i4 = i5 + 1;
                int i8 = this.mColumn;
                if (i7 < i4 * i8) {
                    int[] iArr = this.mTopMargin;
                    if (i7 < iArr.length) {
                        int[] iArr2 = this.mMaxVerticalMargin;
                        int i9 = iArr2[i5];
                        int i10 = iArr[i7];
                        if (i9 < i10) {
                            iArr2[i5] = i10;
                        }
                    }
                    if (i5 > 0 && i7 > 0) {
                        int i11 = i7 - i8;
                        int[] iArr3 = this.mBottomMargin;
                        if (i11 < iArr3.length) {
                            int[] iArr4 = this.mMaxVerticalMargin;
                            if (iArr4[i5] < iArr3[i7 - i8]) {
                                iArr4[i5] = iArr3[i7 - i8];
                            }
                        }
                    }
                    i7++;
                }
            }
            i6 += this.mMaxVerticalMargin[i5];
            i5 = i4;
        }
        return i6;
    }

    private int getVisibleChildCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4).getVisibility() != 8) {
                i3++;
            }
        }
        return i3;
    }

    private int getWidthWithoutPadding() {
        return (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.f1924a);
            this.mHorizontalGap = obtainStyledAttributes.getDimension(c.f1936g, 0.0f);
            this.mMinHorizontalGap = obtainStyledAttributes.getDimension(c.f1942j, 0.0f);
            this.mVerticalGap = obtainStyledAttributes.getDimension(c.f1938h, 0.0f);
            this.mChildMinWidth = obtainStyledAttributes.getDimension(c.f1932e, 0.0f);
            this.mChildMinHeight = obtainStyledAttributes.getDimension(c.f1930d, 0.0f);
            this.mChildHeight = obtainStyledAttributes.getDimension(c.f1928c, 0.0f);
            this.mChildWidth = obtainStyledAttributes.getDimension(c.f1934f, 0.0f);
            this.mChildGridNumber = obtainStyledAttributes.getInteger(c.f1926b, 0);
            this.mGridMarginType = obtainStyledAttributes.getInteger(c.f1940i, 1);
            this.mType = obtainStyledAttributes.getInteger(c.f1944k, 0);
            obtainStyledAttributes.recycle();
        }
    }

    private void initUIManager() {
        if (getContext() != null) {
            this.mResponsiveUIModel = new ResponsiveUIModel(getContext(), 0, 0);
        }
    }

    private boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    private int measureHeight(int i3, double d3) {
        int calculateVerticalMargin = calculateVerticalMargin((int) d3);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(size, (int) ((this.mChildHeight * d3) + ((d3 - 1.0d) * this.mVerticalGap) + calculateVerticalMargin));
        }
        if (mode == 0) {
            return (int) ((this.mChildHeight * d3) + ((d3 - 1.0d) * this.mVerticalGap) + calculateVerticalMargin);
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    @Override // android.widget.GridLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        super.onLayout(z3, i3, i4, i5, i6);
        int paddingStart = getPaddingStart() + this.mGridMargin;
        int paddingTop = getPaddingTop();
        int i9 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            float f3 = this.mType == 0 ? this.mGridModeColumnWidth[i10 % this.mColumn] : this.mChildWidth;
            int max = this.mIsIgnoreChildMargin ? 0 : Math.max(0, this.mMaxHorizontalMargin[i9 % this.mColumn]);
            int max2 = this.mIsIgnoreChildMargin ? 0 : Math.max(0, this.mMaxVerticalMargin[i9 / this.mColumn]);
            if (childAt.getVisibility() != 8) {
                if (isLayoutRTL()) {
                    i8 = (getWidth() - paddingStart) - max;
                    i7 = (int) (i8 - f3);
                } else {
                    i7 = paddingStart + max;
                    i8 = (int) (i7 + f3);
                }
                int i11 = paddingTop + max2;
                childAt.layout(i7, i11, i8, (int) (i11 + this.mChildHeight));
                i9++;
                if (i9 % this.mColumn == 0) {
                    paddingStart = getPaddingStart() + this.mGridMargin;
                    paddingTop = (int) (paddingTop + this.mChildHeight + this.mVerticalGap + max2);
                } else {
                    paddingStart = (int) (paddingStart + this.mHorizontalGap + f3 + max);
                }
            }
        }
    }

    @Override // android.widget.GridLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        calculateMargins();
        int i5 = this.mType;
        if (i5 == 0) {
            calculateInGridMode();
        } else if (i5 == 1) {
            calculateInSpecificGapMode();
        } else if (i5 == 2) {
            calculateInSpecificSizeMode();
        }
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (this.mChildHeight == 0.0f) {
                this.mChildHeight = childAt.getMeasuredHeight();
            }
            measureChild(childAt, ViewGroup.getChildMeasureSpec(i3, 0, (int) this.mChildWidth), ViewGroup.getChildMeasureSpec(i4, 0, (int) this.mChildHeight));
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i3), i3, 0), measureHeight(i4, Math.ceil(getVisibleChildCount() / this.mColumn)));
    }

    public void setChildGridNumber(int i3) {
        this.mChildGridNumber = i3;
        requestLayout();
    }

    public void setChildHeight(float f3) {
        this.mChildHeight = f3;
        requestLayout();
    }

    public void setChildMinHeight(float f3) {
        this.mChildMinHeight = f3;
        requestLayout();
    }

    public void setChildMinWidth(float f3) {
        this.mChildMinWidth = f3;
        requestLayout();
    }

    public void setChildWidth(float f3) {
        this.mChildWidth = f3;
        requestLayout();
    }

    public void setGridMarginType(int i3) {
        this.mGridMarginType = i3;
        requestLayout();
    }

    public void setHorizontalGap(float f3) {
        this.mHorizontalGap = f3;
        requestLayout();
    }

    public void setIsIgnoreChildMargin(boolean z3) {
        this.mIsIgnoreChildMargin = z3;
    }

    public void setMinHorizontalGap(float f3) {
        this.mMinHorizontalGap = f3;
        requestLayout();
    }

    public void setType(int i3) {
        this.mType = i3;
        requestLayout();
    }

    public void setVerticalGap(float f3) {
        this.mVerticalGap = f3;
        requestLayout();
    }

    public COUIGridLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIGridLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUIGridLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mIsIgnoreChildMargin = true;
        initUIManager();
        initAttr(attributeSet);
    }
}
