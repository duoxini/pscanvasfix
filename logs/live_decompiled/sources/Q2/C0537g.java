package q2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: q2.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0537g extends AbstractC0534d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f13044h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Object[] f13045i = new Object[0];

    /* renamed from: e, reason: collision with root package name */
    private int f13046e;

    /* renamed from: f, reason: collision with root package name */
    private Object[] f13047f = f13045i;

    /* renamed from: g, reason: collision with root package name */
    private int f13048g;

    /* renamed from: q2.g$a */
    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    private final void c(int i3, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f13047f.length;
        while (i3 < length && it.hasNext()) {
            this.f13047f[i3] = it.next();
            i3++;
        }
        int i4 = this.f13046e;
        for (int i5 = 0; i5 < i4 && it.hasNext(); i5++) {
            this.f13047f[i5] = it.next();
        }
        this.f13048g = size() + collection.size();
    }

    private final void d(int i3) {
        Object[] objArr = new Object[i3];
        Object[] objArr2 = this.f13047f;
        AbstractC0538h.h(objArr2, objArr, 0, this.f13046e, objArr2.length);
        Object[] objArr3 = this.f13047f;
        int length = objArr3.length;
        int i4 = this.f13046e;
        AbstractC0538h.h(objArr3, objArr, length - i4, 0, i4);
        this.f13046e = 0;
        this.f13047f = objArr;
    }

    private final int e(int i3) {
        return i3 == 0 ? AbstractC0538h.v(this.f13047f) : i3 - 1;
    }

    private final void f(int i3) {
        if (i3 < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        Object[] objArr = this.f13047f;
        if (i3 <= objArr.length) {
            return;
        }
        if (objArr == f13045i) {
            this.f13047f = new Object[H2.d.b(i3, 10)];
        } else {
            d(AbstractC0532b.f13035e.d(objArr.length, i3));
        }
    }

    private final int g(int i3) {
        if (i3 == AbstractC0538h.v(this.f13047f)) {
            return 0;
        }
        return i3 + 1;
    }

    private final int h(int i3) {
        return i3 < 0 ? i3 + this.f13047f.length : i3;
    }

    private final int i(int i3) {
        Object[] objArr = this.f13047f;
        return i3 >= objArr.length ? i3 - objArr.length : i3;
    }

    @Override // q2.AbstractC0534d
    public int a() {
        return this.f13048g;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        D2.k.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        f(size() + collection.size());
        c(i(this.f13046e + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        f(size() + 1);
        int e3 = e(this.f13046e);
        this.f13046e = e3;
        this.f13047f[e3] = obj;
        this.f13048g = size() + 1;
    }

    public final void addLast(Object obj) {
        f(size() + 1);
        this.f13047f[i(this.f13046e + size())] = obj;
        this.f13048g = size() + 1;
    }

    @Override // q2.AbstractC0534d
    public Object b(int i3) {
        AbstractC0532b.f13035e.a(i3, size());
        if (i3 == AbstractC0544n.k(this)) {
            return removeLast();
        }
        if (i3 == 0) {
            return removeFirst();
        }
        int i4 = i(this.f13046e + i3);
        Object obj = this.f13047f[i4];
        if (i3 < (size() >> 1)) {
            int i5 = this.f13046e;
            if (i4 >= i5) {
                Object[] objArr = this.f13047f;
                AbstractC0538h.h(objArr, objArr, i5 + 1, i5, i4);
            } else {
                Object[] objArr2 = this.f13047f;
                AbstractC0538h.h(objArr2, objArr2, 1, 0, i4);
                Object[] objArr3 = this.f13047f;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i6 = this.f13046e;
                AbstractC0538h.h(objArr3, objArr3, i6 + 1, i6, objArr3.length - 1);
            }
            Object[] objArr4 = this.f13047f;
            int i7 = this.f13046e;
            objArr4[i7] = null;
            this.f13046e = g(i7);
        } else {
            int i8 = i(this.f13046e + AbstractC0544n.k(this));
            if (i4 <= i8) {
                Object[] objArr5 = this.f13047f;
                AbstractC0538h.h(objArr5, objArr5, i4, i4 + 1, i8 + 1);
            } else {
                Object[] objArr6 = this.f13047f;
                AbstractC0538h.h(objArr6, objArr6, i4, i4 + 1, objArr6.length);
                Object[] objArr7 = this.f13047f;
                objArr7[objArr7.length - 1] = objArr7[0];
                AbstractC0538h.h(objArr7, objArr7, 0, 1, i8 + 1);
            }
            this.f13047f[i8] = null;
        }
        this.f13048g = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int i3 = i(this.f13046e + size());
        int i4 = this.f13046e;
        if (i4 < i3) {
            AbstractC0541k.n(this.f13047f, null, i4, i3);
        } else if (!isEmpty()) {
            Object[] objArr = this.f13047f;
            AbstractC0541k.n(objArr, null, this.f13046e, objArr.length);
            AbstractC0541k.n(this.f13047f, null, 0, i3);
        }
        this.f13046e = 0;
        this.f13048g = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        AbstractC0532b.f13035e.a(i3, size());
        return this.f13047f[i(this.f13046e + i3)];
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i3;
        int i4 = i(this.f13046e + size());
        int i5 = this.f13046e;
        if (i5 < i4) {
            while (i5 < i4) {
                if (D2.k.a(obj, this.f13047f[i5])) {
                    i3 = this.f13046e;
                } else {
                    i5++;
                }
            }
            return -1;
        }
        if (i5 < i4) {
            return -1;
        }
        int length = this.f13047f.length;
        while (true) {
            if (i5 >= length) {
                for (int i6 = 0; i6 < i4; i6++) {
                    if (D2.k.a(obj, this.f13047f[i6])) {
                        i5 = i6 + this.f13047f.length;
                        i3 = this.f13046e;
                    }
                }
                return -1;
            }
            if (D2.k.a(obj, this.f13047f[i5])) {
                i3 = this.f13046e;
                break;
            }
            i5++;
        }
        return i5 - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Object j() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int v3;
        int i3;
        int i4 = i(this.f13046e + size());
        int i5 = this.f13046e;
        if (i5 < i4) {
            v3 = i4 - 1;
            if (i5 <= v3) {
                while (!D2.k.a(obj, this.f13047f[v3])) {
                    if (v3 != i5) {
                        v3--;
                    }
                }
                i3 = this.f13046e;
                return v3 - i3;
            }
            return -1;
        }
        if (i5 > i4) {
            int i6 = i4 - 1;
            while (true) {
                if (-1 >= i6) {
                    v3 = AbstractC0538h.v(this.f13047f);
                    int i7 = this.f13046e;
                    if (i7 <= v3) {
                        while (!D2.k.a(obj, this.f13047f[v3])) {
                            if (v3 != i7) {
                                v3--;
                            }
                        }
                        i3 = this.f13046e;
                    }
                } else {
                    if (D2.k.a(obj, this.f13047f[i6])) {
                        v3 = i6 + this.f13047f.length;
                        i3 = this.f13046e;
                        break;
                    }
                    i6--;
                }
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int i3;
        D2.k.e(collection, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f13047f.length != 0) {
            int i4 = i(this.f13046e + size());
            int i5 = this.f13046e;
            if (i5 < i4) {
                i3 = i5;
                while (i5 < i4) {
                    Object obj = this.f13047f[i5];
                    if (collection.contains(obj)) {
                        z3 = true;
                    } else {
                        this.f13047f[i3] = obj;
                        i3++;
                    }
                    i5++;
                }
                AbstractC0541k.n(this.f13047f, null, i3, i4);
            } else {
                int length = this.f13047f.length;
                boolean z4 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.f13047f;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (collection.contains(obj2)) {
                        z4 = true;
                    } else {
                        this.f13047f[i6] = obj2;
                        i6++;
                    }
                    i5++;
                }
                i3 = i(i6);
                for (int i7 = 0; i7 < i4; i7++) {
                    Object[] objArr2 = this.f13047f;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (collection.contains(obj3)) {
                        z4 = true;
                    } else {
                        this.f13047f[i3] = obj3;
                        i3 = g(i3);
                    }
                }
                z3 = z4;
            }
            if (z3) {
                this.f13048g = h(i3 - this.f13046e);
            }
        }
        return z3;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        Object[] objArr = this.f13047f;
        int i3 = this.f13046e;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f13046e = g(i3);
        this.f13048g = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        int i3 = i(this.f13046e + AbstractC0544n.k(this));
        Object[] objArr = this.f13047f;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f13048g = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int i3;
        D2.k.e(collection, "elements");
        boolean z3 = false;
        z3 = false;
        z3 = false;
        if (!isEmpty() && this.f13047f.length != 0) {
            int i4 = i(this.f13046e + size());
            int i5 = this.f13046e;
            if (i5 < i4) {
                i3 = i5;
                while (i5 < i4) {
                    Object obj = this.f13047f[i5];
                    if (collection.contains(obj)) {
                        this.f13047f[i3] = obj;
                        i3++;
                    } else {
                        z3 = true;
                    }
                    i5++;
                }
                AbstractC0541k.n(this.f13047f, null, i3, i4);
            } else {
                int length = this.f13047f.length;
                boolean z4 = false;
                int i6 = i5;
                while (i5 < length) {
                    Object[] objArr = this.f13047f;
                    Object obj2 = objArr[i5];
                    objArr[i5] = null;
                    if (collection.contains(obj2)) {
                        this.f13047f[i6] = obj2;
                        i6++;
                    } else {
                        z4 = true;
                    }
                    i5++;
                }
                i3 = i(i6);
                for (int i7 = 0; i7 < i4; i7++) {
                    Object[] objArr2 = this.f13047f;
                    Object obj3 = objArr2[i7];
                    objArr2[i7] = null;
                    if (collection.contains(obj3)) {
                        this.f13047f[i3] = obj3;
                        i3 = g(i3);
                    } else {
                        z4 = true;
                    }
                }
                z3 = z4;
            }
            if (z3) {
                this.f13048g = h(i3 - this.f13046e);
            }
        }
        return z3;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        AbstractC0532b.f13035e.a(i3, size());
        int i4 = i(this.f13046e + i3);
        Object[] objArr = this.f13047f;
        Object obj2 = objArr[i4];
        objArr[i4] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        D2.k.e(objArr, "array");
        if (objArr.length < size()) {
            objArr = AbstractC0539i.a(objArr, size());
        }
        int i3 = i(this.f13046e + size());
        int i4 = this.f13046e;
        if (i4 < i3) {
            AbstractC0541k.j(this.f13047f, objArr, 0, i4, i3, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.f13047f;
            AbstractC0538h.h(objArr2, objArr, 0, this.f13046e, objArr2.length);
            Object[] objArr3 = this.f13047f;
            AbstractC0538h.h(objArr3, objArr, objArr3.length - this.f13046e, 0, i3);
        }
        return AbstractC0544n.e(size(), objArr);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        AbstractC0532b.f13035e.b(i3, size());
        if (i3 == size()) {
            addLast(obj);
            return;
        }
        if (i3 == 0) {
            addFirst(obj);
            return;
        }
        f(size() + 1);
        int i4 = i(this.f13046e + i3);
        if (i3 < ((size() + 1) >> 1)) {
            int e3 = e(i4);
            int e4 = e(this.f13046e);
            int i5 = this.f13046e;
            if (e3 >= i5) {
                Object[] objArr = this.f13047f;
                objArr[e4] = objArr[i5];
                AbstractC0538h.h(objArr, objArr, i5, i5 + 1, e3 + 1);
            } else {
                Object[] objArr2 = this.f13047f;
                AbstractC0538h.h(objArr2, objArr2, i5 - 1, i5, objArr2.length);
                Object[] objArr3 = this.f13047f;
                objArr3[objArr3.length - 1] = objArr3[0];
                AbstractC0538h.h(objArr3, objArr3, 0, 1, e3 + 1);
            }
            this.f13047f[e3] = obj;
            this.f13046e = e4;
        } else {
            int i6 = i(this.f13046e + size());
            if (i4 < i6) {
                Object[] objArr4 = this.f13047f;
                AbstractC0538h.h(objArr4, objArr4, i4 + 1, i4, i6);
            } else {
                Object[] objArr5 = this.f13047f;
                AbstractC0538h.h(objArr5, objArr5, 1, 0, i6);
                Object[] objArr6 = this.f13047f;
                objArr6[0] = objArr6[objArr6.length - 1];
                AbstractC0538h.h(objArr6, objArr6, i4 + 1, i4, objArr6.length - 1);
            }
            this.f13047f[i4] = obj;
        }
        this.f13048g = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection collection) {
        D2.k.e(collection, "elements");
        AbstractC0532b.f13035e.b(i3, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i3 == size()) {
            return addAll(collection);
        }
        f(size() + collection.size());
        int i4 = i(this.f13046e + size());
        int i5 = i(this.f13046e + i3);
        int size = collection.size();
        if (i3 < ((size() + 1) >> 1)) {
            int i6 = this.f13046e;
            int i7 = i6 - size;
            if (i5 < i6) {
                Object[] objArr = this.f13047f;
                AbstractC0538h.h(objArr, objArr, i7, i6, objArr.length);
                if (size >= i5) {
                    Object[] objArr2 = this.f13047f;
                    AbstractC0538h.h(objArr2, objArr2, objArr2.length - size, 0, i5);
                } else {
                    Object[] objArr3 = this.f13047f;
                    AbstractC0538h.h(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f13047f;
                    AbstractC0538h.h(objArr4, objArr4, 0, size, i5);
                }
            } else if (i7 >= 0) {
                Object[] objArr5 = this.f13047f;
                AbstractC0538h.h(objArr5, objArr5, i7, i6, i5);
            } else {
                Object[] objArr6 = this.f13047f;
                i7 += objArr6.length;
                int i8 = i5 - i6;
                int length = objArr6.length - i7;
                if (length >= i8) {
                    AbstractC0538h.h(objArr6, objArr6, i7, i6, i5);
                } else {
                    AbstractC0538h.h(objArr6, objArr6, i7, i6, i6 + length);
                    Object[] objArr7 = this.f13047f;
                    AbstractC0538h.h(objArr7, objArr7, 0, this.f13046e + length, i5);
                }
            }
            this.f13046e = i7;
            c(h(i5 - size), collection);
        } else {
            int i9 = i5 + size;
            if (i5 < i4) {
                int i10 = size + i4;
                Object[] objArr8 = this.f13047f;
                if (i10 <= objArr8.length) {
                    AbstractC0538h.h(objArr8, objArr8, i9, i5, i4);
                } else if (i9 >= objArr8.length) {
                    AbstractC0538h.h(objArr8, objArr8, i9 - objArr8.length, i5, i4);
                } else {
                    int length2 = i4 - (i10 - objArr8.length);
                    AbstractC0538h.h(objArr8, objArr8, 0, length2, i4);
                    Object[] objArr9 = this.f13047f;
                    AbstractC0538h.h(objArr9, objArr9, i9, i5, length2);
                }
            } else {
                Object[] objArr10 = this.f13047f;
                AbstractC0538h.h(objArr10, objArr10, size, 0, i4);
                Object[] objArr11 = this.f13047f;
                if (i9 >= objArr11.length) {
                    AbstractC0538h.h(objArr11, objArr11, i9 - objArr11.length, i5, objArr11.length);
                } else {
                    AbstractC0538h.h(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f13047f;
                    AbstractC0538h.h(objArr12, objArr12, i9, i5, objArr12.length - size);
                }
            }
            c(i5, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
