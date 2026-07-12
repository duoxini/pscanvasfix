package r2;

import D2.k;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import q2.AbstractC0532b;
import q2.AbstractC0534d;
import q2.AbstractC0538h;
import q2.AbstractC0544n;

/* renamed from: r2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0570b extends AbstractC0534d implements List, RandomAccess, Serializable {

    /* renamed from: k, reason: collision with root package name */
    private static final a f13241k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    private static final C0570b f13242l;

    /* renamed from: e, reason: collision with root package name */
    private Object[] f13243e;

    /* renamed from: f, reason: collision with root package name */
    private int f13244f;

    /* renamed from: g, reason: collision with root package name */
    private int f13245g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f13246h;

    /* renamed from: i, reason: collision with root package name */
    private final C0570b f13247i;

    /* renamed from: j, reason: collision with root package name */
    private final C0570b f13248j;

    /* renamed from: r2.b$a */
    private static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: r2.b$b, reason: collision with other inner class name */
    private static final class C0146b implements ListIterator {

        /* renamed from: a, reason: collision with root package name */
        private final C0570b f13249a;

        /* renamed from: b, reason: collision with root package name */
        private int f13250b;

        /* renamed from: c, reason: collision with root package name */
        private int f13251c;

        /* renamed from: d, reason: collision with root package name */
        private int f13252d;

        public C0146b(C0570b c0570b, int i3) {
            k.e(c0570b, "list");
            this.f13249a = c0570b;
            this.f13250b = i3;
            this.f13251c = -1;
            this.f13252d = ((AbstractList) c0570b).modCount;
        }

        private final void a() {
            if (((AbstractList) this.f13249a).modCount != this.f13252d) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            a();
            C0570b c0570b = this.f13249a;
            int i3 = this.f13250b;
            this.f13250b = i3 + 1;
            c0570b.add(i3, obj);
            this.f13251c = -1;
            this.f13252d = ((AbstractList) this.f13249a).modCount;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f13250b < this.f13249a.f13245g;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f13250b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            a();
            if (this.f13250b >= this.f13249a.f13245g) {
                throw new NoSuchElementException();
            }
            int i3 = this.f13250b;
            this.f13250b = i3 + 1;
            this.f13251c = i3;
            return this.f13249a.f13243e[this.f13249a.f13244f + this.f13251c];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f13250b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            a();
            int i3 = this.f13250b;
            if (i3 <= 0) {
                throw new NoSuchElementException();
            }
            int i4 = i3 - 1;
            this.f13250b = i4;
            this.f13251c = i4;
            return this.f13249a.f13243e[this.f13249a.f13244f + this.f13251c];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f13250b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            a();
            int i3 = this.f13251c;
            if (i3 == -1) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
            }
            this.f13249a.remove(i3);
            this.f13250b = this.f13251c;
            this.f13251c = -1;
            this.f13252d = ((AbstractList) this.f13249a).modCount;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            a();
            int i3 = this.f13251c;
            if (i3 == -1) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
            }
            this.f13249a.set(i3, obj);
        }
    }

    static {
        C0570b c0570b = new C0570b(0);
        c0570b.f13246h = true;
        f13242l = c0570b;
    }

    private C0570b(Object[] objArr, int i3, int i4, boolean z3, C0570b c0570b, C0570b c0570b2) {
        this.f13243e = objArr;
        this.f13244f = i3;
        this.f13245g = i4;
        this.f13246h = z3;
        this.f13247i = c0570b;
        this.f13248j = c0570b2;
        if (c0570b != null) {
            ((AbstractList) this).modCount = ((AbstractList) c0570b).modCount;
        }
    }

    private final void g(int i3, Collection collection, int i4) {
        q();
        C0570b c0570b = this.f13247i;
        if (c0570b != null) {
            c0570b.g(i3, collection, i4);
            this.f13243e = this.f13247i.f13243e;
            this.f13245g += i4;
        } else {
            o(i3, i4);
            Iterator it = collection.iterator();
            for (int i5 = 0; i5 < i4; i5++) {
                this.f13243e[i3 + i5] = it.next();
            }
        }
    }

    private final void h(int i3, Object obj) {
        q();
        C0570b c0570b = this.f13247i;
        if (c0570b == null) {
            o(i3, 1);
            this.f13243e[i3] = obj;
        } else {
            c0570b.h(i3, obj);
            this.f13243e = this.f13247i.f13243e;
            this.f13245g++;
        }
    }

    private final void j() {
        C0570b c0570b = this.f13248j;
        if (c0570b != null && ((AbstractList) c0570b).modCount != ((AbstractList) this).modCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void k() {
        if (p()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean l(List list) {
        boolean h3;
        h3 = c.h(this.f13243e, this.f13244f, this.f13245g, list);
        return h3;
    }

    private final void m(int i3) {
        if (i3 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f13243e;
        if (i3 > objArr.length) {
            this.f13243e = c.e(this.f13243e, AbstractC0532b.f13035e.d(objArr.length, i3));
        }
    }

    private final void n(int i3) {
        m(this.f13245g + i3);
    }

    private final void o(int i3, int i4) {
        n(i4);
        Object[] objArr = this.f13243e;
        AbstractC0538h.h(objArr, objArr, i3 + i4, i3, this.f13244f + this.f13245g);
        this.f13245g += i4;
    }

    private final boolean p() {
        C0570b c0570b;
        return this.f13246h || ((c0570b = this.f13248j) != null && c0570b.f13246h);
    }

    private final void q() {
        ((AbstractList) this).modCount++;
    }

    private final Object r(int i3) {
        q();
        C0570b c0570b = this.f13247i;
        if (c0570b != null) {
            this.f13245g--;
            return c0570b.r(i3);
        }
        Object[] objArr = this.f13243e;
        Object obj = objArr[i3];
        AbstractC0538h.h(objArr, objArr, i3, i3 + 1, this.f13244f + this.f13245g);
        c.f(this.f13243e, (this.f13244f + this.f13245g) - 1);
        this.f13245g--;
        return obj;
    }

    private final void s(int i3, int i4) {
        if (i4 > 0) {
            q();
        }
        C0570b c0570b = this.f13247i;
        if (c0570b != null) {
            c0570b.s(i3, i4);
        } else {
            Object[] objArr = this.f13243e;
            AbstractC0538h.h(objArr, objArr, i3, i3 + i4, this.f13245g);
            Object[] objArr2 = this.f13243e;
            int i5 = this.f13245g;
            c.g(objArr2, i5 - i4, i5);
        }
        this.f13245g -= i4;
    }

    private final int t(int i3, int i4, Collection collection, boolean z3) {
        int i5;
        C0570b c0570b = this.f13247i;
        if (c0570b != null) {
            i5 = c0570b.t(i3, i4, collection, z3);
        } else {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                int i8 = i3 + i6;
                if (collection.contains(this.f13243e[i8]) == z3) {
                    Object[] objArr = this.f13243e;
                    i6++;
                    objArr[i7 + i3] = objArr[i8];
                    i7++;
                } else {
                    i6++;
                }
            }
            int i9 = i4 - i7;
            Object[] objArr2 = this.f13243e;
            AbstractC0538h.h(objArr2, objArr2, i3 + i7, i4 + i3, this.f13245g);
            Object[] objArr3 = this.f13243e;
            int i10 = this.f13245g;
            c.g(objArr3, i10 - i9, i10);
            i5 = i9;
        }
        if (i5 > 0) {
            q();
        }
        this.f13245g -= i5;
        return i5;
    }

    @Override // q2.AbstractC0534d
    public int a() {
        j();
        return this.f13245g;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        k();
        j();
        h(this.f13244f + this.f13245g, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        k.e(collection, "elements");
        k();
        j();
        int size = collection.size();
        g(this.f13244f + this.f13245g, collection, size);
        return size > 0;
    }

    @Override // q2.AbstractC0534d
    public Object b(int i3) {
        k();
        j();
        AbstractC0532b.f13035e.a(i3, this.f13245g);
        return r(this.f13244f + i3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        k();
        j();
        s(this.f13244f, this.f13245g);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        j();
        return obj == this || ((obj instanceof List) && l((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        j();
        AbstractC0532b.f13035e.a(i3, this.f13245g);
        return this.f13243e[this.f13244f + i3];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3;
        j();
        i3 = c.i(this.f13243e, this.f13244f, this.f13245g);
        return i3;
    }

    public final List i() {
        if (this.f13247i != null) {
            throw new IllegalStateException();
        }
        k();
        this.f13246h = true;
        return this.f13245g > 0 ? this : f13242l;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        j();
        for (int i3 = 0; i3 < this.f13245g; i3++) {
            if (k.a(this.f13243e[this.f13244f + i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        j();
        return this.f13245g == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        j();
        for (int i3 = this.f13245g - 1; i3 >= 0; i3--) {
            if (k.a(this.f13243e[this.f13244f + i3], obj)) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        k();
        j();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        k.e(collection, "elements");
        k();
        j();
        return t(this.f13244f, this.f13245g, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        k.e(collection, "elements");
        k();
        j();
        return t(this.f13244f, this.f13245g, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        k();
        j();
        AbstractC0532b.f13035e.a(i3, this.f13245g);
        Object[] objArr = this.f13243e;
        int i4 = this.f13244f;
        Object obj2 = objArr[i4 + i3];
        objArr[i4 + i3] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List subList(int i3, int i4) {
        AbstractC0532b.f13035e.c(i3, i4, this.f13245g);
        Object[] objArr = this.f13243e;
        int i5 = this.f13244f + i3;
        int i6 = i4 - i3;
        boolean z3 = this.f13246h;
        C0570b c0570b = this.f13248j;
        return new C0570b(objArr, i5, i6, z3, this, c0570b == null ? this : c0570b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        k.e(objArr, "destination");
        j();
        int length = objArr.length;
        int i3 = this.f13245g;
        if (length >= i3) {
            Object[] objArr2 = this.f13243e;
            int i4 = this.f13244f;
            AbstractC0538h.h(objArr2, objArr, 0, i4, i3 + i4);
            return AbstractC0544n.e(this.f13245g, objArr);
        }
        Object[] objArr3 = this.f13243e;
        int i5 = this.f13244f;
        Object[] copyOfRange = Arrays.copyOfRange(objArr3, i5, i3 + i5, objArr.getClass());
        k.d(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String j3;
        j();
        j3 = c.j(this.f13243e, this.f13244f, this.f13245g, this);
        return j3;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        j();
        AbstractC0532b.f13035e.b(i3, this.f13245g);
        return new C0146b(this, i3);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        k();
        j();
        AbstractC0532b.f13035e.b(i3, this.f13245g);
        h(this.f13244f + i3, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection collection) {
        k.e(collection, "elements");
        k();
        j();
        AbstractC0532b.f13035e.b(i3, this.f13245g);
        int size = collection.size();
        g(this.f13244f + i3, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        j();
        Object[] objArr = this.f13243e;
        int i3 = this.f13244f;
        return AbstractC0538h.l(objArr, i3, this.f13245g + i3);
    }

    public C0570b() {
        this(10);
    }

    public C0570b(int i3) {
        this(c.d(i3), 0, 0, false, null, null);
    }
}
