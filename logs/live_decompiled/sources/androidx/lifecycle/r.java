package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static Map f5820a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static Map f5821b = new HashMap();

    private static InterfaceC0270f a(Constructor constructor, Object obj) {
        try {
            androidx.appcompat.app.p.a(constructor.newInstance(obj));
            return null;
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    private static Constructor b(Class cls) {
        try {
            Package r02 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r02 != null ? r02.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c3 = c(canonicalName);
            if (!name.isEmpty()) {
                c3 = name + "." + c3;
            }
            Constructor<?> declaredConstructor = Class.forName(c3).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class cls) {
        Integer num = (Integer) f5820a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g3 = g(cls);
        f5820a.put(cls, Integer.valueOf(g3));
        return g3;
    }

    private static boolean e(Class cls) {
        return cls != null && n.class.isAssignableFrom(cls);
    }

    static l f(Object obj) {
        boolean z3 = obj instanceof l;
        boolean z4 = obj instanceof InterfaceC0269e;
        if (z3 && z4) {
            return new FullLifecycleObserverAdapter((InterfaceC0269e) obj, (l) obj);
        }
        if (z4) {
            return new FullLifecycleObserverAdapter((InterfaceC0269e) obj, null);
        }
        if (z3) {
            return (l) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f5821b.get(cls);
        if (list.size() == 1) {
            a((Constructor) list.get(0), obj);
            return new SingleGeneratedAdapterObserver(null);
        }
        InterfaceC0270f[] interfaceC0270fArr = new InterfaceC0270f[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            a((Constructor) list.get(i3), obj);
            interfaceC0270fArr[i3] = null;
        }
        return new CompositeGeneratedAdaptersObserver(interfaceC0270fArr);
    }

    private static int g(Class cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor b3 = b(cls);
        if (b3 != null) {
            f5821b.put(cls, Collections.singletonList(b3));
            return 2;
        }
        if (C0266b.f5793c.d(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (!e(superclass)) {
            arrayList = null;
        } else {
            if (d(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList((Collection) f5821b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (e(cls2)) {
                if (d(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll((Collection) f5821b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f5821b.put(cls, arrayList);
        return 2;
    }
}
