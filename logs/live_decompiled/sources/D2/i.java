package D2;

/* loaded from: classes.dex */
public abstract class i extends c implements h, I2.e {

    /* renamed from: l, reason: collision with root package name */
    private final int f331l;

    /* renamed from: m, reason: collision with root package name */
    private final int f332m;

    public i(int i3, Object obj, Class cls, String str, String str2, int i4) {
        super(obj, cls, str, str2, (i4 & 1) == 1);
        this.f331l = i3;
        this.f332m = i4 >> 1;
    }

    @Override // D2.c
    protected I2.a b() {
        return s.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return d().equals(iVar.d()) && h().equals(iVar.h()) && this.f332m == iVar.f332m && this.f331l == iVar.f331l && k.a(c(), iVar.c()) && k.a(g(), iVar.g());
        }
        if (obj instanceof I2.e) {
            return obj.equals(a());
        }
        return false;
    }

    @Override // D2.h
    public int getArity() {
        return this.f331l;
    }

    public int hashCode() {
        return (((g() == null ? 0 : g().hashCode() * 31) + d().hashCode()) * 31) + h().hashCode();
    }

    public String toString() {
        I2.a a3 = a();
        if (a3 != this) {
            return a3.toString();
        }
        if ("<init>".equals(d())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + d() + " (Kotlin reflection is not available)";
    }
}
