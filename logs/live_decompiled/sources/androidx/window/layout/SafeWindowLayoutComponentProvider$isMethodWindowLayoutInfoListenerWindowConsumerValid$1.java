package androidx.window.layout;

import D2.k;
import D2.l;
import android.content.Context;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerWindowConsumerValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeWindowLayoutComponentProvider f7168e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerWindowConsumerValid$1(SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider) {
        super(0);
        this.f7168e = safeWindowLayoutComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        Class h3;
        boolean z3;
        h3 = this.f7168e.h();
        Method method = h3.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
        Method method2 = h3.getMethod("removeWindowLayoutInfoListener", Consumer.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "addListenerMethod");
        if (reflectionUtils.d(method)) {
            k.d(method2, "removeListenerMethod");
            if (reflectionUtils.d(method2)) {
                z3 = true;
                return Boolean.valueOf(z3);
            }
        }
        z3 = false;
        return Boolean.valueOf(z3);
    }
}
