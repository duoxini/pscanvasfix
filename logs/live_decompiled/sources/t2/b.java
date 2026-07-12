package T2;

import C2.q;
import D2.l;
import L2.AbstractC0181m;
import L2.B0;
import L2.C0179k;
import L2.H;
import L2.InterfaceC0178j;
import Q2.A;
import Q2.D;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import t2.InterfaceC0593d;
import t2.g;
import u2.AbstractC0603b;
import v2.h;

/* loaded from: classes.dex */
public class b extends d implements T2.a {

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f2200i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* renamed from: h, reason: collision with root package name */
    private final q f2201h;
    private volatile Object owner;

    private final class a implements InterfaceC0178j, B0 {

        /* renamed from: e, reason: collision with root package name */
        public final C0179k f2202e;

        /* renamed from: f, reason: collision with root package name */
        public final Object f2203f;

        /* renamed from: T2.b$a$a, reason: collision with other inner class name */
        static final class C0040a extends l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f2205e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f2206f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0040a(b bVar, a aVar) {
                super(1);
                this.f2205e = bVar;
                this.f2206f = aVar;
            }

            public final void a(Throwable th) {
                this.f2205e.b(this.f2206f.f2203f);
            }

            @Override // C2.l
            public /* bridge */ /* synthetic */ Object f(Object obj) {
                a((Throwable) obj);
                return p2.q.f12810a;
            }
        }

        /* renamed from: T2.b$a$b, reason: collision with other inner class name */
        static final class C0041b extends l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f2207e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f2208f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0041b(b bVar, a aVar) {
                super(1);
                this.f2207e = bVar;
                this.f2208f = aVar;
            }

            public final void a(Throwable th) {
                b.f2200i.set(this.f2207e, this.f2208f.f2203f);
                this.f2207e.b(this.f2208f.f2203f);
            }

            @Override // C2.l
            public /* bridge */ /* synthetic */ Object f(Object obj) {
                a((Throwable) obj);
                return p2.q.f12810a;
            }
        }

        public a(C0179k c0179k, Object obj) {
            this.f2202e = c0179k;
            this.f2203f = obj;
        }

        @Override // L2.InterfaceC0178j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void m(p2.q qVar, C2.l lVar) {
            b.f2200i.set(b.this, this.f2203f);
            this.f2202e.m(qVar, new C0040a(b.this, this));
        }

        @Override // L2.B0
        public void b(A a3, int i3) {
            this.f2202e.b(a3, i3);
        }

        @Override // L2.InterfaceC0178j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Object k(p2.q qVar, Object obj, C2.l lVar) {
            Object k3 = this.f2202e.k(qVar, obj, new C0041b(b.this, this));
            if (k3 != null) {
                b.f2200i.set(b.this, this.f2203f);
            }
            return k3;
        }

        @Override // t2.InterfaceC0593d
        public g getContext() {
            return this.f2202e.getContext();
        }

        @Override // t2.InterfaceC0593d
        public void resumeWith(Object obj) {
            this.f2202e.resumeWith(obj);
        }

        @Override // L2.InterfaceC0178j
        public void s(Object obj) {
            this.f2202e.s(obj);
        }
    }

    /* renamed from: T2.b$b, reason: collision with other inner class name */
    static final class C0042b extends l implements q {
        C0042b() {
            super(3);
        }
    }

    public b(boolean z3) {
        super(1, z3 ? 1 : 0);
        this.owner = z3 ? null : c.f2210a;
        this.f2201h = new C0042b();
    }

    static /* synthetic */ Object o(b bVar, Object obj, InterfaceC0593d interfaceC0593d) {
        Object p3;
        return (!bVar.q(obj) && (p3 = bVar.p(obj, interfaceC0593d)) == AbstractC0603b.c()) ? p3 : p2.q.f12810a;
    }

    private final Object p(Object obj, InterfaceC0593d interfaceC0593d) {
        C0179k a3 = AbstractC0181m.a(AbstractC0603b.b(interfaceC0593d));
        try {
            c(new a(a3, obj));
            Object v3 = a3.v();
            if (v3 == AbstractC0603b.c()) {
                h.c(interfaceC0593d);
            }
            return v3 == AbstractC0603b.c() ? v3 : p2.q.f12810a;
        } catch (Throwable th) {
            a3.G();
            throw th;
        }
    }

    private final int r(Object obj) {
        while (!i()) {
            if (obj == null) {
                return 1;
            }
            if (m(obj)) {
                return 2;
            }
            if (n()) {
                return 1;
            }
        }
        f2200i.set(this, obj);
        return 0;
    }

    @Override // T2.a
    public Object a(Object obj, InterfaceC0593d interfaceC0593d) {
        return o(this, obj, interfaceC0593d);
    }

    @Override // T2.a
    public void b(Object obj) {
        D d3;
        D d4;
        while (n()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2200i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            d3 = c.f2210a;
            if (obj2 != d3) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                d4 = c.f2210a;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, d4)) {
                    h();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    public boolean m(Object obj) {
        D d3;
        while (n()) {
            Object obj2 = f2200i.get(this);
            d3 = c.f2210a;
            if (obj2 != d3) {
                return obj2 == obj;
            }
        }
        return false;
    }

    public boolean n() {
        return g() == 0;
    }

    public boolean q(Object obj) {
        int r3 = r(obj);
        if (r3 == 0) {
            return true;
        }
        if (r3 == 1) {
            return false;
        }
        if (r3 != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    public String toString() {
        return "Mutex@" + H.b(this) + "[isLocked=" + n() + ",owner=" + f2200i.get(this) + ']';
    }
}
