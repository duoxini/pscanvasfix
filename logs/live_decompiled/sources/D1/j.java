package d1;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import n1.C0483b;

/* loaded from: classes.dex */
public class j extends g {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f11037i;

    /* renamed from: j, reason: collision with root package name */
    private final float[] f11038j;

    /* renamed from: k, reason: collision with root package name */
    private final PathMeasure f11039k;

    /* renamed from: l, reason: collision with root package name */
    private i f11040l;

    public j(List list) {
        super(list);
        this.f11037i = new PointF();
        this.f11038j = new float[2];
        this.f11039k = new PathMeasure();
    }

    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF i(n1.c cVar, float f3) {
        PointF pointF;
        i iVar = (i) cVar;
        Path k3 = iVar.k();
        if (k3 == null) {
            return (PointF) cVar.f12574b;
        }
        C0483b c0483b = this.f11012e;
        if (c0483b != null && (pointF = (PointF) c0483b.b(iVar.f12579g, iVar.f12580h.floatValue(), (PointF) iVar.f12574b, (PointF) iVar.f12575c, e(), f3, f())) != null) {
            return pointF;
        }
        if (this.f11040l != iVar) {
            this.f11039k.setPath(k3, false);
            this.f11040l = iVar;
        }
        PathMeasure pathMeasure = this.f11039k;
        pathMeasure.getPosTan(f3 * pathMeasure.getLength(), this.f11038j, null);
        PointF pointF2 = this.f11037i;
        float[] fArr = this.f11038j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f11037i;
    }
}
