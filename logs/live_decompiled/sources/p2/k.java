package P2;

import C2.p;
import Q2.H;
import p2.l;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
final class k implements O2.d {

    /* renamed from: a, reason: collision with root package name */
    private final t2.g f1880a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f1881b;

    /* renamed from: c, reason: collision with root package name */
    private final p f1882c;

    static final class a extends v2.k implements p {

        /* renamed from: i, reason: collision with root package name */
        int f1883i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f1884j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ O2.d f1885k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(O2.d dVar, InterfaceC0593d interfaceC0593d) {
            super(2, interfaceC0593d);
            this.f1885k = dVar;
        }

        @Override // C2.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, InterfaceC0593d interfaceC0593d) {
            return ((a) create(obj, interfaceC0593d)).invokeSuspend(q.f12810a);
        }

        @Override // v2.AbstractC0610a
        public final InterfaceC0593d create(Object obj, InterfaceC0593d interfaceC0593d) {
            a aVar = new a(this.f1885k, interfaceC0593d);
            aVar.f1884j = obj;
            return aVar;
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            Object c3 = AbstractC0603b.c();
            int i3 = this.f1883i;
            if (i3 == 0) {
                l.b(obj);
                Object obj2 = this.f1884j;
                O2.d dVar = this.f1885k;
                this.f1883i = 1;
                if (dVar.emit(obj2, this) == c3) {
                    return c3;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.b(obj);
            }
            return q.f12810a;
        }
    }

    public k(O2.d dVar, t2.g gVar) {
        this.f1880a = gVar;
        this.f1881b = H.b(gVar);
        this.f1882c = new a(dVar, null);
    }

    @Override // O2.d
    public Object emit(Object obj, InterfaceC0593d interfaceC0593d) {
        Object b3 = c.b(this.f1880a, obj, this.f1881b, this.f1882c, interfaceC0593d);
        return b3 == AbstractC0603b.c() ? b3 : q.f12810a;
    }
}
