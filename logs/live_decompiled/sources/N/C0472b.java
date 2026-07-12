package n;

import java.util.ArrayList;
import n.C0474d;
import n.C0479i;

/* renamed from: n.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0472b implements C0474d.a {

    /* renamed from: e, reason: collision with root package name */
    public a f12476e;

    /* renamed from: a, reason: collision with root package name */
    C0479i f12472a = null;

    /* renamed from: b, reason: collision with root package name */
    float f12473b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    boolean f12474c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList f12475d = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    boolean f12477f = false;

    /* renamed from: n.b$a */
    public interface a {
        float a(int i3);

        float b(C0479i c0479i);

        void c(C0479i c0479i, float f3, boolean z3);

        void clear();

        float d(C0472b c0472b, boolean z3);

        boolean e(C0479i c0479i);

        C0479i f(int i3);

        void g(C0479i c0479i, float f3);

        void h(float f3);

        float i(C0479i c0479i, boolean z3);

        void j();

        int k();
    }

    public C0472b() {
    }

    private boolean u(C0479i c0479i, C0474d c0474d) {
        return c0479i.f12533q <= 1;
    }

    private C0479i w(boolean[] zArr, C0479i c0479i) {
        C0479i.a aVar;
        int k3 = this.f12476e.k();
        C0479i c0479i2 = null;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < k3; i3++) {
            float a3 = this.f12476e.a(i3);
            if (a3 < 0.0f) {
                C0479i f4 = this.f12476e.f(i3);
                if ((zArr == null || !zArr[f4.f12523g]) && f4 != c0479i && (((aVar = f4.f12530n) == C0479i.a.SLACK || aVar == C0479i.a.ERROR) && a3 < f3)) {
                    f3 = a3;
                    c0479i2 = f4;
                }
            }
        }
        return c0479i2;
    }

    public void A(C0474d c0474d, C0479i c0479i, boolean z3) {
        if (c0479i == null || !c0479i.f12527k) {
            return;
        }
        this.f12473b += c0479i.f12526j * this.f12476e.b(c0479i);
        this.f12476e.i(c0479i, z3);
        if (z3) {
            c0479i.d(this);
        }
        if (C0474d.f12484t && this.f12476e.k() == 0) {
            this.f12477f = true;
            c0474d.f12490a = true;
        }
    }

    public void B(C0474d c0474d, C0472b c0472b, boolean z3) {
        this.f12473b += c0472b.f12473b * this.f12476e.d(c0472b, z3);
        if (z3) {
            c0472b.f12472a.d(this);
        }
        if (C0474d.f12484t && this.f12472a != null && this.f12476e.k() == 0) {
            this.f12477f = true;
            c0474d.f12490a = true;
        }
    }

    public void C(C0474d c0474d, C0479i c0479i, boolean z3) {
        if (c0479i == null || !c0479i.f12534r) {
            return;
        }
        float b3 = this.f12476e.b(c0479i);
        this.f12473b += c0479i.f12536t * b3;
        this.f12476e.i(c0479i, z3);
        if (z3) {
            c0479i.d(this);
        }
        this.f12476e.c(c0474d.f12503n.f12481d[c0479i.f12535s], b3, z3);
        if (C0474d.f12484t && this.f12476e.k() == 0) {
            this.f12477f = true;
            c0474d.f12490a = true;
        }
    }

    public void D(C0474d c0474d) {
        if (c0474d.f12496g.length == 0) {
            return;
        }
        boolean z3 = false;
        while (!z3) {
            int k3 = this.f12476e.k();
            for (int i3 = 0; i3 < k3; i3++) {
                C0479i f3 = this.f12476e.f(i3);
                if (f3.f12524h != -1 || f3.f12527k || f3.f12534r) {
                    this.f12475d.add(f3);
                }
            }
            int size = this.f12475d.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    C0479i c0479i = (C0479i) this.f12475d.get(i4);
                    if (c0479i.f12527k) {
                        A(c0474d, c0479i, true);
                    } else if (c0479i.f12534r) {
                        C(c0474d, c0479i, true);
                    } else {
                        B(c0474d, c0474d.f12496g[c0479i.f12524h], true);
                    }
                }
                this.f12475d.clear();
            } else {
                z3 = true;
            }
        }
        if (C0474d.f12484t && this.f12472a != null && this.f12476e.k() == 0) {
            this.f12477f = true;
            c0474d.f12490a = true;
        }
    }

    @Override // n.C0474d.a
    public C0479i a(C0474d c0474d, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // n.C0474d.a
    public void b(C0479i c0479i) {
        int i3 = c0479i.f12525i;
        float f3 = 1.0f;
        if (i3 != 1) {
            if (i3 == 2) {
                f3 = 1000.0f;
            } else if (i3 == 3) {
                f3 = 1000000.0f;
            } else if (i3 == 4) {
                f3 = 1.0E9f;
            } else if (i3 == 5) {
                f3 = 1.0E12f;
            }
        }
        this.f12476e.g(c0479i, f3);
    }

    @Override // n.C0474d.a
    public void c(C0474d.a aVar) {
        if (aVar instanceof C0472b) {
            C0472b c0472b = (C0472b) aVar;
            this.f12472a = null;
            this.f12476e.clear();
            for (int i3 = 0; i3 < c0472b.f12476e.k(); i3++) {
                this.f12476e.c(c0472b.f12476e.f(i3), c0472b.f12476e.a(i3), true);
            }
        }
    }

    @Override // n.C0474d.a
    public void clear() {
        this.f12476e.clear();
        this.f12472a = null;
        this.f12473b = 0.0f;
    }

    public C0472b d(C0474d c0474d, int i3) {
        this.f12476e.g(c0474d.o(i3, "ep"), 1.0f);
        this.f12476e.g(c0474d.o(i3, "em"), -1.0f);
        return this;
    }

    C0472b e(C0479i c0479i, int i3) {
        this.f12476e.g(c0479i, i3);
        return this;
    }

    boolean f(C0474d c0474d) {
        boolean z3;
        C0479i g3 = g(c0474d);
        if (g3 == null) {
            z3 = true;
        } else {
            x(g3);
            z3 = false;
        }
        if (this.f12476e.k() == 0) {
            this.f12477f = true;
        }
        return z3;
    }

    C0479i g(C0474d c0474d) {
        boolean u3;
        boolean u4;
        int k3 = this.f12476e.k();
        C0479i c0479i = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z3 = false;
        boolean z4 = false;
        C0479i c0479i2 = null;
        for (int i3 = 0; i3 < k3; i3++) {
            float a3 = this.f12476e.a(i3);
            C0479i f5 = this.f12476e.f(i3);
            if (f5.f12530n == C0479i.a.UNRESTRICTED) {
                if (c0479i == null) {
                    u4 = u(f5, c0474d);
                } else if (f3 > a3) {
                    u4 = u(f5, c0474d);
                } else if (!z3 && u(f5, c0474d)) {
                    f3 = a3;
                    c0479i = f5;
                    z3 = true;
                }
                z3 = u4;
                f3 = a3;
                c0479i = f5;
            } else if (c0479i == null && a3 < 0.0f) {
                if (c0479i2 == null) {
                    u3 = u(f5, c0474d);
                } else if (f4 > a3) {
                    u3 = u(f5, c0474d);
                } else if (!z4 && u(f5, c0474d)) {
                    f4 = a3;
                    c0479i2 = f5;
                    z4 = true;
                }
                z4 = u3;
                f4 = a3;
                c0479i2 = f5;
            }
        }
        return c0479i != null ? c0479i : c0479i2;
    }

    @Override // n.C0474d.a
    public C0479i getKey() {
        return this.f12472a;
    }

    C0472b h(C0479i c0479i, C0479i c0479i2, int i3, float f3, C0479i c0479i3, C0479i c0479i4, int i4) {
        if (c0479i2 == c0479i3) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i4, 1.0f);
            this.f12476e.g(c0479i2, -2.0f);
            return this;
        }
        if (f3 == 0.5f) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
            this.f12476e.g(c0479i3, -1.0f);
            this.f12476e.g(c0479i4, 1.0f);
            if (i3 > 0 || i4 > 0) {
                this.f12473b = (-i3) + i4;
            }
        } else if (f3 <= 0.0f) {
            this.f12476e.g(c0479i, -1.0f);
            this.f12476e.g(c0479i2, 1.0f);
            this.f12473b = i3;
        } else if (f3 >= 1.0f) {
            this.f12476e.g(c0479i4, -1.0f);
            this.f12476e.g(c0479i3, 1.0f);
            this.f12473b = -i4;
        } else {
            float f4 = 1.0f - f3;
            this.f12476e.g(c0479i, f4 * 1.0f);
            this.f12476e.g(c0479i2, f4 * (-1.0f));
            this.f12476e.g(c0479i3, (-1.0f) * f3);
            this.f12476e.g(c0479i4, 1.0f * f3);
            if (i3 > 0 || i4 > 0) {
                this.f12473b = ((-i3) * f4) + (i4 * f3);
            }
        }
        return this;
    }

    C0472b i(C0479i c0479i, int i3) {
        this.f12472a = c0479i;
        float f3 = i3;
        c0479i.f12526j = f3;
        this.f12473b = f3;
        this.f12477f = true;
        return this;
    }

    @Override // n.C0474d.a
    public boolean isEmpty() {
        return this.f12472a == null && this.f12473b == 0.0f && this.f12476e.k() == 0;
    }

    C0472b j(C0479i c0479i, C0479i c0479i2, float f3) {
        this.f12476e.g(c0479i, -1.0f);
        this.f12476e.g(c0479i2, f3);
        return this;
    }

    public C0472b k(C0479i c0479i, C0479i c0479i2, C0479i c0479i3, C0479i c0479i4, float f3) {
        this.f12476e.g(c0479i, -1.0f);
        this.f12476e.g(c0479i2, 1.0f);
        this.f12476e.g(c0479i3, f3);
        this.f12476e.g(c0479i4, -f3);
        return this;
    }

    public C0472b l(float f3, float f4, float f5, C0479i c0479i, C0479i c0479i2, C0479i c0479i3, C0479i c0479i4) {
        this.f12473b = 0.0f;
        if (f4 == 0.0f || f3 == f5) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
            this.f12476e.g(c0479i4, 1.0f);
            this.f12476e.g(c0479i3, -1.0f);
        } else if (f3 == 0.0f) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
        } else if (f5 == 0.0f) {
            this.f12476e.g(c0479i3, 1.0f);
            this.f12476e.g(c0479i4, -1.0f);
        } else {
            float f6 = (f3 / f4) / (f5 / f4);
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
            this.f12476e.g(c0479i4, f6);
            this.f12476e.g(c0479i3, -f6);
        }
        return this;
    }

    public C0472b m(C0479i c0479i, int i3) {
        if (i3 < 0) {
            this.f12473b = i3 * (-1);
            this.f12476e.g(c0479i, 1.0f);
        } else {
            this.f12473b = i3;
            this.f12476e.g(c0479i, -1.0f);
        }
        return this;
    }

    public C0472b n(C0479i c0479i, C0479i c0479i2, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f12473b = i3;
        }
        if (z3) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
        } else {
            this.f12476e.g(c0479i, -1.0f);
            this.f12476e.g(c0479i2, 1.0f);
        }
        return this;
    }

    public C0472b o(C0479i c0479i, C0479i c0479i2, C0479i c0479i3, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f12473b = i3;
        }
        if (z3) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
            this.f12476e.g(c0479i3, -1.0f);
        } else {
            this.f12476e.g(c0479i, -1.0f);
            this.f12476e.g(c0479i2, 1.0f);
            this.f12476e.g(c0479i3, 1.0f);
        }
        return this;
    }

    public C0472b p(C0479i c0479i, C0479i c0479i2, C0479i c0479i3, int i3) {
        boolean z3 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z3 = true;
            }
            this.f12473b = i3;
        }
        if (z3) {
            this.f12476e.g(c0479i, 1.0f);
            this.f12476e.g(c0479i2, -1.0f);
            this.f12476e.g(c0479i3, 1.0f);
        } else {
            this.f12476e.g(c0479i, -1.0f);
            this.f12476e.g(c0479i2, 1.0f);
            this.f12476e.g(c0479i3, -1.0f);
        }
        return this;
    }

    public C0472b q(C0479i c0479i, C0479i c0479i2, C0479i c0479i3, C0479i c0479i4, float f3) {
        this.f12476e.g(c0479i3, 0.5f);
        this.f12476e.g(c0479i4, 0.5f);
        this.f12476e.g(c0479i, -0.5f);
        this.f12476e.g(c0479i2, -0.5f);
        this.f12473b = -f3;
        return this;
    }

    void r() {
        float f3 = this.f12473b;
        if (f3 < 0.0f) {
            this.f12473b = f3 * (-1.0f);
            this.f12476e.j();
        }
    }

    boolean s() {
        C0479i c0479i = this.f12472a;
        return c0479i != null && (c0479i.f12530n == C0479i.a.UNRESTRICTED || this.f12473b >= 0.0f);
    }

    boolean t(C0479i c0479i) {
        return this.f12476e.e(c0479i);
    }

    public String toString() {
        return z();
    }

    public C0479i v(C0479i c0479i) {
        return w(null, c0479i);
    }

    void x(C0479i c0479i) {
        C0479i c0479i2 = this.f12472a;
        if (c0479i2 != null) {
            this.f12476e.g(c0479i2, -1.0f);
            this.f12472a.f12524h = -1;
            this.f12472a = null;
        }
        float i3 = this.f12476e.i(c0479i, true) * (-1.0f);
        this.f12472a = c0479i;
        if (i3 == 1.0f) {
            return;
        }
        this.f12473b /= i3;
        this.f12476e.h(i3);
    }

    public void y() {
        this.f12472a = null;
        this.f12476e.clear();
        this.f12473b = 0.0f;
        this.f12477f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.C0472b.z():java.lang.String");
    }

    public C0472b(C0473c c0473c) {
        this.f12476e = new C0471a(this, c0473c);
    }
}
