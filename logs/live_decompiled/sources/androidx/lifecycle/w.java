package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.ReportFragment;

/* loaded from: classes.dex */
public class w implements o {

    /* renamed from: m, reason: collision with root package name */
    private static final w f5823m = new w();

    /* renamed from: i, reason: collision with root package name */
    private Handler f5828i;

    /* renamed from: e, reason: collision with root package name */
    private int f5824e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f5825f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5826g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5827h = true;

    /* renamed from: j, reason: collision with root package name */
    private final q f5829j = new q(this);

    /* renamed from: k, reason: collision with root package name */
    private Runnable f5830k = new a();

    /* renamed from: l, reason: collision with root package name */
    ReportFragment.a f5831l = new b();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.f();
            w.this.g();
        }
    }

    class b implements ReportFragment.a {
        b() {
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void a() {
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void b() {
            w.this.b();
        }

        @Override // androidx.lifecycle.ReportFragment.a
        public void c() {
            w.this.c();
        }
    }

    class c extends AbstractC0268d {

        class a extends AbstractC0268d {
            a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                w.this.b();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                w.this.c();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.AbstractC0268d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // androidx.lifecycle.AbstractC0268d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            w.this.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // androidx.lifecycle.AbstractC0268d, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            w.this.d();
        }
    }

    private w() {
    }

    public static o h() {
        return f5823m;
    }

    static void i(Context context) {
        f5823m.e(context);
    }

    void a() {
        int i3 = this.f5825f - 1;
        this.f5825f = i3;
        if (i3 == 0) {
            this.f5828i.postDelayed(this.f5830k, 700L);
        }
    }

    void b() {
        int i3 = this.f5825f + 1;
        this.f5825f = i3;
        if (i3 == 1) {
            if (!this.f5826g) {
                this.f5828i.removeCallbacks(this.f5830k);
            } else {
                this.f5829j.h(AbstractC0272h.b.ON_RESUME);
                this.f5826g = false;
            }
        }
    }

    void c() {
        int i3 = this.f5824e + 1;
        this.f5824e = i3;
        if (i3 == 1 && this.f5827h) {
            this.f5829j.h(AbstractC0272h.b.ON_START);
            this.f5827h = false;
        }
    }

    void d() {
        this.f5824e--;
        g();
    }

    void e(Context context) {
        this.f5828i = new Handler();
        this.f5829j.h(AbstractC0272h.b.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }

    void f() {
        if (this.f5825f == 0) {
            this.f5826g = true;
            this.f5829j.h(AbstractC0272h.b.ON_PAUSE);
        }
    }

    void g() {
        if (this.f5824e == 0 && this.f5826g) {
            this.f5829j.h(AbstractC0272h.b.ON_STOP);
            this.f5827h = true;
        }
    }

    @Override // androidx.lifecycle.o
    public AbstractC0272h getLifecycle() {
        return this.f5829j;
    }
}
