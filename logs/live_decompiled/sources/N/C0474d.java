package n;

import java.util.Arrays;
import java.util.HashMap;
import n.C0479i;
import q.d;

/* renamed from: n.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0474d {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f12482r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f12483s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f12484t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f12485u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f12486v = false;

    /* renamed from: w, reason: collision with root package name */
    private static int f12487w = 1000;

    /* renamed from: x, reason: collision with root package name */
    public static long f12488x;

    /* renamed from: y, reason: collision with root package name */
    public static long f12489y;

    /* renamed from: d, reason: collision with root package name */
    private a f12493d;

    /* renamed from: g, reason: collision with root package name */
    C0472b[] f12496g;

    /* renamed from: n, reason: collision with root package name */
    final C0473c f12503n;

    /* renamed from: q, reason: collision with root package name */
    private a f12506q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12490a = false;

    /* renamed from: b, reason: collision with root package name */
    int f12491b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap f12492c = null;

    /* renamed from: e, reason: collision with root package name */
    private int f12494e = 32;

    /* renamed from: f, reason: collision with root package name */
    private int f12495f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12497h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12498i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean[] f12499j = new boolean[32];

    /* renamed from: k, reason: collision with root package name */
    int f12500k = 1;

    /* renamed from: l, reason: collision with root package name */
    int f12501l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f12502m = 32;

    /* renamed from: o, reason: collision with root package name */
    private C0479i[] f12504o = new C0479i[f12487w];

    /* renamed from: p, reason: collision with root package name */
    private int f12505p = 0;

    /* renamed from: n.d$a */
    interface a {
        C0479i a(C0474d c0474d, boolean[] zArr);

        void b(C0479i c0479i);

        void c(a aVar);

        void clear();

        C0479i getKey();

        boolean isEmpty();
    }

    /* renamed from: n.d$b */
    class b extends C0472b {
        public b(C0473c c0473c) {
            this.f12476e = new C0480j(this, c0473c);
        }
    }

    public C0474d() {
        this.f12496g = null;
        this.f12496g = new C0472b[32];
        D();
        C0473c c0473c = new C0473c();
        this.f12503n = c0473c;
        this.f12493d = new C0478h(c0473c);
        if (f12486v) {
            this.f12506q = new b(c0473c);
        } else {
            this.f12506q = new C0472b(c0473c);
        }
    }

    private final int C(a aVar, boolean z3) {
        for (int i3 = 0; i3 < this.f12500k; i3++) {
            this.f12499j[i3] = false;
        }
        boolean z4 = false;
        int i4 = 0;
        while (!z4) {
            i4++;
            if (i4 >= this.f12500k * 2) {
                return i4;
            }
            if (aVar.getKey() != null) {
                this.f12499j[aVar.getKey().f12523g] = true;
            }
            C0479i a3 = aVar.a(this, this.f12499j);
            if (a3 != null) {
                boolean[] zArr = this.f12499j;
                int i5 = a3.f12523g;
                if (zArr[i5]) {
                    return i4;
                }
                zArr[i5] = true;
            }
            if (a3 != null) {
                float f3 = Float.MAX_VALUE;
                int i6 = -1;
                for (int i7 = 0; i7 < this.f12501l; i7++) {
                    C0472b c0472b = this.f12496g[i7];
                    if (c0472b.f12472a.f12530n != C0479i.a.UNRESTRICTED && !c0472b.f12477f && c0472b.t(a3)) {
                        float b3 = c0472b.f12476e.b(a3);
                        if (b3 < 0.0f) {
                            float f4 = (-c0472b.f12473b) / b3;
                            if (f4 < f3) {
                                i6 = i7;
                                f3 = f4;
                            }
                        }
                    }
                }
                if (i6 > -1) {
                    C0472b c0472b2 = this.f12496g[i6];
                    c0472b2.f12472a.f12524h = -1;
                    c0472b2.x(a3);
                    C0479i c0479i = c0472b2.f12472a;
                    c0479i.f12524h = i6;
                    c0479i.h(this, c0472b2);
                }
            } else {
                z4 = true;
            }
        }
        return i4;
    }

    private void D() {
        int i3 = 0;
        if (f12486v) {
            while (i3 < this.f12501l) {
                C0472b c0472b = this.f12496g[i3];
                if (c0472b != null) {
                    this.f12503n.f12478a.a(c0472b);
                }
                this.f12496g[i3] = null;
                i3++;
            }
            return;
        }
        while (i3 < this.f12501l) {
            C0472b c0472b2 = this.f12496g[i3];
            if (c0472b2 != null) {
                this.f12503n.f12479b.a(c0472b2);
            }
            this.f12496g[i3] = null;
            i3++;
        }
    }

    private C0479i a(C0479i.a aVar, String str) {
        C0479i c0479i = (C0479i) this.f12503n.f12480c.b();
        if (c0479i == null) {
            c0479i = new C0479i(aVar, str);
            c0479i.g(aVar, str);
        } else {
            c0479i.e();
            c0479i.g(aVar, str);
        }
        int i3 = this.f12505p;
        int i4 = f12487w;
        if (i3 >= i4) {
            int i5 = i4 * 2;
            f12487w = i5;
            this.f12504o = (C0479i[]) Arrays.copyOf(this.f12504o, i5);
        }
        C0479i[] c0479iArr = this.f12504o;
        int i6 = this.f12505p;
        this.f12505p = i6 + 1;
        c0479iArr[i6] = c0479i;
        return c0479i;
    }

    private final void l(C0472b c0472b) {
        int i3;
        if (f12484t && c0472b.f12477f) {
            c0472b.f12472a.f(this, c0472b.f12473b);
        } else {
            C0472b[] c0472bArr = this.f12496g;
            int i4 = this.f12501l;
            c0472bArr[i4] = c0472b;
            C0479i c0479i = c0472b.f12472a;
            c0479i.f12524h = i4;
            this.f12501l = i4 + 1;
            c0479i.h(this, c0472b);
        }
        if (f12484t && this.f12490a) {
            int i5 = 0;
            while (i5 < this.f12501l) {
                if (this.f12496g[i5] == null) {
                    System.out.println("WTF");
                }
                C0472b c0472b2 = this.f12496g[i5];
                if (c0472b2 != null && c0472b2.f12477f) {
                    c0472b2.f12472a.f(this, c0472b2.f12473b);
                    if (f12486v) {
                        this.f12503n.f12478a.a(c0472b2);
                    } else {
                        this.f12503n.f12479b.a(c0472b2);
                    }
                    this.f12496g[i5] = null;
                    int i6 = i5 + 1;
                    int i7 = i6;
                    while (true) {
                        i3 = this.f12501l;
                        if (i6 >= i3) {
                            break;
                        }
                        C0472b[] c0472bArr2 = this.f12496g;
                        int i8 = i6 - 1;
                        C0472b c0472b3 = c0472bArr2[i6];
                        c0472bArr2[i8] = c0472b3;
                        C0479i c0479i2 = c0472b3.f12472a;
                        if (c0479i2.f12524h == i6) {
                            c0479i2.f12524h = i8;
                        }
                        i7 = i6;
                        i6++;
                    }
                    if (i7 < i3) {
                        this.f12496g[i7] = null;
                    }
                    this.f12501l = i3 - 1;
                    i5--;
                }
                i5++;
            }
            this.f12490a = false;
        }
    }

    private void n() {
        for (int i3 = 0; i3 < this.f12501l; i3++) {
            C0472b c0472b = this.f12496g[i3];
            c0472b.f12472a.f12526j = c0472b.f12473b;
        }
    }

    public static C0472b s(C0474d c0474d, C0479i c0479i, C0479i c0479i2, float f3) {
        return c0474d.r().j(c0479i, c0479i2, f3);
    }

    private int u(a aVar) {
        for (int i3 = 0; i3 < this.f12501l; i3++) {
            C0472b c0472b = this.f12496g[i3];
            if (c0472b.f12472a.f12530n != C0479i.a.UNRESTRICTED && c0472b.f12473b < 0.0f) {
                boolean z3 = false;
                int i4 = 0;
                while (!z3) {
                    i4++;
                    float f3 = Float.MAX_VALUE;
                    int i5 = 0;
                    int i6 = -1;
                    int i7 = -1;
                    int i8 = 0;
                    while (true) {
                        if (i5 >= this.f12501l) {
                            break;
                        }
                        C0472b c0472b2 = this.f12496g[i5];
                        if (c0472b2.f12472a.f12530n != C0479i.a.UNRESTRICTED && !c0472b2.f12477f && c0472b2.f12473b < 0.0f) {
                            int i9 = 9;
                            if (f12485u) {
                                int k3 = c0472b2.f12476e.k();
                                int i10 = 0;
                                while (i10 < k3) {
                                    C0479i f4 = c0472b2.f12476e.f(i10);
                                    float b3 = c0472b2.f12476e.b(f4);
                                    if (b3 > 0.0f) {
                                        int i11 = 0;
                                        while (i11 < i9) {
                                            float f5 = f4.f12528l[i11] / b3;
                                            if ((f5 < f3 && i11 == i8) || i11 > i8) {
                                                i8 = i11;
                                                i7 = f4.f12523g;
                                                i6 = i5;
                                                f3 = f5;
                                            }
                                            i11++;
                                            i9 = 9;
                                        }
                                    }
                                    i10++;
                                    i9 = 9;
                                }
                            } else {
                                for (int i12 = 1; i12 < this.f12500k; i12++) {
                                    C0479i c0479i = this.f12503n.f12481d[i12];
                                    float b4 = c0472b2.f12476e.b(c0479i);
                                    if (b4 > 0.0f) {
                                        for (int i13 = 0; i13 < 9; i13++) {
                                            float f6 = c0479i.f12528l[i13] / b4;
                                            if ((f6 < f3 && i13 == i8) || i13 > i8) {
                                                i6 = i5;
                                                i7 = i12;
                                                i8 = i13;
                                                f3 = f6;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i5++;
                    }
                    if (i6 != -1) {
                        C0472b c0472b3 = this.f12496g[i6];
                        c0472b3.f12472a.f12524h = -1;
                        c0472b3.x(this.f12503n.f12481d[i7]);
                        C0479i c0479i2 = c0472b3.f12472a;
                        c0479i2.f12524h = i6;
                        c0479i2.h(this, c0472b3);
                    } else {
                        z3 = true;
                    }
                    if (i4 > this.f12500k / 2) {
                        z3 = true;
                    }
                }
                return i4;
            }
        }
        return 0;
    }

    public static AbstractC0475e x() {
        return null;
    }

    private void z() {
        int i3 = this.f12494e * 2;
        this.f12494e = i3;
        this.f12496g = (C0472b[]) Arrays.copyOf(this.f12496g, i3);
        C0473c c0473c = this.f12503n;
        c0473c.f12481d = (C0479i[]) Arrays.copyOf(c0473c.f12481d, this.f12494e);
        int i4 = this.f12494e;
        this.f12499j = new boolean[i4];
        this.f12495f = i4;
        this.f12502m = i4;
    }

    public void A() {
        if (this.f12493d.isEmpty()) {
            n();
            return;
        }
        if (!this.f12497h && !this.f12498i) {
            B(this.f12493d);
            return;
        }
        for (int i3 = 0; i3 < this.f12501l; i3++) {
            if (!this.f12496g[i3].f12477f) {
                B(this.f12493d);
                return;
            }
        }
        n();
    }

    void B(a aVar) {
        u(aVar);
        C(aVar, false);
        n();
    }

    public void E() {
        C0473c c0473c;
        int i3 = 0;
        while (true) {
            c0473c = this.f12503n;
            C0479i[] c0479iArr = c0473c.f12481d;
            if (i3 >= c0479iArr.length) {
                break;
            }
            C0479i c0479i = c0479iArr[i3];
            if (c0479i != null) {
                c0479i.e();
            }
            i3++;
        }
        c0473c.f12480c.c(this.f12504o, this.f12505p);
        this.f12505p = 0;
        Arrays.fill(this.f12503n.f12481d, (Object) null);
        HashMap hashMap = this.f12492c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f12491b = 0;
        this.f12493d.clear();
        this.f12500k = 1;
        for (int i4 = 0; i4 < this.f12501l; i4++) {
            C0472b c0472b = this.f12496g[i4];
            if (c0472b != null) {
                c0472b.f12474c = false;
            }
        }
        D();
        this.f12501l = 0;
        if (f12486v) {
            this.f12506q = new b(this.f12503n);
        } else {
            this.f12506q = new C0472b(this.f12503n);
        }
    }

    public void b(q.e eVar, q.e eVar2, float f3, int i3) {
        d.b bVar = d.b.LEFT;
        C0479i q3 = q(eVar.m(bVar));
        d.b bVar2 = d.b.TOP;
        C0479i q4 = q(eVar.m(bVar2));
        d.b bVar3 = d.b.RIGHT;
        C0479i q5 = q(eVar.m(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        C0479i q6 = q(eVar.m(bVar4));
        C0479i q7 = q(eVar2.m(bVar));
        C0479i q8 = q(eVar2.m(bVar2));
        C0479i q9 = q(eVar2.m(bVar3));
        C0479i q10 = q(eVar2.m(bVar4));
        C0472b r3 = r();
        double d3 = f3;
        double d4 = i3;
        r3.q(q4, q6, q8, q10, (float) (Math.sin(d3) * d4));
        d(r3);
        C0472b r4 = r();
        r4.q(q3, q5, q7, q9, (float) (Math.cos(d3) * d4));
        d(r4);
    }

    public void c(C0479i c0479i, C0479i c0479i2, int i3, float f3, C0479i c0479i3, C0479i c0479i4, int i4, int i5) {
        C0472b r3 = r();
        r3.h(c0479i, c0479i2, i3, f3, c0479i3, c0479i4, i4);
        if (i5 != 8) {
            r3.d(this, i5);
        }
        d(r3);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(n.C0472b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.f12501l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f12502m
            if (r0 >= r2) goto L12
            int r0 = r5.f12500k
            int r0 = r0 + r1
            int r2 = r5.f12495f
            if (r0 < r2) goto L15
        L12:
            r5.z()
        L15:
            boolean r0 = r6.f12477f
            r2 = 0
            if (r0 != 0) goto L84
            r6.D(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L24
            return
        L24:
            r6.r()
            boolean r0 = r6.f(r5)
            if (r0 == 0) goto L7b
            n.i r0 = r5.p()
            r6.f12472a = r0
            int r3 = r5.f12501l
            r5.l(r6)
            int r4 = r5.f12501l
            int r3 = r3 + r1
            if (r4 != r3) goto L7b
            n.d$a r2 = r5.f12506q
            r2.c(r6)
            n.d$a r2 = r5.f12506q
            r5.C(r2, r1)
            int r2 = r0.f12524h
            r3 = -1
            if (r2 != r3) goto L7c
            n.i r2 = r6.f12472a
            if (r2 != r0) goto L59
            n.i r0 = r6.v(r0)
            if (r0 == 0) goto L59
            r6.x(r0)
        L59:
            boolean r0 = r6.f12477f
            if (r0 != 0) goto L62
            n.i r0 = r6.f12472a
            r0.h(r5, r6)
        L62:
            boolean r0 = n.C0474d.f12486v
            if (r0 == 0) goto L6e
            n.c r0 = r5.f12503n
            n.f r0 = r0.f12478a
            r0.a(r6)
            goto L75
        L6e:
            n.c r0 = r5.f12503n
            n.f r0 = r0.f12479b
            r0.a(r6)
        L75:
            int r0 = r5.f12501l
            int r0 = r0 - r1
            r5.f12501l = r0
            goto L7c
        L7b:
            r1 = r2
        L7c:
            boolean r0 = r6.s()
            if (r0 != 0) goto L83
            return
        L83:
            r2 = r1
        L84:
            if (r2 != 0) goto L89
            r5.l(r6)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n.C0474d.d(n.b):void");
    }

    public C0472b e(C0479i c0479i, C0479i c0479i2, int i3, int i4) {
        if (f12483s && i4 == 8 && c0479i2.f12527k && c0479i.f12524h == -1) {
            c0479i.f(this, c0479i2.f12526j + i3);
            return null;
        }
        C0472b r3 = r();
        r3.n(c0479i, c0479i2, i3);
        if (i4 != 8) {
            r3.d(this, i4);
        }
        d(r3);
        return r3;
    }

    public void f(C0479i c0479i, int i3) {
        if (f12483s && c0479i.f12524h == -1) {
            float f3 = i3;
            c0479i.f(this, f3);
            for (int i4 = 0; i4 < this.f12491b + 1; i4++) {
                C0479i c0479i2 = this.f12503n.f12481d[i4];
                if (c0479i2 != null && c0479i2.f12534r && c0479i2.f12535s == c0479i.f12523g) {
                    c0479i2.f(this, c0479i2.f12536t + f3);
                }
            }
            return;
        }
        int i5 = c0479i.f12524h;
        if (i5 == -1) {
            C0472b r3 = r();
            r3.i(c0479i, i3);
            d(r3);
            return;
        }
        C0472b c0472b = this.f12496g[i5];
        if (c0472b.f12477f) {
            c0472b.f12473b = i3;
            return;
        }
        if (c0472b.f12476e.k() == 0) {
            c0472b.f12477f = true;
            c0472b.f12473b = i3;
        } else {
            C0472b r4 = r();
            r4.m(c0479i, i3);
            d(r4);
        }
    }

    public void g(C0479i c0479i, C0479i c0479i2, int i3, boolean z3) {
        C0472b r3 = r();
        C0479i t3 = t();
        t3.f12525i = 0;
        r3.o(c0479i, c0479i2, t3, i3);
        d(r3);
    }

    public void h(C0479i c0479i, C0479i c0479i2, int i3, int i4) {
        C0472b r3 = r();
        C0479i t3 = t();
        t3.f12525i = 0;
        r3.o(c0479i, c0479i2, t3, i3);
        if (i4 != 8) {
            m(r3, (int) (r3.f12476e.b(t3) * (-1.0f)), i4);
        }
        d(r3);
    }

    public void i(C0479i c0479i, C0479i c0479i2, int i3, boolean z3) {
        C0472b r3 = r();
        C0479i t3 = t();
        t3.f12525i = 0;
        r3.p(c0479i, c0479i2, t3, i3);
        d(r3);
    }

    public void j(C0479i c0479i, C0479i c0479i2, int i3, int i4) {
        C0472b r3 = r();
        C0479i t3 = t();
        t3.f12525i = 0;
        r3.p(c0479i, c0479i2, t3, i3);
        if (i4 != 8) {
            m(r3, (int) (r3.f12476e.b(t3) * (-1.0f)), i4);
        }
        d(r3);
    }

    public void k(C0479i c0479i, C0479i c0479i2, C0479i c0479i3, C0479i c0479i4, float f3, int i3) {
        C0472b r3 = r();
        r3.k(c0479i, c0479i2, c0479i3, c0479i4, f3);
        if (i3 != 8) {
            r3.d(this, i3);
        }
        d(r3);
    }

    void m(C0472b c0472b, int i3, int i4) {
        c0472b.e(o(i4, null), i3);
    }

    public C0479i o(int i3, String str) {
        if (this.f12500k + 1 >= this.f12495f) {
            z();
        }
        C0479i a3 = a(C0479i.a.ERROR, str);
        int i4 = this.f12491b + 1;
        this.f12491b = i4;
        this.f12500k++;
        a3.f12523g = i4;
        a3.f12525i = i3;
        this.f12503n.f12481d[i4] = a3;
        this.f12493d.b(a3);
        return a3;
    }

    public C0479i p() {
        if (this.f12500k + 1 >= this.f12495f) {
            z();
        }
        C0479i a3 = a(C0479i.a.SLACK, null);
        int i3 = this.f12491b + 1;
        this.f12491b = i3;
        this.f12500k++;
        a3.f12523g = i3;
        this.f12503n.f12481d[i3] = a3;
        return a3;
    }

    public C0479i q(Object obj) {
        C0479i c0479i = null;
        if (obj == null) {
            return null;
        }
        if (this.f12500k + 1 >= this.f12495f) {
            z();
        }
        if (obj instanceof q.d) {
            q.d dVar = (q.d) obj;
            c0479i = dVar.h();
            if (c0479i == null) {
                dVar.r(this.f12503n);
                c0479i = dVar.h();
            }
            int i3 = c0479i.f12523g;
            if (i3 == -1 || i3 > this.f12491b || this.f12503n.f12481d[i3] == null) {
                if (i3 != -1) {
                    c0479i.e();
                }
                int i4 = this.f12491b + 1;
                this.f12491b = i4;
                this.f12500k++;
                c0479i.f12523g = i4;
                c0479i.f12530n = C0479i.a.UNRESTRICTED;
                this.f12503n.f12481d[i4] = c0479i;
            }
        }
        return c0479i;
    }

    public C0472b r() {
        C0472b c0472b;
        if (f12486v) {
            c0472b = (C0472b) this.f12503n.f12478a.b();
            if (c0472b == null) {
                c0472b = new b(this.f12503n);
                f12489y++;
            } else {
                c0472b.y();
            }
        } else {
            c0472b = (C0472b) this.f12503n.f12479b.b();
            if (c0472b == null) {
                c0472b = new C0472b(this.f12503n);
                f12488x++;
            } else {
                c0472b.y();
            }
        }
        C0479i.c();
        return c0472b;
    }

    public C0479i t() {
        if (this.f12500k + 1 >= this.f12495f) {
            z();
        }
        C0479i a3 = a(C0479i.a.SLACK, null);
        int i3 = this.f12491b + 1;
        this.f12491b = i3;
        this.f12500k++;
        a3.f12523g = i3;
        this.f12503n.f12481d[i3] = a3;
        return a3;
    }

    public void v(AbstractC0475e abstractC0475e) {
    }

    public C0473c w() {
        return this.f12503n;
    }

    public int y(Object obj) {
        C0479i h3 = ((q.d) obj).h();
        if (h3 != null) {
            return (int) (h3.f12526j + 0.5f);
        }
        return 0;
    }
}
