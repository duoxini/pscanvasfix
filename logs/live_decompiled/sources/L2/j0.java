package L2;

import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract /* synthetic */ class j0 {
    public static final void a(t2.g gVar, CancellationException cancellationException) {
        e0 e0Var = (e0) gVar.a(e0.f1268b);
        if (e0Var != null) {
            e0Var.b(cancellationException);
        }
    }

    public static /* synthetic */ void b(t2.g gVar, CancellationException cancellationException, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            cancellationException = null;
        }
        i0.a(gVar, cancellationException);
    }

    public static final void c(e0 e0Var) {
        if (!e0Var.c()) {
            throw e0Var.q();
        }
    }

    public static final void d(t2.g gVar) {
        e0 e0Var = (e0) gVar.a(e0.f1268b);
        if (e0Var != null) {
            i0.c(e0Var);
        }
    }
}
