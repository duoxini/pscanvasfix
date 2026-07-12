package J2;

import C2.l;
import D2.k;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class i implements b {

    /* renamed from: a, reason: collision with root package name */
    private final b f1156a;

    /* renamed from: b, reason: collision with root package name */
    private final l f1157b;

    public static final class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator f1158a;

        a() {
            this.f1158a = i.this.f1156a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1158a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return i.this.f1157b.f(this.f1158a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(b bVar, l lVar) {
        k.e(bVar, "sequence");
        k.e(lVar, "transformer");
        this.f1156a = bVar;
        this.f1157b = lVar;
    }

    @Override // J2.b
    public Iterator iterator() {
        return new a();
    }
}
