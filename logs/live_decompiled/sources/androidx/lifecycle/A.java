package androidx.lifecycle;

import M.c;
import android.os.Bundle;
import java.util.Map;
import p2.AbstractC0506f;
import p2.InterfaceC0505e;

/* loaded from: classes.dex */
public final class A implements c.InterfaceC0026c {

    /* renamed from: a, reason: collision with root package name */
    private final M.c f5689a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5690b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f5691c;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC0505e f5692d;

    static final class a extends D2.l implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ I f5693e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(I i3) {
            super(0);
            this.f5693e = i3;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final B invoke() {
            return z.e(this.f5693e);
        }
    }

    public A(M.c cVar, I i3) {
        D2.k.e(cVar, "savedStateRegistry");
        D2.k.e(i3, "viewModelStoreOwner");
        this.f5689a = cVar;
        this.f5692d = AbstractC0506f.a(new a(i3));
    }

    private final B c() {
        return (B) this.f5692d.getValue();
    }

    @Override // M.c.InterfaceC0026c
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f5691c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : c().f().entrySet()) {
            String str = (String) entry.getKey();
            Bundle a3 = ((y) entry.getValue()).d().a();
            if (!D2.k.a(a3, Bundle.EMPTY)) {
                bundle.putBundle(str, a3);
            }
        }
        this.f5690b = false;
        return bundle;
    }

    public final Bundle b(String str) {
        D2.k.e(str, "key");
        d();
        Bundle bundle = this.f5691c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f5691c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f5691c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f5691c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (this.f5690b) {
            return;
        }
        this.f5691c = this.f5689a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        this.f5690b = true;
        c();
    }
}
