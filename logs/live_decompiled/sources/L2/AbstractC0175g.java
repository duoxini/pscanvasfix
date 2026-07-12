package L2;

import t2.InterfaceC0593d;
import t2.InterfaceC0594e;
import u2.AbstractC0603b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: L2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0175g {
    public static final e0 a(D d3, t2.g gVar, F f3, C2.p pVar) {
        t2.g d4 = AbstractC0193z.d(d3, gVar);
        t0 n0Var = f3.c() ? new n0(d4, pVar) : new t0(d4, true);
        n0Var.G0(f3, n0Var, pVar);
        return n0Var;
    }

    public static /* synthetic */ e0 b(D d3, t2.g gVar, F f3, C2.p pVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gVar = t2.h.f13692e;
        }
        if ((i3 & 2) != 0) {
            f3 = F.DEFAULT;
        }
        return AbstractC0174f.a(d3, gVar, f3, pVar);
    }

    public static final Object c(t2.g gVar, C2.p pVar, InterfaceC0593d interfaceC0593d) {
        Object H02;
        t2.g context = interfaceC0593d.getContext();
        t2.g e3 = AbstractC0193z.e(context, gVar);
        i0.d(e3);
        if (e3 == context) {
            Q2.z zVar = new Q2.z(e3, interfaceC0593d);
            H02 = R2.b.b(zVar, zVar, pVar);
        } else {
            InterfaceC0594e.b bVar = InterfaceC0594e.f13689d;
            if (D2.k.a(e3.a(bVar), context.a(bVar))) {
                z0 z0Var = new z0(e3, interfaceC0593d);
                t2.g context2 = z0Var.getContext();
                Object c3 = Q2.H.c(context2, null);
                try {
                    Object b3 = R2.b.b(z0Var, z0Var, pVar);
                    Q2.H.a(context2, c3);
                    H02 = b3;
                } catch (Throwable th) {
                    Q2.H.a(context2, c3);
                    throw th;
                }
            } else {
                L l3 = new L(e3, interfaceC0593d);
                R2.a.d(pVar, l3, l3, null, 4, null);
                H02 = l3.H0();
            }
        }
        if (H02 == AbstractC0603b.c()) {
            v2.h.c(interfaceC0593d);
        }
        return H02;
    }
}
