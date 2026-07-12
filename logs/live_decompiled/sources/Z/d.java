package Z;

import Z.b;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    double f3058a;

    /* renamed from: b, reason: collision with root package name */
    double f3059b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3060c;

    /* renamed from: d, reason: collision with root package name */
    private double f3061d;

    /* renamed from: e, reason: collision with root package name */
    private double f3062e;

    /* renamed from: f, reason: collision with root package name */
    private double f3063f;

    /* renamed from: g, reason: collision with root package name */
    private double f3064g;

    /* renamed from: h, reason: collision with root package name */
    private double f3065h;

    /* renamed from: i, reason: collision with root package name */
    private double f3066i;

    /* renamed from: j, reason: collision with root package name */
    private final b.p f3067j;

    public d() {
        this.f3058a = Math.sqrt(1500.0d);
        this.f3059b = 0.5d;
        this.f3060c = false;
        this.f3066i = Double.MAX_VALUE;
        this.f3067j = new b.p();
    }

    private void b() {
        if (this.f3060c) {
            return;
        }
        if (this.f3066i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d3 = this.f3059b;
        if (d3 > 1.0d) {
            double d4 = this.f3058a;
            this.f3063f = ((-d3) * d4) + (d4 * Math.sqrt((d3 * d3) - 1.0d));
            double d5 = this.f3059b;
            double d6 = this.f3058a;
            this.f3064g = ((-d5) * d6) - (d6 * Math.sqrt((d5 * d5) - 1.0d));
        } else if (d3 >= 0.0d && d3 < 1.0d) {
            this.f3065h = this.f3058a * Math.sqrt(1.0d - (d3 * d3));
        }
        this.f3060c = true;
    }

    public float a() {
        return (float) this.f3066i;
    }

    public boolean c(float f3, float f4) {
        return ((double) Math.abs(f4)) < this.f3062e && ((double) Math.abs(f3 - a())) < this.f3061d;
    }

    public d d(float f3) {
        float f4 = 1.0f - f3;
        if (f4 >= 0.0f) {
            return e(f4);
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public d e(float f3) {
        if (f3 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f3059b = f3;
        this.f3060c = false;
        return this;
    }

    public d f(float f3) {
        this.f3066i = f3;
        return this;
    }

    public d g(float f3) {
        if (f3 == 0.0f) {
            f3 = 1.0f;
        }
        float pow = (float) Math.pow(6.283185307179586d / f3, 2.0d);
        if (pow > 0.0f) {
            return h(pow);
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public d h(float f3) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f3058a = Math.sqrt(f3);
        this.f3060c = false;
        return this;
    }

    void i(double d3) {
        double abs = Math.abs(d3);
        this.f3061d = abs;
        this.f3062e = abs * 62.5d;
    }

    b.p j(double d3, double d4, long j3) {
        double cos;
        double d5;
        b();
        double d6 = j3 / 1000.0d;
        double d7 = d3 - this.f3066i;
        double d8 = this.f3059b;
        if (d8 > 1.0d) {
            double d9 = this.f3064g;
            double d10 = this.f3063f;
            double d11 = d7 - (((d9 * d7) - d4) / (d9 - d10));
            double d12 = ((d7 * d9) - d4) / (d9 - d10);
            d5 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.f3063f * d6) * d12);
            double d13 = this.f3064g;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.f3063f;
            cos = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f3058a;
            double d16 = d4 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d5 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f3058a) * d6);
            double d18 = this.f3058a;
            cos = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.f3065h;
            double d20 = this.f3058a;
            double d21 = d19 * ((d8 * d20 * d7) + d4);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.f3065h * d6) * d7) + (Math.sin(this.f3065h * d6) * d21));
            double d22 = this.f3058a;
            double d23 = this.f3059b;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d25 = this.f3065h;
            double sin = (-d25) * d7 * Math.sin(d25 * d6);
            double d26 = this.f3065h;
            cos = d24 + (pow4 * (sin + (d21 * d26 * Math.cos(d26 * d6))));
            d5 = pow3;
        }
        b.p pVar = this.f3067j;
        pVar.f3053a = (float) (d5 + this.f3066i);
        pVar.f3054b = (float) cos;
        return pVar;
    }

    public d(float f3) {
        this.f3058a = Math.sqrt(1500.0d);
        this.f3059b = 0.5d;
        this.f3060c = false;
        this.f3066i = Double.MAX_VALUE;
        this.f3067j = new b.p();
        this.f3066i = f3;
    }
}
