package q2;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: q2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0531a implements Collection {

    /* renamed from: q2.a$a, reason: collision with other inner class name */
    static final class C0143a extends D2.l implements C2.l {
        C0143a() {
            super(1);
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence f(Object obj) {
            return obj == AbstractC0531a.this ? "(this Collection)" : String.valueOf(obj);
        }
    }

    protected AbstractC0531a() {
    }

    public abstract int a();

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

    @Override // java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (D2.k.a(it.next(), obj)) {
                return true;
            }
        }
        return false;
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
        return size() == 0;
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
    public Object[] toArray() {
        return D2.f.a(this);
    }

    public String toString() {
        return AbstractC0544n.v(this, ", ", "[", "]", 0, null, new C0143a(), 24, null);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        D2.k.e(objArr, "array");
        return D2.f.b(this, objArr);
    }
}
