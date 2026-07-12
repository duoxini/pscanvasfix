package Q2;

import L2.AbstractC0192y;
import L2.AbstractC0193z;
import L2.S;
import L2.e0;
import L2.x0;
import L2.z0;
import java.util.concurrent.CancellationException;
import p2.C0511k;
import t2.InterfaceC0593d;

/* renamed from: Q2.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0202i {

    /* renamed from: a, reason: collision with root package name */
    private static final D f1990a = new D("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final D f1991b = new D("REUSABLE_CLAIMED");

    public static final void b(InterfaceC0593d interfaceC0593d, Object obj, C2.l lVar) {
        if (!(interfaceC0593d instanceof C0201h)) {
            interfaceC0593d.resumeWith(obj);
            return;
        }
        C0201h c0201h = (C0201h) interfaceC0593d;
        Object b3 = AbstractC0192y.b(obj, lVar);
        if (c0201h.f1986h.d0(c0201h.getContext())) {
            c0201h.f1988j = b3;
            c0201h.f1244g = 1;
            c0201h.f1986h.c0(c0201h.getContext(), c0201h);
            return;
        }
        S a3 = x0.f1311a.a();
        if (a3.l0()) {
            c0201h.f1988j = b3;
            c0201h.f1244g = 1;
            a3.h0(c0201h);
            return;
        }
        a3.j0(true);
        try {
            e0 e0Var = (e0) c0201h.getContext().a(e0.f1268b);
            if (e0Var == null || e0Var.c()) {
                InterfaceC0593d interfaceC0593d2 = c0201h.f1987i;
                Object obj2 = c0201h.f1989k;
                t2.g context = interfaceC0593d2.getContext();
                Object c3 = H.c(context, obj2);
                z0 g3 = c3 != H.f1967a ? AbstractC0193z.g(interfaceC0593d2, context, c3) : null;
                try {
                    c0201h.f1987i.resumeWith(obj);
                    p2.q qVar = p2.q.f12810a;
                } finally {
                    if (g3 == null || g3.H0()) {
                        H.a(context, c3);
                    }
                }
            } else {
                CancellationException q3 = e0Var.q();
                c0201h.a(b3, q3);
                C0511k.a aVar = C0511k.f12803f;
                c0201h.resumeWith(C0511k.b(p2.l.a(q3)));
            }
            while (a3.n0()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(InterfaceC0593d interfaceC0593d, Object obj, C2.l lVar, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            lVar = null;
        }
        b(interfaceC0593d, obj, lVar);
    }
}
