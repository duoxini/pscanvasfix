package t2;

import D2.k;
import t2.g;

/* renamed from: t2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0594e extends g.b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f13689d = b.f13690e;

    /* renamed from: t2.e$a */
    public static final class a {
        public static g.b a(InterfaceC0594e interfaceC0594e, g.c cVar) {
            g.b b3;
            k.e(cVar, "key");
            if (!(cVar instanceof AbstractC0591b)) {
                if (InterfaceC0594e.f13689d != cVar) {
                    return null;
                }
                k.c(interfaceC0594e, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return interfaceC0594e;
            }
            AbstractC0591b abstractC0591b = (AbstractC0591b) cVar;
            if (!abstractC0591b.a(interfaceC0594e.getKey()) || (b3 = abstractC0591b.b(interfaceC0594e)) == null) {
                return null;
            }
            return b3;
        }

        public static g b(InterfaceC0594e interfaceC0594e, g.c cVar) {
            k.e(cVar, "key");
            if (!(cVar instanceof AbstractC0591b)) {
                return InterfaceC0594e.f13689d == cVar ? h.f13692e : interfaceC0594e;
            }
            AbstractC0591b abstractC0591b = (AbstractC0591b) cVar;
            return (!abstractC0591b.a(interfaceC0594e.getKey()) || abstractC0591b.b(interfaceC0594e) == null) ? interfaceC0594e : h.f13692e;
        }
    }

    /* renamed from: t2.e$b */
    public static final class b implements g.c {

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ b f13690e = new b();

        private b() {
        }
    }

    InterfaceC0593d G(InterfaceC0593d interfaceC0593d);

    void j(InterfaceC0593d interfaceC0593d);
}
