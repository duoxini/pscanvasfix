package k1;

import l1.c;

/* renamed from: k1.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0428G implements N {

    /* renamed from: a, reason: collision with root package name */
    public static final C0428G f12227a = new C0428G();

    private C0428G() {
    }

    @Override // k1.N
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n1.d a(l1.c cVar, float f3) {
        boolean z3 = cVar.N() == c.b.BEGIN_ARRAY;
        if (z3) {
            cVar.b();
        }
        float p3 = (float) cVar.p();
        float p4 = (float) cVar.p();
        while (cVar.j()) {
            cVar.c0();
        }
        if (z3) {
            cVar.g();
        }
        return new n1.d((p3 / 100.0f) * f3, (p4 / 100.0f) * f3);
    }
}
