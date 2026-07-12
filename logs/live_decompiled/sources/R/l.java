package r;

import q.d;
import q.e;
import r.f;
import r.p;

/* loaded from: classes.dex */
public class l extends p {

    /* renamed from: k, reason: collision with root package name */
    private static int[] f13104k = new int[2];

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13105a;

        static {
            int[] iArr = new int[p.b.values().length];
            f13105a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13105a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13105a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(q.e eVar) {
        super(eVar);
        this.f13139h.f13083e = f.a.LEFT;
        this.f13140i.f13083e = f.a.RIGHT;
        this.f13137f = 0;
    }

    private void q(int[] iArr, int i3, int i4, int i5, int i6, float f3, int i7) {
        int i8 = i4 - i3;
        int i9 = i6 - i5;
        if (i7 != -1) {
            if (i7 == 0) {
                iArr[0] = (int) ((i9 * f3) + 0.5f);
                iArr[1] = i9;
                return;
            } else {
                if (i7 != 1) {
                    return;
                }
                iArr[0] = i8;
                iArr[1] = (int) ((i8 * f3) + 0.5f);
                return;
            }
        }
        int i10 = (int) ((i9 * f3) + 0.5f);
        int i11 = (int) ((i8 / f3) + 0.5f);
        if (i10 <= i8) {
            iArr[0] = i10;
            iArr[1] = i9;
        } else if (i11 <= i9) {
            iArr[0] = i8;
            iArr[1] = i11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02ba, code lost:
    
        if (r14 != 1) goto L135;
     */
    @Override // r.p, r.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(r.d r17) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.l.a(r.d):void");
    }

    @Override // r.p
    void d() {
        q.e I3;
        q.e I4;
        q.e eVar = this.f13133b;
        if (eVar.f12894a) {
            this.f13136e.d(eVar.U());
        }
        if (this.f13136e.f13088j) {
            e.b bVar = this.f13135d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (I3 = this.f13133b.I()) != null && (I3.y() == e.b.FIXED || I3.y() == bVar2)) {
                b(this.f13139h, I3.f12902e.f13139h, this.f13133b.f12882O.e());
                b(this.f13140i, I3.f12902e.f13140i, -this.f13133b.f12884Q.e());
                return;
            }
        } else {
            e.b y3 = this.f13133b.y();
            this.f13135d = y3;
            if (y3 != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (y3 == bVar3 && (I4 = this.f13133b.I()) != null && (I4.y() == e.b.FIXED || I4.y() == bVar3)) {
                    int U3 = (I4.U() - this.f13133b.f12882O.e()) - this.f13133b.f12884Q.e();
                    b(this.f13139h, I4.f12902e.f13139h, this.f13133b.f12882O.e());
                    b(this.f13140i, I4.f12902e.f13140i, -this.f13133b.f12884Q.e());
                    this.f13136e.d(U3);
                    return;
                }
                if (this.f13135d == e.b.FIXED) {
                    this.f13136e.d(this.f13133b.U());
                }
            }
        }
        g gVar = this.f13136e;
        if (gVar.f13088j) {
            q.e eVar2 = this.f13133b;
            if (eVar2.f12894a) {
                q.d[] dVarArr = eVar2.f12890W;
                q.d dVar = dVarArr[0];
                q.d dVar2 = dVar.f12842f;
                if (dVar2 != null && dVarArr[1].f12842f != null) {
                    if (eVar2.g0()) {
                        this.f13139h.f13084f = this.f13133b.f12890W[0].e();
                        this.f13140i.f13084f = -this.f13133b.f12890W[1].e();
                        return;
                    }
                    f h3 = h(this.f13133b.f12890W[0]);
                    if (h3 != null) {
                        b(this.f13139h, h3, this.f13133b.f12890W[0].e());
                    }
                    f h4 = h(this.f13133b.f12890W[1]);
                    if (h4 != null) {
                        b(this.f13140i, h4, -this.f13133b.f12890W[1].e());
                    }
                    this.f13139h.f13080b = true;
                    this.f13140i.f13080b = true;
                    return;
                }
                if (dVar2 != null) {
                    f h5 = h(dVar);
                    if (h5 != null) {
                        b(this.f13139h, h5, this.f13133b.f12890W[0].e());
                        b(this.f13140i, this.f13139h, this.f13136e.f13085g);
                        return;
                    }
                    return;
                }
                q.d dVar3 = dVarArr[1];
                if (dVar3.f12842f != null) {
                    f h6 = h(dVar3);
                    if (h6 != null) {
                        b(this.f13140i, h6, -this.f13133b.f12890W[1].e());
                        b(this.f13139h, this.f13140i, -this.f13136e.f13085g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof q.h) || eVar2.I() == null || this.f13133b.m(d.b.CENTER).f12842f != null) {
                    return;
                }
                b(this.f13139h, this.f13133b.I().f12902e.f13139h, this.f13133b.V());
                b(this.f13140i, this.f13139h, this.f13136e.f13085g);
                return;
            }
        }
        if (this.f13135d == e.b.MATCH_CONSTRAINT) {
            q.e eVar3 = this.f13133b;
            int i3 = eVar3.f12938w;
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
            } else if (i3 == 3) {
                if (eVar3.f12940x == 3) {
                    this.f13139h.f13079a = this;
                    this.f13140i.f13079a = this;
                    n nVar = eVar3.f12904f;
                    nVar.f13139h.f13079a = this;
                    nVar.f13140i.f13079a = this;
                    gVar.f13079a = this;
                    if (eVar3.i0()) {
                        this.f13136e.f13090l.add(this.f13133b.f12904f.f13136e);
                        this.f13133b.f12904f.f13136e.f13089k.add(this.f13136e);
                        n nVar2 = this.f13133b.f12904f;
                        nVar2.f13136e.f13079a = this;
                        this.f13136e.f13090l.add(nVar2.f13139h);
                        this.f13136e.f13090l.add(this.f13133b.f12904f.f13140i);
                        this.f13133b.f12904f.f13139h.f13089k.add(this.f13136e);
                        this.f13133b.f12904f.f13140i.f13089k.add(this.f13136e);
                    } else if (this.f13133b.g0()) {
                        this.f13133b.f12904f.f13136e.f13090l.add(this.f13136e);
                        this.f13136e.f13089k.add(this.f13133b.f12904f.f13136e);
                    } else {
                        this.f13133b.f12904f.f13136e.f13090l.add(this.f13136e);
                    }
                } else {
                    g gVar4 = eVar3.f12904f.f13136e;
                    gVar.f13090l.add(gVar4);
                    gVar4.f13089k.add(this.f13136e);
                    this.f13133b.f12904f.f13139h.f13089k.add(this.f13136e);
                    this.f13133b.f12904f.f13140i.f13089k.add(this.f13136e);
                    g gVar5 = this.f13136e;
                    gVar5.f13080b = true;
                    gVar5.f13089k.add(this.f13139h);
                    this.f13136e.f13089k.add(this.f13140i);
                    this.f13139h.f13090l.add(this.f13136e);
                    this.f13140i.f13090l.add(this.f13136e);
                }
            }
        }
        q.e eVar4 = this.f13133b;
        q.d[] dVarArr2 = eVar4.f12890W;
        q.d dVar4 = dVarArr2[0];
        q.d dVar5 = dVar4.f12842f;
        if (dVar5 != null && dVarArr2[1].f12842f != null) {
            if (eVar4.g0()) {
                this.f13139h.f13084f = this.f13133b.f12890W[0].e();
                this.f13140i.f13084f = -this.f13133b.f12890W[1].e();
                return;
            }
            f h7 = h(this.f13133b.f12890W[0]);
            f h8 = h(this.f13133b.f12890W[1]);
            if (h7 != null) {
                h7.b(this);
            }
            if (h8 != null) {
                h8.b(this);
            }
            this.f13141j = p.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f h9 = h(dVar4);
            if (h9 != null) {
                b(this.f13139h, h9, this.f13133b.f12890W[0].e());
                c(this.f13140i, this.f13139h, 1, this.f13136e);
                return;
            }
            return;
        }
        q.d dVar6 = dVarArr2[1];
        if (dVar6.f12842f != null) {
            f h10 = h(dVar6);
            if (h10 != null) {
                b(this.f13140i, h10, -this.f13133b.f12890W[1].e());
                c(this.f13139h, this.f13140i, -1, this.f13136e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof q.h) || eVar4.I() == null) {
            return;
        }
        b(this.f13139h, this.f13133b.I().f12902e.f13139h, this.f13133b.V());
        c(this.f13140i, this.f13139h, 1, this.f13136e);
    }

    @Override // r.p
    public void e() {
        f fVar = this.f13139h;
        if (fVar.f13088j) {
            this.f13133b.i1(fVar.f13085g);
        }
    }

    @Override // r.p
    void f() {
        this.f13134c = null;
        this.f13139h.c();
        this.f13140i.c();
        this.f13136e.c();
        this.f13138g = false;
    }

    @Override // r.p
    boolean m() {
        return this.f13135d != e.b.MATCH_CONSTRAINT || this.f13133b.f12938w == 0;
    }

    void r() {
        this.f13138g = false;
        this.f13139h.c();
        this.f13139h.f13088j = false;
        this.f13140i.c();
        this.f13140i.f13088j = false;
        this.f13136e.f13088j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f13133b.r();
    }
}
