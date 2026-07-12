package q;

import n.C0474d;
import n.C0479i;
import q.d;
import q.e;

/* loaded from: classes.dex */
public class g extends e {

    /* renamed from: L0, reason: collision with root package name */
    protected float f12983L0 = -1.0f;

    /* renamed from: M0, reason: collision with root package name */
    protected int f12984M0 = -1;

    /* renamed from: N0, reason: collision with root package name */
    protected int f12985N0 = -1;

    /* renamed from: O0, reason: collision with root package name */
    protected boolean f12986O0 = true;

    /* renamed from: P0, reason: collision with root package name */
    private d f12987P0 = this.f12883P;

    /* renamed from: Q0, reason: collision with root package name */
    private int f12988Q0 = 0;

    /* renamed from: R0, reason: collision with root package name */
    private int f12989R0 = 0;

    /* renamed from: S0, reason: collision with root package name */
    private boolean f12990S0;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12991a;

        static {
            int[] iArr = new int[d.b.values().length];
            f12991a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12991a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12991a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12991a[d.b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12991a[d.b.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12991a[d.b.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12991a[d.b.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12991a[d.b.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f12991a[d.b.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public g() {
        this.f12891X.clear();
        this.f12891X.add(this.f12987P0);
        int length = this.f12890W.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f12890W[i3] = this.f12987P0;
        }
    }

    @Override // q.e
    public void g(C0474d c0474d, boolean z3) {
        f fVar = (f) I();
        if (fVar == null) {
            return;
        }
        d m3 = fVar.m(d.b.LEFT);
        d m4 = fVar.m(d.b.RIGHT);
        e eVar = this.f12895a0;
        boolean z4 = eVar != null && eVar.f12893Z[0] == e.b.WRAP_CONTENT;
        if (this.f12988Q0 == 0) {
            m3 = fVar.m(d.b.TOP);
            m4 = fVar.m(d.b.BOTTOM);
            e eVar2 = this.f12895a0;
            z4 = eVar2 != null && eVar2.f12893Z[1] == e.b.WRAP_CONTENT;
        }
        if (this.f12990S0 && this.f12987P0.m()) {
            C0479i q3 = c0474d.q(this.f12987P0);
            c0474d.f(q3, this.f12987P0.d());
            if (this.f12984M0 != -1) {
                if (z4) {
                    c0474d.h(c0474d.q(m4), q3, 0, 5);
                }
            } else if (this.f12985N0 != -1 && z4) {
                C0479i q4 = c0474d.q(m4);
                c0474d.h(q3, c0474d.q(m3), 0, 5);
                c0474d.h(q4, q3, 0, 5);
            }
            this.f12990S0 = false;
            return;
        }
        if (this.f12984M0 != -1) {
            C0479i q5 = c0474d.q(this.f12987P0);
            c0474d.e(q5, c0474d.q(m3), this.f12984M0, 8);
            if (z4) {
                c0474d.h(c0474d.q(m4), q5, 0, 5);
                return;
            }
            return;
        }
        if (this.f12985N0 == -1) {
            if (this.f12983L0 != -1.0f) {
                c0474d.d(C0474d.s(c0474d, c0474d.q(this.f12987P0), c0474d.q(m4), this.f12983L0));
                return;
            }
            return;
        }
        C0479i q6 = c0474d.q(this.f12987P0);
        C0479i q7 = c0474d.q(m4);
        c0474d.e(q6, q7, -this.f12985N0, 8);
        if (z4) {
            c0474d.h(q6, c0474d.q(m3), 0, 5);
            c0474d.h(q7, q6, 0, 5);
        }
    }

    @Override // q.e
    public boolean h() {
        return true;
    }

    @Override // q.e
    public boolean l0() {
        return this.f12990S0;
    }

    @Override // q.e
    public d m(d.b bVar) {
        int i3 = a.f12991a[bVar.ordinal()];
        if (i3 == 1 || i3 == 2) {
            if (this.f12988Q0 == 1) {
                return this.f12987P0;
            }
            return null;
        }
        if ((i3 == 3 || i3 == 4) && this.f12988Q0 == 0) {
            return this.f12987P0;
        }
        return null;
    }

    @Override // q.e
    public boolean m0() {
        return this.f12990S0;
    }

    @Override // q.e
    public void m1(C0474d c0474d, boolean z3) {
        if (I() == null) {
            return;
        }
        int y3 = c0474d.y(this.f12987P0);
        if (this.f12988Q0 == 1) {
            i1(y3);
            j1(0);
            I0(I().v());
            g1(0);
            return;
        }
        i1(0);
        j1(y3);
        g1(I().U());
        I0(0);
    }

    public d n1() {
        return this.f12987P0;
    }

    public int o1() {
        return this.f12988Q0;
    }

    public int p1() {
        return this.f12984M0;
    }

    public int q1() {
        return this.f12985N0;
    }

    public float r1() {
        return this.f12983L0;
    }

    public void s1(int i3) {
        this.f12987P0.s(i3);
        this.f12990S0 = true;
    }

    public void t1(int i3) {
        if (i3 > -1) {
            this.f12983L0 = -1.0f;
            this.f12984M0 = i3;
            this.f12985N0 = -1;
        }
    }

    public void u1(int i3) {
        if (i3 > -1) {
            this.f12983L0 = -1.0f;
            this.f12984M0 = -1;
            this.f12985N0 = i3;
        }
    }

    public void v1(float f3) {
        if (f3 > -1.0f) {
            this.f12983L0 = f3;
            this.f12984M0 = -1;
            this.f12985N0 = -1;
        }
    }

    public void w1(int i3) {
        if (this.f12988Q0 == i3) {
            return;
        }
        this.f12988Q0 = i3;
        this.f12891X.clear();
        if (this.f12988Q0 == 1) {
            this.f12987P0 = this.f12882O;
        } else {
            this.f12987P0 = this.f12883P;
        }
        this.f12891X.add(this.f12987P0);
        int length = this.f12890W.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.f12890W[i4] = this.f12987P0;
        }
    }
}
