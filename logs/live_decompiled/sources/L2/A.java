package L2;

import Q2.AbstractC0205l;
import Q2.C0201h;
import Q2.C0204k;
import t2.AbstractC0590a;
import t2.AbstractC0591b;
import t2.InterfaceC0593d;
import t2.InterfaceC0594e;
import t2.g;

/* loaded from: classes.dex */
public abstract class A extends AbstractC0590a implements InterfaceC0594e {

    /* renamed from: f, reason: collision with root package name */
    public static final a f1227f = new a(null);

    public static final class a extends AbstractC0591b {

        /* renamed from: L2.A$a$a, reason: collision with other inner class name */
        static final class C0024a extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final C0024a f1228e = new C0024a();

            C0024a() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final A f(g.b bVar) {
                if (bVar instanceof A) {
                    return (A) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
            super(InterfaceC0594e.f13689d, C0024a.f1228e);
        }
    }

    public A() {
        super(InterfaceC0594e.f13689d);
    }

    @Override // t2.InterfaceC0594e
    public final InterfaceC0593d G(InterfaceC0593d interfaceC0593d) {
        return new C0201h(this, interfaceC0593d);
    }

    @Override // t2.AbstractC0590a, t2.g
    public t2.g N(g.c cVar) {
        return InterfaceC0594e.a.b(this, cVar);
    }

    @Override // t2.AbstractC0590a, t2.g.b, t2.g
    public g.b a(g.c cVar) {
        return InterfaceC0594e.a.a(this, cVar);
    }

    public abstract void c0(t2.g gVar, Runnable runnable);

    public boolean d0(t2.g gVar) {
        return true;
    }

    public A e0(int i3) {
        AbstractC0205l.a(i3);
        return new C0204k(this, i3);
    }

    @Override // t2.InterfaceC0594e
    public final void j(InterfaceC0593d interfaceC0593d) {
        D2.k.c(interfaceC0593d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C0201h) interfaceC0593d).o();
    }

    public String toString() {
        return H.a(this) + '@' + H.b(this);
    }
}
