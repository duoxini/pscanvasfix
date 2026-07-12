package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.C0266b;

@Deprecated
/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements l {

    /* renamed from: e, reason: collision with root package name */
    private final Object f5751e;

    /* renamed from: f, reason: collision with root package name */
    private final C0266b.a f5752f;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f5751e = obj;
        this.f5752f = C0266b.f5793c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        this.f5752f.a(oVar, bVar, this.f5751e);
    }
}
