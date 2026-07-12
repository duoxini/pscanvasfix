package M;

import D2.g;
import D2.k;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import k.b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: g, reason: collision with root package name */
    private static final b f1321g = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private boolean f1323b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f1324c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1325d;

    /* renamed from: e, reason: collision with root package name */
    private Recreator.b f1326e;

    /* renamed from: a, reason: collision with root package name */
    private final k.b f1322a = new k.b();

    /* renamed from: f, reason: collision with root package name */
    private boolean f1327f = true;

    public interface a {
        void a(e eVar);
    }

    private static final class b {
        public /* synthetic */ b(g gVar) {
            this();
        }

        private b() {
        }
    }

    /* renamed from: M.c$c, reason: collision with other inner class name */
    public interface InterfaceC0026c {
        Bundle a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, o oVar, AbstractC0272h.b bVar) {
        k.e(cVar, "this$0");
        k.e(oVar, "<anonymous parameter 0>");
        k.e(bVar, "event");
        if (bVar == AbstractC0272h.b.ON_START) {
            cVar.f1327f = true;
        } else if (bVar == AbstractC0272h.b.ON_STOP) {
            cVar.f1327f = false;
        }
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        if (!this.f1325d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f1324c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f1324c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f1324c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f1324c = null;
        }
        return bundle2;
    }

    public final InterfaceC0026c c(String str) {
        k.e(str, "key");
        Iterator it = this.f1322a.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            k.d(entry, "components");
            String str2 = (String) entry.getKey();
            InterfaceC0026c interfaceC0026c = (InterfaceC0026c) entry.getValue();
            if (k.a(str2, str)) {
                return interfaceC0026c;
            }
        }
        return null;
    }

    public final void e(AbstractC0272h abstractC0272h) {
        k.e(abstractC0272h, "lifecycle");
        if (this.f1323b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        abstractC0272h.a(new l() { // from class: M.b
            @Override // androidx.lifecycle.l
            public final void a(o oVar, AbstractC0272h.b bVar) {
                c.d(c.this, oVar, bVar);
            }
        });
        this.f1323b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f1323b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f1325d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f1324c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f1325d = true;
    }

    public final void g(Bundle bundle) {
        k.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f1324c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        b.d d3 = this.f1322a.d();
        k.d(d3, "this.components.iteratorWithAdditions()");
        while (d3.hasNext()) {
            Map.Entry entry = (Map.Entry) d3.next();
            bundle2.putBundle((String) entry.getKey(), ((InterfaceC0026c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, InterfaceC0026c interfaceC0026c) {
        k.e(str, "key");
        k.e(interfaceC0026c, "provider");
        if (((InterfaceC0026c) this.f1322a.g(str, interfaceC0026c)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void i(Class cls) {
        k.e(cls, "clazz");
        if (!this.f1327f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.b bVar = this.f1326e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f1326e = bVar;
        try {
            cls.getDeclaredConstructor(null);
            Recreator.b bVar2 = this.f1326e;
            if (bVar2 != null) {
                String name = cls.getName();
                k.d(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
        }
    }
}
