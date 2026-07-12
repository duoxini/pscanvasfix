package L2;

/* loaded from: classes.dex */
public abstract class h0 extends l0 implements InterfaceC0186s {

    /* renamed from: g, reason: collision with root package name */
    private final boolean f1271g;

    public h0(e0 e0Var) {
        super(true);
        Y(e0Var);
        this.f1271g = D0();
    }

    private final boolean D0() {
        l0 v3;
        InterfaceC0184p T3 = T();
        C0185q c0185q = T3 instanceof C0185q ? (C0185q) T3 : null;
        if (c0185q != null && (v3 = c0185q.v()) != null) {
            while (!v3.Q()) {
                InterfaceC0184p T4 = v3.T();
                C0185q c0185q2 = T4 instanceof C0185q ? (C0185q) T4 : null;
                if (c0185q2 != null && (v3 = c0185q2.v()) != null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // L2.l0
    public boolean Q() {
        return this.f1271g;
    }

    @Override // L2.l0
    public boolean R() {
        return true;
    }
}
