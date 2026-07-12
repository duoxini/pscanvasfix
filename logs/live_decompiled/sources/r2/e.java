package r2;

import D2.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends AbstractC0569a {

    /* renamed from: e, reason: collision with root package name */
    private final d f13274e;

    public e(d dVar) {
        k.e(dVar, "backing");
        this.f13274e = dVar;
    }

    @Override // q2.AbstractC0535e
    public int a() {
        return this.f13274e.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // r2.AbstractC0569a
    public boolean c(Map.Entry entry) {
        k.e(entry, "element");
        return this.f13274e.o(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f13274e.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        k.e(collection, "elements");
        return this.f13274e.n(collection);
    }

    @Override // r2.AbstractC0569a
    public boolean d(Map.Entry entry) {
        k.e(entry, "element");
        return this.f13274e.I(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry entry) {
        k.e(entry, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f13274e.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f13274e.s();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        this.f13274e.l();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        this.f13274e.l();
        return super.retainAll(collection);
    }
}
