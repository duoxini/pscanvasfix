package Q2;

import L2.w0;
import t2.g;

/* loaded from: classes.dex */
public abstract class H {

    /* renamed from: a, reason: collision with root package name */
    public static final D f1967a = new D("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final C2.p f1968b = a.f1971e;

    /* renamed from: c, reason: collision with root package name */
    private static final C2.p f1969c = b.f1972e;

    /* renamed from: d, reason: collision with root package name */
    private static final C2.p f1970d = c.f1973e;

    static final class a extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1971e = new a();

        a() {
            super(2);
        }

        @Override // C2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof w0)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    static final class b extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        public static final b f1972e = new b();

        b() {
            super(2);
        }

        @Override // C2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final w0 invoke(w0 w0Var, g.b bVar) {
            if (w0Var != null) {
                return w0Var;
            }
            if (bVar instanceof w0) {
                return (w0) bVar;
            }
            return null;
        }
    }

    static final class c extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        public static final c f1973e = new c();

        c() {
            super(2);
        }

        @Override // C2.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final L invoke(L l3, g.b bVar) {
            if (bVar instanceof w0) {
                w0 w0Var = (w0) bVar;
                l3.a(w0Var, w0Var.X(l3.f1974a));
            }
            return l3;
        }
    }

    public static final void a(t2.g gVar, Object obj) {
        if (obj == f1967a) {
            return;
        }
        if (obj instanceof L) {
            ((L) obj).b(gVar);
            return;
        }
        Object g3 = gVar.g(null, f1969c);
        D2.k.c(g3, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((w0) g3).K(gVar, obj);
    }

    public static final Object b(t2.g gVar) {
        Object g3 = gVar.g(0, f1968b);
        D2.k.b(g3);
        return g3;
    }

    public static final Object c(t2.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        if (obj == 0) {
            return f1967a;
        }
        if (obj instanceof Integer) {
            return gVar.g(new L(gVar, ((Number) obj).intValue()), f1970d);
        }
        D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((w0) obj).X(gVar);
    }
}
