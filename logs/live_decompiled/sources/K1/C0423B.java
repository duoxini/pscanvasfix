package k1;

import android.graphics.PointF;
import l1.c;

/* renamed from: k1.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0423B implements N {

    /* renamed from: a, reason: collision with root package name */
    public static final C0423B f12222a = new C0423B();

    private C0423B() {
    }

    @Override // k1.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(l1.c cVar, float f3) {
        c.b N3 = cVar.N();
        if (N3 != c.b.BEGIN_ARRAY && N3 != c.b.BEGIN_OBJECT) {
            if (N3 == c.b.NUMBER) {
                PointF pointF = new PointF(((float) cVar.p()) * f3, ((float) cVar.p()) * f3);
                while (cVar.j()) {
                    cVar.c0();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + N3);
        }
        return t.e(cVar, f3);
    }
}
