package J;

/* loaded from: classes.dex */
public abstract class i extends A {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(u uVar) {
        super(uVar);
        D2.k.e(uVar, "database");
    }

    protected abstract void i(N.k kVar, Object obj);

    public final long[] j(Object[] objArr) {
        D2.k.e(objArr, "entities");
        N.k b3 = b();
        try {
            long[] jArr = new long[objArr.length];
            int length = objArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = i4 + 1;
                i(b3, objArr[i3]);
                jArr[i4] = b3.S();
                i3++;
                i4 = i5;
            }
            return jArr;
        } finally {
            h(b3);
        }
    }
}
