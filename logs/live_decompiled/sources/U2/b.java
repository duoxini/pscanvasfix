package U2;

import androidx.preference.Preference;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
public final class b implements d, c, Cloneable, ByteChannel {

    /* renamed from: e, reason: collision with root package name */
    public m f2455e;

    /* renamed from: f, reason: collision with root package name */
    private long f2456f;

    public static final class a implements Closeable {

        /* renamed from: e, reason: collision with root package name */
        public b f2457e;

        /* renamed from: f, reason: collision with root package name */
        private m f2458f;

        /* renamed from: h, reason: collision with root package name */
        public byte[] f2460h;

        /* renamed from: g, reason: collision with root package name */
        public long f2459g = -1;

        /* renamed from: i, reason: collision with root package name */
        public int f2461i = -1;

        /* renamed from: j, reason: collision with root package name */
        public int f2462j = -1;

        public final void a(m mVar) {
            this.f2458f = mVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f2457e == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.f2457e = null;
            a(null);
            this.f2459g = -1L;
            this.f2460h = null;
            this.f2461i = -1;
            this.f2462j = -1;
        }
    }

    @Override // U2.d
    public boolean A(long j3) {
        return this.f2456f >= j3;
    }

    @Override // U2.d
    public d E() {
        return g.a(new k(this));
    }

    public e G() {
        return K(e0());
    }

    public e K(long j3) {
        if (j3 < 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j3).toString());
        }
        if (e0() < j3) {
            throw new EOFException();
        }
        if (j3 < 4096) {
            return new e(u(j3));
        }
        e h02 = h0((int) j3);
        f0(j3);
        return h02;
    }

    @Override // U2.d
    public long L(e eVar) {
        D2.k.e(eVar, "targetBytes");
        return p(eVar, 0L);
    }

    public void N(byte[] bArr) {
        D2.k.e(bArr, "sink");
        int i3 = 0;
        while (i3 < bArr.length) {
            int q3 = q(bArr, i3, bArr.length - i3);
            if (q3 == -1) {
                throw new EOFException();
            }
            i3 += q3;
        }
    }

    @Override // U2.d
    public b Q() {
        return this;
    }

    public int X() {
        if (e0() < 4) {
            throw new EOFException();
        }
        m mVar = this.f2455e;
        D2.k.b(mVar);
        int i3 = mVar.f2487b;
        int i4 = mVar.f2488c;
        if (i4 - i3 < 4) {
            return (Z() & 255) | ((Z() & 255) << 24) | ((Z() & 255) << 16) | ((Z() & 255) << 8);
        }
        byte[] bArr = mVar.f2486a;
        int i5 = i3 + 3;
        int i6 = ((bArr[i3 + 1] & 255) << 16) | ((bArr[i3] & 255) << 24) | ((bArr[i3 + 2] & 255) << 8);
        int i7 = i3 + 4;
        int i8 = (bArr[i5] & 255) | i6;
        d0(e0() - 4);
        if (i7 == i4) {
            this.f2455e = mVar.b();
            n.b(mVar);
        } else {
            mVar.f2487b = i7;
        }
        return i8;
    }

    @Override // U2.d
    public InputStream Y() {
        return new C0043b();
    }

    @Override // U2.d
    public byte Z() {
        if (e0() == 0) {
            throw new EOFException();
        }
        m mVar = this.f2455e;
        D2.k.b(mVar);
        int i3 = mVar.f2487b;
        int i4 = mVar.f2488c;
        int i5 = i3 + 1;
        byte b3 = mVar.f2486a[i3];
        d0(e0() - 1);
        if (i5 == i4) {
            this.f2455e = mVar.b();
            n.b(mVar);
        } else {
            mVar.f2487b = i5;
        }
        return b3;
    }

    public final void a() {
        f0(e0());
    }

    public String a0(long j3, Charset charset) {
        D2.k.e(charset, "charset");
        if (j3 < 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j3).toString());
        }
        if (this.f2456f < j3) {
            throw new EOFException();
        }
        if (j3 == 0) {
            return "";
        }
        m mVar = this.f2455e;
        D2.k.b(mVar);
        int i3 = mVar.f2487b;
        if (i3 + j3 > mVar.f2488c) {
            return new String(u(j3), charset);
        }
        int i4 = (int) j3;
        String str = new String(mVar.f2486a, i3, i4, charset);
        int i5 = mVar.f2487b + i4;
        mVar.f2487b = i5;
        this.f2456f -= j3;
        if (i5 == mVar.f2488c) {
            this.f2455e = mVar.b();
            n.b(mVar);
        }
        return str;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return c();
    }

    public String b0() {
        return a0(this.f2456f, K2.c.f1172b);
    }

    public final b c() {
        b bVar = new b();
        if (e0() != 0) {
            m mVar = this.f2455e;
            D2.k.b(mVar);
            m d3 = mVar.d();
            bVar.f2455e = d3;
            d3.f2492g = d3;
            d3.f2491f = d3;
            for (m mVar2 = mVar.f2491f; mVar2 != mVar; mVar2 = mVar2.f2491f) {
                m mVar3 = d3.f2492g;
                D2.k.b(mVar3);
                D2.k.b(mVar2);
                mVar3.c(mVar2.d());
            }
            bVar.d0(e0());
        }
        return bVar;
    }

    public String c0(long j3) {
        return a0(j3, K2.c.f1172b);
    }

    @Override // U2.p, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    public final void d0(long j3) {
        this.f2456f = j3;
    }

    public final long e0() {
        return this.f2456f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (e0() == bVar.e0()) {
                if (e0() == 0) {
                    return true;
                }
                m mVar = this.f2455e;
                D2.k.b(mVar);
                m mVar2 = bVar.f2455e;
                D2.k.b(mVar2);
                int i3 = mVar.f2487b;
                int i4 = mVar2.f2487b;
                long j3 = 0;
                while (j3 < e0()) {
                    long min = Math.min(mVar.f2488c - i3, mVar2.f2488c - i4);
                    long j4 = 0;
                    while (j4 < min) {
                        int i5 = i3 + 1;
                        int i6 = i4 + 1;
                        if (mVar.f2486a[i3] == mVar2.f2486a[i4]) {
                            j4++;
                            i3 = i5;
                            i4 = i6;
                        }
                    }
                    if (i3 == mVar.f2488c) {
                        mVar = mVar.f2491f;
                        D2.k.b(mVar);
                        i3 = mVar.f2487b;
                    }
                    if (i4 == mVar2.f2488c) {
                        mVar2 = mVar2.f2491f;
                        D2.k.b(mVar2);
                        i4 = mVar2.f2487b;
                    }
                    j3 += min;
                }
                return true;
            }
        }
        return false;
    }

    public void f0(long j3) {
        while (j3 > 0) {
            m mVar = this.f2455e;
            if (mVar == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j3, mVar.f2488c - mVar.f2487b);
            long j4 = min;
            d0(e0() - j4);
            j3 -= j4;
            int i3 = mVar.f2487b + min;
            mVar.f2487b = i3;
            if (i3 == mVar.f2488c) {
                this.f2455e = mVar.b();
                n.b(mVar);
            }
        }
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public final b g(b bVar, long j3, long j4) {
        D2.k.e(bVar, "out");
        U2.a.b(e0(), j3, j4);
        if (j4 != 0) {
            bVar.d0(bVar.e0() + j4);
            m mVar = this.f2455e;
            while (true) {
                D2.k.b(mVar);
                int i3 = mVar.f2488c;
                int i4 = mVar.f2487b;
                if (j3 < i3 - i4) {
                    break;
                }
                j3 -= i3 - i4;
                mVar = mVar.f2491f;
            }
            while (j4 > 0) {
                D2.k.b(mVar);
                m d3 = mVar.d();
                int i5 = d3.f2487b + ((int) j3);
                d3.f2487b = i5;
                d3.f2488c = Math.min(i5 + ((int) j4), d3.f2488c);
                m mVar2 = bVar.f2455e;
                if (mVar2 == null) {
                    d3.f2492g = d3;
                    d3.f2491f = d3;
                    bVar.f2455e = d3;
                } else {
                    D2.k.b(mVar2);
                    m mVar3 = mVar2.f2492g;
                    D2.k.b(mVar3);
                    mVar3.c(d3);
                }
                j4 -= d3.f2488c - d3.f2487b;
                mVar = mVar.f2491f;
                j3 = 0;
            }
        }
        return this;
    }

    public final e g0() {
        if (e0() <= 2147483647L) {
            return h0((int) e0());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + e0()).toString());
    }

    public final e h0(int i3) {
        if (i3 == 0) {
            return e.f2465i;
        }
        U2.a.b(e0(), 0L, i3);
        m mVar = this.f2455e;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < i3) {
            D2.k.b(mVar);
            int i7 = mVar.f2488c;
            int i8 = mVar.f2487b;
            if (i7 == i8) {
                throw new AssertionError("s.limit == s.pos");
            }
            i5 += i7 - i8;
            i6++;
            mVar = mVar.f2491f;
        }
        byte[][] bArr = new byte[i6][];
        int[] iArr = new int[i6 * 2];
        m mVar2 = this.f2455e;
        int i9 = 0;
        while (i4 < i3) {
            D2.k.b(mVar2);
            bArr[i9] = mVar2.f2486a;
            i4 += mVar2.f2488c - mVar2.f2487b;
            iArr[i9] = Math.min(i4, i3);
            iArr[i9 + i6] = mVar2.f2487b;
            mVar2.f2489d = true;
            i9++;
            mVar2 = mVar2.f2491f;
        }
        return new o(bArr, iArr);
    }

    public int hashCode() {
        m mVar = this.f2455e;
        if (mVar == null) {
            return 0;
        }
        int i3 = 1;
        do {
            int i4 = mVar.f2488c;
            for (int i5 = mVar.f2487b; i5 < i4; i5++) {
                i3 = (i3 * 31) + mVar.f2486a[i5];
            }
            mVar = mVar.f2491f;
            D2.k.b(mVar);
        } while (mVar != this.f2455e);
        return i3;
    }

    public boolean i() {
        return this.f2456f == 0;
    }

    public final m i0(int i3) {
        if (i3 < 1 || i3 > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        m mVar = this.f2455e;
        if (mVar == null) {
            m c3 = n.c();
            this.f2455e = c3;
            c3.f2492g = c3;
            c3.f2491f = c3;
            return c3;
        }
        D2.k.b(mVar);
        m mVar2 = mVar.f2492g;
        D2.k.b(mVar2);
        if (mVar2.f2488c + i3 > 8192 || !mVar2.f2490e) {
            mVar2 = mVar2.c(n.c());
        }
        return mVar2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final byte j(long j3) {
        U2.a.b(e0(), j3, 1L);
        m mVar = this.f2455e;
        if (mVar == null) {
            D2.k.b(null);
            throw null;
        }
        if (e0() - j3 < j3) {
            long e02 = e0();
            while (e02 > j3) {
                mVar = mVar.f2492g;
                D2.k.b(mVar);
                e02 -= mVar.f2488c - mVar.f2487b;
            }
            D2.k.b(mVar);
            return mVar.f2486a[(int) ((mVar.f2487b + j3) - e02)];
        }
        long j4 = 0;
        while (true) {
            long j5 = (mVar.f2488c - mVar.f2487b) + j4;
            if (j5 > j3) {
                D2.k.b(mVar);
                return mVar.f2486a[(int) ((mVar.f2487b + j3) - j4)];
            }
            mVar = mVar.f2491f;
            D2.k.b(mVar);
            j4 = j5;
        }
    }

    public void j0(b bVar, long j3) {
        m mVar;
        D2.k.e(bVar, "source");
        if (bVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        U2.a.b(bVar.e0(), 0L, j3);
        while (j3 > 0) {
            m mVar2 = bVar.f2455e;
            D2.k.b(mVar2);
            int i3 = mVar2.f2488c;
            D2.k.b(bVar.f2455e);
            if (j3 < i3 - r1.f2487b) {
                m mVar3 = this.f2455e;
                if (mVar3 != null) {
                    D2.k.b(mVar3);
                    mVar = mVar3.f2492g;
                } else {
                    mVar = null;
                }
                if (mVar != null && mVar.f2490e) {
                    if ((mVar.f2488c + j3) - (mVar.f2489d ? 0 : mVar.f2487b) <= 8192) {
                        m mVar4 = bVar.f2455e;
                        D2.k.b(mVar4);
                        mVar4.f(mVar, (int) j3);
                        bVar.d0(bVar.e0() - j3);
                        d0(e0() + j3);
                        return;
                    }
                }
                m mVar5 = bVar.f2455e;
                D2.k.b(mVar5);
                bVar.f2455e = mVar5.e((int) j3);
            }
            m mVar6 = bVar.f2455e;
            D2.k.b(mVar6);
            long j4 = mVar6.f2488c - mVar6.f2487b;
            bVar.f2455e = mVar6.b();
            m mVar7 = this.f2455e;
            if (mVar7 == null) {
                this.f2455e = mVar6;
                mVar6.f2492g = mVar6;
                mVar6.f2491f = mVar6;
            } else {
                D2.k.b(mVar7);
                m mVar8 = mVar7.f2492g;
                D2.k.b(mVar8);
                mVar8.c(mVar6).a();
            }
            bVar.d0(bVar.e0() - j4);
            d0(e0() + j4);
            j3 -= j4;
        }
    }

    public long k0(p pVar) {
        D2.k.e(pVar, "source");
        long j3 = 0;
        while (true) {
            long o3 = pVar.o(this, 8192L);
            if (o3 == -1) {
                return j3;
            }
            j3 += o3;
        }
    }

    public long l(e eVar, long j3) {
        long j4;
        int i3;
        long j5 = j3;
        D2.k.e(eVar, "bytes");
        if (eVar.o() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        long j6 = 0;
        if (j5 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j5).toString());
        }
        m mVar = this.f2455e;
        if (mVar != null) {
            if (e0() - j5 < j5) {
                j4 = e0();
                while (j4 > j5) {
                    mVar = mVar.f2492g;
                    D2.k.b(mVar);
                    j4 -= mVar.f2488c - mVar.f2487b;
                }
                byte[] i4 = eVar.i();
                byte b3 = i4[0];
                int o3 = eVar.o();
                long e02 = (e0() - o3) + 1;
                while (j4 < e02) {
                    byte[] bArr = mVar.f2486a;
                    int min = (int) Math.min(mVar.f2488c, (mVar.f2487b + e02) - j4);
                    i3 = (int) ((mVar.f2487b + j5) - j4);
                    while (i3 < min) {
                        if (bArr[i3] == b3 && V2.a.a(mVar, i3 + 1, i4, 1, o3)) {
                            return (i3 - mVar.f2487b) + j4;
                        }
                        i3++;
                    }
                    j4 += mVar.f2488c - mVar.f2487b;
                    mVar = mVar.f2491f;
                    D2.k.b(mVar);
                    j5 = j4;
                }
            } else {
                while (true) {
                    long j7 = (mVar.f2488c - mVar.f2487b) + j6;
                    if (j7 > j5) {
                        break;
                    }
                    mVar = mVar.f2491f;
                    D2.k.b(mVar);
                    j6 = j7;
                }
                byte[] i5 = eVar.i();
                byte b4 = i5[0];
                int o4 = eVar.o();
                long e03 = (e0() - o4) + 1;
                j4 = j6;
                while (j4 < e03) {
                    byte[] bArr2 = mVar.f2486a;
                    long j8 = e03;
                    int min2 = (int) Math.min(mVar.f2488c, (mVar.f2487b + e03) - j4);
                    i3 = (int) ((mVar.f2487b + j5) - j4);
                    while (i3 < min2) {
                        if (bArr2[i3] == b4 && V2.a.a(mVar, i3 + 1, i5, 1, o4)) {
                            return (i3 - mVar.f2487b) + j4;
                        }
                        i3++;
                    }
                    j4 += mVar.f2488c - mVar.f2487b;
                    mVar = mVar.f2491f;
                    D2.k.b(mVar);
                    e03 = j8;
                    j5 = j4;
                }
            }
        }
        return -1L;
    }

    @Override // U2.c
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public b T(int i3) {
        m i02 = i0(1);
        byte[] bArr = i02.f2486a;
        int i4 = i02.f2488c;
        i02.f2488c = i4 + 1;
        bArr[i4] = (byte) i3;
        d0(e0() + 1);
        return this;
    }

    public b m0(int i3) {
        m i02 = i0(4);
        byte[] bArr = i02.f2486a;
        int i4 = i02.f2488c;
        bArr[i4] = (byte) ((i3 >>> 24) & 255);
        bArr[i4 + 1] = (byte) ((i3 >>> 16) & 255);
        bArr[i4 + 2] = (byte) ((i3 >>> 8) & 255);
        bArr[i4 + 3] = (byte) (i3 & 255);
        i02.f2488c = i4 + 4;
        d0(e0() + 4);
        return this;
    }

    @Override // U2.c
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b O(String str) {
        D2.k.e(str, "string");
        return k(str, 0, str.length());
    }

    @Override // U2.p
    public long o(b bVar, long j3) {
        D2.k.e(bVar, "sink");
        if (j3 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j3).toString());
        }
        if (e0() == 0) {
            return -1L;
        }
        if (j3 > e0()) {
            j3 = e0();
        }
        bVar.j0(this, j3);
        return j3;
    }

    @Override // U2.c
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b k(String str, int i3, int i4) {
        char charAt;
        D2.k.e(str, "string");
        if (i3 < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i3).toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i4 + " < " + i3).toString());
        }
        if (i4 > str.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i4 + " > " + str.length()).toString());
        }
        while (i3 < i4) {
            char charAt2 = str.charAt(i3);
            if (charAt2 < 128) {
                m i02 = i0(1);
                byte[] bArr = i02.f2486a;
                int i5 = i02.f2488c - i3;
                int min = Math.min(i4, 8192 - i5);
                int i6 = i3 + 1;
                bArr[i3 + i5] = (byte) charAt2;
                while (true) {
                    i3 = i6;
                    if (i3 >= min || (charAt = str.charAt(i3)) >= 128) {
                        break;
                    }
                    i6 = i3 + 1;
                    bArr[i3 + i5] = (byte) charAt;
                }
                int i7 = i02.f2488c;
                int i8 = (i5 + i3) - i7;
                i02.f2488c = i7 + i8;
                d0(e0() + i8);
            } else {
                if (charAt2 < 2048) {
                    m i03 = i0(2);
                    byte[] bArr2 = i03.f2486a;
                    int i9 = i03.f2488c;
                    bArr2[i9] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i9 + 1] = (byte) ((charAt2 & '?') | 128);
                    i03.f2488c = i9 + 2;
                    d0(e0() + 2);
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    m i04 = i0(3);
                    byte[] bArr3 = i04.f2486a;
                    int i10 = i04.f2488c;
                    bArr3[i10] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i10 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i10 + 2] = (byte) ((charAt2 & '?') | 128);
                    i04.f2488c = i10 + 3;
                    d0(e0() + 3);
                } else {
                    int i11 = i3 + 1;
                    char charAt3 = i11 < i4 ? str.charAt(i11) : (char) 0;
                    if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                        T(63);
                        i3 = i11;
                    } else {
                        int i12 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        m i05 = i0(4);
                        byte[] bArr4 = i05.f2486a;
                        int i13 = i05.f2488c;
                        bArr4[i13] = (byte) ((i12 >> 18) | 240);
                        bArr4[i13 + 1] = (byte) (((i12 >> 12) & 63) | 128);
                        bArr4[i13 + 2] = (byte) (((i12 >> 6) & 63) | 128);
                        bArr4[i13 + 3] = (byte) ((i12 & 63) | 128);
                        i05.f2488c = i13 + 4;
                        d0(e0() + 4);
                        i3 += 2;
                    }
                }
                i3++;
            }
        }
        return this;
    }

    public long p(e eVar, long j3) {
        int i3;
        int i4;
        D2.k.e(eVar, "targetBytes");
        long j4 = 0;
        if (j3 < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
        }
        m mVar = this.f2455e;
        if (mVar == null) {
            return -1L;
        }
        if (e0() - j3 < j3) {
            j4 = e0();
            while (j4 > j3) {
                mVar = mVar.f2492g;
                D2.k.b(mVar);
                j4 -= mVar.f2488c - mVar.f2487b;
            }
            if (eVar.o() == 2) {
                byte c3 = eVar.c(0);
                byte c4 = eVar.c(1);
                while (j4 < e0()) {
                    byte[] bArr = mVar.f2486a;
                    i3 = (int) ((mVar.f2487b + j3) - j4);
                    int i5 = mVar.f2488c;
                    while (i3 < i5) {
                        byte b3 = bArr[i3];
                        if (b3 != c3 && b3 != c4) {
                            i3++;
                        }
                        i4 = mVar.f2487b;
                    }
                    j4 += mVar.f2488c - mVar.f2487b;
                    mVar = mVar.f2491f;
                    D2.k.b(mVar);
                    j3 = j4;
                }
                return -1L;
            }
            byte[] i6 = eVar.i();
            while (j4 < e0()) {
                byte[] bArr2 = mVar.f2486a;
                i3 = (int) ((mVar.f2487b + j3) - j4);
                int i7 = mVar.f2488c;
                while (i3 < i7) {
                    byte b4 = bArr2[i3];
                    for (byte b5 : i6) {
                        if (b4 == b5) {
                            i4 = mVar.f2487b;
                        }
                    }
                    i3++;
                }
                j4 += mVar.f2488c - mVar.f2487b;
                mVar = mVar.f2491f;
                D2.k.b(mVar);
                j3 = j4;
            }
            return -1L;
        }
        while (true) {
            long j5 = (mVar.f2488c - mVar.f2487b) + j4;
            if (j5 > j3) {
                break;
            }
            mVar = mVar.f2491f;
            D2.k.b(mVar);
            j4 = j5;
        }
        if (eVar.o() == 2) {
            byte c5 = eVar.c(0);
            byte c6 = eVar.c(1);
            while (j4 < e0()) {
                byte[] bArr3 = mVar.f2486a;
                i3 = (int) ((mVar.f2487b + j3) - j4);
                int i8 = mVar.f2488c;
                while (i3 < i8) {
                    byte b6 = bArr3[i3];
                    if (b6 != c5 && b6 != c6) {
                        i3++;
                    }
                    i4 = mVar.f2487b;
                }
                j4 += mVar.f2488c - mVar.f2487b;
                mVar = mVar.f2491f;
                D2.k.b(mVar);
                j3 = j4;
            }
            return -1L;
        }
        byte[] i9 = eVar.i();
        while (j4 < e0()) {
            byte[] bArr4 = mVar.f2486a;
            i3 = (int) ((mVar.f2487b + j3) - j4);
            int i10 = mVar.f2488c;
            while (i3 < i10) {
                byte b7 = bArr4[i3];
                for (byte b8 : i9) {
                    if (b7 == b8) {
                        i4 = mVar.f2487b;
                    }
                }
                i3++;
            }
            j4 += mVar.f2488c - mVar.f2487b;
            mVar = mVar.f2491f;
            D2.k.b(mVar);
            j3 = j4;
        }
        return -1L;
        return (i3 - i4) + j4;
    }

    public int q(byte[] bArr, int i3, int i4) {
        D2.k.e(bArr, "sink");
        U2.a.b(bArr.length, i3, i4);
        m mVar = this.f2455e;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(i4, mVar.f2488c - mVar.f2487b);
        byte[] bArr2 = mVar.f2486a;
        int i5 = mVar.f2487b;
        AbstractC0538h.g(bArr2, bArr, i3, i5, i5 + min);
        mVar.f2487b += min;
        d0(e0() - min);
        if (mVar.f2487b == mVar.f2488c) {
            this.f2455e = mVar.b();
            n.b(mVar);
        }
        return min;
    }

    @Override // U2.d
    public b r() {
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        D2.k.e(byteBuffer, "sink");
        m mVar = this.f2455e;
        if (mVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), mVar.f2488c - mVar.f2487b);
        byteBuffer.put(mVar.f2486a, mVar.f2487b, min);
        int i3 = mVar.f2487b + min;
        mVar.f2487b = i3;
        this.f2456f -= min;
        if (i3 == mVar.f2488c) {
            this.f2455e = mVar.b();
            n.b(mVar);
        }
        return min;
    }

    @Override // U2.d
    public int t(j jVar) {
        D2.k.e(jVar, "options");
        int c3 = V2.a.c(this, jVar, false, 2, null);
        if (c3 == -1) {
            return -1;
        }
        f0(jVar.d()[c3].o());
        return c3;
    }

    public String toString() {
        return g0().toString();
    }

    public byte[] u(long j3) {
        if (j3 < 0 || j3 > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + j3).toString());
        }
        if (e0() < j3) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j3];
        N(bArr);
        return bArr;
    }

    @Override // U2.d
    public long v(e eVar) {
        D2.k.e(eVar, "bytes");
        return l(eVar, 0L);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        D2.k.e(byteBuffer, "source");
        int remaining = byteBuffer.remaining();
        int i3 = remaining;
        while (i3 > 0) {
            m i02 = i0(1);
            int min = Math.min(i3, 8192 - i02.f2488c);
            byteBuffer.get(i02.f2486a, i02.f2488c, min);
            i3 -= min;
            i02.f2488c += min;
        }
        this.f2456f += remaining;
        return remaining;
    }

    /* renamed from: U2.b$b, reason: collision with other inner class name */
    public static final class C0043b extends InputStream {
        C0043b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(b.this.e0(), Preference.DEFAULT_ORDER);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            if (b.this.e0() > 0) {
                return b.this.Z() & 255;
            }
            return -1;
        }

        public String toString() {
            return b.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            D2.k.e(bArr, "sink");
            return b.this.q(bArr, i3, i4);
        }
    }
}
