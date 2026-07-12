package H1;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: e, reason: collision with root package name */
    private int f863e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f864f;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f865a = new a();
    }

    public static a a() {
        return b.f865a;
    }

    private boolean c() {
        return this.f863e == 1;
    }

    private boolean d() {
        return this.f863e == 0;
    }

    public synchronized void b(Application application) {
        if (!this.f864f) {
            application.registerActivityLifecycleCallbacks(this);
            this.f864f = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (c()) {
            r.e().i(activity.getApplicationContext());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f863e++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f863e--;
        if (d()) {
            r.e().g(activity.getApplicationContext());
        }
    }

    private a() {
        this.f863e = 0;
    }
}
