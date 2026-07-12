package L2;

import t2.InterfaceC0593d;
import t2.InterfaceC0594e;
import t2.g;

/* renamed from: L2.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0193z {

    /* renamed from: L2.z$a */
    static final class a extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1314e = new a();

        a() {
            super(2);
        }

        @Override // C2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t2.g invoke(t2.g gVar, g.b bVar) {
            return gVar.p(bVar);
        }
    }

    /* renamed from: L2.z$b */
    static final class b extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ D2.r f1315e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f1316f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(D2.r rVar, boolean z3) {
            super(2);
            this.f1315e = rVar;
            this.f1316f = z3;
        }

        @Override // C2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t2.g invoke(t2.g gVar, g.b bVar) {
            return gVar.p(bVar);
        }
    }

    /* renamed from: L2.z$c */
    static final class c extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        public static final c f1317e = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z3, g.b bVar) {
            return Boolean.valueOf(z3);
        }

        @Override // C2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Boolean) obj).booleanValue(), (g.b) obj2);
        }
    }

    private static final t2.g a(t2.g gVar, t2.g gVar2, boolean z3) {
        boolean c3 = c(gVar);
        boolean c4 = c(gVar2);
        if (!c3 && !c4) {
            return gVar.p(gVar2);
        }
        D2.r rVar = new D2.r();
        rVar.f337e = gVar2;
        t2.h hVar = t2.h.f13692e;
        t2.g gVar3 = (t2.g) gVar.g(hVar, new b(rVar, z3));
        if (c4) {
            rVar.f337e = ((t2.g) rVar.f337e).g(hVar, a.f1314e);
        }
        return gVar3.p((t2.g) rVar.f337e);
    }

    public static final String b(t2.g gVar) {
        return null;
    }

    private static final boolean c(t2.g gVar) {
        return ((Boolean) gVar.g(Boolean.FALSE, c.f1317e)).booleanValue();
    }

    public static final t2.g d(D d3, t2.g gVar) {
        t2.g a3 = a(d3.h(), gVar, true);
        return (a3 == O.a() || a3.a(InterfaceC0594e.f13689d) != null) ? a3 : a3.p(O.a());
    }

    public static final t2.g e(t2.g gVar, t2.g gVar2) {
        return !c(gVar2) ? gVar.p(gVar2) : a(gVar, gVar2, false);
    }

    public static final z0 f(v2.e eVar) {
        while (!(eVar instanceof L) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof z0) {
                return (z0) eVar;
            }
        }
        return null;
    }

    public static final z0 g(InterfaceC0593d interfaceC0593d, t2.g gVar, Object obj) {
        if (!(interfaceC0593d instanceof v2.e) || gVar.a(A0.f1229e) == null) {
            return null;
        }
        z0 f3 = f((v2.e) interfaceC0593d);
        if (f3 != null) {
            f3.I0(gVar, obj);
        }
        return f3;
    }
}
