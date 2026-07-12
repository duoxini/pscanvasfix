package androidx.appcompat.widget;

/* loaded from: classes.dex */
class N {

    /* renamed from: a, reason: collision with root package name */
    private int f3982a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f3983b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f3984c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    private int f3985d = Integer.MIN_VALUE;

    /* renamed from: e, reason: collision with root package name */
    private int f3986e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f3987f = 0;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3988g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3989h = false;

    N() {
    }

    public int a() {
        return this.f3988g ? this.f3982a : this.f3983b;
    }

    public int b() {
        return this.f3982a;
    }

    public int c() {
        return this.f3983b;
    }

    public int d() {
        return this.f3988g ? this.f3983b : this.f3982a;
    }

    public void e(int i3, int i4) {
        this.f3989h = false;
        if (i3 != Integer.MIN_VALUE) {
            this.f3986e = i3;
            this.f3982a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f3987f = i4;
            this.f3983b = i4;
        }
    }

    public void f(boolean z3) {
        if (z3 == this.f3988g) {
            return;
        }
        this.f3988g = z3;
        if (!this.f3989h) {
            this.f3982a = this.f3986e;
            this.f3983b = this.f3987f;
            return;
        }
        if (z3) {
            int i3 = this.f3985d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = this.f3986e;
            }
            this.f3982a = i3;
            int i4 = this.f3984c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = this.f3987f;
            }
            this.f3983b = i4;
            return;
        }
        int i5 = this.f3984c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = this.f3986e;
        }
        this.f3982a = i5;
        int i6 = this.f3985d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = this.f3987f;
        }
        this.f3983b = i6;
    }

    public void g(int i3, int i4) {
        this.f3984c = i3;
        this.f3985d = i4;
        this.f3989h = true;
        if (this.f3988g) {
            if (i4 != Integer.MIN_VALUE) {
                this.f3982a = i4;
            }
            if (i3 != Integer.MIN_VALUE) {
                this.f3983b = i3;
                return;
            }
            return;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3982a = i3;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f3983b = i4;
        }
    }
}
