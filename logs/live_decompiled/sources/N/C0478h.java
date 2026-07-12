package n;

import java.util.Arrays;
import java.util.Comparator;
import n.C0472b;

/* renamed from: n.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0478h extends C0472b {

    /* renamed from: g, reason: collision with root package name */
    private int f12510g;

    /* renamed from: h, reason: collision with root package name */
    private C0479i[] f12511h;

    /* renamed from: i, reason: collision with root package name */
    private C0479i[] f12512i;

    /* renamed from: j, reason: collision with root package name */
    private int f12513j;

    /* renamed from: k, reason: collision with root package name */
    b f12514k;

    /* renamed from: l, reason: collision with root package name */
    C0473c f12515l;

    /* renamed from: n.h$a */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0479i c0479i, C0479i c0479i2) {
            return c0479i.f12523g - c0479i2.f12523g;
        }
    }

    /* renamed from: n.h$b */
    class b {

        /* renamed from: a, reason: collision with root package name */
        C0479i f12517a;

        /* renamed from: b, reason: collision with root package name */
        C0478h f12518b;

        public b(C0478h c0478h) {
            this.f12518b = c0478h;
        }

        public boolean a(C0479i c0479i, float f3) {
            boolean z3 = true;
            if (!this.f12517a.f12521e) {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f4 = c0479i.f12529m[i3];
                    if (f4 != 0.0f) {
                        float f5 = f4 * f3;
                        if (Math.abs(f5) < 1.0E-4f) {
                            f5 = 0.0f;
                        }
                        this.f12517a.f12529m[i3] = f5;
                    } else {
                        this.f12517a.f12529m[i3] = 0.0f;
                    }
                }
                return true;
            }
            for (int i4 = 0; i4 < 9; i4++) {
                float[] fArr = this.f12517a.f12529m;
                float f6 = fArr[i4] + (c0479i.f12529m[i4] * f3);
                fArr[i4] = f6;
                if (Math.abs(f6) < 1.0E-4f) {
                    this.f12517a.f12529m[i4] = 0.0f;
                } else {
                    z3 = false;
                }
            }
            if (z3) {
                C0478h.this.G(this.f12517a);
            }
            return false;
        }

        public void b(C0479i c0479i) {
            this.f12517a = c0479i;
        }

        public final boolean c() {
            for (int i3 = 8; i3 >= 0; i3--) {
                float f3 = this.f12517a.f12529m[i3];
                if (f3 > 0.0f) {
                    return false;
                }
                if (f3 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(C0479i c0479i) {
            int i3 = 8;
            while (true) {
                if (i3 < 0) {
                    break;
                }
                float f3 = c0479i.f12529m[i3];
                float f4 = this.f12517a.f12529m[i3];
                if (f4 == f3) {
                    i3--;
                } else if (f4 < f3) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f12517a.f12529m, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f12517a != null) {
                for (int i3 = 0; i3 < 9; i3++) {
                    str = str + this.f12517a.f12529m[i3] + " ";
                }
            }
            return str + "] " + this.f12517a;
        }
    }

    public C0478h(C0473c c0473c) {
        super(c0473c);
        this.f12510g = 128;
        this.f12511h = new C0479i[128];
        this.f12512i = new C0479i[128];
        this.f12513j = 0;
        this.f12514k = new b(this);
        this.f12515l = c0473c;
    }

    private final void F(C0479i c0479i) {
        int i3;
        int i4 = this.f12513j + 1;
        C0479i[] c0479iArr = this.f12511h;
        if (i4 > c0479iArr.length) {
            C0479i[] c0479iArr2 = (C0479i[]) Arrays.copyOf(c0479iArr, c0479iArr.length * 2);
            this.f12511h = c0479iArr2;
            this.f12512i = (C0479i[]) Arrays.copyOf(c0479iArr2, c0479iArr2.length * 2);
        }
        C0479i[] c0479iArr3 = this.f12511h;
        int i5 = this.f12513j;
        c0479iArr3[i5] = c0479i;
        int i6 = i5 + 1;
        this.f12513j = i6;
        if (i6 > 1 && c0479iArr3[i5].f12523g > c0479i.f12523g) {
            int i7 = 0;
            while (true) {
                i3 = this.f12513j;
                if (i7 >= i3) {
                    break;
                }
                this.f12512i[i7] = this.f12511h[i7];
                i7++;
            }
            Arrays.sort(this.f12512i, 0, i3, new a());
            for (int i8 = 0; i8 < this.f12513j; i8++) {
                this.f12511h[i8] = this.f12512i[i8];
            }
        }
        c0479i.f12521e = true;
        c0479i.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(C0479i c0479i) {
        int i3 = 0;
        while (i3 < this.f12513j) {
            if (this.f12511h[i3] == c0479i) {
                while (true) {
                    int i4 = this.f12513j;
                    if (i3 >= i4 - 1) {
                        this.f12513j = i4 - 1;
                        c0479i.f12521e = false;
                        return;
                    } else {
                        C0479i[] c0479iArr = this.f12511h;
                        int i5 = i3 + 1;
                        c0479iArr[i3] = c0479iArr[i5];
                        i3 = i5;
                    }
                }
            } else {
                i3++;
            }
        }
    }

    @Override // n.C0472b
    public void B(C0474d c0474d, C0472b c0472b, boolean z3) {
        C0479i c0479i = c0472b.f12472a;
        if (c0479i == null) {
            return;
        }
        C0472b.a aVar = c0472b.f12476e;
        int k3 = aVar.k();
        for (int i3 = 0; i3 < k3; i3++) {
            C0479i f3 = aVar.f(i3);
            float a3 = aVar.a(i3);
            this.f12514k.b(f3);
            if (this.f12514k.a(c0479i, a3)) {
                F(f3);
            }
            this.f12473b += c0472b.f12473b * a3;
        }
        G(c0479i);
    }

    @Override // n.C0472b, n.C0474d.a
    public C0479i a(C0474d c0474d, boolean[] zArr) {
        int i3 = -1;
        for (int i4 = 0; i4 < this.f12513j; i4++) {
            C0479i c0479i = this.f12511h[i4];
            if (!zArr[c0479i.f12523g]) {
                this.f12514k.b(c0479i);
                if (i3 == -1) {
                    if (!this.f12514k.c()) {
                    }
                    i3 = i4;
                } else {
                    if (!this.f12514k.d(this.f12511h[i3])) {
                    }
                    i3 = i4;
                }
            }
        }
        if (i3 == -1) {
            return null;
        }
        return this.f12511h[i3];
    }

    @Override // n.C0472b, n.C0474d.a
    public void b(C0479i c0479i) {
        this.f12514k.b(c0479i);
        this.f12514k.e();
        c0479i.f12529m[c0479i.f12525i] = 1.0f;
        F(c0479i);
    }

    @Override // n.C0472b, n.C0474d.a
    public void clear() {
        this.f12513j = 0;
        this.f12473b = 0.0f;
    }

    @Override // n.C0472b, n.C0474d.a
    public boolean isEmpty() {
        return this.f12513j == 0;
    }

    @Override // n.C0472b
    public String toString() {
        String str = " goal -> (" + this.f12473b + ") : ";
        for (int i3 = 0; i3 < this.f12513j; i3++) {
            this.f12514k.b(this.f12511h[i3]);
            str = str + this.f12514k + " ";
        }
        return str;
    }
}
