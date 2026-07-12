package r1;

import p1.C0498c;
import p1.C0500e;
import q1.C0516a;
import q1.C0517b;

/* renamed from: r1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0567b {

    /* renamed from: c, reason: collision with root package name */
    public C0566a f13218c;

    /* renamed from: d, reason: collision with root package name */
    public C0566a f13219d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13220e;

    /* renamed from: f, reason: collision with root package name */
    private float f13221f;

    /* renamed from: g, reason: collision with root package name */
    private float f13222g;

    /* renamed from: i, reason: collision with root package name */
    private float f13224i;

    /* renamed from: k, reason: collision with root package name */
    private float f13226k;

    /* renamed from: l, reason: collision with root package name */
    private C0516a f13227l;

    /* renamed from: m, reason: collision with root package name */
    private C0516a f13228m;

    /* renamed from: n, reason: collision with root package name */
    private final C0500e f13229n;

    /* renamed from: o, reason: collision with root package name */
    private final C0500e f13230o;

    /* renamed from: p, reason: collision with root package name */
    private final C0500e f13231p;

    /* renamed from: q, reason: collision with root package name */
    private final C0500e f13232q;

    /* renamed from: r, reason: collision with root package name */
    private final C0500e f13233r;

    /* renamed from: s, reason: collision with root package name */
    private final C0498c f13234s;

    /* renamed from: a, reason: collision with root package name */
    public C0567b f13216a = null;

    /* renamed from: b, reason: collision with root package name */
    public C0567b f13217b = null;

    /* renamed from: h, reason: collision with root package name */
    private float f13223h = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f13225j = 0.0f;

    private C0567b(C0500e c0500e, C0568c c0568c) {
        C0500e c0500e2 = new C0500e();
        this.f13229n = c0500e2;
        this.f13230o = new C0500e();
        C0500e c0500e3 = new C0500e();
        this.f13231p = c0500e3;
        this.f13232q = new C0500e();
        this.f13234s = new C0498c();
        this.f13233r = c0500e;
        this.f13227l = c0568c.f13235a;
        this.f13228m = c0568c.f13236b;
        this.f13220e = false;
        this.f13218c = new C0566a();
        this.f13219d = new C0566a();
        if (c0568c.f13239e < 0.0f || c0568c.f13238d < 0.0f || c0568c.f13240f < 0.0f) {
            return;
        }
        c0500e3.e(c0568c.f13237c);
        c0500e2.e(c0500e3).g(this.f13228m.e());
        this.f13224i = c0568c.f13238d;
        this.f13221f = c0568c.f13239e;
        this.f13222g = c0568c.f13240f;
    }

    public static C0567b a(C0517b c0517b, C0568c c0568c) {
        return new C0567b(c0517b.f(), c0568c);
    }

    public final C0516a b() {
        return this.f13227l;
    }

    public final C0516a c() {
        return this.f13228m;
    }

    public void d(C0516a c0516a, float f3) {
        this.f13226k = c0516a.f13020s;
        float f4 = this.f13221f * 6.2831855f;
        float d3 = c0516a.d() * 2.0f * this.f13222g * f4;
        float d4 = c0516a.d() * f4 * f4 * f3;
        float f5 = d3 + d4;
        if (f5 > 1.1920929E-7f) {
            this.f13225j = f3 * f5;
        }
        float f6 = this.f13225j;
        if (f6 != 0.0f) {
            this.f13225j = 1.0f / f6;
        }
        float f7 = this.f13225j;
        this.f13223h = d4 * f7;
        C0498c c0498c = this.f13234s;
        C0500e c0500e = c0498c.f12797a;
        float f8 = this.f13226k;
        c0500e.f12799a = f8 + f7;
        c0498c.f12798b.f12800b = f8 + f7;
        c0498c.a();
        this.f13230o.e(c0516a.f13004c).g(this.f13229n).g(this.f13231p).b(this.f13223h);
        C0500e c0500e2 = c0516a.f13006e;
        float f9 = c0500e2.f12799a;
        float f10 = this.f13226k;
        C0500e c0500e3 = this.f13232q;
        c0500e2.f12799a = f9 + (c0500e3.f12799a * f10);
        c0500e2.f12800b += f10 * c0500e3.f12800b;
    }

    public void e(float f3) {
        this.f13222g = f3;
    }

    public void f(float f3) {
        this.f13221f = f3;
    }

    public void g(C0500e c0500e) {
        this.f13231p.e(c0500e);
    }

    public void h(C0516a c0516a) {
        this.f13233r.e(this.f13232q);
        this.f13233r.b(this.f13225j).a(this.f13230o).a(c0516a.f13006e).c();
        C0498c c0498c = this.f13234s;
        C0500e c0500e = this.f13233r;
        C0498c.b(c0498c, c0500e, c0500e);
        this.f13232q.a(this.f13233r);
        c0516a.f13006e.a(this.f13233r.b(this.f13226k));
    }

    public String toString() {
        return "Spring{mIsSolved=" + this.f13220e + ", mFrequencyHz=" + this.f13221f + ", mDampingRatio=" + this.f13222g + ", mBeta=" + this.f13223h + ", mMaxForce=" + this.f13224i + ", mGamma=" + this.f13225j + ", mInvMass=" + this.f13226k + ", mTarget=" + this.f13231p + ", mLocalAnchor=" + this.f13229n + ", mPositionCenter=" + this.f13230o + ", mImpulse=" + this.f13232q + ", mImpulseTemp=" + this.f13233r + "}@" + hashCode();
    }
}
