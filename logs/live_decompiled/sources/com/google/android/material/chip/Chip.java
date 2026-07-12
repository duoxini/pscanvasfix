package com.google.android.material.chip;

import H0.h;
import H0.i;
import H0.j;
import R0.f;
import U0.k;
import U0.n;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.accessibility.d;
import androidx.core.view.y;
import com.google.android.material.chip.a;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import java.util.List;

/* loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements a.InterfaceC0120a, n, MaterialCheckable<Chip> {

    /* renamed from: A, reason: collision with root package name */
    private static final int f9508A = i.f649n;

    /* renamed from: B, reason: collision with root package name */
    private static final Rect f9509B = new Rect();

    /* renamed from: C, reason: collision with root package name */
    private static final int[] f9510C = {R.attr.state_selected};

    /* renamed from: D, reason: collision with root package name */
    private static final int[] f9511D = {R.attr.state_checkable};

    /* renamed from: i, reason: collision with root package name */
    private com.google.android.material.chip.a f9512i;

    /* renamed from: j, reason: collision with root package name */
    private InsetDrawable f9513j;

    /* renamed from: k, reason: collision with root package name */
    private RippleDrawable f9514k;

    /* renamed from: l, reason: collision with root package name */
    private View.OnClickListener f9515l;

    /* renamed from: m, reason: collision with root package name */
    private MaterialCheckable.OnCheckedChangeListener f9516m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9517n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9518o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f9519p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f9520q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9521r;

    /* renamed from: s, reason: collision with root package name */
    private int f9522s;

    /* renamed from: t, reason: collision with root package name */
    private int f9523t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f9524u;

    /* renamed from: v, reason: collision with root package name */
    private final c f9525v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f9526w;

    /* renamed from: x, reason: collision with root package name */
    private final Rect f9527x;

    /* renamed from: y, reason: collision with root package name */
    private final RectF f9528y;

    /* renamed from: z, reason: collision with root package name */
    private final f f9529z;

    class a extends f {
        a() {
        }

        @Override // R0.f
        public void onFontRetrievalFailed(int i3) {
        }

        @Override // R0.f
        public void onFontRetrieved(Typeface typeface, boolean z3) {
            Chip chip = Chip.this;
            chip.setText(chip.f9512i.H2() ? Chip.this.f9512i.d1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f9512i != null) {
                Chip.this.f9512i.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    private class c extends A.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // A.a
        protected boolean A(int i3, int i4, Bundle bundle) {
            if (i4 != 16) {
                return false;
            }
            if (i3 == 0) {
                return Chip.this.performClick();
            }
            if (i3 == 1) {
                return Chip.this.s();
            }
            return false;
        }

        @Override // A.a
        protected void D(d dVar) {
            dVar.O(Chip.this.q());
            dVar.R(Chip.this.isClickable());
            dVar.Q(Chip.this.getAccessibilityClassName());
            dVar.n0(Chip.this.getText());
        }

        @Override // A.a
        protected void E(int i3, d dVar) {
            if (i3 != 1) {
                dVar.U("");
                dVar.M(Chip.f9509B);
                return;
            }
            CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                dVar.U(closeIconContentDescription);
            } else {
                CharSequence text = Chip.this.getText();
                dVar.U(Chip.this.getContext().getString(h.f627h, TextUtils.isEmpty(text) ? "" : text).trim());
            }
            dVar.M(Chip.this.getCloseIconTouchBoundsInt());
            dVar.b(d.a.f5085i);
            dVar.W(Chip.this.isEnabled());
        }

        @Override // A.a
        protected void F(int i3, boolean z3) {
            if (i3 == 1) {
                Chip.this.f9520q = z3;
                Chip.this.refreshDrawableState();
            }
        }

        @Override // A.a
        protected int q(float f3, float f4) {
            return (Chip.this.m() && Chip.this.getCloseIconTouchBounds().contains(f3, f4)) ? 1 : 0;
        }

        @Override // A.a
        protected void r(List list) {
            list.add(0);
            if (Chip.this.m() && Chip.this.r() && Chip.this.f9515l != null) {
                list.add(1);
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f475g);
    }

    private void A() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        R0.d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f9529z);
        }
    }

    private void B(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f9528y.setEmpty();
        if (m() && this.f9515l != null) {
            this.f9512i.U0(this.f9528y);
        }
        return this.f9528y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f9527x.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f9527x;
    }

    private R0.d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    private void i(com.google.android.material.chip.a aVar) {
        aVar.l2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    private int[] j() {
        ?? isEnabled = isEnabled();
        int i3 = isEnabled;
        if (this.f9520q) {
            i3 = isEnabled + 1;
        }
        int i4 = i3;
        if (this.f9519p) {
            i4 = i3 + 1;
        }
        int i5 = i4;
        if (this.f9518o) {
            i5 = i4 + 1;
        }
        int i6 = i5;
        if (isChecked()) {
            i6 = i5 + 1;
        }
        int[] iArr = new int[i6];
        int i7 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i7 = 1;
        }
        if (this.f9520q) {
            iArr[i7] = 16842908;
            i7++;
        }
        if (this.f9519p) {
            iArr[i7] = 16843623;
            i7++;
        }
        if (this.f9518o) {
            iArr[i7] = 16842919;
            i7++;
        }
        if (isChecked()) {
            iArr[i7] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.f9513j && this.f9512i.getCallback() == null) {
            this.f9512i.setCallback(this.f9513j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        com.google.android.material.chip.a aVar = this.f9512i;
        return (aVar == null || aVar.N0() == null) ? false : true;
    }

    private void n(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, j.f780f0, i3, f9508A, new int[0]);
        this.f9521r = obtainStyledAttributes.getBoolean(j.f702L0, false);
        this.f9523t = (int) Math.ceil(obtainStyledAttributes.getDimension(j.f860z0, (float) Math.ceil(ViewUtils.dpToPx(getContext(), 48))));
        obtainStyledAttributes.recycle();
    }

    private void o() {
        setOutlineProvider(new b());
    }

    private void p(int i3, int i4, int i5, int i6) {
        this.f9513j = new InsetDrawable((Drawable) this.f9512i, i3, i4, i5, i6);
    }

    private void setCloseIconHovered(boolean z3) {
        if (this.f9519p != z3) {
            this.f9519p = z3;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z3) {
        if (this.f9518o != z3) {
            this.f9518o = z3;
            refreshDrawableState();
        }
    }

    private void t() {
        if (this.f9513j != null) {
            this.f9513j = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            x();
        }
    }

    private void v(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.l2(null);
        }
    }

    private void w() {
        if (m() && r() && this.f9515l != null) {
            y.j0(this, this.f9525v);
            this.f9526w = true;
        } else {
            y.j0(this, null);
            this.f9526w = false;
        }
    }

    private void x() {
        if (S0.b.f2070a) {
            y();
            return;
        }
        this.f9512i.G2(true);
        y.n0(this, getBackgroundDrawable());
        z();
        l();
    }

    private void y() {
        this.f9514k = new RippleDrawable(S0.b.a(this.f9512i.b1()), getBackgroundDrawable(), null);
        this.f9512i.G2(false);
        y.n0(this, this.f9514k);
        z();
    }

    private void z() {
        com.google.android.material.chip.a aVar;
        if (TextUtils.isEmpty(getText()) || (aVar = this.f9512i) == null) {
            return;
        }
        int F02 = (int) (aVar.F0() + this.f9512i.f1() + this.f9512i.m0());
        int K02 = (int) (this.f9512i.K0() + this.f9512i.g1() + this.f9512i.i0());
        if (this.f9513j != null) {
            Rect rect = new Rect();
            this.f9513j.getPadding(rect);
            K02 += rect.left;
            F02 += rect.right;
        }
        y.y0(this, K02, getPaddingTop(), F02, getPaddingBottom());
    }

    @Override // com.google.android.material.chip.a.InterfaceC0120a
    public void a() {
        k(this.f9523t);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f9526w ? super.dispatchHoverEvent(motionEvent) : this.f9525v.k(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f9526w) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f9525v.l(keyEvent) || this.f9525v.p() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f9512i;
        if ((aVar == null || !aVar.l1()) ? false : this.f9512i.h2(j())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f9524u)) {
            return this.f9524u;
        }
        if (!q()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).d()) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f9513j;
        return insetDrawable == null ? this.f9512i : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.B0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.C0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.D0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return Math.max(0.0f, aVar.E0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f9512i;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.F0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.G0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.H0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.I0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.J0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.K0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.L0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.O0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.P0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.T0();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.X0();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f9526w && (this.f9525v.p() == 1 || this.f9525v.m() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public I0.c getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.Y0();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.Z0();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.a1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.b1();
        }
        return null;
    }

    public k getShapeAppearanceModel() {
        return this.f9512i.B();
    }

    public I0.c getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.c1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.f1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            return aVar.g1();
        }
        return 0.0f;
    }

    public boolean k(int i3) {
        this.f9523t = i3;
        if (!u()) {
            if (this.f9513j != null) {
                t();
            } else {
                x();
            }
            return false;
        }
        int max = Math.max(0, i3 - this.f9512i.getIntrinsicHeight());
        int max2 = Math.max(0, i3 - this.f9512i.getIntrinsicWidth());
        if (max2 <= 0 && max <= 0) {
            if (this.f9513j != null) {
                t();
            } else {
                x();
            }
            return false;
        }
        int i4 = max2 > 0 ? max2 / 2 : 0;
        int i5 = max > 0 ? max / 2 : 0;
        if (this.f9513j != null) {
            Rect rect = new Rect();
            this.f9513j.getPadding(rect);
            if (rect.top == i5 && rect.bottom == i5 && rect.left == i4 && rect.right == i4) {
                x();
                return true;
            }
        }
        if (getMinHeight() != i3) {
            setMinHeight(i3);
        }
        if (getMinWidth() != i3) {
            setMinWidth(i3);
        }
        p(i4, i5, i4, i5);
        x();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        U0.h.f(this, this.f9512i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f9510C);
        }
        if (q()) {
            View.mergeDrawableStates(onCreateDrawableState, f9511D);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z3, int i3, Rect rect) {
        super.onFocusChanged(z3, i3, rect);
        if (this.f9526w) {
            this.f9525v.z(z3, i3, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(q());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            d.r0(accessibilityNodeInfo).T(d.c.a(chipGroup.getRowIndex(this), 1, chipGroup.isSingleLine() ? chipGroup.c(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.f9522s != i3) {
            this.f9522s = i3;
            z();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L3a
            if (r0 == r2) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L35
            goto L40
        L21:
            boolean r0 = r5.f9518o
            if (r0 == 0) goto L40
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r3)
        L2a:
            r0 = r2
            goto L41
        L2c:
            boolean r0 = r5.f9518o
            if (r0 == 0) goto L35
            r5.s()
            r0 = r2
            goto L36
        L35:
            r0 = r3
        L36:
            r5.setCloseIconPressed(r3)
            goto L41
        L3a:
            if (r1 == 0) goto L40
            r5.setCloseIconPressed(r2)
            goto L2a
        L40:
            r0 = r3
        L41:
            if (r0 != 0) goto L4b
            boolean r5 = super.onTouchEvent(r6)
            if (r5 == 0) goto L4a
            goto L4b
        L4a:
            r2 = r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean q() {
        com.google.android.material.chip.a aVar = this.f9512i;
        return aVar != null && aVar.k1();
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f9512i;
        return aVar != null && aVar.m1();
    }

    public boolean s() {
        boolean z3 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f9515l;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z3 = true;
        }
        if (this.f9526w) {
            this.f9525v.L(1, 1);
        }
        return z3;
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f9524u = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f9514k) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f9514k) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.t1(z3);
        }
    }

    public void setCheckableResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.u1(i3);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        MaterialCheckable.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar == null) {
            this.f9517n = z3;
            return;
        }
        if (aVar.k1()) {
            boolean isChecked = isChecked();
            super.setChecked(z3);
            if (isChecked == z3 || (onCheckedChangeListener = this.f9516m) == null) {
                return;
            }
            onCheckedChangeListener.onCheckedChanged(this, z3);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.v1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z3) {
        setCheckedIconVisible(z3);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.w1(i3);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.x1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.y1(i3);
        }
    }

    public void setCheckedIconVisible(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.z1(i3);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.B1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.C1(i3);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.D1(f3);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.E1(i3);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f9512i;
        if (aVar2 != aVar) {
            v(aVar2);
            this.f9512i = aVar;
            aVar.w2(false);
            i(this.f9512i);
            k(this.f9523t);
        }
    }

    public void setChipEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.F1(f3);
        }
    }

    public void setChipEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.G1(i3);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.H1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z3) {
        setChipIconVisible(z3);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.I1(i3);
        }
    }

    public void setChipIconSize(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.J1(f3);
        }
    }

    public void setChipIconSizeResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.K1(i3);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.L1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.M1(i3);
        }
    }

    public void setChipIconVisible(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.N1(i3);
        }
    }

    public void setChipMinHeight(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.P1(f3);
        }
    }

    public void setChipMinHeightResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.Q1(i3);
        }
    }

    public void setChipStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.R1(f3);
        }
    }

    public void setChipStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.S1(i3);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.T1(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.U1(i3);
        }
    }

    public void setChipStrokeWidth(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.V1(f3);
        }
    }

    public void setChipStrokeWidthResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.W1(i3);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.Y1(drawable);
        }
        w();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.Z1(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z3) {
        setCloseIconVisible(z3);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.a2(f3);
        }
    }

    public void setCloseIconEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.b2(i3);
        }
    }

    public void setCloseIconResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.c2(i3);
        }
        w();
    }

    public void setCloseIconSize(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.d2(f3);
        }
    }

    public void setCloseIconSizeResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.e2(i3);
        }
    }

    public void setCloseIconStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.f2(f3);
        }
    }

    public void setCloseIconStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.g2(i3);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.i2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.j2(i3);
        }
    }

    public void setCloseIconVisible(int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.T(f3);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f9512i == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.m2(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z3) {
        this.f9521r = z3;
        k(this.f9523t);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(I0.c cVar) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.n2(cVar);
        }
    }

    public void setHideMotionSpecResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.o2(i3);
        }
    }

    public void setIconEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.p2(f3);
        }
    }

    public void setIconEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.q2(i3);
        }
    }

    public void setIconStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.r2(f3);
        }
    }

    public void setIconStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.s2(i3);
        }
    }

    @Override // com.google.android.material.internal.MaterialCheckable
    public void setInternalOnCheckedChangeListener(MaterialCheckable.OnCheckedChangeListener<Chip> onCheckedChangeListener) {
        this.f9516m = onCheckedChangeListener;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.f9512i == null) {
            return;
        }
        super.setLayoutDirection(i3);
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.t2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i3);
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f9515l = onClickListener;
        w();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.u2(colorStateList);
        }
        if (this.f9512i.i1()) {
            return;
        }
        y();
    }

    public void setRippleColorResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.v2(i3);
            if (this.f9512i.i1()) {
                return;
            }
            y();
        }
    }

    @Override // U0.n
    public void setShapeAppearanceModel(k kVar) {
        this.f9512i.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(I0.c cVar) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.x2(cVar);
        }
    }

    public void setShowMotionSpecResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.y2(i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z3) {
        if (!z3) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z3);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(aVar.H2() ? null : charSequence, bufferType);
        com.google.android.material.chip.a aVar2 = this.f9512i;
        if (aVar2 != null) {
            aVar2.z2(charSequence);
        }
    }

    public void setTextAppearance(R0.d dVar) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.A2(dVar);
        }
        A();
    }

    public void setTextAppearanceResource(int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.C2(f3);
        }
    }

    public void setTextEndPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.D2(i3);
        }
    }

    public void setTextStartPadding(float f3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.E2(f3);
        }
    }

    public void setTextStartPaddingResource(int i3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.F2(i3);
        }
    }

    public boolean u() {
        return this.f9521r;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Chip(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.chip.Chip.f9508A
            android.content.Context r7 = V0.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r6.f9527x = r7
            android.graphics.RectF r7 = new android.graphics.RectF
            r7.<init>()
            r6.f9528y = r7
            com.google.android.material.chip.Chip$a r7 = new com.google.android.material.chip.Chip$a
            r7.<init>()
            r6.f9529z = r7
            android.content.Context r0 = r6.getContext()
            r6.B(r8)
            com.google.android.material.chip.a r7 = com.google.android.material.chip.a.r0(r0, r8, r9, r4)
            r6.n(r0, r8, r9)
            r6.setChipDrawable(r7)
            float r1 = androidx.core.view.y.t(r6)
            r7.T(r1)
            int[] r2 = H0.j.f780f0
            r1 = 0
            int[] r5 = new int[r1]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r9 = H0.j.f722Q0
            boolean r9 = r8.hasValue(r9)
            r8.recycle()
            com.google.android.material.chip.Chip$c r8 = new com.google.android.material.chip.Chip$c
            r8.<init>(r6)
            r6.f9525v = r8
            r6.w()
            if (r9 != 0) goto L59
            r6.o()
        L59:
            boolean r8 = r6.f9517n
            r6.setChecked(r8)
            java.lang.CharSequence r8 = r7.d1()
            r6.setText(r8)
            android.text.TextUtils$TruncateAt r7 = r7.X0()
            r6.setEllipsize(r7)
            r6.A()
            com.google.android.material.chip.a r7 = r6.f9512i
            boolean r7 = r7.H2()
            if (r7 != 0) goto L7e
            r7 = 1
            r6.setLines(r7)
            r6.setHorizontallyScrolling(r7)
        L7e:
            r7 = 8388627(0x800013, float:1.175497E-38)
            r6.setGravity(r7)
            r6.z()
            boolean r7 = r6.u()
            if (r7 == 0) goto L92
            int r7 = r6.f9523t
            r6.setMinHeight(r7)
        L92:
            int r7 = androidx.core.view.y.x(r6)
            r6.f9522s = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCloseIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.k2(z3);
        }
        w();
    }

    public void setCheckedIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.A1(z3);
        }
    }

    public void setChipIconVisible(boolean z3) {
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.O1(z3);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.B2(i3);
        }
        A();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        com.google.android.material.chip.a aVar = this.f9512i;
        if (aVar != null) {
            aVar.B2(i3);
        }
        A();
    }
}
