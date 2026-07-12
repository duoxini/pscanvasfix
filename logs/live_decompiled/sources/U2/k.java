package U2;

/* loaded from: classes.dex */
public final class k implements p {

    /* renamed from: e, reason: collision with root package name */
    private final d f2475e;

    /* renamed from: f, reason: collision with root package name */
    private final b f2476f;

    /* renamed from: g, reason: collision with root package name */
    private m f2477g;

    /* renamed from: h, reason: collision with root package name */
    private int f2478h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f2479i;

    /* renamed from: j, reason: collision with root package name */
    private long f2480j;

    public k(d dVar) {
        D2.k.e(dVar, "upstream");
        this.f2475e = dVar;
        b Q3 = dVar.Q();
        this.f2476f = Q3;
        m mVar = Q3.f2455e;
        this.f2477g = mVar;
        this.f2478h = mVar != null ? mVar.f2487b : -1;
    }

    @Override // U2.p, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
        this.f2479i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3 == r4.f2487b) goto L15;
     */
    @Override // U2.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long o(U2.b r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            D2.k.e(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L75
            boolean r3 = r8.f2479i
            if (r3 != 0) goto L6d
            U2.m r3 = r8.f2477g
            if (r3 == 0) goto L2b
            U2.b r4 = r8.f2476f
            U2.m r4 = r4.f2455e
            if (r3 != r4) goto L23
            int r3 = r8.f2478h
            D2.k.b(r4)
            int r4 = r4.f2487b
            if (r3 != r4) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Peek source is invalid because upstream source was used"
            r8.<init>(r9)
            throw r8
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            U2.d r0 = r8.f2475e
            long r1 = r8.f2480j
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.A(r1)
            if (r0 != 0) goto L3e
            r8 = -1
            return r8
        L3e:
            U2.m r0 = r8.f2477g
            if (r0 != 0) goto L51
            U2.b r0 = r8.f2476f
            U2.m r0 = r0.f2455e
            if (r0 == 0) goto L51
            r8.f2477g = r0
            D2.k.b(r0)
            int r0 = r0.f2487b
            r8.f2478h = r0
        L51:
            U2.b r0 = r8.f2476f
            long r0 = r0.e0()
            long r2 = r8.f2480j
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            U2.b r2 = r8.f2476f
            long r4 = r8.f2480j
            r3 = r9
            r6 = r10
            r2.g(r3, r4, r6)
            long r0 = r8.f2480j
            long r0 = r0 + r10
            r8.f2480j = r0
            return r10
        L6d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            r8.<init>(r9)
            throw r8
        L75:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "byteCount < 0: "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: U2.k.o(U2.b, long):long");
    }
}
