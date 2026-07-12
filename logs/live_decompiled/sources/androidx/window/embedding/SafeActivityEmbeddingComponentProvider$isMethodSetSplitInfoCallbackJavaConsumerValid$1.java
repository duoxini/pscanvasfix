package androidx.window.embedding;

import D2.k;
import D2.l;
import androidx.window.core.ConsumerAdapter;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackJavaConsumerValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeActivityEmbeddingComponentProvider f7062e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeActivityEmbeddingComponentProvider$isMethodSetSplitInfoCallbackJavaConsumerValid$1(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        super(0);
        this.f7062e = safeActivityEmbeddingComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        ConsumerAdapter consumerAdapter;
        Class f3;
        consumerAdapter = this.f7062e.f7055b;
        Class c3 = consumerAdapter.c();
        if (c3 == null) {
            return Boolean.FALSE;
        }
        f3 = this.f7062e.f();
        Method method = f3.getMethod("setSplitInfoCallback", c3);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "setSplitInfoCallbackMethod");
        return Boolean.valueOf(reflectionUtils.d(method));
    }
}
