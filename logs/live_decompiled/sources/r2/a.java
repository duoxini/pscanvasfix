package R2;

import C2.p;
import Q2.AbstractC0202i;
import p2.C0511k;
import p2.l;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public abstract class a {
    private static final void a(InterfaceC0593d interfaceC0593d, Throwable th) {
        C0511k.a aVar = C0511k.f12803f;
        interfaceC0593d.resumeWith(C0511k.b(l.a(th)));
        throw th;
    }

    public static final void b(p pVar, Object obj, InterfaceC0593d interfaceC0593d, C2.l lVar) {
        try {
            InterfaceC0593d b3 = AbstractC0603b.b(AbstractC0603b.a(pVar, obj, interfaceC0593d));
            C0511k.a aVar = C0511k.f12803f;
            AbstractC0202i.b(b3, C0511k.b(q.f12810a), lVar);
        } catch (Throwable th) {
            a(interfaceC0593d, th);
        }
    }

    public static final void c(InterfaceC0593d interfaceC0593d, InterfaceC0593d interfaceC0593d2) {
        try {
            InterfaceC0593d b3 = AbstractC0603b.b(interfaceC0593d);
            C0511k.a aVar = C0511k.f12803f;
            AbstractC0202i.c(b3, C0511k.b(q.f12810a), null, 2, null);
        } catch (Throwable th) {
            a(interfaceC0593d2, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, InterfaceC0593d interfaceC0593d, C2.l lVar, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        b(pVar, obj, interfaceC0593d, lVar);
    }
}
