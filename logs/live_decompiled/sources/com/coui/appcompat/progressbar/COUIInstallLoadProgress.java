package com.coui.appcompat.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.ProgressBar;
import androidx.appcompat.widget.b0;
import com.oplus.graphics.OplusPathAdapter;
import d0.AbstractC0335a;
import e0.AbstractC0342a;
import java.util.Locale;
import n0.AbstractC0481a;
import u0.AbstractC0597a;
import w0.AbstractC0616b;

/* loaded from: classes.dex */
public class COUIInstallLoadProgress extends com.coui.appcompat.progressbar.a {

    /* renamed from: Q0, reason: collision with root package name */
    private static final int[] f8848Q0 = {M1.c.f1374s, M1.c.f1378w};

    /* renamed from: A0, reason: collision with root package name */
    private int f8849A0;

    /* renamed from: B0, reason: collision with root package name */
    private int f8850B0;

    /* renamed from: C, reason: collision with root package name */
    private final String f8851C;

    /* renamed from: C0, reason: collision with root package name */
    private int f8852C0;

    /* renamed from: D, reason: collision with root package name */
    private final boolean f8853D;

    /* renamed from: D0, reason: collision with root package name */
    private float f8854D0;

    /* renamed from: E, reason: collision with root package name */
    private TextPaint f8855E;

    /* renamed from: E0, reason: collision with root package name */
    private boolean f8856E0;

    /* renamed from: F, reason: collision with root package name */
    private String f8857F;

    /* renamed from: F0, reason: collision with root package name */
    private int f8858F0;

    /* renamed from: G, reason: collision with root package name */
    private int f8859G;

    /* renamed from: G0, reason: collision with root package name */
    private float[] f8860G0;

    /* renamed from: H, reason: collision with root package name */
    private int f8861H;

    /* renamed from: H0, reason: collision with root package name */
    private ValueAnimator f8862H0;

    /* renamed from: I, reason: collision with root package name */
    private ColorStateList f8863I;

    /* renamed from: I0, reason: collision with root package name */
    private ValueAnimator f8864I0;

    /* renamed from: J, reason: collision with root package name */
    private int f8865J;

    /* renamed from: J0, reason: collision with root package name */
    private Interpolator f8866J0;

    /* renamed from: K, reason: collision with root package name */
    private String f8867K;

    /* renamed from: K0, reason: collision with root package name */
    private Interpolator f8868K0;

    /* renamed from: L, reason: collision with root package name */
    private Paint.FontMetricsInt f8869L;

    /* renamed from: L0, reason: collision with root package name */
    private int f8870L0;

    /* renamed from: M, reason: collision with root package name */
    private int f8871M;

    /* renamed from: M0, reason: collision with root package name */
    private Context f8872M0;

    /* renamed from: N, reason: collision with root package name */
    private Paint f8873N;

    /* renamed from: N0, reason: collision with root package name */
    private boolean f8874N0;

    /* renamed from: O, reason: collision with root package name */
    private int f8875O;

    /* renamed from: O0, reason: collision with root package name */
    private String f8876O0;

    /* renamed from: P, reason: collision with root package name */
    private boolean f8877P;

    /* renamed from: P0, reason: collision with root package name */
    private OplusPathAdapter f8878P0;

    /* renamed from: Q, reason: collision with root package name */
    private Path f8879Q;

    /* renamed from: R, reason: collision with root package name */
    private int f8880R;

    /* renamed from: S, reason: collision with root package name */
    private int f8881S;

    /* renamed from: T, reason: collision with root package name */
    private float f8882T;

    /* renamed from: U, reason: collision with root package name */
    private int f8883U;

    /* renamed from: V, reason: collision with root package name */
    private int f8884V;

    /* renamed from: W, reason: collision with root package name */
    private Bitmap f8885W;

    /* renamed from: a0, reason: collision with root package name */
    private Bitmap f8886a0;

    /* renamed from: b0, reason: collision with root package name */
    private Bitmap f8887b0;

    /* renamed from: c0, reason: collision with root package name */
    private Paint f8888c0;

    /* renamed from: d0, reason: collision with root package name */
    private Paint f8889d0;

    /* renamed from: e0, reason: collision with root package name */
    private Paint f8890e0;

    /* renamed from: f0, reason: collision with root package name */
    private Drawable f8891f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f8892g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f8893h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f8894i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f8895j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f8896k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f8897l0;

    /* renamed from: m0, reason: collision with root package name */
    private ColorStateList f8898m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f8899n0;

    /* renamed from: o0, reason: collision with root package name */
    private ColorStateList f8900o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f8901p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f8902q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f8903r0;

    /* renamed from: s0, reason: collision with root package name */
    private ColorStateList f8904s0;

    /* renamed from: t0, reason: collision with root package name */
    private int f8905t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f8906u0;

    /* renamed from: v0, reason: collision with root package name */
    private float f8907v0;

    /* renamed from: w0, reason: collision with root package name */
    private float f8908w0;

    /* renamed from: x0, reason: collision with root package name */
    private float f8909x0;

    /* renamed from: y0, reason: collision with root package name */
    private Locale f8910y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f8911z0;

    class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setPath(COUIInstallLoadProgress.this.f8879Q);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIInstallLoadProgress.this.f8908w0 = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
            float floatValue = ((Float) valueAnimator.getAnimatedValue("narrowHolderX")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("narrowHolderY")).floatValue();
            float floatValue3 = ((Float) valueAnimator.getAnimatedValue("narrowHolderFont")).floatValue();
            if (floatValue < COUIInstallLoadProgress.this.getMeasuredWidth() * 0.005f && floatValue2 < COUIInstallLoadProgress.this.getMeasuredHeight() * 0.005f) {
                floatValue = COUIInstallLoadProgress.this.getMeasuredWidth() * 0.005f;
                floatValue2 = COUIInstallLoadProgress.this.getMeasuredHeight() * 0.005f;
            }
            COUIInstallLoadProgress.this.f8852C0 = (int) (floatValue + 0.5d);
            COUIInstallLoadProgress.this.f8850B0 = (int) (floatValue2 + 0.5d);
            COUIInstallLoadProgress.this.f8854D0 = floatValue3;
            COUIInstallLoadProgress.this.K();
            COUIInstallLoadProgress.this.invalidate();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIInstallLoadProgress.this.f8882T = ((Float) valueAnimator.getAnimatedValue("circleRadiusHolder")).floatValue();
            COUIInstallLoadProgress.this.f8908w0 = ((Float) valueAnimator.getAnimatedValue("circleBrightnessHolder")).floatValue();
            COUIInstallLoadProgress.this.invalidate();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIInstallLoadProgress.this.f8908w0 = ((Float) valueAnimator.getAnimatedValue("brightnessHolder")).floatValue();
            float floatValue = ((Float) valueAnimator.getAnimatedValue("narrowHolderX")).floatValue();
            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("narrowHolderY")).floatValue();
            COUIInstallLoadProgress.this.f8854D0 = ((Float) valueAnimator.getAnimatedValue("narrowHolderFont")).floatValue();
            COUIInstallLoadProgress.this.f8852C0 = (int) (floatValue + 0.5d);
            COUIInstallLoadProgress.this.f8850B0 = (int) (floatValue2 + 0.5d);
            COUIInstallLoadProgress.this.K();
            COUIInstallLoadProgress.this.invalidate();
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8916a;

        e(boolean z3) {
            this.f8916a = z3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8916a) {
                COUIInstallLoadProgress.super.performClick();
            }
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIInstallLoadProgress.this.f8882T = ((Float) valueAnimator.getAnimatedValue("circleRadiusHolder")).floatValue();
            COUIInstallLoadProgress.this.f8908w0 = ((Float) valueAnimator.getAnimatedValue("circleBrightnessHolder")).floatValue();
            COUIInstallLoadProgress.this.f8883U = ((Integer) valueAnimator.getAnimatedValue("circleInAlphaHolder")).intValue();
            COUIInstallLoadProgress.this.f8884V = ((Integer) valueAnimator.getAnimatedValue("circleOutAlphaHolder")).intValue();
            COUIInstallLoadProgress.this.invalidate();
        }
    }

    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            COUIInstallLoadProgress.super.performClick();
        }
    }

    public COUIInstallLoadProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, X1.a.f2863b);
    }

    private String A(String str) {
        int lastIndexOf;
        return (z(str) || (lastIndexOf = str.lastIndexOf(32)) <= 0) ? str : str.substring(0, lastIndexOf);
    }

    private boolean B() {
        return AbstractC0481a.a() == 1;
    }

    private boolean C(Locale locale) {
        return "zh".equalsIgnoreCase(locale.getLanguage());
    }

    private void D(Canvas canvas, float f3, float f4, float f5, float f6) {
        Drawable drawable = this.f8934r;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = this.f8934r.getIntrinsicHeight();
            int i3 = ((int) (f5 - intrinsicWidth)) / 2;
            int i4 = ((int) (f6 - intrinsicHeight)) / 2;
            int i5 = intrinsicWidth + i3;
            int i6 = intrinsicHeight + i4;
            this.f8934r.setBounds(i3, i4, i5, i6);
            Drawable drawable2 = this.f8934r;
            int i7 = this.f8849A0;
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            drawable2.setColorFilter(i7, mode);
            this.f8934r.draw(canvas);
            if (this.f8877P) {
                canvas.save();
                this.f8935s.setBounds(i3, i4, i5, i6);
                this.f8935s.setColorFilter(this.f8905t0, mode);
                if (b0.b(this)) {
                    canvas.clipRect(f5 - this.f8875O, f4, f5, f6);
                } else {
                    canvas.clipRect(f3, f4, this.f8875O, f6);
                }
                this.f8935s.draw(canvas);
                canvas.restore();
                this.f8877P = false;
            }
        }
    }

    private void E(Canvas canvas, float f3, float f4, boolean z3, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap.isRecycled() || bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        this.f8888c0.setColor(this.f8898m0 == null ? w(this.f8896k0) : this.f8899n0);
        if (!z3) {
            this.f8888c0.setColor(this.f8900o0 == null ? w(this.f8897l0) : this.f8901p0);
        }
        int width = (this.f8892g0 - bitmap.getWidth()) / 2;
        int height = (this.f8894i0 - bitmap.getHeight()) / 2;
        this.f8889d0.setAlpha(this.f8883U);
        this.f8890e0.setAlpha(this.f8884V);
        canvas.save();
        canvas.clipPath(this.f8879Q);
        canvas.drawColor(this.f8888c0.getColor());
        float f5 = width;
        float f6 = height;
        canvas.drawBitmap(bitmap, f5, f6, this.f8889d0);
        canvas.drawBitmap(bitmap2, f5, f6, this.f8890e0);
        canvas.restore();
        canvas.save();
    }

    private void F(Canvas canvas, float f3, float f4, float f5, float f6, boolean z3, float f7, float f8) {
        canvas.translate(f7, f8);
        this.f8873N.setColor(this.f8898m0 == null ? w(this.f8896k0) : this.f8899n0);
        if (!z3) {
            this.f8873N.setColor(this.f8900o0 == null ? w(this.f8897l0) : this.f8901p0);
        }
        canvas.drawPath(this.f8879Q, this.f8873N);
        canvas.translate(-f7, -f8);
    }

    private void G(Canvas canvas, float f3, float f4, float f5, float f6) {
        if (this.f8857F != null) {
            this.f8855E.setTextSize(this.f8859G * this.f8854D0);
            float measureText = this.f8855E.measureText(this.f8857F);
            float f7 = this.f8865J + (((f5 - measureText) - (r1 * 2)) / 2.0f);
            Paint.FontMetricsInt fontMetricsInt = this.f8869L;
            float f8 = ((f6 - fontMetricsInt.descent) - fontMetricsInt.ascent) / 2.0f;
            canvas.drawText(this.f8857F, f7, f8, this.f8855E);
            if (this.f8877P) {
                this.f8855E.setColor(this.f8905t0);
                canvas.save();
                if (b0.b(this)) {
                    canvas.clipRect(f5 - this.f8875O, f4, f5, f6);
                } else {
                    canvas.clipRect(f3, f4, this.f8875O, f6);
                }
                canvas.drawText(this.f8857F, f7, f8, this.f8855E);
                canvas.restore();
                this.f8877P = false;
            }
        }
    }

    private void H() {
        if (this.f8874N0) {
            performHapticFeedback(302);
        }
    }

    private void I(boolean z3) {
        H();
        if (this.f8856E0) {
            t(this.f8862H0);
            int i3 = this.f8895j0;
            if (i3 == 0 || i3 == 1) {
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("brightnessHolder", this.f8908w0, 1.0f), PropertyValuesHolder.ofFloat("narrowHolderX", this.f8852C0, 0.0f), PropertyValuesHolder.ofFloat("narrowHolderY", this.f8850B0, 0.0f), PropertyValuesHolder.ofFloat("narrowHolderFont", this.f8854D0, 1.0f));
                this.f8864I0 = ofPropertyValuesHolder;
                ofPropertyValuesHolder.setInterpolator(this.f8868K0);
                this.f8864I0.setDuration(340L);
                this.f8864I0.addUpdateListener(new d());
                this.f8864I0.addListener(new e(z3));
                this.f8864I0.start();
            } else if (i3 == 2) {
                ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("circleRadiusHolder", this.f8882T, this.f8881S), PropertyValuesHolder.ofFloat("circleBrightnessHolder", this.f8908w0, 1.0f), PropertyValuesHolder.ofInt("circleInAlphaHolder", 0, 255), PropertyValuesHolder.ofInt("circleOutAlphaHolder", 255, 0));
                this.f8864I0 = ofPropertyValuesHolder2;
                ofPropertyValuesHolder2.setInterpolator(this.f8868K0);
                this.f8864I0.setDuration(340L);
                this.f8864I0.addUpdateListener(new f());
                this.f8864I0.addListener(new g());
                this.f8864I0.start();
            }
            this.f8856E0 = false;
        }
    }

    private void J() {
        if (this.f8856E0) {
            return;
        }
        t(this.f8864I0);
        int i3 = this.f8895j0;
        if (i3 == 0 || i3 == 1) {
            ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("brightnessHolder", 1.0f, this.f8909x0), PropertyValuesHolder.ofFloat("narrowHolderX", 0.0f, getMeasuredWidth() * 0.05f), PropertyValuesHolder.ofFloat("narrowHolderY", 0.0f, getMeasuredHeight() * 0.05f), PropertyValuesHolder.ofFloat("narrowHolderFont", 1.0f, 0.92f));
            this.f8862H0 = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(this.f8866J0);
            this.f8862H0.setDuration(200L);
            this.f8862H0.addUpdateListener(new b());
            this.f8862H0.start();
        } else if (i3 == 2) {
            ValueAnimator ofPropertyValuesHolder2 = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("circleRadiusHolder", this.f8882T, this.f8881S * 0.9f), PropertyValuesHolder.ofFloat("circleBrightnessHolder", this.f8908w0, this.f8909x0));
            this.f8862H0 = ofPropertyValuesHolder2;
            ofPropertyValuesHolder2.setInterpolator(this.f8866J0);
            this.f8862H0.setDuration(200L);
            this.f8862H0.addUpdateListener(new c());
            this.f8862H0.start();
        }
        this.f8856E0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (this.f8895j0 == 2) {
            float f3 = (float) ((this.f8892g0 * 1.0d) / 2.0d);
            float f4 = (float) ((this.f8894i0 * 1.0d) / 2.0d);
            float f5 = this.f8882T;
            m0.c.a(this.f8879Q, new RectF(f3 - f5, f4 - f5, f3 + f5, f4 + f5), this.f8871M);
            return;
        }
        float f6 = this.f8852C0;
        float f7 = this.f8850B0;
        float width = getWidth() - this.f8852C0;
        float height = getHeight() - this.f8850B0;
        RectF rectF = new RectF(f6, f7, width, height);
        if (!B()) {
            m0.c.a(this.f8879Q, rectF, ((height - f7) / 2.0f) - this.f8907v0);
        } else {
            this.f8879Q.reset();
            this.f8878P0.addSmoothRoundRect(rectF, (rectF.height() * getScaleY()) / 2.0f, (rectF.height() * getScaleY()) / 2.0f, Path.Direction.CCW);
            invalidateOutline();
        }
    }

    private void b() {
        if (this.f8895j0 == 2) {
            return;
        }
        TextPaint textPaint = new TextPaint(1);
        this.f8855E = textPaint;
        textPaint.setAntiAlias(true);
        int i3 = this.f8861H;
        if (i3 == 0) {
            i3 = this.f8859G;
        }
        int i4 = this.f8911z0;
        this.f8849A0 = i4;
        if (i4 == -1) {
            this.f8849A0 = this.f8863I.getColorForState(getDrawableState(), AbstractC0335a.b(getContext(), M1.c.f1380y, 0));
        }
        this.f8855E.setTextSize(i3);
        AbstractC0597a.a(this.f8855E, true);
        this.f8869L = this.f8855E.getFontMetricsInt();
        s();
    }

    private void s() {
        String y3 = y(this.f8857F, this.f8893h0);
        if (y3.length() <= 0 || y3.length() >= this.f8857F.length()) {
            return;
        }
        this.f8857F = A(y(y3, (this.f8893h0 - (this.f8865J * 2)) - ((int) this.f8855E.measureText(this.f8867K)))) + this.f8867K;
    }

    private void t(ValueAnimator valueAnimator) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        valueAnimator.cancel();
    }

    private int u(Context context, float f3) {
        return (int) ((f3 * context.getResources().getDisplayMetrics().density) + 0.5d);
    }

    private Bitmap v(int i3) {
        Drawable drawable = getContext().getDrawable(i3);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private int w(int i3) {
        if (!isEnabled()) {
            return this.f8858F0;
        }
        androidx.core.graphics.a.f(i3, this.f8860G0);
        float[] fArr = this.f8860G0;
        fArr[2] = fArr[2] * this.f8908w0;
        int a3 = androidx.core.graphics.a.a(fArr);
        int red = Color.red(a3);
        int green = Color.green(a3);
        int blue = Color.blue(a3);
        int alpha = Color.alpha(i3);
        if (red > 255) {
            red = 255;
        }
        if (green > 255) {
            green = 255;
        }
        if (blue > 255) {
            blue = 255;
        }
        return Color.argb(alpha, red, green, blue);
    }

    private int x(int i3, float f3, boolean z3) {
        return i3 - (z3 ? u(getContext(), f3) : u(getContext(), f3) * 2);
    }

    private String y(String str, int i3) {
        int breakText = this.f8855E.breakText(str, true, i3, null);
        return (breakText == 0 || breakText == str.length()) ? str : str.substring(0, breakText - 1);
    }

    private static boolean z(String str) {
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (Character.toString(str.charAt(i4)).matches("^[一-龥]{1}$")) {
                i3++;
            }
        }
        return i3 > 0;
    }

    @Override // com.coui.appcompat.progressbar.a, androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f8895j0 == 2) {
            Bitmap bitmap = this.f8885W;
            if (bitmap == null || bitmap.isRecycled()) {
                Bitmap v3 = v(X1.d.f2887a);
                this.f8885W = v3;
                this.f8885W = AbstractC0616b.a(v3, this.f8898m0 == null ? this.f8896k0 : this.f8899n0);
            }
            Bitmap bitmap2 = this.f8886a0;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.f8886a0 = v(X1.d.f2889c);
            }
            Bitmap bitmap3 = this.f8887b0;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                this.f8887b0 = v(X1.d.f2888b);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Locale locale = Locale.getDefault();
        if (this.f8895j0 != 0 || this.f8910y0.getLanguage().equalsIgnoreCase(locale.getLanguage())) {
            return;
        }
        this.f8910y0 = locale;
        int dimensionPixelSize = getResources().getDimensionPixelSize(X1.c.f2876g);
        if (C(this.f8910y0)) {
            this.f8892g0 -= dimensionPixelSize;
            this.f8893h0 -= dimensionPixelSize;
        } else {
            this.f8892g0 += dimensionPixelSize;
            this.f8893h0 += dimensionPixelSize;
        }
        invalidate();
    }

    @Override // com.coui.appcompat.progressbar.a, android.view.View
    protected void onDetachedFromWindow() {
        if (this.f8895j0 == 2) {
            Bitmap bitmap = this.f8885W;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f8885W.recycle();
            }
            Bitmap bitmap2 = this.f8887b0;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.f8887b0.recycle();
            }
            Bitmap bitmap3 = this.f8886a0;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.f8886a0.recycle();
            }
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // com.coui.appcompat.progressbar.a, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r23) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.progressbar.COUIInstallLoadProgress.onDraw(android.graphics.Canvas):void");
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setItemCount(this.f8930n);
        accessibilityEvent.setCurrentItemIndex(this.f8929m);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        String str;
        String str2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        int i3 = this.f8928l;
        if ((i3 == 0 || i3 == 3 || i3 == 2) && (str = this.f8857F) != null) {
            accessibilityNodeInfo.setContentDescription(str);
        } else {
            if (i3 != 1 || (str2 = this.f8876O0) == null) {
                return;
            }
            accessibilityNodeInfo.setContentDescription(str2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(this.f8892g0, this.f8894i0);
        b();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        K();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            boolean z3 = false;
            if (action == 1) {
                float x3 = motionEvent.getX();
                float y3 = motionEvent.getY();
                if (x3 >= 0.0f && x3 <= this.f8892g0 && y3 >= 0.0f && y3 <= this.f8894i0) {
                    z3 = true;
                }
                I(z3);
            } else if (action == 3) {
                I(false);
            }
        } else {
            H();
            J();
        }
        return true;
    }

    @Deprecated
    public void setBtnTextColor(int i3) {
        this.f8903r0 = i3;
        this.f8902q0 = true;
        invalidate();
    }

    public void setBtnTextColorBySurpassProgress(int i3) {
        this.f8905t0 = i3;
        invalidate();
    }

    public void setBtnTextColorStateList(ColorStateList colorStateList) {
        this.f8904s0 = colorStateList;
        if (colorStateList == null) {
            setBtnTextColor(-1);
        } else {
            setBtnTextColor(colorStateList.getDefaultColor());
        }
    }

    public void setDefaultTextSize(int i3) {
        this.f8859G = i3;
    }

    public void setDisabledColor(int i3) {
        this.f8858F0 = i3;
    }

    public void setDownloadingContentDecrpition(String str) {
        this.f8876O0 = str;
    }

    public void setIsNeedVibrate(boolean z3) {
        this.f8874N0 = z3;
    }

    public void setLoadStyle(int i3) {
        if (i3 != 2) {
            this.f8895j0 = i3;
            this.f8873N = new Paint(1);
            return;
        }
        this.f8895j0 = 2;
        Paint paint = new Paint(1);
        this.f8888c0 = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f8889d0 = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint(1);
        this.f8890e0 = paint3;
        paint3.setAntiAlias(true);
        this.f8885W = v(X1.d.f2887a);
        this.f8886a0 = v(X1.d.f2889c);
        this.f8887b0 = v(X1.d.f2888b);
        int dimensionPixelSize = getResources().getDimensionPixelSize(X1.c.f2871b);
        this.f8880R = dimensionPixelSize;
        int x3 = x(dimensionPixelSize, 1.5f, true);
        this.f8881S = x3;
        this.f8882T = x3;
    }

    public void setMaxBrightness(int i3) {
        this.f8909x0 = i3;
    }

    public void setText(String str) {
        if (str.equals(this.f8857F)) {
            return;
        }
        this.f8857F = str;
        if (this.f8855E != null) {
            s();
        }
        invalidate();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i3) {
        if (i3 != 0) {
            this.f8911z0 = i3;
        }
    }

    public void setTextId(int i3) {
        setText(getResources().getString(i3));
    }

    public void setTextPadding(int i3) {
        this.f8865J = i3;
    }

    public void setTextSize(int i3) {
        if (i3 != 0) {
            this.f8861H = i3;
        }
    }

    @Deprecated
    public void setThemeColor(int i3) {
        this.f8899n0 = i3;
        Bitmap bitmap = this.f8885W;
        if (bitmap == null || bitmap.isRecycled()) {
            this.f8885W = v(X1.d.f2887a);
        }
        this.f8885W = AbstractC0616b.a(this.f8885W, this.f8899n0);
        invalidate();
    }

    public void setThemeColorStateList(ColorStateList colorStateList) {
        this.f8898m0 = colorStateList;
        if (colorStateList == null) {
            setThemeColor(-1);
        } else {
            setThemeColor(colorStateList.getDefaultColor());
        }
    }

    @Deprecated
    public void setThemeSecondaryColor(int i3) {
        this.f8901p0 = i3;
        invalidate();
    }

    public void setThemeSecondaryColorStateList(ColorStateList colorStateList) {
        this.f8900o0 = colorStateList;
        if (colorStateList == null) {
            setThemeSecondaryColor(-1);
        } else {
            setThemeSecondaryColor(colorStateList.getDefaultColor());
        }
    }

    public void setTouchModeHeight(int i3) {
        this.f8894i0 = i3;
    }

    public void setTouchModeWidth(int i3) {
        this.f8892g0 = i3;
    }

    public COUIInstallLoadProgress(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, X1.f.f2895e);
    }

    public COUIInstallLoadProgress(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        this.f8851C = "COUIInstallLoadProgress";
        this.f8853D = true;
        this.f8855E = null;
        this.f8861H = 0;
        this.f8865J = 0;
        this.f8867K = null;
        this.f8869L = null;
        this.f8871M = 0;
        this.f8873N = null;
        this.f8875O = 0;
        this.f8877P = false;
        this.f8879Q = new Path();
        this.f8880R = 0;
        this.f8881S = 0;
        this.f8882T = 0.0f;
        this.f8883U = 255;
        this.f8884V = 0;
        this.f8888c0 = null;
        this.f8889d0 = null;
        this.f8890e0 = null;
        this.f8891f0 = null;
        this.f8895j0 = 0;
        this.f8902q0 = false;
        this.f8908w0 = 1.0f;
        this.f8911z0 = -1;
        this.f8850B0 = 0;
        this.f8852C0 = 0;
        this.f8854D0 = 1.0f;
        this.f8860G0 = new float[3];
        AbstractC0342a.b(this, false);
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f8870L0 = attributeSet.getStyleAttribute();
        } else {
            this.f8870L0 = i3;
        }
        this.f8872M0 = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(f8848Q0);
        this.f8896k0 = obtainStyledAttributes.getColor(0, 0);
        this.f8897l0 = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.f8910y0 = Locale.getDefault();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, X1.g.f2902G, i3, i4);
        this.f8906u0 = getResources().getColor(X1.b.f2869a);
        this.f8905t0 = getResources().getColor(X1.b.f2869a);
        this.f8874N0 = obtainStyledAttributes2.getBoolean(X1.g.f2906K, false);
        Drawable drawable = obtainStyledAttributes2.getDrawable(X1.g.f2903H);
        if (drawable != null) {
            setButtonDrawable(drawable);
        }
        setState(obtainStyledAttributes2.getInteger(X1.g.f2905J, 0));
        obtainStyledAttributes2.recycle();
        int dimensionPixelSize = getResources().getDimensionPixelSize(X1.c.f2875f);
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, X1.g.f2927s, i3, i4);
        setLoadStyle(obtainStyledAttributes3.getInteger(X1.g.f2897B, 0));
        this.f8891f0 = obtainStyledAttributes3.getDrawable(X1.g.f2930v);
        this.f8894i0 = obtainStyledAttributes3.getDimensionPixelSize(X1.g.f2934z, 0);
        int dimensionPixelOffset = obtainStyledAttributes3.getDimensionPixelOffset(X1.g.f2896A, 0);
        this.f8892g0 = dimensionPixelOffset;
        this.f8893h0 = x(dimensionPixelOffset, 1.5f, false);
        this.f8909x0 = obtainStyledAttributes3.getFloat(X1.g.f2928t, 0.8f);
        this.f8858F0 = obtainStyledAttributes3.getColor(X1.g.f2901F, 0);
        this.f8866J0 = new Y.e();
        this.f8868K0 = new Y.e();
        int i5 = this.f8895j0;
        if (i5 != 2) {
            if (i5 == 1) {
                this.f8871M = getResources().getDimensionPixelSize(X1.c.f2872c);
            } else {
                this.f8871M = getResources().getDimensionPixelSize(X1.c.f2874e);
                if (!C(this.f8910y0)) {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(X1.c.f2876g);
                    this.f8892g0 += dimensionPixelSize2;
                    this.f8893h0 += dimensionPixelSize2;
                }
            }
            this.f8863I = obtainStyledAttributes3.getColorStateList(X1.g.f2929u);
            this.f8865J = obtainStyledAttributes3.getDimensionPixelOffset(X1.g.f2931w, 0);
            this.f8857F = obtainStyledAttributes3.getString(X1.g.f2933y);
            this.f8859G = obtainStyledAttributes3.getDimensionPixelSize(X1.g.f2932x, dimensionPixelSize);
            this.f8859G = (int) AbstractC0597a.e(this.f8859G, getResources().getConfiguration().fontScale, 2);
            if (this.f8867K == null) {
                this.f8867K = getResources().getString(X1.e.f2890a);
            }
        } else {
            this.f8871M = getResources().getDimensionPixelSize(X1.c.f2870a);
        }
        setThemeColorStateList(obtainStyledAttributes3.getColorStateList(X1.g.f2898C));
        setThemeSecondaryColorStateList(obtainStyledAttributes3.getColorStateList(X1.g.f2899D));
        setBtnTextColorStateList(obtainStyledAttributes3.getColorStateList(X1.g.f2900E));
        obtainStyledAttributes3.recycle();
        this.f8907v0 = getResources().getDimension(X1.c.f2873d);
        if (B()) {
            this.f8878P0 = new OplusPathAdapter(this.f8879Q, 1);
            setOutlineProvider(new a());
            setClipToOutline(true);
        }
    }
}
