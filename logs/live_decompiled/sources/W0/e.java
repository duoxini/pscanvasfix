package W0;

import java.util.Set;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: e, reason: collision with root package name */
    private final X0.c f2588e = new X0.c(false);

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof e) && ((e) obj).f2588e.equals(this.f2588e));
    }

    public void h(String str, b bVar) {
        X0.c cVar = this.f2588e;
        if (bVar == null) {
            bVar = d.f2587e;
        }
        cVar.put(str, bVar);
    }

    public int hashCode() {
        return this.f2588e.hashCode();
    }

    public Set i() {
        return this.f2588e.entrySet();
    }
}
