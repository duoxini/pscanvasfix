package H2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class f extends e {
    public static float a(float f3, float f4) {
        return f3 < f4 ? f4 : f3;
    }

    public static int b(int i3, int i4) {
        return i3 < i4 ? i4 : i3;
    }

    public static int c(int i3, int i4) {
        return i3 > i4 ? i4 : i3;
    }

    public static long d(long j3, long j4) {
        return j3 > j4 ? j4 : j3;
    }

    public static int e(int i3, int i4, int i5) {
        if (i4 <= i5) {
            return i3 < i4 ? i4 : i3 > i5 ? i5 : i3;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i5 + " is less than minimum " + i4 + '.');
    }

    public static a f(int i3, int i4) {
        return a.f882h.a(i3, i4, -1);
    }

    public static c g(int i3, int i4) {
        return i4 <= Integer.MIN_VALUE ? c.f890i.a() : new c(i3, i4 - 1);
    }
}
