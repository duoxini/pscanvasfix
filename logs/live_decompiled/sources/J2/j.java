package j2;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class j implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    public final Charset f12176e;

    /* renamed from: f, reason: collision with root package name */
    public final RandomAccessFile f12177f;

    /* renamed from: g, reason: collision with root package name */
    public final long f12178g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[][] f12179h;

    /* renamed from: i, reason: collision with root package name */
    public final int f12180i;

    /* renamed from: j, reason: collision with root package name */
    public final int f12181j;

    /* renamed from: k, reason: collision with root package name */
    public a f12182k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f12183l = false;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f12184a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f12185b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f12186c;

        /* renamed from: d, reason: collision with root package name */
        public int f12187d;

        public /* synthetic */ a(j jVar, long j3, int i3) {
            this(j3, i3, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x00ad, code lost:
        
            r1 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x00ae, code lost:
        
            if (r0 == false) goto L61;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x00b0, code lost:
        
            r0 = r15.f12186c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x00b2, code lost:
        
            if (r0 == null) goto L62;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00b4, code lost:
        
            r1 = new java.lang.String(r0, r15.f12188e.f12176e.name());
            r15.f12186c = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00c3, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
        
            return r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.String a(j2.j.a r15) {
            /*
                Method dump skipped, instructions count: 196
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j2.j.a.a(j2.j$a):java.lang.String");
        }

        public a(long j3, int i3, byte[] bArr) {
            this.f12184a = j3;
            int length = (bArr != null ? bArr.length : 0) + i3;
            byte[] bArr2 = new byte[length];
            this.f12185b = bArr2;
            long a3 = (j3 - 1) * j.a(j.this);
            if (j3 > 0) {
                j.this.f12177f.seek(a3);
                if (j.this.f12177f.read(bArr2, 0, i3) != i3) {
                    throw new IllegalStateException("Count of requested bytes and actually read bytes don't match");
                }
            }
            if (bArr != null) {
                System.arraycopy(bArr, 0, bArr2, i3, bArr.length);
            }
            this.f12187d = length - 1;
            this.f12186c = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        if (r1 > 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public j(java.io.File r8, java.nio.charset.Charset r9) {
        /*
            r7 = this;
            r7.<init>()
            r0 = 0
            r7.f12183l = r0
            r7.f12176e = r9
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "r"
            r1.<init>(r8, r2)
            r7.f12177f = r1
            long r1 = r1.length()
            r8 = 4096(0x1000, float:5.74E-42)
            long r3 = (long) r8
            long r5 = r1 % r3
            int r5 = (int) r5
            if (r5 <= 0) goto L24
            long r1 = r1 / r3
            r3 = 1
            long r1 = r1 + r3
            r7.f12178g = r1
            goto L2f
        L24:
            long r3 = r1 / r3
            r7.f12178g = r3
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L2f
            goto L30
        L2f:
            r8 = r5
        L30:
            j2.j$a r1 = new j2.j$a
            long r2 = r7.f12178g
            r1.<init>(r7, r2, r8)
            r7.f12182k = r1
            java.nio.charset.Charset r8 = j2.AbstractC0411a.a(r9)
            java.nio.charset.CharsetEncoder r1 = r8.newEncoder()
            float r1 = r1.maxBytesPerChar()
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r2 = 1
            if (r1 != 0) goto L4f
            r7.f12181j = r2
            goto L92
        L4f:
            java.nio.charset.Charset r1 = j2.AbstractC0411a.f12161d
            if (r8 != r1) goto L56
            r7.f12181j = r2
            goto L92
        L56:
            java.lang.String r1 = "Shift_JIS"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            if (r8 != r1) goto L61
            r7.f12181j = r2
            goto L92
        L61:
            java.nio.charset.Charset r1 = j2.AbstractC0411a.f12159b
            if (r8 == r1) goto L8f
            java.nio.charset.Charset r1 = j2.AbstractC0411a.f12160c
            if (r8 != r1) goto L6a
            goto L8f
        L6a:
            java.nio.charset.Charset r7 = j2.AbstractC0411a.f12158a
            if (r8 != r7) goto L76
            java.io.UnsupportedEncodingException r7 = new java.io.UnsupportedEncodingException
            java.lang.String r8 = "For UTF-16, you need to specify the byte order (use UTF-16BE or UTF-16LE)"
            r7.<init>(r8)
            throw r7
        L76:
            java.io.UnsupportedEncodingException r7 = new java.io.UnsupportedEncodingException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Encoding "
            r8.<init>(r0)
            r8.append(r9)
            java.lang.String r9 = " is not supported yet (feel free to submit a patch)"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L8f:
            r8 = 2
            r7.f12181j = r8
        L92:
            java.lang.String r8 = r9.name()
            java.lang.String r1 = "\r\n"
            byte[] r8 = r1.getBytes(r8)
            java.lang.String r1 = r9.name()
            java.lang.String r2 = "\n"
            byte[] r1 = r2.getBytes(r1)
            java.lang.String r9 = r9.name()
            java.lang.String r2 = "\r"
            byte[] r9 = r2.getBytes(r9)
            byte[][] r8 = new byte[][]{r8, r1, r9}
            r7.f12179h = r8
            r8 = r8[r0]
            int r8 = r8.length
            r7.f12180i = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j2.j.<init>(java.io.File, java.nio.charset.Charset):void");
    }

    public static /* synthetic */ int a(j jVar) {
        jVar.getClass();
        return 4096;
    }

    public final String b() {
        a aVar;
        String a3 = a.a(this.f12182k);
        while (a3 == null) {
            a aVar2 = this.f12182k;
            if (aVar2.f12187d > -1) {
                throw new IllegalStateException("Current currentLastCharPos unexpectedly positive... last readLine() should have returned something! currentLastCharPos=" + aVar2.f12187d);
            }
            long j3 = aVar2.f12184a;
            if (j3 > 1) {
                j jVar = j.this;
                jVar.getClass();
                aVar = jVar.new a(j3 - 1, 4096, aVar2.f12186c);
            } else {
                if (aVar2.f12186c != null) {
                    throw new IllegalStateException("Unexpected leftover of the last block: leftOverOfThisFilePart=".concat(new String(aVar2.f12186c, j.this.f12176e.name())));
                }
                aVar = null;
            }
            this.f12182k = aVar;
            if (aVar == null) {
                break;
            }
            a3 = a.a(aVar);
        }
        if (!"".equals(a3) || this.f12183l) {
            return a3;
        }
        this.f12183l = true;
        return b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f12177f.close();
    }
}
