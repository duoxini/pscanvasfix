package F0;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final double f400a;

    /* renamed from: b, reason: collision with root package name */
    private final double f401b;

    /* renamed from: c, reason: collision with root package name */
    private final double f402c;

    /* renamed from: d, reason: collision with root package name */
    private final double f403d;

    public c(double d3, double d4) {
        this.f402c = d3;
        this.f403d = d4;
        double i3 = i(h(d4 / 1.7d, 0.0d, 20.0d), 0.0d, 0.8d);
        double i4 = i(h(d3 / 1.7d, 0.0d, 20.0d), 0.5d, 200.0d);
        this.f400a = i4;
        this.f401b = j(i3, d(i4), 0.01d);
    }

    private double a(double d3) {
        return ((Math.pow(d3, 3.0d) * 7.0E-4d) - (Math.pow(d3, 2.0d) * 0.031d)) + (d3 * 0.64d) + 1.28d;
    }

    private double b(double d3) {
        return ((Math.pow(d3, 3.0d) * 4.4E-5d) - (Math.pow(d3, 2.0d) * 0.006d)) + (d3 * 0.36d) + 2.0d;
    }

    private double c(double d3) {
        return ((Math.pow(d3, 3.0d) * 4.5E-7d) - (Math.pow(d3, 2.0d) * 3.32E-4d)) + (d3 * 0.1078d) + 5.84d;
    }

    private double d(double d3) {
        if (d3 <= 18.0d) {
            return a(d3);
        }
        if (d3 > 18.0d && d3 <= 44.0d) {
            return b(d3);
        }
        if (d3 > 44.0d) {
            return c(d3);
        }
        return 0.0d;
    }

    private double g(double d3, double d4, double d5) {
        return (d5 * d3) + ((1.0d - d3) * d4);
    }

    private double h(double d3, double d4, double d5) {
        return (d3 - d4) / (d5 - d4);
    }

    private double i(double d3, double d4, double d5) {
        return d4 + (d3 * (d5 - d4));
    }

    private double j(double d3, double d4, double d5) {
        return g((2.0d * d3) - (d3 * d3), d4, d5);
    }

    public double e() {
        return this.f401b;
    }

    public double f() {
        return this.f400a;
    }
}
