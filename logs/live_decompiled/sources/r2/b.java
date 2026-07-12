package R2;

import C2.p;
import D2.u;
import L2.C0188u;
import L2.m0;
import Q2.H;
import Q2.z;
import p2.C0511k;
import p2.l;
import t2.InterfaceC0593d;
import t2.g;
import u2.AbstractC0603b;
import v2.h;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(p pVar, Object obj, InterfaceC0593d interfaceC0593d) {
        InterfaceC0593d a3 = h.a(interfaceC0593d);
        try {
            g context = interfaceC0593d.getContext();
            Object c3 = H.c(context, null);
            try {
                Object invoke = ((p) u.a(pVar, 2)).invoke(obj, a3);
                if (invoke != AbstractC0603b.c()) {
                    a3.resumeWith(C0511k.b(invoke));
                }
            } finally {
                H.a(context, c3);
            }
        } catch (Throwable th) {
            C0511k.a aVar = C0511k.f12803f;
            a3.resumeWith(C0511k.b(l.a(th)));
        }
    }

    public static final Object b(z zVar, Object obj, p pVar) {
        Object c0188u;
        Object g02;
        try {
            c0188u = ((p) u.a(pVar, 2)).invoke(obj, zVar);
        } catch (Throwable th) {
            c0188u = new C0188u(th, false, 2, null);
        }
        if (c0188u != AbstractC0603b.c() && (g02 = zVar.g0(c0188u)) != m0.f1292b) {
            if (g02 instanceof C0188u) {
                throw ((C0188u) g02).f1308a;
            }
            return m0.h(g02);
        }
        return AbstractC0603b.c();
    }
}
