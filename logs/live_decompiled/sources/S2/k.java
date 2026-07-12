package S2;

import L2.H;

/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f2166g;

    public k(Runnable runnable, long j3, i iVar) {
        super(j3, iVar);
        this.f2166g = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f2166g.run();
        } finally {
            this.f2164f.b();
        }
    }

    public String toString() {
        return "Task[" + H.a(this.f2166g) + '@' + H.b(this.f2166g) + ", " + this.f2163e + ", " + this.f2164f + ']';
    }
}
