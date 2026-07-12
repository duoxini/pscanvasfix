package K2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class m extends l {
    public static Long f(String str) {
        D2.k.e(str, "<this>");
        return g(str, 10);
    }

    public static final Long g(String str, int i3) {
        boolean z3;
        D2.k.e(str, "<this>");
        a.a(i3);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        long j3 = -9223372036854775807L;
        if (D2.k.f(charAt, 48) < 0) {
            z3 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j3 = Long.MIN_VALUE;
                i4 = 1;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z3 = false;
                i4 = 1;
            }
        } else {
            z3 = false;
        }
        long j4 = -256204778801521550L;
        long j5 = 0;
        long j6 = -256204778801521550L;
        while (i4 < length) {
            int b3 = a.b(str.charAt(i4), i3);
            if (b3 < 0) {
                return null;
            }
            if (j5 < j6) {
                if (j6 == j4) {
                    j6 = j3 / i3;
                    if (j5 < j6) {
                    }
                }
                return null;
            }
            long j7 = j5 * i3;
            long j8 = b3;
            if (j7 < j3 + j8) {
                return null;
            }
            j5 = j7 - j8;
            i4++;
            j4 = -256204778801521550L;
        }
        return z3 ? Long.valueOf(j5) : Long.valueOf(-j5);
    }
}
