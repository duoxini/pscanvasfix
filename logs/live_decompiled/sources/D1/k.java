package d1;

import android.graphics.PointF;
import java.util.List;
import n1.C0483b;

/* loaded from: classes.dex */
public class k extends g {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f11041i;

    public k(List list) {
        super(list);
        this.f11041i = new PointF();
    }

    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(n1.c cVar, float f3) {
        return j(cVar, f3, f3, f3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // d1.AbstractC0336a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF j(n1.c cVar, float f3, float f4, float f5) {
        Object obj;
        PointF pointF;
        Object obj2 = cVar.f12574b;
        if (obj2 == null || (obj = cVar.f12575c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) obj2;
        PointF pointF3 = (PointF) obj;
        C0483b c0483b = this.f11012e;
        if (c0483b != null && (pointF = (PointF) c0483b.b(cVar.f12579g, cVar.f12580h.floatValue(), pointF2, pointF3, f3, e(), f())) != null) {
            return pointF;
        }
        PointF pointF4 = this.f11041i;
        float f6 = pointF2.x;
        float f7 = f6 + (f4 * (pointF3.x - f6));
        float f8 = pointF2.y;
        pointF4.set(f7, f8 + (f5 * (pointF3.y - f8)));
        return this.f11041i;
    }
}
