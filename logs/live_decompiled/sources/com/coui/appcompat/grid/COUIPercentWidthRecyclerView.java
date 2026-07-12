package com.coui.appcompat.grid;

import Q1.b;
import Q1.c;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.COUIRecyclerView;

/* loaded from: classes.dex */
public class COUIPercentWidthRecyclerView extends COUIRecyclerView {
    private static final int CARD_LIST_FLAG = 2;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int SMALL_PADDING = 1;
    private static final String TAG = "COUIPercentWidthRecyclerView";
    private int mGridNumber;
    private int mGridNumberResourceId;
    private int mInitPaddingEnd;
    private int mInitPaddingStart;
    private boolean mIsActivityEmbedded;
    private boolean mIsParentChildHierarchy;
    private int mPaddingSize;
    private int mPaddingType;
    private boolean mPercentEnabled;
    private int mScreenPhysicalWidth;

    public COUIPercentWidthRecyclerView(Context context) {
        this(context, null);
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.f1919V);
            this.mGridNumberResourceId = obtainStyledAttributes.getResourceId(c.f1920W, 0);
            this.mGridNumber = obtainStyledAttributes.getInteger(c.f1920W, getContext().getResources().getInteger(b.f1897a));
            this.mPaddingType = obtainStyledAttributes.getInteger(c.f1923Z, 1);
            this.mPaddingSize = obtainStyledAttributes.getInteger(c.f1922Y, 0);
            this.mIsParentChildHierarchy = obtainStyledAttributes.getBoolean(c.f1921X, false);
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

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getContext() != null && this.mGridNumberResourceId != 0) {
            this.mGridNumber = getContext().getResources().getInteger(this.mGridNumberResourceId);
        }
        prepareForMeasure();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.mPercentEnabled) {
            i3 = COUIResponsiveUtils.measureLayout(this, i3, this.mGridNumber, this.mPaddingType, this.mPaddingSize, 0, this.mInitPaddingStart, this.mInitPaddingEnd, this.mScreenPhysicalWidth, this.mIsParentChildHierarchy, this.mIsActivityEmbedded);
        } else if (getPaddingStart() != this.mInitPaddingStart || getPaddingEnd() != this.mInitPaddingEnd) {
            setPaddingRelative(this.mInitPaddingStart, getPaddingTop(), this.mInitPaddingEnd, getPaddingBottom());
        }
        super.onMeasure(i3, i4);
    }

    public void setIsParentChildHierarchy(boolean z3) {
        this.mIsParentChildHierarchy = z3;
        requestLayout();
    }

    public void setPercentIndentEnabled(boolean z3) {
        this.mPercentEnabled = z3;
        requestLayout();
    }

    public COUIPercentWidthRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIPercentWidthRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPercentEnabled = true;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        initAttr(attributeSet);
        this.mInitPaddingStart = getPaddingStart();
        this.mInitPaddingEnd = getPaddingEnd();
        setScrollBarStyle(33554432);
        prepareForMeasure();
    }
}
