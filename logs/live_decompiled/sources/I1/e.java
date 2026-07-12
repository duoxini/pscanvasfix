package i1;

import a1.C0221a;
import g1.C0366b;
import g1.j;
import g1.k;
import g1.l;
import h1.C0372a;
import java.util.List;
import java.util.Locale;
import k1.C0439j;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final List f12052a;

    /* renamed from: b, reason: collision with root package name */
    private final C0221a f12053b;

    /* renamed from: c, reason: collision with root package name */
    private final String f12054c;

    /* renamed from: d, reason: collision with root package name */
    private final long f12055d;

    /* renamed from: e, reason: collision with root package name */
    private final a f12056e;

    /* renamed from: f, reason: collision with root package name */
    private final long f12057f;

    /* renamed from: g, reason: collision with root package name */
    private final String f12058g;

    /* renamed from: h, reason: collision with root package name */
    private final List f12059h;

    /* renamed from: i, reason: collision with root package name */
    private final l f12060i;

    /* renamed from: j, reason: collision with root package name */
    private final int f12061j;

    /* renamed from: k, reason: collision with root package name */
    private final int f12062k;

    /* renamed from: l, reason: collision with root package name */
    private final int f12063l;

    /* renamed from: m, reason: collision with root package name */
    private final float f12064m;

    /* renamed from: n, reason: collision with root package name */
    private final float f12065n;

    /* renamed from: o, reason: collision with root package name */
    private final float f12066o;

    /* renamed from: p, reason: collision with root package name */
    private final float f12067p;

    /* renamed from: q, reason: collision with root package name */
    private final j f12068q;

    /* renamed from: r, reason: collision with root package name */
    private final k f12069r;

    /* renamed from: s, reason: collision with root package name */
    private final C0366b f12070s;

    /* renamed from: t, reason: collision with root package name */
    private final List f12071t;

    /* renamed from: u, reason: collision with root package name */
    private final b f12072u;

    /* renamed from: v, reason: collision with root package name */
    private final boolean f12073v;

    /* renamed from: w, reason: collision with root package name */
    private final C0372a f12074w;

    /* renamed from: x, reason: collision with root package name */
    private final C0439j f12075x;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public e(List list, C0221a c0221a, String str, long j3, a aVar, long j4, String str2, List list2, l lVar, int i3, int i4, int i5, float f3, float f4, float f5, float f6, j jVar, k kVar, List list3, b bVar, C0366b c0366b, boolean z3, C0372a c0372a, C0439j c0439j) {
        this.f12052a = list;
        this.f12053b = c0221a;
        this.f12054c = str;
        this.f12055d = j3;
        this.f12056e = aVar;
        this.f12057f = j4;
        this.f12058g = str2;
        this.f12059h = list2;
        this.f12060i = lVar;
        this.f12061j = i3;
        this.f12062k = i4;
        this.f12063l = i5;
        this.f12064m = f3;
        this.f12065n = f4;
        this.f12066o = f5;
        this.f12067p = f6;
        this.f12068q = jVar;
        this.f12069r = kVar;
        this.f12071t = list3;
        this.f12072u = bVar;
        this.f12070s = c0366b;
        this.f12073v = z3;
        this.f12074w = c0372a;
        this.f12075x = c0439j;
    }

    public C0372a a() {
        return this.f12074w;
    }

    C0221a b() {
        return this.f12053b;
    }

    public C0439j c() {
        return this.f12075x;
    }

    public long d() {
        return this.f12055d;
    }

    List e() {
        return this.f12071t;
    }

    public a f() {
        return this.f12056e;
    }

    List g() {
        return this.f12059h;
    }

    b h() {
        return this.f12072u;
    }

    public String i() {
        return this.f12054c;
    }

    long j() {
        return this.f12057f;
    }

    float k() {
        return this.f12067p;
    }

    float l() {
        return this.f12066o;
    }

    public String m() {
        return this.f12058g;
    }

    List n() {
        return this.f12052a;
    }

    int o() {
        return this.f12063l;
    }

    int p() {
        return this.f12062k;
    }

    int q() {
        return this.f12061j;
    }

    float r() {
        return this.f12065n / this.f12053b.e();
    }

    j s() {
        return this.f12068q;
    }

    k t() {
        return this.f12069r;
    }

    public String toString() {
        return y("");
    }

    C0366b u() {
        return this.f12070s;
    }

    float v() {
        return this.f12064m;
    }

    l w() {
        return this.f12060i;
    }

    public boolean x() {
        return this.f12073v;
    }

    public String y(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        sb.append("\n");
        e t3 = this.f12053b.t(j());
        if (t3 != null) {
            sb.append("\t\tParents: ");
            sb.append(t3.i());
            e t4 = this.f12053b.t(t3.j());
            while (t4 != null) {
                sb.append("->");
                sb.append(t4.i());
                t4 = this.f12053b.t(t4.j());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!g().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(g().size());
            sb.append("\n");
        }
        if (q() != 0 && p() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(q()), Integer.valueOf(p()), Integer.valueOf(o())));
        }
        if (!this.f12052a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.f12052a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
