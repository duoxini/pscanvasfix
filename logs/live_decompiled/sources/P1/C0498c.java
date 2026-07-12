package p1;

/* renamed from: p1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0498c {

    /* renamed from: a, reason: collision with root package name */
    public final C0500e f12797a = new C0500e();

    /* renamed from: b, reason: collision with root package name */
    public final C0500e f12798b = new C0500e();

    public static final void b(C0498c c0498c, C0500e c0500e, C0500e c0500e2) {
        C0500e c0500e3 = c0498c.f12797a;
        float f3 = c0500e3.f12799a * c0500e.f12799a;
        C0500e c0500e4 = c0498c.f12798b;
        float f4 = c0500e4.f12799a;
        float f5 = c0500e.f12800b;
        c0500e2.f12799a = f3 + (f4 * f5);
        c0500e2.f12800b = (c0500e3.f12800b * c0500e.f12799a) + (c0500e4.f12800b * f5);
    }

    public final C0498c a() {
        C0500e c0500e = this.f12797a;
        float f3 = c0500e.f12799a;
        C0500e c0500e2 = this.f12798b;
        float f4 = c0500e2.f12799a;
        float f5 = c0500e.f12800b;
        float f6 = c0500e2.f12800b;
        float f7 = (f3 * f6) - (f4 * f5);
        if (f7 != 0.0f) {
            f7 = 1.0f / f7;
        }
        c0500e.f12799a = f6 * f7;
        float f8 = -f7;
        c0500e2.f12799a = f4 * f8;
        c0500e.f12800b = f8 * f5;
        c0500e2.f12800b = f7 * f3;
        return this;
    }
}
