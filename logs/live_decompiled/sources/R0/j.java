package r0;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class j extends Drawable implements InterfaceC0564f, InterfaceC0565g {

    /* renamed from: e, reason: collision with root package name */
    private final C0563e f13211e;

    public j(String str) {
        this.f13211e = new C0563e(str, this);
    }

    public void a(int i3, boolean z3, boolean z4, boolean z5) {
        this.f13211e.a(i3, z3, z4, z5);
    }

    @Override // r0.InterfaceC0564f
    public final void b() {
        this.f13211e.b();
    }

    @Override // r0.InterfaceC0564f
    public final void c() {
        this.f13211e.c();
    }

    public void e() {
        this.f13211e.e();
    }

    public void f() {
        this.f13211e.f();
    }

    @Override // r0.InterfaceC0564f
    public final void g() {
        this.f13211e.g();
    }

    @Override // r0.InterfaceC0564f
    public final void h() {
        this.f13211e.h();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f13211e.u();
    }

    public final int k() {
        return this.f13211e.k();
    }

    public boolean l() {
        return this.f13211e.m();
    }

    public final boolean m() {
        return this.f13211e.n();
    }

    public final boolean n() {
        return this.f13211e.o();
    }

    public final boolean o() {
        return this.f13211e.p();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        this.f13211e.x(iArr);
        return super.onStateChange(iArr);
    }

    public final boolean p() {
        return this.f13211e.s();
    }

    public boolean q(int i3) {
        return this.f13211e.t(i3);
    }

    public final boolean r() {
        return this.f13211e.v();
    }

    public void s(boolean z3) {
        this.f13211e.y(z3);
    }

    public void t() {
        this.f13211e.z();
    }

    public void u() {
        this.f13211e.A();
    }
}
