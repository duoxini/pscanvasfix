package L2;

import p2.C0510j;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public final class z0 extends Q2.z {

    /* renamed from: i, reason: collision with root package name */
    private final ThreadLocal f1318i;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public z0(t2.g r3, t2.InterfaceC0593d r4) {
        /*
            r2 = this;
            L2.A0 r0 = L2.A0.f1229e
            t2.g$b r1 = r3.a(r0)
            if (r1 != 0) goto Ld
            t2.g r0 = r3.p(r0)
            goto Le
        Ld:
            r0 = r3
        Le:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.f1318i = r0
            t2.g r4 = r4.getContext()
            t2.e$b r0 = t2.InterfaceC0594e.f13689d
            t2.g$b r4 = r4.a(r0)
            boolean r4 = r4 instanceof L2.A
            if (r4 != 0) goto L31
            r4 = 0
            java.lang.Object r4 = Q2.H.c(r3, r4)
            Q2.H.a(r3, r4)
            r2.I0(r3, r4)
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: L2.z0.<init>(t2.g, t2.d):void");
    }

    @Override // Q2.z, L2.AbstractC0166a
    protected void D0(Object obj) {
        if (this.threadLocalIsSet) {
            C0510j c0510j = (C0510j) this.f1318i.get();
            if (c0510j != null) {
                Q2.H.a((t2.g) c0510j.a(), c0510j.b());
            }
            this.f1318i.remove();
        }
        Object a3 = AbstractC0192y.a(obj, this.f2022h);
        InterfaceC0593d interfaceC0593d = this.f2022h;
        t2.g context = interfaceC0593d.getContext();
        Object c3 = Q2.H.c(context, null);
        z0 g3 = c3 != Q2.H.f1967a ? AbstractC0193z.g(interfaceC0593d, context, c3) : null;
        try {
            this.f2022h.resumeWith(a3);
            p2.q qVar = p2.q.f12810a;
        } finally {
            if (g3 == null || g3.H0()) {
                Q2.H.a(context, c3);
            }
        }
    }

    public final boolean H0() {
        boolean z3 = this.threadLocalIsSet && this.f1318i.get() == null;
        this.f1318i.remove();
        return !z3;
    }

    public final void I0(t2.g gVar, Object obj) {
        this.threadLocalIsSet = true;
        this.f1318i.set(p2.n.a(gVar, obj));
    }
}
