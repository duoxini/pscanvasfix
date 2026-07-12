package m;

/* loaded from: classes.dex */
public class h implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private static final Object f12378i = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f12379e;

    /* renamed from: f, reason: collision with root package name */
    private int[] f12380f;

    /* renamed from: g, reason: collision with root package name */
    private Object[] f12381g;

    /* renamed from: h, reason: collision with root package name */
    private int f12382h;

    public h() {
        this(10);
    }

    private void d() {
        int i3 = this.f12382h;
        int[] iArr = this.f12380f;
        Object[] objArr = this.f12381g;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f12378i) {
                if (i5 != i4) {
                    iArr[i4] = iArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f12379e = false;
        this.f12382h = i4;
    }

    public void a(int i3, Object obj) {
        int i4 = this.f12382h;
        if (i4 != 0 && i3 <= this.f12380f[i4 - 1]) {
            i(i3, obj);
            return;
        }
        if (this.f12379e && i4 >= this.f12380f.length) {
            d();
        }
        int i5 = this.f12382h;
        if (i5 >= this.f12380f.length) {
            int e3 = AbstractC0453c.e(i5 + 1);
            int[] iArr = new int[e3];
            Object[] objArr = new Object[e3];
            int[] iArr2 = this.f12380f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f12381g;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f12380f = iArr;
            this.f12381g = objArr;
        }
        this.f12380f[i5] = i3;
        this.f12381g[i5] = obj;
        this.f12382h = i5 + 1;
    }

    public void b() {
        int i3 = this.f12382h;
        Object[] objArr = this.f12381g;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f12382h = 0;
        this.f12379e = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public h clone() {
        try {
            h hVar = (h) super.clone();
            hVar.f12380f = (int[]) this.f12380f.clone();
            hVar.f12381g = (Object[]) this.f12381g.clone();
            return hVar;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public Object e(int i3) {
        return f(i3, null);
    }

    public Object f(int i3, Object obj) {
        Object obj2;
        int a3 = AbstractC0453c.a(this.f12380f, this.f12382h, i3);
        return (a3 < 0 || (obj2 = this.f12381g[a3]) == f12378i) ? obj : obj2;
    }

    public int g(Object obj) {
        if (this.f12379e) {
            d();
        }
        for (int i3 = 0; i3 < this.f12382h; i3++) {
            if (this.f12381g[i3] == obj) {
                return i3;
            }
        }
        return -1;
    }

    public int h(int i3) {
        if (this.f12379e) {
            d();
        }
        return this.f12380f[i3];
    }

    public void i(int i3, Object obj) {
        int a3 = AbstractC0453c.a(this.f12380f, this.f12382h, i3);
        if (a3 >= 0) {
            this.f12381g[a3] = obj;
            return;
        }
        int i4 = ~a3;
        int i5 = this.f12382h;
        if (i4 < i5) {
            Object[] objArr = this.f12381g;
            if (objArr[i4] == f12378i) {
                this.f12380f[i4] = i3;
                objArr[i4] = obj;
                return;
            }
        }
        if (this.f12379e && i5 >= this.f12380f.length) {
            d();
            i4 = ~AbstractC0453c.a(this.f12380f, this.f12382h, i3);
        }
        int i6 = this.f12382h;
        if (i6 >= this.f12380f.length) {
            int e3 = AbstractC0453c.e(i6 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.f12380f;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f12381g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f12380f = iArr;
            this.f12381g = objArr2;
        }
        int i7 = this.f12382h;
        if (i7 - i4 != 0) {
            int[] iArr3 = this.f12380f;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr4 = this.f12381g;
            System.arraycopy(objArr4, i4, objArr4, i8, this.f12382h - i4);
        }
        this.f12380f[i4] = i3;
        this.f12381g[i4] = obj;
        this.f12382h++;
    }

    public int j() {
        if (this.f12379e) {
            d();
        }
        return this.f12382h;
    }

    public Object k(int i3) {
        if (this.f12379e) {
            d();
        }
        return this.f12381g[i3];
    }

    public String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12382h * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f12382h; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(h(i3));
            sb.append('=');
            Object k3 = k(i3);
            if (k3 != this) {
                sb.append(k3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public h(int i3) {
        this.f12379e = false;
        if (i3 == 0) {
            this.f12380f = AbstractC0453c.f12340a;
            this.f12381g = AbstractC0453c.f12342c;
        } else {
            int e3 = AbstractC0453c.e(i3);
            this.f12380f = new int[e3];
            this.f12381g = new Object[e3];
        }
    }
}
