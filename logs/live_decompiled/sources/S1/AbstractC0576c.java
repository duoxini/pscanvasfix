package s1;

import java.util.HashMap;
import p1.AbstractC0496a;
import p1.AbstractC0497b;
import p1.AbstractC0499d;
import p1.C0500e;
import q1.C0516a;
import r1.C0567b;
import r1.C0568c;

/* renamed from: s1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0576c {

    /* renamed from: f, reason: collision with root package name */
    protected HashMap f13287f;

    /* renamed from: h, reason: collision with root package name */
    protected Runnable f13289h;

    /* renamed from: i, reason: collision with root package name */
    protected Runnable f13290i;

    /* renamed from: j, reason: collision with root package name */
    protected k f13291j;

    /* renamed from: k, reason: collision with root package name */
    protected C0516a f13292k;

    /* renamed from: l, reason: collision with root package name */
    protected C0568c f13293l;

    /* renamed from: n, reason: collision with root package name */
    protected Object f13295n;

    /* renamed from: a, reason: collision with root package name */
    protected float f13282a = 1.0f;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f13283b = false;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f13284c = false;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f13285d = false;

    /* renamed from: e, reason: collision with root package name */
    protected AbstractC0580g f13286e = null;

    /* renamed from: g, reason: collision with root package name */
    protected i f13288g = null;

    /* renamed from: m, reason: collision with root package name */
    protected C0567b f13294m = null;

    protected AbstractC0576c() {
        u();
    }

    private void C(k kVar, AbstractC0580g abstractC0580g) {
        abstractC0580g.e(kVar);
    }

    private void F() {
        i iVar = this.f13288g;
        if (iVar != null && this.f13292k == null) {
            k n3 = iVar.n(this.f13295n);
            this.f13291j = n3;
            i iVar2 = this.f13288g;
            AbstractC0580g abstractC0580g = this.f13286e;
            this.f13292k = iVar2.m(n3, abstractC0580g != null ? abstractC0580g.f13306a : 1);
            v();
            if (AbstractC0497b.b()) {
                AbstractC0497b.c("verifyBodyProperty : mActiveUIItem =:" + this.f13291j + ",mPropertyBody =:" + this.f13292k + ",this =:" + this);
            }
        }
    }

    private void a(AbstractC0580g abstractC0580g) {
        if (this.f13287f == null) {
            this.f13287f = new HashMap(1);
        }
        if (this.f13286e == null) {
            this.f13286e = abstractC0580g;
            F();
        }
        this.f13287f.put(abstractC0580g.f13307b, abstractC0580g);
        this.f13282a = AbstractC0499d.b(this.f13282a, abstractC0580g.f13308c);
    }

    private C0516a i(C0500e c0500e, int i3, int i4, float f3, float f4, String str) {
        return this.f13288g.f(c0500e, i3, i4, f3, f4, str);
    }

    protected void A(C0516a c0516a, C0500e c0500e) {
        c0516a.p(c0500e);
    }

    void B() {
        HashMap hashMap = this.f13287f;
        if (hashMap == null) {
            return;
        }
        for (AbstractC0580g abstractC0580g : hashMap.values()) {
            if (abstractC0580g != null) {
                C(this.f13291j, abstractC0580g);
            }
        }
    }

    protected void D() {
        HashMap hashMap = this.f13287f;
        if (hashMap == null) {
            k kVar = this.f13291j;
            kVar.c(kVar.a().f13323a, this.f13291j.a().f13324b);
            return;
        }
        for (AbstractC0580g abstractC0580g : hashMap.values()) {
            if (abstractC0580g != null) {
                abstractC0580g.f(this.f13291j);
            }
        }
    }

    protected void E() {
        if (this.f13285d) {
            this.f13285d = false;
            this.f13292k.c().d(AbstractC0496a.c(this.f13291j.f13333g.f12799a), AbstractC0496a.c(this.f13291j.f13333g.f12800b));
        }
    }

    public AbstractC0576c G(AbstractC0580g... abstractC0580gArr) {
        for (AbstractC0580g abstractC0580g : abstractC0580gArr) {
            a(abstractC0580g);
        }
        return this;
    }

    public AbstractC0576c b(Object obj) {
        this.f13295n = obj;
        F();
        return this;
    }

    AbstractC0576c c(i iVar) {
        this.f13288g = iVar;
        F();
        s(this.f13288g.l());
        return this;
    }

    protected C0516a d(String str, C0516a c0516a) {
        if (c0516a == null) {
            C0516a c0516a2 = this.f13292k;
            C0500e c0500e = c0516a2.f13002a;
            int g3 = c0516a2.g();
            int f3 = this.f13292k.f();
            C0516a c0516a3 = this.f13292k;
            c0516a = i(c0500e, g3, f3, c0516a3.f13016o, c0516a3.f13017p, str);
        } else {
            C0516a c0516a4 = this.f13292k;
            c0516a.r(c0516a4.f13016o, c0516a4.f13017p);
        }
        c0516a.n(this.f13292k.c());
        c0516a.k(false);
        return c0516a;
    }

    protected boolean e(C0568c c0568c) {
        if (this.f13283b) {
            return false;
        }
        C0567b f3 = f(c0568c, this.f13292k);
        this.f13294m = f3;
        if (f3 == null) {
            return false;
        }
        this.f13283b = true;
        return true;
    }

    protected C0567b f(C0568c c0568c, C0516a c0516a) {
        if (c0568c == null || c0516a == null) {
            return null;
        }
        c0568c.f13237c.e(c0516a.h());
        return this.f13288g.g(c0568c);
    }

    protected void g() {
        h(4.0f, 0.2f);
    }

    protected void h(float f3, float f4) {
        C0568c c0568c = new C0568c();
        this.f13293l = c0568c;
        c0568c.f13239e = 4.0f;
        c0568c.f13240f = 0.2f;
    }

    protected boolean j(C0516a c0516a) {
        return this.f13288g.j(c0516a);
    }

    protected boolean k() {
        if (!this.f13283b) {
            return false;
        }
        l(this.f13294m);
        this.f13294m = null;
        this.f13283b = false;
        return true;
    }

    protected void l(C0567b c0567b) {
        this.f13288g.k(c0567b);
    }

    void m() {
        this.f13291j.f(AbstractC0496a.b(this.f13292k.e().f12799a - this.f13292k.b().f12799a), AbstractC0496a.b(this.f13292k.e().f12800b - this.f13292k.b().f12800b));
    }

    public Object n() {
        AbstractC0580g abstractC0580g = this.f13286e;
        if (abstractC0580g != null) {
            return Float.valueOf(o(this.f13291j, abstractC0580g));
        }
        if (p() != null) {
            return Float.valueOf(p().f13323a);
        }
        return null;
    }

    protected float o(Object obj, AbstractC0580g abstractC0580g) {
        return abstractC0580g.a(obj);
    }

    public j p() {
        k kVar = this.f13291j;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    public abstract int q();

    public abstract boolean r();

    protected void s(C0516a c0516a) {
        C0568c c0568c = this.f13293l;
        if (c0568c != null) {
            c0568c.f13235a = c0516a;
            c0516a.k(true);
        }
    }

    protected abstract void t();

    public String toString() {
        return "BaseBehavior{type=" + q() + ", mFirstProperty=" + this.f13286e + ", mValueThreshold=" + this.f13282a + ", mTarget=" + this.f13295n + ", mPropertyBody=" + this.f13292k + ", mActiveUIItem=" + this.f13291j + ", mSpring=" + this.f13294m + ", mSpringDef=" + this.f13293l + ", mIsSpringApplied=" + this.f13283b + ", mIsStarted=" + this.f13284c + ", mHasCustomStartVelocity=" + this.f13285d + "}@" + hashCode();
    }

    protected void u() {
    }

    protected void v() {
        C0568c c0568c = this.f13293l;
        if (c0568c != null) {
            c0568c.f13236b = this.f13292k;
        }
    }

    void w() {
        if (AbstractC0497b.b()) {
            AbstractC0497b.c("onRemove mIsStarted =:" + this.f13284c + ",this =:" + this);
        }
        this.f13290i = null;
        z();
    }

    public AbstractC0576c x(float f3, float f4) {
        C0568c c0568c = this.f13293l;
        if (c0568c != null) {
            c0568c.f13239e = f3;
            c0568c.f13240f = f4;
            C0567b c0567b = this.f13294m;
            if (c0567b != null) {
                c0567b.f(f3);
                this.f13294m.e(f4);
            }
        }
        return this;
    }

    protected void y() {
        if (this.f13284c) {
            return;
        }
        E();
        D();
        t();
        m();
        this.f13288g.A(this);
        this.f13288g.w(this);
        this.f13284c = true;
        Runnable runnable = this.f13289h;
        if (runnable != null) {
            runnable.run();
        }
    }

    protected boolean z() {
        if (!this.f13284c) {
            return false;
        }
        if (q() != 0) {
            this.f13291j.f13333g.f();
        }
        this.f13288g.y(this);
        this.f13284c = false;
        Runnable runnable = this.f13290i;
        if (runnable == null) {
            return true;
        }
        runnable.run();
        return true;
    }
}
