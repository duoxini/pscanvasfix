package D2;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final t f338a;

    /* renamed from: b, reason: collision with root package name */
    private static final I2.b[] f339b;

    static {
        t tVar = null;
        try {
            tVar = (t) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (tVar == null) {
            tVar = new t();
        }
        f338a = tVar;
        f339b = new I2.b[0];
    }

    public static I2.e a(i iVar) {
        return f338a.a(iVar);
    }

    public static I2.b b(Class cls) {
        return f338a.b(cls);
    }

    public static I2.d c(Class cls) {
        return f338a.c(cls, "");
    }

    public static I2.f d(n nVar) {
        return f338a.d(nVar);
    }

    public static String e(h hVar) {
        return f338a.e(hVar);
    }

    public static String f(l lVar) {
        return f338a.f(lVar);
    }
}
