package r;

import q.d;
import q.e;

/* loaded from: classes.dex */
public abstract class p implements d {

    /* renamed from: a, reason: collision with root package name */
    public int f13132a;

    /* renamed from: b, reason: collision with root package name */
    q.e f13133b;

    /* renamed from: c, reason: collision with root package name */
    m f13134c;

    /* renamed from: d, reason: collision with root package name */
    protected e.b f13135d;

    /* renamed from: e, reason: collision with root package name */
    g f13136e = new g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f13137f = 0;

    /* renamed from: g, reason: collision with root package name */
    boolean f13138g = false;

    /* renamed from: h, reason: collision with root package name */
    public f f13139h = new f(this);

    /* renamed from: i, reason: collision with root package name */
    public f f13140i = new f(this);

    /* renamed from: j, reason: collision with root package name */
    protected b f13141j = b.NONE;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13142a;

        static {
            int[] iArr = new int[d.b.values().length];
            f13142a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13142a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13142a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13142a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13142a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(q.e eVar) {
        this.f13133b = eVar;
    }

    private void l(int i3, int i4) {
        int i5 = this.f13132a;
        if (i5 == 0) {
            this.f13136e.d(g(i4, i3));
            return;
        }
        if (i5 == 1) {
            this.f13136e.d(Math.min(g(this.f13136e.f13100m, i3), i4));
            return;
        }
        if (i5 == 2) {
            q.e I3 = this.f13133b.I();
            if (I3 != null) {
                if ((i3 == 0 ? I3.f12902e : I3.f12904f).f13136e.f13088j) {
                    q.e eVar = this.f13133b;
                    this.f13136e.d(g((int) ((r9.f13085g * (i3 == 0 ? eVar.f12860B : eVar.f12866E)) + 0.5f), i3));
                    return;
                }
                return;
            }
            return;
        }
        if (i5 != 3) {
            return;
        }
        q.e eVar2 = this.f13133b;
        p pVar = eVar2.f12902e;
        e.b bVar = pVar.f13135d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.f13132a == 3) {
            n nVar = eVar2.f12904f;
            if (nVar.f13135d == bVar2 && nVar.f13132a == 3) {
                return;
            }
        }
        if (i3 == 0) {
            pVar = eVar2.f12904f;
        }
        if (pVar.f13136e.f13088j) {
            float t3 = eVar2.t();
            this.f13136e.d(i3 == 1 ? (int) ((pVar.f13136e.f13085g / t3) + 0.5f) : (int) ((t3 * pVar.f13136e.f13085g) + 0.5f));
        }
    }

    @Override // r.d
    public abstract void a(d dVar);

    protected final void b(f fVar, f fVar2, int i3) {
        fVar.f13090l.add(fVar2);
        fVar.f13084f = i3;
        fVar2.f13089k.add(fVar);
    }

    protected final void c(f fVar, f fVar2, int i3, g gVar) {
        fVar.f13090l.add(fVar2);
        fVar.f13090l.add(this.f13136e);
        fVar.f13086h = i3;
        fVar.f13087i = gVar;
        fVar2.f13089k.add(fVar);
        gVar.f13089k.add(fVar);
    }

    abstract void d();

    abstract void e();

    abstract void f();

    protected final int g(int i3, int i4) {
        int max;
        if (i4 == 0) {
            q.e eVar = this.f13133b;
            int i5 = eVar.f12858A;
            max = Math.max(eVar.f12944z, i3);
            if (i5 > 0) {
                max = Math.min(i5, i3);
            }
            if (max == i3) {
                return i3;
            }
        } else {
            q.e eVar2 = this.f13133b;
            int i6 = eVar2.f12864D;
            max = Math.max(eVar2.f12862C, i3);
            if (i6 > 0) {
                max = Math.min(i6, i3);
            }
            if (max == i3) {
                return i3;
            }
        }
        return max;
    }

    protected final f h(q.d dVar) {
        q.d dVar2 = dVar.f12842f;
        if (dVar2 == null) {
            return null;
        }
        q.e eVar = dVar2.f12840d;
        int i3 = a.f13142a[dVar2.f12841e.ordinal()];
        if (i3 == 1) {
            return eVar.f12902e.f13139h;
        }
        if (i3 == 2) {
            return eVar.f12902e.f13140i;
        }
        if (i3 == 3) {
            return eVar.f12904f.f13139h;
        }
        if (i3 == 4) {
            return eVar.f12904f.f13114k;
        }
        if (i3 != 5) {
            return null;
        }
        return eVar.f12904f.f13140i;
    }

    protected final f i(q.d dVar, int i3) {
        q.d dVar2 = dVar.f12842f;
        if (dVar2 == null) {
            return null;
        }
        q.e eVar = dVar2.f12840d;
        p pVar = i3 == 0 ? eVar.f12902e : eVar.f12904f;
        int i4 = a.f13142a[dVar2.f12841e.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f13140i;
        }
        return pVar.f13139h;
    }

    public long j() {
        if (this.f13136e.f13088j) {
            return r2.f13085g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f13138g;
    }

    abstract boolean m();

    protected void n(d dVar, q.d dVar2, q.d dVar3, int i3) {
        f h3 = h(dVar2);
        f h4 = h(dVar3);
        if (h3.f13088j && h4.f13088j) {
            int e3 = h3.f13085g + dVar2.e();
            int e4 = h4.f13085g - dVar3.e();
            int i4 = e4 - e3;
            if (!this.f13136e.f13088j && this.f13135d == e.b.MATCH_CONSTRAINT) {
                l(i3, i4);
            }
            g gVar = this.f13136e;
            if (gVar.f13088j) {
                if (gVar.f13085g == i4) {
                    this.f13139h.d(e3);
                    this.f13140i.d(e4);
                    return;
                }
                q.e eVar = this.f13133b;
                float w3 = i3 == 0 ? eVar.w() : eVar.P();
                if (h3 == h4) {
                    e3 = h3.f13085g;
                    e4 = h4.f13085g;
                    w3 = 0.5f;
                }
                this.f13139h.d((int) (e3 + 0.5f + (((e4 - e3) - this.f13136e.f13085g) * w3)));
                this.f13140i.d(this.f13139h.f13085g + this.f13136e.f13085g);
            }
        }
    }

    protected void o(d dVar) {
    }

    protected void p(d dVar) {
    }
}
