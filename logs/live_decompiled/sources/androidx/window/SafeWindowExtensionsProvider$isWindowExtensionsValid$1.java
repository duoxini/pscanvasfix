package androidx.window;

import C2.a;
import D2.k;
import D2.l;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeWindowExtensionsProvider$isWindowExtensionsValid$1 extends l implements a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeWindowExtensionsProvider f6849e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeWindowExtensionsProvider$isWindowExtensionsValid$1(SafeWindowExtensionsProvider safeWindowExtensionsProvider) {
        super(0);
        this.f6849e = safeWindowExtensionsProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        Class d3;
        d3 = this.f6849e.d();
        Method declaredMethod = d3.getDeclaredMethod("getWindowExtensions", null);
        Class c3 = this.f6849e.c();
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(declaredMethod, "getWindowExtensionsMethod");
        return Boolean.valueOf(reflectionUtils.c(declaredMethod, c3) && reflectionUtils.d(declaredMethod));
    }
}
