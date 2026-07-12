package k1;

import android.graphics.PointF;
import f1.C0353a;
import h1.C0385n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l1.c;
import m1.AbstractC0464g;

/* renamed from: k1.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0429H implements N {

    /* renamed from: a, reason: collision with root package name */
    public static final C0429H f12228a = new C0429H();

    /* renamed from: b, reason: collision with root package name */
    private static final c.a f12229b = c.a.a("c", "v", "i", "o");

    private C0429H() {
    }

    @Override // k1.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0385n a(l1.c cVar, float f3) {
        if (cVar.N() == c.b.BEGIN_ARRAY) {
            cVar.b();
        }
        cVar.c();
        List list = null;
        List list2 = null;
        List list3 = null;
        boolean z3 = false;
        while (cVar.j()) {
            int a02 = cVar.a0(f12229b);
            if (a02 == 0) {
                z3 = cVar.l();
            } else if (a02 == 1) {
                list = t.f(cVar, f3);
            } else if (a02 == 2) {
                list2 = t.f(cVar, f3);
            } else if (a02 != 3) {
                cVar.b0();
                cVar.c0();
            } else {
                list3 = t.f(cVar, f3);
            }
        }
        cVar.i();
        if (cVar.N() == c.b.END_ARRAY) {
            cVar.g();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (list.isEmpty()) {
            return new C0385n(new PointF(), false, Collections.emptyList());
        }
        int size = list.size();
        PointF pointF = (PointF) list.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i3 = 1; i3 < size; i3++) {
            PointF pointF2 = (PointF) list.get(i3);
            int i4 = i3 - 1;
            arrayList.add(new C0353a(AbstractC0464g.a((PointF) list.get(i4), (PointF) list3.get(i4)), AbstractC0464g.a(pointF2, (PointF) list2.get(i3)), pointF2));
        }
        if (z3) {
            PointF pointF3 = (PointF) list.get(0);
            int i5 = size - 1;
            arrayList.add(new C0353a(AbstractC0464g.a((PointF) list.get(i5), (PointF) list3.get(i5)), AbstractC0464g.a(pointF3, (PointF) list2.get(0)), pointF3));
        }
        return new C0385n(pointF, z3, arrayList);
    }
}
