package d1;

import android.graphics.PointF;
import d1.AbstractC0336a;
import java.util.Collections;
import n1.C0483b;

/* loaded from: classes.dex */
public class n extends AbstractC0336a {

    /* renamed from: i, reason: collision with root package name */
    private final PointF f11046i;

    /* renamed from: j, reason: collision with root package name */
    private final PointF f11047j;

    /* renamed from: k, reason: collision with root package name */
    private final AbstractC0336a f11048k;

    /* renamed from: l, reason: collision with root package name */
    private final AbstractC0336a f11049l;

    /* renamed from: m, reason: collision with root package name */
    protected C0483b f11050m;

    /* renamed from: n, reason: collision with root package name */
    protected C0483b f11051n;

    public n(AbstractC0336a abstractC0336a, AbstractC0336a abstractC0336a2) {
        super(Collections.emptyList());
        this.f11046i = new PointF();
        this.f11047j = new PointF();
        this.f11048k = abstractC0336a;
        this.f11049l = abstractC0336a2;
        m(f());
    }

    @Override // d1.AbstractC0336a
    public void m(float f3) {
        this.f11048k.m(f3);
        this.f11049l.m(f3);
        this.f11046i.set(((Float) this.f11048k.h()).floatValue(), ((Float) this.f11049l.h()).floatValue());
        for (int i3 = 0; i3 < this.f11008a.size(); i3++) {
            ((AbstractC0336a.b) this.f11008a.get(i3)).e();
        }
    }

    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d1.AbstractC0336a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public PointF i(n1.c cVar, float f3) {
        Float f4;
        n1.c b3;
        n1.c b4;
        Float f5 = null;
        if (this.f11050m == null || (b4 = this.f11048k.b()) == null) {
            f4 = null;
        } else {
            float d3 = this.f11048k.d();
            Float f6 = b4.f12580h;
            C0483b c0483b = this.f11050m;
            float f7 = b4.f12579g;
            f4 = (Float) c0483b.b(f7, f6 == null ? f7 : f6.floatValue(), (Float) b4.f12574b, (Float) b4.f12575c, f3, f3, d3);
        }
        if (this.f11051n != null && (b3 = this.f11049l.b()) != null) {
            float d4 = this.f11049l.d();
            Float f8 = b3.f12580h;
            C0483b c0483b2 = this.f11051n;
            float f9 = b3.f12579g;
            f5 = (Float) c0483b2.b(f9, f8 == null ? f9 : f8.floatValue(), (Float) b3.f12574b, (Float) b3.f12575c, f3, f3, d4);
        }
        if (f4 == null) {
            this.f11047j.set(this.f11046i.x, 0.0f);
        } else {
            this.f11047j.set(f4.floatValue(), 0.0f);
        }
        if (f5 == null) {
            PointF pointF = this.f11047j;
            pointF.set(pointF.x, this.f11046i.y);
        } else {
            PointF pointF2 = this.f11047j;
            pointF2.set(pointF2.x, f5.floatValue());
        }
        return this.f11047j;
    }

    public void r(C0483b c0483b) {
        C0483b c0483b2 = this.f11050m;
        if (c0483b2 != null) {
            c0483b2.c(null);
        }
        this.f11050m = c0483b;
        if (c0483b != null) {
            c0483b.c(this);
        }
    }

    public void s(C0483b c0483b) {
        C0483b c0483b2 = this.f11051n;
        if (c0483b2 != null) {
            c0483b2.c(null);
        }
        this.f11051n = c0483b;
        if (c0483b != null) {
            c0483b.c(this);
        }
    }
}
