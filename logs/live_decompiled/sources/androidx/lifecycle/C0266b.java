package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0266b {

    /* renamed from: c, reason: collision with root package name */
    static C0266b f5793c = new C0266b();

    /* renamed from: a, reason: collision with root package name */
    private final Map f5794a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f5795b = new HashMap();

    /* renamed from: androidx.lifecycle.b$a */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map f5796a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map f5797b;

        a(Map map) {
            this.f5797b = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0272h.b bVar = (AbstractC0272h.b) entry.getValue();
                List list = (List) this.f5796a.get(bVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f5796a.put(bVar, list);
                }
                list.add((C0087b) entry.getKey());
            }
        }

        private static void b(List list, o oVar, AbstractC0272h.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0087b) list.get(size)).a(oVar, bVar, obj);
                }
            }
        }

        void a(o oVar, AbstractC0272h.b bVar, Object obj) {
            b((List) this.f5796a.get(bVar), oVar, bVar, obj);
            b((List) this.f5796a.get(AbstractC0272h.b.ON_ANY), oVar, bVar, obj);
        }
    }

    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    static final class C0087b {

        /* renamed from: a, reason: collision with root package name */
        final int f5798a;

        /* renamed from: b, reason: collision with root package name */
        final Method f5799b;

        C0087b(int i3, Method method) {
            this.f5798a = i3;
            this.f5799b = method;
            method.setAccessible(true);
        }

        void a(o oVar, AbstractC0272h.b bVar, Object obj) {
            try {
                int i3 = this.f5798a;
                if (i3 == 0) {
                    this.f5799b.invoke(obj, null);
                } else if (i3 == 1) {
                    this.f5799b.invoke(obj, oVar);
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    this.f5799b.invoke(obj, oVar, bVar);
                }
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to call observer method", e4.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0087b)) {
                return false;
            }
            C0087b c0087b = (C0087b) obj;
            return this.f5798a == c0087b.f5798a && this.f5799b.getName().equals(c0087b.f5799b.getName());
        }

        public int hashCode() {
            return (this.f5798a * 31) + this.f5799b.getName().hashCode();
        }
    }

    C0266b() {
    }

    private a a(Class cls, Method[] methodArr) {
        int i3;
        a c3;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c3 = c(superclass)) != null) {
            hashMap.putAll(c3.f5797b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f5797b.entrySet()) {
                e(hashMap, (C0087b) entry.getKey(), (AbstractC0272h.b) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z3 = false;
        for (Method method : methodArr) {
            v vVar = (v) method.getAnnotation(v.class);
            if (vVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i3 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(o.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i3 = 1;
                }
                AbstractC0272h.b value = vVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(AbstractC0272h.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != AbstractC0272h.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i3 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new C0087b(i3, method), value, cls);
                z3 = true;
            }
        }
        a aVar = new a(hashMap);
        this.f5794a.put(cls, aVar);
        this.f5795b.put(cls, Boolean.valueOf(z3));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e3) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
        }
    }

    private void e(Map map, C0087b c0087b, AbstractC0272h.b bVar, Class cls) {
        AbstractC0272h.b bVar2 = (AbstractC0272h.b) map.get(c0087b);
        if (bVar2 == null || bVar == bVar2) {
            if (bVar2 == null) {
                map.put(c0087b, bVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0087b.f5799b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar2 + ", new value " + bVar);
    }

    a c(Class cls) {
        a aVar = (a) this.f5794a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean d(Class cls) {
        Boolean bool = (Boolean) this.f5795b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b3 = b(cls);
        for (Method method : b3) {
            if (((v) method.getAnnotation(v.class)) != null) {
                a(cls, b3);
                return true;
            }
        }
        this.f5795b.put(cls, Boolean.FALSE);
        return false;
    }
}
