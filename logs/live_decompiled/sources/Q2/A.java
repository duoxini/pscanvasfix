package Q2;

import L2.r0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public abstract class A extends AbstractC0197d implements r0 {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1960h = AtomicIntegerFieldUpdater.newUpdater(A.class, "cleanedAndPointers");
    private volatile int cleanedAndPointers;

    /* renamed from: g, reason: collision with root package name */
    public final long f1961g;

    public A(long j3, A a3, int i3) {
        super(a3);
        this.f1961g = j3;
        this.cleanedAndPointers = i3 << 16;
    }

    @Override // Q2.AbstractC0197d
    public boolean h() {
        return f1960h.get(this) == n() && !i();
    }

    public final boolean m() {
        return f1960h.addAndGet(this, -65536) == n() && !i();
    }

    public abstract int n();

    public abstract void o(int i3, Throwable th, t2.g gVar);

    public final void p() {
        if (f1960h.incrementAndGet(this) == n()) {
            k();
        }
    }

    public final boolean q() {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1960h;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 == n() && !i()) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 65536 + i3));
        return true;
    }
}
