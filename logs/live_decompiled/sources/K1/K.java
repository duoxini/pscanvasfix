package k1;

import a1.C0221a;
import h1.C0388q;
import l1.c;

/* loaded from: classes.dex */
abstract class K {

    /* renamed from: a, reason: collision with root package name */
    static c.a f12232a = c.a.a("nm", "ind", "ks", "hd");

    static C0388q a(l1.c cVar, C0221a c0221a) {
        String str = null;
        int i3 = 0;
        boolean z3 = false;
        g1.h hVar = null;
        while (cVar.j()) {
            int a02 = cVar.a0(f12232a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                i3 = cVar.q();
            } else if (a02 == 2) {
                hVar = AbstractC0433d.k(cVar, c0221a);
            } else if (a02 != 3) {
                cVar.c0();
            } else {
                z3 = cVar.l();
            }
        }
        return new C0388q(str, i3, hVar, z3);
    }
}
