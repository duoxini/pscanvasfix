package androidx.lifecycle;

import androidx.lifecycle.AbstractC0272h;
import j.C0399a;
import java.util.Map;
import k.b;

/* loaded from: classes.dex */
public abstract class LiveData {

    /* renamed from: k, reason: collision with root package name */
    static final Object f5732k = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Object f5733a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private k.b f5734b = new k.b();

    /* renamed from: c, reason: collision with root package name */
    int f5735c = 0;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5736d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f5737e;

    /* renamed from: f, reason: collision with root package name */
    volatile Object f5738f;

    /* renamed from: g, reason: collision with root package name */
    private int f5739g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5740h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5741i;

    /* renamed from: j, reason: collision with root package name */
    private final Runnable f5742j;

    class LifecycleBoundObserver extends androidx.lifecycle.LiveData.c implements l {

        /* renamed from: i, reason: collision with root package name */
        final o f5743i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ LiveData f5744j;

        @Override // androidx.lifecycle.l
        public void a(o oVar, AbstractC0272h.b bVar) {
            AbstractC0272h.c b3 = this.f5743i.getLifecycle().b();
            if (b3 == AbstractC0272h.c.DESTROYED) {
                this.f5744j.i(this.f5747e);
                return;
            }
            AbstractC0272h.c cVar = null;
            while (cVar != b3) {
                b(d());
                cVar = b3;
                b3 = this.f5743i.getLifecycle().b();
            }
        }

        void c() {
            this.f5743i.getLifecycle().c(this);
        }

        boolean d() {
            return this.f5743i.getLifecycle().b().a(AbstractC0272h.c.STARTED);
        }
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f5733a) {
                obj = LiveData.this.f5738f;
                LiveData.this.f5738f = LiveData.f5732k;
            }
            LiveData.this.j(obj);
        }
    }

    private class b extends c {
        b(u uVar) {
            super(uVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        boolean d() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: e, reason: collision with root package name */
        final u f5747e;

        /* renamed from: f, reason: collision with root package name */
        boolean f5748f;

        /* renamed from: g, reason: collision with root package name */
        int f5749g = -1;

        c(u uVar) {
            this.f5747e = uVar;
        }

        void b(boolean z3) {
            if (z3 == this.f5748f) {
                return;
            }
            this.f5748f = z3;
            LiveData.this.b(z3 ? 1 : -1);
            if (this.f5748f) {
                LiveData.this.d(this);
            }
        }

        void c() {
        }

        abstract boolean d();
    }

    public LiveData() {
        Object obj = f5732k;
        this.f5738f = obj;
        this.f5742j = new a();
        this.f5737e = obj;
        this.f5739g = -1;
    }

    static void a(String str) {
        if (C0399a.e().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(c cVar) {
        if (cVar.f5748f) {
            if (!cVar.d()) {
                cVar.b(false);
                return;
            }
            int i3 = cVar.f5749g;
            int i4 = this.f5739g;
            if (i3 >= i4) {
                return;
            }
            cVar.f5749g = i4;
            cVar.f5747e.a(this.f5737e);
        }
    }

    void b(int i3) {
        int i4 = this.f5735c;
        this.f5735c = i3 + i4;
        if (this.f5736d) {
            return;
        }
        this.f5736d = true;
        while (true) {
            try {
                int i5 = this.f5735c;
                if (i4 == i5) {
                    this.f5736d = false;
                    return;
                }
                boolean z3 = i4 == 0 && i5 > 0;
                boolean z4 = i4 > 0 && i5 == 0;
                if (z3) {
                    f();
                } else if (z4) {
                    g();
                }
                i4 = i5;
            } catch (Throwable th) {
                this.f5736d = false;
                throw th;
            }
        }
    }

    void d(c cVar) {
        if (this.f5740h) {
            this.f5741i = true;
            return;
        }
        this.f5740h = true;
        do {
            this.f5741i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                b.d d3 = this.f5734b.d();
                while (d3.hasNext()) {
                    c((c) ((Map.Entry) d3.next()).getValue());
                    if (this.f5741i) {
                        break;
                    }
                }
            }
        } while (this.f5741i);
        this.f5740h = false;
    }

    public void e(u uVar) {
        a("observeForever");
        b bVar = new b(uVar);
        c cVar = (c) this.f5734b.g(uVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        bVar.b(true);
    }

    protected void f() {
    }

    protected void g() {
    }

    protected void h(Object obj) {
        boolean z3;
        synchronized (this.f5733a) {
            z3 = this.f5738f == f5732k;
            this.f5738f = obj;
        }
        if (z3) {
            C0399a.e().c(this.f5742j);
        }
    }

    public void i(u uVar) {
        a("removeObserver");
        c cVar = (c) this.f5734b.h(uVar);
        if (cVar == null) {
            return;
        }
        cVar.c();
        cVar.b(false);
    }

    protected void j(Object obj) {
        a("setValue");
        this.f5739g++;
        this.f5737e = obj;
        d(null);
    }
}
