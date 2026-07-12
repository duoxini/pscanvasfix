package com.coui.appcompat.couiswitch;

import M1.d;
import M1.f;
import M1.g;
import M1.j;
import M1.k;
import M1.m;
import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.Switch;
import androidx.appcompat.widget.SwitchCompat;
import com.oplus.graphics.OplusOutlineAdapter;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import n0.AbstractC0481a;
import r0.C0561c;
import r0.C0562d;
import r0.i;

/* loaded from: classes.dex */
public class COUISwitch extends SwitchCompat {

    /* renamed from: A0, reason: collision with root package name */
    private int f7638A0;

    /* renamed from: B0, reason: collision with root package name */
    private int f7639B0;

    /* renamed from: C0, reason: collision with root package name */
    private float f7640C0;

    /* renamed from: D0, reason: collision with root package name */
    private float f7641D0;

    /* renamed from: E0, reason: collision with root package name */
    private int f7642E0;

    /* renamed from: F0, reason: collision with root package name */
    private int f7643F0;

    /* renamed from: G0, reason: collision with root package name */
    private boolean f7644G0;

    /* renamed from: H0, reason: collision with root package name */
    private float f7645H0;

    /* renamed from: I0, reason: collision with root package name */
    private Paint f7646I0;

    /* renamed from: J0, reason: collision with root package name */
    private Paint f7647J0;

    /* renamed from: K0, reason: collision with root package name */
    private int f7648K0;

    /* renamed from: L0, reason: collision with root package name */
    private int f7649L0;

    /* renamed from: M0, reason: collision with root package name */
    private int f7650M0;

    /* renamed from: N0, reason: collision with root package name */
    private int f7651N0;

    /* renamed from: O0, reason: collision with root package name */
    private int f7652O0;

    /* renamed from: P0, reason: collision with root package name */
    private int f7653P0;

    /* renamed from: Q0, reason: collision with root package name */
    private int f7654Q0;

    /* renamed from: R0, reason: collision with root package name */
    private int f7655R0;

    /* renamed from: S0, reason: collision with root package name */
    private int f7656S0;

    /* renamed from: T0, reason: collision with root package name */
    private int f7657T0;

    /* renamed from: U0, reason: collision with root package name */
    private int f7658U0;

    /* renamed from: V0, reason: collision with root package name */
    private int f7659V0;

    /* renamed from: W0, reason: collision with root package name */
    private int f7660W0;

    /* renamed from: X0, reason: collision with root package name */
    private int f7661X0;

    /* renamed from: Y0, reason: collision with root package name */
    private int f7662Y0;

    /* renamed from: Z0, reason: collision with root package name */
    private int f7663Z0;

    /* renamed from: a1, reason: collision with root package name */
    private boolean f7664a1;

    /* renamed from: b0, reason: collision with root package name */
    private final RectF f7665b0;

    /* renamed from: b1, reason: collision with root package name */
    private boolean f7666b1;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f7667c0;

    /* renamed from: c1, reason: collision with root package name */
    private ExecutorService f7668c1;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f7669d0;

    /* renamed from: d1, reason: collision with root package name */
    private AtomicBoolean f7670d1;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f7671e0;

    /* renamed from: e1, reason: collision with root package name */
    private C0562d f7672e1;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f7673f0;

    /* renamed from: f1, reason: collision with root package name */
    private i f7674f1;

    /* renamed from: g0, reason: collision with root package name */
    private String f7675g0;

    /* renamed from: g1, reason: collision with root package name */
    private i f7676g1;

    /* renamed from: h0, reason: collision with root package name */
    private String f7677h0;

    /* renamed from: h1, reason: collision with root package name */
    private C0561c f7678h1;

    /* renamed from: i0, reason: collision with root package name */
    private String f7679i0;

    /* renamed from: j0, reason: collision with root package name */
    private AccessibilityManager f7680j0;

    /* renamed from: k0, reason: collision with root package name */
    private AnimatorSet f7681k0;

    /* renamed from: l0, reason: collision with root package name */
    private AnimatorSet f7682l0;

    /* renamed from: m0, reason: collision with root package name */
    private AnimatorSet f7683m0;

    /* renamed from: n0, reason: collision with root package name */
    private AnimatorSet f7684n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f7685o0;

    /* renamed from: p0, reason: collision with root package name */
    private float f7686p0;

    /* renamed from: q0, reason: collision with root package name */
    private float f7687q0;

    /* renamed from: r0, reason: collision with root package name */
    private Drawable f7688r0;

    /* renamed from: s0, reason: collision with root package name */
    private Drawable f7689s0;

    /* renamed from: t0, reason: collision with root package name */
    private Drawable f7690t0;

    /* renamed from: u0, reason: collision with root package name */
    private Drawable f7691u0;

    /* renamed from: v0, reason: collision with root package name */
    private Drawable f7692v0;

    /* renamed from: w0, reason: collision with root package name */
    private Drawable f7693w0;

    /* renamed from: x0, reason: collision with root package name */
    private int f7694x0;

    /* renamed from: y0, reason: collision with root package name */
    private RectF f7695y0;

    /* renamed from: z0, reason: collision with root package name */
    private RectF f7696z0;

    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f7697a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private OplusOutlineAdapter f7698b;

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            this.f7698b = new OplusOutlineAdapter(outline, 1);
            this.f7697a.left = (int) COUISwitch.this.f7665b0.left;
            this.f7697a.top = (int) COUISwitch.this.f7665b0.top;
            this.f7697a.right = (int) COUISwitch.this.f7665b0.right;
            this.f7697a.bottom = (int) COUISwitch.this.f7665b0.bottom;
            this.f7698b.setSmoothRoundRect(this.f7697a, (this.f7697a.height() * COUISwitch.this.getScaleY()) / 2.0f);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(263L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            if (COUISwitch.this.f7684n0 != null && COUISwitch.this.f7684n0.isRunning() && COUISwitch.this.f7670d1.get()) {
                COUISwitch.this.f7670d1.set(false);
                COUISwitch.this.performHapticFeedback(302);
            }
        }
    }

    public interface c {
    }

    public COUISwitch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, M1.c.f1352J);
    }

    private void A(Canvas canvas) {
        canvas.save();
        float f3 = this.f7641D0;
        canvas.scale(f3, f3, this.f7695y0.centerX(), this.f7695y0.centerY());
        this.f7646I0.setColor(isChecked() ? this.f7653P0 : this.f7654Q0);
        if (!isEnabled()) {
            this.f7646I0.setColor(isChecked() ? this.f7658U0 : this.f7657T0);
        }
        float f4 = this.f7648K0 / 2.0f;
        canvas.drawRoundRect(this.f7695y0, f4, f4, this.f7646I0);
        canvas.restore();
    }

    private void B(Canvas canvas) {
        canvas.save();
        Drawable v3 = v();
        v3.setAlpha(D());
        int i3 = this.f7651N0;
        int switchMinWidth = getSwitchMinWidth();
        int i4 = this.f7651N0;
        v3.setBounds(i3, i3, switchMinWidth + i4, this.f7643F0 + i4);
        v().draw(canvas);
        canvas.restore();
    }

    private void C(Canvas canvas) {
        if (this.f7671e0) {
            int width = (getWidth() - this.f7648K0) / 2;
            int width2 = (getWidth() + this.f7648K0) / 2;
            int height = (getHeight() - this.f7648K0) / 2;
            int height2 = (getHeight() + this.f7648K0) / 2;
            int width3 = getWidth() / 2;
            int height3 = getHeight() / 2;
            canvas.save();
            canvas.rotate(this.f7687q0, width3, height3);
            this.f7689s0.setBounds(width, height, width2, height2);
            this.f7689s0.draw(canvas);
            canvas.restore();
        }
    }

    private int D() {
        return (int) ((isEnabled() ? 1.0f : 0.5f) * 255.0f);
    }

    private void E() {
        J();
        L();
        M();
    }

    private void F(TypedArray typedArray, Context context) {
        this.f7688r0 = typedArray.getDrawable(m.f1569n0);
        this.f7643F0 = typedArray.getDimensionPixelSize(m.f1555g0, 0);
        this.f7642E0 = typedArray.getDimensionPixelSize(m.f1575q0, 0);
        this.f7648K0 = typedArray.getDimensionPixelOffset(m.f1579s0, 0);
        this.f7649L0 = typedArray.getDimensionPixelSize(m.f1567m0, 0);
        this.f7650M0 = typedArray.getDimensionPixelSize(m.f1559i0, 0);
        this.f7652O0 = typedArray.getColor(m.f1563k0, 0);
        this.f7653P0 = typedArray.getColor(m.f1573p0, 0);
        this.f7655R0 = typedArray.getColor(m.f1565l0, 0);
        this.f7654Q0 = typedArray.getColor(m.f1581t0, 0);
        this.f7656S0 = typedArray.getColor(m.f1561j0, 0);
        this.f7657T0 = typedArray.getColor(m.f1577r0, 0);
        this.f7658U0 = typedArray.getColor(m.f1571o0, 0);
        this.f7662Y0 = typedArray.getColor(m.f1557h0, AbstractC0335a.a(context, M1.c.f1374s) & 1308622847);
        boolean z3 = getContext().getResources().getBoolean(d.f1384c);
        this.f7644G0 = z3;
        if (z3) {
            this.f7689s0 = typedArray.getDrawable(m.f1587w0);
            this.f7690t0 = typedArray.getDrawable(m.f1585v0);
            this.f7691u0 = typedArray.getDrawable(m.f1589x0);
            this.f7692v0 = typedArray.getDrawable(m.f1583u0);
            this.f7693w0 = typedArray.getDrawable(m.f1591y0);
        }
    }

    private void G() {
        if (!O() || this.f7644G0) {
            return;
        }
        setOutlineProvider(new a());
        setClipToOutline(true);
        y0.i.b(this);
    }

    private void H() {
        this.f7646I0 = new Paint(1);
        X();
        this.f7647J0 = new Paint(1);
    }

    private void I(Context context) {
        this.f7651N0 = context.getResources().getDimensionPixelSize(f.f1428W);
        this.f7675g0 = getResources().getString(k.f1500j);
        this.f7677h0 = getResources().getString(k.f1499i);
        this.f7679i0 = getResources().getString(k.f1498h);
        this.f7639B0 = (getSwitchMinWidth() - (this.f7650M0 * 2)) - this.f7648K0;
        this.f7659V0 = AbstractC0335a.a(context, M1.c.f1374s);
        this.f7660W0 = AbstractC0335a.a(context, M1.c.f1361f);
        this.f7661X0 = isChecked() ? this.f7659V0 : this.f7660W0;
        this.f7663Z0 = AbstractC0335a.a(context, M1.c.f1373r);
        setTrackTintMode(PorterDuff.Mode.SRC);
    }

    private void J() {
        Interpolator a3 = androidx.core.view.animation.a.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.f7681k0 = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "circleScale", 1.0f, 0.0f);
        ofFloat.setInterpolator(a3);
        ofFloat.setDuration(433L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "loadingScale", 0.5f, 1.0f);
        ofFloat2.setInterpolator(a3);
        ofFloat2.setDuration(550L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "loadingAlpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(a3);
        ofFloat3.setDuration(550L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setDuration(800L);
        ofFloat4.setInterpolator(new Y.d());
        this.f7681k0.play(ofFloat).with(ofFloat3).with(ofFloat2).with(ofFloat4);
    }

    private void K() {
        Drawable background = getBackground();
        C0562d c0562d = new C0562d(getContext());
        this.f7672e1 = c0562d;
        c0562d.w(this.f7665b0, getContext().getResources().getDimensionPixelOffset(f.f1432a), getContext().getResources().getDimensionPixelOffset(f.f1432a));
        if (background == null) {
            background = new ColorDrawable(0);
        }
        Drawable[] drawableArr = {background, this.f7672e1};
        setDefaultFocusHighlightEnabled(false);
        C0561c c0561c = new C0561c(drawableArr);
        this.f7678h1 = c0561c;
        super.setBackground(c0561c);
    }

    private void L() {
        Interpolator a3 = androidx.core.view.animation.a.a(0.3f, 0.0f, 0.1f, 1.0f);
        this.f7682l0 = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "loadingAlpha", 1.0f, 0.0f);
        ofFloat.setInterpolator(a3);
        ofFloat.setDuration(100L);
        this.f7682l0.play(ofFloat);
    }

    private void M() {
        this.f7683m0 = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "loadingRotation", 0.0f, 360.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(800L);
        ofFloat.setInterpolator(new Y.d());
        this.f7683m0.play(ofFloat);
    }

    private boolean O() {
        return AbstractC0481a.a() == 1;
    }

    private boolean P() {
        return getLayoutDirection() == 1;
    }

    private void R() {
        if (Q()) {
            if (this.f7668c1 == null) {
                this.f7668c1 = Executors.newSingleThreadExecutor();
            }
            this.f7670d1.set(true);
            this.f7668c1.execute(new b());
            setTactileFeedbackEnabled(false);
        }
    }

    private void S(boolean z3) {
        q0.b.f(getContext(), z3 ? j.f1490b : j.f1489a, 1.0f, 1.0f, 0, 0, 1.0f);
    }

    private void V() {
        RectF rectF = this.f7695y0;
        float f3 = rectF.left;
        int i3 = this.f7642E0;
        this.f7696z0.set(f3 + i3, rectF.top + i3, rectF.right - i3, rectF.bottom - i3);
    }

    private void W() {
        float f3;
        float f4;
        float f5;
        float f6;
        if (isChecked()) {
            if (P()) {
                f3 = this.f7650M0 + this.f7638A0 + this.f7651N0;
                f4 = this.f7648K0;
                f5 = this.f7640C0;
                f6 = (f4 * f5) + f3;
            } else {
                f6 = ((getSwitchMinWidth() - this.f7650M0) - (this.f7639B0 - this.f7638A0)) + this.f7651N0;
                f3 = f6 - (this.f7648K0 * this.f7640C0);
            }
        } else if (P()) {
            int switchMinWidth = (getSwitchMinWidth() - this.f7650M0) - (this.f7639B0 - this.f7638A0);
            int i3 = this.f7651N0;
            float f7 = switchMinWidth + i3;
            float f8 = i3 + (f7 - (this.f7648K0 * this.f7640C0));
            f6 = f7;
            f3 = f8;
        } else {
            f3 = this.f7650M0 + this.f7638A0 + this.f7651N0;
            f4 = this.f7648K0;
            f5 = this.f7640C0;
            f6 = (f4 * f5) + f3;
        }
        int i4 = this.f7643F0;
        float f9 = ((i4 - r3) / 2.0f) + this.f7651N0;
        this.f7695y0.set(f3, f9, f6, this.f7648K0 + f9);
    }

    private void X() {
        this.f7646I0.setShadowLayer(8.0f, 0.0f, 4.0f, Color.argb(25, 0, 0, 0));
    }

    private int getBarColor() {
        return this.f7661X0;
    }

    private void setBarColor(int i3) {
        this.f7661X0 = i3;
        invalidate();
    }

    private void u(boolean z3) {
        int i3;
        if (this.f7684n0 == null) {
            this.f7684n0 = new AnimatorSet();
        }
        Interpolator a3 = androidx.core.view.animation.a.a(0.3f, 0.0f, 0.1f, 1.0f);
        int i4 = this.f7638A0;
        if (P()) {
            if (!z3) {
                i3 = this.f7639B0;
            }
            i3 = 0;
        } else {
            if (z3) {
                i3 = this.f7639B0;
            }
            i3 = 0;
        }
        this.f7684n0.setInterpolator(a3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "circleScaleX", 1.0f, 1.3f);
        ofFloat.setDuration(133L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "circleScaleX", 1.3f, 1.0f);
        ofFloat2.setStartDelay(133L);
        ofFloat2.setDuration(250L);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "circleTranslation", i4, i3);
        ofInt.setDuration(383L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "innerCircleAlpha", this.f7645H0, z3 ? 0.0f : 1.0f);
        ofFloat3.setDuration(100L);
        ObjectAnimator ofArgb = ObjectAnimator.ofArgb(this, "barColor", getBarColor(), z3 ? this.f7659V0 : this.f7660W0);
        ofArgb.setDuration(450L);
        this.f7684n0.play(ofFloat).with(ofFloat2).with(ofInt).with(ofFloat3).with(ofArgb);
        this.f7684n0.start();
    }

    private Drawable v() {
        return N() ? isChecked() ? this.f7690t0 : this.f7691u0 : isChecked() ? this.f7692v0 : this.f7693w0;
    }

    private boolean w() {
        return true;
    }

    private void x() {
        this.f7674f1 = new i(this, "hover", 0, AbstractC0335a.a(getContext(), M1.c.f1369n));
        this.f7676g1 = new i(this, "press", 0, AbstractC0335a.a(getContext(), M1.c.f1372q));
        this.f7674f1.l(0.3f);
        this.f7674f1.k(0.0f);
        this.f7676g1.l(0.3f);
        this.f7676g1.k(0.0f);
    }

    private void y() {
        Drawable trackDrawable;
        if (w() && (trackDrawable = getTrackDrawable()) != null) {
            if (isEnabled()) {
                trackDrawable.setTint(androidx.core.graphics.a.i(this.f7676g1.g(), androidx.core.graphics.a.i(this.f7674f1.g(), this.f7661X0)));
            } else {
                trackDrawable.setTint(isChecked() ? this.f7662Y0 : this.f7663Z0);
            }
        }
    }

    private void z(Canvas canvas) {
        if (this.f7671e0) {
            canvas.save();
            float f3 = this.f7685o0;
            canvas.scale(f3, f3, this.f7695y0.centerX(), this.f7695y0.centerY());
            canvas.rotate(this.f7687q0, this.f7695y0.centerX(), this.f7695y0.centerY());
            Drawable drawable = this.f7688r0;
            if (drawable != null) {
                RectF rectF = this.f7695y0;
                drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                this.f7688r0.setAlpha((int) (this.f7686p0 * 255.0f));
                this.f7688r0.draw(canvas);
            }
            canvas.restore();
        }
    }

    public boolean N() {
        return this.f7671e0;
    }

    public boolean Q() {
        return this.f7669d0;
    }

    public void T() {
        Drawable e3 = androidx.core.content.a.e(getContext(), g.f1480n);
        Drawable e4 = androidx.core.content.a.e(getContext(), g.f1478l);
        Drawable e5 = androidx.core.content.a.e(getContext(), g.f1481o);
        Drawable e6 = androidx.core.content.a.e(getContext(), g.f1479m);
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.f7659V0 != 0) {
            GradientDrawable gradientDrawable = (GradientDrawable) e3.mutate();
            gradientDrawable.setColor(this.f7659V0);
            stateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_enabled}, gradientDrawable);
        } else {
            stateListDrawable.addState(new int[]{R.attr.state_checked, R.attr.state_enabled}, e3);
        }
        if (this.f7660W0 != 0) {
            GradientDrawable gradientDrawable2 = (GradientDrawable) e4.mutate();
            gradientDrawable2.setColor(this.f7660W0);
            stateListDrawable.addState(new int[]{-16842912, R.attr.state_enabled}, gradientDrawable2);
        } else {
            stateListDrawable.addState(new int[]{-16842912, R.attr.state_enabled}, e4);
        }
        if (this.f7662Y0 != 0) {
            GradientDrawable gradientDrawable3 = (GradientDrawable) e5.mutate();
            gradientDrawable3.setColor(this.f7662Y0);
            stateListDrawable.addState(new int[]{-16842910, R.attr.state_checked}, gradientDrawable3);
        } else {
            stateListDrawable.addState(new int[]{-16842910, R.attr.state_checked}, e5);
        }
        if (this.f7663Z0 != 0) {
            GradientDrawable gradientDrawable4 = (GradientDrawable) e6.mutate();
            gradientDrawable4.setColor(this.f7663Z0);
            stateListDrawable.addState(new int[]{-16842910, -16842912}, gradientDrawable4);
        } else {
            stateListDrawable.addState(new int[]{-16842910, -16842912}, e6);
        }
        setTrackDrawable(stateListDrawable);
    }

    public void U(boolean z3, boolean z4) {
        if (z3 == isChecked()) {
            return;
        }
        super.setChecked(z3);
        if (!this.f7644G0) {
            z3 = isChecked();
            AnimatorSet animatorSet = this.f7684n0;
            if (animatorSet != null) {
                animatorSet.removeAllListeners();
                this.f7684n0.cancel();
                this.f7684n0.end();
            }
            if (!this.f7666b1 || !z4 || getHeight() <= 0 || getWidth() <= 0) {
                if (P()) {
                    setCircleTranslation(z3 ? 0 : this.f7639B0);
                } else {
                    setCircleTranslation(z3 ? this.f7639B0 : 0);
                }
                setInnerCircleAlpha(z3 ? 0.0f : 1.0f);
                setBarColor(z3 ? this.f7659V0 : this.f7660W0);
            } else {
                u(z3);
            }
        }
        if (this.f7667c0 && this.f7666b1) {
            S(z3);
            this.f7667c0 = false;
        }
        R();
        invalidate();
    }

    public void Y() {
        if (this.f7671e0) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f7680j0;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            announceForAccessibility(this.f7679i0);
        }
        this.f7671e0 = true;
        if (this.f7644G0) {
            this.f7683m0.start();
        } else {
            this.f7681k0.start();
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Switch.class.getName();
    }

    public final int getOuterCircleUncheckedColor() {
        return this.f7654Q0;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7666b1 = true;
        q0.b.i(getContext(), j.f1490b, j.f1489a);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7666b1 = false;
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f7644G0) {
            B(canvas);
            C(canvas);
            return;
        }
        y();
        W();
        V();
        super.onDraw(canvas);
        A(canvas);
        z(canvas);
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!this.f7673f0) {
            accessibilityNodeInfo.setText(isChecked() ? this.f7675g0 : this.f7677h0);
        } else {
            accessibilityNodeInfo.setCheckable(false);
            accessibilityNodeInfo.setText(isChecked() ? this.f7675g0 : this.f7677h0);
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int switchMinWidth = getSwitchMinWidth();
        int i5 = this.f7651N0;
        setMeasuredDimension(switchMinWidth + (i5 * 2), this.f7643F0 + (i5 * 2));
        if (this.f7664a1) {
            return;
        }
        this.f7664a1 = true;
        if (P()) {
            this.f7638A0 = isChecked() ? 0 : this.f7639B0;
        } else {
            this.f7638A0 = isChecked() ? this.f7639B0 : 0;
        }
        this.f7645H0 = isChecked() ? 0.0f : 1.0f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        this.f7665b0.set(0.0f, 0.0f, i3, i4);
        if (O()) {
            invalidateOutline();
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isClickable() || isFocusable()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f7676g1.d(10000.0f, true);
            } else if (actionMasked == 1) {
                this.f7667c0 = true;
                this.f7669d0 = true;
                this.f7676g1.d(0.0f, true);
                if (this.f7673f0 && isEnabled()) {
                    Y();
                    return false;
                }
            } else if (actionMasked == 3) {
                this.f7676g1.d(0.0f, true);
            }
        }
        if (this.f7671e0) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2;
        AnimatorSet animatorSet3;
        AnimatorSet animatorSet4;
        super.onVisibilityChanged(view, i3);
        if (i3 == 0) {
            if (this.f7644G0 && (animatorSet4 = this.f7683m0) != null && animatorSet4.isPaused()) {
                this.f7683m0.resume();
                return;
            } else {
                if (this.f7644G0 || (animatorSet3 = this.f7681k0) == null || !animatorSet3.isPaused()) {
                    return;
                }
                this.f7681k0.resume();
                return;
            }
        }
        if (this.f7644G0 && (animatorSet2 = this.f7683m0) != null && animatorSet2.isRunning()) {
            this.f7683m0.pause();
        } else {
            if (this.f7644G0 || (animatorSet = this.f7681k0) == null || !animatorSet.isRunning()) {
                return;
            }
            this.f7681k0.pause();
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        C0561c c0561c = this.f7678h1;
        if (c0561c == null) {
            super.setBackground(drawable);
        } else if (drawable == null) {
            c0561c.h(new ColorDrawable(0));
        } else {
            c0561c.h(drawable);
        }
    }

    public final void setBarCheckedColor(int i3) {
        this.f7659V0 = i3;
        if (isChecked()) {
            this.f7661X0 = this.f7659V0;
        }
        T();
        invalidate();
    }

    public final void setBarCheckedDisabledColor(int i3) {
        this.f7662Y0 = i3;
        T();
        invalidate();
    }

    public final void setBarUnCheckedColor(int i3) {
        this.f7660W0 = i3;
        if (!isChecked()) {
            this.f7661X0 = this.f7660W0;
        }
        T();
        invalidate();
    }

    public final void setBarUncheckedDisabledColor(int i3) {
        this.f7663Z0 = i3;
        T();
        invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        U(z3, true);
    }

    public void setCheckedDrawable(Drawable drawable) {
        this.f7692v0 = drawable;
    }

    public void setCircleScale(float f3) {
        this.f7641D0 = f3;
        invalidate();
    }

    public void setCircleScaleX(float f3) {
        this.f7640C0 = f3;
        invalidate();
    }

    public void setCircleTranslation(int i3) {
        this.f7638A0 = i3;
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z3) {
        super.setEnabled(z3);
        if (this.f7646I0 == null) {
            this.f7646I0 = new Paint(1);
        }
        if (z3) {
            X();
        } else {
            this.f7646I0.clearShadowLayer();
        }
    }

    @Override // android.view.View
    public void setHovered(boolean z3) {
        super.setHovered(z3);
        if (isEnabled()) {
            this.f7674f1.d(z3 ? 10000.0f : 0.0f, true);
        }
    }

    public void setInnerCircleAlpha(float f3) {
        this.f7645H0 = f3;
        invalidate();
    }

    public void setInnerCircleColor(int i3) {
        this.f7652O0 = i3;
    }

    public void setLoadingAlpha(float f3) {
        this.f7686p0 = f3;
        invalidate();
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.f7688r0 = drawable;
    }

    public void setLoadingRotation(float f3) {
        this.f7687q0 = f3;
        invalidate();
    }

    public void setLoadingScale(float f3) {
        this.f7685o0 = f3;
        invalidate();
    }

    public void setLoadingStyle(boolean z3) {
        this.f7673f0 = z3;
    }

    public void setOnLoadingStateChangedListener(c cVar) {
    }

    public void setOuterCircleColor(int i3) {
        this.f7653P0 = i3;
    }

    public void setOuterCircleStrokeWidth(int i3) {
        this.f7642E0 = i3;
    }

    public final void setOuterCircleUncheckedColor(int i3) {
        this.f7654Q0 = i3;
        invalidate();
    }

    public void setShouldPlaySound(boolean z3) {
        this.f7667c0 = z3;
    }

    public void setTactileFeedbackEnabled(boolean z3) {
        this.f7669d0 = z3;
    }

    public void setThemedLoadingCheckedBackground(Drawable drawable) {
        this.f7690t0 = drawable;
    }

    public void setThemedLoadingUncheckedBackground(Drawable drawable) {
        this.f7691u0 = drawable;
    }

    public void setUncheckedDrawable(Drawable drawable) {
        this.f7693w0 = drawable;
    }

    public COUISwitch(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f7665b0 = new RectF();
        this.f7671e0 = false;
        this.f7673f0 = false;
        this.f7684n0 = new AnimatorSet();
        this.f7695y0 = new RectF();
        this.f7696z0 = new RectF();
        this.f7640C0 = 1.0f;
        this.f7641D0 = 1.0f;
        this.f7664a1 = false;
        this.f7670d1 = new AtomicBoolean(false);
        setSoundEffectsEnabled(false);
        AbstractC0342a.b(this, false);
        this.f7680j0 = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (attributeSet == null || attributeSet.getStyleAttribute() == 0) {
            this.f7694x0 = i3;
        } else {
            this.f7694x0 = attributeSet.getStyleAttribute();
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f1553f0, i3, 0);
        F(obtainStyledAttributes, context);
        obtainStyledAttributes.recycle();
        E();
        H();
        I(context);
        K();
        x();
        G();
    }
}
