package Z0;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: n, reason: collision with root package name */
    private static final Pattern f3094n = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: o, reason: collision with root package name */
    private static final String[] f3095o = new String[128];

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f3096p;

    /* renamed from: e, reason: collision with root package name */
    private final Writer f3097e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f3098f = new int[32];

    /* renamed from: g, reason: collision with root package name */
    private int f3099g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f3100h;

    /* renamed from: i, reason: collision with root package name */
    private String f3101i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3102j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3103k;

    /* renamed from: l, reason: collision with root package name */
    private String f3104l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f3105m;

    static {
        for (int i3 = 0; i3 <= 31; i3++) {
            f3095o[i3] = String.format("\\u%04x", Integer.valueOf(i3));
        }
        String[] strArr = f3095o;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f3096p = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        X(6);
        this.f3101i = ":";
        this.f3105m = true;
        Objects.requireNonNull(writer, "out == null");
        this.f3097e = writer;
    }

    private c K(int i3, char c3) {
        b();
        X(i3);
        this.f3097e.write(c3);
        return this;
    }

    private int N() {
        int i3 = this.f3099g;
        if (i3 != 0) {
            return this.f3098f[i3 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void X(int i3) {
        int i4 = this.f3099g;
        int[] iArr = this.f3098f;
        if (i4 == iArr.length) {
            this.f3098f = Arrays.copyOf(iArr, i4 * 2);
        }
        int[] iArr2 = this.f3098f;
        int i5 = this.f3099g;
        this.f3099g = i5 + 1;
        iArr2[i5] = i3;
    }

    private void a() {
        int N3 = N();
        if (N3 == 5) {
            this.f3097e.write(44);
        } else if (N3 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        u();
        a0(4);
    }

    private void a0(int i3) {
        this.f3098f[this.f3099g - 1] = i3;
    }

    private void b() {
        int N3 = N();
        if (N3 == 1) {
            a0(2);
            u();
            return;
        }
        if (N3 == 2) {
            this.f3097e.append(',');
            u();
        } else {
            if (N3 == 4) {
                this.f3097e.append((CharSequence) this.f3101i);
                a0(5);
                return;
            }
            if (N3 != 6) {
                if (N3 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f3102j) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            a0(7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c0(java.lang.String r9) {
        /*
            r8 = this;
            boolean r0 = r8.f3103k
            if (r0 == 0) goto L7
            java.lang.String[] r0 = Z0.c.f3096p
            goto L9
        L7:
            java.lang.String[] r0 = Z0.c.f3095o
        L9:
            java.io.Writer r1 = r8.f3097e
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f3097e
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f3097e
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f3097e
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r8 = r8.f3097e
            r8.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Z0.c.c0(java.lang.String):void");
    }

    private c i(int i3, int i4, char c3) {
        int N3 = N();
        if (N3 != i4 && N3 != i3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3104l != null) {
            throw new IllegalStateException("Dangling name: " + this.f3104l);
        }
        this.f3099g--;
        if (N3 == i4) {
            u();
        }
        this.f3097e.write(c3);
        return this;
    }

    private void j0() {
        if (this.f3104l != null) {
            a();
            c0(this.f3104l);
            this.f3104l = null;
        }
    }

    private static boolean p(Class cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void u() {
        if (this.f3100h == null) {
            return;
        }
        this.f3097e.write(10);
        int i3 = this.f3099g;
        for (int i4 = 1; i4 < i3; i4++) {
            this.f3097e.write(this.f3100h);
        }
    }

    public c G() {
        if (this.f3104l != null) {
            if (!this.f3105m) {
                this.f3104l = null;
                return this;
            }
            j0();
        }
        b();
        this.f3097e.write("null");
        return this;
    }

    public final void b0(boolean z3) {
        this.f3102j = z3;
    }

    public c c() {
        j0();
        return K(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3097e.close();
        int i3 = this.f3099g;
        if (i3 > 1 || (i3 == 1 && this.f3098f[i3 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f3099g = 0;
    }

    public c d0(double d3) {
        j0();
        if (this.f3102j || !(Double.isNaN(d3) || Double.isInfinite(d3))) {
            b();
            this.f3097e.append((CharSequence) Double.toString(d3));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d3);
    }

    public c e0(long j3) {
        j0();
        b();
        this.f3097e.write(Long.toString(j3));
        return this;
    }

    public c f0(Boolean bool) {
        if (bool == null) {
            return G();
        }
        j0();
        b();
        this.f3097e.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    @Override // java.io.Flushable
    public void flush() {
        if (this.f3099g == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3097e.flush();
    }

    public c g() {
        j0();
        return K(3, '{');
    }

    public c g0(Number number) {
        if (number == null) {
            return G();
        }
        j0();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!p(cls) && !f3094n.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f3102j) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        b();
        this.f3097e.append((CharSequence) obj);
        return this;
    }

    public c h0(String str) {
        if (str == null) {
            return G();
        }
        j0();
        b();
        c0(str);
        return this;
    }

    public c i0(boolean z3) {
        j0();
        b();
        this.f3097e.write(z3 ? "true" : "false");
        return this;
    }

    public c j() {
        return i(1, 2, ']');
    }

    public c l() {
        return i(3, 5, '}');
    }

    public c q(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.f3104l != null) {
            throw new IllegalStateException();
        }
        if (this.f3099g == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f3104l = str;
        return this;
    }
}
