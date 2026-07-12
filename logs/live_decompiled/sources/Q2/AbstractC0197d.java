package Q2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: Q2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0197d {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1981e = AtomicReferenceFieldUpdater.newUpdater(AbstractC0197d.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1982f = AtomicReferenceFieldUpdater.newUpdater(AbstractC0197d.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public AbstractC0197d(AbstractC0197d abstractC0197d) {
        this._prev = abstractC0197d;
    }

    private final AbstractC0197d c() {
        AbstractC0197d g3 = g();
        while (g3 != null && g3.h()) {
            g3 = (AbstractC0197d) f1982f.get(g3);
        }
        return g3;
    }

    private final AbstractC0197d d() {
        AbstractC0197d e3;
        AbstractC0197d e4 = e();
        D2.k.b(e4);
        while (e4.h() && (e3 = e4.e()) != null) {
            e4 = e3;
        }
        return e4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object f() {
        return f1981e.get(this);
    }

    public final void b() {
        f1982f.lazySet(this, null);
    }

    public final AbstractC0197d e() {
        Object f3 = f();
        if (f3 == AbstractC0196c.f1980a) {
            return null;
        }
        return (AbstractC0197d) f3;
    }

    public final AbstractC0197d g() {
        return (AbstractC0197d) f1982f.get(this);
    }

    public abstract boolean h();

    public final boolean i() {
        return e() == null;
    }

    public final boolean j() {
        return f1981e.compareAndSet(this, null, AbstractC0196c.f1980a);
    }

    public final void k() {
        Object obj;
        if (i()) {
            return;
        }
        while (true) {
            AbstractC0197d c3 = c();
            AbstractC0197d d3 = d();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1982f;
            do {
                obj = atomicReferenceFieldUpdater.get(d3);
            } while (!atomicReferenceFieldUpdater.compareAndSet(d3, obj, ((AbstractC0197d) obj) == null ? null : c3));
            if (c3 != null) {
                f1981e.set(c3, d3);
            }
            if (!d3.h() || d3.i()) {
                if (c3 == null || !c3.h()) {
                    return;
                }
            }
        }
    }

    public final boolean l(AbstractC0197d abstractC0197d) {
        return f1981e.compareAndSet(this, null, abstractC0197d);
    }
}
