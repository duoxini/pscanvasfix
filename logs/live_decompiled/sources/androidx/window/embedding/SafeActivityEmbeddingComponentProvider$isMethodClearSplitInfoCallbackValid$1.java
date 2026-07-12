package androidx.window.embedding;

import D2.k;
import D2.l;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeActivityEmbeddingComponentProvider$isMethodClearSplitInfoCallbackValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeActivityEmbeddingComponentProvider f7059e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeActivityEmbeddingComponentProvider$isMethodClearSplitInfoCallbackValid$1(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        super(0);
        this.f7059e = safeActivityEmbeddingComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        Class f3;
        f3 = this.f7059e.f();
        Method method = f3.getMethod("clearSplitInfoCallback", null);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "clearSplitInfoCallbackMethod");
        return Boolean.valueOf(reflectionUtils.d(method));
    }
}
