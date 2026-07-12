package k1;

import f1.C0356d;
import l1.c;

/* loaded from: classes.dex */
abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12267a = c.a.a("fFamily", "fName", "fStyle", "ascent");

    static C0356d a(l1.c cVar) {
        cVar.c();
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        String str3 = null;
        while (cVar.j()) {
            int a02 = cVar.a0(f12267a);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                str3 = cVar.G();
            } else if (a02 == 2) {
                str2 = cVar.G();
            } else if (a02 != 3) {
                cVar.b0();
                cVar.c0();
            } else {
                f3 = (float) cVar.p();
            }
        }
        cVar.i();
        return new C0356d(str, str3, str2, f3);
    }
}
