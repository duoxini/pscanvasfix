package com.coui.appcompat.edittext;

import M1.m;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.C0236j;
import androidx.core.view.y;
import com.coui.appcompat.edittext.a;
import d0.AbstractC0335a;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class COUIEditText extends C0236j {

    /* renamed from: A, reason: collision with root package name */
    private boolean f7753A;

    /* renamed from: A0, reason: collision with root package name */
    private com.coui.appcompat.edittext.b f7754A0;

    /* renamed from: B, reason: collision with root package name */
    private CharSequence f7755B;

    /* renamed from: B0, reason: collision with root package name */
    private Runnable f7756B0;

    /* renamed from: C, reason: collision with root package name */
    private boolean f7757C;

    /* renamed from: C0, reason: collision with root package name */
    private Runnable f7758C0;

    /* renamed from: D, reason: collision with root package name */
    private GradientDrawable f7759D;

    /* renamed from: E, reason: collision with root package name */
    private int f7760E;

    /* renamed from: F, reason: collision with root package name */
    private int f7761F;

    /* renamed from: G, reason: collision with root package name */
    private float f7762G;

    /* renamed from: H, reason: collision with root package name */
    private float f7763H;

    /* renamed from: I, reason: collision with root package name */
    private float f7764I;

    /* renamed from: J, reason: collision with root package name */
    private float f7765J;

    /* renamed from: K, reason: collision with root package name */
    private int f7766K;

    /* renamed from: L, reason: collision with root package name */
    private int f7767L;

    /* renamed from: M, reason: collision with root package name */
    private int f7768M;

    /* renamed from: N, reason: collision with root package name */
    private RectF f7769N;

    /* renamed from: O, reason: collision with root package name */
    private ColorStateList f7770O;

    /* renamed from: P, reason: collision with root package name */
    private ColorStateList f7771P;

    /* renamed from: Q, reason: collision with root package name */
    private int f7772Q;

    /* renamed from: R, reason: collision with root package name */
    private int f7773R;

    /* renamed from: S, reason: collision with root package name */
    private int f7774S;

    /* renamed from: T, reason: collision with root package name */
    private int f7775T;

    /* renamed from: U, reason: collision with root package name */
    private boolean f7776U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f7777V;

    /* renamed from: W, reason: collision with root package name */
    private ValueAnimator f7778W;

    /* renamed from: a0, reason: collision with root package name */
    private ValueAnimator f7779a0;

    /* renamed from: b0, reason: collision with root package name */
    private ValueAnimator f7780b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f7781c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f7782d0;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f7783e0;

    /* renamed from: f0, reason: collision with root package name */
    private Paint f7784f0;

    /* renamed from: g0, reason: collision with root package name */
    private Paint f7785g0;

    /* renamed from: h0, reason: collision with root package name */
    private Paint f7786h0;

    /* renamed from: i0, reason: collision with root package name */
    private Paint f7787i0;

    /* renamed from: j0, reason: collision with root package name */
    private TextPaint f7788j0;

    /* renamed from: k, reason: collision with root package name */
    private final a.C0101a f7789k;

    /* renamed from: k0, reason: collision with root package name */
    private int f7790k0;

    /* renamed from: l, reason: collision with root package name */
    private Interpolator f7791l;

    /* renamed from: l0, reason: collision with root package name */
    private float f7792l0;

    /* renamed from: m, reason: collision with root package name */
    private Interpolator f7793m;

    /* renamed from: m0, reason: collision with root package name */
    private int f7794m0;

    /* renamed from: n, reason: collision with root package name */
    private int f7795n;

    /* renamed from: n0, reason: collision with root package name */
    private int f7796n0;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f7797o;

    /* renamed from: o0, reason: collision with root package name */
    private int f7798o0;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f7799p;

    /* renamed from: p0, reason: collision with root package name */
    private int f7800p0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7801q;

    /* renamed from: q0, reason: collision with root package name */
    private int f7802q0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7803r;

    /* renamed from: r0, reason: collision with root package name */
    private int f7804r0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f7805s;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f7806s0;

    /* renamed from: t, reason: collision with root package name */
    private int f7807t;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f7808t0;

    /* renamed from: u, reason: collision with root package name */
    private Context f7809u;

    /* renamed from: u0, reason: collision with root package name */
    private String f7810u0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f7811v;

    /* renamed from: v0, reason: collision with root package name */
    private int f7812v0;

    /* renamed from: w, reason: collision with root package name */
    private f f7813w;

    /* renamed from: w0, reason: collision with root package name */
    private View.OnFocusChangeListener f7814w0;

    /* renamed from: x, reason: collision with root package name */
    private String f7815x;

    /* renamed from: x0, reason: collision with root package name */
    private View.OnTouchListener f7816x0;

    /* renamed from: y, reason: collision with root package name */
    private h f7817y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f7818y0;

    /* renamed from: z, reason: collision with root package name */
    private CharSequence f7819z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f7820z0;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIEditText.this.setCompoundDrawables(null, null, null, null);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            COUIEditText cOUIEditText = COUIEditText.this;
            cOUIEditText.setCompoundDrawables(null, null, cOUIEditText.f7797o, null);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIEditText.this.f7792l0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            COUIEditText.this.invalidate();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIEditText.this.f7790k0 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            COUIEditText.this.invalidate();
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIEditText.this.f7789k.T(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public class f extends A.a implements View.OnClickListener {

        /* renamed from: r, reason: collision with root package name */
        private View f7826r;

        /* renamed from: s, reason: collision with root package name */
        private Rect f7827s;

        /* renamed from: t, reason: collision with root package name */
        private Rect f7828t;

        public f(View view) {
            super(view);
            this.f7827s = null;
            this.f7828t = null;
            this.f7826r = view;
        }

        private Rect N(int i3) {
            if (i3 != 0) {
                return new Rect();
            }
            if (this.f7827s == null) {
                O();
            }
            return this.f7827s;
        }

        private void O() {
            Rect rect = new Rect();
            this.f7827s = rect;
            rect.left = COUIEditText.this.getDeleteButtonLeft();
            this.f7827s.right = COUIEditText.this.getWidth();
            Rect rect2 = this.f7827s;
            rect2.top = 0;
            rect2.bottom = COUIEditText.this.getHeight();
        }

        @Override // A.a
        protected boolean A(int i3, int i4, Bundle bundle) {
            if (i4 != 16) {
                return false;
            }
            if (i3 != 0 || !COUIEditText.this.x()) {
                return true;
            }
            COUIEditText.this.G();
            return true;
        }

        @Override // A.a
        protected void C(int i3, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(COUIEditText.this.f7815x);
        }

        @Override // A.a
        protected void E(int i3, androidx.core.view.accessibility.d dVar) {
            if (i3 == 0) {
                dVar.U(COUIEditText.this.f7815x);
                dVar.Q(Button.class.getName());
                dVar.a(16);
            }
            dVar.M(N(i3));
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        @Override // A.a
        protected int q(float f3, float f4) {
            if (this.f7827s == null) {
                O();
            }
            Rect rect = this.f7827s;
            return (f3 < ((float) rect.left) || f3 > ((float) rect.right) || f4 < ((float) rect.top) || f4 > ((float) rect.bottom) || !COUIEditText.this.x()) ? Integer.MIN_VALUE : 0;
        }

        @Override // A.a
        protected void r(List list) {
            if (COUIEditText.this.x()) {
                list.add(0);
            }
        }
    }

    public static class g extends View.BaseSavedState {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        String f7830e;

        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i3) {
                return new g[i3];
            }
        }

        /* synthetic */ g(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f7830e);
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        private g(Parcel parcel) {
            super(parcel);
            this.f7830e = parcel.readString();
        }
    }

    private class h implements TextWatcher {
        private h() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            COUIEditText cOUIEditText = COUIEditText.this;
            cOUIEditText.N(cOUIEditText.hasFocus());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }

        /* synthetic */ h(COUIEditText cOUIEditText, a aVar) {
            this();
        }
    }

    public interface i {
    }

    public interface j {
        void a(boolean z3);

        void b(boolean z3);
    }

    public interface k {
    }

    public interface l {
    }

    public COUIEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    private boolean B() {
        return (getGravity() & 7) == 1;
    }

    private boolean D() {
        return getLayoutDirection() == 1;
    }

    private void F() {
        p();
        S();
    }

    private void H() {
        if (t()) {
            RectF rectF = this.f7769N;
            this.f7789k.n(rectF);
            o(rectF);
            ((com.coui.appcompat.edittext.a) this.f7759D).h(rectF);
        }
    }

    private void J() {
        if (this.f7761F == 2 && this.f7773R == 0) {
            this.f7773R = this.f7771P.getColorForState(getDrawableState(), this.f7771P.getDefaultColor());
        }
    }

    private void L() {
        F();
        this.f7789k.S(getTextSize());
        int gravity = getGravity();
        this.f7789k.O((gravity & (-113)) | 48);
        this.f7789k.R(gravity);
        if (this.f7770O == null) {
            this.f7770O = getHintTextColors();
        }
        boolean equals = Locale.getDefault().getLanguage().equals("my");
        if (!equals) {
            setHint(this.f7753A ? null : "");
        }
        if (TextUtils.isEmpty(this.f7755B) && !equals) {
            CharSequence hint = getHint();
            this.f7819z = hint;
            setTopHint(hint);
            setHint(this.f7753A ? null : "");
        }
        this.f7757C = !equals;
        P(false, true);
        if (this.f7753A) {
            R();
        }
    }

    private void M() {
        if (isFocused()) {
            if (this.f7806s0) {
                setText(this.f7810u0);
                setSelection(this.f7812v0 >= getSelectionEnd() ? getSelectionEnd() : this.f7812v0);
            }
            this.f7806s0 = false;
            return;
        }
        if (this.f7788j0.measureText(String.valueOf(getText())) <= getWidth() || this.f7806s0) {
            return;
        }
        this.f7810u0 = String.valueOf(getText());
        this.f7806s0 = true;
        setText(TextUtils.ellipsize(getText(), this.f7788j0, getWidth(), TextUtils.TruncateAt.END));
        if (this.f7782d0) {
            setErrorState(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z3) {
        if (TextUtils.isEmpty(getText().toString())) {
            if (B()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            if (this.f7805s) {
                setCompoundDrawables(null, null, null, null);
            } else {
                post(this.f7756B0);
            }
            this.f7805s = false;
            return;
        }
        if (!z3) {
            if (this.f7805s) {
                if (B()) {
                    setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
                }
                post(this.f7756B0);
                this.f7805s = false;
                return;
            }
            return;
        }
        if (this.f7797o == null || this.f7805s) {
            return;
        }
        if (B()) {
            setPaddingRelative(this.f7802q0 + getCompoundDrawablePadding(), getPaddingTop(), getPaddingEnd(), getPaddingBottom());
        }
        if (A() && this.f7818y0) {
            post(this.f7758C0);
        }
        this.f7805s = true;
    }

    private void P(boolean z3, boolean z4) {
        a.C0101a c0101a;
        ColorStateList colorStateList;
        boolean isEnabled = isEnabled();
        boolean isEmpty = TextUtils.isEmpty(getText());
        if (this.f7770O != null) {
            this.f7770O = getHintTextColors();
            a.C0101a c0101a2 = this.f7789k;
            if (c0101a2 != null) {
                c0101a2.N(this.f7771P);
                this.f7789k.Q(this.f7770O);
            }
        }
        a.C0101a c0101a3 = this.f7789k;
        if (c0101a3 != null) {
            if (!isEnabled) {
                c0101a3.N(ColorStateList.valueOf(this.f7774S));
                this.f7789k.Q(ColorStateList.valueOf(this.f7774S));
            } else if (hasFocus() && (colorStateList = this.f7771P) != null) {
                this.f7789k.N(colorStateList);
            }
        }
        if (!isEmpty || (isEnabled() && hasFocus())) {
            if (z4 || this.f7776U) {
                s(z3);
            }
        } else if ((z4 || !this.f7776U) && C()) {
            u(z3);
        }
        com.coui.appcompat.edittext.b bVar = this.f7754A0;
        if (bVar == null || (c0101a = this.f7789k) == null) {
            return;
        }
        bVar.L(c0101a);
    }

    private void Q() {
        if (this.f7761F != 1) {
            return;
        }
        if (!isEnabled()) {
            this.f7792l0 = 0.0f;
            return;
        }
        if (hasFocus()) {
            if (this.f7783e0) {
                return;
            }
            m();
        } else if (this.f7783e0) {
            l();
        }
    }

    private void R() {
        y.y0(this, D() ? getPaddingRight() : getPaddingLeft(), getModePaddingTop(), D() ? getPaddingLeft() : getPaddingRight(), getPaddingBottom());
    }

    private void S() {
        if (this.f7761F == 0 || this.f7759D == null || getRight() == 0) {
            return;
        }
        this.f7759D.setBounds(0, getBoundsTop(), getWidth(), getHeight());
        n();
    }

    private void T() {
        int i3;
        if (this.f7759D == null || (i3 = this.f7761F) == 0 || i3 != 2) {
            return;
        }
        if (!isEnabled()) {
            this.f7768M = this.f7774S;
        } else if (hasFocus()) {
            this.f7768M = this.f7773R;
        } else {
            this.f7768M = this.f7772Q;
        }
        n();
    }

    private int getBoundsTop() {
        int i3 = this.f7761F;
        if (i3 == 1) {
            return this.f7796n0;
        }
        if (i3 == 2 || i3 == 3) {
            return (int) (this.f7789k.q() / 2.0f);
        }
        return 0;
    }

    private Drawable getBoxBackground() {
        int i3 = this.f7761F;
        if (i3 == 1 || i3 == 2) {
            return this.f7759D;
        }
        return null;
    }

    private float[] getCornerRadiiAsArray() {
        float f3 = this.f7763H;
        float f4 = this.f7762G;
        float f5 = this.f7765J;
        float f6 = this.f7764I;
        return new float[]{f3, f3, f4, f4, f5, f5, f6, f6};
    }

    private int getModePaddingTop() {
        int y3;
        int i3;
        int i4 = this.f7761F;
        if (i4 == 1) {
            y3 = this.f7796n0 + ((int) this.f7789k.y());
            i3 = this.f7800p0;
        } else {
            if (i4 != 2 && i4 != 3) {
                return 0;
            }
            y3 = this.f7794m0;
            i3 = (int) (this.f7789k.q() / 2.0f);
        }
        return y3 + i3;
    }

    private void k(float f3) {
        if (this.f7789k.x() == f3) {
            return;
        }
        if (this.f7778W == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f7778W = valueAnimator;
            valueAnimator.setInterpolator(this.f7791l);
            this.f7778W.setDuration(200L);
            this.f7778W.addUpdateListener(new e());
        }
        this.f7778W.setFloatValues(this.f7789k.x(), f3);
        this.f7778W.start();
    }

    private void l() {
        if (this.f7780b0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f7780b0 = valueAnimator;
            valueAnimator.setInterpolator(this.f7793m);
            this.f7780b0.setDuration(250L);
            this.f7780b0.addUpdateListener(new d());
        }
        this.f7780b0.setIntValues(255, 0);
        this.f7780b0.start();
        this.f7783e0 = false;
    }

    private void m() {
        if (this.f7779a0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f7779a0 = valueAnimator;
            valueAnimator.setInterpolator(this.f7793m);
            this.f7779a0.setDuration(250L);
            this.f7779a0.addUpdateListener(new c());
        }
        this.f7790k0 = 255;
        this.f7779a0.setFloatValues(0.0f, 1.0f);
        ValueAnimator valueAnimator2 = this.f7780b0;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f7780b0.cancel();
        }
        this.f7779a0.start();
        this.f7783e0 = true;
    }

    private void n() {
        int i3;
        if (this.f7759D == null) {
            return;
        }
        J();
        int i4 = this.f7766K;
        if (i4 > -1 && (i3 = this.f7768M) != 0) {
            this.f7759D.setStroke(i4, i3);
        }
        this.f7759D.setCornerRadii(getCornerRadiiAsArray());
        invalidate();
    }

    private void o(RectF rectF) {
        float f3 = rectF.left;
        int i3 = this.f7760E;
        rectF.left = f3 - i3;
        rectF.top -= i3;
        rectF.right += i3;
        rectF.bottom += i3;
    }

    private void p() {
        int i3 = this.f7761F;
        if (i3 == 0) {
            this.f7759D = null;
            return;
        }
        if (i3 == 2 && this.f7753A && !(this.f7759D instanceof com.coui.appcompat.edittext.a)) {
            this.f7759D = new com.coui.appcompat.edittext.a();
        } else if (this.f7759D == null) {
            this.f7759D = new GradientDrawable();
        }
    }

    private int q() {
        int i3 = this.f7761F;
        if (i3 == 1) {
            if (getBoxBackground() != null) {
                return getBoxBackground().getBounds().top;
            }
            return 0;
        }
        if (i3 != 2 && i3 != 3) {
            return getPaddingTop();
        }
        if (getBoxBackground() != null) {
            return getBoxBackground().getBounds().top - getLabelMarginTop();
        }
        return 0;
    }

    private void r() {
        if (t()) {
            ((com.coui.appcompat.edittext.a) this.f7759D).e();
        }
    }

    private void s(boolean z3) {
        ValueAnimator valueAnimator = this.f7778W;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7778W.cancel();
        }
        if (z3 && this.f7777V) {
            k(1.0f);
        } else {
            this.f7789k.T(1.0f);
        }
        this.f7776U = false;
        if (t()) {
            H();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f7755B)) {
            return;
        }
        if (Locale.getDefault().getLanguage().equals("my")) {
            this.f7755B = charSequence;
            super.setHint(charSequence);
            this.f7789k.Z(null);
            return;
        }
        this.f7755B = charSequence;
        this.f7789k.Z(charSequence);
        if (!this.f7776U) {
            H();
        }
        com.coui.appcompat.edittext.b bVar = this.f7754A0;
        if (bVar != null) {
            bVar.J(this.f7789k);
        }
        setContentDescription(charSequence);
    }

    private boolean t() {
        return this.f7753A && !TextUtils.isEmpty(this.f7755B) && (this.f7759D instanceof com.coui.appcompat.edittext.a);
    }

    private void u(boolean z3) {
        if (this.f7759D != null) {
            Log.d("COUIEditText", "mBoxBackground: " + this.f7759D.getBounds());
        }
        ValueAnimator valueAnimator = this.f7778W;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7778W.cancel();
        }
        if (z3 && this.f7777V) {
            k(0.0f);
        } else {
            this.f7789k.T(0.0f);
        }
        if (t() && ((com.coui.appcompat.edittext.a) this.f7759D).b()) {
            r();
        }
        this.f7776U = true;
    }

    private boolean v(Rect rect) {
        int compoundPaddingLeft = D() ? (getCompoundPaddingLeft() - this.f7802q0) - getCompoundDrawablePadding() : (getWidth() - getCompoundPaddingRight()) + getCompoundDrawablePadding();
        int i3 = this.f7802q0 + compoundPaddingLeft;
        int height = ((((getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom()) - this.f7802q0) / 2) + getCompoundPaddingTop();
        rect.set(compoundPaddingLeft, height, i3, this.f7802q0 + height);
        return true;
    }

    private void w(Context context, AttributeSet attributeSet, int i3) {
        this.f7789k.a0(new Y.d());
        this.f7789k.X(new Y.d());
        this.f7789k.O(8388659);
        this.f7791l = new Y.e();
        this.f7793m = new Y.c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1509A, i3, M1.l.f1503c);
        this.f7753A = obtainStyledAttributes.getBoolean(m.f1533R, false);
        setTopHint(obtainStyledAttributes.getText(m.f1513C));
        if (this.f7753A) {
            this.f7777V = obtainStyledAttributes.getBoolean(m.f1532Q, true);
        }
        this.f7794m0 = obtainStyledAttributes.getDimensionPixelOffset(m.f1537V, 0);
        float dimension = obtainStyledAttributes.getDimension(m.f1519F, 0.0f);
        this.f7762G = dimension;
        this.f7763H = dimension;
        this.f7764I = dimension;
        this.f7765J = dimension;
        this.f7773R = obtainStyledAttributes.getColor(m.f1534S, AbstractC0335a.b(context, M1.c.f1374s, 0));
        this.f7766K = obtainStyledAttributes.getDimensionPixelSize(m.f1535T, 0);
        this.f7767L = obtainStyledAttributes.getDimensionPixelSize(m.f1531P, this.f7767L);
        this.f7798o0 = context.getResources().getDimensionPixelOffset(M1.f.f1430Y);
        if (this.f7753A) {
            this.f7760E = context.getResources().getDimensionPixelOffset(M1.f.f1429X);
            this.f7796n0 = context.getResources().getDimensionPixelOffset(M1.f.f1433a0);
            this.f7800p0 = context.getResources().getDimensionPixelOffset(M1.f.f1431Z);
        }
        int i4 = obtainStyledAttributes.getInt(m.f1521G, 0);
        setBoxBackgroundMode(i4);
        if (this.f7761F != 0) {
            setBackgroundDrawable(null);
        }
        if (obtainStyledAttributes.hasValue(m.f1511B)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(m.f1511B);
            this.f7770O = colorStateList;
            this.f7771P = colorStateList;
        }
        this.f7772Q = obtainStyledAttributes.getColor(m.f1523H, 0);
        this.f7774S = obtainStyledAttributes.getColor(m.f1524I, 0);
        String string = obtainStyledAttributes.getString(m.f1530O);
        this.f7810u0 = string;
        setText(string);
        K(obtainStyledAttributes.getDimensionPixelSize(m.f1517E, 0), obtainStyledAttributes.getColorStateList(m.f1515D));
        if (i4 == 2) {
            this.f7789k.b0(Typeface.create("sans-serif-medium", 0));
        }
        obtainStyledAttributes.recycle();
        this.f7787i0 = new Paint();
        TextPaint textPaint = new TextPaint();
        this.f7788j0 = textPaint;
        textPaint.setTextSize(getTextSize());
        Paint paint = new Paint();
        this.f7785g0 = paint;
        paint.setColor(this.f7772Q);
        Paint paint2 = new Paint();
        this.f7786h0 = paint2;
        paint2.setColor(this.f7774S);
        Paint paint3 = new Paint();
        this.f7784f0 = paint3;
        paint3.setColor(this.f7773R);
        L();
    }

    private boolean y(String str) {
        if (str == null) {
            return false;
        }
        return TextUtils.isEmpty(str);
    }

    public boolean A() {
        return this.f7803r;
    }

    public boolean C() {
        return this.f7753A;
    }

    public boolean E() {
        return this.f7818y0;
    }

    public void G() {
        Editable text = getText();
        text.delete(0, text.length());
    }

    public void I() {
        TypedArray obtainStyledAttributes;
        Drawable drawable;
        String resourceTypeName = getResources().getResourceTypeName(this.f7795n);
        if ("attr".equals(resourceTypeName)) {
            obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, m.f1509A, this.f7795n, 0);
        } else if (!"style".equals(resourceTypeName)) {
            return;
        } else {
            obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, m.f1509A, 0, this.f7795n);
        }
        if (obtainStyledAttributes.hasValue(m.f1511B)) {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(m.f1511B);
            this.f7770O = colorStateList;
            this.f7771P = colorStateList;
            if (colorStateList == null) {
                this.f7770O = getHintTextColors();
            }
        }
        this.f7775T = obtainStyledAttributes.getColor(m.f1527L, AbstractC0335a.a(getContext(), M1.c.f1365j));
        this.f7773R = obtainStyledAttributes.getColor(m.f1534S, AbstractC0335a.b(getContext(), M1.c.f1374s, 0));
        this.f7772Q = obtainStyledAttributes.getColor(m.f1523H, 0);
        this.f7774S = obtainStyledAttributes.getColor(m.f1524I, 0);
        this.f7754A0.C(this.f7775T);
        this.f7785g0.setColor(this.f7772Q);
        this.f7786h0.setColor(this.f7774S);
        this.f7784f0.setColor(this.f7773R);
        this.f7797o = obtainStyledAttributes.getDrawable(m.f1525J);
        this.f7799p = obtainStyledAttributes.getDrawable(m.f1526K);
        Drawable drawable2 = this.f7797o;
        if (drawable2 != null) {
            this.f7802q0 = drawable2.getIntrinsicWidth();
            int intrinsicHeight = this.f7797o.getIntrinsicHeight();
            this.f7804r0 = intrinsicHeight;
            this.f7797o.setBounds(0, 0, this.f7802q0, intrinsicHeight);
        }
        Drawable drawable3 = this.f7799p;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.f7802q0, this.f7804r0);
        }
        if (this.f7803r && this.f7818y0 && !TextUtils.isEmpty(getText()) && hasFocus() && this.f7805s && (drawable = this.f7797o) != null) {
            setCompoundDrawables(null, null, drawable, null);
        }
        T();
        obtainStyledAttributes.recycle();
        invalidate();
    }

    public void K(int i3, ColorStateList colorStateList) {
        this.f7789k.M(i3, colorStateList);
        this.f7771P = this.f7789k.o();
        O(false);
        this.f7754A0.B(i3, colorStateList);
    }

    public void O(boolean z3) {
        P(z3, false);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        f fVar;
        if (x() && (fVar = this.f7813w) != null && fVar.k(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        if (this.f7811v) {
            onStartTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (getMaxLines() < 2 && this.f7808t0) {
            M();
        }
        if (getHintTextColors() != this.f7770O) {
            O(false);
        }
        int save = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        if (this.f7753A || getText().length() == 0) {
            this.f7789k.k(canvas);
        } else {
            canvas.drawText(" ", 0.0f, 0.0f, this.f7787i0);
        }
        if (this.f7759D != null && this.f7761F == 2) {
            if (getScrollX() != 0) {
                S();
            }
            if (this.f7754A0.v()) {
                this.f7754A0.o(canvas, this.f7759D, this.f7768M);
            } else {
                this.f7759D.draw(canvas);
            }
        }
        if (this.f7761F == 1) {
            int height = getHeight();
            this.f7784f0.setAlpha(this.f7790k0);
            if (isEnabled()) {
                if (this.f7754A0.v()) {
                    this.f7754A0.n(canvas, height, getWidth(), (int) (this.f7792l0 * getWidth()), this.f7785g0, this.f7784f0);
                } else {
                    if (!this.f7820z0) {
                        canvas.drawRect(0.0f, height - this.f7766K, getWidth(), height, this.f7785g0);
                    }
                    if (hasFocus()) {
                        canvas.drawRect(0.0f, height - this.f7767L, this.f7792l0 * getWidth(), height, this.f7784f0);
                    }
                }
            } else if (!this.f7820z0) {
                canvas.drawRect(0.0f, height - this.f7766K, getWidth(), height, this.f7786h0);
            }
        }
        canvas.restoreToCount(save);
        super.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // androidx.appcompat.widget.C0236j, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.f7781c0
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.f7781c0 = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            boolean r2 = r4.f7753A
            r3 = 0
            if (r2 == 0) goto L26
            boolean r2 = androidx.core.view.y.O(r4)
            if (r2 == 0) goto L21
            boolean r2 = r4.isEnabled()
            if (r2 == 0) goto L21
            goto L22
        L21:
            r0 = r3
        L22:
            r4.O(r0)
            goto L29
        L26:
            r4.O(r3)
        L29:
            r4.Q()
            boolean r0 = r4.f7753A
            if (r0 == 0) goto L44
            r4.S()
            r4.T()
            com.coui.appcompat.edittext.a$a r0 = r4.f7789k
            if (r0 == 0) goto L44
            boolean r0 = r0.Y(r1)
            com.coui.appcompat.edittext.b r2 = r4.f7754A0
            r2.p(r1)
            goto L45
        L44:
            r0 = r3
        L45:
            if (r0 == 0) goto L4a
            r4.invalidate()
        L4a:
            r4.f7781c0 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.edittext.COUIEditText.drawableStateChanged():void");
    }

    public Rect getBackgroundRect() {
        int i3 = this.f7761F;
        if ((i3 == 1 || i3 == 2 || i3 == 3) && getBoxBackground() != null) {
            getBoxBackground().getBounds();
        }
        return null;
    }

    public int getBoxStrokeColor() {
        return this.f7773R;
    }

    public String getCouiEditTexttNoEllipsisText() {
        return this.f7806s0 ? this.f7810u0 : String.valueOf(getText());
    }

    public int getDeleteButtonLeft() {
        Drawable drawable = this.f7797o;
        return ((getRight() - getLeft()) - getPaddingRight()) - (drawable != null ? drawable.getIntrinsicWidth() : 0);
    }

    public int getDeleteIconWidth() {
        return this.f7802q0;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        if (this.f7753A) {
            return this.f7755B;
        }
        return null;
    }

    public int getLabelMarginTop() {
        if (this.f7753A) {
            return (int) (this.f7789k.q() / 2.0f);
        }
        return 0;
    }

    l getTextDeleteListener() {
        return null;
    }

    public void j(j jVar) {
        this.f7754A0.l(jVar);
    }

    @Override // androidx.appcompat.widget.C0236j, android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7754A0.x(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z3, int i3, Rect rect) {
        super.onFocusChanged(z3, i3, rect);
        if (this.f7803r) {
            N(z3);
        }
        View.OnFocusChangeListener onFocusChangeListener = this.f7814w0;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(this, z3);
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (!this.f7803r || i3 != 67) {
            return super.onKeyDown(i3, keyEvent);
        }
        super.onKeyDown(i3, keyEvent);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        if (this.f7759D != null) {
            S();
        }
        if (this.f7753A) {
            R();
        }
        int compoundPaddingLeft = getCompoundPaddingLeft();
        int width = getWidth() - getCompoundPaddingRight();
        int q3 = q();
        this.f7789k.P(compoundPaddingLeft, getCompoundPaddingTop(), width, getHeight() - getCompoundPaddingBottom());
        this.f7789k.L(compoundPaddingLeft, q3, width, getHeight() - getCompoundPaddingBottom());
        this.f7789k.J();
        if (t() && !this.f7776U) {
            H();
        }
        this.f7754A0.y(this.f7789k);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        String str;
        if (getMaxLines() < 2 && this.f7808t0 && (parcelable instanceof g) && (str = ((g) parcelable).f7830e) != null) {
            setText(str);
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (getMaxLines() >= 2 || !this.f7808t0 || isFocused()) {
            return onSaveInstanceState;
        }
        g gVar = new g(onSaveInstanceState);
        gVar.f7830e = getCouiEditTexttNoEllipsisText();
        return gVar;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f7818y0 && this.f7803r && !TextUtils.isEmpty(getText()) && hasFocus()) {
            Rect rect = new Rect();
            boolean z3 = v(rect) && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (this.f7805s && z3) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f7801q = true;
                    return true;
                }
                if (action != 1) {
                    if (action == 2 && this.f7801q) {
                        return true;
                    }
                } else if (this.f7801q) {
                    G();
                    this.f7801q = false;
                    return true;
                }
            }
        }
        View.OnTouchListener onTouchListener = this.f7816x0;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        this.f7812v0 = getSelectionEnd();
        return onTouchEvent;
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.f7761F) {
            return;
        }
        this.f7761F = i3;
        F();
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f7773R != i3) {
            this.f7773R = i3;
            this.f7784f0.setColor(i3);
            T();
        }
    }

    @Override // androidx.appcompat.widget.C0236j, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (drawable3 != null) {
            this.f7807t = drawable3.getBounds().width();
        } else {
            this.f7807t = 0;
        }
    }

    public void setCouiEditTexttNoEllipsisText(String str) {
        this.f7810u0 = str;
        setText(str);
    }

    public void setCustomEditTextOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f7816x0 = onTouchListener;
    }

    public void setDefaultStrokeColor(int i3) {
        if (this.f7772Q != i3) {
            this.f7772Q = i3;
            this.f7785g0.setColor(i3);
            T();
        }
    }

    public void setDisabledStrokeColor(int i3) {
        if (this.f7774S != i3) {
            this.f7774S = i3;
            this.f7786h0.setColor(i3);
            T();
        }
    }

    public void setEditFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f7814w0 = onFocusChangeListener;
    }

    public void setEditTextColor(int i3) {
        setTextColor(i3);
        this.f7754A0.K(getTextColors());
    }

    public void setEditTextDeleteIconNormal(Drawable drawable) {
        if (drawable != null) {
            this.f7797o = drawable;
            this.f7802q0 = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f7797o.getIntrinsicHeight();
            this.f7804r0 = intrinsicHeight;
            this.f7797o.setBounds(0, 0, this.f7802q0, intrinsicHeight);
            invalidate();
        }
    }

    public void setEditTextDeleteIconPressed(Drawable drawable) {
        if (drawable != null) {
            this.f7799p = drawable;
            drawable.setBounds(0, 0, this.f7802q0, this.f7804r0);
            invalidate();
        }
    }

    public void setEditTextErrorColor(int i3) {
        if (i3 != this.f7775T) {
            this.f7775T = i3;
            this.f7754A0.C(i3);
            invalidate();
        }
    }

    public void setErrorState(boolean z3) {
        this.f7782d0 = z3;
        this.f7754A0.D(z3);
    }

    public void setFastDeletable(boolean z3) {
        if (this.f7803r != z3) {
            this.f7803r = z3;
            if (z3 && this.f7817y == null) {
                h hVar = new h(this, null);
                this.f7817y = hVar;
                addTextChangedListener(hVar);
            }
        }
    }

    public void setHintEnabled(boolean z3) {
        if (z3 != this.f7753A) {
            this.f7753A = z3;
            if (!z3) {
                this.f7757C = false;
                if (!TextUtils.isEmpty(this.f7755B) && TextUtils.isEmpty(getHint())) {
                    setHint(this.f7755B);
                }
                setHintInternal(null);
                return;
            }
            CharSequence hint = getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f7755B)) {
                    setTopHint(hint);
                }
                setHint((CharSequence) null);
            }
            this.f7757C = true;
        }
    }

    public void setInputConnectionListener(i iVar) {
    }

    public void setIsEllipsisEnabled(boolean z3) {
        this.f7808t0 = z3;
    }

    public void setJustShowFocusLine(boolean z3) {
        this.f7820z0 = z3;
    }

    public void setOnTextDeletedListener(l lVar) {
    }

    public void setShowDeleteIcon(boolean z3) {
        this.f7818y0 = z3;
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        Selection.setSelection(getText(), length());
    }

    public void setTextDeletedListener(k kVar) {
    }

    public void setTopHint(CharSequence charSequence) {
        setHintInternal(charSequence);
    }

    public void setmHintAnimationEnabled(boolean z3) {
        this.f7777V = z3;
    }

    public boolean x() {
        return this.f7803r && !y(getText().toString()) && hasFocus();
    }

    public boolean z() {
        return this.f7754A0.v();
    }

    public COUIEditText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a.C0101a c0101a = new a.C0101a(this);
        this.f7789k = c0101a;
        this.f7801q = false;
        this.f7803r = false;
        this.f7805s = false;
        this.f7811v = false;
        this.f7815x = null;
        this.f7817y = null;
        this.f7766K = 1;
        this.f7767L = 3;
        this.f7769N = new RectF();
        this.f7806s0 = false;
        this.f7808t0 = false;
        this.f7810u0 = "";
        this.f7812v0 = 0;
        this.f7818y0 = true;
        this.f7820z0 = false;
        this.f7756B0 = new a();
        this.f7758C0 = new b();
        if (attributeSet != null) {
            this.f7795n = attributeSet.getStyleAttribute();
        }
        if (this.f7795n == 0) {
            this.f7795n = i3;
        }
        this.f7809u = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1509A, i3, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(m.f1536U, false);
        this.f7775T = obtainStyledAttributes.getColor(m.f1527L, AbstractC0335a.a(context, M1.c.f1365j));
        this.f7797o = obtainStyledAttributes.getDrawable(m.f1525J);
        this.f7799p = obtainStyledAttributes.getDrawable(m.f1526K);
        this.f7808t0 = obtainStyledAttributes.getBoolean(m.f1529N, true);
        int i4 = obtainStyledAttributes.getInt(m.f1528M, 1);
        c0101a.U(i4);
        obtainStyledAttributes.recycle();
        setFastDeletable(z3);
        Drawable drawable = this.f7797o;
        if (drawable != null) {
            this.f7802q0 = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f7797o.getIntrinsicHeight();
            this.f7804r0 = intrinsicHeight;
            this.f7797o.setBounds(0, 0, this.f7802q0, intrinsicHeight);
        }
        Drawable drawable2 = this.f7799p;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.f7802q0, this.f7804r0);
        }
        c0101a.V(context.getResources().getDimensionPixelSize(M1.f.f1453m));
        f fVar = new f(this);
        this.f7813w = fVar;
        y.j0(this, fVar);
        y.u0(this, 1);
        this.f7815x = this.f7809u.getString(M1.k.f1497g);
        this.f7813w.t();
        this.f7754A0 = new com.coui.appcompat.edittext.b(this, i4);
        w(context, attributeSet, i3);
        this.f7754A0.t(this.f7775T, this.f7767L, this.f7761F, getCornerRadiiAsArray(), c0101a);
    }
}
