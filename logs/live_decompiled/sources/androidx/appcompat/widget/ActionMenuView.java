package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    e mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private C0229c mPresenter;
    private boolean mReserveOverflow;

    public interface a {
        boolean needsDividerAfter();

        boolean needsDividerBefore();
    }

    private static class b implements MenuPresenter.Callback {
        b() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class c extends LinearLayoutCompat.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3864a;

        /* renamed from: b, reason: collision with root package name */
        public int f3865b;

        /* renamed from: c, reason: collision with root package name */
        public int f3866c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3867d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3868e;

        /* renamed from: f, reason: collision with root package name */
        boolean f3869f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f3864a = cVar.f3864a;
        }

        public c(int i3, int i4) {
            super(i3, i4);
            this.f3864a = false;
        }
    }

    private class d implements MenuBuilder.Callback {
        d() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            e eVar = ActionMenuView.this.mOnMenuItemClickListener;
            return eVar != null && eVar.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.mMenuBuilderCallback;
            if (callback != null) {
                callback.onMenuModeChange(menuBuilder);
            }
        }
    }

    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void d(int i3, int i4) {
        int i5;
        int i6;
        boolean z3;
        int i7;
        int i8;
        boolean z4;
        boolean z5;
        int i9;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i4);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i4, paddingTop, -2);
        int i10 = size - paddingLeft;
        int i11 = this.mMinCellSize;
        int i12 = i10 / i11;
        int i13 = i10 % i11;
        if (i12 == 0) {
            setMeasuredDimension(i10, 0);
            return;
        }
        int i14 = i11 + (i13 / i12);
        int childCount = getChildCount();
        int i15 = 0;
        int i16 = 0;
        boolean z6 = false;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        long j3 = 0;
        while (i16 < childCount) {
            View childAt = getChildAt(i16);
            int i20 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i21 = i17 + 1;
                if (z7) {
                    int i22 = this.mGeneratedItemPadding;
                    i9 = i21;
                    r14 = 0;
                    childAt.setPadding(i22, 0, i22, 0);
                } else {
                    i9 = i21;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f3869f = r14;
                cVar.f3866c = r14;
                cVar.f3865b = r14;
                cVar.f3867d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f3868e = z7 && ((ActionMenuItemView) childAt).hasText();
                int measureChildForCells = measureChildForCells(childAt, i14, cVar.f3864a ? 1 : i12, childMeasureSpec, paddingTop);
                i18 = Math.max(i18, measureChildForCells);
                if (cVar.f3867d) {
                    i19++;
                }
                if (cVar.f3864a) {
                    z6 = true;
                }
                i12 -= measureChildForCells;
                i15 = Math.max(i15, childAt.getMeasuredHeight());
                if (measureChildForCells == 1) {
                    j3 |= 1 << i16;
                    i15 = i15;
                }
                i17 = i9;
            }
            i16++;
            size2 = i20;
        }
        int i23 = size2;
        boolean z8 = z6 && i17 == 2;
        boolean z9 = false;
        while (i19 > 0 && i12 > 0) {
            int i24 = Integer.MAX_VALUE;
            int i25 = 0;
            int i26 = 0;
            long j4 = 0;
            while (i26 < childCount) {
                boolean z10 = z9;
                c cVar2 = (c) getChildAt(i26).getLayoutParams();
                int i27 = i15;
                if (cVar2.f3867d) {
                    int i28 = cVar2.f3865b;
                    if (i28 < i24) {
                        j4 = 1 << i26;
                        i24 = i28;
                        i25 = 1;
                    } else if (i28 == i24) {
                        i25++;
                        j4 |= 1 << i26;
                    }
                }
                i26++;
                i15 = i27;
                z9 = z10;
            }
            z3 = z9;
            i7 = i15;
            j3 |= j4;
            if (i25 > i12) {
                i5 = mode;
                i6 = i10;
                break;
            }
            int i29 = i24 + 1;
            int i30 = 0;
            while (i30 < childCount) {
                View childAt2 = getChildAt(i30);
                c cVar3 = (c) childAt2.getLayoutParams();
                int i31 = i10;
                int i32 = mode;
                long j5 = 1 << i30;
                if ((j4 & j5) == 0) {
                    if (cVar3.f3865b == i29) {
                        j3 |= j5;
                    }
                    z5 = z8;
                } else {
                    if (z8 && cVar3.f3868e && i12 == 1) {
                        int i33 = this.mGeneratedItemPadding;
                        z5 = z8;
                        childAt2.setPadding(i33 + i14, 0, i33, 0);
                    } else {
                        z5 = z8;
                    }
                    cVar3.f3865b++;
                    cVar3.f3869f = true;
                    i12--;
                }
                i30++;
                mode = i32;
                i10 = i31;
                z8 = z5;
            }
            i15 = i7;
            z9 = true;
        }
        i5 = mode;
        i6 = i10;
        z3 = z9;
        i7 = i15;
        boolean z11 = !z6 && i17 == 1;
        if (i12 <= 0 || j3 == 0 || (i12 >= i17 - 1 && !z11 && i18 <= 1)) {
            i8 = 0;
            z4 = z3;
        } else {
            float bitCount = Long.bitCount(j3);
            if (z11) {
                i8 = 0;
            } else {
                i8 = 0;
                if ((j3 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f3868e) {
                    bitCount -= 0.5f;
                }
                int i34 = childCount - 1;
                if ((j3 & (1 << i34)) != 0 && !((c) getChildAt(i34).getLayoutParams()).f3868e) {
                    bitCount -= 0.5f;
                }
            }
            int i35 = bitCount > 0.0f ? (int) ((i12 * i14) / bitCount) : i8;
            z4 = z3;
            for (int i36 = i8; i36 < childCount; i36++) {
                if ((j3 & (1 << i36)) != 0) {
                    View childAt3 = getChildAt(i36);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f3866c = i35;
                        cVar4.f3869f = true;
                        if (i36 == 0 && !cVar4.f3868e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i35) / 2;
                        }
                        z4 = true;
                    } else if (cVar4.f3864a) {
                        cVar4.f3866c = i35;
                        cVar4.f3869f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i35) / 2;
                        z4 = true;
                    } else {
                        if (i36 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i35 / 2;
                        }
                        if (i36 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i35 / 2;
                        }
                    }
                }
            }
        }
        if (z4) {
            for (int i37 = i8; i37 < childCount; i37++) {
                View childAt4 = getChildAt(i37);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f3869f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f3865b * i14) + cVar5.f3866c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i6, i5 != 1073741824 ? i7 : i23);
    }

    static int measureChildForCells(View view, int i3, int i4, int i5, int i6) {
        int i7;
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i5) - i6, View.MeasureSpec.getMode(i5));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z3 = false;
        boolean z4 = actionMenuItemView != null && actionMenuItemView.hasText();
        if (i4 > 0) {
            i7 = 2;
            if (!z4 || i4 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i4 * i3, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i8 = measuredWidth / i3;
                if (measuredWidth % i3 != 0) {
                    i8++;
                }
                if (!z4 || i8 >= 2) {
                    i7 = i8;
                }
                if (!cVar.f3864a && z4) {
                    z3 = true;
                }
                cVar.f3867d = z3;
                cVar.f3865b = i7;
                view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i7, 1073741824), makeMeasureSpec);
                return i7;
            }
        }
        i7 = 0;
        if (!cVar.f3864a) {
            z3 = true;
        }
        cVar.f3867d = z3;
        cVar.f3865b = i7;
        view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i7, 1073741824), makeMeasureSpec);
        return i7;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public void dismissPopupMenus() {
        C0229c c0229c = this.mPresenter;
        if (c0229c != null) {
            c0229c.i();
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public c generateOverflowButtonLayoutParams() {
        c generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.f3864a = true;
        return generateDefaultLayoutParams;
    }

    public Menu getMenu() {
        if (this.mMenu == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.mMenu = menuBuilder;
            menuBuilder.setCallback(new d());
            C0229c c0229c = new C0229c(context);
            this.mPresenter = c0229c;
            c0229c.t(true);
            C0229c c0229c2 = this.mPresenter;
            MenuPresenter.Callback callback = this.mActionMenuPresenterCallback;
            if (callback == null) {
                callback = new b();
            }
            c0229c2.setCallback(callback);
            this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
            this.mPresenter.r(this);
        }
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.mPresenter.k();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    protected boolean hasSupportDividerBeforeChildAt(int i3) {
        boolean z3 = false;
        if (i3 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i3 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i3);
        if (i3 < getChildCount() && (childAt instanceof a)) {
            z3 = ((a) childAt).needsDividerAfter();
        }
        return (i3 <= 0 || !(childAt2 instanceof a)) ? z3 : z3 | ((a) childAt2).needsDividerBefore();
    }

    public boolean hideOverflowMenu() {
        C0229c c0229c = this.mPresenter;
        return c0229c != null && c0229c.l();
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction(menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        C0229c c0229c = this.mPresenter;
        return c0229c != null && c0229c.n();
    }

    public boolean isOverflowMenuShowing() {
        C0229c c0229c = this.mPresenter;
        return c0229c != null && c0229c.o();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0229c c0229c = this.mPresenter;
        if (c0229c != null) {
            c0229c.updateMenuView(false);
            if (this.mPresenter.o()) {
                this.mPresenter.l();
                this.mPresenter.u();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int width;
        int i7;
        if (!this.mFormatItems) {
            super.onLayout(z3, i3, i4, i5, i6);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i6 - i4) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i5 - i3;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean b3 = b0.b(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f3864a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (hasSupportDividerBeforeChildAt(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b3) {
                        i7 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        width = i7 + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i7 = width - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i7, i13, width, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    hasSupportDividerBeforeChildAt(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        int max = Math.max(0, i16 > 0 ? paddingRight / i16 : 0);
        if (b3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f3864a) {
                    int i18 = width2 - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width2 = i18 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f3864a) {
                int i21 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i3, int i4) {
        MenuBuilder menuBuilder;
        boolean z3 = this.mFormatItems;
        boolean z4 = View.MeasureSpec.getMode(i3) == 1073741824;
        this.mFormatItems = z4;
        if (z3 != z4) {
            this.mFormatItemsWidth = 0;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && size != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = size;
            menuBuilder.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (this.mFormatItems && childCount > 0) {
            d(i3, i4);
            return;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            c cVar = (c) getChildAt(i5).getLayoutParams();
            ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
            ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
        }
        super.onMeasure(i3, i4);
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean z3) {
        this.mPresenter.q(z3);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.mOnMenuItemClickListener = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.mPresenter.s(drawable);
    }

    public void setOverflowReserved(boolean z3) {
        this.mReserveOverflow = z3;
    }

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

    public void setPresenter(C0229c c0229c) {
        this.mPresenter = c0229c;
        c0229c.r(this);
    }

    public boolean showOverflowMenu() {
        C0229c c0229c = this.mPresenter;
        return c0229c != null && c0229c.u();
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f3 = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int) (56.0f * f3);
        this.mGeneratedItemPadding = (int) (f3 * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams != null) {
            if (layoutParams instanceof c) {
                cVar = new c((c) layoutParams);
            } else {
                cVar = new c(layoutParams);
            }
            if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
                ((LinearLayout.LayoutParams) cVar).gravity = 16;
            }
            return cVar;
        }
        return generateDefaultLayoutParams();
    }
}
