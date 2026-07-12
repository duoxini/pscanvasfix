package k1;

import a1.C0221a;
import g1.C0366b;
import h1.C0383l;
import l1.c;

/* renamed from: k1.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0426E {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12225a = c.a.a("nm", "c", "o", "tr", "hd");

    static C0383l a(l1.c cVar, C0221a c0221a) {
        String str = null;
        C0366b c0366b = null;
        C0366b c0366b2 = null;
        g1.l lVar = null;
        boolean z3 = false;
        while (cVar.j()) {
            int a02 = cVar.a0(f12225a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                c0366b = AbstractC0433d.f(cVar, c0221a, false);
            } else if (a02 == 2) {
                c0366b2 = AbstractC0433d.f(cVar, c0221a, false);
            } else if (a02 == 3) {
                lVar = AbstractC0432c.g(cVar, c0221a);
            } else if (a02 != 4) {
                cVar.c0();
            } else {
                z3 = cVar.l();
            }
        }
        return new C0383l(str, c0366b, c0366b2, lVar, z3);
    }
}
