package k1;

import a1.C0221a;
import g1.C0365a;
import g1.C0366b;
import g1.C0367c;
import java.util.List;
import m1.AbstractC0465h;

/* renamed from: k1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0433d {
    private static List a(l1.c cVar, float f3, C0221a c0221a, N n3) {
        return v.a(cVar, c0221a, f3, n3, false);
    }

    private static List b(l1.c cVar, C0221a c0221a, N n3) {
        return v.a(cVar, c0221a, 1.0f, n3, false);
    }

    static C0365a c(l1.c cVar, C0221a c0221a) {
        return new C0365a(b(cVar, c0221a, C0436g.f12244a));
    }

    static g1.j d(l1.c cVar, C0221a c0221a) {
        return new g1.j(a(cVar, AbstractC0465h.e(), c0221a, C0438i.f12246a));
    }

    public static C0366b e(l1.c cVar, C0221a c0221a) {
        return f(cVar, c0221a, true);
    }

    public static C0366b f(l1.c cVar, C0221a c0221a, boolean z3) {
        return new C0366b(a(cVar, z3 ? AbstractC0465h.e() : 1.0f, c0221a, C0442m.f12264a));
    }

    static C0367c g(l1.c cVar, C0221a c0221a, int i3) {
        return new C0367c(b(cVar, c0221a, new p(i3)));
    }

    static g1.d h(l1.c cVar, C0221a c0221a) {
        return new g1.d(b(cVar, c0221a, s.f12274a));
    }

    static g1.f i(l1.c cVar, C0221a c0221a) {
        return new g1.f(v.a(cVar, c0221a, AbstractC0465h.e(), C0423B.f12222a, true));
    }

    static g1.g j(l1.c cVar, C0221a c0221a) {
        return new g1.g(b(cVar, c0221a, C0428G.f12227a));
    }

    static g1.h k(l1.c cVar, C0221a c0221a) {
        return new g1.h(a(cVar, AbstractC0465h.e(), c0221a, C0429H.f12228a));
    }
}
