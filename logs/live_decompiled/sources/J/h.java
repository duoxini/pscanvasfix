package J;

/* loaded from: classes.dex */
public abstract class h extends A {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u uVar) {
        super(uVar);
        D2.k.e(uVar, "database");
    }

    protected abstract void i(N.k kVar, Object obj);

    public final int j(Object[] objArr) {
        D2.k.e(objArr, "entities");
        N.k b3 = b();
        try {
            int i3 = 0;
            for (Object obj : objArr) {
                i(b3, obj);
                i3 += b3.B();
            }
            return i3;
        } finally {
            h(b3);
        }
    }
}
