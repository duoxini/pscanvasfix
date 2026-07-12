package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.emoji2.text.e;
import com.customer.feedback.sdk.activity.FeedbackActivity;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import e.AbstractC0339a;
import f.AbstractC0348a;
import i.C0392a;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* renamed from: W, reason: collision with root package name */
    private static final Property f4093W = new a(Float.class, "thumbPos");

    /* renamed from: a0, reason: collision with root package name */
    private static final int[] f4094a0 = {R.attr.state_checked};

    /* renamed from: A, reason: collision with root package name */
    private float f4095A;

    /* renamed from: B, reason: collision with root package name */
    private VelocityTracker f4096B;

    /* renamed from: C, reason: collision with root package name */
    private int f4097C;

    /* renamed from: D, reason: collision with root package name */
    float f4098D;

    /* renamed from: E, reason: collision with root package name */
    private int f4099E;

    /* renamed from: F, reason: collision with root package name */
    private int f4100F;

    /* renamed from: G, reason: collision with root package name */
    private int f4101G;

    /* renamed from: H, reason: collision with root package name */
    private int f4102H;

    /* renamed from: I, reason: collision with root package name */
    private int f4103I;

    /* renamed from: J, reason: collision with root package name */
    private int f4104J;

    /* renamed from: K, reason: collision with root package name */
    private int f4105K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f4106L;

    /* renamed from: M, reason: collision with root package name */
    private final TextPaint f4107M;

    /* renamed from: N, reason: collision with root package name */
    private ColorStateList f4108N;

    /* renamed from: O, reason: collision with root package name */
    private Layout f4109O;

    /* renamed from: P, reason: collision with root package name */
    private Layout f4110P;

    /* renamed from: Q, reason: collision with root package name */
    private TransformationMethod f4111Q;

    /* renamed from: R, reason: collision with root package name */
    ObjectAnimator f4112R;

    /* renamed from: S, reason: collision with root package name */
    private final C0250y f4113S;

    /* renamed from: T, reason: collision with root package name */
    private C0238l f4114T;

    /* renamed from: U, reason: collision with root package name */
    private c f4115U;

    /* renamed from: V, reason: collision with root package name */
    private final Rect f4116V;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f4117e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f4118f;

    /* renamed from: g, reason: collision with root package name */
    private PorterDuff.Mode f4119g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4120h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4121i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f4122j;

    /* renamed from: k, reason: collision with root package name */
    private ColorStateList f4123k;

    /* renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f4124l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4125m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4126n;

    /* renamed from: o, reason: collision with root package name */
    private int f4127o;

    /* renamed from: p, reason: collision with root package name */
    private int f4128p;

    /* renamed from: q, reason: collision with root package name */
    private int f4129q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f4130r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f4131s;

    /* renamed from: t, reason: collision with root package name */
    private CharSequence f4132t;

    /* renamed from: u, reason: collision with root package name */
    private CharSequence f4133u;

    /* renamed from: v, reason: collision with root package name */
    private CharSequence f4134v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f4135w;

    /* renamed from: x, reason: collision with root package name */
    private int f4136x;

    /* renamed from: y, reason: collision with root package name */
    private int f4137y;

    /* renamed from: z, reason: collision with root package name */
    private float f4138z;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f4098D);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f3) {
            switchCompat.setThumbPosition(f3.floatValue());
        }
    }

    static class b {
        static void a(ObjectAnimator objectAnimator, boolean z3) {
            objectAnimator.setAutoCancel(z3);
        }
    }

    static class c extends e.AbstractC0078e {

        /* renamed from: a, reason: collision with root package name */
        private final Reference f4139a;

        c(SwitchCompat switchCompat) {
            this.f4139a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.e.AbstractC0078e
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f4139a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.e.AbstractC0078e
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f4139a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11082K);
    }

    private void a(boolean z3) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) f4093W, z3 ? 1.0f : 0.0f);
        this.f4112R = ofFloat;
        ofFloat.setDuration(250L);
        b.a(this.f4112R, true);
        this.f4112R.start();
    }

    private void b() {
        Drawable drawable = this.f4117e;
        if (drawable != null) {
            if (this.f4120h || this.f4121i) {
                Drawable mutate = androidx.core.graphics.drawable.a.l(drawable).mutate();
                this.f4117e = mutate;
                if (this.f4120h) {
                    androidx.core.graphics.drawable.a.i(mutate, this.f4118f);
                }
                if (this.f4121i) {
                    androidx.core.graphics.drawable.a.j(this.f4117e, this.f4119g);
                }
                if (this.f4117e.isStateful()) {
                    this.f4117e.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f4122j;
        if (drawable != null) {
            if (this.f4125m || this.f4126n) {
                Drawable mutate = androidx.core.graphics.drawable.a.l(drawable).mutate();
                this.f4122j = mutate;
                if (this.f4125m) {
                    androidx.core.graphics.drawable.a.i(mutate, this.f4123k);
                }
                if (this.f4126n) {
                    androidx.core.graphics.drawable.a.j(this.f4122j, this.f4124l);
                }
                if (this.f4122j.isStateful()) {
                    this.f4122j.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.f4112R;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f3, float f4, float f5) {
        return f3 < f4 ? f4 : f3 > f5 ? f5 : f3;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod f3 = getEmojiTextViewHelper().f(this.f4111Q);
        return f3 != null ? f3.getTransformation(charSequence, this) : charSequence;
    }

    private C0238l getEmojiTextViewHelper() {
        if (this.f4114T == null) {
            this.f4114T = new C0238l(this);
        }
        return this.f4114T;
    }

    private boolean getTargetCheckedState() {
        return this.f4098D > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((b0.b(this) ? 1.0f - this.f4098D : this.f4098D) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f4122j;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.f4116V;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f4117e;
        Rect c3 = drawable2 != null ? E.c(drawable2) : E.f3902c;
        return ((((this.f4099E - this.f4101G) - rect.left) - rect.right) - c3.left) - c3.right;
    }

    private boolean h(float f3, float f4) {
        if (this.f4117e == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f4117e.getPadding(this.f4116V);
        int i3 = this.f4103I;
        int i4 = this.f4137y;
        int i5 = i3 - i4;
        int i6 = (this.f4102H + thumbOffset) - i4;
        int i7 = this.f4101G + i6;
        Rect rect = this.f4116V;
        return f3 > ((float) i6) && f3 < ((float) (((i7 + rect.left) + rect.right) + i4)) && f4 > ((float) i5) && f4 < ((float) (this.f4105K + i4));
    }

    private Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.f4107M, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        CharSequence charSequence = this.f4133u;
        if (charSequence == null) {
            charSequence = getResources().getString(e.h.f11237c);
        }
        androidx.core.view.y.A0(this, charSequence);
    }

    private void l() {
        CharSequence charSequence = this.f4131s;
        if (charSequence == null) {
            charSequence = getResources().getString(e.h.f11238d);
        }
        androidx.core.view.y.A0(this, charSequence);
    }

    private void o(int i3, int i4) {
        n(i3 != 1 ? i3 != 2 ? i3 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i4);
    }

    private void p() {
        if (this.f4115U == null && this.f4114T.b() && androidx.emoji2.text.e.h()) {
            androidx.emoji2.text.e b3 = androidx.emoji2.text.e.b();
            int d3 = b3.d();
            if (d3 == 3 || d3 == 0) {
                c cVar = new c(this);
                this.f4115U = cVar;
                b3.s(cVar);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        this.f4136x = 0;
        boolean z3 = true;
        boolean z4 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z4) {
            this.f4096B.computeCurrentVelocity(OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT);
            float xVelocity = this.f4096B.getXVelocity();
            if (Math.abs(xVelocity) <= this.f4097C) {
                z3 = getTargetCheckedState();
            } else if (!b0.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z3 = false;
            }
        } else {
            z3 = isChecked;
        }
        if (z3 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z3);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f4133u = charSequence;
        this.f4134v = g(charSequence);
        this.f4110P = null;
        if (this.f4135w) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f4131s = charSequence;
        this.f4132t = g(charSequence);
        this.f4109O = null;
        if (this.f4135w) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int i4;
        Rect rect = this.f4116V;
        int i5 = this.f4102H;
        int i6 = this.f4103I;
        int i7 = this.f4104J;
        int i8 = this.f4105K;
        int thumbOffset = getThumbOffset() + i5;
        Drawable drawable = this.f4117e;
        Rect c3 = drawable != null ? E.c(drawable) : E.f3902c;
        Drawable drawable2 = this.f4122j;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i9 = rect.left;
            thumbOffset += i9;
            if (c3 != null) {
                int i10 = c3.left;
                if (i10 > i9) {
                    i5 += i10 - i9;
                }
                int i11 = c3.top;
                int i12 = rect.top;
                i3 = i11 > i12 ? (i11 - i12) + i6 : i6;
                int i13 = c3.right;
                int i14 = rect.right;
                if (i13 > i14) {
                    i7 -= i13 - i14;
                }
                int i15 = c3.bottom;
                int i16 = rect.bottom;
                if (i15 > i16) {
                    i4 = i8 - (i15 - i16);
                    this.f4122j.setBounds(i5, i3, i7, i4);
                }
            } else {
                i3 = i6;
            }
            i4 = i8;
            this.f4122j.setBounds(i5, i3, i7, i4);
        }
        Drawable drawable3 = this.f4117e;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i17 = thumbOffset - rect.left;
            int i18 = thumbOffset + this.f4101G + rect.right;
            this.f4117e.setBounds(i17, i6, i18, i8);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.f(background, i17, i6, i18, i8);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f3, float f4) {
        super.drawableHotspotChanged(f3, f4);
        Drawable drawable = this.f4117e;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.e(drawable, f3, f4);
        }
        Drawable drawable2 = this.f4122j;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.e(drawable2, f3, f4);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4117e;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f4122j;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!b0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f4099E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f4129q : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (b0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f4099E;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f4129q : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return androidx.core.widget.i.o(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f4135w;
    }

    public boolean getSplitTrack() {
        return this.f4130r;
    }

    public int getSwitchMinWidth() {
        return this.f4128p;
    }

    public int getSwitchPadding() {
        return this.f4129q;
    }

    public CharSequence getTextOff() {
        return this.f4133u;
    }

    public CharSequence getTextOn() {
        return this.f4131s;
    }

    public Drawable getThumbDrawable() {
        return this.f4117e;
    }

    protected final float getThumbPosition() {
        return this.f4098D;
    }

    public int getThumbTextPadding() {
        return this.f4127o;
    }

    public ColorStateList getThumbTintList() {
        return this.f4118f;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f4119g;
    }

    public Drawable getTrackDrawable() {
        return this.f4122j;
    }

    public ColorStateList getTrackTintList() {
        return this.f4123k;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f4124l;
    }

    void j() {
        setTextOnInternal(this.f4131s);
        setTextOffInternal(this.f4133u);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f4117e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f4122j;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f4112R;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.f4112R.end();
        this.f4112R = null;
    }

    public void m(Context context, int i3) {
        V u3 = V.u(context, i3, e.j.f11329S2);
        ColorStateList c3 = u3.c(e.j.f11345W2);
        if (c3 != null) {
            this.f4108N = c3;
        } else {
            this.f4108N = getTextColors();
        }
        int f3 = u3.f(e.j.f11333T2, 0);
        if (f3 != 0) {
            float f4 = f3;
            if (f4 != this.f4107M.getTextSize()) {
                this.f4107M.setTextSize(f4);
                requestLayout();
            }
        }
        o(u3.k(e.j.f11337U2, -1), u3.k(e.j.f11341V2, -1));
        if (u3.a(e.j.b3, false)) {
            this.f4111Q = new C0392a(getContext());
        } else {
            this.f4111Q = null;
        }
        setTextOnInternal(this.f4131s);
        setTextOffInternal(this.f4133u);
        u3.x();
    }

    public void n(Typeface typeface, int i3) {
        if (i3 <= 0) {
            this.f4107M.setFakeBoldText(false);
            this.f4107M.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
            setSwitchTypeface(defaultFromStyle);
            int i4 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i3;
            this.f4107M.setFakeBoldText((i4 & 1) != 0);
            this.f4107M.setTextSkewX((i4 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f4094a0);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f4116V;
        Drawable drawable = this.f4122j;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.f4103I;
        int i4 = this.f4105K;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f4117e;
        if (drawable != null) {
            if (!this.f4130r || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect c3 = E.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += c3.left;
                rect.right -= c3.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f4109O : this.f4110P;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.f4108N;
            if (colorStateList != null) {
                this.f4107M.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.f4107M.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i5 + i6) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        int i7;
        int width;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z3, i3, i4, i5, i6);
        int i12 = 0;
        if (this.f4117e != null) {
            Rect rect = this.f4116V;
            Drawable drawable = this.f4122j;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect c3 = E.c(this.f4117e);
            i7 = Math.max(0, c3.left - rect.left);
            i12 = Math.max(0, c3.right - rect.right);
        } else {
            i7 = 0;
        }
        if (b0.b(this)) {
            i8 = getPaddingLeft() + i7;
            width = ((this.f4099E + i8) - i7) - i12;
        } else {
            width = (getWidth() - getPaddingRight()) - i12;
            i8 = (width - this.f4099E) + i7 + i12;
        }
        int gravity = getGravity() & FeedbackActivity.SHOW_NO_NETWORK;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i9 = this.f4100F;
            i10 = paddingTop - (i9 / 2);
        } else {
            if (gravity == 80) {
                i11 = getHeight() - getPaddingBottom();
                i10 = i11 - this.f4100F;
                this.f4102H = i8;
                this.f4103I = i10;
                this.f4105K = i11;
                this.f4104J = width;
            }
            i10 = getPaddingTop();
            i9 = this.f4100F;
        }
        i11 = i9 + i10;
        this.f4102H = i8;
        this.f4103I = i10;
        this.f4105K = i11;
        this.f4104J = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i4) {
        int i5;
        int i6;
        if (this.f4135w) {
            if (this.f4109O == null) {
                this.f4109O = i(this.f4132t);
            }
            if (this.f4110P == null) {
                this.f4110P = i(this.f4134v);
            }
        }
        Rect rect = this.f4116V;
        Drawable drawable = this.f4117e;
        int i7 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.f4117e.getIntrinsicWidth() - rect.left) - rect.right;
            i6 = this.f4117e.getIntrinsicHeight();
        } else {
            i5 = 0;
            i6 = 0;
        }
        this.f4101G = Math.max(this.f4135w ? Math.max(this.f4109O.getWidth(), this.f4110P.getWidth()) + (this.f4127o * 2) : 0, i5);
        Drawable drawable2 = this.f4122j;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i7 = this.f4122j.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i8 = rect.left;
        int i9 = rect.right;
        Drawable drawable3 = this.f4117e;
        if (drawable3 != null) {
            Rect c3 = E.c(drawable3);
            i8 = Math.max(i8, c3.left);
            i9 = Math.max(i9, c3.right);
        }
        int max = this.f4106L ? Math.max(this.f4128p, (this.f4101G * 2) + i8 + i9) : this.f4128p;
        int max2 = Math.max(i7, i6);
        this.f4099E = max;
        this.f4100F = max2;
        super.onMeasure(i3, i4);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f4131s : this.f4133u;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r0 != 3) goto L44;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f4096B
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f4136x
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f4138z
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = androidx.appcompat.widget.b0.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.f4098D
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.f4098D
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f4138z = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f4138z
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f4137y
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f4095A
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f4137y
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f4136x = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f4138z = r0
            r6.f4095A = r3
            return r1
        L89:
            int r0 = r6.f4136x
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f4136x = r0
            android.view.VelocityTracker r0 = r6.f4096B
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f4136x = r1
            r6.f4138z = r0
            r6.f4095A = r2
        Lb7:
            boolean r6 = super.onTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z3) {
        super.setAllCaps(z3);
        getEmojiTextViewHelper().d(z3);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        super.setChecked(z3);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && androidx.core.view.y.O(this)) {
            a(isChecked);
        } else {
            d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.i.p(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z3) {
        getEmojiTextViewHelper().e(z3);
        setTextOnInternal(this.f4131s);
        setTextOffInternal(this.f4133u);
        requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean z3) {
        this.f4106L = z3;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z3) {
        if (this.f4135w != z3) {
            this.f4135w = z3;
            requestLayout();
            if (z3) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z3) {
        this.f4130r = z3;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.f4128p = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.f4129q = i3;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f4107M.getTypeface() == null || this.f4107M.getTypeface().equals(typeface)) && (this.f4107M.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f4107M.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4117e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4117e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f3) {
        this.f4098D = f3;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(AbstractC0348a.b(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.f4127o = i3;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f4118f = colorStateList;
        this.f4120h = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f4119g = mode;
        this.f4121i = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f4122j;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f4122j = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(AbstractC0348a.b(getContext(), i3));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f4123k = colorStateList;
        this.f4125m = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f4124l = mode;
        this.f4126n = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4117e || drawable == this.f4122j;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f4118f = null;
        this.f4119g = null;
        this.f4120h = false;
        this.f4121i = false;
        this.f4123k = null;
        this.f4124l = null;
        this.f4125m = false;
        this.f4126n = false;
        this.f4096B = VelocityTracker.obtain();
        this.f4106L = true;
        this.f4116V = new Rect();
        Q.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.f4107M = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        V w3 = V.w(context, attributeSet, e.j.f11269D2, i3, 0);
        androidx.core.view.y.h0(this, context, e.j.f11269D2, attributeSet, w3.r(), i3, 0);
        Drawable g3 = w3.g(e.j.f11281G2);
        this.f4117e = g3;
        if (g3 != null) {
            g3.setCallback(this);
        }
        Drawable g4 = w3.g(e.j.f11317P2);
        this.f4122j = g4;
        if (g4 != null) {
            g4.setCallback(this);
        }
        setTextOnInternal(w3.p(e.j.f11273E2));
        setTextOffInternal(w3.p(e.j.f11277F2));
        this.f4135w = w3.a(e.j.f11285H2, true);
        this.f4127o = w3.f(e.j.f11305M2, 0);
        this.f4128p = w3.f(e.j.f11293J2, 0);
        this.f4129q = w3.f(e.j.f11297K2, 0);
        this.f4130r = w3.a(e.j.f11289I2, false);
        ColorStateList c3 = w3.c(e.j.f11309N2);
        if (c3 != null) {
            this.f4118f = c3;
            this.f4120h = true;
        }
        PorterDuff.Mode d3 = E.d(w3.k(e.j.f11313O2, -1), null);
        if (this.f4119g != d3) {
            this.f4119g = d3;
            this.f4121i = true;
        }
        if (this.f4120h || this.f4121i) {
            b();
        }
        ColorStateList c4 = w3.c(e.j.f11321Q2);
        if (c4 != null) {
            this.f4123k = c4;
            this.f4125m = true;
        }
        PorterDuff.Mode d4 = E.d(w3.k(e.j.f11325R2, -1), null);
        if (this.f4124l != d4) {
            this.f4124l = d4;
            this.f4126n = true;
        }
        if (this.f4125m || this.f4126n) {
            c();
        }
        int n3 = w3.n(e.j.f11301L2, 0);
        if (n3 != 0) {
            m(context, n3);
        }
        C0250y c0250y = new C0250y(this);
        this.f4113S = c0250y;
        c0250y.m(attributeSet, i3);
        w3.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4137y = viewConfiguration.getScaledTouchSlop();
        this.f4097C = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i3);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
