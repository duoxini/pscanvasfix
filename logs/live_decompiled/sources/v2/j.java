package v2;

import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class j extends AbstractC0610a {
    public j(InterfaceC0593d interfaceC0593d) {
        super(interfaceC0593d);
        if (interfaceC0593d != null && interfaceC0593d.getContext() != t2.h.f13692e) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // t2.InterfaceC0593d
    public t2.g getContext() {
        return t2.h.f13692e;
    }
}
