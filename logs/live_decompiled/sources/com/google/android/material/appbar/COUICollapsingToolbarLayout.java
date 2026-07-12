package com.google.android.material.appbar;

import M1.d;
import Y.b;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.text.e;
import androidx.core.view.y;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.StaticLayoutBuilderCompat;
import com.google.android.material.internal.CollapsingTextHelper;
import g2.c;
import g2.i;
import java.lang.reflect.Field;
import y0.j;

/* loaded from: classes.dex */
public class COUICollapsingToolbarLayout extends CollapsingToolbarLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final long DEFAULT_FADE_IN_ALPHA_ANIMATION_DURATION = 200;
    private static final float DEFAULT_FADE_MODE_EXPANSION_FRACTION = 0.81f;
    private static final float DEFAULT_FADE_MODE_EXPANSION_FRACTION_ERROR = 0.02f;
    private static final float DEFAULT_FADE_MODE_START_FRACTION = 1.0f;
    private static final long DEFAULT_FADE_OUT_ALPHA_ANIMATION_DURATION = 150;
    private static final int DEFAULT_NORMAL_TEXT_COLOR_ALPHA = 255;
    private static final float DEFAULT_SCALE_MODE_START_FRACTION = 0.5f;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final String ELLIPSIS_TWO_DOTS = "‥";
    private static final float FADE_MODE_EXPANSION_FRACTION_ERROR_WITH_SEARCH = 0.0075f;
    private static final float FADE_MODE_EXPANSION_FRACTION_WITH_SEARCH = 0.35f;
    private static final boolean IS_DEBUG = false;
    private static final String TAG = "COUICollapsingToolbar";
    private static final PathInterpolator TITLE_PATH_INTERPOLATOR = new b();
    private ObjectAnimator mAlphaAnimator;
    private Rect mCollapsedBounds;
    private int mCollapsedSubtitleMarginTopIfNotHidden;
    private ColorStateList mCollapsedTextColor;
    private ColorDrawable mContentScrimDrawable;
    private RectF mCurrentBounds;
    private Rect mExpandedBounds;
    private float mFadeModeExpansionFraction;
    private float mFadeModeExpansionFractionError;
    private View mIconView;
    private ViewTreeObserver.OnGlobalLayoutListener mIconViewFirstLayoutListener;
    private boolean mIsAllowFadeInAnimation;
    private boolean mIsAllowFadeOutAnimation;
    private boolean mIsInsideSideNavigationBar;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private StaticLayout mTextLayout;
    private TextPaint mTextPaint;
    private int mTitleTranslateOffset;
    private COUIToolbar mToolbar;
    private int mToolbarNormalPaddingEnd;
    private int mToolbarNormalPaddingStart;

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
            if (COUICollapsingToolbarLayout.this.mToolbar == null || !COUICollapsingToolbarLayout.this.mToolbar.getIsTitleCenterStyle()) {
                COUICollapsingToolbarLayout.this.updateTextLayoutIfNeed();
            } else {
                COUICollapsingToolbarLayout.this.fixCollapsingTitleAlpha();
                COUICollapsingToolbarLayout.this.collapsingTextHelper.recalculate();
            }
        }
    }

    public COUICollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    private void addIconView() {
        View view = this.mIconView;
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CollapsingToolbarLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) ((CollapsingToolbarLayout.LayoutParams) layoutParams)).gravity = 8388691;
        }
        addView(this.mIconView, getChildCount());
        this.mIconView.getViewTreeObserver().addOnGlobalLayoutListener(this.mIconViewFirstLayoutListener);
    }

    private int calculateCollapsedBound() {
        View findSubtitleContentView;
        int measuredHeight;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (!(viewGroup instanceof COUICollapsableAppBarLayout)) {
            return 0;
        }
        COUICollapsableAppBarLayout cOUICollapsableAppBarLayout = (COUICollapsableAppBarLayout) viewGroup;
        if (cOUICollapsableAppBarLayout.isSubtitleHideEnable() || (findSubtitleContentView = cOUICollapsableAppBarLayout.findSubtitleContentView()) == null || findSubtitleContentView.getVisibility() == 8 || (measuredHeight = findSubtitleContentView.getMeasuredHeight()) == 0) {
            return 0;
        }
        return ((this.mCollapsedBounds.height() - ((int) this.collapsingTextHelper.getCollapsedTextHeight())) / 2) - (measuredHeight + this.mCollapsedSubtitleMarginTopIfNotHidden);
    }

    private boolean calculateIsRtl(CharSequence charSequence) {
        boolean z3 = y.x(this) == 1;
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled() ? isTextDirectionHeuristicsIsRtl(charSequence, z3) : z3;
    }

    private StaticLayout createStaticLayout() {
        float floatValue = ((Float) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "scale")).floatValue();
        if (floatValue == 1.0f || floatValue == 0.0f) {
            return null;
        }
        CharSequence text = this.collapsingTextHelper.getText();
        try {
            return StaticLayoutBuilderCompat.obtain(text, this.mTextPaint, (int) (this.mCurrentBounds.width() / floatValue)).setEllipsize(TextUtils.TruncateAt.END).setIsRtl(calculateIsRtl(text)).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setMaxLines(1).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e3) {
            Log.e(TAG, e3.getCause().getMessage(), e3);
            return null;
        }
    }

    private void ensureToolbar() {
        if (this.mToolbar != null) {
            return;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof COUIToolbar) {
                this.mToolbar = (COUIToolbar) childAt;
                return;
            }
        }
    }

    private Object getReflectField(Class cls, Object obj, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e3) {
            Log.e(TAG, "getReflectField error: " + e3.getMessage());
            return null;
        }
    }

    private float getScale() {
        try {
            return ((Float) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "scale")).floatValue();
        } catch (Exception unused) {
            return 1.0f;
        }
    }

    private Rect getTextHelperCollapsedBounds() {
        try {
            return (Rect) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "collapsedBounds");
        } catch (Exception unused) {
            return null;
        }
    }

    private RectF getTextHelperCurrentBounds() {
        try {
            return (RectF) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "currentBounds");
        } catch (Exception unused) {
            return null;
        }
    }

    private Rect getTextHelperExpandedBounds() {
        try {
            return (Rect) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "expandedBounds");
        } catch (Exception unused) {
            return null;
        }
    }

    private StaticLayout getTextLayout() {
        try {
            return (StaticLayout) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "textLayout");
        } catch (Exception unused) {
            return null;
        }
    }

    private TextPaint getTextPaint() {
        try {
            return (TextPaint) getReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "textPaint");
        } catch (Exception unused) {
            return null;
        }
    }

    private void init(AttributeSet attributeSet) {
        resetTextHelperInterpolator();
        TextPaint textPaint = getTextPaint();
        this.mTextPaint = textPaint;
        if (textPaint != null) {
            textPaint.setElegantTextHeight(getContext().getResources().getBoolean(d.f1383b));
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f11850f);
            int resourceId = obtainStyledAttributes.getResourceId(i.f11851g, 0);
            obtainStyledAttributes.recycle();
            setIconView(resourceId);
        }
    }

    private boolean isTextDirectionHeuristicsIsRtl(CharSequence charSequence, boolean z3) {
        return (z3 ? e.f5002d : e.f5001c).a(charSequence, 0, charSequence.length());
    }

    private void setReflectField(Class cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception e3) {
            Log.e(TAG, "setReflectField error: " + e3.getMessage());
        }
    }

    private void showCollapsedTitleAnimation() {
        if (!this.mToolbar.getIsTitleCenterStyle() || this.mToolbar.getCOUITitleTextView() == null) {
            return;
        }
        getCollapsingTextHelper().setFadeModeStartFraction(1.0f);
        float expansionFraction = getCollapsingTextHelper().getExpansionFraction();
        float f3 = this.mFadeModeExpansionFraction;
        if (expansionFraction <= f3) {
            startFadeAnimation(false, this.mToolbar.getCOUITitleTextView());
        } else if (expansionFraction > f3 + this.mFadeModeExpansionFractionError) {
            startFadeAnimation(true, this.mToolbar.getCOUITitleTextView());
        }
    }

    private void startFadeAnimation(final boolean z3, TextView textView) {
        if (z3) {
            this.mIsAllowFadeOutAnimation = true;
            if (!this.mIsAllowFadeInAnimation) {
                return;
            }
        } else {
            this.mIsAllowFadeInAnimation = true;
            if (!this.mIsAllowFadeOutAnimation) {
                return;
            }
        }
        if (textView == null) {
            return;
        }
        ObjectAnimator objectAnimator = this.mAlphaAnimator;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.mAlphaAnimator.cancel();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "alpha", z3 ? 0.0f : 1.0f, z3 ? 1.0f : 0.0f);
        this.mAlphaAnimator = ofFloat;
        ofFloat.setDuration(z3 ? DEFAULT_FADE_IN_ALPHA_ANIMATION_DURATION : DEFAULT_FADE_OUT_ALPHA_ANIMATION_DURATION);
        this.mAlphaAnimator.setInterpolator(TITLE_PATH_INTERPOLATOR);
        this.mAlphaAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.appbar.COUICollapsingToolbarLayout.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                COUICollapsingToolbarLayout.this.mAlphaAnimator = null;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z3) {
                    COUICollapsingToolbarLayout.this.mIsAllowFadeInAnimation = false;
                } else {
                    COUICollapsingToolbarLayout.this.mIsAllowFadeOutAnimation = false;
                }
            }
        });
        this.mAlphaAnimator.start();
    }

    private void translateTitleIfNeed() {
        if (this.mCollapsedBounds == null) {
            return;
        }
        int calculateCollapsedBound = calculateCollapsedBound();
        this.mTitleTranslateOffset = calculateCollapsedBound;
        if (calculateCollapsedBound != 0) {
            this.mCollapsedBounds.offset(0, calculateCollapsedBound);
            this.collapsingTextHelper.recalculate();
        }
    }

    private void updateFadeModeExpansionFraction() {
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            boolean z3 = false;
            int i3 = 0;
            while (true) {
                AppBarLayout appBarLayout = (AppBarLayout) parent;
                if (i3 < appBarLayout.getChildCount()) {
                    if (appBarLayout.getChildAt(i3) instanceof COUISearchBar) {
                        z3 = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            this.mFadeModeExpansionFraction = z3 ? FADE_MODE_EXPANSION_FRACTION_WITH_SEARCH : DEFAULT_FADE_MODE_EXPANSION_FRACTION;
            this.mFadeModeExpansionFractionError = z3 ? FADE_MODE_EXPANSION_FRACTION_ERROR_WITH_SEARCH : DEFAULT_FADE_MODE_EXPANSION_FRACTION_ERROR;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextLayoutIfNeed() {
        StaticLayout staticLayout;
        StaticLayout createStaticLayout;
        if (isExpanded() || isCollapsed() || getMaxLines() > 1 || (staticLayout = this.mTextLayout) == null) {
            return;
        }
        CharSequence text = staticLayout.getText();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        if ((text.toString().contains(ELLIPSIS_TWO_DOTS) || text.toString().contains(ELLIPSIS_NORMAL)) && (createStaticLayout = createStaticLayout()) != null) {
            setReflectField(this.collapsingTextHelper.getClass(), this.collapsingTextHelper, "textLayout", createStaticLayout);
            this.mTextLayout = createStaticLayout;
        }
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.View
    public void draw(Canvas canvas) {
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null && cOUIToolbar.getIsTitleCenterStyle()) {
            setScrimAlpha(DEFAULT_NORMAL_TEXT_COLOR_ALPHA);
            showCollapsedTitleAnimation();
        }
        super.draw(canvas);
    }

    public void fixCollapsingTitleAlpha() {
        this.collapsingTextHelper.setFadeModeStartFraction(1.0f);
        this.mTextPaint.setAlpha(DEFAULT_NORMAL_TEXT_COLOR_ALPHA);
    }

    public CollapsingTextHelper getCollapsingTextHelper() {
        return this.collapsingTextHelper;
    }

    public StaticLayout getCollapsingTextLayout() {
        return this.mTextLayout;
    }

    public TextPaint getCollapsingTextPaint() {
        return this.mTextPaint;
    }

    public View getIconView() {
        return this.mIconView;
    }

    public boolean isCollapsed() {
        return this.collapsingTextHelper.getExpansionFraction() == 1.0f;
    }

    public boolean isExpanded() {
        return this.collapsingTextHelper.getExpansionFraction() == 0.0f;
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.mOnOffsetChangedListener == null) {
                this.mOnOffsetChangedListener = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.mOnOffsetChangedListener);
            y.f0(this);
        }
        bringChildToFront(this.mIconView);
        setTouchscreenBlocksFocus(false);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        updateFadeModeExpansionFraction();
        updateTextLayoutIfNeed();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.mTextLayout = getTextLayout();
        if (this.mCurrentBounds.isEmpty()) {
            this.mCurrentBounds = getTextHelperCurrentBounds();
        }
        if (this.mCollapsedBounds.isEmpty()) {
            this.mCollapsedBounds = getTextHelperCollapsedBounds();
        }
        if (this.mExpandedBounds.isEmpty()) {
            this.mExpandedBounds = getTextHelperExpandedBounds();
        }
        translateTitleIfNeed();
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null && cOUIToolbar.getIsTitleCenterStyle()) {
            this.collapsingTextHelper.setCollapsedBounds(this.mExpandedBounds);
            this.collapsingTextHelper.recalculate();
        }
        View view = this.mIconView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (calculateIsRtl(this.mTextLayout.getText())) {
            this.mCollapsedBounds.left += this.mIconView.getMeasuredWidth();
            this.mExpandedBounds.left += this.mIconView.getMeasuredWidth();
        } else {
            this.mCollapsedBounds.right -= this.mIconView.getMeasuredWidth();
            this.mExpandedBounds.right -= this.mIconView.getMeasuredWidth();
        }
        this.collapsingTextHelper.recalculate();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        super.onMeasure(i3, i4);
        if (this.mIsInsideSideNavigationBar) {
            setExpandedTitleMarginStart(this.mToolbarNormalPaddingStart);
            setExpandedTitleMarginEnd(this.mToolbarNormalPaddingEnd);
            return;
        }
        if (COUIResponsiveUtils.isSmallScreen(getContext(), getMeasuredWidth())) {
            i5 = getContext().getResources().getDimensionPixelOffset(c.f11776p);
            i6 = getContext().getResources().getDimensionPixelOffset(c.f11768l);
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), getMeasuredWidth(), j.j(getContext()))) {
            i5 = getContext().getResources().getDimensionPixelOffset(c.f11780r);
            i6 = getContext().getResources().getDimensionPixelOffset(c.f11772n);
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), getMeasuredWidth(), j.j(getContext()))) {
            i5 = getContext().getResources().getDimensionPixelOffset(c.f11778q);
            i6 = getContext().getResources().getDimensionPixelOffset(c.f11770m);
        } else {
            i5 = 0;
            i6 = 0;
        }
        setExpandedTitleMarginStart(i5);
        setExpandedTitleMarginEnd(i6);
    }

    public void resetTextHelperInterpolator() {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        PathInterpolator pathInterpolator = TITLE_PATH_INTERPOLATOR;
        collapsingTextHelper.setTextSizeInterpolator(pathInterpolator);
        this.collapsingTextHelper.setPositionInterpolator(pathInterpolator);
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setCollapsedTitleTextColor(int i3) {
        super.setCollapsedTitleTextColor(i3);
        this.mCollapsedTextColor = ColorStateList.valueOf(i3);
    }

    @Deprecated
    public void setEditStyle(boolean z3) {
        setIsTitleCenterStyle(z3);
    }

    public void setIconView(int i3) {
        setIconView(i3 == 0 ? null : LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, false));
    }

    public void setIsInsideSideNavigationBar(boolean z3) {
        this.mIsInsideSideNavigationBar = z3;
        requestLayout();
    }

    public void setIsTitleCenterStyle(boolean z3) {
        setTitleCollapseMode(z3 ? 1 : 0);
        setContentScrim(this.mContentScrimDrawable);
        ensureToolbar();
        COUIToolbar cOUIToolbar = this.mToolbar;
        if (cOUIToolbar != null) {
            cOUIToolbar.setIsTitleCenterStyle(z3);
            this.mToolbar.getCOUITitleTextView().setAlpha(isExpanded() ? 0.0f : 1.0f);
            if (z3) {
                getCollapsingTextHelper().setCollapsedTextColor(ColorStateList.valueOf(0));
            } else if (this.mCollapsedTextColor != null) {
                getCollapsingTextHelper().setCollapsedTextColor(this.mCollapsedTextColor);
            } else {
                getCollapsingTextHelper().setFadeModeStartFraction(DEFAULT_SCALE_MODE_START_FRACTION);
            }
        }
        this.mIsAllowFadeInAnimation = isExpanded();
        this.mIsAllowFadeOutAnimation = !isExpanded();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        View view = this.mIconView;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.mIconViewFirstLayoutListener);
        }
    }

    protected void updateIconViewLocationIfNeed() {
        View view;
        StaticLayout staticLayout = this.mTextLayout;
        if (staticLayout == null) {
            return;
        }
        CharSequence text = staticLayout.getText();
        if (TextUtils.isEmpty(text) || (view = this.mIconView) == null || view.getVisibility() != 0) {
            return;
        }
        boolean z3 = text.toString().contains(ELLIPSIS_TWO_DOTS) || text.toString().contains(ELLIPSIS_NORMAL);
        Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
        float scale = getScale();
        boolean calculateIsRtl = calculateIsRtl(text);
        int i3 = (int) ((fontMetricsInt.descent - fontMetricsInt.ascent) * scale);
        int measuredHeight = (int) (((getMeasuredHeight() - this.mCurrentBounds.top) - i3) + (this.mTitleTranslateOffset * this.collapsingTextHelper.getExpansionFraction()));
        int measuredWidth = (getMeasuredWidth() - this.mIconView.getMeasuredWidth()) - getExpandedTitleMarginEnd();
        if (!z3) {
            measuredWidth = Math.min((int) ((calculateIsRtl ? getMeasuredWidth() - this.mCurrentBounds.right : this.mCurrentBounds.left) + ((int) (this.mTextLayout.getLineWidth(0) * scale))), measuredWidth);
        } else if (!isExpanded()) {
            measuredWidth = (int) (calculateIsRtl ? this.mCurrentBounds.width() + getExpandedTitleMarginStart() : this.mCurrentBounds.right);
        }
        ViewGroup.LayoutParams layoutParams = this.mIconView.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            layoutParams.height = i3;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = measuredHeight;
            marginLayoutParams.setMarginStart(measuredWidth);
            this.mIconView.setLayoutParams(layoutParams);
        }
    }

    public COUICollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUICollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mCollapsedSubtitleMarginTopIfNotHidden = 0;
        this.mToolbarNormalPaddingStart = 0;
        this.mToolbarNormalPaddingEnd = 0;
        this.mFadeModeExpansionFraction = DEFAULT_FADE_MODE_EXPANSION_FRACTION;
        this.mFadeModeExpansionFractionError = DEFAULT_FADE_MODE_EXPANSION_FRACTION_ERROR;
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
        this.mIsAllowFadeInAnimation = false;
        this.mIsAllowFadeOutAnimation = false;
        this.mIsInsideSideNavigationBar = false;
        this.mContentScrimDrawable = new ColorDrawable(0);
        this.mIconViewFirstLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.appbar.COUICollapsingToolbarLayout.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (COUICollapsingToolbarLayout.this.mIconView == null) {
                    return;
                }
                COUICollapsingToolbarLayout.this.mIconView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                COUICollapsingToolbarLayout.this.updateIconViewLocationIfNeed();
            }
        };
        init(attributeSet);
        this.mCollapsedSubtitleMarginTopIfNotHidden = context.getResources().getDimensionPixelOffset(c.f11764j);
        this.mToolbarNormalPaddingStart = getContext().getResources().getDimensionPixelOffset(c.f11774o);
        this.mToolbarNormalPaddingEnd = getContext().getResources().getDimensionPixelOffset(c.f11766k);
        this.mCollapsedTextColor = getCollapsingTextHelper().getCollapsedTextColor();
    }

    @Override // com.google.android.material.appbar.CollapsingToolbarLayout
    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        super.setCollapsedTitleTextColor(colorStateList);
        this.mCollapsedTextColor = colorStateList;
    }

    public void setIconView(View view) {
        View view2 = this.mIconView;
        if (view2 == view) {
            return;
        }
        if (view == null) {
            removeView(view2);
            this.mIconView = null;
        } else {
            this.mIconView = view;
            addIconView();
        }
    }
}
