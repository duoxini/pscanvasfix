package com.google.android.material.button;

import H0.i;
import U0.h;
import U0.k;
import U0.n;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.app.p;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.y;
import f.AbstractC0348a;
import java.util.Iterator;
import java.util.LinkedHashSet;
import z.AbstractC0645a;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, n {

    /* renamed from: u, reason: collision with root package name */
    private static final int[] f9450u = {R.attr.state_checkable};

    /* renamed from: v, reason: collision with root package name */
    private static final int[] f9451v = {R.attr.state_checked};

    /* renamed from: w, reason: collision with root package name */
    private static final int f9452w = i.f647l;

    /* renamed from: h, reason: collision with root package name */
    private final com.google.android.material.button.a f9453h;

    /* renamed from: i, reason: collision with root package name */
    private final LinkedHashSet f9454i;

    /* renamed from: j, reason: collision with root package name */
    private a f9455j;

    /* renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f9456k;

    /* renamed from: l, reason: collision with root package name */
    private ColorStateList f9457l;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f9458m;

    /* renamed from: n, reason: collision with root package name */
    private int f9459n;

    /* renamed from: o, reason: collision with root package name */
    private int f9460o;

    /* renamed from: p, reason: collision with root package name */
    private int f9461p;

    /* renamed from: q, reason: collision with root package name */
    private int f9462q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9463r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f9464s;

    /* renamed from: t, reason: collision with root package name */
    private int f9465t;

    interface a {
        void a(MaterialButton materialButton, boolean z3);
    }

    static class b extends AbstractC0645a {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        boolean f9466e;

        class a implements Parcelable.ClassLoaderCreator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i3) {
                return new b[i3];
            }
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(Parcel parcel) {
            this.f9466e = parcel.readInt() == 1;
        }

        @Override // z.AbstractC0645a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f9466e ? 1 : 0);
        }

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f489u);
    }

    private boolean b() {
        int i3 = this.f9465t;
        return i3 == 3 || i3 == 4;
    }

    private boolean c() {
        int i3 = this.f9465t;
        return i3 == 1 || i3 == 2;
    }

    private boolean d() {
        int i3 = this.f9465t;
        return i3 == 16 || i3 == 32;
    }

    private boolean e() {
        return y.x(this) == 1;
    }

    private boolean f() {
        com.google.android.material.button.a aVar = this.f9453h;
        return (aVar == null || aVar.o()) ? false : true;
    }

    private void g() {
        if (c()) {
            androidx.core.widget.i.h(this, this.f9458m, null, null, null);
        } else if (b()) {
            androidx.core.widget.i.h(this, null, null, this.f9458m, null);
        } else if (d()) {
            androidx.core.widget.i.h(this, null, this.f9458m, null, null);
        }
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private void h(boolean z3) {
        Drawable drawable = this.f9458m;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.l(drawable).mutate();
            this.f9458m = mutate;
            androidx.core.graphics.drawable.a.i(mutate, this.f9457l);
            PorterDuff.Mode mode = this.f9456k;
            if (mode != null) {
                androidx.core.graphics.drawable.a.j(this.f9458m, mode);
            }
            int i3 = this.f9459n;
            if (i3 == 0) {
                i3 = this.f9458m.getIntrinsicWidth();
            }
            int i4 = this.f9459n;
            if (i4 == 0) {
                i4 = this.f9458m.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f9458m;
            int i5 = this.f9460o;
            int i6 = this.f9461p;
            drawable2.setBounds(i5, i6, i3 + i5, i4 + i6);
            this.f9458m.setVisible(true, z3);
        }
        if (z3) {
            g();
            return;
        }
        Drawable[] a3 = androidx.core.widget.i.a(this);
        Drawable drawable3 = a3[0];
        Drawable drawable4 = a3[1];
        Drawable drawable5 = a3[2];
        if ((!c() || drawable3 == this.f9458m) && ((!b() || drawable5 == this.f9458m) && (!d() || drawable4 == this.f9458m))) {
            return;
        }
        g();
    }

    private void i(int i3, int i4) {
        if (this.f9458m == null || getLayout() == null) {
            return;
        }
        if (!c() && !b()) {
            if (d()) {
                this.f9460o = 0;
                if (this.f9465t == 16) {
                    this.f9461p = 0;
                    h(false);
                    return;
                }
                int i5 = this.f9459n;
                if (i5 == 0) {
                    i5 = this.f9458m.getIntrinsicHeight();
                }
                int textHeight = (((((i4 - getTextHeight()) - getPaddingTop()) - i5) - this.f9462q) - getPaddingBottom()) / 2;
                if (this.f9461p != textHeight) {
                    this.f9461p = textHeight;
                    h(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f9461p = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i6 = this.f9465t;
        if (i6 == 1 || i6 == 3 || ((i6 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i6 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f9460o = 0;
            h(false);
            return;
        }
        int i7 = this.f9459n;
        if (i7 == 0) {
            i7 = this.f9458m.getIntrinsicWidth();
        }
        int textWidth = ((((i3 - getTextWidth()) - y.B(this)) - i7) - this.f9462q) - y.C(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textWidth /= 2;
        }
        if (e() != (this.f9465t == 4)) {
            textWidth = -textWidth;
        }
        if (this.f9460o != textWidth) {
            this.f9460o = textWidth;
            h(false);
        }
    }

    public boolean a() {
        com.google.android.material.button.a aVar = this.f9453h;
        return aVar != null && aVar.p();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (f()) {
            return this.f9453h.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f9458m;
    }

    public int getIconGravity() {
        return this.f9465t;
    }

    public int getIconPadding() {
        return this.f9462q;
    }

    public int getIconSize() {
        return this.f9459n;
    }

    public ColorStateList getIconTint() {
        return this.f9457l;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f9456k;
    }

    public int getInsetBottom() {
        return this.f9453h.c();
    }

    public int getInsetTop() {
        return this.f9453h.d();
    }

    public ColorStateList getRippleColor() {
        if (f()) {
            return this.f9453h.h();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        if (f()) {
            return this.f9453h.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (f()) {
            return this.f9453h.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (f()) {
            return this.f9453h.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return f() ? this.f9453h.l() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return f() ? this.f9453h.m() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9463r;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (f()) {
            h.f(this, this.f9453h.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (a()) {
            View.mergeDrawableStates(onCreateDrawableState, f9450u);
        }
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f9451v);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.getSuperState());
        setChecked(bVar.f9466e);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f9466e = this.f9463r;
        return bVar;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        super.onTextChanged(charSequence, i3, i4, i5);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f9458m != null) {
            if (this.f9458m.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        if (f()) {
            this.f9453h.r(i3);
        } else {
            super.setBackgroundColor(i3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!f()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f9453h.s();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i3) {
        setBackgroundDrawable(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z3) {
        if (f()) {
            this.f9453h.t(z3);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (a() && isEnabled() && this.f9463r != z3) {
            this.f9463r = z3;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m(this, this.f9463r);
            }
            if (this.f9464s) {
                return;
            }
            this.f9464s = true;
            Iterator it = this.f9454i.iterator();
            if (it.hasNext()) {
                p.a(it.next());
                throw null;
            }
            this.f9464s = false;
        }
    }

    public void setCornerRadius(int i3) {
        if (f()) {
            this.f9453h.u(i3);
        }
    }

    public void setCornerRadiusResource(int i3) {
        if (f()) {
            setCornerRadius(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        if (f()) {
            this.f9453h.f().T(f3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f9458m != drawable) {
            this.f9458m = drawable;
            h(true);
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i3) {
        if (this.f9465t != i3) {
            this.f9465t = i3;
            i(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i3) {
        if (this.f9462q != i3) {
            this.f9462q = i3;
            setCompoundDrawablePadding(i3);
        }
    }

    public void setIconResource(int i3) {
        setIcon(i3 != 0 ? AbstractC0348a.b(getContext(), i3) : null);
    }

    public void setIconSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f9459n != i3) {
            this.f9459n = i3;
            h(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f9457l != colorStateList) {
            this.f9457l = colorStateList;
            h(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f9456k != mode) {
            this.f9456k = mode;
            h(false);
        }
    }

    public void setIconTintResource(int i3) {
        setIconTint(AbstractC0348a.a(getContext(), i3));
    }

    public void setInsetBottom(int i3) {
        this.f9453h.v(i3);
    }

    public void setInsetTop(int i3) {
        this.f9453h.w(i3);
    }

    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    void setOnPressedChangeListenerInternal(a aVar) {
        this.f9455j = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z3) {
        a aVar = this.f9455j;
        if (aVar != null) {
            aVar.a(this, z3);
        }
        super.setPressed(z3);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (f()) {
            this.f9453h.x(colorStateList);
        }
    }

    public void setRippleColorResource(int i3) {
        if (f()) {
            setRippleColor(AbstractC0348a.a(getContext(), i3));
        }
    }

    @Override // U0.n
    public void setShapeAppearanceModel(k kVar) {
        if (!f()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f9453h.y(kVar);
    }

    void setShouldDrawSurfaceColorStroke(boolean z3) {
        if (f()) {
            this.f9453h.z(z3);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (f()) {
            this.f9453h.A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i3) {
        if (f()) {
            setStrokeColor(AbstractC0348a.a(getContext(), i3));
        }
    }

    public void setStrokeWidth(int i3) {
        if (f()) {
            this.f9453h.B(i3);
        }
    }

    public void setStrokeWidthResource(int i3) {
        if (f()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i3));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (f()) {
            this.f9453h.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (f()) {
            this.f9453h.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i3) {
        super.setTextAlignment(i3);
        i(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f9463r);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButton(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = com.google.android.material.button.MaterialButton.f9452w
            android.content.Context r9 = V0.a.c(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f9454i = r9
            r9 = 0
            r8.f9463r = r9
            r8.f9464s = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = H0.j.f704L2
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r1 = H0.j.Y2
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f9462q = r1
            int r1 = H0.j.b3
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.parseTintMode(r1, r2)
            r8.f9456k = r1
            android.content.Context r1 = r8.getContext()
            int r2 = H0.j.a3
            android.content.res.ColorStateList r1 = R0.c.a(r1, r0, r2)
            r8.f9457l = r1
            android.content.Context r1 = r8.getContext()
            int r2 = H0.j.f748W2
            android.graphics.drawable.Drawable r1 = R0.c.d(r1, r0, r2)
            r8.f9458m = r1
            int r1 = H0.j.f752X2
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f9465t = r1
            int r1 = H0.j.Z2
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f9459n = r1
            U0.k$b r10 = U0.k.e(r7, r10, r11, r6)
            U0.k r10 = r10.m()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.f9453h = r11
            r11.q(r0)
            r0.recycle()
            int r10 = r8.f9462q
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f9458m
            if (r10 == 0) goto L84
            r9 = r2
        L84:
            r8.h(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
