package d1;

import a1.C0221a;
import android.graphics.Path;
import android.graphics.PointF;
import m1.AbstractC0465h;

/* loaded from: classes.dex */
public class i extends n1.c {

    /* renamed from: q, reason: collision with root package name */
    private Path f11035q;

    /* renamed from: r, reason: collision with root package name */
    private final n1.c f11036r;

    public i(C0221a c0221a, n1.c cVar) {
        super(c0221a, (PointF) cVar.f12574b, (PointF) cVar.f12575c, cVar.f12576d, cVar.f12577e, cVar.f12578f, cVar.f12579g, cVar.f12580h);
        this.f11036r = cVar;
        j();
    }

    public void j() {
        Object obj;
        Object obj2;
        Object obj3 = this.f12575c;
        boolean z3 = (obj3 == null || (obj2 = this.f12574b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) ? false : true;
        Object obj4 = this.f12574b;
        if (obj4 == null || (obj = this.f12575c) == null || z3) {
            return;
        }
        n1.c cVar = this.f11036r;
        this.f11035q = AbstractC0465h.d((PointF) obj4, (PointF) obj, cVar.f12587o, cVar.f12588p);
    }

    Path k() {
        return this.f11035q;
    }
}
