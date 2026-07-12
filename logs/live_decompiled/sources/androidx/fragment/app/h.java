package androidx.fragment.app;

import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final m.g f5438a = new m.g();

    static boolean b(ClassLoader classLoader, String str) {
        try {
            return Fragment.class.isAssignableFrom(c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static Class c(ClassLoader classLoader, String str) {
        m.g gVar = f5438a;
        m.g gVar2 = (m.g) gVar.get(classLoader);
        if (gVar2 == null) {
            gVar2 = new m.g();
            gVar.put(classLoader, gVar2);
        }
        Class cls = (Class) gVar2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        gVar2.put(str, cls2);
        return cls2;
    }

    public static Class d(ClassLoader classLoader, String str) {
        try {
            return c(classLoader, str);
        } catch (ClassCastException e3) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e3);
        } catch (ClassNotFoundException e4) {
            throw new Fragment.j("Unable to instantiate fragment " + str + ": make sure class name exists", e4);
        }
    }

    public abstract Fragment a(ClassLoader classLoader, String str);
}
