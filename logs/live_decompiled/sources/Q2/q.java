package Q2;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: e, reason: collision with root package name */
    public static final a f2007e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2008f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f2009g = AtomicLongFieldUpdater.newUpdater(q.class, "_state");

    /* renamed from: h, reason: collision with root package name */
    public static final D f2010h = new D("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    private final int f2011a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f2012b;

    /* renamed from: c, reason: collision with root package name */
    private final int f2013c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicReferenceArray f2014d;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final int a(long j3) {
            return (j3 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j3, int i3) {
            return d(j3, 1073741823L) | i3;
        }

        public final long c(long j3, int i3) {
            return d(j3, 1152921503533105152L) | (i3 << 30);
        }

        public final long d(long j3, long j4) {
            return j3 & (~j4);
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f2015a;

        public b(int i3) {
            this.f2015a = i3;
        }
    }

    public q(int i3, boolean z3) {
        this.f2011a = i3;
        this.f2012b = z3;
        int i4 = i3 - 1;
        this.f2013c = i4;
        this.f2014d = new AtomicReferenceArray(i3);
        if (i4 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i3 & i4) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    private final q b(long j3) {
        q qVar = new q(this.f2011a * 2, this.f2012b);
        int i3 = (int) (1073741823 & j3);
        int i4 = (int) ((1152921503533105152L & j3) >> 30);
        while (true) {
            int i5 = this.f2013c;
            if ((i3 & i5) == (i4 & i5)) {
                f2009g.set(qVar, f2007e.d(j3, 1152921504606846976L));
                return qVar;
            }
            Object obj = this.f2014d.get(i5 & i3);
            if (obj == null) {
                obj = new b(i3);
            }
            qVar.f2014d.set(qVar.f2013c & i3, obj);
            i3++;
        }
    }

    private final q c(long j3) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2008f;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar != null) {
                return qVar;
            }
            f2008f.compareAndSet(this, null, b(j3));
        }
    }

    private final q e(int i3, Object obj) {
        Object obj2 = this.f2014d.get(this.f2013c & i3);
        if (!(obj2 instanceof b) || ((b) obj2).f2015a != i3) {
            return null;
        }
        this.f2014d.set(i3 & this.f2013c, obj);
        return this;
    }

    private final long h() {
        long j3;
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2009g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if ((j3 & 1152921504606846976L) != 0) {
                return j3;
            }
            j4 = j3 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, j4));
        return j4;
    }

    private final q k(int i3, int i4) {
        long j3;
        int i5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2009g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            i5 = (int) (1073741823 & j3);
            if ((1152921504606846976L & j3) != 0) {
                return i();
            }
        } while (!f2009g.compareAndSet(this, j3, f2007e.b(j3, i4)));
        this.f2014d.set(this.f2013c & i5, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = Q2.q.f2009g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            Q2.q$a r12 = Q2.q.f2007e
            int r12 = r12.a(r3)
            return r12
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f2013c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L30
            return r6
        L30:
            boolean r2 = r12.f2012b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f2014d
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L4f
            int r2 = r12.f2011a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = Q2.q.f2009g
            Q2.q$a r5 = Q2.q.f2007e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f2014d
            r1 = r9 & r10
            r0.set(r1, r13)
        L69:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = Q2.q.f2009g
            long r0 = r0.get(r12)
            r2 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r0 = r0 & r2
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 == 0) goto L80
            Q2.q r12 = r12.i()
            Q2.q r12 = r12.e(r9, r13)
            if (r12 != 0) goto L69
        L80:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2.q.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2009g;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            if ((j3 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j3) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, j3 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j3 = f2009g.get(this);
        return 1073741823 & (((int) ((j3 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j3)));
    }

    public final boolean g() {
        long j3 = f2009g.get(this);
        return ((int) (1073741823 & j3)) == ((int) ((j3 & 1152921503533105152L) >> 30));
    }

    public final q i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2009g;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j3) != 0) {
                return f2010h;
            }
            int i3 = (int) (1073741823 & j3);
            int i4 = this.f2013c;
            if ((((int) ((1152921503533105152L & j3) >> 30)) & i4) == (i3 & i4)) {
                return null;
            }
            Object obj = this.f2014d.get(i4 & i3);
            if (obj == null) {
                if (this.f2012b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i5 = (i3 + 1) & 1073741823;
                if (f2009g.compareAndSet(this, j3, f2007e.b(j3, i5))) {
                    this.f2014d.set(this.f2013c & i3, null);
                    return obj;
                }
                if (this.f2012b) {
                    do {
                        this = this.k(i3, i5);
                    } while (this != null);
                    return obj;
                }
            }
        }
    }
}
