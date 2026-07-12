package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import w.c;

/* loaded from: classes.dex */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final c mSubMenu;

    SubMenuWrapperICS(Context context, c cVar) {
        super(context, cVar);
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        throw null;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i3) {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i3) {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i3) {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        throw null;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        throw null;
    }
}
