package com.coui.appcompat.toolbar;

import M1.l;
import Z1.d;
import Z1.e;
import Z1.g;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Z;
import androidx.appcompat.widget.b0;
import androidx.core.view.y;
import com.coui.appcompat.poplist.f;
import com.coui.appcompat.poplist.s;
import d0.AbstractC0335a;
import e.h;
import e0.AbstractC0342a;
import g2.c;
import h0.AbstractC0371a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k0.C0421a;
import m.C0451a;
import r0.C0560b;
import u0.AbstractC0597a;
import y0.EnumC0643a;
import y0.j;

/* loaded from: classes.dex */
public class COUIActionMenuView extends ActionMenuView {
    private static final String EMPTY_TITLE = "";
    private static final int HUNDRED = 100;
    private static final int MAX_TEXT_MENU_ITEM_LINE = 2;
    private static final String OVER_FLOW_MENU_CLASS = "androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton";
    private static final String TAG = "COUIActionMenuView";
    private static final int TEN = 10;
    private EnumC0643a mBlurMinAnimLevel;
    private int mEdgeIconItemMargin;
    private int mEdgeTextItemMargin;
    private boolean mEnableAddExtraWidth;
    private C0421a mHintRedDotHelper;
    private int mIconItemHorOffset;
    private boolean mIsFixTitleFontSize;
    private boolean mIsSameSide;
    private int mItemSpacing;
    private C0451a mItemSpecialColorMap;
    private int mItemVerOffset;
    private C0560b mMaskRippleDrawable;
    private MenuBuilder mMenu;
    private int mMenuIconBgRadius;
    private int mMenuIconTopPadding;
    private MenuItemImpl mMenuItem;
    private int mMenuViewPadding;
    private int mNonActionRedDotCount;
    private int mNonActionRedDotSum;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private AdapterView.OnItemClickListener mOnSubMenuItemClickListener;
    private final OpenOverflowRunnable mOpenOverflowRunnable;
    private String mOverFlowButtonDescription;
    private int mOverFlowHorPadding;
    private View mOverFlowMenuButton;
    private int mOverFlowMinWidth;
    private ArrayList<s> mOverflowItems;
    private OverflowMenuListener mOverflowMenuListener;
    public f mOverflowPopup;
    private List<Class<?>> mPresenterClasses;
    private String mRedDotDescription;
    private int mRedDotHorizontalOffset;
    private HashMap<Integer, Integer> mRedDotMap;
    private int mRedDotVerticalOffset;
    private int mRedDotWithBigNumberHorizontalOffset;
    private int mRedDotWithNumberDescriptionId;
    private int mRedDotWithNumberHorizontalOffset;
    private int mRedDotWithNumberVerticalOffset;
    private int mRedDotWithSmallNumberHorizontalOffset;
    private C0451a mSubItemSpecialColorMap;
    private ArrayList<s> mSubMenuList;
    private int mSubPosition;
    private int mTextExtarPadding;
    private int mTextMenuItemHorizontalPadding;
    private int mTextMenuItemMaxWidth;
    private int mToolbarTitleMinWidth;
    private boolean mUseBackgroundBlur;

    private class OpenOverflowRunnable implements Runnable {
        private OpenOverflowRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar;
            if (COUIActionMenuView.this.mMenu != null) {
                COUIActionMenuView.this.mMenu.changeMenuMode();
            }
            if (COUIActionMenuView.this.getWindowToken() == null || (fVar = COUIActionMenuView.this.mOverflowPopup) == null || fVar.isShowing()) {
                return;
            }
            COUIActionMenuView cOUIActionMenuView = COUIActionMenuView.this;
            cOUIActionMenuView.mOverflowPopup.u0(cOUIActionMenuView.mOverFlowMenuButton, COUIActionMenuView.this.mOverFlowMenuButton.getWidth() / 2, COUIActionMenuView.this.mOverFlowMenuButton.getHeight());
        }
    }

    public interface OverflowMenuListener {
        void onOverflowMenuPreShow(f fVar);
    }

    public COUIActionMenuView(Context context) {
        this(context, null);
    }

    private void configOverflowIconBackground() {
        C0560b c0560b = new C0560b(getContext());
        this.mMaskRippleDrawable = c0560b;
        c0560b.v(C0560b.t(getContext(), 0));
        this.mOverFlowMenuButton.setBackground(this.mMaskRippleDrawable);
        AbstractC0342a.b(this.mOverFlowMenuButton, false);
    }

    private void drawRedDot(View view, int i3, Canvas canvas) {
        int i4;
        int i5;
        float f3;
        float f4;
        float y3;
        float f5;
        float f6;
        float f7;
        int i6 = i3 != -1 ? i3 != 0 ? 2 : 1 : 0;
        if (view != null) {
            int o3 = this.mHintRedDotHelper.o(i6, i3);
            int n3 = this.mHintRedDotHelper.n(i6);
            if (i6 == 1) {
                i4 = this.mRedDotHorizontalOffset;
                i5 = this.mRedDotVerticalOffset;
            } else if (i3 < 10) {
                i4 = this.mRedDotWithSmallNumberHorizontalOffset;
                i5 = this.mRedDotWithNumberVerticalOffset;
            } else if (i3 < HUNDRED) {
                i4 = this.mRedDotWithNumberHorizontalOffset;
                i5 = this.mRedDotWithNumberVerticalOffset;
            } else {
                i4 = this.mRedDotWithBigNumberHorizontalOffset;
                i5 = this.mRedDotWithNumberVerticalOffset;
            }
            RectF rectF = new RectF();
            if ((view instanceof ActionMenuItemView) && ((ActionMenuItemView) view).getItemData().getIcon() == null) {
                if (isLayoutRTL()) {
                    f6 = (view.getX() + i4) - this.mMenuViewPadding;
                    f7 = f6 - o3;
                } else {
                    f7 = ((view.getX() + view.getWidth()) - i4) + this.mMenuViewPadding;
                    f6 = o3 + f7;
                }
                y3 = (this.mMenuIconTopPadding - i5) + this.mItemVerOffset;
                f5 = n3 + y3;
            } else {
                if (isLayoutRTL()) {
                    f3 = (view.getX() + ((view.getWidth() - this.mMenuIconBgRadius) / 2)) - i4;
                    f4 = o3 + f3;
                } else {
                    float x3 = ((view.getX() + view.getWidth()) - ((view.getWidth() - this.mMenuIconBgRadius) / 2)) + i4;
                    f3 = x3 - o3;
                    f4 = x3;
                }
                y3 = (view.getY() + ((view.getHeight() - this.mMenuIconBgRadius) / 2)) - i5;
                f5 = y3 + n3;
                f6 = f4;
                f7 = f3;
            }
            rectF.left = f7;
            rectF.top = y3;
            rectF.right = f6;
            rectF.bottom = f5;
            this.mHintRedDotHelper.g(canvas, i6, Integer.valueOf(i3), rectF);
        }
    }

    private void ensureOverflowMenu() {
        if (this.mOverflowPopup == null) {
            Context context = getContext();
            if (!AbstractC0335a.k(context)) {
                Configuration configuration = getContext().getResources().getConfiguration();
                configuration.densityDpi = getContext().getResources().getDisplayMetrics().densityDpi;
                context = new ContextThemeWrapper(getContext().createConfigurationContext(configuration), l.f1502b);
            }
            f fVar = new f(context);
            this.mOverflowPopup = fVar;
            fVar.t0(this.mUseBackgroundBlur, this.mBlurMinAnimLevel);
            this.mOverflowPopup.setInputMethodMode(2);
            this.mOverflowPopup.setOnDismissListener(this.mOnDismissListener);
            this.mOverflowItems = new ArrayList<>();
        }
    }

    private boolean isLayoutRTL() {
        return y.x(this) == 1;
    }

    private int measureChild(int i3, int i4) {
        int measureChildCollapseMargins;
        int i5 = 0;
        if (!shouldUseStrictTextMeasure()) {
            int i6 = 0;
            while (i5 < getChildCount()) {
                i6 += measureChildCollapseMargins(getChildAt(i5), i3, i6, i4, 0);
                i5++;
            }
            return i6;
        }
        int size = View.MeasureSpec.getSize(i3);
        int i7 = this.mToolbarTitleMinWidth;
        while (i5 < getChildCount()) {
            View childAt = getChildAt(i5);
            if (childAt instanceof COUIActionMenuItemView) {
                COUIActionMenuItemView cOUIActionMenuItemView = (COUIActionMenuItemView) childAt;
                if (cOUIActionMenuItemView.isTextMenuItem()) {
                    TextView textView = (TextView) childAt;
                    int f3 = AbstractC0597a.f(textView, this.mTextMenuItemMaxWidth, this.mTextMenuItemHorizontalPadding * 2);
                    if (i5 == 0) {
                        if (f3 <= 2) {
                            cOUIActionMenuItemView.setMaxWidth(this.mTextMenuItemMaxWidth);
                        } else {
                            cOUIActionMenuItemView.setMaxWidth((size - i7) / 2);
                        }
                        measureChildCollapseMargins = measureChildCollapseMargins(childAt, i3, ((size - i7) / 2) + i7, i4, 0);
                    } else {
                        if (f3 <= 2) {
                            cOUIActionMenuItemView.setMaxWidth(this.mTextMenuItemMaxWidth);
                        } else {
                            cOUIActionMenuItemView.setMaxWidth(AbstractC0597a.c(textView, 2, this.mTextMenuItemMaxWidth, size - i7, this.mTextMenuItemHorizontalPadding * 2));
                        }
                        measureChildCollapseMargins = measureChildCollapseMargins(childAt, i3, i7, i4, 0);
                    }
                    i7 += measureChildCollapseMargins;
                }
            }
            i5++;
        }
        return i7;
    }

    private int measureChildCollapseMargins(View view, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i7 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        view.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight() + i7 + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i6, marginLayoutParams.height));
        return view.getMeasuredWidth() + i7;
    }

    private void resetItemMargin() {
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            if (getChildAt(i6).getVisibility() != 8) {
                i5++;
                if (i5 == 1) {
                    i3 = i6;
                    i4 = i3;
                } else {
                    i4 = i6;
                }
            }
        }
        if (i3 != -1 && !this.mIsSameSide && i5 > 1) {
            View childAt = getChildAt(i3);
            if (childAt instanceof ActionMenuItemView) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (((ActionMenuItemView) childAt).getItemData().getIcon() == null) {
                    if (isLayoutRTL()) {
                        marginLayoutParams.rightMargin = this.mEdgeTextItemMargin;
                    } else {
                        marginLayoutParams.leftMargin = this.mEdgeTextItemMargin;
                    }
                } else if (isLayoutRTL()) {
                    marginLayoutParams.rightMargin = this.mEdgeIconItemMargin;
                } else {
                    marginLayoutParams.leftMargin = this.mEdgeIconItemMargin;
                }
            }
        }
        if (i4 != -1) {
            View childAt2 = getChildAt(i4);
            if (childAt2 instanceof ActionMenuItemView) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                if (((ActionMenuItemView) childAt2).getItemData().getIcon() == null) {
                    if (isLayoutRTL()) {
                        marginLayoutParams2.leftMargin = this.mEdgeTextItemMargin;
                        return;
                    } else {
                        marginLayoutParams2.rightMargin = this.mEdgeTextItemMargin;
                        return;
                    }
                }
                if (isLayoutRTL()) {
                    marginLayoutParams2.leftMargin = this.mEdgeIconItemMargin;
                } else {
                    marginLayoutParams2.rightMargin = this.mEdgeIconItemMargin;
                }
            }
        }
    }

    private String setRedDotDescription(int i3) {
        return i3 != -1 ? i3 != 0 ? getResources().getQuantityString(this.mRedDotWithNumberDescriptionId, i3, Integer.valueOf(i3)) : this.mRedDotDescription : EMPTY_TITLE;
    }

    private boolean shouldUseStrictTextMeasure() {
        if (getChildCount() != 2 || this.mIsSameSide) {
            return false;
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof COUIActionMenuItemView) && !((COUIActionMenuItemView) childAt).isTextMenuItem()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryBuildOverflowMenu() {
        ArrayList arrayList;
        Integer num;
        ensureOverflowMenu();
        this.mOverflowItems.clear();
        if (this.mMenu != null) {
            s.a aVar = new s.a();
            for (int i3 = 0; i3 < this.mMenu.getNonActionItems().size(); i3++) {
                MenuItemImpl menuItemImpl = this.mMenu.getNonActionItems().get(i3);
                this.mMenuItem = menuItemImpl;
                boolean hasSubMenu = menuItemImpl.hasSubMenu();
                String str = EMPTY_TITLE;
                if (hasSubMenu) {
                    arrayList = new ArrayList();
                    SubMenu subMenu = this.mMenuItem.getSubMenu();
                    for (int i4 = 0; i4 < subMenu.size(); i4++) {
                        MenuItem item = subMenu.getItem(i4);
                        aVar.y().D(item.getItemId()).B(item.getIcon()).I(item.getTitle() != null ? item.getTitle().toString() : EMPTY_TITLE).z(item.getGroupId()).F(item.isEnabled());
                        arrayList.add(aVar.x());
                    }
                } else {
                    arrayList = null;
                }
                int i5 = -1;
                int intValue = (!this.mRedDotMap.containsKey(Integer.valueOf(this.mMenuItem.getItemId())) || (num = this.mRedDotMap.get(Integer.valueOf(this.mMenuItem.getItemId()))) == null) ? -1 : num.intValue();
                s.a B3 = aVar.y().D(this.mMenuItem.getItemId()).B(this.mMenuItem.getIcon());
                if (this.mMenuItem.getTitle() != null) {
                    str = this.mMenuItem.getTitle().toString();
                }
                s.a G3 = B3.I(str).E(this.mMenuItem.isChecked()).z(this.mMenuItem.getGroupId()).G(intValue);
                if (intValue != -1) {
                    i5 = 0;
                }
                G3.A(i5).H(arrayList).F(this.mMenuItem.isEnabled());
                this.mOverflowItems.add(aVar.x());
            }
            this.mOverflowPopup.k0(this.mOverflowItems);
            this.mOverflowPopup.j0(this.mIsFixTitleFontSize);
            this.mOverflowPopup.p0(new AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.toolbar.COUIActionMenuView.2
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j3) {
                    if (i6 < COUIActionMenuView.this.mMenu.getNonActionItems().size()) {
                        if (((s) COUIActionMenuView.this.mOverflowItems.get(i6)).s() != null) {
                            COUIActionMenuView.this.mMenu.performItemAction(COUIActionMenuView.this.mMenu.getNonActionItems().get(i6), 4);
                            return;
                        }
                        if (COUIActionMenuView.this.mMenu.getNonActionItems().get(i6).getIntent() != null) {
                            COUIActionMenuView.this.mOverflowPopup.h0(true);
                        }
                        COUIActionMenuView.this.mMenu.performItemAction(COUIActionMenuView.this.mMenu.getNonActionItems().get(i6), 0);
                        COUIActionMenuView.this.mOverflowPopup.dismiss();
                        return;
                    }
                    AbstractC0371a.c(COUIActionMenuView.TAG, "IndexOutOfBoundsException! position = " + i6 + " non action items size = " + COUIActionMenuView.this.mMenu.getNonActionItems().size() + "popup menu size = " + COUIActionMenuView.this.mOverflowPopup.S().size());
                }
            });
            this.mOverflowPopup.r0(this.mOnSubMenuItemClickListener);
            OverflowMenuListener overflowMenuListener = this.mOverflowMenuListener;
            if (overflowMenuListener != null) {
                overflowMenuListener.onOverflowMenuPreShow(this.mOverflowPopup);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        view.setHapticFeedbackEnabled(false);
        Z.a(view, EMPTY_TITLE);
        if (((ActionMenuView.c) layoutParams).f3864a) {
            this.mOverFlowMenuButton = view;
            configOverflowIconBackground();
            layoutParams.height = -1;
            this.mOverFlowMenuButton.setMinimumWidth(this.mOverFlowMinWidth);
            View view2 = this.mOverFlowMenuButton;
            view2.setPadding(this.mOverFlowHorPadding, view2.getPaddingTop(), this.mOverFlowHorPadding, this.mOverFlowMenuButton.getPaddingBottom());
            this.mOverFlowMenuButton.setOnTouchListener(null);
            this.mOverFlowMenuButton.setLongClickable(false);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.toolbar.COUIActionMenuView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    COUIActionMenuView.this.tryBuildOverflowMenu();
                    COUIActionMenuView cOUIActionMenuView = COUIActionMenuView.this;
                    cOUIActionMenuView.post(cOUIActionMenuView.mOpenOverflowRunnable);
                }
            });
        }
        super.addView(view, i3, layoutParams);
        configMenuItemViewAlignment();
    }

    public void clearRedDotInfo() {
        this.mNonActionRedDotSum = 0;
        this.mNonActionRedDotCount = 0;
        this.mRedDotMap.clear();
        postInvalidate();
    }

    protected void configMenuItemViewAlignment() {
        if (getParent() instanceof COUIToolbar) {
            this.mIsSameSide = !((COUIToolbar) getParent()).getIsTitleCenterStyle();
        } else {
            this.mIsSameSide = true;
        }
        if (!this.mIsSameSide) {
            View view = null;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof ActionMenuItemView) {
                    if (view != null) {
                        childAt.setTextAlignment(5);
                        view.setTextAlignment(6);
                    } else {
                        childAt.setTextAlignment(6);
                    }
                    view = childAt;
                }
            }
            return;
        }
        int i3 = 0;
        for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
            View childAt2 = getChildAt(childCount2);
            if (childAt2 instanceof ActionMenuItemView) {
                i3++;
                childAt2.setTextAlignment(4);
            }
        }
        if (i3 == 1 && (getChildAt(0) instanceof COUIActionMenuItemView)) {
            COUIActionMenuItemView cOUIActionMenuItemView = (COUIActionMenuItemView) getChildAt(0);
            if (cOUIActionMenuItemView.isTextMenuItem()) {
                cOUIActionMenuItemView.setTextAlignment(6);
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void dismissPopupMenus() {
        f fVar = this.mOverflowPopup;
        if (fVar != null) {
            fVar.dismiss();
        }
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (this.mRedDotMap.containsKey(Integer.valueOf(childAt.getId()))) {
                Integer num = this.mRedDotMap.get(Integer.valueOf(childAt.getId()));
                drawRedDot(childAt, num == null ? 0 : num.intValue(), canvas);
            }
            if (((ActionMenuView.c) childAt.getLayoutParams()).f3864a && this.mRedDotMap.size() > 0) {
                int i4 = this.mNonActionRedDotCount == 0 ? -1 : this.mNonActionRedDotSum;
                drawRedDot(childAt, i4, canvas);
                childAt.setContentDescription(TextUtils.isEmpty(setRedDotDescription(i4)) ? this.mOverFlowButtonDescription : this.mOverFlowButtonDescription + "," + setRedDotDescription(i4));
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public Menu getMenu() {
        MenuBuilder menuBuilder = (MenuBuilder) super.getMenu();
        this.mMenu = menuBuilder;
        return menuBuilder;
    }

    public View getOverFlowMenuButton() {
        return this.mOverFlowMenuButton;
    }

    public f getOverflowPopupWindow() {
        return this.mOverflowPopup;
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
        super.initialize(menuBuilder);
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            if (getChildAt(i9).getVisibility() != 8) {
                i8++;
            }
        }
        boolean b3 = b0.b(this);
        int i10 = (i6 - i4) / 2;
        if (this.mIsSameSide) {
            if (b3) {
                int width = getWidth() - getPaddingRight();
                while (i7 < childCount) {
                    View childAt = getChildAt(i7);
                    ActionMenuView.c cVar = (ActionMenuView.c) childAt.getLayoutParams();
                    if (childAt.getVisibility() != 8) {
                        int i11 = width - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        int measuredWidth = childAt.getMeasuredWidth();
                        int measuredHeight = childAt.getMeasuredHeight();
                        int i12 = i10 - (measuredHeight / 2);
                        childAt.layout(i11 - measuredWidth, i12, i11, measuredHeight + i12);
                        width = i11 - ((measuredWidth + ((LinearLayout.LayoutParams) cVar).leftMargin) + this.mItemSpacing);
                    }
                    i7++;
                }
                return;
            }
            int paddingLeft = getPaddingLeft();
            while (i7 < childCount) {
                View childAt2 = getChildAt(i7);
                ActionMenuView.c cVar2 = (ActionMenuView.c) childAt2.getLayoutParams();
                if (childAt2.getVisibility() != 8) {
                    int i13 = paddingLeft + ((LinearLayout.LayoutParams) cVar2).leftMargin;
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight2 = childAt2.getMeasuredHeight();
                    int i14 = i10 - (measuredHeight2 / 2);
                    childAt2.layout(i13, i14, i13 + measuredWidth2, measuredHeight2 + i14);
                    paddingLeft = i13 + measuredWidth2 + ((LinearLayout.LayoutParams) cVar2).rightMargin + this.mItemSpacing;
                }
                i7++;
            }
            return;
        }
        if (b3) {
            int paddingLeft2 = getPaddingLeft();
            boolean z4 = true;
            for (int i15 = childCount - 1; i15 >= 0; i15--) {
                View childAt3 = getChildAt(i15);
                ActionMenuView.c cVar3 = (ActionMenuView.c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8) {
                    paddingLeft2 += ((LinearLayout.LayoutParams) cVar3).leftMargin;
                    if (z4) {
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            paddingLeft2 += this.mTextExtarPadding;
                        }
                        z4 = false;
                    }
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i10 - (measuredHeight3 / 2);
                    if (i15 != 0 || i8 <= 1) {
                        childAt3.layout(paddingLeft2, i16, paddingLeft2 + measuredWidth3, measuredHeight3 + i16);
                        paddingLeft2 += measuredWidth3 + ((LinearLayout.LayoutParams) cVar3).rightMargin + this.mItemSpacing;
                    } else {
                        int width2 = ((getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar3).rightMargin) - measuredWidth3;
                        if ((childAt3 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt3).getText())) {
                            width2 -= this.mMenuViewPadding;
                        }
                        childAt3.layout(width2, i16, measuredWidth3 + width2, measuredHeight3 + i16);
                    }
                }
            }
            return;
        }
        int width3 = getWidth() - getPaddingRight();
        boolean z5 = true;
        for (int i17 = childCount - 1; i17 >= 0; i17--) {
            View childAt4 = getChildAt(i17);
            ActionMenuView.c cVar4 = (ActionMenuView.c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8) {
                width3 -= ((LinearLayout.LayoutParams) cVar4).rightMargin;
                if (z5) {
                    if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                        width3 -= this.mTextExtarPadding;
                    }
                    z5 = false;
                }
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i18 = i10 - (measuredHeight4 / 2);
                if (i17 != 0 || i8 <= 1) {
                    childAt4.layout(width3 - measuredWidth4, i18, width3, measuredHeight4 + i18);
                    width3 -= (measuredWidth4 + ((LinearLayout.LayoutParams) cVar4).leftMargin) + this.mItemSpacing;
                } else {
                    int paddingLeft3 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar4).leftMargin;
                    if ((childAt4 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt4).getText())) {
                        paddingLeft3 += this.mMenuViewPadding;
                    }
                    childAt4.layout(paddingLeft3, i18, measuredWidth4 + paddingLeft3, measuredHeight4 + i18);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView, androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.mMenu == null) {
            super.onMeasure(i3, i4);
            return;
        }
        this.mIsSameSide = true;
        if ((getParent() instanceof COUIToolbar) && ((COUIToolbar) getParent()).getIsTitleCenterStyle()) {
            this.mIsSameSide = false;
        }
        setPadding(0, getPaddingTop(), 0, getPaddingBottom());
        boolean z3 = y.x(this) == 1;
        int size = View.MeasureSpec.getSize(i3);
        View.MeasureSpec.getSize(i4);
        resetItemMargin();
        int measureChild = measureChild(i3, i4);
        int i5 = 0;
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getMeasuredHeight() > i5) {
                i5 = childAt.getMeasuredHeight();
            }
        }
        if (this.mIsSameSide) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i7 = 0;
                int i8 = -1;
                for (int i9 = 0; i9 < childCount; i9++) {
                    if (getChildAt(i9).getVisibility() != 8) {
                        i7++;
                        i8 = i9;
                    }
                }
                int i10 = measureChild + ((i7 - 1) * this.mItemSpacing);
                if (i8 != -1) {
                    View childAt2 = getChildAt(i8);
                    if ((childAt2 instanceof TextView) && !TextUtils.isEmpty(((TextView) childAt2).getText())) {
                        i10 += this.mTextExtarPadding;
                    }
                }
                size = i10;
            } else {
                size = 0;
            }
            if (z3) {
                setPadding(getPaddingLeft(), getPaddingTop(), 0, getPaddingBottom());
            }
        }
        setMeasuredDimension(size, i5);
    }

    public void refresh() {
        f fVar = this.mOverflowPopup;
        if (fVar != null) {
            fVar.b0();
        }
        C0560b c0560b = this.mMaskRippleDrawable;
        if (c0560b != null) {
            c0560b.u(getContext());
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof COUIActionMenuItemView) {
                ((COUIActionMenuItemView) childAt).refresh();
            }
        }
    }

    public void setBlurMinAnimLevel(EnumC0643a enumC0643a) {
        this.mBlurMinAnimLevel = enumC0643a;
    }

    public void setDismissMenuWithWindowAnimation(boolean z3) {
        ensureOverflowMenu();
        this.mOverflowPopup.h0(z3);
    }

    @Deprecated
    public void setEnableAddExtraWidth(boolean z3) {
    }

    @Deprecated
    public void setIsFixTitleFontSize(boolean z3) {
        this.mIsFixTitleFontSize = z3;
    }

    @Deprecated
    public void setItemSpecialColor(int i3, int i4) {
    }

    void setMenuItemGap(boolean z3) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof COUIActionMenuItemView) {
                ((COUIActionMenuItemView) childAt).setItemWithGap(z3);
            }
        }
    }

    public void setOnSubMenuItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnSubMenuItemClickListener = onItemClickListener;
    }

    public void setOverflowMenuListener(OverflowMenuListener overflowMenuListener) {
        this.mOverflowMenuListener = overflowMenuListener;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public void setOverflowReserved(boolean z3) {
        super.setOverflowReserved(z3);
        f fVar = this.mOverflowPopup;
        if (fVar == null || !fVar.isShowing()) {
            return;
        }
        if (this.mMenu.getNonActionItems().isEmpty()) {
            this.mOverflowPopup.dismiss();
        } else {
            tryBuildOverflowMenu();
        }
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setRedDot(int i3, int i4) {
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder == null) {
            Log.e(TAG, "The MenuBuilder is null");
            return;
        }
        menuBuilder.flagActionItems();
        MenuItemImpl menuItemImpl = (MenuItemImpl) this.mMenu.findItem(i3);
        if (menuItemImpl == null) {
            return;
        }
        if (i4 != -1) {
            if (!menuItemImpl.isActionButton()) {
                if (this.mRedDotMap.containsKey(Integer.valueOf(i3))) {
                    Integer num = this.mRedDotMap.get(Integer.valueOf(i3));
                    this.mNonActionRedDotSum = (this.mNonActionRedDotSum + i4) - (num != null ? num.intValue() : 0);
                } else {
                    this.mNonActionRedDotCount++;
                    this.mNonActionRedDotSum += i4;
                }
            }
            this.mRedDotMap.put(Integer.valueOf(i3), Integer.valueOf(i4));
        } else if (this.mRedDotMap.containsKey(Integer.valueOf(i3))) {
            if (!menuItemImpl.isActionButton()) {
                int i5 = this.mNonActionRedDotCount;
                this.mNonActionRedDotCount = i5 - (i5 == 0 ? 0 : 1);
                Integer num2 = this.mRedDotMap.get(Integer.valueOf(i3));
                this.mNonActionRedDotSum -= num2 != null ? num2.intValue() : 0;
            }
            this.mRedDotMap.remove(Integer.valueOf(i3));
        }
        CharSequence title = menuItemImpl.getTitle();
        if (i4 != -1) {
            title = ((Object) title) + "," + setRedDotDescription(i4);
        }
        menuItemImpl.setContentDescription(title);
        postInvalidate();
    }

    @Deprecated
    public void setSubItemSpecialColor(int i3, int i4) {
    }

    @Deprecated
    public void setSubMenuClickListener(com.coui.appcompat.poplist.l lVar) {
        this.mOnSubMenuItemClickListener = lVar;
    }

    @Deprecated
    public void setSubMenuList(ArrayList<s> arrayList, int i3) {
    }

    public void setUseBackgroundBlur(boolean z3) {
        this.mUseBackgroundBlur = z3;
    }

    @Override // androidx.appcompat.widget.ActionMenuView
    public boolean showOverflowMenu() {
        View view;
        Activity c3 = j.c(getContext());
        if ((c3 != null && (c3.isFinishing() || c3.isDestroyed())) || this.mOverflowPopup == null || (view = this.mOverFlowMenuButton) == null || view.getParent() == null) {
            return false;
        }
        tryBuildOverflowMenu();
        post(this.mOpenOverflowRunnable);
        return true;
    }

    public COUIActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOpenOverflowRunnable = new OpenOverflowRunnable();
        this.mMenu = null;
        this.mPresenterClasses = new ArrayList();
        this.mIsSameSide = true;
        this.mMenuViewPadding = 0;
        this.mSubMenuList = null;
        this.mSubPosition = -1;
        this.mEnableAddExtraWidth = true;
        this.mOverflowMenuListener = null;
        this.mUseBackgroundBlur = false;
        this.mBlurMinAnimLevel = j.f14497a;
        this.mOverFlowMinWidth = getResources().getDimensionPixelSize(c.f11750c);
        this.mOverFlowHorPadding = getResources().getDimensionPixelSize(c.f11787u0);
        this.mEdgeIconItemMargin = getResources().getDimensionPixelSize(c.f11701B0);
        this.mIconItemHorOffset = getResources().getDimensionPixelSize(c.f11703C0);
        this.mItemVerOffset = getResources().getDimensionPixelSize(c.f11705D0);
        this.mItemSpacing = getResources().getDimensionPixelSize(c.f11754e);
        this.mRedDotMap = new HashMap<>();
        this.mRedDotHorizontalOffset = getResources().getDimensionPixelSize(c.f11757f0);
        this.mRedDotVerticalOffset = getResources().getDimensionPixelSize(c.f11759g0);
        this.mRedDotWithNumberVerticalOffset = getResources().getDimensionPixelSize(c.f11765j0);
        this.mRedDotWithNumberHorizontalOffset = getResources().getDimensionPixelSize(c.f11763i0);
        this.mRedDotWithSmallNumberHorizontalOffset = getResources().getDimensionPixelSize(c.f11767k0);
        this.mRedDotWithBigNumberHorizontalOffset = getResources().getDimensionPixelSize(c.f11761h0);
        this.mMenuIconTopPadding = getResources().getDimensionPixelSize(c.f11755e0);
        this.mHintRedDotHelper = new C0421a(getContext(), null, g.f3120a, 0, Z1.f.f3119b);
        this.mOverFlowButtonDescription = getResources().getString(h.f11236b);
        this.mRedDotDescription = getResources().getString(e.f3116a);
        this.mRedDotWithNumberDescriptionId = d.f3115a;
        this.mMenuIconBgRadius = getResources().getDimensionPixelSize(c.f11753d0);
        this.mTextMenuItemMaxWidth = context.getResources().getDimensionPixelSize(c.f11748b);
        this.mToolbarTitleMinWidth = context.getResources().getDimensionPixelSize(c.f11783s0);
        this.mTextMenuItemHorizontalPadding = context.getResources().getDimensionPixelSize(c.f11779q0);
    }

    public void dismissPopupMenus(boolean z3) {
        f fVar = this.mOverflowPopup;
        if (fVar != null) {
            if (z3) {
                fVar.dismiss();
            } else {
                fVar.x0();
            }
        }
    }
}
