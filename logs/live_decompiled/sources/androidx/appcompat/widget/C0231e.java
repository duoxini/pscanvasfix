package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: androidx.appcompat.widget.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0231e {

    /* renamed from: a, reason: collision with root package name */
    private final View f4235a;

    /* renamed from: d, reason: collision with root package name */
    private T f4238d;

    /* renamed from: e, reason: collision with root package name */
    private T f4239e;

    /* renamed from: f, reason: collision with root package name */
    private T f4240f;

    /* renamed from: c, reason: collision with root package name */
    private int f4237c = -1;

    /* renamed from: b, reason: collision with root package name */
    private final C0235i f4236b = C0235i.b();

    C0231e(View view) {
        this.f4235a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f4240f == null) {
            this.f4240f = new T();
        }
        T t3 = this.f4240f;
        t3.a();
        ColorStateList p3 = androidx.core.view.y.p(this.f4235a);
        if (p3 != null) {
            t3.f4143d = true;
            t3.f4140a = p3;
        }
        PorterDuff.Mode q3 = androidx.core.view.y.q(this.f4235a);
        if (q3 != null) {
            t3.f4142c = true;
            t3.f4141b = q3;
        }
        if (!t3.f4143d && !t3.f4142c) {
            return false;
        }
        C0235i.i(drawable, t3, this.f4235a.getDrawableState());
        return true;
    }

    private boolean k() {
        return this.f4238d != null;
    }

    void b() {
        Drawable background = this.f4235a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            T t3 = this.f4239e;
            if (t3 != null) {
                C0235i.i(background, t3, this.f4235a.getDrawableState());
                return;
            }
            T t4 = this.f4238d;
            if (t4 != null) {
                C0235i.i(background, t4, this.f4235a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        T t3 = this.f4239e;
        if (t3 != null) {
            return t3.f4140a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        T t3 = this.f4239e;
        if (t3 != null) {
            return t3.f4141b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i3) {
        V w3 = V.w(this.f4235a.getContext(), attributeSet, e.j.L3, i3, 0);
        View view = this.f4235a;
        androidx.core.view.y.h0(view, view.getContext(), e.j.L3, attributeSet, w3.r(), i3, 0);
        try {
            if (w3.s(e.j.M3)) {
                this.f4237c = w3.n(e.j.M3, -1);
                ColorStateList f3 = this.f4236b.f(this.f4235a.getContext(), this.f4237c);
                if (f3 != null) {
                    h(f3);
                }
            }
            if (w3.s(e.j.N3)) {
                androidx.core.view.y.o0(this.f4235a, w3.c(e.j.N3));
            }
            if (w3.s(e.j.O3)) {
                androidx.core.view.y.p0(this.f4235a, E.d(w3.k(e.j.O3, -1), null));
            }
            w3.x();
        } catch (Throwable th) {
            w3.x();
            throw th;
        }
    }

    void f(Drawable drawable) {
        this.f4237c = -1;
        h(null);
        b();
    }

    void g(int i3) {
        this.f4237c = i3;
        C0235i c0235i = this.f4236b;
        h(c0235i != null ? c0235i.f(this.f4235a.getContext(), i3) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f4238d == null) {
                this.f4238d = new T();
            }
            T t3 = this.f4238d;
            t3.f4140a = colorStateList;
            t3.f4143d = true;
        } else {
            this.f4238d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f4239e == null) {
            this.f4239e = new T();
        }
        T t3 = this.f4239e;
        t3.f4140a = colorStateList;
        t3.f4143d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f4239e == null) {
            this.f4239e = new T();
        }
        T t3 = this.f4239e;
        t3.f4141b = mode;
        t3.f4142c = true;
        b();
    }
}
