package S2;

import Q2.E;
import Q2.G;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2167a = E.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b, reason: collision with root package name */
    public static final long f2168b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f2169c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f2170d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f2171e;

    /* renamed from: f, reason: collision with root package name */
    public static g f2172f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f2173g;

    /* renamed from: h, reason: collision with root package name */
    public static final i f2174h;

    static {
        long f3;
        int e3;
        int e4;
        long f4;
        f3 = G.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f2168b = f3;
        e3 = G.e("kotlinx.coroutines.scheduler.core.pool.size", H2.d.b(E.a(), 2), 1, 0, 8, null);
        f2169c = e3;
        e4 = G.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f2170d = e4;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f4 = G.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f2171e = timeUnit.toNanos(f4);
        f2172f = e.f2157a;
        f2173g = new j(0);
        f2174h = new j(1);
    }
}
