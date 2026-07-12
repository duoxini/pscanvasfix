package androidx.core.util;

/* loaded from: classes.dex */
public abstract class h {
    public static void a(boolean z3, Object obj) {
        if (!z3) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int b(int i3) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException();
    }

    public static int c(int i3, String str) {
        if (i3 >= 0) {
            return i3;
        }
        throw new IllegalArgumentException(str);
    }

    public static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object e(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static void f(boolean z3, String str) {
        if (!z3) {
            throw new IllegalStateException(str);
        }
    }
}
