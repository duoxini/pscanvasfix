package q2;

import androidx.preference.Preference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* renamed from: q2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0532b extends AbstractC0531a implements List {

    /* renamed from: e, reason: collision with root package name */
    public static final a f13035e = new a(null);

    /* renamed from: q2.b$a */
    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final void a(int i3, int i4) {
            if (i3 < 0 || i3 >= i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void b(int i3, int i4) {
            if (i3 < 0 || i3 > i4) {
                throw new IndexOutOfBoundsException("index: " + i3 + ", size: " + i4);
            }
        }

        public final void c(int i3, int i4, int i5) {
            if (i3 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("fromIndex: " + i3 + ", toIndex: " + i4 + ", size: " + i5);
            }
            if (i3 <= i4) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i3 + " > toIndex: " + i4);
        }

        public final int d(int i3, int i4) {
            int i5 = i3 + (i3 >> 1);
            if (i5 - i4 < 0) {
                i5 = i4;
            }
            if (i5 - 2147483639 > 0) {
                return i4 > 2147483639 ? Preference.DEFAULT_ORDER : 2147483639;
            }
            return i5;
        }

        public final boolean e(Collection collection, Collection collection2) {
            D2.k.e(collection, "c");
            D2.k.e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!D2.k.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(Collection collection) {
            D2.k.e(collection, "c");
            Iterator it = collection.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i3 = (i3 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i3;
        }

        private a() {
        }
    }

    /* renamed from: q2.b$b, reason: collision with other inner class name */
    private class C0144b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f13036a;

        public C0144b() {
        }

        protected final int a() {
            return this.f13036a;
        }

        protected final void b(int i3) {
            this.f13036a = i3;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13036a < AbstractC0532b.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC0532b abstractC0532b = AbstractC0532b.this;
            int i3 = this.f13036a;
            this.f13036a = i3 + 1;
            return abstractC0532b.get(i3);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: q2.b$c */
    private class c extends C0144b implements ListIterator {
        public c(int i3) {
            super();
            AbstractC0532b.f13035e.b(i3, AbstractC0532b.this.size());
            b(i3);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC0532b abstractC0532b = AbstractC0532b.this;
            b(a() - 1);
            return abstractC0532b.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* renamed from: q2.b$d */
    private static final class d extends AbstractC0532b implements RandomAccess {

        /* renamed from: f, reason: collision with root package name */
        private final AbstractC0532b f13039f;

        /* renamed from: g, reason: collision with root package name */
        private final int f13040g;

        /* renamed from: h, reason: collision with root package name */
        private int f13041h;

        public d(AbstractC0532b abstractC0532b, int i3, int i4) {
            D2.k.e(abstractC0532b, "list");
            this.f13039f = abstractC0532b;
            this.f13040g = i3;
            AbstractC0532b.f13035e.c(i3, i4, abstractC0532b.size());
            this.f13041h = i4 - i3;
        }

        @Override // q2.AbstractC0531a
        public int a() {
            return this.f13041h;
        }

        @Override // q2.AbstractC0532b, java.util.List
        public Object get(int i3) {
            AbstractC0532b.f13035e.a(i3, this.f13041h);
            return this.f13039f.get(this.f13040g + i3);
        }
    }

    protected AbstractC0532b() {
    }

    @Override // java.util.List
    public void add(int i3, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f13035e.e(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i3);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f13035e.f(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (D2.k.a(it.next(), obj)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new C0144b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (D2.k.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public Object remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i3, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i3, int i4) {
        return new d(this, i3, i4);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i3) {
        return new c(i3);
    }
}
