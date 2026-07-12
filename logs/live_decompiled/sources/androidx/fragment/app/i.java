package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public abstract class i extends f {

    /* renamed from: e, reason: collision with root package name */
    private final Activity f5439e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f5440f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f5441g;

    /* renamed from: h, reason: collision with root package name */
    private final int f5442h;

    /* renamed from: i, reason: collision with root package name */
    final l f5443i;

    i(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    Activity e() {
        return this.f5439e;
    }

    Context f() {
        return this.f5440f;
    }

    Handler g() {
        return this.f5441g;
    }

    public abstract Object h();

    public abstract LayoutInflater i();

    public void j(Fragment fragment, String[] strArr, int i3) {
    }

    public abstract boolean k(Fragment fragment);

    public abstract boolean l(String str);

    public void m(Fragment fragment, Intent intent, int i3, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        androidx.core.content.a.i(this.f5440f, intent, bundle);
    }

    public void n(Fragment fragment, IntentSender intentSender, int i3, Intent intent, int i4, int i5, int i6, Bundle bundle) {
        if (i3 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        androidx.core.app.a.s(this.f5439e, intentSender, i3, intent, i4, i5, i6, bundle);
    }

    public abstract void o();

    i(Activity activity, Context context, Handler handler, int i3) {
        this.f5443i = new m();
        this.f5439e = activity;
        this.f5440f = (Context) androidx.core.util.h.e(context, "context == null");
        this.f5441g = (Handler) androidx.core.util.h.e(handler, "handler == null");
        this.f5442h = i3;
    }
}
