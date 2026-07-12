package r;

import java.util.ArrayList;
import java.util.Iterator;
import q.C0512a;
import q.d;
import q.e;
import r.C0558b;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static C0558b.a f13101a = new C0558b.a();

    /* renamed from: b, reason: collision with root package name */
    private static int f13102b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f13103c = 0;

    private static boolean a(int i3, q.e eVar) {
        e.b bVar;
        e.b bVar2;
        e.b y3 = eVar.y();
        e.b R3 = eVar.R();
        q.f fVar = eVar.I() != null ? (q.f) eVar.I() : null;
        if (fVar != null) {
            fVar.y();
            e.b bVar3 = e.b.FIXED;
        }
        if (fVar != null) {
            fVar.R();
            e.b bVar4 = e.b.FIXED;
        }
        e.b bVar5 = e.b.FIXED;
        boolean z3 = y3 == bVar5 || eVar.l0() || y3 == e.b.WRAP_CONTENT || (y3 == (bVar2 = e.b.MATCH_CONSTRAINT) && eVar.f12938w == 0 && eVar.f12901d0 == 0.0f && eVar.Y(0)) || (y3 == bVar2 && eVar.f12938w == 1 && eVar.b0(0, eVar.U()));
        boolean z4 = R3 == bVar5 || eVar.m0() || R3 == e.b.WRAP_CONTENT || (R3 == (bVar = e.b.MATCH_CONSTRAINT) && eVar.f12940x == 0 && eVar.f12901d0 == 0.0f && eVar.Y(1)) || (R3 == bVar && eVar.f12940x == 1 && eVar.b0(1, eVar.v()));
        if (eVar.f12901d0 <= 0.0f || !(z3 || z4)) {
            return z3 && z4;
        }
        return true;
    }

    private static void b(int i3, q.e eVar, C0558b.InterfaceC0145b interfaceC0145b, boolean z3) {
        q.d dVar;
        q.d dVar2;
        q.d dVar3;
        q.d dVar4;
        if (eVar.e0()) {
            return;
        }
        boolean z4 = true;
        f13102b++;
        if (!(eVar instanceof q.f) && eVar.k0()) {
            int i4 = i3 + 1;
            if (a(i4, eVar)) {
                q.f.O1(i4, eVar, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
            }
        }
        q.d m3 = eVar.m(d.b.LEFT);
        q.d m4 = eVar.m(d.b.RIGHT);
        int d3 = m3.d();
        int d4 = m4.d();
        if (m3.c() != null && m3.m()) {
            Iterator it = m3.c().iterator();
            while (it.hasNext()) {
                q.d dVar5 = (q.d) it.next();
                q.e eVar2 = dVar5.f12840d;
                int i5 = i3 + 1;
                boolean a3 = a(i5, eVar2);
                if (eVar2.k0() && a3) {
                    q.f.O1(i5, eVar2, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
                }
                boolean z5 = ((dVar5 == eVar2.f12882O && (dVar4 = eVar2.f12884Q.f12842f) != null && dVar4.m()) || (dVar5 == eVar2.f12884Q && (dVar3 = eVar2.f12882O.f12842f) != null && dVar3.m())) ? z4 : false;
                e.b y3 = eVar2.y();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (y3 != bVar || a3) {
                    if (!eVar2.k0()) {
                        q.d dVar6 = eVar2.f12882O;
                        if (dVar5 == dVar6 && eVar2.f12884Q.f12842f == null) {
                            int e3 = dVar6.e() + d3;
                            eVar2.C0(e3, eVar2.U() + e3);
                            b(i5, eVar2, interfaceC0145b, z3);
                        } else {
                            q.d dVar7 = eVar2.f12884Q;
                            if (dVar5 == dVar7 && dVar6.f12842f == null) {
                                int e4 = d3 - dVar7.e();
                                eVar2.C0(e4 - eVar2.U(), e4);
                                b(i5, eVar2, interfaceC0145b, z3);
                            } else if (z5 && !eVar2.g0()) {
                                d(i5, interfaceC0145b, eVar2, z3);
                            }
                        }
                    }
                } else if (eVar2.y() == bVar && eVar2.f12858A >= 0 && eVar2.f12944z >= 0 && ((eVar2.T() == 8 || (eVar2.f12938w == 0 && eVar2.t() == 0.0f)) && !eVar2.g0() && !eVar2.j0() && z5 && !eVar2.g0())) {
                    e(i5, eVar, interfaceC0145b, eVar2, z3);
                }
                z4 = true;
            }
        }
        if (eVar instanceof q.g) {
            return;
        }
        if (m4.c() != null && m4.m()) {
            Iterator it2 = m4.c().iterator();
            while (it2.hasNext()) {
                q.d dVar8 = (q.d) it2.next();
                q.e eVar3 = dVar8.f12840d;
                int i6 = i3 + 1;
                boolean a4 = a(i6, eVar3);
                if (eVar3.k0() && a4) {
                    q.f.O1(i6, eVar3, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
                }
                boolean z6 = (dVar8 == eVar3.f12882O && (dVar2 = eVar3.f12884Q.f12842f) != null && dVar2.m()) || (dVar8 == eVar3.f12884Q && (dVar = eVar3.f12882O.f12842f) != null && dVar.m());
                e.b y4 = eVar3.y();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (y4 != bVar2 || a4) {
                    if (!eVar3.k0()) {
                        q.d dVar9 = eVar3.f12882O;
                        if (dVar8 == dVar9 && eVar3.f12884Q.f12842f == null) {
                            int e5 = dVar9.e() + d4;
                            eVar3.C0(e5, eVar3.U() + e5);
                            b(i6, eVar3, interfaceC0145b, z3);
                        } else {
                            q.d dVar10 = eVar3.f12884Q;
                            if (dVar8 == dVar10 && dVar9.f12842f == null) {
                                int e6 = d4 - dVar10.e();
                                eVar3.C0(e6 - eVar3.U(), e6);
                                b(i6, eVar3, interfaceC0145b, z3);
                            } else if (z6 && !eVar3.g0()) {
                                d(i6, interfaceC0145b, eVar3, z3);
                            }
                        }
                    }
                } else if (eVar3.y() == bVar2 && eVar3.f12858A >= 0 && eVar3.f12944z >= 0 && (eVar3.T() == 8 || (eVar3.f12938w == 0 && eVar3.t() == 0.0f))) {
                    if (!eVar3.g0() && !eVar3.j0() && z6 && !eVar3.g0()) {
                        e(i6, eVar, interfaceC0145b, eVar3, z3);
                    }
                }
            }
        }
        eVar.o0();
    }

    private static void c(int i3, C0512a c0512a, C0558b.InterfaceC0145b interfaceC0145b, int i4, boolean z3) {
        if (c0512a.p1()) {
            if (i4 == 0) {
                b(i3 + 1, c0512a, interfaceC0145b, z3);
            } else {
                i(i3 + 1, c0512a, interfaceC0145b);
            }
        }
    }

    private static void d(int i3, C0558b.InterfaceC0145b interfaceC0145b, q.e eVar, boolean z3) {
        float w3 = eVar.w();
        int d3 = eVar.f12882O.f12842f.d();
        int d4 = eVar.f12884Q.f12842f.d();
        int e3 = eVar.f12882O.e() + d3;
        int e4 = d4 - eVar.f12884Q.e();
        if (d3 == d4) {
            w3 = 0.5f;
        } else {
            d3 = e3;
            d4 = e4;
        }
        int U3 = eVar.U();
        int i4 = (d4 - d3) - U3;
        if (d3 > d4) {
            i4 = (d3 - d4) - U3;
        }
        int i5 = ((int) (i4 > 0 ? (w3 * i4) + 0.5f : w3 * i4)) + d3;
        int i6 = i5 + U3;
        if (d3 > d4) {
            i6 = i5 - U3;
        }
        eVar.C0(i5, i6);
        b(i3 + 1, eVar, interfaceC0145b, z3);
    }

    private static void e(int i3, q.e eVar, C0558b.InterfaceC0145b interfaceC0145b, q.e eVar2, boolean z3) {
        float w3 = eVar2.w();
        int d3 = eVar2.f12882O.f12842f.d() + eVar2.f12882O.e();
        int d4 = eVar2.f12884Q.f12842f.d() - eVar2.f12884Q.e();
        if (d4 >= d3) {
            int U3 = eVar2.U();
            if (eVar2.T() != 8) {
                int i4 = eVar2.f12938w;
                if (i4 == 2) {
                    U3 = (int) (eVar2.w() * 0.5f * (eVar instanceof q.f ? eVar.U() : eVar.I().U()));
                } else if (i4 == 0) {
                    U3 = d4 - d3;
                }
                U3 = Math.max(eVar2.f12944z, U3);
                int i5 = eVar2.f12858A;
                if (i5 > 0) {
                    U3 = Math.min(i5, U3);
                }
            }
            int i6 = d3 + ((int) ((w3 * ((d4 - d3) - U3)) + 0.5f));
            eVar2.C0(i6, U3 + i6);
            b(i3 + 1, eVar2, interfaceC0145b, z3);
        }
    }

    private static void f(int i3, C0558b.InterfaceC0145b interfaceC0145b, q.e eVar) {
        float P3 = eVar.P();
        int d3 = eVar.f12883P.f12842f.d();
        int d4 = eVar.f12885R.f12842f.d();
        int e3 = eVar.f12883P.e() + d3;
        int e4 = d4 - eVar.f12885R.e();
        if (d3 == d4) {
            P3 = 0.5f;
        } else {
            d3 = e3;
            d4 = e4;
        }
        int v3 = eVar.v();
        int i4 = (d4 - d3) - v3;
        if (d3 > d4) {
            i4 = (d3 - d4) - v3;
        }
        int i5 = (int) (i4 > 0 ? (P3 * i4) + 0.5f : P3 * i4);
        int i6 = d3 + i5;
        int i7 = i6 + v3;
        if (d3 > d4) {
            i6 = d3 - i5;
            i7 = i6 - v3;
        }
        eVar.F0(i6, i7);
        i(i3 + 1, eVar, interfaceC0145b);
    }

    private static void g(int i3, q.e eVar, C0558b.InterfaceC0145b interfaceC0145b, q.e eVar2) {
        float P3 = eVar2.P();
        int d3 = eVar2.f12883P.f12842f.d() + eVar2.f12883P.e();
        int d4 = eVar2.f12885R.f12842f.d() - eVar2.f12885R.e();
        if (d4 >= d3) {
            int v3 = eVar2.v();
            if (eVar2.T() != 8) {
                int i4 = eVar2.f12940x;
                if (i4 == 2) {
                    v3 = (int) (P3 * 0.5f * (eVar instanceof q.f ? eVar.v() : eVar.I().v()));
                } else if (i4 == 0) {
                    v3 = d4 - d3;
                }
                v3 = Math.max(eVar2.f12862C, v3);
                int i5 = eVar2.f12864D;
                if (i5 > 0) {
                    v3 = Math.min(i5, v3);
                }
            }
            int i6 = d3 + ((int) ((P3 * ((d4 - d3) - v3)) + 0.5f));
            eVar2.F0(i6, v3 + i6);
            i(i3 + 1, eVar2, interfaceC0145b);
        }
    }

    public static void h(q.f fVar, C0558b.InterfaceC0145b interfaceC0145b) {
        e.b y3 = fVar.y();
        e.b R3 = fVar.R();
        f13102b = 0;
        f13103c = 0;
        fVar.s0();
        ArrayList n12 = fVar.n1();
        int size = n12.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((q.e) n12.get(i3)).s0();
        }
        boolean L12 = fVar.L1();
        if (y3 == e.b.FIXED) {
            fVar.C0(0, fVar.U());
        } else {
            fVar.D0(0);
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            q.e eVar = (q.e) n12.get(i4);
            if (eVar instanceof q.g) {
                q.g gVar = (q.g) eVar;
                if (gVar.o1() == 1) {
                    if (gVar.p1() != -1) {
                        gVar.s1(gVar.p1());
                    } else if (gVar.q1() != -1 && fVar.l0()) {
                        gVar.s1(fVar.U() - gVar.q1());
                    } else if (fVar.l0()) {
                        gVar.s1((int) ((gVar.r1() * fVar.U()) + 0.5f));
                    }
                    z3 = true;
                }
            } else if ((eVar instanceof C0512a) && ((C0512a) eVar).t1() == 0) {
                z4 = true;
            }
        }
        if (z3) {
            for (int i5 = 0; i5 < size; i5++) {
                q.e eVar2 = (q.e) n12.get(i5);
                if (eVar2 instanceof q.g) {
                    q.g gVar2 = (q.g) eVar2;
                    if (gVar2.o1() == 1) {
                        b(0, gVar2, interfaceC0145b, L12);
                    }
                }
            }
        }
        b(0, fVar, interfaceC0145b, L12);
        if (z4) {
            for (int i6 = 0; i6 < size; i6++) {
                q.e eVar3 = (q.e) n12.get(i6);
                if (eVar3 instanceof C0512a) {
                    C0512a c0512a = (C0512a) eVar3;
                    if (c0512a.t1() == 0) {
                        c(0, c0512a, interfaceC0145b, 0, L12);
                    }
                }
            }
        }
        if (R3 == e.b.FIXED) {
            fVar.F0(0, fVar.v());
        } else {
            fVar.E0(0);
        }
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            q.e eVar4 = (q.e) n12.get(i7);
            if (eVar4 instanceof q.g) {
                q.g gVar3 = (q.g) eVar4;
                if (gVar3.o1() == 0) {
                    if (gVar3.p1() != -1) {
                        gVar3.s1(gVar3.p1());
                    } else if (gVar3.q1() != -1 && fVar.m0()) {
                        gVar3.s1(fVar.v() - gVar3.q1());
                    } else if (fVar.m0()) {
                        gVar3.s1((int) ((gVar3.r1() * fVar.v()) + 0.5f));
                    }
                    z5 = true;
                }
            } else if ((eVar4 instanceof C0512a) && ((C0512a) eVar4).t1() == 1) {
                z6 = true;
            }
        }
        if (z5) {
            for (int i8 = 0; i8 < size; i8++) {
                q.e eVar5 = (q.e) n12.get(i8);
                if (eVar5 instanceof q.g) {
                    q.g gVar4 = (q.g) eVar5;
                    if (gVar4.o1() == 0) {
                        i(1, gVar4, interfaceC0145b);
                    }
                }
            }
        }
        i(0, fVar, interfaceC0145b);
        if (z6) {
            for (int i9 = 0; i9 < size; i9++) {
                q.e eVar6 = (q.e) n12.get(i9);
                if (eVar6 instanceof C0512a) {
                    C0512a c0512a2 = (C0512a) eVar6;
                    if (c0512a2.t1() == 1) {
                        c(0, c0512a2, interfaceC0145b, 1, L12);
                    }
                }
            }
        }
        for (int i10 = 0; i10 < size; i10++) {
            q.e eVar7 = (q.e) n12.get(i10);
            if (eVar7.k0() && a(0, eVar7)) {
                q.f.O1(0, eVar7, interfaceC0145b, f13101a, C0558b.a.f13055k);
                if (!(eVar7 instanceof q.g)) {
                    b(0, eVar7, interfaceC0145b, L12);
                    i(0, eVar7, interfaceC0145b);
                } else if (((q.g) eVar7).o1() == 0) {
                    i(0, eVar7, interfaceC0145b);
                } else {
                    b(0, eVar7, interfaceC0145b, L12);
                }
            }
        }
    }

    private static void i(int i3, q.e eVar, C0558b.InterfaceC0145b interfaceC0145b) {
        q.d dVar;
        q.d dVar2;
        q.d dVar3;
        q.d dVar4;
        if (eVar.n0()) {
            return;
        }
        f13103c++;
        if (!(eVar instanceof q.f) && eVar.k0()) {
            int i4 = i3 + 1;
            if (a(i4, eVar)) {
                q.f.O1(i4, eVar, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
            }
        }
        q.d m3 = eVar.m(d.b.TOP);
        q.d m4 = eVar.m(d.b.BOTTOM);
        int d3 = m3.d();
        int d4 = m4.d();
        if (m3.c() != null && m3.m()) {
            Iterator it = m3.c().iterator();
            while (it.hasNext()) {
                q.d dVar5 = (q.d) it.next();
                q.e eVar2 = dVar5.f12840d;
                int i5 = i3 + 1;
                boolean a3 = a(i5, eVar2);
                if (eVar2.k0() && a3) {
                    q.f.O1(i5, eVar2, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
                }
                boolean z3 = (dVar5 == eVar2.f12883P && (dVar4 = eVar2.f12885R.f12842f) != null && dVar4.m()) || (dVar5 == eVar2.f12885R && (dVar3 = eVar2.f12883P.f12842f) != null && dVar3.m());
                e.b R3 = eVar2.R();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (R3 != bVar || a3) {
                    if (!eVar2.k0()) {
                        q.d dVar6 = eVar2.f12883P;
                        if (dVar5 == dVar6 && eVar2.f12885R.f12842f == null) {
                            int e3 = dVar6.e() + d3;
                            eVar2.F0(e3, eVar2.v() + e3);
                            i(i5, eVar2, interfaceC0145b);
                        } else {
                            q.d dVar7 = eVar2.f12885R;
                            if (dVar5 == dVar7 && dVar6.f12842f == null) {
                                int e4 = d3 - dVar7.e();
                                eVar2.F0(e4 - eVar2.v(), e4);
                                i(i5, eVar2, interfaceC0145b);
                            } else if (z3 && !eVar2.i0()) {
                                f(i5, interfaceC0145b, eVar2);
                            }
                        }
                    }
                } else if (eVar2.R() == bVar && eVar2.f12864D >= 0 && eVar2.f12862C >= 0 && (eVar2.T() == 8 || (eVar2.f12940x == 0 && eVar2.t() == 0.0f))) {
                    if (!eVar2.i0() && !eVar2.j0() && z3 && !eVar2.i0()) {
                        g(i5, eVar, interfaceC0145b, eVar2);
                    }
                }
            }
        }
        if (eVar instanceof q.g) {
            return;
        }
        if (m4.c() != null && m4.m()) {
            Iterator it2 = m4.c().iterator();
            while (it2.hasNext()) {
                q.d dVar8 = (q.d) it2.next();
                q.e eVar3 = dVar8.f12840d;
                int i6 = i3 + 1;
                boolean a4 = a(i6, eVar3);
                if (eVar3.k0() && a4) {
                    q.f.O1(i6, eVar3, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
                }
                boolean z4 = (dVar8 == eVar3.f12883P && (dVar2 = eVar3.f12885R.f12842f) != null && dVar2.m()) || (dVar8 == eVar3.f12885R && (dVar = eVar3.f12883P.f12842f) != null && dVar.m());
                e.b R4 = eVar3.R();
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (R4 != bVar2 || a4) {
                    if (!eVar3.k0()) {
                        q.d dVar9 = eVar3.f12883P;
                        if (dVar8 == dVar9 && eVar3.f12885R.f12842f == null) {
                            int e5 = dVar9.e() + d4;
                            eVar3.F0(e5, eVar3.v() + e5);
                            i(i6, eVar3, interfaceC0145b);
                        } else {
                            q.d dVar10 = eVar3.f12885R;
                            if (dVar8 == dVar10 && dVar9.f12842f == null) {
                                int e6 = d4 - dVar10.e();
                                eVar3.F0(e6 - eVar3.v(), e6);
                                i(i6, eVar3, interfaceC0145b);
                            } else if (z4 && !eVar3.i0()) {
                                f(i6, interfaceC0145b, eVar3);
                            }
                        }
                    }
                } else if (eVar3.R() == bVar2 && eVar3.f12864D >= 0 && eVar3.f12862C >= 0 && (eVar3.T() == 8 || (eVar3.f12940x == 0 && eVar3.t() == 0.0f))) {
                    if (!eVar3.i0() && !eVar3.j0() && z4 && !eVar3.i0()) {
                        g(i6, eVar, interfaceC0145b, eVar3);
                    }
                }
            }
        }
        q.d m5 = eVar.m(d.b.BASELINE);
        if (m5.c() != null && m5.m()) {
            int d5 = m5.d();
            Iterator it3 = m5.c().iterator();
            while (it3.hasNext()) {
                q.d dVar11 = (q.d) it3.next();
                q.e eVar4 = dVar11.f12840d;
                int i7 = i3 + 1;
                boolean a5 = a(i7, eVar4);
                if (eVar4.k0() && a5) {
                    q.f.O1(i7, eVar4, interfaceC0145b, new C0558b.a(), C0558b.a.f13055k);
                }
                if (eVar4.R() != e.b.MATCH_CONSTRAINT || a5) {
                    if (!eVar4.k0() && dVar11 == eVar4.f12886S) {
                        eVar4.B0(dVar11.e() + d5);
                        i(i7, eVar4, interfaceC0145b);
                    }
                }
            }
        }
        eVar.p0();
    }
}
