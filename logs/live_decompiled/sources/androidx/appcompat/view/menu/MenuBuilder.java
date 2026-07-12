package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.a;
import androidx.core.view.AbstractC0253b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import w.InterfaceMenuC0613a;

/* loaded from: classes.dex */
public class MenuBuilder implements InterfaceMenuC0613a {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private Callback mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private MenuItemImpl mExpandedItem;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mOverrideVisibleItems;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private int mDefaultShowAsAction = 0;
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private boolean mOptionalIconsVisible = false;
    private boolean mIsClosing = false;
    private ArrayList<MenuItemImpl> mTempShortcutItemList = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<MenuPresenter>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mGroupDividerEnabled = false;
    private ArrayList<MenuItemImpl> mItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> mVisibleItems = new ArrayList<>();
    private boolean mIsVisibleItemsStale = true;
    private ArrayList<MenuItemImpl> mActionItems = new ArrayList<>();
    private ArrayList<MenuItemImpl> mNonActionItems = new ArrayList<>();
    private boolean mIsActionItemsStale = true;

    public interface Callback {
        boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem);

        void onMenuModeChange(MenuBuilder menuBuilder);
    }

    public interface ItemInvoker {
        boolean invokeItem(MenuItemImpl menuItemImpl);
    }

    public MenuBuilder(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        setShortcutsVisibleInner(true);
    }

    private MenuItemImpl createNewMenuItem(int i3, int i4, int i5, int i6, CharSequence charSequence, int i7) {
        return new MenuItemImpl(this, i3, i4, i5, i6, charSequence, i7);
    }

    private void dispatchPresenterUpdate(boolean z3) {
        if (this.mPresenters.isEmpty()) {
            return;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                menuPresenter.updateMenuView(z3);
            }
        }
        startDispatchingItemsChanged();
    }

    private void dispatchRestoreInstanceState(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray == null || this.mPresenters.isEmpty()) {
            return;
        }
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                    menuPresenter.onRestoreInstanceState(parcelable);
                }
            }
        }
    }

    private void dispatchSaveInstanceState(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (this.mPresenters.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                int id = menuPresenter.getId();
                if (id > 0 && (onSaveInstanceState = menuPresenter.onSaveInstanceState()) != null) {
                    sparseArray.put(id, onSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
    }

    private boolean dispatchSubMenuSelected(SubMenuBuilder subMenuBuilder, MenuPresenter menuPresenter) {
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        boolean onSubMenuSelected = menuPresenter != null ? menuPresenter.onSubMenuSelected(subMenuBuilder) : false;
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null) {
                this.mPresenters.remove(next);
            } else if (!onSubMenuSelected) {
                onSubMenuSelected = menuPresenter2.onSubMenuSelected(subMenuBuilder);
            }
        }
        return onSubMenuSelected;
    }

    private static int findInsertIndex(ArrayList<MenuItemImpl> arrayList, int i3) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i3) {
                return size + 1;
            }
        }
        return 0;
    }

    private static int getOrdering(int i3) {
        int i4 = ((-65536) & i3) >> 16;
        if (i4 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i4 < iArr.length) {
                return (i3 & 65535) | (iArr[i4] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    private void removeItemAtInt(int i3, boolean z3) {
        if (i3 < 0 || i3 >= this.mItems.size()) {
            return;
        }
        this.mItems.remove(i3);
        if (z3) {
            onItemsChanged(true);
        }
    }

    private void setHeaderInternal(int i3, CharSequence charSequence, int i4, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i3 > 0) {
                this.mHeaderTitle = resources.getText(i3);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i4 > 0) {
                this.mHeaderIcon = a.e(getContext(), i4);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0019, code lost:
    
        if (androidx.core.view.A.c(android.view.ViewConfiguration.get(r2.mContext), r2.mContext) != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void setShortcutsVisibleInner(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L1c
            android.content.res.Resources r3 = r2.mResources
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L1c
            android.content.Context r3 = r2.mContext
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.mContext
            boolean r3 = androidx.core.view.A.c(r3, r1)
            if (r3 == 0) goto L1c
            goto L1d
        L1c:
            r0 = 0
        L1d:
            r2.mShortcutsVisible = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.MenuBuilder.setShortcutsVisibleInner(boolean):void");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i3, int i4, int i5, ComponentName componentName, Intent[] intentArr, Intent intent, int i6, MenuItem[] menuItemArr) {
        int i7;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i6 & 1) == 0) {
            removeGroup(i3);
        }
        for (int i8 = 0; i8 < size; i8++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i8);
            int i9 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i9 < 0 ? intent : intentArr[i9]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent3 = add(i3, i4, i5, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i7 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i7] = intent3;
            }
        }
        return size;
    }

    protected MenuItem addInternal(int i3, int i4, int i5, CharSequence charSequence) {
        int ordering = getOrdering(i5);
        MenuItemImpl createNewMenuItem = createNewMenuItem(i3, i4, i5, ordering, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            createNewMenuItem.setMenuInfo(contextMenuInfo);
        }
        ArrayList<MenuItemImpl> arrayList = this.mItems;
        arrayList.add(findInsertIndex(arrayList, ordering), createNewMenuItem);
        onItemsChanged(true);
        return createNewMenuItem;
    }

    public void addMenuPresenter(MenuPresenter menuPresenter) {
        addMenuPresenter(menuPresenter, this.mContext);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void changeMenuMode() {
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.onMenuModeChange(this);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        MenuItemImpl menuItemImpl = this.mExpandedItem;
        if (menuItemImpl != null) {
            collapseItemActionView(menuItemImpl);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z3) {
        if (this.mIsClosing) {
            return;
        }
        this.mIsClosing = true;
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                menuPresenter.onCloseMenu(this, z3);
            }
        }
        this.mIsClosing = false;
    }

    public boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        boolean z3 = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == menuItemImpl) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z3 = menuPresenter.collapseItemActionView(this, menuItemImpl);
                    if (z3) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z3) {
                this.mExpandedItem = null;
            }
        }
        return z3;
    }

    boolean dispatchMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        Callback callback = this.mCallback;
        return callback != null && callback.onMenuItemSelected(menuBuilder, menuItem);
    }

    public boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        boolean z3 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter = next.get();
            if (menuPresenter == null) {
                this.mPresenters.remove(next);
            } else {
                z3 = menuPresenter.expandItemActionView(this, menuItemImpl);
                if (z3) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z3) {
            this.mExpandedItem = menuItemImpl;
        }
        return z3;
    }

    public int findGroupIndex(int i3) {
        return findGroupIndex(i3, 0);
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i3) {
        MenuItem findItem;
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i4);
            if (menuItemImpl.getItemId() == i3) {
                return menuItemImpl;
            }
            if (menuItemImpl.hasSubMenu() && (findItem = menuItemImpl.getSubMenu().findItem(i3)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i3) {
        int size = size();
        for (int i4 = 0; i4 < size; i4++) {
            if (this.mItems.get(i4).getItemId() == i3) {
                return i4;
            }
        }
        return -1;
    }

    MenuItemImpl findItemWithShortcutForKey(int i3, KeyEvent keyEvent) {
        ArrayList<MenuItemImpl> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i3, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = arrayList.get(i4);
            char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
            char[] cArr = keyData.meta;
            if ((alphabeticShortcut == cArr[0] && (metaState & 2) == 0) || ((alphabeticShortcut == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && alphabeticShortcut == '\b' && i3 == 67))) {
                return menuItemImpl;
            }
        }
        return null;
    }

    void findItemsWithShortcutForKey(List<MenuItemImpl> list, int i3, KeyEvent keyEvent) {
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i3 == 67) {
            int size = this.mItems.size();
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = this.mItems.get(i4);
                if (menuItemImpl.hasSubMenu()) {
                    ((MenuBuilder) menuItemImpl.getSubMenu()).findItemsWithShortcutForKey(list, i3, keyEvent);
                }
                char alphabeticShortcut = isQwertyMode ? menuItemImpl.getAlphabeticShortcut() : menuItemImpl.getNumericShortcut();
                if ((modifiers & 69647) == ((isQwertyMode ? menuItemImpl.getAlphabeticModifiers() : menuItemImpl.getNumericModifiers()) & 69647) && alphabeticShortcut != 0) {
                    char[] cArr = keyData.meta;
                    if ((alphabeticShortcut == cArr[0] || alphabeticShortcut == cArr[2] || (isQwertyMode && alphabeticShortcut == '\b' && i3 == 67)) && menuItemImpl.isEnabled()) {
                        list.add(menuItemImpl);
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<MenuItemImpl> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                WeakReference<MenuPresenter> next = it.next();
                MenuPresenter menuPresenter = next.get();
                if (menuPresenter == null) {
                    this.mPresenters.remove(next);
                } else {
                    z3 |= menuPresenter.flagActionItems();
                }
            }
            if (z3) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i3 = 0; i3 < size; i3++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i3);
                    if (menuItemImpl.isActionButton()) {
                        this.mActionItems.add(menuItemImpl);
                    } else {
                        this.mNonActionItems.add(menuItemImpl);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<MenuItemImpl> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    protected String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public MenuItemImpl getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i3) {
        return this.mItems.get(i3);
    }

    public ArrayList<MenuItemImpl> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    Resources getResources() {
        return this.mResources;
    }

    public MenuBuilder getRootMenu() {
        return this;
    }

    public ArrayList<MenuItemImpl> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i3);
            if (menuItemImpl.isVisible()) {
                this.mVisibleItems.add(menuItemImpl);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.mItems.get(i3).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i3, KeyEvent keyEvent) {
        return findItemWithShortcutForKey(i3, keyEvent) != null;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    void onItemActionRequestChanged(MenuItemImpl menuItemImpl) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    void onItemVisibleChanged(MenuItemImpl menuItemImpl) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z3) {
        if (this.mPreventDispatchingItemsChanged) {
            this.mItemsChangedWhileDispatchPrevented = true;
            if (z3) {
                this.mStructureChangedWhileDispatchPrevented = true;
                return;
            }
            return;
        }
        if (z3) {
            this.mIsVisibleItemsStale = true;
            this.mIsActionItemsStale = true;
        }
        dispatchPresenterUpdate(z3);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i3, int i4) {
        return performItemAction(findItem(i3), i4);
    }

    public boolean performItemAction(MenuItem menuItem, int i3) {
        return performItemAction(menuItem, null, i3);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i3, KeyEvent keyEvent, int i4) {
        MenuItemImpl findItemWithShortcutForKey = findItemWithShortcutForKey(i3, keyEvent);
        boolean performItemAction = findItemWithShortcutForKey != null ? performItemAction(findItemWithShortcutForKey, i4) : false;
        if ((i4 & 2) != 0) {
            close(true);
        }
        return performItemAction;
    }

    @Override // android.view.Menu
    public void removeGroup(int i3) {
        int findGroupIndex = findGroupIndex(i3);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                if (i4 >= size || this.mItems.get(findGroupIndex).getGroupId() != i3) {
                    break;
                }
                removeItemAtInt(findGroupIndex, false);
                i4 = i5;
            }
            onItemsChanged(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i3) {
        removeItemAtInt(findItemIndex(i3), true);
    }

    public void removeItemAt(int i3) {
        removeItemAtInt(i3, true);
    }

    public void removeMenuPresenter(MenuPresenter menuPresenter) {
        Iterator<WeakReference<MenuPresenter>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> next = it.next();
            MenuPresenter menuPresenter2 = next.get();
            if (menuPresenter2 == null || menuPresenter2 == menuPresenter) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).restoreActionViewStates(bundle);
            }
        }
        int i4 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
        if (i4 <= 0 || (findItem = findItem(i4)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public void restorePresenterStates(Bundle bundle) {
        dispatchRestoreInstanceState(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = getItem(i3);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuBuilder) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        dispatchSaveInstanceState(bundle);
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public MenuBuilder setDefaultShowAsAction(int i3) {
        this.mDefaultShowAsAction = i3;
        return this;
    }

    void setExclusiveItemChecked(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i3);
            if (menuItemImpl.getGroupId() == groupId && menuItemImpl.isExclusiveCheckable() && menuItemImpl.isCheckable()) {
                menuItemImpl.setCheckedInt(menuItemImpl == menuItem);
            }
        }
        startDispatchingItemsChanged();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i3, boolean z3, boolean z4) {
        int size = this.mItems.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i4);
            if (menuItemImpl.getGroupId() == i3) {
                menuItemImpl.setExclusiveCheckable(z4);
                menuItemImpl.setCheckable(z3);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z3) {
        this.mGroupDividerEnabled = z3;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i3, boolean z3) {
        int size = this.mItems.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i4);
            if (menuItemImpl.getGroupId() == i3) {
                menuItemImpl.setEnabled(z3);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i3, boolean z3) {
        int size = this.mItems.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = this.mItems.get(i4);
            if (menuItemImpl.getGroupId() == i3 && menuItemImpl.setVisibleInt(z3)) {
                z4 = true;
            }
        }
        if (z4) {
            onItemsChanged(true);
        }
    }

    protected MenuBuilder setHeaderIconInt(Drawable drawable) {
        setHeaderInternal(0, null, 0, drawable, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(CharSequence charSequence) {
        setHeaderInternal(0, charSequence, 0, null, null);
        return this;
    }

    protected MenuBuilder setHeaderViewInt(View view) {
        setHeaderInternal(0, null, 0, null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z3) {
        this.mOptionalIconsVisible = z3;
    }

    public void setOverrideVisibleItems(boolean z3) {
        this.mOverrideVisibleItems = z3;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z3) {
        this.mQwertyMode = z3;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z3) {
        if (this.mShortcutsVisible == z3) {
            return;
        }
        setShortcutsVisibleInner(z3);
        onItemsChanged(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (this.mPreventDispatchingItemsChanged) {
            return;
        }
        this.mPreventDispatchingItemsChanged = true;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3) {
        return addInternal(0, 0, 0, this.mResources.getString(i3));
    }

    public void addMenuPresenter(MenuPresenter menuPresenter, Context context) {
        this.mPresenters.add(new WeakReference<>(menuPresenter));
        menuPresenter.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3) {
        return addSubMenu(0, 0, 0, this.mResources.getString(i3));
    }

    public int findGroupIndex(int i3, int i4) {
        int size = size();
        if (i4 < 0) {
            i4 = 0;
        }
        while (i4 < size) {
            if (this.mItems.get(i4).getGroupId() == i3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, MenuPresenter menuPresenter, int i3) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) menuItem;
        if (menuItemImpl == null || !menuItemImpl.isEnabled()) {
            return false;
        }
        boolean invoke = menuItemImpl.invoke();
        AbstractC0253b supportActionProvider = menuItemImpl.getSupportActionProvider();
        boolean z3 = supportActionProvider != null && supportActionProvider.hasSubMenu();
        if (menuItemImpl.hasCollapsibleActionView()) {
            invoke |= menuItemImpl.expandActionView();
            if (invoke) {
                close(true);
            }
        } else if (menuItemImpl.hasSubMenu() || z3) {
            if ((i3 & 4) == 0) {
                close(false);
            }
            if (!menuItemImpl.hasSubMenu()) {
                menuItemImpl.setSubMenu(new SubMenuBuilder(getContext(), this, menuItemImpl));
            }
            SubMenuBuilder subMenuBuilder = (SubMenuBuilder) menuItemImpl.getSubMenu();
            if (z3) {
                supportActionProvider.onPrepareSubMenu(subMenuBuilder);
            }
            invoke |= dispatchSubMenuSelected(subMenuBuilder, menuPresenter);
            if (!invoke) {
                close(true);
            }
        } else if ((i3 & 1) == 0) {
            close(true);
        }
        return invoke;
    }

    protected MenuBuilder setHeaderIconInt(int i3) {
        setHeaderInternal(0, null, i3, null, null);
        return this;
    }

    protected MenuBuilder setHeaderTitleInt(int i3) {
        setHeaderInternal(i3, null, 0, null, null);
        return this;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, CharSequence charSequence) {
        return addInternal(i3, i4, i5, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, CharSequence charSequence) {
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i3, i4, i5, charSequence);
        SubMenuBuilder subMenuBuilder = new SubMenuBuilder(this.mContext, this, menuItemImpl);
        menuItemImpl.setSubMenu(subMenuBuilder);
        return subMenuBuilder;
    }

    @Override // android.view.Menu
    public MenuItem add(int i3, int i4, int i5, int i6) {
        return addInternal(i3, i4, i5, this.mResources.getString(i6));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i3, int i4, int i5, int i6) {
        return addSubMenu(i3, i4, i5, this.mResources.getString(i6));
    }

    @Override // android.view.Menu
    public void close() {
        close(true);
    }
}
