package v2;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f13853a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final a f13854b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    private static a f13855c;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f13856a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f13857b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f13858c;

        public a(Method method, Method method2, Method method3) {
            this.f13856a = method;
            this.f13857b = method2;
            this.f13858c = method3;
        }
    }

    private i() {
    }

    private final a a(AbstractC0610a abstractC0610a) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", null), abstractC0610a.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), abstractC0610a.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            f13855c = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f13854b;
            f13855c = aVar2;
            return aVar2;
        }
    }

    public final String b(AbstractC0610a abstractC0610a) {
        D2.k.e(abstractC0610a, "continuation");
        a aVar = f13855c;
        if (aVar == null) {
            aVar = a(abstractC0610a);
        }
        if (aVar == f13854b) {
            return null;
        }
        Method method = aVar.f13856a;
        Object invoke = method != null ? method.invoke(abstractC0610a.getClass(), null) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar.f13857b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, null) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar.f13858c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
