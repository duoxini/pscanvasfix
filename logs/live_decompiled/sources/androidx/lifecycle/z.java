package androidx.lifecycle;

import H.a;
import M.c;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.F;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final a.b f5842a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final a.b f5843b = new c();

    /* renamed from: c, reason: collision with root package name */
    public static final a.b f5844c = new a();

    public static final class a implements a.b {
        a() {
        }
    }

    public static final class b implements a.b {
        b() {
        }
    }

    public static final class c implements a.b {
        c() {
        }
    }

    static final class d extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        public static final d f5845e = new d();

        d() {
            super(1);
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final B f(H.a aVar) {
            D2.k.e(aVar, "$this$initializer");
            return new B();
        }
    }

    public static final y a(H.a aVar) {
        D2.k.e(aVar, "<this>");
        M.e eVar = (M.e) aVar.a(f5842a);
        if (eVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        I i3 = (I) aVar.a(f5843b);
        if (i3 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f5844c);
        String str = (String) aVar.a(F.c.f5718d);
        if (str != null) {
            return b(eVar, i3, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    private static final y b(M.e eVar, I i3, String str, Bundle bundle) {
        A d3 = d(eVar);
        B e3 = e(i3);
        y yVar = (y) e3.f().get(str);
        if (yVar != null) {
            return yVar;
        }
        y a3 = y.f5835f.a(d3.b(str), bundle);
        e3.f().put(str, a3);
        return a3;
    }

    public static final void c(M.e eVar) {
        D2.k.e(eVar, "<this>");
        AbstractC0272h.c b3 = eVar.getLifecycle().b();
        D2.k.d(b3, "lifecycle.currentState");
        if (b3 != AbstractC0272h.c.INITIALIZED && b3 != AbstractC0272h.c.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (eVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            A a3 = new A(eVar.getSavedStateRegistry(), (I) eVar);
            eVar.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", a3);
            eVar.getLifecycle().a(new SavedStateHandleAttacher(a3));
        }
    }

    public static final A d(M.e eVar) {
        D2.k.e(eVar, "<this>");
        c.InterfaceC0026c c3 = eVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        A a3 = c3 instanceof A ? (A) c3 : null;
        if (a3 != null) {
            return a3;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final B e(I i3) {
        D2.k.e(i3, "<this>");
        H.c cVar = new H.c();
        cVar.a(D2.s.b(B.class), d.f5845e);
        return (B) new F(i3, cVar.b()).b("androidx.lifecycle.internal.SavedStateHandlesVM", B.class);
    }
}
