package F0;

/* loaded from: classes.dex */
public class f {

    /* renamed from: c, reason: collision with root package name */
    public static f f421c = b(40.0d, 7.0d);

    /* renamed from: a, reason: collision with root package name */
    public double f422a;

    /* renamed from: b, reason: collision with root package name */
    public double f423b;

    public f(double d3, double d4) {
        this.f423b = d3;
        this.f422a = d4;
    }

    public static f a(double d3, double d4) {
        c cVar = new c(d4, d3);
        return b(cVar.f(), cVar.e());
    }

    public static f b(double d3, double d4) {
        return new f(d.b(d3), d.a(d4));
    }
}
