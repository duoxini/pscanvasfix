package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.view.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0253b {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private a mSubUiVisibilityListener;
    private InterfaceC0073b mVisibilityListener;

    /* renamed from: androidx.core.view.b$a */
    public interface a {
        void a(boolean z3);
    }

    /* renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0073b {
        void onActionProviderVisibilityChanged(boolean z3);
    }

    public AbstractC0253b(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public abstract boolean hasSubMenu();

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public abstract boolean onPerformDefaultAction();

    public abstract void onPrepareSubMenu(SubMenu subMenu);

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(a aVar) {
        this.mSubUiVisibilityListener = aVar;
    }

    public void setVisibilityListener(InterfaceC0073b interfaceC0073b) {
        if (this.mVisibilityListener != null && interfaceC0073b != null) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = interfaceC0073b;
    }

    public void subUiVisibilityChanged(boolean z3) {
        a aVar = this.mSubUiVisibilityListener;
        if (aVar != null) {
            aVar.a(z3);
        }
    }
}
