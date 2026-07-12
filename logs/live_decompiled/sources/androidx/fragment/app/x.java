package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.H;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0271g;

/* loaded from: classes.dex */
class x implements InterfaceC0271g, M.e, I {

    /* renamed from: e, reason: collision with root package name */
    private final Fragment f5652e;

    /* renamed from: f, reason: collision with root package name */
    private final H f5653f;

    /* renamed from: g, reason: collision with root package name */
    private androidx.lifecycle.q f5654g = null;

    /* renamed from: h, reason: collision with root package name */
    private M.d f5655h = null;

    x(Fragment fragment, H h3) {
        this.f5652e = fragment;
        this.f5653f = h3;
    }

    void a(AbstractC0272h.b bVar) {
        this.f5654g.h(bVar);
    }

    void b() {
        if (this.f5654g == null) {
            this.f5654g = new androidx.lifecycle.q(this);
            this.f5655h = M.d.a(this);
        }
    }

    boolean c() {
        return this.f5654g != null;
    }

    void d(Bundle bundle) {
        this.f5655h.d(bundle);
    }

    void e(Bundle bundle) {
        this.f5655h.e(bundle);
    }

    void f(AbstractC0272h.c cVar) {
        this.f5654g.o(cVar);
    }

    @Override // androidx.lifecycle.o
    public AbstractC0272h getLifecycle() {
        b();
        return this.f5654g;
    }

    @Override // M.e
    public M.c getSavedStateRegistry() {
        b();
        return this.f5655h.b();
    }

    @Override // androidx.lifecycle.I
    public H getViewModelStore() {
        b();
        return this.f5653f;
    }
}
