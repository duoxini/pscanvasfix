package K2;

/* loaded from: classes.dex */
abstract class a {
    public static final int a(int i3) {
        if (new H2.c(2, 36).f(i3)) {
            return i3;
        }
        throw new IllegalArgumentException("radix " + i3 + " was not in valid range " + new H2.c(2, 36));
    }

    public static final int b(char c3, int i3) {
        return Character.digit((int) c3, i3);
    }

    public static final boolean c(char c3) {
        return Character.isWhitespace(c3) || Character.isSpaceChar(c3);
    }
}
