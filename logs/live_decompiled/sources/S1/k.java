package s1;

import p1.C0500e;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public float f13327a;

    /* renamed from: b, reason: collision with root package name */
    public float f13328b;

    /* renamed from: c, reason: collision with root package name */
    Object f13329c;

    /* renamed from: d, reason: collision with root package name */
    public final C0500e f13330d;

    /* renamed from: e, reason: collision with root package name */
    public final C0500e f13331e;

    /* renamed from: f, reason: collision with root package name */
    public final C0500e f13332f;

    /* renamed from: g, reason: collision with root package name */
    public final C0500e f13333g;

    /* renamed from: h, reason: collision with root package name */
    final j f13334h;

    public k() {
        this(null);
    }

    public j a() {
        return this.f13334h;
    }

    public k b(float f3, float f4) {
        this.f13327a = f3;
        this.f13328b = f4;
        return this;
    }

    public k c(float f3, float f4) {
        this.f13331e.d(f3, f4);
        return this;
    }

    public k d(float f3, float f4) {
        this.f13332f.d(f3, f4);
        return this;
    }

    public void e(float f3, float f4) {
        this.f13333g.d(f3, f4);
    }

    public void f(float f3, float f4) {
        j jVar = this.f13334h;
        jVar.f13323a = f3;
        jVar.f13324b = f4;
    }

    public String toString() {
        return "UIItem{mTarget=" + this.f13329c + ", size=( " + this.f13327a + "," + this.f13328b + "), startPos =:" + this.f13331e + ", startVel =:" + this.f13333g + ", mMoveTarget =:" + this.f13330d + ", mStartScale =:" + this.f13332f + ", mStartVelocity =:" + this.f13333g + ", mTransform =:" + this.f13334h + "}@" + hashCode();
    }

    public k(Object obj) {
        this.f13327a = 0.0f;
        this.f13328b = 0.0f;
        this.f13330d = new C0500e();
        this.f13331e = new C0500e();
        this.f13332f = new C0500e(1.0f, 1.0f);
        this.f13333g = new C0500e();
        this.f13334h = new j();
        this.f13329c = obj;
    }
}
