package N2;

import L2.AbstractC0193z;
import L2.D;
import L2.F;
import L2.InterfaceC0178j;
import p2.C0511k;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
public abstract class o {

    static final class a extends v2.d {

        /* renamed from: h, reason: collision with root package name */
        Object f1676h;

        /* renamed from: i, reason: collision with root package name */
        Object f1677i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f1678j;

        /* renamed from: k, reason: collision with root package name */
        int f1679k;

        a(InterfaceC0593d interfaceC0593d) {
            super(interfaceC0593d);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            this.f1678j = obj;
            this.f1679k |= Integer.MIN_VALUE;
            return o.a(null, null, this);
        }
    }

    static final class b extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC0178j f1680e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC0178j interfaceC0178j) {
            super(1);
            this.f1680e = interfaceC0178j;
        }

        public final void a(Throwable th) {
            InterfaceC0178j interfaceC0178j = this.f1680e;
            C0511k.a aVar = C0511k.f12803f;
            interfaceC0178j.resumeWith(C0511k.b(p2.q.f12810a));
        }

        @Override // C2.l
        public /* bridge */ /* synthetic */ Object f(Object obj) {
            a((Throwable) obj);
            return p2.q.f12810a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(N2.q r4, C2.a r5, t2.InterfaceC0593d r6) {
        /*
            boolean r0 = r6 instanceof N2.o.a
            if (r0 == 0) goto L13
            r0 = r6
            N2.o$a r0 = (N2.o.a) r0
            int r1 = r0.f1679k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1679k = r1
            goto L18
        L13:
            N2.o$a r0 = new N2.o$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f1678j
            java.lang.Object r1 = u2.AbstractC0603b.c()
            int r2 = r0.f1679k
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f1677i
            r5 = r4
            C2.a r5 = (C2.a) r5
            java.lang.Object r4 = r0.f1676h
            N2.q r4 = (N2.q) r4
            p2.l.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L75
        L32:
            r4 = move-exception
            goto L7b
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            p2.l.b(r6)
            t2.g r6 = r0.getContext()
            L2.e0$b r2 = L2.e0.f1268b
            t2.g$b r6 = r6.a(r2)
            if (r6 != r4) goto L7f
            r0.f1676h = r4     // Catch: java.lang.Throwable -> L32
            r0.f1677i = r5     // Catch: java.lang.Throwable -> L32
            r0.f1679k = r3     // Catch: java.lang.Throwable -> L32
            L2.k r6 = new L2.k     // Catch: java.lang.Throwable -> L32
            t2.d r2 = u2.AbstractC0603b.b(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.y()     // Catch: java.lang.Throwable -> L32
            N2.o$b r2 = new N2.o$b     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.d(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.v()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = u2.AbstractC0603b.c()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L72
            v2.h.c(r0)     // Catch: java.lang.Throwable -> L32
        L72:
            if (r4 != r1) goto L75
            return r1
        L75:
            r5.invoke()
            p2.q r4 = p2.q.f12810a
            return r4
        L7b:
            r5.invoke()
            throw r4
        L7f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: N2.o.a(N2.q, C2.a, t2.d):java.lang.Object");
    }

    public static final r b(D d3, t2.g gVar, int i3, N2.a aVar, F f3, C2.l lVar, C2.p pVar) {
        p pVar2 = new p(AbstractC0193z.d(d3, gVar), g.b(i3, aVar, null, 4, null));
        if (lVar != null) {
            pVar2.Z(lVar);
        }
        pVar2.G0(f3, pVar2, pVar);
        return pVar2;
    }

    public static /* synthetic */ r c(D d3, t2.g gVar, int i3, N2.a aVar, F f3, C2.l lVar, C2.p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            gVar = t2.h.f13692e;
        }
        t2.g gVar2 = gVar;
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        int i5 = i3;
        if ((i4 & 4) != 0) {
            aVar = N2.a.SUSPEND;
        }
        N2.a aVar2 = aVar;
        if ((i4 & 8) != 0) {
            f3 = F.DEFAULT;
        }
        F f4 = f3;
        if ((i4 & 16) != 0) {
            lVar = null;
        }
        return b(d3, gVar2, i5, aVar2, f4, lVar, pVar);
    }
}
