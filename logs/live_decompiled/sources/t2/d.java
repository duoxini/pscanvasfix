package T2;

import C2.l;
import C2.p;
import D2.j;
import D2.k;
import L2.B0;
import L2.InterfaceC0178j;
import Q2.A;
import Q2.AbstractC0196c;
import Q2.B;
import Q2.D;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p2.q;

/* loaded from: classes.dex */
public class d {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2212c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "head");

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f2213d = AtomicLongFieldUpdater.newUpdater(d.class, "deqIdx");

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2214e = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "tail");

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f2215f = AtomicLongFieldUpdater.newUpdater(d.class, "enqIdx");

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f2216g = AtomicIntegerFieldUpdater.newUpdater(d.class, "_availablePermits");
    private volatile int _availablePermits;

    /* renamed from: a, reason: collision with root package name */
    private final int f2217a;

    /* renamed from: b, reason: collision with root package name */
    private final l f2218b;
    private volatile long deqIdx;
    private volatile long enqIdx;
    private volatile Object head;
    private volatile Object tail;

    /* synthetic */ class a extends j implements p {

        /* renamed from: n, reason: collision with root package name */
        public static final a f2219n = new a();

        a() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f i(long j3, f fVar) {
            f h3;
            h3 = e.h(j3, fVar);
            return h3;
        }

        @Override // C2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return i(((Number) obj).longValue(), (f) obj2);
        }
    }

    static final class b extends D2.l implements l {
        b() {
            super(1);
        }

        public final void a(Throwable th) {
            d.this.h();
        }

        @Override // C2.l
        public /* bridge */ /* synthetic */ Object f(Object obj) {
            a((Throwable) obj);
            return q.f12810a;
        }
    }

    /* synthetic */ class c extends j implements p {

        /* renamed from: n, reason: collision with root package name */
        public static final c f2221n = new c();

        c() {
            super(2, e.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        public final f i(long j3, f fVar) {
            f h3;
            h3 = e.h(j3, fVar);
            return h3;
        }

        @Override // C2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return i(((Number) obj).longValue(), (f) obj2);
        }
    }

    public d(int i3, int i4) {
        this.f2217a = i3;
        if (i3 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i3).toString());
        }
        if (i4 < 0 || i4 > i3) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i3).toString());
        }
        f fVar = new f(0L, null, 2);
        this.head = fVar;
        this.tail = fVar;
        this._availablePermits = i3 - i4;
        this.f2218b = new b();
    }

    private final boolean d(B0 b02) {
        int i3;
        Object c3;
        int i4;
        D d3;
        D d4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2214e;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f2215f.getAndIncrement(this);
        a aVar = a.f2219n;
        i3 = e.f2227f;
        long j3 = andIncrement / i3;
        loop0: while (true) {
            c3 = AbstractC0196c.c(fVar, j3, aVar);
            if (!B.c(c3)) {
                A b3 = B.b(c3);
                while (true) {
                    A a3 = (A) atomicReferenceFieldUpdater.get(this);
                    if (a3.f1961g >= b3.f1961g) {
                        break loop0;
                    }
                    if (!b3.q()) {
                        break;
                    }
                    if (atomicReferenceFieldUpdater.compareAndSet(this, a3, b3)) {
                        if (a3.m()) {
                            a3.k();
                        }
                    } else if (b3.m()) {
                        b3.k();
                    }
                }
            } else {
                break;
            }
        }
        f fVar2 = (f) B.b(c3);
        i4 = e.f2227f;
        int i5 = (int) (andIncrement % i4);
        if (fVar2.r().compareAndSet(i5, null, b02)) {
            b02.b(fVar2, i5);
            return true;
        }
        d3 = e.f2223b;
        d4 = e.f2224c;
        if (!fVar2.r().compareAndSet(i5, d3, d4)) {
            return false;
        }
        if (b02 instanceof InterfaceC0178j) {
            k.c(b02, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((InterfaceC0178j) b02).m(q.f12810a, this.f2218b);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + b02).toString());
    }

    private final void e() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        int i4;
        do {
            atomicIntegerFieldUpdater = f2216g;
            i3 = atomicIntegerFieldUpdater.get(this);
            i4 = this.f2217a;
            if (i3 <= i4) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, i4));
    }

    private final int f() {
        int andDecrement;
        do {
            andDecrement = f2216g.getAndDecrement(this);
        } while (andDecrement > this.f2217a);
        return andDecrement;
    }

    private final boolean j(Object obj) {
        if (!(obj instanceof InterfaceC0178j)) {
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        InterfaceC0178j interfaceC0178j = (InterfaceC0178j) obj;
        Object k3 = interfaceC0178j.k(q.f12810a, null, this.f2218b);
        if (k3 == null) {
            return false;
        }
        interfaceC0178j.s(k3);
        return true;
    }

    private final boolean k() {
        int i3;
        Object c3;
        int i4;
        D d3;
        D d4;
        int i5;
        D d5;
        D d6;
        D d7;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2212c;
        f fVar = (f) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f2213d.getAndIncrement(this);
        i3 = e.f2227f;
        long j3 = andIncrement / i3;
        c cVar = c.f2221n;
        loop0: while (true) {
            c3 = AbstractC0196c.c(fVar, j3, cVar);
            if (B.c(c3)) {
                break;
            }
            A b3 = B.b(c3);
            while (true) {
                A a3 = (A) atomicReferenceFieldUpdater.get(this);
                if (a3.f1961g >= b3.f1961g) {
                    break loop0;
                }
                if (!b3.q()) {
                    break;
                }
                if (atomicReferenceFieldUpdater.compareAndSet(this, a3, b3)) {
                    if (a3.m()) {
                        a3.k();
                    }
                } else if (b3.m()) {
                    b3.k();
                }
            }
        }
        f fVar2 = (f) B.b(c3);
        fVar2.b();
        if (fVar2.f1961g > j3) {
            return false;
        }
        i4 = e.f2227f;
        int i6 = (int) (andIncrement % i4);
        d3 = e.f2223b;
        Object andSet = fVar2.r().getAndSet(i6, d3);
        if (andSet != null) {
            d4 = e.f2226e;
            if (andSet == d4) {
                return false;
            }
            return j(andSet);
        }
        i5 = e.f2222a;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = fVar2.r().get(i6);
            d7 = e.f2224c;
            if (obj == d7) {
                return true;
            }
        }
        d5 = e.f2223b;
        d6 = e.f2225d;
        return !fVar2.r().compareAndSet(i6, d5, d6);
    }

    protected final void c(InterfaceC0178j interfaceC0178j) {
        while (f() <= 0) {
            k.c(interfaceC0178j, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (d((B0) interfaceC0178j)) {
                return;
            }
        }
        interfaceC0178j.m(q.f12810a, this.f2218b);
    }

    public int g() {
        return Math.max(f2216g.get(this), 0);
    }

    public void h() {
        do {
            int andIncrement = f2216g.getAndIncrement(this);
            if (andIncrement >= this.f2217a) {
                e();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f2217a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!k());
    }

    public boolean i() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2216g;
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 > this.f2217a) {
                e();
            } else {
                if (i3 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 - 1)) {
                    return true;
                }
            }
        }
    }
}
