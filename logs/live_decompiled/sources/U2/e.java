package U2;

import java.io.Serializable;
import java.util.Arrays;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
public class e implements Serializable, Comparable {

    /* renamed from: h, reason: collision with root package name */
    public static final a f2464h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final e f2465i = new e(new byte[0]);

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f2466e;

    /* renamed from: f, reason: collision with root package name */
    private transient int f2467f;

    /* renamed from: g, reason: collision with root package name */
    private transient String f2468g;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final e a(String str) {
            D2.k.e(str, "<this>");
            e eVar = new e(r.a(str));
            eVar.n(str);
            return eVar;
        }

        private a() {
        }
    }

    public e(byte[] bArr) {
        D2.k.e(bArr, "data");
        this.f2466e = bArr;
    }

    public static final e b(String str) {
        return f2464h.a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(U2.e r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            D2.k.e(r10, r0)
            int r0 = r9.o()
            int r1 = r10.o()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2e
            byte r7 = r9.c(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.c(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L2c
        L2a:
            r3 = r5
            goto L34
        L2c:
            r3 = r6
            goto L34
        L2e:
            if (r0 != r1) goto L31
            goto L34
        L31:
            if (r0 >= r1) goto L2c
            goto L2a
        L34:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: U2.e.compareTo(U2.e):int");
    }

    public final byte c(int i3) {
        return j(i3);
    }

    public final byte[] d() {
        return this.f2466e;
    }

    public final int e() {
        return this.f2467f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.o() == d().length && eVar.l(0, d(), 0, d().length)) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return d().length;
    }

    public final String g() {
        return this.f2468g;
    }

    public String h() {
        char[] cArr = new char[d().length * 2];
        int i3 = 0;
        for (byte b3 : d()) {
            int i4 = i3 + 1;
            cArr[i3] = V2.b.c()[(b3 >> 4) & 15];
            i3 += 2;
            cArr[i4] = V2.b.c()[b3 & 15];
        }
        return K2.e.i(cArr);
    }

    public int hashCode() {
        int e3 = e();
        if (e3 != 0) {
            return e3;
        }
        int hashCode = Arrays.hashCode(d());
        m(hashCode);
        return hashCode;
    }

    public byte[] i() {
        return d();
    }

    public byte j(int i3) {
        return d()[i3];
    }

    public boolean k(int i3, e eVar, int i4, int i5) {
        D2.k.e(eVar, "other");
        return eVar.l(i4, d(), i3, i5);
    }

    public boolean l(int i3, byte[] bArr, int i4, int i5) {
        D2.k.e(bArr, "other");
        return i3 >= 0 && i3 <= d().length - i5 && i4 >= 0 && i4 <= bArr.length - i5 && U2.a.a(d(), i3, bArr, i4, i5);
    }

    public final void m(int i3) {
        this.f2467f = i3;
    }

    public final void n(String str) {
        this.f2468g = str;
    }

    public final int o() {
        return f();
    }

    public final boolean p(e eVar) {
        D2.k.e(eVar, "prefix");
        return k(0, eVar, 0, eVar.o());
    }

    public String q() {
        String g3 = g();
        if (g3 != null) {
            return g3;
        }
        String b3 = r.b(i());
        n(b3);
        return b3;
    }

    public String toString() {
        int b3;
        if (d().length == 0) {
            return "[size=0]";
        }
        b3 = V2.b.b(d(), 64);
        if (b3 != -1) {
            String q3 = q();
            String substring = q3.substring(0, b3);
            D2.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String r3 = K2.e.r(K2.e.r(K2.e.r(substring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
            if (b3 >= q3.length()) {
                return "[text=" + r3 + ']';
            }
            return "[size=" + d().length + " text=" + r3 + "…]";
        }
        if (d().length <= 64) {
            return "[hex=" + h() + ']';
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[size=");
        sb.append(d().length);
        sb.append(" hex=");
        e eVar = this;
        int c3 = U2.a.c(eVar, 64);
        if (c3 > d().length) {
            throw new IllegalArgumentException(("endIndex > length(" + d().length + ')').toString());
        }
        if (c3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (c3 != d().length) {
            eVar = new e(AbstractC0538h.k(d(), 0, c3));
        }
        sb.append(eVar.h());
        sb.append("…]");
        return sb.toString();
    }
}
