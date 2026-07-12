package q;

import java.util.ArrayList;
import n.C0473c;

/* loaded from: classes.dex */
public abstract class k extends e {

    /* renamed from: L0, reason: collision with root package name */
    public ArrayList f12995L0 = new ArrayList();

    public void a(e eVar) {
        this.f12995L0.add(eVar);
        if (eVar.I() != null) {
            ((k) eVar.I()).p1(eVar);
        }
        eVar.Y0(this);
    }

    public ArrayList n1() {
        return this.f12995L0;
    }

    public abstract void o1();

    public void p1(e eVar) {
        this.f12995L0.remove(eVar);
        eVar.r0();
    }

    public void q1() {
        this.f12995L0.clear();
    }

    @Override // q.e
    public void r0() {
        this.f12995L0.clear();
        super.r0();
    }

    @Override // q.e
    public void t0(C0473c c0473c) {
        super.t0(c0473c);
        int size = this.f12995L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((e) this.f12995L0.get(i3)).t0(c0473c);
        }
    }
}
