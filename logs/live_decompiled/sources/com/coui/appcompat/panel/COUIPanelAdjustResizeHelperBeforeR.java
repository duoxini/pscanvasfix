package com.coui.appcompat.panel;

import M1.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.core.view.w;
import com.coui.appcompat.buttonBar.COUIButtonBarLayout;
import java.lang.ref.WeakReference;
import y0.j;

/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelperBeforeR extends COUIAbsPanelAdjustResizeHelper {
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT = 50.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 200.0f;
    private static final int IME_ADJUST = 1;
    private static final int IME_HIDE = 2;
    private static final int IME_SHOW = 0;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT = 120.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 300.0f;
    private ValueAnimator mBottomButtonBarAnim;
    private int mMarginBottomValue;
    private ValueAnimator mPaddingBottomAnim;
    private WeakReference<View> mPaddingBottomAnimView;
    private int mPaddingBottomOffset;
    private float mTranslateOffset;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR = new Y.c();
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR = new LinearInterpolator();
    private int mWindowType = 2;
    private int mAdjustResizeType = 2;
    private int mAdjustKeyboardStartHeight = 0;
    private int mAdjustKeyboardHeight = 0;
    private int mAdjustKeyboardOffset = 0;
    private int mFocusViewRawY = 0;
    private boolean mIsIgnoreHideKeyboardAnim = true;
    private boolean mIsKeyboardShow = false;
    private boolean mIsFocusViewDisplayInVerticalScrolledView = false;
    private View mFocusVerticalScrolledView = null;

    private void adjustResizeBeforeR(ViewGroup viewGroup, boolean z3, int i3) {
        updateAdjustKeyboardType(z3);
        updateAdjustKeyboardData(viewGroup, i3);
        updateAdjustKeyboardOffset(viewGroup, Boolean.valueOf(z3));
        doAdjustKeyboardAnim(viewGroup, z3);
        this.mIsIgnoreHideKeyboardAnim = false;
    }

    private void doAdjustKeyboardAnim(ViewGroup viewGroup, boolean z3) {
        if (viewGroup == null || this.mPaddingBottomAnimView == null) {
            return;
        }
        if (!(viewGroup instanceof COUIPanelContentLayout)) {
            int k3 = j.k(viewGroup.getContext());
            doMarginBottomAnim(viewGroup, this.mMarginBottomValue, (long) (z3 ? Math.abs((this.mAdjustKeyboardOffset * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT) / k3) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE : Math.abs((this.mAdjustKeyboardOffset * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT) / k3) + DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE));
            return;
        }
        COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) viewGroup;
        int maxHeight = cOUIPanelContentLayout.getMaxHeight();
        long abs = (long) (z3 ? Math.abs((this.mAdjustKeyboardOffset * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT) / maxHeight) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE : Math.abs((this.mAdjustKeyboardOffset * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT) / maxHeight) + DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE);
        doPaddingBottomAnim(this.mPaddingBottomAnimView.get(), this.mPaddingBottomOffset, abs);
        doBottomButtonTranslateAnim(cOUIPanelContentLayout, this.mTranslateOffset, abs);
    }

    private void doBottomButtonTranslateAnim(final COUIPanelContentLayout cOUIPanelContentLayout, float f3, long j3) {
        if (f3 == 0.0f || cOUIPanelContentLayout == null || cOUIPanelContentLayout.getBtnBarLayout() == null) {
            return;
        }
        float translationY = cOUIPanelContentLayout.getBtnBarLayout().getTranslationY();
        final float min = Math.min(0.0f, f3 + translationY);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(translationY, min);
        this.mBottomButtonBarAnim = ofFloat;
        ofFloat.setDuration(j3);
        if (translationY < min) {
            this.mBottomButtonBarAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
        } else {
            this.mBottomButtonBarAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
        }
        this.mBottomButtonBarAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                cOUIPanelContentLayout.getBtnBarLayout().setTranslationY(min);
                cOUIPanelContentLayout.getDivider().setTranslationY(min);
            }
        });
        this.mBottomButtonBarAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (cOUIPanelContentLayout.isAttachedToWindow()) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    cOUIPanelContentLayout.getBtnBarLayout().setTranslationY(floatValue);
                    cOUIPanelContentLayout.getDivider().setTranslationY(floatValue);
                }
            }
        });
        this.mBottomButtonBarAnim.start();
    }

    private void doMarginBottomAnim(final View view, int i3, long j3) {
        if (i3 == 0 || view == null) {
            return;
        }
        int max = Math.max(0, COUIViewMarginUtil.getMargin(view, 3));
        final int max2 = Math.max(0, i3 + max);
        ValueAnimator ofInt = ValueAnimator.ofInt(max, max2);
        ofInt.setDuration(j3);
        if (max < max2) {
            ofInt.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
        } else {
            ofInt.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
        }
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIViewMarginUtil.setMargin(view, max2, 3);
            }
        });
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view.isAttachedToWindow()) {
                    COUIViewMarginUtil.setMargin(view, ((Integer) valueAnimator.getAnimatedValue()).intValue(), 3);
                }
            }
        });
        ofInt.start();
    }

    private void doPaddingBottomAnim(final View view, int i3, long j3) {
        if (i3 == 0 || view == null) {
            return;
        }
        final int paddingLeft = view.getPaddingLeft();
        final int paddingRight = view.getPaddingRight();
        final int paddingTop = view.getPaddingTop();
        int max = Math.max(0, view.getPaddingBottom());
        final int max2 = Math.max(0, i3 + max);
        ValueAnimator ofInt = ValueAnimator.ofInt(max, max2);
        this.mPaddingBottomAnim = ofInt;
        ofInt.setDuration(j3);
        if (max < max2) {
            this.mPaddingBottomAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
        } else {
            this.mPaddingBottomAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
        }
        this.mPaddingBottomAnim.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setPadding(paddingLeft, paddingTop, paddingRight, max2);
            }
        });
        this.mPaddingBottomAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperBeforeR.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view.isAttachedToWindow()) {
                    view.setPadding(paddingLeft, paddingTop, paddingRight, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        });
        this.mPaddingBottomAnim.start();
    }

    private void findFocusView(ViewGroup viewGroup) {
        View findFocus;
        if (viewGroup == null || (findFocus = viewGroup.findFocus()) == null) {
            return;
        }
        this.mFocusViewRawY = 0;
        this.mIsFocusViewDisplayInVerticalScrolledView = false;
        this.mFocusVerticalScrolledView = null;
        if (isScrollable(findFocus)) {
            this.mIsFocusViewDisplayInVerticalScrolledView = true;
            this.mFocusVerticalScrolledView = findFocus;
        }
        this.mFocusViewRawY = getMeasureHeight(findFocus) + findFocus.getTop() + COUIViewMarginUtil.getMargin(findFocus, 3);
        for (View view = (View) findFocus.getParent(); view != null && view != viewGroup.getParent(); view = (View) view.getParent()) {
            if (isScrollable(view)) {
                this.mIsFocusViewDisplayInVerticalScrolledView = true;
                this.mFocusVerticalScrolledView = view;
            }
            this.mFocusViewRawY += view.getTop();
        }
    }

    private int getKeyboardHeightBeforeR(int i3, int i4) {
        return this.mWindowType == 2038 ? i3 : i3 - i4;
    }

    private int getMeasureHeight(View view) {
        if (view == null || view.getVisibility() == 8) {
            return 0;
        }
        int measuredHeight = view.getMeasuredHeight();
        if (measuredHeight != 0) {
            return measuredHeight;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }

    private boolean isScrollable(View view) {
        return (view instanceof ScrollView) || (view instanceof AbsListView) || (view instanceof w);
    }

    private boolean updateAdjustKeyboardData(ViewGroup viewGroup, int i3) {
        if (viewGroup == null) {
            return false;
        }
        releaseData();
        if (viewGroup instanceof COUIPanelContentLayout) {
            COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) viewGroup;
            viewGroup.measure(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(cOUIPanelContentLayout.getMaxHeight(), cOUIPanelContentLayout.getLayoutAtMaxHeight() ? 1073741824 : Integer.MIN_VALUE));
            findFocusView(viewGroup);
        }
        int measuredHeight = viewGroup.getMeasuredHeight();
        this.mAdjustKeyboardStartHeight = measuredHeight;
        int i4 = this.mAdjustResizeType;
        if (i4 == 0) {
            this.mAdjustKeyboardHeight = i3;
            this.mAdjustKeyboardOffset = i3;
        } else if (i4 == 1) {
            this.mAdjustKeyboardStartHeight = measuredHeight - i3;
            this.mAdjustKeyboardOffset = i3 - this.mAdjustKeyboardHeight;
            this.mAdjustKeyboardHeight = i3;
        } else if (i4 == 2 && !this.mIsIgnoreHideKeyboardAnim) {
            this.mAdjustKeyboardHeight = i3;
            this.mAdjustKeyboardOffset = i3;
        }
        return true;
    }

    private void updateAdjustKeyboardOffset(ViewGroup viewGroup, Boolean bool) {
        this.mPaddingBottomAnimView = null;
        this.mPaddingBottomOffset = 0;
        this.mTranslateOffset = 0.0f;
        this.mMarginBottomValue = 0;
        if (viewGroup == null || this.mAdjustKeyboardOffset == 0) {
            return;
        }
        if (viewGroup instanceof COUIPanelContentLayout) {
            updateOffsetInConstraintLayout((COUIPanelContentLayout) viewGroup, bool);
        } else {
            updateOffsetInNormalLayout(viewGroup, bool);
        }
    }

    private void updateAdjustKeyboardType(boolean z3) {
        this.mAdjustResizeType = 2;
        boolean z4 = this.mIsKeyboardShow;
        if (!z4 && z3) {
            this.mAdjustResizeType = 0;
        } else if (z4 && z3) {
            this.mAdjustResizeType = 1;
        }
        this.mIsKeyboardShow = z3;
    }

    private void updateOffsetInConstraintLayout(COUIPanelContentLayout cOUIPanelContentLayout, Boolean bool) {
        int i3 = this.mAdjustResizeType == 2 ? -1 : 1;
        int maxHeight = cOUIPanelContentLayout.getMaxHeight();
        int i4 = this.mAdjustKeyboardOffset * i3;
        float translationY = cOUIPanelContentLayout.getBtnBarLayout() != null ? cOUIPanelContentLayout.getBtnBarLayout().getTranslationY() : 0.0f;
        this.mPaddingBottomAnimView = new WeakReference<>(cOUIPanelContentLayout);
        if ((this.mIsFocusViewDisplayInVerticalScrolledView && maxHeight != 0) || (!COUIPanelMultiWindowUtils.isPortrait(cOUIPanelContentLayout.getContext()) && translationY == 0.0f)) {
            View view = this.mFocusVerticalScrolledView;
            if (view != null) {
                View view2 = (View) view.getParent();
                if (view2 != null) {
                    this.mPaddingBottomAnimView = new WeakReference<>(view2);
                }
                this.mTranslateOffset = -i4;
            }
            this.mPaddingBottomOffset = i4;
            return;
        }
        int i5 = this.mAdjustKeyboardStartHeight - this.mFocusViewRawY;
        int paddingBottom = cOUIPanelContentLayout.getPaddingBottom();
        int height = cOUIPanelContentLayout.getBtnBarLayout() != null ? cOUIPanelContentLayout.getBtnBarLayout().getHeight() : 0;
        int height2 = cOUIPanelContentLayout.getDivider() != null ? cOUIPanelContentLayout.getDivider().getHeight() : 0;
        int i6 = this.mAdjustResizeType;
        if (i6 == 1) {
            i5 += this.mAdjustKeyboardHeight;
        } else if (i6 == 2) {
            i5 -= this.mAdjustKeyboardHeight;
        }
        int i7 = this.mAdjustKeyboardHeight;
        if (i5 >= i7 + height + height2 && paddingBottom == 0) {
            this.mTranslateOffset = -i4;
            return;
        }
        int i8 = i3 * (((i7 + height) + height2) - i5);
        this.mPaddingBottomOffset = Math.max(-paddingBottom, i8);
        if (this.mAdjustResizeType != 1) {
            this.mTranslateOffset = bool.booleanValue() ? -(i4 - r2) : -translationY;
            return;
        }
        int max = Math.max(0, paddingBottom + i8);
        int i9 = this.mAdjustKeyboardHeight;
        this.mTranslateOffset = (-Math.min(i9, Math.max(-i9, i9 - max))) - translationY;
    }

    private void updateOffsetInNormalLayout(ViewGroup viewGroup, Boolean bool) {
        int i3 = (this.mAdjustResizeType == 2 ? -1 : 1) * this.mAdjustKeyboardOffset;
        this.mPaddingBottomAnimView = new WeakReference<>(viewGroup);
        this.mMarginBottomValue = i3;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z3) {
        if (viewGroup == null || !z3) {
            return;
        }
        int keyboardHeightBeforeR = getKeyboardHeightBeforeR(windowInsets.getSystemWindowInsetBottom(), (!COUINavigationBarUtil.isNavigationBarShow(context) || context.getResources().getBoolean(U1.b.f2366b)) ? 0 : COUINavigationBarUtil.getNavigationBarHeight(context));
        if (keyboardHeightBeforeR > 0) {
            adjustResizeBeforeR(viewGroup, true, keyboardHeightBeforeR);
            return;
        }
        if (this.mAdjustResizeType != 2) {
            adjustResizeBeforeR(viewGroup, false, this.mAdjustKeyboardHeight);
        }
        View findViewById = view.findViewById(h.f1483b);
        int panelMarginBottom = COUIPanelMultiWindowUtils.getPanelMarginBottom(viewGroup.getContext(), viewGroup.getContext().getResources().getConfiguration(), windowInsets, findViewById instanceof COUIPanelPercentFrameLayout ? ((COUIPanelPercentFrameLayout) findViewById).isIsHandlePanel() : false, isCouiPanelEdgeToEdgeEnable());
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = panelMarginBottom;
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getMarginBottomValue() {
        return this.mMarginBottomValue;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getPaddingBottomOffset() {
        return this.mPaddingBottomOffset;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public float getTranslateOffset() {
        return this.mTranslateOffset;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getWindowType() {
        return this.mWindowType;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
        if (cOUIPanelContentLayout != null) {
            COUIButtonBarLayout btnBarLayout = cOUIPanelContentLayout.getBtnBarLayout();
            View divider = cOUIPanelContentLayout.getDivider();
            if (btnBarLayout != null) {
                btnBarLayout.setTranslationY(0.0f);
            }
            if (divider != null) {
                divider.setTranslationY(0.0f);
            }
            cOUIPanelContentLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public boolean releaseData() {
        ValueAnimator valueAnimator = this.mPaddingBottomAnim;
        boolean z3 = false;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.mPaddingBottomAnim.cancel();
                z3 = true;
            }
            this.mPaddingBottomAnim = null;
        }
        ValueAnimator valueAnimator2 = this.mBottomButtonBarAnim;
        if (valueAnimator2 != null) {
            if (valueAnimator2.isRunning()) {
                this.mBottomButtonBarAnim.cancel();
            }
            this.mBottomButtonBarAnim = null;
        }
        return z3;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void resetInnerStatus() {
        this.mAdjustKeyboardHeight = 0;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setIgnoreHideKeyboardAnim(boolean z3) {
        this.mIsIgnoreHideKeyboardAnim = z3;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setWindowType(int i3) {
        this.mWindowType = i3;
    }
}
