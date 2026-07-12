package y0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: c, reason: collision with root package name */
    private static d f14483c;

    /* renamed from: d, reason: collision with root package name */
    private static d f14484d;

    /* renamed from: a, reason: collision with root package name */
    private final HandlerThread f14485a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f14486b;

    private static class b extends d {
        private b() {
            super();
        }

        @Override // y0.d
        protected HandlerThread g() {
            return new HandlerThread("COUIAudioWorkHandler", -16);
        }
    }

    private static class c extends d {
        private c() {
            super();
        }

        @Override // y0.d
        protected HandlerThread g() {
            return new HandlerThread("COUIDefaultWorkHandler", 0);
        }
    }

    private void a() {
        if (Looper.myLooper() != null && Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("Current thread is not origin thread!");
        }
    }

    private void b() {
        if (c() != null || d().getLooper() == null) {
            return;
        }
        h(new Handler(d().getLooper()));
    }

    public static d e() {
        return f(0);
    }

    public static d f(int i3) {
        if (1 == i3) {
            if (f14484d == null) {
                f14484d = new b();
            }
            return f14484d;
        }
        if (f14483c == null) {
            f14483c = new c();
        }
        return f14483c;
    }

    protected Handler c() {
        return this.f14486b;
    }

    protected HandlerThread d() {
        return this.f14485a;
    }

    protected abstract HandlerThread g();

    protected void h(Handler handler) {
        this.f14486b = handler;
    }

    public void i(Runnable runnable) {
        a();
        b();
        c().post(runnable);
    }

    private d() {
        HandlerThread g3 = g();
        this.f14485a = g3;
        g3.start();
    }
}
