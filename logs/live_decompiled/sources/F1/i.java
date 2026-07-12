package f1;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    Object f11589a;

    /* renamed from: b, reason: collision with root package name */
    Object f11590b;

    private static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public void b(Object obj, Object obj2) {
        this.f11589a = obj;
        this.f11590b = obj2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof androidx.core.util.d)) {
            return false;
        }
        androidx.core.util.d dVar = (androidx.core.util.d) obj;
        return a(dVar.f5012a, this.f11589a) && a(dVar.f5013b, this.f11590b);
    }

    public int hashCode() {
        Object obj = this.f11589a;
        int hashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f11590b;
        return hashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f11589a + " " + this.f11590b + "}";
    }
}
