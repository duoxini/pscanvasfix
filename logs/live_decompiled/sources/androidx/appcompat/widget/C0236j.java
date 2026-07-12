package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import e.AbstractC0339a;

/* renamed from: androidx.appcompat.widget.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0236j extends EditText implements androidx.core.view.u {

    /* renamed from: e, reason: collision with root package name */
    private final C0231e f4266e;

    /* renamed from: f, reason: collision with root package name */
    private final C0250y f4267f;

    /* renamed from: g, reason: collision with root package name */
    private final C0249x f4268g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.core.widget.j f4269h;

    /* renamed from: i, reason: collision with root package name */
    private final C0237k f4270i;

    /* renamed from: j, reason: collision with root package name */
    private a f4271j;

    /* renamed from: androidx.appcompat.widget.j$a */
    class a {
        a() {
        }

        public TextClassifier a() {
            return C0236j.super.getTextClassifier();
        }

        public void b(TextClassifier textClassifier) {
            C0236j.super.setTextClassifier(textClassifier);
        }
    }

    public C0236j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11110y);
    }

    private a getSuperCaller() {
        if (this.f4271j == null) {
            this.f4271j = new a();
        }
        return this.f4271j;
    }

    void c(C0237k c0237k) {
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
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            c0231e.b();
        }
        C0250y c0250y = this.f4267f;
        if (c0250y != null) {
            c0250y.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f4267f.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f4267f.k();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        return getSuperCaller().a();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f4267f.r(this, onCreateInputConnection, editorInfo);
        return this.f4270i.d(AbstractC0239m.a(onCreateInputConnection, editorInfo, this), editorInfo);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        if (AbstractC0245t.a(this, dragEvent)) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        if (AbstractC0245t.b(this, i3)) {
            return true;
        }
        return super.onTextContextMenuItem(i3);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f4267f;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0250y c0250y = this.f4267f;
        if (c0250y != null) {
            c0250y.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        this.f4270i.e(z3);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f4270i.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f4266e;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f4267f.w(colorStateList);
        this.f4267f.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f4267f.x(mode);
        this.f4267f.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C0250y c0250y = this.f4267f;
        if (c0250y != null) {
            c0250y.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        getSuperCaller().b(textClassifier);
    }

    public C0236j(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        Q.a(this, getContext());
        C0231e c0231e = new C0231e(this);
        this.f4266e = c0231e;
        c0231e.e(attributeSet, i3);
        C0250y c0250y = new C0250y(this);
        this.f4267f = c0250y;
        c0250y.m(attributeSet, i3);
        c0250y.b();
        this.f4268g = new C0249x(this);
        this.f4269h = new androidx.core.widget.j();
        C0237k c0237k = new C0237k(this);
        this.f4270i = c0237k;
        c0237k.c(attributeSet, i3);
        c(c0237k);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return super.getText();
    }
}
