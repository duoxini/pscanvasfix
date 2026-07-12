package k1;

import a1.C0221a;
import h1.C0373b;
import l1.c;

/* renamed from: k1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0435f {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12243a = c.a.a("nm", "p", "s", "hd", "d");

    static C0373b a(l1.c cVar, C0221a c0221a, int i3) {
        boolean z3 = i3 == 3;
        boolean z4 = false;
        String str = null;
        g1.m mVar = null;
        g1.f fVar = null;
        while (cVar.j()) {
            int a02 = cVar.a0(f12243a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                mVar = AbstractC0430a.b(cVar, c0221a);
            } else if (a02 == 2) {
                fVar = AbstractC0433d.i(cVar, c0221a);
            } else if (a02 == 3) {
                z4 = cVar.l();
            } else if (a02 != 4) {
                cVar.b0();
                cVar.c0();
            } else {
                z3 = cVar.q() == 3;
            }
        }
        return new C0373b(str, mVar, fVar, z3, z4);
    }
}
