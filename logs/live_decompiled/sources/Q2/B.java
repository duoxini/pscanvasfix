package Q2;

/* loaded from: classes.dex */
public abstract class B {
    public static Object a(Object obj) {
        return obj;
    }

    public static final A b(Object obj) {
        if (obj == AbstractC0196c.f1980a) {
            throw new IllegalStateException("Does not contain segment");
        }
        D2.k.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (A) obj;
    }

    public static final boolean c(Object obj) {
        return obj == AbstractC0196c.f1980a;
    }
}
