package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import f.AbstractC0348a;

/* renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0241o {

    /* renamed from: a, reason: collision with root package name */
    private final ImageView f4277a;

    /* renamed from: b, reason: collision with root package name */
    private T f4278b;

    /* renamed from: c, reason: collision with root package name */
    private T f4279c;

    /* renamed from: d, reason: collision with root package name */
    private T f4280d;

    /* renamed from: e, reason: collision with root package name */
    private int f4281e = 0;

    public C0241o(ImageView imageView) {
        this.f4277a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f4280d == null) {
            this.f4280d = new T();
        }
        T t3 = this.f4280d;
        t3.a();
        ColorStateList a3 = androidx.core.widget.e.a(this.f4277a);
        if (a3 != null) {
            t3.f4143d = true;
            t3.f4140a = a3;
        }
        PorterDuff.Mode b3 = androidx.core.widget.e.b(this.f4277a);
        if (b3 != null) {
            t3.f4142c = true;
            t3.f4141b = b3;
        }
        if (!t3.f4143d && !t3.f4142c) {
            return false;
        }
        C0235i.i(drawable, t3, this.f4277a.getDrawableState());
        return true;
    }

    private boolean l() {
        return this.f4278b != null;
    }

    void b() {
        if (this.f4277a.getDrawable() != null) {
            this.f4277a.getDrawable().setLevel(this.f4281e);
        }
    }

    void c() {
        Drawable drawable = this.f4277a.getDrawable();
        if (drawable != null) {
            E.b(drawable);
        }
        if (drawable != null) {
            if (l() && a(drawable)) {
                return;
            }
            T t3 = this.f4279c;
            if (t3 != null) {
                C0235i.i(drawable, t3, this.f4277a.getDrawableState());
                return;
            }
            T t4 = this.f4278b;
            if (t4 != null) {
                C0235i.i(drawable, t4, this.f4277a.getDrawableState());
            }
        }
    }

    ColorStateList d() {
        T t3 = this.f4279c;
        if (t3 != null) {
            return t3.f4140a;
        }
        return null;
    }

    PorterDuff.Mode e() {
        T t3 = this.f4279c;
        if (t3 != null) {
            return t3.f4141b;
        }
        return null;
    }

    boolean f() {
        return !(this.f4277a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i3) {
        int n3;
        V w3 = V.w(this.f4277a.getContext(), attributeSet, e.j.f11314P, i3, 0);
        ImageView imageView = this.f4277a;
        androidx.core.view.y.h0(imageView, imageView.getContext(), e.j.f11314P, attributeSet, w3.r(), i3, 0);
        try {
            Drawable drawable = this.f4277a.getDrawable();
            if (drawable == null && (n3 = w3.n(e.j.f11318Q, -1)) != -1 && (drawable = AbstractC0348a.b(this.f4277a.getContext(), n3)) != null) {
                this.f4277a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                E.b(drawable);
            }
            if (w3.s(e.j.f11322R)) {
                androidx.core.widget.e.c(this.f4277a, w3.c(e.j.f11322R));
            }
            if (w3.s(e.j.f11326S)) {
                androidx.core.widget.e.d(this.f4277a, E.d(w3.k(e.j.f11326S, -1), null));
            }
            w3.x();
        } catch (Throwable th) {
            w3.x();
            throw th;
        }
    }

    void h(Drawable drawable) {
        this.f4281e = drawable.getLevel();
    }

    public void i(int i3) {
        if (i3 != 0) {
            Drawable b3 = AbstractC0348a.b(this.f4277a.getContext(), i3);
            if (b3 != null) {
                E.b(b3);
            }
            this.f4277a.setImageDrawable(b3);
        } else {
            this.f4277a.setImageDrawable(null);
        }
        c();
    }

    void j(ColorStateList colorStateList) {
        if (this.f4279c == null) {
            this.f4279c = new T();
        }
        T t3 = this.f4279c;
        t3.f4140a = colorStateList;
        t3.f4143d = true;
        c();
    }

    void k(PorterDuff.Mode mode) {
        if (this.f4279c == null) {
            this.f4279c = new T();
        }
        T t3 = this.f4279c;
        t3.f4141b = mode;
        t3.f4142c = true;
        c();
    }
}
