package Q2;

import java.util.Iterator;
import p2.AbstractC0501a;

/* renamed from: Q2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0199f {
    public static final void a(t2.g gVar, Throwable th) {
        Iterator it = AbstractC0198e.a().iterator();
        while (it.hasNext()) {
            try {
                ((L2.B) it.next()).u(gVar, th);
            } catch (Throwable th2) {
                AbstractC0198e.b(L2.C.b(th, th2));
            }
        }
        try {
            AbstractC0501a.a(th, new C0200g(gVar));
        } catch (Throwable unused) {
        }
        AbstractC0198e.b(th);
    }
}
