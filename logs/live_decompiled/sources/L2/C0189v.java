package L2;

/* renamed from: L2.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0189v {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1309a;

    /* renamed from: b, reason: collision with root package name */
    public final C2.l f1310b;

    public C0189v(Object obj, C2.l lVar) {
        this.f1309a = obj;
        this.f1310b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0189v)) {
            return false;
        }
        C0189v c0189v = (C0189v) obj;
        return D2.k.a(this.f1309a, c0189v.f1309a) && D2.k.a(this.f1310b, c0189v.f1310b);
    }

    public int hashCode() {
        Object obj = this.f1309a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f1310b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f1309a + ", onCancellation=" + this.f1310b + ')';
    }
}
