package Q2;

/* renamed from: Q2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0196c {

    /* renamed from: a, reason: collision with root package name */
    private static final D f1980a = new D("CLOSED");

    public static final AbstractC0197d b(AbstractC0197d abstractC0197d) {
        while (true) {
            Object f3 = abstractC0197d.f();
            if (f3 == f1980a) {
                return abstractC0197d;
            }
            AbstractC0197d abstractC0197d2 = (AbstractC0197d) f3;
            if (abstractC0197d2 != null) {
                abstractC0197d = abstractC0197d2;
            } else if (abstractC0197d.j()) {
                return abstractC0197d;
            }
        }
    }

    public static final Object c(A a3, long j3, C2.p pVar) {
        while (true) {
            if (a3.f1961g >= j3 && !a3.h()) {
                return B.a(a3);
            }
            Object f3 = a3.f();
            if (f3 == f1980a) {
                return B.a(f1980a);
            }
            A a4 = (A) ((AbstractC0197d) f3);
            if (a4 == null) {
                a4 = (A) pVar.invoke(Long.valueOf(a3.f1961g + 1), a3);
                if (a3.l(a4)) {
                    if (a3.h()) {
                        a3.k();
                    }
                }
            }
            a3 = a4;
        }
    }
}
