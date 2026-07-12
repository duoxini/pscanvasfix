package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;

/* loaded from: classes.dex */
final class SavedStateHandleController implements l {

    /* renamed from: e, reason: collision with root package name */
    private final String f5786e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5787f = false;

    /* renamed from: g, reason: collision with root package name */
    private final y f5788g;

    SavedStateHandleController(String str, y yVar) {
        this.f5786e = str;
        this.f5788g = yVar;
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        if (bVar == AbstractC0272h.b.ON_DESTROY) {
            this.f5787f = false;
            oVar.getLifecycle().c(this);
        }
    }

    void b(M.c cVar, AbstractC0272h abstractC0272h) {
        if (this.f5787f) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f5787f = true;
        abstractC0272h.a(this);
        cVar.h(this.f5786e, this.f5788g.d());
    }

    y c() {
        return this.f5788g;
    }

    boolean d() {
        return this.f5787f;
    }
}
