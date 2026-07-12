package H;

import D2.g;
import D2.k;
import H.a;

/* loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // H.a
    public Object a(a.b bVar) {
        k.e(bVar, "key");
        return b().get(bVar);
    }

    public final void c(a.b bVar, Object obj) {
        k.e(bVar, "key");
        b().put(bVar, obj);
    }

    public d(a aVar) {
        k.e(aVar, "initialExtras");
        b().putAll(aVar.b());
    }

    public /* synthetic */ d(a aVar, int i3, g gVar) {
        this((i3 & 1) != 0 ? a.C0013a.f454b : aVar);
    }
}
