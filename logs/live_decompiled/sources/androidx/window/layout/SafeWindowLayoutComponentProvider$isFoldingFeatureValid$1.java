package androidx.window.layout;

import D2.k;
import D2.l;
import D2.s;
import android.graphics.Rect;
import androidx.window.reflection.ReflectionUtils;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1 extends l implements C2.a {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ SafeWindowLayoutComponentProvider f7166e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1(SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider) {
        super(0);
        this.f7166e = safeWindowLayoutComponentProvider;
    }

    @Override // C2.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke() {
        Class f3;
        boolean z3;
        f3 = this.f7166e.f();
        Method method = f3.getMethod("getBounds", null);
        Method method2 = f3.getMethod("getType", null);
        Method method3 = f3.getMethod("getState", null);
        ReflectionUtils reflectionUtils = ReflectionUtils.f7266a;
        k.d(method, "getBoundsMethod");
        if (reflectionUtils.b(method, s.b(Rect.class)) && reflectionUtils.d(method)) {
            k.d(method2, "getTypeMethod");
            Class cls = Integer.TYPE;
            if (reflectionUtils.b(method2, s.b(cls)) && reflectionUtils.d(method2)) {
                k.d(method3, "getStateMethod");
                if (reflectionUtils.b(method3, s.b(cls)) && reflectionUtils.d(method3)) {
                    z3 = true;
                    return Boolean.valueOf(z3);
                }
            }
        }
        z3 = false;
        return Boolean.valueOf(z3);
    }
}
