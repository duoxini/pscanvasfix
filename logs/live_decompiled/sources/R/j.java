package r;

/* loaded from: classes.dex */
class j extends p {
    public j(q.e eVar) {
        super(eVar);
        eVar.f12902e.f();
        eVar.f12904f.f();
        this.f13137f = ((q.g) eVar).o1();
    }

    private void q(f fVar) {
        this.f13139h.f13089k.add(fVar);
        fVar.f13090l.add(this.f13139h);
    }

    @Override // r.p, r.d
    public void a(d dVar) {
        f fVar = this.f13139h;
        if (fVar.f13081c && !fVar.f13088j) {
            this.f13139h.d((int) ((((f) fVar.f13090l.get(0)).f13085g * ((q.g) this.f13133b).r1()) + 0.5f));
        }
    }

    @Override // r.p
    void d() {
        q.g gVar = (q.g) this.f13133b;
        int p12 = gVar.p1();
        int q12 = gVar.q1();
        gVar.r1();
        if (gVar.o1() == 1) {
            if (p12 != -1) {
                this.f13139h.f13090l.add(this.f13133b.f12895a0.f12902e.f13139h);
                this.f13133b.f12895a0.f12902e.f13139h.f13089k.add(this.f13139h);
                this.f13139h.f13084f = p12;
            } else if (q12 != -1) {
                this.f13139h.f13090l.add(this.f13133b.f12895a0.f12902e.f13140i);
                this.f13133b.f12895a0.f12902e.f13140i.f13089k.add(this.f13139h);
                this.f13139h.f13084f = -q12;
            } else {
                f fVar = this.f13139h;
                fVar.f13080b = true;
                fVar.f13090l.add(this.f13133b.f12895a0.f12902e.f13140i);
                this.f13133b.f12895a0.f12902e.f13140i.f13089k.add(this.f13139h);
            }
            q(this.f13133b.f12902e.f13139h);
            q(this.f13133b.f12902e.f13140i);
            return;
        }
        if (p12 != -1) {
            this.f13139h.f13090l.add(this.f13133b.f12895a0.f12904f.f13139h);
            this.f13133b.f12895a0.f12904f.f13139h.f13089k.add(this.f13139h);
            this.f13139h.f13084f = p12;
        } else if (q12 != -1) {
            this.f13139h.f13090l.add(this.f13133b.f12895a0.f12904f.f13140i);
            this.f13133b.f12895a0.f12904f.f13140i.f13089k.add(this.f13139h);
            this.f13139h.f13084f = -q12;
        } else {
            f fVar2 = this.f13139h;
            fVar2.f13080b = true;
            fVar2.f13090l.add(this.f13133b.f12895a0.f12904f.f13140i);
            this.f13133b.f12895a0.f12904f.f13140i.f13089k.add(this.f13139h);
        }
        q(this.f13133b.f12904f.f13139h);
        q(this.f13133b.f12904f.f13140i);
    }

    @Override // r.p
    public void e() {
        if (((q.g) this.f13133b).o1() == 1) {
            this.f13133b.i1(this.f13139h.f13085g);
        } else {
            this.f13133b.j1(this.f13139h.f13085g);
        }
    }

    @Override // r.p
    void f() {
        this.f13139h.c();
    }

    @Override // r.p
    boolean m() {
        return false;
    }
}
