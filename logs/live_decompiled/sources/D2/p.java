package D2;

/* loaded from: classes.dex */
public abstract class p extends c implements I2.g {

    /* renamed from: l, reason: collision with root package name */
    private final boolean f335l;

    public p(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f335l = (i3 & 2) == 2;
    }

    @Override // D2.c
    public I2.a a() {
        return this.f335l ? this : super.a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return g().equals(pVar.g()) && d().equals(pVar.d()) && h().equals(pVar.h()) && k.a(c(), pVar.c());
        }
        if (obj instanceof I2.g) {
            return obj.equals(a());
        }
        return false;
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + d().hashCode()) * 31) + h().hashCode();
    }

    public String toString() {
        I2.a a3 = a();
        if (a3 != this) {
            return a3.toString();
        }
        return "property " + d() + " (Kotlin reflection is not available)";
    }
}
