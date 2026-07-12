package Q2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: Q2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0204k extends L2.A implements L2.K {

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1992l = AtomicIntegerFieldUpdater.newUpdater(C0204k.class, "runningWorkers");

    /* renamed from: g, reason: collision with root package name */
    private final L2.A f1993g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1994h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ L2.K f1995i;

    /* renamed from: j, reason: collision with root package name */
    private final p f1996j;

    /* renamed from: k, reason: collision with root package name */
    private final Object f1997k;
    private volatile int runningWorkers;

    /* renamed from: Q2.k$a */
    private final class a implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private Runnable f1998e;

        public a(Runnable runnable) {
            this.f1998e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3 = 0;
            while (true) {
                try {
                    this.f1998e.run();
                } catch (Throwable th) {
                    L2.C.a(t2.h.f13692e, th);
                }
                Runnable h02 = C0204k.this.h0();
                if (h02 == null) {
                    return;
                }
                this.f1998e = h02;
                i3++;
                if (i3 >= 16 && C0204k.this.f1993g.d0(C0204k.this)) {
                    C0204k.this.f1993g.c0(C0204k.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0204k(L2.A a3, int i3) {
        this.f1993g = a3;
        this.f1994h = i3;
        L2.K k3 = a3 instanceof L2.K ? (L2.K) a3 : null;
        this.f1995i = k3 == null ? L2.J.a() : k3;
        this.f1996j = new p(false);
        this.f1997k = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable h0() {
        while (true) {
            Runnable runnable = (Runnable) this.f1996j.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f1997k) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1992l;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f1996j.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    private final boolean i0() {
        synchronized (this.f1997k) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1992l;
            if (atomicIntegerFieldUpdater.get(this) >= this.f1994h) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // L2.A
    public void c0(t2.g gVar, Runnable runnable) {
        Runnable h02;
        this.f1996j.a(runnable);
        if (f1992l.get(this) >= this.f1994h || !i0() || (h02 = h0()) == null) {
            return;
        }
        this.f1993g.c0(this, new a(h02));
    }
}
