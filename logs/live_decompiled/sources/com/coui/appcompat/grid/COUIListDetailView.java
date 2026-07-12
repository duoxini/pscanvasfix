package com.coui.appcompat.grid;

import M1.c;
import Q1.a;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.y;
import androidx.fragment.app.FragmentContainerView;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowTotalSizeClass;
import d0.AbstractC0335a;
import e0.AbstractC0342a;

/* loaded from: classes.dex */
public class COUIListDetailView extends FrameLayout {
    private static final float DEFAULT_MAIN_WIDTH_PERCENT = 0.4f;
    private View mDivider;
    private int mDividerColor;
    private FragmentContainerView mEmptyPageFragment;
    private int mGapWidth;
    private FragmentContainerView mMainFragment;
    private float mMainFragmentPercent;
    private int mMaxMainFragmentWidth;
    private int mMinMainFragmentWidth;
    private FragmentContainerView mSubFragment;

    public COUIListDetailView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mMainFragment = new FragmentContainerView(context);
        this.mSubFragment = new FragmentContainerView(context);
        this.mEmptyPageFragment = new FragmentContainerView(context);
        this.mDivider = new View(context);
        addView(this.mEmptyPageFragment);
        addView(this.mMainFragment);
        addView(this.mDivider);
        addView(this.mSubFragment);
        this.mEmptyPageFragment.setId(View.generateViewId());
        this.mMainFragment.setId(View.generateViewId());
        this.mSubFragment.setId(View.generateViewId());
        int a3 = AbstractC0335a.a(getContext(), c.f1363h);
        this.mDividerColor = a3;
        setDividerColor(a3);
        AbstractC0342a.b(this.mDivider, false);
        this.mMaxMainFragmentWidth = context.getResources().getDimensionPixelSize(a.f1892b);
        this.mMinMainFragmentWidth = context.getResources().getDimensionPixelSize(a.f1893c);
        this.mGapWidth = context.getResources().getDimensionPixelSize(a.f1891a);
    }

    public FrameLayout getEmptyPageFragmentContainer() {
        return this.mEmptyPageFragment;
    }

    public FrameLayout getMainFragmentContainer() {
        return this.mMainFragment;
    }

    public FrameLayout getSubFragmentContainer() {
        return this.mSubFragment;
    }

    public boolean isInSplitMode() {
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        return companion.calculateFromSize(companion2.pixel2Dp(getContext(), Math.abs(getWidth())), companion2.pixel2Dp(getContext(), Math.abs(getWidth()))).getWindowTotalSizeClass() != WindowTotalSizeClass.Compact;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int a3 = AbstractC0335a.a(getContext(), c.f1363h);
        this.mDividerColor = a3;
        setDividerColor(a3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        boolean z4 = y.x(this) == 1;
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        WindowTotalSizeClass windowTotalSizeClass = companion.calculateFromSize(companion2.pixel2Dp(getContext(), Math.abs(getWidth())), companion2.pixel2Dp(getContext(), Math.abs(getWidth()))).getWindowTotalSizeClass();
        if (z4) {
            if (windowTotalSizeClass == WindowTotalSizeClass.Compact) {
                this.mEmptyPageFragment.setVisibility(8);
                FragmentContainerView fragmentContainerView = this.mMainFragment;
                fragmentContainerView.layout(0, 0, fragmentContainerView.getWidth(), this.mMainFragment.getHeight());
                FragmentContainerView fragmentContainerView2 = this.mSubFragment;
                fragmentContainerView2.layout(0, 0, fragmentContainerView2.getWidth(), this.mSubFragment.getHeight());
                return;
            }
            this.mEmptyPageFragment.setVisibility(0);
            this.mEmptyPageFragment.layout(0, 0, this.mSubFragment.getWidth(), this.mSubFragment.getHeight());
            FragmentContainerView fragmentContainerView3 = this.mSubFragment;
            fragmentContainerView3.layout(0, 0, fragmentContainerView3.getWidth(), this.mSubFragment.getHeight());
            this.mDivider.layout(this.mSubFragment.getWidth(), 0, this.mSubFragment.getWidth() + this.mDivider.getWidth(), this.mDivider.getHeight());
            this.mMainFragment.layout(this.mSubFragment.getWidth() + this.mDivider.getWidth(), 0, this.mSubFragment.getWidth() + this.mDivider.getWidth() + this.mMainFragment.getWidth(), this.mMainFragment.getHeight());
            return;
        }
        if (windowTotalSizeClass == WindowTotalSizeClass.Compact) {
            this.mEmptyPageFragment.setVisibility(8);
            FragmentContainerView fragmentContainerView4 = this.mMainFragment;
            fragmentContainerView4.layout(0, 0, fragmentContainerView4.getWidth(), this.mMainFragment.getHeight());
            FragmentContainerView fragmentContainerView5 = this.mSubFragment;
            fragmentContainerView5.layout(0, 0, fragmentContainerView5.getWidth(), this.mSubFragment.getHeight());
            return;
        }
        this.mEmptyPageFragment.setVisibility(0);
        this.mEmptyPageFragment.layout(this.mMainFragment.getWidth() + this.mDivider.getWidth(), 0, this.mMainFragment.getWidth() + this.mDivider.getWidth() + this.mSubFragment.getWidth(), this.mSubFragment.getHeight());
        FragmentContainerView fragmentContainerView6 = this.mMainFragment;
        fragmentContainerView6.layout(0, 0, fragmentContainerView6.getWidth(), this.mMainFragment.getHeight());
        this.mDivider.layout(this.mMainFragment.getWidth(), 0, this.mMainFragment.getWidth() + this.mDivider.getWidth(), this.mDivider.getHeight());
        this.mSubFragment.layout(this.mMainFragment.getWidth() + this.mDivider.getWidth(), 0, this.mMainFragment.getWidth() + this.mDivider.getWidth() + this.mSubFragment.getWidth(), this.mSubFragment.getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int min;
        int i5;
        int i6;
        super.onMeasure(i3, i4);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        WindowSizeClass.Companion companion = WindowSizeClass.Companion;
        Dp.Companion companion2 = Dp.Companion;
        WindowTotalSizeClass windowTotalSizeClass = companion.calculateFromSize(companion2.pixel2Dp(getContext(), Math.abs(measuredWidth)), companion2.pixel2Dp(getContext(), Math.abs(measuredHeight))).getWindowTotalSizeClass();
        int max = (int) Math.max(Math.min(measuredWidth * this.mMainFragmentPercent, this.mMaxMainFragmentWidth), this.mMinMainFragmentWidth);
        if (windowTotalSizeClass == WindowTotalSizeClass.Compact) {
            min = measuredWidth;
            i5 = min;
            i6 = 0;
        } else {
            min = Math.min(Math.max(max, this.mMinMainFragmentWidth), this.mMaxMainFragmentWidth);
            i5 = measuredWidth - min;
            i6 = this.mGapWidth;
        }
        measureChild(this.mMainFragment, ViewGroup.getChildMeasureSpec(i3, 0, Math.min(measuredWidth, min)), i4);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, 0, i5);
        measureChild(this.mSubFragment, childMeasureSpec, i4);
        measureChild(this.mEmptyPageFragment, childMeasureSpec, i4);
        measureChild(this.mDivider, ViewGroup.getChildMeasureSpec(i3, 0, i6), i4);
    }

    public void setDividerColor(int i3) {
        this.mDividerColor = i3;
        this.mDivider.setBackgroundColor(i3);
    }

    public void setMainFragmentPercent(float f3) {
        this.mMainFragmentPercent = f3;
        requestLayout();
    }

    public COUIListDetailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIListDetailView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mMainFragmentPercent = DEFAULT_MAIN_WIDTH_PERCENT;
        init(context);
    }
}
