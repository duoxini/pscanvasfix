package L2;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class X {
    public static final CancellationException a(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
