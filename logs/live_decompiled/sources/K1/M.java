package k1;

import a1.C0221a;
import g1.C0366b;
import h1.s;
import l1.c;

/* loaded from: classes.dex */
abstract class M {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12235a = c.a.a("s", "e", "o", "nm", "m", "hd");

    static h1.s a(l1.c cVar, C0221a c0221a) {
        String str = null;
        s.a aVar = null;
        C0366b c0366b = null;
        C0366b c0366b2 = null;
        C0366b c0366b3 = null;
        boolean z3 = false;
        while (cVar.j()) {
            int a02 = cVar.a0(f12235a);
            if (a02 == 0) {
                c0366b = AbstractC0433d.f(cVar, c0221a, false);
            } else if (a02 == 1) {
                c0366b2 = AbstractC0433d.f(cVar, c0221a, false);
            } else if (a02 == 2) {
                c0366b3 = AbstractC0433d.f(cVar, c0221a, false);
            } else if (a02 == 3) {
                str = cVar.G();
            } else if (a02 == 4) {
                aVar = s.a.a(cVar.q());
            } else if (a02 != 5) {
                cVar.c0();
            } else {
                z3 = cVar.l();
            }
        }
        return new h1.s(str, aVar, c0366b, c0366b2, c0366b3, z3);
    }
}
