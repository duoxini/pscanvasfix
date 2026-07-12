package q2;

import java.util.AbstractList;
import java.util.List;

/* renamed from: q2.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0534d extends AbstractList implements List {
    protected AbstractC0534d() {
    }

    public abstract int a();

    public abstract Object b(int i3);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i3) {
        return b(i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
