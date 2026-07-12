package com.coui.appcompat.grid;

import Q1.b;
import Q1.c;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class COUIPercentWidthRelativeLayout extends RelativeLayout {
    private static final int CARD_LIST_FLAG = 2;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int PADDING_MODE = 0;
    private static final int REMEASURE_MODE = 1;
    private static final int SMALL_PADDING = 1;
    private int mGridNumber;
    private int mGridNumberResourceId;
    private int mInitPaddingEnd;
    private int mInitPaddingStart;
    private boolean mIsActivityEmbedded;
    private boolean mIsParentChildHierarchy;
    public int mMode;
    private int mPaddingSize;
    private int mPaddingType;
    private boolean mPercentEnabled;
    private int mScreenPhysicalWidth;

    public COUIPercentWidthRelativeLayout(Context context) {
        this(context, null);
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.f1925a0);
            this.mGridNumberResourceId = obtainStyledAttributes.getResourceId(c.f1927b0, 0);
            this.mGridNumber = obtainStyledAttributes.getInteger(c.f1927b0, getContext().getResources().getInteger(b.f1897a));
            this.mPaddingType = obtainStyledAttributes.getInteger(c.f1933e0, 0);
            this.mPaddingSize = obtainStyledAttributes.getInteger(c.f1931d0, 0);
            this.mPercentEnabled = obtainStyledAttributes.getBoolean(c.f1935f0, true);
            this.mMode = obtainStyledAttributes.getInt(c.f1937g0, 0);
            this.mIsParentChildHierarchy = obtainStyledAttributes.getBoolean(c.f1929c0, false);
            this.mInitPaddingStart = getPaddingStart();
            this.mInitPaddingEnd = getPaddingEnd();
            obtainStyledAttributes.recycle();
        }
    }

    private void prepareForMeasure() {
        Context context = getContext();
        if (context != null) {
            this.mIsActivityEmbedded = COUIResponsiveUtils.isActivityEmbedded(getContext());
            if (context instanceof Activity) {
                this.mScreenPhysicalWidth = COUIResponsiveUtils.getScreenPhysicalWidth((Activity) context);
            } else {
                this.mScreenPhysicalWidth = -1;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getContext() != null && this.mGridNumberResourceId != 0) {
            this.mGridNumber = getContext().getResources().getInteger(this.mGridNumberResourceId);
        }
        prepareForMeasure();
        requestLayout();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        if (this.mPercentEnabled) {
            i5 = COUIResponsiveUtils.measureLayout(this, i3, this.mGridNumber, this.mPaddingType, this.mPaddingSize, this.mMode, this.mInitPaddingStart, this.mInitPaddingEnd, this.mScreenPhysicalWidth, this.mIsParentChildHierarchy, this.mIsActivityEmbedded);
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                COUIResponsiveUtils.measureChildWithPercent(getContext(), getChildAt(i6), i5, this.mPaddingType, this.mPaddingSize, layoutParams.mGridNumber, layoutParams.mPercentMode);
            }
        } else {
            i5 = i3;
        }
        super.onMeasure(i5, i4);
    }

    public void setIsParentChildHierarchy(boolean z3) {
        this.mIsParentChildHierarchy = z3;
        requestLayout();
    }

    public void setPercentIndentEnabled(boolean z3) {
        this.mPercentEnabled = z3;
        requestLayout();
    }

    public static class LayoutParams extends RelativeLayout.LayoutParams {
        public int mGridNumber;
        public int mPercentMode;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init(context, attributeSet);
        }

        private void init(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.f1939h0);
            this.mGridNumber = obtainStyledAttributes.getInt(c.f1941i0, 0);
            this.mPercentMode = obtainStyledAttributes.getInt(c.f1943j0, 0);
            obtainStyledAttributes.recycle();
        }

        public void setGridNumber(int i3) {
            this.mGridNumber = i3;
        }

        public void setPercentMode(int i3) {
            this.mPercentMode = i3;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
        }
    }

    public COUIPercentWidthRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public COUIPercentWidthRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public COUIPercentWidthRelativeLayout(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mMode = 0;
        this.mPercentEnabled = true;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        initAttr(attributeSet);
        prepareForMeasure();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
