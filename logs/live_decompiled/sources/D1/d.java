package d1;

import java.util.List;
import m1.AbstractC0464g;
import n1.C0483b;

/* loaded from: classes.dex */
public class d extends g {
    public d(List list) {
        super(list);
    }

    public float p() {
        return q(b(), d());
    }

    float q(n1.c cVar, float f3) {
        Float f4;
        if (cVar.f12574b == null || cVar.f12575c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        C0483b c0483b = this.f11012e;
        return (c0483b == null || (f4 = (Float) c0483b.b(cVar.f12579g, cVar.f12580h.floatValue(), (Float) cVar.f12574b, (Float) cVar.f12575c, f3, e(), f())) == null) ? AbstractC0464g.i(cVar.g(), cVar.d(), f3) : f4.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d1.AbstractC0336a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float i(n1.c cVar, float f3) {
        return Float.valueOf(q(cVar, f3));
    }
}
