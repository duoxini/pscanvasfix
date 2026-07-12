package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import q2.AbstractC0538h;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public abstract class D {

    /* renamed from: a, reason: collision with root package name */
    private static final List f5701a = AbstractC0544n.l(Application.class, y.class);

    /* renamed from: b, reason: collision with root package name */
    private static final List f5702b = AbstractC0544n.d(y.class);

    public static final Constructor c(Class cls, List list) {
        D2.k.e(cls, "modelClass");
        D2.k.e(list, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        D2.k.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            D2.k.d(parameterTypes, "constructor.parameterTypes");
            List G3 = AbstractC0538h.G(parameterTypes);
            if (D2.k.a(list, G3)) {
                return constructor;
            }
            if (list.size() == G3.size() && G3.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final E d(Class cls, Constructor constructor, Object... objArr) {
        D2.k.e(cls, "modelClass");
        D2.k.e(constructor, "constructor");
        D2.k.e(objArr, "params");
        try {
            return (E) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Failed to access " + cls, e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e5.getCause());
        }
    }
}
