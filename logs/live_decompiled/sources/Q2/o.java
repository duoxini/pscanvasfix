package Q2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class o {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2001e = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2002f = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_prev");

    /* renamed from: g, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2003g = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends AbstractC0195b {

        /* renamed from: b, reason: collision with root package name */
        public final o f2004b;

        /* renamed from: c, reason: collision with root package name */
        public o f2005c;

        public a(o oVar) {
            this.f2004b = oVar;
        }

        @Override // Q2.AbstractC0195b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(o oVar, Object obj) {
            boolean z3 = obj == null;
            o oVar2 = z3 ? this.f2004b : this.f2005c;
            if (oVar2 != null && o.f2001e.compareAndSet(oVar, this, oVar2) && z3) {
                o oVar3 = this.f2004b;
                o oVar4 = this.f2005c;
                D2.k.b(oVar4);
                oVar3.l(oVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0042, code lost:
    
        if (r4.compareAndSet(r3, r2, ((Q2.x) r5).f2021a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final Q2.o j(Q2.w r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = Q2.o.f2002f
            java.lang.Object r0 = r0.get(r8)
            Q2.o r0 = (Q2.o) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = Q2.o.f2001e
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = Q2.o.f2002f
            boolean r0 = r1.compareAndSet(r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.p()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof Q2.w
            if (r6 == 0) goto L34
            Q2.w r5 = (Q2.w) r5
            r5.a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof Q2.x
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            Q2.x r5 = (Q2.x) r5
            Q2.o r5 = r5.f2021a
            boolean r2 = r4.compareAndSet(r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = Q2.o.f2002f
            java.lang.Object r2 = r4.get(r2)
            Q2.o r2 = (Q2.o) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            D2.k.c(r5, r3)
            r3 = r5
            Q2.o r3 = (Q2.o) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2.o.j(Q2.w):Q2.o");
    }

    private final o k(o oVar) {
        while (oVar.p()) {
            oVar = (o) f2002f.get(oVar);
        }
        return oVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(o oVar) {
        o oVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2002f;
        do {
            oVar2 = (o) atomicReferenceFieldUpdater.get(oVar);
            if (m() != oVar) {
                return;
            }
        } while (!f2002f.compareAndSet(oVar, oVar2, this));
        if (p()) {
            oVar.j(null);
        }
    }

    private final x s() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2003g;
        x xVar = (x) atomicReferenceFieldUpdater.get(this);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(this);
        atomicReferenceFieldUpdater.lazySet(this, xVar2);
        return xVar2;
    }

    public final boolean i(o oVar) {
        f2002f.lazySet(oVar, this);
        f2001e.lazySet(oVar, this);
        while (m() == this) {
            if (f2001e.compareAndSet(this, this, oVar)) {
                oVar.l(this);
                return true;
            }
        }
        return false;
    }

    public final Object m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2001e;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof w)) {
                return obj;
            }
            ((w) obj).a(this);
        }
    }

    public final o n() {
        return n.b(m());
    }

    public final o o() {
        o j3 = j(null);
        return j3 == null ? k((o) f2002f.get(this)) : j3;
    }

    public boolean p() {
        return m() instanceof x;
    }

    public boolean q() {
        return r() == null;
    }

    public final o r() {
        Object m3;
        o oVar;
        do {
            m3 = m();
            if (m3 instanceof x) {
                return ((x) m3).f2021a;
            }
            if (m3 == this) {
                return (o) m3;
            }
            D2.k.c(m3, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            oVar = (o) m3;
        } while (!f2001e.compareAndSet(this, m3, oVar.s()));
        oVar.j(null);
        return null;
    }

    public final int t(o oVar, o oVar2, a aVar) {
        f2002f.lazySet(oVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2001e;
        atomicReferenceFieldUpdater.lazySet(oVar, oVar2);
        aVar.f2005c = oVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, oVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new D2.o(this) { // from class: Q2.o.b
            @Override // I2.f
            public Object get() {
                return L2.H.a(this.f317f);
            }
        } + '@' + L2.H.b(this);
    }
}
