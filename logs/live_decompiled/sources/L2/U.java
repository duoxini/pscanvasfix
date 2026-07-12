package L2;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public abstract class U extends S {
    protected abstract Thread p0();

    protected final void q0() {
        Thread p02 = p0();
        if (Thread.currentThread() != p02) {
            AbstractC0170c.a();
            LockSupport.unpark(p02);
        }
    }
}
