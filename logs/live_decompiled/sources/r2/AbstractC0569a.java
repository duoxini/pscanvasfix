package r2;

import D2.k;
import java.util.Map;
import q2.AbstractC0535e;

/* renamed from: r2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0569a extends AbstractC0535e {
    public final boolean b(Map.Entry entry) {
        k.e(entry, "element");
        return c(entry);
    }

    public abstract boolean c(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return b((Map.Entry) obj);
        }
        return false;
    }

    public abstract /* bridge */ boolean d(Map.Entry entry);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof Map.Entry) {
            return d((Map.Entry) obj);
        }
        return false;
    }
}
