package androidx.window.embedding;

import D2.k;
import D2.l;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeActivityEmbeddingComponentProvider$isActivityEmbeddingComponentValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeActivityEmbeddingComponentProvider f7058e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeActivityEmbeddingComponentProvider$isActivityEmbeddingComponentValid$1(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        super(0);
        this.f7058e = safeActivityEmbeddingComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        SafeWindowExtensionsProvider safeWindowExtensionsProvider;
        Class f3;
        safeWindowExtensionsProvider = this.f7058e.f7057d;
        Method method = safeWindowExtensionsProvider.c().getMethod("getActivityEmbeddingComponent", null);
        f3 = this.f7058e.f();
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "getActivityEmbeddingComponentMethod");
        return Boolean.valueOf(reflectionUtils.d(method) && reflectionUtils.c(method, f3));
    }
}
