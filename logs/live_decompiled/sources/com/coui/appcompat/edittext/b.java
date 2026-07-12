package com.coui.appcompat.edittext;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.animation.Interpolator;
import android.widget.EditText;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.edittext.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
class b {

    /* renamed from: v, reason: collision with root package name */
    private static final Rect f7913v = new Rect();

    /* renamed from: a, reason: collision with root package name */
    private final EditText f7914a;

    /* renamed from: b, reason: collision with root package name */
    private final a.C0101a f7915b;

    /* renamed from: c, reason: collision with root package name */
    private ColorStateList f7916c;

    /* renamed from: d, reason: collision with root package name */
    private int f7917d;

    /* renamed from: e, reason: collision with root package name */
    private int f7918e;

    /* renamed from: f, reason: collision with root package name */
    private int f7919f;

    /* renamed from: g, reason: collision with root package name */
    private com.coui.appcompat.edittext.a f7920g;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f7921h;

    /* renamed from: i, reason: collision with root package name */
    private ColorStateList f7922i;

    /* renamed from: j, reason: collision with root package name */
    private Paint f7923j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f7924k;

    /* renamed from: l, reason: collision with root package name */
    private AnimatorSet f7925l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7926m;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList f7927n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7928o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f7929p;

    /* renamed from: q, reason: collision with root package name */
    private float f7930q;

    /* renamed from: r, reason: collision with root package name */
    private float f7931r;

    /* renamed from: s, reason: collision with root package name */
    private float f7932s;

    /* renamed from: t, reason: collision with root package name */
    private float f7933t;

    /* renamed from: u, reason: collision with root package name */
    private float f7934u;

    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            b.this.F(false, false, false);
            Editable text = b.this.f7914a.getText();
            int length = text.length();
            b bVar = b.this;
            bVar.f7933t = bVar.f7914a.getPaint().measureText(text, 0, length);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            if (b.this.f7934u <= 0.0f) {
                b.this.f7934u = r0.f7914a.getHeight();
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
        }
    }

    /* renamed from: com.coui.appcompat.edittext.b$b, reason: collision with other inner class name */
    class C0102b implements ValueAnimator.AnimatorUpdateListener {
        C0102b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b.this.f7930q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f7929p) {
                b.this.f7931r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
            b.this.f7914a.invalidate();
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (b.this.f7929p) {
                b.this.f7932s = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        }
    }

    class e implements Animator.AnimatorListener {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f7934u = r1.f7914a.getHeight();
            }
        }

        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.G(true, true, true);
            b.this.z(true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f7914a.setSelection(b.this.f7914a.length());
            if (b.this.f7934u <= 0.0f) {
                b.this.f7914a.post(new a());
            }
        }
    }

    private static class f implements Interpolator {

        /* renamed from: b, reason: collision with root package name */
        private static final float[] f7941b = {0.0f, -1.0f, 0.5f, -0.5f, 0.0f};

        /* renamed from: c, reason: collision with root package name */
        private static final int[] f7942c;

        /* renamed from: d, reason: collision with root package name */
        private static final float[] f7943d;

        /* renamed from: a, reason: collision with root package name */
        private final Interpolator f7944a;

        static {
            int[] iArr = {83, 133, 117, 117};
            f7942c = iArr;
            f7943d = new float[iArr.length + 1];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr2 = f7942c;
                if (i3 >= iArr2.length) {
                    return;
                }
                i4 += iArr2[i3];
                i3++;
                f7943d[i3] = i4 / 450.0f;
            }
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            int i3 = 1;
            while (true) {
                float[] fArr = f7943d;
                if (i3 >= fArr.length) {
                    return 0.0f;
                }
                float f4 = fArr[i3];
                if (f3 <= f4) {
                    int i4 = i3 - 1;
                    float f5 = fArr[i4];
                    float interpolation = this.f7944a.getInterpolation((f3 - f5) / (f4 - f5));
                    float[] fArr2 = f7941b;
                    return (fArr2[i4] * (1.0f - interpolation)) + (fArr2[i3] * interpolation);
                }
                i3++;
            }
        }

        private f() {
            this.f7944a = new Y.b();
        }
    }

    b(EditText editText, int i3) {
        this.f7914a = editText;
        a.C0101a c0101a = new a.C0101a(editText);
        this.f7915b = c0101a;
        c0101a.U(i3);
        c0101a.a0(new Y.d());
        c0101a.X(new Y.d());
        c0101a.O(8388659);
    }

    private void A(boolean z3) {
        if (this.f7927n != null) {
            for (int i3 = 0; i3 < this.f7927n.size(); i3++) {
                ((COUIEditText.j) this.f7927n.get(i3)).a(z3);
            }
        }
    }

    private void E(boolean z3, boolean z4) {
        F(z3, z4, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z3, boolean z4, boolean z5) {
        if (this.f7926m == z3) {
            return;
        }
        this.f7926m = z3;
        A(z3);
        if (z4) {
            H(z3, z5);
        } else {
            I(z3, z5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(boolean z3, boolean z4, boolean z5) {
        this.f7928o = false;
        if (!z3) {
            this.f7914a.setTextColor(this.f7916c);
            this.f7914a.setHighlightColor(this.f7917d);
            return;
        }
        if (z4) {
            this.f7914a.setTextColor(this.f7916c);
        }
        this.f7914a.setHighlightColor(s(0.3f));
        if (z5) {
            EditText editText = this.f7914a;
            editText.setSelection(0, editText.getText().length());
        }
    }

    private void H(boolean z3, boolean z4) {
        if (!z3) {
            m();
            G(false, false, z4);
            return;
        }
        m();
        this.f7914a.setTextColor(0);
        this.f7914a.setHighlightColor(0);
        this.f7930q = 0.0f;
        this.f7931r = 0.0f;
        this.f7932s = 0.0f;
        this.f7928o = true;
        this.f7929p = this.f7914a.isFocused();
        this.f7925l.start();
    }

    private void I(boolean z3, boolean z4) {
        if (!z3) {
            G(false, false, z4);
            return;
        }
        this.f7930q = 1.0f;
        this.f7931r = 0.0f;
        this.f7932s = 0.0f;
        G(true, false, z4);
    }

    private void m() {
        if (this.f7925l.isStarted()) {
            this.f7925l.cancel();
        }
    }

    private Layout.Alignment q() {
        switch (this.f7914a.getTextAlignment()) {
            case 1:
                int gravity = this.f7914a.getGravity() & 8388615;
                if (gravity == 1) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                if (gravity == 3) {
                    return w() ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL;
                }
                if (gravity == 5) {
                    return w() ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
                }
                if (gravity != 8388611 && gravity == 8388613) {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
                return Layout.Alignment.ALIGN_NORMAL;
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
                return Layout.Alignment.ALIGN_NORMAL;
            case 6:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private int r(int i3, int i4, float f3) {
        if (f3 <= 0.0f) {
            return i3;
        }
        if (f3 >= 1.0f) {
            return i4;
        }
        float f4 = 1.0f - f3;
        int alpha = (int) ((Color.alpha(i3) * f4) + (Color.alpha(i4) * f3));
        int red = (int) ((Color.red(i3) * f4) + (Color.red(i4) * f3));
        int green = (int) ((Color.green(i3) * f4) + (Color.green(i4) * f3));
        int blue = (int) ((Color.blue(i3) * f4) + (Color.blue(i4) * f3));
        if (alpha > 255) {
            alpha = 255;
        }
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

    private int s(float f3) {
        return Color.argb((int) (f3 * 255.0f), Color.red(this.f7918e), Color.green(this.f7918e), Color.blue(this.f7918e));
    }

    private void u() {
        float dimension = this.f7914a.getResources().getDimension(M1.f.f1454n);
        Y.b bVar = new Y.b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(bVar);
        ofFloat.setDuration(217L);
        ofFloat.addUpdateListener(new C0102b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, dimension);
        ofFloat2.setInterpolator(new f(null));
        ofFloat2.setDuration(450L);
        ofFloat2.addUpdateListener(new c());
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 0.3f);
        ofFloat3.setInterpolator(bVar);
        ofFloat3.setDuration(133L);
        ofFloat3.setStartDelay(80L);
        ofFloat3.addUpdateListener(new d());
        AnimatorSet animatorSet = new AnimatorSet();
        this.f7925l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        this.f7925l.addListener(new e());
    }

    private boolean w() {
        return this.f7914a.getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z3) {
        if (this.f7927n != null) {
            for (int i3 = 0; i3 < this.f7927n.size(); i3++) {
                ((COUIEditText.j) this.f7927n.get(i3)).b(z3);
            }
        }
    }

    void B(int i3, ColorStateList colorStateList) {
        this.f7915b.M(i3, colorStateList);
    }

    void C(int i3) {
        this.f7918e = i3;
    }

    void D(boolean z3) {
        E(z3, true);
    }

    void J(a.C0101a c0101a) {
        this.f7915b.Z(c0101a.z());
    }

    public void K(ColorStateList colorStateList) {
        this.f7916c = colorStateList;
    }

    void L(a.C0101a c0101a) {
        this.f7921h = c0101a.o();
        this.f7922i = c0101a.u();
        this.f7915b.N(this.f7921h);
        this.f7915b.Q(this.f7922i);
    }

    void l(COUIEditText.j jVar) {
        if (this.f7927n == null) {
            this.f7927n = new ArrayList();
        }
        if (this.f7927n.contains(jVar)) {
            return;
        }
        this.f7927n.add(jVar);
    }

    void n(Canvas canvas, int i3, int i4, int i5, Paint paint, Paint paint2) {
        this.f7923j.setColor(r(paint.getColor(), this.f7918e, this.f7930q));
        float f3 = i3;
        canvas.drawRect(0.0f, i3 - this.f7919f, i4, f3, this.f7923j);
        this.f7923j.setColor(r(paint2.getColor(), this.f7918e, this.f7930q));
        canvas.drawRect(0.0f, i3 - this.f7919f, i5, f3, this.f7923j);
    }

    void o(Canvas canvas, GradientDrawable gradientDrawable, int i3) {
        this.f7920g.setBounds(gradientDrawable.getBounds());
        if (gradientDrawable instanceof com.coui.appcompat.edittext.a) {
            this.f7920g.h(((com.coui.appcompat.edittext.a) gradientDrawable).a());
        }
        this.f7920g.setStroke(this.f7919f, r(i3, this.f7918e, this.f7930q));
        this.f7920g.draw(canvas);
    }

    void p(int[] iArr) {
        this.f7915b.Y(iArr);
    }

    void t(int i3, int i4, int i5, float[] fArr, a.C0101a c0101a) {
        this.f7916c = this.f7914a.getTextColors();
        this.f7917d = this.f7914a.getHighlightColor();
        this.f7918e = i3;
        this.f7919f = i4;
        if (i5 == 2) {
            this.f7915b.b0(Typeface.create("sans-serif-medium", 0));
        }
        this.f7915b.S(c0101a.w());
        this.f7915b.O(c0101a.p());
        this.f7915b.R(c0101a.v());
        com.coui.appcompat.edittext.a aVar = new com.coui.appcompat.edittext.a();
        this.f7920g = aVar;
        aVar.setCornerRadii(fArr);
        this.f7923j = new Paint();
        this.f7924k = new Paint();
        u();
        this.f7914a.addTextChangedListener(new a());
        J(c0101a);
        L(c0101a);
    }

    boolean v() {
        return this.f7926m;
    }

    void x(Canvas canvas) {
        Layout.Alignment alignment;
        float f3;
        float f4;
        if (this.f7928o && this.f7926m) {
            int save = canvas.save();
            if (w()) {
                canvas.translate(-this.f7931r, 0.0f);
            } else {
                canvas.translate(this.f7931r, 0.0f);
            }
            int compoundPaddingStart = this.f7914a.getCompoundPaddingStart();
            int compoundPaddingEnd = this.f7914a.getCompoundPaddingEnd();
            int width = this.f7914a.getWidth() - compoundPaddingEnd;
            int i3 = width - compoundPaddingStart;
            float x3 = width + this.f7914a.getX() + this.f7914a.getScrollX();
            float f5 = i3;
            float scrollX = (this.f7933t - this.f7914a.getScrollX()) - f5;
            this.f7914a.getLineBounds(0, f7913v);
            int save2 = canvas.save();
            if (w()) {
                canvas.translate(compoundPaddingEnd, r10.top);
            } else {
                canvas.translate(compoundPaddingStart, r10.top);
            }
            int save3 = canvas.save();
            if (this.f7914a.getBottom() - this.f7914a.getTop() == this.f7934u && this.f7933t > f5) {
                if (w()) {
                    canvas.clipRect(this.f7914a.getScrollX() + i3, 0.0f, this.f7914a.getScrollX(), this.f7934u);
                } else {
                    canvas.translate(-scrollX, 0.0f);
                    canvas.clipRect(this.f7914a.getScrollX(), 0.0f, x3, this.f7934u);
                }
            }
            Layout layout = this.f7914a.getLayout();
            layout.getPaint().setColor(this.f7916c.getDefaultColor());
            layout.draw(canvas);
            canvas.restoreToCount(save3);
            canvas.restoreToCount(save2);
            Layout.Alignment q3 = q();
            this.f7924k.setColor(s(this.f7932s));
            Layout.Alignment alignment2 = Layout.Alignment.ALIGN_NORMAL;
            if ((q3 != alignment2 || w()) && (!(q3 == (alignment = Layout.Alignment.ALIGN_OPPOSITE) && w()) && (!(q3 == alignment2 && w()) && (q3 != alignment || w())))) {
                float f6 = ((compoundPaddingStart + r4) - compoundPaddingEnd) / 2.0f;
                float f7 = this.f7933t;
                float f8 = f6 - (f7 / 2.0f);
                f3 = f8;
                f4 = f8 + f7;
            } else {
                f3 = compoundPaddingStart;
                f4 = f3;
            }
            canvas.drawRect(f3, r10.top, f4, r10.bottom, this.f7924k);
            canvas.restoreToCount(save);
        }
    }

    void y(a.C0101a c0101a) {
        Rect t3 = c0101a.t();
        Rect m3 = c0101a.m();
        this.f7915b.P(t3.left, t3.top, t3.right, t3.bottom);
        this.f7915b.L(m3.left, m3.top, m3.right, m3.bottom);
        this.f7915b.J();
    }
}
