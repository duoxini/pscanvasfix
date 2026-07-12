package O2;

import D2.r;
import t2.InterfaceC0593d;

/* loaded from: classes.dex */
abstract /* synthetic */ class j {

    public static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f1740a;

        public a(r rVar) {
            this.f1740a = rVar;
        }

        @Override // O2.d
        public Object emit(Object obj, InterfaceC0593d interfaceC0593d) {
            this.f1740a.f337e = obj;
            throw new P2.a(this);
        }
    }

    static final class b extends v2.d {

        /* renamed from: h, reason: collision with root package name */
        Object f1741h;

        /* renamed from: i, reason: collision with root package name */
        Object f1742i;

        /* renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f1743j;

        /* renamed from: k, reason: collision with root package name */
        int f1744k;

        b(InterfaceC0593d interfaceC0593d) {
            super(interfaceC0593d);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            this.f1743j = obj;
            this.f1744k |= Integer.MIN_VALUE;
            return e.d(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(O2.c r4, t2.InterfaceC0593d r5) {
        /*
            boolean r0 = r5 instanceof O2.j.b
            if (r0 == 0) goto L13
            r0 = r5
            O2.j$b r0 = (O2.j.b) r0
            int r1 = r0.f1744k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1744k = r1
            goto L18
        L13:
            O2.j$b r0 = new O2.j$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f1743j
            java.lang.Object r1 = u2.AbstractC0603b.c()
            int r2 = r0.f1744k
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f1742i
            O2.j$a r4 = (O2.j.a) r4
            java.lang.Object r0 = r0.f1741h
            D2.r r0 = (D2.r) r0
            p2.l.b(r5)     // Catch: P2.a -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            p2.l.b(r5)
            D2.r r5 = new D2.r
            r5.<init>()
            Q2.D r2 = P2.h.f1874a
            r5.f337e = r2
            O2.j$a r2 = new O2.j$a
            r2.<init>(r5)
            r0.f1741h = r5     // Catch: P2.a -> L5b
            r0.f1742i = r2     // Catch: P2.a -> L5b
            r0.f1744k = r3     // Catch: P2.a -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: P2.a -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            P2.f.a(r5, r4)
        L62:
            java.lang.Object r4 = r0.f337e
            Q2.D r5 = P2.h.f1874a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.j.a(O2.c, t2.d):java.lang.Object");
    }
}
