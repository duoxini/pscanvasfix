package S2;

import D2.r;
import L2.AbstractC0170c;
import L2.H;
import Q2.D;
import Q2.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import p2.q;

/* loaded from: classes.dex */
public final class a implements Executor, Closeable {

    /* renamed from: l, reason: collision with root package name */
    public static final C0039a f2126l = new C0039a(null);

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f2127m = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: n, reason: collision with root package name */
    private static final AtomicLongFieldUpdater f2128n = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: o, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f2129o = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: p, reason: collision with root package name */
    public static final D f2130p = new D("NOT_IN_STACK");
    private volatile int _isTerminated;
    private volatile long controlState;

    /* renamed from: e, reason: collision with root package name */
    public final int f2131e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2132f;

    /* renamed from: g, reason: collision with root package name */
    public final long f2133g;

    /* renamed from: h, reason: collision with root package name */
    public final String f2134h;

    /* renamed from: i, reason: collision with root package name */
    public final S2.d f2135i;

    /* renamed from: j, reason: collision with root package name */
    public final S2.d f2136j;

    /* renamed from: k, reason: collision with root package name */
    public final y f2137k;
    private volatile long parkedWorkersStack;

    /* renamed from: S2.a$a, reason: collision with other inner class name */
    public static final class C0039a {
        public /* synthetic */ C0039a(D2.g gVar) {
            this();
        }

        private C0039a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2138a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f2138a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i3, int i4, long j3, String str) {
        this.f2131e = i3;
        this.f2132f = i4;
        this.f2133g = j3;
        this.f2134h = str;
        if (i3 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i3 + " should be at least 1").toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should be greater than or equals to core pool size " + i3).toString());
        }
        if (i4 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j3 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j3 + " must be positive").toString());
        }
        this.f2135i = new S2.d();
        this.f2136j = new S2.d();
        this.f2137k = new y((i3 + 1) * 2);
        this.controlState = i3 << 42;
        this._isTerminated = 0;
    }

    private final void a0(long j3, boolean z3) {
        if (z3 || f0() || d0(j3)) {
            return;
        }
        f0();
    }

    private final boolean b(h hVar) {
        return hVar.f2164f.a() == 1 ? this.f2136j.a(hVar) : this.f2135i.a(hVar);
    }

    private final int c() {
        synchronized (this.f2137k) {
            try {
                if (p()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f2128n;
                long j3 = atomicLongFieldUpdater.get(this);
                int i3 = (int) (j3 & 2097151);
                int b3 = H2.d.b(i3 - ((int) ((j3 & 4398044413952L) >> 21)), 0);
                if (b3 >= this.f2131e) {
                    return 0;
                }
                if (i3 >= this.f2132f) {
                    return 0;
                }
                int i4 = ((int) (f2128n.get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.f2137k.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i4);
                this.f2137k.c(i4, cVar);
                if (i4 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i5 = b3 + 1;
                cVar.start();
                return i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final h c0(c cVar, h hVar, boolean z3) {
        if (cVar == null || cVar.f2142g == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f2164f.a() == 0 && cVar.f2142g == d.BLOCKING) {
            return hVar;
        }
        cVar.f2146k = true;
        return cVar.f2140e.a(hVar, z3);
    }

    private final boolean d0(long j3) {
        if (H2.d.b(((int) (2097151 & j3)) - ((int) ((j3 & 4398044413952L) >> 21)), 0) < this.f2131e) {
            int c3 = c();
            if (c3 == 1 && this.f2131e > 1) {
                c();
            }
            if (c3 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean e0(a aVar, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = f2128n.get(aVar);
        }
        return aVar.d0(j3);
    }

    private final boolean f0() {
        c u3;
        do {
            u3 = u();
            if (u3 == null) {
                return false;
            }
        } while (!c.j().compareAndSet(u3, -1, 0));
        LockSupport.unpark(u3);
        return true;
    }

    private final c i() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !D2.k.a(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void l(a aVar, Runnable runnable, i iVar, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iVar = l.f2173g;
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        aVar.j(runnable, iVar, z3);
    }

    private final int q(c cVar) {
        Object i3 = cVar.i();
        while (i3 != f2130p) {
            if (i3 == null) {
                return 0;
            }
            c cVar2 = (c) i3;
            int h3 = cVar2.h();
            if (h3 != 0) {
                return h3;
            }
            i3 = cVar2.i();
        }
        return -1;
    }

    private final c u() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2127m;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f2137k.b((int) (2097151 & j3));
            if (cVar == null) {
                return null;
            }
            long j4 = (2097152 + j3) & (-2097152);
            int q3 = q(cVar);
            if (q3 >= 0 && f2127m.compareAndSet(this, j3, q3 | j4)) {
                cVar.r(f2130p);
                return cVar;
            }
        }
    }

    public final boolean G(c cVar) {
        long j3;
        int h3;
        if (cVar.i() != f2130p) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2127m;
        do {
            j3 = atomicLongFieldUpdater.get(this);
            h3 = cVar.h();
            cVar.r(this.f2137k.b((int) (2097151 & j3)));
        } while (!f2127m.compareAndSet(this, j3, ((2097152 + j3) & (-2097152)) | h3));
        return true;
    }

    public final void K(c cVar, int i3, int i4) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f2127m;
        while (true) {
            long j3 = atomicLongFieldUpdater.get(this);
            int i5 = (int) (2097151 & j3);
            long j4 = (2097152 + j3) & (-2097152);
            if (i5 == i3) {
                i5 = i4 == 0 ? q(cVar) : i4;
            }
            if (i5 >= 0 && f2127m.compareAndSet(this, j3, j4 | i5)) {
                return;
            }
        }
    }

    public final void N(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void X(long j3) {
        int i3;
        h hVar;
        if (f2129o.compareAndSet(this, 0, 1)) {
            c i4 = i();
            synchronized (this.f2137k) {
                i3 = (int) (f2128n.get(this) & 2097151);
            }
            if (1 <= i3) {
                int i5 = 1;
                while (true) {
                    Object b3 = this.f2137k.b(i5);
                    D2.k.b(b3);
                    c cVar = (c) b3;
                    if (cVar != i4) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j3);
                        }
                        cVar.f2140e.f(this.f2136j);
                    }
                    if (i5 == i3) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            this.f2136j.b();
            this.f2135i.b();
            while (true) {
                if (i4 != null) {
                    hVar = i4.g(true);
                    if (hVar != null) {
                        continue;
                        N(hVar);
                    }
                }
                hVar = (h) this.f2135i.d();
                if (hVar == null && (hVar = (h) this.f2136j.d()) == null) {
                    break;
                }
                N(hVar);
            }
            if (i4 != null) {
                i4.u(d.TERMINATED);
            }
            f2127m.set(this, 0L);
            f2128n.set(this, 0L);
        }
    }

    public final void b0() {
        if (f0() || e0(this, 0L, 1, null)) {
            return;
        }
        f0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        X(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        l(this, runnable, null, false, 6, null);
    }

    public final h g(Runnable runnable, i iVar) {
        long a3 = l.f2172f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a3, iVar);
        }
        h hVar = (h) runnable;
        hVar.f2163e = a3;
        hVar.f2164f = iVar;
        return hVar;
    }

    public final void j(Runnable runnable, i iVar, boolean z3) {
        AbstractC0170c.a();
        h g3 = g(runnable, iVar);
        boolean z4 = false;
        boolean z5 = g3.f2164f.a() == 1;
        long addAndGet = z5 ? f2128n.addAndGet(this, 2097152L) : 0L;
        c i3 = i();
        h c02 = c0(i3, g3, z3);
        if (c02 != null && !b(c02)) {
            throw new RejectedExecutionException(this.f2134h + " was terminated");
        }
        if (z3 && i3 != null) {
            z4 = true;
        }
        if (z5) {
            a0(addAndGet, z4);
        } else {
            if (z4) {
                return;
            }
            b0();
        }
    }

    public final boolean p() {
        return f2129o.get(this) != 0;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a3 = this.f2137k.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a3; i8++) {
            c cVar = (c) this.f2137k.b(i8);
            if (cVar != null) {
                int e3 = cVar.f2140e.e();
                int i9 = b.f2138a[cVar.f2142g.ordinal()];
                if (i9 == 1) {
                    i5++;
                } else if (i9 == 2) {
                    i4++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(e3);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i9 == 3) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(e3);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i9 == 4) {
                    i6++;
                    if (e3 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(e3);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i9 == 5) {
                    i7++;
                }
            }
        }
        long j3 = f2128n.get(this);
        return this.f2134h + '@' + H.b(this) + "[Pool Size {core = " + this.f2131e + ", max = " + this.f2132f + "}, Worker States {CPU = " + i3 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i6 + ", terminated = " + i7 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f2135i.c() + ", global blocking queue size = " + this.f2136j.c() + ", Control State {created workers= " + ((int) (2097151 & j3)) + ", blocking tasks = " + ((int) ((4398044413952L & j3) >> 21)) + ", CPUs acquired = " + (this.f2131e - ((int) ((9223367638808264704L & j3) >> 42))) + "}]";
    }

    public final class c extends Thread {

        /* renamed from: m, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f2139m = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: e, reason: collision with root package name */
        public final n f2140e;

        /* renamed from: f, reason: collision with root package name */
        private final r f2141f;

        /* renamed from: g, reason: collision with root package name */
        public d f2142g;

        /* renamed from: h, reason: collision with root package name */
        private long f2143h;

        /* renamed from: i, reason: collision with root package name */
        private long f2144i;
        private volatile int indexInArray;

        /* renamed from: j, reason: collision with root package name */
        private int f2145j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f2146k;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.f2140e = new n();
            this.f2141f = new r();
            this.f2142g = d.DORMANT;
            this.nextParkedWorker = a.f2130p;
            this.f2145j = F2.c.f430e.b();
        }

        private final void b(int i3) {
            if (i3 == 0) {
                return;
            }
            a.f2128n.addAndGet(a.this, -2097152L);
            if (this.f2142g != d.TERMINATED) {
                this.f2142g = d.DORMANT;
            }
        }

        private final void c(int i3) {
            if (i3 != 0 && u(d.BLOCKING)) {
                a.this.b0();
            }
        }

        private final void d(h hVar) {
            int a3 = hVar.f2164f.a();
            k(a3);
            c(a3);
            a.this.N(hVar);
            b(a3);
        }

        private final h e(boolean z3) {
            h o3;
            h o4;
            if (z3) {
                boolean z4 = m(a.this.f2131e * 2) == 0;
                if (z4 && (o4 = o()) != null) {
                    return o4;
                }
                h g3 = this.f2140e.g();
                if (g3 != null) {
                    return g3;
                }
                if (!z4 && (o3 = o()) != null) {
                    return o3;
                }
            } else {
                h o5 = o();
                if (o5 != null) {
                    return o5;
                }
            }
            return v(3);
        }

        private final h f() {
            h h3 = this.f2140e.h();
            if (h3 != null) {
                return h3;
            }
            h hVar = (h) a.this.f2136j.d();
            return hVar == null ? v(1) : hVar;
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f2139m;
        }

        private final void k(int i3) {
            this.f2143h = 0L;
            if (this.f2142g == d.PARKING) {
                this.f2142g = d.BLOCKING;
            }
        }

        private final boolean l() {
            return this.nextParkedWorker != a.f2130p;
        }

        private final void n() {
            if (this.f2143h == 0) {
                this.f2143h = System.nanoTime() + a.this.f2133g;
            }
            LockSupport.parkNanos(a.this.f2133g);
            if (System.nanoTime() - this.f2143h >= 0) {
                this.f2143h = 0L;
                w();
            }
        }

        private final h o() {
            if (m(2) == 0) {
                h hVar = (h) a.this.f2135i.d();
                return hVar != null ? hVar : (h) a.this.f2136j.d();
            }
            h hVar2 = (h) a.this.f2136j.d();
            return hVar2 != null ? hVar2 : (h) a.this.f2135i.d();
        }

        private final void p() {
            loop0: while (true) {
                boolean z3 = false;
                while (!a.this.p() && this.f2142g != d.TERMINATED) {
                    h g3 = g(this.f2146k);
                    if (g3 != null) {
                        this.f2144i = 0L;
                        d(g3);
                    } else {
                        this.f2146k = false;
                        if (this.f2144i == 0) {
                            t();
                        } else if (z3) {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f2144i);
                            this.f2144i = 0L;
                        } else {
                            z3 = true;
                        }
                    }
                }
            }
            u(d.TERMINATED);
        }

        private final boolean s() {
            long j3;
            if (this.f2142g == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f2128n;
            do {
                j3 = atomicLongFieldUpdater.get(aVar);
                if (((int) ((9223367638808264704L & j3) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f2128n.compareAndSet(aVar, j3, j3 - 4398046511104L));
            this.f2142g = d.CPU_ACQUIRED;
            return true;
        }

        private final void t() {
            if (!l()) {
                a.this.G(this);
                return;
            }
            f2139m.set(this, -1);
            while (l() && f2139m.get(this) == -1 && !a.this.p() && this.f2142g != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final h v(int i3) {
            int i4 = (int) (a.f2128n.get(a.this) & 2097151);
            if (i4 < 2) {
                return null;
            }
            int m3 = m(i4);
            a aVar = a.this;
            long j3 = Long.MAX_VALUE;
            for (int i5 = 0; i5 < i4; i5++) {
                m3++;
                if (m3 > i4) {
                    m3 = 1;
                }
                c cVar = (c) aVar.f2137k.b(m3);
                if (cVar != null && cVar != this) {
                    long n3 = cVar.f2140e.n(i3, this.f2141f);
                    if (n3 == -1) {
                        r rVar = this.f2141f;
                        h hVar = (h) rVar.f337e;
                        rVar.f337e = null;
                        return hVar;
                    }
                    if (n3 > 0) {
                        j3 = Math.min(j3, n3);
                    }
                }
            }
            if (j3 == Long.MAX_VALUE) {
                j3 = 0;
            }
            this.f2144i = j3;
            return null;
        }

        private final void w() {
            a aVar = a.this;
            synchronized (aVar.f2137k) {
                try {
                    if (aVar.p()) {
                        return;
                    }
                    if (((int) (a.f2128n.get(aVar) & 2097151)) <= aVar.f2131e) {
                        return;
                    }
                    if (f2139m.compareAndSet(this, -1, 1)) {
                        int i3 = this.indexInArray;
                        q(0);
                        aVar.K(this, i3, 0);
                        int andDecrement = (int) (a.f2128n.getAndDecrement(aVar) & 2097151);
                        if (andDecrement != i3) {
                            Object b3 = aVar.f2137k.b(andDecrement);
                            D2.k.b(b3);
                            c cVar = (c) b3;
                            aVar.f2137k.c(i3, cVar);
                            cVar.q(i3);
                            aVar.K(cVar, andDecrement, i3);
                        }
                        aVar.f2137k.c(andDecrement, null);
                        q qVar = q.f12810a;
                        this.f2142g = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final h g(boolean z3) {
            return s() ? e(z3) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i3) {
            int i4 = this.f2145j;
            int i5 = i4 ^ (i4 << 13);
            int i6 = i5 ^ (i5 >> 17);
            int i7 = i6 ^ (i6 << 5);
            this.f2145j = i7;
            int i8 = i3 - 1;
            return (i8 & i3) == 0 ? i8 & i7 : (Integer.MAX_VALUE & i7) % i3;
        }

        public final void q(int i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f2134h);
            sb.append("-worker-");
            sb.append(i3 == 0 ? "TERMINATED" : String.valueOf(i3));
            setName(sb.toString());
            this.indexInArray = i3;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean u(d dVar) {
            d dVar2 = this.f2142g;
            boolean z3 = dVar2 == d.CPU_ACQUIRED;
            if (z3) {
                a.f2128n.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f2142g = dVar;
            }
            return z3;
        }

        public c(a aVar, int i3) {
            this();
            q(i3);
        }
    }
}
