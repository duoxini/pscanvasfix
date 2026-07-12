package L2;

import L2.e0;
import Q2.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p2.AbstractC0501a;
import t2.g;

/* loaded from: classes.dex */
public class l0 implements e0, r, s0 {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1279e = AtomicReferenceFieldUpdater.newUpdater(l0.class, Object.class, "_state");

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1280f = AtomicReferenceFieldUpdater.newUpdater(l0.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    private static final class a extends k0 {

        /* renamed from: i, reason: collision with root package name */
        private final l0 f1281i;

        /* renamed from: j, reason: collision with root package name */
        private final b f1282j;

        /* renamed from: k, reason: collision with root package name */
        private final C0185q f1283k;

        /* renamed from: l, reason: collision with root package name */
        private final Object f1284l;

        public a(l0 l0Var, b bVar, C0185q c0185q, Object obj) {
            this.f1281i = l0Var;
            this.f1282j = bVar;
            this.f1283k = c0185q;
            this.f1284l = obj;
        }

        @Override // C2.l
        public /* bridge */ /* synthetic */ Object f(Object obj) {
            u((Throwable) obj);
            return p2.q.f12810a;
        }

        @Override // L2.AbstractC0190w
        public void u(Throwable th) {
            this.f1281i.I(this.f1282j, this.f1283k, this.f1284l);
        }
    }

    private static final class b implements InterfaceC0167a0 {

        /* renamed from: f, reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater f1285f = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isCompleting");

        /* renamed from: g, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f1286g = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_rootCause");

        /* renamed from: h, reason: collision with root package name */
        private static final AtomicReferenceFieldUpdater f1287h = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_exceptionsHolder");
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: e, reason: collision with root package name */
        private final p0 f1288e;

        public b(p0 p0Var, boolean z3, Throwable th) {
            this.f1288e = p0Var;
            this._isCompleting = z3 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList b() {
            return new ArrayList(4);
        }

        private final Object e() {
            return f1287h.get(this);
        }

        private final void l(Object obj) {
            f1287h.set(this, obj);
        }

        public final void a(Throwable th) {
            Throwable f3 = f();
            if (f3 == null) {
                m(th);
                return;
            }
            if (th == f3) {
                return;
            }
            Object e3 = e();
            if (e3 == null) {
                l(th);
                return;
            }
            if (e3 instanceof Throwable) {
                if (th == e3) {
                    return;
                }
                ArrayList b3 = b();
                b3.add(e3);
                b3.add(th);
                l(b3);
                return;
            }
            if (e3 instanceof ArrayList) {
                ((ArrayList) e3).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + e3).toString());
        }

        @Override // L2.InterfaceC0167a0
        public boolean c() {
            return f() == null;
        }

        @Override // L2.InterfaceC0167a0
        public p0 d() {
            return this.f1288e;
        }

        public final Throwable f() {
            return (Throwable) f1286g.get(this);
        }

        public final boolean g() {
            return f() != null;
        }

        public final boolean h() {
            return f1285f.get(this) != 0;
        }

        public final boolean i() {
            Q2.D d3;
            Object e3 = e();
            d3 = m0.f1295e;
            return e3 == d3;
        }

        public final List j(Throwable th) {
            ArrayList arrayList;
            Q2.D d3;
            Object e3 = e();
            if (e3 == null) {
                arrayList = b();
            } else if (e3 instanceof Throwable) {
                ArrayList b3 = b();
                b3.add(e3);
                arrayList = b3;
            } else {
                if (!(e3 instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + e3).toString());
                }
                arrayList = (ArrayList) e3;
            }
            Throwable f3 = f();
            if (f3 != null) {
                arrayList.add(0, f3);
            }
            if (th != null && !D2.k.a(th, f3)) {
                arrayList.add(th);
            }
            d3 = m0.f1295e;
            l(d3);
            return arrayList;
        }

        public final void k(boolean z3) {
            f1285f.set(this, z3 ? 1 : 0);
        }

        public final void m(Throwable th) {
            f1286g.set(this, th);
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + d() + ']';
        }
    }

    public static final class c extends o.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0 f1289d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f1290e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Q2.o oVar, l0 l0Var, Object obj) {
            super(oVar);
            this.f1289d = l0Var;
            this.f1290e = obj;
        }

        @Override // Q2.AbstractC0195b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(Q2.o oVar) {
            if (this.f1289d.U() == this.f1290e) {
                return null;
            }
            return Q2.n.a();
        }
    }

    public l0(boolean z3) {
        this._state = z3 ? m0.f1297g : m0.f1296f;
    }

    private final Object A0(Object obj, Object obj2) {
        Q2.D d3;
        Q2.D d4;
        if (!(obj instanceof InterfaceC0167a0)) {
            d4 = m0.f1291a;
            return d4;
        }
        if ((!(obj instanceof Q) && !(obj instanceof k0)) || (obj instanceof C0185q) || (obj2 instanceof C0188u)) {
            return B0((InterfaceC0167a0) obj, obj2);
        }
        if (y0((InterfaceC0167a0) obj, obj2)) {
            return obj2;
        }
        d3 = m0.f1293c;
        return d3;
    }

    private final Object B0(InterfaceC0167a0 interfaceC0167a0, Object obj) {
        Q2.D d3;
        Q2.D d4;
        Q2.D d5;
        p0 S3 = S(interfaceC0167a0);
        if (S3 == null) {
            d5 = m0.f1293c;
            return d5;
        }
        b bVar = interfaceC0167a0 instanceof b ? (b) interfaceC0167a0 : null;
        if (bVar == null) {
            bVar = new b(S3, false, null);
        }
        D2.r rVar = new D2.r();
        synchronized (bVar) {
            if (bVar.h()) {
                d4 = m0.f1291a;
                return d4;
            }
            bVar.k(true);
            if (bVar != interfaceC0167a0 && !f1279e.compareAndSet(this, interfaceC0167a0, bVar)) {
                d3 = m0.f1293c;
                return d3;
            }
            boolean g3 = bVar.g();
            C0188u c0188u = obj instanceof C0188u ? (C0188u) obj : null;
            if (c0188u != null) {
                bVar.a(c0188u.f1308a);
            }
            Throwable f3 = g3 ? null : bVar.f();
            rVar.f337e = f3;
            p2.q qVar = p2.q.f12810a;
            if (f3 != null) {
                k0(S3, f3);
            }
            C0185q M3 = M(interfaceC0167a0);
            return (M3 == null || !C0(bVar, M3, obj)) ? L(bVar, obj) : m0.f1292b;
        }
    }

    private final Object C(Object obj) {
        Q2.D d3;
        Object A02;
        Q2.D d4;
        do {
            Object U3 = U();
            if (!(U3 instanceof InterfaceC0167a0) || ((U3 instanceof b) && ((b) U3).h())) {
                d3 = m0.f1291a;
                return d3;
            }
            A02 = A0(U3, new C0188u(J(obj), false, 2, null));
            d4 = m0.f1293c;
        } while (A02 == d4);
        return A02;
    }

    private final boolean C0(b bVar, C0185q c0185q, Object obj) {
        while (e0.a.d(c0185q.f1301i, false, false, new a(this, bVar, c0185q, obj), 1, null) == q0.f1302e) {
            c0185q = j0(c0185q);
            if (c0185q == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean D(Throwable th) {
        if (e0()) {
            return true;
        }
        boolean z3 = th instanceof CancellationException;
        InterfaceC0184p T3 = T();
        return (T3 == null || T3 == q0.f1302e) ? z3 : T3.b(th) || z3;
    }

    private final void H(InterfaceC0167a0 interfaceC0167a0, Object obj) {
        InterfaceC0184p T3 = T();
        if (T3 != null) {
            T3.a();
            s0(q0.f1302e);
        }
        C0188u c0188u = obj instanceof C0188u ? (C0188u) obj : null;
        Throwable th = c0188u != null ? c0188u.f1308a : null;
        if (!(interfaceC0167a0 instanceof k0)) {
            p0 d3 = interfaceC0167a0.d();
            if (d3 != null) {
                l0(d3, th);
                return;
            }
            return;
        }
        try {
            ((k0) interfaceC0167a0).u(th);
        } catch (Throwable th2) {
            W(new C0191x("Exception in completion handler " + interfaceC0167a0 + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(b bVar, C0185q c0185q, Object obj) {
        C0185q j02 = j0(c0185q);
        if (j02 == null || !C0(bVar, j02, obj)) {
            y(L(bVar, obj));
        }
    }

    private final Throwable J(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new f0(E(), null, this) : th;
        }
        D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((s0) obj).i();
    }

    private final Object L(b bVar, Object obj) {
        boolean g3;
        Throwable P3;
        C0188u c0188u = obj instanceof C0188u ? (C0188u) obj : null;
        Throwable th = c0188u != null ? c0188u.f1308a : null;
        synchronized (bVar) {
            g3 = bVar.g();
            List j3 = bVar.j(th);
            P3 = P(bVar, j3);
            if (P3 != null) {
                x(P3, j3);
            }
        }
        if (P3 != null && P3 != th) {
            obj = new C0188u(P3, false, 2, null);
        }
        if (P3 != null && (D(P3) || V(P3))) {
            D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            ((C0188u) obj).b();
        }
        if (!g3) {
            m0(P3);
        }
        n0(obj);
        f1279e.compareAndSet(this, bVar, m0.g(obj));
        H(bVar, obj);
        return obj;
    }

    private final C0185q M(InterfaceC0167a0 interfaceC0167a0) {
        C0185q c0185q = interfaceC0167a0 instanceof C0185q ? (C0185q) interfaceC0167a0 : null;
        if (c0185q != null) {
            return c0185q;
        }
        p0 d3 = interfaceC0167a0.d();
        if (d3 != null) {
            return j0(d3);
        }
        return null;
    }

    private final Throwable O(Object obj) {
        C0188u c0188u = obj instanceof C0188u ? (C0188u) obj : null;
        if (c0188u != null) {
            return c0188u.f1308a;
        }
        return null;
    }

    private final Throwable P(b bVar, List list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.g()) {
                return new f0(E(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : (Throwable) list.get(0);
    }

    private final p0 S(InterfaceC0167a0 interfaceC0167a0) {
        p0 d3 = interfaceC0167a0.d();
        if (d3 != null) {
            return d3;
        }
        if (interfaceC0167a0 instanceof Q) {
            return new p0();
        }
        if (interfaceC0167a0 instanceof k0) {
            q0((k0) interfaceC0167a0);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + interfaceC0167a0).toString());
    }

    private final Object f0(Object obj) {
        Q2.D d3;
        Q2.D d4;
        Q2.D d5;
        Q2.D d6;
        Q2.D d7;
        Q2.D d8;
        Throwable th = null;
        while (true) {
            Object U3 = U();
            if (U3 instanceof b) {
                synchronized (U3) {
                    if (((b) U3).i()) {
                        d4 = m0.f1294d;
                        return d4;
                    }
                    boolean g3 = ((b) U3).g();
                    if (obj != null || !g3) {
                        if (th == null) {
                            th = J(obj);
                        }
                        ((b) U3).a(th);
                    }
                    Throwable f3 = g3 ? null : ((b) U3).f();
                    if (f3 != null) {
                        k0(((b) U3).d(), f3);
                    }
                    d3 = m0.f1291a;
                    return d3;
                }
            }
            if (!(U3 instanceof InterfaceC0167a0)) {
                d5 = m0.f1294d;
                return d5;
            }
            if (th == null) {
                th = J(obj);
            }
            InterfaceC0167a0 interfaceC0167a0 = (InterfaceC0167a0) U3;
            if (!interfaceC0167a0.c()) {
                Object A02 = A0(U3, new C0188u(th, false, 2, null));
                d7 = m0.f1291a;
                if (A02 == d7) {
                    throw new IllegalStateException(("Cannot happen in " + U3).toString());
                }
                d8 = m0.f1293c;
                if (A02 != d8) {
                    return A02;
                }
            } else if (z0(interfaceC0167a0, th)) {
                d6 = m0.f1291a;
                return d6;
            }
        }
    }

    private final k0 h0(C2.l lVar, boolean z3) {
        k0 k0Var;
        if (z3) {
            k0Var = lVar instanceof g0 ? (g0) lVar : null;
            if (k0Var == null) {
                k0Var = new C0171c0(lVar);
            }
        } else {
            k0Var = lVar instanceof k0 ? (k0) lVar : null;
            if (k0Var == null) {
                k0Var = new d0(lVar);
            }
        }
        k0Var.w(this);
        return k0Var;
    }

    private final C0185q j0(Q2.o oVar) {
        while (oVar.p()) {
            oVar = oVar.o();
        }
        while (true) {
            oVar = oVar.n();
            if (!oVar.p()) {
                if (oVar instanceof C0185q) {
                    return (C0185q) oVar;
                }
                if (oVar instanceof p0) {
                    return null;
                }
            }
        }
    }

    private final void k0(p0 p0Var, Throwable th) {
        m0(th);
        Object m3 = p0Var.m();
        D2.k.c(m3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0191x c0191x = null;
        for (Q2.o oVar = (Q2.o) m3; !D2.k.a(oVar, p0Var); oVar = oVar.n()) {
            if (oVar instanceof g0) {
                k0 k0Var = (k0) oVar;
                try {
                    k0Var.u(th);
                } catch (Throwable th2) {
                    if (c0191x != null) {
                        AbstractC0501a.a(c0191x, th2);
                    } else {
                        c0191x = new C0191x("Exception in completion handler " + k0Var + " for " + this, th2);
                        p2.q qVar = p2.q.f12810a;
                    }
                }
            }
        }
        if (c0191x != null) {
            W(c0191x);
        }
        D(th);
    }

    private final void l0(p0 p0Var, Throwable th) {
        Object m3 = p0Var.m();
        D2.k.c(m3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        C0191x c0191x = null;
        for (Q2.o oVar = (Q2.o) m3; !D2.k.a(oVar, p0Var); oVar = oVar.n()) {
            if (oVar instanceof k0) {
                k0 k0Var = (k0) oVar;
                try {
                    k0Var.u(th);
                } catch (Throwable th2) {
                    if (c0191x != null) {
                        AbstractC0501a.a(c0191x, th2);
                    } else {
                        c0191x = new C0191x("Exception in completion handler " + k0Var + " for " + this, th2);
                        p2.q qVar = p2.q.f12810a;
                    }
                }
            }
        }
        if (c0191x != null) {
            W(c0191x);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [L2.Z] */
    private final void p0(Q q3) {
        p0 p0Var = new p0();
        if (!q3.c()) {
            p0Var = new Z(p0Var);
        }
        f1279e.compareAndSet(this, q3, p0Var);
    }

    private final void q0(k0 k0Var) {
        k0Var.i(new p0());
        f1279e.compareAndSet(this, k0Var, k0Var.n());
    }

    private final int t0(Object obj) {
        Q q3;
        if (!(obj instanceof Q)) {
            if (!(obj instanceof Z)) {
                return 0;
            }
            if (!f1279e.compareAndSet(this, obj, ((Z) obj).d())) {
                return -1;
            }
            o0();
            return 1;
        }
        if (((Q) obj).c()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1279e;
        q3 = m0.f1297g;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, q3)) {
            return -1;
        }
        o0();
        return 1;
    }

    private final String u0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof InterfaceC0167a0 ? ((InterfaceC0167a0) obj).c() ? "Active" : "New" : obj instanceof C0188u ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.g() ? "Cancelling" : bVar.h() ? "Completing" : "Active";
    }

    private final boolean w(Object obj, p0 p0Var, k0 k0Var) {
        int t3;
        c cVar = new c(k0Var, this, obj);
        do {
            t3 = p0Var.o().t(k0Var, p0Var, cVar);
            if (t3 == 1) {
                return true;
            }
        } while (t3 != 2);
        return false;
    }

    public static /* synthetic */ CancellationException w0(l0 l0Var, Throwable th, String str, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i3 & 1) != 0) {
            str = null;
        }
        return l0Var.v0(th, str);
    }

    private final void x(Throwable th, List list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                AbstractC0501a.a(th, th2);
            }
        }
    }

    private final boolean y0(InterfaceC0167a0 interfaceC0167a0, Object obj) {
        if (!f1279e.compareAndSet(this, interfaceC0167a0, m0.g(obj))) {
            return false;
        }
        m0(null);
        n0(obj);
        H(interfaceC0167a0, obj);
        return true;
    }

    private final boolean z0(InterfaceC0167a0 interfaceC0167a0, Throwable th) {
        p0 S3 = S(interfaceC0167a0);
        if (S3 == null) {
            return false;
        }
        if (!f1279e.compareAndSet(this, interfaceC0167a0, new b(S3, false, th))) {
            return false;
        }
        k0(S3, th);
        return true;
    }

    public final boolean A(Object obj) {
        Object obj2;
        Q2.D d3;
        Q2.D d4;
        Q2.D d5;
        obj2 = m0.f1291a;
        if (R() && (obj2 = C(obj)) == m0.f1292b) {
            return true;
        }
        d3 = m0.f1291a;
        if (obj2 == d3) {
            obj2 = f0(obj);
        }
        d4 = m0.f1291a;
        if (obj2 == d4 || obj2 == m0.f1292b) {
            return true;
        }
        d5 = m0.f1294d;
        if (obj2 == d5) {
            return false;
        }
        y(obj2);
        return true;
    }

    public void B(Throwable th) {
        A(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String E() {
        return "Job was cancelled";
    }

    public boolean F(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return A(th) && Q();
    }

    @Override // t2.g
    public t2.g N(g.c cVar) {
        return e0.a.e(this, cVar);
    }

    public boolean Q() {
        return true;
    }

    public boolean R() {
        return false;
    }

    public final InterfaceC0184p T() {
        return (InterfaceC0184p) f1280f.get(this);
    }

    public final Object U() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1279e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof Q2.w)) {
                return obj;
            }
            ((Q2.w) obj).a(this);
        }
    }

    protected boolean V(Throwable th) {
        return false;
    }

    public void W(Throwable th) {
        throw th;
    }

    protected final void Y(e0 e0Var) {
        if (e0Var == null) {
            s0(q0.f1302e);
            return;
        }
        e0Var.start();
        InterfaceC0184p a02 = e0Var.a0(this);
        s0(a02);
        if (d0()) {
            a02.a();
            s0(q0.f1302e);
        }
    }

    public final P Z(C2.l lVar) {
        return b0(false, true, lVar);
    }

    @Override // t2.g.b, t2.g
    public g.b a(g.c cVar) {
        return e0.a.c(this, cVar);
    }

    @Override // L2.e0
    public final InterfaceC0184p a0(r rVar) {
        P d3 = e0.a.d(this, true, false, new C0185q(rVar), 2, null);
        D2.k.c(d3, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (InterfaceC0184p) d3;
    }

    @Override // L2.e0
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new f0(E(), null, this);
        }
        B(cancellationException);
    }

    @Override // L2.e0
    public final P b0(boolean z3, boolean z4, C2.l lVar) {
        k0 h02 = h0(lVar, z3);
        while (true) {
            Object U3 = U();
            if (U3 instanceof Q) {
                Q q3 = (Q) U3;
                if (!q3.c()) {
                    p0(q3);
                } else if (f1279e.compareAndSet(this, U3, h02)) {
                    return h02;
                }
            } else {
                if (!(U3 instanceof InterfaceC0167a0)) {
                    if (z4) {
                        C0188u c0188u = U3 instanceof C0188u ? (C0188u) U3 : null;
                        lVar.f(c0188u != null ? c0188u.f1308a : null);
                    }
                    return q0.f1302e;
                }
                p0 d3 = ((InterfaceC0167a0) U3).d();
                if (d3 == null) {
                    D2.k.c(U3, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    q0((k0) U3);
                } else {
                    P p3 = q0.f1302e;
                    if (z3 && (U3 instanceof b)) {
                        synchronized (U3) {
                            try {
                                r3 = ((b) U3).f();
                                if (r3 != null) {
                                    if ((lVar instanceof C0185q) && !((b) U3).h()) {
                                    }
                                    p2.q qVar = p2.q.f12810a;
                                }
                                if (w(U3, d3, h02)) {
                                    if (r3 == null) {
                                        return h02;
                                    }
                                    p3 = h02;
                                    p2.q qVar2 = p2.q.f12810a;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (r3 != null) {
                        if (z4) {
                            lVar.f(r3);
                        }
                        return p3;
                    }
                    if (w(U3, d3, h02)) {
                        return h02;
                    }
                }
            }
        }
    }

    @Override // L2.e0
    public boolean c() {
        Object U3 = U();
        return (U3 instanceof InterfaceC0167a0) && ((InterfaceC0167a0) U3).c();
    }

    public final boolean c0() {
        Object U3 = U();
        return (U3 instanceof C0188u) || ((U3 instanceof b) && ((b) U3).g());
    }

    public final boolean d0() {
        return !(U() instanceof InterfaceC0167a0);
    }

    protected boolean e0() {
        return false;
    }

    @Override // t2.g
    public Object g(Object obj, C2.p pVar) {
        return e0.a.b(this, obj, pVar);
    }

    public final Object g0(Object obj) {
        Object A02;
        Q2.D d3;
        Q2.D d4;
        do {
            A02 = A0(U(), obj);
            d3 = m0.f1291a;
            if (A02 == d3) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, O(obj));
            }
            d4 = m0.f1293c;
        } while (A02 == d4);
        return A02;
    }

    @Override // t2.g.b
    public final g.c getKey() {
        return e0.f1268b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // L2.s0
    public CancellationException i() {
        CancellationException cancellationException;
        Object U3 = U();
        if (U3 instanceof b) {
            cancellationException = ((b) U3).f();
        } else if (U3 instanceof C0188u) {
            cancellationException = ((C0188u) U3).f1308a;
        } else {
            if (U3 instanceof InterfaceC0167a0) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + U3).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new f0("Parent job is " + u0(U3), cancellationException, this);
    }

    public String i0() {
        return H.a(this);
    }

    @Override // L2.r
    public final void l(s0 s0Var) {
        A(s0Var);
    }

    protected void m0(Throwable th) {
    }

    protected void n0(Object obj) {
    }

    protected void o0() {
    }

    @Override // t2.g
    public t2.g p(t2.g gVar) {
        return e0.a.f(this, gVar);
    }

    @Override // L2.e0
    public final CancellationException q() {
        Object U3 = U();
        if (!(U3 instanceof b)) {
            if (U3 instanceof InterfaceC0167a0) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (U3 instanceof C0188u) {
                return w0(this, ((C0188u) U3).f1308a, null, 1, null);
            }
            return new f0(H.a(this) + " has completed normally", null, this);
        }
        Throwable f3 = ((b) U3).f();
        if (f3 != null) {
            CancellationException v02 = v0(f3, H.a(this) + " is cancelling");
            if (v02 != null) {
                return v02;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final void r0(k0 k0Var) {
        Object U3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Q q3;
        do {
            U3 = U();
            if (!(U3 instanceof k0)) {
                if (!(U3 instanceof InterfaceC0167a0) || ((InterfaceC0167a0) U3).d() == null) {
                    return;
                }
                k0Var.q();
                return;
            }
            if (U3 != k0Var) {
                return;
            }
            atomicReferenceFieldUpdater = f1279e;
            q3 = m0.f1297g;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, U3, q3));
    }

    public final void s0(InterfaceC0184p interfaceC0184p) {
        f1280f.set(this, interfaceC0184p);
    }

    @Override // L2.e0
    public final boolean start() {
        int t02;
        do {
            t02 = t0(U());
            if (t02 == 0) {
                return false;
            }
        } while (t02 != 1);
        return true;
    }

    public String toString() {
        return x0() + '@' + H.b(this);
    }

    protected final CancellationException v0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = E();
            }
            cancellationException = new f0(str, th, this);
        }
        return cancellationException;
    }

    public final String x0() {
        return i0() + '{' + u0(U()) + '}';
    }

    protected void y(Object obj) {
    }

    public final boolean z(Throwable th) {
        return A(th);
    }
}
