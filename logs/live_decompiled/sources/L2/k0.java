package L2;

/* loaded from: classes.dex */
public abstract class k0 extends AbstractC0190w implements P, InterfaceC0167a0 {

    /* renamed from: h, reason: collision with root package name */
    public l0 f1277h;

    @Override // L2.P
    public void a() {
        v().r0(this);
    }

    @Override // L2.InterfaceC0167a0
    public boolean c() {
        return true;
    }

    @Override // L2.InterfaceC0167a0
    public p0 d() {
        return null;
    }

    @Override // Q2.o
    public String toString() {
        return H.a(this) + '@' + H.b(this) + "[job@" + H.b(v()) + ']';
    }

    public final l0 v() {
        l0 l0Var = this.f1277h;
        if (l0Var != null) {
            return l0Var;
        }
        D2.k.n("job");
        return null;
    }

    public final void w(l0 l0Var) {
        this.f1277h = l0Var;
    }
}
