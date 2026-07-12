package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.app.p;
import androidx.core.view.AbstractC0257f;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.o;
import androidx.lifecycle.q;

/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements o, AbstractC0257f.a {
    private m.g mExtraDataMap = new m.g();
    private q mLifecycleRegistry = new q(this);

    public static class a {
    }

    private static boolean a(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            String str = strArr[0];
            str.hashCode();
            switch (str) {
                case "--translation":
                    return true;
                case "--dump-dumpable":
                case "--list-dumpables":
                    return androidx.core.os.a.b();
                case "--contentcapture":
                case "--autofill":
                    return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !AbstractC0257f.a(decorView, keyEvent)) {
            return AbstractC0257f.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !AbstractC0257f.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        p.a(this.mExtraDataMap.get(cls));
        return null;
    }

    public AbstractC0272h getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.f(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.j(AbstractC0272h.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(a aVar) {
        throw null;
    }

    protected final boolean shouldDumpInternalState(String[] strArr) {
        return !a(strArr);
    }

    @Override // androidx.core.view.AbstractC0257f.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
