package H;

import D2.k;
import androidx.lifecycle.E;
import androidx.lifecycle.F;

/* loaded from: classes.dex */
public final class b implements F.b {

    /* renamed from: b, reason: collision with root package name */
    private final f[] f455b;

    public b(f... fVarArr) {
        k.e(fVarArr, "initializers");
        this.f455b = fVarArr;
    }

    @Override // androidx.lifecycle.F.b
    public E b(Class cls, a aVar) {
        k.e(cls, "modelClass");
        k.e(aVar, "extras");
        E e3 = null;
        for (f fVar : this.f455b) {
            if (k.a(fVar.a(), cls)) {
                Object f3 = fVar.b().f(aVar);
                e3 = f3 instanceof E ? (E) f3 : null;
            }
        }
        if (e3 != null) {
            return e3;
        }
        throw new IllegalArgumentException("No initializer set for given class " + cls.getName());
    }
}
