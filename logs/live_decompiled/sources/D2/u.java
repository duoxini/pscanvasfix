package D2;

import p2.InterfaceC0503c;

/* loaded from: classes.dex */
public abstract class u {
    public static Object a(Object obj, int i3) {
        if (obj != null && !c(obj, i3)) {
            f(obj, "kotlin.jvm.functions.Function" + i3);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof C2.a) {
            return 0;
        }
        if (obj instanceof C2.l) {
            return 1;
        }
        if (obj instanceof C2.p) {
            return 2;
        }
        if (obj instanceof C2.q) {
            return 3;
        }
        return obj instanceof C2.r ? 4 : -1;
    }

    public static boolean c(Object obj, int i3) {
        return (obj instanceof InterfaceC0503c) && b(obj) == i3;
    }

    private static Throwable d(Throwable th) {
        return k.i(th, u.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw ((ClassCastException) d(classCastException));
    }

    public static void f(Object obj, String str) {
        g((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void g(String str) {
        throw e(new ClassCastException(str));
    }
}
