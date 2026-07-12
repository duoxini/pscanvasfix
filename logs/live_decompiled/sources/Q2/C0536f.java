package q2;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: q2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0536f implements Collection {

    /* renamed from: e, reason: collision with root package name */
    private final Object[] f13042e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f13043f;

    public C0536f(Object[] objArr, boolean z3) {
        D2.k.e(objArr, "values");
        this.f13042e = objArr;
        this.f13043f = z3;
    }

    public int a() {
        return this.f13042e.length;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return AbstractC0538h.q(this.f13042e, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        D2.k.e(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f13042e.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return D2.b.a(this.f13042e);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        D2.k.e(objArr, "array");
        return D2.f.b(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC0545o.b(this.f13042e, this.f13043f);
    }
}
