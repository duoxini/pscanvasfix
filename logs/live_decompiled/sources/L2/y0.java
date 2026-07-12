package L2;

/* loaded from: classes.dex */
public final class y0 extends A {

    /* renamed from: g, reason: collision with root package name */
    public static final y0 f1313g = new y0();

    private y0() {
    }

    @Override // L2.A
    public void c0(t2.g gVar, Runnable runnable) {
        androidx.appcompat.app.p.a(gVar.a(C0.f1232f));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override // L2.A
    public boolean d0(t2.g gVar) {
        return false;
    }

    @Override // L2.A
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
