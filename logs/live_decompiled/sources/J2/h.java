package J2;

import C2.l;
import D2.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.AbstractC0544n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class h extends g {
    public static b c(b bVar, l lVar) {
        k.e(bVar, "<this>");
        k.e(lVar, "transform");
        return new i(bVar, lVar);
    }

    public static List d(b bVar) {
        k.e(bVar, "<this>");
        Iterator it = bVar.iterator();
        if (!it.hasNext()) {
            return AbstractC0544n.j();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC0544n.d(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
