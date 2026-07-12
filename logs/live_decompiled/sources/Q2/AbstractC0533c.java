package q2;

import java.util.AbstractCollection;
import java.util.Collection;

/* renamed from: q2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0533c extends AbstractCollection implements Collection {
    protected AbstractC0533c() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }
}
