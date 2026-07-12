package androidx.lifecycle;

import M.c;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0272h;
import java.util.Iterator;

/* loaded from: classes.dex */
abstract class LegacySavedStateHandleController {

    static final class a implements c.a {
        a() {
        }

        @Override // M.c.a
        public void a(M.e eVar) {
            if (!(eVar instanceof I)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            H viewModelStore = ((I) eVar).getViewModelStore();
            M.c savedStateRegistry = eVar.getSavedStateRegistry();
            Iterator it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                LegacySavedStateHandleController.a(viewModelStore.b((String) it.next()), savedStateRegistry, eVar.getLifecycle());
            }
            if (viewModelStore.c().isEmpty()) {
                return;
            }
            savedStateRegistry.i(a.class);
        }
    }

    static void a(E e3, M.c cVar, AbstractC0272h abstractC0272h) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) e3.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.d()) {
            return;
        }
        savedStateHandleController.b(cVar, abstractC0272h);
        c(cVar, abstractC0272h);
    }

    static SavedStateHandleController b(M.c cVar, AbstractC0272h abstractC0272h, String str, Bundle bundle) {
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, y.c(cVar.b(str), bundle));
        savedStateHandleController.b(cVar, abstractC0272h);
        c(cVar, abstractC0272h);
        return savedStateHandleController;
    }

    private static void c(final M.c cVar, final AbstractC0272h abstractC0272h) {
        AbstractC0272h.c b3 = abstractC0272h.b();
        if (b3 == AbstractC0272h.c.INITIALIZED || b3.a(AbstractC0272h.c.STARTED)) {
            cVar.i(a.class);
        } else {
            abstractC0272h.a(new l() { // from class: androidx.lifecycle.LegacySavedStateHandleController.1
                @Override // androidx.lifecycle.l
                public void a(o oVar, AbstractC0272h.b bVar) {
                    if (bVar == AbstractC0272h.b.ON_START) {
                        AbstractC0272h.this.c(this);
                        cVar.i(a.class);
                    }
                }
            });
        }
    }
}
