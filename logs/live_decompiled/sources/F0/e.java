package F0;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class e {

    /* renamed from: o, reason: collision with root package name */
    private static int f404o;

    /* renamed from: a, reason: collision with root package name */
    private f f405a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f406b;

    /* renamed from: c, reason: collision with root package name */
    private final String f407c;

    /* renamed from: d, reason: collision with root package name */
    private final b f408d;

    /* renamed from: e, reason: collision with root package name */
    private final b f409e;

    /* renamed from: f, reason: collision with root package name */
    private final b f410f;

    /* renamed from: g, reason: collision with root package name */
    private double f411g;

    /* renamed from: h, reason: collision with root package name */
    private double f412h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f413i = true;

    /* renamed from: j, reason: collision with root package name */
    private double f414j = 0.005d;

    /* renamed from: k, reason: collision with root package name */
    private double f415k = 0.005d;

    /* renamed from: l, reason: collision with root package name */
    private CopyOnWriteArraySet f416l = new CopyOnWriteArraySet();

    /* renamed from: m, reason: collision with root package name */
    private double f417m = 0.0d;

    /* renamed from: n, reason: collision with root package name */
    private final F0.b f418n;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        double f419a;

        /* renamed from: b, reason: collision with root package name */
        double f420b;

        private b() {
        }
    }

    e(F0.b bVar) {
        this.f408d = new b();
        this.f409e = new b();
        this.f410f = new b();
        if (bVar == null) {
            throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
        }
        this.f418n = bVar;
        StringBuilder sb = new StringBuilder();
        sb.append("spring:");
        int i3 = f404o;
        f404o = i3 + 1;
        sb.append(i3);
        this.f407c = sb.toString();
        l(f.f421c);
    }

    private double d(b bVar) {
        return Math.abs(this.f412h - bVar.f419a);
    }

    private void g(double d3) {
        b bVar = this.f408d;
        double d4 = bVar.f419a * d3;
        b bVar2 = this.f409e;
        double d5 = 1.0d - d3;
        bVar.f419a = d4 + (bVar2.f419a * d5);
        bVar.f420b = (bVar.f420b * d3) + (bVar2.f420b * d5);
    }

    public e a(g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.f416l.add(gVar);
        return this;
    }

    void b(double d3) {
        double d4;
        boolean z3;
        boolean z4;
        boolean h3 = h();
        if (h3 && this.f413i) {
            return;
        }
        this.f417m += d3 <= 0.064d ? d3 : 0.064d;
        f fVar = this.f405a;
        double d5 = fVar.f423b;
        double d6 = fVar.f422a;
        b bVar = this.f408d;
        double d7 = bVar.f419a;
        double d8 = bVar.f420b;
        b bVar2 = this.f410f;
        double d9 = bVar2.f419a;
        double d10 = bVar2.f420b;
        while (true) {
            d4 = this.f417m;
            if (d4 < 0.001d) {
                break;
            }
            double d11 = d4 - 0.001d;
            this.f417m = d11;
            if (d11 < 0.001d) {
                b bVar3 = this.f409e;
                bVar3.f419a = d7;
                bVar3.f420b = d8;
            }
            double d12 = this.f412h;
            double d13 = ((d12 - d9) * d5) - (d6 * d8);
            double d14 = d8 + (d13 * 0.001d * 0.5d);
            double d15 = ((d12 - (((d8 * 0.001d) * 0.5d) + d7)) * d5) - (d6 * d14);
            double d16 = d8 + (d15 * 0.001d * 0.5d);
            double d17 = ((d12 - (d7 + ((d14 * 0.001d) * 0.5d))) * d5) - (d6 * d16);
            double d18 = d7 + (d16 * 0.001d);
            double d19 = d8 + (d17 * 0.001d);
            d7 += (d8 + ((d14 + d16) * 2.0d) + d19) * 0.16666666666666666d * 0.001d;
            d8 += (d13 + ((d15 + d17) * 2.0d) + (((d12 - d18) * d5) - (d6 * d19))) * 0.16666666666666666d * 0.001d;
            d9 = d18;
            d10 = d19;
        }
        b bVar4 = this.f410f;
        bVar4.f419a = d9;
        bVar4.f420b = d10;
        b bVar5 = this.f408d;
        bVar5.f419a = d7;
        bVar5.f420b = d8;
        if (d4 > 0.0d) {
            g(d4 / 0.001d);
        }
        boolean z5 = true;
        if (h() || (this.f406b && i())) {
            if (d5 > 0.0d) {
                double d20 = this.f412h;
                this.f411g = d20;
                this.f408d.f419a = d20;
            } else {
                double d21 = this.f408d.f419a;
                this.f412h = d21;
                this.f411g = d21;
            }
            m(0.0d);
            z3 = true;
        } else {
            z3 = h3;
        }
        if (this.f413i) {
            this.f413i = false;
            z4 = true;
        } else {
            z4 = false;
        }
        if (z3) {
            this.f413i = true;
        } else {
            z5 = false;
        }
        Iterator it = this.f416l.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (z4) {
                gVar.onSpringActivate(this);
            }
            gVar.onSpringUpdate(this);
            if (z5) {
                gVar.onSpringAtRest(this);
            }
        }
    }

    public double c() {
        return this.f408d.f419a;
    }

    public String e() {
        return this.f407c;
    }

    public double f() {
        return this.f408d.f420b;
    }

    public boolean h() {
        return Math.abs(this.f408d.f420b) <= this.f414j && (d(this.f408d) <= this.f415k || this.f405a.f423b == 0.0d);
    }

    public boolean i() {
        return this.f405a.f423b > 0.0d && ((this.f411g < this.f412h && c() > this.f412h) || (this.f411g > this.f412h && c() < this.f412h));
    }

    public e j() {
        b bVar = this.f408d;
        double d3 = bVar.f419a;
        this.f412h = d3;
        this.f410f.f419a = d3;
        bVar.f420b = 0.0d;
        return this;
    }

    public e k(double d3) {
        if (this.f412h == d3 && h()) {
            return this;
        }
        this.f411g = c();
        this.f412h = d3;
        this.f418n.a(e());
        Iterator it = this.f416l.iterator();
        while (it.hasNext()) {
            ((g) it.next()).onSpringEndStateChange(this);
        }
        return this;
    }

    public e l(f fVar) {
        if (fVar == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        this.f405a = fVar;
        return this;
    }

    public e m(double d3) {
        b bVar = this.f408d;
        if (d3 == bVar.f420b) {
            return this;
        }
        bVar.f420b = d3;
        this.f418n.a(e());
        return this;
    }

    public boolean n() {
        return (h() && o()) ? false : true;
    }

    public boolean o() {
        return this.f413i;
    }
}
