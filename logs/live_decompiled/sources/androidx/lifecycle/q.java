package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;
import j.C0399a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k.C0420a;
import k.b;

/* loaded from: classes.dex */
public class q extends AbstractC0272h {

    /* renamed from: b, reason: collision with root package name */
    private C0420a f5810b;

    /* renamed from: c, reason: collision with root package name */
    private AbstractC0272h.c f5811c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference f5812d;

    /* renamed from: e, reason: collision with root package name */
    private int f5813e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5814f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5815g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f5816h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f5817i;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        AbstractC0272h.c f5818a;

        /* renamed from: b, reason: collision with root package name */
        l f5819b;

        a(n nVar, AbstractC0272h.c cVar) {
            this.f5819b = r.f(nVar);
            this.f5818a = cVar;
        }

        void a(o oVar, AbstractC0272h.b bVar) {
            AbstractC0272h.c b3 = bVar.b();
            this.f5818a = q.k(this.f5818a, b3);
            this.f5819b.a(oVar, bVar);
            this.f5818a = b3;
        }
    }

    public q(o oVar) {
        this(oVar, true);
    }

    private void d(o oVar) {
        Iterator a3 = this.f5810b.a();
        while (a3.hasNext() && !this.f5815g) {
            Map.Entry entry = (Map.Entry) a3.next();
            a aVar = (a) entry.getValue();
            while (aVar.f5818a.compareTo(this.f5811c) > 0 && !this.f5815g && this.f5810b.contains((n) entry.getKey())) {
                AbstractC0272h.b a4 = AbstractC0272h.b.a(aVar.f5818a);
                if (a4 == null) {
                    throw new IllegalStateException("no event down from " + aVar.f5818a);
                }
                n(a4.b());
                aVar.a(oVar, a4);
                m();
            }
        }
    }

    private AbstractC0272h.c e(n nVar) {
        Map.Entry i3 = this.f5810b.i(nVar);
        AbstractC0272h.c cVar = null;
        AbstractC0272h.c cVar2 = i3 != null ? ((a) i3.getValue()).f5818a : null;
        if (!this.f5816h.isEmpty()) {
            cVar = (AbstractC0272h.c) this.f5816h.get(r0.size() - 1);
        }
        return k(k(this.f5811c, cVar2), cVar);
    }

    private void f(String str) {
        if (!this.f5817i || C0399a.e().b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    private void g(o oVar) {
        b.d d3 = this.f5810b.d();
        while (d3.hasNext() && !this.f5815g) {
            Map.Entry entry = (Map.Entry) d3.next();
            a aVar = (a) entry.getValue();
            while (aVar.f5818a.compareTo(this.f5811c) < 0 && !this.f5815g && this.f5810b.contains((n) entry.getKey())) {
                n(aVar.f5818a);
                AbstractC0272h.b c3 = AbstractC0272h.b.c(aVar.f5818a);
                if (c3 == null) {
                    throw new IllegalStateException("no event up from " + aVar.f5818a);
                }
                aVar.a(oVar, c3);
                m();
            }
        }
    }

    private boolean i() {
        if (this.f5810b.size() == 0) {
            return true;
        }
        AbstractC0272h.c cVar = ((a) this.f5810b.b().getValue()).f5818a;
        AbstractC0272h.c cVar2 = ((a) this.f5810b.e().getValue()).f5818a;
        return cVar == cVar2 && this.f5811c == cVar2;
    }

    static AbstractC0272h.c k(AbstractC0272h.c cVar, AbstractC0272h.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void l(AbstractC0272h.c cVar) {
        AbstractC0272h.c cVar2 = this.f5811c;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 == AbstractC0272h.c.INITIALIZED && cVar == AbstractC0272h.c.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f5811c);
        }
        this.f5811c = cVar;
        if (this.f5814f || this.f5813e != 0) {
            this.f5815g = true;
            return;
        }
        this.f5814f = true;
        p();
        this.f5814f = false;
        if (this.f5811c == AbstractC0272h.c.DESTROYED) {
            this.f5810b = new C0420a();
        }
    }

    private void m() {
        this.f5816h.remove(r1.size() - 1);
    }

    private void n(AbstractC0272h.c cVar) {
        this.f5816h.add(cVar);
    }

    private void p() {
        o oVar = (o) this.f5812d.get();
        if (oVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f5815g = false;
            if (this.f5811c.compareTo(((a) this.f5810b.b().getValue()).f5818a) < 0) {
                d(oVar);
            }
            Map.Entry e3 = this.f5810b.e();
            if (!this.f5815g && e3 != null && this.f5811c.compareTo(((a) e3.getValue()).f5818a) > 0) {
                g(oVar);
            }
        }
        this.f5815g = false;
    }

    @Override // androidx.lifecycle.AbstractC0272h
    public void a(n nVar) {
        o oVar;
        f("addObserver");
        AbstractC0272h.c cVar = this.f5811c;
        AbstractC0272h.c cVar2 = AbstractC0272h.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = AbstractC0272h.c.INITIALIZED;
        }
        a aVar = new a(nVar, cVar2);
        if (((a) this.f5810b.g(nVar, aVar)) == null && (oVar = (o) this.f5812d.get()) != null) {
            boolean z3 = this.f5813e != 0 || this.f5814f;
            AbstractC0272h.c e3 = e(nVar);
            this.f5813e++;
            while (aVar.f5818a.compareTo(e3) < 0 && this.f5810b.contains(nVar)) {
                n(aVar.f5818a);
                AbstractC0272h.b c3 = AbstractC0272h.b.c(aVar.f5818a);
                if (c3 == null) {
                    throw new IllegalStateException("no event up from " + aVar.f5818a);
                }
                aVar.a(oVar, c3);
                m();
                e3 = e(nVar);
            }
            if (!z3) {
                p();
            }
            this.f5813e--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0272h
    public AbstractC0272h.c b() {
        return this.f5811c;
    }

    @Override // androidx.lifecycle.AbstractC0272h
    public void c(n nVar) {
        f("removeObserver");
        this.f5810b.h(nVar);
    }

    public void h(AbstractC0272h.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.b());
    }

    public void j(AbstractC0272h.c cVar) {
        f("markState");
        o(cVar);
    }

    public void o(AbstractC0272h.c cVar) {
        f("setCurrentState");
        l(cVar);
    }

    private q(o oVar, boolean z3) {
        this.f5810b = new C0420a();
        this.f5813e = 0;
        this.f5814f = false;
        this.f5815g = false;
        this.f5816h = new ArrayList();
        this.f5812d = new WeakReference(oVar);
        this.f5811c = AbstractC0272h.c.INITIALIZED;
        this.f5817i = z3;
    }
}
