package androidx.window.area;

import D2.k;
import D2.l;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeWindowAreaComponentProvider$isWindowAreaProviderValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f6860e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ SafeWindowAreaComponentProvider f6861f;

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        boolean z3;
        Class b3;
        Method method = this.f6860e.getClass().getMethod("getWindowAreaComponent", null);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "getWindowAreaComponentMethod");
        if (reflectionUtils.d(method)) {
            b3 = this.f6861f.b();
            if (reflectionUtils.c(method, b3)) {
                z3 = true;
                return Boolean.valueOf(z3);
            }
        }
        z3 = false;
        return Boolean.valueOf(z3);
    }
}
