package q1;

import android.graphics.RectF;
import p1.AbstractC0496a;
import p1.C0500e;
import r1.C0566a;
import s1.AbstractC0576c;

/* renamed from: q1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0516a {

    /* renamed from: a, reason: collision with root package name */
    public final C0500e f13002a;

    /* renamed from: b, reason: collision with root package name */
    public final C0500e f13003b;

    /* renamed from: c, reason: collision with root package name */
    public final C0500e f13004c;

    /* renamed from: d, reason: collision with root package name */
    public final C0500e f13005d;

    /* renamed from: e, reason: collision with root package name */
    public final C0500e f13006e;

    /* renamed from: f, reason: collision with root package name */
    public final C0500e f13007f;

    /* renamed from: g, reason: collision with root package name */
    public AbstractC0576c f13008g;

    /* renamed from: h, reason: collision with root package name */
    public RectF f13009h;

    /* renamed from: i, reason: collision with root package name */
    public RectF f13010i;

    /* renamed from: j, reason: collision with root package name */
    public C0516a f13011j;

    /* renamed from: k, reason: collision with root package name */
    public C0516a f13012k;

    /* renamed from: l, reason: collision with root package name */
    public C0566a f13013l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13014m;

    /* renamed from: n, reason: collision with root package name */
    public float f13015n;

    /* renamed from: o, reason: collision with root package name */
    public float f13016o;

    /* renamed from: p, reason: collision with root package name */
    public float f13017p;

    /* renamed from: q, reason: collision with root package name */
    public float f13018q;

    /* renamed from: r, reason: collision with root package name */
    public float f13019r;

    /* renamed from: s, reason: collision with root package name */
    public float f13020s;

    /* renamed from: t, reason: collision with root package name */
    public float f13021t;

    /* renamed from: u, reason: collision with root package name */
    public int f13022u;

    /* renamed from: v, reason: collision with root package name */
    public int f13023v;

    /* renamed from: w, reason: collision with root package name */
    boolean f13024w;

    /* renamed from: x, reason: collision with root package name */
    boolean f13025x;

    /* renamed from: y, reason: collision with root package name */
    private String f13026y;

    public C0516a(C0500e c0500e, int i3, int i4, float f3, float f4) {
        C0500e c0500e2 = new C0500e();
        this.f13002a = c0500e2;
        this.f13003b = new C0500e();
        this.f13004c = new C0500e();
        this.f13005d = new C0500e(0.0f, 0.0f);
        this.f13006e = new C0500e();
        this.f13007f = new C0500e();
        this.f13008g = null;
        this.f13014m = false;
        this.f13015n = 50.0f;
        this.f13024w = false;
        this.f13025x = false;
        this.f13026y = "";
        t(i3);
        q(i4);
        c0500e2.e(c0500e);
        this.f13018q = 1.0f;
        r(f3, f4);
        this.f13024w = true;
        this.f13013l = null;
        this.f13011j = null;
        this.f13012k = null;
    }

    private final void i() {
        if (this.f13022u == 0) {
            o(1.0f);
            m(0.0f);
            return;
        }
        o(this.f13016o * this.f13017p * this.f13018q);
        m(AbstractC0496a.a(this.f13019r));
        if (!this.f13024w || this.f13023v == 1) {
            this.f13003b.d(this.f13016o * 0.5f, this.f13017p * 0.5f);
            this.f13004c.e(this.f13002a).a(this.f13003b);
        }
    }

    private final void o(float f3) {
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        this.f13019r = f3;
        this.f13020s = 1.0f / f3;
    }

    private void q(int i3) {
        this.f13023v = i3;
    }

    private void t(int i3) {
        this.f13022u = i3;
    }

    public void a(AbstractC0576c abstractC0576c) {
        AbstractC0576c abstractC0576c2;
        RectF rectF = this.f13010i;
        if (rectF == null || (abstractC0576c2 = this.f13008g) == null || abstractC0576c2 != abstractC0576c) {
            return;
        }
        rectF.setEmpty();
    }

    public final C0500e b() {
        return this.f13005d;
    }

    public final C0500e c() {
        return this.f13006e;
    }

    public final float d() {
        return this.f13019r;
    }

    public final C0500e e() {
        return this.f13002a;
    }

    public int f() {
        return this.f13023v;
    }

    public int g() {
        return this.f13022u;
    }

    public final C0500e h() {
        return this.f13004c;
    }

    public void j(float f3) {
        this.f13015n = f3;
    }

    public void k(boolean z3) {
        this.f13014m = z3;
    }

    public final void l(float f3, float f4) {
        this.f13005d.d(AbstractC0496a.c(f3), AbstractC0496a.c(f4));
    }

    public final void m(float f3) {
        this.f13021t = f3;
    }

    public final void n(C0500e c0500e) {
        if (this.f13022u == 0) {
            return;
        }
        this.f13006e.e(c0500e);
    }

    public final void p(C0500e c0500e) {
        this.f13002a.e(c0500e);
        this.f13004c.e(c0500e).a(this.f13003b);
    }

    public void r(float f3, float f4) {
        this.f13016o = f3;
        this.f13017p = f4;
        i();
    }

    void s(String str) {
        this.f13026y = str;
    }

    public String toString() {
        return "Body{mType=" + this.f13022u + ", mProperty=" + this.f13023v + ", mLinearVelocity=" + this.f13006e + ", mLinearDamping=" + this.f13021t + ", mPosition=" + this.f13002a + ", mHookPosition=" + this.f13005d + ", mOriginActiveRect=" + this.f13009h + ", mActiveRect=" + this.f13010i + ", mMassCenter='" + this.f13003b + ", mWorldCenter='" + this.f13004c + ", mLinearVelocity='" + this.f13006e + ", mForce='" + this.f13007f + ", mWidth='" + this.f13016o + ", mHeight='" + this.f13017p + ", mDensity='" + this.f13018q + ", mMass='" + this.f13019r + ", mInvMass='" + this.f13020s + ", mLinearDamping='" + this.f13021t + ", mType='" + this.f13022u + ", mIsSolved='" + this.f13025x + ", mTag='" + this.f13026y + "}@" + hashCode();
    }

    void u() {
        C0500e c0500e = this.f13002a;
        C0500e c0500e2 = this.f13004c;
        float f3 = c0500e2.f12799a;
        C0500e c0500e3 = this.f13003b;
        c0500e.d(f3 - c0500e3.f12799a, c0500e2.f12800b - c0500e3.f12800b);
    }

    void v() {
        AbstractC0576c abstractC0576c;
        RectF rectF = this.f13010i;
        if (rectF == null || rectF.isEmpty() || (abstractC0576c = this.f13008g) == null || abstractC0576c.q() != 0) {
            return;
        }
        RectF rectF2 = this.f13010i;
        float f3 = rectF2.left;
        float f4 = rectF2.right;
        float f5 = rectF2.top;
        float f6 = rectF2.bottom;
        C0500e c0500e = this.f13002a;
        float f7 = c0500e.f12799a;
        if (f7 < f3) {
            this.f13007f.f12799a = f3 - f7;
        } else if (f7 > f4) {
            this.f13007f.f12799a = f4 - f7;
        }
        float f8 = c0500e.f12800b;
        if (f8 < f5) {
            this.f13007f.f12800b = f5 - f8;
        } else if (f8 > f6) {
            this.f13007f.f12800b = f6 - f8;
        }
        float f9 = this.f13015n * 6.2831855f;
        this.f13007f.b(this.f13019r * f9 * f9 * 1.0f);
    }

    public boolean w(AbstractC0576c abstractC0576c) {
        RectF rectF = this.f13009h;
        if (rectF == null || rectF.isEmpty()) {
            return false;
        }
        this.f13008g = abstractC0576c;
        if (this.f13010i == null) {
            this.f13010i = new RectF();
        }
        RectF rectF2 = this.f13010i;
        RectF rectF3 = this.f13009h;
        float f3 = rectF3.left;
        C0500e c0500e = this.f13005d;
        float f4 = c0500e.f12799a;
        float f5 = rectF3.top;
        float f6 = c0500e.f12800b;
        rectF2.set(f3 + f4, f5 + f6, rectF3.right - (this.f13016o - f4), rectF3.bottom - (this.f13017p - f6));
        return true;
    }
}
