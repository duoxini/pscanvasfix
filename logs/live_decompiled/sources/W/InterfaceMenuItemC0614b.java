package w;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.AbstractC0253b;

/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceMenuItemC0614b extends MenuItem {
    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    AbstractC0253b getSupportActionProvider();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    MenuItem setActionView(int i3);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c3, int i3);

    @Override // android.view.MenuItem
    InterfaceMenuItemC0614b setContentDescription(CharSequence charSequence);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c3, int i3);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c3, char c4, int i3, int i4);

    @Override // android.view.MenuItem
    void setShowAsAction(int i3);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int i3);

    InterfaceMenuItemC0614b setSupportActionProvider(AbstractC0253b abstractC0253b);

    @Override // android.view.MenuItem
    InterfaceMenuItemC0614b setTooltipText(CharSequence charSequence);
}
