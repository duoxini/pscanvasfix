package k1;

import a1.C0221a;
import g1.C0366b;
import h1.C0384m;
import l1.c;

/* renamed from: k1.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0427F {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12226a = c.a.a("nm", "r", "hd");

    static C0384m a(l1.c cVar, C0221a c0221a) {
        boolean z3 = false;
        String str = null;
        C0366b c0366b = null;
        while (cVar.j()) {
            int a02 = cVar.a0(f12226a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                c0366b = AbstractC0433d.f(cVar, c0221a, true);
            } else if (a02 != 2) {
                cVar.c0();
            } else {
                z3 = cVar.l();
            }
        }
        if (z3) {
            return null;
        }
        return new C0384m(str, c0366b);
    }
}
