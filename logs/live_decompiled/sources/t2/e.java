package T2;

import Q2.D;
import Q2.G;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2222a;

    /* renamed from: b, reason: collision with root package name */
    private static final D f2223b;

    /* renamed from: c, reason: collision with root package name */
    private static final D f2224c;

    /* renamed from: d, reason: collision with root package name */
    private static final D f2225d;

    /* renamed from: e, reason: collision with root package name */
    private static final D f2226e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f2227f;

    static {
        int e3;
        int e4;
        e3 = G.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f2222a = e3;
        f2223b = new D("PERMIT");
        f2224c = new D("TAKEN");
        f2225d = new D("BROKEN");
        f2226e = new D("CANCELLED");
        e4 = G.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f2227f = e4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f h(long j3, f fVar) {
        return new f(j3, fVar, 0);
    }
}
