package N2;

import L2.C;
import N2.s;

/* loaded from: classes.dex */
final class p extends e implements q {
    public p(t2.g gVar, d dVar) {
        super(gVar, dVar, true, true);
    }

    @Override // L2.AbstractC0166a
    protected void E0(Throwable th, boolean z3) {
        if (I0().e(th) || z3) {
            return;
        }
        C.a(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // L2.AbstractC0166a
    /* renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void F0(p2.q qVar) {
        s.a.a(I0(), null, 1, null);
    }

    @Override // L2.AbstractC0166a, L2.l0, L2.e0
    public boolean c() {
        return super.c();
    }

    @Override // N2.q
    public /* bridge */ /* synthetic */ s r() {
        return H0();
    }
}
