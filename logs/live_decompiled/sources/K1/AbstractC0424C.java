package k1;

import a1.C0221a;
import com.customer.feedback.sdk.model.RequestData;
import com.oplus.backup.sdk.common.utils.Constants;
import g1.C0366b;
import h1.C0381j;
import l1.c;

/* renamed from: k1.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0424C {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12223a = c.a.a("nm", "sy", "pt", "p", "r", "or", RequestData.TYPE_OS, "ir", "is", "hd", "d");

    static C0381j a(l1.c cVar, C0221a c0221a, int i3) {
        boolean z3 = false;
        boolean z4 = i3 == 3;
        String str = null;
        C0381j.a aVar = null;
        C0366b c0366b = null;
        g1.m mVar = null;
        C0366b c0366b2 = null;
        C0366b c0366b3 = null;
        C0366b c0366b4 = null;
        C0366b c0366b5 = null;
        C0366b c0366b6 = null;
        while (cVar.j()) {
            switch (cVar.a0(f12223a)) {
                case 0:
                    str = cVar.G();
                    break;
                case 1:
                    aVar = C0381j.a.a(cVar.q());
                    break;
                case 2:
                    c0366b = AbstractC0433d.f(cVar, c0221a, false);
                    break;
                case 3:
                    mVar = AbstractC0430a.b(cVar, c0221a);
                    break;
                case 4:
                    c0366b2 = AbstractC0433d.f(cVar, c0221a, false);
                    break;
                case 5:
                    c0366b4 = AbstractC0433d.e(cVar, c0221a);
                    break;
                case 6:
                    c0366b6 = AbstractC0433d.f(cVar, c0221a, false);
                    break;
                case 7:
                    c0366b3 = AbstractC0433d.e(cVar, c0221a);
                    break;
                case 8:
                    c0366b5 = AbstractC0433d.f(cVar, c0221a, false);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    z3 = cVar.l();
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    if (cVar.q() != 3) {
                        z4 = false;
                        break;
                    } else {
                        z4 = true;
                        break;
                    }
                default:
                    cVar.b0();
                    cVar.c0();
                    break;
            }
        }
        return new C0381j(str, aVar, c0366b, mVar, c0366b2, c0366b3, c0366b4, c0366b5, c0366b6, z3, z4);
    }
}
