package com.oplus.flexibletask.setting.base;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import t1.d;
import t1.f;
import z1.AbstractC0652e;

/* loaded from: classes.dex */
public class SecondToolbarBehavior extends CoordinatorLayout.c implements AbsListView.OnScrollListener {
    private View mChild;
    private int mCurrentOffset;
    private View mDivider;
    private int mDividerAlphaChangeEndY;
    private int mDividerAlphaChangeOffset;
    private float mDividerAlphaRange;
    private AppBarLayout.LayoutParams mDividerParams;
    private int mDividerWidthChangeEndY;
    private int mDividerWidthChangeInitY;
    private int mDividerWidthChangeOffset;
    private float mDividerWidthRange;
    private int mListFirstChildInitY;
    private int[] mLocation;
    private int mLocationY;
    private int mMarginLeftRight;
    private int mNewOffset;
    private Resources mResources;
    private View mScrollView;

    /* renamed from: com.oplus.flexibletask.setting.base.SecondToolbarBehavior$1, reason: invalid class name */
    class AnonymousClass1 extends RecyclerView.u {
        AnonymousClass1() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.u
        public void onScrolled(RecyclerView recyclerView, int i3, int i4) {
            SecondToolbarBehavior.this.onListScroll();
        }
    }

    public SecondToolbarBehavior() {
        this.mLocation = new int[2];
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        this.mResources = resources;
        this.mMarginLeftRight = resources.getDimensionPixelOffset(d.f13377f);
        this.mDividerAlphaChangeOffset = this.mResources.getDimensionPixelOffset(d.f13380i);
        this.mDividerWidthChangeOffset = this.mResources.getDimensionPixelOffset(d.f13378g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onStartNestedScroll$0(View view, int i3, int i4, int i5, int i6) {
        onListScroll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onListScroll() {
        this.mChild = null;
        View view = this.mScrollView;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= viewGroup.getChildCount()) {
                        break;
                    }
                    if (viewGroup.getChildAt(i3).getVisibility() == 0) {
                        this.mChild = viewGroup.getChildAt(i3);
                        break;
                    }
                    i3++;
                }
            }
        }
        if (this.mChild == null) {
            this.mChild = this.mScrollView;
        }
        this.mChild.getLocationOnScreen(this.mLocation);
        int dimensionPixelOffset = this.mLocation[1] + this.mResources.getDimensionPixelOffset(d.f13383l);
        this.mLocationY = dimensionPixelOffset;
        this.mNewOffset = 0;
        int i4 = this.mDividerAlphaChangeEndY;
        if (dimensionPixelOffset < i4) {
            this.mNewOffset = this.mDividerAlphaChangeOffset;
        } else {
            int i5 = this.mListFirstChildInitY;
            if (dimensionPixelOffset > i5 || this.mLocation[1] >= 0) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i5 - dimensionPixelOffset;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        if (dimensionPixelOffset > i4) {
            float abs = Math.abs(r1) / this.mDividerAlphaChangeOffset;
            this.mDividerAlphaRange = abs;
            this.mDivider.setAlpha(abs);
        } else {
            this.mDivider.setAlpha(1.0f);
        }
        int i6 = this.mLocationY;
        if (i6 < this.mDividerWidthChangeEndY) {
            this.mNewOffset = this.mDividerWidthChangeOffset;
        } else {
            int i7 = this.mDividerWidthChangeInitY;
            if (i6 > i7) {
                this.mNewOffset = 0;
            } else {
                this.mNewOffset = i7 - i6;
            }
        }
        this.mCurrentOffset = this.mNewOffset;
        float abs2 = Math.abs(r0) / this.mDividerWidthChangeOffset;
        this.mDividerWidthRange = abs2;
        AppBarLayout.LayoutParams layoutParams = this.mDividerParams;
        int i8 = this.mMarginLeftRight;
        layoutParams.setMargins((int) (i8 * (1.0f - abs2)), ((LinearLayout.LayoutParams) layoutParams).topMargin, (int) (i8 * (1.0f - abs2)), ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
        this.mDivider.setLayoutParams(this.mDividerParams);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        onListScroll();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        AbstractC0652e.a("onScrollStateChanged");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i3, int i4) {
        if ((i3 & 2) == 0 || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight()) {
            return false;
        }
        if (this.mListFirstChildInitY <= 0) {
            this.mListFirstChildInitY = appBarLayout.getMeasuredHeight();
            this.mScrollView = view2;
            View findViewById = appBarLayout.findViewById(f.f13463w);
            this.mDivider = findViewById;
            this.mDividerParams = (AppBarLayout.LayoutParams) findViewById.getLayoutParams();
            int i5 = this.mListFirstChildInitY;
            this.mDividerAlphaChangeEndY = i5 - this.mDividerAlphaChangeOffset;
            int dimensionPixelOffset = i5 - this.mResources.getDimensionPixelOffset(d.f13379h);
            this.mDividerWidthChangeInitY = dimensionPixelOffset;
            this.mDividerWidthChangeEndY = dimensionPixelOffset - this.mDividerWidthChangeOffset;
        }
        view2.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.oplus.flexibletask.setting.base.b
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view3, int i6, int i7, int i8, int i9) {
                SecondToolbarBehavior.this.lambda$onStartNestedScroll$0(view3, i6, i7, i8, i9);
            }
        });
        return false;
    }

    public SecondToolbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLocation = new int[2];
        init(context);
    }
}
