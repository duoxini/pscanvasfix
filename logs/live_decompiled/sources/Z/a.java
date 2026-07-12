package Z;

import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import m.g;

/* loaded from: classes.dex */
class a {

    /* renamed from: g, reason: collision with root package name */
    public static final ThreadLocal f3010g = new ThreadLocal();

    /* renamed from: d, reason: collision with root package name */
    private c f3014d;

    /* renamed from: a, reason: collision with root package name */
    private final g f3011a = new g();

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f3012b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final C0047a f3013c = new C0047a();

    /* renamed from: e, reason: collision with root package name */
    long f3015e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3016f = false;

    /* renamed from: Z.a$a, reason: collision with other inner class name */
    class C0047a {
        C0047a() {
        }

        void a() {
            a.this.f3015e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f3015e);
            if (a.this.f3012b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    interface b {
        boolean doAnimationFrame(long j3);
    }

    static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        final C0047a f3018a;

        c(C0047a c0047a) {
            this.f3018a = c0047a;
        }

        abstract void a();
    }

    private static class d extends c {

        /* renamed from: b, reason: collision with root package name */
        private final Choreographer f3019b;

        /* renamed from: c, reason: collision with root package name */
        private final Choreographer.FrameCallback f3020c;

        /* renamed from: Z.a$d$a, reason: collision with other inner class name */
        class ChoreographerFrameCallbackC0048a implements Choreographer.FrameCallback {
            ChoreographerFrameCallbackC0048a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j3) {
                d.this.f3018a.a();
            }
        }

        d(C0047a c0047a) {
            super(c0047a);
            this.f3019b = Choreographer.getInstance();
            this.f3020c = new ChoreographerFrameCallbackC0048a();
        }

        @Override // Z.a.c
        void a() {
            this.f3019b.postFrameCallback(this.f3020c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f3016f) {
            for (int size = this.f3012b.size() - 1; size >= 0; size--) {
                if (this.f3012b.get(size) == null) {
                    this.f3012b.remove(size);
                }
            }
            this.f3016f = false;
        }
    }

    public static a d() {
        ThreadLocal threadLocal = f3010g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return (a) threadLocal.get();
    }

    private boolean f(b bVar, long j3) {
        Long l3 = (Long) this.f3011a.get(bVar);
        if (l3 == null) {
            return true;
        }
        if (l3.longValue() >= j3) {
            return false;
        }
        this.f3011a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j3) {
        if (this.f3012b.size() == 0) {
            e().a();
        }
        if (!this.f3012b.contains(bVar)) {
            this.f3012b.add(bVar);
        }
        if (j3 > 0) {
            this.f3011a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j3));
        }
    }

    void c(long j3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i3 = 0; i3 < this.f3012b.size(); i3++) {
            b bVar = (b) this.f3012b.get(i3);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.doAnimationFrame(j3);
            }
        }
        b();
    }

    c e() {
        if (this.f3014d == null) {
            this.f3014d = new d(this.f3013c);
        }
        return this.f3014d;
    }

    public void g(b bVar) {
        this.f3011a.remove(bVar);
        int indexOf = this.f3012b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f3012b.set(indexOf, null);
            this.f3016f = true;
        }
    }
}
