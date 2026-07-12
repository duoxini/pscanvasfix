package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import e.AbstractC0339a;
import f.AbstractC0348a;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton {

    /* renamed from: e, reason: collision with root package name */
    private final C0234h f3882e;

    /* renamed from: f, reason: collision with root package name */
    private final C0231e f3883f;

    /* renamed from: g, reason: collision with root package name */
    private final C0250y f3884g;

    /* renamed from: h, reason: collision with root package name */
    private C0238l f3885h;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11077F);
    }

    private C0238l getEmojiTextViewHelper() {
        if (this.f3885h == null) {
            this.f3885h = new C0238l(this);
        }
        return this.f3885h;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            c0231e.b();
        }
        C0250y c0250y = this.f3884g;
        if (c0250y != null) {
            c0250y.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0234h c0234h = this.f3882e;
        return c0234h != null ? c0234h.b(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        C0234h c0234h = this.f3882e;
        if (c0234h != null) {
            return c0234h.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0234h c0234h = this.f3882e;
        if (c0234h != null) {
            return c0234h.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3884g.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3884g.k();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0234h c0234h = this.f3882e;
        if (c0234h != null) {
            c0234h.f();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f3884g;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f3884g;
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
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f3883f;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0234h c0234h = this.f3882e;
        if (c0234h != null) {
            c0234h.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0234h c0234h = this.f3882e;
        if (c0234h != null) {
            c0234h.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3884g.w(colorStateList);
        this.f3884g.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3884g.x(mode);
        this.f3884g.b();
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        Q.a(this, getContext());
        C0234h c0234h = new C0234h(this);
        this.f3882e = c0234h;
        c0234h.e(attributeSet, i3);
        C0231e c0231e = new C0231e(this);
        this.f3883f = c0231e;
        c0231e.e(attributeSet, i3);
        C0250y c0250y = new C0250y(this);
        this.f3884g = c0250y;
        c0250y.m(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(AbstractC0348a.b(getContext(), i3));
    }
}
