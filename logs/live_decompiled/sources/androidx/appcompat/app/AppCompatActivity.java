package androidx.appcompat.app;

import M.c;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.a0;
import androidx.core.app.i;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import b.InterfaceC0290b;

/* loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements d, i.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private f mDelegate;
    private Resources mResources;

    class a implements c.InterfaceC0026c {
        a() {
        }

        @Override // M.c.InterfaceC0026c
        public Bundle a() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.getDelegate().z(bundle);
            return bundle;
        }
    }

    class b implements InterfaceC0290b {
        b() {
        }

        @Override // b.InterfaceC0290b
        public void a(Context context) {
            f delegate = AppCompatActivity.this.getDelegate();
            delegate.q();
            delegate.v(AppCompatActivity.this.getSavedStateRegistry().b(AppCompatActivity.DELEGATE_TAG));
        }
    }

    public AppCompatActivity() {
        i();
    }

    private void d() {
        J.a(getWindow().getDecorView(), this);
        K.a(getWindow().getDecorView(), this);
        M.f.a(getWindow().getDecorView(), this);
        androidx.activity.m.a(getWindow().getDecorView(), this);
    }

    private void i() {
        getSavedStateRegistry().h(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private boolean j(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        getDelegate().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().e(context));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i3) {
        return (T) getDelegate().h(i3);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.f(this, this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        return getDelegate().l();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().o();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && a0.c()) {
            this.mResources = new a0(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public androidx.appcompat.app.a getSupportActionBar() {
        return getDelegate().p();
    }

    @Override // androidx.core.app.i.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.e.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().r();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().u(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.i iVar) {
        iVar.b(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().w();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (j(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    protected void onLocalesChanged(androidx.core.os.f fVar) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.j() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i3, Menu menu) {
        return super.onMenuOpened(i3, menu);
    }

    protected void onNightModeChanged(int i3) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().x(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().y();
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.i iVar) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        getDelegate().A();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        getDelegate().B();
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeFinished(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.appcompat.app.d
    public void onSupportActionModeStarted(androidx.appcompat.view.b bVar) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        androidx.core.app.i d3 = androidx.core.app.i.d(this);
        onCreateSupportNavigateUpTaskStack(d3);
        onPrepareSupportNavigateUpTaskStack(d3);
        d3.e();
        try {
            androidx.core.app.a.j(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i3) {
        super.onTitleChanged(charSequence, i3);
        getDelegate().L(charSequence);
    }

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i3) {
        d();
        getDelegate().F(i3);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().J(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i3) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z3) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z3) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z3) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        super.setTheme(i3);
        getDelegate().K(i3);
    }

    public androidx.appcompat.view.b startSupportActionMode(b.a aVar) {
        return getDelegate().M(aVar);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().r();
    }

    public void supportNavigateUpTo(Intent intent) {
        androidx.core.app.e.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i3) {
        return getDelegate().E(i3);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return androidx.core.app.e.f(this, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        d();
        getDelegate().G(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        getDelegate().H(view, layoutParams);
    }
}
