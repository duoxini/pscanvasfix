package r;

import java.util.Iterator;
import q.C0512a;
import r.f;

/* loaded from: classes.dex */
class k extends p {
    public k(q.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f13139h.f13089k.add(fVar);
        fVar.f13090l.add(this.f13139h);
    }

    @Override // r.p, r.d
    public void a(d dVar) {
        C0512a c0512a = (C0512a) this.f13133b;
        int r12 = c0512a.r1();
        Iterator it = this.f13139h.f13090l.iterator();
        int i3 = 0;
        int i4 = -1;
        while (it.hasNext()) {
            int i5 = ((f) it.next()).f13085g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (r12 == 0 || r12 == 2) {
            this.f13139h.d(i4 + c0512a.s1());
        } else {
            this.f13139h.d(i3 + c0512a.s1());
        }
    }

    @Override // r.p
    void d() {
        q.e eVar = this.f13133b;
        if (eVar instanceof C0512a) {
            this.f13139h.f13080b = true;
            C0512a c0512a = (C0512a) eVar;
            int r12 = c0512a.r1();
            boolean q12 = c0512a.q1();
            int i3 = 0;
            if (r12 == 0) {
                this.f13139h.f13083e = f.a.LEFT;
                while (i3 < c0512a.f12993M0) {
                    q.e eVar2 = c0512a.f12992L0[i3];
                    if (q12 || eVar2.T() != 8) {
                        f fVar = eVar2.f12902e.f13139h;
                        fVar.f13089k.add(this.f13139h);
                        this.f13139h.f13090l.add(fVar);
                    }
                    i3++;
                }
                q(this.f13133b.f12902e.f13139h);
                q(this.f13133b.f12902e.f13140i);
                return;
            }
            if (r12 == 1) {
                this.f13139h.f13083e = f.a.RIGHT;
                while (i3 < c0512a.f12993M0) {
                    q.e eVar3 = c0512a.f12992L0[i3];
                    if (q12 || eVar3.T() != 8) {
                        f fVar2 = eVar3.f12902e.f13140i;
                        fVar2.f13089k.add(this.f13139h);
                        this.f13139h.f13090l.add(fVar2);
                    }
                    i3++;
                }
                q(this.f13133b.f12902e.f13139h);
                q(this.f13133b.f12902e.f13140i);
                return;
            }
            if (r12 == 2) {
                this.f13139h.f13083e = f.a.TOP;
                while (i3 < c0512a.f12993M0) {
                    q.e eVar4 = c0512a.f12992L0[i3];
                    if (q12 || eVar4.T() != 8) {
                        f fVar3 = eVar4.f12904f.f13139h;
                        fVar3.f13089k.add(this.f13139h);
                        this.f13139h.f13090l.add(fVar3);
                    }
                    i3++;
                }
                q(this.f13133b.f12904f.f13139h);
                q(this.f13133b.f12904f.f13140i);
                return;
            }
            if (r12 != 3) {
                return;
            }
            this.f13139h.f13083e = f.a.BOTTOM;
            while (i3 < c0512a.f12993M0) {
                q.e eVar5 = c0512a.f12992L0[i3];
                if (q12 || eVar5.T() != 8) {
                    f fVar4 = eVar5.f12904f.f13140i;
                    fVar4.f13089k.add(this.f13139h);
                    this.f13139h.f13090l.add(fVar4);
                }
                i3++;
            }
            q(this.f13133b.f12904f.f13139h);
            q(this.f13133b.f12904f.f13140i);
        }
    }

    @Override // r.p
    public void e() {
        q.e eVar = this.f13133b;
        if (eVar instanceof C0512a) {
            int r12 = ((C0512a) eVar).r1();
            if (r12 == 0 || r12 == 1) {
                this.f13133b.i1(this.f13139h.f13085g);
            } else {
                this.f13133b.j1(this.f13139h.f13085g);
            }
        }
    }

    @Override // r.p
    void f() {
        this.f13134c = null;
        this.f13139h.c();
    }

    @Override // r.p
    boolean m() {
        return false;
    }
}
