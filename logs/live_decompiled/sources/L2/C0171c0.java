package L2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: L2.c0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0171c0 extends g0 {

    /* renamed from: j, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1263j = AtomicIntegerFieldUpdater.newUpdater(C0171c0.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: i, reason: collision with root package name */
    private final C2.l f1264i;

    public C0171c0(C2.l lVar) {
        this.f1264i = lVar;
    }

    @Override // C2.l
    public /* bridge */ /* synthetic */ Object f(Object obj) {
        u((Throwable) obj);
        return p2.q.f12810a;
    }

    @Override // L2.AbstractC0190w
    public void u(Throwable th) {
        if (f1263j.compareAndSet(this, 0, 1)) {
            this.f1264i.f(th);
        }
    }
}
