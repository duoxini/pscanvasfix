package G0;

import java.util.List;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    static List f434a;

    private static short a(byte[] bArr, byte[] bArr2, int i3) {
        int i4 = i3 % 8;
        short s3 = (short) (bArr2[i3] & 255);
        return (bArr[i3 / 8] & f.f441a[i4]) != 0 ? (short) (s3 | 256) : s3;
    }

    private static int b(char c3) {
        int i3 = c3 - 19968;
        return (i3 < 0 || i3 >= 7000) ? (7000 > i3 || i3 >= 14000) ? a(e.f439a, e.f440b, c3 - 33968) : a(d.f437a, d.f438b, c3 - 26968) : a(c.f435a, c.f436b, i3);
    }

    public static boolean c(char c3) {
        return (19968 <= c3 && c3 <= 40869 && b(c3) > 0) || 12295 == c3;
    }

    public static String d(char c3) {
        return c(c3) ? c3 == 12295 ? "LING" : f.f442b[b(c3)] : String.valueOf(c3);
    }

    public static String e(String str, String str2) {
        return a.a(str, null, f434a, str2, null);
    }
}
