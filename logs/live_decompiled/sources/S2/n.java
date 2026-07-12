package S2;

import D2.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2176b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f2177c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f2178d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f2179e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray f2180a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    private final h b(h hVar) {
        if (d() == 127) {
            return hVar;
        }
        if (hVar.f2164f.a() == 1) {
            f2179e.incrementAndGet(this);
        }
        int i3 = f2177c.get(this) & 127;
        while (this.f2180a.get(i3) != null) {
            Thread.yield();
        }
        this.f2180a.lazySet(i3, hVar);
        f2177c.incrementAndGet(this);
        return null;
    }

    private final void c(h hVar) {
        if (hVar == null || hVar.f2164f.a() != 1) {
            return;
        }
        f2179e.decrementAndGet(this);
    }

    private final int d() {
        return f2177c.get(this) - f2178d.get(this);
    }

    private final h i() {
        h hVar;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2178d;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 - f2177c.get(this) == 0) {
                return null;
            }
            int i4 = i3 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 + 1) && (hVar = (h) this.f2180a.getAndSet(i4, null)) != null) {
                c(hVar);
                return hVar;
            }
        }
    }

    private final boolean j(d dVar) {
        h i3 = i();
        if (i3 == null) {
            return false;
        }
        dVar.a(i3);
        return true;
    }

    private final h k(boolean z3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f2176b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar != null) {
                if ((hVar.f2164f.a() == 1) == z3) {
                }
            }
            int i3 = f2178d.get(this);
            int i4 = f2177c.get(this);
            while (i3 != i4) {
                if (z3 && f2179e.get(this) == 0) {
                    return null;
                }
                i4--;
                h m3 = m(i4, z3);
                if (m3 != null) {
                    return m3;
                }
            }
            return null;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, hVar, null));
        return hVar;
    }

    private final h l(int i3) {
        int i4 = f2178d.get(this);
        int i5 = f2177c.get(this);
        boolean z3 = i3 == 1;
        while (i4 != i5) {
            if (z3 && f2179e.get(this) == 0) {
                return null;
            }
            int i6 = i4 + 1;
            h m3 = m(i4, z3);
            if (m3 != null) {
                return m3;
            }
            i4 = i6;
        }
        return null;
    }

    private final h m(int i3, boolean z3) {
        int i4 = i3 & 127;
        h hVar = (h) this.f2180a.get(i4);
        if (hVar != null) {
            if ((hVar.f2164f.a() == 1) == z3 && this.f2180a.compareAndSet(i4, hVar, null)) {
                if (z3) {
                    f2179e.decrementAndGet(this);
                }
                return hVar;
            }
        }
        return null;
    }

    private final long o(int i3, r rVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        h hVar;
        do {
            atomicReferenceFieldUpdater = f2176b;
            hVar = (h) atomicReferenceFieldUpdater.get(this);
            if (hVar == null) {
                return -2L;
            }
            if (((hVar.f2164f.a() != 1 ? 2 : 1) & i3) == 0) {
                return -2L;
            }
            long a3 = l.f2172f.a() - hVar.f2163e;
            long j3 = l.f2168b;
            if (a3 < j3) {
                return j3 - a3;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, hVar, null));
        rVar.f337e = hVar;
        return -1L;
    }

    public final h a(h hVar, boolean z3) {
        if (z3) {
            return b(hVar);
        }
        h hVar2 = (h) f2176b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return b(hVar2);
    }

    public final int e() {
        Object obj = f2176b.get(this);
        int d3 = d();
        return obj != null ? d3 + 1 : d3;
    }

    public final void f(d dVar) {
        h hVar = (h) f2176b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h g() {
        h hVar = (h) f2176b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final h h() {
        return k(true);
    }

    public final long n(int i3, r rVar) {
        h i4 = i3 == 3 ? i() : l(i3);
        if (i4 == null) {
            return o(i3, rVar);
        }
        rVar.f337e = i4;
        return -1L;
    }
}
