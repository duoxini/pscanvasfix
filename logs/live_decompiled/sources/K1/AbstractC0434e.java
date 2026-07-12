package k1;

import a1.C0221a;
import h1.C0372a;
import l1.c;

/* renamed from: k1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0434e {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12241a = c.a.a("ef");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12242b = c.a.a("ty", "v");

    private static C0372a a(l1.c cVar, C0221a c0221a) {
        cVar.c();
        C0372a c0372a = null;
        while (true) {
            boolean z3 = false;
            while (cVar.j()) {
                int a02 = cVar.a0(f12242b);
                if (a02 != 0) {
                    if (a02 != 1) {
                        cVar.b0();
                        cVar.c0();
                    } else if (z3) {
                        c0372a = new C0372a(AbstractC0433d.e(cVar, c0221a));
                    } else {
                        cVar.c0();
                    }
                } else if (cVar.q() == 0) {
                    z3 = true;
                }
            }
            cVar.i();
            return c0372a;
        }
    }

    static C0372a b(l1.c cVar, C0221a c0221a) {
        C0372a c0372a = null;
        while (cVar.j()) {
            if (cVar.a0(f12241a) != 0) {
                cVar.b0();
                cVar.c0();
            } else {
                cVar.b();
                while (cVar.j()) {
                    C0372a a3 = a(cVar, c0221a);
                    if (a3 != null) {
                        c0372a = a3;
                    }
                }
                cVar.g();
            }
        }
        return c0372a;
    }
}
