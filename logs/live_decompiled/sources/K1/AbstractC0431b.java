package k1;

import a1.C0221a;
import g1.C0365a;
import g1.C0366b;
import l1.c;

/* renamed from: k1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0431b {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12237a = c.a.a("a");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12238b = c.a.a("fc", "sc", "sw", "t");

    public static g1.k a(l1.c cVar, C0221a c0221a) {
        cVar.c();
        g1.k kVar = null;
        while (cVar.j()) {
            if (cVar.a0(f12237a) != 0) {
                cVar.b0();
                cVar.c0();
            } else {
                kVar = b(cVar, c0221a);
            }
        }
        cVar.i();
        return kVar == null ? new g1.k(null, null, null, null) : kVar;
    }

    private static g1.k b(l1.c cVar, C0221a c0221a) {
        cVar.c();
        C0365a c0365a = null;
        C0365a c0365a2 = null;
        C0366b c0366b = null;
        C0366b c0366b2 = null;
        while (cVar.j()) {
            int a02 = cVar.a0(f12238b);
            if (a02 == 0) {
                c0365a = AbstractC0433d.c(cVar, c0221a);
            } else if (a02 == 1) {
                c0365a2 = AbstractC0433d.c(cVar, c0221a);
            } else if (a02 == 2) {
                c0366b = AbstractC0433d.e(cVar, c0221a);
            } else if (a02 != 3) {
                cVar.b0();
                cVar.c0();
            } else {
                c0366b2 = AbstractC0433d.e(cVar, c0221a);
            }
        }
        cVar.i();
        return new g1.k(c0365a, c0365a2, c0366b, c0366b2);
    }
}
