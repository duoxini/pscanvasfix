package S2;

import L2.A;
import L2.Y;
import Q2.E;
import Q2.G;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b extends Y implements Executor {

    /* renamed from: h, reason: collision with root package name */
    public static final b f2154h = new b();

    /* renamed from: i, reason: collision with root package name */
    private static final A f2155i;

    static {
        int e3;
        m mVar = m.f2175g;
        e3 = G.e("kotlinx.coroutines.io.parallelism", H2.d.b(64, E.a()), 0, 0, 12, null);
        f2155i = mVar.e0(e3);
    }

    private b() {
    }

    @Override // L2.A
    public void c0(t2.g gVar, Runnable runnable) {
        f2155i.c0(gVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c0(t2.h.f13692e, runnable);
    }

    @Override // L2.A
    public String toString() {
        return "Dispatchers.IO";
    }
}
