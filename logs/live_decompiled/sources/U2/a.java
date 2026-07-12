package U2;

import U2.b;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final b.a f2453a = new b.a();

    /* renamed from: b, reason: collision with root package name */
    private static final int f2454b = -1234567890;

    public static final boolean a(byte[] bArr, int i3, byte[] bArr2, int i4, int i5) {
        D2.k.e(bArr, "a");
        D2.k.e(bArr2, "b");
        for (int i6 = 0; i6 < i5; i6++) {
            if (bArr[i6 + i3] != bArr2[i6 + i4]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j3, long j4, long j5) {
        if ((j4 | j5) < 0 || j4 > j3 || j3 - j4 < j5) {
            throw new ArrayIndexOutOfBoundsException("size=" + j3 + " offset=" + j4 + " byteCount=" + j5);
        }
    }

    public static final int c(e eVar, int i3) {
        D2.k.e(eVar, "<this>");
        return i3 == f2454b ? eVar.o() : i3;
    }
}
