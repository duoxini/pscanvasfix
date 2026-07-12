package P2;

import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public final class e extends d {
    public /* synthetic */ e(O2.c cVar, t2.g gVar, int i3, N2.a aVar, int i4, D2.g gVar2) {
        this(cVar, (i4 & 2) != 0 ? t2.h.f13692e : gVar, (i4 & 4) != 0 ? -3 : i3, (i4 & 8) != 0 ? N2.a.SUSPEND : aVar);
    }

    @Override // P2.b
    protected b e(t2.g gVar, int i3, N2.a aVar) {
        return new e(this.f1870d, gVar, i3, aVar);
    }

    @Override // P2.d
    protected Object l(O2.d dVar, InterfaceC0593d interfaceC0593d) {
        Object collect = this.f1870d.collect(dVar, interfaceC0593d);
        return collect == AbstractC0603b.c() ? collect : q.f12810a;
    }

    public e(O2.c cVar, t2.g gVar, int i3, N2.a aVar) {
        super(cVar, gVar, i3, aVar);
    }
}
