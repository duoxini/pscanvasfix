package P2;

import t2.InterfaceC0593d;

/* loaded from: classes.dex */
final class j implements InterfaceC0593d, v2.e {

    /* renamed from: e, reason: collision with root package name */
    private final InterfaceC0593d f1878e;

    /* renamed from: f, reason: collision with root package name */
    private final t2.g f1879f;

    public j(InterfaceC0593d interfaceC0593d, t2.g gVar) {
        this.f1878e = interfaceC0593d;
        this.f1879f = gVar;
    }

    @Override // v2.e
    public v2.e getCallerFrame() {
        InterfaceC0593d interfaceC0593d = this.f1878e;
        if (interfaceC0593d instanceof v2.e) {
            return (v2.e) interfaceC0593d;
        }
        return null;
    }

    @Override // t2.InterfaceC0593d
    public t2.g getContext() {
        return this.f1879f;
    }

    @Override // t2.InterfaceC0593d
    public void resumeWith(Object obj) {
        this.f1878e.resumeWith(obj);
    }
}
