package k1;

import a1.C0221a;
import g1.C0365a;
import g1.C0366b;
import h1.C0389r;
import java.util.ArrayList;
import java.util.Collections;
import l1.c;

/* loaded from: classes.dex */
abstract class L {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12233a = c.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12234b = c.a.a("n", "v");

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static C0389r a(l1.c cVar, C0221a c0221a) {
        char c3;
        ArrayList arrayList = new ArrayList();
        float f3 = 0.0f;
        boolean z3 = false;
        String str = null;
        C0366b c0366b = null;
        C0365a c0365a = null;
        C0366b c0366b2 = null;
        C0389r.b bVar = null;
        C0389r.c cVar2 = null;
        g1.d dVar = null;
        while (cVar.j()) {
            switch (cVar.a0(f12233a)) {
                case 0:
                    str = cVar.G();
                    break;
                case 1:
                    c0365a = AbstractC0433d.c(cVar, c0221a);
                    break;
                case 2:
                    c0366b2 = AbstractC0433d.e(cVar, c0221a);
                    break;
                case 3:
                    dVar = AbstractC0433d.h(cVar, c0221a);
                    break;
                case 4:
                    bVar = C0389r.b.values()[cVar.q() - 1];
                    break;
                case 5:
                    cVar2 = C0389r.c.values()[cVar.q() - 1];
                    break;
                case 6:
                    f3 = (float) cVar.p();
                    break;
                case 7:
                    z3 = cVar.l();
                    break;
                case 8:
                    cVar.b();
                    while (cVar.j()) {
                        cVar.c();
                        String str2 = null;
                        C0366b c0366b3 = null;
                        while (cVar.j()) {
                            int a02 = cVar.a0(f12234b);
                            if (a02 == 0) {
                                str2 = cVar.G();
                            } else if (a02 != 1) {
                                cVar.b0();
                                cVar.c0();
                            } else {
                                c0366b3 = AbstractC0433d.e(cVar, c0221a);
                            }
                        }
                        cVar.i();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c3 = 0;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c3 = 1;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c3 = 2;
                                    break;
                                }
                                c3 = 65535;
                                break;
                            default:
                                c3 = 65535;
                                break;
                        }
                        switch (c3) {
                            case 0:
                            case 1:
                                c0221a.u(true);
                                arrayList.add(c0366b3);
                                break;
                            case 2:
                                c0366b = c0366b3;
                                break;
                        }
                    }
                    cVar.g();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add((C0366b) arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    cVar.c0();
                    break;
            }
        }
        return new C0389r(str, c0366b, arrayList, c0365a, dVar == null ? new g1.d(Collections.singletonList(new n1.c(100))) : dVar, c0366b2, bVar, cVar2, f3, z3);
    }
}
