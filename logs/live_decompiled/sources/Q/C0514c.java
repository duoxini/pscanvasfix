package q;

import java.util.ArrayList;
import q.e;

/* renamed from: q.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0514c {

    /* renamed from: a, reason: collision with root package name */
    protected e f12815a;

    /* renamed from: b, reason: collision with root package name */
    protected e f12816b;

    /* renamed from: c, reason: collision with root package name */
    protected e f12817c;

    /* renamed from: d, reason: collision with root package name */
    protected e f12818d;

    /* renamed from: e, reason: collision with root package name */
    protected e f12819e;

    /* renamed from: f, reason: collision with root package name */
    protected e f12820f;

    /* renamed from: g, reason: collision with root package name */
    protected e f12821g;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList f12822h;

    /* renamed from: i, reason: collision with root package name */
    protected int f12823i;

    /* renamed from: j, reason: collision with root package name */
    protected int f12824j;

    /* renamed from: k, reason: collision with root package name */
    protected float f12825k = 0.0f;

    /* renamed from: l, reason: collision with root package name */
    int f12826l;

    /* renamed from: m, reason: collision with root package name */
    int f12827m;

    /* renamed from: n, reason: collision with root package name */
    int f12828n;

    /* renamed from: o, reason: collision with root package name */
    boolean f12829o;

    /* renamed from: p, reason: collision with root package name */
    private int f12830p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12831q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f12832r;

    /* renamed from: s, reason: collision with root package name */
    protected boolean f12833s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f12834t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f12835u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f12836v;

    public C0514c(e eVar, int i3, boolean z3) {
        this.f12815a = eVar;
        this.f12830p = i3;
        this.f12831q = z3;
    }

    private void b() {
        int i3 = this.f12830p * 2;
        e eVar = this.f12815a;
        this.f12829o = true;
        e eVar2 = eVar;
        boolean z3 = false;
        while (!z3) {
            this.f12823i++;
            e[] eVarArr = eVar.f12869F0;
            int i4 = this.f12830p;
            e eVar3 = null;
            eVarArr[i4] = null;
            eVar.f12867E0[i4] = null;
            if (eVar.T() != 8) {
                this.f12826l++;
                e.b s3 = eVar.s(this.f12830p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (s3 != bVar) {
                    this.f12827m += eVar.C(this.f12830p);
                }
                int e3 = this.f12827m + eVar.f12890W[i3].e();
                this.f12827m = e3;
                int i5 = i3 + 1;
                this.f12827m = e3 + eVar.f12890W[i5].e();
                int e4 = this.f12828n + eVar.f12890W[i3].e();
                this.f12828n = e4;
                this.f12828n = e4 + eVar.f12890W[i5].e();
                if (this.f12816b == null) {
                    this.f12816b = eVar;
                }
                this.f12818d = eVar;
                e.b[] bVarArr = eVar.f12893Z;
                int i6 = this.f12830p;
                if (bVarArr[i6] == bVar) {
                    int i7 = eVar.f12942y[i6];
                    if (i7 == 0 || i7 == 3 || i7 == 2) {
                        this.f12824j++;
                        float f3 = eVar.f12865D0[i6];
                        if (f3 > 0.0f) {
                            this.f12825k += f3;
                        }
                        if (c(eVar, i6)) {
                            if (f3 < 0.0f) {
                                this.f12832r = true;
                            } else {
                                this.f12833s = true;
                            }
                            if (this.f12822h == null) {
                                this.f12822h = new ArrayList();
                            }
                            this.f12822h.add(eVar);
                        }
                        if (this.f12820f == null) {
                            this.f12820f = eVar;
                        }
                        e eVar4 = this.f12821g;
                        if (eVar4 != null) {
                            eVar4.f12867E0[this.f12830p] = eVar;
                        }
                        this.f12821g = eVar;
                    }
                    if (this.f12830p == 0) {
                        if (eVar.f12938w != 0) {
                            this.f12829o = false;
                        } else if (eVar.f12944z != 0 || eVar.f12858A != 0) {
                            this.f12829o = false;
                        }
                    } else if (eVar.f12940x != 0) {
                        this.f12829o = false;
                    } else if (eVar.f12862C != 0 || eVar.f12864D != 0) {
                        this.f12829o = false;
                    }
                    if (eVar.f12901d0 != 0.0f) {
                        this.f12829o = false;
                        this.f12835u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f12869F0[this.f12830p] = eVar;
            }
            d dVar = eVar.f12890W[i3 + 1].f12842f;
            if (dVar != null) {
                e eVar5 = dVar.f12840d;
                d dVar2 = eVar5.f12890W[i3].f12842f;
                if (dVar2 != null && dVar2.f12840d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z3 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f12816b;
        if (eVar6 != null) {
            this.f12827m -= eVar6.f12890W[i3].e();
        }
        e eVar7 = this.f12818d;
        if (eVar7 != null) {
            this.f12827m -= eVar7.f12890W[i3 + 1].e();
        }
        this.f12817c = eVar;
        if (this.f12830p == 0 && this.f12831q) {
            this.f12819e = eVar;
        } else {
            this.f12819e = this.f12815a;
        }
        this.f12834t = this.f12833s && this.f12832r;
    }

    private static boolean c(e eVar, int i3) {
        int i4;
        return eVar.T() != 8 && eVar.f12893Z[i3] == e.b.MATCH_CONSTRAINT && ((i4 = eVar.f12942y[i3]) == 0 || i4 == 3);
    }

    public void a() {
        if (!this.f12836v) {
            b();
        }
        this.f12836v = true;
    }
}
