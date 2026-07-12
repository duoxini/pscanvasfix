package Q2;

import L2.AbstractC0192y;
import L2.C0179k;
import L2.C0189v;
import L2.InterfaceC0178j;
import L2.S;
import L2.x0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t2.InterfaceC0593d;

/* renamed from: Q2.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0201h extends L2.M implements v2.e, InterfaceC0593d {

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1985l = AtomicReferenceFieldUpdater.newUpdater(C0201h.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: h, reason: collision with root package name */
    public final L2.A f1986h;

    /* renamed from: i, reason: collision with root package name */
    public final InterfaceC0593d f1987i;

    /* renamed from: j, reason: collision with root package name */
    public Object f1988j;

    /* renamed from: k, reason: collision with root package name */
    public final Object f1989k;

    public C0201h(L2.A a3, InterfaceC0593d interfaceC0593d) {
        super(-1);
        D d3;
        this.f1986h = a3;
        this.f1987i = interfaceC0593d;
        d3 = AbstractC0202i.f1990a;
        this.f1988j = d3;
        this.f1989k = H.b(getContext());
    }

    private final C0179k j() {
        Object obj = f1985l.get(this);
        if (obj instanceof C0179k) {
            return (C0179k) obj;
        }
        return null;
    }

    @Override // L2.M
    public void a(Object obj, Throwable th) {
        if (obj instanceof C0189v) {
            ((C0189v) obj).f1310b.f(th);
        }
    }

    @Override // L2.M
    public InterfaceC0593d c() {
        return this;
    }

    @Override // L2.M
    public Object g() {
        D d3;
        Object obj = this.f1988j;
        d3 = AbstractC0202i.f1990a;
        this.f1988j = d3;
        return obj;
    }

    @Override // v2.e
    public v2.e getCallerFrame() {
        InterfaceC0593d interfaceC0593d = this.f1987i;
        if (interfaceC0593d instanceof v2.e) {
            return (v2.e) interfaceC0593d;
        }
        return null;
    }

    @Override // t2.InterfaceC0593d
    public t2.g getContext() {
        return this.f1987i.getContext();
    }

    public final void h() {
        while (f1985l.get(this) == AbstractC0202i.f1991b) {
        }
    }

    public final C0179k i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1985l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f1985l.set(this, AbstractC0202i.f1991b);
                return null;
            }
            if (obj instanceof C0179k) {
                if (f1985l.compareAndSet(this, obj, AbstractC0202i.f1991b)) {
                    return (C0179k) obj;
                }
            } else if (obj != AbstractC0202i.f1991b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean l() {
        return f1985l.get(this) != null;
    }

    public final boolean n(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1985l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            D d3 = AbstractC0202i.f1991b;
            if (D2.k.a(obj, d3)) {
                if (f1985l.compareAndSet(this, d3, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f1985l.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void o() {
        h();
        C0179k j3 = j();
        if (j3 != null) {
            j3.p();
        }
    }

    public final Throwable p(InterfaceC0178j interfaceC0178j) {
        D d3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1985l;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            d3 = AbstractC0202i.f1991b;
            if (obj != d3) {
                if (obj instanceof Throwable) {
                    if (f1985l.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f1985l.compareAndSet(this, d3, interfaceC0178j));
        return null;
    }

    @Override // t2.InterfaceC0593d
    public void resumeWith(Object obj) {
        t2.g context = this.f1987i.getContext();
        Object d3 = AbstractC0192y.d(obj, null, 1, null);
        if (this.f1986h.d0(context)) {
            this.f1988j = d3;
            this.f1244g = 0;
            this.f1986h.c0(context, this);
            return;
        }
        S a3 = x0.f1311a.a();
        if (a3.l0()) {
            this.f1988j = d3;
            this.f1244g = 0;
            a3.h0(this);
            return;
        }
        a3.j0(true);
        try {
            t2.g context2 = getContext();
            Object c3 = H.c(context2, this.f1989k);
            try {
                this.f1987i.resumeWith(obj);
                p2.q qVar = p2.q.f12810a;
                while (a3.n0()) {
                }
            } finally {
                H.a(context2, c3);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f1986h + ", " + L2.H.c(this.f1987i) + ']';
    }
}
