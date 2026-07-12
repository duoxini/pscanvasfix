package Y;

import android.view.animation.BaseInterpolator;

/* loaded from: classes.dex */
public class h extends BaseInterpolator {

    /* renamed from: a, reason: collision with root package name */
    private final double f2936a;

    /* renamed from: b, reason: collision with root package name */
    private final double f2937b;

    /* renamed from: c, reason: collision with root package name */
    private final double f2938c;

    /* renamed from: d, reason: collision with root package name */
    private final float f2939d;

    /* renamed from: e, reason: collision with root package name */
    private final double f2940e;

    /* renamed from: f, reason: collision with root package name */
    private float f2941f;

    /* renamed from: g, reason: collision with root package name */
    private double f2942g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f2943h;

    public h(double d3, double d4) {
        this(d3, d4, 0.0d, 15000.0f);
    }

    private float a(float f3) {
        double sqrt;
        double sinh;
        double cosh;
        double sinh2;
        double d3 = (f3 >= 0.0f ? f3 : 0.0f) * this.f2939d;
        double exp = Math.exp((-this.f2937b) * this.f2936a * d3);
        double d4 = this.f2937b;
        if (d4 >= 1.0d) {
            if (Double.compare(1.0d, d4) == 0) {
                sinh2 = ((this.f2940e * d3) + 1.0d) * Math.exp((-r2) * this.f2936a);
            } else {
                double d5 = this.f2936a;
                double d6 = this.f2937b;
                sqrt = d5 * Math.sqrt((d6 * d6) - 1.0d);
                if (this.f2943h) {
                    exp /= sqrt;
                    double d7 = -this.f2938c;
                    double d8 = this.f2937b;
                    sinh = (d7 + (this.f2936a * d8)) * Math.sinh(d8 * d3);
                    cosh = Math.cosh(this.f2937b * d3);
                } else {
                    double d9 = f3 * sqrt;
                    sinh2 = (exp / sqrt) * ((((-this.f2938c) + (this.f2937b * this.f2936a)) * Math.sinh(d9)) + (sqrt * Math.cosh(d9)));
                }
            }
            return (float) (1.0d - sinh2);
        }
        sinh = Math.cos(this.f2942g * d3);
        sqrt = this.f2940e;
        cosh = Math.sin(this.f2942g * d3);
        sinh2 = exp * (sinh + (sqrt * cosh));
        return (float) (1.0d - sinh2);
    }

    public float b(float f3) {
        double abs;
        double d3 = f3 >= 0.0f ? f3 : 0.0f;
        double exp = Math.exp((-this.f2939d) * this.f2937b * this.f2936a * d3);
        double d4 = this.f2937b;
        if (d4 < 1.0d) {
            float f4 = this.f2939d;
            double d5 = this.f2940e;
            double d6 = this.f2936a;
            double d7 = this.f2942g;
            abs = Math.abs(exp * (((-f4) * ((d5 * d4 * d6) + d7) * Math.sin(f4 * d7 * d3)) + (f4 * ((d5 * d7) - (d4 * d6)) * Math.cos(this.f2939d * this.f2942g * d3))));
        } else if (Double.compare(1.0d, d4) == 0) {
            float f5 = this.f2939d;
            double d8 = this.f2940e;
            double d9 = this.f2936a;
            abs = Math.abs(f5 * ((d8 - d9) - (((d8 * f5) * d9) * d3)) * Math.exp((-f5) * d9 * d3));
        } else {
            double d10 = this.f2936a;
            double d11 = this.f2937b;
            double sqrt = d10 * Math.sqrt((d11 * d11) - 1.0d);
            float f6 = this.f2939d;
            double d12 = this.f2938c;
            double d13 = this.f2937b;
            double d14 = this.f2936a;
            double d15 = f6 * (((sqrt * sqrt) + ((d12 * d13) * d14)) - (((d13 * d13) * d14) * d14));
            if (this.f2943h) {
                abs = Math.abs((exp / sqrt) * ((d15 * Math.sinh(f6 * d13 * d3)) + (f6 * d13 * (((d13 * d14) - d12) - (sqrt * d14)) * Math.cosh(this.f2939d * this.f2937b * d3))));
            } else {
                double d16 = (-f6) * d12 * sqrt;
                double d17 = f3;
                abs = Math.abs((exp / sqrt) * ((d15 * Math.sinh(f6 * sqrt * d17)) + (d16 * Math.cosh(this.f2939d * sqrt * d17))));
            }
        }
        return (float) abs;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f3) {
        if (this.f2941f == -1.0f) {
            float f4 = 1.0f;
            float a3 = a(1.0f);
            if (a3 != 0.0f && !Float.isNaN(a3)) {
                f4 = a3;
            }
            this.f2941f = f4;
        }
        return a(f3) / this.f2941f;
    }

    public h(double d3, double d4, double d5, float f3) {
        this(Math.pow(6.283185307179586d / (d3 == 0.0d ? 1.0d : d3), 2.0d), 1.0d - d4, d5, 1.0f, f3);
    }

    public h(double d3, double d4, double d5, float f3, float f4, boolean z3) {
        this(d3, d4, d5, f3, f4);
        this.f2943h = z3;
    }

    public h(double d3, double d4, double d5, float f3, float f4) {
        this.f2941f = -1.0f;
        double sqrt = Math.sqrt(d3 <= 0.0d ? 40.0d : d3);
        this.f2936a = sqrt;
        d4 = d4 <= 0.0d ? 1.15d : d4;
        this.f2937b = d4;
        double min = Math.min(Math.abs(d5), 20000.0d) / (f4 <= 0.0f ? 15000.0f : f4);
        this.f2938c = min;
        this.f2939d = f3 <= 0.0f ? 1.0f : f3;
        if (d4 < 1.0d) {
            double sqrt2 = Math.sqrt(1.0d - (d4 * d4)) * sqrt;
            this.f2942g = sqrt2;
            this.f2940e = ((d4 * sqrt) - min) / sqrt2;
        } else if (Double.compare(1.0d, d4) == 0) {
            this.f2940e = (-min) + sqrt;
        } else {
            this.f2940e = (-min) + (d4 * sqrt);
        }
    }
}
