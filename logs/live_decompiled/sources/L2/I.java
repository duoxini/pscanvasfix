package L2;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/* loaded from: classes.dex */
public final class I extends T implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: m, reason: collision with root package name */
    public static final I f1239m;

    /* renamed from: n, reason: collision with root package name */
    private static final long f1240n;

    static {
        Long l3;
        I i3 = new I();
        f1239m = i3;
        S.k0(i3, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l3 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l3 = 1000L;
        }
        f1240n = timeUnit.toNanos(l3.longValue());
    }

    private I() {
    }

    private final synchronized void B0() {
        if (E0()) {
            debugStatus = 3;
            z0();
            D2.k.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread C0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean D0() {
        return debugStatus == 4;
    }

    private final boolean E0() {
        int i3 = debugStatus;
        return i3 == 2 || i3 == 3;
    }

    private final synchronized boolean F0() {
        if (E0()) {
            return false;
        }
        debugStatus = 1;
        D2.k.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void G0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // L2.T, L2.S
    public void o0() {
        debugStatus = 4;
        super.o0();
    }

    @Override // L2.U
    protected Thread p0() {
        Thread thread = _thread;
        return thread == null ? C0() : thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean w02;
        x0.f1311a.c(this);
        AbstractC0170c.a();
        try {
            if (!F0()) {
                if (w02) {
                    return;
                } else {
                    return;
                }
            }
            long j3 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long x02 = x0();
                if (x02 == Long.MAX_VALUE) {
                    AbstractC0170c.a();
                    long nanoTime = System.nanoTime();
                    if (j3 == Long.MAX_VALUE) {
                        j3 = f1240n + nanoTime;
                    }
                    long j4 = j3 - nanoTime;
                    if (j4 <= 0) {
                        _thread = null;
                        B0();
                        AbstractC0170c.a();
                        if (w0()) {
                            return;
                        }
                        p0();
                        return;
                    }
                    x02 = H2.d.d(x02, j4);
                } else {
                    j3 = Long.MAX_VALUE;
                }
                if (x02 > 0) {
                    if (E0()) {
                        _thread = null;
                        B0();
                        AbstractC0170c.a();
                        if (w0()) {
                            return;
                        }
                        p0();
                        return;
                    }
                    AbstractC0170c.a();
                    LockSupport.parkNanos(this, x02);
                }
            }
        } finally {
            _thread = null;
            B0();
            AbstractC0170c.a();
            if (!w0()) {
                p0();
            }
        }
    }

    @Override // L2.T
    public void t0(Runnable runnable) {
        if (D0()) {
            G0();
        }
        super.t0(runnable);
    }
}
