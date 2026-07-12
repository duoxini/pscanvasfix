package com.google.android.material.timepicker;

import H0.i;
import H0.j;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f9984e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9985f;

    /* renamed from: g, reason: collision with root package name */
    private float f9986g;

    /* renamed from: h, reason: collision with root package name */
    private float f9987h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9988i;

    /* renamed from: j, reason: collision with root package name */
    private int f9989j;

    /* renamed from: k, reason: collision with root package name */
    private final List f9990k;

    /* renamed from: l, reason: collision with root package name */
    private final int f9991l;

    /* renamed from: m, reason: collision with root package name */
    private final float f9992m;

    /* renamed from: n, reason: collision with root package name */
    private final Paint f9993n;

    /* renamed from: o, reason: collision with root package name */
    private final RectF f9994o;

    /* renamed from: p, reason: collision with root package name */
    private final int f9995p;

    /* renamed from: q, reason: collision with root package name */
    private float f9996q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f9997r;

    /* renamed from: s, reason: collision with root package name */
    private double f9998s;

    /* renamed from: t, reason: collision with root package name */
    private int f9999t;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f3, boolean z3);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f492x);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float cos = (this.f9999t * ((float) Math.cos(this.f9998s))) + width;
        float f3 = height;
        float sin = (this.f9999t * ((float) Math.sin(this.f9998s))) + f3;
        this.f9993n.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.f9991l, this.f9993n);
        double sin2 = Math.sin(this.f9998s);
        double cos2 = Math.cos(this.f9998s);
        this.f9993n.setStrokeWidth(this.f9995p);
        canvas.drawLine(width, f3, r1 + ((int) (cos2 * r6)), height + ((int) (r6 * sin2)), this.f9993n);
        canvas.drawCircle(width, f3, this.f9992m, this.f9993n);
    }

    private int e(float f3, float f4) {
        int degrees = (int) Math.toDegrees(Math.atan2(f4 - (getHeight() / 2), f3 - (getWidth() / 2)));
        int i3 = degrees + 90;
        return i3 < 0 ? degrees + 450 : i3;
    }

    private Pair h(float f3) {
        float f4 = f();
        if (Math.abs(f4 - f3) > 180.0f) {
            if (f4 > 180.0f && f3 < 180.0f) {
                f3 += 360.0f;
            }
            if (f4 < 180.0f && f3 > 180.0f) {
                f4 += 360.0f;
            }
        }
        return new Pair(Float.valueOf(f4), Float.valueOf(f3));
    }

    private boolean i(float f3, float f4, boolean z3, boolean z4, boolean z5) {
        float e3 = e(f3, f4);
        boolean z6 = false;
        boolean z7 = f() != e3;
        if (z4 && z7) {
            return true;
        }
        if (!z7 && !z3) {
            return false;
        }
        if (z5 && this.f9985f) {
            z6 = true;
        }
        l(e3, z6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(float f3, boolean z3) {
        float f4 = f3 % 360.0f;
        this.f9996q = f4;
        this.f9998s = Math.toRadians(f4 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.f9999t * ((float) Math.cos(this.f9998s)));
        float sin = height + (this.f9999t * ((float) Math.sin(this.f9998s)));
        RectF rectF = this.f9994o;
        int i3 = this.f9991l;
        rectF.set(width - i3, sin - i3, width + i3, sin + i3);
        Iterator it = this.f9990k.iterator();
        while (it.hasNext()) {
            ((c) it.next()).a(f4, z3);
        }
        invalidate();
    }

    public void b(c cVar) {
        this.f9990k.add(cVar);
    }

    public RectF d() {
        return this.f9994o;
    }

    public float f() {
        return this.f9996q;
    }

    public int g() {
        return this.f9991l;
    }

    public void j(int i3) {
        this.f9999t = i3;
        invalidate();
    }

    public void k(float f3) {
        l(f3, false);
    }

    public void l(float f3, boolean z3) {
        ValueAnimator valueAnimator = this.f9984e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z3) {
            m(f3, false);
            return;
        }
        Pair h3 = h(f3);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h3.first).floatValue(), ((Float) h3.second).floatValue());
        this.f9984e = ofFloat;
        ofFloat.setDuration(200L);
        this.f9984e.addUpdateListener(new a());
        this.f9984e.addListener(new b());
        this.f9984e.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        k(f());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        boolean z5;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f9986g = x3;
            this.f9987h = y3;
            this.f9988i = true;
            this.f9997r = false;
            z3 = true;
            z4 = false;
            z5 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i3 = (int) (x3 - this.f9986g);
            int i4 = (int) (y3 - this.f9987h);
            this.f9988i = (i3 * i3) + (i4 * i4) > this.f9989j;
            z4 = this.f9997r;
            z5 = actionMasked == 1;
            z3 = false;
        } else {
            z4 = false;
            z3 = false;
            z5 = false;
        }
        this.f9997r |= i(x3, y3, z4, z3, z5);
        return true;
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9990k = new ArrayList();
        Paint paint = new Paint();
        this.f9993n = paint;
        this.f9994o = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f785g1, i3, i.f655t);
        this.f9999t = obtainStyledAttributes.getDimensionPixelSize(j.f793i1, 0);
        this.f9991l = obtainStyledAttributes.getDimensionPixelSize(j.f797j1, 0);
        this.f9995p = getResources().getDimensionPixelSize(H0.c.f527j);
        this.f9992m = r6.getDimensionPixelSize(H0.c.f525h);
        int color = obtainStyledAttributes.getColor(j.f789h1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.f9989j = ViewConfiguration.get(context).getScaledTouchSlop();
        y.u0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
