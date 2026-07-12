package N2;

import L2.AbstractC0181m;
import L2.B0;
import L2.C0179k;
import L2.InterfaceC0178j;
import Q2.A;
import Q2.AbstractC0196c;
import Q2.AbstractC0197d;
import Q2.AbstractC0203j;
import Q2.B;
import Q2.C;
import Q2.D;
import Q2.M;
import Q2.v;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p2.AbstractC0501a;
import p2.C0511k;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;
import v2.AbstractC0611b;

/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f1629h = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f1630i = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f1631j = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* renamed from: k, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f1632k = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1633l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1634m = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* renamed from: n, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1635n = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* renamed from: o, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1636o = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* renamed from: p, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1637p = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    /* renamed from: e, reason: collision with root package name */
    private final int f1638e;

    /* renamed from: f, reason: collision with root package name */
    public final C2.l f1639f;

    /* renamed from: g, reason: collision with root package name */
    private final C2.q f1640g;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    private final class a implements f, B0 {

        /* renamed from: e, reason: collision with root package name */
        private Object f1641e;

        /* renamed from: f, reason: collision with root package name */
        private C0179k f1642f;

        public a() {
            D d3;
            d3 = c.f1660p;
            this.f1641e = d3;
        }

        private final Object f(i iVar, int i3, long j3, InterfaceC0593d interfaceC0593d) {
            D d3;
            D d4;
            Boolean a3;
            D d5;
            D d6;
            D d7;
            b bVar = b.this;
            C0179k a4 = AbstractC0181m.a(AbstractC0603b.b(interfaceC0593d));
            try {
                this.f1642f = a4;
                Object v02 = bVar.v0(iVar, i3, j3, this);
                d3 = c.f1657m;
                if (v02 == d3) {
                    bVar.i0(this, iVar, i3);
                } else {
                    d4 = c.f1659o;
                    C2.l lVar = null;
                    if (v02 == d4) {
                        if (j3 < bVar.M()) {
                            iVar.b();
                        }
                        i iVar2 = (i) b.f1634m.get(bVar);
                        while (true) {
                            if (bVar.T()) {
                                h();
                                break;
                            }
                            long andIncrement = b.f1630i.getAndIncrement(bVar);
                            int i4 = c.f1646b;
                            long j4 = andIncrement / i4;
                            int i5 = (int) (andIncrement % i4);
                            if (iVar2.f1961g != j4) {
                                i F3 = bVar.F(j4, iVar2);
                                if (F3 != null) {
                                    iVar2 = F3;
                                }
                            }
                            Object v03 = bVar.v0(iVar2, i5, andIncrement, this);
                            d5 = c.f1657m;
                            if (v03 == d5) {
                                bVar.i0(this, iVar2, i5);
                                break;
                            }
                            d6 = c.f1659o;
                            if (v03 != d6) {
                                d7 = c.f1658n;
                                if (v03 == d7) {
                                    throw new IllegalStateException("unexpected");
                                }
                                iVar2.b();
                                this.f1641e = v03;
                                this.f1642f = null;
                                a3 = AbstractC0611b.a(true);
                                C2.l lVar2 = bVar.f1639f;
                                if (lVar2 != null) {
                                    lVar = v.a(lVar2, v03, a4.getContext());
                                }
                            } else if (andIncrement < bVar.M()) {
                                iVar2.b();
                            }
                        }
                    } else {
                        iVar.b();
                        this.f1641e = v02;
                        this.f1642f = null;
                        a3 = AbstractC0611b.a(true);
                        C2.l lVar3 = bVar.f1639f;
                        if (lVar3 != null) {
                            lVar = v.a(lVar3, v02, a4.getContext());
                        }
                    }
                    a4.m(a3, lVar);
                }
                Object v3 = a4.v();
                if (v3 == AbstractC0603b.c()) {
                    v2.h.c(interfaceC0593d);
                }
                return v3;
            } catch (Throwable th) {
                a4.G();
                throw th;
            }
        }

        private final boolean g() {
            this.f1641e = c.z();
            Throwable I3 = b.this.I();
            if (I3 == null) {
                return false;
            }
            throw C.a(I3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            C0179k c0179k = this.f1642f;
            D2.k.b(c0179k);
            this.f1642f = null;
            this.f1641e = c.z();
            Throwable I3 = b.this.I();
            if (I3 == null) {
                C0511k.a aVar = C0511k.f12803f;
                c0179k.resumeWith(C0511k.b(Boolean.FALSE));
            } else {
                C0511k.a aVar2 = C0511k.f12803f;
                c0179k.resumeWith(C0511k.b(p2.l.a(I3)));
            }
        }

        @Override // N2.f
        public Object a(InterfaceC0593d interfaceC0593d) {
            i iVar;
            D d3;
            D d4;
            D d5;
            b bVar = b.this;
            i iVar2 = (i) b.f1634m.get(bVar);
            while (!bVar.T()) {
                long andIncrement = b.f1630i.getAndIncrement(bVar);
                int i3 = c.f1646b;
                long j3 = andIncrement / i3;
                int i4 = (int) (andIncrement % i3);
                if (iVar2.f1961g != j3) {
                    i F3 = bVar.F(j3, iVar2);
                    if (F3 == null) {
                        continue;
                    } else {
                        iVar = F3;
                    }
                } else {
                    iVar = iVar2;
                }
                Object v02 = bVar.v0(iVar, i4, andIncrement, null);
                d3 = c.f1657m;
                if (v02 == d3) {
                    throw new IllegalStateException("unreachable");
                }
                d4 = c.f1659o;
                if (v02 != d4) {
                    d5 = c.f1658n;
                    if (v02 == d5) {
                        return f(iVar, i4, andIncrement, interfaceC0593d);
                    }
                    iVar.b();
                    this.f1641e = v02;
                    return AbstractC0611b.a(true);
                }
                if (andIncrement < bVar.M()) {
                    iVar.b();
                }
                iVar2 = iVar;
            }
            return AbstractC0611b.a(g());
        }

        @Override // L2.B0
        public void b(A a3, int i3) {
            C0179k c0179k = this.f1642f;
            if (c0179k != null) {
                c0179k.b(a3, i3);
            }
        }

        public final boolean i(Object obj) {
            boolean B3;
            C0179k c0179k = this.f1642f;
            D2.k.b(c0179k);
            this.f1642f = null;
            this.f1641e = obj;
            Boolean bool = Boolean.TRUE;
            C2.l lVar = b.this.f1639f;
            B3 = c.B(c0179k, bool, lVar != null ? v.a(lVar, obj, c0179k.getContext()) : null);
            return B3;
        }

        public final void j() {
            C0179k c0179k = this.f1642f;
            D2.k.b(c0179k);
            this.f1642f = null;
            this.f1641e = c.z();
            Throwable I3 = b.this.I();
            if (I3 == null) {
                C0511k.a aVar = C0511k.f12803f;
                c0179k.resumeWith(C0511k.b(Boolean.FALSE));
            } else {
                C0511k.a aVar2 = C0511k.f12803f;
                c0179k.resumeWith(C0511k.b(p2.l.a(I3)));
            }
        }

        @Override // N2.f
        public Object next() {
            D d3;
            D d4;
            Object obj = this.f1641e;
            d3 = c.f1660p;
            if (obj == d3) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            d4 = c.f1660p;
            this.f1641e = d4;
            if (obj != c.z()) {
                return obj;
            }
            throw C.a(b.this.J());
        }
    }

    /* renamed from: N2.b$b, reason: collision with other inner class name */
    static final class C0030b extends D2.l implements C2.q {
        C0030b() {
            super(3);
        }
    }

    public b(int i3, C2.l lVar) {
        long A3;
        D d3;
        this.f1638e = i3;
        this.f1639f = lVar;
        if (i3 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i3 + ", should be >=0").toString());
        }
        A3 = c.A(i3);
        this.bufferEnd = A3;
        this.completedExpandBuffersAndPauseFlag = H();
        i iVar = new i(0L, null, this, 3);
        this.sendSegment = iVar;
        this.receiveSegment = iVar;
        if (X()) {
            iVar = c.f1645a;
            D2.k.c(iVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = iVar;
        this.f1640g = lVar != null ? new C0030b() : null;
        d3 = c.f1663s;
        this._closeCause = d3;
    }

    private final i A(long j3) {
        i x3 = x();
        if (W()) {
            long Y2 = Y(x3);
            if (Y2 != -1) {
                C(Y2);
            }
        }
        w(x3, j3);
        return x3;
    }

    private final void A0(long j3) {
        long j4;
        long w3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1629h;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            long j5 = 1152921504606846975L & j4;
            if (j5 >= j3) {
                return;
            } else {
                w3 = c.w(j5, (int) (j4 >> 60));
            }
        } while (!f1629h.compareAndSet(this, j4, w3));
    }

    private final void B() {
        o();
    }

    private final void D() {
        if (X()) {
            return;
        }
        i iVar = (i) f1635n.get(this);
        while (true) {
            long andIncrement = f1631j.getAndIncrement(this);
            int i3 = c.f1646b;
            long j3 = andIncrement / i3;
            if (M() <= andIncrement) {
                if (iVar.f1961g < j3 && iVar.e() != null) {
                    c0(j3, iVar);
                }
                P(this, 0L, 1, null);
                return;
            }
            if (iVar.f1961g != j3) {
                i E3 = E(j3, iVar, andIncrement);
                if (E3 == null) {
                    continue;
                } else {
                    iVar = E3;
                }
            }
            if (t0(iVar, (int) (andIncrement % i3), andIncrement)) {
                P(this, 0L, 1, null);
                return;
            }
            P(this, 0L, 1, null);
        }
    }

    private final i E(long j3, i iVar, long j4) {
        Object c3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1635n;
        C2.p pVar = (C2.p) c.y();
        loop0: while (true) {
            c3 = AbstractC0196c.c(iVar, j3, pVar);
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
        if (B.c(c3)) {
            B();
            c0(j3, iVar);
            P(this, 0L, 1, null);
            return null;
        }
        i iVar2 = (i) B.b(c3);
        long j5 = iVar2.f1961g;
        if (j5 <= j3) {
            return iVar2;
        }
        int i3 = c.f1646b;
        if (f1631j.compareAndSet(this, j4 + 1, i3 * j5)) {
            O((iVar2.f1961g * i3) - j4);
            return null;
        }
        P(this, 0L, 1, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i F(long j3, i iVar) {
        Object c3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1634m;
        C2.p pVar = (C2.p) c.y();
        loop0: while (true) {
            c3 = AbstractC0196c.c(iVar, j3, pVar);
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
        if (B.c(c3)) {
            B();
            if (iVar.f1961g * c.f1646b >= M()) {
                return null;
            }
            iVar.b();
            return null;
        }
        i iVar2 = (i) B.b(c3);
        if (!X() && j3 <= H() / c.f1646b) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1635n;
            while (true) {
                A a4 = (A) atomicReferenceFieldUpdater2.get(this);
                if (a4.f1961g >= iVar2.f1961g || !iVar2.q()) {
                    break;
                }
                if (atomicReferenceFieldUpdater2.compareAndSet(this, a4, iVar2)) {
                    if (a4.m()) {
                        a4.k();
                    }
                } else if (iVar2.m()) {
                    iVar2.k();
                }
            }
        }
        long j4 = iVar2.f1961g;
        if (j4 <= j3) {
            return iVar2;
        }
        int i3 = c.f1646b;
        z0(j4 * i3);
        if (iVar2.f1961g * i3 >= M()) {
            return null;
        }
        iVar2.b();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i G(long j3, i iVar) {
        Object c3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1633l;
        C2.p pVar = (C2.p) c.y();
        loop0: while (true) {
            c3 = AbstractC0196c.c(iVar, j3, pVar);
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
        if (B.c(c3)) {
            B();
            if (iVar.f1961g * c.f1646b >= K()) {
                return null;
            }
            iVar.b();
            return null;
        }
        i iVar2 = (i) B.b(c3);
        long j4 = iVar2.f1961g;
        if (j4 <= j3) {
            return iVar2;
        }
        int i3 = c.f1646b;
        A0(j4 * i3);
        if (iVar2.f1961g * i3 >= K()) {
            return null;
        }
        iVar2.b();
        return null;
    }

    private final long H() {
        return f1631j.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable J() {
        Throwable I3 = I();
        return I3 == null ? new l("Channel was closed") : I3;
    }

    private final void O(long j3) {
        if ((f1632k.addAndGet(this, j3) & 4611686018427387904L) != 0) {
            while ((f1632k.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    static /* synthetic */ void P(b bVar, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i3 & 1) != 0) {
            j3 = 1;
        }
        bVar.O(j3);
    }

    private final void Q() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1637p;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, obj == null ? c.f1661q : c.f1662r));
        if (obj == null) {
            return;
        }
        ((C2.l) obj).f(I());
    }

    private final boolean R(i iVar, int i3, long j3) {
        Object w3;
        D d3;
        D d4;
        D d5;
        D d6;
        D d7;
        D d8;
        D d9;
        do {
            w3 = iVar.w(i3);
            if (w3 != null) {
                d4 = c.f1649e;
                if (w3 != d4) {
                    if (w3 == c.f1648d) {
                        return true;
                    }
                    d5 = c.f1654j;
                    if (w3 == d5 || w3 == c.z()) {
                        return false;
                    }
                    d6 = c.f1653i;
                    if (w3 == d6) {
                        return false;
                    }
                    d7 = c.f1652h;
                    if (w3 == d7) {
                        return false;
                    }
                    d8 = c.f1651g;
                    if (w3 == d8) {
                        return true;
                    }
                    d9 = c.f1650f;
                    return w3 != d9 && j3 == K();
                }
            }
            d3 = c.f1652h;
        } while (!iVar.r(i3, w3, d3));
        D();
        return false;
    }

    private final boolean S(long j3, boolean z3) {
        int i3 = (int) (j3 >> 60);
        if (i3 == 0 || i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            A(j3 & 1152921504606846975L);
            if (z3 && N()) {
                return false;
            }
        } else {
            if (i3 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i3).toString());
            }
            z(j3 & 1152921504606846975L);
        }
        return true;
    }

    private final boolean U(long j3) {
        return S(j3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V(long j3) {
        return S(j3, false);
    }

    private final boolean X() {
        long H3 = H();
        return H3 == 0 || H3 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        r8 = (N2.i) r8.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long Y(N2.i r8) {
        /*
            r7 = this;
        L0:
            int r0 = N2.c.f1646b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f1961g
            int r5 = N2.c.f1646b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.K()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.w(r0)
            if (r1 == 0) goto L2c
            Q2.D r2 = N2.c.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            Q2.D r2 = N2.c.f1648d
            if (r1 != r2) goto L39
            return r3
        L2c:
            Q2.D r2 = N2.c.z()
            boolean r1 = r8.r(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.p()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            Q2.d r8 = r8.g()
            N2.i r8 = (N2.i) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.Y(N2.i):long");
    }

    private final void Z() {
        long j3;
        long w3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1629h;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if (((int) (j3 >> 60)) != 0) {
                return;
            } else {
                w3 = c.w(1152921504606846975L & j3, 1);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, w3));
    }

    private final void a0() {
        long j3;
        long w3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1629h;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            w3 = c.w(1152921504606846975L & j3, 3);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, w3));
    }

    private final void b0() {
        long j3;
        long w3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1629h;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            int i3 = (int) (j3 >> 60);
            if (i3 == 0) {
                w3 = c.w(j3 & 1152921504606846975L, 2);
            } else if (i3 != 1) {
                return;
            } else {
                w3 = c.w(j3 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, w3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void c0(long r5, N2.i r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f1961g
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            Q2.d r0 = r7.e()
            N2.i r0 = (N2.i) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.h()
            if (r5 == 0) goto L22
            Q2.d r5 = r7.e()
            N2.i r5 = (N2.i) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = N2.b.f1635n
        L24:
            java.lang.Object r6 = r5.get(r4)
            Q2.A r6 = (Q2.A) r6
            long r0 = r6.f1961g
            long r2 = r7.f1961g
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.q()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r4 = r6.m()
            if (r4 == 0) goto L49
            r6.k()
        L49:
            return
        L4a:
            boolean r6 = r7.m()
            if (r6 == 0) goto L24
            r7.k()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.c0(long, N2.i):void");
    }

    private final Object e0(Object obj, InterfaceC0593d interfaceC0593d) {
        M d3;
        C0179k c0179k = new C0179k(AbstractC0603b.b(interfaceC0593d), 1);
        c0179k.y();
        C2.l lVar = this.f1639f;
        if (lVar == null || (d3 = v.d(lVar, obj, null, 2, null)) == null) {
            Throwable L3 = L();
            C0511k.a aVar = C0511k.f12803f;
            c0179k.resumeWith(C0511k.b(p2.l.a(L3)));
        } else {
            AbstractC0501a.a(d3, L());
            C0511k.a aVar2 = C0511k.f12803f;
            c0179k.resumeWith(C0511k.b(p2.l.a(d3)));
        }
        Object v3 = c0179k.v();
        if (v3 == AbstractC0603b.c()) {
            v2.h.c(interfaceC0593d);
        }
        return v3 == AbstractC0603b.c() ? v3 : p2.q.f12810a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(Object obj, InterfaceC0178j interfaceC0178j) {
        C2.l lVar = this.f1639f;
        if (lVar != null) {
            v.b(lVar, obj, interfaceC0178j.getContext());
        }
        Throwable L3 = L();
        C0511k.a aVar = C0511k.f12803f;
        interfaceC0178j.resumeWith(C0511k.b(p2.l.a(L3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(B0 b02, i iVar, int i3) {
        h0();
        b02.b(iVar, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(B0 b02, i iVar, int i3) {
        b02.b(iVar, i3 + c.f1646b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x00b3, code lost:
    
        r12 = (N2.i) r12.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void k0(N2.i r12) {
        /*
            r11 = this;
            C2.l r0 = r11.f1639f
            r1 = 0
            r2 = 1
            java.lang.Object r3 = Q2.AbstractC0203j.b(r1, r2, r1)
        L8:
            int r4 = N2.c.f1646b
            int r4 = r4 - r2
        Lb:
            r5 = -1
            if (r5 >= r4) goto Lb3
            long r6 = r12.f1961g
            int r8 = N2.c.f1646b
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L16:
            java.lang.Object r8 = r12.w(r4)
            Q2.D r9 = N2.c.f()
            if (r8 == r9) goto Lbb
            Q2.D r9 = N2.c.f1648d
            if (r8 != r9) goto L48
            long r9 = r11.K()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            Q2.D r9 = N2.c.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L40
            java.lang.Object r5 = r12.v(r4)
            Q2.M r1 = Q2.v.c(r0, r5, r1)
        L40:
            r12.s(r4)
            r12.p()
            goto Laf
        L48:
            Q2.D r9 = N2.c.k()
            if (r8 == r9) goto La2
            if (r8 != 0) goto L51
            goto La2
        L51:
            boolean r9 = r8 instanceof L2.B0
            if (r9 != 0) goto L6e
            boolean r9 = r8 instanceof N2.t
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            Q2.D r9 = N2.c.p()
            if (r8 == r9) goto Lbb
            Q2.D r9 = N2.c.q()
            if (r8 != r9) goto L67
            goto Lbb
        L67:
            Q2.D r9 = N2.c.p()
            if (r8 == r9) goto L16
            goto Laf
        L6e:
            long r9 = r11.K()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto Lbb
            boolean r9 = r8 instanceof N2.t
            if (r9 == 0) goto L80
            r9 = r8
            N2.t r9 = (N2.t) r9
            L2.B0 r9 = r9.f1681a
            goto L83
        L80:
            r9 = r8
            L2.B0 r9 = (L2.B0) r9
        L83:
            Q2.D r10 = N2.c.z()
            boolean r8 = r12.r(r4, r8, r10)
            if (r8 == 0) goto L16
            if (r0 == 0) goto L97
            java.lang.Object r5 = r12.v(r4)
            Q2.M r1 = Q2.v.c(r0, r5, r1)
        L97:
            java.lang.Object r3 = Q2.AbstractC0203j.c(r3, r9)
            r12.s(r4)
            r12.p()
            goto Laf
        La2:
            Q2.D r9 = N2.c.z()
            boolean r8 = r12.r(r4, r8, r9)
            if (r8 == 0) goto L16
            r12.p()
        Laf:
            int r4 = r4 + (-1)
            goto Lb
        Lb3:
            Q2.d r12 = r12.g()
            N2.i r12 = (N2.i) r12
            if (r12 != 0) goto L8
        Lbb:
            if (r3 == 0) goto Le1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto Lc7
            L2.B0 r3 = (L2.B0) r3
            r11.m0(r3)
            goto Le1
        Lc7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            D2.k.c(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        Ld3:
            if (r5 >= r12) goto Le1
            java.lang.Object r0 = r3.get(r12)
            L2.B0 r0 = (L2.B0) r0
            r11.m0(r0)
            int r12 = r12 + (-1)
            goto Ld3
        Le1:
            if (r1 != 0) goto Le4
            return
        Le4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.k0(N2.i):void");
    }

    private final void l0(B0 b02) {
        n0(b02, true);
    }

    private final void m0(B0 b02) {
        n0(b02, false);
    }

    private final void n0(B0 b02, boolean z3) {
        if (b02 instanceof InterfaceC0178j) {
            InterfaceC0593d interfaceC0593d = (InterfaceC0593d) b02;
            C0511k.a aVar = C0511k.f12803f;
            interfaceC0593d.resumeWith(C0511k.b(p2.l.a(z3 ? J() : L())));
        } else {
            if (b02 instanceof a) {
                ((a) b02).j();
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + b02).toString());
        }
    }

    static /* synthetic */ Object o0(b bVar, Object obj, InterfaceC0593d interfaceC0593d) {
        i iVar = (i) f1633l.get(bVar);
        while (true) {
            long andIncrement = f1629h.getAndIncrement(bVar);
            long j3 = 1152921504606846975L & andIncrement;
            boolean V3 = bVar.V(andIncrement);
            int i3 = c.f1646b;
            long j4 = j3 / i3;
            int i4 = (int) (j3 % i3);
            if (iVar.f1961g != j4) {
                i G3 = bVar.G(j4, iVar);
                if (G3 != null) {
                    iVar = G3;
                } else if (V3) {
                    Object e02 = bVar.e0(obj, interfaceC0593d);
                    if (e02 == AbstractC0603b.c()) {
                        return e02;
                    }
                }
            }
            int x02 = bVar.x0(iVar, i4, obj, j3, null, V3);
            if (x02 == 0) {
                iVar.b();
                break;
            }
            if (x02 == 1) {
                break;
            }
            if (x02 != 2) {
                if (x02 == 3) {
                    Object p02 = bVar.p0(iVar, i4, obj, j3, interfaceC0593d);
                    if (p02 == AbstractC0603b.c()) {
                        return p02;
                    }
                } else if (x02 == 4) {
                    if (j3 < bVar.K()) {
                        iVar.b();
                    }
                    Object e03 = bVar.e0(obj, interfaceC0593d);
                    if (e03 == AbstractC0603b.c()) {
                        return e03;
                    }
                } else if (x02 == 5) {
                    iVar.b();
                }
            } else if (V3) {
                iVar.p();
                Object e04 = bVar.e0(obj, interfaceC0593d);
                if (e04 == AbstractC0603b.c()) {
                    return e04;
                }
            }
        }
        return p2.q.f12810a;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object p0(N2.i r21, int r22, java.lang.Object r23, long r24, t2.InterfaceC0593d r26) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.p0(N2.i, int, java.lang.Object, long, t2.d):java.lang.Object");
    }

    private final boolean q0(long j3) {
        if (V(j3)) {
            return false;
        }
        return !u(j3 & 1152921504606846975L);
    }

    private final boolean r0(Object obj, Object obj2) {
        boolean B3;
        if (obj instanceof a) {
            D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(obj2);
        }
        if (!(obj instanceof InterfaceC0178j)) {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
        InterfaceC0178j interfaceC0178j = (InterfaceC0178j) obj;
        C2.l lVar = this.f1639f;
        B3 = c.B(interfaceC0178j, obj2, lVar != null ? v.a(lVar, obj2, interfaceC0178j.getContext()) : null);
        return B3;
    }

    private final boolean s0(Object obj, i iVar, int i3) {
        if (obj instanceof InterfaceC0178j) {
            D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return c.C((InterfaceC0178j) obj, p2.q.f12810a, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final boolean t0(i iVar, int i3, long j3) {
        D d3;
        D d4;
        Object w3 = iVar.w(i3);
        if ((w3 instanceof B0) && j3 >= f1630i.get(this)) {
            d3 = c.f1651g;
            if (iVar.r(i3, w3, d3)) {
                if (s0(w3, iVar, i3)) {
                    iVar.A(i3, c.f1648d);
                    return true;
                }
                d4 = c.f1654j;
                iVar.A(i3, d4);
                iVar.x(i3, false);
                return false;
            }
        }
        return u0(iVar, i3, j3);
    }

    private final boolean u(long j3) {
        return j3 < H() || j3 < K() + ((long) this.f1638e);
    }

    private final boolean u0(i iVar, int i3, long j3) {
        D d3;
        D d4;
        D d5;
        D d6;
        D d7;
        D d8;
        D d9;
        D d10;
        while (true) {
            Object w3 = iVar.w(i3);
            if (!(w3 instanceof B0)) {
                d5 = c.f1654j;
                if (w3 != d5) {
                    if (w3 != null) {
                        if (w3 != c.f1648d) {
                            d7 = c.f1652h;
                            if (w3 == d7) {
                                break;
                            }
                            d8 = c.f1653i;
                            if (w3 == d8) {
                                break;
                            }
                            d9 = c.f1655k;
                            if (w3 == d9 || w3 == c.z()) {
                                return true;
                            }
                            d10 = c.f1650f;
                            if (w3 != d10) {
                                throw new IllegalStateException(("Unexpected cell state: " + w3).toString());
                            }
                        } else {
                            return true;
                        }
                    } else {
                        d6 = c.f1649e;
                        if (iVar.r(i3, w3, d6)) {
                            return true;
                        }
                    }
                } else {
                    return false;
                }
            } else if (j3 >= f1630i.get(this)) {
                d3 = c.f1651g;
                if (iVar.r(i3, w3, d3)) {
                    if (s0(w3, iVar, i3)) {
                        iVar.A(i3, c.f1648d);
                        return true;
                    }
                    d4 = c.f1654j;
                    iVar.A(i3, d4);
                    iVar.x(i3, false);
                    return false;
                }
            } else if (iVar.r(i3, w3, new t((B0) w3))) {
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v0(i iVar, int i3, long j3, Object obj) {
        D d3;
        D d4;
        D d5;
        Object w3 = iVar.w(i3);
        if (w3 == null) {
            if (j3 >= (f1629h.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    d5 = c.f1658n;
                    return d5;
                }
                if (iVar.r(i3, w3, obj)) {
                    D();
                    d4 = c.f1657m;
                    return d4;
                }
            }
        } else if (w3 == c.f1648d) {
            d3 = c.f1653i;
            if (iVar.r(i3, w3, d3)) {
                D();
                return iVar.y(i3);
            }
        }
        return w0(iVar, i3, j3, obj);
    }

    private final void w(i iVar, long j3) {
        D d3;
        Object b3 = AbstractC0203j.b(null, 1, null);
        loop0: while (iVar != null) {
            for (int i3 = c.f1646b - 1; -1 < i3; i3--) {
                if ((iVar.f1961g * c.f1646b) + i3 < j3) {
                    break loop0;
                }
                while (true) {
                    Object w3 = iVar.w(i3);
                    if (w3 != null) {
                        d3 = c.f1649e;
                        if (w3 != d3) {
                            if (!(w3 instanceof t)) {
                                if (!(w3 instanceof B0)) {
                                    break;
                                }
                                if (iVar.r(i3, w3, c.z())) {
                                    b3 = AbstractC0203j.c(b3, w3);
                                    iVar.x(i3, true);
                                    break;
                                }
                            } else {
                                if (iVar.r(i3, w3, c.z())) {
                                    b3 = AbstractC0203j.c(b3, ((t) w3).f1681a);
                                    iVar.x(i3, true);
                                    break;
                                }
                            }
                        }
                    }
                    if (iVar.r(i3, w3, c.z())) {
                        iVar.p();
                        break;
                    }
                }
            }
            iVar = (i) iVar.g();
        }
        if (b3 != null) {
            if (!(b3 instanceof ArrayList)) {
                l0((B0) b3);
                return;
            }
            D2.k.c(b3, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) b3;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                l0((B0) arrayList.get(size));
            }
        }
    }

    private final Object w0(i iVar, int i3, long j3, Object obj) {
        D d3;
        D d4;
        D d5;
        D d6;
        D d7;
        D d8;
        D d9;
        D d10;
        D d11;
        D d12;
        D d13;
        D d14;
        D d15;
        D d16;
        D d17;
        D d18;
        while (true) {
            Object w3 = iVar.w(i3);
            if (w3 != null) {
                d7 = c.f1649e;
                if (w3 != d7) {
                    if (w3 == c.f1648d) {
                        d8 = c.f1653i;
                        if (iVar.r(i3, w3, d8)) {
                            D();
                            return iVar.y(i3);
                        }
                    } else {
                        d9 = c.f1654j;
                        if (w3 == d9) {
                            d10 = c.f1659o;
                            return d10;
                        }
                        d11 = c.f1652h;
                        if (w3 == d11) {
                            d12 = c.f1659o;
                            return d12;
                        }
                        if (w3 == c.z()) {
                            D();
                            d13 = c.f1659o;
                            return d13;
                        }
                        d14 = c.f1651g;
                        if (w3 != d14) {
                            d15 = c.f1650f;
                            if (iVar.r(i3, w3, d15)) {
                                boolean z3 = w3 instanceof t;
                                if (z3) {
                                    w3 = ((t) w3).f1681a;
                                }
                                if (s0(w3, iVar, i3)) {
                                    d18 = c.f1653i;
                                    iVar.A(i3, d18);
                                    D();
                                    return iVar.y(i3);
                                }
                                d16 = c.f1654j;
                                iVar.A(i3, d16);
                                iVar.x(i3, false);
                                if (z3) {
                                    D();
                                }
                                d17 = c.f1659o;
                                return d17;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (j3 < (f1629h.get(this) & 1152921504606846975L)) {
                d3 = c.f1652h;
                if (iVar.r(i3, w3, d3)) {
                    D();
                    d4 = c.f1659o;
                    return d4;
                }
            } else {
                if (obj == null) {
                    d5 = c.f1658n;
                    return d5;
                }
                if (iVar.r(i3, w3, obj)) {
                    D();
                    d6 = c.f1657m;
                    return d6;
                }
            }
        }
    }

    private final i x() {
        Object obj = f1635n.get(this);
        i iVar = (i) f1633l.get(this);
        if (iVar.f1961g > ((i) obj).f1961g) {
            obj = iVar;
        }
        i iVar2 = (i) f1634m.get(this);
        if (iVar2.f1961g > ((i) obj).f1961g) {
            obj = iVar2;
        }
        return (i) AbstractC0196c.b((AbstractC0197d) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int x0(i iVar, int i3, Object obj, long j3, Object obj2, boolean z3) {
        D d3;
        D d4;
        D d5;
        iVar.B(i3, obj);
        if (z3) {
            return y0(iVar, i3, obj, j3, obj2, z3);
        }
        Object w3 = iVar.w(i3);
        if (w3 == null) {
            if (u(j3)) {
                if (iVar.r(i3, null, c.f1648d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (iVar.r(i3, null, obj2)) {
                    return 2;
                }
            }
        } else if (w3 instanceof B0) {
            iVar.s(i3);
            if (r0(w3, obj)) {
                d5 = c.f1653i;
                iVar.A(i3, d5);
                g0();
                return 0;
            }
            d3 = c.f1655k;
            Object t3 = iVar.t(i3, d3);
            d4 = c.f1655k;
            if (t3 != d4) {
                iVar.x(i3, true);
            }
            return 5;
        }
        return y0(iVar, i3, obj, j3, obj2, z3);
    }

    private final int y0(i iVar, int i3, Object obj, long j3, Object obj2, boolean z3) {
        D d3;
        D d4;
        D d5;
        D d6;
        D d7;
        D d8;
        D d9;
        while (true) {
            Object w3 = iVar.w(i3);
            if (w3 != null) {
                d4 = c.f1649e;
                if (w3 != d4) {
                    d5 = c.f1655k;
                    if (w3 == d5) {
                        iVar.s(i3);
                        return 5;
                    }
                    d6 = c.f1652h;
                    if (w3 == d6) {
                        iVar.s(i3);
                        return 5;
                    }
                    if (w3 == c.z()) {
                        iVar.s(i3);
                        B();
                        return 4;
                    }
                    iVar.s(i3);
                    if (w3 instanceof t) {
                        w3 = ((t) w3).f1681a;
                    }
                    if (r0(w3, obj)) {
                        d9 = c.f1653i;
                        iVar.A(i3, d9);
                        g0();
                        return 0;
                    }
                    d7 = c.f1655k;
                    Object t3 = iVar.t(i3, d7);
                    d8 = c.f1655k;
                    if (t3 != d8) {
                        iVar.x(i3, true);
                    }
                    return 5;
                }
                if (iVar.r(i3, w3, c.f1648d)) {
                    return 1;
                }
            } else if (!u(j3) || z3) {
                if (z3) {
                    d3 = c.f1654j;
                    if (iVar.r(i3, null, d3)) {
                        iVar.x(i3, false);
                        return 4;
                    }
                } else {
                    if (obj2 == null) {
                        return 3;
                    }
                    if (iVar.r(i3, null, obj2)) {
                        return 2;
                    }
                }
            } else if (iVar.r(i3, null, c.f1648d)) {
                return 1;
            }
        }
    }

    private final void z(long j3) {
        k0(A(j3));
    }

    private final void z0(long j3) {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1630i;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if (j4 >= j3) {
                return;
            }
        } while (!f1630i.compareAndSet(this, j4, j3));
    }

    public final void B0(long j3) {
        int i3;
        long j4;
        long v3;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long v4;
        long j5;
        long v5;
        if (X()) {
            return;
        }
        while (H() <= j3) {
        }
        i3 = c.f1647c;
        for (int i4 = 0; i4 < i3; i4++) {
            long H3 = H();
            if (H3 == (4611686018427387903L & f1632k.get(this)) && H3 == H()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f1632k;
        do {
            j4 = atomicLongFieldUpdater2.get(this);
            v3 = c.v(j4 & 4611686018427387903L, true);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j4, v3));
        while (true) {
            long H4 = H();
            atomicLongFieldUpdater = f1632k;
            long j6 = atomicLongFieldUpdater.get(this);
            long j7 = j6 & 4611686018427387903L;
            boolean z3 = (4611686018427387904L & j6) != 0;
            if (H4 == j7 && H4 == H()) {
                break;
            } else if (!z3) {
                v4 = c.v(j7, true);
                atomicLongFieldUpdater.compareAndSet(this, j6, v4);
            }
        }
        do {
            j5 = atomicLongFieldUpdater.get(this);
            v5 = c.v(j5 & 4611686018427387903L, false);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, v5));
    }

    protected final void C(long j3) {
        D d3;
        M d4;
        i iVar = (i) f1634m.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f1630i;
            long j4 = atomicLongFieldUpdater.get(this);
            if (j3 < Math.max(this.f1638e + j4, H())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j4, j4 + 1)) {
                int i3 = c.f1646b;
                long j5 = j4 / i3;
                int i4 = (int) (j4 % i3);
                if (iVar.f1961g != j5) {
                    i F3 = F(j5, iVar);
                    if (F3 == null) {
                        continue;
                    } else {
                        iVar = F3;
                    }
                }
                Object v02 = v0(iVar, i4, j4, null);
                d3 = c.f1659o;
                if (v02 != d3) {
                    iVar.b();
                    C2.l lVar = this.f1639f;
                    if (lVar != null && (d4 = v.d(lVar, v02, null, 2, null)) != null) {
                        throw d4;
                    }
                } else if (j4 < M()) {
                    iVar.b();
                }
            }
        }
    }

    protected final Throwable I() {
        return (Throwable) f1636o.get(this);
    }

    public final long K() {
        return f1630i.get(this);
    }

    protected final Throwable L() {
        Throwable I3 = I();
        return I3 == null ? new m("Channel was closed") : I3;
    }

    public final long M() {
        return f1629h.get(this) & 1152921504606846975L;
    }

    public final boolean N() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1634m;
            i iVar = (i) atomicReferenceFieldUpdater.get(this);
            long K3 = K();
            if (M() <= K3) {
                return false;
            }
            int i3 = c.f1646b;
            long j3 = K3 / i3;
            if (iVar.f1961g == j3 || (iVar = F(j3, iVar)) != null) {
                iVar.b();
                if (R(iVar, (int) (K3 % i3), K3)) {
                    return true;
                }
                f1630i.compareAndSet(this, K3, K3 + 1);
            } else if (((i) atomicReferenceFieldUpdater.get(this)).f1961g < j3) {
                return false;
            }
        }
    }

    public boolean T() {
        return U(f1629h.get(this));
    }

    protected boolean W() {
        return false;
    }

    @Override // N2.r
    public final void b(CancellationException cancellationException) {
        v(cancellationException);
    }

    @Override // N2.s
    public void d(C2.l lVar) {
        D d3;
        D d4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        D d5;
        D d6;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1637p;
        if (atomicReferenceFieldUpdater2.compareAndSet(this, null, lVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater2.get(this);
            d3 = c.f1661q;
            if (obj != d3) {
                d4 = c.f1662r;
                if (obj == d4) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            atomicReferenceFieldUpdater = f1637p;
            d5 = c.f1661q;
            d6 = c.f1662r;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, d5, d6));
        lVar.f(I());
    }

    protected void d0() {
    }

    @Override // N2.s
    public boolean e(Throwable th) {
        return y(th, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return N2.h.f1669a.c(p2.q.f12810a);
     */
    @Override // N2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.Object r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = N2.b.f1629h
            long r0 = r0.get(r14)
            boolean r0 = r14.q0(r0)
            if (r0 == 0) goto L13
            N2.h$b r14 = N2.h.f1669a
            java.lang.Object r14 = r14.b()
            return r14
        L13:
            Q2.D r8 = N2.c.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = j()
            java.lang.Object r0 = r0.get(r14)
            N2.i r0 = (N2.i) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = k()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = l(r14, r1)
            int r1 = N2.c.f1646b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f1961g
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L59
            N2.i r1 = c(r14, r2, r0)
            if (r1 != 0) goto L57
            if (r11 == 0) goto L21
        L4b:
            N2.h$b r15 = N2.h.f1669a
            java.lang.Throwable r14 = r14.L()
            java.lang.Object r14 = r15.a(r14)
            goto Lba
        L57:
            r13 = r1
            goto L5a
        L59:
            r13 = r0
        L5a:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = t(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb6
            r1 = 1
            if (r0 == r1) goto Lad
            r1 = 2
            if (r0 == r1) goto L90
            r1 = 3
            if (r0 == r1) goto L88
            r1 = 4
            if (r0 == r1) goto L7c
            r1 = 5
            if (r0 == r1) goto L77
            goto L7a
        L77:
            r13.b()
        L7a:
            r0 = r13
            goto L21
        L7c:
            long r0 = r14.K()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L4b
            r13.b()
            goto L4b
        L88:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            r14.<init>(r15)
            throw r14
        L90:
            if (r11 == 0) goto L96
            r13.p()
            goto L4b
        L96:
            boolean r15 = r8 instanceof L2.B0
            if (r15 == 0) goto L9d
            L2.B0 r8 = (L2.B0) r8
            goto L9e
        L9d:
            r8 = 0
        L9e:
            if (r8 == 0) goto La3
            q(r14, r8, r13, r12)
        La3:
            r13.p()
            N2.h$b r14 = N2.h.f1669a
            java.lang.Object r14 = r14.b()
            goto Lba
        Lad:
            N2.h$b r14 = N2.h.f1669a
            p2.q r15 = p2.q.f12810a
            java.lang.Object r14 = r14.c(r15)
            goto Lba
        Lb6:
            r13.b()
            goto Lad
        Lba:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.f(java.lang.Object):java.lang.Object");
    }

    protected void g0() {
    }

    protected void h0() {
    }

    @Override // N2.r
    public f iterator() {
        return new a();
    }

    @Override // N2.s
    public Object n(Object obj, InterfaceC0593d interfaceC0593d) {
        return o0(this, obj, interfaceC0593d);
    }

    @Override // N2.s
    public boolean o() {
        return V(f1629h.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x01b1, code lost:
    
        r3 = (N2.i) r3.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01b8, code lost:
    
        if (r3 != null) goto L82;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 481
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.b.toString():java.lang.String");
    }

    public boolean v(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return y(th, true);
    }

    protected boolean y(Throwable th, boolean z3) {
        D d3;
        if (z3) {
            Z();
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1636o;
        d3 = c.f1663s;
        boolean compareAndSet = atomicReferenceFieldUpdater.compareAndSet(this, d3, th);
        if (z3) {
            a0();
        } else {
            b0();
        }
        B();
        d0();
        if (compareAndSet) {
            Q();
        }
        return compareAndSet;
    }
}
