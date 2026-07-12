package r2;

import D2.k;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import q2.AbstractC0535e;

/* loaded from: classes.dex */
public final class h extends AbstractC0535e implements Set, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private static final a f13277f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final h f13278g = new h(d.f13253r.e());

    /* renamed from: e, reason: collision with root package name */
    private final d f13279e;

    private static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    public h(d dVar) {
        k.e(dVar, "backing");
        this.f13279e = dVar;
    }

    @Override // q2.AbstractC0535e
    public int a() {
        return this.f13279e.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        return this.f13279e.i(obj) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        this.f13279e.l();
        return super.addAll(collection);
    }

    public final Set b() {
        this.f13279e.k();
        return size() > 0 ? this : f13278g;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f13279e.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f13279e.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f13279e.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f13279e.C();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f13279e.K(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        this.f13279e.l();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        this.f13279e.l();
        return super.retainAll(collection);
    }

    public h() {
        this(new d());
    }
}
