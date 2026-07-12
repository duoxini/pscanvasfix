package k1;

import a1.C0221a;
import android.graphics.Path;
import g1.C0367c;
import h1.C0376e;
import h1.EnumC0378g;
import java.util.Collections;
import l1.c;

/* loaded from: classes.dex */
abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12269a = c.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12270b = c.a.a("p", "k");

    static C0376e a(l1.c cVar, C0221a c0221a) {
        g1.d dVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        EnumC0378g enumC0378g = null;
        C0367c c0367c = null;
        g1.f fVar = null;
        g1.f fVar2 = null;
        boolean z3 = false;
        while (cVar.j()) {
            switch (cVar.a0(f12269a)) {
                case 0:
                    str = cVar.G();
                    break;
                case 1:
                    cVar.c();
                    int i3 = -1;
                    while (cVar.j()) {
                        int a02 = cVar.a0(f12270b);
                        if (a02 == 0) {
                            i3 = cVar.q();
                        } else if (a02 != 1) {
                            cVar.b0();
                            cVar.c0();
                        } else {
                            c0367c = AbstractC0433d.g(cVar, c0221a, i3);
                        }
                    }
                    cVar.i();
                    break;
                case 2:
                    dVar = AbstractC0433d.h(cVar, c0221a);
                    break;
                case 3:
                    enumC0378g = cVar.q() == 1 ? EnumC0378g.LINEAR : EnumC0378g.RADIAL;
                    break;
                case 4:
                    fVar = AbstractC0433d.i(cVar, c0221a);
                    break;
                case 5:
                    fVar2 = AbstractC0433d.i(cVar, c0221a);
                    break;
                case 6:
                    fillType = cVar.q() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z3 = cVar.l();
                    break;
                default:
                    cVar.b0();
                    cVar.c0();
                    break;
            }
        }
        return new C0376e(str, enumC0378g, fillType, c0367c, dVar == null ? new g1.d(Collections.singletonList(new n1.c(100))) : dVar, fVar, fVar2, null, null, z3);
    }
}
