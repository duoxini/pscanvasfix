package androidx.lifecycle;

import L2.AbstractC0175g;
import L2.O;
import L2.j0;
import androidx.lifecycle.AbstractC0272h;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends AbstractC0273i implements l {

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0272h f5726e;

    /* renamed from: f, reason: collision with root package name */
    private final t2.g f5727f;

    static final class a extends v2.k implements C2.p {

        /* renamed from: i, reason: collision with root package name */
        int f5728i;

        /* renamed from: j, reason: collision with root package name */
        private /* synthetic */ Object f5729j;

        a(InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            a aVar = LifecycleCoroutineScopeImpl.this.new a(interfaceC0593d);
            aVar.f5729j = obj;
            return aVar;
        }

        @Override // C2.p
        public final Object invoke(L2.D d3, InterfaceC0593d interfaceC0593d) {
            return ((a) create(d3, interfaceC0593d)).invokeSuspend(p2.q.f12810a);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            AbstractC0603b.c();
            if (this.f5728i != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p2.l.b(obj);
            L2.D d3 = (L2.D) this.f5729j;
            if (LifecycleCoroutineScopeImpl.this.b().b().compareTo(AbstractC0272h.c.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.b().a(LifecycleCoroutineScopeImpl.this);
            } else {
                j0.b(d3.h(), null, 1, null);
            }
            return p2.q.f12810a;
        }
    }

    public LifecycleCoroutineScopeImpl(AbstractC0272h abstractC0272h, t2.g gVar) {
        D2.k.e(abstractC0272h, "lifecycle");
        D2.k.e(gVar, "coroutineContext");
        this.f5726e = abstractC0272h;
        this.f5727f = gVar;
        if (b().b() == AbstractC0272h.c.DESTROYED) {
            j0.b(h(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.l
    public void a(o oVar, AbstractC0272h.b bVar) {
        D2.k.e(oVar, "source");
        D2.k.e(bVar, "event");
        if (b().b().compareTo(AbstractC0272h.c.DESTROYED) <= 0) {
            b().c(this);
            j0.b(h(), null, 1, null);
        }
    }

    public AbstractC0272h b() {
        return this.f5726e;
    }

    public final void c() {
        AbstractC0175g.b(this, O.c().f0(), null, new a(null), 2, null);
    }

    @Override // L2.D
    public t2.g h() {
        return this.f5727f;
    }
}
