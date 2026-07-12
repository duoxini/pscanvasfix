package L2;

import Q2.AbstractC0199f;
import p2.AbstractC0501a;

/* loaded from: classes.dex */
public abstract class C {
    public static final void a(t2.g gVar, Throwable th) {
        try {
            B b3 = (B) gVar.a(B.f1230a);
            if (b3 != null) {
                b3.u(gVar, th);
            } else {
                AbstractC0199f.a(gVar, th);
            }
        } catch (Throwable th2) {
            AbstractC0199f.a(gVar, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC0501a.a(runtimeException, th);
        return runtimeException;
    }
}
