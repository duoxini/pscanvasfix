package k1;

import a1.C0221a;
import h1.C0387p;
import h1.InterfaceC0374c;
import java.util.ArrayList;
import l1.c;

/* loaded from: classes.dex */
abstract class J {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12231a = c.a.a("nm", "hd", "it");

    static C0387p a(l1.c cVar, C0221a c0221a) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z3 = false;
        while (cVar.j()) {
            int a02 = cVar.a0(f12231a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                z3 = cVar.l();
            } else if (a02 != 2) {
                cVar.c0();
            } else {
                cVar.b();
                while (cVar.j()) {
                    InterfaceC0374c a3 = AbstractC0437h.a(cVar, c0221a);
                    if (a3 != null) {
                        arrayList.add(a3);
                    }
                }
                cVar.g();
            }
        }
        return new C0387p(str, arrayList, z3);
    }
}
