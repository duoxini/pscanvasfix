package t2;

import C2.p;
import D2.k;
import t2.g;

/* renamed from: t2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0590a implements g.b {

    /* renamed from: e, reason: collision with root package name */
    private final g.c f13683e;

    public AbstractC0590a(g.c cVar) {
        k.e(cVar, "key");
        this.f13683e = cVar;
    }

    @Override // t2.g
    public g N(g.c cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // t2.g.b, t2.g
    public g.b a(g.c cVar) {
        return g.b.a.b(this, cVar);
    }

    @Override // t2.g
    public Object g(Object obj, p pVar) {
        return g.b.a.a(this, obj, pVar);
    }

    @Override // t2.g.b
    public g.c getKey() {
        return this.f13683e;
    }

    @Override // t2.g
    public g p(g gVar) {
        return g.b.a.d(this, gVar);
    }
}
