package U2;

import q2.AbstractC0538h;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: h, reason: collision with root package name */
    public static final a f2485h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f2486a;

    /* renamed from: b, reason: collision with root package name */
    public int f2487b;

    /* renamed from: c, reason: collision with root package name */
    public int f2488c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2489d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2490e;

    /* renamed from: f, reason: collision with root package name */
    public m f2491f;

    /* renamed from: g, reason: collision with root package name */
    public m f2492g;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    public m() {
        this.f2486a = new byte[8192];
        this.f2490e = true;
        this.f2489d = false;
    }

    public final void a() {
        int i3;
        m mVar = this.f2492g;
        if (mVar == this) {
            throw new IllegalStateException("cannot compact");
        }
        D2.k.b(mVar);
        if (mVar.f2490e) {
            int i4 = this.f2488c - this.f2487b;
            m mVar2 = this.f2492g;
            D2.k.b(mVar2);
            int i5 = 8192 - mVar2.f2488c;
            m mVar3 = this.f2492g;
            D2.k.b(mVar3);
            if (mVar3.f2489d) {
                i3 = 0;
            } else {
                m mVar4 = this.f2492g;
                D2.k.b(mVar4);
                i3 = mVar4.f2487b;
            }
            if (i4 > i5 + i3) {
                return;
            }
            m mVar5 = this.f2492g;
            D2.k.b(mVar5);
            f(mVar5, i4);
            b();
            n.b(this);
        }
    }

    public final m b() {
        m mVar = this.f2491f;
        if (mVar == this) {
            mVar = null;
        }
        m mVar2 = this.f2492g;
        D2.k.b(mVar2);
        mVar2.f2491f = this.f2491f;
        m mVar3 = this.f2491f;
        D2.k.b(mVar3);
        mVar3.f2492g = this.f2492g;
        this.f2491f = null;
        this.f2492g = null;
        return mVar;
    }

    public final m c(m mVar) {
        D2.k.e(mVar, "segment");
        mVar.f2492g = this;
        mVar.f2491f = this.f2491f;
        m mVar2 = this.f2491f;
        D2.k.b(mVar2);
        mVar2.f2492g = mVar;
        this.f2491f = mVar;
        return mVar;
    }

    public final m d() {
        this.f2489d = true;
        return new m(this.f2486a, this.f2487b, this.f2488c, true, false);
    }

    public final m e(int i3) {
        m c3;
        if (i3 <= 0 || i3 > this.f2488c - this.f2487b) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i3 >= 1024) {
            c3 = d();
        } else {
            c3 = n.c();
            byte[] bArr = this.f2486a;
            byte[] bArr2 = c3.f2486a;
            int i4 = this.f2487b;
            AbstractC0538h.i(bArr, bArr2, 0, i4, i4 + i3, 2, null);
        }
        c3.f2488c = c3.f2487b + i3;
        this.f2487b += i3;
        m mVar = this.f2492g;
        D2.k.b(mVar);
        mVar.c(c3);
        return c3;
    }

    public final void f(m mVar, int i3) {
        D2.k.e(mVar, "sink");
        if (!mVar.f2490e) {
            throw new IllegalStateException("only owner can write");
        }
        int i4 = mVar.f2488c;
        if (i4 + i3 > 8192) {
            if (mVar.f2489d) {
                throw new IllegalArgumentException();
            }
            int i5 = mVar.f2487b;
            if ((i4 + i3) - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = mVar.f2486a;
            AbstractC0538h.i(bArr, bArr, 0, i5, i4, 2, null);
            mVar.f2488c -= mVar.f2487b;
            mVar.f2487b = 0;
        }
        byte[] bArr2 = this.f2486a;
        byte[] bArr3 = mVar.f2486a;
        int i6 = mVar.f2488c;
        int i7 = this.f2487b;
        AbstractC0538h.g(bArr2, bArr3, i6, i7, i7 + i3);
        mVar.f2488c += i3;
        this.f2487b += i3;
    }

    public m(byte[] bArr, int i3, int i4, boolean z3, boolean z4) {
        D2.k.e(bArr, "data");
        this.f2486a = bArr;
        this.f2487b = i3;
        this.f2488c = i4;
        this.f2489d = z3;
        this.f2490e = z4;
    }
}
