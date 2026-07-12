package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public abstract class RepeatOnLifecycleKt {
    public static final Object a(AbstractC0272h abstractC0272h, AbstractC0272h.c cVar, C2.p pVar, InterfaceC0593d interfaceC0593d) {
        Object a3;
        if (cVar != AbstractC0272h.c.INITIALIZED) {
            return (abstractC0272h.b() != AbstractC0272h.c.DESTROYED && (a3 = L2.E.a(new RepeatOnLifecycleKt$repeatOnLifecycle$3(abstractC0272h, cVar, pVar, null), interfaceC0593d)) == AbstractC0603b.c()) ? a3 : p2.q.f12810a;
        }
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }
}
