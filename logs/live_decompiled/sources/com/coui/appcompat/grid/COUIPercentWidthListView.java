package com.coui.appcompat.grid;

import Q1.b;
import Q1.c;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import com.coui.appcompat.list.a;

/* loaded from: classes.dex */
public class COUIPercentWidthListView extends a {
    private static final int CARD_LIST_FLAG = 2;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int PADDING_MODE = 0;
    private static final int REMEASURE_MODE = 1;
    private static final int SMALL_PADDING = 1;
    private static final String TAG = "COUIPercentWidthListView";
    private int mGridNumber;
    private int mGridNumberResourceId;
    private int mInitPaddingEnd;
    private int mInitPaddingStart;
    private boolean mIsActivityEmbedded;
    private boolean mIsParentChildHierarchy;
    private boolean mMeasureEnabled;
    public int mMode;
    private int mPaddingSize;
    private int mPaddingType;
    private boolean mPercentEnabled;
    private int mScreenPhysicalWidth;

    public COUIPercentWidthListView(Context context) {
        this(context, null);
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.f1914Q);
            this.mGridNumberResourceId = obtainStyledAttributes.getResourceId(c.f1915R, 0);
            this.mGridNumber = obtainStyledAttributes.getInteger(c.f1915R, getContext().getResources().getInteger(b.f1897a));
            this.mMode = obtainStyledAttributes.getInt(c.f1918U, 0);
            this.mPaddingType = obtainStyledAttributes.getInteger(c.f1917T, 1);
            this.mPaddingSize = obtainStyledAttributes.getInteger(c.f1916S, 0);
            this.mIsParentChildHierarchy = obtainStyledAttributes.getBoolean(c.f1921X, false);
            this.mPercentEnabled = obtainStyledAttributes.getBoolean(c.f1909L, true);
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

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.mMeasureEnabled) {
            if (this.mPercentEnabled) {
                i3 = COUIResponsiveUtils.measureLayout(this, i3, this.mGridNumber, this.mPaddingType, this.mPaddingSize, this.mMode, this.mInitPaddingStart, this.mInitPaddingEnd, this.mScreenPhysicalWidth, this.mIsParentChildHierarchy, this.mIsActivityEmbedded);
            } else if (getPaddingStart() != this.mInitPaddingStart || getPaddingEnd() != this.mInitPaddingEnd) {
                setPaddingRelative(this.mInitPaddingStart, getPaddingTop(), this.mInitPaddingEnd, getPaddingBottom());
            }
        }
        super.onMeasure(i3, i4);
    }

    public void setIsParentChildHierarchy(boolean z3) {
        this.mIsParentChildHierarchy = z3;
        requestLayout();
    }

    @SuppressLint({"LongLogTag"})
    public void setMeasureEnable(boolean z3) {
        Log.d(TAG, "setMeasureEnable = " + z3 + " " + Log.getStackTraceString(new Throwable()));
        this.mMeasureEnabled = z3;
    }

    public void setPercentIndentEnabled(boolean z3) {
        this.mPercentEnabled = z3;
        requestLayout();
    }

    public COUIPercentWidthListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPercentEnabled = true;
        this.mMode = 0;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        this.mMeasureEnabled = true;
        initAttr(attributeSet);
        prepareForMeasure();
    }

    public COUIPercentWidthListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mPercentEnabled = true;
        this.mMode = 0;
        this.mIsActivityEmbedded = false;
        this.mScreenPhysicalWidth = 0;
        this.mMeasureEnabled = true;
        initAttr(attributeSet);
        this.mInitPaddingStart = getPaddingStart();
        this.mInitPaddingEnd = getPaddingEnd();
        setScrollBarStyle(33554432);
    }
}
