package U2;

import q2.AbstractC0538h;

/* loaded from: classes.dex */
public final class o extends e {

    /* renamed from: j, reason: collision with root package name */
    private final transient byte[][] f2498j;

    /* renamed from: k, reason: collision with root package name */
    private final transient int[] f2499k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(byte[][] bArr, int[] iArr) {
        super(e.f2465i.d());
        D2.k.e(bArr, "segments");
        D2.k.e(iArr, "directory");
        this.f2498j = bArr;
        this.f2499k = iArr;
    }

    private final e u() {
        return new e(t());
    }

    @Override // U2.e
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.o() == o() && k(0, eVar, 0, o())) {
                return true;
            }
        }
        return false;
    }

    @Override // U2.e
    public int f() {
        return r()[s().length - 1];
    }

    @Override // U2.e
    public String h() {
        return u().h();
    }

    @Override // U2.e
    public int hashCode() {
        int e3 = e();
        if (e3 != 0) {
            return e3;
        }
        int length = s().length;
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        while (i3 < length) {
            int i6 = r()[length + i3];
            int i7 = r()[i3];
            byte[] bArr = s()[i3];
            int i8 = (i7 - i5) + i6;
            while (i6 < i8) {
                i4 = (i4 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i5 = i7;
        }
        m(i4);
        return i4;
    }

    @Override // U2.e
    public byte[] i() {
        return t();
    }

    @Override // U2.e
    public byte j(int i3) {
        a.b(r()[s().length - 1], i3, 1L);
        int b3 = V2.c.b(this, i3);
        return s()[b3][(i3 - (b3 == 0 ? 0 : r()[b3 - 1])) + r()[s().length + b3]];
    }

    @Override // U2.e
    public boolean k(int i3, e eVar, int i4, int i5) {
        D2.k.e(eVar, "other");
        if (i3 < 0 || i3 > o() - i5) {
            return false;
        }
        int i6 = i5 + i3;
        int b3 = V2.c.b(this, i3);
        while (i3 < i6) {
            int i7 = b3 == 0 ? 0 : r()[b3 - 1];
            int i8 = r()[b3] - i7;
            int i9 = r()[s().length + b3];
            int min = Math.min(i6, i8 + i7) - i3;
            if (!eVar.l(i4, s()[b3], i9 + (i3 - i7), min)) {
                return false;
            }
            i4 += min;
            i3 += min;
            b3++;
        }
        return true;
    }

    @Override // U2.e
    public boolean l(int i3, byte[] bArr, int i4, int i5) {
        D2.k.e(bArr, "other");
        if (i3 < 0 || i3 > o() - i5 || i4 < 0 || i4 > bArr.length - i5) {
            return false;
        }
        int i6 = i5 + i3;
        int b3 = V2.c.b(this, i3);
        while (i3 < i6) {
            int i7 = b3 == 0 ? 0 : r()[b3 - 1];
            int i8 = r()[b3] - i7;
            int i9 = r()[s().length + b3];
            int min = Math.min(i6, i8 + i7) - i3;
            if (!a.a(s()[b3], i9 + (i3 - i7), bArr, i4, min)) {
                return false;
            }
            i4 += min;
            i3 += min;
            b3++;
        }
        return true;
    }

    public final int[] r() {
        return this.f2499k;
    }

    public final byte[][] s() {
        return this.f2498j;
    }

    public byte[] t() {
        byte[] bArr = new byte[o()];
        int length = s().length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < length) {
            int i6 = r()[length + i3];
            int i7 = r()[i3];
            int i8 = i7 - i4;
            AbstractC0538h.g(s()[i3], bArr, i5, i6, i6 + i8);
            i5 += i8;
            i3++;
            i4 = i7;
        }
        return bArr;
    }

    @Override // U2.e
    public String toString() {
        return u().toString();
    }
}
