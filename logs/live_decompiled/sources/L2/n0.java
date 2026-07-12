package L2;

import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
final class n0 extends t0 {

    /* renamed from: h, reason: collision with root package name */
    private final InterfaceC0593d f1299h;

    public n0(t2.g gVar, C2.p pVar) {
        super(gVar, false);
        this.f1299h = AbstractC0603b.a(pVar, this, this);
    }

    @Override // L2.l0
    protected void o0() {
        R2.a.c(this.f1299h, this);
    }
}
