package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;

/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements l {

    /* renamed from: e, reason: collision with root package name */
    private final A f5785e;

    public SavedStateHandleAttacher(A a3) {
        D2.k.e(a3, "provider");
        this.f5785e = a3;
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        D2.k.e(oVar, "source");
        D2.k.e(bVar, "event");
        if (bVar == AbstractC0272h.b.ON_CREATE) {
            oVar.getLifecycle().c(this);
            this.f5785e.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + bVar).toString());
        }
    }
}
