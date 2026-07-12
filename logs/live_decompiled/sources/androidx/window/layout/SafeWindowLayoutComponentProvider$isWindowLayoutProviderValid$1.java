package androidx.window.layout;

import D2.k;
import D2.l;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeWindowLayoutComponentProvider f7169e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1(SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider) {
        super(0);
        this.f7169e = safeWindowLayoutComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        SafeWindowExtensionsProvider safeWindowExtensionsProvider;
        Class h3;
        safeWindowExtensionsProvider = this.f7169e.f7165c;
        Method method = safeWindowExtensionsProvider.c().getMethod("getWindowLayoutComponent", null);
        h3 = this.f7169e.h();
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "getWindowLayoutComponentMethod");
        return Boolean.valueOf(reflectionUtils.d(method) && reflectionUtils.c(method, h3));
    }
}
