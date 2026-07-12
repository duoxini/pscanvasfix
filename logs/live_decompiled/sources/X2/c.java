package x2;

/* loaded from: classes.dex */
public abstract class c {
    private static final int a(int i3, int i4, int i5) {
        return c(c(i3, i5) - c(i4, i5), i5);
    }

    public static final int b(int i3, int i4, int i5) {
        if (i5 > 0) {
            return i3 >= i4 ? i4 : i4 - a(i4, i3, i5);
        }
        if (i5 < 0) {
            return i3 <= i4 ? i4 : i4 + a(i3, i4, -i5);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int c(int i3, int i4) {
        int i5 = i3 % i4;
        return i5 >= 0 ? i5 : i5 + i4;
    }
}
