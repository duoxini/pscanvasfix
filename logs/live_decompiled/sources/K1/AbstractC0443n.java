package k1;

import a1.C0221a;
import f1.C0357e;
import h1.C0387p;
import java.util.ArrayList;
import l1.c;

/* renamed from: k1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0443n {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12265a = c.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12266b = c.a.a("shapes");

    static C0357e a(l1.c cVar, C0221a c0221a) {
        ArrayList arrayList = new ArrayList();
        cVar.c();
        double d3 = 0.0d;
        String str = null;
        String str2 = null;
        char c3 = 0;
        double d4 = 0.0d;
        while (cVar.j()) {
            int a02 = cVar.a0(f12265a);
            if (a02 == 0) {
                c3 = cVar.G().charAt(0);
            } else if (a02 == 1) {
                d4 = cVar.p();
            } else if (a02 == 2) {
                d3 = cVar.p();
            } else if (a02 == 3) {
                str = cVar.G();
            } else if (a02 == 4) {
                str2 = cVar.G();
            } else if (a02 != 5) {
                cVar.b0();
                cVar.c0();
            } else {
                cVar.c();
                while (cVar.j()) {
                    if (cVar.a0(f12266b) != 0) {
                        cVar.b0();
                        cVar.c0();
                    } else {
                        cVar.b();
                        while (cVar.j()) {
                            arrayList.add((C0387p) AbstractC0437h.a(cVar, c0221a));
                        }
                        cVar.g();
                    }
                }
                cVar.i();
            }
        }
        cVar.i();
        return new C0357e(arrayList, c3, d4, d3, str, str2);
    }
}
