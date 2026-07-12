package androidx.lifecycle;

import L2.InterfaceC0178j;
import androidx.lifecycle.AbstractC0272h;
import p2.C0511k;

/* loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements l {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AbstractC0272h.c f5789e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractC0272h f5790f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ InterfaceC0178j f5791g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ C2.a f5792h;

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        Object b3;
        D2.k.e(oVar, "source");
        D2.k.e(bVar, "event");
        if (bVar != AbstractC0272h.b.d(this.f5789e)) {
            if (bVar == AbstractC0272h.b.ON_DESTROY) {
                this.f5790f.c(this);
                InterfaceC0178j interfaceC0178j = this.f5791g;
                C0511k.a aVar = C0511k.f12803f;
                interfaceC0178j.resumeWith(C0511k.b(p2.l.a(new C0274j())));
                return;
            }
            return;
        }
        this.f5790f.c(this);
        InterfaceC0178j interfaceC0178j2 = this.f5791g;
        C2.a aVar2 = this.f5792h;
        try {
            C0511k.a aVar3 = C0511k.f12803f;
            b3 = C0511k.b(aVar2.invoke());
        } catch (Throwable th) {
            C0511k.a aVar4 = C0511k.f12803f;
            b3 = C0511k.b(p2.l.a(th));
        }
        interfaceC0178j2.resumeWith(b3);
    }
}
