package O2;

import D2.k;
import L2.e0;
import P2.g;

/* loaded from: classes.dex */
abstract /* synthetic */ class h {
    private static final void a(t2.g gVar) {
        if (gVar.a(e0.f1268b) == null) {
            return;
        }
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + gVar).toString());
    }

    public static final c b(c cVar, t2.g gVar) {
        a(gVar);
        if (k.a(gVar, t2.h.f13692e)) {
            return cVar;
        }
        if (cVar instanceof P2.g) {
            return g.a.a((P2.g) cVar, gVar, 0, null, 6, null);
        }
        return new P2.e(cVar, gVar, 0, null, 12, null);
    }
}
