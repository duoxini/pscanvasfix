package O2;

import N2.r;
import p2.q;
import t2.InterfaceC0593d;
import u2.AbstractC0603b;

/* loaded from: classes.dex */
abstract /* synthetic */ class g {

    static final class a extends v2.d {

        /* renamed from: h, reason: collision with root package name */
        Object f1734h;

        /* renamed from: i, reason: collision with root package name */
        Object f1735i;

        /* renamed from: j, reason: collision with root package name */
        Object f1736j;

        /* renamed from: k, reason: collision with root package name */
        boolean f1737k;

        /* renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f1738l;

        /* renamed from: m, reason: collision with root package name */
        int f1739m;

        a(InterfaceC0593d interfaceC0593d) {
            super(interfaceC0593d);
        }

        @Override // v2.AbstractC0610a
        public final Object invokeSuspend(Object obj) {
            this.f1738l = obj;
            this.f1739m |= Integer.MIN_VALUE;
            return g.c(null, null, false, this);
        }
    }

    public static final Object b(d dVar, r rVar, InterfaceC0593d interfaceC0593d) {
        Object c3 = c(dVar, rVar, true, interfaceC0593d);
        return c3 == AbstractC0603b.c() ? c3 : q.f12810a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:12:0x0036, B:14:0x0062, B:19:0x0077, B:21:0x007f, B:32:0x0054, B:34:0x005e), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(O2.d r6, N2.r r7, boolean r8, t2.InterfaceC0593d r9) {
        /*
            boolean r0 = r9 instanceof O2.g.a
            if (r0 == 0) goto L13
            r0 = r9
            O2.g$a r0 = (O2.g.a) r0
            int r1 = r0.f1739m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1739m = r1
            goto L18
        L13:
            O2.g$a r0 = new O2.g$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f1738l
            java.lang.Object r1 = u2.AbstractC0603b.c()
            int r2 = r0.f1739m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L58
            if (r2 == r4) goto L46
            if (r2 != r3) goto L3e
            boolean r8 = r0.f1737k
            java.lang.Object r6 = r0.f1736j
            N2.f r6 = (N2.f) r6
            java.lang.Object r7 = r0.f1735i
            N2.r r7 = (N2.r) r7
            java.lang.Object r2 = r0.f1734h
            O2.d r2 = (O2.d) r2
            p2.l.b(r9)     // Catch: java.lang.Throwable -> L3c
        L39:
            r9 = r6
            r6 = r2
            goto L62
        L3c:
            r6 = move-exception
            goto L9d
        L3e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L46:
            boolean r8 = r0.f1737k
            java.lang.Object r6 = r0.f1736j
            N2.f r6 = (N2.f) r6
            java.lang.Object r7 = r0.f1735i
            N2.r r7 = (N2.r) r7
            java.lang.Object r2 = r0.f1734h
            O2.d r2 = (O2.d) r2
            p2.l.b(r9)     // Catch: java.lang.Throwable -> L3c
            goto L77
        L58:
            p2.l.b(r9)
            O2.e.c(r6)
            N2.f r9 = r7.iterator()     // Catch: java.lang.Throwable -> L3c
        L62:
            r0.f1734h = r6     // Catch: java.lang.Throwable -> L3c
            r0.f1735i = r7     // Catch: java.lang.Throwable -> L3c
            r0.f1736j = r9     // Catch: java.lang.Throwable -> L3c
            r0.f1737k = r8     // Catch: java.lang.Throwable -> L3c
            r0.f1739m = r4     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r9.a(r0)     // Catch: java.lang.Throwable -> L3c
            if (r2 != r1) goto L73
            return r1
        L73:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L77:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L3c
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r9 == 0) goto L94
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L3c
            r0.f1734h = r2     // Catch: java.lang.Throwable -> L3c
            r0.f1735i = r7     // Catch: java.lang.Throwable -> L3c
            r0.f1736j = r6     // Catch: java.lang.Throwable -> L3c
            r0.f1737k = r8     // Catch: java.lang.Throwable -> L3c
            r0.f1739m = r3     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L3c
            if (r9 != r1) goto L39
            return r1
        L94:
            if (r8 == 0) goto L9a
            r6 = 0
            N2.j.a(r7, r6)
        L9a:
            p2.q r6 = p2.q.f12810a
            return r6
        L9d:
            throw r6     // Catch: java.lang.Throwable -> L9e
        L9e:
            r9 = move-exception
            if (r8 == 0) goto La4
            N2.j.a(r7, r6)
        La4:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: O2.g.c(O2.d, N2.r, boolean, t2.d):java.lang.Object");
    }
}
