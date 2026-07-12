package r;

import java.util.ArrayList;
import n.C0474d;
import q.d;
import q.e;

/* renamed from: r.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0558b {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f13052a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private a f13053b = new a();

    /* renamed from: c, reason: collision with root package name */
    private q.f f13054c;

    /* renamed from: r.b$a */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        public static int f13055k = 0;

        /* renamed from: l, reason: collision with root package name */
        public static int f13056l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static int f13057m = 2;

        /* renamed from: a, reason: collision with root package name */
        public e.b f13058a;

        /* renamed from: b, reason: collision with root package name */
        public e.b f13059b;

        /* renamed from: c, reason: collision with root package name */
        public int f13060c;

        /* renamed from: d, reason: collision with root package name */
        public int f13061d;

        /* renamed from: e, reason: collision with root package name */
        public int f13062e;

        /* renamed from: f, reason: collision with root package name */
        public int f13063f;

        /* renamed from: g, reason: collision with root package name */
        public int f13064g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f13065h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f13066i;

        /* renamed from: j, reason: collision with root package name */
        public int f13067j;
    }

    /* renamed from: r.b$b, reason: collision with other inner class name */
    public interface InterfaceC0145b {
        void a(q.e eVar, a aVar);

        void b();
    }

    public C0558b(q.f fVar) {
        this.f13054c = fVar;
    }

    private boolean a(InterfaceC0145b interfaceC0145b, q.e eVar, int i3) {
        this.f13053b.f13058a = eVar.y();
        this.f13053b.f13059b = eVar.R();
        this.f13053b.f13060c = eVar.U();
        this.f13053b.f13061d = eVar.v();
        a aVar = this.f13053b;
        aVar.f13066i = false;
        aVar.f13067j = i3;
        e.b bVar = aVar.f13058a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z3 = bVar == bVar2;
        boolean z4 = aVar.f13059b == bVar2;
        boolean z5 = z3 && eVar.f12901d0 > 0.0f;
        boolean z6 = z4 && eVar.f12901d0 > 0.0f;
        if (z5 && eVar.f12942y[0] == 4) {
            aVar.f13058a = e.b.FIXED;
        }
        if (z6 && eVar.f12942y[1] == 4) {
            aVar.f13059b = e.b.FIXED;
        }
        interfaceC0145b.a(eVar, aVar);
        eVar.g1(this.f13053b.f13062e);
        eVar.I0(this.f13053b.f13063f);
        eVar.H0(this.f13053b.f13065h);
        eVar.x0(this.f13053b.f13064g);
        a aVar2 = this.f13053b;
        aVar2.f13067j = a.f13055k;
        return aVar2.f13066i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0089, code lost:
    
        if (r8 != r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0090, code lost:
    
        if (r5.f12901d0 <= 0.0f) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(q.f r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = r13.f12995L0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.P1(r1)
            r.b$b r2 = r13.F1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto La0
            java.util.ArrayList r5 = r13.f12995L0
            java.lang.Object r5 = r5.get(r4)
            q.e r5 = (q.e) r5
            boolean r6 = r5 instanceof q.g
            if (r6 == 0) goto L22
            goto L9c
        L22:
            boolean r6 = r5 instanceof q.C0512a
            if (r6 == 0) goto L28
            goto L9c
        L28:
            boolean r6 = r5.j0()
            if (r6 == 0) goto L30
            goto L9c
        L30:
            if (r1 == 0) goto L47
            r.l r6 = r5.f12902e
            if (r6 == 0) goto L47
            r.n r7 = r5.f12904f
            if (r7 == 0) goto L47
            r.g r6 = r6.f13136e
            boolean r6 = r6.f13088j
            if (r6 == 0) goto L47
            r.g r6 = r7.f13136e
            boolean r6 = r6.f13088j
            if (r6 == 0) goto L47
            goto L9c
        L47:
            q.e$b r6 = r5.s(r3)
            r7 = 1
            q.e$b r8 = r5.s(r7)
            q.e$b r9 = q.e.b.MATCH_CONSTRAINT
            if (r6 != r9) goto L60
            int r10 = r5.f12938w
            if (r10 == r7) goto L60
            if (r8 != r9) goto L60
            int r10 = r5.f12940x
            if (r10 == r7) goto L60
            r10 = r7
            goto L61
        L60:
            r10 = r3
        L61:
            if (r10 != 0) goto L93
            boolean r11 = r13.P1(r7)
            if (r11 == 0) goto L93
            if (r6 != r9) goto L78
            int r11 = r5.f12938w
            if (r11 != 0) goto L78
            if (r8 == r9) goto L78
            boolean r11 = r5.g0()
            if (r11 != 0) goto L78
            r10 = r7
        L78:
            if (r8 != r9) goto L87
            int r11 = r5.f12940x
            if (r11 != 0) goto L87
            if (r6 == r9) goto L87
            boolean r11 = r5.g0()
            if (r11 != 0) goto L87
            r10 = r7
        L87:
            if (r6 == r9) goto L8b
            if (r8 != r9) goto L93
        L8b:
            float r6 = r5.f12901d0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L93
            goto L94
        L93:
            r7 = r10
        L94:
            if (r7 == 0) goto L97
            goto L9c
        L97:
            int r6 = r.C0558b.a.f13055k
            r12.a(r2, r5, r6)
        L9c:
            int r4 = r4 + 1
            goto L12
        La0:
            r2.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r.C0558b.b(q.f):void");
    }

    private void c(q.f fVar, String str, int i3, int i4, int i5) {
        int G3 = fVar.G();
        int F3 = fVar.F();
        fVar.W0(0);
        fVar.V0(0);
        fVar.g1(i4);
        fVar.I0(i5);
        fVar.W0(G3);
        fVar.V0(F3);
        this.f13054c.T1(i3);
        this.f13054c.o1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public long d(q.f fVar, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12;
        boolean z3;
        int i13;
        int i14;
        boolean z4;
        boolean z5;
        int i15;
        C0558b c0558b = this;
        InterfaceC0145b F12 = fVar.F1();
        int size = fVar.f12995L0.size();
        int U3 = fVar.U();
        int v3 = fVar.v();
        boolean b3 = q.j.b(i3, 128);
        int i16 = 1;
        boolean z6 = b3 || q.j.b(i3, 64);
        if (z6) {
            for (int i17 = 0; i17 < size; i17++) {
                q.e eVar = (q.e) fVar.f12995L0.get(i17);
                e.b y3 = eVar.y();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z7 = (y3 == bVar) && (eVar.R() == bVar) && eVar.t() > 0.0f;
                if ((eVar.g0() && z7) || ((eVar.i0() && z7) || eVar.g0() || eVar.i0())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6) {
            boolean z8 = C0474d.f12482r;
        }
        boolean z9 = z6 & ((i6 == 1073741824 && i8 == 1073741824) || b3);
        int i18 = 2;
        if (z9) {
            int min = Math.min(fVar.E(), i7);
            int min2 = Math.min(fVar.D(), i9);
            if (i6 == 1073741824 && fVar.U() != min) {
                fVar.g1(min);
                fVar.I1();
            }
            if (i8 == 1073741824 && fVar.v() != min2) {
                fVar.I0(min2);
                fVar.I1();
            }
            if (i6 == 1073741824 && i8 == 1073741824) {
                z3 = fVar.B1(b3);
                i13 = 2;
                i12 = 0;
            } else {
                boolean C12 = fVar.C1(b3);
                i12 = 0;
                if (i6 == 1073741824) {
                    C12 &= fVar.D1(b3, 0);
                    i13 = 1;
                } else {
                    i13 = 0;
                }
                if (i8 == 1073741824) {
                    z3 = fVar.D1(b3, 1) & C12;
                    i13++;
                } else {
                    z3 = C12;
                }
            }
            if (z3) {
                fVar.l1(i6 == 1073741824 ? 1 : i12, i8 == 1073741824 ? 1 : i12);
            }
        } else {
            i12 = 0;
            z3 = false;
            i13 = 0;
        }
        if (z3 && i13 == 2) {
            return 0L;
        }
        int G12 = fVar.G1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = c0558b.f13052a.size();
        if (size > 0) {
            c(fVar, "First pass", 0, U3, v3);
        }
        if (size2 > 0) {
            e.b y4 = fVar.y();
            e.b bVar2 = e.b.WRAP_CONTENT;
            int i19 = y4 == bVar2 ? 1 : i12;
            int i20 = fVar.R() == bVar2 ? 1 : i12;
            int max = Math.max(fVar.U(), c0558b.f13054c.G());
            int max2 = Math.max(fVar.v(), c0558b.f13054c.F());
            for (int i21 = i12; i21 < size2; i21++) {
            }
            int i22 = 0;
            while (i22 < i18) {
                int i23 = 0;
                boolean z10 = false;
                while (i23 < size2) {
                    q.e eVar2 = (q.e) c0558b.f13052a.get(i23);
                    if ((eVar2 instanceof q.h) || (eVar2 instanceof q.g)) {
                        i14 = size2;
                    } else {
                        i14 = size2;
                        if (eVar2.T() != 8 && (!z9 || !eVar2.f12902e.f13136e.f13088j || !eVar2.f12904f.f13136e.f13088j)) {
                            int U4 = eVar2.U();
                            int v4 = eVar2.v();
                            z4 = z9;
                            int n3 = eVar2.n();
                            int i24 = a.f13056l;
                            if (i22 == 1) {
                                i24 = a.f13057m;
                            }
                            boolean a3 = z10 | c0558b.a(F12, eVar2, i24);
                            int U5 = eVar2.U();
                            int v5 = eVar2.v();
                            if (U5 != U4) {
                                eVar2.g1(U5);
                                if (i19 != 0 && eVar2.K() > max) {
                                    max = Math.max(max, eVar2.K() + eVar2.m(d.b.RIGHT).e());
                                }
                                z5 = true;
                            } else {
                                z5 = a3;
                            }
                            if (v5 != v4) {
                                eVar2.I0(v5);
                                if (i20 != 0 && eVar2.p() > max2) {
                                    max2 = Math.max(max2, eVar2.p() + eVar2.m(d.b.BOTTOM).e());
                                }
                                z10 = true;
                            } else {
                                z10 = z5;
                            }
                            if (eVar2.X() && n3 != eVar2.n()) {
                                i15 = 1;
                                z10 = true;
                                i23 += i15;
                                size2 = i14;
                                i16 = i15;
                                z9 = z4;
                                c0558b = this;
                            }
                            i15 = 1;
                            i23 += i15;
                            size2 = i14;
                            i16 = i15;
                            z9 = z4;
                            c0558b = this;
                        }
                    }
                    z4 = z9;
                    i15 = 1;
                    i23 += i15;
                    size2 = i14;
                    i16 = i15;
                    z9 = z4;
                    c0558b = this;
                }
                boolean z11 = z9;
                int i25 = size2;
                int i26 = i16;
                if (!z10) {
                    break;
                }
                i22 += i26;
                c(fVar, "intermediate pass", i22, U3, v3);
                size2 = i25;
                i16 = i26;
                z9 = z11;
                i18 = 2;
                c0558b = this;
            }
        }
        fVar.S1(G12);
        return 0L;
    }

    public void e(q.f fVar) {
        this.f13052a.clear();
        int size = fVar.f12995L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            q.e eVar = (q.e) fVar.f12995L0.get(i3);
            e.b y3 = eVar.y();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (y3 == bVar || eVar.R() == bVar) {
                this.f13052a.add(eVar);
            }
        }
        fVar.I1();
    }
}
