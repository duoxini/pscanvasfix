package l1;

import U2.j;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class c implements Closeable {

    /* renamed from: k, reason: collision with root package name */
    private static final String[] f12295k = new String[128];

    /* renamed from: e, reason: collision with root package name */
    int f12296e;

    /* renamed from: f, reason: collision with root package name */
    int[] f12297f = new int[32];

    /* renamed from: g, reason: collision with root package name */
    String[] f12298g = new String[32];

    /* renamed from: h, reason: collision with root package name */
    int[] f12299h = new int[32];

    /* renamed from: i, reason: collision with root package name */
    boolean f12300i;

    /* renamed from: j, reason: collision with root package name */
    boolean f12301j;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final String[] f12302a;

        /* renamed from: b, reason: collision with root package name */
        final j f12303b;

        private a(String[] strArr, j jVar) {
            this.f12302a = strArr;
            this.f12303b = jVar;
        }

        public static a a(String... strArr) {
            try {
                U2.e[] eVarArr = new U2.e[strArr.length];
                U2.b bVar = new U2.b();
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    c.d0(bVar, strArr[i3]);
                    bVar.Z();
                    eVarArr[i3] = bVar.G();
                }
                return new a((String[]) strArr.clone(), j.h(eVarArr));
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }
    }

    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f12295k[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f12295k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    c() {
    }

    public static c K(U2.d dVar) {
        return new e(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d0(U2.c r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = l1.c.f12295k
            r1 = 34
            r7.T(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.k(r8, r4, r3)
        L2e:
            r7.O(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.k(r8, r4, r2)
        L3b:
            r7.T(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.c.d0(U2.c, java.lang.String):void");
    }

    public abstract String G();

    public abstract b N();

    final void X(int i3) {
        int i4 = this.f12296e;
        int[] iArr = this.f12297f;
        if (i4 == iArr.length) {
            if (i4 == 256) {
                throw new C0447a("Nesting too deep at " + d());
            }
            this.f12297f = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f12298g;
            this.f12298g = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f12299h;
            this.f12299h = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f12297f;
        int i5 = this.f12296e;
        this.f12296e = i5 + 1;
        iArr3[i5] = i3;
    }

    public abstract int a0(a aVar);

    public abstract void b();

    public abstract void b0();

    public abstract void c();

    public abstract void c0();

    public final String d() {
        return d.a(this.f12296e, this.f12297f, this.f12298g, this.f12299h);
    }

    final l1.b e0(String str) {
        throw new l1.b(str + " at path " + d());
    }

    public abstract void g();

    public abstract void i();

    public abstract boolean j();

    public abstract boolean l();

    public abstract double p();

    public abstract int q();

    public abstract String u();
}
