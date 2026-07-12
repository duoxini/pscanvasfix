package v2;

import t2.InterfaceC0593d;
import t2.InterfaceC0594e;
import t2.g;

/* loaded from: classes.dex */
public abstract class d extends AbstractC0610a {

    /* renamed from: f, reason: collision with root package name */
    private final t2.g f13851f;

    /* renamed from: g, reason: collision with root package name */
    private transient InterfaceC0593d f13852g;

    public d(InterfaceC0593d interfaceC0593d, t2.g gVar) {
        super(interfaceC0593d);
        this.f13851f = gVar;
    }

    @Override // v2.AbstractC0610a
    protected void a() {
        InterfaceC0593d interfaceC0593d = this.f13852g;
        if (interfaceC0593d != null && interfaceC0593d != this) {
            g.b a3 = getContext().a(InterfaceC0594e.f13689d);
            D2.k.b(a3);
            ((InterfaceC0594e) a3).j(interfaceC0593d);
        }
        this.f13852g = C0612c.f13850e;
    }

    @Override // t2.InterfaceC0593d
    public t2.g getContext() {
        t2.g gVar = this.f13851f;
        D2.k.b(gVar);
        return gVar;
    }

    public final InterfaceC0593d intercepted() {
        InterfaceC0593d interfaceC0593d = this.f13852g;
        if (interfaceC0593d == null) {
            InterfaceC0594e interfaceC0594e = (InterfaceC0594e) getContext().a(InterfaceC0594e.f13689d);
            if (interfaceC0594e == null || (interfaceC0593d = interfaceC0594e.G(this)) == null) {
                interfaceC0593d = this;
            }
            this.f13852g = interfaceC0593d;
        }
        return interfaceC0593d;
    }

    public d(InterfaceC0593d interfaceC0593d) {
        this(interfaceC0593d, interfaceC0593d != null ? interfaceC0593d.getContext() : null);
    }
}
