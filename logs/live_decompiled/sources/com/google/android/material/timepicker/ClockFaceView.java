package com.google.android.material.timepicker;

import H0.e;
import H0.g;
import H0.i;
import H0.j;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.core.view.C0252a;
import androidx.core.view.accessibility.d;
import androidx.core.view.y;
import com.google.android.material.timepicker.ClockHandView;
import f.AbstractC0348a;
import java.util.Arrays;

/* loaded from: classes.dex */
class ClockFaceView extends com.google.android.material.timepicker.b implements ClockHandView.c {

    /* renamed from: h, reason: collision with root package name */
    private final ClockHandView f9968h;

    /* renamed from: i, reason: collision with root package name */
    private final Rect f9969i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f9970j;

    /* renamed from: k, reason: collision with root package name */
    private final SparseArray f9971k;

    /* renamed from: l, reason: collision with root package name */
    private final C0252a f9972l;

    /* renamed from: m, reason: collision with root package name */
    private final int[] f9973m;

    /* renamed from: n, reason: collision with root package name */
    private final float[] f9974n;

    /* renamed from: o, reason: collision with root package name */
    private final int f9975o;

    /* renamed from: p, reason: collision with root package name */
    private final int f9976p;

    /* renamed from: q, reason: collision with root package name */
    private final int f9977q;

    /* renamed from: r, reason: collision with root package name */
    private final int f9978r;

    /* renamed from: s, reason: collision with root package name */
    private String[] f9979s;

    /* renamed from: t, reason: collision with root package name */
    private float f9980t;

    /* renamed from: u, reason: collision with root package name */
    private final ColorStateList f9981u;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ClockFaceView.this.isShown()) {
                return true;
            }
            ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ClockFaceView.this.p(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f9968h.g()) - ClockFaceView.this.f9975o);
            return true;
        }
    }

    class b extends C0252a {
        b() {
        }

        @Override // androidx.core.view.C0252a
        public void onInitializeAccessibilityNodeInfo(View view, d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            int intValue = ((Integer) view.getTag(e.f583p)).intValue();
            if (intValue > 0) {
                dVar.o0((View) ClockFaceView.this.f9971k.get(intValue - 1));
            }
            dVar.T(d.c.a(0, 1, intValue, 1, false, view.isSelected()));
            dVar.R(true);
            dVar.b(d.a.f5085i);
        }

        @Override // androidx.core.view.C0252a
        public boolean performAccessibilityAction(View view, int i3, Bundle bundle) {
            if (i3 != 16) {
                return super.performAccessibilityAction(view, i3, bundle);
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            float x3 = view.getX() + (view.getWidth() / 2.0f);
            float height = (view.getHeight() / 2.0f) + view.getY();
            ClockFaceView.this.f9968h.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, x3, height, 0));
            ClockFaceView.this.f9968h.onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 1, x3, height, 0));
            return true;
        }
    }

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H0.a.f492x);
    }

    private void A(int i3) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f9971k.size();
        for (int i4 = 0; i4 < Math.max(this.f9979s.length, size); i4++) {
            TextView textView = (TextView) this.f9971k.get(i4);
            if (i4 >= this.f9979s.length) {
                removeView(textView);
                this.f9971k.remove(i4);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(g.f605j, (ViewGroup) this, false);
                    this.f9971k.put(i4, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f9979s[i4]);
                textView.setTag(e.f583p, Integer.valueOf(i4));
                y.j0(textView, this.f9972l);
                textView.setTextColor(this.f9981u);
                if (i3 != 0) {
                    textView.setContentDescription(getResources().getString(i3, this.f9979s[i4]));
                }
            }
        }
    }

    private void w() {
        RectF d3 = this.f9968h.d();
        for (int i3 = 0; i3 < this.f9971k.size(); i3++) {
            TextView textView = (TextView) this.f9971k.get(i3);
            if (textView != null) {
                textView.getDrawingRect(this.f9969i);
                offsetDescendantRectToMyCoords(textView, this.f9969i);
                textView.setSelected(d3.contains(this.f9969i.centerX(), this.f9969i.centerY()));
                textView.getPaint().setShader(x(d3, this.f9969i, textView));
                textView.invalidate();
            }
        }
    }

    private RadialGradient x(RectF rectF, Rect rect, TextView textView) {
        this.f9970j.set(rect);
        this.f9970j.offset(textView.getPaddingLeft(), textView.getPaddingTop());
        if (RectF.intersects(rectF, this.f9970j)) {
            return new RadialGradient(rectF.centerX() - this.f9970j.left, rectF.centerY() - this.f9970j.top, rectF.width() * 0.5f, this.f9973m, this.f9974n, Shader.TileMode.CLAMP);
        }
        return null;
    }

    private static float y(float f3, float f4, float f5) {
        return Math.max(Math.max(f3, f4), f5);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void a(float f3, boolean z3) {
        if (Math.abs(this.f9980t - f3) > 0.001f) {
            this.f9980t = f3;
            w();
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        d.r0(accessibilityNodeInfo).S(d.b.b(1, this.f9979s.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int y3 = (int) (this.f9978r / y(this.f9976p / displayMetrics.heightPixels, this.f9977q / displayMetrics.widthPixels, 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(y3, 1073741824);
        setMeasuredDimension(y3, y3);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    @Override // com.google.android.material.timepicker.b
    public void p(int i3) {
        if (i3 != l()) {
            super.p(i3);
            this.f9968h.j(l());
        }
    }

    public void z(String[] strArr, int i3) {
        this.f9979s = strArr;
        A(i3);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9969i = new Rect();
        this.f9970j = new RectF();
        this.f9971k = new SparseArray();
        this.f9974n = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f773d1, i3, i.f655t);
        Resources resources = getResources();
        ColorStateList a3 = R0.c.a(context, obtainStyledAttributes, j.f781f1);
        this.f9981u = a3;
        LayoutInflater.from(context).inflate(g.f606k, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(e.f578k);
        this.f9968h = clockHandView;
        this.f9975o = resources.getDimensionPixelSize(H0.c.f526i);
        int colorForState = a3.getColorForState(new int[]{R.attr.state_selected}, a3.getDefaultColor());
        this.f9973m = new int[]{colorForState, colorForState, a3.getDefaultColor()};
        clockHandView.b(this);
        int defaultColor = AbstractC0348a.a(context, H0.b.f496b).getDefaultColor();
        ColorStateList a4 = R0.c.a(context, obtainStyledAttributes, j.f777e1);
        setBackgroundColor(a4 != null ? a4.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new a());
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f9972l = new b();
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        z(strArr, 0);
        this.f9976p = resources.getDimensionPixelSize(H0.c.f539v);
        this.f9977q = resources.getDimensionPixelSize(H0.c.f540w);
        this.f9978r = resources.getDimensionPixelSize(H0.c.f528k);
    }
}
