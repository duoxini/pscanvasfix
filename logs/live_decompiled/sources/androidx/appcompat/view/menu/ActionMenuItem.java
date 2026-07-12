package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.graphics.drawable.a;
import androidx.core.view.AbstractC0253b;
import w.InterfaceMenuItemC0614b;

/* loaded from: classes.dex */
public class ActionMenuItem implements InterfaceMenuItemC0614b {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private Context mContext;
    private final int mGroup;
    private Drawable mIconDrawable;
    private final int mId;
    private Intent mIntent;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private char mShortcutNumericChar;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;
    private int mShortcutNumericModifiers = 4096;
    private int mShortcutAlphabeticModifiers = 4096;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private int mFlags = 16;

    public ActionMenuItem(Context context, int i3, int i4, int i5, int i6, CharSequence charSequence) {
        this.mContext = context;
        this.mId = i4;
        this.mGroup = i3;
        this.mOrdering = i6;
        this.mTitle = charSequence;
    }

    private void applyIconTint() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            if (this.mHasIconTint || this.mHasIconTintMode) {
                Drawable l3 = a.l(drawable);
                this.mIconDrawable = l3;
                Drawable mutate = l3.mutate();
                this.mIconDrawable = mutate;
                if (this.mHasIconTint) {
                    a.i(mutate, this.mIconTintList);
                }
                if (this.mHasIconTintMode) {
                    a.j(this.mIconDrawable, this.mIconTintMode);
                }
            }
        }
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mGroup;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.mIconDrawable;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mOrdering;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // w.InterfaceMenuItemC0614b
    public AbstractC0253b getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        return charSequence != null ? charSequence : this.mTitle;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.mClickListener;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        Intent intent = this.mIntent;
        if (intent == null) {
            return false;
        }
        this.mContext.startActivity(intent);
        return true;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.mFlags & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.mFlags & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.mFlags & 8) == 0;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z3) {
        this.mFlags = (z3 ? 1 : 0) | (this.mFlags & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z3) {
        this.mFlags = (z3 ? 2 : 0) | (this.mFlags & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z3) {
        this.mFlags = (z3 ? 16 : 0) | (this.mFlags & (-17));
        return this;
    }

    public ActionMenuItem setExclusiveCheckable(boolean z3) {
        this.mFlags = (z3 ? 4 : 0) | (this.mFlags & (-5));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        applyIconTint();
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.mShortcutNumericChar = c3;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.mShortcutNumericChar = c3;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c4);
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public void setShowAsAction(int i3) {
    }

    @Override // w.InterfaceMenuItemC0614b
    public InterfaceMenuItemC0614b setSupportActionProvider(AbstractC0253b abstractC0253b) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z3) {
        this.mFlags = (this.mFlags & 8) | (z3 ? 0 : 8);
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c3);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC0614b setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.mShortcutNumericChar = c3;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public InterfaceMenuItemC0614b setShowAsActionFlags(int i3) {
        setShowAsAction(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.mTitle = this.mContext.getResources().getString(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public InterfaceMenuItemC0614b setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public InterfaceMenuItemC0614b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.mIconDrawable = androidx.core.content.a.e(this.mContext, i3);
        applyIconTint();
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.mShortcutNumericChar = c3;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i3);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c4);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i4);
        return this;
    }

    @Override // w.InterfaceMenuItemC0614b, android.view.MenuItem
    public InterfaceMenuItemC0614b setActionView(int i3) {
        throw new UnsupportedOperationException();
    }
}
