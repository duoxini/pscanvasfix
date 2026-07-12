package H;

import C2.l;
import D2.k;
import androidx.lifecycle.F;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List f456a = new ArrayList();

    public final void a(I2.b bVar, l lVar) {
        k.e(bVar, "clazz");
        k.e(lVar, "initializer");
        this.f456a.add(new f(B2.a.a(bVar), lVar));
    }

    public final F.b b() {
        Object[] array = this.f456a.toArray(new f[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        f[] fVarArr = (f[]) array;
        return new b((f[]) Arrays.copyOf(fVarArr, fVarArr.length));
    }
}
