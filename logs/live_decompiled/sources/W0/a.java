package W0;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a extends b implements Iterable {

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList f2586e = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof a) && ((a) obj).f2586e.equals(this.f2586e));
    }

    public void h(b bVar) {
        if (bVar == null) {
            bVar = d.f2587e;
        }
        this.f2586e.add(bVar);
    }

    public int hashCode() {
        return this.f2586e.hashCode();
    }

    public b i(int i3) {
        return (b) this.f2586e.get(i3);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f2586e.iterator();
    }

    public int size() {
        return this.f2586e.size();
    }
}
