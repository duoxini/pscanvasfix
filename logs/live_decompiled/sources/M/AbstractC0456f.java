package m;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: m.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0456f {

    /* renamed from: a, reason: collision with root package name */
    b f12356a;

    /* renamed from: b, reason: collision with root package name */
    c f12357b;

    /* renamed from: c, reason: collision with root package name */
    e f12358c;

    /* renamed from: m.f$a */
    final class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        final int f12359a;

        /* renamed from: b, reason: collision with root package name */
        int f12360b;

        /* renamed from: c, reason: collision with root package name */
        int f12361c;

        /* renamed from: d, reason: collision with root package name */
        boolean f12362d = false;

        a(int i3) {
            this.f12359a = i3;
            this.f12360b = AbstractC0456f.this.d();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12361c < this.f12360b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object b3 = AbstractC0456f.this.b(this.f12361c, this.f12359a);
            this.f12361c++;
            this.f12362d = true;
            return b3;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f12362d) {
                throw new IllegalStateException();
            }
            int i3 = this.f12361c - 1;
            this.f12361c = i3;
            this.f12360b--;
            this.f12362d = false;
            AbstractC0456f.this.h(i3);
        }
    }

    /* renamed from: m.f$b */
    final class b implements Set {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            int d3 = AbstractC0456f.this.d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                AbstractC0456f.this.g(entry.getKey(), entry.getValue());
            }
            return d3 != AbstractC0456f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0456f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int e3 = AbstractC0456f.this.e(entry.getKey());
            if (e3 < 0) {
                return false;
            }
            return AbstractC0453c.c(AbstractC0456f.this.b(e3, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0456f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i3 = 0;
            for (int d3 = AbstractC0456f.this.d() - 1; d3 >= 0; d3--) {
                Object b3 = AbstractC0456f.this.b(d3, 0);
                Object b4 = AbstractC0456f.this.b(d3, 1);
                i3 += (b3 == null ? 0 : b3.hashCode()) ^ (b4 == null ? 0 : b4.hashCode());
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0456f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC0456f.this.new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0456f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: m.f$c */
    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0456f.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0456f.this.e(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return AbstractC0456f.j(AbstractC0456f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0456f.k(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i3 = 0;
            for (int d3 = AbstractC0456f.this.d() - 1; d3 >= 0; d3--) {
                Object b3 = AbstractC0456f.this.b(d3, 0);
                i3 += b3 == null ? 0 : b3.hashCode();
            }
            return i3;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0456f.this.d() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC0456f.this.new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int e3 = AbstractC0456f.this.e(obj);
            if (e3 < 0) {
                return false;
            }
            AbstractC0456f.this.h(e3);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return AbstractC0456f.o(AbstractC0456f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return AbstractC0456f.p(AbstractC0456f.this.c(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0456f.this.d();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0456f.this.q(0);
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC0456f.this.r(objArr, 0);
        }
    }

    /* renamed from: m.f$d */
    final class d implements Iterator, Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        int f12366a;

        /* renamed from: c, reason: collision with root package name */
        boolean f12368c = false;

        /* renamed from: b, reason: collision with root package name */
        int f12367b = -1;

        d() {
            this.f12366a = AbstractC0456f.this.d() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f12367b++;
            this.f12368c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f12368c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC0453c.c(entry.getKey(), AbstractC0456f.this.b(this.f12367b, 0)) && AbstractC0453c.c(entry.getValue(), AbstractC0456f.this.b(this.f12367b, 1));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f12368c) {
                return AbstractC0456f.this.b(this.f12367b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f12368c) {
                return AbstractC0456f.this.b(this.f12367b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12367b < this.f12366a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f12368c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object b3 = AbstractC0456f.this.b(this.f12367b, 0);
            Object b4 = AbstractC0456f.this.b(this.f12367b, 1);
            return (b3 == null ? 0 : b3.hashCode()) ^ (b4 != null ? b4.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f12368c) {
                throw new IllegalStateException();
            }
            AbstractC0456f.this.h(this.f12367b);
            this.f12367b--;
            this.f12366a--;
            this.f12368c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f12368c) {
                return AbstractC0456f.this.i(this.f12367b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: m.f$e */
    final class e implements Collection {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0456f.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0456f.this.f(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0456f.this.d() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return AbstractC0456f.this.new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int f3 = AbstractC0456f.this.f(obj);
            if (f3 < 0) {
                return false;
            }
            AbstractC0456f.this.h(f3);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int d3 = AbstractC0456f.this.d();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < d3) {
                if (collection.contains(AbstractC0456f.this.b(i3, 1))) {
                    AbstractC0456f.this.h(i3);
                    i3--;
                    d3--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int d3 = AbstractC0456f.this.d();
            int i3 = 0;
            boolean z3 = false;
            while (i3 < d3) {
                if (!collection.contains(AbstractC0456f.this.b(i3, 1))) {
                    AbstractC0456f.this.h(i3);
                    i3--;
                    d3--;
                    z3 = true;
                }
                i3++;
            }
            return z3;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0456f.this.d();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0456f.this.q(1);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return AbstractC0456f.this.r(objArr, 1);
        }
    }

    AbstractC0456f() {
    }

    public static boolean j(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static boolean o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract void a();

    protected abstract Object b(int i3, int i4);

    protected abstract Map c();

    protected abstract int d();

    protected abstract int e(Object obj);

    protected abstract int f(Object obj);

    protected abstract void g(Object obj, Object obj2);

    protected abstract void h(int i3);

    protected abstract Object i(int i3, Object obj);

    public Set l() {
        if (this.f12356a == null) {
            this.f12356a = new b();
        }
        return this.f12356a;
    }

    public Set m() {
        if (this.f12357b == null) {
            this.f12357b = new c();
        }
        return this.f12357b;
    }

    public Collection n() {
        if (this.f12358c == null) {
            this.f12358c = new e();
        }
        return this.f12358c;
    }

    public Object[] q(int i3) {
        int d3 = d();
        Object[] objArr = new Object[d3];
        for (int i4 = 0; i4 < d3; i4++) {
            objArr[i4] = b(i4, i3);
        }
        return objArr;
    }

    public Object[] r(Object[] objArr, int i3) {
        int d3 = d();
        if (objArr.length < d3) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), d3);
        }
        for (int i4 = 0; i4 < d3; i4++) {
            objArr[i4] = b(i4, i3);
        }
        if (objArr.length > d3) {
            objArr[d3] = null;
        }
        return objArr;
    }
}
