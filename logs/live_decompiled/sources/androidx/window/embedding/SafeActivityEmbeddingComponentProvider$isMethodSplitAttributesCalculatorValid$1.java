package androidx.window.embedding;

import D2.k;
import D2.l;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeActivityEmbeddingComponentProvider$isMethodSplitAttributesCalculatorValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeActivityEmbeddingComponentProvider f7064e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeActivityEmbeddingComponentProvider$isMethodSplitAttributesCalculatorValid$1(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        super(0);
        this.f7064e = safeActivityEmbeddingComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        Class f3;
        Class f4;
        boolean z3;
        f3 = this.f7064e.f();
        Method method = f3.getMethod("setSplitAttributesCalculator", Function.class);
        f4 = this.f7064e.f();
        Method method2 = f4.getMethod("clearSplitAttributesCalculator", null);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "setSplitAttributesCalculatorMethod");
        if (reflectionUtils.d(method)) {
            k.d(method2, "clearSplitAttributesCalculatorMethod");
            if (reflectionUtils.d(method2)) {
                z3 = true;
                return Boolean.valueOf(z3);
            }
        }
        z3 = false;
        return Boolean.valueOf(z3);
    }
}
