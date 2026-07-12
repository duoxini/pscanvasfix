package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import g2.c;
import g2.f;
import g2.i;

/* loaded from: classes.dex */
public class COUIDividerAppBarLayout extends AppBarLayout {
    private static boolean DEBUG = false;
    private static final String DIVIDER_FRACTION_STATE_KEY = "DIVIDER_FRACTION_STATE_KEY";
    private static final float MAX_FRACTION = 1.0f;
    private static final String OFFSET_DY_SCROLL_STATE_KEY = "OFFSET_DY_SCROLL_STATE_KEY";
    private static final String OVERSCROLL_DY_SCROLL_STATE_KEY = "OVERSCROLL_DY_SCROLL_STATE_KEY";
    private static final String SCROLL_DY_SCROLL_STATE_KEY = "SCROLL_DY_SCROLL_STATE_KEY";
    private static final String SUPER_STATE_KEY = "SUPER_STATE_KEY";
    private static final String TAG = "COUIDividerAppBarLayout";
    protected boolean mCollapsable;
    private float mDividerEndAlpha;
    private int mDividerEndMarginHorizontal;
    private float mDividerFraction;
    private float mDividerStartAlpha;
    private int mDividerStartMarginHorizontal;
    private View mDividerView;
    private boolean mHasDivider;
    private OnDividerProgressChangedListener mOnDividerProgressChangedListener;
    private View.OnLayoutChangeListener mOnLayoutChangeListener;
    private RecyclerView.u mOnScrollListener;
    protected int mScrollDyByOffset;
    protected int mScrollDyByOverScroll;
    protected int mScrollDyByScroll;
    protected RecyclerView mTargetView;
    protected int mTargetViewState;

    private static class DividerAppBarOnScrollChangedListener implements ViewTreeObserver.OnScrollChangedListener {
        private AppBarLayout mAbl;
        private View mTarget;

        private DividerAppBarOnScrollChangedListener() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            View view = this.mTarget;
            if (view instanceof COUIRecyclerView) {
                int scrollY = view.getScrollY();
                ((COUIDividerAppBarLayout) this.mAbl).mScrollDyByOverScroll = Math.max(0, scrollY);
                ((COUIDividerAppBarLayout) this.mAbl).onDividerChanged();
                if (((COUIDividerAppBarLayout) this.mAbl).mScrollDyByOverScroll == 0) {
                    this.mTarget.getViewTreeObserver().removeOnScrollChangedListener(this);
                }
            }
        }

        public void setAbl(AppBarLayout appBarLayout) {
            this.mAbl = appBarLayout;
        }

        public void setTarget(View view) {
            this.mTarget = view;
        }
    }

    static class DividerBehavior extends AppBarLayout.Behavior {
        private DividerAppBarOnScrollChangedListener mScrollChangedListener;
        private boolean mStopAfterFling = false;

        DividerBehavior() {
        }

        public boolean canScrollUp(View view) {
            return view.canScrollVertically(1);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, float f3, float f4) {
            this.mStopAfterFling = true;
            return super.onNestedPreFling(coordinatorLayout, (View) appBarLayout, view, f3, f4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            if ((appBarLayout instanceof COUIDividerAppBarLayout) && (view instanceof COUIRecyclerView)) {
                COUIDividerAppBarLayout cOUIDividerAppBarLayout = (COUIDividerAppBarLayout) appBarLayout;
                int i8 = cOUIDividerAppBarLayout.mScrollDyByOverScroll;
                int max = Math.max(0, view.getScrollY());
                cOUIDividerAppBarLayout.mScrollDyByOverScroll = max;
                if (i8 != max) {
                    cOUIDividerAppBarLayout.onDividerChanged();
                }
            }
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i3, i4, i5, i6, i7, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i3, i4) || ((appBarLayout instanceof COUIDividerAppBarLayout) && ((COUIDividerAppBarLayout) appBarLayout).isDividerAnimEnable());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            if (view instanceof COUIRecyclerView) {
                if (this.mScrollChangedListener == null) {
                    this.mScrollChangedListener = new DividerAppBarOnScrollChangedListener();
                }
                this.mScrollChangedListener.setTarget(view);
                this.mScrollChangedListener.setAbl(appBarLayout);
                view.getViewTreeObserver().addOnScrollChangedListener(this.mScrollChangedListener);
            }
            if (!this.mStopAfterFling) {
                super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i3);
            }
            this.mStopAfterFling = false;
        }
    }

    interface OnDividerProgressChangedListener {
        void onDividerProgressChanged(float f3);
    }

    public COUIDividerAppBarLayout(Context context) {
        this(context, null);
    }

    private void bindListener() {
        RecyclerView recyclerView = this.mTargetView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mTargetView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        } else if (DEBUG) {
            Log.d(TAG, "Can not find RecyclerView");
        }
    }

    private void findRecyclerView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            if (viewGroup.getChildAt(i3) instanceof RecyclerView) {
                this.mTargetView = (RecyclerView) viewGroup.getChildAt(i3);
                return;
            }
        }
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f11852h);
        this.mHasDivider = obtainStyledAttributes.getBoolean(i.f11857m, true);
        this.mDividerStartAlpha = obtainStyledAttributes.getFloat(i.f11855k, 0.0f);
        this.mDividerEndAlpha = obtainStyledAttributes.getFloat(i.f11853i, this.mHasDivider ? 1.0f : 0.0f);
        this.mDividerStartMarginHorizontal = obtainStyledAttributes.getDimensionPixelOffset(i.f11856l, getContext().getResources().getDimensionPixelOffset(c.f11758g));
        this.mDividerEndMarginHorizontal = obtainStyledAttributes.getDimensionPixelOffset(i.f11854j, getContext().getResources().getDimensionPixelOffset(c.f11756f));
        obtainStyledAttributes.recycle();
        this.mDividerEndAlpha = Math.max(0.0f, Math.min(this.mDividerEndAlpha, 1.0f));
        this.mDividerStartAlpha = Math.max(0.0f, Math.min(this.mDividerStartAlpha, 1.0f));
        this.mOnScrollListener = new RecyclerView.u() { // from class: com.google.android.material.appbar.COUIDividerAppBarLayout.1
            @Override // androidx.recyclerview.widget.RecyclerView.u
            public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
                super.onScrollStateChanged(recyclerView, i3);
                COUIDividerAppBarLayout.this.mTargetViewState = i3;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.u
            public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
                super.onScrolled(recyclerView, i3, i4);
                COUIDividerAppBarLayout.this.mScrollDyByScroll = recyclerView.computeVerticalScrollOffset();
                COUIDividerAppBarLayout.this.onDividerChanged();
            }
        };
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.appbar.COUIDividerAppBarLayout.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                COUIDividerAppBarLayout.this.refreshAppBar(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDividerAnimEnable() {
        return this.mDividerView != null && this.mHasDivider && ((this.mDividerStartAlpha > this.mDividerEndAlpha ? 1 : (this.mDividerStartAlpha == this.mDividerEndAlpha ? 0 : -1)) != 0 || this.mDividerStartMarginHorizontal != this.mDividerEndMarginHorizontal);
    }

    private void setDividerHorizontalMargin(int i3) {
        View view = this.mDividerView;
        if (view == null || !view.isAttachedToWindow() || this.mDividerView.getMeasuredWidth() <= 0) {
            return;
        }
        this.mDividerView.setPivotX(r0.getMeasuredWidth() / 2.0f);
        this.mDividerView.setScaleX((getMeasuredWidth() - (i3 * 2)) / this.mDividerView.getMeasuredWidth());
    }

    public void bindRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mTargetView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.mOnScrollListener);
            this.mTargetView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
        this.mTargetView = recyclerView;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this.mOnScrollListener);
            this.mTargetView.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return new DividerBehavior();
    }

    public float getDividerEndAlpha() {
        return this.mDividerEndAlpha;
    }

    public int getDividerEndMarginHorizontal() {
        return this.mDividerEndMarginHorizontal;
    }

    protected int getDividerScrollRange() {
        return getMeasuredHeight();
    }

    public float getDividerStartAlpha() {
        return this.mDividerStartAlpha;
    }

    public int getDividerStartMarginHorizontal() {
        return this.mDividerStartMarginHorizontal;
    }

    public boolean hasDivider() {
        return this.mHasDivider;
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mDividerView == null) {
            View inflate = LayoutInflater.from(getContext()).inflate(f.f11807a, (ViewGroup) this, false);
            this.mDividerView = inflate;
            addView(inflate, getChildCount());
            this.mDividerView.setAlpha(this.mDividerStartAlpha);
        }
        this.mDividerView.setBackgroundColor(AbstractC0335a.a(getContext(), M1.c.f1363h));
        refreshDivider();
        this.mDividerView.setVisibility(this.mHasDivider ? 0 : 8);
        AbstractC0342a.b(this.mDividerView, false);
        findRecyclerView();
        bindListener();
        setTouchscreenBlocksFocus(false);
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RecyclerView recyclerView = this.mTargetView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.mOnScrollListener);
            this.mTargetView.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        } else if (DEBUG) {
            Log.d(TAG, "Can not find RecyclerView");
        }
    }

    void onDividerChanged() {
        if (DEBUG) {
            Log.d(TAG, "onDividerChanged: mScrollDyByScroll = " + this.mScrollDyByScroll + " mScrollDyByOffset = " + this.mScrollDyByOffset + " mScrollDyByOverScroll = " + this.mScrollDyByOverScroll);
        }
        int max = Math.max(0, this.mScrollDyByScroll) + this.mScrollDyByOffset + this.mScrollDyByOverScroll;
        if (max < 0 || !isDividerAnimEnable()) {
            return;
        }
        float f3 = this.mDividerFraction;
        float dividerScrollRange = getDividerScrollRange();
        if (dividerScrollRange == 0.0f) {
            this.mDividerFraction = dividerScrollRange;
        } else {
            this.mDividerFraction = Math.min(max / dividerScrollRange, 1.0f);
        }
        float f4 = this.mDividerStartAlpha;
        float f5 = this.mDividerEndAlpha - f4;
        float f6 = this.mDividerFraction;
        float f7 = f4 + (f5 * f6);
        int i3 = this.mDividerStartMarginHorizontal + ((int) ((this.mDividerEndMarginHorizontal - r2) * f6));
        View view = this.mDividerView;
        if (view != null) {
            view.setAlpha(f7);
            setDividerHorizontalMargin(i3);
        }
        OnDividerProgressChangedListener onDividerProgressChangedListener = this.mOnDividerProgressChangedListener;
        if (onDividerProgressChangedListener != null) {
            float f8 = this.mDividerFraction;
            if (f3 != f8) {
                onDividerProgressChangedListener.onDividerProgressChanged(f8);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mScrollDyByOffset = bundle.getInt(OFFSET_DY_SCROLL_STATE_KEY);
            this.mScrollDyByScroll = bundle.getInt(SCROLL_DY_SCROLL_STATE_KEY);
            this.mScrollDyByOverScroll = bundle.getInt(OVERSCROLL_DY_SCROLL_STATE_KEY);
            this.mDividerFraction = bundle.getFloat(DIVIDER_FRACTION_STATE_KEY);
            parcelable = bundle.getParcelable(SUPER_STATE_KEY);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, super.onSaveInstanceState());
        bundle.putInt(OFFSET_DY_SCROLL_STATE_KEY, this.mScrollDyByOffset);
        bundle.putInt(SCROLL_DY_SCROLL_STATE_KEY, this.mScrollDyByScroll);
        bundle.putInt(OVERSCROLL_DY_SCROLL_STATE_KEY, this.mScrollDyByOverScroll);
        bundle.putFloat(DIVIDER_FRACTION_STATE_KEY, this.mDividerFraction);
        return bundle;
    }

    public boolean refreshAppBar(View view) {
        int scrollY;
        if (view instanceof COUIRecyclerView) {
            scrollY = ((COUIRecyclerView) view).computeVerticalScrollOffset();
        } else {
            if (!(view instanceof com.coui.appcompat.scrollview.a)) {
                return false;
            }
            scrollY = view.getScrollY();
        }
        if (scrollY == this.mScrollDyByScroll) {
            return false;
        }
        this.mScrollDyByScroll = scrollY;
        return true;
    }

    public void refreshDivider() {
        float f3 = this.mDividerStartAlpha;
        float f4 = this.mDividerEndAlpha - f3;
        float f5 = this.mDividerFraction;
        float f6 = f3 + (f4 * f5);
        int i3 = this.mDividerStartMarginHorizontal + ((int) ((this.mDividerEndMarginHorizontal - r1) * f5));
        View view = this.mDividerView;
        if (view != null) {
            view.setBackgroundColor(AbstractC0335a.a(getContext(), M1.c.f1363h));
            this.mDividerView.setAlpha(f6);
        }
        onDividerChanged();
        setDividerHorizontalMargin(i3);
        OnDividerProgressChangedListener onDividerProgressChangedListener = this.mOnDividerProgressChangedListener;
        if (onDividerProgressChangedListener != null) {
            onDividerProgressChangedListener.onDividerProgressChanged(this.mDividerFraction);
        }
    }

    public void reset() {
        this.mScrollDyByScroll = 0;
        this.mScrollDyByOffset = 0;
        this.mScrollDyByOverScroll = 0;
    }

    public void setDebug(boolean z3) {
        DEBUG = z3;
    }

    public void setDividerEndAlpha(float f3) {
        this.mDividerEndAlpha = f3;
    }

    public void setDividerEndMarginHorizontal(int i3) {
        this.mDividerEndMarginHorizontal = i3;
    }

    public void setDividerStartAlpha(float f3) {
        this.mDividerStartAlpha = f3;
    }

    public void setDividerStartMarginHorizontal(int i3) {
        this.mDividerStartMarginHorizontal = i3;
    }

    public void setHasDivider(boolean z3) {
        this.mHasDivider = z3;
        View view = this.mDividerView;
        if (view != null) {
            view.setVisibility(z3 ? 0 : 8);
        }
    }

    public void setOnDividerProgressChangedListener(OnDividerProgressChangedListener onDividerProgressChangedListener) {
        this.mOnDividerProgressChangedListener = onDividerProgressChangedListener;
    }

    void translateDivider(int i3) {
        View view = this.mDividerView;
        if (view == null || !view.isAttachedToWindow()) {
            return;
        }
        this.mDividerView.setTranslationY(i3);
    }

    public COUIDividerAppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIDividerAppBarLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mCollapsable = false;
        this.mTargetViewState = 0;
        this.mTargetView = null;
        this.mDividerFraction = 0.0f;
        this.mOnDividerProgressChangedListener = null;
        this.mOnScrollListener = null;
        this.mOnLayoutChangeListener = null;
        init(attributeSet);
    }
}
