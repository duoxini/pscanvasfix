package L2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class T extends U implements K {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1253j = AtomicReferenceFieldUpdater.newUpdater(T.class, Object.class, "_queue");

    /* renamed from: k, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1254k = AtomicReferenceFieldUpdater.newUpdater(T.class, Object.class, "_delayed");

    /* renamed from: l, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1255l = AtomicIntegerFieldUpdater.newUpdater(T.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    public static final class a extends Q2.J {
    }

    private final void A0(boolean z3) {
        f1255l.set(this, z3 ? 1 : 0);
    }

    private final void r0() {
        Q2.D d3;
        Q2.D d4;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1253j;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f1253j;
                d3 = W.f1257b;
                if (atomicReferenceFieldUpdater2.compareAndSet(this, null, d3)) {
                    return;
                }
            } else {
                if (obj instanceof Q2.q) {
                    ((Q2.q) obj).d();
                    return;
                }
                d4 = W.f1257b;
                if (obj == d4) {
                    return;
                }
                Q2.q qVar = new Q2.q(8, true);
                D2.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar.a((Runnable) obj);
                if (f1253j.compareAndSet(this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable s0() {
        Q2.D d3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1253j;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof Q2.q) {
                D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                Q2.q qVar = (Q2.q) obj;
                Object j3 = qVar.j();
                if (j3 != Q2.q.f2010h) {
                    return (Runnable) j3;
                }
                f1253j.compareAndSet(this, obj, qVar.i());
            } else {
                d3 = W.f1257b;
                if (obj == d3) {
                    return null;
                }
                if (f1253j.compareAndSet(this, obj, null)) {
                    D2.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean u0(Runnable runnable) {
        Q2.D d3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1253j;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (v0()) {
                return false;
            }
            if (obj == null) {
                if (f1253j.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof Q2.q) {
                D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                Q2.q qVar = (Q2.q) obj;
                int a3 = qVar.a(runnable);
                if (a3 == 0) {
                    return true;
                }
                if (a3 == 1) {
                    f1253j.compareAndSet(this, obj, qVar.i());
                } else if (a3 == 2) {
                    return false;
                }
            } else {
                d3 = W.f1257b;
                if (obj == d3) {
                    return false;
                }
                Q2.q qVar2 = new Q2.q(8, true);
                D2.k.c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (f1253j.compareAndSet(this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    private final boolean v0() {
        return f1255l.get(this) != 0;
    }

    private final void y0() {
        AbstractC0170c.a();
        System.nanoTime();
    }

    @Override // L2.A
    public final void c0(t2.g gVar, Runnable runnable) {
        t0(runnable);
    }

    @Override // L2.S
    protected long i0() {
        Q2.D d3;
        if (super.i0() == 0) {
            return 0L;
        }
        Object obj = f1253j.get(this);
        if (obj != null) {
            if (!(obj instanceof Q2.q)) {
                d3 = W.f1257b;
                return obj == d3 ? Long.MAX_VALUE : 0L;
            }
            if (!((Q2.q) obj).g()) {
                return 0L;
            }
        }
        return Long.MAX_VALUE;
    }

    @Override // L2.S
    public void o0() {
        x0.f1311a.b();
        A0(true);
        r0();
        while (x0() <= 0) {
        }
        y0();
    }

    public void t0(Runnable runnable) {
        if (u0(runnable)) {
            q0();
        } else {
            I.f1239m.t0(runnable);
        }
    }

    protected boolean w0() {
        Q2.D d3;
        if (!m0()) {
            return false;
        }
        Object obj = f1253j.get(this);
        if (obj != null) {
            if (obj instanceof Q2.q) {
                return ((Q2.q) obj).g();
            }
            d3 = W.f1257b;
            if (obj != d3) {
                return false;
            }
        }
        return true;
    }

    public long x0() {
        if (n0()) {
            return 0L;
        }
        Runnable s02 = s0();
        if (s02 == null) {
            return i0();
        }
        s02.run();
        return 0L;
    }

    protected final void z0() {
        f1253j.set(this, null);
        f1254k.set(this, null);
    }
}
