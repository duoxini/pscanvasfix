package p1;

/* renamed from: p1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0496a {

    /* renamed from: a, reason: collision with root package name */
    public static float f12792a = 0.008333334f;

    /* renamed from: b, reason: collision with root package name */
    public static float f12793b = 0.1f;

    /* renamed from: c, reason: collision with root package name */
    public static float f12794c = 160.0f;

    public static float a(float f3) {
        return (AbstractC0499d.c(f3) * 2.8600001f) + 2.2141f;
    }

    public static float b(float f3) {
        return f3 * f12794c;
    }

    public static float c(float f3) {
        return f3 / f12794c;
    }

    public static void d(float f3) {
        f12794c = (f3 * 55.0f) + 0.5f;
        f12793b = c(0.1f);
    }

    public static void e(float f3) {
        f12792a = f3;
    }
}
