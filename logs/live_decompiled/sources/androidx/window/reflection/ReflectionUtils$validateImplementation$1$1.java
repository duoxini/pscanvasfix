package androidx.window.reflection;

import C2.a;
import D2.k;
import D2.l;
import java.lang.reflect.Method;
import java.util.Arrays;

/* loaded from: classes.dex */
final class ReflectionUtils$validateImplementation$1$1 extends l implements a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Class f7267e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Method f7268f;

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        boolean z3;
        Class cls = this.f7267e;
        String name = this.f7268f.getName();
        Class<?>[] parameterTypes = this.f7268f.getParameterTypes();
        Method method = cls.getMethod(name, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length));
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "implementedMethod");
        if (reflectionUtils.d(method)) {
            Class<?> returnType = this.f7268f.getReturnType();
            k.d(returnType, "it.returnType");
            if (reflectionUtils.c(method, returnType)) {
                z3 = true;
                return Boolean.valueOf(z3);
            }
        }
        z3 = false;
        return Boolean.valueOf(z3);
    }
}
