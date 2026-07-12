package t2;

import C2.p;
import D2.k;
import java.io.Serializable;
import t2.g;

/* loaded from: classes.dex */
public final class h implements g, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final h f13692e = new h();

    private h() {
    }

    @Override // t2.g
    public g N(g.c cVar) {
        k.e(cVar, "key");
        return this;
    }

    @Override // t2.g
    public g.b a(g.c cVar) {
        k.e(cVar, "key");
        return null;
    }

    @Override // t2.g
    public Object g(Object obj, p pVar) {
        k.e(pVar, "operation");
        return obj;
    }

    public int hashCode() {
        return 0;
    }

    @Override // t2.g
    public g p(g gVar) {
        k.e(gVar, "context");
        return gVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
