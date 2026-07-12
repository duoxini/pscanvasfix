package J2;

import D2.k;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference f1154a;

    public a(b bVar) {
        k.e(bVar, "sequence");
        this.f1154a = new AtomicReference(bVar);
    }

    @Override // J2.b
    public Iterator iterator() {
        b bVar = (b) this.f1154a.getAndSet(null);
        if (bVar != null) {
            return bVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
