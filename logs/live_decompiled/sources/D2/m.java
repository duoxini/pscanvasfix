package D2;

/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Class f333a;

    /* renamed from: b, reason: collision with root package name */
    private final String f334b;

    public m(Class cls, String str) {
        k.e(cls, "jClass");
        k.e(str, "moduleName");
        this.f333a = cls;
        this.f334b = str;
    }

    @Override // D2.d
    public Class c() {
        return this.f333a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(c(), ((m) obj).c());
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
