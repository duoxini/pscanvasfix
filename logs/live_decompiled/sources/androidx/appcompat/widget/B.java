package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: classes.dex */
public class B extends ToggleButton {

    /* renamed from: e, reason: collision with root package name */
    private final C0231e f3886e;

    /* renamed from: f, reason: collision with root package name */
    private final C0250y f3887f;

    /* renamed from: g, reason: collision with root package name */
    private C0238l f3888g;

    public B(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyleToggle);
    }

    private C0238l getEmojiTextViewHelper() {
        if (this.f3888g == null) {
            this.f3888g = new C0238l(this);
        }
        return this.f3888g;
    }

    @Override // android.widget.ToggleButton, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            c0231e.b();
        }
        C0250y c0250y = this.f3887f;
        if (c0250y != null) {
            c0250y.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3887f.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3887f.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.ToggleButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f3887f;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f3887f;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f3886e;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3887f.w(colorStateList);
        this.f3887f.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3887f.x(mode);
        this.f3887f.b();
    }

    public B(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Q.a(this, getContext());
        C0231e c0231e = new C0231e(this);
        this.f3886e = c0231e;
        c0231e.e(attributeSet, i3);
        C0250y c0250y = new C0250y(this);
        this.f3887f = c0250y;
        c0250y.m(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }
}
