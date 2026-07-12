package O2;

import C2.p;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
final class a extends b {

    /* renamed from: e, reason: collision with root package name */
    private final p f1728e;

    /* renamed from: O2.a$a, reason: collision with other inner class name */
    static final class C0034a extends v2.d {

        /* renamed from: h, reason: collision with root package name */
        Object f1729h;

        /* renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1730i;

        /* renamed from: k, reason: collision with root package name */
        int f1732k;

        C0034a(InterfaceC0593d interfaceC0593d) {
            super(interfaceC0593d);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            this.f1730i = obj;
            this.f1732k |= Integer.MIN_VALUE;
            return a.this.d(null, this);
        }
    }

    public /* synthetic */ a(p pVar, t2.g gVar, int i3, N2.a aVar, int i4, D2.g gVar2) {
        this(pVar, (i4 & 2) != 0 ? t2.h.f13692e : gVar, (i4 & 4) != 0 ? -2 : i3, (i4 & 8) != 0 ? N2.a.SUSPEND : aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // O2.b, P2.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object d(N2.q r5, t2.InterfaceC0593d r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof O2.a.C0034a
            if (r0 == 0) goto L13
            r0 = r6
            O2.a$a r0 = (O2.a.C0034a) r0
            int r1 = r0.f1732k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1732k = r1
            goto L18
        L13:
            O2.a$a r0 = new O2.a$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f1730i
            java.lang.Object r1 = u2.AbstractC0603b.c()
            int r2 = r0.f1732k
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.f1729h
            r5 = r4
            N2.q r5 = (N2.q) r5
            p2.l.b(r6)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            p2.l.b(r6)
            r0.f1729h = r5
            r0.f1732k = r3
            java.lang.Object r4 = super.d(r5, r0)
            if (r4 != r1) goto L44
            return r1
        L44:
            boolean r4 = r5.o()
            if (r4 == 0) goto L4d
            p2.q r4 = p2.q.f12810a
            return r4
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.a.d(N2.q, t2.d):java.lang.Object");
    }

    @Override // P2.b
    protected P2.b e(t2.g gVar, int i3, N2.a aVar) {
        return new a(this.f1728e, gVar, i3, aVar);
    }

    public a(p pVar, t2.g gVar, int i3, N2.a aVar) {
        super(pVar, gVar, i3, aVar);
        this.f1728e = pVar;
    }
}
