package androidx.core.util;

/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f5014a;

    /* renamed from: b, reason: collision with root package name */
    private int f5015b;

    public f(int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f5014a = new Object[i3];
    }

    private boolean c(Object obj) {
        for (int i3 = 0; i3 < this.f5015b; i3++) {
            if (this.f5014a[i3] == obj) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.e
    public boolean a(Object obj) {
        if (c(obj)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.f5015b;
        Object[] objArr = this.f5014a;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.f5015b = i3 + 1;
        return true;
    }

    @Override // androidx.core.util.e
    public Object b() {
        int i3 = this.f5015b;
        if (i3 <= 0) {
            return null;
        }
        int i4 = i3 - 1;
        Object[] objArr = this.f5014a;
        Object obj = objArr[i4];
        objArr[i4] = null;
        this.f5015b = i3 - 1;
        return obj;
    }
}
