package r;

import r.f;

/* loaded from: classes.dex */
class g extends f {

    /* renamed from: m, reason: collision with root package name */
    public int f13100m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f13083e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f13083e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // r.f
    public void d(int i3) {
        if (this.f13088j) {
            return;
        }
        this.f13088j = true;
        this.f13085g = i3;
        for (d dVar : this.f13089k) {
            dVar.a(dVar);
        }
    }
}
