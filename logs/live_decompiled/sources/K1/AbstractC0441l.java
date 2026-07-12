package k1;

import a1.C0221a;
import android.graphics.Rect;
import com.oplus.backup.sdk.common.utils.Constants;
import f1.C0356d;
import f1.C0357e;
import i1.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l1.c;
import m.C0454d;
import m1.AbstractC0462e;
import m1.AbstractC0465h;

/* renamed from: k1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0441l {

    /* renamed from: a, reason: collision with root package name */
    private static final c.a f12260a = c.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    static c.a f12261b = c.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c, reason: collision with root package name */
    private static final c.a f12262c = c.a.a("list");

    /* renamed from: d, reason: collision with root package name */
    private static final c.a f12263d = c.a.a("cm", "tm", "dr");

    public static C0221a a(l1.c cVar) {
        HashMap hashMap;
        ArrayList arrayList;
        l1.c cVar2 = cVar;
        float e3 = AbstractC0465h.e();
        C0454d c0454d = new C0454d();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        m.h hVar = new m.h();
        C0221a c0221a = new C0221a();
        cVar.c();
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        while (cVar.j()) {
            switch (cVar2.a0(f12260a)) {
                case 0:
                    i3 = cVar.q();
                    continue;
                case 1:
                    i4 = cVar.q();
                    continue;
                case 2:
                    f3 = (float) cVar.p();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = ((float) cVar.p()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f5 = (float) cVar.p();
                    break;
                case 5:
                    String[] split = cVar.G().split("\\.");
                    if (AbstractC0465h.k(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        break;
                    } else {
                        c0221a.a("EffectiveAnimation only supports bodymovin >= 4.4.0");
                        continue;
                    }
                case 6:
                    e(cVar2, c0221a, arrayList2, c0454d);
                    continue;
                case 7:
                    b(cVar2, c0221a, hashMap2, hashMap3);
                    continue;
                case 8:
                    d(cVar2, hashMap4);
                    continue;
                case Constants.MessagerConstants.METHOD_ID_PAUSE /* 9 */:
                    c(cVar2, c0221a, hVar);
                    continue;
                case Constants.MessagerConstants.METHOD_ID_CONTINUE /* 10 */:
                    f(cVar2, arrayList3);
                    continue;
                default:
                    cVar.b0();
                    cVar.c0();
                    continue;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            cVar2 = cVar;
        }
        c0221a.s(new Rect(0, 0, (int) (i3 * e3), (int) (i4 * e3)), f3, f4, f5, arrayList2, c0454d, hashMap2, hashMap3, hVar, hashMap4, arrayList3);
        return c0221a;
    }

    private static void b(l1.c cVar, C0221a c0221a, Map map, Map map2) {
        cVar.b();
        while (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            C0454d c0454d = new C0454d();
            cVar.c();
            int i3 = 0;
            int i4 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (cVar.j()) {
                int a02 = cVar.a0(f12261b);
                if (a02 == 0) {
                    str = cVar.G();
                } else if (a02 == 1) {
                    cVar.b();
                    while (cVar.j()) {
                        i1.e b3 = w.b(cVar, c0221a);
                        c0454d.i(b3.d(), b3);
                        arrayList.add(b3);
                    }
                    cVar.g();
                } else if (a02 == 2) {
                    i3 = cVar.q();
                } else if (a02 == 3) {
                    i4 = cVar.q();
                } else if (a02 == 4) {
                    str2 = cVar.G();
                } else if (a02 != 5) {
                    cVar.b0();
                    cVar.c0();
                } else {
                    str3 = cVar.G();
                }
            }
            cVar.i();
            if (str2 != null) {
                a1.r rVar = new a1.r(i3, i4, str, str2, str3);
                map2.put(rVar.d(), rVar);
            } else {
                map.put(str, arrayList);
            }
        }
        cVar.g();
    }

    private static void c(l1.c cVar, C0221a c0221a, m.h hVar) {
        cVar.b();
        while (cVar.j()) {
            C0357e a3 = AbstractC0443n.a(cVar, c0221a);
            hVar.i(a3.hashCode(), a3);
        }
        cVar.g();
    }

    private static void d(l1.c cVar, Map map) {
        cVar.c();
        while (cVar.j()) {
            if (cVar.a0(f12262c) != 0) {
                cVar.b0();
                cVar.c0();
            } else {
                cVar.b();
                while (cVar.j()) {
                    C0356d a3 = o.a(cVar);
                    map.put(a3.b(), a3);
                }
                cVar.g();
            }
        }
        cVar.i();
    }

    private static void e(l1.c cVar, C0221a c0221a, List list, C0454d c0454d) {
        cVar.b();
        int i3 = 0;
        while (cVar.j()) {
            i1.e b3 = w.b(cVar, c0221a);
            if (b3.f() == e.a.IMAGE) {
                i3++;
            }
            list.add(b3);
            c0454d.i(b3.d(), b3);
            if (i3 > 4) {
                AbstractC0462e.c("You have " + i3 + " images. EffectiveAnimation should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        cVar.g();
    }

    private static void f(l1.c cVar, List list) {
        cVar.b();
        while (cVar.j()) {
            cVar.c();
            float f3 = 0.0f;
            String str = null;
            float f4 = 0.0f;
            while (cVar.j()) {
                int a02 = cVar.a0(f12263d);
                if (a02 == 0) {
                    str = cVar.G();
                } else if (a02 == 1) {
                    f3 = (float) cVar.p();
                } else if (a02 != 2) {
                    cVar.b0();
                    cVar.c0();
                } else {
                    f4 = (float) cVar.p();
                }
            }
            cVar.i();
            list.add(new f1.h(str, f3, f4));
        }
        cVar.g();
    }
}
