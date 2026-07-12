package d1;

import android.graphics.Path;
import c1.s;
import h1.C0385n;
import java.util.List;
import m1.AbstractC0464g;

/* loaded from: classes.dex */
public class m extends AbstractC0336a {

    /* renamed from: i, reason: collision with root package name */
    private final C0385n f11043i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f11044j;

    /* renamed from: k, reason: collision with root package name */
    private List f11045k;

    public m(List list) {
        super(list);
        this.f11043i = new C0385n();
        this.f11044j = new Path();
    }

    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Path i(n1.c cVar, float f3) {
        this.f11043i.c((C0385n) cVar.f12574b, (C0385n) cVar.f12575c, f3);
        C0385n c0385n = this.f11043i;
        List list = this.f11045k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c0385n = ((s) this.f11045k.get(size)).c(c0385n);
            }
        }
        AbstractC0464g.h(c0385n, this.f11044j);
        return this.f11044j;
    }

    public void q(List list) {
        this.f11045k = list;
    }
}
