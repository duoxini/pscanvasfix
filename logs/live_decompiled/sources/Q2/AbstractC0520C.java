package q2;

import java.util.Iterator;

/* renamed from: q2.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0520C implements Iterator {
    public abstract int a();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
