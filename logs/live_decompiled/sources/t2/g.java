package t2;

import C2.p;
import D2.k;
import D2.l;
import t2.InterfaceC0594e;

/* loaded from: classes.dex */
public interface g {

    public static final class a {

        /* renamed from: t2.g$a$a, reason: collision with other inner class name */
        static final class C0148a extends l implements p {

            /* renamed from: e, reason: collision with root package name */
            public static final C0148a f13691e = new C0148a();

            C0148a() {
                super(2);
            }

            @Override // C2.p
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke(g gVar, b bVar) {
                C0592c c0592c;
                k.e(gVar, "acc");
                k.e(bVar, "element");
                g N3 = gVar.N(bVar.getKey());
                h hVar = h.f13692e;
                if (N3 == hVar) {
                    return bVar;
                }
                InterfaceC0594e.b bVar2 = InterfaceC0594e.f13689d;
                InterfaceC0594e interfaceC0594e = (InterfaceC0594e) N3.a(bVar2);
                if (interfaceC0594e == null) {
                    c0592c = new C0592c(N3, bVar);
                } else {
                    g N4 = N3.N(bVar2);
                    if (N4 == hVar) {
                        return new C0592c(bVar, interfaceC0594e);
                    }
                    c0592c = new C0592c(new C0592c(N4, bVar), interfaceC0594e);
                }
                return c0592c;
            }
        }

        public static g a(g gVar, g gVar2) {
            k.e(gVar2, "context");
            return gVar2 == h.f13692e ? gVar : (g) gVar2.g(gVar, C0148a.f13691e);
        }
    }

    public interface b extends g {

        public static final class a {
            public static Object a(b bVar, Object obj, p pVar) {
                k.e(pVar, "operation");
                return pVar.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                k.e(cVar, "key");
                if (!k.a(bVar.getKey(), cVar)) {
                    return null;
                }
                k.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c cVar) {
                k.e(cVar, "key");
                return k.a(bVar.getKey(), cVar) ? h.f13692e : bVar;
            }

            public static g d(b bVar, g gVar) {
                k.e(gVar, "context");
                return a.a(bVar, gVar);
            }
        }

        @Override // t2.g
        b a(c cVar);

        c getKey();
    }

    public interface c {
    }

    g N(c cVar);

    b a(c cVar);

    Object g(Object obj, p pVar);

    g p(g gVar);
}
