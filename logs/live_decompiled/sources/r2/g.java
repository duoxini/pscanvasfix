package r2;

import D2.k;
import java.util.Collection;
import java.util.Iterator;
import q2.AbstractC0533c;

/* loaded from: classes.dex */
public final class g extends AbstractC0533c implements Collection {

    /* renamed from: e, reason: collision with root package name */
    private final d f13276e;

    public g(d dVar) {
        k.e(dVar, "backing");
        this.f13276e = dVar;
    }

    @Override // q2.AbstractC0533c
    public int a() {
        return this.f13276e.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f13276e.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f13276e.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f13276e.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f13276e.O();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f13276e.M(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        this.f13276e.l();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        this.f13276e.l();
        return super.retainAll(collection);
    }
}
