package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.AbstractC0272h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.core.view.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0262k {

    /* renamed from: a, reason: collision with root package name */
    private final Runnable f5117a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList f5118b = new CopyOnWriteArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final Map f5119c = new HashMap();

    /* renamed from: androidx.core.view.k$a */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        final AbstractC0272h f5120a;

        /* renamed from: b, reason: collision with root package name */
        private androidx.lifecycle.l f5121b;

        a(AbstractC0272h abstractC0272h, androidx.lifecycle.l lVar) {
            this.f5120a = abstractC0272h;
            this.f5121b = lVar;
            abstractC0272h.a(lVar);
        }

        void a() {
            this.f5120a.c(this.f5121b);
            this.f5121b = null;
        }
    }

    public C0262k(Runnable runnable) {
        this.f5117a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(m mVar, androidx.lifecycle.o oVar, AbstractC0272h.b bVar) {
        if (bVar == AbstractC0272h.b.ON_DESTROY) {
            l(mVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(AbstractC0272h.c cVar, m mVar, androidx.lifecycle.o oVar, AbstractC0272h.b bVar) {
        if (bVar == AbstractC0272h.b.d(cVar)) {
            c(mVar);
            return;
        }
        if (bVar == AbstractC0272h.b.ON_DESTROY) {
            l(mVar);
        } else if (bVar == AbstractC0272h.b.a(cVar)) {
            this.f5118b.remove(mVar);
            this.f5117a.run();
        }
    }

    public void c(m mVar) {
        this.f5118b.add(mVar);
        this.f5117a.run();
    }

    public void d(final m mVar, androidx.lifecycle.o oVar) {
        c(mVar);
        AbstractC0272h lifecycle = oVar.getLifecycle();
        a aVar = (a) this.f5119c.remove(mVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f5119c.put(mVar, new a(lifecycle, new androidx.lifecycle.l(mVar) { // from class: androidx.core.view.j
            @Override // androidx.lifecycle.l
            public final void a(androidx.lifecycle.o oVar2, AbstractC0272h.b bVar) {
                C0262k.this.f(null, oVar2, bVar);
            }
        }));
    }

    public void e(final m mVar, androidx.lifecycle.o oVar, final AbstractC0272h.c cVar) {
        AbstractC0272h lifecycle = oVar.getLifecycle();
        a aVar = (a) this.f5119c.remove(mVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f5119c.put(mVar, new a(lifecycle, new androidx.lifecycle.l(cVar, mVar) { // from class: androidx.core.view.i

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ AbstractC0272h.c f5115f;

            @Override // androidx.lifecycle.l
            public final void a(androidx.lifecycle.o oVar2, AbstractC0272h.b bVar) {
                C0262k.this.g(this.f5115f, null, oVar2, bVar);
            }
        }));
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f5118b.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.p.a(it.next());
            throw null;
        }
    }

    public void i(Menu menu) {
        Iterator it = this.f5118b.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.p.a(it.next());
            throw null;
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.f5118b.iterator();
        if (!it.hasNext()) {
            return false;
        }
        androidx.appcompat.app.p.a(it.next());
        throw null;
    }

    public void k(Menu menu) {
        Iterator it = this.f5118b.iterator();
        if (it.hasNext()) {
            androidx.appcompat.app.p.a(it.next());
            throw null;
        }
    }

    public void l(m mVar) {
        this.f5118b.remove(mVar);
        a aVar = (a) this.f5119c.remove(mVar);
        if (aVar != null) {
            aVar.a();
        }
        this.f5117a.run();
    }
}
