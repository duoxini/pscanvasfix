package androidx.core.graphics;

import android.graphics.Color;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f4898a = new ThreadLocal();

    public static int a(float[] fArr) {
        int round;
        int round2;
        int round3;
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float abs = (1.0f - Math.abs((f5 * 2.0f) - 1.0f)) * f4;
        float f6 = f5 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f3 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f3) / 60) {
            case 0:
                round = Math.round((abs + f6) * 255.0f);
                round2 = Math.round((abs2 + f6) * 255.0f);
                round3 = Math.round(f6 * 255.0f);
                break;
            case 1:
                round = Math.round((abs2 + f6) * 255.0f);
                round2 = Math.round((abs + f6) * 255.0f);
                round3 = Math.round(f6 * 255.0f);
                break;
            case 2:
                round = Math.round(f6 * 255.0f);
                round2 = Math.round((abs + f6) * 255.0f);
                round3 = Math.round((abs2 + f6) * 255.0f);
                break;
            case 3:
                round = Math.round(f6 * 255.0f);
                round2 = Math.round((abs2 + f6) * 255.0f);
                round3 = Math.round((abs + f6) * 255.0f);
                break;
            case 4:
                round = Math.round((abs2 + f6) * 255.0f);
                round2 = Math.round(f6 * 255.0f);
                round3 = Math.round((abs + f6) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f6) * 255.0f);
                round2 = Math.round(f6 * 255.0f);
                round3 = Math.round((abs2 + f6) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return Color.rgb(l(round, 0, 255), l(round2, 0, 255), l(round3, 0, 255));
    }

    public static void b(int i3, int i4, int i5, float[] fArr) {
        float f3;
        float abs;
        float f4 = i3 / 255.0f;
        float f5 = i4 / 255.0f;
        float f6 = i5 / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = (max + min) / 2.0f;
        if (max == min) {
            f3 = 0.0f;
            abs = 0.0f;
        } else {
            f3 = max == f4 ? ((f5 - f6) / f7) % 6.0f : max == f5 ? ((f6 - f4) / f7) + 2.0f : 4.0f + ((f4 - f5) / f7);
            abs = f7 / (1.0f - Math.abs((2.0f * f8) - 1.0f));
        }
        float f9 = (f3 * 60.0f) % 360.0f;
        if (f9 < 0.0f) {
            f9 += 360.0f;
        }
        fArr[0] = k(f9, 0.0f, 360.0f);
        fArr[1] = k(abs, 0.0f, 1.0f);
        fArr[2] = k(f8, 0.0f, 1.0f);
    }

    public static void c(int i3, int i4, int i5, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d3 = i3 / 255.0d;
        double pow = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = i4 / 255.0d;
        double pow2 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        double d5 = i5 / 255.0d;
        double pow3 = d5 < 0.04045d ? d5 / 12.92d : Math.pow((d5 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
    }

    public static int d(double d3, double d4, double d5) {
        double d6 = (((3.2406d * d3) + ((-1.5372d) * d4)) + ((-0.4986d) * d5)) / 100.0d;
        double d7 = ((((-0.9689d) * d3) + (1.8758d * d4)) + (0.0415d * d5)) / 100.0d;
        double d8 = (((0.0557d * d3) + ((-0.204d) * d4)) + (1.057d * d5)) / 100.0d;
        return Color.rgb(l((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), l((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : d7 * 12.92d) * 255.0d), 0, 255), l((int) Math.round((d8 > 0.0031308d ? (Math.pow(d8, 0.4166666666666667d) * 1.055d) - 0.055d : d8 * 12.92d) * 255.0d), 0, 255));
    }

    public static double e(int i3) {
        double[] m3 = m();
        g(i3, m3);
        return m3[1] / 100.0d;
    }

    public static void f(int i3, float[] fArr) {
        b(Color.red(i3), Color.green(i3), Color.blue(i3), fArr);
    }

    public static void g(int i3, double[] dArr) {
        c(Color.red(i3), Color.green(i3), Color.blue(i3), dArr);
    }

    private static int h(int i3, int i4) {
        return 255 - (((255 - i4) * (255 - i3)) / 255);
    }

    public static int i(int i3, int i4) {
        int alpha = Color.alpha(i4);
        int alpha2 = Color.alpha(i3);
        int h3 = h(alpha2, alpha);
        return Color.argb(h3, j(Color.red(i3), alpha2, Color.red(i4), alpha, h3), j(Color.green(i3), alpha2, Color.green(i4), alpha, h3), j(Color.blue(i3), alpha2, Color.blue(i4), alpha, h3));
    }

    private static int j(int i3, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        return (((i3 * 255) * i4) + ((i5 * i6) * (255 - i4))) / (i7 * 255);
    }

    private static float k(float f3, float f4, float f5) {
        return f3 < f4 ? f4 : Math.min(f3, f5);
    }

    private static int l(int i3, int i4, int i5) {
        return i3 < i4 ? i4 : Math.min(i3, i5);
    }

    private static double[] m() {
        ThreadLocal threadLocal = f4898a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int n(int i3, int i4) {
        if (i4 < 0 || i4 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i3 & 16777215) | (i4 << 24);
    }
}
