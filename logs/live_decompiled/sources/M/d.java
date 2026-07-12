package M;

import D2.g;
import D2.k;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import androidx.savedstate.Recreator;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1328d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final e f1329a;

    /* renamed from: b, reason: collision with root package name */
    private final c f1330b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1331c;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        public final d a(e eVar) {
            k.e(eVar, "owner");
            return new d(eVar, null);
        }

        private a() {
        }
    }

    public /* synthetic */ d(e eVar, g gVar) {
        this(eVar);
    }

    public static final d a(e eVar) {
        return f1328d.a(eVar);
    }

    public final c b() {
        return this.f1330b;
    }

    public final void c() {
        AbstractC0272h lifecycle = this.f1329a.getLifecycle();
        k.d(lifecycle, "owner.lifecycle");
        if (lifecycle.b() != AbstractC0272h.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f1329a));
        this.f1330b.e(lifecycle);
        this.f1331c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f1331c) {
            c();
        }
        AbstractC0272h lifecycle = this.f1329a.getLifecycle();
        k.d(lifecycle, "owner.lifecycle");
        if (!lifecycle.b().a(AbstractC0272h.c.STARTED)) {
            this.f1330b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycle.b()).toString());
    }

    public final void e(Bundle bundle) {
        k.e(bundle, "outBundle");
        this.f1330b.g(bundle);
    }

    private d(e eVar) {
        this.f1329a = eVar;
        this.f1330b = new c();
    }
}
