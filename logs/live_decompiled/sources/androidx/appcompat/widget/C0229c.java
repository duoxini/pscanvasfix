package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.AbstractC0253b;
import e.AbstractC0339a;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0229c extends BaseMenuPresenter implements AbstractC0253b.a {

    /* renamed from: e, reason: collision with root package name */
    d f4201e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f4202f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f4203g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4204h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4205i;

    /* renamed from: j, reason: collision with root package name */
    private int f4206j;

    /* renamed from: k, reason: collision with root package name */
    private int f4207k;

    /* renamed from: l, reason: collision with root package name */
    private int f4208l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4209m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4210n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4211o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4212p;

    /* renamed from: q, reason: collision with root package name */
    private int f4213q;

    /* renamed from: r, reason: collision with root package name */
    private final SparseBooleanArray f4214r;

    /* renamed from: s, reason: collision with root package name */
    e f4215s;

    /* renamed from: t, reason: collision with root package name */
    a f4216t;

    /* renamed from: u, reason: collision with root package name */
    RunnableC0057c f4217u;

    /* renamed from: v, reason: collision with root package name */
    private b f4218v;

    /* renamed from: w, reason: collision with root package name */
    final f f4219w;

    /* renamed from: x, reason: collision with root package name */
    int f4220x;

    /* renamed from: androidx.appcompat.widget.c$a */
    private class a extends MenuPopupHelper {
        public a(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, AbstractC0339a.f11094i);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).isActionButton()) {
                View view2 = C0229c.this.f4201e;
                setAnchorView(view2 == null ? (View) ((BaseMenuPresenter) C0229c.this).mMenuView : view2);
            }
            setPresenterCallback(C0229c.this.f4219w);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void onDismiss() {
            C0229c c0229c = C0229c.this;
            c0229c.f4216t = null;
            c0229c.f4220x = 0;
            super.onDismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    private class b extends ActionMenuItemView.PopupCallback {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public ShowableListMenu getPopup() {
            a aVar = C0229c.this.f4216t;
            if (aVar != null) {
                return aVar.getPopup();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c, reason: collision with other inner class name */
    private class RunnableC0057c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private e f4223e;

        public RunnableC0057c(e eVar) {
            this.f4223e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((BaseMenuPresenter) C0229c.this).mMenu != null) {
                ((BaseMenuPresenter) C0229c.this).mMenu.changeMenuMode();
            }
            View view = (View) ((BaseMenuPresenter) C0229c.this).mMenuView;
            if (view != null && view.getWindowToken() != null && this.f4223e.tryShow()) {
                C0229c.this.f4215s = this.f4223e;
            }
            C0229c.this.f4217u = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    private class d extends AppCompatImageView implements ActionMenuView.a {

        /* renamed from: androidx.appcompat.widget.c$d$a */
        class a extends H {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ C0229c f4226e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, C0229c c0229c) {
                super(view);
                this.f4226e = c0229c;
            }

            @Override // androidx.appcompat.widget.H
            public ShowableListMenu getPopup() {
                e eVar = C0229c.this.f4215s;
                if (eVar == null) {
                    return null;
                }
                return eVar.getPopup();
            }

            @Override // androidx.appcompat.widget.H
            public boolean onForwardingStarted() {
                C0229c.this.u();
                return true;
            }

            @Override // androidx.appcompat.widget.H
            public boolean onForwardingStopped() {
                C0229c c0229c = C0229c.this;
                if (c0229c.f4217u != null) {
                    return false;
                }
                c0229c.l();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, AbstractC0339a.f11093h);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            Z.a(this, getContentDescription());
            setOnTouchListener(new a(this, C0229c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0229c.this.u();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i3, int i4, int i5, int i6) {
            boolean frame = super.setFrame(i3, i4, i5, i6);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.f(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    private class e extends MenuPopupHelper {
        public e(Context context, MenuBuilder menuBuilder, View view, boolean z3) {
            super(context, menuBuilder, view, z3, AbstractC0339a.f11094i);
            setGravity(8388613);
            setPresenterCallback(C0229c.this.f4219w);
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        protected void onDismiss() {
            if (((BaseMenuPresenter) C0229c.this).mMenu != null) {
                ((BaseMenuPresenter) C0229c.this).mMenu.close();
            }
            C0229c.this.f4215s = null;
            super.onDismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    private class f implements MenuPresenter.Callback {
        f() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = C0229c.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z3);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            if (menuBuilder == ((BaseMenuPresenter) C0229c.this).mMenu) {
                return false;
            }
            C0229c.this.f4220x = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback callback = C0229c.this.getCallback();
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$g */
    private static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        public int f4230e;

        /* renamed from: androidx.appcompat.widget.c$g$a */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f4230e);
        }

        g(Parcel parcel) {
            this.f4230e = parcel.readInt();
        }
    }

    public C0229c(Context context) {
        super(context, e.g.f11218c, e.g.f11217b);
        this.f4214r = new SparseBooleanArray();
        this.f4219w = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View j(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // androidx.core.view.AbstractC0253b.a
    public void a(boolean z3) {
        if (z3) {
            super.onSubMenuSelected(null);
            return;
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.close(false);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.f4218v == null) {
            this.f4218v = new b();
        }
        actionMenuItemView.setPopupCallback(this.f4218v);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean filterLeftoverView(ViewGroup viewGroup, int i3) {
        if (viewGroup.getChildAt(i3) == this.f4201e) {
            return false;
        }
        return super.filterLeftoverView(viewGroup, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        ArrayList<MenuItemImpl> arrayList;
        int i3;
        int i4;
        int i5;
        boolean z3;
        int i6;
        C0229c c0229c = this;
        MenuBuilder menuBuilder = c0229c.mMenu;
        View view = null;
        ?? r3 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i3 = arrayList.size();
        } else {
            arrayList = null;
            i3 = 0;
        }
        int i7 = c0229c.f4208l;
        int i8 = c0229c.f4207k;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0229c.mMenuView;
        boolean z4 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            MenuItemImpl menuItemImpl = arrayList.get(i11);
            if (menuItemImpl.requiresActionButton()) {
                i9++;
            } else if (menuItemImpl.requestsActionButton()) {
                i10++;
            } else {
                z4 = true;
            }
            if (c0229c.f4212p && menuItemImpl.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (c0229c.f4204h && (z4 || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = c0229c.f4214r;
        sparseBooleanArray.clear();
        if (c0229c.f4210n) {
            int i13 = c0229c.f4213q;
            i5 = i8 / i13;
            i4 = i13 + ((i8 % i13) / i5);
        } else {
            i4 = 0;
            i5 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i3) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i14);
            if (menuItemImpl2.requiresActionButton()) {
                View itemView = c0229c.getItemView(menuItemImpl2, view, viewGroup);
                if (c0229c.f4210n) {
                    i5 -= ActionMenuView.measureChildForCells(itemView, i4, i5, makeMeasureSpec, r3);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = itemView.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.setIsActionButton(true);
                z3 = r3;
                i6 = i3;
            } else if (menuItemImpl2.requestsActionButton()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z5 = sparseBooleanArray.get(groupId2);
                boolean z6 = (i12 > 0 || z5) && i8 > 0 && (!c0229c.f4210n || i5 > 0);
                boolean z7 = z6;
                i6 = i3;
                if (z6) {
                    View itemView2 = c0229c.getItemView(menuItemImpl2, null, viewGroup);
                    if (c0229c.f4210n) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i4, i5, makeMeasureSpec, 0);
                        i5 -= measureChildForCells;
                        if (measureChildForCells == 0) {
                            z7 = false;
                        }
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z8 = z7;
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z6 = z8 & (!c0229c.f4210n ? i8 + i15 <= 0 : i8 < 0);
                }
                if (z6 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z5) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i16);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.isActionButton()) {
                                i12++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z6) {
                    i12--;
                }
                menuItemImpl2.setIsActionButton(z6);
                z3 = false;
            } else {
                z3 = r3;
                i6 = i3;
                menuItemImpl2.setIsActionButton(z3);
            }
            i14++;
            r3 = z3;
            i3 = i6;
            view = null;
            c0229c = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            actionView = super.getItemView(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        MenuView menuView2 = super.getMenuView(viewGroup);
        if (menuView != menuView2) {
            ((ActionMenuView) menuView2).setPresenter(this);
        }
        return menuView2;
    }

    public boolean i() {
        return m() | l();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        Resources resources = context.getResources();
        androidx.appcompat.view.a b3 = androidx.appcompat.view.a.b(context);
        if (!this.f4205i) {
            this.f4204h = b3.f();
        }
        if (!this.f4211o) {
            this.f4206j = b3.c();
        }
        if (!this.f4209m) {
            this.f4208l = b3.d();
        }
        int i3 = this.f4206j;
        if (this.f4204h) {
            if (this.f4201e == null) {
                d dVar = new d(this.mSystemContext);
                this.f4201e = dVar;
                if (this.f4203g) {
                    dVar.setImageDrawable(this.f4202f);
                    this.f4202f = null;
                    this.f4203g = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f4201e.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i3 -= this.f4201e.getMeasuredWidth();
        } else {
            this.f4201e = null;
        }
        this.f4207k = i3;
        this.f4213q = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public Drawable k() {
        d dVar = this.f4201e;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f4203g) {
            return this.f4202f;
        }
        return null;
    }

    public boolean l() {
        Object obj;
        RunnableC0057c runnableC0057c = this.f4217u;
        if (runnableC0057c != null && (obj = this.mMenuView) != null) {
            ((View) obj).removeCallbacks(runnableC0057c);
            this.f4217u = null;
            return true;
        }
        e eVar = this.f4215s;
        if (eVar == null) {
            return false;
        }
        eVar.dismiss();
        return true;
    }

    public boolean m() {
        a aVar = this.f4216t;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    public boolean n() {
        return this.f4217u != null || o();
    }

    public boolean o() {
        e eVar = this.f4215s;
        return eVar != null && eVar.isShowing();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
        i();
        super.onCloseMenu(menuBuilder, z3);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i3;
        MenuItem findItem;
        if ((parcelable instanceof g) && (i3 = ((g) parcelable).f4230e) > 0 && (findItem = this.mMenu.findItem(i3)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        g gVar = new g();
        gVar.f4230e = this.f4220x;
        return gVar;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z3 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.getParentMenu();
        }
        View j3 = j(subMenuBuilder2.getItem());
        if (j3 == null) {
            return false;
        }
        this.f4220x = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z3 = true;
                break;
            }
            i3++;
        }
        a aVar = new a(this.mContext, subMenuBuilder, j3);
        this.f4216t = aVar;
        aVar.setForceShowIcon(z3);
        this.f4216t.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void p(Configuration configuration) {
        if (!this.f4209m) {
            this.f4208l = androidx.appcompat.view.a.b(this.mContext).d();
        }
        MenuBuilder menuBuilder = this.mMenu;
        if (menuBuilder != null) {
            menuBuilder.onItemsChanged(true);
        }
    }

    public void q(boolean z3) {
        this.f4212p = z3;
    }

    public void r(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void s(Drawable drawable) {
        d dVar = this.f4201e;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.f4203g = true;
            this.f4202f = drawable;
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public boolean shouldIncludeItem(int i3, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public void t(boolean z3) {
        this.f4204h = z3;
        this.f4205i = true;
    }

    public boolean u() {
        MenuBuilder menuBuilder;
        if (!this.f4204h || o() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.f4217u != null || menuBuilder.getNonActionItems().isEmpty()) {
            return false;
        }
        RunnableC0057c runnableC0057c = new RunnableC0057c(new e(this.mContext, this.mMenu, this.f4201e, true));
        this.f4217u = runnableC0057c;
        ((View) this.mMenuView).post(runnableC0057c);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z3) {
        super.updateMenuView(z3);
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder = this.mMenu;
        boolean z4 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> actionItems = menuBuilder.getActionItems();
            int size = actionItems.size();
            for (int i3 = 0; i3 < size; i3++) {
                AbstractC0253b supportActionProvider = actionItems.get(i3).getSupportActionProvider();
                if (supportActionProvider != null) {
                    supportActionProvider.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.mMenu;
        ArrayList<MenuItemImpl> nonActionItems = menuBuilder2 != null ? menuBuilder2.getNonActionItems() : null;
        if (this.f4204h && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z4 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z4 = true;
            }
        }
        if (z4) {
            if (this.f4201e == null) {
                this.f4201e = new d(this.mSystemContext);
            }
            ViewGroup viewGroup = (ViewGroup) this.f4201e.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f4201e);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.f4201e, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else {
            d dVar = this.f4201e;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.mMenuView;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f4201e);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.f4204h);
    }
}
