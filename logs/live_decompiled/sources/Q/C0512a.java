package q;

import n.C0474d;
import n.C0479i;
import q.d;
import q.e;

/* renamed from: q.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0512a extends i {

    /* renamed from: N0, reason: collision with root package name */
    private int f12811N0 = 0;

    /* renamed from: O0, reason: collision with root package name */
    private boolean f12812O0 = true;

    /* renamed from: P0, reason: collision with root package name */
    private int f12813P0 = 0;

    /* renamed from: Q0, reason: collision with root package name */
    boolean f12814Q0 = false;

    @Override // q.e
    public void g(C0474d c0474d, boolean z3) {
        d[] dVarArr;
        boolean z4;
        int i3;
        int i4;
        int i5;
        d[] dVarArr2 = this.f12890W;
        dVarArr2[0] = this.f12882O;
        dVarArr2[2] = this.f12883P;
        dVarArr2[1] = this.f12884Q;
        dVarArr2[3] = this.f12885R;
        int i6 = 0;
        while (true) {
            dVarArr = this.f12890W;
            if (i6 >= dVarArr.length) {
                break;
            }
            d dVar = dVarArr[i6];
            dVar.f12845i = c0474d.q(dVar);
            i6++;
        }
        int i7 = this.f12811N0;
        if (i7 < 0 || i7 >= 4) {
            return;
        }
        d dVar2 = dVarArr[i7];
        if (!this.f12814Q0) {
            p1();
        }
        if (this.f12814Q0) {
            this.f12814Q0 = false;
            int i8 = this.f12811N0;
            if (i8 == 0 || i8 == 1) {
                c0474d.f(this.f12882O.f12845i, this.f12905f0);
                c0474d.f(this.f12884Q.f12845i, this.f12905f0);
                return;
            } else {
                if (i8 == 2 || i8 == 3) {
                    c0474d.f(this.f12883P.f12845i, this.f12907g0);
                    c0474d.f(this.f12885R.f12845i, this.f12907g0);
                    return;
                }
                return;
            }
        }
        for (int i9 = 0; i9 < this.f12993M0; i9++) {
            e eVar = this.f12992L0[i9];
            if ((this.f12812O0 || eVar.h()) && ((((i4 = this.f12811N0) == 0 || i4 == 1) && eVar.y() == e.b.MATCH_CONSTRAINT && eVar.f12882O.f12842f != null && eVar.f12884Q.f12842f != null) || (((i5 = this.f12811N0) == 2 || i5 == 3) && eVar.R() == e.b.MATCH_CONSTRAINT && eVar.f12883P.f12842f != null && eVar.f12885R.f12842f != null))) {
                z4 = true;
                break;
            }
        }
        z4 = false;
        boolean z5 = this.f12882O.k() || this.f12884Q.k();
        boolean z6 = this.f12883P.k() || this.f12885R.k();
        int i10 = !(!z4 && (((i3 = this.f12811N0) == 0 && z5) || ((i3 == 2 && z6) || ((i3 == 1 && z5) || (i3 == 3 && z6))))) ? 4 : 5;
        for (int i11 = 0; i11 < this.f12993M0; i11++) {
            e eVar2 = this.f12992L0[i11];
            if (this.f12812O0 || eVar2.h()) {
                C0479i q3 = c0474d.q(eVar2.f12890W[this.f12811N0]);
                d[] dVarArr3 = eVar2.f12890W;
                int i12 = this.f12811N0;
                d dVar3 = dVarArr3[i12];
                dVar3.f12845i = q3;
                d dVar4 = dVar3.f12842f;
                int i13 = (dVar4 == null || dVar4.f12840d != this) ? 0 : dVar3.f12843g;
                if (i12 == 0 || i12 == 2) {
                    c0474d.i(dVar2.f12845i, q3, this.f12813P0 - i13, z4);
                } else {
                    c0474d.g(dVar2.f12845i, q3, this.f12813P0 + i13, z4);
                }
                c0474d.e(dVar2.f12845i, q3, this.f12813P0 + i13, i10);
            }
        }
        int i14 = this.f12811N0;
        if (i14 == 0) {
            c0474d.e(this.f12884Q.f12845i, this.f12882O.f12845i, 0, 8);
            c0474d.e(this.f12882O.f12845i, this.f12895a0.f12884Q.f12845i, 0, 4);
            c0474d.e(this.f12882O.f12845i, this.f12895a0.f12882O.f12845i, 0, 0);
            return;
        }
        if (i14 == 1) {
            c0474d.e(this.f12882O.f12845i, this.f12884Q.f12845i, 0, 8);
            c0474d.e(this.f12882O.f12845i, this.f12895a0.f12882O.f12845i, 0, 4);
            c0474d.e(this.f12882O.f12845i, this.f12895a0.f12884Q.f12845i, 0, 0);
        } else if (i14 == 2) {
            c0474d.e(this.f12885R.f12845i, this.f12883P.f12845i, 0, 8);
            c0474d.e(this.f12883P.f12845i, this.f12895a0.f12885R.f12845i, 0, 4);
            c0474d.e(this.f12883P.f12845i, this.f12895a0.f12883P.f12845i, 0, 0);
        } else if (i14 == 3) {
            c0474d.e(this.f12883P.f12845i, this.f12885R.f12845i, 0, 8);
            c0474d.e(this.f12883P.f12845i, this.f12895a0.f12883P.f12845i, 0, 4);
            c0474d.e(this.f12883P.f12845i, this.f12895a0.f12885R.f12845i, 0, 0);
        }
    }

    @Override // q.e
    public boolean h() {
        return true;
    }

    @Override // q.e
    public boolean l0() {
        return this.f12814Q0;
    }

    @Override // q.e
    public boolean m0() {
        return this.f12814Q0;
    }

    public boolean p1() {
        int i3;
        int i4;
        int i5;
        boolean z3 = true;
        int i6 = 0;
        while (true) {
            i3 = this.f12993M0;
            if (i6 >= i3) {
                break;
            }
            e eVar = this.f12992L0[i6];
            if ((this.f12812O0 || eVar.h()) && ((((i4 = this.f12811N0) == 0 || i4 == 1) && !eVar.l0()) || (((i5 = this.f12811N0) == 2 || i5 == 3) && !eVar.m0()))) {
                z3 = false;
            }
            i6++;
        }
        if (!z3 || i3 <= 0) {
            return false;
        }
        int i7 = 0;
        boolean z4 = false;
        for (int i8 = 0; i8 < this.f12993M0; i8++) {
            e eVar2 = this.f12992L0[i8];
            if (this.f12812O0 || eVar2.h()) {
                if (!z4) {
                    int i9 = this.f12811N0;
                    if (i9 == 0) {
                        i7 = eVar2.m(d.b.LEFT).d();
                    } else if (i9 == 1) {
                        i7 = eVar2.m(d.b.RIGHT).d();
                    } else if (i9 == 2) {
                        i7 = eVar2.m(d.b.TOP).d();
                    } else if (i9 == 3) {
                        i7 = eVar2.m(d.b.BOTTOM).d();
                    }
                    z4 = true;
                }
                int i10 = this.f12811N0;
                if (i10 == 0) {
                    i7 = Math.min(i7, eVar2.m(d.b.LEFT).d());
                } else if (i10 == 1) {
                    i7 = Math.max(i7, eVar2.m(d.b.RIGHT).d());
                } else if (i10 == 2) {
                    i7 = Math.min(i7, eVar2.m(d.b.TOP).d());
                } else if (i10 == 3) {
                    i7 = Math.max(i7, eVar2.m(d.b.BOTTOM).d());
                }
            }
        }
        int i11 = i7 + this.f12813P0;
        int i12 = this.f12811N0;
        if (i12 == 0 || i12 == 1) {
            C0(i11, i11);
        } else {
            F0(i11, i11);
        }
        this.f12814Q0 = true;
        return true;
    }

    public boolean q1() {
        return this.f12812O0;
    }

    public int r1() {
        return this.f12811N0;
    }

    public int s1() {
        return this.f12813P0;
    }

    public int t1() {
        int i3 = this.f12811N0;
        if (i3 == 0 || i3 == 1) {
            return 0;
        }
        return (i3 == 2 || i3 == 3) ? 1 : -1;
    }

    @Override // q.e
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i3 = 0; i3 < this.f12993M0; i3++) {
            e eVar = this.f12992L0[i3];
            if (i3 > 0) {
                str = str + ", ";
            }
            str = str + eVar.r();
        }
        return str + "}";
    }

    protected void u1() {
        for (int i3 = 0; i3 < this.f12993M0; i3++) {
            e eVar = this.f12992L0[i3];
            if (this.f12812O0 || eVar.h()) {
                int i4 = this.f12811N0;
                if (i4 == 0 || i4 == 1) {
                    eVar.P0(0, true);
                } else if (i4 == 2 || i4 == 3) {
                    eVar.P0(1, true);
                }
            }
        }
    }

    public void v1(boolean z3) {
        this.f12812O0 = z3;
    }

    public void w1(int i3) {
        this.f12811N0 = i3;
    }

    public void x1(int i3) {
        this.f12813P0 = i3;
    }
}
