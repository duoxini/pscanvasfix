package androidx.core.content.res;

import android.graphics.Color;

/* loaded from: classes.dex */
abstract class b {

    /* renamed from: a, reason: collision with root package name */
    static final float[][] f4859a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b, reason: collision with root package name */
    static final float[][] f4860b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c, reason: collision with root package name */
    static final float[] f4861c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d, reason: collision with root package name */
    static final float[][] f4862d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    static int a(float f3) {
        if (f3 < 1.0f) {
            return -16777216;
        }
        if (f3 > 99.0f) {
            return -1;
        }
        float f4 = (f3 + 16.0f) / 116.0f;
        float f5 = f3 > 8.0f ? f4 * f4 * f4 : f3 / 903.2963f;
        float f6 = f4 * f4 * f4;
        boolean z3 = f6 > 0.008856452f;
        float f7 = z3 ? f6 : ((f4 * 116.0f) - 16.0f) / 903.2963f;
        if (!z3) {
            f6 = ((f4 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f4861c;
        return androidx.core.graphics.a.d(f7 * fArr[0], f5 * fArr[1], f6 * fArr[2]);
    }

    static float b(int i3) {
        return c(g(i3));
    }

    static float c(float f3) {
        float f4 = f3 / 100.0f;
        return f4 <= 0.008856452f ? f4 * 903.2963f : (((float) Math.cbrt(f4)) * 116.0f) - 16.0f;
    }

    static float d(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    static float e(int i3) {
        float f3 = i3 / 255.0f;
        return (f3 <= 0.04045f ? f3 / 12.92f : (float) Math.pow((f3 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    static float[] f(int i3) {
        float e3 = e(Color.red(i3));
        float e4 = e(Color.green(i3));
        float e5 = e(Color.blue(i3));
        float[][] fArr = f4862d;
        float[] fArr2 = fArr[0];
        float f3 = (fArr2[0] * e3) + (fArr2[1] * e4) + (fArr2[2] * e5);
        float[] fArr3 = fArr[1];
        float f4 = (fArr3[0] * e3) + (fArr3[1] * e4) + (fArr3[2] * e5);
        float[] fArr4 = fArr[2];
        return new float[]{f3, f4, (e3 * fArr4[0]) + (e4 * fArr4[1]) + (e5 * fArr4[2])};
    }

    static float g(int i3) {
        float e3 = e(Color.red(i3));
        float e4 = e(Color.green(i3));
        float e5 = e(Color.blue(i3));
        float[] fArr = f4862d[1];
        return (e3 * fArr[0]) + (e4 * fArr[1]) + (e5 * fArr[2]);
    }

    static float h(float f3) {
        return (f3 > 8.0f ? (float) Math.pow((f3 + 16.0d) / 116.0d, 3.0d) : f3 / 903.2963f) * 100.0f;
    }
}
