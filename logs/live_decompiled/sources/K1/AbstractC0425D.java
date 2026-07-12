package k1;

import a1.C0221a;
import g1.C0366b;
import h1.C0382k;
import l1.c;

/* renamed from: k1.D, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0425D {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12224a = c.a.a("nm", "p", "s", "r", "hd");

    static C0382k a(l1.c cVar, C0221a c0221a) {
        String str = null;
        g1.m mVar = null;
        g1.f fVar = null;
        C0366b c0366b = null;
        boolean z3 = false;
        while (cVar.j()) {
            int a02 = cVar.a0(f12224a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                mVar = AbstractC0430a.b(cVar, c0221a);
            } else if (a02 == 2) {
                fVar = AbstractC0433d.i(cVar, c0221a);
            } else if (a02 == 3) {
                c0366b = AbstractC0433d.e(cVar, c0221a);
            } else if (a02 != 4) {
                cVar.c0();
            } else {
                z3 = cVar.l();
            }
        }
        return new C0382k(str, mVar, fVar, c0366b, z3);
    }
}
