package L2;

import Q2.C0201h;
import java.util.concurrent.CancellationException;
import p2.AbstractC0501a;
import p2.C0511k;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class M extends S2.h {

    /* renamed from: g, reason: collision with root package name */
    public int f1244g;

    public M(int i3) {
        this.f1244g = i3;
    }

    public abstract void a(Object obj, Throwable th);

    public abstract InterfaceC0593d c();

    public Throwable d(Object obj) {
        C0188u c0188u = obj instanceof C0188u ? (C0188u) obj : null;
        if (c0188u != null) {
            return c0188u.f1308a;
        }
        return null;
    }

    public Object e(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            AbstractC0501a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        D2.k.b(th);
        C.a(c().getContext(), new G("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object g();

    @Override // java.lang.Runnable
    public final void run() {
        Object b3;
        Object b4;
        S2.i iVar = this.f2164f;
        try {
            InterfaceC0593d c3 = c();
            D2.k.c(c3, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            C0201h c0201h = (C0201h) c3;
            InterfaceC0593d interfaceC0593d = c0201h.f1987i;
            Object obj = c0201h.f1989k;
            t2.g context = interfaceC0593d.getContext();
            Object c4 = Q2.H.c(context, obj);
            z0 g3 = c4 != Q2.H.f1967a ? AbstractC0193z.g(interfaceC0593d, context, c4) : null;
            try {
                t2.g context2 = interfaceC0593d.getContext();
                Object g4 = g();
                Throwable d3 = d(g4);
                e0 e0Var = (d3 == null && N.b(this.f1244g)) ? (e0) context2.a(e0.f1268b) : null;
                if (e0Var != null && !e0Var.c()) {
                    CancellationException q3 = e0Var.q();
                    a(g4, q3);
                    C0511k.a aVar = C0511k.f12803f;
                    interfaceC0593d.resumeWith(C0511k.b(p2.l.a(q3)));
                } else if (d3 != null) {
                    C0511k.a aVar2 = C0511k.f12803f;
                    interfaceC0593d.resumeWith(C0511k.b(p2.l.a(d3)));
                } else {
                    C0511k.a aVar3 = C0511k.f12803f;
                    interfaceC0593d.resumeWith(C0511k.b(e(g4)));
                }
                p2.q qVar = p2.q.f12810a;
                if (g3 == null || g3.H0()) {
                    Q2.H.a(context, c4);
                }
                try {
                    iVar.b();
                    b4 = C0511k.b(p2.q.f12810a);
                } catch (Throwable th) {
                    C0511k.a aVar4 = C0511k.f12803f;
                    b4 = C0511k.b(p2.l.a(th));
                }
                f(null, C0511k.d(b4));
            } catch (Throwable th2) {
                if (g3 == null || g3.H0()) {
                    Q2.H.a(context, c4);
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                C0511k.a aVar5 = C0511k.f12803f;
                iVar.b();
                b3 = C0511k.b(p2.q.f12810a);
            } catch (Throwable th4) {
                C0511k.a aVar6 = C0511k.f12803f;
                b3 = C0511k.b(p2.l.a(th4));
            }
            f(th3, C0511k.d(b3));
        }
    }
}
