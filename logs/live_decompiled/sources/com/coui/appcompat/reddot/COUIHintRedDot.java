package com.coui.appcompat.reddot;

import Z1.g;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import k0.C0421a;

/* loaded from: classes.dex */
public class COUIHintRedDot extends View {

    /* renamed from: v, reason: collision with root package name */
    public static final Interpolator f8946v = new Y.e();

    /* renamed from: e, reason: collision with root package name */
    private boolean f8947e;

    /* renamed from: f, reason: collision with root package name */
    private int f8948f;

    /* renamed from: g, reason: collision with root package name */
    private int f8949g;

    /* renamed from: h, reason: collision with root package name */
    private String f8950h;

    /* renamed from: i, reason: collision with root package name */
    private String f8951i;

    /* renamed from: j, reason: collision with root package name */
    private int f8952j;

    /* renamed from: k, reason: collision with root package name */
    private C0421a f8953k;

    /* renamed from: l, reason: collision with root package name */
    private RectF f8954l;

    /* renamed from: m, reason: collision with root package name */
    private String f8955m;

    /* renamed from: n, reason: collision with root package name */
    private int f8956n;

    /* renamed from: o, reason: collision with root package name */
    private int f8957o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8958p;

    /* renamed from: q, reason: collision with root package name */
    private ValueAnimator f8959q;

    /* renamed from: r, reason: collision with root package name */
    private int f8960r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f8961s;

    /* renamed from: t, reason: collision with root package name */
    private ValueAnimator f8962t;

    /* renamed from: u, reason: collision with root package name */
    private Drawable f8963u;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIHintRedDot.this.f8960r = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            COUIHintRedDot.this.requestLayout();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            COUIHintRedDot.this.f8961s = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            COUIHintRedDot.this.f8961s = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            COUIHintRedDot.this.f8961s = true;
            COUIHintRedDot.this.m();
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            COUIHintRedDot.this.f8957o = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        }
    }

    class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            COUIHintRedDot.this.f8958p = false;
            COUIHintRedDot cOUIHintRedDot = COUIHintRedDot.this;
            cOUIHintRedDot.f8949g = cOUIHintRedDot.f8952j;
            COUIHintRedDot cOUIHintRedDot2 = COUIHintRedDot.this;
            cOUIHintRedDot2.f8950h = String.valueOf(cOUIHintRedDot2.f8949g);
            COUIHintRedDot.this.f8952j = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            COUIHintRedDot.this.f8958p = false;
            COUIHintRedDot cOUIHintRedDot = COUIHintRedDot.this;
            cOUIHintRedDot.f8949g = cOUIHintRedDot.f8952j;
            COUIHintRedDot cOUIHintRedDot2 = COUIHintRedDot.this;
            cOUIHintRedDot2.f8950h = String.valueOf(cOUIHintRedDot2.f8949g);
            COUIHintRedDot.this.f8952j = 0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            COUIHintRedDot.this.f8958p = true;
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f3 = (Float) valueAnimator.getAnimatedValue();
            if (COUIHintRedDot.this.getVisibility() != 8) {
                COUIHintRedDot.this.setScaleX(f3.floatValue());
                COUIHintRedDot.this.setScaleY(f3.floatValue());
                COUIHintRedDot.this.invalidate();
            }
        }
    }

    class f implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f8969a;

        f(boolean z3) {
            this.f8969a = z3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f8969a) {
                return;
            }
            COUIHintRedDot.this.setPointMode(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8969a) {
                return;
            }
            COUIHintRedDot.this.setVisibility(8);
            COUIHintRedDot.this.setPointMode(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f8969a) {
                COUIHintRedDot.this.setVisibility(0);
                COUIHintRedDot.this.requestLayout();
            }
        }
    }

    public COUIHintRedDot(Context context) {
        this(context, null);
    }

    private void k() {
        ValueAnimator valueAnimator = this.f8959q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f8959q.end();
        }
        ValueAnimator valueAnimator2 = this.f8962t;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f8962t.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f8962t == null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(255, 0);
            this.f8962t = ofInt;
            ofInt.setDuration(150L);
            this.f8962t.addUpdateListener(new c());
            this.f8962t.addListener(new d());
        }
        this.f8962t.start();
    }

    private void o(int i3, int i4) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f8953k.o(this.f8948f, i3), this.f8953k.o(this.f8948f, i4));
        this.f8959q = ofInt;
        ofInt.setDuration(517L);
        this.f8959q.setInterpolator(f8946v);
        this.f8959q.addUpdateListener(new a());
        this.f8959q.addListener(new b());
        this.f8959q.start();
    }

    public boolean getIsLaidOut() {
        return this.f8947e;
    }

    public int getPointMode() {
        return this.f8948f;
    }

    public int getPointNumber() {
        return this.f8949g;
    }

    public String getPointText() {
        return this.f8950h;
    }

    public void l(int i3) {
        int i4;
        if (getVisibility() == 8 || (i4 = this.f8948f) == 0 || i4 == 1 || i4 == 4 || i4 == 5 || this.f8949g == i3 || i3 <= 0 || this.f8953k == null) {
            return;
        }
        k();
        if (!this.f8947e) {
            setPointNumber(i3);
        } else {
            this.f8952j = i3;
            o(this.f8949g, i3);
        }
    }

    public void n(boolean z3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(z3 ? 0.0f : 1.0f, z3 ? 1.0f : 0.0f);
        ofFloat.setDuration(520L);
        ofFloat.setInterpolator(f8946v);
        ofFloat.addUpdateListener(new e());
        ofFloat.addListener(new f(z3));
        ofFloat.start();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        k();
        super.onDetachedFromWindow();
        this.f8947e = false;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        RectF rectF = this.f8954l;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = getWidth();
        this.f8954l.bottom = getHeight();
        if (this.f8958p && ((i3 = this.f8949g) < 1000 || this.f8952j < 1000)) {
            C0421a c0421a = this.f8953k;
            int i4 = this.f8957o;
            c0421a.d(canvas, i3, i4, this.f8952j, 255 - i4, this.f8954l);
        } else {
            int i5 = this.f8949g;
            if (i5 == 0 || i5 < 1000) {
                this.f8953k.g(canvas, this.f8948f, this.f8950h, this.f8954l);
            } else {
                this.f8953k.g(canvas, this.f8948f, this.f8951i, this.f8954l);
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        this.f8947e = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(this.f8961s ? this.f8960r : this.f8953k.p(this.f8948f, this.f8950h), this.f8953k.n(this.f8948f));
    }

    public void p() {
        this.f8947e = true;
    }

    public void setBgColor(int i3) {
        this.f8953k.r(i3);
    }

    public void setCornerRadius(int i3) {
        this.f8953k.s(i3);
    }

    public void setDotDiameter(int i3) {
        this.f8953k.t(i3);
    }

    public void setEllipsisDiameter(int i3) {
        this.f8953k.u(i3);
    }

    public void setLargeWidth(int i3) {
        this.f8953k.v(i3);
    }

    public void setMediumWidth(int i3) {
        this.f8953k.w(i3);
    }

    public void setPointMode(int i3) {
        if (this.f8948f != i3) {
            this.f8948f = i3;
            if (i3 == 4) {
                setBackground(this.f8963u);
            }
            requestLayout();
            int i4 = this.f8948f;
            if (i4 == 1 || i4 == 4) {
                setContentDescription(this.f8955m);
            } else if (i4 == 0) {
                setContentDescription("");
            }
        }
    }

    public void setPointNumber(int i3) {
        this.f8949g = i3;
        if (i3 != 0) {
            setPointText(String.valueOf(i3));
        } else {
            setPointText("");
        }
        if (i3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(",");
            Resources resources = getResources();
            int i4 = this.f8956n;
            int i5 = this.f8949g;
            sb.append(resources.getQuantityString(i4, i5, Integer.valueOf(i5)));
            setContentDescription(sb.toString());
        }
    }

    public void setPointText(String str) {
        this.f8950h = str;
        requestLayout();
    }

    public void setSmallWidth(int i3) {
        this.f8953k.x(i3);
    }

    public void setTextColor(int i3) {
        this.f8953k.y(i3);
    }

    public void setTextSize(int i3) {
        this.f8953k.z(i3);
    }

    public void setViewHeight(int i3) {
        this.f8953k.A(i3);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Z1.a.f3107b);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, Z1.f.f3118a);
    }

    public COUIHintRedDot(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f8948f = 0;
        this.f8949g = 0;
        this.f8950h = "";
        this.f8952j = 0;
        this.f8957o = 255;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3120a, i3, i4);
        this.f8948f = obtainStyledAttributes.getInteger(g.f3127h, 0);
        setPointNumber(obtainStyledAttributes.getInteger(g.f3128i, 0));
        this.f8950h = obtainStyledAttributes.getString(g.f3129j);
        obtainStyledAttributes.recycle();
        this.f8953k = new C0421a(context, attributeSet, g.f3120a, i3, i4);
        this.f8954l = new RectF();
        this.f8955m = getResources().getString(Z1.e.f3116a);
        this.f8956n = Z1.d.f3115a;
        Drawable drawable = context.getResources().getDrawable(Z1.c.f3114a);
        this.f8963u = drawable;
        if (this.f8948f == 4) {
            setBackground(drawable);
        }
        this.f8951i = context.getString(Z1.e.f3117b);
    }
}
