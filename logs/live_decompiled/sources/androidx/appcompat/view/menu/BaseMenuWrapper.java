package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import m.g;
import w.InterfaceMenuItemC0614b;

/* loaded from: classes.dex */
abstract class BaseMenuWrapper {
    final Context mContext;
    private g mMenuItems;
    private g mSubMenus;

    BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC0614b)) {
            return menuItem;
        }
        InterfaceMenuItemC0614b interfaceMenuItemC0614b = (InterfaceMenuItemC0614b) menuItem;
        if (this.mMenuItems == null) {
            this.mMenuItems = new g();
        }
        MenuItem menuItem2 = (MenuItem) this.mMenuItems.get(interfaceMenuItemC0614b);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.mContext, interfaceMenuItemC0614b);
        this.mMenuItems.put(interfaceMenuItemC0614b, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        return subMenu;
    }

    final void internalClear() {
        g gVar = this.mMenuItems;
        if (gVar != null) {
            gVar.clear();
        }
        g gVar2 = this.mSubMenus;
        if (gVar2 != null) {
            gVar2.clear();
        }
    }

    final void internalRemoveGroup(int i3) {
        if (this.mMenuItems == null) {
            return;
        }
        int i4 = 0;
        while (i4 < this.mMenuItems.size()) {
            if (((InterfaceMenuItemC0614b) this.mMenuItems.i(i4)).getGroupId() == i3) {
                this.mMenuItems.k(i4);
                i4--;
            }
            i4++;
        }
    }

    final void internalRemoveItem(int i3) {
        if (this.mMenuItems == null) {
            return;
        }
        for (int i4 = 0; i4 < this.mMenuItems.size(); i4++) {
            if (((InterfaceMenuItemC0614b) this.mMenuItems.i(i4)).getItemId() == i3) {
                this.mMenuItems.k(i4);
                return;
            }
        }
    }
}
