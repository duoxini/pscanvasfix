package D2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class a implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f313a;

    /* renamed from: b, reason: collision with root package name */
    private int f314b;

    public a(Object[] objArr) {
        k.e(objArr, "array");
        this.f313a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f314b < this.f313a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f313a;
            int i3 = this.f314b;
            this.f314b = i3 + 1;
            return objArr[i3];
        } catch (ArrayIndexOutOfBoundsException e3) {
            this.f314b--;
            throw new NoSuchElementException(e3.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
