package androidx.core.content.res;

/* loaded from: classes.dex */
final class j {

    /* renamed from: k, reason: collision with root package name */
    static final j f4887k = k(b.f4861c, (float) ((b.h(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: a, reason: collision with root package name */
    private final float f4888a;

    /* renamed from: b, reason: collision with root package name */
    private final float f4889b;

    /* renamed from: c, reason: collision with root package name */
    private final float f4890c;

    /* renamed from: d, reason: collision with root package name */
    private final float f4891d;

    /* renamed from: e, reason: collision with root package name */
    private final float f4892e;

    /* renamed from: f, reason: collision with root package name */
    private final float f4893f;

    /* renamed from: g, reason: collision with root package name */
    private final float[] f4894g;

    /* renamed from: h, reason: collision with root package name */
    private final float f4895h;

    /* renamed from: i, reason: collision with root package name */
    private final float f4896i;

    /* renamed from: j, reason: collision with root package name */
    private final float f4897j;

    private j(float f3, float f4, float f5, float f6, float f7, float f8, float[] fArr, float f9, float f10, float f11) {
        this.f4893f = f3;
        this.f4888a = f4;
        this.f4889b = f5;
        this.f4890c = f6;
        this.f4891d = f7;
        this.f4892e = f8;
        this.f4894g = fArr;
        this.f4895h = f9;
        this.f4896i = f10;
        this.f4897j = f11;
    }

    static j k(float[] fArr, float f3, float f4, float f5, boolean z3) {
        float[][] fArr2 = b.f4859a;
        float f6 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f7 = fArr3[0] * f6;
        float f8 = fArr[1];
        float f9 = f7 + (fArr3[1] * f8);
        float f10 = fArr[2];
        float f11 = f9 + (fArr3[2] * f10);
        float[] fArr4 = fArr2[1];
        float f12 = (fArr4[0] * f6) + (fArr4[1] * f8) + (fArr4[2] * f10);
        float[] fArr5 = fArr2[2];
        float f13 = (f6 * fArr5[0]) + (f8 * fArr5[1]) + (f10 * fArr5[2]);
        float f14 = (f5 / 10.0f) + 0.8f;
        float d3 = ((double) f14) >= 0.9d ? b.d(0.59f, 0.69f, (f14 - 0.9f) * 10.0f) : b.d(0.525f, 0.59f, (f14 - 0.8f) * 10.0f);
        float exp = z3 ? 1.0f : (1.0f - (((float) Math.exp(((-f3) - 42.0f) / 92.0f)) * 0.2777778f)) * f14;
        double d4 = exp;
        if (d4 > 1.0d) {
            exp = 1.0f;
        } else if (d4 < 0.0d) {
            exp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f11) * exp) + 1.0f) - exp, (((100.0f / f12) * exp) + 1.0f) - exp, (((100.0f / f13) * exp) + 1.0f) - exp};
        float f15 = 1.0f / ((5.0f * f3) + 1.0f);
        float f16 = f15 * f15 * f15 * f15;
        float f17 = 1.0f - f16;
        float cbrt = (f16 * f3) + (0.1f * f17 * f17 * ((float) Math.cbrt(f3 * 5.0d)));
        float h3 = b.h(f4) / fArr[1];
        double d5 = h3;
        float sqrt = ((float) Math.sqrt(d5)) + 1.48f;
        float pow = 0.725f / ((float) Math.pow(d5, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * cbrt) * f11) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * cbrt) * f12) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * cbrt) * f13) / 100.0d, 0.42d)};
        float f18 = fArr7[0];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[1];
        float f21 = (f20 * 400.0f) / (f20 + 27.13f);
        float f22 = fArr7[2];
        float[] fArr8 = {f19, f21, (400.0f * f22) / (f22 + 27.13f)};
        return new j(h3, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * pow, pow, pow, d3, f14, fArr6, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt);
    }

    float a() {
        return this.f4888a;
    }

    float b() {
        return this.f4891d;
    }

    float c() {
        return this.f4895h;
    }

    float d() {
        return this.f4896i;
    }

    float e() {
        return this.f4893f;
    }

    float f() {
        return this.f4889b;
    }

    float g() {
        return this.f4892e;
    }

    float h() {
        return this.f4890c;
    }

    float[] i() {
        return this.f4894g;
    }

    float j() {
        return this.f4897j;
    }
}
