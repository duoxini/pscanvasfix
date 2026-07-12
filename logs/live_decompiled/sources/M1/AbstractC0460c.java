package m1;

/* renamed from: m1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0460c {
    private static float a(float f3) {
        return f3 <= 0.04045f ? f3 / 12.92f : (float) Math.pow((f3 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    private static float b(float f3) {
        return f3 <= 0.0031308f ? f3 * 12.92f : (float) ((Math.pow(f3, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f3, int i3, int i4) {
        if (i3 == i4) {
            return i3;
        }
        float f4 = ((i3 >> 24) & 255) / 255.0f;
        float a3 = a(((i3 >> 16) & 255) / 255.0f);
        float a4 = a(((i3 >> 8) & 255) / 255.0f);
        float a5 = a((i3 & 255) / 255.0f);
        float a6 = a(((i4 >> 16) & 255) / 255.0f);
        float f5 = f4 + (((((i4 >> 24) & 255) / 255.0f) - f4) * f3);
        float a7 = a4 + ((a(((i4 >> 8) & 255) / 255.0f) - a4) * f3);
        float a8 = a5 + (f3 * (a((i4 & 255) / 255.0f) - a5));
        return (Math.round(b(a3 + ((a6 - a3) * f3)) * 255.0f) << 16) | (Math.round(f5 * 255.0f) << 24) | (Math.round(b(a7) * 255.0f) << 8) | Math.round(b(a8) * 255.0f);
    }
}
