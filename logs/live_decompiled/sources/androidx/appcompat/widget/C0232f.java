package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import e.AbstractC0339a;
import f.AbstractC0348a;

/* renamed from: androidx.appcompat.widget.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0232f extends CheckedTextView {

    /* renamed from: e, reason: collision with root package name */
    private final C0233g f4241e;

    /* renamed from: f, reason: collision with root package name */
    private final C0231e f4242f;

    /* renamed from: g, reason: collision with root package name */
    private final C0250y f4243g;

    /* renamed from: h, reason: collision with root package name */
    private C0238l f4244h;

    public C0232f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11101p);
    }

    private C0238l getEmojiTextViewHelper() {
        if (this.f4244h == null) {
            this.f4244h = new C0238l(this);
        }
        return this.f4244h;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0250y c0250y = this.f4243g;
        if (c0250y != null) {
            c0250y.b();
        }
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            c0231e.b();
        }
        C0233g c0233g = this.f4241e;
        if (c0233g != null) {
            c0233g.a();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        C0233g c0233g = this.f4241e;
        if (c0233g != null) {
            return c0233g.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        C0233g c0233g = this.f4241e;
        if (c0233g != null) {
            return c0233g.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f4243g.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f4243g.k();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AbstractC0239m.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        C0233g c0233g = this.f4241e;
        if (c0233g != null) {
            c0233g.e();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f4243g;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f4243g;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f4242f;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        C0233g c0233g = this.f4241e;
        if (c0233g != null) {
            c0233g.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        C0233g c0233g = this.f4241e;
        if (c0233g != null) {
            c0233g.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f4243g.w(colorStateList);
        this.f4243g.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f4243g.x(mode);
        this.f4243g.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C0250y c0250y = this.f4243g;
        if (c0250y != null) {
            c0250y.q(context, i3);
        }
    }

    public C0232f(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        Q.a(this, getContext());
        C0250y c0250y = new C0250y(this);
        this.f4243g = c0250y;
        c0250y.m(attributeSet, i3);
        c0250y.b();
        C0231e c0231e = new C0231e(this);
        this.f4242f = c0231e;
        c0231e.e(attributeSet, i3);
        C0233g c0233g = new C0233g(this);
        this.f4241e = c0233g;
        c0233g.d(attributeSet, i3);
        getEmojiTextViewHelper().c(attributeSet, i3);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i3) {
        setCheckMarkDrawable(AbstractC0348a.b(getContext(), i3));
    }
}
