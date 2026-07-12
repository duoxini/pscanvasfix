package P2;

import C2.p;
import D2.u;
import Q2.H;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public abstract class c {
    public static final Object b(t2.g gVar, Object obj, Object obj2, p pVar, InterfaceC0593d interfaceC0593d) {
        Object c3 = H.c(gVar, obj2);
        try {
            Object invoke = ((p) u.a(pVar, 2)).invoke(obj, new j(interfaceC0593d, gVar));
            H.a(gVar, c3);
            if (invoke == AbstractC0603b.c()) {
                v2.h.c(interfaceC0593d);
            }
            return invoke;
        } catch (Throwable th) {
            H.a(gVar, c3);
            throw th;
        }
    }

    public static /* synthetic */ Object c(t2.g gVar, Object obj, Object obj2, p pVar, InterfaceC0593d interfaceC0593d, int i3, Object obj3) {
        if ((i3 & 4) != 0) {
            obj2 = H.b(gVar);
        }
        return b(gVar, obj, obj2, pVar, interfaceC0593d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final O2.d d(O2.d dVar, t2.g gVar) {
        return dVar instanceof i ? dVar : new k(dVar, gVar);
    }
}
