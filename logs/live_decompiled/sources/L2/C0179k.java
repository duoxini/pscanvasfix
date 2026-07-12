package L2;

import L2.e0;
import Q2.C0201h;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p2.C0504d;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* renamed from: L2.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0179k extends M implements InterfaceC0178j, v2.e, B0 {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1272j = AtomicIntegerFieldUpdater.newUpdater(C0179k.class, "_decisionAndIndex");

    /* renamed from: k, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1273k = AtomicReferenceFieldUpdater.newUpdater(C0179k.class, Object.class, "_state");

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1274l = AtomicReferenceFieldUpdater.newUpdater(C0179k.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: h, reason: collision with root package name */
    private final InterfaceC0593d f1275h;

    /* renamed from: i, reason: collision with root package name */
    private final t2.g f1276i;

    public C0179k(InterfaceC0593d interfaceC0593d, int i3) {
        super(i3);
        this.f1275h = interfaceC0593d;
        this.f1276i = interfaceC0593d.getContext();
        this._decisionAndIndex = 536870911;
        this._state = C0172d.f1265e;
    }

    private final void A(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1273k;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof C0172d) {
                if (f1273k.compareAndSet(this, obj2, obj)) {
                    return;
                }
            } else if (obj2 instanceof Q2.A) {
                D(obj, obj2);
            } else {
                if (obj2 instanceof C0188u) {
                    C0188u c0188u = (C0188u) obj2;
                    if (!c0188u.b()) {
                        D(obj, obj2);
                    }
                    if (obj2 instanceof C0182n) {
                        if (!(obj2 instanceof C0188u)) {
                            c0188u = null;
                        }
                        Throwable th = c0188u != null ? c0188u.f1308a : null;
                        D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Segment<*>");
                        l((Q2.A) obj, th);
                        return;
                    }
                    return;
                }
                if (obj2 instanceof C0187t) {
                    C0187t c0187t = (C0187t) obj2;
                    c0187t.getClass();
                    if (obj instanceof Q2.A) {
                        return;
                    }
                    D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    androidx.appcompat.app.p.a(obj);
                    if (c0187t.c()) {
                        androidx.appcompat.app.p.a(obj);
                        i(null, c0187t.f1306d);
                        return;
                    } else {
                        androidx.appcompat.app.p.a(obj);
                        if (f1273k.compareAndSet(this, obj2, C0187t.b(c0187t, null, null, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (obj instanceof Q2.A) {
                        return;
                    }
                    D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancelHandler");
                    androidx.appcompat.app.p.a(obj);
                    androidx.appcompat.app.p.a(obj);
                    if (f1273k.compareAndSet(this, obj2, new C0187t(obj2, null, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    private final boolean C() {
        if (N.c(this.f1244g)) {
            InterfaceC0593d interfaceC0593d = this.f1275h;
            D2.k.c(interfaceC0593d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (((C0201h) interfaceC0593d).l()) {
                return true;
            }
        }
        return false;
    }

    private final void D(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    private final void I(Object obj, int i3, C2.l lVar) {
        Object obj2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1273k;
        do {
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof r0)) {
                if (obj2 instanceof C0182n) {
                    C0182n c0182n = (C0182n) obj2;
                    if (c0182n.c()) {
                        if (lVar != null) {
                            j(lVar, c0182n.f1308a);
                            return;
                        }
                        return;
                    }
                }
                h(obj);
                throw new C0504d();
            }
        } while (!f1273k.compareAndSet(this, obj2, K((r0) obj2, obj, i3, lVar, null)));
        q();
        r(i3);
    }

    static /* synthetic */ void J(C0179k c0179k, Object obj, int i3, C2.l lVar, int i4, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i4 & 4) != 0) {
            lVar = null;
        }
        c0179k.I(obj, i3, lVar);
    }

    private final Object K(r0 r0Var, Object obj, int i3, C2.l lVar, Object obj2) {
        return obj instanceof C0188u ? obj : (N.b(i3) || obj2 != null) ? (lVar == null && obj2 == null) ? obj : new C0187t(obj, null, lVar, obj2, null, 16, null) : obj;
    }

    private final boolean L() {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1272j;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f1272j.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
        return true;
    }

    private final Q2.D M(Object obj, Object obj2, C2.l lVar) {
        Object obj3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1273k;
        do {
            obj3 = atomicReferenceFieldUpdater.get(this);
            if (!(obj3 instanceof r0)) {
                if ((obj3 instanceof C0187t) && obj2 != null && ((C0187t) obj3).f1305c == obj2) {
                    return AbstractC0180l.f1278a;
                }
                return null;
            }
        } while (!f1273k.compareAndSet(this, obj3, K((r0) obj3, obj, this.f1244g, lVar, obj2)));
        q();
        return AbstractC0180l.f1278a;
    }

    private final boolean N() {
        int i3;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1272j;
        do {
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f1272j.compareAndSet(this, i3, 536870912 + (536870911 & i3)));
        return true;
    }

    private final Void h(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void l(Q2.A a3, Throwable th) {
        int i3 = f1272j.get(this) & 536870911;
        if (i3 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            a3.o(i3, th, getContext());
        } catch (Throwable th2) {
            C.a(getContext(), new C0191x("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean o(Throwable th) {
        if (!C()) {
            return false;
        }
        InterfaceC0593d interfaceC0593d = this.f1275h;
        D2.k.c(interfaceC0593d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        return ((C0201h) interfaceC0593d).n(th);
    }

    private final void q() {
        if (C()) {
            return;
        }
        p();
    }

    private final void r(int i3) {
        if (L()) {
            return;
        }
        N.a(this, i3);
    }

    private final P u() {
        return (P) f1274l.get(this);
    }

    private final String x() {
        Object w3 = w();
        return w3 instanceof r0 ? "Active" : w3 instanceof C0182n ? "Cancelled" : "Completed";
    }

    private final P z() {
        e0 e0Var = (e0) getContext().a(e0.f1268b);
        if (e0Var == null) {
            return null;
        }
        P d3 = e0.a.d(e0Var, true, false, new C0183o(this), 2, null);
        f1274l.compareAndSet(this, null, d3);
        return d3;
    }

    public boolean B() {
        return !(w() instanceof r0);
    }

    protected String E() {
        return "CancellableContinuation";
    }

    public final void F(Throwable th) {
        if (o(th)) {
            return;
        }
        n(th);
        q();
    }

    public final void G() {
        Throwable p3;
        InterfaceC0593d interfaceC0593d = this.f1275h;
        C0201h c0201h = interfaceC0593d instanceof C0201h ? (C0201h) interfaceC0593d : null;
        if (c0201h == null || (p3 = c0201h.p(this)) == null) {
            return;
        }
        p();
        n(p3);
    }

    public final boolean H() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1273k;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if ((obj instanceof C0187t) && ((C0187t) obj).f1305c != null) {
            p();
            return false;
        }
        f1272j.set(this, 536870911);
        atomicReferenceFieldUpdater.set(this, C0172d.f1265e);
        return true;
    }

    @Override // L2.M
    public void a(Object obj, Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1273k;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof r0) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C0188u) {
                return;
            }
            if (obj2 instanceof C0187t) {
                C0187t c0187t = (C0187t) obj2;
                if (c0187t.c()) {
                    throw new IllegalStateException("Must be called at most once");
                }
                if (f1273k.compareAndSet(this, obj2, C0187t.b(c0187t, null, null, null, null, th, 15, null))) {
                    c0187t.d(this, th);
                    return;
                }
            } else if (f1273k.compareAndSet(this, obj2, new C0187t(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // L2.B0
    public void b(Q2.A a3, int i3) {
        int i4;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1272j;
        do {
            i4 = atomicIntegerFieldUpdater.get(this);
            if ((i4 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i4, ((i4 >> 29) << 29) + i3));
        A(a3);
    }

    @Override // L2.M
    public final InterfaceC0593d c() {
        return this.f1275h;
    }

    @Override // L2.M
    public Throwable d(Object obj) {
        Throwable d3 = super.d(obj);
        if (d3 != null) {
            return d3;
        }
        return null;
    }

    @Override // L2.M
    public Object e(Object obj) {
        return obj instanceof C0187t ? ((C0187t) obj).f1303a : obj;
    }

    @Override // L2.M
    public Object g() {
        return w();
    }

    @Override // v2.e
    public v2.e getCallerFrame() {
        InterfaceC0593d interfaceC0593d = this.f1275h;
        if (interfaceC0593d instanceof v2.e) {
            return (v2.e) interfaceC0593d;
        }
        return null;
    }

    @Override // t2.InterfaceC0593d
    public t2.g getContext() {
        return this.f1276i;
    }

    public final void i(AbstractC0176h abstractC0176h, Throwable th) {
        try {
            throw null;
        } catch (Throwable th2) {
            C.a(getContext(), new C0191x("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void j(C2.l lVar, Throwable th) {
        try {
            lVar.f(th);
        } catch (Throwable th2) {
            C.a(getContext(), new C0191x("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // L2.InterfaceC0178j
    public Object k(Object obj, Object obj2, C2.l lVar) {
        return M(obj, obj2, lVar);
    }

    @Override // L2.InterfaceC0178j
    public void m(Object obj, C2.l lVar) {
        I(obj, this.f1244g, lVar);
    }

    public boolean n(Throwable th) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1273k;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof r0)) {
                return false;
            }
        } while (!f1273k.compareAndSet(this, obj, new C0182n(this, th, obj instanceof Q2.A)));
        if (((r0) obj) instanceof Q2.A) {
            l((Q2.A) obj, th);
        }
        q();
        r(this.f1244g);
        return true;
    }

    public final void p() {
        P u3 = u();
        if (u3 == null) {
            return;
        }
        u3.a();
        f1274l.set(this, q0.f1302e);
    }

    @Override // t2.InterfaceC0593d
    public void resumeWith(Object obj) {
        J(this, AbstractC0192y.c(obj, this), this.f1244g, null, 4, null);
    }

    @Override // L2.InterfaceC0178j
    public void s(Object obj) {
        r(this.f1244g);
    }

    public Throwable t(e0 e0Var) {
        return e0Var.q();
    }

    public String toString() {
        return E() + '(' + H.c(this.f1275h) + "){" + x() + "}@" + H.b(this);
    }

    public final Object v() {
        e0 e0Var;
        boolean C3 = C();
        if (N()) {
            if (u() == null) {
                z();
            }
            if (C3) {
                G();
            }
            return AbstractC0603b.c();
        }
        if (C3) {
            G();
        }
        Object w3 = w();
        if (w3 instanceof C0188u) {
            throw ((C0188u) w3).f1308a;
        }
        if (!N.b(this.f1244g) || (e0Var = (e0) getContext().a(e0.f1268b)) == null || e0Var.c()) {
            return e(w3);
        }
        CancellationException q3 = e0Var.q();
        a(w3, q3);
        throw q3;
    }

    public final Object w() {
        return f1273k.get(this);
    }

    public void y() {
        P z3 = z();
        if (z3 != null && B()) {
            z3.a();
            f1274l.set(this, q0.f1302e);
        }
    }
}
