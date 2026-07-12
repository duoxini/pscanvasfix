package Q2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2006a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_cur");
    private volatile Object _cur;

    public p(boolean z3) {
        this._cur = new q(8, z3);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2006a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            int a3 = qVar.a(obj);
            if (a3 == 0) {
                return true;
            }
            if (a3 == 1) {
                f2006a.compareAndSet(this, qVar, qVar.i());
            } else if (a3 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2006a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar.d()) {
                return;
            } else {
                f2006a.compareAndSet(this, qVar, qVar.i());
            }
        }
    }

    public final int c() {
        return ((q) f2006a.get(this)).f();
    }

    public final Object d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2006a;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            Object j3 = qVar.j();
            if (j3 != q.f2010h) {
                return j3;
            }
            f2006a.compareAndSet(this, qVar, qVar.i());
        }
    }
}
