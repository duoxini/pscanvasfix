package androidx.window.core;

import C2.l;
import D2.k;
import I2.b;
import I2.c;
import android.annotation.SuppressLint;
import android.app.Activity;
import com.oplus.backup.sdk.common.utils.Constants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import p2.q;

@SuppressLint({"BanUncheckedReflection"})
/* loaded from: classes.dex */
public final class ConsumerAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f6944a;

    private static final class ConsumerHandler<T> implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final b f6945a;

        /* renamed from: b, reason: collision with root package name */
        private final l f6946b;

        public ConsumerHandler(b bVar, l lVar) {
            k.e(bVar, "clazz");
            k.e(lVar, "consumer");
            this.f6945a = bVar;
            this.f6946b = lVar;
        }

        private final boolean b(Method method, Object[] objArr) {
            return k.a(method.getName(), "accept") && objArr != null && objArr.length == 1;
        }

        private final boolean c(Method method, Object[] objArr) {
            return k.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        private final boolean d(Method method, Object[] objArr) {
            return k.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        private final boolean e(Method method, Object[] objArr) {
            return k.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        public final void a(Object obj) {
            k.e(obj, "parameter");
            this.f6946b.f(obj);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            k.e(obj, "obj");
            k.e(method, Constants.MessagerConstants.METHOD_KEY);
            if (b(method, objArr)) {
                a(c.a(this.f6945a, objArr != null ? objArr[0] : null));
                return q.f12810a;
            }
            if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            }
            if (d(method, objArr)) {
                return Integer.valueOf(this.f6946b.hashCode());
            }
            if (e(method, objArr)) {
                return this.f6946b.toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    public interface Subscription {
        void a();
    }

    public ConsumerAdapter(ClassLoader classLoader) {
        k.e(classLoader, "loader");
        this.f6944a = classLoader;
    }

    private final Object b(b bVar, l lVar) {
        Object newProxyInstance = Proxy.newProxyInstance(this.f6944a, new Class[]{e()}, new ConsumerHandler(bVar, lVar));
        k.d(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return newProxyInstance;
    }

    private final Class e() {
        Class<?> loadClass = this.f6944a.loadClass("java.util.function.Consumer");
        k.d(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }

    public final void a(Object obj, b bVar, String str, l lVar) {
        k.e(obj, "obj");
        k.e(bVar, "clazz");
        k.e(str, "methodName");
        k.e(lVar, "consumer");
        obj.getClass().getMethod(str, e()).invoke(obj, b(bVar, lVar));
    }

    public final Class c() {
        try {
            return e();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final Subscription d(final Object obj, b bVar, String str, String str2, Activity activity, l lVar) {
        k.e(obj, "obj");
        k.e(bVar, "clazz");
        k.e(str, "addMethodName");
        k.e(str2, "removeMethodName");
        k.e(activity, "activity");
        k.e(lVar, "consumer");
        final Object b3 = b(bVar, lVar);
        obj.getClass().getMethod(str, Activity.class, e()).invoke(obj, activity, b3);
        final Method method = obj.getClass().getMethod(str2, e());
        return new Subscription() { // from class: androidx.window.core.ConsumerAdapter$createSubscription$1
            @Override // androidx.window.core.ConsumerAdapter.Subscription
            public void a() {
                method.invoke(obj, b3);
            }
        };
    }
}
