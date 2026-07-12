package Q2;

import L2.o0;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f2016a;

    /* renamed from: b, reason: collision with root package name */
    public static final o0 f2017b;

    static {
        s sVar = new s();
        f2016a = sVar;
        E.f("kotlinx.coroutines.fast.service.loader", true);
        f2017b = sVar.a();
    }

    private s() {
    }

    private final o0 a() {
        Object next;
        o0 e3;
        try {
            List d3 = J2.c.d(J2.c.a(ServiceLoader.load(r.class, r.class.getClassLoader()).iterator()));
            Iterator it = d3.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int a3 = ((r) next).a();
                    do {
                        Object next2 = it.next();
                        int a4 = ((r) next2).a();
                        if (a3 < a4) {
                            next = next2;
                            a3 = a4;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            if (rVar != null && (e3 = t.e(rVar, d3)) != null) {
                return e3;
            }
            t.b(null, null, 3, null);
            return null;
        } catch (Throwable th) {
            t.b(th, null, 2, null);
            return null;
        }
    }
}
