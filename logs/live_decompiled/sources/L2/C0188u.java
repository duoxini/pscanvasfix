package L2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: L2.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0188u {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f1307b = AtomicIntegerFieldUpdater.newUpdater(C0188u.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f1308a;

    public C0188u(Throwable th, boolean z3) {
        this.f1308a = th;
        this._handled = z3 ? 1 : 0;
    }

    public final boolean a() {
        return f1307b.get(this) != 0;
    }

    public final boolean b() {
        return f1307b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return H.a(this) + '[' + this.f1308a + ']';
    }

    public /* synthetic */ C0188u(Throwable th, boolean z3, int i3, D2.g gVar) {
        this(th, (i3 & 2) != 0 ? false : z3);
    }
}
