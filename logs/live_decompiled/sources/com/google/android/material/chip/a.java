package com.google.android.material.chip;

import H0.j;
import I0.c;
import R0.d;
import S0.b;
import U0.g;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import f.AbstractC0348a;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes.dex */
public class a extends g implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {

    /* renamed from: N0, reason: collision with root package name */
    private static final int[] f9544N0 = {R.attr.state_enabled};

    /* renamed from: O0, reason: collision with root package name */
    private static final ShapeDrawable f9545O0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A0, reason: collision with root package name */
    private int f9546A0;

    /* renamed from: B0, reason: collision with root package name */
    private ColorFilter f9547B0;

    /* renamed from: C0, reason: collision with root package name */
    private PorterDuffColorFilter f9548C0;

    /* renamed from: D, reason: collision with root package name */
    private ColorStateList f9549D;

    /* renamed from: D0, reason: collision with root package name */
    private ColorStateList f9550D0;

    /* renamed from: E, reason: collision with root package name */
    private ColorStateList f9551E;

    /* renamed from: E0, reason: collision with root package name */
    private PorterDuff.Mode f9552E0;

    /* renamed from: F, reason: collision with root package name */
    private float f9553F;

    /* renamed from: F0, reason: collision with root package name */
    private int[] f9554F0;

    /* renamed from: G, reason: collision with root package name */
    private float f9555G;

    /* renamed from: G0, reason: collision with root package name */
    private boolean f9556G0;

    /* renamed from: H, reason: collision with root package name */
    private ColorStateList f9557H;

    /* renamed from: H0, reason: collision with root package name */
    private ColorStateList f9558H0;

    /* renamed from: I, reason: collision with root package name */
    private float f9559I;

    /* renamed from: I0, reason: collision with root package name */
    private WeakReference f9560I0;

    /* renamed from: J, reason: collision with root package name */
    private ColorStateList f9561J;

    /* renamed from: J0, reason: collision with root package name */
    private TextUtils.TruncateAt f9562J0;

    /* renamed from: K, reason: collision with root package name */
    private CharSequence f9563K;

    /* renamed from: K0, reason: collision with root package name */
    private boolean f9564K0;

    /* renamed from: L, reason: collision with root package name */
    private boolean f9565L;

    /* renamed from: L0, reason: collision with root package name */
    private int f9566L0;

    /* renamed from: M, reason: collision with root package name */
    private Drawable f9567M;

    /* renamed from: M0, reason: collision with root package name */
    private boolean f9568M0;

    /* renamed from: N, reason: collision with root package name */
    private ColorStateList f9569N;

    /* renamed from: O, reason: collision with root package name */
    private float f9570O;

    /* renamed from: P, reason: collision with root package name */
    private boolean f9571P;

    /* renamed from: Q, reason: collision with root package name */
    private boolean f9572Q;

    /* renamed from: R, reason: collision with root package name */
    private Drawable f9573R;

    /* renamed from: S, reason: collision with root package name */
    private Drawable f9574S;

    /* renamed from: T, reason: collision with root package name */
    private ColorStateList f9575T;

    /* renamed from: U, reason: collision with root package name */
    private float f9576U;

    /* renamed from: V, reason: collision with root package name */
    private CharSequence f9577V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f9578W;

    /* renamed from: X, reason: collision with root package name */
    private boolean f9579X;

    /* renamed from: Y, reason: collision with root package name */
    private Drawable f9580Y;

    /* renamed from: Z, reason: collision with root package name */
    private ColorStateList f9581Z;

    /* renamed from: a0, reason: collision with root package name */
    private c f9582a0;

    /* renamed from: b0, reason: collision with root package name */
    private c f9583b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f9584c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f9585d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f9586e0;

    /* renamed from: f0, reason: collision with root package name */
    private float f9587f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f9588g0;

    /* renamed from: h0, reason: collision with root package name */
    private float f9589h0;

    /* renamed from: i0, reason: collision with root package name */
    private float f9590i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f9591j0;

    /* renamed from: k0, reason: collision with root package name */
    private final Context f9592k0;

    /* renamed from: l0, reason: collision with root package name */
    private final Paint f9593l0;

    /* renamed from: m0, reason: collision with root package name */
    private final Paint f9594m0;

    /* renamed from: n0, reason: collision with root package name */
    private final Paint.FontMetrics f9595n0;

    /* renamed from: o0, reason: collision with root package name */
    private final RectF f9596o0;

    /* renamed from: p0, reason: collision with root package name */
    private final PointF f9597p0;

    /* renamed from: q0, reason: collision with root package name */
    private final Path f9598q0;

    /* renamed from: r0, reason: collision with root package name */
    private final TextDrawableHelper f9599r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f9600s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f9601t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f9602u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f9603v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f9604w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f9605x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f9606y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f9607z0;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0120a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f9555G = -1.0f;
        this.f9593l0 = new Paint(1);
        this.f9595n0 = new Paint.FontMetrics();
        this.f9596o0 = new RectF();
        this.f9597p0 = new PointF();
        this.f9598q0 = new Path();
        this.f9546A0 = 255;
        this.f9552E0 = PorterDuff.Mode.SRC_IN;
        this.f9560I0 = new WeakReference(null);
        K(context);
        this.f9592k0 = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.f9599r0 = textDrawableHelper;
        this.f9563K = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.f9594m0 = null;
        int[] iArr = f9544N0;
        setState(iArr);
        h2(iArr);
        this.f9564K0 = true;
        if (b.f2070a) {
            f9545O0.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect) {
        if (this.f9563K != null) {
            Paint.Align p02 = p0(rect, this.f9597p0);
            n0(rect, this.f9596o0);
            if (this.f9599r0.getTextAppearance() != null) {
                this.f9599r0.getTextPaint().drawableState = getState();
                this.f9599r0.updateTextPaintDrawState(this.f9592k0);
            }
            this.f9599r0.getTextPaint().setTextAlign(p02);
            int i3 = 0;
            boolean z3 = Math.round(this.f9599r0.getTextWidth(d1().toString())) > Math.round(this.f9596o0.width());
            if (z3) {
                i3 = canvas.save();
                canvas.clipRect(this.f9596o0);
            }
            CharSequence charSequence = this.f9563K;
            if (z3 && this.f9562J0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.f9599r0.getTextPaint(), this.f9596o0.width(), this.f9562J0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.f9597p0;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.f9599r0.getTextPaint());
            if (z3) {
                canvas.restoreToCount(i3);
            }
        }
    }

    private boolean I2() {
        return this.f9579X && this.f9580Y != null && this.f9606y0;
    }

    private boolean J2() {
        return this.f9565L && this.f9567M != null;
    }

    private boolean K2() {
        return this.f9572Q && this.f9573R != null;
    }

    private void L2(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void M2() {
        this.f9558H0 = this.f9556G0 ? b.a(this.f9561J) : null;
    }

    private void N2() {
        this.f9574S = new RippleDrawable(b.a(b1()), this.f9573R, f9545O0);
    }

    private float V0() {
        Drawable drawable = this.f9606y0 ? this.f9580Y : this.f9567M;
        float f3 = this.f9570O;
        if (f3 > 0.0f || drawable == null) {
            return f3;
        }
        float ceil = (float) Math.ceil(ViewUtils.dpToPx(this.f9592k0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= ceil ? drawable.getIntrinsicHeight() : ceil;
    }

    private float W0() {
        Drawable drawable = this.f9606y0 ? this.f9580Y : this.f9567M;
        float f3 = this.f9570O;
        return (f3 > 0.0f || drawable == null) ? f3 : drawable.getIntrinsicWidth();
    }

    private void X1(ColorStateList colorStateList) {
        if (this.f9549D != colorStateList) {
            this.f9549D = colorStateList;
            onStateChange(getState());
        }
    }

    private void g0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.g(drawable, androidx.core.graphics.drawable.a.b(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f9573R) {
            if (drawable.isStateful()) {
                drawable.setState(S0());
            }
            androidx.core.graphics.drawable.a.i(drawable, this.f9575T);
            return;
        }
        Drawable drawable2 = this.f9567M;
        if (drawable == drawable2 && this.f9571P) {
            androidx.core.graphics.drawable.a.i(drawable2, this.f9569N);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void h0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (J2() || I2()) {
            float f3 = this.f9584c0 + this.f9585d0;
            float W02 = W0();
            if (androidx.core.graphics.drawable.a.b(this) == 0) {
                float f4 = rect.left + f3;
                rectF.left = f4;
                rectF.right = f4 + W02;
            } else {
                float f5 = rect.right - f3;
                rectF.right = f5;
                rectF.left = f5 - W02;
            }
            float V02 = V0();
            float exactCenterY = rect.exactCenterY() - (V02 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + V02;
        }
    }

    private ColorFilter h1() {
        ColorFilter colorFilter = this.f9547B0;
        return colorFilter != null ? colorFilter : this.f9548C0;
    }

    private void j0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (K2()) {
            float f3 = this.f9591j0 + this.f9590i0 + this.f9576U + this.f9589h0 + this.f9588g0;
            if (androidx.core.graphics.drawable.a.b(this) == 0) {
                rectF.right = rect.right - f3;
            } else {
                rectF.left = rect.left + f3;
            }
        }
    }

    private static boolean j1(int[] iArr, int i3) {
        if (iArr == null) {
            return false;
        }
        for (int i4 : iArr) {
            if (i4 == i3) {
                return true;
            }
        }
        return false;
    }

    private void k0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2()) {
            float f3 = this.f9591j0 + this.f9590i0;
            if (androidx.core.graphics.drawable.a.b(this) == 0) {
                float f4 = rect.right - f3;
                rectF.right = f4;
                rectF.left = f4 - this.f9576U;
            } else {
                float f5 = rect.left + f3;
                rectF.left = f5;
                rectF.right = f5 + this.f9576U;
            }
            float exactCenterY = rect.exactCenterY();
            float f6 = this.f9576U;
            float f7 = exactCenterY - (f6 / 2.0f);
            rectF.top = f7;
            rectF.bottom = f7 + f6;
        }
    }

    private void l0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (K2()) {
            float f3 = this.f9591j0 + this.f9590i0 + this.f9576U + this.f9589h0 + this.f9588g0;
            if (androidx.core.graphics.drawable.a.b(this) == 0) {
                float f4 = rect.right;
                rectF.right = f4;
                rectF.left = f4 - f3;
            } else {
                int i3 = rect.left;
                rectF.left = i3;
                rectF.right = i3 + f3;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void n0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f9563K != null) {
            float i02 = this.f9584c0 + i0() + this.f9587f0;
            float m02 = this.f9591j0 + m0() + this.f9588g0;
            if (androidx.core.graphics.drawable.a.b(this) == 0) {
                rectF.left = rect.left + i02;
                rectF.right = rect.right - m02;
            } else {
                rectF.left = rect.left + m02;
                rectF.right = rect.right - i02;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean n1(d dVar) {
        return (dVar == null || dVar.i() == null || !dVar.i().isStateful()) ? false : true;
    }

    private float o0() {
        this.f9599r0.getTextPaint().getFontMetrics(this.f9595n0);
        Paint.FontMetrics fontMetrics = this.f9595n0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean o1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean p1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private boolean q0() {
        return this.f9579X && this.f9580Y != null && this.f9578W;
    }

    private void q1(AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.f9592k0, attributeSet, j.f780f0, i3, i4, new int[0]);
        this.f9568M0 = obtainStyledAttributes.hasValue(j.f722Q0);
        X1(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f670D0));
        B1(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f824q0));
        P1(obtainStyledAttributes.getDimension(j.f856y0, 0.0f));
        if (obtainStyledAttributes.hasValue(j.f828r0)) {
            D1(obtainStyledAttributes.getDimension(j.f828r0, 0.0f));
        }
        T1(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f662B0));
        V1(obtainStyledAttributes.getDimension(j.f666C0, 0.0f));
        u2(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f718P0));
        z2(obtainStyledAttributes.getText(j.f800k0));
        d f3 = R0.c.f(this.f9592k0, obtainStyledAttributes, j.f784g0);
        f3.l(obtainStyledAttributes.getDimension(j.f788h0, f3.j()));
        A2(f3);
        int i5 = obtainStyledAttributes.getInt(j.f792i0, 0);
        if (i5 == 1) {
            m2(TextUtils.TruncateAt.START);
        } else if (i5 == 2) {
            m2(TextUtils.TruncateAt.MIDDLE);
        } else if (i5 == 3) {
            m2(TextUtils.TruncateAt.END);
        }
        O1(obtainStyledAttributes.getBoolean(j.f852x0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            O1(obtainStyledAttributes.getBoolean(j.f840u0, false));
        }
        H1(R0.c.d(this.f9592k0, obtainStyledAttributes, j.f836t0));
        if (obtainStyledAttributes.hasValue(j.f848w0)) {
            L1(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f848w0));
        }
        J1(obtainStyledAttributes.getDimension(j.f844v0, -1.0f));
        k2(obtainStyledAttributes.getBoolean(j.f698K0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            k2(obtainStyledAttributes.getBoolean(j.f678F0, false));
        }
        Y1(R0.c.d(this.f9592k0, obtainStyledAttributes, j.f674E0));
        i2(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f694J0));
        d2(obtainStyledAttributes.getDimension(j.f686H0, 0.0f));
        t1(obtainStyledAttributes.getBoolean(j.f804l0, false));
        A1(obtainStyledAttributes.getBoolean(j.f820p0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            A1(obtainStyledAttributes.getBoolean(j.f812n0, false));
        }
        v1(R0.c.d(this.f9592k0, obtainStyledAttributes, j.f808m0));
        if (obtainStyledAttributes.hasValue(j.f816o0)) {
            x1(R0.c.a(this.f9592k0, obtainStyledAttributes, j.f816o0));
        }
        x2(c.b(this.f9592k0, obtainStyledAttributes, j.f726R0));
        n2(c.b(this.f9592k0, obtainStyledAttributes, j.f706M0));
        R1(obtainStyledAttributes.getDimension(j.f658A0, 0.0f));
        r2(obtainStyledAttributes.getDimension(j.f714O0, 0.0f));
        p2(obtainStyledAttributes.getDimension(j.f710N0, 0.0f));
        E2(obtainStyledAttributes.getDimension(j.f734T0, 0.0f));
        C2(obtainStyledAttributes.getDimension(j.f730S0, 0.0f));
        f2(obtainStyledAttributes.getDimension(j.f690I0, 0.0f));
        a2(obtainStyledAttributes.getDimension(j.f682G0, 0.0f));
        F1(obtainStyledAttributes.getDimension(j.f832s0, 0.0f));
        t2(obtainStyledAttributes.getDimensionPixelSize(j.f796j0, Preference.DEFAULT_ORDER));
        obtainStyledAttributes.recycle();
    }

    public static a r0(Context context, AttributeSet attributeSet, int i3, int i4) {
        a aVar = new a(context, attributeSet, i3, i4);
        aVar.q1(attributeSet, i3, i4);
        return aVar;
    }

    private void s0(Canvas canvas, Rect rect) {
        if (I2()) {
            h0(rect, this.f9596o0);
            RectF rectF = this.f9596o0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.f9580Y.setBounds(0, 0, (int) this.f9596o0.width(), (int) this.f9596o0.height());
            this.f9580Y.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private boolean s1(int[] iArr, int[] iArr2) {
        boolean z3;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f9549D;
        int k3 = k(colorStateList != null ? colorStateList.getColorForState(iArr, this.f9600s0) : 0);
        boolean z4 = true;
        if (this.f9600s0 != k3) {
            this.f9600s0 = k3;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.f9551E;
        int k4 = k(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f9601t0) : 0);
        if (this.f9601t0 != k4) {
            this.f9601t0 = k4;
            onStateChange = true;
        }
        int g3 = L0.a.g(k3, k4);
        if ((this.f9602u0 != g3) | (w() == null)) {
            this.f9602u0 = g3;
            U(ColorStateList.valueOf(g3));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.f9557H;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f9603v0) : 0;
        if (this.f9603v0 != colorForState) {
            this.f9603v0 = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.f9558H0 == null || !b.b(iArr)) ? 0 : this.f9558H0.getColorForState(iArr, this.f9604w0);
        if (this.f9604w0 != colorForState2) {
            this.f9604w0 = colorForState2;
            if (this.f9556G0) {
                onStateChange = true;
            }
        }
        int colorForState3 = (this.f9599r0.getTextAppearance() == null || this.f9599r0.getTextAppearance().i() == null) ? 0 : this.f9599r0.getTextAppearance().i().getColorForState(iArr, this.f9605x0);
        if (this.f9605x0 != colorForState3) {
            this.f9605x0 = colorForState3;
            onStateChange = true;
        }
        boolean z5 = j1(getState(), R.attr.state_checked) && this.f9578W;
        if (this.f9606y0 == z5 || this.f9580Y == null) {
            z3 = false;
        } else {
            float i02 = i0();
            this.f9606y0 = z5;
            if (i02 != i0()) {
                onStateChange = true;
                z3 = true;
            } else {
                z3 = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f9550D0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f9607z0) : 0;
        if (this.f9607z0 != colorForState4) {
            this.f9607z0 = colorForState4;
            this.f9548C0 = N0.a.a(this, this.f9550D0, this.f9552E0);
        } else {
            z4 = onStateChange;
        }
        if (p1(this.f9567M)) {
            z4 |= this.f9567M.setState(iArr);
        }
        if (p1(this.f9580Y)) {
            z4 |= this.f9580Y.setState(iArr);
        }
        if (p1(this.f9573R)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z4 |= this.f9573R.setState(iArr3);
        }
        if (b.f2070a && p1(this.f9574S)) {
            z4 |= this.f9574S.setState(iArr2);
        }
        if (z4) {
            invalidateSelf();
        }
        if (z3) {
            r1();
        }
        return z4;
    }

    private void t0(Canvas canvas, Rect rect) {
        if (this.f9568M0) {
            return;
        }
        this.f9593l0.setColor(this.f9601t0);
        this.f9593l0.setStyle(Paint.Style.FILL);
        this.f9593l0.setColorFilter(h1());
        this.f9596o0.set(rect);
        canvas.drawRoundRect(this.f9596o0, E0(), E0(), this.f9593l0);
    }

    private void u0(Canvas canvas, Rect rect) {
        if (J2()) {
            h0(rect, this.f9596o0);
            RectF rectF = this.f9596o0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.f9567M.setBounds(0, 0, (int) this.f9596o0.width(), (int) this.f9596o0.height());
            this.f9567M.draw(canvas);
            canvas.translate(-f3, -f4);
        }
    }

    private void v0(Canvas canvas, Rect rect) {
        if (this.f9559I <= 0.0f || this.f9568M0) {
            return;
        }
        this.f9593l0.setColor(this.f9603v0);
        this.f9593l0.setStyle(Paint.Style.STROKE);
        if (!this.f9568M0) {
            this.f9593l0.setColorFilter(h1());
        }
        RectF rectF = this.f9596o0;
        float f3 = rect.left;
        float f4 = this.f9559I;
        rectF.set(f3 + (f4 / 2.0f), rect.top + (f4 / 2.0f), rect.right - (f4 / 2.0f), rect.bottom - (f4 / 2.0f));
        float f5 = this.f9555G - (this.f9559I / 2.0f);
        canvas.drawRoundRect(this.f9596o0, f5, f5, this.f9593l0);
    }

    private void w0(Canvas canvas, Rect rect) {
        if (this.f9568M0) {
            return;
        }
        this.f9593l0.setColor(this.f9600s0);
        this.f9593l0.setStyle(Paint.Style.FILL);
        this.f9596o0.set(rect);
        canvas.drawRoundRect(this.f9596o0, E0(), E0(), this.f9593l0);
    }

    private void x0(Canvas canvas, Rect rect) {
        if (K2()) {
            k0(rect, this.f9596o0);
            RectF rectF = this.f9596o0;
            float f3 = rectF.left;
            float f4 = rectF.top;
            canvas.translate(f3, f4);
            this.f9573R.setBounds(0, 0, (int) this.f9596o0.width(), (int) this.f9596o0.height());
            if (b.f2070a) {
                this.f9574S.setBounds(this.f9573R.getBounds());
                this.f9574S.jumpToCurrentState();
                this.f9574S.draw(canvas);
            } else {
                this.f9573R.draw(canvas);
            }
            canvas.translate(-f3, -f4);
        }
    }

    private void y0(Canvas canvas, Rect rect) {
        this.f9593l0.setColor(this.f9604w0);
        this.f9593l0.setStyle(Paint.Style.FILL);
        this.f9596o0.set(rect);
        if (!this.f9568M0) {
            canvas.drawRoundRect(this.f9596o0, E0(), E0(), this.f9593l0);
        } else {
            g(new RectF(rect), this.f9598q0);
            super.p(canvas, this.f9593l0, this.f9598q0, t());
        }
    }

    private void z0(Canvas canvas, Rect rect) {
        Paint paint = this.f9594m0;
        if (paint != null) {
            paint.setColor(androidx.core.graphics.a.n(-16777216, 127));
            canvas.drawRect(rect, this.f9594m0);
            if (J2() || I2()) {
                h0(rect, this.f9596o0);
                canvas.drawRect(this.f9596o0, this.f9594m0);
            }
            if (this.f9563K != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f9594m0);
            }
            if (K2()) {
                k0(rect, this.f9596o0);
                canvas.drawRect(this.f9596o0, this.f9594m0);
            }
            this.f9594m0.setColor(androidx.core.graphics.a.n(-65536, 127));
            j0(rect, this.f9596o0);
            canvas.drawRect(this.f9596o0, this.f9594m0);
            this.f9594m0.setColor(androidx.core.graphics.a.n(-16711936, 127));
            l0(rect, this.f9596o0);
            canvas.drawRect(this.f9596o0, this.f9594m0);
        }
    }

    public void A1(boolean z3) {
        if (this.f9579X != z3) {
            boolean I22 = I2();
            this.f9579X = z3;
            boolean I23 = I2();
            if (I22 != I23) {
                if (I23) {
                    g0(this.f9580Y);
                } else {
                    L2(this.f9580Y);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public void A2(d dVar) {
        this.f9599r0.setTextAppearance(dVar, this.f9592k0);
    }

    public Drawable B0() {
        return this.f9580Y;
    }

    public void B1(ColorStateList colorStateList) {
        if (this.f9551E != colorStateList) {
            this.f9551E = colorStateList;
            onStateChange(getState());
        }
    }

    public void B2(int i3) {
        A2(new d(this.f9592k0, i3));
    }

    public ColorStateList C0() {
        return this.f9581Z;
    }

    public void C1(int i3) {
        B1(AbstractC0348a.a(this.f9592k0, i3));
    }

    public void C2(float f3) {
        if (this.f9588g0 != f3) {
            this.f9588g0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public ColorStateList D0() {
        return this.f9551E;
    }

    public void D1(float f3) {
        if (this.f9555G != f3) {
            this.f9555G = f3;
            setShapeAppearanceModel(B().w(f3));
        }
    }

    public void D2(int i3) {
        C2(this.f9592k0.getResources().getDimension(i3));
    }

    public float E0() {
        return this.f9568M0 ? D() : this.f9555G;
    }

    public void E1(int i3) {
        D1(this.f9592k0.getResources().getDimension(i3));
    }

    public void E2(float f3) {
        if (this.f9587f0 != f3) {
            this.f9587f0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public float F0() {
        return this.f9591j0;
    }

    public void F1(float f3) {
        if (this.f9591j0 != f3) {
            this.f9591j0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public void F2(int i3) {
        E2(this.f9592k0.getResources().getDimension(i3));
    }

    public Drawable G0() {
        Drawable drawable = this.f9567M;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.k(drawable);
        }
        return null;
    }

    public void G1(int i3) {
        F1(this.f9592k0.getResources().getDimension(i3));
    }

    public void G2(boolean z3) {
        if (this.f9556G0 != z3) {
            this.f9556G0 = z3;
            M2();
            onStateChange(getState());
        }
    }

    public float H0() {
        return this.f9570O;
    }

    public void H1(Drawable drawable) {
        Drawable G02 = G0();
        if (G02 != drawable) {
            float i02 = i0();
            this.f9567M = drawable != null ? androidx.core.graphics.drawable.a.l(drawable).mutate() : null;
            float i03 = i0();
            L2(G02);
            if (J2()) {
                g0(this.f9567M);
            }
            invalidateSelf();
            if (i02 != i03) {
                r1();
            }
        }
    }

    boolean H2() {
        return this.f9564K0;
    }

    public ColorStateList I0() {
        return this.f9569N;
    }

    public void I1(int i3) {
        H1(AbstractC0348a.b(this.f9592k0, i3));
    }

    public float J0() {
        return this.f9553F;
    }

    public void J1(float f3) {
        if (this.f9570O != f3) {
            float i02 = i0();
            this.f9570O = f3;
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                r1();
            }
        }
    }

    public float K0() {
        return this.f9584c0;
    }

    public void K1(int i3) {
        J1(this.f9592k0.getResources().getDimension(i3));
    }

    public ColorStateList L0() {
        return this.f9557H;
    }

    public void L1(ColorStateList colorStateList) {
        this.f9571P = true;
        if (this.f9569N != colorStateList) {
            this.f9569N = colorStateList;
            if (J2()) {
                androidx.core.graphics.drawable.a.i(this.f9567M, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float M0() {
        return this.f9559I;
    }

    public void M1(int i3) {
        L1(AbstractC0348a.a(this.f9592k0, i3));
    }

    public Drawable N0() {
        Drawable drawable = this.f9573R;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.k(drawable);
        }
        return null;
    }

    public void N1(int i3) {
        O1(this.f9592k0.getResources().getBoolean(i3));
    }

    public CharSequence O0() {
        return this.f9577V;
    }

    public void O1(boolean z3) {
        if (this.f9565L != z3) {
            boolean J22 = J2();
            this.f9565L = z3;
            boolean J23 = J2();
            if (J22 != J23) {
                if (J23) {
                    g0(this.f9567M);
                } else {
                    L2(this.f9567M);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public float P0() {
        return this.f9590i0;
    }

    public void P1(float f3) {
        if (this.f9553F != f3) {
            this.f9553F = f3;
            invalidateSelf();
            r1();
        }
    }

    public float Q0() {
        return this.f9576U;
    }

    public void Q1(int i3) {
        P1(this.f9592k0.getResources().getDimension(i3));
    }

    public float R0() {
        return this.f9589h0;
    }

    public void R1(float f3) {
        if (this.f9584c0 != f3) {
            this.f9584c0 = f3;
            invalidateSelf();
            r1();
        }
    }

    public int[] S0() {
        return this.f9554F0;
    }

    public void S1(int i3) {
        R1(this.f9592k0.getResources().getDimension(i3));
    }

    public ColorStateList T0() {
        return this.f9575T;
    }

    public void T1(ColorStateList colorStateList) {
        if (this.f9557H != colorStateList) {
            this.f9557H = colorStateList;
            if (this.f9568M0) {
                b0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void U0(RectF rectF) {
        l0(getBounds(), rectF);
    }

    public void U1(int i3) {
        T1(AbstractC0348a.a(this.f9592k0, i3));
    }

    public void V1(float f3) {
        if (this.f9559I != f3) {
            this.f9559I = f3;
            this.f9593l0.setStrokeWidth(f3);
            if (this.f9568M0) {
                super.c0(f3);
            }
            invalidateSelf();
        }
    }

    public void W1(int i3) {
        V1(this.f9592k0.getResources().getDimension(i3));
    }

    public TextUtils.TruncateAt X0() {
        return this.f9562J0;
    }

    public c Y0() {
        return this.f9583b0;
    }

    public void Y1(Drawable drawable) {
        Drawable N02 = N0();
        if (N02 != drawable) {
            float m02 = m0();
            this.f9573R = drawable != null ? androidx.core.graphics.drawable.a.l(drawable).mutate() : null;
            if (b.f2070a) {
                N2();
            }
            float m03 = m0();
            L2(N02);
            if (K2()) {
                g0(this.f9573R);
            }
            invalidateSelf();
            if (m02 != m03) {
                r1();
            }
        }
    }

    public float Z0() {
        return this.f9586e0;
    }

    public void Z1(CharSequence charSequence) {
        if (this.f9577V != charSequence) {
            this.f9577V = androidx.core.text.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float a1() {
        return this.f9585d0;
    }

    public void a2(float f3) {
        if (this.f9590i0 != f3) {
            this.f9590i0 = f3;
            invalidateSelf();
            if (K2()) {
                r1();
            }
        }
    }

    public ColorStateList b1() {
        return this.f9561J;
    }

    public void b2(int i3) {
        a2(this.f9592k0.getResources().getDimension(i3));
    }

    public c c1() {
        return this.f9582a0;
    }

    public void c2(int i3) {
        Y1(AbstractC0348a.b(this.f9592k0, i3));
    }

    public CharSequence d1() {
        return this.f9563K;
    }

    public void d2(float f3) {
        if (this.f9576U != f3) {
            this.f9576U = f3;
            invalidateSelf();
            if (K2()) {
                r1();
            }
        }
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i3 = this.f9546A0;
        int a3 = i3 < 255 ? J0.a.a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, i3) : 0;
        w0(canvas, bounds);
        t0(canvas, bounds);
        if (this.f9568M0) {
            super.draw(canvas);
        }
        v0(canvas, bounds);
        y0(canvas, bounds);
        u0(canvas, bounds);
        s0(canvas, bounds);
        if (this.f9564K0) {
            A0(canvas, bounds);
        }
        x0(canvas, bounds);
        z0(canvas, bounds);
        if (this.f9546A0 < 255) {
            canvas.restoreToCount(a3);
        }
    }

    public d e1() {
        return this.f9599r0.getTextAppearance();
    }

    public void e2(int i3) {
        d2(this.f9592k0.getResources().getDimension(i3));
    }

    public float f1() {
        return this.f9588g0;
    }

    public void f2(float f3) {
        if (this.f9589h0 != f3) {
            this.f9589h0 = f3;
            invalidateSelf();
            if (K2()) {
                r1();
            }
        }
    }

    public float g1() {
        return this.f9587f0;
    }

    public void g2(int i3) {
        f2(this.f9592k0.getResources().getDimension(i3));
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9546A0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f9547B0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f9553F;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f9584c0 + i0() + this.f9587f0 + this.f9599r0.getTextWidth(d1().toString()) + this.f9588g0 + m0() + this.f9591j0), this.f9566L0);
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f9568M0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f9555G);
        } else {
            outline.setRoundRect(bounds, this.f9555G);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    public boolean h2(int[] iArr) {
        if (Arrays.equals(this.f9554F0, iArr)) {
            return false;
        }
        this.f9554F0 = iArr;
        if (K2()) {
            return s1(getState(), iArr);
        }
        return false;
    }

    float i0() {
        if (J2() || I2()) {
            return this.f9585d0 + W0() + this.f9586e0;
        }
        return 0.0f;
    }

    public boolean i1() {
        return this.f9556G0;
    }

    public void i2(ColorStateList colorStateList) {
        if (this.f9575T != colorStateList) {
            this.f9575T = colorStateList;
            if (K2()) {
                androidx.core.graphics.drawable.a.i(this.f9573R, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return o1(this.f9549D) || o1(this.f9551E) || o1(this.f9557H) || (this.f9556G0 && o1(this.f9558H0)) || n1(this.f9599r0.getTextAppearance()) || q0() || p1(this.f9567M) || p1(this.f9580Y) || o1(this.f9550D0);
    }

    public void j2(int i3) {
        i2(AbstractC0348a.a(this.f9592k0, i3));
    }

    public boolean k1() {
        return this.f9578W;
    }

    public void k2(boolean z3) {
        if (this.f9572Q != z3) {
            boolean K22 = K2();
            this.f9572Q = z3;
            boolean K23 = K2();
            if (K22 != K23) {
                if (K23) {
                    g0(this.f9573R);
                } else {
                    L2(this.f9573R);
                }
                invalidateSelf();
                r1();
            }
        }
    }

    public boolean l1() {
        return p1(this.f9573R);
    }

    public void l2(InterfaceC0120a interfaceC0120a) {
        this.f9560I0 = new WeakReference(interfaceC0120a);
    }

    float m0() {
        if (K2()) {
            return this.f9589h0 + this.f9576U + this.f9590i0;
        }
        return 0.0f;
    }

    public boolean m1() {
        return this.f9572Q;
    }

    public void m2(TextUtils.TruncateAt truncateAt) {
        this.f9562J0 = truncateAt;
    }

    public void n2(c cVar) {
        this.f9583b0 = cVar;
    }

    public void o2(int i3) {
        n2(c.c(this.f9592k0, i3));
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i3) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (J2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.g(this.f9567M, i3);
        }
        if (I2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.g(this.f9580Y, i3);
        }
        if (K2()) {
            onLayoutDirectionChanged |= androidx.core.graphics.drawable.a.g(this.f9573R, i3);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        boolean onLevelChange = super.onLevelChange(i3);
        if (J2()) {
            onLevelChange |= this.f9567M.setLevel(i3);
        }
        if (I2()) {
            onLevelChange |= this.f9580Y.setLevel(i3);
        }
        if (K2()) {
            onLevelChange |= this.f9573R.setLevel(i3);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f9568M0) {
            super.onStateChange(iArr);
        }
        return s1(iArr, S0());
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        r1();
        invalidateSelf();
    }

    Paint.Align p0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f9563K != null) {
            float i02 = this.f9584c0 + i0() + this.f9587f0;
            if (androidx.core.graphics.drawable.a.b(this) == 0) {
                pointF.x = rect.left + i02;
            } else {
                pointF.x = rect.right - i02;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - o0();
        }
        return align;
    }

    public void p2(float f3) {
        if (this.f9586e0 != f3) {
            float i02 = i0();
            this.f9586e0 = f3;
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                r1();
            }
        }
    }

    public void q2(int i3) {
        p2(this.f9592k0.getResources().getDimension(i3));
    }

    protected void r1() {
        InterfaceC0120a interfaceC0120a = (InterfaceC0120a) this.f9560I0.get();
        if (interfaceC0120a != null) {
            interfaceC0120a.a();
        }
    }

    public void r2(float f3) {
        if (this.f9585d0 != f3) {
            float i02 = i0();
            this.f9585d0 = f3;
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                r1();
            }
        }
    }

    public void s2(int i3) {
        r2(this.f9592k0.getResources().getDimension(i3));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j3);
        }
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (this.f9546A0 != i3) {
            this.f9546A0 = i3;
            invalidateSelf();
        }
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f9547B0 != colorFilter) {
            this.f9547B0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f9550D0 != colorStateList) {
            this.f9550D0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // U0.g, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f9552E0 != mode) {
            this.f9552E0 = mode;
            this.f9548C0 = N0.a.a(this, this.f9550D0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        if (J2()) {
            visible |= this.f9567M.setVisible(z3, z4);
        }
        if (I2()) {
            visible |= this.f9580Y.setVisible(z3, z4);
        }
        if (K2()) {
            visible |= this.f9573R.setVisible(z3, z4);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t1(boolean z3) {
        if (this.f9578W != z3) {
            this.f9578W = z3;
            float i02 = i0();
            if (!z3 && this.f9606y0) {
                this.f9606y0 = false;
            }
            float i03 = i0();
            invalidateSelf();
            if (i02 != i03) {
                r1();
            }
        }
    }

    public void t2(int i3) {
        this.f9566L0 = i3;
    }

    public void u1(int i3) {
        t1(this.f9592k0.getResources().getBoolean(i3));
    }

    public void u2(ColorStateList colorStateList) {
        if (this.f9561J != colorStateList) {
            this.f9561J = colorStateList;
            M2();
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v1(Drawable drawable) {
        if (this.f9580Y != drawable) {
            float i02 = i0();
            this.f9580Y = drawable;
            float i03 = i0();
            L2(this.f9580Y);
            g0(this.f9580Y);
            invalidateSelf();
            if (i02 != i03) {
                r1();
            }
        }
    }

    public void v2(int i3) {
        u2(AbstractC0348a.a(this.f9592k0, i3));
    }

    public void w1(int i3) {
        v1(AbstractC0348a.b(this.f9592k0, i3));
    }

    void w2(boolean z3) {
        this.f9564K0 = z3;
    }

    public void x1(ColorStateList colorStateList) {
        if (this.f9581Z != colorStateList) {
            this.f9581Z = colorStateList;
            if (q0()) {
                androidx.core.graphics.drawable.a.i(this.f9580Y, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void x2(c cVar) {
        this.f9582a0 = cVar;
    }

    public void y1(int i3) {
        x1(AbstractC0348a.a(this.f9592k0, i3));
    }

    public void y2(int i3) {
        x2(c.c(this.f9592k0, i3));
    }

    public void z1(int i3) {
        A1(this.f9592k0.getResources().getBoolean(i3));
    }

    public void z2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f9563K, charSequence)) {
            return;
        }
        this.f9563K = charSequence;
        this.f9599r0.setTextWidthDirty(true);
        invalidateSelf();
        r1();
    }
}
