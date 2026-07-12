package B;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import m.g;

/* loaded from: classes.dex */
class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f89g = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    private c f93d;

    /* renamed from: a, reason: collision with root package name */
    private final g f90a = new g();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f91b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final C0004a f92c = new C0004a();

    /* renamed from: e, reason: collision with root package name */
    long f94e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f95f = false;

    /* renamed from: B.a$a, reason: collision with other inner class name */
    class C0004a {
        C0004a() {
        }

        void a() {
            a.this.f94e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f94e);
            if (a.this.f91b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    interface b {
        boolean doAnimationFrame(long j3);
    }

    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final C0004a f97a;

        c(C0004a c0004a) {
            this.f97a = c0004a;
        }

        abstract void a();
    }

    private static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f98b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f99c;

        /* renamed from: B.a$d$a, reason: collision with other inner class name */
        class ChoreographerFrameCallbackC0005a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0005a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j3) {
                d.this.f97a.a();
            }
        }

        d(C0004a c0004a) {
            super(c0004a);
            this.f98b = Choreographer.getInstance();
            this.f99c = new ChoreographerFrameCallbackC0005a();
        }

        @Override // B.a.c
        void a() {
            this.f98b.postFrameCallback(this.f99c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f95f) {
            for (int size = this.f91b.size() - 1; size >= 0; size--) {
                if (this.f91b.get(size) == null) {
                    this.f91b.remove(size);
                }
            }
            this.f95f = false;
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f89g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    private boolean f(b bVar, long j3) {
        Long l3 = (Long) this.f90a.get(bVar);
        if (l3 == null) {
            return true;
        }
        if (l3.longValue() >= j3) {
            return false;
        }
        this.f90a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j3) {
        if (this.f91b.size() == 0) {
            e().a();
        }
        if (!this.f91b.contains(bVar)) {
            this.f91b.add(bVar);
        }
        if (j3 > 0) {
            this.f90a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j3));
        }
    }

    void c(long j3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i3 = 0; i3 < this.f91b.size(); i3++) {
            b bVar = (b) this.f91b.get(i3);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.doAnimationFrame(j3);
            }
        }
        b();
    }

    c e() {
        if (this.f93d == null) {
            this.f93d = new d(this.f92c);
        }
        return this.f93d;
    }

    public void g(b bVar) {
        this.f90a.remove(bVar);
        int indexOf = this.f91b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f91b.set(indexOf, null);
            this.f95f = true;
        }
    }
}
