package com.google.android.material.internal;

import H0.c;
import H0.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.J;
import androidx.core.view.accessibility.d;
import androidx.core.view.y;
import androidx.core.widget.i;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    public static final int NO_TEXT_APPEARANCE_SET = 0;
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    NavigationMenuAdapter adapter;
    private MenuPresenter.Callback callback;
    int dividerInsetEnd;
    int dividerInsetStart;
    boolean hasCustomItemIconSize;
    LinearLayout headerLayout;
    ColorStateList iconTintList;
    private int id;
    Drawable itemBackground;
    RippleDrawable itemForeground;
    int itemHorizontalPadding;
    int itemIconPadding;
    int itemIconSize;
    private int itemMaxLines;
    int itemVerticalPadding;
    LayoutInflater layoutInflater;
    MenuBuilder menu;
    private NavigationMenuView menuView;
    int paddingSeparator;
    private int paddingTopDefault;
    ColorStateList subheaderColor;
    int subheaderInsetEnd;
    int subheaderInsetStart;
    ColorStateList textColor;
    int subheaderTextAppearance = 0;
    int textAppearance = 0;
    boolean isBehindStatusBar = true;
    private int overScrollMode = -1;
    final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z3 = true;
            NavigationMenuPresenter.this.setUpdateSuspended(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                NavigationMenuPresenter.this.adapter.setCheckedItem(itemData);
            } else {
                z3 = false;
            }
            NavigationMenuPresenter.this.setUpdateSuspended(false);
            if (z3) {
                NavigationMenuPresenter.this.updateMenuView(false);
            }
        }
    };

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.h {
        private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
        private static final String STATE_CHECKED_ITEM = "android:menu:checked";
        private static final int VIEW_TYPE_HEADER = 3;
        private static final int VIEW_TYPE_NORMAL = 0;
        private static final int VIEW_TYPE_SEPARATOR = 2;
        private static final int VIEW_TYPE_SUBHEADER = 1;
        private MenuItemImpl checkedItem;
        private final ArrayList<NavigationMenuItem> items = new ArrayList<>();
        private boolean updateSuspended;

        NavigationMenuAdapter() {
            prepareMenuItems();
        }

        private void appendTransparentIconIfMissing(int i3, int i4) {
            while (i3 < i4) {
                ((NavigationMenuTextItem) this.items.get(i3)).needsEmptyIcon = true;
                i3++;
            }
        }

        private void prepareMenuItems() {
            if (this.updateSuspended) {
                return;
            }
            boolean z3 = true;
            this.updateSuspended = true;
            this.items.clear();
            this.items.add(new NavigationMenuHeaderItem());
            int size = NavigationMenuPresenter.this.menu.getVisibleItems().size();
            int i3 = -1;
            int i4 = 0;
            boolean z4 = false;
            int i5 = 0;
            while (i4 < size) {
                MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.menu.getVisibleItems().get(i4);
                if (menuItemImpl.isChecked()) {
                    setCheckedItem(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.items.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
                        }
                        this.items.add(new NavigationMenuTextItem(menuItemImpl));
                        int size2 = this.items.size();
                        int size3 = subMenu.size();
                        int i6 = 0;
                        boolean z5 = false;
                        while (i6 < size3) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i6);
                            if (menuItemImpl2.isVisible()) {
                                if (!z5 && menuItemImpl2.getIcon() != null) {
                                    z5 = z3;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    setCheckedItem(menuItemImpl);
                                }
                                this.items.add(new NavigationMenuTextItem(menuItemImpl2));
                            }
                            i6++;
                            z3 = true;
                        }
                        if (z5) {
                            appendTransparentIconIfMissing(size2, this.items.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i3) {
                        i5 = this.items.size();
                        z4 = menuItemImpl.getIcon() != null;
                        if (i4 != 0) {
                            i5++;
                            ArrayList<NavigationMenuItem> arrayList = this.items;
                            int i7 = NavigationMenuPresenter.this.paddingSeparator;
                            arrayList.add(new NavigationMenuSeparatorItem(i7, i7));
                        }
                    } else if (!z4 && menuItemImpl.getIcon() != null) {
                        appendTransparentIconIfMissing(i5, this.items.size());
                        z4 = true;
                    }
                    NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem.needsEmptyIcon = z4;
                    this.items.add(navigationMenuTextItem);
                    i3 = groupId;
                }
                i4++;
                z3 = true;
            }
            this.updateSuspended = false;
        }

        public Bundle createInstanceState() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.checkedItem;
            if (menuItemImpl != null) {
                bundle.putInt(STATE_CHECKED_ITEM, menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.items.size();
            for (int i3 = 0; i3 < size; i3++) {
                NavigationMenuItem navigationMenuItem = this.items.get(i3);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItem = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem();
                    View actionView = menuItem != null ? menuItem.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(menuItem.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
            return bundle;
        }

        public MenuItemImpl getCheckedItem() {
            return this.checkedItem;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public long getItemId(int i3) {
            return i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int getItemViewType(int i3) {
            NavigationMenuItem navigationMenuItem = this.items.get(i3);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).getMenuItem().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        int getRowCount() {
            int i3 = NavigationMenuPresenter.this.headerLayout.getChildCount() == 0 ? 0 : 1;
            for (int i4 = 0; i4 < NavigationMenuPresenter.this.adapter.getItemCount(); i4++) {
                if (NavigationMenuPresenter.this.adapter.getItemViewType(i4) == 0) {
                    i3++;
                }
            }
            return i3;
        }

        public void restoreInstanceState(Bundle bundle) {
            MenuItemImpl menuItem;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl menuItem2;
            int i3 = bundle.getInt(STATE_CHECKED_ITEM, 0);
            if (i3 != 0) {
                this.updateSuspended = true;
                int size = this.items.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.items.get(i4);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (menuItem2 = ((NavigationMenuTextItem) navigationMenuItem).getMenuItem()) != null && menuItem2.getItemId() == i3) {
                        setCheckedItem(menuItem2);
                        break;
                    }
                    i4++;
                }
                this.updateSuspended = false;
                prepareMenuItems();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS);
            if (sparseParcelableArray != null) {
                int size2 = this.items.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    NavigationMenuItem navigationMenuItem2 = this.items.get(i5);
                    if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (menuItem = ((NavigationMenuTextItem) navigationMenuItem2).getMenuItem()) != null && (actionView = menuItem.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(menuItem.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void setCheckedItem(MenuItemImpl menuItemImpl) {
            if (this.checkedItem == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.checkedItem;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.checkedItem = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void setUpdateSuspended(boolean z3) {
            this.updateSuspended = z3;
        }

        public void update() {
            prepareMenuItems();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onBindViewHolder(ViewHolder viewHolder, int i3) {
            int itemViewType = getItemViewType(i3);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    if (itemViewType != 2) {
                        return;
                    }
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.items.get(i3);
                    viewHolder.itemView.setPadding(NavigationMenuPresenter.this.dividerInsetStart, navigationMenuSeparatorItem.getPaddingTop(), NavigationMenuPresenter.this.dividerInsetEnd, navigationMenuSeparatorItem.getPaddingBottom());
                    return;
                }
                TextView textView = (TextView) viewHolder.itemView;
                textView.setText(((NavigationMenuTextItem) this.items.get(i3)).getMenuItem().getTitle());
                int i4 = NavigationMenuPresenter.this.subheaderTextAppearance;
                if (i4 != 0) {
                    i.m(textView, i4);
                }
                textView.setPadding(NavigationMenuPresenter.this.subheaderInsetStart, textView.getPaddingTop(), NavigationMenuPresenter.this.subheaderInsetEnd, textView.getPaddingBottom());
                ColorStateList colorStateList = NavigationMenuPresenter.this.subheaderColor;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                    return;
                }
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
            navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.iconTintList);
            int i5 = NavigationMenuPresenter.this.textAppearance;
            if (i5 != 0) {
                navigationMenuItemView.setTextAppearance(i5);
            }
            ColorStateList colorStateList2 = NavigationMenuPresenter.this.textColor;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = NavigationMenuPresenter.this.itemBackground;
            y.n0(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            RippleDrawable rippleDrawable = NavigationMenuPresenter.this.itemForeground;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.items.get(i3);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.needsEmptyIcon);
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            int i6 = navigationMenuPresenter.itemHorizontalPadding;
            int i7 = navigationMenuPresenter.itemVerticalPadding;
            navigationMenuItemView.setPadding(i6, i7, i6, i7);
            navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
            if (navigationMenuPresenter2.hasCustomItemIconSize) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter2.itemIconSize);
            }
            navigationMenuItemView.setMaxLines(NavigationMenuPresenter.this.itemMaxLines);
            navigationMenuItemView.initialize(navigationMenuTextItem.getMenuItem(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (i3 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new NormalViewHolder(navigationMenuPresenter.layoutInflater, viewGroup, navigationMenuPresenter.onClickListener);
            }
            if (i3 == 1) {
                return new SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i3 == 2) {
                return new SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, viewGroup);
            }
            if (i3 != 3) {
                return null;
            }
            return new HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).recycle();
            }
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private interface NavigationMenuItem {
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {
        private final int paddingBottom;
        private final int paddingTop;

        public NavigationMenuSeparatorItem(int i3, int i4) {
            this.paddingTop = i3;
            this.paddingBottom = i4;
        }

        public int getPaddingBottom() {
            return this.paddingBottom;
        }

        public int getPaddingTop() {
            return this.paddingTop;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {
        private final MenuItemImpl menuItem;
        boolean needsEmptyIcon;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.menuItem = menuItemImpl;
        }

        public MenuItemImpl getMenuItem() {
            return this.menuItem;
        }
    }

    private class NavigationMenuViewAccessibilityDelegate extends m {
        NavigationMenuViewAccessibilityDelegate(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.m, androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            dVar.S(d.b.a(NavigationMenuPresenter.this.adapter.getRowCount(), 0, false));
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(g.f597b, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(g.f599d, viewGroup, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(g.f600e, viewGroup, false));
        }
    }

    private static abstract class ViewHolder extends RecyclerView.E {
        public ViewHolder(View view) {
            super(view);
        }
    }

    private void updateTopPadding() {
        int i3 = (this.headerLayout.getChildCount() == 0 && this.isBehindStatusBar) ? this.paddingTopDefault : 0;
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, i3, 0, navigationMenuView.getPaddingBottom());
    }

    public void addHeaderView(View view) {
        this.headerLayout.addView(view);
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(J j3) {
        int k3 = j3.k();
        if (this.paddingTopDefault != k3) {
            this.paddingTopDefault = k3;
            updateTopPadding();
        }
        NavigationMenuView navigationMenuView = this.menuView;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, j3.h());
        y.f(this.headerLayout, j3);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.dividerInsetEnd;
    }

    public int getDividerInsetStart() {
        return this.dividerInsetStart;
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int i3) {
        return this.headerLayout.getChildAt(i3);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.id;
    }

    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public int getItemMaxLines() {
        return this.itemMaxLines;
    }

    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    public int getItemVerticalPadding() {
        return this.itemVerticalPadding;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.menuView == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.layoutInflater.inflate(g.f601f, viewGroup, false);
            this.menuView = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.menuView));
            if (this.adapter == null) {
                this.adapter = new NavigationMenuAdapter();
            }
            int i3 = this.overScrollMode;
            if (i3 != -1) {
                this.menuView.setOverScrollMode(i3);
            }
            this.headerLayout = (LinearLayout) this.layoutInflater.inflate(g.f598c, (ViewGroup) this.menuView, false);
            this.menuView.setAdapter(this.adapter);
        }
        return this.menuView;
    }

    public int getSubheaderInsetEnd() {
        return this.subheaderInsetEnd;
    }

    public int getSubheaderInsetStart() {
        return this.subheaderInsetStart;
    }

    public View inflateHeaderView(int i3) {
        View inflate = this.layoutInflater.inflate(i3, (ViewGroup) this.headerLayout, false);
        addHeaderView(inflate);
        return inflate;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.layoutInflater = LayoutInflater.from(context);
        this.menu = menuBuilder;
        this.paddingSeparator = context.getResources().getDimensionPixelOffset(c.f521d);
    }

    public boolean isBehindStatusBar() {
        return this.isBehindStatusBar;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z3) {
        MenuPresenter.Callback callback = this.callback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.menuView.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle(STATE_ADAPTER);
            if (bundle2 != null) {
                this.adapter.restoreInstanceState(bundle2);
            }
            SparseArray<Parcelable> sparseParcelableArray2 = bundle.getSparseParcelableArray(STATE_HEADER);
            if (sparseParcelableArray2 != null) {
                this.headerLayout.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.menuView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.menuView.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            bundle.putBundle(STATE_ADAPTER, navigationMenuAdapter.createInstanceState());
        }
        if (this.headerLayout != null) {
            SparseArray<Parcelable> sparseArray2 = new SparseArray<>();
            this.headerLayout.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray(STATE_HEADER, sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(View view) {
        this.headerLayout.removeView(view);
        if (this.headerLayout.getChildCount() == 0) {
            NavigationMenuView navigationMenuView = this.menuView;
            navigationMenuView.setPadding(0, this.paddingTopDefault, 0, navigationMenuView.getPaddingBottom());
        }
    }

    public void setBehindStatusBar(boolean z3) {
        if (this.isBehindStatusBar != z3) {
            this.isBehindStatusBar = z3;
            updateTopPadding();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.callback = callback;
    }

    public void setCheckedItem(MenuItemImpl menuItemImpl) {
        this.adapter.setCheckedItem(menuItemImpl);
    }

    public void setDividerInsetEnd(int i3) {
        this.dividerInsetEnd = i3;
        updateMenuView(false);
    }

    public void setDividerInsetStart(int i3) {
        this.dividerInsetStart = i3;
        updateMenuView(false);
    }

    public void setId(int i3) {
        this.id = i3;
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        updateMenuView(false);
    }

    public void setItemForeground(RippleDrawable rippleDrawable) {
        this.itemForeground = rippleDrawable;
        updateMenuView(false);
    }

    public void setItemHorizontalPadding(int i3) {
        this.itemHorizontalPadding = i3;
        updateMenuView(false);
    }

    public void setItemIconPadding(int i3) {
        this.itemIconPadding = i3;
        updateMenuView(false);
    }

    public void setItemIconSize(int i3) {
        if (this.itemIconSize != i3) {
            this.itemIconSize = i3;
            this.hasCustomItemIconSize = true;
            updateMenuView(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        updateMenuView(false);
    }

    public void setItemMaxLines(int i3) {
        this.itemMaxLines = i3;
        updateMenuView(false);
    }

    public void setItemTextAppearance(int i3) {
        this.textAppearance = i3;
        updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
        updateMenuView(false);
    }

    public void setItemVerticalPadding(int i3) {
        this.itemVerticalPadding = i3;
        updateMenuView(false);
    }

    public void setOverScrollMode(int i3) {
        this.overScrollMode = i3;
        NavigationMenuView navigationMenuView = this.menuView;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i3);
        }
    }

    public void setSubheaderColor(ColorStateList colorStateList) {
        this.subheaderColor = colorStateList;
        updateMenuView(false);
    }

    public void setSubheaderInsetEnd(int i3) {
        this.subheaderInsetEnd = i3;
        updateMenuView(false);
    }

    public void setSubheaderInsetStart(int i3) {
        this.subheaderInsetStart = i3;
        updateMenuView(false);
    }

    public void setSubheaderTextAppearance(int i3) {
        this.subheaderTextAppearance = i3;
        updateMenuView(false);
    }

    public void setUpdateSuspended(boolean z3) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.setUpdateSuspended(z3);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z3) {
        NavigationMenuAdapter navigationMenuAdapter = this.adapter;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.update();
        }
    }
}
