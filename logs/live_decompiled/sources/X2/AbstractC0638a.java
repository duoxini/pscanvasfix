package x2;

import D2.k;
import java.lang.reflect.Method;
import q2.AbstractC0538h;

/* renamed from: x2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0638a {

    /* renamed from: x2.a$a, reason: collision with other inner class name */
    private static final class C0157a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0157a f14436a = new C0157a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f14437b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f14438c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            k.b(methods);
            int length = methods.length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                method = null;
                if (i4 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i4];
                if (k.a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    k.d(parameterTypes, "getParameterTypes(...)");
                    if (k.a(AbstractC0538h.E(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i4++;
            }
            f14437b = method2;
            int length2 = methods.length;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                Method method3 = methods[i3];
                if (k.a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i3++;
            }
            f14438c = method;
        }

        private C0157a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        k.e(th, "cause");
        k.e(th2, "exception");
        Method method = C0157a.f14437b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public F2.c b() {
        return new F2.b();
    }
}
