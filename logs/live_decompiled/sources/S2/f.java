package S2;

import L2.Y;

/* loaded from: classes.dex */
public abstract class f extends Y {

    /* renamed from: h, reason: collision with root package name */
    private final int f2158h;

    /* renamed from: i, reason: collision with root package name */
    private final int f2159i;

    /* renamed from: j, reason: collision with root package name */
    private final long f2160j;

    /* renamed from: k, reason: collision with root package name */
    private final String f2161k;

    /* renamed from: l, reason: collision with root package name */
    private a f2162l = f0();

    public f(int i3, int i4, long j3, String str) {
        this.f2158h = i3;
        this.f2159i = i4;
        this.f2160j = j3;
        this.f2161k = str;
    }

    private final a f0() {
        return new a(this.f2158h, this.f2159i, this.f2160j, this.f2161k);
    }

    @Override // L2.A
    public void c0(t2.g gVar, Runnable runnable) {
        a.l(this.f2162l, runnable, null, false, 6, null);
    }

    public final void g0(Runnable runnable, i iVar, boolean z3) {
        this.f2162l.j(runnable, iVar, z3);
    }
}
