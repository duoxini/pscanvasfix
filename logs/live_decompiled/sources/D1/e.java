package d1;

import h1.C0375d;
import java.util.List;

/* loaded from: classes.dex */
public class e extends g {

    /* renamed from: i, reason: collision with root package name */
    private final C0375d f11031i;

    public e(List list) {
        super(list);
        C0375d c0375d = (C0375d) ((n1.c) list.get(0)).f12574b;
        int e3 = c0375d != null ? c0375d.e() : 0;
        this.f11031i = new C0375d(new float[e3], new int[e3]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0375d i(n1.c cVar, float f3) {
        this.f11031i.f((C0375d) cVar.f12574b, (C0375d) cVar.f12575c, f3);
        return this.f11031i;
    }
}
