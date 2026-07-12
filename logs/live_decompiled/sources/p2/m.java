package p2;

import java.io.Serializable;

/* loaded from: classes.dex */
final class m implements InterfaceC0505e, Serializable {

    /* renamed from: e, reason: collision with root package name */
    private C2.a f12806e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Object f12807f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f12808g;

    public m(C2.a aVar, Object obj) {
        D2.k.e(aVar, "initializer");
        this.f12806e = aVar;
        this.f12807f = o.f12809a;
        this.f12808g = obj == null ? this : obj;
    }

    @Override // p2.InterfaceC0505e
    public boolean a() {
        return this.f12807f != o.f12809a;
    }

    @Override // p2.InterfaceC0505e
    public Object getValue() {
        Object obj;
        Object obj2 = this.f12807f;
        o oVar = o.f12809a;
        if (obj2 != oVar) {
            return obj2;
        }
        synchronized (this.f12808g) {
            obj = this.f12807f;
            if (obj == oVar) {
                C2.a aVar = this.f12806e;
                D2.k.b(aVar);
                obj = aVar.invoke();
                this.f12807f = obj;
                this.f12806e = null;
            }
        }
        return obj;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ m(C2.a aVar, Object obj, int i3, D2.g gVar) {
        this(aVar, (i3 & 2) != 0 ? null : obj);
    }
}
