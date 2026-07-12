package Z0;

import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: e, reason: collision with root package name */
    private final Reader f3068e;

    /* renamed from: m, reason: collision with root package name */
    private long f3076m;

    /* renamed from: n, reason: collision with root package name */
    private int f3077n;

    /* renamed from: o, reason: collision with root package name */
    private String f3078o;

    /* renamed from: p, reason: collision with root package name */
    private int[] f3079p;

    /* renamed from: r, reason: collision with root package name */
    private String[] f3081r;

    /* renamed from: s, reason: collision with root package name */
    private int[] f3082s;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3069f = false;

    /* renamed from: g, reason: collision with root package name */
    private final char[] f3070g = new char[1024];

    /* renamed from: h, reason: collision with root package name */
    private int f3071h = 0;

    /* renamed from: i, reason: collision with root package name */
    private int f3072i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f3073j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f3074k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f3075l = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f3080q = 1;

    /* renamed from: Z0.a$a, reason: collision with other inner class name */
    class C0050a extends X0.a {
        C0050a() {
        }
    }

    static {
        X0.a.f2834a = new C0050a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f3079p = iArr;
        iArr[0] = 6;
        this.f3081r = new String[32];
        this.f3082s = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f3068e = reader;
    }

    private boolean N(char c3) {
        if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
            return false;
        }
        if (c3 != '#') {
            if (c3 == ',') {
                return false;
            }
            if (c3 != '/' && c3 != '=') {
                if (c3 == '{' || c3 == '}' || c3 == ':') {
                    return false;
                }
                if (c3 != ';') {
                    switch (c3) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private void c() {
        if (!this.f3069f) {
            throw s0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int f0(boolean z3) {
        char[] cArr = this.f3070g;
        int i3 = this.f3071h;
        int i4 = this.f3072i;
        while (true) {
            if (i3 == i4) {
                this.f3071h = i3;
                if (!p(1)) {
                    if (!z3) {
                        return -1;
                    }
                    throw new EOFException("End of input" + X());
                }
                i3 = this.f3071h;
                i4 = this.f3072i;
            }
            int i5 = i3 + 1;
            char c3 = cArr[i3];
            if (c3 == '\n') {
                this.f3073j++;
                this.f3074k = i5;
            } else if (c3 != ' ' && c3 != '\r' && c3 != '\t') {
                if (c3 == '/') {
                    this.f3071h = i5;
                    if (i5 == i4) {
                        this.f3071h = i3;
                        boolean p3 = p(2);
                        this.f3071h++;
                        if (!p3) {
                            return c3;
                        }
                    }
                    c();
                    int i6 = this.f3071h;
                    char c4 = cArr[i6];
                    if (c4 == '*') {
                        this.f3071h = i6 + 1;
                        if (!q0("*/")) {
                            throw s0("Unterminated comment");
                        }
                        i3 = this.f3071h + 2;
                        i4 = this.f3072i;
                    } else {
                        if (c4 != '/') {
                            return c3;
                        }
                        this.f3071h = i6 + 1;
                        r0();
                        i3 = this.f3071h;
                        i4 = this.f3072i;
                    }
                } else {
                    if (c3 != '#') {
                        this.f3071h = i5;
                        return c3;
                    }
                    this.f3071h = i5;
                    c();
                    r0();
                    i3 = this.f3071h;
                    i4 = this.f3072i;
                }
            }
            i3 = i5;
        }
    }

    private void g() {
        f0(true);
        int i3 = this.f3071h;
        this.f3071h = i3 - 1;
        if (i3 + 4 <= this.f3072i || p(5)) {
            int i4 = this.f3071h;
            char[] cArr = this.f3070g;
            if (cArr[i4] == ')' && cArr[i4 + 1] == ']' && cArr[i4 + 2] == '}' && cArr[i4 + 3] == '\'' && cArr[i4 + 4] == '\n') {
                this.f3071h = i4 + 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f3071h = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String h0(char r10) {
        /*
            r9 = this;
            char[] r0 = r9.f3070g
            r1 = 0
        L3:
            int r2 = r9.f3071h
            int r3 = r9.f3072i
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5a
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f3071h = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r9 = new java.lang.String
            r9.<init>(r0, r3, r7)
            return r9
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r9 = r1.toString()
            return r9
        L28:
            r8 = 92
            if (r2 != r8) goto L4d
            r9.f3071h = r7
            int r7 = r7 - r3
            int r2 = r7 + (-1)
            if (r1 != 0) goto L3e
            int r7 = r7 * 2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = java.lang.Math.max(r7, r5)
            r1.<init>(r4)
        L3e:
            r1.append(r0, r3, r2)
            char r2 = r9.o0()
            r1.append(r2)
            int r2 = r9.f3071h
            int r3 = r9.f3072i
            goto L7
        L4d:
            r5 = 10
            if (r2 != r5) goto L58
            int r2 = r9.f3073j
            int r2 = r2 + r6
            r9.f3073j = r2
            r9.f3074k = r7
        L58:
            r2 = r7
            goto L9
        L5a:
            if (r1 != 0) goto L6a
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6a:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f3071h = r2
            boolean r2 = r9.p(r6)
            if (r2 == 0) goto L78
            goto L3
        L78:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r9 = r9.s0(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Z0.a.h0(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String j0() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r1
        L3:
            int r3 = r6.f3071h
            int r4 = r3 + r2
            int r5 = r6.f3072i
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f3070g
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.c()
            goto L5c
        L4e:
            char[] r3 = r6.f3070g
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.p(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f3070g
            int r4 = r6.f3071h
            r0.append(r3, r4, r2)
            int r3 = r6.f3071h
            int r3 = r3 + r2
            r6.f3071h = r3
            r2 = 1
            boolean r2 = r6.p(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f3070g
            int r3 = r6.f3071h
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f3070g
            int r3 = r6.f3071h
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f3071h
            int r2 = r2 + r1
            r6.f3071h = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: Z0.a.j0():java.lang.String");
    }

    private int l0() {
        String str;
        String str2;
        int i3;
        char c3 = this.f3070g[this.f3071h];
        if (c3 == 't' || c3 == 'T') {
            str = "true";
            str2 = "TRUE";
            i3 = 5;
        } else if (c3 == 'f' || c3 == 'F') {
            str = "false";
            str2 = "FALSE";
            i3 = 6;
        } else {
            if (c3 != 'n' && c3 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i3 = 7;
        }
        int length = str.length();
        for (int i4 = 1; i4 < length; i4++) {
            if (this.f3071h + i4 >= this.f3072i && !p(i4 + 1)) {
                return 0;
            }
            char c4 = this.f3070g[this.f3071h + i4];
            if (c4 != str.charAt(i4) && c4 != str2.charAt(i4)) {
                return 0;
            }
        }
        if ((this.f3071h + length < this.f3072i || p(length + 1)) && N(this.f3070g[this.f3071h + length])) {
            return 0;
        }
        this.f3071h += length;
        this.f3075l = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ab, code lost:
    
        r18.f3076m = r11;
        r18.f3071h += r8;
        r18.f3075l = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c2, code lost:
    
        r18.f3077n = r8;
        r18.f3075l = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0091, code lost:
    
        if (N(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c9, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m0() {
        /*
            Method dump skipped, instructions count: 248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z0.a.m0():int");
    }

    private void n0(int i3) {
        int i4 = this.f3080q;
        int[] iArr = this.f3079p;
        if (i4 == iArr.length) {
            int i5 = i4 * 2;
            this.f3079p = Arrays.copyOf(iArr, i5);
            this.f3082s = Arrays.copyOf(this.f3082s, i5);
            this.f3081r = (String[]) Arrays.copyOf(this.f3081r, i5);
        }
        int[] iArr2 = this.f3079p;
        int i6 = this.f3080q;
        this.f3080q = i6 + 1;
        iArr2[i6] = i3;
    }

    private char o0() {
        int i3;
        if (this.f3071h == this.f3072i && !p(1)) {
            throw s0("Unterminated escape sequence");
        }
        char[] cArr = this.f3070g;
        int i4 = this.f3071h;
        int i5 = i4 + 1;
        this.f3071h = i5;
        char c3 = cArr[i4];
        if (c3 == '\n') {
            this.f3073j++;
            this.f3074k = i5;
        } else if (c3 != '\"' && c3 != '\'' && c3 != '/' && c3 != '\\') {
            if (c3 == 'b') {
                return '\b';
            }
            if (c3 == 'f') {
                return '\f';
            }
            if (c3 == 'n') {
                return '\n';
            }
            if (c3 == 'r') {
                return '\r';
            }
            if (c3 == 't') {
                return '\t';
            }
            if (c3 != 'u') {
                throw s0("Invalid escape sequence");
            }
            if (i4 + 5 > this.f3072i && !p(4)) {
                throw s0("Unterminated escape sequence");
            }
            int i6 = this.f3071h;
            int i7 = i6 + 4;
            char c4 = 0;
            while (i6 < i7) {
                char c5 = this.f3070g[i6];
                char c6 = (char) (c4 << 4);
                if (c5 >= '0' && c5 <= '9') {
                    i3 = c5 - '0';
                } else if (c5 >= 'a' && c5 <= 'f') {
                    i3 = c5 - 'W';
                } else {
                    if (c5 < 'A' || c5 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.f3070g, this.f3071h, 4));
                    }
                    i3 = c5 - '7';
                }
                c4 = (char) (c6 + i3);
                i6++;
            }
            this.f3071h += 4;
            return c4;
        }
        return c3;
    }

    private boolean p(int i3) {
        int i4;
        int i5;
        char[] cArr = this.f3070g;
        int i6 = this.f3074k;
        int i7 = this.f3071h;
        this.f3074k = i6 - i7;
        int i8 = this.f3072i;
        if (i8 != i7) {
            int i9 = i8 - i7;
            this.f3072i = i9;
            System.arraycopy(cArr, i7, cArr, 0, i9);
        } else {
            this.f3072i = 0;
        }
        this.f3071h = 0;
        do {
            Reader reader = this.f3068e;
            int i10 = this.f3072i;
            int read = reader.read(cArr, i10, cArr.length - i10);
            if (read == -1) {
                return false;
            }
            i4 = this.f3072i + read;
            this.f3072i = i4;
            if (this.f3073j == 0 && (i5 = this.f3074k) == 0 && i4 > 0 && cArr[0] == 65279) {
                this.f3071h++;
                this.f3074k = i5 + 1;
                i3++;
            }
        } while (i4 < i3);
        return true;
    }

    private String q(boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i3 = 0;
        while (true) {
            int i4 = this.f3080q;
            if (i3 >= i4) {
                return sb.toString();
            }
            int i5 = this.f3079p[i3];
            if (i5 == 1 || i5 == 2) {
                int i6 = this.f3082s[i3];
                if (z3 && i6 > 0 && i3 == i4 - 1) {
                    i6--;
                }
                sb.append('[');
                sb.append(i6);
                sb.append(']');
            } else if (i5 == 3 || i5 == 4 || i5 == 5) {
                sb.append('.');
                String str = this.f3081r[i3];
                if (str != null) {
                    sb.append(str);
                }
            }
            i3++;
        }
    }

    private boolean q0(String str) {
        int length = str.length();
        while (true) {
            if (this.f3071h + length > this.f3072i && !p(length)) {
                return false;
            }
            char[] cArr = this.f3070g;
            int i3 = this.f3071h;
            if (cArr[i3] != '\n') {
                for (int i4 = 0; i4 < length; i4++) {
                    if (this.f3070g[this.f3071h + i4] != str.charAt(i4)) {
                        break;
                    }
                }
                return true;
            }
            this.f3073j++;
            this.f3074k = i3 + 1;
            this.f3071h++;
        }
    }

    private void r0() {
        char c3;
        do {
            if (this.f3071h >= this.f3072i && !p(1)) {
                return;
            }
            char[] cArr = this.f3070g;
            int i3 = this.f3071h;
            int i4 = i3 + 1;
            this.f3071h = i4;
            c3 = cArr[i3];
            if (c3 == '\n') {
                this.f3073j++;
                this.f3074k = i4;
                return;
            }
        } while (c3 != '\r');
    }

    private IOException s0(String str) {
        throw new d(str + X());
    }

    public boolean G() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        return (i3 == 2 || i3 == 4 || i3 == 17) ? false : true;
    }

    public final boolean K() {
        return this.f3069f;
    }

    String X() {
        return " at line " + (this.f3073j + 1) + " column " + ((this.f3071h - this.f3074k) + 1) + " path " + d();
    }

    public void a() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 3) {
            n0(1);
            this.f3082s[this.f3080q - 1] = 0;
            this.f3075l = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + k0() + X());
        }
    }

    public boolean a0() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 5) {
            this.f3075l = 0;
            int[] iArr = this.f3082s;
            int i4 = this.f3080q - 1;
            iArr[i4] = iArr[i4] + 1;
            return true;
        }
        if (i3 == 6) {
            this.f3075l = 0;
            int[] iArr2 = this.f3082s;
            int i5 = this.f3080q - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + k0() + X());
    }

    public void b() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 1) {
            n0(3);
            this.f3075l = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + k0() + X());
        }
    }

    public double b0() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 15) {
            this.f3075l = 0;
            int[] iArr = this.f3082s;
            int i4 = this.f3080q - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f3076m;
        }
        if (i3 == 16) {
            this.f3078o = new String(this.f3070g, this.f3071h, this.f3077n);
            this.f3071h += this.f3077n;
        } else if (i3 == 8 || i3 == 9) {
            this.f3078o = h0(i3 == 8 ? '\'' : '\"');
        } else if (i3 == 10) {
            this.f3078o = j0();
        } else if (i3 != 11) {
            throw new IllegalStateException("Expected a double but was " + k0() + X());
        }
        this.f3075l = 11;
        double parseDouble = Double.parseDouble(this.f3078o);
        if (!this.f3069f && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + X());
        }
        this.f3078o = null;
        this.f3075l = 0;
        int[] iArr2 = this.f3082s;
        int i5 = this.f3080q - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return parseDouble;
    }

    public int c0() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 15) {
            long j3 = this.f3076m;
            int i4 = (int) j3;
            if (j3 == i4) {
                this.f3075l = 0;
                int[] iArr = this.f3082s;
                int i5 = this.f3080q - 1;
                iArr[i5] = iArr[i5] + 1;
                return i4;
            }
            throw new NumberFormatException("Expected an int but was " + this.f3076m + X());
        }
        if (i3 == 16) {
            this.f3078o = new String(this.f3070g, this.f3071h, this.f3077n);
            this.f3071h += this.f3077n;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected an int but was " + k0() + X());
            }
            if (i3 == 10) {
                this.f3078o = j0();
            } else {
                this.f3078o = h0(i3 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f3078o);
                this.f3075l = 0;
                int[] iArr2 = this.f3082s;
                int i6 = this.f3080q - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3075l = 11;
        double parseDouble = Double.parseDouble(this.f3078o);
        int i7 = (int) parseDouble;
        if (i7 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f3078o + X());
        }
        this.f3078o = null;
        this.f3075l = 0;
        int[] iArr3 = this.f3082s;
        int i8 = this.f3080q - 1;
        iArr3[i8] = iArr3[i8] + 1;
        return i7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3075l = 0;
        this.f3079p[0] = 8;
        this.f3080q = 1;
        this.f3068e.close();
    }

    public String d() {
        return q(false);
    }

    public long d0() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 15) {
            this.f3075l = 0;
            int[] iArr = this.f3082s;
            int i4 = this.f3080q - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f3076m;
        }
        if (i3 == 16) {
            this.f3078o = new String(this.f3070g, this.f3071h, this.f3077n);
            this.f3071h += this.f3077n;
        } else {
            if (i3 != 8 && i3 != 9 && i3 != 10) {
                throw new IllegalStateException("Expected a long but was " + k0() + X());
            }
            if (i3 == 10) {
                this.f3078o = j0();
            } else {
                this.f3078o = h0(i3 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f3078o);
                this.f3075l = 0;
                int[] iArr2 = this.f3082s;
                int i5 = this.f3080q - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f3075l = 11;
        double parseDouble = Double.parseDouble(this.f3078o);
        long j3 = (long) parseDouble;
        if (j3 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f3078o + X());
        }
        this.f3078o = null;
        this.f3075l = 0;
        int[] iArr3 = this.f3082s;
        int i6 = this.f3080q - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return j3;
    }

    public String e0() {
        String h02;
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 14) {
            h02 = j0();
        } else if (i3 == 12) {
            h02 = h0('\'');
        } else {
            if (i3 != 13) {
                throw new IllegalStateException("Expected a name but was " + k0() + X());
            }
            h02 = h0('\"');
        }
        this.f3075l = 0;
        this.f3081r[this.f3080q - 1] = h02;
        return h02;
    }

    public void g0() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 7) {
            this.f3075l = 0;
            int[] iArr = this.f3082s;
            int i4 = this.f3080q - 1;
            iArr[i4] = iArr[i4] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + k0() + X());
    }

    int i() {
        int f02;
        int[] iArr = this.f3079p;
        int i3 = this.f3080q;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 == 2) {
            int f03 = f0(true);
            if (f03 != 44) {
                if (f03 != 59) {
                    if (f03 != 93) {
                        throw s0("Unterminated array");
                    }
                    this.f3075l = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5 && (f02 = f0(true)) != 44) {
                    if (f02 != 59) {
                        if (f02 != 125) {
                            throw s0("Unterminated object");
                        }
                        this.f3075l = 2;
                        return 2;
                    }
                    c();
                }
                int f04 = f0(true);
                if (f04 == 34) {
                    this.f3075l = 13;
                    return 13;
                }
                if (f04 == 39) {
                    c();
                    this.f3075l = 12;
                    return 12;
                }
                if (f04 == 125) {
                    if (i4 == 5) {
                        throw s0("Expected name");
                    }
                    this.f3075l = 2;
                    return 2;
                }
                c();
                this.f3071h--;
                if (!N((char) f04)) {
                    throw s0("Expected name");
                }
                this.f3075l = 14;
                return 14;
            }
            if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int f05 = f0(true);
                if (f05 != 58) {
                    if (f05 != 61) {
                        throw s0("Expected ':'");
                    }
                    c();
                    if (this.f3071h < this.f3072i || p(1)) {
                        char[] cArr = this.f3070g;
                        int i5 = this.f3071h;
                        if (cArr[i5] == '>') {
                            this.f3071h = i5 + 1;
                        }
                    }
                }
            } else if (i4 == 6) {
                if (this.f3069f) {
                    g();
                }
                this.f3079p[this.f3080q - 1] = 7;
            } else if (i4 == 7) {
                if (f0(false) == -1) {
                    this.f3075l = 17;
                    return 17;
                }
                c();
                this.f3071h--;
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int f06 = f0(true);
        if (f06 == 34) {
            this.f3075l = 9;
            return 9;
        }
        if (f06 == 39) {
            c();
            this.f3075l = 8;
            return 8;
        }
        if (f06 != 44 && f06 != 59) {
            if (f06 == 91) {
                this.f3075l = 3;
                return 3;
            }
            if (f06 != 93) {
                if (f06 == 123) {
                    this.f3075l = 1;
                    return 1;
                }
                this.f3071h--;
                int l02 = l0();
                if (l02 != 0) {
                    return l02;
                }
                int m02 = m0();
                if (m02 != 0) {
                    return m02;
                }
                if (!N(this.f3070g[this.f3071h])) {
                    throw s0("Expected value");
                }
                c();
                this.f3075l = 10;
                return 10;
            }
            if (i4 == 1) {
                this.f3075l = 4;
                return 4;
            }
        }
        if (i4 != 1 && i4 != 2) {
            throw s0("Unexpected value");
        }
        c();
        this.f3071h--;
        this.f3075l = 7;
        return 7;
    }

    public String i0() {
        String str;
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 == 10) {
            str = j0();
        } else if (i3 == 8) {
            str = h0('\'');
        } else if (i3 == 9) {
            str = h0('\"');
        } else if (i3 == 11) {
            str = this.f3078o;
            this.f3078o = null;
        } else if (i3 == 15) {
            str = Long.toString(this.f3076m);
        } else {
            if (i3 != 16) {
                throw new IllegalStateException("Expected a string but was " + k0() + X());
            }
            str = new String(this.f3070g, this.f3071h, this.f3077n);
            this.f3071h += this.f3077n;
        }
        this.f3075l = 0;
        int[] iArr = this.f3082s;
        int i4 = this.f3080q - 1;
        iArr[i4] = iArr[i4] + 1;
        return str;
    }

    public void j() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + k0() + X());
        }
        int i4 = this.f3080q;
        this.f3080q = i4 - 1;
        int[] iArr = this.f3082s;
        int i5 = i4 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.f3075l = 0;
    }

    public b k0() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        switch (i3) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
            case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
            case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                return b.STRING;
            case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
            case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                return b.NAME;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void l() {
        int i3 = this.f3075l;
        if (i3 == 0) {
            i3 = i();
        }
        if (i3 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + k0() + X());
        }
        int i4 = this.f3080q;
        int i5 = i4 - 1;
        this.f3080q = i5;
        this.f3081r[i5] = null;
        int[] iArr = this.f3082s;
        int i6 = i4 - 2;
        iArr[i6] = iArr[i6] + 1;
        this.f3075l = 0;
    }

    public final void p0(boolean z3) {
        this.f3069f = z3;
    }

    public String toString() {
        return getClass().getSimpleName() + X();
    }

    public String u() {
        return q(true);
    }
}
