package k1;

import a1.C0221a;
import java.util.ArrayList;
import java.util.List;
import l1.c;

/* loaded from: classes.dex */
abstract class v {

    /* renamed from: a, reason: collision with root package name */
    static c.a f12281a = c.a.a("k");

    static List a(l1.c cVar, C0221a c0221a, float f3, N n3, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (cVar.N() == c.b.STRING) {
            c0221a.a("Effective doesn't support expressions.");
            return arrayList;
        }
        cVar.c();
        while (cVar.j()) {
            if (cVar.a0(f12281a) != 0) {
                cVar.c0();
            } else if (cVar.N() == c.b.BEGIN_ARRAY) {
                cVar.b();
                if (cVar.N() == c.b.NUMBER) {
                    arrayList.add(u.c(cVar, c0221a, f3, n3, false, z3));
                } else {
                    while (cVar.j()) {
                        arrayList.add(u.c(cVar, c0221a, f3, n3, true, z3));
                    }
                }
                cVar.g();
            } else {
                arrayList.add(u.c(cVar, c0221a, f3, n3, false, z3));
            }
        }
        cVar.i();
        b(arrayList);
        return arrayList;
    }

    public static void b(List list) {
        int i3;
        Object obj;
        int size = list.size();
        int i4 = 0;
        while (true) {
            i3 = size - 1;
            if (i4 >= i3) {
                break;
            }
            n1.c cVar = (n1.c) list.get(i4);
            i4++;
            n1.c cVar2 = (n1.c) list.get(i4);
            cVar.f12580h = Float.valueOf(cVar2.f12579g);
            if (cVar.f12575c == null && (obj = cVar2.f12574b) != null) {
                cVar.f12575c = obj;
                if (cVar instanceof d1.i) {
                    ((d1.i) cVar).j();
                }
            }
        }
        n1.c cVar3 = (n1.c) list.get(i3);
        if ((cVar3.f12574b == null || cVar3.f12575c == null) && list.size() > 1) {
            list.remove(cVar3);
        }
    }
}
