package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* loaded from: classes.dex */
public class K extends I implements J {

    /* renamed from: K, reason: collision with root package name */
    private J f3966K;

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z3) {
            popupWindow.setTouchModal(z3);
        }
    }

    public static class c extends F {

        /* renamed from: r, reason: collision with root package name */
        final int f3967r;

        /* renamed from: s, reason: collision with root package name */
        final int f3968s;

        /* renamed from: t, reason: collision with root package name */
        private J f3969t;

        /* renamed from: u, reason: collision with root package name */
        private MenuItem f3970u;

        static class a {
            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public c(Context context, boolean z3) {
            super(context, z3);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.f3967r = 21;
                this.f3968s = 22;
            } else {
                this.f3967r = 22;
                this.f3968s = 21;
            }
        }

        @Override // androidx.appcompat.widget.F
        public /* bridge */ /* synthetic */ int d(int i3, int i4, int i5, int i6, int i7) {
            return super.d(i3, i4, i5, i6, i7);
        }

        @Override // androidx.appcompat.widget.F
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i3) {
            return super.e(motionEvent, i3);
        }

        @Override // androidx.appcompat.widget.F, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.F, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            MenuAdapter menuAdapter;
            int i3;
            int pointToPosition;
            int i4;
            if (this.f3969t != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i3 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i3 = 0;
                }
                MenuItemImpl item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i4 = pointToPosition - i3) < 0 || i4 >= menuAdapter.getCount()) ? null : menuAdapter.getItem(i4);
                MenuItem menuItem = this.f3970u;
                if (menuItem != item) {
                    MenuBuilder adapterMenu = menuAdapter.getAdapterMenu();
                    if (menuItem != null) {
                        this.f3969t.onItemHoverExit(adapterMenu, menuItem);
                    }
                    this.f3970u = item;
                    if (item != null) {
                        this.f3969t.onItemHoverEnter(adapterMenu, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i3, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i3 == this.f3967r) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i3 != this.f3968s) {
                return super.onKeyDown(i3, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (MenuAdapter) adapter).getAdapterMenu().close(false);
            return true;
        }

        @Override // androidx.appcompat.widget.F, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(J j3) {
            this.f3969t = j3;
        }

        @Override // androidx.appcompat.widget.F, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public K(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public void M(Object obj) {
        a.a(this.f3936J, (Transition) obj);
    }

    public void N(Object obj) {
        a.b(this.f3936J, (Transition) obj);
    }

    public void O(J j3) {
        this.f3966K = j3;
    }

    public void P(boolean z3) {
        b.a(this.f3936J, z3);
    }

    @Override // androidx.appcompat.widget.I
    F n(Context context, boolean z3) {
        c cVar = new c(context, z3);
        cVar.setHoverListener(this);
        return cVar;
    }

    @Override // androidx.appcompat.widget.J
    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        J j3 = this.f3966K;
        if (j3 != null) {
            j3.onItemHoverEnter(menuBuilder, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.J
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        J j3 = this.f3966K;
        if (j3 != null) {
            j3.onItemHoverExit(menuBuilder, menuItem);
        }
    }
}
