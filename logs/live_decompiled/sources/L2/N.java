package L2;

import Q2.C0201h;
import p2.C0511k;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class N {
    public static final void a(M m3, int i3) {
        InterfaceC0593d c3 = m3.c();
        boolean z3 = i3 == 4;
        if (z3 || !(c3 instanceof C0201h) || b(i3) != b(m3.f1244g)) {
            d(m3, c3, z3);
            return;
        }
        A a3 = ((C0201h) c3).f1986h;
        t2.g context = c3.getContext();
        if (a3.d0(context)) {
            a3.c0(context, m3);
        } else {
            e(m3);
        }
    }

    public static final boolean b(int i3) {
        return i3 == 1 || i3 == 2;
    }

    public static final boolean c(int i3) {
        return i3 == 2;
    }

    public static final void d(M m3, InterfaceC0593d interfaceC0593d, boolean z3) {
        Object e3;
        Object g3 = m3.g();
        Throwable d3 = m3.d(g3);
        if (d3 != null) {
            C0511k.a aVar = C0511k.f12803f;
            e3 = p2.l.a(d3);
        } else {
            C0511k.a aVar2 = C0511k.f12803f;
            e3 = m3.e(g3);
        }
        Object b3 = C0511k.b(e3);
        if (!z3) {
            interfaceC0593d.resumeWith(b3);
            return;
        }
        D2.k.c(interfaceC0593d, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C0201h c0201h = (C0201h) interfaceC0593d;
        InterfaceC0593d interfaceC0593d2 = c0201h.f1987i;
        Object obj = c0201h.f1989k;
        t2.g context = interfaceC0593d2.getContext();
        Object c3 = Q2.H.c(context, obj);
        z0 g4 = c3 != Q2.H.f1967a ? AbstractC0193z.g(interfaceC0593d2, context, c3) : null;
        try {
            c0201h.f1987i.resumeWith(b3);
            p2.q qVar = p2.q.f12810a;
        } finally {
            if (g4 == null || g4.H0()) {
                Q2.H.a(context, c3);
            }
        }
    }

    private static final void e(M m3) {
        S a3 = x0.f1311a.a();
        if (a3.l0()) {
            a3.h0(m3);
            return;
        }
        a3.j0(true);
        try {
            d(m3, m3.c(), true);
            do {
            } while (a3.n0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
