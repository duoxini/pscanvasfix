package r0;

import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;

/* loaded from: classes.dex */
public abstract class h extends RippleDrawable implements InterfaceC0564f, InterfaceC0565g {

    /* renamed from: e, reason: collision with root package name */
    protected final C0563e f13196e;

    public h(String str) {
        super(ColorStateList.valueOf(0), null, null);
        this.f13196e = new C0563e(str, this);
    }

    public void a(int i3, boolean z3, boolean z4, boolean z5) {
        this.f13196e.a(i3, z3, z4, z5);
    }

    @Override // r0.InterfaceC0564f
    public final void b() {
        this.f13196e.b();
    }

    @Override // r0.InterfaceC0564f
    public final void c() {
        this.f13196e.c();
    }

    @Override // r0.InterfaceC0564f
    public final void e() {
        this.f13196e.e();
    }

    @Override // r0.InterfaceC0564f
    public final void f() {
        this.f13196e.f();
    }

    @Override // r0.InterfaceC0564f
    public final void g() {
        this.f13196e.g();
    }

    @Override // r0.InterfaceC0564f
    public final void h() {
        this.f13196e.h();
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.f13196e.u();
    }

    public boolean k() {
        return this.f13196e.m();
    }

    public final boolean l() {
        return this.f13196e.n();
    }

    public final boolean m() {
        return this.f13196e.o();
    }

    public final boolean n() {
        return this.f13196e.p();
    }

    public final boolean o() {
        return this.f13196e.r();
    }

    public boolean p(int i3) {
        return this.f13196e.t(i3);
    }

    public void q(boolean z3) {
        this.f13196e.y(z3);
    }
}
