package androidx.appcompat.app;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.b;
import androidx.core.view.AbstractC0257f;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class j extends androidx.activity.f implements d {
    private f mDelegate;
    private final AbstractC0257f.a mKeyDispatcher;

    public j(Context context, int i3) {
        super(context, d(context, i3));
        this.mKeyDispatcher = new AbstractC0257f.a() { // from class: androidx.appcompat.app.i
            @Override // androidx.core.view.AbstractC0257f.a
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                return j.this.superDispatchKeyEvent(keyEvent);
            }
        };
        f delegate = getDelegate();
        delegate.K(d(context, i3));
        delegate.v(null);
    }

    private static int d(Context context, int i3) {
        if (i3 != 0) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(AbstractC0339a.f11108w, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().c(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().w();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return AbstractC0257f.b(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i3) {
        return (T) getDelegate().h(i3);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.g(this, this);
        }
        return this.mDelegate;
    }

    public a getSupportActionBar() {
        return getDelegate().p();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().r();
    }

    @Override // androidx.activity.f, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        getDelegate().q();
        super.onCreate(bundle);
        getDelegate().v(bundle);
    }

    @Override // androidx.activity.f, android.app.Dialog
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

    @Override // androidx.appcompat.app.d
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i3) {
        getDelegate().F(i3);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().L(charSequence);
    }

    boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i3) {
        return getDelegate().E(i3);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().G(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().H(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i3) {
        super.setTitle(i3);
        getDelegate().L(getContext().getString(i3));
    }
}
