package B;

import B.b;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    double f136a;

    /* renamed from: b, reason: collision with root package name */
    double f137b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f138c;

    /* renamed from: d, reason: collision with root package name */
    private double f139d;

    /* renamed from: e, reason: collision with root package name */
    private double f140e;

    /* renamed from: f, reason: collision with root package name */
    private double f141f;

    /* renamed from: g, reason: collision with root package name */
    private double f142g;

    /* renamed from: h, reason: collision with root package name */
    private double f143h;

    /* renamed from: i, reason: collision with root package name */
    private double f144i;

    /* renamed from: j, reason: collision with root package name */
    private final b.p f145j;

    public f() {
        this.f136a = Math.sqrt(1500.0d);
        this.f137b = 0.5d;
        this.f138c = false;
        this.f144i = Double.MAX_VALUE;
        this.f145j = new b.p();
    }

    private void b() {
        if (this.f138c) {
            return;
        }
        if (this.f144i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d3 = this.f137b;
        if (d3 > 1.0d) {
            double d4 = this.f136a;
            this.f141f = ((-d3) * d4) + (d4 * Math.sqrt((d3 * d3) - 1.0d));
            double d5 = this.f137b;
            double d6 = this.f136a;
            this.f142g = ((-d5) * d6) - (d6 * Math.sqrt((d5 * d5) - 1.0d));
        } else if (d3 >= 0.0d && d3 < 1.0d) {
            this.f143h = this.f136a * Math.sqrt(1.0d - (d3 * d3));
        }
        this.f138c = true;
    }

    public float a() {
        return (float) this.f144i;
    }

    public boolean c(float f3, float f4) {
        return ((double) Math.abs(f4)) < this.f140e && ((double) Math.abs(f3 - a())) < this.f139d;
    }

    public f d(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f137b = f3;
        this.f138c = false;
        return this;
    }

    public f e(float f3) {
        this.f144i = f3;
        return this;
    }

    public f f(float f3) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f136a = Math.sqrt(f3);
        this.f138c = false;
        return this;
    }

    void g(double d3) {
        double abs = Math.abs(d3);
        this.f139d = abs;
        this.f140e = abs * 62.5d;
    }

    b.p h(double d3, double d4, long j3) {
        double cos;
        double d5;
        b();
        double d6 = j3 / 1000.0d;
        double d7 = d3 - this.f144i;
        double d8 = this.f137b;
        if (d8 > 1.0d) {
            double d9 = this.f142g;
            double d10 = this.f141f;
            double d11 = d7 - (((d9 * d7) - d4) / (d9 - d10));
            double d12 = ((d7 * d9) - d4) / (d9 - d10);
            d5 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.f141f * d6) * d12);
            double d13 = this.f142g;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.f141f;
            cos = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f136a;
            double d16 = d4 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d5 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f136a) * d6);
            double d18 = this.f136a;
            cos = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.f143h;
            double d20 = this.f136a;
            double d21 = d19 * ((d8 * d20 * d7) + d4);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.f143h * d6) * d7) + (Math.sin(this.f143h * d6) * d21));
            double d22 = this.f136a;
            double d23 = this.f137b;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d25 = this.f143h;
            double sin = (-d25) * d7 * Math.sin(d25 * d6);
            double d26 = this.f143h;
            cos = d24 + (pow4 * (sin + (d21 * d26 * Math.cos(d26 * d6))));
            d5 = pow3;
        }
        b.p pVar = this.f145j;
        pVar.f129a = (float) (d5 + this.f144i);
        pVar.f130b = (float) cos;
        return pVar;
    }

    public f(float f3) {
        this.f136a = Math.sqrt(1500.0d);
        this.f137b = 0.5d;
        this.f138c = false;
        this.f144i = Double.MAX_VALUE;
        this.f145j = new b.p();
        this.f144i = f3;
    }
}
