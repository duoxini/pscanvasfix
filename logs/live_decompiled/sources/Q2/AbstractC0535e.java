package q2;

import java.util.AbstractSet;
import java.util.Set;

/* renamed from: q2.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0535e extends AbstractSet implements Set {
    protected AbstractC0535e() {
    }

    public abstract int a();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return a();
    }
}
