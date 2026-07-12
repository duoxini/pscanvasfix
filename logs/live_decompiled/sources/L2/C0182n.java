package L2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: L2.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0182n extends C0188u {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1298c = AtomicIntegerFieldUpdater.newUpdater(C0182n.class, "_resumed");
    private volatile int _resumed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C0182n(t2.InterfaceC0593d r3, java.lang.Throwable r4, boolean r5) {
        /*
            r2 = this;
            if (r4 != 0) goto L1d
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Continuation "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = " was cancelled normally"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4.<init>(r3)
        L1d:
            r2.<init>(r4, r5)
            r3 = 0
            r2._resumed = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: L2.C0182n.<init>(t2.d, java.lang.Throwable, boolean):void");
    }

    public final boolean c() {
        return f1298c.compareAndSet(this, 0, 1);
    }
}
