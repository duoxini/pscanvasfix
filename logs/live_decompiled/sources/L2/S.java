package L2;

import q2.C0537g;

/* loaded from: classes.dex */
public abstract class S extends A {

    /* renamed from: g, reason: collision with root package name */
    private long f1250g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1251h;

    /* renamed from: i, reason: collision with root package name */
    private C0537g f1252i;

    private final long g0(boolean z3) {
        return z3 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void k0(S s3, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i3 & 1) != 0) {
            z3 = false;
        }
        s3.j0(z3);
    }

    public final void f0(boolean z3) {
        long g02 = this.f1250g - g0(z3);
        this.f1250g = g02;
        if (g02 <= 0 && this.f1251h) {
            o0();
        }
    }

    public final void h0(M m3) {
        C0537g c0537g = this.f1252i;
        if (c0537g == null) {
            c0537g = new C0537g();
            this.f1252i = c0537g;
        }
        c0537g.addLast(m3);
    }

    protected long i0() {
        C0537g c0537g = this.f1252i;
        return (c0537g == null || c0537g.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void j0(boolean z3) {
        this.f1250g += g0(z3);
        if (z3) {
            return;
        }
        this.f1251h = true;
    }

    public final boolean l0() {
        return this.f1250g >= g0(true);
    }

    public final boolean m0() {
        C0537g c0537g = this.f1252i;
        if (c0537g != null) {
            return c0537g.isEmpty();
        }
        return true;
    }

    public final boolean n0() {
        M m3;
        C0537g c0537g = this.f1252i;
        if (c0537g == null || (m3 = (M) c0537g.j()) == null) {
            return false;
        }
        m3.run();
        return true;
    }

    public abstract void o0();
}
