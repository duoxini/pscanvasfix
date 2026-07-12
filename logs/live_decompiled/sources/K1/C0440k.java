package k1;

import a1.C0221a;
import g1.C0365a;
import g1.C0366b;
import l1.c;

/* renamed from: k1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0440k {

    /* renamed from: f, reason: collision with root package name */
    private static final c.a f12253f = c.a.a("ef");

    /* renamed from: g, reason: collision with root package name */
    private static final c.a f12254g = c.a.a("nm", "v");

    /* renamed from: a, reason: collision with root package name */
    private C0365a f12255a;

    /* renamed from: b, reason: collision with root package name */
    private C0366b f12256b;

    /* renamed from: c, reason: collision with root package name */
    private C0366b f12257c;

    /* renamed from: d, reason: collision with root package name */
    private C0366b f12258d;

    /* renamed from: e, reason: collision with root package name */
    private C0366b f12259e;

    private void a(l1.c cVar, C0221a c0221a) {
        cVar.c();
        String str = "";
        while (cVar.j()) {
            int a02 = cVar.a0(f12254g);
            if (a02 == 0) {
                str = cVar.G();
            } else if (a02 == 1) {
                str.hashCode();
                switch (str) {
                    case "Distance":
                        this.f12258d = AbstractC0433d.e(cVar, c0221a);
                        break;
                    case "Opacity":
                        this.f12256b = AbstractC0433d.f(cVar, c0221a, false);
                        break;
                    case "Direction":
                        this.f12257c = AbstractC0433d.f(cVar, c0221a, false);
                        break;
                    case "Shadow Color":
                        this.f12255a = AbstractC0433d.c(cVar, c0221a);
                        break;
                    case "Softness":
                        this.f12259e = AbstractC0433d.e(cVar, c0221a);
                        break;
                    default:
                        cVar.c0();
                        break;
                }
            } else {
                cVar.b0();
                cVar.c0();
            }
        }
        cVar.i();
    }

    C0439j b(l1.c cVar, C0221a c0221a) {
        C0366b c0366b;
        C0366b c0366b2;
        C0366b c0366b3;
        C0366b c0366b4;
        while (cVar.j()) {
            if (cVar.a0(f12253f) != 0) {
                cVar.b0();
                cVar.c0();
            } else {
                cVar.b();
                while (cVar.j()) {
                    a(cVar, c0221a);
                }
                cVar.g();
            }
        }
        C0365a c0365a = this.f12255a;
        if (c0365a == null || (c0366b = this.f12256b) == null || (c0366b2 = this.f12257c) == null || (c0366b3 = this.f12258d) == null || (c0366b4 = this.f12259e) == null) {
            return null;
        }
        return new C0439j(c0365a, c0366b, c0366b2, c0366b3, c0366b4);
    }
}
