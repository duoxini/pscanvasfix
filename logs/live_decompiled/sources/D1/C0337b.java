package d1;

import java.util.List;
import m1.AbstractC0460c;
import m1.AbstractC0464g;
import n1.C0483b;

/* renamed from: d1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0337b extends g {
    public C0337b(List list) {
        super(list);
    }

    public int p() {
        return q(b(), d());
    }

    public int q(n1.c cVar, float f3) {
        Integer num;
        if (cVar.f12574b == null || cVar.f12575c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0483b c0483b = this.f11012e;
        return (c0483b == null || (num = (Integer) c0483b.b(cVar.f12579g, cVar.f12580h.floatValue(), (Integer) cVar.f12574b, (Integer) cVar.f12575c, f3, e(), f())) == null) ? AbstractC0460c.c(AbstractC0464g.b(f3, 0.0f, 1.0f), ((Integer) cVar.f12574b).intValue(), ((Integer) cVar.f12575c).intValue()) : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d1.AbstractC0336a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer i(n1.c cVar, float f3) {
        return Integer.valueOf(q(cVar, f3));
    }
}
