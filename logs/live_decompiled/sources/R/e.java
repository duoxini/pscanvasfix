package r;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import q.e;
import r.C0558b;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private q.f f13070a;

    /* renamed from: d, reason: collision with root package name */
    private q.f f13073d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f13071b = true;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13072c = true;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList f13074e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private ArrayList f13075f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private C0558b.InterfaceC0145b f13076g = null;

    /* renamed from: h, reason: collision with root package name */
    private C0558b.a f13077h = new C0558b.a();

    /* renamed from: i, reason: collision with root package name */
    ArrayList f13078i = new ArrayList();

    public e(q.f fVar) {
        this.f13070a = fVar;
        this.f13073d = fVar;
    }

    private void a(f fVar, int i3, int i4, f fVar2, ArrayList arrayList, m mVar) {
        p pVar = fVar.f13082d;
        if (pVar.f13134c == null) {
            q.f fVar3 = this.f13070a;
            if (pVar == fVar3.f12902e || pVar == fVar3.f12904f) {
                return;
            }
            if (mVar == null) {
                mVar = new m(pVar, i4);
                arrayList.add(mVar);
            }
            pVar.f13134c = mVar;
            mVar.a(pVar);
            for (d dVar : pVar.f13139h.f13089k) {
                if (dVar instanceof f) {
                    a((f) dVar, i3, 0, fVar2, arrayList, mVar);
                }
            }
            for (d dVar2 : pVar.f13140i.f13089k) {
                if (dVar2 instanceof f) {
                    a((f) dVar2, i3, 1, fVar2, arrayList, mVar);
                }
            }
            if (i3 == 1 && (pVar instanceof n)) {
                for (d dVar3 : ((n) pVar).f13114k.f13089k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i3, 2, fVar2, arrayList, mVar);
                    }
                }
            }
            for (f fVar4 : pVar.f13139h.f13090l) {
                if (fVar4 == fVar2) {
                    mVar.f13108b = true;
                }
                a(fVar4, i3, 0, fVar2, arrayList, mVar);
            }
            for (f fVar5 : pVar.f13140i.f13090l) {
                if (fVar5 == fVar2) {
                    mVar.f13108b = true;
                }
                a(fVar5, i3, 1, fVar2, arrayList, mVar);
            }
            if (i3 == 1 && (pVar instanceof n)) {
                Iterator it = ((n) pVar).f13114k.f13090l.iterator();
                while (it.hasNext()) {
                    a((f) it.next(), i3, 2, fVar2, arrayList, mVar);
                }
            }
        }
    }

    private boolean b(q.f fVar) {
        int i3;
        e.b bVar;
        int i4;
        e.b bVar2;
        e.b bVar3;
        e.b bVar4;
        Iterator it = fVar.f12995L0.iterator();
        while (it.hasNext()) {
            q.e eVar = (q.e) it.next();
            e.b[] bVarArr = eVar.f12893Z;
            e.b bVar5 = bVarArr[0];
            e.b bVar6 = bVarArr[1];
            if (eVar.T() == 8) {
                eVar.f12894a = true;
            } else {
                if (eVar.f12860B < 1.0f && bVar5 == e.b.MATCH_CONSTRAINT) {
                    eVar.f12938w = 2;
                }
                if (eVar.f12866E < 1.0f && bVar6 == e.b.MATCH_CONSTRAINT) {
                    eVar.f12940x = 2;
                }
                if (eVar.t() > 0.0f) {
                    e.b bVar7 = e.b.MATCH_CONSTRAINT;
                    if (bVar5 == bVar7 && (bVar6 == e.b.WRAP_CONTENT || bVar6 == e.b.FIXED)) {
                        eVar.f12938w = 3;
                    } else if (bVar6 == bVar7 && (bVar5 == e.b.WRAP_CONTENT || bVar5 == e.b.FIXED)) {
                        eVar.f12940x = 3;
                    } else if (bVar5 == bVar7 && bVar6 == bVar7) {
                        if (eVar.f12938w == 0) {
                            eVar.f12938w = 3;
                        }
                        if (eVar.f12940x == 0) {
                            eVar.f12940x = 3;
                        }
                    }
                }
                e.b bVar8 = e.b.MATCH_CONSTRAINT;
                if (bVar5 == bVar8 && eVar.f12938w == 1 && (eVar.f12882O.f12842f == null || eVar.f12884Q.f12842f == null)) {
                    bVar5 = e.b.WRAP_CONTENT;
                }
                e.b bVar9 = bVar5;
                if (bVar6 == bVar8 && eVar.f12940x == 1 && (eVar.f12883P.f12842f == null || eVar.f12885R.f12842f == null)) {
                    bVar6 = e.b.WRAP_CONTENT;
                }
                e.b bVar10 = bVar6;
                l lVar = eVar.f12902e;
                lVar.f13135d = bVar9;
                int i5 = eVar.f12938w;
                lVar.f13132a = i5;
                n nVar = eVar.f12904f;
                nVar.f13135d = bVar10;
                int i6 = eVar.f12940x;
                nVar.f13132a = i6;
                e.b bVar11 = e.b.MATCH_PARENT;
                if ((bVar9 == bVar11 || bVar9 == e.b.FIXED || bVar9 == e.b.WRAP_CONTENT) && (bVar10 == bVar11 || bVar10 == e.b.FIXED || bVar10 == e.b.WRAP_CONTENT)) {
                    int U3 = eVar.U();
                    if (bVar9 == bVar11) {
                        i3 = (fVar.U() - eVar.f12882O.f12843g) - eVar.f12884Q.f12843g;
                        bVar = e.b.FIXED;
                    } else {
                        i3 = U3;
                        bVar = bVar9;
                    }
                    int v3 = eVar.v();
                    if (bVar10 == bVar11) {
                        i4 = (fVar.v() - eVar.f12883P.f12843g) - eVar.f12885R.f12843g;
                        bVar2 = e.b.FIXED;
                    } else {
                        i4 = v3;
                        bVar2 = bVar10;
                    }
                    l(eVar, bVar, i3, bVar2, i4);
                    eVar.f12902e.f13136e.d(eVar.U());
                    eVar.f12904f.f13136e.d(eVar.v());
                    eVar.f12894a = true;
                } else {
                    if (bVar9 == bVar8 && (bVar10 == (bVar4 = e.b.WRAP_CONTENT) || bVar10 == e.b.FIXED)) {
                        if (i5 == 3) {
                            if (bVar10 == bVar4) {
                                l(eVar, bVar4, 0, bVar4, 0);
                            }
                            int v4 = eVar.v();
                            int i7 = (int) ((v4 * eVar.f12901d0) + 0.5f);
                            e.b bVar12 = e.b.FIXED;
                            l(eVar, bVar12, i7, bVar12, v4);
                            eVar.f12902e.f13136e.d(eVar.U());
                            eVar.f12904f.f13136e.d(eVar.v());
                            eVar.f12894a = true;
                        } else if (i5 == 1) {
                            l(eVar, bVar4, 0, bVar10, 0);
                            eVar.f12902e.f13136e.f13100m = eVar.U();
                        } else if (i5 == 2) {
                            e.b bVar13 = fVar.f12893Z[0];
                            e.b bVar14 = e.b.FIXED;
                            if (bVar13 == bVar14 || bVar13 == bVar11) {
                                l(eVar, bVar14, (int) ((eVar.f12860B * fVar.U()) + 0.5f), bVar10, eVar.v());
                                eVar.f12902e.f13136e.d(eVar.U());
                                eVar.f12904f.f13136e.d(eVar.v());
                                eVar.f12894a = true;
                            }
                        } else {
                            q.d[] dVarArr = eVar.f12890W;
                            if (dVarArr[0].f12842f == null || dVarArr[1].f12842f == null) {
                                l(eVar, bVar4, 0, bVar10, 0);
                                eVar.f12902e.f13136e.d(eVar.U());
                                eVar.f12904f.f13136e.d(eVar.v());
                                eVar.f12894a = true;
                            }
                        }
                    }
                    if (bVar10 == bVar8 && (bVar9 == (bVar3 = e.b.WRAP_CONTENT) || bVar9 == e.b.FIXED)) {
                        if (i6 == 3) {
                            if (bVar9 == bVar3) {
                                l(eVar, bVar3, 0, bVar3, 0);
                            }
                            int U4 = eVar.U();
                            float f3 = eVar.f12901d0;
                            if (eVar.u() == -1) {
                                f3 = 1.0f / f3;
                            }
                            e.b bVar15 = e.b.FIXED;
                            l(eVar, bVar15, U4, bVar15, (int) ((U4 * f3) + 0.5f));
                            eVar.f12902e.f13136e.d(eVar.U());
                            eVar.f12904f.f13136e.d(eVar.v());
                            eVar.f12894a = true;
                        } else if (i6 == 1) {
                            l(eVar, bVar9, 0, bVar3, 0);
                            eVar.f12904f.f13136e.f13100m = eVar.v();
                        } else if (i6 == 2) {
                            e.b bVar16 = fVar.f12893Z[1];
                            e.b bVar17 = e.b.FIXED;
                            if (bVar16 == bVar17 || bVar16 == bVar11) {
                                l(eVar, bVar9, eVar.U(), bVar17, (int) ((eVar.f12866E * fVar.v()) + 0.5f));
                                eVar.f12902e.f13136e.d(eVar.U());
                                eVar.f12904f.f13136e.d(eVar.v());
                                eVar.f12894a = true;
                            }
                        } else {
                            q.d[] dVarArr2 = eVar.f12890W;
                            if (dVarArr2[2].f12842f == null || dVarArr2[3].f12842f == null) {
                                l(eVar, bVar3, 0, bVar10, 0);
                                eVar.f12902e.f13136e.d(eVar.U());
                                eVar.f12904f.f13136e.d(eVar.v());
                                eVar.f12894a = true;
                            }
                        }
                    }
                    if (bVar9 == bVar8 && bVar10 == bVar8) {
                        if (i5 == 1 || i6 == 1) {
                            e.b bVar18 = e.b.WRAP_CONTENT;
                            l(eVar, bVar18, 0, bVar18, 0);
                            eVar.f12902e.f13136e.f13100m = eVar.U();
                            eVar.f12904f.f13136e.f13100m = eVar.v();
                        } else if (i6 == 2 && i5 == 2) {
                            e.b[] bVarArr2 = fVar.f12893Z;
                            e.b bVar19 = bVarArr2[0];
                            e.b bVar20 = e.b.FIXED;
                            if (bVar19 == bVar20 && bVarArr2[1] == bVar20) {
                                l(eVar, bVar20, (int) ((eVar.f12860B * fVar.U()) + 0.5f), bVar20, (int) ((eVar.f12866E * fVar.v()) + 0.5f));
                                eVar.f12902e.f13136e.d(eVar.U());
                                eVar.f12904f.f13136e.d(eVar.v());
                                eVar.f12894a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(q.f fVar, int i3) {
        int size = this.f13078i.size();
        long j3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            j3 = Math.max(j3, ((m) this.f13078i.get(i4)).b(fVar, i3));
        }
        return (int) j3;
    }

    private void i(p pVar, int i3, ArrayList arrayList) {
        for (d dVar : pVar.f13139h.f13089k) {
            if (dVar instanceof f) {
                a((f) dVar, i3, 0, pVar.f13140i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f13139h, i3, 0, pVar.f13140i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f13140i.f13089k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i3, 1, pVar.f13139h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f13140i, i3, 1, pVar.f13139h, arrayList, null);
            }
        }
        if (i3 == 1) {
            for (d dVar3 : ((n) pVar).f13114k.f13089k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i3, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(q.e eVar, e.b bVar, int i3, e.b bVar2, int i4) {
        C0558b.a aVar = this.f13077h;
        aVar.f13058a = bVar;
        aVar.f13059b = bVar2;
        aVar.f13060c = i3;
        aVar.f13061d = i4;
        this.f13076g.a(eVar, aVar);
        eVar.g1(this.f13077h.f13062e);
        eVar.I0(this.f13077h.f13063f);
        eVar.H0(this.f13077h.f13065h);
        eVar.x0(this.f13077h.f13064g);
    }

    public void c() {
        d(this.f13074e);
        this.f13078i.clear();
        m.f13106h = 0;
        i(this.f13070a.f12902e, 0, this.f13078i);
        i(this.f13070a.f12904f, 1, this.f13078i);
        this.f13071b = false;
    }

    public void d(ArrayList arrayList) {
        arrayList.clear();
        this.f13073d.f12902e.f();
        this.f13073d.f12904f.f();
        arrayList.add(this.f13073d.f12902e);
        arrayList.add(this.f13073d.f12904f);
        Iterator it = this.f13073d.f12995L0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            q.e eVar = (q.e) it.next();
            if (eVar instanceof q.g) {
                arrayList.add(new j(eVar));
            } else {
                if (eVar.g0()) {
                    if (eVar.f12898c == null) {
                        eVar.f12898c = new c(eVar, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f12898c);
                } else {
                    arrayList.add(eVar.f12902e);
                }
                if (eVar.i0()) {
                    if (eVar.f12900d == null) {
                        eVar.f12900d = new c(eVar, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(eVar.f12900d);
                } else {
                    arrayList.add(eVar.f12904f);
                }
                if (eVar instanceof q.i) {
                    arrayList.add(new k(eVar));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((p) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p pVar = (p) it3.next();
            if (pVar.f13133b != this.f13073d) {
                pVar.d();
            }
        }
    }

    public boolean f(boolean z3) {
        boolean z4;
        boolean z5 = false;
        if (this.f13071b || this.f13072c) {
            Iterator it = this.f13070a.f12995L0.iterator();
            while (it.hasNext()) {
                q.e eVar = (q.e) it.next();
                eVar.l();
                eVar.f12894a = false;
                eVar.f12902e.r();
                eVar.f12904f.q();
            }
            this.f13070a.l();
            q.f fVar = this.f13070a;
            fVar.f12894a = false;
            fVar.f12902e.r();
            this.f13070a.f12904f.q();
            this.f13072c = false;
        }
        if (b(this.f13073d)) {
            return false;
        }
        this.f13070a.i1(0);
        this.f13070a.j1(0);
        e.b s3 = this.f13070a.s(0);
        e.b s4 = this.f13070a.s(1);
        if (this.f13071b) {
            c();
        }
        int V3 = this.f13070a.V();
        int W3 = this.f13070a.W();
        this.f13070a.f12902e.f13139h.d(V3);
        this.f13070a.f12904f.f13139h.d(W3);
        m();
        e.b bVar = e.b.WRAP_CONTENT;
        if (s3 == bVar || s4 == bVar) {
            if (z3) {
                Iterator it2 = this.f13074e.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((p) it2.next()).m()) {
                        z3 = false;
                        break;
                    }
                }
            }
            if (z3 && s3 == e.b.WRAP_CONTENT) {
                this.f13070a.M0(e.b.FIXED);
                q.f fVar2 = this.f13070a;
                fVar2.g1(e(fVar2, 0));
                q.f fVar3 = this.f13070a;
                fVar3.f12902e.f13136e.d(fVar3.U());
            }
            if (z3 && s4 == e.b.WRAP_CONTENT) {
                this.f13070a.c1(e.b.FIXED);
                q.f fVar4 = this.f13070a;
                fVar4.I0(e(fVar4, 1));
                q.f fVar5 = this.f13070a;
                fVar5.f12904f.f13136e.d(fVar5.v());
            }
        }
        q.f fVar6 = this.f13070a;
        e.b bVar2 = fVar6.f12893Z[0];
        e.b bVar3 = e.b.FIXED;
        if (bVar2 == bVar3 || bVar2 == e.b.MATCH_PARENT) {
            int U3 = fVar6.U() + V3;
            this.f13070a.f12902e.f13140i.d(U3);
            this.f13070a.f12902e.f13136e.d(U3 - V3);
            m();
            q.f fVar7 = this.f13070a;
            e.b bVar4 = fVar7.f12893Z[1];
            if (bVar4 == bVar3 || bVar4 == e.b.MATCH_PARENT) {
                int v3 = fVar7.v() + W3;
                this.f13070a.f12904f.f13140i.d(v3);
                this.f13070a.f12904f.f13136e.d(v3 - W3);
            }
            m();
            z4 = true;
        } else {
            z4 = false;
        }
        Iterator it3 = this.f13074e.iterator();
        while (it3.hasNext()) {
            p pVar = (p) it3.next();
            if (pVar.f13133b != this.f13070a || pVar.f13138g) {
                pVar.e();
            }
        }
        Iterator it4 = this.f13074e.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z5 = true;
                break;
            }
            p pVar2 = (p) it4.next();
            if (z4 || pVar2.f13133b != this.f13070a) {
                if (!pVar2.f13139h.f13088j) {
                    break;
                }
                if (!pVar2.f13140i.f13088j) {
                    if (!(pVar2 instanceof j)) {
                        break;
                    }
                }
                if (!pVar2.f13136e.f13088j && !(pVar2 instanceof c) && !(pVar2 instanceof j)) {
                    break;
                }
            }
        }
        this.f13070a.M0(s3);
        this.f13070a.c1(s4);
        return z5;
    }

    public boolean g(boolean z3) {
        if (this.f13071b) {
            Iterator it = this.f13070a.f12995L0.iterator();
            while (it.hasNext()) {
                q.e eVar = (q.e) it.next();
                eVar.l();
                eVar.f12894a = false;
                l lVar = eVar.f12902e;
                lVar.f13136e.f13088j = false;
                lVar.f13138g = false;
                lVar.r();
                n nVar = eVar.f12904f;
                nVar.f13136e.f13088j = false;
                nVar.f13138g = false;
                nVar.q();
            }
            this.f13070a.l();
            q.f fVar = this.f13070a;
            fVar.f12894a = false;
            l lVar2 = fVar.f12902e;
            lVar2.f13136e.f13088j = false;
            lVar2.f13138g = false;
            lVar2.r();
            n nVar2 = this.f13070a.f12904f;
            nVar2.f13136e.f13088j = false;
            nVar2.f13138g = false;
            nVar2.q();
            c();
        }
        if (b(this.f13073d)) {
            return false;
        }
        this.f13070a.i1(0);
        this.f13070a.j1(0);
        this.f13070a.f12902e.f13139h.d(0);
        this.f13070a.f12904f.f13139h.d(0);
        return true;
    }

    public boolean h(boolean z3, int i3) {
        boolean z4;
        e.b bVar;
        boolean z5 = false;
        e.b s3 = this.f13070a.s(0);
        e.b s4 = this.f13070a.s(1);
        int V3 = this.f13070a.V();
        int W3 = this.f13070a.W();
        if (z3 && (s3 == (bVar = e.b.WRAP_CONTENT) || s4 == bVar)) {
            Iterator it = this.f13074e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p pVar = (p) it.next();
                if (pVar.f13137f == i3 && !pVar.m()) {
                    z3 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z3 && s3 == e.b.WRAP_CONTENT) {
                    this.f13070a.M0(e.b.FIXED);
                    q.f fVar = this.f13070a;
                    fVar.g1(e(fVar, 0));
                    q.f fVar2 = this.f13070a;
                    fVar2.f12902e.f13136e.d(fVar2.U());
                }
            } else if (z3 && s4 == e.b.WRAP_CONTENT) {
                this.f13070a.c1(e.b.FIXED);
                q.f fVar3 = this.f13070a;
                fVar3.I0(e(fVar3, 1));
                q.f fVar4 = this.f13070a;
                fVar4.f12904f.f13136e.d(fVar4.v());
            }
        }
        if (i3 == 0) {
            q.f fVar5 = this.f13070a;
            e.b bVar2 = fVar5.f12893Z[0];
            if (bVar2 == e.b.FIXED || bVar2 == e.b.MATCH_PARENT) {
                int U3 = fVar5.U() + V3;
                this.f13070a.f12902e.f13140i.d(U3);
                this.f13070a.f12902e.f13136e.d(U3 - V3);
                z4 = true;
            }
            z4 = false;
        } else {
            q.f fVar6 = this.f13070a;
            e.b bVar3 = fVar6.f12893Z[1];
            if (bVar3 == e.b.FIXED || bVar3 == e.b.MATCH_PARENT) {
                int v3 = fVar6.v() + W3;
                this.f13070a.f12904f.f13140i.d(v3);
                this.f13070a.f12904f.f13136e.d(v3 - W3);
                z4 = true;
            }
            z4 = false;
        }
        m();
        Iterator it2 = this.f13074e.iterator();
        while (it2.hasNext()) {
            p pVar2 = (p) it2.next();
            if (pVar2.f13137f == i3 && (pVar2.f13133b != this.f13070a || pVar2.f13138g)) {
                pVar2.e();
            }
        }
        Iterator it3 = this.f13074e.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z5 = true;
                break;
            }
            p pVar3 = (p) it3.next();
            if (pVar3.f13137f == i3 && (z4 || pVar3.f13133b != this.f13070a)) {
                if (!pVar3.f13139h.f13088j) {
                    break;
                }
                if (!pVar3.f13140i.f13088j) {
                    break;
                }
                if (!(pVar3 instanceof c) && !pVar3.f13136e.f13088j) {
                    break;
                }
            }
        }
        this.f13070a.M0(s3);
        this.f13070a.c1(s4);
        return z5;
    }

    public void j() {
        this.f13071b = true;
    }

    public void k() {
        this.f13072c = true;
    }

    public void m() {
        g gVar;
        Iterator it = this.f13070a.f12995L0.iterator();
        while (it.hasNext()) {
            q.e eVar = (q.e) it.next();
            if (!eVar.f12894a) {
                e.b[] bVarArr = eVar.f12893Z;
                boolean z3 = false;
                e.b bVar = bVarArr[0];
                e.b bVar2 = bVarArr[1];
                int i3 = eVar.f12938w;
                int i4 = eVar.f12940x;
                e.b bVar3 = e.b.WRAP_CONTENT;
                boolean z4 = bVar == bVar3 || (bVar == e.b.MATCH_CONSTRAINT && i3 == 1);
                if (bVar2 == bVar3 || (bVar2 == e.b.MATCH_CONSTRAINT && i4 == 1)) {
                    z3 = true;
                }
                g gVar2 = eVar.f12902e.f13136e;
                boolean z5 = gVar2.f13088j;
                g gVar3 = eVar.f12904f.f13136e;
                boolean z6 = gVar3.f13088j;
                if (z5 && z6) {
                    e.b bVar4 = e.b.FIXED;
                    l(eVar, bVar4, gVar2.f13085g, bVar4, gVar3.f13085g);
                    eVar.f12894a = true;
                } else if (z5 && z3) {
                    l(eVar, e.b.FIXED, gVar2.f13085g, bVar3, gVar3.f13085g);
                    if (bVar2 == e.b.MATCH_CONSTRAINT) {
                        eVar.f12904f.f13136e.f13100m = eVar.v();
                    } else {
                        eVar.f12904f.f13136e.d(eVar.v());
                        eVar.f12894a = true;
                    }
                } else if (z6 && z4) {
                    l(eVar, bVar3, gVar2.f13085g, e.b.FIXED, gVar3.f13085g);
                    if (bVar == e.b.MATCH_CONSTRAINT) {
                        eVar.f12902e.f13136e.f13100m = eVar.U();
                    } else {
                        eVar.f12902e.f13136e.d(eVar.U());
                        eVar.f12894a = true;
                    }
                }
                if (eVar.f12894a && (gVar = eVar.f12904f.f13115l) != null) {
                    gVar.d(eVar.n());
                }
            }
        }
    }

    public void n(C0558b.InterfaceC0145b interfaceC0145b) {
        this.f13076g = interfaceC0145b;
    }
}
