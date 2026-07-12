package K2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
final class d implements J2.b {

    /* renamed from: a, reason: collision with root package name */
    private final CharSequence f1178a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1179b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1180c;

    /* renamed from: d, reason: collision with root package name */
    private final C2.p f1181d;

    public static final class a implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private int f1182a = -1;

        /* renamed from: b, reason: collision with root package name */
        private int f1183b;

        /* renamed from: c, reason: collision with root package name */
        private int f1184c;

        /* renamed from: d, reason: collision with root package name */
        private H2.c f1185d;

        /* renamed from: e, reason: collision with root package name */
        private int f1186e;

        a() {
            int e3 = H2.d.e(d.this.f1179b, 0, d.this.f1178a.length());
            this.f1183b = e3;
            this.f1184c = e3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        
            if (r0 < r6.f1187f.f1180c) goto L9;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f1184c
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f1182a = r1
                r0 = 0
                r6.f1185d = r0
                goto L9e
            Lc:
                K2.d r0 = K2.d.this
                int r0 = K2.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.f1186e
                int r0 = r0 + r3
                r6.f1186e = r0
                K2.d r4 = K2.d.this
                int r4 = K2.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.f1184c
                K2.d r4 = K2.d.this
                java.lang.CharSequence r4 = K2.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                H2.c r0 = new H2.c
                int r1 = r6.f1183b
                K2.d r4 = K2.d.this
                java.lang.CharSequence r4 = K2.d.b(r4)
                int r4 = K2.e.z(r4)
                r0.<init>(r1, r4)
                r6.f1185d = r0
                r6.f1184c = r2
                goto L9c
            L47:
                K2.d r0 = K2.d.this
                C2.p r0 = K2.d.a(r0)
                K2.d r4 = K2.d.this
                java.lang.CharSequence r4 = K2.d.b(r4)
                int r5 = r6.f1184c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                p2.j r0 = (p2.C0510j) r0
                if (r0 != 0) goto L77
                H2.c r0 = new H2.c
                int r1 = r6.f1183b
                K2.d r4 = K2.d.this
                java.lang.CharSequence r4 = K2.d.b(r4)
                int r4 = K2.e.z(r4)
                r0.<init>(r1, r4)
                r6.f1185d = r0
                r6.f1184c = r2
                goto L9c
            L77:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f1183b
                H2.c r4 = H2.d.g(r4, r2)
                r6.f1185d = r4
                int r2 = r2 + r0
                r6.f1183b = r2
                if (r0 != 0) goto L99
                r1 = r3
            L99:
                int r2 = r2 + r1
                r6.f1184c = r2
            L9c:
                r6.f1182a = r3
            L9e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: K2.d.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public H2.c next() {
            if (this.f1182a == -1) {
                a();
            }
            if (this.f1182a == 0) {
                throw new NoSuchElementException();
            }
            H2.c cVar = this.f1185d;
            D2.k.c(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f1185d = null;
            this.f1182a = -1;
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1182a == -1) {
                a();
            }
            return this.f1182a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public d(CharSequence charSequence, int i3, int i4, C2.p pVar) {
        D2.k.e(charSequence, "input");
        D2.k.e(pVar, "getNextMatch");
        this.f1178a = charSequence;
        this.f1179b = i3;
        this.f1180c = i4;
        this.f1181d = pVar;
    }

    @Override // J2.b
    public Iterator iterator() {
        return new a();
    }
}
