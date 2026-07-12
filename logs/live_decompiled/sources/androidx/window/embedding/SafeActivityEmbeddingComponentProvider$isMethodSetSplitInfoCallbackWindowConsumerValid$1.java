package androidx.window.embedding;

import D2.k;
import D2.l;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackWindowConsumerValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeActivityEmbeddingComponentProvider f7063e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackWindowConsumerValid$1(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        super(0);
        this.f7063e = safeActivityEmbeddingComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        Class f3;
        f3 = this.f7063e.f();
        Method method = f3.getMethod("setSplitInfoCallback", Consumer.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "setSplitInfoCallbackMethod");
        return Boolean.valueOf(reflectionUtils.d(method));
    }
}
