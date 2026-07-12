package n;

import java.util.Arrays;
import n.C0472b;

/* renamed from: n.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0471a implements C0472b.a {

    /* renamed from: l, reason: collision with root package name */
    private static float f12460l = 0.001f;

    /* renamed from: b, reason: collision with root package name */
    private final C0472b f12462b;

    /* renamed from: c, reason: collision with root package name */
    protected final C0473c f12463c;

    /* renamed from: a, reason: collision with root package name */
    int f12461a = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f12464d = 8;

    /* renamed from: e, reason: collision with root package name */
    private C0479i f12465e = null;

    /* renamed from: f, reason: collision with root package name */
    private int[] f12466f = new int[8];

    /* renamed from: g, reason: collision with root package name */
    private int[] f12467g = new int[8];

    /* renamed from: h, reason: collision with root package name */
    private float[] f12468h = new float[8];

    /* renamed from: i, reason: collision with root package name */
    private int f12469i = -1;

    /* renamed from: j, reason: collision with root package name */
    private int f12470j = -1;

    /* renamed from: k, reason: collision with root package name */
    private boolean f12471k = false;

    C0471a(C0472b c0472b, C0473c c0473c) {
        this.f12462b = c0472b;
        this.f12463c = c0473c;
    }

    @Override // n.C0472b.a
    public float a(int i3) {
        int i4 = this.f12469i;
        for (int i5 = 0; i4 != -1 && i5 < this.f12461a; i5++) {
            if (i5 == i3) {
                return this.f12468h[i4];
            }
            i4 = this.f12467g[i4];
        }
        return 0.0f;
    }

    @Override // n.C0472b.a
    public final float b(C0479i c0479i) {
        int i3 = this.f12469i;
        for (int i4 = 0; i3 != -1 && i4 < this.f12461a; i4++) {
            if (this.f12466f[i3] == c0479i.f12523g) {
                return this.f12468h[i3];
            }
            i3 = this.f12467g[i3];
        }
        return 0.0f;
    }

    @Override // n.C0472b.a
    public void c(C0479i c0479i, float f3, boolean z3) {
        float f4 = f12460l;
        if (f3 <= (-f4) || f3 >= f4) {
            int i3 = this.f12469i;
            if (i3 == -1) {
                this.f12469i = 0;
                this.f12468h[0] = f3;
                this.f12466f[0] = c0479i.f12523g;
                this.f12467g[0] = -1;
                c0479i.f12533q++;
                c0479i.a(this.f12462b);
                this.f12461a++;
                if (this.f12471k) {
                    return;
                }
                int i4 = this.f12470j + 1;
                this.f12470j = i4;
                int[] iArr = this.f12466f;
                if (i4 >= iArr.length) {
                    this.f12471k = true;
                    this.f12470j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i5 = -1;
            for (int i6 = 0; i3 != -1 && i6 < this.f12461a; i6++) {
                int i7 = this.f12466f[i3];
                int i8 = c0479i.f12523g;
                if (i7 == i8) {
                    float[] fArr = this.f12468h;
                    float f5 = fArr[i3] + f3;
                    float f6 = f12460l;
                    if (f5 > (-f6) && f5 < f6) {
                        f5 = 0.0f;
                    }
                    fArr[i3] = f5;
                    if (f5 == 0.0f) {
                        if (i3 == this.f12469i) {
                            this.f12469i = this.f12467g[i3];
                        } else {
                            int[] iArr2 = this.f12467g;
                            iArr2[i5] = iArr2[i3];
                        }
                        if (z3) {
                            c0479i.d(this.f12462b);
                        }
                        if (this.f12471k) {
                            this.f12470j = i3;
                        }
                        c0479i.f12533q--;
                        this.f12461a--;
                        return;
                    }
                    return;
                }
                if (i7 < i8) {
                    i5 = i3;
                }
                i3 = this.f12467g[i3];
            }
            int i9 = this.f12470j;
            int i10 = i9 + 1;
            if (this.f12471k) {
                int[] iArr3 = this.f12466f;
                if (iArr3[i9] != -1) {
                    i9 = iArr3.length;
                }
            } else {
                i9 = i10;
            }
            int[] iArr4 = this.f12466f;
            if (i9 >= iArr4.length && this.f12461a < iArr4.length) {
                int i11 = 0;
                while (true) {
                    int[] iArr5 = this.f12466f;
                    if (i11 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i11] == -1) {
                        i9 = i11;
                        break;
                    }
                    i11++;
                }
            }
            int[] iArr6 = this.f12466f;
            if (i9 >= iArr6.length) {
                i9 = iArr6.length;
                int i12 = this.f12464d * 2;
                this.f12464d = i12;
                this.f12471k = false;
                this.f12470j = i9 - 1;
                this.f12468h = Arrays.copyOf(this.f12468h, i12);
                this.f12466f = Arrays.copyOf(this.f12466f, this.f12464d);
                this.f12467g = Arrays.copyOf(this.f12467g, this.f12464d);
            }
            this.f12466f[i9] = c0479i.f12523g;
            this.f12468h[i9] = f3;
            if (i5 != -1) {
                int[] iArr7 = this.f12467g;
                iArr7[i9] = iArr7[i5];
                iArr7[i5] = i9;
            } else {
                this.f12467g[i9] = this.f12469i;
                this.f12469i = i9;
            }
            c0479i.f12533q++;
            c0479i.a(this.f12462b);
            this.f12461a++;
            if (!this.f12471k) {
                this.f12470j++;
            }
            int i13 = this.f12470j;
            int[] iArr8 = this.f12466f;
            if (i13 >= iArr8.length) {
                this.f12471k = true;
                this.f12470j = iArr8.length - 1;
            }
        }
    }

    @Override // n.C0472b.a
    public final void clear() {
        int i3 = this.f12469i;
        for (int i4 = 0; i3 != -1 && i4 < this.f12461a; i4++) {
            C0479i c0479i = this.f12463c.f12481d[this.f12466f[i3]];
            if (c0479i != null) {
                c0479i.d(this.f12462b);
            }
            i3 = this.f12467g[i3];
        }
        this.f12469i = -1;
        this.f12470j = -1;
        this.f12471k = false;
        this.f12461a = 0;
    }

    @Override // n.C0472b.a
    public float d(C0472b c0472b, boolean z3) {
        float b3 = b(c0472b.f12472a);
        i(c0472b.f12472a, z3);
        C0472b.a aVar = c0472b.f12476e;
        int k3 = aVar.k();
        for (int i3 = 0; i3 < k3; i3++) {
            C0479i f3 = aVar.f(i3);
            c(f3, aVar.b(f3) * b3, z3);
        }
        return b3;
    }

    @Override // n.C0472b.a
    public boolean e(C0479i c0479i) {
        int i3 = this.f12469i;
        if (i3 == -1) {
            return false;
        }
        for (int i4 = 0; i3 != -1 && i4 < this.f12461a; i4++) {
            if (this.f12466f[i3] == c0479i.f12523g) {
                return true;
            }
            i3 = this.f12467g[i3];
        }
        return false;
    }

    @Override // n.C0472b.a
    public C0479i f(int i3) {
        int i4 = this.f12469i;
        for (int i5 = 0; i4 != -1 && i5 < this.f12461a; i5++) {
            if (i5 == i3) {
                return this.f12463c.f12481d[this.f12466f[i4]];
            }
            i4 = this.f12467g[i4];
        }
        return null;
    }

    @Override // n.C0472b.a
    public final void g(C0479i c0479i, float f3) {
        if (f3 == 0.0f) {
            i(c0479i, true);
            return;
        }
        int i3 = this.f12469i;
        if (i3 == -1) {
            this.f12469i = 0;
            this.f12468h[0] = f3;
            this.f12466f[0] = c0479i.f12523g;
            this.f12467g[0] = -1;
            c0479i.f12533q++;
            c0479i.a(this.f12462b);
            this.f12461a++;
            if (this.f12471k) {
                return;
            }
            int i4 = this.f12470j + 1;
            this.f12470j = i4;
            int[] iArr = this.f12466f;
            if (i4 >= iArr.length) {
                this.f12471k = true;
                this.f12470j = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i3 != -1 && i6 < this.f12461a; i6++) {
            int i7 = this.f12466f[i3];
            int i8 = c0479i.f12523g;
            if (i7 == i8) {
                this.f12468h[i3] = f3;
                return;
            }
            if (i7 < i8) {
                i5 = i3;
            }
            i3 = this.f12467g[i3];
        }
        int i9 = this.f12470j;
        int i10 = i9 + 1;
        if (this.f12471k) {
            int[] iArr2 = this.f12466f;
            if (iArr2[i9] != -1) {
                i9 = iArr2.length;
            }
        } else {
            i9 = i10;
        }
        int[] iArr3 = this.f12466f;
        if (i9 >= iArr3.length && this.f12461a < iArr3.length) {
            int i11 = 0;
            while (true) {
                int[] iArr4 = this.f12466f;
                if (i11 >= iArr4.length) {
                    break;
                }
                if (iArr4[i11] == -1) {
                    i9 = i11;
                    break;
                }
                i11++;
            }
        }
        int[] iArr5 = this.f12466f;
        if (i9 >= iArr5.length) {
            i9 = iArr5.length;
            int i12 = this.f12464d * 2;
            this.f12464d = i12;
            this.f12471k = false;
            this.f12470j = i9 - 1;
            this.f12468h = Arrays.copyOf(this.f12468h, i12);
            this.f12466f = Arrays.copyOf(this.f12466f, this.f12464d);
            this.f12467g = Arrays.copyOf(this.f12467g, this.f12464d);
        }
        this.f12466f[i9] = c0479i.f12523g;
        this.f12468h[i9] = f3;
        if (i5 != -1) {
            int[] iArr6 = this.f12467g;
            iArr6[i9] = iArr6[i5];
            iArr6[i5] = i9;
        } else {
            this.f12467g[i9] = this.f12469i;
            this.f12469i = i9;
        }
        c0479i.f12533q++;
        c0479i.a(this.f12462b);
        int i13 = this.f12461a + 1;
        this.f12461a = i13;
        if (!this.f12471k) {
            this.f12470j++;
        }
        int[] iArr7 = this.f12466f;
        if (i13 >= iArr7.length) {
            this.f12471k = true;
        }
        if (this.f12470j >= iArr7.length) {
            this.f12471k = true;
            this.f12470j = iArr7.length - 1;
        }
    }

    @Override // n.C0472b.a
    public void h(float f3) {
        int i3 = this.f12469i;
        for (int i4 = 0; i3 != -1 && i4 < this.f12461a; i4++) {
            float[] fArr = this.f12468h;
            fArr[i3] = fArr[i3] / f3;
            i3 = this.f12467g[i3];
        }
    }

    @Override // n.C0472b.a
    public final float i(C0479i c0479i, boolean z3) {
        if (this.f12465e == c0479i) {
            this.f12465e = null;
        }
        int i3 = this.f12469i;
        if (i3 == -1) {
            return 0.0f;
        }
        int i4 = 0;
        int i5 = -1;
        while (i3 != -1 && i4 < this.f12461a) {
            if (this.f12466f[i3] == c0479i.f12523g) {
                if (i3 == this.f12469i) {
                    this.f12469i = this.f12467g[i3];
                } else {
                    int[] iArr = this.f12467g;
                    iArr[i5] = iArr[i3];
                }
                if (z3) {
                    c0479i.d(this.f12462b);
                }
                c0479i.f12533q--;
                this.f12461a--;
                this.f12466f[i3] = -1;
                if (this.f12471k) {
                    this.f12470j = i3;
                }
                return this.f12468h[i3];
            }
            i4++;
            i5 = i3;
            i3 = this.f12467g[i3];
        }
        return 0.0f;
    }

    @Override // n.C0472b.a
    public void j() {
        int i3 = this.f12469i;
        for (int i4 = 0; i3 != -1 && i4 < this.f12461a; i4++) {
            float[] fArr = this.f12468h;
            fArr[i3] = fArr[i3] * (-1.0f);
            i3 = this.f12467g[i3];
        }
    }

    @Override // n.C0472b.a
    public int k() {
        return this.f12461a;
    }

    public String toString() {
        int i3 = this.f12469i;
        String str = "";
        for (int i4 = 0; i3 != -1 && i4 < this.f12461a; i4++) {
            str = ((str + " -> ") + this.f12468h[i3] + " : ") + this.f12463c.f12481d[this.f12466f[i3]];
            i3 = this.f12467g[i3];
        }
        return str;
    }
}
