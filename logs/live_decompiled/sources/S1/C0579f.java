package s1;

import android.graphics.RectF;
import p1.AbstractC0496a;
import p1.AbstractC0497b;
import p1.AbstractC0499d;
import p1.C0500e;
import q1.C0516a;
import r1.C0567b;
import r1.C0568c;

/* renamed from: s1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0579f extends AbstractC0576c {

    /* renamed from: o, reason: collision with root package name */
    private C0516a f13301o;

    /* renamed from: p, reason: collision with root package name */
    private C0568c f13302p;

    /* renamed from: q, reason: collision with root package name */
    private C0567b f13303q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f13304r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f13305s = true;

    public C0579f() {
        g();
        C0568c c0568c = new C0568c();
        this.f13302p = c0568c;
        c0568c.f13239e = 2000000.0f;
        c0568c.f13240f = 100.0f;
    }

    private void J() {
        if (e(this.f13293l)) {
            this.f13294m.g(this.f13291j.f13330d);
            C0567b f3 = f(this.f13302p, this.f13301o);
            this.f13303q = f3;
            if (f3 != null) {
                f3.g(this.f13291j.f13330d);
                this.f13301o.k(true);
            }
        }
    }

    private void K() {
        if (k()) {
            l(this.f13303q);
            this.f13301o.k(false);
        }
    }

    private void L(float f3, float f4) {
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("DragBehavior : dragTo : x =:" + f3 + ",y =:" + f4);
        }
        if (this.f13294m != null) {
            this.f13291j.f13330d.d(O(AbstractC0496a.c(f3)), P(AbstractC0496a.c(f4)));
            this.f13294m.g(this.f13291j.f13330d);
            C0567b c0567b = this.f13303q;
            if (c0567b != null) {
                c0567b.g(this.f13291j.f13330d);
            }
        }
    }

    private void S(C0500e c0500e) {
        A(this.f13292k, c0500e);
        C0516a c0516a = this.f13301o;
        if (c0516a != null) {
            A(c0516a, c0500e);
        }
    }

    public void H(float f3, float f4) {
        I(f3, 0.0f, f4, 0.0f);
    }

    public void I(float f3, float f4, float f5, float f6) {
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("DragBehavior : beginDrag : x =:" + f3 + ",y =:" + f4 + ",currentX =:" + f5 + ",currentY =:" + f6);
        }
        this.f13292k.l(f3 - f5, f4 - f6);
        this.f13292k.w(this);
        this.f13292k.f13006e.f();
        C0516a c0516a = this.f13301o;
        if (c0516a != null) {
            c0516a.f13006e.f();
        }
        this.f13291j.f13330d.d(O(AbstractC0496a.c(f3)), P(AbstractC0496a.c(f4)));
        S(this.f13291j.f13330d);
        this.f13304r = true;
        y();
    }

    public void M(float f3) {
        N(f3, 0.0f);
    }

    public void N(float f3, float f4) {
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("DragBehavior : endDrag : xVel =:" + f3 + ",yVel =:" + f4);
        }
        K();
        C0516a c0516a = this.f13301o;
        if (c0516a != null) {
            C0500e c0500e = c0516a.f13006e;
            float f5 = c0500e.f12799a;
            f3 = f5 == 0.0f ? 0.0f : (f5 / AbstractC0499d.a(f5)) * AbstractC0499d.a(f3);
            float f6 = c0500e.f12800b;
            f4 = f6 == 0.0f ? 0.0f : AbstractC0499d.a(f4) * (f6 / AbstractC0499d.a(f6));
        }
        this.f13291j.e(f3, f4);
        this.f13304r = false;
        this.f13292k.a(this);
    }

    protected float O(float f3) {
        RectF rectF;
        if (!this.f13305s && (rectF = this.f13292k.f13010i) != null && (this.f13284c || !rectF.isEmpty())) {
            RectF rectF2 = this.f13292k.f13010i;
            float f4 = rectF2.left;
            if (f3 < f4) {
                return f4;
            }
            float f5 = rectF2.right;
            if (f3 > f5) {
                return f5;
            }
        }
        return f3;
    }

    protected float P(float f3) {
        RectF rectF;
        if (!this.f13305s && (rectF = this.f13292k.f13010i) != null && (this.f13284c || !rectF.isEmpty())) {
            RectF rectF2 = this.f13292k.f13010i;
            float f4 = rectF2.top;
            if (f3 < f4) {
                return f4;
            }
            float f5 = rectF2.bottom;
            if (f3 > f5) {
                return f5;
            }
        }
        return f3;
    }

    public boolean Q() {
        return this.f13304r;
    }

    public void R(float f3) {
        L(f3, 0.0f);
    }

    @Override // s1.AbstractC0576c
    public int q() {
        return 0;
    }

    @Override // s1.AbstractC0576c
    public boolean r() {
        return !this.f13304r;
    }

    @Override // s1.AbstractC0576c
    protected void s(C0516a c0516a) {
        super.s(c0516a);
        C0568c c0568c = this.f13302p;
        if (c0568c != null) {
            c0568c.f13235a = c0516a;
        }
    }

    @Override // s1.AbstractC0576c
    protected void t() {
    }

    @Override // s1.AbstractC0576c
    protected void v() {
        super.v();
        this.f13292k.j(this.f13293l.f13239e);
        if (this.f13302p != null) {
            C0516a d3 = d("SimulateTouch", this.f13301o);
            this.f13301o = d3;
            this.f13302p.f13236b = d3;
        }
    }

    @Override // s1.AbstractC0576c
    void w() {
        super.w();
        C0516a c0516a = this.f13301o;
        if (c0516a != null) {
            j(c0516a);
        }
    }

    @Override // s1.AbstractC0576c
    public AbstractC0576c x(float f3, float f4) {
        C0516a c0516a = this.f13292k;
        if (c0516a != null) {
            c0516a.j(f3);
        }
        return super.x(f3, f4);
    }

    @Override // s1.AbstractC0576c
    protected void y() {
        super.y();
        J();
    }

    @Override // s1.AbstractC0576c
    protected boolean z() {
        K();
        return super.z();
    }
}
