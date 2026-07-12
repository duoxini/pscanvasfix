package P2;

import N2.s;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public final class i implements O2.d {

    /* renamed from: a, reason: collision with root package name */
    private final s f1877a;

    public i(s sVar) {
        this.f1877a = sVar;
    }

    @Override // O2.d
    public Object emit(Object obj, InterfaceC0593d interfaceC0593d) {
        Object n3 = this.f1877a.n(obj, interfaceC0593d);
        return n3 == AbstractC0603b.c() ? n3 : q.f12810a;
    }
}
