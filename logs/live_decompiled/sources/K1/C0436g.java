package k1;

import android.graphics.Color;
import l1.c;

/* renamed from: k1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0436g implements N {

    /* renamed from: a, reason: collision with root package name */
    public static final C0436g f12244a = new C0436g();

    private C0436g() {
    }

    @Override // k1.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(l1.c cVar, float f3) {
        boolean z3 = cVar.N() == c.b.BEGIN_ARRAY;
        if (z3) {
            cVar.b();
        }
        double p3 = cVar.p();
        double p4 = cVar.p();
        double p5 = cVar.p();
        double p6 = cVar.N() == c.b.NUMBER ? cVar.p() : 1.0d;
        if (z3) {
            cVar.g();
        }
        if (p3 <= 1.0d && p4 <= 1.0d && p5 <= 1.0d) {
            p3 *= 255.0d;
            p4 *= 255.0d;
            p5 *= 255.0d;
            if (p6 <= 1.0d) {
                p6 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) p6, (int) p3, (int) p4, (int) p5));
    }
}
