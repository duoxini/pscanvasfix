package Q2;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2000a = new D("CONDITION_FALSE");

    public static final Object a() {
        return f2000a;
    }

    public static final o b(Object obj) {
        o oVar;
        x xVar = obj instanceof x ? (x) obj : null;
        if (xVar != null && (oVar = xVar.f2021a) != null) {
            return oVar;
        }
        D2.k.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (o) obj;
    }
}
