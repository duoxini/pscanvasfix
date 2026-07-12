package androidx.window.layout;

import D2.k;
import D2.l;
import android.app.Activity;
import androidx.window.core.ConsumerAdapter;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerJavaConsumerValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeWindowLayoutComponentProvider f7167e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isMethodWindowLayoutInfoListenerJavaConsumerValid$1(SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider) {
        super(0);
        this.f7167e = safeWindowLayoutComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        ConsumerAdapter consumerAdapter;
        Class h3;
        boolean z3;
        consumerAdapter = this.f7167e.f7164b;
        Class c3 = consumerAdapter.c();
        if (c3 == null) {
            return Boolean.FALSE;
        }
        h3 = this.f7167e.h();
        Method method = h3.getMethod("addWindowLayoutInfoListener", Activity.class, c3);
        Method method2 = h3.getMethod("removeWindowLayoutInfoListener", c3);
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
