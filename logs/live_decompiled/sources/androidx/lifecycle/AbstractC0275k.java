package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.lifecycle.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0275k {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f5809a = new AtomicBoolean(false);

    /* renamed from: androidx.lifecycle.k$a */
    static class a extends AbstractC0268d {
        a() {
        }

        @Override // androidx.lifecycle.AbstractC0268d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.f(activity);
        }

        @Override // androidx.lifecycle.AbstractC0268d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.AbstractC0268d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Context context) {
        if (f5809a.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    }
}
