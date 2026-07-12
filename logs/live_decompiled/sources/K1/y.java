package k1;

import h1.C0380i;
import l1.c;

/* loaded from: classes.dex */
abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12286a = c.a.a("nm", "mm", "hd");

    static C0380i a(l1.c cVar) {
        String str = null;
        boolean z3 = false;
        C0380i.a aVar = null;
        while (cVar.j()) {
            int a02 = cVar.a0(f12286a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                aVar = C0380i.a.a(cVar.q());
            } else if (a02 != 2) {
                cVar.b0();
                cVar.c0();
            } else {
                z3 = cVar.l();
            }
        }
        return new C0380i(str, aVar, z3);
    }
}
