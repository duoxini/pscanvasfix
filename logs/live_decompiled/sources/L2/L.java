package L2;

import Q2.AbstractC0202i;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public final class L extends Q2.z {

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1243i = AtomicIntegerFieldUpdater.newUpdater(L.class, "_decision");
    private volatile int _decision;

    public L(t2.g gVar, InterfaceC0593d interfaceC0593d) {
        super(gVar, interfaceC0593d);
    }

    private final boolean I0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1243i;
        do {
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed");
            }
        } while (!f1243i.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean J0() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1243i;
        do {
            int i3 = atomicIntegerFieldUpdater.get(this);
            if (i3 != 0) {
                if (i3 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended");
            }
        } while (!f1243i.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // Q2.z, L2.AbstractC0166a
    protected void D0(Object obj) {
        if (I0()) {
            return;
        }
        AbstractC0202i.c(AbstractC0603b.b(this.f2022h), AbstractC0192y.a(obj, this.f2022h), null, 2, null);
    }

    public final Object H0() {
        if (J0()) {
            return AbstractC0603b.c();
        }
        Object h3 = m0.h(U());
        if (h3 instanceof C0188u) {
            throw ((C0188u) h3).f1308a;
        }
        return h3;
    }

    @Override // Q2.z, L2.l0
    protected void y(Object obj) {
        D0(obj);
    }
}
