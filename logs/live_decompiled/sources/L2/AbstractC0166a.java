package L2;

import t2.InterfaceC0593d;

/* renamed from: L2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0166a extends l0 implements e0, InterfaceC0593d, D {

    /* renamed from: g, reason: collision with root package name */
    private final t2.g f1261g;

    public AbstractC0166a(t2.g gVar, boolean z3, boolean z4) {
        super(z4);
        if (z3) {
            Y((e0) gVar.a(e0.f1268b));
        }
        this.f1261g = gVar.p(this);
    }

    protected void D0(Object obj) {
        y(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // L2.l0
    public String E() {
        return H.a(this) + " was cancelled";
    }

    protected void E0(Throwable th, boolean z3) {
    }

    protected void F0(Object obj) {
    }

    public final void G0(F f3, Object obj, C2.p pVar) {
        f3.b(pVar, obj, this);
    }

    @Override // L2.l0
    public final void W(Throwable th) {
        C.a(this.f1261g, th);
    }

    @Override // L2.l0, L2.e0
    public boolean c() {
        return super.c();
    }

    @Override // t2.InterfaceC0593d
    public final t2.g getContext() {
        return this.f1261g;
    }

    @Override // L2.D
    public t2.g h() {
        return this.f1261g;
    }

    @Override // L2.l0
    public String i0() {
        String b3 = AbstractC0193z.b(this.f1261g);
        if (b3 == null) {
            return super.i0();
        }
        return '\"' + b3 + "\":" + super.i0();
    }

    @Override // L2.l0
    protected final void n0(Object obj) {
        if (!(obj instanceof C0188u)) {
            F0(obj);
        } else {
            C0188u c0188u = (C0188u) obj;
            E0(c0188u.f1308a, c0188u.a());
        }
    }

    @Override // t2.InterfaceC0593d
    public final void resumeWith(Object obj) {
        Object g02 = g0(AbstractC0192y.d(obj, null, 1, null));
        if (g02 == m0.f1292b) {
            return;
        }
        D0(g02);
    }
}
