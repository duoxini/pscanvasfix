package D2;

/* loaded from: classes.dex */
public class t {
    public I2.e a(i iVar) {
        return iVar;
    }

    public I2.b b(Class cls) {
        return new e(cls);
    }

    public I2.d c(Class cls, String str) {
        return new m(cls, str);
    }

    public I2.f d(n nVar) {
        return nVar;
    }

    public String e(h hVar) {
        String obj = hVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String f(l lVar) {
        return e(lVar);
    }
}
