package N2;

import Q2.A;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class i extends A {

    /* renamed from: i, reason: collision with root package name */
    private final b f1672i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicReferenceArray f1673j;

    public i(long j3, i iVar, b bVar, int i3) {
        super(j3, iVar, i3);
        this.f1672i = bVar;
        this.f1673j = new AtomicReferenceArray(c.f1646b * 2);
    }

    private final void z(int i3, Object obj) {
        this.f1673j.lazySet(i3 * 2, obj);
    }

    public final void A(int i3, Object obj) {
        this.f1673j.set((i3 * 2) + 1, obj);
    }

    public final void B(int i3, Object obj) {
        z(i3, obj);
    }

    @Override // Q2.A
    public int n() {
        return c.f1646b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0063, code lost:
    
        s(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0066, code lost:
    
        if (r0 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0068, code lost:
    
        r3 = u().f1639f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x006e, code lost:
    
        if (r3 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0070, code lost:
    
        Q2.v.b(r3, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // Q2.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(int r4, java.lang.Throwable r5, t2.g r6) {
        /*
            r3 = this;
            int r5 = N2.c.f1646b
            if (r4 < r5) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            if (r0 == 0) goto La
            int r4 = r4 - r5
        La:
            java.lang.Object r5 = r3.v(r4)
        Le:
            java.lang.Object r1 = r3.w(r4)
            boolean r2 = r1 instanceof L2.B0
            if (r2 != 0) goto L74
            boolean r2 = r1 instanceof N2.t
            if (r2 == 0) goto L1b
            goto L74
        L1b:
            Q2.D r2 = N2.c.j()
            if (r1 == r2) goto L63
            Q2.D r2 = N2.c.i()
            if (r1 != r2) goto L28
            goto L63
        L28:
            Q2.D r2 = N2.c.p()
            if (r1 == r2) goto Le
            Q2.D r2 = N2.c.q()
            if (r1 != r2) goto L35
            goto Le
        L35:
            Q2.D r3 = N2.c.f()
            if (r1 == r3) goto L62
            Q2.D r3 = N2.c.f1648d
            if (r1 != r3) goto L40
            goto L62
        L40:
            Q2.D r3 = N2.c.z()
            if (r1 != r3) goto L47
            return
        L47:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "unexpected state: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L62:
            return
        L63:
            r3.s(r4)
            if (r0 == 0) goto L73
            N2.b r3 = r3.u()
            C2.l r3 = r3.f1639f
            if (r3 == 0) goto L73
            Q2.v.b(r3, r5, r6)
        L73:
            return
        L74:
            if (r0 == 0) goto L7b
            Q2.D r2 = N2.c.j()
            goto L7f
        L7b:
            Q2.D r2 = N2.c.i()
        L7f:
            boolean r1 = r3.r(r4, r1, r2)
            if (r1 == 0) goto Le
            r3.s(r4)
            r1 = r0 ^ 1
            r3.x(r4, r1)
            if (r0 == 0) goto L9a
            N2.b r3 = r3.u()
            C2.l r3 = r3.f1639f
            if (r3 == 0) goto L9a
            Q2.v.b(r3, r5, r6)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.i.o(int, java.lang.Throwable, t2.g):void");
    }

    public final boolean r(int i3, Object obj, Object obj2) {
        return this.f1673j.compareAndSet((i3 * 2) + 1, obj, obj2);
    }

    public final void s(int i3) {
        z(i3, null);
    }

    public final Object t(int i3, Object obj) {
        return this.f1673j.getAndSet((i3 * 2) + 1, obj);
    }

    public final b u() {
        b bVar = this.f1672i;
        D2.k.b(bVar);
        return bVar;
    }

    public final Object v(int i3) {
        return this.f1673j.get(i3 * 2);
    }

    public final Object w(int i3) {
        return this.f1673j.get((i3 * 2) + 1);
    }

    public final void x(int i3, boolean z3) {
        if (z3) {
            u().B0((this.f1961g * c.f1646b) + i3);
        }
        p();
    }

    public final Object y(int i3) {
        Object v3 = v(i3);
        s(i3);
        return v3;
    }
}
