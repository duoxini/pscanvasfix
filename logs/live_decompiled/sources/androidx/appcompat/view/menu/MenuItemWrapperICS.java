package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.c;
import androidx.core.view.AbstractC0253b;
import java.lang.reflect.Method;
import w.InterfaceMenuItemC0614b;

/* loaded from: classes.dex */
public class MenuItemWrapperICS extends BaseMenuWrapper implements MenuItem {
    static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final InterfaceMenuItemC0614b mWrappedObject;

    private class ActionProviderWrapper extends AbstractC0253b {
        final ActionProvider mInner;

        ActionProviderWrapper(Context context, ActionProvider actionProvider) {
            super(context);
            this.mInner = actionProvider;
        }

        @Override // androidx.core.view.AbstractC0253b
        public boolean hasSubMenu() {
            return this.mInner.hasSubMenu();
        }

        @Override // androidx.core.view.AbstractC0253b
        public View onCreateActionView() {
            return this.mInner.onCreateActionView();
        }

        @Override // androidx.core.view.AbstractC0253b
        public boolean onPerformDefaultAction() {
            return this.mInner.onPerformDefaultAction();
        }

        @Override // androidx.core.view.AbstractC0253b
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.mInner.onPrepareSubMenu(MenuItemWrapperICS.this.getSubMenuWrapper(subMenu));
        }
    }

    private class ActionProviderWrapperJB extends ActionProviderWrapper implements ActionProvider.VisibilityListener {
        private AbstractC0253b.InterfaceC0073b mListener;

        ActionProviderWrapperJB(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // androidx.core.view.AbstractC0253b
        public boolean isVisible() {
            return this.mInner.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z3) {
            AbstractC0253b.InterfaceC0073b interfaceC0073b = this.mListener;
            if (interfaceC0073b != null) {
                interfaceC0073b.onActionProviderVisibilityChanged(z3);
            }
        }

        @Override // androidx.core.view.AbstractC0253b
        public View onCreateActionView(MenuItem menuItem) {
            return this.mInner.onCreateActionView(menuItem);
        }

        @Override // androidx.core.view.AbstractC0253b
        public boolean overridesItemVisibility() {
            return this.mInner.overridesItemVisibility();
        }

        @Override // androidx.core.view.AbstractC0253b
        public void refreshVisibility() {
            this.mInner.refreshVisibility();
        }

        @Override // androidx.core.view.AbstractC0253b
        public void setVisibilityListener(AbstractC0253b.InterfaceC0073b interfaceC0073b) {
            this.mListener = interfaceC0073b;
            ActionProvider actionProvider = this.mInner;
            if (interfaceC0073b == null) {
                this = null;
            }
            actionProvider.setVisibilityListener(this);
        }
    }

    static class CollapsibleActionViewWrapper extends FrameLayout implements c {
        final CollapsibleActionView mWrappedView;

        /* JADX WARN: Multi-variable type inference failed */
        CollapsibleActionViewWrapper(View view) {
            super(view.getContext());
            this.mWrappedView = (CollapsibleActionView) view;
            addView(view);
        }

        View getWrappedView() {
            return (View) this.mWrappedView;
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewCollapsed() {
            this.mWrappedView.onActionViewCollapsed();
        }

        @Override // androidx.appcompat.view.c
        public void onActionViewExpanded() {
            this.mWrappedView.onActionViewExpanded();
        }
    }

    private class OnActionExpandListenerWrapper implements MenuItem.OnActionExpandListener {
        private final MenuItem.OnActionExpandListener mObject;

        OnActionExpandListenerWrapper(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.mObject = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.mObject.onMenuItemActionCollapse(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.mObject.onMenuItemActionExpand(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    private class OnMenuItemClickListenerWrapper implements MenuItem.OnMenuItemClickListener {
        private final MenuItem.OnMenuItemClickListener mObject;

        OnMenuItemClickListenerWrapper(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.mObject = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.mObject.onMenuItemClick(MenuItemWrapperICS.this.getMenuItemWrapper(menuItem));
        }
    }

    public MenuItemWrapperICS(Context context, InterfaceMenuItemC0614b interfaceMenuItemC0614b) {
        super(context);
        if (interfaceMenuItemC0614b == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.mWrappedObject = interfaceMenuItemC0614b;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0253b supportActionProvider = this.mWrappedObject.getSupportActionProvider();
        if (supportActionProvider instanceof ActionProviderWrapper) {
            return ((ActionProviderWrapper) supportActionProvider).mInner;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.mWrappedObject.getActionView();
        return actionView instanceof CollapsibleActionViewWrapper ? ((CollapsibleActionViewWrapper) actionView).getWrappedView() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return getSubMenuWrapper(this.mWrappedObject.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ActionProviderWrapperJB actionProviderWrapperJB = new ActionProviderWrapperJB(this.mContext, actionProvider);
        InterfaceMenuItemC0614b interfaceMenuItemC0614b = this.mWrappedObject;
        if (actionProvider == null) {
            actionProviderWrapperJB = null;
        }
        interfaceMenuItemC0614b.setSupportActionProvider(actionProviderWrapperJB);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new CollapsibleActionViewWrapper(view);
        }
        this.mWrappedObject.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3) {
        this.mWrappedObject.setAlphabeticShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z3) {
        this.mWrappedObject.setCheckable(z3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z3) {
        this.mWrappedObject.setChecked(z3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.mWrappedObject.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z3) {
        this.mWrappedObject.setEnabled(z3);
        return this;
    }

    public void setExclusiveCheckable(boolean z3) {
        try {
            if (this.mSetExclusiveCheckableMethod == null) {
                this.mSetExclusiveCheckableMethod = this.mWrappedObject.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.mSetExclusiveCheckableMethod.invoke(this.mWrappedObject, Boolean.valueOf(z3));
        } catch (Exception e3) {
            Log.w(LOG_TAG, "Error while calling setExclusiveCheckable", e3);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.mWrappedObject.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mWrappedObject.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mWrappedObject.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.mWrappedObject.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3) {
        this.mWrappedObject.setNumericShortcut(c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mWrappedObject.setOnActionExpandListener(onActionExpandListener != null ? new OnActionExpandListenerWrapper(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mWrappedObject.setOnMenuItemClickListener(onMenuItemClickListener != null ? new OnMenuItemClickListenerWrapper(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4) {
        this.mWrappedObject.setShortcut(c3, c4);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i3) {
        this.mWrappedObject.setShowAsAction(i3);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i3) {
        this.mWrappedObject.setShowAsActionFlags(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mWrappedObject.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.mWrappedObject.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z3) {
        return this.mWrappedObject.setVisible(z3);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c3, int i3) {
        this.mWrappedObject.setAlphabeticShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i3) {
        this.mWrappedObject.setIcon(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c3, int i3) {
        this.mWrappedObject.setNumericShortcut(c3, i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c3, char c4, int i3, int i4) {
        this.mWrappedObject.setShortcut(c3, c4, i3, i4);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i3) {
        this.mWrappedObject.setTitle(i3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i3) {
        this.mWrappedObject.setActionView(i3);
        View actionView = this.mWrappedObject.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.mWrappedObject.setActionView(new CollapsibleActionViewWrapper(actionView));
        }
        return this;
    }
}
