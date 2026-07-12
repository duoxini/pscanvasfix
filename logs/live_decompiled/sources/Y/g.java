package Y;

/* loaded from: classes.dex */
public abstract class g {
    public static int a(int i3, int i4, int i5) {
        float f3 = i5 * 0.3731f;
        return i3 + ((int) ((i4 * f3) / Math.sqrt((i4 * i4) + (f3 * f3))));
    }

    public static int b(int i3, int i4, int i5) {
        return (int) (((i3 * (1.0f - Math.min((Math.abs(i4) * 1.0f) / i5, 1.0f))) / 5.0f) * 2.0f);
    }
}
