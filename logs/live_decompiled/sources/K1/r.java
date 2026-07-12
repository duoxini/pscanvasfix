package k1;

import a1.C0221a;
import com.oplus.backup.sdk.common.utils.Constants;
import g1.C0366b;
import g1.C0367c;
import h1.C0377f;
import h1.C0389r;
import h1.EnumC0378g;
import java.util.ArrayList;
import java.util.Collections;
import l1.c;

/* loaded from: classes.dex */
abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12271a = c.a.a("nm", "g", "o", "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12272b = c.a.a("p", "k");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f12273c = c.a.a("n", "v");

    static C0377f a(l1.c cVar, C0221a c0221a) {
        String str;
        C0367c c0367c;
        ArrayList arrayList = new ArrayList();
        float f3 = 0.0f;
        String str2 = null;
        EnumC0378g enumC0378g = null;
        C0367c c0367c2 = null;
        g1.f fVar = null;
        g1.f fVar2 = null;
        C0366b c0366b = null;
        C0389r.b bVar = null;
        C0389r.c cVar2 = null;
        C0366b c0366b2 = null;
        boolean z3 = false;
        g1.d dVar = null;
        while (cVar.j()) {
            switch (cVar.a0(f12271a)) {
                case 0:
                    str2 = cVar.G();
                    continue;
                case 1:
                    str = str2;
                    cVar.c();
                    int i3 = -1;
                    while (cVar.j()) {
                        int a02 = cVar.a0(f12272b);
                        if (a02 != 0) {
                            c0367c = c0367c2;
                            if (a02 != 1) {
                                cVar.b0();
                                cVar.c0();
                            } else {
                                c0367c2 = AbstractC0433d.g(cVar, c0221a, i3);
                            }
                        } else {
                            c0367c = c0367c2;
                            i3 = cVar.q();
                        }
                        c0367c2 = c0367c;
                    }
                    cVar.i();
                    break;
                case 2:
                    dVar = AbstractC0433d.h(cVar, c0221a);
                    continue;
                case 3:
                    str = str2;
                    enumC0378g = cVar.q() == 1 ? EnumC0378g.LINEAR : EnumC0378g.RADIAL;
                    break;
                case 4:
                    fVar = AbstractC0433d.i(cVar, c0221a);
                    continue;
                case 5:
                    fVar2 = AbstractC0433d.i(cVar, c0221a);
                    continue;
                case 6:
                    c0366b = AbstractC0433d.e(cVar, c0221a);
                    continue;
                case 7:
                    str = str2;
                    bVar = C0389r.b.values()[cVar.q() - 1];
                    break;
                case 8:
                    str = str2;
                    cVar2 = C0389r.c.values()[cVar.q() - 1];
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    str = str2;
                    f3 = (float) cVar.p();
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    z3 = cVar.l();
                    continue;
                case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                    cVar.b();
                    while (cVar.j()) {
                        cVar.c();
                        String str3 = null;
                        C0366b c0366b3 = null;
                        while (cVar.j()) {
                            int a03 = cVar.a0(f12273c);
                            if (a03 != 0) {
                                C0366b c0366b4 = c0366b2;
                                if (a03 != 1) {
                                    cVar.b0();
                                    cVar.c0();
                                } else {
                                    c0366b3 = AbstractC0433d.e(cVar, c0221a);
                                }
                                c0366b2 = c0366b4;
                            } else {
                                str3 = cVar.G();
                            }
                        }
                        C0366b c0366b5 = c0366b2;
                        cVar.i();
                        if (str3.equals("o")) {
                            c0366b2 = c0366b3;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                c0221a.u(true);
                                arrayList.add(c0366b3);
                            }
                            c0366b2 = c0366b5;
                        }
                    }
                    C0366b c0366b6 = c0366b2;
                    cVar.g();
                    if (arrayList.size() == 1) {
                        arrayList.add((C0366b) arrayList.get(0));
                    }
                    c0366b2 = c0366b6;
                    continue;
                default:
                    cVar.b0();
                    cVar.c0();
                    continue;
            }
            str2 = str;
        }
        String str4 = str2;
        if (dVar == null) {
            dVar = new g1.d(Collections.singletonList(new n1.c(100)));
        }
        return new C0377f(str4, enumC0378g, c0367c2, dVar, fVar, fVar2, c0366b, bVar, cVar2, f3, arrayList, c0366b2, z3);
    }
}
