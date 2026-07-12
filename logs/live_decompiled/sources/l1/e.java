package l1;

import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.EOFException;
import l1.c;

/* loaded from: classes.dex */
final class e extends c {

    /* renamed from: r, reason: collision with root package name */
    private static final U2.e f12315r = U2.e.b("'\\");

    /* renamed from: s, reason: collision with root package name */
    private static final U2.e f12316s = U2.e.b("\"\\");

    /* renamed from: t, reason: collision with root package name */
    private static final U2.e f12317t = U2.e.b("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: u, reason: collision with root package name */
    private static final U2.e f12318u = U2.e.b("\n\r");

    /* renamed from: v, reason: collision with root package name */
    private static final U2.e f12319v = U2.e.b("*/");

    /* renamed from: l, reason: collision with root package name */
    private final U2.d f12320l;

    /* renamed from: m, reason: collision with root package name */
    private final U2.b f12321m;

    /* renamed from: n, reason: collision with root package name */
    private int f12322n = 0;

    /* renamed from: o, reason: collision with root package name */
    private long f12323o;

    /* renamed from: p, reason: collision with root package name */
    private int f12324p;

    /* renamed from: q, reason: collision with root package name */
    private String f12325q;

    e(U2.d dVar) {
        if (dVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f12320l = dVar;
        this.f12321m = dVar.r();
        X(6);
    }

    private void f0() {
        if (!this.f12300i) {
            throw e0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int g0() {
        int[] iArr = this.f12297f;
        int i3 = this.f12296e;
        int i4 = iArr[i3 - 1];
        if (i4 == 1) {
            iArr[i3 - 1] = 2;
        } else if (i4 == 2) {
            int j02 = j0(true);
            this.f12321m.Z();
            if (j02 != 44) {
                if (j02 != 59) {
                    if (j02 != 93) {
                        throw e0("Unterminated array");
                    }
                    this.f12322n = 4;
                    return 4;
                }
                f0();
            }
        } else {
            if (i4 == 3 || i4 == 5) {
                iArr[i3 - 1] = 4;
                if (i4 == 5) {
                    int j03 = j0(true);
                    this.f12321m.Z();
                    if (j03 != 44) {
                        if (j03 != 59) {
                            if (j03 != 125) {
                                throw e0("Unterminated object");
                            }
                            this.f12322n = 2;
                            return 2;
                        }
                        f0();
                    }
                }
                int j04 = j0(true);
                if (j04 == 34) {
                    this.f12321m.Z();
                    this.f12322n = 13;
                    return 13;
                }
                if (j04 == 39) {
                    this.f12321m.Z();
                    f0();
                    this.f12322n = 12;
                    return 12;
                }
                if (j04 != 125) {
                    f0();
                    if (!i0((char) j04)) {
                        throw e0("Expected name");
                    }
                    this.f12322n = 14;
                    return 14;
                }
                if (i4 == 5) {
                    throw e0("Expected name");
                }
                this.f12321m.Z();
                this.f12322n = 2;
                return 2;
            }
            if (i4 == 4) {
                iArr[i3 - 1] = 5;
                int j05 = j0(true);
                this.f12321m.Z();
                if (j05 != 58) {
                    if (j05 != 61) {
                        throw e0("Expected ':'");
                    }
                    f0();
                    if (this.f12320l.A(1L) && this.f12321m.j(0L) == 62) {
                        this.f12321m.Z();
                    }
                }
            } else if (i4 == 6) {
                iArr[i3 - 1] = 7;
            } else if (i4 == 7) {
                if (j0(false) == -1) {
                    this.f12322n = 18;
                    return 18;
                }
                f0();
            } else if (i4 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int j06 = j0(true);
        if (j06 == 34) {
            this.f12321m.Z();
            this.f12322n = 9;
            return 9;
        }
        if (j06 == 39) {
            f0();
            this.f12321m.Z();
            this.f12322n = 8;
            return 8;
        }
        if (j06 != 44 && j06 != 59) {
            if (j06 == 91) {
                this.f12321m.Z();
                this.f12322n = 3;
                return 3;
            }
            if (j06 != 93) {
                if (j06 == 123) {
                    this.f12321m.Z();
                    this.f12322n = 1;
                    return 1;
                }
                int m02 = m0();
                if (m02 != 0) {
                    return m02;
                }
                int n02 = n0();
                if (n02 != 0) {
                    return n02;
                }
                if (!i0(this.f12321m.j(0L))) {
                    throw e0("Expected value");
                }
                f0();
                this.f12322n = 10;
                return 10;
            }
            if (i4 == 1) {
                this.f12321m.Z();
                this.f12322n = 4;
                return 4;
            }
        }
        if (i4 != 1 && i4 != 2) {
            throw e0("Unexpected value");
        }
        f0();
        this.f12322n = 7;
        return 7;
    }

    private int h0(String str, c.a aVar) {
        int length = aVar.f12302a.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(aVar.f12302a[i3])) {
                this.f12322n = 0;
                this.f12298g[this.f12296e - 1] = str;
                return i3;
            }
        }
        return -1;
    }

    private boolean i0(int i3) {
        if (i3 == 9 || i3 == 10 || i3 == 12 || i3 == 13 || i3 == 32) {
            return false;
        }
        if (i3 != 35) {
            if (i3 == 44) {
                return false;
            }
            if (i3 != 47 && i3 != 61) {
                if (i3 == 123 || i3 == 125 || i3 == 58) {
                    return false;
                }
                if (i3 != 59) {
                    switch (i3) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        f0();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f12321m.f0(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        f0();
        r0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.f12320l.A(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        f0();
        r3 = r6.f12321m.j(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.f12321m.Z();
        r6.f12321m.Z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (q0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw e0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.f12321m.Z();
        r6.f12321m.Z();
        r0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int j0(boolean r7) {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            U2.d r2 = r6.f12320l
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.A(r4)
            if (r2 == 0) goto L80
            U2.b r2 = r6.f12321m
            long r4 = (long) r1
            byte r2 = r2.j(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            U2.b r3 = r6.f12321m
            long r4 = (long) r1
            r3.f0(r4)
            r1 = 47
            if (r2 != r1) goto L72
            U2.d r3 = r6.f12320l
            r4 = 2
            boolean r3 = r3.A(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.f0()
            U2.b r3 = r6.f12321m
            r4 = 1
            byte r3 = r3.j(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            U2.b r1 = r6.f12321m
            r1.Z()
            U2.b r1 = r6.f12321m
            r1.Z()
            r6.r0()
            goto L1
        L5a:
            U2.b r1 = r6.f12321m
            r1.Z()
            U2.b r1 = r6.f12321m
            r1.Z()
            boolean r1 = r6.q0()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            l1.b r6 = r6.e0(r7)
            throw r6
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.f0()
            r6.r0()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r6 = -1
            return r6
        L84:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "End of input"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.e.j0(boolean):int");
    }

    private String k0(U2.e eVar) {
        StringBuilder sb = null;
        while (true) {
            long L3 = this.f12320l.L(eVar);
            if (L3 == -1) {
                throw e0("Unterminated string");
            }
            if (this.f12321m.j(L3) != 92) {
                if (sb == null) {
                    String c02 = this.f12321m.c0(L3);
                    this.f12321m.Z();
                    return c02;
                }
                sb.append(this.f12321m.c0(L3));
                this.f12321m.Z();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.f12321m.c0(L3));
            this.f12321m.Z();
            sb.append(o0());
        }
    }

    private String l0() {
        long L3 = this.f12320l.L(f12317t);
        U2.b bVar = this.f12321m;
        return L3 != -1 ? bVar.c0(L3) : bVar.b0();
    }

    private int m0() {
        String str;
        String str2;
        int i3;
        byte j3 = this.f12321m.j(0L);
        if (j3 == 116 || j3 == 84) {
            str = "true";
            str2 = "TRUE";
            i3 = 5;
        } else if (j3 == 102 || j3 == 70) {
            str = "false";
            str2 = "FALSE";
            i3 = 6;
        } else {
            if (j3 != 110 && j3 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i3 = 7;
        }
        int length = str.length();
        int i4 = 1;
        while (i4 < length) {
            int i5 = i4 + 1;
            if (!this.f12320l.A(i5)) {
                return 0;
            }
            byte j4 = this.f12321m.j(i4);
            if (j4 != str.charAt(i4) && j4 != str2.charAt(i4)) {
                return 0;
            }
            i4 = i5;
        }
        if (this.f12320l.A(length + 1) && i0(this.f12321m.j(length))) {
            return 0;
        }
        this.f12321m.f0(length);
        this.f12322n = i3;
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (i0(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.f12323o = r8;
        r16.f12321m.f0(r5);
        r16.f12322n = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.f12324p = r5;
        r16.f12322n = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int n0() {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.e.n0():int");
    }

    private char o0() {
        int i3;
        if (!this.f12320l.A(1L)) {
            throw e0("Unterminated escape sequence");
        }
        byte Z2 = this.f12321m.Z();
        if (Z2 == 10 || Z2 == 34 || Z2 == 39 || Z2 == 47 || Z2 == 92) {
            return (char) Z2;
        }
        if (Z2 == 98) {
            return '\b';
        }
        if (Z2 == 102) {
            return '\f';
        }
        if (Z2 == 110) {
            return '\n';
        }
        if (Z2 == 114) {
            return '\r';
        }
        if (Z2 == 116) {
            return '\t';
        }
        if (Z2 != 117) {
            if (this.f12300i) {
                return (char) Z2;
            }
            throw e0("Invalid escape sequence: \\" + ((char) Z2));
        }
        if (!this.f12320l.A(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + d());
        }
        char c3 = 0;
        for (int i4 = 0; i4 < 4; i4++) {
            byte j3 = this.f12321m.j(i4);
            char c4 = (char) (c3 << 4);
            if (j3 >= 48 && j3 <= 57) {
                i3 = j3 - 48;
            } else if (j3 >= 97 && j3 <= 102) {
                i3 = j3 - 87;
            } else {
                if (j3 < 65 || j3 > 70) {
                    throw e0("\\u" + this.f12321m.c0(4L));
                }
                i3 = j3 - 55;
            }
            c3 = (char) (c4 + i3);
        }
        this.f12321m.f0(4L);
        return c3;
    }

    private void p0(U2.e eVar) {
        while (true) {
            long L3 = this.f12320l.L(eVar);
            if (L3 == -1) {
                throw e0("Unterminated string");
            }
            if (this.f12321m.j(L3) != 92) {
                this.f12321m.f0(L3 + 1);
                return;
            } else {
                this.f12321m.f0(L3 + 1);
                o0();
            }
        }
    }

    private boolean q0() {
        long v3 = this.f12320l.v(f12319v);
        boolean z3 = v3 != -1;
        U2.b bVar = this.f12321m;
        bVar.f0(z3 ? v3 + r1.o() : bVar.e0());
        return z3;
    }

    private void r0() {
        long L3 = this.f12320l.L(f12318u);
        U2.b bVar = this.f12321m;
        bVar.f0(L3 != -1 ? L3 + 1 : bVar.e0());
    }

    private void s0() {
        long L3 = this.f12320l.L(f12317t);
        U2.b bVar = this.f12321m;
        if (L3 == -1) {
            L3 = bVar.e0();
        }
        bVar.f0(L3);
    }

    @Override // l1.c
    public String G() {
        String c02;
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 10) {
            c02 = l0();
        } else if (i3 == 9) {
            c02 = k0(f12316s);
        } else if (i3 == 8) {
            c02 = k0(f12315r);
        } else if (i3 == 11) {
            c02 = this.f12325q;
            this.f12325q = null;
        } else if (i3 == 16) {
            c02 = Long.toString(this.f12323o);
        } else {
            if (i3 != 17) {
                throw new C0447a("Expected a string but was " + N() + " at path " + d());
            }
            c02 = this.f12321m.c0(this.f12324p);
        }
        this.f12322n = 0;
        int[] iArr = this.f12299h;
        int i4 = this.f12296e - 1;
        iArr[i4] = iArr[i4] + 1;
        return c02;
    }

    @Override // l1.c
    public c.b N() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        switch (i3) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
            case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
            case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                return c.b.STRING;
            case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
            case Constants.MessagerConstants.METHOD_ID_PREVIEW /* 13 */:
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                return c.b.NAME;
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // l1.c
    public int a0(c.a aVar) {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 < 12 || i3 > 15) {
            return -1;
        }
        if (i3 == 15) {
            return h0(this.f12325q, aVar);
        }
        int t3 = this.f12320l.t(aVar.f12303b);
        if (t3 != -1) {
            this.f12322n = 0;
            this.f12298g[this.f12296e - 1] = aVar.f12302a[t3];
            return t3;
        }
        String str = this.f12298g[this.f12296e - 1];
        String u3 = u();
        int h02 = h0(u3, aVar);
        if (h02 == -1) {
            this.f12322n = 15;
            this.f12325q = u3;
            this.f12298g[this.f12296e - 1] = str;
        }
        return h02;
    }

    @Override // l1.c
    public void b() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 3) {
            X(1);
            this.f12299h[this.f12296e - 1] = 0;
            this.f12322n = 0;
        } else {
            throw new C0447a("Expected BEGIN_ARRAY but was " + N() + " at path " + d());
        }
    }

    @Override // l1.c
    public void b0() {
        if (this.f12301j) {
            throw new C0447a("Cannot skip unexpected " + N() + " at " + d());
        }
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 14) {
            s0();
        } else if (i3 == 13) {
            p0(f12316s);
        } else if (i3 == 12) {
            p0(f12315r);
        } else if (i3 != 15) {
            throw new C0447a("Expected a name but was " + N() + " at path " + d());
        }
        this.f12322n = 0;
        this.f12298g[this.f12296e - 1] = "null";
    }

    @Override // l1.c
    public void c() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 1) {
            X(3);
            this.f12322n = 0;
            return;
        }
        throw new C0447a("Expected BEGIN_OBJECT but was " + N() + " at path " + d());
    }

    @Override // l1.c
    public void c0() {
        if (this.f12301j) {
            throw new C0447a("Cannot skip unexpected " + N() + " at " + d());
        }
        int i3 = 0;
        do {
            int i4 = this.f12322n;
            if (i4 == 0) {
                i4 = g0();
            }
            if (i4 == 3) {
                X(1);
            } else if (i4 == 1) {
                X(3);
            } else {
                if (i4 == 4) {
                    i3--;
                    if (i3 < 0) {
                        throw new C0447a("Expected a value but was " + N() + " at path " + d());
                    }
                    this.f12296e--;
                } else if (i4 == 2) {
                    i3--;
                    if (i3 < 0) {
                        throw new C0447a("Expected a value but was " + N() + " at path " + d());
                    }
                    this.f12296e--;
                } else if (i4 == 14 || i4 == 10) {
                    s0();
                } else if (i4 == 9 || i4 == 13) {
                    p0(f12316s);
                } else if (i4 == 8 || i4 == 12) {
                    p0(f12315r);
                } else if (i4 == 17) {
                    this.f12321m.f0(this.f12324p);
                } else if (i4 == 18) {
                    throw new C0447a("Expected a value but was " + N() + " at path " + d());
                }
                this.f12322n = 0;
            }
            i3++;
            this.f12322n = 0;
        } while (i3 != 0);
        int[] iArr = this.f12299h;
        int i5 = this.f12296e;
        int i6 = i5 - 1;
        iArr[i6] = iArr[i6] + 1;
        this.f12298g[i5 - 1] = "null";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f12322n = 0;
        this.f12297f[0] = 8;
        this.f12296e = 1;
        this.f12321m.a();
        this.f12320l.close();
    }

    @Override // l1.c
    public void g() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 != 4) {
            throw new C0447a("Expected END_ARRAY but was " + N() + " at path " + d());
        }
        int i4 = this.f12296e;
        this.f12296e = i4 - 1;
        int[] iArr = this.f12299h;
        int i5 = i4 - 2;
        iArr[i5] = iArr[i5] + 1;
        this.f12322n = 0;
    }

    @Override // l1.c
    public void i() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 != 2) {
            throw new C0447a("Expected END_OBJECT but was " + N() + " at path " + d());
        }
        int i4 = this.f12296e;
        int i5 = i4 - 1;
        this.f12296e = i5;
        this.f12298g[i5] = null;
        int[] iArr = this.f12299h;
        int i6 = i4 - 2;
        iArr[i6] = iArr[i6] + 1;
        this.f12322n = 0;
    }

    @Override // l1.c
    public boolean j() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        return (i3 == 2 || i3 == 4 || i3 == 18) ? false : true;
    }

    @Override // l1.c
    public boolean l() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 5) {
            this.f12322n = 0;
            int[] iArr = this.f12299h;
            int i4 = this.f12296e - 1;
            iArr[i4] = iArr[i4] + 1;
            return true;
        }
        if (i3 == 6) {
            this.f12322n = 0;
            int[] iArr2 = this.f12299h;
            int i5 = this.f12296e - 1;
            iArr2[i5] = iArr2[i5] + 1;
            return false;
        }
        throw new C0447a("Expected a boolean but was " + N() + " at path " + d());
    }

    @Override // l1.c
    public double p() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 16) {
            this.f12322n = 0;
            int[] iArr = this.f12299h;
            int i4 = this.f12296e - 1;
            iArr[i4] = iArr[i4] + 1;
            return this.f12323o;
        }
        if (i3 == 17) {
            this.f12325q = this.f12321m.c0(this.f12324p);
        } else if (i3 == 9) {
            this.f12325q = k0(f12316s);
        } else if (i3 == 8) {
            this.f12325q = k0(f12315r);
        } else if (i3 == 10) {
            this.f12325q = l0();
        } else if (i3 != 11) {
            throw new C0447a("Expected a double but was " + N() + " at path " + d());
        }
        this.f12322n = 11;
        try {
            double parseDouble = Double.parseDouble(this.f12325q);
            if (this.f12300i || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.f12325q = null;
                this.f12322n = 0;
                int[] iArr2 = this.f12299h;
                int i5 = this.f12296e - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseDouble;
            }
            throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + d());
        } catch (NumberFormatException unused) {
            throw new C0447a("Expected a double but was " + this.f12325q + " at path " + d());
        }
    }

    @Override // l1.c
    public int q() {
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 16) {
            long j3 = this.f12323o;
            int i4 = (int) j3;
            if (j3 == i4) {
                this.f12322n = 0;
                int[] iArr = this.f12299h;
                int i5 = this.f12296e - 1;
                iArr[i5] = iArr[i5] + 1;
                return i4;
            }
            throw new C0447a("Expected an int but was " + this.f12323o + " at path " + d());
        }
        if (i3 == 17) {
            this.f12325q = this.f12321m.c0(this.f12324p);
        } else if (i3 == 9 || i3 == 8) {
            String k02 = i3 == 9 ? k0(f12316s) : k0(f12315r);
            this.f12325q = k02;
            try {
                int parseInt = Integer.parseInt(k02);
                this.f12322n = 0;
                int[] iArr2 = this.f12299h;
                int i6 = this.f12296e - 1;
                iArr2[i6] = iArr2[i6] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i3 != 11) {
            throw new C0447a("Expected an int but was " + N() + " at path " + d());
        }
        this.f12322n = 11;
        try {
            double parseDouble = Double.parseDouble(this.f12325q);
            int i7 = (int) parseDouble;
            if (i7 == parseDouble) {
                this.f12325q = null;
                this.f12322n = 0;
                int[] iArr3 = this.f12299h;
                int i8 = this.f12296e - 1;
                iArr3[i8] = iArr3[i8] + 1;
                return i7;
            }
            throw new C0447a("Expected an int but was " + this.f12325q + " at path " + d());
        } catch (NumberFormatException unused2) {
            throw new C0447a("Expected an int but was " + this.f12325q + " at path " + d());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f12320l + ")";
    }

    @Override // l1.c
    public String u() {
        String str;
        int i3 = this.f12322n;
        if (i3 == 0) {
            i3 = g0();
        }
        if (i3 == 14) {
            str = l0();
        } else if (i3 == 13) {
            str = k0(f12316s);
        } else if (i3 == 12) {
            str = k0(f12315r);
        } else {
            if (i3 != 15) {
                throw new C0447a("Expected a name but was " + N() + " at path " + d());
            }
            str = this.f12325q;
        }
        this.f12322n = 0;
        this.f12298g[this.f12296e - 1] = str;
        return str;
    }
}
