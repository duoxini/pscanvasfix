package P2;

import C2.p;
import p2.l;
import p2.q;
import t2.InterfaceC0593d;
import t2.InterfaceC0594e;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public abstract class d extends b {

    /* renamed from: d, reason: collision with root package name */
    protected final O2.c f1870d;

    static final class a extends v2.k implements p {

        /* renamed from: i, reason: collision with root package name */
        int f1871i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f1872j;

        a(InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
        }

        @Override // C2.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(O2.d dVar, InterfaceC0593d interfaceC0593d) {
            return ((a) create(dVar, interfaceC0593d)).invokeSuspend(q.f12810a);
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            a aVar = d.this.new a(interfaceC0593d);
            aVar.f1872j = obj;
            return aVar;
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            Object c3 = AbstractC0603b.c();
            int i3 = this.f1871i;
            if (i3 == 0) {
                l.b(obj);
                O2.d dVar = (O2.d) this.f1872j;
                d dVar2 = d.this;
                this.f1871i = 1;
                if (dVar2.l(dVar, this) == c3) {
                    return c3;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.b(obj);
            }
            return q.f12810a;
        }
    }

    public d(O2.c cVar, t2.g gVar, int i3, N2.a aVar) {
        super(gVar, i3, aVar);
        this.f1870d = cVar;
    }

    static /* synthetic */ Object i(d dVar, O2.d dVar2, InterfaceC0593d interfaceC0593d) {
        if (dVar.f1861b == -3) {
            t2.g context = interfaceC0593d.getContext();
            t2.g p3 = context.p(dVar.f1860a);
            if (D2.k.a(p3, context)) {
                Object l3 = dVar.l(dVar2, interfaceC0593d);
                return l3 == AbstractC0603b.c() ? l3 : q.f12810a;
            }
            InterfaceC0594e.b bVar = InterfaceC0594e.f13689d;
            if (D2.k.a(p3.a(bVar), context.a(bVar))) {
                Object k3 = dVar.k(dVar2, p3, interfaceC0593d);
                return k3 == AbstractC0603b.c() ? k3 : q.f12810a;
            }
        }
        Object collect = super.collect(dVar2, interfaceC0593d);
        return collect == AbstractC0603b.c() ? collect : q.f12810a;
    }

    static /* synthetic */ Object j(d dVar, N2.q qVar, InterfaceC0593d interfaceC0593d) {
        Object l3 = dVar.l(new i(qVar), interfaceC0593d);
        return l3 == AbstractC0603b.c() ? l3 : q.f12810a;
    }

    private final Object k(O2.d dVar, t2.g gVar, InterfaceC0593d interfaceC0593d) {
        O2.d d3;
        d3 = c.d(dVar, interfaceC0593d.getContext());
        Object c3 = c.c(gVar, d3, null, new a(null), interfaceC0593d, 4, null);
        return c3 == AbstractC0603b.c() ? c3 : q.f12810a;
    }

    @Override // P2.b, O2.c
    public Object collect(O2.d dVar, InterfaceC0593d interfaceC0593d) {
        return i(this, dVar, interfaceC0593d);
    }

    @Override // P2.b
    protected Object d(N2.q qVar, InterfaceC0593d interfaceC0593d) {
        return j(this, qVar, interfaceC0593d);
    }

    protected abstract Object l(O2.d dVar, InterfaceC0593d interfaceC0593d);

    @Override // P2.b
    public String toString() {
        return this.f1870d + " -> " + super.toString();
    }
}
