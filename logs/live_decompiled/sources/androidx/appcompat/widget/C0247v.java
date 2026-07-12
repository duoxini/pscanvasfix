package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: androidx.appcompat.widget.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0247v extends r {

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f4293d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f4294e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f4295f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f4296g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4297h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4298i;

    C0247v(SeekBar seekBar) {
        super(seekBar);
        this.f4295f = null;
        this.f4296g = null;
        this.f4297h = false;
        this.f4298i = false;
        this.f4293d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f4294e;
        if (drawable != null) {
            if (this.f4297h || this.f4298i) {
                Drawable l3 = androidx.core.graphics.drawable.a.l(drawable.mutate());
                this.f4294e = l3;
                if (this.f4297h) {
                    androidx.core.graphics.drawable.a.i(l3, this.f4295f);
                }
                if (this.f4298i) {
                    androidx.core.graphics.drawable.a.j(this.f4294e, this.f4296g);
                }
                if (this.f4294e.isStateful()) {
                    this.f4294e.setState(this.f4293d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.r
    void c(AttributeSet attributeSet, int i3) {
        super.c(attributeSet, i3);
        V w3 = V.w(this.f4293d.getContext(), attributeSet, e.j.f11330T, i3, 0);
        SeekBar seekBar = this.f4293d;
        androidx.core.view.y.h0(seekBar, seekBar.getContext(), e.j.f11330T, attributeSet, w3.r(), i3, 0);
        Drawable h3 = w3.h(e.j.f11334U);
        if (h3 != null) {
            this.f4293d.setThumb(h3);
        }
        j(w3.g(e.j.f11338V));
        if (w3.s(e.j.f11346X)) {
            this.f4296g = E.d(w3.k(e.j.f11346X, -1), this.f4296g);
            this.f4298i = true;
        }
        if (w3.s(e.j.f11342W)) {
            this.f4295f = w3.c(e.j.f11342W);
            this.f4297h = true;
        }
        w3.x();
        f();
    }

    void g(Canvas canvas) {
        if (this.f4294e != null) {
            int max = this.f4293d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f4294e.getIntrinsicWidth();
                int intrinsicHeight = this.f4294e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i4 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f4294e.setBounds(-i3, -i4, i3, i4);
                float width = ((this.f4293d.getWidth() - this.f4293d.getPaddingLeft()) - this.f4293d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f4293d.getPaddingLeft(), this.f4293d.getHeight() / 2);
                for (int i5 = 0; i5 <= max; i5++) {
                    this.f4294e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    void h() {
        Drawable drawable = this.f4294e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f4293d.getDrawableState())) {
            this.f4293d.invalidateDrawable(drawable);
        }
    }

    void i() {
        Drawable drawable = this.f4294e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f4294e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4294e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f4293d);
            androidx.core.graphics.drawable.a.g(drawable, androidx.core.view.y.x(this.f4293d));
            if (drawable.isStateful()) {
                drawable.setState(this.f4293d.getDrawableState());
            }
            f();
        }
        this.f4293d.invalidate();
    }
}
