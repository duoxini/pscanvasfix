package d1;

import f1.C0354b;
import java.util.List;
import n1.C0482a;
import n1.C0483b;

/* loaded from: classes.dex */
public class o extends g {

    class a extends C0483b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C0482a f11052d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C0483b f11053e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ C0354b f11054f;

        a(C0482a c0482a, C0483b c0483b, C0354b c0354b) {
            this.f11052d = c0482a;
            this.f11053e = c0483b;
            this.f11054f = c0354b;
        }

        @Override // n1.C0483b
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public C0354b a(C0482a c0482a) {
            this.f11052d.h(c0482a.f(), c0482a.a(), ((C0354b) c0482a.g()).f11553a, ((C0354b) c0482a.b()).f11553a, c0482a.d(), c0482a.c(), c0482a.e());
            String str = (String) this.f11053e.a(this.f11052d);
            C0354b c0354b = (C0354b) (c0482a.c() == 1.0f ? c0482a.b() : c0482a.g());
            this.f11054f.a(str, c0354b.f11554b, c0354b.f11555c, c0354b.f11556d, c0354b.f11557e, c0354b.f11558f, c0354b.f11559g, c0354b.f11560h, c0354b.f11561i, c0354b.f11562j, c0354b.f11563k, c0354b.f11564l, c0354b.f11565m);
            return this.f11054f;
        }
    }

    public o(List list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // d1.AbstractC0336a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0354b i(n1.c cVar, float f3) {
        Object obj;
        C0483b c0483b = this.f11012e;
        if (c0483b == null) {
            return (f3 != 1.0f || (obj = cVar.f12575c) == null) ? (C0354b) cVar.f12574b : (C0354b) obj;
        }
        float f4 = cVar.f12579g;
        Float f5 = cVar.f12580h;
        float floatValue = f5 == null ? Float.MAX_VALUE : f5.floatValue();
        Object obj2 = cVar.f12574b;
        C0354b c0354b = (C0354b) obj2;
        Object obj3 = cVar.f12575c;
        return (C0354b) c0483b.b(f4, floatValue, c0354b, obj3 == null ? (C0354b) obj2 : (C0354b) obj3, f3, d(), f());
    }

    public void q(C0483b c0483b) {
        super.n(new a(new C0482a(), c0483b, new C0354b()));
    }
}
