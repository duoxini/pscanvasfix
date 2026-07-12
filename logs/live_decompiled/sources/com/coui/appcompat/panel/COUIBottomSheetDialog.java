package com.coui.appcompat.panel;

import B.b;
import B.f;
import F0.i;
import M1.h;
import U1.g;
import Z.b;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.preference.Preference;
import com.coui.appcompat.edittext.COUIInputView;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.panel.COUIBottomSheetBehavior;
import com.oplus.dynamicframerate.AnimationVelocityCalculator;
import com.oplus.dynamicframerate.DynamicFrameRateManager;
import com.oplus.wrapper.view.ViewTreeObserver;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import h0.AbstractC0371a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import x.AbstractC0626a;
import y0.j;
import z0.AbstractC0647b;

/* loaded from: classes.dex */
public class COUIBottomSheetDialog extends com.google.android.material.bottomsheet.a implements b.r, b.q {
    private static final float ALPHA_OPAQUE = 1.0f;
    private static final float ALPHA_TRANSPARENT = 0.0f;
    private static final int ANIMATION_TYPE_DIALOG_ALPHA = 8;
    public static final int ANIMATION_TYPE_ID = 10101;
    private static final int ANIMATION_TYPE_OUTSIDE_ALPHA = 2;
    private static final int ANIMATION_TYPE_SCALE = 4;
    private static final int ANIMATION_TYPE_TRANSLATION = 1;
    private static final boolean DEBUG;
    private static final float DEFAULT_ALPHA_HIDE_SPRING_RESPONSE = 0.25f;
    private static final float DEFAULT_ALPHA_HIDING_ANIMATOR_DURATION = 183.0f;
    private static final float DEFAULT_ALPHA_SHOW_SPRING_RESPONSE = 0.25f;
    private static final float DEFAULT_CENTER_HIDE_SPRING_RESPONSE = 0.25f;
    private static final float DEFAULT_CENTER_SHOW_SPRING_RESPONSE = 0.25f;
    private static final float DEFAULT_MINIMUM_VISIBLE_CHANGE_DISMISS = 10.0f;
    private static final float DEFAULT_MINIMUM_VISIBLE_CHANGE_SHOW = 1.0f;
    private static final int DEFAULT_MOVE_PX = 1;
    private static final float DEFAULT_SPRING_DAMPING_RATIO = 0.7f;
    private static final int DEFAULT_SPRING_FACTOR = 10000;
    private static final float DEFAULT_SPRING_STIFFNESS = 200.0f;
    private static final float DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION = 333.0f;
    static final float DEFAULT_TRANSLATION_HIDE_SPRING_RESPONSE_LARGE = 0.37f;
    static final float DEFAULT_TRANSLATION_HIDE_SPRING_RESPONSE_SMALL = 0.18f;
    private static final float DEFAULT_TRANSLATION_SHOW_SPRING_RESPONSE_LARGE = 0.45f;
    private static final float DEFAULT_TRANSLATION_SHOW_SPRING_RESPONSE_SMALL = 0.25f;
    private static final float DEFAULT_TRANSLATION_SPRING_BOUNCE = 0.0f;
    private static final float DIALOG_SHOW_SCALE_DELTA = 0.2f;
    private static final float DIALOG_SHOW_SCALE_START = 0.8f;
    private static final Interpolator DISMISS_ALPHA_ANIM_INTERPOLATOR;
    private static final float ELEVATION_VALUE = 24.0f;
    private static final int FINAL_POSITION = 100;
    private static final float FIRST_TIER_ALPHA = 0.75f;
    private static final float FLOAT_ONE = 1.0f;
    private static final float FLOAT_POINT_FIVE = 0.5f;
    private static final int HUNDRED = 100;
    private static final int INT_TWO = 2;
    private static final float MAX_ALPHA = 255.0f;
    private static final long NAV_COLOR_ANIM_DURATION = 200;
    private static final float NO_ELEVATION_VALUE = 0.0f;
    private static final Interpolator OUTSIDE_ALPHA_ANIM_INTERPOLATOR;
    private static final float PHYSICS_UNSET = Float.MIN_VALUE;
    private static final float PULL_UP_FRICTION = 0.8f;
    private static final int PULL_UP_REBOUND_BOUNCINESS = 6;
    private static final int PULL_UP_REBOUND_SPEED = 42;
    private static final int SDK_SUB_VERSION_FOR_COMPUTE = 10;
    private static final int SDK_SUB_VERSION_FOR_FRAME_RATE = 10;
    private static final int SDK_VERSION_FOR_COMPUTE = 34;
    private static final float SECOND_TIER_ALPHA = 0.5f;
    private static final float SHOW_HEIGHT_ANIM_DURATION_IN_TINY_SCREEN = 167.0f;
    private static final Interpolator SHOW_HEIGHT_ANIM_INTERPOLATOR;
    private static final String STATE_FOCUS_CHANGES = "state_focus_changes";
    private static final String STATE_LAST_STATIC_CHANGES = "last_static_state";
    private static final String TAG = "COUIBottomSheetDialog";
    private static final float THIRD_TIER_ALPHA = 0.25f;
    private static final double THREE_POINT_EIGHT = 3.8d;
    private static final double TWENTY = 20.0d;
    private static final int UNSET_SIZE = -1;
    private static final double ZERO = 0.0d;
    protected boolean isLargeScreenLimitMaxSize;
    private int mADFRFeatureType;
    private WeakReference<Activity> mActivityWeakReference;
    private ViewGroup mAdjustLayout;
    private boolean mAdjustResizeEnable;
    private COUIPanelAdjustResizeHelper mAdjustResizeHelper;
    private Z.c mAlphaSpringAnimation;
    private b.q mAlphaSpringEndListener;
    private b.r mAlphaSpringUpdateListener;
    private View mAnchorView;
    private int mAnimationFlag;
    private OnAnimationListener mAnimationListener;
    private float mAppearDampingRatio;
    private B.e mAppearSpringAnim;
    private f mAppearSpringForce;
    private float mAppearStiffness;
    private WindowInsets mApplyWindowInsets;
    private BottomSheetDialogAnimatorListener mBottomSheetDialogAnimatorListener;
    private boolean mCanPerformHapticFeedback;
    private boolean mCanPullUp;
    private boolean mCancelable;
    private boolean mCanceledOnTouchOutside;
    private int mColorMask;
    private ComponentCallbacks mComponentCallbacks;
    private Configuration mConfiguration;
    private IgnoreWindowInsetsFrameLayout mContainerFrameLayout;
    private View mContentView;
    private View mCoordinatorLayout;
    protected int mCoordinatorLayoutMinInsetsTop;
    private int mCoordinatorLayoutPaddingExtra;
    private boolean mCouiPanelEdgeToEdgeEnable;
    private float mCurrentOutSideAlphaStateHidden;
    private float mCurrentOutSideAlphaStateShow;
    private float mCurrentOutsideAlpha;
    private float mCurrentParentViewTranslationY;
    private int mCurrentSpringTotalOffset;
    private int mDefaultPaddingBottom;
    private COUIPanelPercentFrameLayout mDesignBottomSheetFrameLayout;
    private DialogOffsetListener mDialogOffsetListener;
    private F0.e mDisableFastCloseFeedbackSpring;
    private boolean mDisableSubExpand;
    protected COUIPanelContentLayout mDraggableConstraintLayout;
    private float mEndValueOfTranslateAnimation;
    private View mFeedBackView;

    @Deprecated
    private int mFinalNavColorAfterDismiss;
    private boolean mFirstShowCollapsed;
    private Boolean mFocusChange;
    private boolean mFrameRate;
    private boolean mGlobalDrag;
    private GradientDrawable mGradientDrawable;
    private boolean mHandleViewHasPressAnim;
    private int mHideDragViewHeight;
    private InputMethodManager mInputMethodManager;
    private boolean mIsAnimationInFirst;
    private boolean mIsAppearSpringAnimStared;
    private boolean mIsDraggable;
    private boolean mIsEntering;

    @Deprecated
    private boolean mIsExecuteNavColorAnimAfterDismiss;
    private boolean mIsExecutingDismissAnim;
    private boolean mIsFullScreenInTinyScreen;
    private boolean mIsGestureNavigation;
    private boolean mIsHandlePanel;
    private boolean mIsInTinyScreen;
    private boolean mIsInWindowFloatingMode;
    private boolean mIsInterruptingAnim;
    private boolean mIsNeedOutsideViewAnim;
    private boolean mIsNeedShowKeyboard;
    private boolean mIsRevertAnimationFromSettlingAnimation;
    private boolean mIsShowInDialogFragment;
    private boolean mIsShowInMaxHeight;
    private boolean mIsVSdk;
    private int mLastStaticState;
    private int mNavColor;
    private View mNavigationCustomView;
    private ViewTreeObserver.OnComputeInternalInsetsListener mOSDKComputeListener;
    private ViewTreeObserver mOSDKViewTreeObserver;
    private View.OnAttachStateChangeListener mOnAttatchStateChangeListener;
    private OnBackInvokedCallback mOnBackInvokedCallback;
    private OnBackInvokedLocalListener mOnBackInvokedLocalListener;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    private int mOriginWidth;
    private View.OnTouchListener mOutSideViewTouchListener;
    private View mOutsideView;
    private float mOutsideViewBackgroundAlpha;
    private Drawable mPanelBackground;
    private int mPanelBackgroundTintColor;
    private COUIPanelBarView mPanelBarView;
    private Drawable mPanelDragViewDrawable;
    private int mPanelDragViewDrawableTintColor;
    private int mPanelHeight;
    private int mPanelPaddingBottom;
    private COUIPanelPullUpListener mPanelPullUpListener;
    private F0.e mPanelSpringBackAnim;
    private AnimatorSet mPanelViewTranslationAnimationSet;
    private int mPanelWidth;
    private int mParentViewPaddingBottom;
    private int mPeekHeight;
    private float mPhysicsDampingRatio;
    private float mPhysicsFrequency;
    private int mPreferWidth;
    private WindowInsets mProgressWindowInsets;
    private int mPullUpMaxOffset;
    private COUIBottomSheetBehavior.PullUpToDismissPanelListener mPullUpToDismissPanelListener;
    private View mPulledUpView;
    private boolean mRegisterConfigurationChangeCallBack;
    private boolean mShouldRegisterWindowInsetsListener;
    private boolean mSkipCollapsed;
    private int mSnapStartBottom;
    private Z.d mSpringForceAlpha;
    private Z.d mSpringForceTranslationAndScale;
    private float mStartValueOfTranslateAnimation;
    private int mStatusBarHeight;
    private boolean mSupportExitBlockingAnimation;
    private final Rect mTemtRect;
    private float mTranslateHidingDuration;
    private b.q mTranslationAndScaleEndListener;
    private Z.c mTranslationAndScaleSpringAnimation;
    private b.r mTranslationAndScaleUpdateListener;
    private boolean mWindowInsetsAnimEnable;
    private int mWindowInsetsLeft;
    private View.OnApplyWindowInsetsListener mWindowInsetsListener;
    private int mWindowInsetsTop;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationType {
    }

    public interface BottomSheetDialogAnimatorListener {
        void onBottomSheetDialogCollapsed();

        void onBottomSheetDialogExpanded();
    }

    public interface DialogOffsetListener {
        void onDialogOffsetChanged(float f3);
    }

    public interface OnAnimationListener {
        default void onDismissAnimationEnd() {
        }

        default void onDismissAnimationStart() {
        }

        default void onShowAnimationEnd() {
        }

        default void onShowAnimationStart() {
        }
    }

    public interface OnBackInvokedLocalListener {
        void onBackInvokedLocal();
    }

    static {
        Y.c cVar = new Y.c();
        SHOW_HEIGHT_ANIM_INTERPOLATOR = cVar;
        OUTSIDE_ALPHA_ANIM_INTERPOLATOR = new Y.b();
        DISMISS_ALPHA_ANIM_INTERPOLATOR = cVar;
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public COUIBottomSheetDialog(Context context) {
        this(context, 0);
    }

    private void addAnimationFlag(int i3) {
        this.mAnimationFlag = i3 | this.mAnimationFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOSDKViewTreeObserver() {
        if (this.mOSDKViewTreeObserver == null) {
            com.oplus.wrapper.view.ViewTreeObserver viewTreeObserver = new com.oplus.wrapper.view.ViewTreeObserver(this.mOutsideView.getViewTreeObserver());
            this.mOSDKViewTreeObserver = viewTreeObserver;
            viewTreeObserver.addOnComputeInternalInsetsListener(this.mOSDKComputeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustResize(WindowInsets windowInsets, boolean z3) {
        if (z3) {
            boolean z4 = getContext().getResources().getBoolean(U1.b.f2365a);
            ViewGroup viewGroup = (ViewGroup) findViewById(h.f1483b);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(U1.f.f2408f);
            if (z4) {
                viewGroup = viewGroup2;
            }
            ViewGroup viewGroup3 = this.mAdjustLayout;
            if (viewGroup3 != (z4 ? this.mDraggableConstraintLayout : this.mDesignBottomSheetFrameLayout)) {
                COUIViewMarginUtil.setMargin(viewGroup3, 3, 0);
            }
            ViewGroup viewGroup4 = z4 ? this.mDraggableConstraintLayout : this.mDesignBottomSheetFrameLayout;
            this.mAdjustLayout = viewGroup4;
            if (viewGroup4 != null) {
                viewGroup = viewGroup4;
            }
            adjustResizeInternal(windowInsets, viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustResizeInternal(final WindowInsets windowInsets, final ViewGroup viewGroup) {
        if (viewGroup == null || !viewGroup.isLayoutRequested()) {
            getAdjustResizeHelper().adjustResize(getContext(), viewGroup, windowInsets, this.mCoordinatorLayout, getFocusChange());
        } else {
            viewGroup.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.9
                @Override // java.lang.Runnable
                public void run() {
                    COUIBottomSheetDialog.this.adjustResizeInternal(windowInsets, viewGroup);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animationEnd() {
        if (this.mDesignBottomSheetFrameLayout != null) {
            if (!isFollowHand() && !isFadeInCenter()) {
                this.mDesignBottomSheetFrameLayout.setTranslationY(this.mCurrentParentViewTranslationY);
            }
            if (getBehavior() != null && getBehavior().getState() == 3 && this.mCanPerformHapticFeedback) {
                this.mDesignBottomSheetFrameLayout.performHapticFeedback(14);
            }
        }
        OnAnimationListener onAnimationListener = this.mAnimationListener;
        if (onAnimationListener != null) {
            onAnimationListener.onShowAnimationEnd();
        }
        if (isFollowHand()) {
            haveEnoughSpace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animationStart() {
        if (getBehavior() != null && getBehavior().getState() == 5) {
            ((COUIBottomSheetBehavior) getBehavior()).setPanelState(this.mLastStaticState);
        }
        OnAnimationListener onAnimationListener = this.mAnimationListener;
        if (onAnimationListener != null) {
            onAnimationListener.onShowAnimationStart();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int[] calculateFinalLocationOnScreen(android.view.View r17) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIBottomSheetDialog.calculateFinalLocationOnScreen(android.view.View):int[]");
    }

    private void cancelAnim(Animator animator) {
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.end();
    }

    private void checkInitState() {
        if (this.mContainerFrameLayout == null) {
            throw new IllegalArgumentException("container can not be null");
        }
        if (this.mCoordinatorLayout == null) {
            throw new IllegalArgumentException("coordinator can not be null");
        }
        if (this.mOutsideView == null) {
            throw new IllegalArgumentException("panel_outside can not be null");
        }
        if (this.mDesignBottomSheetFrameLayout == null) {
            throw new IllegalArgumentException("design_bottom_sheet can not be null");
        }
    }

    private ValueAnimator createNavigationColorAnimation(int i3) {
        if (COUINavigationBarUtil.isNavigationBarShow(getContext()) && getWindow() != null) {
            final Window window = getWindow();
            int navigationBarColor = window.getNavigationBarColor();
            if (Color.alpha(i3) == 0) {
                i3 = Color.argb(1, Color.red(i3), Color.green(i3), Color.blue(i3));
            }
            if (navigationBarColor != i3) {
                ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(navigationBarColor), Integer.valueOf(i3));
                ofObject.setDuration(NAV_COLOR_ANIM_DURATION);
                ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.23
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        window.setNavigationBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                return ofObject;
            }
        }
        return null;
    }

    private ValueAnimator createOutsideAlphaAnimation(final boolean z3, float f3, PathInterpolator pathInterpolator) {
        final float f4 = this.mCurrentOutsideAlpha;
        final float f5 = z3 ? 1.0f : 0.0f;
        if (f4 == f5) {
            AbstractC0371a.g(TAG, "StartAlphaValue == endAlphaValue, No need to perform transparency animation anymore");
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
        ofFloat.setDuration((long) f3);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.21
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f6 = f4;
                float f7 = f5;
                COUIBottomSheetDialog.this.outsideAlphaChange(f6 != f7 ? (floatValue - f6) / (f7 - f6) : 0.0f, z3);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.22
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null && COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getAlpha() == 0.0f) {
                    COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setAlpha(1.0f);
                }
                COUIBottomSheetDialog.this.mIsNeedShowKeyboard = false;
            }
        });
        return ofFloat;
    }

    private void createPanelConstraintLayout() {
        COUIPanelContentLayout cOUIPanelContentLayout = (COUIPanelContentLayout) getLayoutInflater().inflate(this.mIsInTinyScreen ? g.f2427f : g.f2426e, (ViewGroup) null);
        Drawable drawable = this.mPanelDragViewDrawable;
        if (drawable != null) {
            drawable.setTint(this.mPanelDragViewDrawableTintColor);
            cOUIPanelContentLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
        }
        if (this.mHandleViewHasPressAnim) {
            cOUIPanelContentLayout.setDragViewPressAnim(true);
        }
        WindowInsets windowInsets = this.mApplyWindowInsets;
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        cOUIPanelContentLayout.setNavigationMargin(null, windowInsets, cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getRatio() == 1.0f, this.mCouiPanelEdgeToEdgeEnable);
        this.mDraggableConstraintLayout = cOUIPanelContentLayout;
        if (this.mIsHandlePanel) {
            return;
        }
        hideDragView();
    }

    private ValueAnimator createPanelTranslateAnimation(float f3, float f4, float f5, PathInterpolator pathInterpolator) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f4);
        ofFloat.setDuration((long) f5);
        ofFloat.setInterpolator(pathInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.16
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                COUIBottomSheetDialog.this.translateUpdate(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        setFrameRate(ofFloat);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWithAlphaAnim() {
        this.mIsEntering = false;
        this.mIsRevertAnimationFromSettlingAnimation = false;
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIBottomSheetDialog.this.mCurrentOutSideAlphaStateHidden = 0.0f;
                super.onAnimationCancel(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener != null) {
                    COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener.onBottomSheetDialogCollapsed();
                }
                COUIBottomSheetDialog.this.mCurrentOutSideAlphaStateHidden = 0.0f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = true;
                if (COUIBottomSheetDialog.this.mAnimationListener != null) {
                    COUIBottomSheetDialog.this.mAnimationListener.onDismissAnimationStart();
                }
                super.onAnimationStart(animator);
            }
        };
        stopCurrentRunningViewTranslationAnim();
        this.mCurrentOutSideAlphaStateHidden = this.mCurrentOutsideAlpha;
        resetAnimationFlag();
        addAnimationFlag(2);
        doAlphaSpringAnimaion(animatorListenerAdapter);
    }

    private void dismissWithInterruptibleAnim() {
        doParentViewTranslationHidingAnim(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.10
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener != null) {
                    COUIBottomSheetDialog.this.mBottomSheetDialogAnimatorListener.onBottomSheetDialogCollapsed();
                }
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = false;
                COUIBottomSheetDialog.this.superDismiss();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                COUIBottomSheetDialog.this.mIsExecutingDismissAnim = true;
                if (COUIBottomSheetDialog.this.mAnimationListener != null) {
                    COUIBottomSheetDialog.this.mAnimationListener.onDismissAnimationStart();
                }
            }
        });
    }

    private void doAlphaSpringAnimaion(final Animator.AnimatorListener animatorListener) {
        if (this.mAlphaSpringAnimation == null) {
            this.mAlphaSpringAnimation = new Z.c(new B.d());
            Z.d dVar = new Z.d();
            this.mSpringForceAlpha = dVar;
            dVar.d(0.0f);
            this.mAlphaSpringAnimation.B(this.mSpringForceAlpha);
        }
        if (hasAnimationFlag(2)) {
            if (!isFadeInCenter()) {
                this.mSpringForceAlpha.g(getTranslationResponse());
            } else if (this.mIsEntering) {
                this.mSpringForceAlpha.g(0.25f);
            } else {
                this.mSpringForceAlpha.g(0.25f);
            }
        }
        if (animatorListener != null) {
            this.mAlphaSpringAnimation.i(this.mAlphaSpringEndListener);
            b.q qVar = new b.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.14
                @Override // Z.b.q
                public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
                    if (z3) {
                        animatorListener.onAnimationCancel(null);
                    } else {
                        animatorListener.onAnimationEnd(null);
                    }
                    COUIBottomSheetDialog.this.mAlphaSpringAnimation.i(COUIBottomSheetDialog.this.mAlphaSpringEndListener);
                    COUIBottomSheetDialog.this.mAlphaSpringAnimation.l(COUIBottomSheetDialog.this.mAlphaSpringUpdateListener);
                }
            };
            this.mAlphaSpringEndListener = qVar;
            this.mAlphaSpringAnimation.a(qVar);
            animatorListener.onAnimationStart(null);
        }
        this.mAlphaSpringAnimation.l(this.mAlphaSpringUpdateListener);
        this.mAlphaSpringUpdateListener = new b.r() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.15
            @Override // Z.b.r
            public void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                float f5 = COUIBottomSheetDialog.this.mEndValueOfTranslateAnimation != COUIBottomSheetDialog.this.mStartValueOfTranslateAnimation ? (f3 - COUIBottomSheetDialog.this.mStartValueOfTranslateAnimation) / (COUIBottomSheetDialog.this.mEndValueOfTranslateAnimation - COUIBottomSheetDialog.this.mStartValueOfTranslateAnimation) : 0.0f;
                if (COUIBottomSheetDialog.this.hasAnimationFlag(2)) {
                    COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog.outsideAlphaChange(f5, cOUIBottomSheetDialog.mIsEntering);
                }
                if (!COUIBottomSheetDialog.this.hasAnimationFlag(8) || COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout == null) {
                    return;
                }
                COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout;
                if (!COUIBottomSheetDialog.this.mIsEntering) {
                    f5 = Math.max(0.0f, 1.0f - f5);
                }
                cOUIPanelPercentFrameLayout.setAlpha(f5);
            }
        };
        if (this.mIsRevertAnimationFromSettlingAnimation) {
            this.mCurrentOutSideAlphaStateShow = this.mOutsideView.getAlpha();
        } else {
            this.mCurrentOutSideAlphaStateShow = 0.0f;
        }
        this.mAlphaSpringAnimation.b(this.mAlphaSpringUpdateListener);
        this.mAlphaSpringAnimation.o(this.mStartValueOfTranslateAnimation);
        this.mAlphaSpringAnimation.u(this.mEndValueOfTranslateAnimation);
    }

    private void doFeedbackAnimation(View view) {
        if (view == null) {
            return;
        }
        if (this.mDisableFastCloseFeedbackSpring == null || this.mFeedBackView != view) {
            this.mFeedBackView = view;
            F0.e c3 = i.g().c();
            this.mDisableFastCloseFeedbackSpring = c3;
            c3.l(F0.f.a(THREE_POINT_EIGHT, TWENTY));
            this.mDisableFastCloseFeedbackSpring.a(new F0.g() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.24
                @Override // F0.g
                public void onSpringActivate(F0.e eVar) {
                }

                @Override // F0.g
                public void onSpringAtRest(F0.e eVar) {
                }

                @Override // F0.g
                public void onSpringEndStateChange(F0.e eVar) {
                }

                @Override // F0.g
                public void onSpringUpdate(F0.e eVar) {
                    if (COUIBottomSheetDialog.this.mDisableFastCloseFeedbackSpring == null || COUIBottomSheetDialog.this.mFeedBackView == null) {
                        return;
                    }
                    int c4 = (int) eVar.c();
                    if (c4 >= 100) {
                        COUIBottomSheetDialog.this.mDisableFastCloseFeedbackSpring.k(0.0d);
                    }
                    COUIBottomSheetDialog.this.mFeedBackView.setTranslationY(c4);
                }
            });
        }
        this.mDisableFastCloseFeedbackSpring.k(100.0d);
    }

    private void doParentViewTranslationHidingAnim(Animator.AnimatorListener animatorListener) {
        if (reversalAnimation(animatorListener, false)) {
            this.mIsExecutingDismissAnim = true;
            return;
        }
        this.mIsEntering = false;
        stopCurrentRunningViewTranslationAnim();
        resetAnimationFlag();
        if (getDialogMaxHeight() == 0) {
            Log.d(TAG, "doParentViewTranslationHidingAnim return directly for dialogMaxHeight is 0, but call superDismiss");
            superDismiss();
            return;
        }
        this.mPanelViewTranslationAnimationSet = new AnimatorSet();
        if (this.mIsInTinyScreen) {
            startReleaseAnimInTinyScreen(this.mStartValueOfTranslateAnimation, this.mEndValueOfTranslateAnimation, this.mTranslateHidingDuration, animatorListener);
            return;
        }
        if (isFollowHand()) {
            setDefaultSpringStartEndValue();
            if (this.mDesignBottomSheetFrameLayout.getAlpha() != 1.0f) {
                this.mDesignBottomSheetFrameLayout.setAlpha(1.0f);
            }
            if (haveEnoughSpace()) {
                addAnimationFlag(8);
            } else {
                addAnimationFlag(8);
                addAnimationFlag(2);
            }
        } else if (isFadeInCenter()) {
            addAnimationFlag(4);
            addAnimationFlag(2);
            addAnimationFlag(8);
            setDefaultSpringStartEndValue();
        } else {
            addAnimationFlag(1);
            addAnimationFlag(2);
            this.mStartValueOfTranslateAnimation = (int) this.mCurrentParentViewTranslationY;
            this.mEndValueOfTranslateAnimation = getTranslationDistance();
        }
        this.mIsAnimationInFirst = false;
        doTranslationAndScaleSpringAnimaion(animatorListener);
        doAlphaSpringAnimaion(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doParentViewTranslationShowingAnim(int i3, Animator.AnimatorListener animatorListener) {
        this.mCurrentOutSideAlphaStateShow = 0.0f;
        if (reversalAnimation(animatorListener, true)) {
            this.mIsExecutingDismissAnim = false;
            return;
        }
        if (((COUIBottomSheetBehavior) getBehavior()).isPanelHeightChangeAnimRunning()) {
            this.mIsRevertAnimationFromSettlingAnimation = true;
            ((COUIBottomSheetBehavior) getBehavior()).stopSettlingAnimationIfRunning();
            this.mIsExecutingDismissAnim = false;
        }
        stopCurrentRunningViewTranslationAnim();
        resetAnimationFlag();
        if (getDialogMaxHeight() == 0) {
            Log.d(TAG, "doParentViewTranslationShowingAnim return directly for dialogMaxHeight is 0");
            return;
        }
        this.mIsEntering = true;
        getContentViewHeightWithMargins();
        this.mPanelViewTranslationAnimationSet = new AnimatorSet();
        if (this.mIsInTinyScreen) {
            startShowingAnimInTinyScreen(i3, animatorListener);
            return;
        }
        if (isFollowHand()) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getAlpha() != 0.0f) {
                this.mDesignBottomSheetFrameLayout.setAlpha(0.0f);
                this.mDesignBottomSheetFrameLayout.setScaleX(0.8f);
                this.mDesignBottomSheetFrameLayout.setScaleY(0.8f);
            }
            setDefaultSpringStartEndValue();
            if (haveEnoughSpace()) {
                offsetViewTo();
                addAnimationFlag(8);
                addAnimationFlag(4);
            } else {
                updateBottomSheetCenterVertical();
                addAnimationFlag(8);
                addAnimationFlag(4);
                addAnimationFlag(2);
            }
        } else if (isFadeInCenter()) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout2 = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout2 != null) {
                cOUIPanelPercentFrameLayout2.setAlpha(0.0f);
                this.mDesignBottomSheetFrameLayout.setScaleX(0.8f);
                this.mDesignBottomSheetFrameLayout.setScaleY(0.8f);
            }
            addAnimationFlag(4);
            addAnimationFlag(2);
            addAnimationFlag(8);
            setDefaultSpringStartEndValue();
        } else {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout3 = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout3 != null) {
                cOUIPanelPercentFrameLayout3.setAlpha(1.0f);
                this.mDesignBottomSheetFrameLayout.setScaleX(1.0f);
                this.mDesignBottomSheetFrameLayout.setScaleY(1.0f);
            }
            addAnimationFlag(1);
            addAnimationFlag(2);
            this.mStartValueOfTranslateAnimation = getTranslationDistance();
            this.mEndValueOfTranslateAnimation = 0.0f;
            if (this.mIsRevertAnimationFromSettlingAnimation) {
                this.mStartValueOfTranslateAnimation = this.mDesignBottomSheetFrameLayout.getTop();
            }
        }
        this.mIsAnimationInFirst = true;
        doTranslationAndScaleSpringAnimaion(animatorListener);
        doAlphaSpringAnimaion(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSpringBackReboundAnim(final int i3) {
        F0.e c3 = i.g().c();
        this.mPanelSpringBackAnim = c3;
        c3.l(F0.f.a(6.0d, 42.0d));
        this.mCurrentSpringTotalOffset = 0;
        this.mPanelSpringBackAnim.a(new F0.g() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.28
            @Override // F0.g
            public void onSpringActivate(F0.e eVar) {
            }

            @Override // F0.g
            public void onSpringAtRest(F0.e eVar) {
                if ((COUIBottomSheetDialog.this.getBehavior() instanceof COUIBottomSheetBehavior) && COUIBottomSheetDialog.this.mPulledUpView != null) {
                    COUIBottomSheetDialog.this.mParentViewPaddingBottom = 0;
                    COUIBottomSheetDialog.this.setPulledUpViewPaddingBottom(0);
                    ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.getBehavior()).setStateInternal(3);
                }
                COUIBottomSheetDialog.this.setCanPullUp(true);
            }

            @Override // F0.g
            public void onSpringEndStateChange(F0.e eVar) {
            }

            @Override // F0.g
            public void onSpringUpdate(F0.e eVar) {
                if (COUIBottomSheetDialog.this.mPanelSpringBackAnim == null || COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout == null) {
                    return;
                }
                if (eVar.o() && eVar.f() == 0.0d) {
                    COUIBottomSheetDialog.this.mPanelSpringBackAnim.j();
                    return;
                }
                int c4 = (int) eVar.c();
                COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.offsetTopAndBottom(c4 - COUIBottomSheetDialog.this.mCurrentSpringTotalOffset);
                COUIBottomSheetDialog.this.mCurrentSpringTotalOffset = c4;
                COUIBottomSheetDialog.this.setPulledUpViewPaddingBottom(i3 - c4);
            }
        });
        this.mPanelSpringBackAnim.k(i3);
    }

    private void doTranslationAndScaleSpringAnimaion(final Animator.AnimatorListener animatorListener) {
        initTranslationAndScaleSpringAnimation();
        if (hasAnimationFlag(1)) {
            this.mSpringForceTranslationAndScale.g(getTranslationResponse());
        } else if (hasAnimationFlag(4)) {
            if (this.mIsEntering) {
                this.mSpringForceTranslationAndScale.g(0.25f);
            } else {
                this.mSpringForceTranslationAndScale.g(0.25f);
            }
        }
        this.mTranslationAndScaleSpringAnimation.i(this.mTranslationAndScaleEndListener);
        b.q qVar = new b.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.12
            @Override // Z.b.q
            public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
                if (z3) {
                    animatorListener.onAnimationCancel(null);
                } else {
                    animatorListener.onAnimationEnd(null);
                }
                COUIBottomSheetDialog.this.mTranslationAndScaleSpringAnimation.i(COUIBottomSheetDialog.this.mTranslationAndScaleEndListener);
                COUIBottomSheetDialog.this.mTranslationAndScaleSpringAnimation.l(COUIBottomSheetDialog.this.mTranslationAndScaleUpdateListener);
                if (COUIBottomSheetDialog.this.mAlphaSpringAnimation == null || !COUIBottomSheetDialog.this.mAlphaSpringAnimation.h()) {
                    return;
                }
                COUIBottomSheetDialog.this.mAlphaSpringAnimation.w();
            }
        };
        this.mTranslationAndScaleEndListener = qVar;
        this.mTranslationAndScaleSpringAnimation.a(qVar);
        animatorListener.onAnimationStart(null);
        this.mTranslationAndScaleSpringAnimation.l(this.mTranslationAndScaleUpdateListener);
        this.mTranslationAndScaleUpdateListener = new b.r() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.13
            @Override // Z.b.r
            public void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                float f5 = COUIBottomSheetDialog.this.mEndValueOfTranslateAnimation != COUIBottomSheetDialog.this.mStartValueOfTranslateAnimation ? (f3 - COUIBottomSheetDialog.this.mStartValueOfTranslateAnimation) / (COUIBottomSheetDialog.this.mEndValueOfTranslateAnimation - COUIBottomSheetDialog.this.mStartValueOfTranslateAnimation) : 0.0f;
                if (COUIBottomSheetDialog.this.hasAnimationFlag(1)) {
                    COUIBottomSheetDialog.this.translateUpdate(f3);
                }
                if (!COUIBottomSheetDialog.this.hasAnimationFlag(4) || COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout == null) {
                    return;
                }
                float f6 = COUIBottomSheetDialog.this.mIsEntering ? (f5 * COUIBottomSheetDialog.DIALOG_SHOW_SCALE_DELTA) + 0.8f : ((1.0f - f5) * COUIBottomSheetDialog.DIALOG_SHOW_SCALE_DELTA) + 0.8f;
                COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setScaleX(f6);
                COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setScaleY(f6);
            }
        };
        if (!this.mSupportExitBlockingAnimation) {
            if (this.mIsEntering) {
                this.mTranslationAndScaleSpringAnimation.m(1.0f);
            } else {
                this.mTranslationAndScaleSpringAnimation.m(DEFAULT_MINIMUM_VISIBLE_CHANGE_DISMISS);
            }
        }
        this.mTranslationAndScaleSpringAnimation.b(this.mTranslationAndScaleUpdateListener);
        setFrameRate(this.mTranslationAndScaleSpringAnimation);
        this.mTranslationAndScaleSpringAnimation.o(this.mStartValueOfTranslateAnimation);
        this.mTranslationAndScaleSpringAnimation.u(this.mIsEntering ? this.mEndValueOfTranslateAnimation : this.mEndValueOfTranslateAnimation + 1.0f);
    }

    private void enforceChangeScreenWidth() {
        if (this.mPreferWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            this.mOriginWidth = configuration.screenWidthDp;
            configuration.screenWidthDp = this.mPreferWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : OriginWidth=" + this.mOriginWidth + " ,PreferWidth:" + this.mPreferWidth);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.setPreferWidth(this.mPreferWidth);
            }
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    private void ensureDraggableContentLayout() {
        if (this.mDraggableConstraintLayout == null) {
            createPanelConstraintLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getContentViewHeightWithMargins() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            return cOUIPanelPercentFrameLayout.getMeasuredHeight() + COUIViewMarginUtil.getMargin(this.mDesignBottomSheetFrameLayout, 3);
        }
        return 0;
    }

    private boolean getFocusChange() {
        Boolean bool = this.mFocusChange;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    private Rect getLocationRectInScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getMeasuredWidth() + i3, iArr[1] + view.getMeasuredHeight());
    }

    private int getNavColor() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout;
        int i3 = this.mNavColor;
        return i3 != Integer.MAX_VALUE ? i3 : (this.mIsHandlePanel || ((cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout) != null && cOUIPanelPercentFrameLayout.getRatio() == 1.0f)) ? this.mPanelBackgroundTintColor : this.mColorMask;
    }

    private Drawable getNavigationDrawable(int i3) {
        if (this.mGradientDrawable == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            this.mGradientDrawable = gradientDrawable;
            gradientDrawable.setShape(0);
            this.mGradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        }
        this.mGradientDrawable.setColors(new int[]{i3, i3, getSpecifiedTransparencyColor(i3, FIRST_TIER_ALPHA), getSpecifiedTransparencyColor(i3, 0.5f), getSpecifiedTransparencyColor(i3, 0.25f), 0});
        return this.mGradientDrawable;
    }

    private COUIPanelPullUpListener getPanelPullUpListener() {
        return new COUIPanelPullUpListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.27
            private int mLastPosition = -1;

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onCancel() {
                COUIBottomSheetDialog.this.setPulledUpViewPaddingBottom(0);
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public int onDragging(int i3, int i4) {
                if (COUIBottomSheetDialog.this.mPanelSpringBackAnim != null && COUIBottomSheetDialog.this.mPanelSpringBackAnim.f() != 0.0d) {
                    COUIBottomSheetDialog.this.mPanelSpringBackAnim.j();
                    return COUIBottomSheetDialog.this.mParentViewPaddingBottom;
                }
                int b3 = AbstractC0626a.b((int) ((COUIBottomSheetDialog.this.mPulledUpView.getPaddingBottom() - COUIBottomSheetDialog.this.mPanelPaddingBottom) - (i3 * 0.19999999f)), 0, Math.min(COUIBottomSheetDialog.this.mPullUpMaxOffset, COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getTop()));
                if (COUIBottomSheetDialog.this.mParentViewPaddingBottom != b3) {
                    COUIBottomSheetDialog.this.mParentViewPaddingBottom = b3;
                    COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog.setPulledUpViewPaddingBottom(cOUIBottomSheetDialog.mParentViewPaddingBottom);
                }
                return COUIBottomSheetDialog.this.mParentViewPaddingBottom;
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onDraggingPanel() {
                boolean unused = COUIBottomSheetDialog.this.mIsInTinyScreen;
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onOffsetChanged(float f3) {
                if (this.mLastPosition == -1) {
                    this.mLastPosition = COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getHeight();
                }
                if (COUIBottomSheetDialog.this.mDialogOffsetListener != null) {
                    COUIBottomSheetDialog.this.mDialogOffsetListener.onDialogOffsetChanged(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getTop());
                }
                if (COUIBottomSheetDialog.this.mIsNeedOutsideViewAnim && !COUIBottomSheetDialog.this.mIsExecutingDismissAnim) {
                    float max = Math.max(0.0f, COUIBottomSheetDialog.this.getOutsideViewAlpha(f3));
                    COUIBottomSheetDialog.this.mOutsideView.setAlpha(max);
                    COUIBottomSheetDialog.this.mCurrentOutsideAlpha = max;
                    if (!COUIPanelMultiWindowUtils.isSmallScreen(COUIBottomSheetDialog.this.getContext(), null) && COUINavigationBarUtil.isNavigationBarShow(COUIBottomSheetDialog.this.getContext()) && ((!COUIBottomSheetDialog.this.mIsHandlePanel || COUIBottomSheetDialog.this.shouldHandlePanelUpdateNavBarColor()) && COUIBottomSheetDialog.this.getWindow() != null && ((int) (COUIBottomSheetDialog.this.mOutsideViewBackgroundAlpha * f3)) != 0 && !COUINavigationBarUtil.isGestureNavigation(COUIBottomSheetDialog.this.getContext()))) {
                        COUIBottomSheetDialog.this.setNavigationBarColorAlpha(max);
                    }
                }
                if (COUIBottomSheetDialog.this.mPanelBarView == null || f3 == 1.0f || !COUIBottomSheetDialog.this.mIsInTinyScreen) {
                    return;
                }
                COUIBottomSheetDialog.this.mPanelBarView.setPanelOffset(this.mLastPosition - ((int) (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getHeight() * f3)));
                this.mLastPosition = (int) (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getHeight() * f3);
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onReleased(int i3) {
                COUIBottomSheetDialog.this.setCanPullUp(false);
                int top = COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getTop() - (i3 - COUIBottomSheetDialog.this.mParentViewPaddingBottom);
                COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                cOUIBottomSheetDialog.doSpringBackReboundAnim(cOUIBottomSheetDialog.mParentViewPaddingBottom - top);
            }

            @Override // com.coui.appcompat.panel.COUIPanelPullUpListener
            public void onReleasedDrag() {
                boolean unused = COUIBottomSheetDialog.this.mIsInTinyScreen;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator.AnimatorListener getPanelShowAnimListener() {
        return new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.26
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIBottomSheetDialog.this.animationEnd();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIBottomSheetDialog.this.animationStart();
            }
        };
    }

    private float getRevertAnimationFinalPositionToHide() {
        return this.mIsAnimationInFirst ? this.mStartValueOfTranslateAnimation : this.mEndValueOfTranslateAnimation;
    }

    private float getRevertAnimationFinalPositionToShow() {
        return this.mIsAnimationInFirst ? this.mEndValueOfTranslateAnimation : this.mStartValueOfTranslateAnimation;
    }

    private int getSpecifiedTransparencyColor(int i3, float f3) {
        return Color.argb((int) ((Color.alpha(i3) / MAX_ALPHA) * f3 * MAX_ALPHA), Color.red(i3), Color.green(i3), Color.blue(i3));
    }

    private int getTranslationDistance() {
        int height = this.mDesignBottomSheetFrameLayout.getHeight() - this.mPanelPaddingBottom;
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        boolean z3 = inputMethodManager != null && inputMethodManager.isAcceptingText();
        if (!this.mIsEntering && isInMultiWindowMode() && z3) {
            this.mDesignBottomSheetFrameLayout.getGlobalVisibleRect(this.mTemtRect);
            height = Math.max(height, j.j(getContext()) - this.mTemtRect.top);
        }
        COUIBottomSheetBehavior cOUIBottomSheetBehavior = (COUIBottomSheetBehavior) getBehavior();
        return cOUIBottomSheetBehavior.getState() == 3 ? height : cOUIBottomSheetBehavior.getState() == 6 ? this.mCoordinatorLayout.getMeasuredHeight() - cOUIBottomSheetBehavior.halfExpandedOffset : cOUIBottomSheetBehavior.getState() == 4 ? this.mPeekHeight : height;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float getTranslationResponse() {
        /*
            r5 = this;
            boolean r0 = r5.mIsEntering
            if (r0 == 0) goto La
            r0 = 1048576000(0x3e800000, float:0.25)
            r1 = 1055286886(0x3ee66666, float:0.45)
            goto L10
        La:
            r0 = 1043878380(0x3e3851ec, float:0.18)
            r1 = 1052602532(0x3ebd70a4, float:0.37)
        L10:
            com.coui.appcompat.panel.COUIPanelPercentFrameLayout r2 = r5.mDesignBottomSheetFrameLayout
            int r2 = r2.getHeight()
            int r3 = r5.mPanelPaddingBottom
            int r2 = r2 - r3
            float r2 = (float) r2
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r5.getBehavior()
            int r3 = r3.getState()
            r4 = 4
            if (r3 != r4) goto L29
            int r2 = r5.mPeekHeight
        L27:
            float r2 = (float) r2
            goto L61
        L29:
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r5.getBehavior()
            int r3 = r3.getState()
            r4 = 6
            if (r3 != r4) goto L45
            android.view.View r2 = r5.mCoordinatorLayout
            int r2 = r2.getHeight()
            float r2 = (float) r2
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r5.getBehavior()
            float r3 = r3.getHalfExpandedRatio()
            float r2 = r2 * r3
            goto L61
        L45:
            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = r5.getBehavior()
            int r3 = r3.getState()
            r4 = 3
            if (r3 != r4) goto L51
            goto L61
        L51:
            android.content.Context r2 = r5.getContext()
            int r2 = y0.j.j(r2)
            com.coui.appcompat.panel.COUIPanelPercentFrameLayout r3 = r5.mDesignBottomSheetFrameLayout
            int r3 = r3.getTop()
            int r2 = r2 - r3
            goto L27
        L61:
            android.view.View r3 = r5.mCoordinatorLayout
            int r3 = r3.getHeight()
            int r4 = r5.mPeekHeight
            int r3 = r3 - r4
            float r3 = (float) r3
            r4 = 0
            float r3 = java.lang.Math.max(r3, r4)
            int r5 = r5.mPeekHeight
            float r5 = (float) r5
            float r2 = r2 - r5
            float r5 = java.lang.Math.max(r2, r4)
            int r2 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r2 == 0) goto L7e
            float r5 = r5 / r3
            goto L80
        L7e:
            r5 = 1065353216(0x3f800000, float:1.0)
        L80:
            float r5 = java.lang.Math.max(r4, r5)
            float r1 = r1 - r0
            float r1 = r1 * r5
            float r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.panel.COUIBottomSheetDialog.getTranslationResponse():float");
    }

    private Drawable getTypedArrayDrawable(TypedArray typedArray, int i3, int i4) {
        Drawable drawable = typedArray != null ? typedArray.getDrawable(i3) : null;
        return drawable == null ? getContext().getResources().getDrawable(i4, getContext().getTheme()) : drawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleBehaviorStateChange(View view, int i3) {
        if (i3 == 3 || i3 == 6 || i3 == 4) {
            this.mLastStaticState = i3;
        }
        if (i3 == 2) {
            if (needHideKeyboardWhenSettling()) {
                hideKeyboard();
            }
        } else if (i3 == 3) {
            this.mAdjustResizeEnable = true;
            this.mWindowInsetsAnimEnable = false;
        } else if (i3 == 5 && !this.mIsRevertAnimationFromSettlingAnimation) {
            dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasAnimationFlag(int i3) {
        return (this.mAnimationFlag & i3) > 0;
    }

    private boolean hasEditText(ViewGroup viewGroup) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof EditText) || (childAt instanceof COUIInputView)) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasEditText((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean haveEnoughSpace() {
        View view;
        if (this.mDesignBottomSheetFrameLayout == null || (view = this.mAnchorView) == null) {
            return false;
        }
        Rect locationRectInScreen = getLocationRectInScreen(view);
        int measuredWidth = this.mDesignBottomSheetFrameLayout.getMeasuredWidth();
        int measuredHeight = this.mDesignBottomSheetFrameLayout.getMeasuredHeight();
        Rect locationRectInScreen2 = getLocationRectInScreen(((ViewGroup) this.mAnchorView.getRootView()).getChildAt(0));
        int navigationBarHeight = COUINavigationBarUtil.getNavigationBarHeight(getContext());
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(P1.b.f1762K);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(P1.b.f1764M);
        if ((locationRectInScreen.left - measuredWidth) - dimensionPixelOffset2 <= locationRectInScreen2.left && locationRectInScreen.right + measuredWidth + dimensionPixelOffset2 >= locationRectInScreen2.right && ((locationRectInScreen.top - measuredHeight) - this.mCoordinatorLayoutMinInsetsTop) - dimensionPixelOffset <= locationRectInScreen2.top && locationRectInScreen.bottom + measuredHeight + navigationBarHeight + dimensionPixelOffset >= locationRectInScreen2.bottom) {
            Log.d(TAG, "anchor view have no enoughSpace anchorContentViewLocationRect: " + locationRectInScreen2);
            this.mDesignBottomSheetFrameLayout.setHasAnchor(false);
            this.mDesignBottomSheetFrameLayout.setElevation(0.0f);
            this.mOutsideView.setAlpha(1.0f);
            return false;
        }
        Log.d(TAG, "anchor view haveEnoughSpace");
        this.mDesignBottomSheetFrameLayout.setHasAnchor(true);
        this.mDesignBottomSheetFrameLayout.setTop(0);
        this.mDesignBottomSheetFrameLayout.setBottom(measuredHeight);
        y0.i.d(this.mDesignBottomSheetFrameLayout, 3, getContext().getResources().getDimensionPixelOffset(U1.d.f2376d), androidx.core.content.a.c(getContext(), U1.c.f2368b));
        this.mOutsideView.setAlpha(0.0f);
        setCanPullUp(false);
        getBehavior().setDraggable(false);
        return true;
    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        if (getWindow() != null) {
            this.mAdjustResizeEnable = false;
        }
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            this.mInputMethodManager.hideSoftInputFromWindow(cOUIPanelPercentFrameLayout.getWindowToken(), 0);
        }
    }

    private void initBehavior() {
        int i3;
        boolean z3;
        if (!(getBehavior() instanceof COUIBottomSheetBehavior)) {
            throw new IllegalArgumentException("Must use COUIBottomSheetBehavior, check value of bottom_sheet_behavior in strings.xml");
        }
        COUIBottomSheetBehavior cOUIBottomSheetBehavior = (COUIBottomSheetBehavior) getBehavior();
        cOUIBottomSheetBehavior.applyPhysics(this.mPhysicsFrequency, this.mPhysicsDampingRatio);
        cOUIBottomSheetBehavior.setGlobalDrag(this.mGlobalDrag);
        cOUIBottomSheetBehavior.setIsInTinyScreen(this.mIsInTinyScreen);
        cOUIBottomSheetBehavior.setPanelPeekHeight(this.mPeekHeight);
        cOUIBottomSheetBehavior.setPanelSkipCollapsed(this.mSkipCollapsed);
        cOUIBottomSheetBehavior.setIsHandlePanel(this.mIsHandlePanel);
        cOUIBottomSheetBehavior.setLayoutAtMaxHeight(this.mIsShowInMaxHeight);
        cOUIBottomSheetBehavior.setPanelPaddingBottom(this.mPanelPaddingBottom);
        if (this.mIsHandlePanel) {
            if (COUIPanelMultiWindowUtils.isNormalLandScreen(getContext(), this.mConfiguration)) {
                i3 = 4;
                z3 = true;
            } else {
                i3 = 6;
                z3 = false;
            }
            cOUIBottomSheetBehavior.setFitToContents(z3);
            cOUIBottomSheetBehavior.setGestureInsetBottomIgnored(true);
            setIsNeedOutsideViewAnim(false);
        } else {
            i3 = 3;
        }
        int i4 = this.mFirstShowCollapsed ? 4 : i3;
        cOUIBottomSheetBehavior.setPanelState(i4);
        this.mLastStaticState = i4;
        cOUIBottomSheetBehavior.addBottomSheetCallback(new COUIBottomSheetBehavior.COUIBottomSheetCallback() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.3
            @Override // com.coui.appcompat.panel.COUIBottomSheetBehavior.COUIBottomSheetCallback
            public void onSlide(View view, float f3) {
            }

            @Override // com.coui.appcompat.panel.COUIBottomSheetBehavior.COUIBottomSheetCallback
            public void onStateChanged(View view, int i5) {
                if (COUIBottomSheetDialog.DEBUG) {
                    Log.d(COUIBottomSheetDialog.TAG, "onStateChanged: newState=" + i5);
                }
                COUIBottomSheetDialog.this.handleBehaviorStateChange(view, i5);
            }
        });
        if (DEBUG) {
            Log.d(TAG, "initBehavior: peekHeight=" + this.mPeekHeight + " mSkipCollapsed=" + this.mSkipCollapsed + " mIsHandlePanel=" + this.mIsHandlePanel + " mFirstShowCollapsed=" + this.mFirstShowCollapsed + " state=" + i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCoordinateInsets(WindowInsets windowInsets) {
        View view = this.mCoordinatorLayout;
        if (view == null || windowInsets == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        boolean z3 = getContext().getResources().getConfiguration().smallestScreenWidthDp < 600;
        this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(U1.d.f2379g);
        if (z3 && windowInsets.getSystemWindowInsetTop() > 0) {
            this.mCoordinatorLayoutMinInsetsTop = windowInsets.getSystemWindowInsetTop();
        }
        if (this.mIsInTinyScreen) {
            if (this.mIsFullScreenInTinyScreen) {
                this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(U1.d.f2398z);
            } else {
                this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(U1.d.f2370B);
            }
        }
        int i3 = layoutParams.topMargin;
        int i4 = this.mCoordinatorLayoutMinInsetsTop;
        if (i3 != i4) {
            layoutParams.topMargin = i4;
            this.mCoordinatorLayout.setLayoutParams(layoutParams);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            Configuration configuration = this.mConfiguration;
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            cOUIPanelContentLayout.setNavigationMargin(configuration, windowInsets, cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getRatio() == 1.0f, this.mCouiPanelEdgeToEdgeEnable);
        }
    }

    private void initDraggableConstraintLayoutSize() {
        setPanelWidth();
        setPanelHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMaxHeight(WindowInsets windowInsets) {
        boolean z3 = this.mPanelHeight >= COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), null, windowInsets, this.mIsHandlePanel, this.mCouiPanelEdgeToEdgeEnable);
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            cOUIPanelPercentFrameLayout.getLayoutParams().height = (this.mIsShowInMaxHeight || z3) ? -1 : -2;
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            if (this.mIsShowInMaxHeight || z3) {
                cOUIPanelContentLayout.getLayoutParams().height = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initOrRefreshNavigationView() {
        if (unNeedNavigationCustomView()) {
            if (this.mNavigationCustomView == null || !(this.mContainerFrameLayout.getParent() instanceof FrameLayout)) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) this.mContainerFrameLayout.getParent();
            if (frameLayout.indexOfChild(this.mNavigationCustomView) != -1) {
                frameLayout.removeView(this.mNavigationCustomView);
            }
            this.mNavigationCustomView = null;
            return;
        }
        if (this.mNavigationCustomView == null) {
            this.mNavigationCustomView = new View(getContext());
        }
        setNavigationBarColor(getNavColor());
        if (!(this.mContainerFrameLayout.getParent() instanceof FrameLayout)) {
            setNavigationCustomViewHeight(this.mApplyWindowInsets);
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) this.mContainerFrameLayout.getParent();
        if (frameLayout2.indexOfChild(this.mNavigationCustomView) == -1) {
            frameLayout2.addView(this.mNavigationCustomView, new FrameLayout.LayoutParams(-1, this.mApplyWindowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom, 80));
        }
    }

    private void initPeekHeight() {
        if (this.mIsGestureNavigation) {
            this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(U1.d.f2388p);
        } else if (this.mCouiPanelEdgeToEdgeEnable) {
            this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(U1.d.f2389q);
        } else {
            this.mPeekHeight = getContext().getResources().getDimensionPixelOffset(U1.d.f2387o);
        }
    }

    private void initPhysics() {
        if (this.mAppearStiffness == PHYSICS_UNSET) {
            this.mAppearStiffness = DEFAULT_SPRING_STIFFNESS;
        }
        if (this.mAppearDampingRatio == PHYSICS_UNSET) {
            this.mAppearDampingRatio = DEFAULT_SPRING_DAMPING_RATIO;
        }
        this.mAppearSpringForce = new f(0.0f).f(this.mAppearStiffness).d(this.mAppearDampingRatio);
        B.e t3 = new B.e(new B.d()).t(this.mAppearSpringForce);
        this.mAppearSpringAnim = t3;
        t3.b(this);
        this.mAppearSpringAnim.a(this);
    }

    private void initThemeResources(int i3) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, U1.i.f2431a, U1.a.f2363a, i3);
        this.mPanelDragViewDrawable = getTypedArrayDrawable(obtainStyledAttributes, U1.i.f2440j, U1.e.f2401c);
        int color = obtainStyledAttributes.getColor(U1.i.f2441k, AbstractC0335a.a(getContext(), M1.c.f1361f));
        this.mPanelDragViewDrawableTintColor = color;
        this.mPanelDragViewDrawable.setTint(color);
        this.mPanelBackground = getTypedArrayDrawable(obtainStyledAttributes, U1.i.f2438h, U1.e.f2399a);
        this.mPanelBackgroundTintColor = obtainStyledAttributes.getColor(U1.i.f2439i, AbstractC0335a.a(getContext(), M1.c.f1379x));
        this.mHandleViewHasPressAnim = obtainStyledAttributes.getBoolean(U1.i.f2432b, true);
        this.mIsShowInMaxHeight = obtainStyledAttributes.getBoolean(U1.i.f2437g, true);
        this.mIsHandlePanel = obtainStyledAttributes.getBoolean(U1.i.f2433c, false);
        this.mDefaultPaddingBottom = obtainStyledAttributes.getDimensionPixelSize(U1.i.f2435e, getContext().getResources().getDimensionPixelSize(U1.d.f2371C));
        this.mCouiPanelEdgeToEdgeEnable = obtainStyledAttributes.getBoolean(U1.i.f2434d, false);
        this.mSupportExitBlockingAnimation = obtainStyledAttributes.getBoolean(U1.i.f2436f, false);
        getAdjustResizeHelper().setCouiPanelEdgeToEdgeEnable(this.mCouiPanelEdgeToEdgeEnable);
        if (this.mIsHandlePanel && this.mSkipCollapsed) {
            this.mSkipCollapsed = false;
        }
        obtainStyledAttributes.recycle();
        Drawable drawable = this.mPanelBackground;
        if (drawable != null) {
            drawable.setTint(this.mPanelBackgroundTintColor);
        }
    }

    private void initTranslationAndScaleSpringAnimation() {
        if (this.mTranslationAndScaleSpringAnimation == null) {
            this.mTranslationAndScaleSpringAnimation = new Z.c(new B.d());
            Z.d dVar = new Z.d();
            this.mSpringForceTranslationAndScale = dVar;
            dVar.d(0.0f);
            this.mTranslationAndScaleSpringAnimation.B(this.mSpringForceTranslationAndScale);
        }
    }

    private void initValueResources() {
        this.mPullUpMaxOffset = (int) getContext().getResources().getDimension(U1.d.f2372D);
        this.mCoordinatorLayoutMinInsetsTop = (int) getContext().getResources().getDimension(U1.d.f2397y);
        this.mCoordinatorLayoutPaddingExtra = getContext().getResources().getDimensionPixelOffset(U1.d.f2369A);
        refreshColorMask();
        this.mIsGestureNavigation = COUINavigationBarUtil.isGestureNavigation(getContext());
        initPeekHeight();
    }

    private void initView() {
        IgnoreWindowInsetsFrameLayout ignoreWindowInsetsFrameLayout = (IgnoreWindowInsetsFrameLayout) findViewById(U1.f.f2405c);
        this.mContainerFrameLayout = ignoreWindowInsetsFrameLayout;
        if (ignoreWindowInsetsFrameLayout != null) {
            ignoreWindowInsetsFrameLayout.setCouiPanelEdgeToEdgeEnable(this.mCouiPanelEdgeToEdgeEnable);
        }
        this.mOutsideView = findViewById(U1.f.f2416n);
        operateBlockingAnimation();
        this.mCoordinatorLayout = findViewById(U1.f.f2406d);
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = (COUIPanelPercentFrameLayout) findViewById(h.f1483b);
        this.mDesignBottomSheetFrameLayout = cOUIPanelPercentFrameLayout;
        cOUIPanelPercentFrameLayout.setIsHandlePanel(this.mIsHandlePanel);
        this.mPanelBarView = (COUIPanelBarView) findViewById(U1.f.f2415m);
        this.mDesignBottomSheetFrameLayout.getLayoutParams().height = this.mIsShowInMaxHeight ? -1 : -2;
        if (isFollowHand()) {
            this.mDesignBottomSheetFrameLayout.post(new Runnable() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.4
                @Override // java.lang.Runnable
                public void run() {
                    if (COUIBottomSheetDialog.this.haveEnoughSpace()) {
                        y0.i.d(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, 3, COUIBottomSheetDialog.this.getContext().getResources().getDimensionPixelOffset(U1.d.f2376d), androidx.core.content.a.c(COUIBottomSheetDialog.this.getContext(), U1.c.f2368b));
                        COUIBottomSheetDialog.this.setCanPullUp(false);
                        COUIBottomSheetDialog.this.getBehavior().setDraggable(false);
                    }
                }
            });
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setLayoutAtMaxHeight(this.mIsShowInMaxHeight);
        }
        this.mPulledUpView = this.mDesignBottomSheetFrameLayout;
        checkInitState();
        this.mOutsideView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (COUIBottomSheetDialog.this.mCancelable && COUIBottomSheetDialog.this.isShowing() && COUIBottomSheetDialog.this.mCanceledOnTouchOutside) {
                    COUIBottomSheetDialog.this.cancel();
                }
            }
        });
        this.mDesignBottomSheetFrameLayout.setBackground(this.mPanelBackground);
        updatePaddingBottom();
    }

    private void initWindow() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setLayout(-1, -1);
            window.setGravity(80);
        }
    }

    private void initWindowInsetsListener() {
        if (this.mShouldRegisterWindowInsetsListener && getWindow() != null && this.mWindowInsetsListener == null) {
            View decorView = getWindow().getDecorView();
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = new View.OnApplyWindowInsetsListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.8
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    if (view == null || view.getLayoutParams() == null) {
                        return windowInsets;
                    }
                    if (windowInsets.equals(COUIBottomSheetDialog.this.mApplyWindowInsets)) {
                        AbstractC0371a.a(COUIBottomSheetDialog.TAG, "Window inset is not change, return!");
                        return windowInsets;
                    }
                    COUIBottomSheetDialog.this.initCoordinateInsets(windowInsets);
                    COUIBottomSheetDialog.this.initMaxHeight(windowInsets);
                    if (COUIBottomSheetDialog.this.mInputMethodManager == null) {
                        COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                        cOUIBottomSheetDialog.mInputMethodManager = (InputMethodManager) cOUIBottomSheetDialog.getContext().getSystemService("input_method");
                    }
                    COUIBottomSheetDialog cOUIBottomSheetDialog2 = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog2.adjustResize(windowInsets, cOUIBottomSheetDialog2.mAdjustResizeEnable);
                    COUIBottomSheetDialog.this.largeScreenLimitMaxSize();
                    COUIBottomSheetDialog.this.mApplyWindowInsets = windowInsets;
                    view.onApplyWindowInsets(COUIBottomSheetDialog.this.mApplyWindowInsets);
                    COUIBottomSheetDialog.this.initOrRefreshNavigationView();
                    if (!COUIBottomSheetDialog.this.mIsExecutingDismissAnim) {
                        COUIBottomSheetDialog cOUIBottomSheetDialog3 = COUIBottomSheetDialog.this;
                        cOUIBottomSheetDialog3.updatePanelMarginBottom(cOUIBottomSheetDialog3.mConfiguration, COUIBottomSheetDialog.this.mApplyWindowInsets);
                    }
                    return COUIBottomSheetDialog.this.mApplyWindowInsets;
                }
            };
            this.mWindowInsetsListener = onApplyWindowInsetsListener;
            decorView.setOnApplyWindowInsetsListener(onApplyWindowInsetsListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFadeInCenter() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        return cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getRatio() == 2.0f && (getBehavior() == null || !(getBehavior() == null || getBehavior().getState() == 4));
    }

    private boolean isFadeInCenterAllState() {
        return this.mDesignBottomSheetFrameLayout.getRatio() == 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFollowHand() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout;
        return this.mAnchorView != null && (cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout) != null && cOUIPanelPercentFrameLayout.getRatio() == 2.0f && this.mAnchorView.isAttachedToWindow();
    }

    private boolean isInMultiWindowMode() {
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        return (weakReference == null || weakReference.get() == null || !COUIPanelMultiWindowUtils.isInMultiWindowMode(this.mActivityWeakReference.get())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrameRate$0(AnimationVelocityCalculator animationVelocityCalculator, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        float calculator = animationVelocityCalculator.calculator(this.mDesignBottomSheetFrameLayout.getHeight(), valueAnimator);
        AbstractC0371a.a(TAG, "DynamicFrameRateManager.getSuggestFrameRate: v " + calculator + " frame " + DynamicFrameRateManager.getSuggestFrameRate(calculator, 2));
        DynamicFrameRateManager.setFrameRate(this.mDesignBottomSheetFrameLayout, ANIMATION_TYPE_ID, (int) calculator, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setFrameRate$1(Z.b bVar, float f3, float f4) {
        AbstractC0371a.a(TAG, "COUISpringAnimation DynamicFrameRateManager.getSuggestFrameRate: v " + Math.abs(f4) + " frame " + DynamicFrameRateManager.getSuggestFrameRate(f4, 2));
        DynamicFrameRateManager.setFrameRate(this.mDesignBottomSheetFrameLayout, ANIMATION_TYPE_ID, Math.abs((int) f4), (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void largeScreenLimitMaxSize() {
        if (this.mDesignBottomSheetFrameLayout == null) {
            return;
        }
        int i3 = getContext().getResources().getConfiguration().screenWidthDp;
        int i4 = getContext().getResources().getConfiguration().screenHeightDp;
        if (!this.isLargeScreenLimitMaxSize || !COUIResponsiveUtils.isLargePadWindow(getContext(), i3, i4) || COUIPanelMultiWindowUtils.isInMultiWindowMode(COUIPanelMultiWindowUtils.contextToActivity(getContext()))) {
            this.mDesignBottomSheetFrameLayout.restoreDefaultMaxSize();
            this.mDesignBottomSheetFrameLayout.setMaxHeight(getContext().getResources().getDimensionPixelOffset(U1.d.f2395w));
            return;
        }
        int min = Math.min(j.k(getContext()), j.n(getContext()));
        int max = Math.max(j.k(getContext()), j.n(getContext()));
        this.mDesignBottomSheetFrameLayout.setMaxSize((int) COUIResponsiveUtils.calculateWidth(max, min, this.mDesignBottomSheetFrameLayout.getGridNumber(), this.mDesignBottomSheetFrameLayout.getPaddingType(), this.mDesignBottomSheetFrameLayout.getPaddingSize(), getContext()), min - (this.mCoordinatorLayoutMinInsetsTop * 2));
    }

    private boolean needHideKeyboardWhenSettling() {
        return ((COUIBottomSheetBehavior) getBehavior()).isCanHideKeyboard();
    }

    private int normalizePoints(int i3, int i4) {
        return Math.max(0, Math.min(i3, i4));
    }

    private void offsetViewTo() {
        int[] calculateFinalLocationOnScreen = calculateFinalLocationOnScreen(this.mAnchorView);
        this.mDesignBottomSheetFrameLayout.setX(calculateFinalLocationOnScreen[0]);
        this.mDesignBottomSheetFrameLayout.setY(calculateFinalLocationOnScreen[1]);
        this.mCurrentParentViewTranslationY = this.mDesignBottomSheetFrameLayout.getY();
    }

    private void operateBlockingAnimation() {
        View view = this.mOutsideView;
        if (view == null) {
            return;
        }
        if (!this.mSupportExitBlockingAnimation) {
            view.removeOnAttachStateChangeListener(this.mOnAttatchStateChangeListener);
            return;
        }
        if (this.mOSDKComputeListener == null) {
            this.mOSDKComputeListener = new ViewTreeObserver.OnComputeInternalInsetsListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.6
                public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
                    internalInsetsInfo.setTouchableInsets(ViewTreeObserver.InternalInsetsInfo.TOUCHABLE_INSETS_REGION);
                    if (!COUIBottomSheetDialog.this.mIsExecutingDismissAnim) {
                        internalInsetsInfo.getTouchableRegion().set(0, 0, COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getRootView().getWidth(), COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getRootView().getHeight());
                    } else {
                        COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getGlobalVisibleRect(COUIBottomSheetDialog.this.mTemtRect);
                        internalInsetsInfo.getTouchableRegion().set(COUIBottomSheetDialog.this.mTemtRect);
                    }
                }
            };
        }
        if (this.mOnAttatchStateChangeListener == null) {
            this.mOnAttatchStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.7
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    COUIBottomSheetDialog.this.addOSDKViewTreeObserver();
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    COUIBottomSheetDialog.this.removeOSDKViewTreeObserver();
                }
            };
        }
        this.mOutsideView.addOnAttachStateChangeListener(this.mOnAttatchStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void outsideAlphaChange(float f3, boolean z3) {
        View view;
        View findFocus;
        InputMethodManager inputMethodManager;
        float f4 = this.mCurrentOutSideAlphaStateHidden;
        if (f4 <= 0.0f) {
            f4 = 1.0f;
        }
        float f5 = this.mCurrentOutSideAlphaStateShow;
        if (f5 <= 0.0f) {
            f5 = 0.0f;
        }
        float outsideViewAlpha = getOutsideViewAlpha(f3);
        this.mCurrentOutsideAlpha = outsideViewAlpha;
        float max = z3 ? f5 + (outsideViewAlpha * (1.0f - f5)) : Math.max(0.0f, 1.0f - outsideViewAlpha) * f4;
        View view2 = this.mOutsideView;
        if (view2 != null) {
            view2.setAlpha(max);
        }
        boolean z4 = isFollowHand() || isFadeInCenterAllState() || shouldHandlePanelUpdateNavBarColor();
        if (this.mOutsideView != null && COUIPanelMultiWindowUtils.isVirtualNavigation(getContext()) && z4 && !this.mIsInTinyScreen) {
            setNavigationBarColorAlpha(max);
        } else if (this.mCouiPanelEdgeToEdgeEnable && (view = this.mNavigationCustomView) != null) {
            if (!this.mIsEntering) {
                f3 = Math.max(0.0f, 1.0f - f3);
            }
            view.setAlpha(f3);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout == null || !this.mIsNeedShowKeyboard || (findFocus = cOUIPanelContentLayout.findFocus()) == null || !z3 || (inputMethodManager = this.mInputMethodManager) == null) {
            return;
        }
        inputMethodManager.showSoftInput(findFocus, 0);
    }

    private void refreshColorMask() {
        this.mColorMask = getContext().getResources().getColor(M1.e.f1390f);
        this.mOutsideViewBackgroundAlpha = Color.alpha(r0);
    }

    private void refreshParams() {
        if (COUIPanelMultiWindowUtils.isVirtualNavigation(getContext())) {
            return;
        }
        resetParentViewStyle(getContext().getResources().getConfiguration());
        resetNavigationBarColor();
    }

    private void registerApplicationConfigChangeListener() {
        getContext().registerComponentCallbacks(this.mComponentCallbacks);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerBackCallback(View view) {
        OnBackInvokedDispatcher findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
        if (findOnBackInvokedDispatcher == null) {
            AbstractC0371a.c(TAG, "OnBackInvokedDispatcher is null！");
            return;
        }
        OnBackInvokedCallback onBackInvokedCallback = this.mOnBackInvokedCallback;
        if (onBackInvokedCallback != null) {
            try {
                findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
            } catch (Exception e3) {
                AbstractC0371a.c(TAG, "unregisterOnBackInvokedCallback fail: " + e3.getMessage());
            }
            this.mOnBackInvokedCallback = null;
        }
        OnBackInvokedCallback onBackInvokedCallback2 = new OnBackInvokedCallback() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.30
            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                if (COUIBottomSheetDialog.this.mOnBackInvokedLocalListener != null) {
                    COUIBottomSheetDialog.this.mOnBackInvokedLocalListener.onBackInvokedLocal();
                } else {
                    COUIBottomSheetDialog.this.onBackPressed();
                }
            }
        };
        this.mOnBackInvokedCallback = onBackInvokedCallback2;
        try {
            findOnBackInvokedDispatcher.registerOnBackInvokedCallback(0, onBackInvokedCallback2);
        } catch (Exception e4) {
            AbstractC0371a.c(TAG, "registerOnBackInvokedCallback fail: " + e4.getMessage());
        }
    }

    private void registerBehaviorPullUpListener() {
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            this.mPanelPullUpListener = this.mCanPullUp ? getPanelPullUpListener() : null;
            ((COUIBottomSheetBehavior) getBehavior()).setPullUpListener(this.mPanelPullUpListener);
        }
    }

    private void registerPreDrawListener() {
        View view = this.mOutsideView;
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    private void registerPullUpToDismissPanelListener() {
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) getBehavior()).setPullUpToDismissPanelListener(this.mPullUpToDismissPanelListener);
        }
    }

    private void releaseApplicationConfigChangeListener() {
        if (this.mComponentCallbacks != null) {
            getContext().unregisterComponentCallbacks(this.mComponentCallbacks);
        }
    }

    private void releaseApplyWindowInsetsListener() {
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
            this.mWindowInsetsListener = null;
        }
    }

    private void releaseBehaviorPullUpListener() {
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) getBehavior()).setPullUpListener(null);
            this.mPanelPullUpListener = null;
        }
    }

    private void releasePullUpToDismissPanelListener() {
        if (getBehavior() instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) getBehavior()).setPullUpToDismissPanelListener(null);
        }
    }

    private void releaseResizeHelper() {
        COUIPanelAdjustResizeHelper cOUIPanelAdjustResizeHelper = this.mAdjustResizeHelper;
        if (cOUIPanelAdjustResizeHelper != null) {
            cOUIPanelAdjustResizeHelper.releaseData();
            this.mAdjustResizeHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOSDKViewTreeObserver() {
        com.oplus.wrapper.view.ViewTreeObserver viewTreeObserver = this.mOSDKViewTreeObserver;
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnComputeInternalInsetsListener(this.mOSDKComputeListener);
            this.mOSDKViewTreeObserver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOnPreDrawListener() {
        View view = this.mOutsideView;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
    }

    private void resetAnimationFlag() {
        this.mAnimationFlag = 0;
    }

    private void resetNavigationBarColor() {
        setNavigationBarColor(getNavColor());
    }

    private void resetParentViewStyle(Configuration configuration) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout == null) {
            return;
        }
        COUIViewMarginUtil.setMargin(cOUIPanelPercentFrameLayout, 3, 0);
    }

    private void resetWindowImeAnimFlags() {
        this.mAdjustResizeEnable = true;
        int i3 = 0;
        this.mIsNeedShowKeyboard = false;
        Window window = getWindow();
        getAdjustResizeHelper().setWindowType(window.getAttributes().type);
        int i4 = window.getAttributes().softInputMode & 15;
        if (i4 != 5 || isInMultiWindowMode() || this.mIsInWindowFloatingMode) {
            i3 = i4;
        } else {
            this.mIsNeedShowKeyboard = true;
        }
        window.setSoftInputMode(i3 | 48);
    }

    static int resolveDialogTheme(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(U1.a.f2363a, typedValue, true);
        return typedValue.resourceId;
    }

    private void restoreScreenWidth() {
        if (this.mOriginWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.screenWidthDp = this.mOriginWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "restoreScreenWidth : PreferWidth=" + this.mPreferWidth + " ,OriginWidth=" + this.mOriginWidth);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.delPreferWidth();
            }
        } catch (Exception unused) {
            Log.d(TAG, "restoreScreenWidth : failed to updateConfiguration");
        }
    }

    private boolean reversalAnimation(final Animator.AnimatorListener animatorListener, boolean z3) {
        Z.c cVar;
        Z.c cVar2 = this.mTranslationAndScaleSpringAnimation;
        if (cVar2 == null || !cVar2.h() || (cVar = this.mAlphaSpringAnimation) == null || !cVar.h()) {
            return false;
        }
        if (z3) {
            this.mTranslationAndScaleSpringAnimation.u(getRevertAnimationFinalPositionToShow());
            this.mAlphaSpringAnimation.u(getRevertAnimationFinalPositionToShow());
        } else {
            float revertAnimationFinalPositionToHide = getRevertAnimationFinalPositionToHide();
            if (this.mDesignBottomSheetFrameLayout.getRatio() == 1.0f) {
                revertAnimationFinalPositionToHide = Math.max(getRevertAnimationFinalPositionToHide(), getTranslationDistance());
            }
            this.mTranslationAndScaleSpringAnimation.u(revertAnimationFinalPositionToHide);
            this.mAlphaSpringAnimation.u(revertAnimationFinalPositionToHide);
            OnAnimationListener onAnimationListener = this.mAnimationListener;
            if (onAnimationListener != null) {
                onAnimationListener.onDismissAnimationStart();
            }
        }
        this.mTranslationAndScaleSpringAnimation.i(this.mTranslationAndScaleEndListener);
        b.q qVar = new b.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.31
            @Override // Z.b.q
            public void onAnimationEnd(Z.b bVar, boolean z4, float f3, float f4) {
                if (z4) {
                    animatorListener.onAnimationCancel(null);
                } else {
                    animatorListener.onAnimationEnd(null);
                }
            }
        };
        this.mTranslationAndScaleEndListener = qVar;
        this.mTranslationAndScaleSpringAnimation.a(qVar);
        return true;
    }

    private void saveActivityContextToGetMultiWindowInfo(Context context) {
        Activity c3 = j.c(context);
        if (c3 != null) {
            this.mActivityWeakReference = new WeakReference<>(c3);
        }
    }

    private void setContentViewLocal(View view) {
        if (this.mIsShowInDialogFragment) {
            super.setContentView(view);
        } else {
            ensureDraggableContentLayout();
            this.mDraggableConstraintLayout.removeContentView();
            this.mDraggableConstraintLayout.addContentView(view);
            super.setContentView(this.mDraggableConstraintLayout);
        }
        this.mContentView = view;
    }

    private void setDefaultSpringStartEndValue() {
        this.mStartValueOfTranslateAnimation = 0.0f;
        this.mEndValueOfTranslateAnimation = 100.0f;
    }

    private void setFocusChangeFalseIfHasnotEdittext() {
        if (this.mFocusChange == null && hasEditText((ViewGroup) getWindow().getDecorView().getRootView())) {
            this.mFocusChange = Boolean.TRUE;
        }
    }

    private void setFrameRate(final ValueAnimator valueAnimator) {
        if (!this.mIsVSdk || this.mDesignBottomSheetFrameLayout == null) {
            return;
        }
        int i3 = this.mADFRFeatureType;
        if (i3 == 2) {
            final AnimationVelocityCalculator animationVelocityCalculator = new AnimationVelocityCalculator(valueAnimator);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.panel.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    COUIBottomSheetDialog.this.lambda$setFrameRate$0(animationVelocityCalculator, valueAnimator, valueAnimator2);
                }
            });
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.17
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    AbstractC0371a.a(COUIBottomSheetDialog.TAG, "LEVEL_HIGH_PRECISION onAnimatorEnd: DynamicFrameRateManager.FRAME_RATE_END");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, COUIBottomSheetDialog.ANIMATION_TYPE_ID, -2, (Bundle) null);
                }
            });
        } else if (i3 == 1) {
            valueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.18
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    AbstractC0371a.a(COUIBottomSheetDialog.TAG, "LEVEL_LOW_PRECISION onAnimatorEnd: DynamicFrameRateManager.FRAME_RATE_END");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, COUIBottomSheetDialog.ANIMATION_TYPE_ID, -2, (Bundle) null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    AbstractC0371a.a(COUIBottomSheetDialog.TAG, "LEVEL_LOW_PRECISION onAnimatorStart: DynamicFrameRateManager.LOW_PRECISION_FRAME_RATE");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, COUIBottomSheetDialog.ANIMATION_TYPE_ID, -1, (Bundle) null);
                }
            });
        } else if (i3 == 0) {
            AbstractC0371a.a(TAG, "LEVEL_DEFAULT do nothing");
        }
    }

    private void setNavigation() {
        if (!this.mIsGestureNavigation) {
            getWindow().setDecorFitsSystemWindows(false);
            getWindow().setNavigationBarContrastEnforced(false);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 512);
            getWindow().setNavigationBarContrastEnforced(false);
            setNavigationBarColor(0);
        }
    }

    private void setNavigationBarColor(int i3) {
        if (unNeedNavigationCustomView()) {
            getWindow().setNavigationBarColor(i3);
        } else {
            getWindow().setNavigationBarColor(0);
        }
        setNavigationCustomViewColor(i3);
        AbstractC0371a.a(TAG, "setNavigationBarColor color: " + Integer.toHexString(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNavigationBarColorAlpha(float f3) {
        int i3 = (int) (f3 * this.mOutsideViewBackgroundAlpha);
        if (i3 > 0) {
            setNavigationBarColor(Color.argb(i3, 0, 0, 0));
        } else {
            setNavigationBarColor(0);
            getWindow().setNavigationBarContrastEnforced(false);
        }
    }

    private void setNavigationCustomViewColor(int i3) {
        View view;
        if (unNeedNavigationCustomView() || (view = this.mNavigationCustomView) == null) {
            return;
        }
        if (this.mCouiPanelEdgeToEdgeEnable) {
            view.setBackground(getNavigationDrawable(i3));
        } else {
            view.setBackgroundColor(i3);
        }
    }

    private void setNavigationCustomViewHeight(WindowInsets windowInsets) {
        if (unNeedNavigationCustomView() || windowInsets == null || this.mNavigationCustomView == null) {
            return;
        }
        int i3 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        this.mNavigationCustomView.getLayoutParams().height = Math.max(0, i3);
    }

    private void setPanelHeight() {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelContentLayout.getLayoutParams();
            int i3 = this.mPanelHeight;
            if (i3 != 0) {
                layoutParams.height = i3;
            }
            this.mDraggableConstraintLayout.setLayoutParams(layoutParams);
        }
        WindowInsets windowInsets = this.mApplyWindowInsets;
        if (windowInsets != null) {
            initMaxHeight(windowInsets);
        }
    }

    private void setPanelWidth() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelPercentFrameLayout.getLayoutParams();
            int i3 = this.mPanelWidth;
            if (i3 != 0) {
                layoutParams.width = i3;
            }
            this.mDesignBottomSheetFrameLayout.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPulledUpViewPaddingBottom(int i3) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout;
        if (this.mPulledUpView == null || (cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout) == null) {
            return;
        }
        if (TextUtils.equals(cOUIPanelPercentFrameLayout.getClass().getSimpleName(), this.mPulledUpView.getClass().getSimpleName())) {
            i3 += this.mPanelPaddingBottom;
        }
        View view = this.mPulledUpView;
        view.setPadding(view.getPaddingLeft(), this.mPulledUpView.getPaddingTop(), this.mPulledUpView.getPaddingRight(), i3);
    }

    private void setSpringStartPosition(float f3) {
        this.mAppearSpringAnim.k(f3);
    }

    private void setStatusBarTransparentAndFont(Window window) {
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i3 = systemUiVisibility | 1024;
        window.setStatusBarColor(0);
        window.addFlags(Integer.MIN_VALUE);
        decorView.setSystemUiVisibility(AbstractC0342a.a(getContext()) ? i3 & (-8209) : systemUiVisibility | 1280);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldHandlePanelUpdateNavBarColor() {
        if (this.mIsHandlePanel) {
            return COUIPanelMultiWindowUtils.isNormalLandScreen(getContext(), this.mConfiguration);
        }
        return false;
    }

    private void snapToTop() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            this.mSnapStartBottom = cOUIPanelPercentFrameLayout.getBottom();
        }
        this.mIsAppearSpringAnimStared = true;
        this.mAppearSpringAnim.m();
    }

    private void startListeningForBackCallbacks(View view) {
        if (view.isAttachedToWindow()) {
            registerBackCallback(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.29
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    COUIBottomSheetDialog.this.registerBackCallback(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout != null) {
                        COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                        cOUIBottomSheetDialog.stopListeningForBackCallbacks(cOUIBottomSheetDialog.mDesignBottomSheetFrameLayout);
                    }
                }
            });
        }
    }

    private void startReleaseAnim(Animator.AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mPanelViewTranslationAnimationSet.addListener(animatorListener);
        }
        this.mPanelViewTranslationAnimationSet.start();
    }

    private void startReleaseAnimInTinyScreen(float f3, float f4, float f5, Animator.AnimatorListener animatorListener) {
        this.mPanelViewTranslationAnimationSet.playTogether(createPanelTranslateAnimation(f3, f4, this.mTranslateHidingDuration, new Y.f()), createOutsideAlphaAnimation(false, DEFAULT_ALPHA_HIDING_ANIMATOR_DURATION, new Y.b()));
        startReleaseAnim(animatorListener);
    }

    private void startShowingAnim(Animator.AnimatorListener animatorListener) {
        if (animatorListener != null) {
            this.mPanelViewTranslationAnimationSet.addListener(animatorListener);
        }
        this.mPanelViewTranslationAnimationSet.start();
    }

    private void startShowingAnimInTinyScreen(int i3, Animator.AnimatorListener animatorListener) {
        this.mPanelViewTranslationAnimationSet.playTogether(createOutsideAlphaAnimation(true, SHOW_HEIGHT_ANIM_DURATION_IN_TINY_SCREEN, (PathInterpolator) OUTSIDE_ALPHA_ANIM_INTERPOLATOR));
        setSpringStartPosition(this.mFirstShowCollapsed ? this.mPeekHeight : getContentViewHeightWithMargins() + i3);
        snapToTop();
        startShowingAnim(animatorListener);
    }

    private void stopCurrentRunningViewTranslationAnim() {
        AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.mIsInterruptingAnim = true;
            this.mPanelViewTranslationAnimationSet.end();
        }
        Z.c cVar = this.mTranslationAndScaleSpringAnimation;
        if (cVar != null && cVar.h()) {
            this.mTranslationAndScaleSpringAnimation.c();
        }
        Z.c cVar2 = this.mAlphaSpringAnimation;
        if (cVar2 != null && cVar2.h()) {
            this.mAlphaSpringAnimation.c();
        }
        if (this.mIsInTinyScreen && this.mIsAppearSpringAnimStared) {
            this.mAppearSpringAnim.c();
        }
    }

    private void stopFeedbackAnimation() {
        F0.e eVar = this.mDisableFastCloseFeedbackSpring;
        if (eVar == null || eVar.f() == 0.0d) {
            return;
        }
        this.mDisableFastCloseFeedbackSpring.j();
        this.mDisableFastCloseFeedbackSpring = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopListeningForBackCallbacks(View view) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher findOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
        if (findOnBackInvokedDispatcher == null || (onBackInvokedCallback = this.mOnBackInvokedCallback) == null) {
            return;
        }
        findOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
        this.mOnBackInvokedCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void superDismiss() {
        if (DEBUG) {
            Log.d(TAG, "superDismiss");
        }
        try {
            this.mIsRevertAnimationFromSettlingAnimation = false;
            adjustResize(this.mApplyWindowInsets, true);
            super.dismiss();
            OnAnimationListener onAnimationListener = this.mAnimationListener;
            if (onAnimationListener != null) {
                onAnimationListener.onDismissAnimationEnd();
            }
            this.mIsExecutingDismissAnim = false;
        } catch (Exception e3) {
            Log.e(TAG, e3.getMessage(), e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateUpdate(float f3) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            cOUIPanelPercentFrameLayout.setTranslationY(f3);
            if (!this.mIsInterruptingAnim) {
                this.mCurrentParentViewTranslationY = f3;
            }
            this.mIsInterruptingAnim = false;
        }
    }

    private boolean unNeedNavigationCustomView() {
        return this.mIsGestureNavigation || this.mDesignBottomSheetFrameLayout == null;
    }

    private void updateBottomSheetCenterVertical() {
        View view = this.mCoordinatorLayout;
        if (view == null) {
            Log.w(TAG, "updateBottomSheetCenterVertical: directly return for mCoordinatorLayout is null");
            return;
        }
        if (this.mDesignBottomSheetFrameLayout == null) {
            Log.i(TAG, "updateBottomSheetCenterVertical: directly return for mDesignBottomSheetFrameLayout is null");
            return;
        }
        int measuredHeight = view.getMeasuredHeight();
        int max = (int) Math.max(0.0f, ((measuredHeight - (this.mDesignBottomSheetFrameLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) r1).bottomMargin : 0)) / this.mDesignBottomSheetFrameLayout.getRatio()) - (this.mDesignBottomSheetFrameLayout.getHeight() / this.mDesignBottomSheetFrameLayout.getRatio()));
        if (this.mDesignBottomSheetFrameLayout.getBottom() + max <= measuredHeight) {
            this.mDesignBottomSheetFrameLayout.setY(max);
        }
    }

    private void updateFitToContents() {
        if (this.mIsHandlePanel) {
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout == null) {
                Log.e(TAG, "updateFitToContents: mDesignBottomSheetFrameLayout is null");
            } else {
                COUIBottomSheetBehavior.from(cOUIPanelPercentFrameLayout).setFitToContents(COUIPanelMultiWindowUtils.isNormalLandScreen(getContext(), this.mConfiguration));
            }
        }
    }

    private void updateListeningForBackCallbacks() {
        if (this.mCancelable) {
            startListeningForBackCallbacks(this.mDesignBottomSheetFrameLayout);
        } else {
            stopListeningForBackCallbacks(this.mDesignBottomSheetFrameLayout);
        }
    }

    private void updatePaddingBottom() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            this.mPanelPaddingBottom = cOUIPanelPercentFrameLayout.getRatio() == 2.0f ? 0 : this.mDefaultPaddingBottom;
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout2 = this.mDesignBottomSheetFrameLayout;
            cOUIPanelPercentFrameLayout2.setPaddingRelative(cOUIPanelPercentFrameLayout2.getPaddingStart(), this.mDesignBottomSheetFrameLayout.getPaddingTop(), this.mDesignBottomSheetFrameLayout.getPaddingEnd(), this.mPanelPaddingBottom);
            ((COUIBottomSheetBehavior) getBehavior()).setPanelPaddingBottom(this.mPanelPaddingBottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePanelMarginBottom(Configuration configuration, WindowInsets windowInsets) {
        if (windowInsets == null || configuration == null || this.mDesignBottomSheetFrameLayout == null) {
            return;
        }
        int panelMarginBottom = COUIPanelMultiWindowUtils.getPanelMarginBottom(getContext(), configuration, windowInsets, this.mIsHandlePanel, this.mCouiPanelEdgeToEdgeEnable);
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) this.mDesignBottomSheetFrameLayout.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) fVar).bottomMargin != panelMarginBottom) {
            ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = panelMarginBottom;
        }
    }

    public boolean canPullUp() {
        return this.mCanPullUp;
    }

    public void delPreferWidth() {
        restoreScreenWidth();
        this.mPreferWidth = -1;
        this.mOriginWidth = -1;
        Log.d(TAG, "delPreferWidth");
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        stopFeedbackAnimation();
        dismiss(true);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        COUIPanelContentLayout cOUIPanelContentLayout;
        int action = motionEvent.getAction();
        if ((action == 1 || action == 3) && (cOUIPanelContentLayout = this.mDraggableConstraintLayout) != null && cOUIPanelContentLayout.mIsTurnOnAnim) {
            cOUIPanelContentLayout.mIsTurnOnAnim = false;
            cOUIPanelContentLayout.dragBgEndAnim();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public COUIPanelAdjustResizeHelper getAdjustResizeHelper() {
        if (this.mAdjustResizeHelper == null) {
            this.mAdjustResizeHelper = new COUIPanelAdjustResizeHelper();
        }
        return this.mAdjustResizeHelper;
    }

    public boolean getCanPerformHapticFeedback() {
        return this.mCanPerformHapticFeedback;
    }

    public Button getCenterButton() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(R.id.button3);
        }
        return null;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public int getDialogHeight() {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            return cOUIPanelPercentFrameLayout.getHeight();
        }
        return 0;
    }

    public int getDialogMaxHeight() {
        View view = this.mCoordinatorLayout;
        if (view != null) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    public COUIPanelContentLayout getDragableLinearLayout() {
        return this.mDraggableConstraintLayout;
    }

    public boolean getIsHandlePanel() {
        return this.mIsHandlePanel;
    }

    public boolean getIsInWindowFloatingMode() {
        return this.mIsInWindowFloatingMode;
    }

    public Button getLeftButton() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(R.id.button2);
        }
        return null;
    }

    float getOutsideViewAlpha(float f3) {
        return !this.mIsInTinyScreen ? f3 : Math.max(0.0f, f3 - 0.5f) * 2.0f;
    }

    public int getPeekHeight() {
        return this.mPeekHeight;
    }

    public Button getRightButton() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(R.id.button1);
        }
        return null;
    }

    @Override // android.app.Dialog
    public void hide() {
        COUIPanelContentLayout cOUIPanelContentLayout;
        if (!this.mIsShowInDialogFragment || (cOUIPanelContentLayout = this.mDraggableConstraintLayout) == null || cOUIPanelContentLayout.findFocus() == null) {
            super.hide();
        }
    }

    public void hideDragView() {
        COUIPanelBarView cOUIPanelBarView = this.mPanelBarView;
        if (cOUIPanelBarView != null) {
            cOUIPanelBarView.setVisibility(4);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout == null || cOUIPanelContentLayout.getDrawLayout() == null) {
            return;
        }
        setHideDragViewHeight();
        this.mDraggableConstraintLayout.getDrawLayout().setVisibility(4);
        if (this.mDraggableConstraintLayout.getDragBgView() != null) {
            this.mDraggableConstraintLayout.getDragBgView().setVisibility(8);
        }
    }

    public boolean isFirstShowCollapsed() {
        return this.mFirstShowCollapsed;
    }

    public boolean isPanelHeightChangeAnimRunning() {
        return ((COUIBottomSheetBehavior) getBehavior()).isPanelHeightChangeAnimRunning();
    }

    public boolean isSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    @Override // B.b.q
    public void onAnimationEnd(B.b bVar, boolean z3, float f3, float f4) {
        this.mIsAppearSpringAnimStared = false;
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null && this.mSnapStartBottom != -1) {
            cOUIPanelPercentFrameLayout.layout(cOUIPanelPercentFrameLayout.getLeft(), this.mDesignBottomSheetFrameLayout.getTop(), this.mDesignBottomSheetFrameLayout.getRight(), this.mSnapStartBottom);
        }
        this.mSnapStartBottom = -1;
        BottomSheetDialogAnimatorListener bottomSheetDialogAnimatorListener = this.mBottomSheetDialogAnimatorListener;
        if (bottomSheetDialogAnimatorListener != null) {
            bottomSheetDialogAnimatorListener.onBottomSheetDialogExpanded();
        }
    }

    @Override // B.b.r
    public void onAnimationUpdate(B.b bVar, float f3, float f4) {
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout == null || this.mSnapStartBottom == -1) {
            return;
        }
        if (f3 < 0.0f) {
            cOUIPanelPercentFrameLayout.layout(cOUIPanelPercentFrameLayout.getLeft(), this.mDesignBottomSheetFrameLayout.getTop(), this.mDesignBottomSheetFrameLayout.getRight(), (int) (this.mSnapStartBottom - f3));
        }
        this.mDesignBottomSheetFrameLayout.setTranslationY(f3);
        if (!this.mIsInterruptingAnim) {
            this.mCurrentParentViewTranslationY = this.mDesignBottomSheetFrameLayout.getTranslationY();
        }
        this.mIsInterruptingAnim = false;
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        enforceChangeScreenWidth();
        refreshParams();
        resetWindowImeAnimFlags();
        setStatusBarTransparentAndFont(getWindow());
        registerPreDrawListener();
        registerApplicationConfigChangeListener();
        registerBehaviorPullUpListener();
        registerPullUpToDismissPanelListener();
        initWindowInsetsListener();
        setNavigation();
        if (this.mDesignBottomSheetFrameLayout != null) {
            updateListeningForBackCallbacks();
        }
        if (this.mIsExecutingDismissAnim) {
            return;
        }
        updatePanelMarginBottom(this.mConfiguration, this.mApplyWindowInsets);
    }

    @Override // androidx.activity.f, android.app.Dialog
    public void onBackPressed() {
        WeakReference<Activity> weakReference = this.mActivityWeakReference;
        if (weakReference != null && weakReference.get() != null && this.mIsExecutingDismissAnim) {
            this.mActivityWeakReference.get().onBackPressed();
        }
        super.onBackPressed();
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.j, androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mConfiguration = getContext().getResources().getConfiguration();
        int identifier = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.mStatusBarHeight = getContext().getResources().getDimensionPixelSize(identifier);
        }
        if (this.mIsInTinyScreen) {
            initPhysics();
        }
        initBehavior();
        initWindow();
        initDraggableConstraintLayoutSize();
        if (this.mFrameRate && AbstractC0647b.b(SDK_VERSION_FOR_COMPUTE, 10)) {
            this.mADFRFeatureType = DynamicFrameRateManager.getDynamicFrameRateType();
            this.mIsVSdk = true;
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        releaseResizeHelper();
        releaseApplyWindowInsetsListener();
        cancelAnim(this.mPanelViewTranslationAnimationSet);
        cancelAnim(this.mTranslationAndScaleSpringAnimation);
        cancelAnim(this.mAlphaSpringAnimation);
        releaseApplicationConfigChangeListener();
        releaseBehaviorPullUpListener();
        releasePullUpToDismissPanelListener();
        restoreScreenWidth();
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle bundle) {
        this.mFocusChange = Boolean.valueOf(bundle.getBoolean(STATE_FOCUS_CHANGES, getFocusChange()));
        this.mLastStaticState = bundle.getInt(STATE_LAST_STATIC_CHANGES, 3);
        super.onRestoreInstanceState(bundle);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        onSaveInstanceState.putBoolean(STATE_FOCUS_CHANGES, getFocusChange());
        onSaveInstanceState.putInt(STATE_LAST_STATIC_CHANGES, this.mLastStaticState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        if (z3) {
            setFocusChangeFalseIfHasnotEdittext();
        }
        super.onWindowFocusChanged(z3);
    }

    public void refresh() {
        if (this.mDraggableConstraintLayout == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, U1.i.f2431a, 0, U1.h.f2430c);
        this.mPanelDragViewDrawable = getTypedArrayDrawable(obtainStyledAttributes, U1.i.f2440j, U1.e.f2401c);
        this.mPanelDragViewDrawableTintColor = obtainStyledAttributes.getColor(U1.i.f2441k, AbstractC0335a.a(getContext(), M1.c.f1361f));
        this.mPanelBackground = getTypedArrayDrawable(obtainStyledAttributes, U1.i.f2438h, U1.e.f2399a);
        this.mPanelBackgroundTintColor = obtainStyledAttributes.getColor(U1.i.f2439i, AbstractC0335a.a(getContext(), M1.c.f1379x));
        obtainStyledAttributes.recycle();
        Drawable drawable = this.mPanelDragViewDrawable;
        if (drawable != null && this.mDraggableConstraintLayout != null) {
            drawable.setTint(this.mPanelDragViewDrawableTintColor);
            this.mDraggableConstraintLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
            this.mDraggableConstraintLayout.refresh();
        }
        if (this.mPanelBackground == null || this.mDraggableConstraintLayout == null) {
            return;
        }
        if (getWindow() != null && !COUINavigationBarUtil.isGestureNavigation(getContext())) {
            setNavigationBarColor(getNavColor());
        }
        this.mPanelBackground.setTint(this.mPanelBackgroundTintColor);
        this.mDraggableConstraintLayout.setBackground(this.mIsShowInDialogFragment ? this.mPanelBackground : null);
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            cOUIPanelPercentFrameLayout.setBackground(this.mPanelBackground);
        }
    }

    public void setAnchorView(View view) {
        if (view != null) {
            Log.e(TAG, "setAnchorView: ---------");
            this.mAnchorView = view;
            getBehavior().setDraggable(false);
        }
    }

    public void setAnimationListener(OnAnimationListener onAnimationListener) {
        this.mAnimationListener = onAnimationListener;
    }

    public void setBottomButtonBar(boolean z3, String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setUpBottomBar(z3, str, onClickListener, str2, onClickListener2, str3, onClickListener3);
    }

    public void setBottomSheetDialogAnimatorListener(BottomSheetDialogAnimatorListener bottomSheetDialogAnimatorListener) {
        this.mBottomSheetDialogAnimatorListener = bottomSheetDialogAnimatorListener;
    }

    public void setCanPerformHapticFeedback(boolean z3) {
        this.mCanPerformHapticFeedback = z3;
    }

    public void setCanPullUp(boolean z3) {
        if (this.mCanPullUp != z3) {
            this.mCanPullUp = z3;
            if (getBehavior() instanceof COUIBottomSheetBehavior) {
                this.mPanelPullUpListener = this.mCanPullUp ? getPanelPullUpListener() : null;
                ((COUIBottomSheetBehavior) getBehavior()).setPullUpListener(this.mPanelPullUpListener);
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog
    public void setCancelable(boolean z3) {
        super.setCancelable(z3);
        if (this.mCancelable != z3) {
            this.mCancelable = z3;
            if (this.mDesignBottomSheetFrameLayout == null || getWindow() == null) {
                return;
            }
            updateListeningForBackCallbacks();
        }
    }

    @Override // com.google.android.material.bottomsheet.a, android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z3) {
        super.setCanceledOnTouchOutside(z3);
        if (z3 && !this.mCancelable) {
            this.mCancelable = true;
            if (this.mDesignBottomSheetFrameLayout != null && getWindow() != null) {
                startListeningForBackCallbacks(this.mDesignBottomSheetFrameLayout);
            }
        }
        this.mCanceledOnTouchOutside = z3;
    }

    public void setCenterButton(String str, View.OnClickListener onClickListener) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setCenterButton(str, onClickListener);
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.j, android.app.Dialog
    public void setContentView(int i3) {
        setContentView(getLayoutInflater().inflate(i3, (ViewGroup) null));
    }

    public void setCouiPanelEdgeToEdgeEnable(boolean z3) {
        if (this.mCouiPanelEdgeToEdgeEnable != z3) {
            this.mCouiPanelEdgeToEdgeEnable = z3;
            initPeekHeight();
            getAdjustResizeHelper().setCouiPanelEdgeToEdgeEnable(this.mCouiPanelEdgeToEdgeEnable);
        }
    }

    public void setDialogOffsetListener(DialogOffsetListener dialogOffsetListener) {
        this.mDialogOffsetListener = dialogOffsetListener;
    }

    public void setDisableSubExpand(boolean z3) {
        this.mDisableSubExpand = z3;
    }

    public void setDragableLinearLayout(COUIPanelContentLayout cOUIPanelContentLayout) {
        setDragableLinearLayout(cOUIPanelContentLayout, false);
    }

    public void setDraggable(boolean z3) {
        if (this.mIsDraggable != z3) {
            this.mIsDraggable = z3;
            getBehavior().setDraggable(this.mIsDraggable);
        }
    }

    @Deprecated
    public void setExecuteNavColorAnimAfterDismiss(boolean z3) {
        this.mIsExecuteNavColorAnimAfterDismiss = z3;
    }

    @Deprecated
    public void setFinalNavColorAfterDismiss(int i3) {
        this.mFinalNavColorAfterDismiss = i3;
    }

    public void setFirstShowCollapsed(boolean z3) {
        this.mFirstShowCollapsed = z3;
    }

    public void setFollowWindowChange(boolean z3) {
        this.mFocusChange = Boolean.valueOf(z3);
    }

    public void setGlobalDrag(boolean z3) {
        this.mGlobalDrag = z3;
    }

    public void setHandleViewHasPressAnim(boolean z3) {
        if (this.mHandleViewHasPressAnim != z3) {
            this.mHandleViewHasPressAnim = z3;
            COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
            if (cOUIPanelContentLayout == null) {
                return;
            }
            if (z3) {
                cOUIPanelContentLayout.setDragViewPressAnim(true);
            } else {
                cOUIPanelContentLayout.removeDragViewPressAnim();
            }
        }
    }

    public void setHeight(int i3) {
        this.mPanelHeight = i3;
        setPanelHeight();
    }

    public void setHeightChangeAnim(boolean z3) {
        ((COUIBottomSheetBehavior) getBehavior()).setHeightChangeAnim(z3);
    }

    public void setHideDragViewHeight(int i3) {
        COUIPanelContentLayout cOUIPanelContentLayout;
        this.mHideDragViewHeight = i3;
        if (this.mIsHandlePanel || (cOUIPanelContentLayout = this.mDraggableConstraintLayout) == null || cOUIPanelContentLayout.getDrawLayout() == null) {
            return;
        }
        setHideDragViewHeight();
    }

    public void setIsHandlePanel(boolean z3) {
        if (this.mIsHandlePanel != z3) {
            this.mIsHandlePanel = z3;
            if (this.mDraggableConstraintLayout == null) {
                return;
            }
            if (z3) {
                showDragView();
            } else {
                hideDragView();
            }
        }
    }

    public void setIsInTinyScreen(boolean z3, boolean z4) {
        this.mIsInTinyScreen = z3;
        this.mIsFullScreenInTinyScreen = z4;
    }

    public void setIsInWindowFloatingMode(boolean z3) {
        this.mIsInWindowFloatingMode = z3;
    }

    public void setIsNeedOutsideViewAnim(boolean z3) {
        this.mIsNeedOutsideViewAnim = z3;
    }

    public void setIsShowInMaxHeight(boolean z3) {
        this.mIsShowInMaxHeight = z3;
        int i3 = z3 ? -1 : -2;
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setLayoutAtMaxHeight(z3);
        }
        COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
        if (cOUIPanelPercentFrameLayout != null) {
            ViewGroup.LayoutParams layoutParams = cOUIPanelPercentFrameLayout.getLayoutParams();
            layoutParams.height = i3;
            this.mDesignBottomSheetFrameLayout.setLayoutParams(layoutParams);
            ((COUIBottomSheetBehavior) getBehavior()).setLayoutAtMaxHeight(this.mIsShowInMaxHeight);
        }
    }

    public void setLeftButton(String str, View.OnClickListener onClickListener) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setLeftButton(str, onClickListener);
    }

    public void setNavColor(int i3) {
        this.mNavColor = i3;
        if (getWindow() != null) {
            setNavigationBarColor(getNavColor());
        }
    }

    public void setOnBackInvokedLocalListener(OnBackInvokedLocalListener onBackInvokedLocalListener) {
        this.mOnBackInvokedLocalListener = onBackInvokedLocalListener;
    }

    public void setOnPanelHeightChangeAnimListener(COUIBottomSheetBehavior.OnPanelHeightChangeAnimListener onPanelHeightChangeAnimListener) {
        ((COUIBottomSheetBehavior) getBehavior()).setOnPanelHeightChangeAnimListener(onPanelHeightChangeAnimListener);
    }

    public void setOutSideViewTouchListener(View.OnTouchListener onTouchListener) {
        if (this.mOutsideView == null) {
            this.mOutsideView = findViewById(U1.f.f2416n);
        }
        this.mOutSideViewTouchListener = onTouchListener;
        View view = this.mOutsideView;
        if (view != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public void setOutsideMaskColor(int i3) {
        View view = this.mOutsideView;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void setPanelBackground(Drawable drawable) {
        if (this.mDesignBottomSheetFrameLayout == null || drawable == null || this.mPanelBackground == drawable) {
            return;
        }
        this.mPanelBackground = drawable;
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            if (!this.mIsShowInDialogFragment) {
                drawable = null;
            }
            cOUIPanelContentLayout.setBackground(drawable);
        }
        this.mDesignBottomSheetFrameLayout.setBackground(this.mPanelBackground);
    }

    public void setPanelBackgroundTintColor(int i3) {
        if (this.mDesignBottomSheetFrameLayout == null || this.mPanelBackground == null || this.mPanelBackgroundTintColor == i3) {
            return;
        }
        this.mPanelBackgroundTintColor = i3;
        if (getWindow() != null && !COUINavigationBarUtil.isGestureNavigation(getContext())) {
            setNavigationBarColor(getNavColor());
        }
        this.mPanelBackground.setTint(this.mPanelBackgroundTintColor);
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout != null) {
            cOUIPanelContentLayout.setBackground(this.mIsShowInDialogFragment ? this.mPanelBackground : null);
        }
        this.mDesignBottomSheetFrameLayout.setBackground(this.mPanelBackground);
    }

    public void setPanelBarViewColor(int i3) {
        COUIPanelBarView cOUIPanelBarView = this.mPanelBarView;
        if (cOUIPanelBarView != null) {
            cOUIPanelBarView.setBarColor(i3);
        }
    }

    public void setPanelDismissTranslateDuration(float f3) {
        this.mTranslateHidingDuration = f3;
    }

    public void setPanelDragViewDrawable(Drawable drawable) {
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout == null || drawable == null || this.mPanelDragViewDrawable == drawable) {
            return;
        }
        this.mPanelDragViewDrawable = drawable;
        cOUIPanelContentLayout.setDragViewDrawable(drawable);
    }

    public void setPanelDragViewDrawableTintColor(int i3) {
        Drawable drawable;
        if (this.mDraggableConstraintLayout == null || (drawable = this.mPanelDragViewDrawable) == null || this.mPanelDragViewDrawableTintColor == i3) {
            return;
        }
        this.mPanelDragViewDrawableTintColor = i3;
        drawable.setTint(i3);
        this.mDraggableConstraintLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
    }

    public void setPeekHeight(int i3) {
        this.mPeekHeight = i3;
    }

    public void setPhysicsParams(float f3, float f4) {
        this.mAppearStiffness = f3;
        this.mAppearDampingRatio = f4;
    }

    public void setPreferWidth(int i3) {
        this.mPreferWidth = i3;
        Log.d(TAG, "setPreferWidth =：" + this.mPreferWidth);
    }

    public void setRegisterConfigurationChangeCallBack(boolean z3) {
        this.mRegisterConfigurationChangeCallBack = z3;
    }

    public void setRightButton(String str, View.OnClickListener onClickListener) {
        ensureDraggableContentLayout();
        this.mDraggableConstraintLayout.setRightButton(str, onClickListener);
    }

    public void setShouldRegisterWindowInsetsListener(boolean z3) {
        this.mShouldRegisterWindowInsetsListener = z3;
    }

    void setShowInDialogFragment(boolean z3) {
        this.mIsShowInDialogFragment = z3;
    }

    public void setSkipCollapsed(boolean z3) {
        this.mSkipCollapsed = z3;
    }

    public void setSupportExitBlockingAnimation(boolean z3) {
        if (!AbstractC0647b.b(SDK_VERSION_FOR_COMPUTE, 10) || this.mSupportExitBlockingAnimation == z3) {
            return;
        }
        this.mSupportExitBlockingAnimation = z3;
        operateBlockingAnimation();
    }

    public void setWidth(int i3) {
        this.mPanelWidth = i3;
        setPanelWidth();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isShowing() && this.mIsExecutingDismissAnim && this.mSupportExitBlockingAnimation) {
            doParentViewTranslationShowingAnim(0, getPanelShowAnimListener());
        } else {
            super.show();
        }
    }

    public void showDragView() {
        COUIPanelBarView cOUIPanelBarView = this.mPanelBarView;
        if (cOUIPanelBarView != null) {
            cOUIPanelBarView.setVisibility(0);
        }
        COUIPanelContentLayout cOUIPanelContentLayout = this.mDraggableConstraintLayout;
        if (cOUIPanelContentLayout == null || cOUIPanelContentLayout.getDrawLayout() == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDraggableConstraintLayout.getDrawLayout().getLayoutParams();
        marginLayoutParams.height = getContext().getResources().getDimensionPixelSize(U1.d.f2391s);
        marginLayoutParams.topMargin = getContext().getResources().getDimensionPixelSize(U1.d.f2393u);
        this.mDraggableConstraintLayout.getDrawLayout().setLayoutParams(marginLayoutParams);
        this.mDraggableConstraintLayout.getDrawLayout().setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T typeCasting(Class<T> cls, Object obj) {
        if (obj == 0 || !cls.isInstance(obj)) {
            return null;
        }
        return obj;
    }

    public boolean updateFollowHandPanelLocation() {
        if (this.mDesignBottomSheetFrameLayout == null) {
            Log.e(TAG, "update follow hand panel while config change error.");
            return false;
        }
        boolean isFollowHand = isFollowHand();
        this.mDesignBottomSheetFrameLayout.setHasAnchor(isFollowHand);
        boolean haveEnoughSpace = haveEnoughSpace();
        if (isFollowHand && haveEnoughSpace) {
            this.mOutsideView.setAlpha(0.0f);
            this.mCurrentOutsideAlpha = 0.0f;
            offsetViewTo();
            return true;
        }
        updateBottomSheetCenterVertical();
        this.mDesignBottomSheetFrameLayout.setElevation(0.0f);
        this.mOutsideView.setAlpha(1.0f);
        this.mCurrentOutsideAlpha = 1.0f;
        this.mDesignBottomSheetFrameLayout.setTranslationY(0.0f);
        this.mDesignBottomSheetFrameLayout.setTranslationX(0.0f);
        return true;
    }

    public void updateLayoutWhileConfigChange(Configuration configuration) {
        refreshColorMask();
        enforceChangeScreenWidth(configuration);
        this.mConfiguration = configuration;
        this.mIsGestureNavigation = COUINavigationBarUtil.isGestureNavigation(getContext());
        getAdjustResizeHelper().resetInnerStatus();
        if (this.mDesignBottomSheetFrameLayout != null) {
            largeScreenLimitMaxSize();
            this.mDesignBottomSheetFrameLayout.updateLayoutWhileConfigChange(configuration);
            if (!this.mIsHandlePanel || COUIPanelMultiWindowUtils.isNormalScreen(getContext(), this.mConfiguration)) {
                resetNavigationBarColor();
            }
            setNavigation();
        }
        updateFitToContents();
        updatePaddingBottom();
        initCoordinateInsets(this.mApplyWindowInsets);
        if (this.mIsExecutingDismissAnim) {
            return;
        }
        updatePanelMarginBottom(this.mConfiguration, this.mApplyWindowInsets);
    }

    public COUIBottomSheetDialog(Context context, boolean z3, DialogInterface.OnCancelListener onCancelListener) {
        this(context, U1.h.f2430c);
        setCancelable(z3);
        setOnCancelListener(onCancelListener);
    }

    @Override // com.google.android.material.bottomsheet.a, androidx.appcompat.app.j, android.app.Dialog
    public void setContentView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("ContentView can't be null");
        }
        com.coui.appcompat.theme.a.h().a(getContext());
        setContentViewLocal(view);
        initView();
    }

    public void setDragableLinearLayout(COUIPanelContentLayout cOUIPanelContentLayout, boolean z3) {
        this.mDraggableConstraintLayout = cOUIPanelContentLayout;
        if (!this.mIsHandlePanel) {
            hideDragView();
        }
        if (cOUIPanelContentLayout != null) {
            this.mPulledUpView = (ViewGroup) this.mDraggableConstraintLayout.getParent();
            cOUIPanelContentLayout.setLayoutAtMaxHeight(this.mIsShowInMaxHeight);
            if (this.mHandleViewHasPressAnim) {
                cOUIPanelContentLayout.setDragViewPressAnim(true);
            }
            cOUIPanelContentLayout.setDragViewDrawable(this.mPanelDragViewDrawable);
        }
        if (z3) {
            refresh();
        } else if (cOUIPanelContentLayout != null) {
            WindowInsets windowInsets = this.mApplyWindowInsets;
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            cOUIPanelContentLayout.setNavigationMargin(null, windowInsets, cOUIPanelPercentFrameLayout != null && cOUIPanelPercentFrameLayout.getRatio() == 1.0f, this.mCouiPanelEdgeToEdgeEnable);
        }
        initDraggableConstraintLayoutSize();
    }

    private void cancelAnim(Z.c cVar) {
        if (cVar == null || !cVar.h()) {
            return;
        }
        cVar.c();
    }

    public void dismiss(boolean z3) {
        if (isShowing() && z3 && !this.mIsExecutingDismissAnim) {
            hideKeyboard();
            if (getBehavior().getState() != 5) {
                dismissWithInterruptibleAnim();
                return;
            }
            return;
        }
        superDismiss();
    }

    private void setHideDragViewHeight() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mDraggableConstraintLayout.getDrawLayout().getLayoutParams();
        int i3 = this.mHideDragViewHeight;
        if (i3 > 0) {
            marginLayoutParams.height = i3;
        } else {
            marginLayoutParams.height = getContext().getResources().getDimensionPixelSize(U1.d.f2392t);
        }
        marginLayoutParams.topMargin = 0;
        this.mDraggableConstraintLayout.getDrawLayout().setLayoutParams(marginLayoutParams);
    }

    public COUIBottomSheetDialog(Context context, int i3, float f3, float f4) {
        this(context, i3);
        this.mPhysicsFrequency = f3;
        this.mPhysicsDampingRatio = f4;
    }

    public COUIBottomSheetDialog(Context context, int i3) {
        super(context, resolveDialogTheme(context, i3));
        this.mTemtRect = new Rect();
        this.mHandleViewHasPressAnim = true;
        this.mIsShowInDialogFragment = false;
        this.mCancelable = true;
        this.mCanceledOnTouchOutside = true;
        this.mCanPullUp = true;
        this.mCurrentSpringTotalOffset = 0;
        this.mCoordinatorLayoutMinInsetsTop = 0;
        this.mCoordinatorLayoutPaddingExtra = 0;
        this.mPeekHeight = 0;
        this.mSkipCollapsed = true;
        this.mFirstShowCollapsed = false;
        this.mCurrentParentViewTranslationY = 0.0f;
        this.mCurrentOutsideAlpha = 0.0f;
        this.mIsInterruptingAnim = false;
        this.mWindowInsetsListener = null;
        this.mPanelPullUpListener = null;
        this.mNavColor = Preference.DEFAULT_ORDER;
        this.mWindowInsetsAnimEnable = false;
        this.mIsInWindowFloatingMode = false;
        this.mCanPerformHapticFeedback = false;
        this.mRegisterConfigurationChangeCallBack = true;
        this.mIsNeedShowKeyboard = false;
        this.mIsNeedOutsideViewAnim = true;
        this.mFocusChange = null;
        this.mIsDraggable = true;
        this.mTranslateHidingDuration = DEFAULT_TRANSLATE_HIDING_ANIMATOR_DURATION;
        this.mPanelBarView = null;
        this.mBottomSheetDialogAnimatorListener = null;
        this.mDisableSubExpand = false;
        this.mGlobalDrag = true;
        this.mPhysicsFrequency = PHYSICS_UNSET;
        this.mPhysicsDampingRatio = PHYSICS_UNSET;
        this.mAnchorView = null;
        this.mStatusBarHeight = 0;
        this.mSnapStartBottom = -1;
        this.mAppearStiffness = PHYSICS_UNSET;
        this.mAppearDampingRatio = PHYSICS_UNSET;
        this.mIsAppearSpringAnimStared = false;
        this.mShouldRegisterWindowInsetsListener = true;
        this.mPreferWidth = -1;
        this.mOriginWidth = -1;
        this.isLargeScreenLimitMaxSize = false;
        this.mIsHandlePanel = false;
        this.mIsGestureNavigation = true;
        this.mHideDragViewHeight = 0;
        this.mFrameRate = true;
        this.mAnimationFlag = 0;
        this.mCurrentOutSideAlphaStateHidden = 0.0f;
        this.mCurrentOutSideAlphaStateShow = 0.0f;
        this.mPullUpToDismissPanelListener = new COUIBottomSheetBehavior.PullUpToDismissPanelListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.1
            @Override // com.coui.appcompat.panel.COUIBottomSheetBehavior.PullUpToDismissPanelListener
            public void onPullUpDismiss() {
                COUIBottomSheetDialog.this.dismissWithAlphaAnim();
            }
        };
        this.mIsAnimationInFirst = false;
        this.mOnAttatchStateChangeListener = null;
        this.mLastStaticState = 3;
        this.mComponentCallbacks = new ComponentCallbacks() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.2
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                if (COUIBottomSheetDialog.this.mRegisterConfigurationChangeCallBack) {
                    COUIBottomSheetDialog.this.updateLayoutWhileConfigChange(configuration);
                }
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }
        };
        this.mOnPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.25
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                COUIBottomSheetDialog.this.removeOnPreDrawListener();
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout == null) {
                    COUIBottomSheetDialog cOUIBottomSheetDialog = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog.doParentViewTranslationShowingAnim(0, cOUIBottomSheetDialog.getPanelShowAnimListener());
                    return true;
                }
                int contentViewHeightWithMargins = COUIBottomSheetDialog.this.getContentViewHeightWithMargins();
                if (COUIBottomSheetDialog.this.mFirstShowCollapsed) {
                    contentViewHeightWithMargins = COUIBottomSheetDialog.this.mPeekHeight;
                }
                COUIPanelContentLayout cOUIPanelContentLayout = COUIBottomSheetDialog.this.mDraggableConstraintLayout;
                if ((cOUIPanelContentLayout == null || cOUIPanelContentLayout.findFocus() == null) && !COUIBottomSheetDialog.this.isFollowHand() && !COUIBottomSheetDialog.this.isFadeInCenter()) {
                    COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.setTranslationY(contentViewHeightWithMargins);
                }
                COUIBottomSheetDialog.this.mOutsideView.setAlpha(0.0f);
                if (COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout.getRatio() == 2.0f) {
                    COUIBottomSheetDialog cOUIBottomSheetDialog2 = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog2.doParentViewTranslationShowingAnim(cOUIBottomSheetDialog2.mCoordinatorLayout.getHeight() / 2, COUIBottomSheetDialog.this.getPanelShowAnimListener());
                } else {
                    COUIBottomSheetDialog cOUIBottomSheetDialog3 = COUIBottomSheetDialog.this;
                    cOUIBottomSheetDialog3.doParentViewTranslationShowingAnim(0, cOUIBottomSheetDialog3.getPanelShowAnimListener());
                }
                return true;
            }
        };
        initThemeResources(i3);
        initValueResources();
        saveActivityContextToGetMultiWindowInfo(context);
    }

    private void setFrameRate(Z.c cVar) {
        if (!this.mIsVSdk || this.mDesignBottomSheetFrameLayout == null) {
            return;
        }
        int i3 = this.mADFRFeatureType;
        if (i3 == 2) {
            cVar.b(new b.r() { // from class: com.coui.appcompat.panel.a
                @Override // Z.b.r
                public final void onAnimationUpdate(Z.b bVar, float f3, float f4) {
                    COUIBottomSheetDialog.this.lambda$setFrameRate$1(bVar, f3, f4);
                }
            });
            cVar.a(new b.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.19
                @Override // Z.b.q
                public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
                    AbstractC0371a.a(COUIBottomSheetDialog.TAG, "COUISpringAnimation LEVEL_HIGH_PRECISION onAnimatorEnd: DynamicFrameRateManager.FRAME_RATE_END");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, COUIBottomSheetDialog.ANIMATION_TYPE_ID, -2, (Bundle) null);
                }
            });
        } else if (i3 == 1) {
            AbstractC0371a.a(TAG, "COUISpringAnimation LEVEL_LOW_PRECISION onAnimatorStart: DynamicFrameRateManager.LOW_PRECISION_FRAME_RATE");
            DynamicFrameRateManager.setFrameRate(this.mDesignBottomSheetFrameLayout, ANIMATION_TYPE_ID, -1, (Bundle) null);
            cVar.a(new b.q() { // from class: com.coui.appcompat.panel.COUIBottomSheetDialog.20
                @Override // Z.b.q
                public void onAnimationEnd(Z.b bVar, boolean z3, float f3, float f4) {
                    AbstractC0371a.a(COUIBottomSheetDialog.TAG, "COUISpringAnimation LEVEL_LOW_PRECISION onAnimatorEnd: DynamicFrameRateManager.FRAME_RATE_END");
                    DynamicFrameRateManager.setFrameRate(COUIBottomSheetDialog.this.mDesignBottomSheetFrameLayout, COUIBottomSheetDialog.ANIMATION_TYPE_ID, -2, (Bundle) null);
                }
            });
        } else if (i3 == 0) {
            AbstractC0371a.a(TAG, "COUISpringAnimation LEVEL_DEFAULT do nothing");
        }
    }

    public void doFeedbackAnimation() {
        if (this.mDesignBottomSheetFrameLayout != null) {
            AnimatorSet animatorSet = this.mPanelViewTranslationAnimationSet;
            if (animatorSet == null || !animatorSet.isRunning()) {
                Z.c cVar = this.mTranslationAndScaleSpringAnimation;
                if (cVar == null || !cVar.h()) {
                    doFeedbackAnimation(this.mDesignBottomSheetFrameLayout);
                }
            }
        }
    }

    private void enforceChangeScreenWidth(Configuration configuration) {
        if (this.mPreferWidth == -1) {
            return;
        }
        try {
            Resources resources = getContext().getResources();
            this.mOriginWidth = configuration.screenWidthDp;
            configuration.screenWidthDp = this.mPreferWidth;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            Log.d(TAG, "enforceChangeScreenWidth : OriginWidth=" + this.mOriginWidth + " ,PreferWidth:" + this.mPreferWidth);
            COUIPanelPercentFrameLayout cOUIPanelPercentFrameLayout = this.mDesignBottomSheetFrameLayout;
            if (cOUIPanelPercentFrameLayout != null) {
                cOUIPanelPercentFrameLayout.setPreferWidth(this.mPreferWidth);
            }
        } catch (Exception unused) {
            Log.d(TAG, "enforceChangeScreenWidth : failed to updateConfiguration");
        }
    }

    public void setFrameRate(boolean z3) {
        this.mFrameRate = z3;
    }
}
