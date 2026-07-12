package n;

import java.util.Arrays;
import n.C0472b;

/* renamed from: n.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0480j implements C0472b.a {

    /* renamed from: n, reason: collision with root package name */
    private static float f12544n = 0.001f;

    /* renamed from: a, reason: collision with root package name */
    private final int f12545a = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f12546b = 16;

    /* renamed from: c, reason: collision with root package name */
    private int f12547c = 16;

    /* renamed from: d, reason: collision with root package name */
    int[] f12548d = new int[16];

    /* renamed from: e, reason: collision with root package name */
    int[] f12549e = new int[16];

    /* renamed from: f, reason: collision with root package name */
    int[] f12550f = new int[16];

    /* renamed from: g, reason: collision with root package name */
    float[] f12551g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    int[] f12552h = new int[16];

    /* renamed from: i, reason: collision with root package name */
    int[] f12553i = new int[16];

    /* renamed from: j, reason: collision with root package name */
    int f12554j = 0;

    /* renamed from: k, reason: collision with root package name */
    int f12555k = -1;

    /* renamed from: l, reason: collision with root package name */
    private final C0472b f12556l;

    /* renamed from: m, reason: collision with root package name */
    protected final C0473c f12557m;

    C0480j(C0472b c0472b, C0473c c0473c) {
        this.f12556l = c0472b;
        this.f12557m = c0473c;
        clear();
    }

    private void l(C0479i c0479i, int i3) {
        int[] iArr;
        int i4 = c0479i.f12523g % this.f12547c;
        int[] iArr2 = this.f12548d;
        int i5 = iArr2[i4];
        if (i5 == -1) {
            iArr2[i4] = i3;
        } else {
            while (true) {
                iArr = this.f12549e;
                int i6 = iArr[i5];
                if (i6 == -1) {
                    break;
                } else {
                    i5 = i6;
                }
            }
            iArr[i5] = i3;
        }
        this.f12549e[i3] = -1;
    }

    private void m(int i3, C0479i c0479i, float f3) {
        this.f12550f[i3] = c0479i.f12523g;
        this.f12551g[i3] = f3;
        this.f12552h[i3] = -1;
        this.f12553i[i3] = -1;
        c0479i.a(this.f12556l);
        c0479i.f12533q++;
        this.f12554j++;
    }

    private int n() {
        for (int i3 = 0; i3 < this.f12546b; i3++) {
            if (this.f12550f[i3] == -1) {
                return i3;
            }
        }
        return -1;
    }

    private void o() {
        int i3 = this.f12546b * 2;
        this.f12550f = Arrays.copyOf(this.f12550f, i3);
        this.f12551g = Arrays.copyOf(this.f12551g, i3);
        this.f12552h = Arrays.copyOf(this.f12552h, i3);
        this.f12553i = Arrays.copyOf(this.f12553i, i3);
        this.f12549e = Arrays.copyOf(this.f12549e, i3);
        for (int i4 = this.f12546b; i4 < i3; i4++) {
            this.f12550f[i4] = -1;
            this.f12549e[i4] = -1;
        }
        this.f12546b = i3;
    }

    private void q(int i3, C0479i c0479i, float f3) {
        int n3 = n();
        m(n3, c0479i, f3);
        if (i3 != -1) {
            this.f12552h[n3] = i3;
            int[] iArr = this.f12553i;
            iArr[n3] = iArr[i3];
            iArr[i3] = n3;
        } else {
            this.f12552h[n3] = -1;
            if (this.f12554j > 0) {
                this.f12553i[n3] = this.f12555k;
                this.f12555k = n3;
            } else {
                this.f12553i[n3] = -1;
            }
        }
        int i4 = this.f12553i[n3];
        if (i4 != -1) {
            this.f12552h[i4] = n3;
        }
        l(c0479i, n3);
    }

    private void r(C0479i c0479i) {
        int[] iArr;
        int i3;
        int i4 = c0479i.f12523g;
        int i5 = i4 % this.f12547c;
        int[] iArr2 = this.f12548d;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            return;
        }
        if (this.f12550f[i6] == i4) {
            int[] iArr3 = this.f12549e;
            iArr2[i5] = iArr3[i6];
            iArr3[i6] = -1;
            return;
        }
        while (true) {
            iArr = this.f12549e;
            i3 = iArr[i6];
            if (i3 == -1 || this.f12550f[i3] == i4) {
                break;
            } else {
                i6 = i3;
            }
        }
        if (i3 == -1 || this.f12550f[i3] != i4) {
            return;
        }
        iArr[i6] = iArr[i3];
        iArr[i3] = -1;
    }

    @Override // n.C0472b.a
    public float a(int i3) {
        int i4 = this.f12554j;
        int i5 = this.f12555k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3) {
                return this.f12551g[i5];
            }
            i5 = this.f12553i[i5];
            if (i5 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // n.C0472b.a
    public float b(C0479i c0479i) {
        int p3 = p(c0479i);
        if (p3 != -1) {
            return this.f12551g[p3];
        }
        return 0.0f;
    }

    @Override // n.C0472b.a
    public void c(C0479i c0479i, float f3, boolean z3) {
        float f4 = f12544n;
        if (f3 <= (-f4) || f3 >= f4) {
            int p3 = p(c0479i);
            if (p3 == -1) {
                g(c0479i, f3);
                return;
            }
            float[] fArr = this.f12551g;
            float f5 = fArr[p3] + f3;
            fArr[p3] = f5;
            float f6 = f12544n;
            if (f5 <= (-f6) || f5 >= f6) {
                return;
            }
            fArr[p3] = 0.0f;
            i(c0479i, z3);
        }
    }

    @Override // n.C0472b.a
    public void clear() {
        int i3 = this.f12554j;
        for (int i4 = 0; i4 < i3; i4++) {
            C0479i f3 = f(i4);
            if (f3 != null) {
                f3.d(this.f12556l);
            }
        }
        for (int i5 = 0; i5 < this.f12546b; i5++) {
            this.f12550f[i5] = -1;
            this.f12549e[i5] = -1;
        }
        for (int i6 = 0; i6 < this.f12547c; i6++) {
            this.f12548d[i6] = -1;
        }
        this.f12554j = 0;
        this.f12555k = -1;
    }

    @Override // n.C0472b.a
    public float d(C0472b c0472b, boolean z3) {
        float b3 = b(c0472b.f12472a);
        i(c0472b.f12472a, z3);
        C0480j c0480j = (C0480j) c0472b.f12476e;
        int k3 = c0480j.k();
        int i3 = 0;
        int i4 = 0;
        while (i3 < k3) {
            int i5 = c0480j.f12550f[i4];
            if (i5 != -1) {
                c(this.f12557m.f12481d[i5], c0480j.f12551g[i4] * b3, z3);
                i3++;
            }
            i4++;
        }
        return b3;
    }

    @Override // n.C0472b.a
    public boolean e(C0479i c0479i) {
        return p(c0479i) != -1;
    }

    @Override // n.C0472b.a
    public C0479i f(int i3) {
        int i4 = this.f12554j;
        if (i4 == 0) {
            return null;
        }
        int i5 = this.f12555k;
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 == i3 && i5 != -1) {
                return this.f12557m.f12481d[this.f12550f[i5]];
            }
            i5 = this.f12553i[i5];
            if (i5 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // n.C0472b.a
    public void g(C0479i c0479i, float f3) {
        float f4 = f12544n;
        if (f3 > (-f4) && f3 < f4) {
            i(c0479i, true);
            return;
        }
        if (this.f12554j == 0) {
            m(0, c0479i, f3);
            l(c0479i, 0);
            this.f12555k = 0;
            return;
        }
        int p3 = p(c0479i);
        if (p3 != -1) {
            this.f12551g[p3] = f3;
            return;
        }
        if (this.f12554j + 1 >= this.f12546b) {
            o();
        }
        int i3 = this.f12554j;
        int i4 = this.f12555k;
        int i5 = -1;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = this.f12550f[i4];
            int i8 = c0479i.f12523g;
            if (i7 == i8) {
                this.f12551g[i4] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i4;
            }
            i4 = this.f12553i[i4];
            if (i4 == -1) {
                break;
            }
        }
        q(i5, c0479i, f3);
    }

    @Override // n.C0472b.a
    public void h(float f3) {
        int i3 = this.f12554j;
        int i4 = this.f12555k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f12551g;
            fArr[i4] = fArr[i4] / f3;
            i4 = this.f12553i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // n.C0472b.a
    public float i(C0479i c0479i, boolean z3) {
        int p3 = p(c0479i);
        if (p3 == -1) {
            return 0.0f;
        }
        r(c0479i);
        float f3 = this.f12551g[p3];
        if (this.f12555k == p3) {
            this.f12555k = this.f12553i[p3];
        }
        this.f12550f[p3] = -1;
        int[] iArr = this.f12552h;
        int i3 = iArr[p3];
        if (i3 != -1) {
            int[] iArr2 = this.f12553i;
            iArr2[i3] = iArr2[p3];
        }
        int i4 = this.f12553i[p3];
        if (i4 != -1) {
            iArr[i4] = iArr[p3];
        }
        this.f12554j--;
        c0479i.f12533q--;
        if (z3) {
            c0479i.d(this.f12556l);
        }
        return f3;
    }

    @Override // n.C0472b.a
    public void j() {
        int i3 = this.f12554j;
        int i4 = this.f12555k;
        for (int i5 = 0; i5 < i3; i5++) {
            float[] fArr = this.f12551g;
            fArr[i4] = fArr[i4] * (-1.0f);
            i4 = this.f12553i[i4];
            if (i4 == -1) {
                return;
            }
        }
    }

    @Override // n.C0472b.a
    public int k() {
        return this.f12554j;
    }

    public int p(C0479i c0479i) {
        if (this.f12554j != 0 && c0479i != null) {
            int i3 = c0479i.f12523g;
            int i4 = this.f12548d[i3 % this.f12547c];
            if (i4 == -1) {
                return -1;
            }
            if (this.f12550f[i4] == i3) {
                return i4;
            }
            do {
                i4 = this.f12549e[i4];
                if (i4 == -1) {
                    break;
                }
            } while (this.f12550f[i4] != i3);
            if (i4 != -1 && this.f12550f[i4] == i3) {
                return i4;
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i3 = this.f12554j;
        for (int i4 = 0; i4 < i3; i4++) {
            C0479i f3 = f(i4);
            if (f3 != null) {
                String str2 = str + f3 + " = " + a(i4) + " ";
                int p3 = p(f3);
                String str3 = str2 + "[p: ";
                String str4 = (this.f12552h[p3] != -1 ? str3 + this.f12557m.f12481d[this.f12550f[this.f12552h[p3]]] : str3 + "none") + ", n: ";
                str = (this.f12553i[p3] != -1 ? str4 + this.f12557m.f12481d[this.f12550f[this.f12553i[p3]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }
}
