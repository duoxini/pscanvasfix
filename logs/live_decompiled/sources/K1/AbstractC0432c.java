package k1;

import a1.C0221a;
import android.graphics.PointF;
import com.oplus.backup.sdk.common.utils.Constants;
import g1.C0366b;
import l1.c;

/* renamed from: k1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0432c {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12239a = c.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12240b = c.a.a("k");

    private static boolean a(g1.e eVar) {
        return eVar == null || (eVar.c() && ((PointF) ((n1.c) eVar.b().get(0)).f12574b).equals(0.0f, 0.0f));
    }

    private static boolean b(g1.m mVar) {
        return mVar == null || (!(mVar instanceof g1.i) && mVar.c() && ((PointF) ((n1.c) mVar.b().get(0)).f12574b).equals(0.0f, 0.0f));
    }

    private static boolean c(C0366b c0366b) {
        return c0366b == null || (c0366b.c() && ((Float) ((n1.c) c0366b.b().get(0)).f12574b).floatValue() == 0.0f);
    }

    private static boolean d(g1.g gVar) {
        return gVar == null || (gVar.c() && ((n1.d) ((n1.c) gVar.b().get(0)).f12574b).a(1.0f, 1.0f));
    }

    private static boolean e(C0366b c0366b) {
        return c0366b == null || (c0366b.c() && ((Float) ((n1.c) c0366b.b().get(0)).f12574b).floatValue() == 0.0f);
    }

    private static boolean f(C0366b c0366b) {
        return c0366b == null || (c0366b.c() && ((Float) ((n1.c) c0366b.b().get(0)).f12574b).floatValue() == 0.0f);
    }

    public static g1.l g(l1.c cVar, C0221a c0221a) {
        boolean z3;
        boolean z4;
        boolean z5 = false;
        boolean z6 = cVar.N() == c.b.BEGIN_OBJECT;
        if (z6) {
            cVar.c();
        }
        C0366b c0366b = null;
        g1.e eVar = null;
        g1.m mVar = null;
        g1.g gVar = null;
        C0366b c0366b2 = null;
        C0366b c0366b3 = null;
        g1.d dVar = null;
        C0366b c0366b4 = null;
        C0366b c0366b5 = null;
        while (cVar.j()) {
            switch (cVar.a0(f12239a)) {
                case 0:
                    z3 = z5;
                    cVar.c();
                    while (cVar.j()) {
                        if (cVar.a0(f12240b) != 0) {
                            cVar.b0();
                            cVar.c0();
                        } else {
                            eVar = AbstractC0430a.a(cVar, c0221a);
                        }
                    }
                    cVar.i();
                    break;
                case 1:
                    mVar = AbstractC0430a.b(cVar, c0221a);
                    continue;
                case 2:
                    gVar = AbstractC0433d.j(cVar, c0221a);
                    continue;
                case 3:
                    z3 = z5;
                    c0221a.a("EffectiveAnimation doesn't support 3D layers.");
                    break;
                case 4:
                    C0366b f3 = AbstractC0433d.f(cVar, c0221a, z5);
                    if (f3.b().isEmpty()) {
                        f3.b().add(new n1.c(c0221a, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c0221a.f())));
                    } else if (((n1.c) f3.b().get(0)).f12574b == null) {
                        z4 = false;
                        f3.b().set(0, new n1.c(c0221a, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(c0221a.f())));
                        z5 = z4;
                        c0366b = f3;
                        continue;
                    }
                    z4 = false;
                    z5 = z4;
                    c0366b = f3;
                    continue;
                case 5:
                    dVar = AbstractC0433d.h(cVar, c0221a);
                    continue;
                case 6:
                    c0366b4 = AbstractC0433d.f(cVar, c0221a, z5);
                    continue;
                case 7:
                    c0366b5 = AbstractC0433d.f(cVar, c0221a, z5);
                    continue;
                case 8:
                    c0366b2 = AbstractC0433d.f(cVar, c0221a, z5);
                    continue;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    c0366b3 = AbstractC0433d.f(cVar, c0221a, z5);
                    continue;
                default:
                    cVar.b0();
                    cVar.c0();
                    z3 = z5;
                    break;
            }
            z5 = z3;
        }
        if (z6) {
            cVar.i();
        }
        g1.e eVar2 = a(eVar) ? null : eVar;
        g1.m mVar2 = b(mVar) ? null : mVar;
        C0366b c0366b6 = c(c0366b) ? null : c0366b;
        if (d(gVar)) {
            gVar = null;
        }
        return new g1.l(eVar2, mVar2, gVar, c0366b6, dVar, c0366b4, c0366b5, f(c0366b2) ? null : c0366b2, e(c0366b3) ? null : c0366b3);
    }
}
