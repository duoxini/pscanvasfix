package androidx.lifecycle;

import L2.AbstractC0174f;
import L2.O;
import L2.o0;
import androidx.lifecycle.AbstractC0272h;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends v2.k implements C2.p {

    /* renamed from: i, reason: collision with root package name */
    int f5753i;

    /* renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f5754j;

    /* renamed from: k, reason: collision with root package name */
    final /* synthetic */ AbstractC0272h f5755k;

    /* renamed from: l, reason: collision with root package name */
    final /* synthetic */ AbstractC0272h.c f5756l;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ C2.p f5757m;

    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    static final class AnonymousClass1 extends v2.k implements C2.p {

        /* renamed from: i, reason: collision with root package name */
        Object f5758i;

        /* renamed from: j, reason: collision with root package name */
        Object f5759j;

        /* renamed from: k, reason: collision with root package name */
        Object f5760k;

        /* renamed from: l, reason: collision with root package name */
        Object f5761l;

        /* renamed from: m, reason: collision with root package name */
        Object f5762m;

        /* renamed from: n, reason: collision with root package name */
        Object f5763n;

        /* renamed from: o, reason: collision with root package name */
        int f5764o;

        /* renamed from: p, reason: collision with root package name */
        final /* synthetic */ AbstractC0272h f5765p;

        /* renamed from: q, reason: collision with root package name */
        final /* synthetic */ AbstractC0272h.c f5766q;

        /* renamed from: r, reason: collision with root package name */
        final /* synthetic */ L2.D f5767r;

        /* renamed from: s, reason: collision with root package name */
        final /* synthetic */ C2.p f5768s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AbstractC0272h abstractC0272h, AbstractC0272h.c cVar, L2.D d3, C2.p pVar, InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
            this.f5765p = abstractC0272h;
            this.f5766q = cVar;
            this.f5767r = d3;
            this.f5768s = pVar;
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            return new AnonymousClass1(this.f5765p, this.f5766q, this.f5767r, this.f5768s, interfaceC0593d);
        }

        @Override // C2.p
        public final Object invoke(L2.D d3, InterfaceC0593d interfaceC0593d) {
            return ((AnonymousClass1) create(d3, interfaceC0593d)).invokeSuspend(p2.q.f12810a);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00d1  */
        @Override // v2.AbstractC0610a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                Method dump skipped, instructions count: 215
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RepeatOnLifecycleKt$repeatOnLifecycle$3(AbstractC0272h abstractC0272h, AbstractC0272h.c cVar, C2.p pVar, InterfaceC0593d interfaceC0593d) {
        super(2, interfaceC0593d);
        this.f5755k = abstractC0272h;
        this.f5756l = cVar;
        this.f5757m = pVar;
    }

    @Override // v2.AbstractC0610a
    public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.f5755k, this.f5756l, this.f5757m, interfaceC0593d);
        repeatOnLifecycleKt$repeatOnLifecycle$3.f5754j = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // C2.p
    public final Object invoke(L2.D d3, InterfaceC0593d interfaceC0593d) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(d3, interfaceC0593d)).invokeSuspend(p2.q.f12810a);
    }

    @Override // v2.AbstractC0610a
    public final Object invokeSuspend(Object obj) {
        Object c3 = AbstractC0603b.c();
        int i3 = this.f5753i;
        if (i3 == 0) {
            p2.l.b(obj);
            L2.D d3 = (L2.D) this.f5754j;
            o0 f02 = O.c().f0();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f5755k, this.f5756l, d3, this.f5757m, null);
            this.f5753i = 1;
            if (AbstractC0174f.c(f02, anonymousClass1, this) == c3) {
                return c3;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            p2.l.b(obj);
        }
        return p2.q.f12810a;
    }
}
