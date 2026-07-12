package O2;

import C2.p;
import N2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
abstract class b extends P2.b {

    /* renamed from: d, reason: collision with root package name */
    private final p f1733d;

    public b(p pVar, t2.g gVar, int i3, N2.a aVar) {
        super(gVar, i3, aVar);
        this.f1733d = pVar;
    }

    static /* synthetic */ Object i(b bVar, q qVar, InterfaceC0593d interfaceC0593d) {
        Object invoke = bVar.f1733d.invoke(qVar, interfaceC0593d);
        return invoke == AbstractC0603b.c() ? invoke : p2.q.f12810a;
    }

    @Override // P2.b
    protected Object d(q qVar, InterfaceC0593d interfaceC0593d) {
        return i(this, qVar, interfaceC0593d);
    }

    @Override // P2.b
    public String toString() {
        return "block[" + this.f1733d + "] -> " + super.toString();
    }
}
