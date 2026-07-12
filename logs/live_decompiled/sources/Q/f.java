package q;

import androidx.appcompat.app.p;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import n.AbstractC0475e;
import n.C0474d;
import n.C0479i;
import q.e;
import r.C0558b;

/* loaded from: classes.dex */
public class f extends k {

    /* renamed from: O0, reason: collision with root package name */
    private int f12955O0;

    /* renamed from: S0, reason: collision with root package name */
    int f12959S0;

    /* renamed from: T0, reason: collision with root package name */
    int f12960T0;

    /* renamed from: U0, reason: collision with root package name */
    int f12961U0;

    /* renamed from: V0, reason: collision with root package name */
    int f12962V0;

    /* renamed from: M0, reason: collision with root package name */
    C0558b f12953M0 = new C0558b(this);

    /* renamed from: N0, reason: collision with root package name */
    public r.e f12954N0 = new r.e(this);

    /* renamed from: P0, reason: collision with root package name */
    protected C0558b.InterfaceC0145b f12956P0 = null;

    /* renamed from: Q0, reason: collision with root package name */
    private boolean f12957Q0 = false;

    /* renamed from: R0, reason: collision with root package name */
    protected C0474d f12958R0 = new C0474d();

    /* renamed from: W0, reason: collision with root package name */
    public int f12963W0 = 0;

    /* renamed from: X0, reason: collision with root package name */
    public int f12964X0 = 0;

    /* renamed from: Y0, reason: collision with root package name */
    C0514c[] f12965Y0 = new C0514c[4];

    /* renamed from: Z0, reason: collision with root package name */
    C0514c[] f12966Z0 = new C0514c[4];

    /* renamed from: a1, reason: collision with root package name */
    public boolean f12967a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    public boolean f12968b1 = false;

    /* renamed from: c1, reason: collision with root package name */
    public boolean f12969c1 = false;

    /* renamed from: d1, reason: collision with root package name */
    public int f12970d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    public int f12971e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    private int f12972f1 = 257;

    /* renamed from: g1, reason: collision with root package name */
    public boolean f12973g1 = false;

    /* renamed from: h1, reason: collision with root package name */
    private boolean f12974h1 = false;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f12975i1 = false;

    /* renamed from: j1, reason: collision with root package name */
    int f12976j1 = 0;

    /* renamed from: k1, reason: collision with root package name */
    private WeakReference f12977k1 = null;

    /* renamed from: l1, reason: collision with root package name */
    private WeakReference f12978l1 = null;

    /* renamed from: m1, reason: collision with root package name */
    private WeakReference f12979m1 = null;

    /* renamed from: n1, reason: collision with root package name */
    private WeakReference f12980n1 = null;

    /* renamed from: o1, reason: collision with root package name */
    HashSet f12981o1 = new HashSet();

    /* renamed from: p1, reason: collision with root package name */
    public C0558b.a f12982p1 = new C0558b.a();

    public static boolean O1(int i3, e eVar, C0558b.InterfaceC0145b interfaceC0145b, C0558b.a aVar, int i4) {
        int i5;
        int i6;
        if (interfaceC0145b == null) {
            return false;
        }
        if (eVar.T() == 8 || (eVar instanceof g) || (eVar instanceof C0512a)) {
            aVar.f13062e = 0;
            aVar.f13063f = 0;
            return false;
        }
        aVar.f13058a = eVar.y();
        aVar.f13059b = eVar.R();
        aVar.f13060c = eVar.U();
        aVar.f13061d = eVar.v();
        aVar.f13066i = false;
        aVar.f13067j = i4;
        e.b bVar = aVar.f13058a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z3 = bVar == bVar2;
        boolean z4 = aVar.f13059b == bVar2;
        boolean z5 = z3 && eVar.f12901d0 > 0.0f;
        boolean z6 = z4 && eVar.f12901d0 > 0.0f;
        if (z3 && eVar.Y(0) && eVar.f12938w == 0 && !z5) {
            aVar.f13058a = e.b.WRAP_CONTENT;
            if (z4 && eVar.f12940x == 0) {
                aVar.f13058a = e.b.FIXED;
            }
            z3 = false;
        }
        if (z4 && eVar.Y(1) && eVar.f12940x == 0 && !z6) {
            aVar.f13059b = e.b.WRAP_CONTENT;
            if (z3 && eVar.f12938w == 0) {
                aVar.f13059b = e.b.FIXED;
            }
            z4 = false;
        }
        if (eVar.l0()) {
            aVar.f13058a = e.b.FIXED;
            z3 = false;
        }
        if (eVar.m0()) {
            aVar.f13059b = e.b.FIXED;
            z4 = false;
        }
        if (z5) {
            if (eVar.f12942y[0] == 4) {
                aVar.f13058a = e.b.FIXED;
            } else if (!z4) {
                e.b bVar3 = aVar.f13059b;
                e.b bVar4 = e.b.FIXED;
                if (bVar3 == bVar4) {
                    i6 = aVar.f13061d;
                } else {
                    aVar.f13058a = e.b.WRAP_CONTENT;
                    interfaceC0145b.a(eVar, aVar);
                    i6 = aVar.f13063f;
                }
                aVar.f13058a = bVar4;
                aVar.f13060c = (int) (eVar.t() * i6);
            }
        }
        if (z6) {
            if (eVar.f12942y[1] == 4) {
                aVar.f13059b = e.b.FIXED;
            } else if (!z3) {
                e.b bVar5 = aVar.f13058a;
                e.b bVar6 = e.b.FIXED;
                if (bVar5 == bVar6) {
                    i5 = aVar.f13060c;
                } else {
                    aVar.f13059b = e.b.WRAP_CONTENT;
                    interfaceC0145b.a(eVar, aVar);
                    i5 = aVar.f13062e;
                }
                aVar.f13059b = bVar6;
                if (eVar.u() == -1) {
                    aVar.f13061d = (int) (i5 / eVar.t());
                } else {
                    aVar.f13061d = (int) (eVar.t() * i5);
                }
            }
        }
        interfaceC0145b.a(eVar, aVar);
        eVar.g1(aVar.f13062e);
        eVar.I0(aVar.f13063f);
        eVar.H0(aVar.f13065h);
        eVar.x0(aVar.f13064g);
        aVar.f13067j = C0558b.a.f13055k;
        return aVar.f13066i;
    }

    private void Q1() {
        this.f12963W0 = 0;
        this.f12964X0 = 0;
    }

    private void t1(e eVar) {
        int i3 = this.f12963W0 + 1;
        C0514c[] c0514cArr = this.f12966Z0;
        if (i3 >= c0514cArr.length) {
            this.f12966Z0 = (C0514c[]) Arrays.copyOf(c0514cArr, c0514cArr.length * 2);
        }
        this.f12966Z0[this.f12963W0] = new C0514c(eVar, 0, L1());
        this.f12963W0++;
    }

    private void w1(d dVar, C0479i c0479i) {
        this.f12958R0.h(c0479i, this.f12958R0.q(dVar), 0, 5);
    }

    private void x1(d dVar, C0479i c0479i) {
        this.f12958R0.h(this.f12958R0.q(dVar), c0479i, 0, 5);
    }

    private void y1(e eVar) {
        int i3 = this.f12964X0 + 1;
        C0514c[] c0514cArr = this.f12965Y0;
        if (i3 >= c0514cArr.length) {
            this.f12965Y0 = (C0514c[]) Arrays.copyOf(c0514cArr, c0514cArr.length * 2);
        }
        this.f12965Y0[this.f12964X0] = new C0514c(eVar, 1, L1());
        this.f12964X0++;
    }

    void A1(d dVar) {
        WeakReference weakReference = this.f12977k1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f12977k1.get()).d()) {
            this.f12977k1 = new WeakReference(dVar);
        }
    }

    public boolean B1(boolean z3) {
        return this.f12954N0.f(z3);
    }

    public boolean C1(boolean z3) {
        return this.f12954N0.g(z3);
    }

    public boolean D1(boolean z3, int i3) {
        return this.f12954N0.h(z3, i3);
    }

    public void E1(AbstractC0475e abstractC0475e) {
        this.f12958R0.v(abstractC0475e);
    }

    public C0558b.InterfaceC0145b F1() {
        return this.f12956P0;
    }

    public int G1() {
        return this.f12972f1;
    }

    public C0474d H1() {
        return this.f12958R0;
    }

    public void I1() {
        this.f12954N0.j();
    }

    public void J1() {
        this.f12954N0.k();
    }

    public boolean K1() {
        return this.f12975i1;
    }

    public boolean L1() {
        return this.f12957Q0;
    }

    @Override // q.e
    public void M(StringBuilder sb) {
        sb.append(this.f12922o + ":{\n");
        sb.append("  actualWidth:" + this.f12897b0);
        sb.append("\n");
        sb.append("  actualHeight:" + this.f12899c0);
        sb.append("\n");
        Iterator it = n1().iterator();
        while (it.hasNext()) {
            ((e) it.next()).M(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public boolean M1() {
        return this.f12974h1;
    }

    public long N1(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.f12959S0 = i10;
        this.f12960T0 = i11;
        return this.f12953M0.d(this, i3, i10, i11, i4, i5, i6, i7, i8, i9);
    }

    public boolean P1(int i3) {
        return (this.f12972f1 & i3) == i3;
    }

    public void R1(C0558b.InterfaceC0145b interfaceC0145b) {
        this.f12956P0 = interfaceC0145b;
        this.f12954N0.n(interfaceC0145b);
    }

    public void S1(int i3) {
        this.f12972f1 = i3;
        C0474d.f12482r = P1(512);
    }

    public void T1(int i3) {
        this.f12955O0 = i3;
    }

    public void U1(boolean z3) {
        this.f12957Q0 = z3;
    }

    public boolean V1(C0474d c0474d, boolean[] zArr) {
        zArr[2] = false;
        boolean P12 = P1(64);
        m1(c0474d, P12);
        int size = this.f12995L0.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) this.f12995L0.get(i3);
            eVar.m1(c0474d, P12);
            if (eVar.a0()) {
                z3 = true;
            }
        }
        return z3;
    }

    public void W1() {
        this.f12953M0.e(this);
    }

    @Override // q.e
    public void l1(boolean z3, boolean z4) {
        super.l1(z3, z4);
        int size = this.f12995L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((e) this.f12995L0.get(i3)).l1(z3, z4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x030c  */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // q.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o1() {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q.f.o1():void");
    }

    @Override // q.k, q.e
    public void r0() {
        this.f12958R0.E();
        this.f12959S0 = 0;
        this.f12961U0 = 0;
        this.f12960T0 = 0;
        this.f12962V0 = 0;
        this.f12973g1 = false;
        super.r0();
    }

    void r1(e eVar, int i3) {
        if (i3 == 0) {
            t1(eVar);
        } else if (i3 == 1) {
            y1(eVar);
        }
    }

    public boolean s1(C0474d c0474d) {
        boolean P12 = P1(64);
        g(c0474d, P12);
        int size = this.f12995L0.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = (e) this.f12995L0.get(i3);
            eVar.P0(0, false);
            eVar.P0(1, false);
            if (eVar instanceof C0512a) {
                z3 = true;
            }
        }
        if (z3) {
            for (int i4 = 0; i4 < size; i4++) {
                e eVar2 = (e) this.f12995L0.get(i4);
                if (eVar2 instanceof C0512a) {
                    ((C0512a) eVar2).u1();
                }
            }
        }
        this.f12981o1.clear();
        for (int i5 = 0; i5 < size; i5++) {
            e eVar3 = (e) this.f12995L0.get(i5);
            if (eVar3.f()) {
                eVar3.g(c0474d, P12);
            }
        }
        while (this.f12981o1.size() > 0) {
            int size2 = this.f12981o1.size();
            Iterator it = this.f12981o1.iterator();
            if (it.hasNext()) {
                p.a((e) it.next());
                throw null;
            }
            if (size2 == this.f12981o1.size()) {
                Iterator it2 = this.f12981o1.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).g(c0474d, P12);
                }
                this.f12981o1.clear();
            }
        }
        if (C0474d.f12482r) {
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < size; i6++) {
                e eVar4 = (e) this.f12995L0.get(i6);
                if (!eVar4.f()) {
                    hashSet.add(eVar4);
                }
            }
            e(this, c0474d, hashSet, y() == e.b.WRAP_CONTENT ? 0 : 1, false);
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                e eVar5 = (e) it3.next();
                j.a(this, c0474d, eVar5);
                eVar5.g(c0474d, P12);
            }
        } else {
            for (int i7 = 0; i7 < size; i7++) {
                e eVar6 = (e) this.f12995L0.get(i7);
                if (eVar6 instanceof f) {
                    e.b[] bVarArr = eVar6.f12893Z;
                    e.b bVar = bVarArr[0];
                    e.b bVar2 = bVarArr[1];
                    e.b bVar3 = e.b.WRAP_CONTENT;
                    if (bVar == bVar3) {
                        eVar6.M0(e.b.FIXED);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.c1(e.b.FIXED);
                    }
                    eVar6.g(c0474d, P12);
                    if (bVar == bVar3) {
                        eVar6.M0(bVar);
                    }
                    if (bVar2 == bVar3) {
                        eVar6.c1(bVar2);
                    }
                } else {
                    j.a(this, c0474d, eVar6);
                    if (!eVar6.f()) {
                        eVar6.g(c0474d, P12);
                    }
                }
            }
        }
        if (this.f12963W0 > 0) {
            AbstractC0513b.b(this, c0474d, null, 0);
        }
        if (this.f12964X0 > 0) {
            AbstractC0513b.b(this, c0474d, null, 1);
        }
        return true;
    }

    public void u1(d dVar) {
        WeakReference weakReference = this.f12980n1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f12980n1.get()).d()) {
            this.f12980n1 = new WeakReference(dVar);
        }
    }

    public void v1(d dVar) {
        WeakReference weakReference = this.f12978l1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f12978l1.get()).d()) {
            this.f12978l1 = new WeakReference(dVar);
        }
    }

    void z1(d dVar) {
        WeakReference weakReference = this.f12979m1;
        if (weakReference == null || weakReference.get() == null || dVar.d() > ((d) this.f12979m1.get()).d()) {
            this.f12979m1 = new WeakReference(dVar);
        }
    }
}
