package t2;

import C2.l;
import D2.k;
import t2.g;

/* renamed from: t2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0591b implements g.c {

    /* renamed from: e, reason: collision with root package name */
    private final l f13684e;

    /* renamed from: f, reason: collision with root package name */
    private final g.c f13685f;

    public AbstractC0591b(g.c cVar, l lVar) {
        k.e(cVar, "baseKey");
        k.e(lVar, "safeCast");
        this.f13684e = lVar;
        this.f13685f = cVar instanceof AbstractC0591b ? ((AbstractC0591b) cVar).f13685f : cVar;
    }

    public final boolean a(g.c cVar) {
        k.e(cVar, "key");
        return cVar == this || this.f13685f == cVar;
    }

    public final g.b b(g.b bVar) {
        k.e(bVar, "element");
        return (g.b) this.f13684e.f(bVar);
    }
}
