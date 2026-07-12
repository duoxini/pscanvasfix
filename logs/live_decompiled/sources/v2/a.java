package V2;

import D2.k;
import U2.j;
import U2.m;
import U2.r;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f2579a = r.a("0123456789abcdef");

    public static final boolean a(m mVar, int i3, byte[] bArr, int i4, int i5) {
        k.e(mVar, "segment");
        k.e(bArr, "bytes");
        int i6 = mVar.f2488c;
        byte[] bArr2 = mVar.f2486a;
        while (i4 < i5) {
            if (i3 == i6) {
                mVar = mVar.f2491f;
                k.b(mVar);
                byte[] bArr3 = mVar.f2486a;
                bArr2 = bArr3;
                i3 = mVar.f2487b;
                i6 = mVar.f2488c;
            }
            if (bArr2[i3] != bArr[i4]) {
                return false;
            }
            i3++;
            i4++;
        }
        return true;
    }

    public static final int b(U2.b bVar, j jVar, boolean z3) {
        int i3;
        int i4;
        m mVar;
        int i5;
        int i6;
        k.e(bVar, "<this>");
        k.e(jVar, "options");
        m mVar2 = bVar.f2455e;
        if (mVar2 == null) {
            return z3 ? -2 : -1;
        }
        byte[] bArr = mVar2.f2486a;
        int i7 = mVar2.f2487b;
        int i8 = mVar2.f2488c;
        int[] e3 = jVar.e();
        m mVar3 = mVar2;
        int i9 = -1;
        int i10 = 0;
        loop0: while (true) {
            int i11 = i10 + 1;
            int i12 = e3[i10];
            int i13 = i10 + 2;
            int i14 = e3[i11];
            if (i14 != -1) {
                i9 = i14;
            }
            if (mVar3 == null) {
                break;
            }
            if (i12 >= 0) {
                i3 = i7 + 1;
                int i15 = bArr[i7] & 255;
                int i16 = i13 + i12;
                while (i13 != i16) {
                    if (i15 == e3[i13]) {
                        i4 = e3[i13 + i12];
                        if (i3 == i8) {
                            mVar3 = mVar3.f2491f;
                            k.b(mVar3);
                            i3 = mVar3.f2487b;
                            bArr = mVar3.f2486a;
                            i8 = mVar3.f2488c;
                            if (mVar3 == mVar2) {
                                mVar3 = null;
                            }
                        }
                    } else {
                        i13++;
                    }
                }
                return i9;
            }
            int i17 = i13 + (i12 * (-1));
            while (true) {
                int i18 = i7 + 1;
                int i19 = i13 + 1;
                if ((bArr[i7] & 255) != e3[i13]) {
                    return i9;
                }
                boolean z4 = i19 == i17;
                if (i18 == i8) {
                    k.b(mVar3);
                    m mVar4 = mVar3.f2491f;
                    k.b(mVar4);
                    i6 = mVar4.f2487b;
                    byte[] bArr2 = mVar4.f2486a;
                    i5 = mVar4.f2488c;
                    if (mVar4 != mVar2) {
                        mVar = mVar4;
                        bArr = bArr2;
                    } else {
                        if (!z4) {
                            break loop0;
                        }
                        bArr = bArr2;
                        mVar = null;
                    }
                } else {
                    mVar = mVar3;
                    i5 = i8;
                    i6 = i18;
                }
                if (z4) {
                    i4 = e3[i19];
                    i3 = i6;
                    i8 = i5;
                    mVar3 = mVar;
                    break;
                }
                i7 = i6;
                i8 = i5;
                mVar3 = mVar;
                i13 = i19;
            }
            if (i4 >= 0) {
                return i4;
            }
            i10 = -i4;
            i7 = i3;
        }
        if (z3) {
            return -2;
        }
        return i9;
    }

    public static /* synthetic */ int c(U2.b bVar, j jVar, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return b(bVar, jVar, z3);
    }
}
