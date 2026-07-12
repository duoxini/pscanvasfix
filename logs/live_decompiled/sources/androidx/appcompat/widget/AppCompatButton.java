package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {

    /* renamed from: e, reason: collision with root package name */
    private final C0231e f3872e;

    /* renamed from: f, reason: collision with root package name */
    private final C0250y f3873f;

    /* renamed from: g, reason: collision with root package name */
    private C0238l f3874g;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11099n);
    }

    private C0238l getEmojiTextViewHelper() {
        if (this.f3874g == null) {
            this.f3874g = new C0238l(this);
        }
        return this.f3874g;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            c0231e.b();
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b0.f4200b) {
            return super.getAutoSizeMaxTextSize();
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            return c0250y.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b0.f4200b) {
            return super.getAutoSizeMinTextSize();
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            return c0250y.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b0.f4200b) {
            return super.getAutoSizeStepGranularity();
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            return c0250y.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b0.f4200b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0250y c0250y = this.f3873f;
        return c0250y != null ? c0250y.h() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b0.f4200b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            return c0250y.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            return c0231e.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            return c0231e.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f3873f.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f3873f.k();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.o(z3, i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        C0250y c0250y = this.f3873f;
        if (c0250y == null || b0.f4200b || !c0250y.l()) {
            return;
        }
        this.f3873f.c();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i4, int i5, int i6) {
        if (b0.f4200b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i3, i4, i5, i6);
            return;
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.t(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        if (b0.f4200b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
            return;
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.u(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (b0.f4200b) {
            super.setAutoSizeTextTypeWithDefaults(i3);
            return;
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.v(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            c0231e.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            c0231e.g(i3);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z3) {
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.s(z3);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            c0231e.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0231e c0231e = this.f3872e;
        if (c0231e != null) {
            c0231e.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f3873f.w(colorStateList);
        this.f3873f.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f3873f.x(mode);
        this.f3873f.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.q(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i3, float f3) {
        if (b0.f4200b) {
            super.setTextSize(i3, f3);
            return;
        }
        C0250y c0250y = this.f3873f;
        if (c0250y != null) {
            c0250y.A(i3, f3);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i3) {
        super(S.b(context), attributeSet, i3);
        Q.a(this, getContext());
        C0231e c0231e = new C0231e(this);
        this.f3872e = c0231e;
        c0231e.e(attributeSet, i3);
        C0250y c0250y = new C0250y(this);
        this.f3873f = c0250y;
        c0250y.m(attributeSet, i3);
        c0250y.b();
        getEmojiTextViewHelper().c(attributeSet, i3);
    }
}
