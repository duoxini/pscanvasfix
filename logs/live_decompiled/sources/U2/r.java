package U2;

/* loaded from: classes.dex */
public abstract class r {
    public static final byte[] a(String str) {
        D2.k.e(str, "<this>");
        byte[] bytes = str.getBytes(K2.c.f1172b);
        D2.k.d(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] bArr) {
        D2.k.e(bArr, "<this>");
        return new String(bArr, K2.c.f1172b);
    }
}
