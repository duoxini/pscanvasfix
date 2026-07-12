package com.coui.appcompat.toolbar;

import M1.g;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.c;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.V;
import androidx.appcompat.widget.Y;
import androidx.appcompat.widget.b0;
import androidx.core.graphics.drawable.a;
import androidx.core.view.AbstractC0256e;
import androidx.core.view.AbstractC0259h;
import androidx.core.view.n;
import androidx.core.view.y;
import androidx.preference.Preference;
import com.coui.appcompat.grid.COUIResponsiveUtils;
import com.coui.appcompat.poplist.f;
import com.coui.appcompat.poplist.l;
import com.coui.appcompat.poplist.s;
import com.coui.appcompat.poplist.t;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import e.AbstractC0339a;
import e0.AbstractC0342a;
import f.AbstractC0348a;
import g.AbstractC0362a;
import g2.AbstractC0368a;
import g2.e;
import g2.h;
import g2.i;
import java.util.ArrayList;
import java.util.List;
import r0.C0560b;
import u0.AbstractC0597a;
import y0.j;

/* loaded from: classes.dex */
public class COUIToolbar extends Toolbar implements t {
    private static final int DEFAULT_TEXT_MAX = 24;
    private static final int DEFAULT_TEXT_MIN = 16;
    private static final String TAG = "Toolbar";
    public static final int TITLE_TYPE_HEAD = 0;
    public static final int TITLE_TYPE_SECONDARY = 1;
    private static final Rect TOOLBAR_OUTSETS = new Rect();
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private int mButtonGravity;
    private ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private final COUIRtlSpacingHelper mContentInsets;
    private Rect mDisplayFrame;
    private View mDummyView;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    private View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private final int mGapBeforeMenuView;
    private int mGapBetweenNavigationAndTitle;
    private int mGapBetweenSearchViewAndMenu;
    private int mGravity;
    private boolean mHasCustomViewBeforeTitle;
    private boolean mHasSearchViewFlag;
    boolean mIsInsidePanel;
    private boolean mIsInsideSideNavigationBar;
    private boolean mIsTiny;
    private boolean mIsTitleCenterStyle;
    private ImageView mLogoView;
    private C0560b mMaskRippleDrawable;
    private int mMaxButtonHeight;
    private MenuBuilder.Callback mMenuBuilderCallback;
    private COUIActionMenuView mMenuView;
    private final ActionMenuView.e mMenuViewItemClickListener;
    private int mMinHeight;
    private ImageButton mNavButtonView;
    private Toolbar.h mOnMenuItemClickListener;
    private Context mPopupContext;
    private boolean mPopupRuleEnable;
    private int mPopupTheme;
    private int mResId;
    private final int[] mSearchCollapsingMargins;
    private int mSectionGap;
    private final int mSectionGapMediumLarge;
    private final int mSectionGapSmall;
    private View mSegmentButton;
    private final int mSegmentButtonHeight;
    private final int mSegmentButtonMaxWidth;
    private final int mSegmentButtonMinWidth;
    private final Runnable mShowOverflowMenuRunnable;
    private int mStyle;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private int mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private View mTextButton;
    private float mTextMaxSize;
    private float mTextMinSize;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private int mTitleMinWidth;
    private int mTitlePaddingBottom;
    private int mTitlePaddingTop;
    private int[] mTitlePosition;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private int mTitleTextColor;
    private final int mTitleTextMinWidth;
    private float mTitleTextSize;
    private TextView mTitleTextView;
    private int mTitleType;
    private int mToolbarCenterTitlePaddingLeft;
    private int mToolbarCenterTitlePaddingRight;
    private int mToolbarHeight;
    private int mToolbarNormalPaddingLeft;
    private int mToolbarNormalPaddingRight;
    private int mToolbarOverFlowPadding;
    private boolean mUseResponsivePadding;
    private Rect mWindowFrame;
    private Y mWrapper;

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;

        private ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            if (COUIToolbar.this.mExpandedActionView instanceof c) {
                ((c) COUIToolbar.this.mExpandedActionView).onActionViewCollapsed();
            }
            COUIToolbar cOUIToolbar = COUIToolbar.this;
            cOUIToolbar.removeView(cOUIToolbar.mExpandedActionView);
            COUIToolbar cOUIToolbar2 = COUIToolbar.this;
            cOUIToolbar2.removeView(cOUIToolbar2.mCollapseButtonView);
            COUIToolbar.this.mExpandedActionView = null;
            COUIToolbar.this.setChildVisibilityForExpandedActionView(false);
            this.mCurrentExpandedItem = null;
            COUIToolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            COUIToolbar.this.ensureCollapseButtonView();
            ViewParent parent = COUIToolbar.this.mCollapseButtonView.getParent();
            COUIToolbar cOUIToolbar = COUIToolbar.this;
            if (parent != cOUIToolbar) {
                cOUIToolbar.addView(cOUIToolbar.mCollapseButtonView);
            }
            COUIToolbar.this.mExpandedActionView = menuItemImpl.getActionView();
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = COUIToolbar.this.mExpandedActionView.getParent();
            COUIToolbar cOUIToolbar2 = COUIToolbar.this;
            if (parent2 != cOUIToolbar2) {
                LayoutParams generateDefaultLayoutParams = cOUIToolbar2.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = (COUIToolbar.this.mButtonGravity & FeedbackActivity.SHOW_NO_NETWORK) | 8388611;
                generateDefaultLayoutParams.mViewType = 2;
                COUIToolbar.this.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                COUIToolbar cOUIToolbar3 = COUIToolbar.this;
                cOUIToolbar3.addView(cOUIToolbar3.mExpandedActionView);
            }
            COUIToolbar.this.setChildVisibilityForExpandedActionView(true);
            COUIToolbar.this.requestLayout();
            menuItemImpl.setActionViewExpanded(true);
            if (COUIToolbar.this.mExpandedActionView instanceof c) {
                ((c) COUIToolbar.this.mExpandedActionView).onActionViewExpanded();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup viewGroup) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (menuBuilder2 != null && (menuItemImpl = this.mCurrentExpandedItem) != null) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
            return subMenuBuilder != null && subMenuBuilder.size() > 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback callback) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean z3) {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                if (menuBuilder != null) {
                    int size = menuBuilder.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (this.mMenu.getItem(i3) == this.mCurrentExpandedItem) {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            }
        }
    }

    public COUIToolbar(Context context) {
        this(context, null);
    }

    private void addCustomCenterViews(List<View> list) {
        int childCount = getChildCount();
        int b3 = AbstractC0256e.b(1, y.x(this));
        list.clear();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == b3) {
                list.add(childAt);
            }
        }
    }

    private void addCustomViewsWithGravity(List<View> list, int i3) {
        boolean z3 = y.x(this) == 1;
        int childCount = getChildCount();
        int b3 = AbstractC0256e.b(i3, y.x(this));
        list.clear();
        if (!z3) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && getChildHorizontalGravity(layoutParams.gravity) == b3) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(layoutParams2.gravity) == b3) {
                list.add(childAt2);
            }
        }
    }

    private void addSystemView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (LayoutParams) layoutParams;
        generateDefaultLayoutParams.mViewType = 1;
        addView(view, generateDefaultLayoutParams);
    }

    private void calculateTitlePosition(int[] iArr) {
        int measuredWidth;
        int i3;
        boolean z3 = y.x(this) == 1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(g2.c.f11754e);
        iArr[0] = Math.max(this.mContentInsets.getLeft(), getPaddingLeft());
        iArr[1] = getMeasuredWidth() - Math.max(this.mContentInsets.getRight(), getPaddingRight());
        if (!shouldLayout(this.mMenuView) || this.mMenuView.getChildCount() == 0) {
            return;
        }
        if (this.mMenuView.getChildCount() == 1) {
            i3 = this.mMenuView.getChildAt(0).getMeasuredWidth() + dimensionPixelSize;
            measuredWidth = 0;
        } else {
            measuredWidth = this.mMenuView.getChildAt(0).getMeasuredWidth() + dimensionPixelSize;
            i3 = 0;
            for (int i4 = 1; i4 < this.mMenuView.getChildCount(); i4++) {
                i3 += this.mMenuView.getChildAt(i4).getMeasuredWidth() + dimensionPixelSize;
            }
        }
        if (z3) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] - measuredWidth;
        } else {
            iArr[0] = iArr[0] + measuredWidth;
            iArr[1] = iArr[1] - i3;
        }
        int max = Math.max(iArr[0], getMeasuredWidth() - iArr[1]) + getResources().getDimensionPixelSize(g2.c.f11742W);
        if (this.mIsInsidePanel || AbstractC0597a.f(this.mTitleTextView, getMeasuredWidth(), max * 2) > 1) {
            return;
        }
        iArr[0] = max;
        iArr[1] = getMeasuredWidth() - max;
    }

    private void calculateToolbarPadding(MenuBuilder menuBuilder, int i3, boolean z3) {
        boolean z4 = true;
        boolean z5 = this.mHasCustomViewBeforeTitle || shouldLayout(this.mNavButtonView);
        if ((menuBuilder == null || (menuBuilder.getNonActionItems().isEmpty() && menuBuilder.getActionItems().isEmpty())) && !z3) {
            z4 = false;
        }
        if (COUIResponsiveUtils.isSmallScreen(getContext(), View.MeasureSpec.getSize(i3))) {
            this.mToolbarNormalPaddingLeft = getContext().getResources().getDimensionPixelOffset(z5 ? g2.c.f11711G0 : g2.c.f11729P0);
            this.mToolbarNormalPaddingRight = z4 ? getContext().getResources().getDimensionPixelOffset(g2.c.f11719K0) : getContext().getResources().getDimensionPixelOffset(g2.c.f11735S0);
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(g2.c.f11791w0);
        } else if (COUIResponsiveUtils.isMediumScreen(getContext(), View.MeasureSpec.getSize(i3), j.j(getContext()))) {
            this.mToolbarNormalPaddingLeft = getContext().getResources().getDimensionPixelOffset(z5 ? g2.c.f11715I0 : g2.c.f11733R0);
            this.mToolbarNormalPaddingRight = z4 ? getContext().getResources().getDimensionPixelOffset(g2.c.f11723M0) : getContext().getResources().getDimensionPixelOffset(g2.c.f11739U0);
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(g2.c.f11795y0);
        } else if (COUIResponsiveUtils.isLargeScreen(getContext(), View.MeasureSpec.getSize(i3), j.j(getContext()))) {
            this.mToolbarNormalPaddingLeft = getContext().getResources().getDimensionPixelOffset(z5 ? g2.c.f11713H0 : g2.c.f11731Q0);
            this.mToolbarNormalPaddingRight = z4 ? getContext().getResources().getDimensionPixelOffset(g2.c.f11721L0) : getContext().getResources().getDimensionPixelOffset(g2.c.f11737T0);
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(g2.c.f11793x0);
        }
        if (this.mIsInsideSideNavigationBar) {
            this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(g2.c.f11795y0);
        }
        this.mToolbarCenterTitlePaddingRight = this.mToolbarCenterTitlePaddingLeft;
        if (this.mIsTiny) {
            this.mToolbarNormalPaddingLeft = z5 ? 0 : getContext().getResources().getDimensionPixelOffset(g2.c.f11725N0);
            this.mToolbarNormalPaddingRight = getContext().getResources().getDimensionPixelOffset(g2.c.f11727O0);
        }
    }

    private void changeBackViewParams() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton == null || !this.mIsTiny) {
            return;
        }
        LayoutParams layoutParams = (LayoutParams) imageButton.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = getContext().getResources().getDimensionPixelOffset(g2.c.f11743X);
        this.mNavButtonView.setLayoutParams(layoutParams);
        this.mNavButtonView.setPadding(0, 0, 0, 0);
    }

    private void changeToolbarPadding(MenuBuilder menuBuilder, ImageButton imageButton, boolean z3, int i3, boolean z4) {
        if (menuBuilder == null && imageButton == null && !z4) {
            return;
        }
        calculateToolbarPadding(menuBuilder, i3, z4);
        if ((menuBuilder == null || (menuBuilder.getNonActionItems().isEmpty() && menuBuilder.getActionItems().isEmpty())) && !z4) {
            if (this.mUseResponsivePadding) {
                int i4 = this.mIsTitleCenterStyle ? this.mToolbarCenterTitlePaddingLeft : this.mToolbarNormalPaddingLeft;
                int i5 = useTextMenuItemPaddingEnd() ? this.mToolbarCenterTitlePaddingRight : this.mToolbarNormalPaddingRight;
                if (z3) {
                    setPadding(i5, getPaddingTop(), i4, getPaddingBottom());
                    return;
                } else {
                    setPadding(i4, getPaddingTop(), i5, getPaddingBottom());
                    return;
                }
            }
            return;
        }
        if (this.mUseResponsivePadding) {
            boolean z5 = this.mIsTitleCenterStyle;
            int i6 = z5 ? this.mToolbarCenterTitlePaddingLeft : this.mToolbarNormalPaddingLeft;
            int i7 = z5 ? this.mToolbarCenterTitlePaddingRight : this.mToolbarNormalPaddingRight;
            if (z3) {
                setPadding(i7, getPaddingTop(), i6, getPaddingBottom());
            } else {
                setPadding(i6, getPaddingTop(), i7, getPaddingBottom());
            }
        }
    }

    private void configNavigationButtonBackground() {
        C0560b c0560b = new C0560b(getContext());
        this.mMaskRippleDrawable = c0560b;
        c0560b.v(C0560b.t(getContext(), 0));
        this.mNavButtonView.setBackground(this.mMaskRippleDrawable);
        AbstractC0342a.b(this.mNavButtonView, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, AbstractC0368a.f11693b, h.f11817f);
            this.mCollapseButtonView = imageButton;
            imageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & FeedbackActivity.SHOW_NO_NETWORK) | 8388611;
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.toolbar.COUIToolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIToolbar.this.collapseActionView();
                }
            });
        }
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new ImageView(getContext());
        }
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() == null) {
            MenuBuilder menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            COUIActionMenuView cOUIActionMenuView = new COUIActionMenuView(getContext());
            this.mMenuView = cOUIActionMenuView;
            cOUIActionMenuView.setId(e.f11805f);
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            if (this.mIsTitleCenterStyle) {
                ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width = -1;
            } else {
                ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).width = -2;
            }
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & FeedbackActivity.SHOW_NO_NETWORK) | 8388613;
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView);
        }
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            ImageButton imageButton = new ImageButton(getContext(), null, AbstractC0368a.f11693b, h.f11817f);
            this.mNavButtonView = imageButton;
            imageButton.setId(e.f11804e);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & FeedbackActivity.SHOW_NO_NETWORK) | 8388611;
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
            configNavigationButtonBackground();
            changeBackViewParams();
        }
    }

    private void ensureTitleTextView() {
        if (this.mTitleTextView == null) {
            Context context = getContext();
            TextView textView = new TextView(context);
            this.mTitleTextView = textView;
            textView.setPaddingRelative(0, this.mTitlePaddingTop, 0, this.mTitlePaddingBottom);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.mTypeTitle = true;
            ((ViewGroup.MarginLayoutParams) generateDefaultLayoutParams).bottomMargin = this.mIsTiny ? 0 : this.mTitleMarginBottom;
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & FeedbackActivity.SHOW_NO_NETWORK) | 8388613;
            this.mTitleTextView.setLayoutParams(generateDefaultLayoutParams);
            this.mTitleTextView.setSingleLine();
            this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
            int i3 = this.mTitleTextAppearance;
            if (i3 != 0) {
                setTitleTextAppearance(context, i3);
            }
            int i4 = this.mTitleTextColor;
            if (i4 != 0) {
                this.mTitleTextView.setTextColor(i4);
            }
            this.mTitleTextView.setTextAlignment(this.mIsTitleCenterStyle ? 4 : 5);
            if (this.mTitleType == 1) {
                this.mTitleTextView.setTextSize(0, AbstractC0597a.e(this.mTitleTextView.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
        }
    }

    private int getChildHorizontalGravity(int i3) {
        int x3 = y.x(this);
        int b3 = AbstractC0256e.b(i3, x3) & 7;
        return (b3 == 1 || b3 == 3 || b3 == 5) ? b3 : x3 == 1 ? 5 : 3;
    }

    private int getChildTop(View view, int i3) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i3 > 0 ? (measuredHeight - i3) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(layoutParams.gravity);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i4;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i4;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i5 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (i5 < i6) {
            i5 = i6;
        } else {
            int i7 = (((height - paddingBottom) - measuredHeight) - i5) - paddingTop;
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i7 < i8) {
                i5 = Math.max(0, i5 - (i8 - i7));
            }
        }
        return paddingTop + i5;
    }

    private int getChildVerticalGravity(int i3) {
        int i4 = i3 & FeedbackActivity.SHOW_NO_NETWORK;
        return (i4 == 16 || i4 == 48 || i4 == 80) ? i4 : this.mGravity & FeedbackActivity.SHOW_NO_NETWORK;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return AbstractC0259h.b(marginLayoutParams) + AbstractC0259h.a(marginLayoutParams);
    }

    private int getMinimumHeightCompat() {
        return y.z(this);
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int i3 = iArr[0];
        int i4 = iArr[1];
        int size = list.size();
        int i5 = 0;
        int i6 = 0;
        while (i5 < size) {
            View view = list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - i3;
            int i8 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - i4;
            int max = Math.max(0, i7);
            int max2 = Math.max(0, i8);
            int max3 = Math.max(0, -i7);
            int max4 = Math.max(0, -i8);
            i6 += max + view.getMeasuredWidth() + max2;
            i5++;
            i4 = max4;
            i3 = max3;
        }
        return i6;
    }

    private boolean isDummyView(View view, LayoutParams layoutParams) {
        if (view == null || view.getClass() != View.class) {
            return false;
        }
        this.mDummyView = view;
        return true;
    }

    private int layoutChildLeft(View view, int i3, int i4, int[] iArr, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = i3 + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        int childTop = getChildTop(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, Math.min(i4, max + measuredWidth), view.getMeasuredHeight() + childTop);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    private int layoutChildRight(View view, int i3, int i4, int[] iArr, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i4 - Math.max(0, i6);
        iArr[1] = Math.max(0, -i6);
        int childTop = getChildTop(view, i5);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(Math.max(i3, max - measuredWidth), childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    private int measureChildCollapseMargins(View view, int i3, int i4, int i5, int i6, int[] iArr) {
        return measureChildCollapseMargins(view, i3, i4, Preference.DEFAULT_ORDER, i5, i6, iArr);
    }

    private void measureChildConstrained(View view, int i3, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void measureChildMaxWidthConstrained(View view, int i3, int i4, int i5, int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i7 >= 0) {
            if (mode != 0) {
                i7 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i7);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
        if (i5 <= 0 || view.getMeasuredWidth() <= i5) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), childMeasureSpec2);
    }

    private void refreshWidthLimits(int i3) {
        if (COUIResponsiveUtils.isSmallScreen(getContext(), i3)) {
            this.mSectionGap = this.mSectionGapSmall;
        } else {
            this.mSectionGap = this.mSectionGapMediumLarge;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType != 2 && childAt != this.mMenuView) {
                childAt.setVisibility(z3 ? 8 : 0);
            }
        }
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void updateChildVisibilityForExpandedActionView(View view) {
        if (((LayoutParams) view.getLayoutParams()).mViewType == 2 || view == this.mMenuView) {
            return;
        }
        view.setVisibility(this.mExpandedActionView != null ? 8 : 0);
    }

    private boolean useTextMenuItemPaddingEnd() {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        return this.mIsTitleCenterStyle || ((cOUIActionMenuView == null || cOUIActionMenuView.getChildCount() != 1 || !(this.mMenuView.getChildAt(0) instanceof COUIActionMenuItemView)) ? false : ((COUIActionMenuItemView) this.mMenuView.getChildAt(0)).isTextMenuItem());
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public void clearMenu() {
        this.mResId = 0;
        getMenu().clear();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void collapseActionView() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.mCurrentExpandedItem;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void dismissPopupMenus() {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null) {
            cOUIActionMenuView.dismissPopupMenus();
        }
    }

    @Override // com.coui.appcompat.poplist.t
    public int getBarrierDirection() {
        if (this.mWindowFrame == null) {
            this.mWindowFrame = new Rect();
        }
        getRootView().getGlobalVisibleRect(this.mWindowFrame);
        return this.mWindowFrame.height() <= getContext().getResources().getDimensionPixelSize(V1.c.f2550q) ? -1 : 1;
    }

    public TextView getCOUITitleTextView() {
        ensureTitleTextView();
        return this.mTitleTextView;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetEnd() {
        return this.mContentInsets.getEnd();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetLeft() {
        return this.mContentInsets.getLeft();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetRight() {
        return this.mContentInsets.getRight();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetStart() {
        return this.mContentInsets.getStart();
    }

    @Override // com.coui.appcompat.poplist.t
    public Rect getDisplayFrame() {
        if (this.mDisplayFrame == null) {
            this.mDisplayFrame = new Rect();
        }
        getGlobalVisibleRect(this.mDisplayFrame);
        return this.mDisplayFrame;
    }

    public boolean getIsTitleCenterStyle() {
        return this.mIsTitleCenterStyle;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public COUIActionMenuView getMenuView() {
        ensureMenuView();
        return this.mMenuView;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Override // com.coui.appcompat.poplist.t
    public Rect getOutsets() {
        return TOOLBAR_OUTSETS;
    }

    public View getOverFlowMenuButton() {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null) {
            return cOUIActionMenuView.getOverFlowMenuButton();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    @Override // com.coui.appcompat.poplist.t
    public boolean getPopupMenuRuleEnabled() {
        return this.mPopupRuleEnable;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public View getTitleView() {
        return this.mTitleTextView;
    }

    @Override // com.coui.appcompat.poplist.t
    public int getType() {
        return 2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i3) {
        super.inflateMenu(i3);
        this.mResId = i3;
        if (this.mMenuView != null) {
            this.mMenuView.clearRedDotInfo();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a3 = n.a(motionEvent);
        if (a3 == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a3 == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (a3 == 10 || a3 == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0458 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x06db  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02fe  */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r22, int r23, int r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 1789
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.toolbar.COUIToolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v0 */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        MenuBuilder menuBuilder;
        boolean z3;
        int i9;
        int i10;
        int max;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        boolean z4;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int size = View.MeasureSpec.getSize(i3);
        refreshWidthLimits(size);
        boolean z5 = y.x(this) == 1;
        if (this.mIsTitleCenterStyle) {
            int[] iArr = this.mTempMargins;
            boolean b3 = b0.b(this);
            int i28 = !b3 ? 1 : 0;
            int contentInsetStart = getContentInsetStart();
            int max2 = Math.max(contentInsetStart, 0);
            iArr[b3 ? 1 : 0] = Math.max(0, contentInsetStart);
            if (shouldLayout(this.mMenuView)) {
                changeToolbarPadding((MenuBuilder) this.mMenuView.getMenu(), null, z5, i3, false);
                measureChildConstrained(this.mMenuView, i3, 0, i4, 0, this.mMaxButtonHeight);
                i20 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
                i22 = Math.max(0, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
                i21 = View.combineMeasuredStates(0, y.y(this.mMenuView));
            } else {
                i20 = 0;
                i21 = 0;
                i22 = 0;
            }
            int contentInsetEnd = getContentInsetEnd();
            int max3 = max2 + Math.max(contentInsetEnd, i20);
            iArr[i28] = Math.max(0, contentInsetEnd - i20);
            if (shouldLayout(this.mExpandedActionView)) {
                max3 += measureChildCollapseMargins(this.mExpandedActionView, i3, max3, i4, 0, iArr);
                i22 = Math.max(i22, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
                i21 = View.combineMeasuredStates(i21, y.y(this.mExpandedActionView));
            }
            int childCount = getChildCount();
            int i29 = 0;
            int i30 = i22;
            int i31 = i21;
            int i32 = i30;
            while (i29 < childCount) {
                View childAt = getChildAt(i29);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt) && !layoutParams.mTypeSegmentButton) {
                    i27 = i29;
                    max3 += measureChildCollapseMargins(childAt, i3, max3, i4, 0, iArr);
                    i32 = Math.max(i32, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                    i31 = View.combineMeasuredStates(i31, y.y(childAt));
                } else {
                    i27 = i29;
                    i32 = i32;
                }
                i29 = i27 + 1;
            }
            int i33 = i32;
            int i34 = this.mTitleMarginTop + this.mTitleMarginBottom;
            if (shouldLayout(this.mTitleTextView)) {
                this.mTitleTextView.getLayoutParams().width = -2;
                this.mTitleTextView.setTextSize(0, this.mTitleTextSize);
                measureChildCollapseMargins(this.mTitleTextView, i3, 0, i4, i34, iArr);
                int measuredWidth = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
                i23 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
                i24 = View.combineMeasuredStates(i31, y.y(this.mTitleTextView));
                i25 = measuredWidth;
            } else {
                i23 = 0;
                i24 = i31;
                i25 = 0;
            }
            if (shouldLayout(this.mSubtitleTextView)) {
                this.mSubtitleTextView.getLayoutParams().width = -2;
                i26 = i23;
                i25 = Math.max(i25, measureChildCollapseMargins(this.mSubtitleTextView, i3, 0, i4, i23 + i34, iArr));
                i24 = View.combineMeasuredStates(i24, y.y(this.mSubtitleTextView));
            } else {
                i26 = i23;
            }
            int max4 = Math.max(i33, i26);
            int paddingLeft = max3 + i25 + getPaddingLeft() + getPaddingRight();
            int paddingTop = max4 + getPaddingTop() + getPaddingBottom();
            int g02 = y.g0(Math.max(paddingLeft, getSuggestedMinimumWidth()), i3, (-16777216) & i24);
            int g03 = y.g0(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, i24 << 16);
            if (shouldCollapse()) {
                g03 = 0;
            }
            setMeasuredDimension(g02, g03);
            calculateTitlePosition(this.mTitlePosition);
            int[] iArr2 = this.mTitlePosition;
            int i35 = iArr2[1] - iArr2[0];
            if (shouldLayout(this.mTitleTextView)) {
                this.mTitleTextView.setMaxWidth(i35);
                measureChildCollapseMargins(this.mTitleTextView, View.MeasureSpec.makeMeasureSpec(i35, Integer.MIN_VALUE), 0, i4, i34, iArr);
            }
            if (shouldLayout(this.mSubtitleTextView)) {
                this.mSubtitleTextView.setMaxWidth(i35);
                measureChildCollapseMargins(this.mSubtitleTextView, View.MeasureSpec.makeMeasureSpec(i35, Integer.MIN_VALUE), 0, i4, i26 + i34, iArr);
                return;
            }
            return;
        }
        int[] iArr3 = this.mTempMargins;
        boolean b4 = b0.b(this);
        boolean z6 = !b4 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView)) {
            changeToolbarPadding(null, this.mNavButtonView, z5, i3, false);
            measureChildConstrained(this.mNavButtonView, i3, 0, i4, 0, this.mMaxButtonHeight);
            i5 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            i7 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            i6 = View.combineMeasuredStates(0, y.y(this.mNavButtonView));
        } else {
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i3, 0, i4, 0, this.mMaxButtonHeight);
            i5 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            i7 = Math.max(i7, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            i6 = View.combineMeasuredStates(i6, y.y(this.mCollapseButtonView));
        }
        int i36 = i6;
        int i37 = i7;
        int contentInsetStart2 = getContentInsetStart();
        int max5 = Math.max(contentInsetStart2, i5);
        iArr3[b4 ? 1 : 0] = Math.max(0, contentInsetStart2 - i5);
        if (shouldLayout(this.mTextButton)) {
            measureChildCollapseMargins(this.mTextButton, i3, max5, i4, 0, iArr3);
            int measuredWidth2 = this.mTextButton.getMeasuredWidth() + getHorizontalMargins(this.mTextButton);
            i37 = Math.max(i37, this.mTextButton.getMeasuredHeight() + getVerticalMargins(this.mTextButton));
            i36 = View.combineMeasuredStates(i36, y.y(this.mTextButton));
            i8 = measuredWidth2;
        } else {
            i8 = 0;
        }
        boolean isSmallScreen = COUIResponsiveUtils.isSmallScreen(getContext(), View.MeasureSpec.getSize(i3));
        if (shouldLayout(this.mMenuView)) {
            menuBuilder = (MenuBuilder) this.mMenuView.getMenu();
            changeToolbarPadding(menuBuilder, this.mNavButtonView, z5, i3, false);
            measureChildConstrained(this.mMenuView, i3, max5, i4, 0, this.mMaxButtonHeight);
            i8 += this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            i37 = Math.max(i37, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            i36 = View.combineMeasuredStates(i36, y.y(this.mMenuView));
        } else {
            menuBuilder = null;
        }
        if (i8 > 0) {
            changeToolbarPadding(null, this.mNavButtonView, z5, i3, true);
            if (!isSmallScreen) {
                i8 += this.mGapBeforeMenuView;
            }
        }
        addCustomViewsWithGravity(this.mTempViews, 8388611);
        this.mHasCustomViewBeforeTitle = (this.mTempViews.isEmpty() || isSmallScreen) ? false : true;
        int size2 = this.mTempViews.size();
        int i38 = 0;
        while (true) {
            if (i38 >= size2) {
                z3 = true;
                break;
            }
            View view = this.mTempViews.get(i38);
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            if (layoutParams2.mViewType != 0 || layoutParams2.mTypeTextButton || layoutParams2.mTypeSegmentButton || isDummyView(view, layoutParams2) || !shouldLayout(view)) {
                i18 = i38;
                i19 = size2;
                if (isDummyView(view, layoutParams2)) {
                    z3 = true;
                    if (this.mTempViews.size() == 1) {
                        this.mHasCustomViewBeforeTitle = false;
                        break;
                    } else {
                        i38 = i18 + 1;
                        size2 = i19;
                    }
                }
            } else {
                i18 = i38;
                i19 = size2;
                max5 += measureChildCollapseMargins(view, i3, max5 + i8, i4, 0, iArr3);
                i37 = Math.max(i37, view.getMeasuredHeight() + getVerticalMargins(view));
                i36 = View.combineMeasuredStates(i36, y.y(view));
            }
            i38 = i18 + 1;
            size2 = i19;
        }
        changeToolbarPadding(menuBuilder, this.mNavButtonView, z5, i3, (this.mHasCustomViewBeforeTitle || i8 > 0) ? z3 : false);
        int i39 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i40 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (!shouldLayout(this.mSegmentButton) || this.mIsTitleCenterStyle) {
            i9 = 0;
        } else {
            if (shouldLayout(this.mTitleTextView)) {
                this.mTitleTextView.getLayoutParams().width = -2;
                this.mTitleTextView.setTextSize(0, this.mTitleTextSize);
                TextPaint paint = this.mTitleTextView.getPaint();
                CharSequence charSequence = this.mTitleText;
                i17 = (int) paint.measureText(charSequence, 0, charSequence.length());
            } else {
                i17 = 0;
            }
            int i41 = (size / 2) - max5;
            if (i17 <= ((i41 - (this.mSegmentButtonMinWidth / 2)) - this.mSectionGap) - getPaddingStart()) {
                int paddingStart = (((i41 - i17) - this.mSectionGap) - getPaddingStart()) * 2;
                measureChildMaxWidthConstrained(this.mSegmentButton, i3, max5, isSmallScreen ? Math.min(paddingStart, this.mSegmentButtonMaxWidth) : paddingStart, i4, this.mSegmentButtonHeight);
            } else {
                measureChildMaxWidthConstrained(this.mSegmentButton, i3, max5, (((i41 - getPaddingStart()) - this.mSectionGap) / 2) * 2, i4, this.mSegmentButtonHeight);
            }
            i9 = this.mSegmentButton.getMeasuredWidth() + getHorizontalMargins(this.mSegmentButton);
            i37 = Math.max(i37, this.mSegmentButton.getMeasuredHeight() + getVerticalMargins(this.mSegmentButton));
            i36 = View.combineMeasuredStates(i36, y.y(this.mSegmentButton));
        }
        int i42 = max5 == 0 ? this.mSectionGap + i8 : max5 + i8 + (this.mSectionGap * 2);
        if (shouldLayout(this.mTitleTextView)) {
            this.mTitleTextView.getLayoutParams().width = -2;
            this.mTitleTextView.setTextSize(0, this.mTitleTextSize);
            TextPaint paint2 = this.mTitleTextView.getPaint();
            CharSequence charSequence2 = this.mTitleText;
            int min = Math.min((int) paint2.measureText(charSequence2, 0, charSequence2.length()), this.mTitleTextMinWidth) + ((this.mHasCustomViewBeforeTitle || shouldLayout(this.mNavButtonView)) ? this.mGapBetweenNavigationAndTitle : 0);
            int i43 = this.mSectionGap;
            i10 = min;
            i42 = Math.max((max5 + min + i43) * 2, (i43 + i8) * 2);
        } else {
            i10 = 0;
        }
        addCustomCenterViews(this.mTempViews);
        int size3 = this.mTempViews.size();
        int i44 = i37;
        int i45 = i36;
        int i46 = 0;
        int i47 = i9;
        int i48 = i42;
        boolean z7 = z6;
        while (i46 < size3) {
            View view2 = this.mTempViews.get(i46);
            LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams3.mViewType != 0 || layoutParams3.mTypeSegmentButton || !shouldLayout(view2) || isDummyView(view2, layoutParams3)) {
                i15 = i46;
                i16 = size3;
                z4 = z7;
                i45 = i45;
                i44 = i44;
            } else {
                i15 = i46;
                z4 = z7;
                i16 = size3;
                i47 += measureChildCollapseMargins(view2, i3, i48, i4, 0, iArr3);
                i48 += i47;
                i44 = Math.max(i44, view2.getMeasuredHeight() + getVerticalMargins(view2));
                i45 = View.combineMeasuredStates(i45, y.y(view2));
            }
            i46 = i15 + 1;
            size3 = i16;
            z7 = z4;
        }
        int i49 = i45;
        ?? r25 = z7;
        int i50 = i44;
        int i51 = size / 2;
        int i52 = (i47 / 2) + i51;
        int paddingStart2 = (this.mSectionGap + i52) - getPaddingStart();
        int paddingEnd = (i52 + this.mSectionGap) - getPaddingEnd();
        int contentInsetEnd2 = getContentInsetEnd();
        if (i47 > 0) {
            if (!z5) {
                paddingStart2 = paddingEnd;
            }
            max = max5 + paddingStart2;
        } else {
            max = max5 + Math.max(contentInsetEnd2, i8) + this.mSectionGap;
        }
        iArr3[r25] = Math.max(0, contentInsetEnd2 - i8);
        if (shouldLayout(this.mExpandedActionView)) {
            max += measureChildCollapseMargins(this.mExpandedActionView, i3, max, i4, 0, iArr3);
            int max6 = Math.max(i50, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            i49 = View.combineMeasuredStates(i49, y.y(this.mExpandedActionView));
            i50 = max6;
        }
        if (shouldLayout(this.mLogoView)) {
            max += measureChildCollapseMargins(this.mLogoView, i3, max, i4, 0, iArr3);
            i50 = Math.max(i50, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            i49 = View.combineMeasuredStates(i49, y.y(this.mLogoView));
        }
        addCustomViewsWithGravity(this.mTempViews, 8388613);
        int size4 = this.mTempViews.size();
        int paddingEnd2 = i47 > 0 ? ((i51 - (((this.mSectionGap * 2) + i47) / 2)) - getPaddingEnd()) - i8 : (((size - max) - i10) - getPaddingEnd()) - getPaddingStart();
        int i53 = i49;
        for (int i54 = 0; i54 < size4; i54++) {
            View view3 = this.mTempViews.get(i54);
            LayoutParams layoutParams4 = (LayoutParams) view3.getLayoutParams();
            if (layoutParams4.mViewType == 0 && !layoutParams4.mTypeSegmentButton && !layoutParams4.mTypeTextButton && shouldLayout(view3) && !isDummyView(view3, layoutParams4)) {
                int measureChildCollapseMargins = measureChildCollapseMargins(view3, i3, max + i10, paddingEnd2, i4, 0, iArr3);
                if (i47 == 0) {
                    max += measureChildCollapseMargins;
                }
                i50 = Math.max(i50, view3.getMeasuredHeight() + getVerticalMargins(view3));
                i53 = View.combineMeasuredStates(i53, y.y(view3));
            }
        }
        if (shouldLayout(this.mDummyView)) {
            measureChildCollapseMargins(this.mDummyView, i3, max, i4, i39, iArr3);
            max += this.mDummyView.getMeasuredWidth() + getHorizontalMargins(this.mDummyView);
        }
        if (shouldLayout(this.mTitleTextView)) {
            this.mTitleTextView.getLayoutParams().width = -1;
            i11 = 0;
            this.mTitleTextView.setTextSize(0, this.mTitleTextSize);
            measureChildCollapseMargins(this.mTitleTextView, i3, max + i40 + ((this.mHasCustomViewBeforeTitle || shouldLayout(this.mNavButtonView)) ? this.mGapBetweenNavigationAndTitle : 0), i4, i39, iArr3);
            int measuredWidth3 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            int measuredHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            i12 = measuredWidth3;
            i13 = View.combineMeasuredStates(i53, y.y(this.mTitleTextView));
            i14 = measuredHeight;
        } else {
            i11 = 0;
            i12 = 0;
            i13 = i53;
            i14 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            this.mSubtitleTextView.getLayoutParams().width = -1;
            i12 = Math.max(i12, measureChildCollapseMargins(this.mSubtitleTextView, i3, max + i40 + ((this.mHasCustomViewBeforeTitle || shouldLayout(this.mNavButtonView)) ? this.mGapBetweenNavigationAndTitle : i11), i4, i14 + i39, iArr3));
            i14 += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            i13 = View.combineMeasuredStates(i13, y.y(this.mSubtitleTextView));
        }
        setMeasuredDimension(y.g0(Math.max(max + i12 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, (-16777216) & i13), shouldCollapse() ? i11 : y.g0(Math.max(Math.max(i50, i14) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i13 << 16));
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        COUIRtlSpacingHelper cOUIRtlSpacingHelper = this.mContentInsets;
        if (cOUIRtlSpacingHelper != null) {
            cOUIRtlSpacingHelper.setDirection(i3 == 1);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a3 = n.a(motionEvent);
        if (a3 == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a3 == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (a3 == 1 || a3 == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    public void refresh() {
        int i3;
        int i4;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, e.j.f11356a, AbstractC0339a.f11088c, 0);
        setOverflowIcon(getResources().getDrawable(g.f1477k, getContext().getTheme()));
        Drawable drawable = obtainStyledAttributes.getDrawable(e.j.f11400l);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        C0560b c0560b = this.mMaskRippleDrawable;
        if (c0560b != null) {
            c0560b.u(getContext());
        }
        if (this.mMenuView != null) {
            COUIActionMenuView cOUIActionMenuView = this.mMenuView;
            f fVar = cOUIActionMenuView.mOverflowPopup;
            if (fVar != null && fVar.isShowing()) {
                cOUIActionMenuView.mOverflowPopup.dismiss();
            }
            cOUIActionMenuView.mOverflowPopup = null;
        }
        if (this.mTitleTextView != null && this.mTitleTextAppearance != 0) {
            setTitleTextAppearance(getContext(), this.mTitleTextAppearance);
        }
        TextView textView = this.mTitleTextView;
        if (textView != null && (i4 = this.mTitleTextColor) != 0) {
            textView.setTextColor(i4);
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null && this.mSubtitleTextAppearance != 0) {
            textView2.setTextAppearance(getContext(), this.mSubtitleTextAppearance);
        }
        TextView textView3 = this.mSubtitleTextView;
        if (textView3 != null && (i3 = this.mSubtitleTextColor) != 0) {
            textView3.setTextColor(i3);
        }
        if (this.mResId != 0) {
            getMenu().clear();
            inflateMenu(this.mResId);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setCollapsible(boolean z3) {
        this.mCollapsible = z3;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsAbsolute(int i3, int i4) {
        this.mContentInsets.setAbsolute(i3, i4);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsRelative(int i3, int i4) {
        this.mContentInsets.setRelative(i3, i4);
    }

    @Deprecated
    public void setEnableAddExtraWidth(boolean z3) {
    }

    @Deprecated
    public void setIsFixTitleFontSize(boolean z3) {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null) {
            cOUIActionMenuView.setIsFixTitleFontSize(z3);
        } else {
            Log.e(TAG, "setIsFixTitleFontSize when mMenuView is null");
        }
    }

    public void setIsInsideSideNavigationBar(boolean z3) {
        if (this.mIsInsideSideNavigationBar != z3) {
            this.mIsInsideSideNavigationBar = z3;
            requestLayout();
        }
    }

    public void setIsTitleCenterStyle(boolean z3) {
        ensureMenuView();
        this.mIsTitleCenterStyle = z3;
        LayoutParams layoutParams = (LayoutParams) this.mMenuView.getLayoutParams();
        boolean z4 = this.mIsTitleCenterStyle;
        if (z4) {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        }
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAlignment(z4 ? 4 : 5);
        }
        this.mMenuView.setLayoutParams(layoutParams);
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(int i3) {
        setLogo(AbstractC0348a.b(getContext(), i3));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(int i3) {
        setLogoDescription(getContext().getText(i3));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setMenuViewColor(int i3) {
        Drawable overflowIcon;
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView == null || (overflowIcon = cOUIActionMenuView.getOverflowIcon()) == null || (overflowIcon instanceof AbstractC0362a)) {
            return;
        }
        a.h(overflowIcon, i3);
        this.mMenuView.setOverflowIcon(overflowIcon);
    }

    public void setMinTitleTextSize(float f3) {
        float f4 = this.mTextMaxSize;
        if (f3 > f4) {
            f3 = f4;
        }
        this.mTextMinSize = f3;
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        this.mMinHeight = i3;
        super.setMinimumHeight(i3);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(int i3) {
        setNavigationContentDescription(i3 != 0 ? getContext().getText(i3) : null);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(int i3) {
        setNavigationIcon(AbstractC0348a.b(getContext(), i3));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOnMenuItemClickListener(Toolbar.h hVar) {
        this.mOnMenuItemClickListener = hVar;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupMenuRuleEnabled(boolean z3) {
        this.mPopupRuleEnable = z3;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setPopupTheme(int i3) {
        if (this.mPopupTheme != i3) {
            this.mPopupTheme = i3;
            if (i3 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i3);
            }
        }
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        if (this.mMenuView != null) {
            this.mMenuView.setPopupWindowOnDismissListener(onDismissListener);
        }
    }

    public void setRedDot(int i3, int i4) {
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView == null) {
            Log.e(TAG, "The COUIActionMenuView is null");
        } else {
            cOUIActionMenuView.setRedDot(i3, i4);
        }
    }

    public void setSearchView(View view) {
        setSearchView(view, view != null ? view.getLayoutParams() == null ? new LayoutParams(new LayoutParams(-1, this.mToolbarHeight)) : new LayoutParams(view.getLayoutParams()) : null);
    }

    public void setSegmentButtons(View view) {
        View view2 = this.mSegmentButton;
        if (view2 != null) {
            removeView(view2);
        }
        if (view != null) {
            setSegmentButtons(view, view.getLayoutParams() == null ? new LayoutParams(new LayoutParams(-2, this.mSegmentButtonHeight)) : new LayoutParams(view.getLayoutParams()));
        } else {
            this.mSegmentButton = null;
        }
    }

    @Deprecated
    public void setSubMenuList(ArrayList<s> arrayList, int i3, l lVar) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(int i3) {
        setSubtitle(getContext().getText(i3));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextAppearance(Context context, int i3) {
        this.mSubtitleTextAppearance = i3;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextColor(int i3) {
        this.mSubtitleTextColor = i3;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public void setTextButton(View view) {
        View view2 = this.mTextButton;
        if (view2 != null) {
            removeView(view2);
        }
        if (view != null) {
            setTextButton(view, view.getLayoutParams() == null ? new LayoutParams(new LayoutParams(-2, -2)) : new LayoutParams(view.getLayoutParams()));
        } else {
            this.mTextButton = null;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(int i3) {
        setTitle(getContext().getText(i3));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleMarginStart(int i3) {
        this.mTitleMarginStart = i3;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextAppearance(Context context, int i3) {
        this.mTitleTextAppearance = i3;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i3);
            if (this.mTitleType == 1) {
                this.mTitleTextView.setTextSize(0, AbstractC0597a.e(this.mTitleTextView.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.minHeight});
            if (obtainStyledAttributes != null) {
                this.mTitleTextView.setMinHeight(obtainStyledAttributes.getDimensionPixelSize(0, 0));
                obtainStyledAttributes.recycle();
            }
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.lineSpacingMultiplier});
            if (obtainStyledAttributes2 != null) {
                float f3 = obtainStyledAttributes2.getFloat(0, 1.4f);
                TextView textView2 = this.mTitleTextView;
                textView2.setLineSpacing(textView2.getLineSpacingExtra(), f3);
                obtainStyledAttributes2.recycle();
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.textAlignment});
            if (obtainStyledAttributes3 != null) {
                int integer = obtainStyledAttributes3.getInteger(0, 5);
                if (integer >= 0) {
                    this.mTitleTextView.setTextAlignment(integer);
                }
                obtainStyledAttributes3.recycle();
            }
            TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.maxLines});
            if (obtainStyledAttributes4 != null) {
                int integer2 = obtainStyledAttributes4.getInteger(0, 1);
                if (integer2 >= 1) {
                    this.mTitleTextView.setSingleLine(false);
                    this.mTitleTextView.setMaxLines(integer2);
                }
                obtainStyledAttributes4.recycle();
            }
            this.mTextMaxSize = this.mTitleTextView.getTextSize();
            this.mTitleTextSize = this.mTitleTextView.getTextSize();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextColor(int i3) {
        this.mTitleTextColor = i3;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i3);
        }
    }

    public void setTitleTextSize(float f3) {
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextSize(f3);
            this.mTitleTextSize = TypedValue.applyDimension(1, f3, getResources().getDisplayMetrics());
        }
    }

    public void setTitleTextViewTypeface(Typeface typeface) {
        ensureTitleTextView();
        this.mTitleTextView.setTypeface(typeface);
    }

    public void setUseResponsivePadding(boolean z3) {
        this.mUseResponsivePadding = z3;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public boolean showOverflowMenu() {
        return (this.mMenuView == null || this.mMenuView.getWindowToken() == null) ? super.showOverflowMenu() : this.mMenuView.showOverflowMenu();
    }

    public void tintNavigationIconDrawable(int i3) {
        Drawable drawable;
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton == null || (drawable = imageButton.getDrawable()) == null || (drawable instanceof AbstractC0362a)) {
            return;
        }
        a.h(drawable, i3);
    }

    public COUIToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11085N);
    }

    private int measureChildCollapseMargins(View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        boolean z3;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i8 = marginLayoutParams.leftMargin - iArr[0];
        boolean z4 = true;
        int i9 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i8) + Math.max(0, i9);
        iArr[0] = Math.max(0, -i8);
        iArr[1] = Math.max(0, -i9);
        if (marginLayoutParams instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) marginLayoutParams;
            z3 = layoutParams.mTypeSearch && this.mHasSearchViewFlag;
            if (!layoutParams.mTypeTitle || !this.mIsTitleCenterStyle) {
                z4 = false;
            }
        } else {
            z3 = false;
            z4 = false;
        }
        int childMeasureSpec = (z3 || z4) ? ViewGroup.getChildMeasureSpec(i3, max, marginLayoutParams.width) : ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + max + i4, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i7, marginLayoutParams.height);
        view.measure(childMeasureSpec, childMeasureSpec2);
        if (!z3) {
            if (view.getMeasuredWidth() > i5) {
                view.measure(View.MeasureSpec.makeMeasureSpec(Math.max(i5, 0), 1073741824), childMeasureSpec2);
            }
            return view.getMeasuredWidth() + max;
        }
        COUIActionMenuView cOUIActionMenuView = this.mMenuView;
        if (cOUIActionMenuView != null && cOUIActionMenuView.getVisibility() != 8) {
            view.measure(ViewGroup.getChildMeasureSpec(i3, max, ((view.getMeasuredWidth() - this.mMenuView.getMeasuredWidth()) - (this.mMenuView.getMeasuredWidth() != 0 ? getPaddingEnd() : 0)) - this.mGapBetweenSearchViewAndMenu), childMeasureSpec2);
        }
        return max;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (this.mLogoView.getParent() == null) {
                addSystemView(this.mLogoView);
                updateChildVisibilityForExpandedActionView(this.mLogoView);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && imageView.getParent() != null) {
                removeView(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (this.mNavButtonView.getParent() == null) {
                addSystemView(this.mNavButtonView);
                updateChildVisibilityForExpandedActionView(this.mNavButtonView);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && imageButton.getParent() != null) {
                removeView(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && textView.getParent() != null) {
                removeView(this.mSubtitleTextView);
            }
        } else {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new TextView(context);
                LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
                generateDefaultLayoutParams.mTypeTitle = true;
                this.mSubtitleTextView.setLayoutParams(generateDefaultLayoutParams);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i3 = this.mSubtitleTextAppearance;
                if (i3 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i3);
                }
                int i4 = this.mSubtitleTextColor;
                if (i4 != 0) {
                    this.mSubtitleTextView.setTextColor(i4);
                }
            }
            if (this.mSubtitleTextView.getParent() == null) {
                addSystemView(this.mSubtitleTextView);
                updateChildVisibilityForExpandedActionView(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setTextAlignment(5);
            this.mSubtitleTextView.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            TextView textView = this.mTitleTextView;
            if (textView != null && textView.getParent() != null) {
                removeView(this.mTitleTextView);
            }
        } else {
            ensureTitleTextView();
            if (this.mTitleTextView.getParent() == null) {
                addSystemView(this.mTitleTextView);
                updateChildVisibilityForExpandedActionView(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
            this.mTitleTextSize = this.mTitleTextView.getTextSize();
        }
        this.mTitleText = charSequence;
    }

    public COUIToolbar(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, h.f11816e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public COUIToolbar(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        int i5;
        COUIRtlSpacingHelper cOUIRtlSpacingHelper = new COUIRtlSpacingHelper();
        this.mContentInsets = cOUIRtlSpacingHelper;
        this.mTempViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.e() { // from class: com.coui.appcompat.toolbar.COUIToolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (COUIToolbar.this.mOnMenuItemClickListener != null) {
                    return COUIToolbar.this.mOnMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.mSearchCollapsingMargins = new int[2];
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: com.coui.appcompat.toolbar.COUIToolbar.2
            @Override // java.lang.Runnable
            public void run() {
                COUIToolbar.this.showOverflowMenu();
            }
        };
        this.mDisplayFrame = null;
        this.mWindowFrame = null;
        this.mHasCustomViewBeforeTitle = false;
        this.mGravity = 8388627;
        this.mIsTitleCenterStyle = false;
        this.mTitlePosition = new int[2];
        this.mTitleTextSize = 0.0f;
        this.mHasSearchViewFlag = false;
        this.mIsInsideSideNavigationBar = false;
        this.mPopupRuleEnable = true;
        this.mUseResponsivePadding = true;
        this.mDummyView = null;
        setClipToPadding(false);
        setClipChildren(false);
        if (attributeSet != null) {
            int styleAttribute = attributeSet.getStyleAttribute();
            this.mStyle = styleAttribute;
            if (styleAttribute == 0) {
                this.mStyle = i3;
            }
        } else {
            this.mStyle = 0;
        }
        V w3 = V.w(getContext(), attributeSet, i.f11869y, AbstractC0368a.f11694c, i4);
        if (w3.s(i.f11845a0)) {
            this.mTitleType = w3.k(i.f11845a0, 0);
        }
        this.mTitleTextAppearance = w3.n(i.f11842Y, 0);
        this.mSubtitleTextAppearance = w3.n(i.f11833P, 0);
        this.mGravity = w3.l(i.f11870z, this.mGravity);
        this.mButtonGravity = w3.l(i.f11819B, 48);
        this.mTitleMarginStart = w3.e(i.f11839V, 0);
        this.mIsTiny = w3.a(i.f11826I, false);
        this.mIsInsidePanel = w3.a(i.f11830M, false);
        int i6 = this.mTitleMarginStart;
        this.mTitleMarginEnd = i6;
        this.mTitleMarginTop = i6;
        this.mTitleMarginBottom = i6;
        int e3 = w3.e(i.f11837T, getContext().getResources().getDimensionPixelSize(g2.c.f11777p0));
        if (e3 >= 0) {
            this.mTitleMarginStart = e3;
        }
        int e4 = w3.e(i.f11836S, -1);
        if (e4 >= 0) {
            this.mTitleMarginEnd = e4;
        }
        int e5 = w3.e(i.f11838U, -1);
        if (e5 >= 0) {
            this.mTitleMarginTop = e5;
        }
        int e6 = w3.e(i.f11835R, -1);
        if (e6 >= 0) {
            this.mTitleMarginBottom = e6;
        }
        this.mTitlePaddingTop = w3.f(i.f11841X, 0);
        this.mTitlePaddingBottom = w3.f(i.f11840W, 0);
        this.mMaxButtonHeight = w3.f(i.f11827J, -1);
        int e7 = w3.e(i.f11825H, Integer.MIN_VALUE);
        int e8 = w3.e(i.f11822E, Integer.MIN_VALUE);
        cOUIRtlSpacingHelper.setAbsolute(w3.f(i.f11823F, 0), w3.f(i.f11824G, 0));
        if (e7 != Integer.MIN_VALUE || e8 != Integer.MIN_VALUE) {
            cOUIRtlSpacingHelper.setRelative(e7, e8);
        }
        this.mCollapseIcon = w3.g(i.f11821D);
        this.mCollapseDescription = w3.p(i.f11820C);
        CharSequence p3 = w3.p(i.f11834Q);
        if (!TextUtils.isEmpty(p3)) {
            setTitle(p3);
        }
        CharSequence p4 = w3.p(i.f11832O);
        if (!TextUtils.isEmpty(p4)) {
            setSubtitle(p4);
        }
        this.mPopupContext = getContext();
        setPopupTheme(w3.n(i.f11831N, 0));
        Drawable g3 = w3.g(i.f11829L);
        if (g3 != null) {
            setNavigationIcon(g3);
        }
        CharSequence p5 = w3.p(i.f11828K);
        if (!TextUtils.isEmpty(p5)) {
            setNavigationContentDescription(p5);
        }
        this.mMinHeight = w3.f(e.j.f3, 0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (w3.s(i.f11818A)) {
            this.mTextMinSize = w3.f(i.f11818A, (int) (displayMetrics.scaledDensity * 16.0f));
        } else {
            this.mTextMinSize = displayMetrics.scaledDensity * 16.0f;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(this.mTitleTextAppearance, new int[]{R.attr.textSize});
        if (obtainStyledAttributes != null) {
            this.mTextMaxSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) (displayMetrics.scaledDensity * 24.0f));
            obtainStyledAttributes.recycle();
        }
        if (this.mTitleType == 1) {
            this.mTextMaxSize = AbstractC0597a.e(this.mTextMaxSize, getResources().getConfiguration().fontScale, 2);
            this.mTextMinSize = AbstractC0597a.e(this.mTextMinSize, getResources().getConfiguration().fontScale, 2);
        }
        this.mSegmentButtonMaxWidth = getContext().getResources().getDimensionPixelSize(g2.c.f11773n0);
        this.mSegmentButtonMinWidth = getContext().getResources().getDimensionPixelSize(g2.c.f11775o0);
        this.mSectionGapMediumLarge = getContext().getResources().getDimensionPixelSize(g2.c.f11769l0);
        this.mSectionGapSmall = getContext().getResources().getDimensionPixelSize(g2.c.f11771m0);
        this.mTitleTextMinWidth = getContext().getResources().getDimensionPixelSize(g2.c.f11785t0);
        this.mToolbarHeight = getContext().getResources().getDimensionPixelSize(g2.c.f11707E0);
        this.mSegmentButtonHeight = getContext().getResources().getDimensionPixelSize(g2.c.f11789v0);
        this.mToolbarNormalPaddingLeft = getContext().getResources().getDimensionPixelOffset(g2.c.f11709F0);
        this.mGapBeforeMenuView = getContext().getResources().getDimensionPixelSize(g2.c.f11744Y);
        if (this.mIsTiny) {
            this.mToolbarNormalPaddingRight = getContext().getResources().getDimensionPixelOffset(g2.c.f11727O0);
            changeBackViewParams();
        } else {
            this.mToolbarNormalPaddingRight = getContext().getResources().getDimensionPixelOffset(g2.c.f11717J0);
        }
        this.mToolbarCenterTitlePaddingLeft = getContext().getResources().getDimensionPixelOffset(g2.c.f11797z0);
        this.mToolbarCenterTitlePaddingRight = getContext().getResources().getDimensionPixelOffset(g2.c.f11699A0);
        this.mToolbarOverFlowPadding = getContext().getResources().getDimensionPixelOffset(g2.c.f11741V0);
        this.mTitleMinWidth = getContext().getResources().getDimensionPixelOffset(g2.c.f11783s0);
        this.mGapBetweenSearchViewAndMenu = getContext().getResources().getDimensionPixelOffset(g2.c.f11747a0);
        this.mGapBetweenNavigationAndTitle = getContext().getResources().getDimensionPixelOffset(g2.c.f11745Z);
        if (w3.s(i.f11843Z)) {
            this.mIsTitleCenterStyle = w3.a(i.f11843Z, false);
        }
        TextView textView = this.mSubtitleTextView;
        if (textView != null && (i5 = this.mSubtitleTextAppearance) != 0) {
            textView.setTextAppearance(context, i5);
        }
        setWillNotDraw(false);
        w3.x();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends Toolbar.g {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        boolean mTypeSearch;
        boolean mTypeSegmentButton;
        boolean mTypeTextButton;
        boolean mTypeTitle;
        int mViewType;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
            this.gravity = 8388627;
        }

        public LayoutParams(int i3, int i4, int i5) {
            super(i3, i4);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
            this.gravity = i5;
        }

        public LayoutParams(int i3) {
            this(-2, -1, i3);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((Toolbar.g) layoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
            this.mViewType = layoutParams.mViewType;
        }

        public LayoutParams(a.C0054a c0054a) {
            super(c0054a);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
            copyMarginsFromCompat(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mViewType = 0;
            this.mTypeSearch = false;
            this.mTypeTitle = false;
            this.mTypeSegmentButton = false;
            this.mTypeTextButton = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof a.C0054a) {
            return new LayoutParams((a.C0054a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public void setSearchView(View view, LayoutParams layoutParams) {
        if (view == null) {
            this.mHasSearchViewFlag = false;
            return;
        }
        this.mHasSearchViewFlag = true;
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.mTypeSearch = true;
        layoutParams2.mViewType = 0;
        addView(view, 0, layoutParams2);
    }

    private void setSegmentButtons(View view, LayoutParams layoutParams) {
        this.mSegmentButton = view;
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.mViewType = 0;
        layoutParams2.mTypeSegmentButton = true;
        layoutParams2.gravity = 1;
        addView(view, 0, layoutParams2);
    }

    private void setTextButton(View view, LayoutParams layoutParams) {
        this.mTextButton = view;
        LayoutParams layoutParams2 = new LayoutParams(layoutParams);
        layoutParams2.mViewType = 0;
        layoutParams2.mTypeTextButton = true;
        layoutParams2.gravity = 8388613;
        addView(view, layoutParams2);
    }
}
