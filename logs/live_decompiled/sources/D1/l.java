package d1;

import java.util.List;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class l extends g {

    /* renamed from: i, reason: collision with root package name */
    private final n1.d f11042i;

    public l(List list) {
        super(list);
        this.f11042i = new n1.d();
    }

    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public n1.d i(n1.c cVar, float f3) {
        Object obj;
        n1.d dVar;
        Object obj2 = cVar.f12574b;
        if (obj2 == null || (obj = cVar.f12575c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        n1.d dVar2 = (n1.d) obj2;
        n1.d dVar3 = (n1.d) obj;
        C0483b c0483b = this.f11012e;
        if (c0483b != null && (dVar = (n1.d) c0483b.b(cVar.f12579g, cVar.f12580h.floatValue(), dVar2, dVar3, f3, e(), f())) != null) {
            return dVar;
        }
        this.f11042i.d(AbstractC0464g.i(dVar2.b(), dVar3.b(), f3), AbstractC0464g.i(dVar2.c(), dVar3.c(), f3));
        return this.f11042i;
    }
}
