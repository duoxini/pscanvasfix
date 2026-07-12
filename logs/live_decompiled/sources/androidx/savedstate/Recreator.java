package androidx.savedstate;

import D2.g;
import D2.k;
import M.c;
import M.e;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import androidx.lifecycle.l;
import androidx.lifecycle.o;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Recreator implements l {

    /* renamed from: f, reason: collision with root package name */
    public static final a f6638f = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final e f6639e;

    public static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements c.InterfaceC0026c {

        /* renamed from: a, reason: collision with root package name */
        private final Set f6640a;

        public b(c cVar) {
            k.e(cVar, "registry");
            this.f6640a = new LinkedHashSet();
            cVar.h("androidx.savedstate.Restarter", this);
        }

        @Override // M.c.InterfaceC0026c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f6640a));
            return bundle;
        }

        public final void b(String str) {
            k.e(str, "className");
            this.f6640a.add(str);
        }
    }

    public Recreator(e eVar) {
        k.e(eVar, "owner");
        this.f6639e = eVar;
    }

    private final void b(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(c.a.class);
            k.d(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(null);
                    k.d(newInstance, "{\n                constr…wInstance()\n            }");
                    ((c.a) newInstance).a(this.f6639e);
                } catch (Exception e3) {
                    throw new RuntimeException("Failed to instantiate " + str, e3);
                }
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("Class " + str + " wasn't found", e5);
        }
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        k.e(oVar, "source");
        k.e(bVar, "event");
        if (bVar != AbstractC0272h.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        oVar.getLifecycle().c(this);
        Bundle b3 = this.f6639e.getSavedStateRegistry().b("androidx.savedstate.Restarter");
        if (b3 == null) {
            return;
        }
        ArrayList<String> stringArrayList = b3.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
    }
}
