package Q2;

import L2.AbstractC0166a;
import L2.AbstractC0192y;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public class z extends AbstractC0166a implements v2.e {

    /* renamed from: h, reason: collision with root package name */
    public final InterfaceC0593d f2022h;

    public z(t2.g gVar, InterfaceC0593d interfaceC0593d) {
        super(gVar, true, true);
        this.f2022h = interfaceC0593d;
    }

    @Override // L2.AbstractC0166a
    protected void D0(Object obj) {
        InterfaceC0593d interfaceC0593d = this.f2022h;
        interfaceC0593d.resumeWith(AbstractC0192y.a(obj, interfaceC0593d));
    }

    @Override // L2.l0
    protected final boolean e0() {
        return true;
    }

    @Override // v2.e
    public final v2.e getCallerFrame() {
        InterfaceC0593d interfaceC0593d = this.f2022h;
        if (interfaceC0593d instanceof v2.e) {
            return (v2.e) interfaceC0593d;
        }
        return null;
    }

    @Override // L2.l0
    protected void y(Object obj) {
        AbstractC0202i.c(AbstractC0603b.b(this.f2022h), AbstractC0192y.a(obj, this.f2022h), null, 2, null);
    }
}
