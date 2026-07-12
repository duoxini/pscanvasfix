package N2;

import L2.AbstractC0166a;
import L2.f0;
import L2.l0;
import java.util.concurrent.CancellationException;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class e extends AbstractC0166a implements d {

    /* renamed from: h, reason: collision with root package name */
    private final d f1668h;

    public e(t2.g gVar, d dVar, boolean z3, boolean z4) {
        super(gVar, z3, z4);
        this.f1668h = dVar;
    }

    @Override // L2.l0
    public void B(Throwable th) {
        CancellationException w02 = l0.w0(this, th, null, 1, null);
        this.f1668h.b(w02);
        z(w02);
    }

    public final d H0() {
        return this;
    }

    protected final d I0() {
        return this.f1668h;
    }

    @Override // L2.l0, L2.e0
    public final void b(CancellationException cancellationException) {
        if (c0()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new f0(E(), null, this);
        }
        B(cancellationException);
    }

    @Override // N2.s
    public void d(C2.l lVar) {
        this.f1668h.d(lVar);
    }

    @Override // N2.s
    public boolean e(Throwable th) {
        return this.f1668h.e(th);
    }

    @Override // N2.s
    public Object f(Object obj) {
        return this.f1668h.f(obj);
    }

    @Override // N2.r
    public f iterator() {
        return this.f1668h.iterator();
    }

    @Override // N2.s
    public Object n(Object obj, InterfaceC0593d interfaceC0593d) {
        return this.f1668h.n(obj, interfaceC0593d);
    }

    @Override // N2.s
    public boolean o() {
        return this.f1668h.o();
    }
}
