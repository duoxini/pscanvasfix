package k1;

import a1.C0221a;
import android.graphics.Path;
import g1.C0365a;
import h1.C0386o;
import java.util.Collections;
import l1.c;

/* loaded from: classes.dex */
abstract class I {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12230a = c.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    static C0386o a(l1.c cVar, C0221a c0221a) {
        g1.d dVar = null;
        String str = null;
        C0365a c0365a = null;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 1;
        while (cVar.j()) {
            int a02 = cVar.a0(f12230a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                c0365a = AbstractC0433d.c(cVar, c0221a);
            } else if (a02 == 2) {
                dVar = AbstractC0433d.h(cVar, c0221a);
            } else if (a02 == 3) {
                z3 = cVar.l();
            } else if (a02 == 4) {
                i3 = cVar.q();
            } else if (a02 != 5) {
                cVar.b0();
                cVar.c0();
            } else {
                z4 = cVar.l();
            }
        }
        if (dVar == null) {
            dVar = new g1.d(Collections.singletonList(new n1.c(100)));
        }
        return new C0386o(str, z3, i3 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, c0365a, dVar, z4);
    }
}
