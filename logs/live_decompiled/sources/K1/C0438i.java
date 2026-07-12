package k1;

import android.graphics.PointF;
import com.oplus.backup.sdk.common.utils.Constants;
import f1.C0354b;
import l1.c;

/* renamed from: k1.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0438i implements N {

    /* renamed from: a, reason: collision with root package name */
    public static final C0438i f12246a = new C0438i();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12247b = c.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private C0438i() {
    }

    @Override // k1.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0354b a(l1.c cVar, float f3) {
        C0354b.a aVar = C0354b.a.CENTER;
        cVar.c();
        C0354b.a aVar2 = aVar;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = true;
        while (cVar.j()) {
            switch (cVar.a0(f12247b)) {
                case 0:
                    str = cVar.G();
                    break;
                case 1:
                    str2 = cVar.G();
                    break;
                case 2:
                    f4 = (float) cVar.p();
                    break;
                case 3:
                    int q3 = cVar.q();
                    aVar2 = C0354b.a.CENTER;
                    if (q3 <= aVar2.ordinal() && q3 >= 0) {
                        aVar2 = C0354b.a.values()[q3];
                        break;
                    }
                    break;
                case 4:
                    i3 = cVar.q();
                    break;
                case 5:
                    f5 = (float) cVar.p();
                    break;
                case 6:
                    f6 = (float) cVar.p();
                    break;
                case 7:
                    i4 = t.d(cVar);
                    break;
                case 8:
                    i5 = t.d(cVar);
                    break;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    f7 = (float) cVar.p();
                    break;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    z3 = cVar.l();
                    break;
                case Constants.MessagerConstants.METHOD_ID_CANCEL /* 11 */:
                    cVar.b();
                    PointF pointF3 = new PointF(((float) cVar.p()) * f3, ((float) cVar.p()) * f3);
                    cVar.g();
                    pointF = pointF3;
                    break;
                case Constants.MessagerConstants.METHOD_ID_DESTROY /* 12 */:
                    cVar.b();
                    PointF pointF4 = new PointF(((float) cVar.p()) * f3, ((float) cVar.p()) * f3);
                    cVar.g();
                    pointF2 = pointF4;
                    break;
                default:
                    cVar.b0();
                    cVar.c0();
                    break;
            }
        }
        cVar.i();
        return new C0354b(str, str2, f4, aVar2, i3, f5, f6, i4, i5, f7, z3, pointF, pointF2);
    }
}
