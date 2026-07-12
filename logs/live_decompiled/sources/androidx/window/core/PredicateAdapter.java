package androidx.window.core;

import C2.l;
import C2.p;
import D2.k;
import I2.b;
import I2.c;
import android.annotation.SuppressLint;
import android.util.Pair;
import com.oplus.backup.sdk.common.utils.Constants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@SuppressLint({"BanUncheckedReflection"})
/* loaded from: classes.dex */
public final class PredicateAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final ClassLoader f6965a;

    private static abstract class BaseHandler<T> implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final b f6966a;

        public abstract boolean a(Object obj, Object obj2);

        protected final boolean b(Method method, Object[] objArr) {
            k.e(method, "<this>");
            return k.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        protected final boolean c(Method method, Object[] objArr) {
            k.e(method, "<this>");
            return k.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        protected final boolean d(Method method, Object[] objArr) {
            k.e(method, "<this>");
            return k.a(method.getName(), "test") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1;
        }

        protected final boolean e(Method method, Object[] objArr) {
            k.e(method, "<this>");
            return k.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            k.e(obj, "obj");
            k.e(method, Constants.MessagerConstants.METHOD_KEY);
            if (d(method, objArr)) {
                return Boolean.valueOf(a(obj, c.a(this.f6966a, objArr != null ? objArr[0] : null)));
            }
            if (b(method, objArr)) {
                Object obj2 = objArr != null ? objArr[0] : null;
                k.b(obj2);
                return Boolean.valueOf(obj == obj2);
            }
            if (c(method, objArr)) {
                return Integer.valueOf(hashCode());
            }
            if (e(method, objArr)) {
                return toString();
            }
            throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
        }
    }

    private static final class PairPredicateStubHandler<T, U> extends BaseHandler<Pair<?, ?>> {

        /* renamed from: b, reason: collision with root package name */
        private final b f6967b;

        /* renamed from: c, reason: collision with root package name */
        private final b f6968c;

        /* renamed from: d, reason: collision with root package name */
        private final p f6969d;

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public boolean a(Object obj, Pair pair) {
            k.e(obj, "obj");
            k.e(pair, "parameter");
            return ((Boolean) this.f6969d.invoke(c.a(this.f6967b, pair.first), c.a(this.f6968c, pair.second))).booleanValue();
        }

        public int hashCode() {
            return this.f6969d.hashCode();
        }

        public String toString() {
            return this.f6969d.toString();
        }
    }

    private static final class PredicateStubHandler<T> extends BaseHandler<T> {

        /* renamed from: b, reason: collision with root package name */
        private final l f6970b;

        @Override // androidx.window.core.PredicateAdapter.BaseHandler
        public boolean a(Object obj, Object obj2) {
            k.e(obj, "obj");
            k.e(obj2, "parameter");
            return ((Boolean) this.f6970b.f(obj2)).booleanValue();
        }

        public int hashCode() {
            return this.f6970b.hashCode();
        }

        public String toString() {
            return this.f6970b.toString();
        }
    }

    public PredicateAdapter(ClassLoader classLoader) {
        k.e(classLoader, "loader");
        this.f6965a = classLoader;
    }
}
