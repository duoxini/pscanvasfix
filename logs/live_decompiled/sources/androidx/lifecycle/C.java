package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.F;
import java.lang.reflect.Constructor;
import java.util.List;

/* loaded from: classes.dex */
public final class C extends F.d implements F.b {

    /* renamed from: b, reason: collision with root package name */
    private Application f5695b;

    /* renamed from: c, reason: collision with root package name */
    private final F.b f5696c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f5697d;

    /* renamed from: e, reason: collision with root package name */
    private AbstractC0272h f5698e;

    /* renamed from: f, reason: collision with root package name */
    private M.c f5699f;

    public C(Application application, M.e eVar, Bundle bundle) {
        D2.k.e(eVar, "owner");
        this.f5699f = eVar.getSavedStateRegistry();
        this.f5698e = eVar.getLifecycle();
        this.f5697d = bundle;
        this.f5695b = application;
        this.f5696c = application != null ? F.a.f5709f.a(application) : new F.a();
    }

    @Override // androidx.lifecycle.F.b
    public E a(Class cls) {
        D2.k.e(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.F.b
    public E b(Class cls, H.a aVar) {
        List list;
        Constructor c3;
        List list2;
        D2.k.e(cls, "modelClass");
        D2.k.e(aVar, "extras");
        String str = (String) aVar.a(F.c.f5718d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (aVar.a(z.f5842a) == null || aVar.a(z.f5843b) == null) {
            if (this.f5698e != null) {
                return d(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) aVar.a(F.a.f5711h);
        boolean isAssignableFrom = AbstractC0265a.class.isAssignableFrom(cls);
        if (!isAssignableFrom || application == null) {
            list = D.f5702b;
            c3 = D.c(cls, list);
        } else {
            list2 = D.f5701a;
            c3 = D.c(cls, list2);
        }
        return c3 == null ? this.f5696c.b(cls, aVar) : (!isAssignableFrom || application == null) ? D.d(cls, c3, z.a(aVar)) : D.d(cls, c3, application, z.a(aVar));
    }

    @Override // androidx.lifecycle.F.d
    public void c(E e3) {
        D2.k.e(e3, "viewModel");
        AbstractC0272h abstractC0272h = this.f5698e;
        if (abstractC0272h != null) {
            LegacySavedStateHandleController.a(e3, this.f5699f, abstractC0272h);
        }
    }

    public final E d(String str, Class cls) {
        List list;
        Constructor c3;
        E d3;
        Application application;
        List list2;
        D2.k.e(str, "key");
        D2.k.e(cls, "modelClass");
        if (this.f5698e == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean isAssignableFrom = AbstractC0265a.class.isAssignableFrom(cls);
        if (!isAssignableFrom || this.f5695b == null) {
            list = D.f5702b;
            c3 = D.c(cls, list);
        } else {
            list2 = D.f5701a;
            c3 = D.c(cls, list2);
        }
        if (c3 == null) {
            return this.f5695b != null ? this.f5696c.a(cls) : F.c.f5716b.a().a(cls);
        }
        SavedStateHandleController b3 = LegacySavedStateHandleController.b(this.f5699f, this.f5698e, str, this.f5697d);
        if (!isAssignableFrom || (application = this.f5695b) == null) {
            y c4 = b3.c();
            D2.k.d(c4, "controller.handle");
            d3 = D.d(cls, c3, c4);
        } else {
            D2.k.b(application);
            y c5 = b3.c();
            D2.k.d(c5, "controller.handle");
            d3 = D.d(cls, c3, application, c5);
        }
        d3.e("androidx.lifecycle.savedstate.vm.tag", b3);
        return d3;
    }
}
