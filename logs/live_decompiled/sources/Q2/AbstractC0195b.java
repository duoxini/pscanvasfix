package Q2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: Q2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0195b extends w {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f1979a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0195b.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC0194a.f1978a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1979a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = AbstractC0194a.f1978a;
        return obj2 != obj3 ? obj2 : atomicReferenceFieldUpdater.compareAndSet(this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    @Override // Q2.w
    public final Object a(Object obj) {
        Object obj2 = f1979a.get(this);
        if (obj2 == AbstractC0194a.f1978a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract Object d(Object obj);
}
