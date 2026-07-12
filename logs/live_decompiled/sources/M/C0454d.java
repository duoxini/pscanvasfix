package m;

/* renamed from: m.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0454d implements Cloneable {

    /* renamed from: i, reason: collision with root package name */
    private static final Object f12343i = new Object();

    /* renamed from: e, reason: collision with root package name */
    private boolean f12344e;

    /* renamed from: f, reason: collision with root package name */
    private long[] f12345f;

    /* renamed from: g, reason: collision with root package name */
    private Object[] f12346g;

    /* renamed from: h, reason: collision with root package name */
    private int f12347h;

    public C0454d() {
        this(10);
    }

    private void d() {
        int i3 = this.f12347h;
        long[] jArr = this.f12345f;
        Object[] objArr = this.f12346g;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            Object obj = objArr[i5];
            if (obj != f12343i) {
                if (i5 != i4) {
                    jArr[i4] = jArr[i5];
                    objArr[i4] = obj;
                    objArr[i5] = null;
                }
                i4++;
            }
        }
        this.f12344e = false;
        this.f12347h = i4;
    }

    public void a() {
        int i3 = this.f12347h;
        Object[] objArr = this.f12346g;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f12347h = 0;
        this.f12344e = false;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0454d clone() {
        try {
            C0454d c0454d = (C0454d) super.clone();
            c0454d.f12345f = (long[]) this.f12345f.clone();
            c0454d.f12346g = (Object[]) this.f12346g.clone();
            return c0454d;
        } catch (CloneNotSupportedException e3) {
            throw new AssertionError(e3);
        }
    }

    public boolean c(long j3) {
        return g(j3) >= 0;
    }

    public Object e(long j3) {
        return f(j3, null);
    }

    public Object f(long j3, Object obj) {
        Object obj2;
        int b3 = AbstractC0453c.b(this.f12345f, this.f12347h, j3);
        return (b3 < 0 || (obj2 = this.f12346g[b3]) == f12343i) ? obj : obj2;
    }

    public int g(long j3) {
        if (this.f12344e) {
            d();
        }
        return AbstractC0453c.b(this.f12345f, this.f12347h, j3);
    }

    public long h(int i3) {
        if (this.f12344e) {
            d();
        }
        return this.f12345f[i3];
    }

    public void i(long j3, Object obj) {
        int b3 = AbstractC0453c.b(this.f12345f, this.f12347h, j3);
        if (b3 >= 0) {
            this.f12346g[b3] = obj;
            return;
        }
        int i3 = ~b3;
        int i4 = this.f12347h;
        if (i3 < i4) {
            Object[] objArr = this.f12346g;
            if (objArr[i3] == f12343i) {
                this.f12345f[i3] = j3;
                objArr[i3] = obj;
                return;
            }
        }
        if (this.f12344e && i4 >= this.f12345f.length) {
            d();
            i3 = ~AbstractC0453c.b(this.f12345f, this.f12347h, j3);
        }
        int i5 = this.f12347h;
        if (i5 >= this.f12345f.length) {
            int f3 = AbstractC0453c.f(i5 + 1);
            long[] jArr = new long[f3];
            Object[] objArr2 = new Object[f3];
            long[] jArr2 = this.f12345f;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f12346g;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f12345f = jArr;
            this.f12346g = objArr2;
        }
        int i6 = this.f12347h;
        if (i6 - i3 != 0) {
            long[] jArr3 = this.f12345f;
            int i7 = i3 + 1;
            System.arraycopy(jArr3, i3, jArr3, i7, i6 - i3);
            Object[] objArr4 = this.f12346g;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f12347h - i3);
        }
        this.f12345f[i3] = j3;
        this.f12346g[i3] = obj;
        this.f12347h++;
    }

    public void j(long j3) {
        int b3 = AbstractC0453c.b(this.f12345f, this.f12347h, j3);
        if (b3 >= 0) {
            Object[] objArr = this.f12346g;
            Object obj = objArr[b3];
            Object obj2 = f12343i;
            if (obj != obj2) {
                objArr[b3] = obj2;
                this.f12344e = true;
            }
        }
    }

    public void k(int i3) {
        Object[] objArr = this.f12346g;
        Object obj = objArr[i3];
        Object obj2 = f12343i;
        if (obj != obj2) {
            objArr[i3] = obj2;
            this.f12344e = true;
        }
    }

    public int l() {
        if (this.f12344e) {
            d();
        }
        return this.f12347h;
    }

    public Object m(int i3) {
        if (this.f12344e) {
            d();
        }
        return this.f12346g[i3];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f12347h * 28);
        sb.append('{');
        for (int i3 = 0; i3 < this.f12347h; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(h(i3));
            sb.append('=');
            Object m3 = m(i3);
            if (m3 != this) {
                sb.append(m3);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public C0454d(int i3) {
        this.f12344e = false;
        if (i3 == 0) {
            this.f12345f = AbstractC0453c.f12341b;
            this.f12346g = AbstractC0453c.f12342c;
        } else {
            int f3 = AbstractC0453c.f(i3);
            this.f12345f = new long[f3];
            this.f12346g = new Object[f3];
        }
    }
}
