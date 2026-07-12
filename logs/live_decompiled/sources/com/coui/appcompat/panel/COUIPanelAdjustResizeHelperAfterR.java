package com.coui.appcompat.panel;

import M1.h;
import Y.f;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import y0.j;

/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelperAfterR extends COUIAbsPanelAdjustResizeHelper {
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT = 133.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE = 117.0f;
    private static final float DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 200.0f;
    private static final long PANEL_ALPHA_ANIM_DURATION = 250;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT = 132.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE = 150.0f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE = 300.0f;
    private static final String TAG = "AdjustResizeAfterR";
    private boolean mIsPanelAlphaRun;
    private ValueAnimator mMarginBottomAnim;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR = new Y.c();
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR = new f();
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE = new Y.c();
    private static final Interpolator DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE = new f();
    private int mWindowType = 2;
    private int mCurrentKeyboardHeight = 0;

    private ValueAnimator createPanelAlphaAnimation(final View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperAfterR.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view != null) {
                    view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (COUIPanelAdjustResizeHelperAfterR.this.mIsPanelAlphaRun) {
                        return;
                    }
                    COUIPanelAdjustResizeHelperAfterR.this.mIsPanelAlphaRun = true;
                }
            }
        });
        return ofFloat;
    }

    private void doMarginBottomAnim(final View view, final View view2, final int i3, boolean z3, final int i4, int i5) {
        float abs;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int max = Math.max(0, i4 + i5);
        int max2 = Math.max(0, i5);
        int k3 = j.k(view.getContext());
        this.mMarginBottomAnim = ValueAnimator.ofInt(max2, max);
        if (COUIPanelMultiWindowUtils.isLargeHeightScreen(view.getContext(), null)) {
            if (z3) {
                abs = Math.abs((i3 * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE) / k3) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
                this.mMarginBottomAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE);
            } else {
                abs = Math.abs((i3 * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT_IN_LARGE) / k3) + DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
                this.mMarginBottomAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR_IN_LARGE);
            }
        } else if (z3) {
            abs = Math.abs((i3 * SHOW_HEIGHT_ANIM_DURATION_COEFFICIENT) / k3) + SHOW_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
            this.mMarginBottomAnim.setInterpolator(SHOW_HEIGHT_ANIM_INTERPOLATOR);
        } else {
            abs = Math.abs((i3 * DISMISS_HEIGHT_ANIM_DURATION_COEFFICIENT) / k3) + DISMISS_HEIGHT_ANIM_DURATION_INITIAL_VALUE;
            this.mMarginBottomAnim.setInterpolator(DISMISS_HEIGHT_ANIM_INTERPOLATOR);
        }
        this.mMarginBottomAnim.setDuration((long) abs);
        ValueAnimator createPanelAlphaAnimation = createPanelAlphaAnimation(view);
        createPanelAlphaAnimation.setDuration(PANEL_ALPHA_ANIM_DURATION);
        createPanelAlphaAnimation.setInterpolator(this.mMarginBottomAnim.getInterpolator());
        this.mMarginBottomAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIPanelAdjustResizeHelperAfterR.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i6;
                View view3;
                if (view.isAttachedToWindow()) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    if (i4 > 0 && intValue >= (i6 = i3) && (view3 = view2) != null) {
                        view3.setPadding(0, 0, 0, Math.max(intValue - i6, 0));
                        intValue = i6;
                    }
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = intValue;
                        view.setLayoutParams(layoutParams2);
                    }
                }
            }
        });
        this.mMarginBottomAnim.start();
        if (!z3) {
            this.mIsPanelAlphaRun = false;
        }
        if (z3 && !this.mIsPanelAlphaRun && view.getAlpha() == 0.0f) {
            createPanelAlphaAnimation.start();
        }
    }

    private void setMarginBottomTo(View view, int i3, WindowInsets windowInsets, View view2) {
        int i4;
        if (view != null) {
            View findViewById = view2.findViewById(U1.f.f2408f);
            int measuredHeight = view2.getMeasuredHeight();
            int measuredHeight2 = view.getMeasuredHeight();
            if (i3 > measuredHeight * 0.9f) {
                Log.e(TAG, "KeyboardHeight > availableHeight * 0.9f, so not elevated");
                return;
            }
            Context context = view.getContext();
            View findViewById2 = view2.findViewById(h.f1483b);
            int panelMarginBottom = COUIPanelMultiWindowUtils.getPanelMarginBottom(context, context.getResources().getConfiguration(), windowInsets, findViewById2 instanceof COUIPanelPercentFrameLayout ? ((COUIPanelPercentFrameLayout) findViewById2).isIsHandlePanel() : false, isCouiPanelEdgeToEdgeEnable());
            int i5 = (measuredHeight <= 0 || measuredHeight2 <= 0 || (i4 = measuredHeight2 + i3) <= measuredHeight) ? i3 : i3 - (i4 - measuredHeight);
            int i6 = i3 - panelMarginBottom;
            ValueAnimator valueAnimator = this.mMarginBottomAnim;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mMarginBottomAnim.cancel();
            }
            if (i3 != 0) {
                doMarginBottomAnim(view, findViewById, i5, windowInsets.getInsets(WindowInsets.Type.ime()).bottom != 0, i6, panelMarginBottom);
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = panelMarginBottom;
                view.setLayoutParams(layoutParams);
            }
            if (findViewById != null) {
                findViewById.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z3) {
        if (z3) {
            int max = Math.max(0, windowInsets.getInsets(WindowInsets.Type.ime()).bottom - windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom);
            if (max == this.mCurrentKeyboardHeight) {
                Log.w(TAG, "keyboardHeight is the same size, keyboardHeight");
            } else {
                this.mCurrentKeyboardHeight = max;
                setMarginBottomTo(viewGroup, max, windowInsets, view);
            }
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getMarginBottomValue() {
        return -1;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getPaddingBottomOffset() {
        return -1;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public float getTranslateOffset() {
        return -1.0f;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public int getWindowType() {
        return this.mWindowType;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public boolean releaseData() {
        return true;
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void resetInnerStatus() {
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setIgnoreHideKeyboardAnim(boolean z3) {
    }

    @Override // com.coui.appcompat.panel.COUIAbsPanelAdjustResizeHelper
    public void setWindowType(int i3) {
        this.mWindowType = i3;
    }
}
