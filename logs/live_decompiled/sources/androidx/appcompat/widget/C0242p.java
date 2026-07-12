package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import e.AbstractC0339a;
import f.AbstractC0348a;

/* renamed from: androidx.appcompat.widget.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0242p extends MultiAutoCompleteTextView {

    /* renamed from: h, reason: collision with root package name */
    private static final int[] f4282h = {R.attr.popupBackground};

    /* renamed from: e, reason: collision with root package name */
    private final C0231e f4283e;

    /* renamed from: f, reason: collision with root package name */
    private final C0250y f4284f;

    /* renamed from: g, reason: collision with root package name */
    private final C0237k f4285g;

    public C0242p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11098m);
    }

    void a(C0237k c0237k) {
        KeyListener keyListener = getKeyListener();
        if (c0237k.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a3 = c0237k.a(keyListener);
            if (a3 == keyListener) {
                return;
            }
            super.setKeyListener(a3);
            super.setRawInputType(inputType);
            super.setFocusable(isFocusable);
            super.setClickable(isClickable);
            super.setLongClickable(isLongClickable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            c0231e.b();
        }
        C0250y c0250y = this.f4284f;
        if (c0250y != null) {
            c0250y.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f4284f.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f4284f.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f4285g.d(AbstractC0239m.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f4284f;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f4284f;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i3) {
        setDropDownBackgroundDrawable(AbstractC0348a.b(getContext(), i3));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f4285g.e(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f4285g.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f4283e;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f4284f.w(colorStateList);
        this.f4284f.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f4284f.x(mode);
        this.f4284f.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C0250y c0250y = this.f4284f;
        if (c0250y != null) {
            c0250y.q(context, i3);
        }
    }

    public C0242p(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        Q.a(this, getContext());
        V w3 = V.w(getContext(), attributeSet, f4282h, i3, 0);
        if (w3.s(0)) {
            setDropDownBackgroundDrawable(w3.g(0));
        }
        w3.x();
        C0231e c0231e = new C0231e(this);
        this.f4283e = c0231e;
        c0231e.e(attributeSet, i3);
        C0250y c0250y = new C0250y(this);
        this.f4284f = c0250y;
        c0250y.m(attributeSet, i3);
        c0250y.b();
        C0237k c0237k = new C0237k(this);
        this.f4285g = c0237k;
        c0237k.c(attributeSet, i3);
        a(c0237k);
    }
}
