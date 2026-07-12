package androidx.lifecycle;

import L2.O;
import L2.v0;

/* loaded from: classes.dex */
public abstract class m {
    public static final AbstractC0273i a(AbstractC0272h abstractC0272h) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        D2.k.e(abstractC0272h, "<this>");
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) abstractC0272h.f5800a.get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(abstractC0272h, v0.b(null, 1, null).p(O.c().f0()));
        } while (!abstractC0272h.f5800a.compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.c();
        return lifecycleCoroutineScopeImpl;
    }
}
