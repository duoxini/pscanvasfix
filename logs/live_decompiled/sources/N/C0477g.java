package n;

/* renamed from: n.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0477g implements InterfaceC0476f {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f12508a;

    /* renamed from: b, reason: collision with root package name */
    private int f12509b;

    C0477g(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f12508a = new Object[i3];
    }

    @Override // n.InterfaceC0476f
    public boolean a(Object obj) {
        int i3 = this.f12509b;
        Object[] objArr = this.f12508a;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.f12509b = i3 + 1;
        return true;
    }

    @Override // n.InterfaceC0476f
    public Object b() {
        int i3 = this.f12509b;
        if (i3 <= 0) {
            return null;
        }
        int i4 = i3 - 1;
        Object[] objArr = this.f12508a;
        Object obj = objArr[i4];
        objArr[i4] = null;
        this.f12509b = i3 - 1;
        return obj;
    }

    @Override // n.InterfaceC0476f
    public void c(Object[] objArr, int i3) {
        if (i3 > objArr.length) {
            i3 = objArr.length;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            Object obj = objArr[i4];
            int i5 = this.f12509b;
            Object[] objArr2 = this.f12508a;
            if (i5 < objArr2.length) {
                objArr2[i5] = obj;
                this.f12509b = i5 + 1;
            }
        }
    }
}
