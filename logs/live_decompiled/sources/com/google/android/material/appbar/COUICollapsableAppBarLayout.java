package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.COUIDividerAppBarLayout;
import g2.c;
import g2.e;
import g2.i;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import y0.j;

/* loaded from: classes.dex */
public class COUICollapsableAppBarLayout extends COUIDividerAppBarLayout {
    private static boolean DEBUG = false;
    public static final int DEFAULT_SCROLL_FLAG = 19;
    public static final int MODE_COLLAPSABLE = 0;
    public static final int MODE_FIXED_COLLAPSED = 1;
    public static final int MODE_FIXED_EXPANDED = 2;
    private static final String MODE_STATE_KEY = "MODE_STATE_KEY";
    private static final String OFFSET_STATE_KEY = "OFFSET_STATE_KEY";
    private static final String SUPER_STATE_KEY = "SUPER_STATE_KEY";
    private static final String TAG = "COUICollapsableAppBarLayout";
    private static final String TITLE_FRACTION_STATE_KEY = "TITLE_FRACTION_STATE_KEY";
    private boolean mAutoExpand;
    private int mCollapsingToolbarHeight;
    private int mEndPaddingBottom;
    private int mMode;
    private boolean mNeedUpdateModeAfterOffsetChanged;
    private int mOffset;
    private int mStartPaddingBottom;
    private boolean mSubtitleHideEnable;
    private int mSubtitleViewHeight;
    private boolean mUpdateOffset;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private static class ScrollBehavior extends COUIDividerAppBarLayout.DividerBehavior {
        private int mLastStartedType;
        private boolean mShouldSnapToBottom;

        private ScrollBehavior() {
        }

        public boolean contentInScreen(View view) {
            return (view.canScrollVertically(1) || view.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        int getTopBottomOffsetForScrollingSibling() {
            if (!this.mShouldSnapToBottom) {
                return super.getTopBottomOffsetForScrollingSibling();
            }
            this.mShouldSnapToBottom = false;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.HeaderBehavior
        public boolean canDragView(AppBarLayout appBarLayout) {
            return super.canDragView((ScrollBehavior) appBarLayout) && (!(appBarLayout instanceof COUICollapsableAppBarLayout) || ((COUICollapsableAppBarLayout) appBarLayout).getMode() == 0);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i3) {
            if (appBarLayout instanceof COUICollapsableAppBarLayout) {
                COUICollapsableAppBarLayout cOUICollapsableAppBarLayout = (COUICollapsableAppBarLayout) appBarLayout;
                if (cOUICollapsableAppBarLayout.getUpdateOffset()) {
                    setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
                    cOUICollapsableAppBarLayout.setUpdateOffset(false);
                }
            }
            return super.onLayoutChild(coordinatorLayout, appBarLayout, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int[] iArr, int i5) {
            if ((view instanceof COUIRecyclerView) && view.getScrollY() < 0) {
                i4 = 0;
            }
            super.onNestedPreScroll(coordinatorLayout, appBarLayout, view, i3, i4, iArr, i5);
        }

        @Override // com.google.android.material.appbar.COUIDividerAppBarLayout.DividerBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
            super.onNestedScroll(coordinatorLayout, appBarLayout, view, i3, i4, i5, ((appBarLayout instanceof COUICollapsableAppBarLayout) && ((COUICollapsableAppBarLayout) appBarLayout).mMode == 1) ? 0 : i6, i7, iArr);
        }

        @Override // com.google.android.material.appbar.COUIDividerAppBarLayout.DividerBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
            this.mLastStartedType = i4;
            return super.onStartNestedScroll(coordinatorLayout, appBarLayout, view, view2, i3, i4);
        }

        @Override // com.google.android.material.appbar.COUIDividerAppBarLayout.DividerBehavior, com.google.android.material.appbar.AppBarLayout.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
            if (appBarLayout.getChildCount() > 0) {
                if (appBarLayout.getChildAt(0) instanceof COUICollapsingToolbarLayout) {
                    int scrollFlags = ((AppBarLayout.LayoutParams) appBarLayout.getChildAt(0).getLayoutParams()).getScrollFlags() & 17;
                    boolean z3 = scrollFlags == 17 && contentInScreen(view) && ((COUICollapsableAppBarLayout) appBarLayout).mCollapsable;
                    this.mShouldSnapToBottom = z3;
                    this.mShouldSnapToBottom = z3 && ((COUICollapsableAppBarLayout) appBarLayout).mAutoExpand;
                    if (COUICollapsableAppBarLayout.DEBUG) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("((mLastStartedType == ViewCompat.TYPE_TOUCH) || (type == ViewCompat.TYPE_NON_TOUCH)) = ");
                        sb.append(this.mLastStartedType == 0 || i3 == 1);
                        sb.append("\n((snapFlag & LayoutParams.FLAG_SNAP) == LayoutParams.FLAG_SNAP) = ");
                        sb.append(scrollFlags == 17);
                        sb.append("\n(contentInScreen(target)) = ");
                        sb.append(contentInScreen(view));
                        sb.append("\n(((COUICollapsableAppBarLayout) abl).mCollapsable = ");
                        sb.append(((COUICollapsableAppBarLayout) appBarLayout).mCollapsable);
                        Log.d(COUICollapsableAppBarLayout.TAG, sb.toString());
                    }
                }
            }
            super.onStopNestedScroll(coordinatorLayout, appBarLayout, view, i3);
        }
    }

    public COUICollapsableAppBarLayout(Context context) {
        this(context, null);
    }

    private void adjustPaddingBottom(int i3, boolean z3) {
        float totalScrollRange = getTotalScrollRange();
        if (z3 || !(totalScrollRange == 0.0f || this.mStartPaddingBottom == this.mEndPaddingBottom)) {
            int i4 = this.mStartPaddingBottom;
            translateDivider(-(i4 + ((int) ((this.mEndPaddingBottom - i4) * (Math.abs(i3) / totalScrollRange)))));
        }
    }

    private void adjustSubtitleIfNeed(int i3) {
        View findSubtitleContentView = findSubtitleContentView();
        int i4 = 0;
        boolean z3 = findSubtitleContentView != null && findSubtitleContentView.getVisibility() == 0;
        if (findCollapsingToolbarLayout() == null || !z3) {
            return;
        }
        float abs = Math.abs(i3) / getTotalScrollRange();
        float f3 = this.mSubtitleHideEnable ? 1.0f - abs : 1.0f;
        ViewGroup.LayoutParams layoutParams = findSubtitleContentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
                i4 = getContext().getResources().getDimensionPixelOffset(c.f11729P0);
            } else if (COUIResponsiveUtils.isMediumScreen(getContext(), getMeasuredWidth(), j.j(getContext()))) {
                i4 = getContext().getResources().getDimensionPixelOffset(c.f11733R0);
            } else if (COUIResponsiveUtils.isLargeScreen(getContext(), getMeasuredWidth(), j.j(getContext()))) {
                i4 = getContext().getResources().getDimensionPixelOffset(c.f11731Q0);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.getMarginStart() != i4) {
                marginLayoutParams.setMarginStart(i4);
                findSubtitleContentView.setLayoutParams(layoutParams);
            }
        }
        if (Float.isNaN(abs)) {
            return;
        }
        findSubtitleContentView.setTranslationY((this.mEndPaddingBottom - this.mStartPaddingBottom) * (1.0f - abs));
        findSubtitleContentView.setAlpha(f3);
    }

    private View findCollapsingToolbarLayout() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof CollapsingToolbarLayout) {
                return childAt;
            }
        }
        return null;
    }

    private float getExpansionFraction() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            return ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).collapsingTextHelper.getExpansionFraction();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean getUpdateOffset() {
        return this.mUpdateOffset;
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f11844a);
        this.mMode = obtainStyledAttributes.getInt(i.f11847c, 0);
        this.mSubtitleHideEnable = obtainStyledAttributes.getBoolean(i.f11849e, true);
        this.mStartPaddingBottom = obtainStyledAttributes.getDimensionPixelOffset(i.f11848d, getContext().getResources().getDimensionPixelOffset(c.f11762i));
        this.mEndPaddingBottom = obtainStyledAttributes.getDimensionPixelOffset(i.f11846b, getContext().getResources().getDimensionPixelOffset(c.f11760h));
        if (this.mMode == 0) {
            this.mCollapsable = true;
        }
        obtainStyledAttributes.recycle();
    }

    private boolean isCollapsed() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            return ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).isCollapsed();
        }
        return false;
    }

    private boolean isExpanded() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            return ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).isExpanded();
        }
        return false;
    }

    private void setScrollFlags(int i3) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.setScrollFlags(i3);
            childAt.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpdateOffset(boolean z3) {
        this.mUpdateOffset = z3;
    }

    private void updateIconViewLocationIfNeed(float f3) {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            COUICollapsingToolbarLayout cOUICollapsingToolbarLayout = (COUICollapsingToolbarLayout) findCollapsingToolbarLayout;
            cOUICollapsingToolbarLayout.collapsingTextHelper.setExpansionFraction(f3);
            cOUICollapsingToolbarLayout.updateIconViewLocationIfNeed();
        }
    }

    public void enableAutoExpand(boolean z3) {
        this.mAutoExpand = z3;
    }

    protected View findSubtitleContentView() {
        return findViewById(e.f11801b);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, com.google.android.material.appbar.AppBarLayout, androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c getBehavior() {
        return new ScrollBehavior();
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    protected int getDividerScrollRange() {
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout != null) {
            int i3 = this.mMode;
            if (i3 == 0) {
                return getTotalScrollRange();
            }
            if (i3 == 1) {
                return findCollapsingToolbarLayout.getMinimumHeight();
            }
        }
        return getMeasuredHeight();
    }

    public int getEndPaddingBottom() {
        return this.mEndPaddingBottom;
    }

    public int getMode() {
        return this.mMode;
    }

    public int getStartPaddingBottom() {
        return this.mStartPaddingBottom;
    }

    public boolean isSubtitleHideEnable() {
        return this.mSubtitleHideEnable;
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, com.google.android.material.appbar.AppBarLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setMode(this.mMode);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        post(new Runnable() { // from class: com.google.android.material.appbar.a
            @Override // java.lang.Runnable
            public final void run() {
                COUICollapsableAppBarLayout.this.updateSubtitle();
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (findSubtitleContentView() != null) {
            findSubtitleContentView().setTranslationY(-this.mStartPaddingBottom);
        }
    }

    @Override // com.google.android.material.appbar.AppBarLayout, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        View findSubtitleContentView = findSubtitleContentView();
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        boolean z3 = false;
        setUpdateOffset(this.mSubtitleHideEnable && isCollapsed());
        boolean z4 = findSubtitleContentView != null && findSubtitleContentView.getVisibility() == 0;
        if (findCollapsingToolbarLayout != null) {
            ViewGroup.LayoutParams layoutParams = findCollapsingToolbarLayout.getLayoutParams();
            if (this.mCollapsingToolbarHeight == 0) {
                this.mCollapsingToolbarHeight = layoutParams.height;
            }
            int i5 = this.mCollapsingToolbarHeight;
            if (i5 != 0) {
                if (z4) {
                    findSubtitleContentView.measure(i3, i4);
                    ViewGroup.LayoutParams layoutParams2 = findSubtitleContentView.getLayoutParams();
                    int i6 = this.mSubtitleViewHeight;
                    boolean z5 = (i6 == 0 || i6 == findSubtitleContentView.getMeasuredHeight()) ? false : true;
                    if (this.mUpdateOffset || (z5 && isCollapsed())) {
                        z3 = true;
                    }
                    setUpdateOffset(z3);
                    if (layoutParams.height == this.mCollapsingToolbarHeight || z5) {
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            int measuredHeight = findSubtitleContentView.getMeasuredHeight();
                            this.mSubtitleViewHeight = measuredHeight;
                            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = -measuredHeight;
                            findSubtitleContentView.setLayoutParams(layoutParams2);
                        }
                        layoutParams.height = this.mCollapsingToolbarHeight + this.mSubtitleViewHeight;
                        findCollapsingToolbarLayout.setLayoutParams(layoutParams);
                    }
                } else {
                    layoutParams.height = i5;
                    findCollapsingToolbarLayout.setLayoutParams(layoutParams);
                }
            }
        }
        super.onMeasure(i3, i4);
    }

    @Override // com.google.android.material.appbar.AppBarLayout
    void onOffsetChanged(int i3) {
        super.onOffsetChanged(i3);
        if (i3 == this.mOffset) {
            return;
        }
        if (this.mMode == 0) {
            this.mScrollDyByOffset = Math.max(0, -i3);
        }
        this.mOffset = i3;
        onDividerChanged();
        adjustPaddingBottom(i3, false);
        adjustSubtitleIfNeed(i3);
        View findCollapsingToolbarLayout = findCollapsingToolbarLayout();
        if (findCollapsingToolbarLayout instanceof COUICollapsingToolbarLayout) {
            ((COUICollapsingToolbarLayout) findCollapsingToolbarLayout).updateIconViewLocationIfNeed();
            findCollapsingToolbarLayout.invalidate();
        }
        if (this.mNeedUpdateModeAfterOffsetChanged) {
            int i4 = this.mMode;
            if (i4 == 0) {
                this.mNeedUpdateModeAfterOffsetChanged = false;
            } else if (i4 == 1 && this.mOffset == (-getDividerScrollRange())) {
                updateIconViewLocationIfNeed(1.0f);
                this.mNeedUpdateModeAfterOffsetChanged = false;
            } else if (this.mMode == 2 && this.mOffset == 0) {
                setScrollFlags(0);
                updateIconViewLocationIfNeed(0.0f);
                this.mNeedUpdateModeAfterOffsetChanged = false;
            }
        }
        if (this.mTargetViewState == 2 && this.mOffset == (-getDividerScrollRange()) && !this.mTargetView.canScrollVertically(1) && !this.mTargetView.canScrollVertically(-1) && this.mMode == 0) {
            setExpanded(true);
        }
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mOffset = bundle.getInt(OFFSET_STATE_KEY);
            this.mMode = bundle.getInt(MODE_STATE_KEY);
            updateIconViewLocationIfNeed(bundle.getFloat(TITLE_FRACTION_STATE_KEY, 0.0f));
            parcelable = bundle.getParcelable(SUPER_STATE_KEY);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, super.onSaveInstanceState());
        bundle.putInt(OFFSET_STATE_KEY, this.mOffset);
        bundle.putInt(MODE_STATE_KEY, this.mMode);
        bundle.putFloat(TITLE_FRACTION_STATE_KEY, getExpansionFraction());
        return bundle;
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public boolean refreshAppBar(View view) {
        boolean z3;
        boolean refreshAppBar = super.refreshAppBar(view);
        if (!view.canScrollVertically(1) && !view.canScrollVertically(-1) && this.mMode == 0 && isCollapsed() && this.mTargetViewState == 2) {
            setExpanded(true);
            z3 = true;
        } else {
            z3 = false;
        }
        return refreshAppBar || z3;
    }

    @Deprecated
    public void refreshExpand(View view) {
        if (view.canScrollVertically(1) || view.canScrollVertically(-1) || this.mMode != 0 || !isCollapsed()) {
            return;
        }
        setExpanded(true);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public void reset() {
        super.reset();
        this.mCollapsable = true;
        setMode(0);
        setExpanded(true);
    }

    @Override // com.google.android.material.appbar.COUIDividerAppBarLayout
    public void setDebug(boolean z3) {
        super.setDebug(z3);
        DEBUG = z3;
    }

    public void setEndPaddingBottom(int i3) {
        this.mEndPaddingBottom = i3;
        adjustPaddingBottom(this.mOffset, true);
    }

    public void setMode(int i3) {
        if (this.mMode == i3) {
            return;
        }
        if (i3 == 0) {
            this.mCollapsable = true;
            setScrollFlags(19);
            if (this.mMode == 1) {
                if (this.mScrollDyByScroll > 0) {
                    this.mScrollDyByOffset -= this.mOffset;
                    onDividerChanged();
                } else {
                    setExpanded(true);
                }
            }
            if (this.mMode == 2 && this.mScrollDyByScroll > 0) {
                this.mScrollDyByOffset -= this.mOffset;
                setExpanded(false);
            }
        } else if (i3 == 1) {
            this.mCollapsable = false;
            setExpanded(false);
            setScrollFlags(19);
            this.mScrollDyByOffset = 0;
            if (isCollapsed()) {
                updateIconViewLocationIfNeed(1.0f);
            } else {
                this.mNeedUpdateModeAfterOffsetChanged = true;
            }
            onDividerChanged();
        } else if (i3 == 2) {
            this.mCollapsable = false;
            setExpanded(true);
            this.mScrollDyByOffset = 0;
            if (isExpanded()) {
                setScrollFlags(0);
                updateIconViewLocationIfNeed(0.0f);
            } else {
                this.mNeedUpdateModeAfterOffsetChanged = true;
            }
            onDividerChanged();
        }
        this.mMode = i3;
    }

    public void setStartPaddingBottom(int i3) {
        this.mStartPaddingBottom = i3;
        adjustPaddingBottom(this.mOffset, true);
    }

    public void setSubtitleHideEnable(boolean z3) {
        if (this.mSubtitleHideEnable != z3) {
            this.mSubtitleHideEnable = z3;
            updateSubtitle();
        }
    }

    public void updateSubtitle() {
        adjustSubtitleIfNeed(this.mOffset);
    }

    public COUICollapsableAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 0;
        this.mCollapsingToolbarHeight = 0;
        this.mSubtitleViewHeight = 0;
        this.mAutoExpand = true;
        this.mUpdateOffset = false;
        this.mNeedUpdateModeAfterOffsetChanged = false;
        init(attributeSet);
    }

    public COUICollapsableAppBarLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mMode = 0;
        this.mCollapsingToolbarHeight = 0;
        this.mSubtitleViewHeight = 0;
        this.mAutoExpand = true;
        this.mUpdateOffset = false;
        this.mNeedUpdateModeAfterOffsetChanged = false;
        init(attributeSet);
    }
}
