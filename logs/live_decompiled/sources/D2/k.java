package D2;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class k {
    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj) {
        if (obj == null) {
            j();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            k(str);
        }
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) h(new NullPointerException(str + " must not be null")));
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            l(str);
        }
    }

    public static int f(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 == i4 ? 0 : 1;
    }

    private static String g(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = k.class.getName();
        int i3 = 0;
        while (!stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        while (stackTrace[i3].getClassName().equals(name)) {
            i3++;
        }
        StackTraceElement stackTraceElement = stackTrace[i3];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    private static Throwable h(Throwable th) {
        return i(th, k.class.getName());
    }

    static Throwable i(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            if (str.equals(stackTrace[i4].getClassName())) {
                i3 = i4;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i3 + 1, length));
        return th;
    }

    public static void j() {
        throw ((NullPointerException) h(new NullPointerException()));
    }

    public static void k(String str) {
        throw ((NullPointerException) h(new NullPointerException(str)));
    }

    private static void l(String str) {
        throw ((NullPointerException) h(new NullPointerException(g(str))));
    }

    public static void m(String str) {
        throw ((p2.p) h(new p2.p(str)));
    }

    public static void n(String str) {
        m("lateinit property " + str + " has not been initialized");
    }
}
