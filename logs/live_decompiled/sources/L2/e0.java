package L2;

import java.util.concurrent.CancellationException;
import t2.g;

/* loaded from: classes.dex */
public interface e0 extends g.b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f1268b = b.f1269e;

    public static final class a {
        public static /* synthetic */ void a(e0 e0Var, CancellationException cancellationException, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i3 & 1) != 0) {
                cancellationException = null;
            }
            e0Var.b(cancellationException);
        }

        public static Object b(e0 e0Var, Object obj, C2.p pVar) {
            return g.b.a.a(e0Var, obj, pVar);
        }

        public static g.b c(e0 e0Var, g.c cVar) {
            return g.b.a.b(e0Var, cVar);
        }

        public static /* synthetic */ P d(e0 e0Var, boolean z3, boolean z4, C2.l lVar, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i3 & 1) != 0) {
                z3 = false;
            }
            if ((i3 & 2) != 0) {
                z4 = true;
            }
            return e0Var.b0(z3, z4, lVar);
        }

        public static t2.g e(e0 e0Var, g.c cVar) {
            return g.b.a.c(e0Var, cVar);
        }

        public static t2.g f(e0 e0Var, t2.g gVar) {
            return g.b.a.d(e0Var, gVar);
        }
    }

    public static final class b implements g.c {

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ b f1269e = new b();

        private b() {
        }
    }

    InterfaceC0184p a0(r rVar);

    void b(CancellationException cancellationException);

    P b0(boolean z3, boolean z4, C2.l lVar);

    boolean c();

    CancellationException q();

    boolean start();
}
