package r;

import q.d;
import q.e;
import r.f;
import r.p;

/* loaded from: classes.dex */
public class n extends p {

    /* renamed from: k, reason: collision with root package name */
    public f f13114k;

    /* renamed from: l, reason: collision with root package name */
    g f13115l;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13116a;

        static {
            int[] iArr = new int[p.b.values().length];
            f13116a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13116a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13116a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(q.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f13114k = fVar;
        this.f13115l = null;
        this.f13139h.f13083e = f.a.TOP;
        this.f13140i.f13083e = f.a.BOTTOM;
        fVar.f13083e = f.a.BASELINE;
        this.f13137f = 1;
    }

    @Override // r.p, r.d
    public void a(d dVar) {
        float f3;
        float t3;
        float f4;
        int i3;
        int i4 = a.f13116a[this.f13141j.ordinal()];
        if (i4 == 1) {
            p(dVar);
        } else if (i4 == 2) {
            o(dVar);
        } else if (i4 == 3) {
            q.e eVar = this.f13133b;
            n(dVar, eVar.f12883P, eVar.f12885R, 1);
            return;
        }
        g gVar = this.f13136e;
        if (gVar.f13081c && !gVar.f13088j && this.f13135d == e.b.MATCH_CONSTRAINT) {
            q.e eVar2 = this.f13133b;
            int i5 = eVar2.f12940x;
            if (i5 == 2) {
                q.e I3 = eVar2.I();
                if (I3 != null) {
                    if (I3.f12904f.f13136e.f13088j) {
                        this.f13136e.d((int) ((r7.f13085g * this.f13133b.f12866E) + 0.5f));
                    }
                }
            } else if (i5 == 3 && eVar2.f12902e.f13136e.f13088j) {
                int u3 = eVar2.u();
                if (u3 == -1) {
                    q.e eVar3 = this.f13133b;
                    f3 = eVar3.f12902e.f13136e.f13085g;
                    t3 = eVar3.t();
                } else if (u3 == 0) {
                    f4 = r7.f12902e.f13136e.f13085g * this.f13133b.t();
                    i3 = (int) (f4 + 0.5f);
                    this.f13136e.d(i3);
                } else if (u3 != 1) {
                    i3 = 0;
                    this.f13136e.d(i3);
                } else {
                    q.e eVar4 = this.f13133b;
                    f3 = eVar4.f12902e.f13136e.f13085g;
                    t3 = eVar4.t();
                }
                f4 = f3 / t3;
                i3 = (int) (f4 + 0.5f);
                this.f13136e.d(i3);
            }
        }
        f fVar = this.f13139h;
        if (fVar.f13081c) {
            f fVar2 = this.f13140i;
            if (fVar2.f13081c) {
                if (fVar.f13088j && fVar2.f13088j && this.f13136e.f13088j) {
                    return;
                }
                if (!this.f13136e.f13088j && this.f13135d == e.b.MATCH_CONSTRAINT) {
                    q.e eVar5 = this.f13133b;
                    if (eVar5.f12938w == 0 && !eVar5.i0()) {
                        f fVar3 = (f) this.f13139h.f13090l.get(0);
                        f fVar4 = (f) this.f13140i.f13090l.get(0);
                        int i6 = fVar3.f13085g;
                        f fVar5 = this.f13139h;
                        int i7 = i6 + fVar5.f13084f;
                        int i8 = fVar4.f13085g + this.f13140i.f13084f;
                        fVar5.d(i7);
                        this.f13140i.d(i8);
                        this.f13136e.d(i8 - i7);
                        return;
                    }
                }
                if (!this.f13136e.f13088j && this.f13135d == e.b.MATCH_CONSTRAINT && this.f13132a == 1 && this.f13139h.f13090l.size() > 0 && this.f13140i.f13090l.size() > 0) {
                    f fVar6 = (f) this.f13139h.f13090l.get(0);
                    int i9 = (((f) this.f13140i.f13090l.get(0)).f13085g + this.f13140i.f13084f) - (fVar6.f13085g + this.f13139h.f13084f);
                    g gVar2 = this.f13136e;
                    int i10 = gVar2.f13100m;
                    if (i9 < i10) {
                        gVar2.d(i9);
                    } else {
                        gVar2.d(i10);
                    }
                }
                if (this.f13136e.f13088j && this.f13139h.f13090l.size() > 0 && this.f13140i.f13090l.size() > 0) {
                    f fVar7 = (f) this.f13139h.f13090l.get(0);
                    f fVar8 = (f) this.f13140i.f13090l.get(0);
                    int i11 = fVar7.f13085g + this.f13139h.f13084f;
                    int i12 = fVar8.f13085g + this.f13140i.f13084f;
                    float P3 = this.f13133b.P();
                    if (fVar7 == fVar8) {
                        i11 = fVar7.f13085g;
                        i12 = fVar8.f13085g;
                        P3 = 0.5f;
                    }
                    this.f13139h.d((int) (i11 + 0.5f + (((i12 - i11) - this.f13136e.f13085g) * P3)));
                    this.f13140i.d(this.f13139h.f13085g + this.f13136e.f13085g);
                }
            }
        }
    }

    @Override // r.p
    void d() {
        q.e I3;
        q.e I4;
        q.e eVar = this.f13133b;
        if (eVar.f12894a) {
            this.f13136e.d(eVar.v());
        }
        if (!this.f13136e.f13088j) {
            this.f13135d = this.f13133b.R();
            if (this.f13133b.X()) {
                this.f13115l = new C0557a(this);
            }
            e.b bVar = this.f13135d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (I4 = this.f13133b.I()) != null && I4.R() == e.b.FIXED) {
                    int v3 = (I4.v() - this.f13133b.f12883P.e()) - this.f13133b.f12885R.e();
                    b(this.f13139h, I4.f12904f.f13139h, this.f13133b.f12883P.e());
                    b(this.f13140i, I4.f12904f.f13140i, -this.f13133b.f12885R.e());
                    this.f13136e.d(v3);
                    return;
                }
                if (this.f13135d == e.b.FIXED) {
                    this.f13136e.d(this.f13133b.v());
                }
            }
        } else if (this.f13135d == e.b.MATCH_PARENT && (I3 = this.f13133b.I()) != null && I3.R() == e.b.FIXED) {
            b(this.f13139h, I3.f12904f.f13139h, this.f13133b.f12883P.e());
            b(this.f13140i, I3.f12904f.f13140i, -this.f13133b.f12885R.e());
            return;
        }
        g gVar = this.f13136e;
        boolean z3 = gVar.f13088j;
        if (z3) {
            q.e eVar2 = this.f13133b;
            if (eVar2.f12894a) {
                q.d[] dVarArr = eVar2.f12890W;
                q.d dVar = dVarArr[2];
                q.d dVar2 = dVar.f12842f;
                if (dVar2 != null && dVarArr[3].f12842f != null) {
                    if (eVar2.i0()) {
                        this.f13139h.f13084f = this.f13133b.f12890W[2].e();
                        this.f13140i.f13084f = -this.f13133b.f12890W[3].e();
                    } else {
                        f h3 = h(this.f13133b.f12890W[2]);
                        if (h3 != null) {
                            b(this.f13139h, h3, this.f13133b.f12890W[2].e());
                        }
                        f h4 = h(this.f13133b.f12890W[3]);
                        if (h4 != null) {
                            b(this.f13140i, h4, -this.f13133b.f12890W[3].e());
                        }
                        this.f13139h.f13080b = true;
                        this.f13140i.f13080b = true;
                    }
                    if (this.f13133b.X()) {
                        b(this.f13114k, this.f13139h, this.f13133b.n());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f h5 = h(dVar);
                    if (h5 != null) {
                        b(this.f13139h, h5, this.f13133b.f12890W[2].e());
                        b(this.f13140i, this.f13139h, this.f13136e.f13085g);
                        if (this.f13133b.X()) {
                            b(this.f13114k, this.f13139h, this.f13133b.n());
                            return;
                        }
                        return;
                    }
                    return;
                }
                q.d dVar3 = dVarArr[3];
                if (dVar3.f12842f != null) {
                    f h6 = h(dVar3);
                    if (h6 != null) {
                        b(this.f13140i, h6, -this.f13133b.f12890W[3].e());
                        b(this.f13139h, this.f13140i, -this.f13136e.f13085g);
                    }
                    if (this.f13133b.X()) {
                        b(this.f13114k, this.f13139h, this.f13133b.n());
                        return;
                    }
                    return;
                }
                q.d dVar4 = dVarArr[4];
                if (dVar4.f12842f != null) {
                    f h7 = h(dVar4);
                    if (h7 != null) {
                        b(this.f13114k, h7, 0);
                        b(this.f13139h, this.f13114k, -this.f13133b.n());
                        b(this.f13140i, this.f13139h, this.f13136e.f13085g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof q.h) || eVar2.I() == null || this.f13133b.m(d.b.CENTER).f12842f != null) {
                    return;
                }
                b(this.f13139h, this.f13133b.I().f12904f.f13139h, this.f13133b.W());
                b(this.f13140i, this.f13139h, this.f13136e.f13085g);
                if (this.f13133b.X()) {
                    b(this.f13114k, this.f13139h, this.f13133b.n());
                    return;
                }
                return;
            }
        }
        if (z3 || this.f13135d != e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            q.e eVar3 = this.f13133b;
            int i3 = eVar3.f12940x;
            if (i3 == 2) {
                q.e I5 = eVar3.I();
                if (I5 != null) {
                    g gVar2 = I5.f12904f.f13136e;
                    this.f13136e.f13090l.add(gVar2);
                    gVar2.f13089k.add(this.f13136e);
                    g gVar3 = this.f13136e;
                    gVar3.f13080b = true;
                    gVar3.f13089k.add(this.f13139h);
                    this.f13136e.f13089k.add(this.f13140i);
                }
            } else if (i3 == 3 && !eVar3.i0()) {
                q.e eVar4 = this.f13133b;
                if (eVar4.f12938w != 3) {
                    g gVar4 = eVar4.f12902e.f13136e;
                    this.f13136e.f13090l.add(gVar4);
                    gVar4.f13089k.add(this.f13136e);
                    g gVar5 = this.f13136e;
                    gVar5.f13080b = true;
                    gVar5.f13089k.add(this.f13139h);
                    this.f13136e.f13089k.add(this.f13140i);
                }
            }
        }
        q.e eVar5 = this.f13133b;
        q.d[] dVarArr2 = eVar5.f12890W;
        q.d dVar5 = dVarArr2[2];
        q.d dVar6 = dVar5.f12842f;
        if (dVar6 != null && dVarArr2[3].f12842f != null) {
            if (eVar5.i0()) {
                this.f13139h.f13084f = this.f13133b.f12890W[2].e();
                this.f13140i.f13084f = -this.f13133b.f12890W[3].e();
            } else {
                f h8 = h(this.f13133b.f12890W[2]);
                f h9 = h(this.f13133b.f12890W[3]);
                if (h8 != null) {
                    h8.b(this);
                }
                if (h9 != null) {
                    h9.b(this);
                }
                this.f13141j = p.b.CENTER;
            }
            if (this.f13133b.X()) {
                c(this.f13114k, this.f13139h, 1, this.f13115l);
            }
        } else if (dVar6 != null) {
            f h10 = h(dVar5);
            if (h10 != null) {
                b(this.f13139h, h10, this.f13133b.f12890W[2].e());
                c(this.f13140i, this.f13139h, 1, this.f13136e);
                if (this.f13133b.X()) {
                    c(this.f13114k, this.f13139h, 1, this.f13115l);
                }
                e.b bVar2 = this.f13135d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f13133b.t() > 0.0f) {
                    l lVar = this.f13133b.f12902e;
                    if (lVar.f13135d == bVar3) {
                        lVar.f13136e.f13089k.add(this.f13136e);
                        this.f13136e.f13090l.add(this.f13133b.f12902e.f13136e);
                        this.f13136e.f13079a = this;
                    }
                }
            }
        } else {
            q.d dVar7 = dVarArr2[3];
            if (dVar7.f12842f != null) {
                f h11 = h(dVar7);
                if (h11 != null) {
                    b(this.f13140i, h11, -this.f13133b.f12890W[3].e());
                    c(this.f13139h, this.f13140i, -1, this.f13136e);
                    if (this.f13133b.X()) {
                        c(this.f13114k, this.f13139h, 1, this.f13115l);
                    }
                }
            } else {
                q.d dVar8 = dVarArr2[4];
                if (dVar8.f12842f != null) {
                    f h12 = h(dVar8);
                    if (h12 != null) {
                        b(this.f13114k, h12, 0);
                        c(this.f13139h, this.f13114k, -1, this.f13115l);
                        c(this.f13140i, this.f13139h, 1, this.f13136e);
                    }
                } else if (!(eVar5 instanceof q.h) && eVar5.I() != null) {
                    b(this.f13139h, this.f13133b.I().f12904f.f13139h, this.f13133b.W());
                    c(this.f13140i, this.f13139h, 1, this.f13136e);
                    if (this.f13133b.X()) {
                        c(this.f13114k, this.f13139h, 1, this.f13115l);
                    }
                    e.b bVar4 = this.f13135d;
                    e.b bVar5 = e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f13133b.t() > 0.0f) {
                        l lVar2 = this.f13133b.f12902e;
                        if (lVar2.f13135d == bVar5) {
                            lVar2.f13136e.f13089k.add(this.f13136e);
                            this.f13136e.f13090l.add(this.f13133b.f12902e.f13136e);
                            this.f13136e.f13079a = this;
                        }
                    }
                }
            }
        }
        if (this.f13136e.f13090l.size() == 0) {
            this.f13136e.f13081c = true;
        }
    }

    @Override // r.p
    public void e() {
        f fVar = this.f13139h;
        if (fVar.f13088j) {
            this.f13133b.j1(fVar.f13085g);
        }
    }

    @Override // r.p
    void f() {
        this.f13134c = null;
        this.f13139h.c();
        this.f13140i.c();
        this.f13114k.c();
        this.f13136e.c();
        this.f13138g = false;
    }

    @Override // r.p
    boolean m() {
        return this.f13135d != e.b.MATCH_CONSTRAINT || this.f13133b.f12940x == 0;
    }

    void q() {
        this.f13138g = false;
        this.f13139h.c();
        this.f13139h.f13088j = false;
        this.f13140i.c();
        this.f13140i.f13088j = false;
        this.f13114k.c();
        this.f13114k.f13088j = false;
        this.f13136e.f13088j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f13133b.r();
    }
}
