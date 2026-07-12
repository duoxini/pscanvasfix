package k1;

import a1.C0221a;
import g1.C0366b;
import java.util.ArrayList;
import l1.c;
import m1.AbstractC0465h;

/* renamed from: k1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0430a {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12236a = c.a.a("k", "x", "y");

    public static g1.e a(l1.c cVar, C0221a c0221a) {
        ArrayList arrayList = new ArrayList();
        if (cVar.N() == c.b.BEGIN_ARRAY) {
            cVar.b();
            while (cVar.j()) {
                arrayList.add(z.a(cVar, c0221a));
            }
            cVar.g();
            v.b(arrayList);
        } else {
            arrayList.add(new n1.c(t.e(cVar, AbstractC0465h.e())));
        }
        return new g1.e(arrayList);
    }

    static g1.m b(l1.c cVar, C0221a c0221a) {
        cVar.c();
        g1.e eVar = null;
        C0366b c0366b = null;
        boolean z3 = false;
        C0366b c0366b2 = null;
        while (cVar.N() != c.b.END_OBJECT) {
            int a02 = cVar.a0(f12236a);
            if (a02 == 0) {
                eVar = a(cVar, c0221a);
            } else if (a02 != 1) {
                if (a02 != 2) {
                    cVar.b0();
                    cVar.c0();
                } else if (cVar.N() == c.b.STRING) {
                    cVar.c0();
                    z3 = true;
                } else {
                    c0366b = AbstractC0433d.e(cVar, c0221a);
                }
            } else if (cVar.N() == c.b.STRING) {
                cVar.c0();
                z3 = true;
            } else {
                c0366b2 = AbstractC0433d.e(cVar, c0221a);
            }
        }
        cVar.i();
        if (z3) {
            c0221a.a("EffectiveAnimation doesn't support expressions.");
        }
        return eVar != null ? eVar : new g1.i(c0366b2, c0366b);
    }
}
