package Q2;

import java.util.Collection;
import java.util.ServiceLoader;

/* renamed from: Q2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0198e {

    /* renamed from: a, reason: collision with root package name */
    private static final Collection f1983a = J2.c.d(J2.c.a(ServiceLoader.load(L2.B.class, L2.B.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return f1983a;
    }

    public static final void b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }
}
