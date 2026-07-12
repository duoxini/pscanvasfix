package androidx.appcompat.app;

/* loaded from: classes.dex */
class r {

    /* renamed from: d, reason: collision with root package name */
    private static r f3669d;

    /* renamed from: a, reason: collision with root package name */
    public long f3670a;

    /* renamed from: b, reason: collision with root package name */
    public long f3671b;

    /* renamed from: c, reason: collision with root package name */
    public int f3672c;

    r() {
    }

    static r b() {
        if (f3669d == null) {
            f3669d = new r();
        }
        return f3669d;
    }

    public void a(long j3, double d3, double d4) {
        double d5 = (0.01720197f * ((j3 - 946728000000L) / 8.64E7f)) + 6.24006f;
        double sin = (Math.sin(d5) * 0.03341960161924362d) + d5 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double round = Math.round((r3 - 9.0E-4f) - r7) + 9.0E-4f + ((-d4) / 360.0d) + (Math.sin(d5) * 0.0053d) + (Math.sin(2.0d * sin) * (-0.0069d));
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d6 = 0.01745329238474369d * d3;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d6) * Math.sin(asin))) / (Math.cos(d6) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.f3672c = 1;
            this.f3670a = -1L;
            this.f3671b = -1L;
        } else {
            if (sin2 <= -1.0d) {
                this.f3672c = 0;
                this.f3670a = -1L;
                this.f3671b = -1L;
                return;
            }
            double acos = (float) (Math.acos(sin2) / 6.283185307179586d);
            this.f3670a = Math.round((round + acos) * 8.64E7d) + 946728000000L;
            long round2 = Math.round((round - acos) * 8.64E7d) + 946728000000L;
            this.f3671b = round2;
            if (round2 >= j3 || this.f3670a <= j3) {
                this.f3672c = 1;
            } else {
                this.f3672c = 0;
            }
        }
    }
}
