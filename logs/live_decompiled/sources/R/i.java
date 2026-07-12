package r;

import java.util.ArrayList;
import q.e;

/* loaded from: classes.dex */
public abstract class i {
    public static o a(q.e eVar, int i3, ArrayList arrayList, o oVar) {
        int o12;
        int i4 = i3 == 0 ? eVar.f12875I0 : eVar.f12877J0;
        if (i4 != -1 && (oVar == null || i4 != oVar.f13119b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                o oVar2 = (o) arrayList.get(i5);
                if (oVar2.c() == i4) {
                    if (oVar != null) {
                        oVar.g(i3, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i5++;
                }
            }
        } else if (i4 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((eVar instanceof q.i) && (o12 = ((q.i) eVar).o1(i3)) != -1) {
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = (o) arrayList.get(i6);
                    if (oVar3.c() == o12) {
                        oVar = oVar3;
                        break;
                    }
                    i6++;
                }
            }
            if (oVar == null) {
                oVar = new o(i3);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(eVar)) {
            if (eVar instanceof q.g) {
                q.g gVar = (q.g) eVar;
                gVar.n1().b(gVar.o1() == 0 ? 1 : 0, arrayList, oVar);
            }
            if (i3 == 0) {
                eVar.f12875I0 = oVar.c();
                eVar.f12882O.b(i3, arrayList, oVar);
                eVar.f12884Q.b(i3, arrayList, oVar);
            } else {
                eVar.f12877J0 = oVar.c();
                eVar.f12883P.b(i3, arrayList, oVar);
                eVar.f12886S.b(i3, arrayList, oVar);
                eVar.f12885R.b(i3, arrayList, oVar);
            }
            eVar.f12889V.b(i3, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList arrayList, int i3) {
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            o oVar = (o) arrayList.get(i4);
            if (i3 == oVar.f13119b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:207:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x038d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0388  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(q.f r16, r.C0558b.InterfaceC0145b r17) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.i.c(q.f, r.b$b):boolean");
    }

    public static boolean d(e.b bVar, e.b bVar2, e.b bVar3, e.b bVar4) {
        e.b bVar5;
        e.b bVar6;
        e.b bVar7 = e.b.FIXED;
        return (bVar3 == bVar7 || bVar3 == (bVar6 = e.b.WRAP_CONTENT) || (bVar3 == e.b.MATCH_PARENT && bVar != bVar6)) || (bVar4 == bVar7 || bVar4 == (bVar5 = e.b.WRAP_CONTENT) || (bVar4 == e.b.MATCH_PARENT && bVar2 != bVar5));
    }
}
