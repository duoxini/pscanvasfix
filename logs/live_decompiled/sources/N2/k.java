package N2;

import L2.X;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
abstract /* synthetic */ class k {
    public static final void a(r rVar, Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = X.a("Channel was consumed, consumer had failed", th);
            }
        }
        rVar.b(r0);
    }
}
