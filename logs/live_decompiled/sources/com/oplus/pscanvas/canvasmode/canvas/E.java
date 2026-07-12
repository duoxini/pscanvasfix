package com.oplus.pscanvas.canvasmode.canvas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.internal.dynamicanimation.animation.DynamicAnimation;
import com.android.internal.dynamicanimation.animation.FloatValueHolder;
import com.android.internal.dynamicanimation.animation.SpringAnimation;
import com.android.internal.dynamicanimation.animation.SpringForce;
import com.coui.appcompat.poplist.s;
import com.oplus.anim.EffectiveAnimationView;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import com.oplus.view.inputmethod.OplusInputMethodManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import t1.AbstractC0589c;
import u1.C0601d;
import x0.C0629c;

/* loaded from: classes.dex */
public class E implements ContainerActivity.h {

    /* renamed from: f0, reason: collision with root package name */
    static final String f10305f0 = "E";

    /* renamed from: g0, reason: collision with root package name */
    private static final Object f10306g0 = new Object();

    /* renamed from: A, reason: collision with root package name */
    private boolean f10307A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f10308B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f10309C;

    /* renamed from: E, reason: collision with root package name */
    private EffectiveAnimationView f10311E;

    /* renamed from: F, reason: collision with root package name */
    private ValueAnimator f10312F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f10313G;

    /* renamed from: H, reason: collision with root package name */
    private c f10314H;

    /* renamed from: I, reason: collision with root package name */
    private d f10315I;

    /* renamed from: J, reason: collision with root package name */
    private boolean f10316J;

    /* renamed from: K, reason: collision with root package name */
    private ArrayList f10317K;

    /* renamed from: L, reason: collision with root package name */
    private int f10318L;

    /* renamed from: M, reason: collision with root package name */
    private int f10319M;

    /* renamed from: N, reason: collision with root package name */
    private MotionEvent f10320N;

    /* renamed from: O, reason: collision with root package name */
    private boolean f10321O;

    /* renamed from: P, reason: collision with root package name */
    private C0629c f10322P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f10323Q;

    /* renamed from: R, reason: collision with root package name */
    public float f10324R;

    /* renamed from: T, reason: collision with root package name */
    private SpringAnimation f10326T;

    /* renamed from: U, reason: collision with root package name */
    private float f10327U;

    /* renamed from: V, reason: collision with root package name */
    private float f10328V;

    /* renamed from: W, reason: collision with root package name */
    private float f10329W;

    /* renamed from: X, reason: collision with root package name */
    private float f10330X;

    /* renamed from: Y, reason: collision with root package name */
    private float f10331Y;

    /* renamed from: a0, reason: collision with root package name */
    private c f10334a0;

    /* renamed from: b, reason: collision with root package name */
    private int f10335b;

    /* renamed from: c, reason: collision with root package name */
    private final int f10337c;

    /* renamed from: d0, reason: collision with root package name */
    private A1.e f10340d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f10341e;

    /* renamed from: f, reason: collision with root package name */
    private final int f10343f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f10344g;

    /* renamed from: h, reason: collision with root package name */
    private final ContainerView f10345h;

    /* renamed from: i, reason: collision with root package name */
    private final Vibrator f10346i;

    /* renamed from: j, reason: collision with root package name */
    private com.coui.appcompat.poplist.f f10347j;

    /* renamed from: k, reason: collision with root package name */
    private final int f10348k;

    /* renamed from: l, reason: collision with root package name */
    private final int f10349l;

    /* renamed from: m, reason: collision with root package name */
    private final int f10350m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f10351n;

    /* renamed from: o, reason: collision with root package name */
    private List f10352o;

    /* renamed from: s, reason: collision with root package name */
    private boolean f10356s;

    /* renamed from: w, reason: collision with root package name */
    private long f10360w;

    /* renamed from: x, reason: collision with root package name */
    private c f10361x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f10362y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f10363z;

    /* renamed from: a, reason: collision with root package name */
    private final PathInterpolator f10333a = new PathInterpolator(0.17f, 0.0f, 0.1f, 1.0f);

    /* renamed from: d, reason: collision with root package name */
    private long f10339d = 1;

    /* renamed from: p, reason: collision with root package name */
    private Rect f10353p = new Rect();

    /* renamed from: q, reason: collision with root package name */
    private boolean f10354q = false;

    /* renamed from: r, reason: collision with root package name */
    private List f10355r = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    private String f10357t = "";

    /* renamed from: u, reason: collision with root package name */
    private String f10358u = "";

    /* renamed from: v, reason: collision with root package name */
    private String f10359v = "";

    /* renamed from: D, reason: collision with root package name */
    private Rect f10310D = new Rect();

    /* renamed from: S, reason: collision with root package name */
    private long f10325S = -1;

    /* renamed from: Z, reason: collision with root package name */
    private int f10332Z = 0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f10336b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f10338c0 = false;

    /* renamed from: e0, reason: collision with root package name */
    private final Runnable f10342e0 = new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.A
        @Override // java.lang.Runnable
        public final void run() {
            E.this.k0();
        }
    };

    class a implements AdapterView.OnItemClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f10364e;

        a(c cVar) {
            this.f10364e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i3, long j3) {
            com.coui.appcompat.poplist.s sVar = (com.coui.appcompat.poplist.s) E.this.f10317K.get(i3);
            Log.d(E.f10305f0, "onItemClick " + i3 + ",getId:" + sVar.m());
            if (sVar.m() == 2) {
                E.this.P();
                E.this.f10345h.k0(this.f10364e);
                return;
            }
            if (sVar.m() == 1 && sVar.z()) {
                E.this.P();
                E.this.f10345h.K1();
                B1.h.a(E.this.f10344g.getApplicationContext()).d("menu_save", E.this.f10345h);
            } else if (sVar.m() == 3 && sVar.z()) {
                E.this.P();
                E.this.f10345h.f0(1);
                E.this.x0("menu_top_down", 1);
            } else if (sVar.m() == 4 && sVar.z()) {
                E.this.P();
                E.this.f10345h.f0(2);
                E.this.x0("menu_left_right", 2);
            }
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f10366a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ float f10367b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f10368c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f10369d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f10370e;

        b(float f3, float f4, float f5, float f6, c cVar) {
            this.f10366a = f3;
            this.f10367b = f4;
            this.f10368c = f5;
            this.f10369d = f6;
            this.f10370e = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            E.this.f10345h.f2();
            E.this.r0(null, this.f10366a, this.f10367b, (int) this.f10368c, (int) this.f10369d, 2, this.f10370e);
            E.this.f10311E.setVisibility(8);
            E.this.f10316J = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f10370e != E.this.f10314H || E.this.f10316J) {
                return;
            }
            E.this.f10313G = false;
            E.this.z0();
            E e3 = E.this;
            e3.f10315I = e3.new d(this.f10366a, this.f10367b, (int) this.f10368c, (int) this.f10369d, this.f10370e);
            E.this.f10344g.getMainThreadHandler().postDelayed(E.this.f10315I, 167L);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d(E.f10305f0, "onAnimationStart");
            if (E.this.f10315I != null) {
                E.this.f10344g.getMainThreadHandler().removeCallbacks(E.this.f10315I);
            }
            E.this.f10316J = false;
            E.this.f10311E.setVisibility(0);
            E.this.f10311E.v();
            E.this.f10313G = true;
            E.this.f10345h.f2();
            super.onAnimationStart(animator);
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        private final FrameLayout f10372a;

        /* renamed from: b, reason: collision with root package name */
        private final ImageView f10373b;

        /* renamed from: c, reason: collision with root package name */
        private int f10374c = 0;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f10375d = new Rect();

        c() {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(E.this.f10344g).inflate(t1.h.f13476i, (ViewGroup) null);
            this.f10372a = frameLayout;
            frameLayout.setBackgroundColor(0);
            this.f10373b = (ImageView) frameLayout.findViewById(t1.f.f13456p);
            if (frameLayout != null) {
                frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.F
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        E.c.this.l(view);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(View view) {
            E.this.o0(this);
        }

        public FrameLayout g() {
            return this.f10372a;
        }

        public ImageView h() {
            return this.f10373b;
        }

        public int i() {
            return this.f10374c;
        }

        public Rect j() {
            return this.f10375d;
        }

        public boolean k() {
            return this.f10374c == 0;
        }
    }

    private final class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final int f10377e;

        /* renamed from: f, reason: collision with root package name */
        private final int f10378f;

        /* renamed from: g, reason: collision with root package name */
        private final float f10379g;

        /* renamed from: h, reason: collision with root package name */
        private final float f10380h;

        /* renamed from: i, reason: collision with root package name */
        private final c f10381i;

        public d(float f3, float f4, int i3, int i4, c cVar) {
            this.f10377e = i3;
            this.f10378f = i4;
            this.f10379g = f3;
            this.f10380h = f4;
            this.f10381i = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            E.this.r0(null, this.f10379g, this.f10380h, this.f10377e, this.f10378f, 1, this.f10381i);
        }
    }

    public E(Context context, ContainerView containerView) {
        this.f10340d0 = null;
        this.f10344g = context;
        this.f10345h = containerView;
        Resources resources = context.getResources();
        this.f10349l = resources.getDimensionPixelSize(V1.c.f2538e);
        this.f10348k = 0;
        this.f10350m = resources.getDimensionPixelSize(V1.c.f2544k);
        this.f10335b = (int) context.getResources().getDimension(t1.d.f13385n);
        this.f10337c = (int) context.getResources().getDimension(t1.d.f13384m);
        this.f10341e = A(28.0f, context.getResources());
        this.f10343f = A(24.0f, context.getResources());
        this.f10340d0 = new A1.e(context, containerView);
        this.f10346i = (Vibrator) context.getSystemService("vibrator");
        if (context == null || B1.l.O1(context) == null) {
            return;
        }
        B1.l.O1(context).x1(this);
    }

    private int A(float f3, Resources resources) {
        return (int) TypedValue.applyDimension(1, f3, resources.getDisplayMetrics());
    }

    private com.coui.appcompat.poplist.s B0(s.a aVar, boolean z3) {
        boolean e12 = this.f10345h.e1();
        boolean z4 = (z3 || e12 || B1.l.y0(this.f10345h.getContainerController()) || !X()) ? false : true;
        aVar.C(z4 ? t1.e.f13415u : t1.e.f13414t).I(e12 ? this.f10344g.getResources().getString(t1.j.f13620T) : this.f10344g.getResources().getString(t1.j.f13646j0)).D(1).F(z4);
        return aVar.x();
    }

    private void F0(MotionEvent motionEvent, int i3, int i4) {
        EffectiveAnimationView effectiveAnimationView = this.f10311E;
        if (effectiveAnimationView != null) {
            effectiveAnimationView.setVisibility(8);
        }
        ContainerView containerView = this.f10345h;
        if (containerView == null || containerView.getFlexibleUiManager() == null) {
            return;
        }
        this.f10345h.o2();
        this.f10345h.getFlexibleUiManager().M(motionEvent, i3, i4, ((c) this.f10355r.get(0)).k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void k0() {
        boolean z3;
        float f3;
        float f4;
        ContainerView containerView = this.f10345h;
        if (containerView == null || !B1.l.N0(containerView)) {
            this.f10313G = false;
            return;
        }
        if (this.f10345h.getFlexibleUiManager() != null) {
            this.f10345h.getFlexibleUiManager().o(203);
        }
        List list = this.f10355r;
        if (list == null || list.size() != 1) {
            this.f10313G = false;
            return;
        }
        List<Rect> childrenPositionOnScreen = this.f10345h.getChildrenPositionOnScreen();
        if (childrenPositionOnScreen == null || childrenPositionOnScreen.size() != 2) {
            this.f10313G = false;
            return;
        }
        Rect rect = childrenPositionOnScreen.get(0);
        if (rect != null && (rect.left < 0 || rect.top < 0)) {
            this.f10313G = false;
            return;
        }
        if (!androidx.preference.j.b(this.f10344g).getBoolean("scroll_split_bar_tips_pres", true)) {
            this.f10313G = false;
            return;
        }
        ValueAnimator valueAnimator = this.f10312F;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f10312F.cancel();
        }
        final c cVar = (c) this.f10355r.get(0);
        if (cVar == null) {
            this.f10313G = false;
            return;
        }
        if (this.f10345h.S0(2)) {
            this.f10313G = false;
            return;
        }
        if (this.f10311E == null) {
            EffectiveAnimationView effectiveAnimationView = new EffectiveAnimationView(this.f10344g);
            this.f10311E = effectiveAnimationView;
            effectiveAnimationView.setBackgroundColor(this.f10344g.getResources().getColor(AbstractC0589c.f13365d, null));
            this.f10311E.setAnimation(t1.i.f13564i1);
            this.f10311E.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            z3 = true;
        } else {
            z3 = false;
        }
        final float f5 = cVar.f10375d.left;
        final float f6 = cVar.f10375d.top;
        this.f10311E.setVisibility(8);
        this.f10311E.setProgress(0.0f);
        this.f10311E.setTranslationX(0.0f);
        this.f10311E.setTranslationY(0.0f);
        int G02 = B1.l.O1(this.f10344g).G0();
        RelativeLayout.LayoutParams layoutParams = this.f10311E.getLayoutParams() == null ? new RelativeLayout.LayoutParams(330, 120) : (RelativeLayout.LayoutParams) this.f10311E.getLayoutParams();
        boolean z4 = cVar.i() == 0;
        if (z4) {
            layoutParams.leftMargin = cVar.f10375d.centerX() - 270;
            layoutParams.topMargin = cVar.f10375d.centerY() - 60;
            this.f10311E.setRotation(0.0f);
            f4 = 216.0f + f5;
            f3 = f6;
        } else {
            layoutParams.leftMargin = cVar.f10375d.centerX() - 165;
            layoutParams.topMargin = (cVar.f10375d.centerY() - 165) + G02;
            this.f10311E.setRotation(90.0f);
            f3 = 216.0f + f6;
            f4 = f5;
        }
        this.f10311E.setLayoutParams(layoutParams);
        if (z3) {
            ((ContainerActivity) this.f10344g).w0().addView(this.f10311E, layoutParams);
        }
        this.f10311E.setRepeatCount(0);
        this.f10351n = false;
        this.f10313G = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f10312F = ofFloat;
        ofFloat.setInterpolator(this.f10333a);
        this.f10312F.setDuration(883L);
        final boolean z5 = z4;
        final float f7 = f4;
        final float f8 = f3;
        this.f10312F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.B
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                E.this.l0(z5, f5, f6, f7, f8, cVar, valueAnimator2);
            }
        });
        this.f10312F.addListener(new b(f4, f3, f5, f6, cVar));
        this.f10323Q = true;
        this.f10312F.start();
        if (B1.s.w(this.f10344g) && B1.s.B()) {
            I0(z4 ? (cVar.f10373b.getHeight() / 2) - A(8.0f, this.f10344g.getResources()) : (-60) - A(8.0f, this.f10344g.getResources()));
        }
    }

    private void I0(int i3) {
        this.f10322P = new C0629c(this.f10344g);
        String string = this.f10344g.getString(t1.j.f13643i);
        this.f10322P.U(false);
        this.f10322P.T(string);
        this.f10322P.Z(this.f10314H.f10373b, 4, false, 0, i3);
        Log.d(f10305f0, "showScrollTipsText ");
    }

    private void J0(c cVar) {
        Rect rect;
        com.coui.appcompat.poplist.f fVar = this.f10347j;
        if (fVar != null && fVar.isShowing()) {
            Log.i(f10305f0, "split bar menu is showing");
            return;
        }
        Context context = this.f10344g;
        if (context == null || ((ContainerActivity) context).isFinishing()) {
            Log.i(f10305f0, "showSplitBarMenu invalid context");
            return;
        }
        if (this.f10345h.f10755S) {
            Log.e(f10305f0, "showSplitBarMenu return when duringTransform.");
            return;
        }
        OplusInputMethodManager.getInstance().hideCurrentInputMethod();
        S();
        T(cVar);
        this.f10347j.k0(this.f10317K);
        this.f10347j.p0(new a(cVar));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f10347j.getContentView().measure(makeMeasureSpec, makeMeasureSpec);
        int[] locationOnScreen = cVar.f10373b.getLocationOnScreen();
        float parentScaleX = this.f10345h.getParentScaleX();
        float parentScaleY = this.f10345h.getParentScaleY();
        if (cVar.k()) {
            int i3 = locationOnScreen[0];
            rect = new Rect(i3, locationOnScreen[1], (int) (i3 + (cVar.f10373b.getWidth() * parentScaleX)), (int) (locationOnScreen[1] + (cVar.f10373b.getHeight() * parentScaleY)));
        } else {
            int i4 = locationOnScreen[0];
            rect = new Rect(i4, locationOnScreen[1], (int) (i4 + (cVar.f10373b.getWidth() * parentScaleX)), (int) (locationOnScreen[1] + (cVar.f10373b.getHeight() * parentScaleY)));
        }
        Rect rect2 = new Rect(rect.centerX(), rect.centerY(), rect.centerX(), rect.centerY());
        if (rect2.left < this.f10345h.getWindowMetricsBounds().left + A(24.0f, this.f10344g.getResources())) {
            rect2.offset((this.f10345h.getWindowMetricsBounds().left + A(24.0f, this.f10344g.getResources())) - rect2.left, 0);
        }
        if (rect2.right > this.f10345h.getWindowMetricsBounds().right - A(24.0f, this.f10344g.getResources())) {
            rect2.offset((this.f10345h.getWindowMetricsBounds().right - A(24.0f, this.f10344g.getResources())) - rect2.right, 0);
        }
        if (rect2.bottom > this.f10345h.getWindowMetricsBounds().bottom - A(24.0f, this.f10344g.getResources())) {
            rect2.offset(0, (this.f10345h.getWindowMetricsBounds().bottom - A(24.0f, this.f10344g.getResources())) - rect2.bottom);
        }
        if (rect2.top < this.f10345h.getWindowMetricsBounds().top + A(24.0f, this.f10344g.getResources())) {
            rect2.offset(0, (this.f10345h.getWindowMetricsBounds().top + A(24.0f, this.f10344g.getResources())) - rect2.top);
        }
        this.f10347j.o0(true, true);
        this.f10347j.u0(((ContainerActivity) this.f10344g).w0(), rect2.left, rect2.top);
        this.f10345h.setCurrentPopWindow(this.f10347j);
    }

    private void K0(boolean z3, float f3, float f4, float f5, float f6, float f7, c cVar) {
        if (this.f10314H != cVar) {
            return;
        }
        if (z3) {
            p0(cVar, f4, f5, f4 + ((f6 - f4) * f3), f7, true);
        } else {
            p0(cVar, f4, f5, f6, f5 + ((f7 - f5) * f3), true);
        }
    }

    private int M() {
        return B1.d.f168d ? 150 : 250;
    }

    private void S() {
        com.coui.appcompat.poplist.f fVar = new com.coui.appcompat.poplist.f(this.f10344g);
        this.f10347j = fVar;
        fVar.setBackgroundDrawable(null);
        this.f10347j.setWindowLayoutType(2008);
        this.f10347j.setOutsideTouchable(true);
        this.f10347j.setSplitTouchEnabled(false);
        this.f10347j.setIsLaidOutInScreen(true);
        this.f10347j.setInputMethodMode(2);
        this.f10347j.setFocusable(true);
        this.f10347j.setTouchable(true);
        Context context = this.f10344g;
        if (context == null || B1.l.O1(context) == null) {
            return;
        }
        B1.l.O1(this.f10344g).t1(this.f10347j, this);
    }

    private void T(c cVar) {
        ArrayList arrayList = this.f10317K;
        if (arrayList == null) {
            this.f10317K = new ArrayList();
        } else {
            arrayList.clear();
        }
        if (B1.s.H() || B1.s.s(this.f10344g)) {
            u(cVar);
        } else if (B1.s.w(this.f10344g)) {
            t(cVar);
        } else {
            s(cVar);
        }
    }

    private boolean X() {
        for (C0601d c0601d : this.f10345h.getAdapter().l()) {
            int v3 = c0601d.v();
            Intent f3 = c0601d.f();
            ComponentName component = f3.getComponent();
            if (B1.l.Y(this.f10344g, component != null ? component.getPackageName() : f3.getPackage(), v3) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean Y(c cVar, Rect rect, Rect rect2) {
        return cVar.k() ? ((float) rect.centerX()) > ((float) rect2.width()) * 0.4f && ((float) rect.centerX()) < ((float) rect2.width()) * 0.6f : ((float) rect.centerY()) > ((float) rect2.height()) * 0.4f && ((float) rect.centerY()) < ((float) rect2.height()) * 0.6f;
    }

    public static boolean c0(String str, int i3) {
        if (!B1.q.d(null).g(str)) {
            return false;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ActivityTaskManager.getInstance().getTasks(5, true)) {
            if (runningTaskInfo.taskId == i3) {
                ComponentName componentName = runningTaskInfo.topActivity;
                synchronized (f10306g0) {
                    if (componentName != null) {
                        try {
                            if (B1.q.d(null).f(componentName)) {
                                return false;
                            }
                        } finally {
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean d0(C0601d c0601d) {
        if (c0601d == null) {
            return false;
        }
        return c0(c0601d.k(), c0601d.s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(DynamicAnimation dynamicAnimation, float f3, float f4) {
        if (this.f10332Z == 1) {
            this.f10345h.i2(this.f10352o, f3, f3 - (this.f10334a0.k() ? this.f10327U : this.f10328V), this.f10334a0);
        }
        if (this.f10332Z == 2) {
            t0(f3, this.f10334a0);
            this.f10332Z = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j0(DynamicAnimation dynamicAnimation, boolean z3, float f3, float f4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(boolean z3, float f3, float f4, float f5, float f6, c cVar, ValueAnimator valueAnimator) {
        K0(z3, ((Float) valueAnimator.getAnimatedValue()).floatValue(), f3, f4, f5, f6, cVar);
    }

    private void s(c cVar) {
        com.coui.appcompat.poplist.s sVar;
        s.a aVar = new s.a();
        boolean z3 = cVar.f10374c == 0;
        com.coui.appcompat.poplist.s x3 = aVar.C(z3 ? t1.e.f13416v : t1.e.f13393A).D(2).I(this.f10344g.getResources().getString(t1.j.f13652m0)).F(true).x();
        boolean L02 = B1.l.L0(this.f10345h.getContainerController());
        ContainerView containerView = this.f10345h;
        boolean K02 = B1.l.K0(L02, containerView, containerView.getContainerController(), this.f10344g);
        com.coui.appcompat.poplist.s B02 = B0(aVar, L02);
        com.coui.appcompat.poplist.s sVar2 = null;
        if (this.f10345h.getRectList().size() == 2 && z3) {
            sVar = aVar.C(K02 ? t1.e.f13420z : t1.e.f13419y).I(this.f10344g.getResources().getString(t1.j.f13650l0)).D(3).F(!K02).x();
        } else {
            sVar = null;
        }
        if (this.f10345h.getRectList().size() == 2 && !z3) {
            sVar2 = aVar.C(K02 ? t1.e.f13418x : t1.e.f13417w).I(this.f10344g.getResources().getString(t1.j.f13648k0)).D(4).F(!K02).x();
        }
        this.f10317K.add(x3);
        if (B02 != null) {
            this.f10317K.add(B02);
        }
        if (sVar != null) {
            this.f10317K.add(sVar);
        }
        if (sVar2 != null) {
            this.f10317K.add(sVar2);
        }
    }

    private void t(c cVar) {
        com.coui.appcompat.poplist.s B02;
        boolean z3 = cVar.f10374c == 0;
        s.a aVar = new s.a();
        this.f10317K.add(aVar.C(z3 ? t1.e.f13416v : t1.e.f13393A).I(this.f10344g.getResources().getString(t1.j.f13652m0)).D(2).F(true).x());
        if (!B1.s.B() || (B02 = B0(aVar, B1.l.L0(this.f10345h.getContainerController()))) == null) {
            return;
        }
        this.f10317K.add(B02);
    }

    private void t0(float f3, c cVar) {
        this.f10357t = "";
        this.f10358u = "";
        this.f10359v = "";
        if (this.f10345h.getContainerController().k() != 3) {
            return;
        }
        int M3 = M();
        B1.n.a().c("DefaultPolicy").f(this.f10345h, this.f10345h.v0(f3), M3, cVar);
    }

    private void u(c cVar) {
        s.a aVar = new s.a();
        com.coui.appcompat.poplist.s x3 = aVar.C(cVar.f10374c == 0 ? t1.e.f13416v : t1.e.f13393A).D(2).I(this.f10344g.getResources().getString(t1.j.f13652m0)).F(true).x();
        com.coui.appcompat.poplist.s B02 = B0(aVar, B1.l.L0(this.f10345h.getContainerController()));
        this.f10317K.add(x3);
        if (B02 != null) {
            this.f10317K.add(B02);
        }
    }

    private void u0(c cVar, float f3, float f4, float f5, float f6) {
        boolean z3 = cVar.f10374c == 0;
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        Rect windowMetricsBounds = this.f10345h.getWindowMetricsBounds();
        B1.m c3 = B1.n.a().c("DefaultPolicy");
        if (this.f10351n) {
            if (this.f10345h.getContainerController().k() != 3) {
                return;
            }
            float f9 = cVar.k() ? f5 : f6;
            float f10 = this.f10330X + f7;
            float f11 = this.f10331Y + f8;
            if (!cVar.k()) {
                f10 = f11;
            }
            float width = cVar.k() ? windowMetricsBounds.width() : windowMetricsBounds.height();
            if (f10 > width * 0.92f) {
                f9 = this.f10329W;
            }
            if (f10 < width * 0.08f) {
                f9 = this.f10329W;
            }
            this.f10329W = f9;
            this.f10326T.animateToFinalPosition(f9);
            return;
        }
        if (!z3 || Math.abs(f7) >= 40.0f) {
            if (z3 || Math.abs(f8) >= 40.0f) {
                ContainerView containerView = this.f10345h;
                if (containerView.f10755S) {
                    return;
                }
                this.f10321O = false;
                containerView.setLastDragMode(-1);
                C0601d l3 = this.f10345h.getContainerController().l(0);
                if (l3 == null) {
                    Log.i(f10305f0, "onSplitBarScrollInThreeSplit t0 is null");
                    return;
                }
                C0601d l4 = this.f10345h.getContainerController().l(1);
                if (l4 == null) {
                    Log.i(f10305f0, "onSplitBarScrollInThreeSplit t1 is null");
                    return;
                }
                C0601d l5 = this.f10345h.getContainerController().l(2);
                if (l5 == null) {
                    Log.i(f10305f0, "onSplitBarScrollInThreeSplit t2 is null");
                    return;
                }
                v0(false);
                try {
                    this.f10359v = "";
                    this.f10358u = "";
                    this.f10357t = "";
                    ApplicationInfo applicationInfo = this.f10344g.getPackageManager().getApplicationInfo(l3.k(), 128);
                    ApplicationInfo applicationInfo2 = this.f10344g.getPackageManager().getApplicationInfo(l4.k(), 128);
                    ApplicationInfo applicationInfo3 = this.f10344g.getPackageManager().getApplicationInfo(l5.k(), 128);
                    this.f10357t = applicationInfo.loadLabel(this.f10344g.getPackageManager()).toString();
                    this.f10358u = applicationInfo2.loadLabel(this.f10344g.getPackageManager()).toString();
                    this.f10359v = applicationInfo3.loadLabel(this.f10344g.getPackageManager()).toString();
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e(f10305f0, "can't find package exception ");
                }
                this.f10362y = x(this.f10345h, l3);
                this.f10363z = x(this.f10345h, l4);
                this.f10307A = x(this.f10345h, l5);
                ContainerView containerView2 = this.f10345h;
                containerView2.setOriginalLocations(containerView2.getChildrenPositionOnScreen());
                if (!c3.d(this.f10345h, cVar, f7, f8)) {
                    Log.i(f10305f0, "onSplitBarScrollInThreeSplit, forbid drag splitBar, not handle drag mode");
                    return;
                }
                this.f10327U = f3;
                this.f10328V = f4;
                this.f10334a0 = cVar;
                this.f10354q = Y(cVar, this.f10353p, windowMetricsBounds);
                this.f10330X = this.f10353p.centerX();
                this.f10331Y = this.f10353p.centerY();
                float f12 = cVar.k() ? this.f10330X : this.f10331Y;
                float width2 = cVar.k() ? windowMetricsBounds.width() : windowMetricsBounds.height();
                if (!cVar.k()) {
                    f7 = f8;
                }
                if (!this.f10354q && ((f12 > width2 * 0.92f && f7 > 0.0f) || (f12 < width2 * 0.08f && f7 < 0.0f))) {
                    Log.i(f10305f0, "onSplitBarScrollInThreeSplit, forbid drag splitBar, is max drag split bar");
                    return;
                }
                this.f10352o = this.f10345h.E2();
                this.f10351n = true;
                this.f10332Z = 1;
                this.f10345h.f10732G.R();
            }
        }
    }

    private c v(Rect rect, Rect rect2) {
        int splitPadding;
        int splitPadding2;
        if (rect.intersect(rect2)) {
            return null;
        }
        c cVar = new c();
        if (rect.right < rect2.left || rect2.right < rect.left) {
            cVar.f10374c = 0;
        } else {
            cVar.f10374c = 1;
        }
        int[] iArr = {rect.left, rect.right, rect2.left, rect2.right};
        int[] iArr2 = {rect.top, rect.bottom, rect2.top, rect2.bottom};
        Arrays.sort(iArr);
        Arrays.sort(iArr2);
        B1.l.f0(rect, rect2);
        if (cVar.f10374c == 0) {
            if (iArr[2] - iArr[1] > A(20.0f, this.f10344g.getResources())) {
                return null;
            }
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            if (i3 == i4) {
                int i5 = iArr2[2];
                int i6 = iArr2[3];
                if (i5 == i6) {
                    splitPadding2 = (i3 + i6) / 2;
                    Rect rect3 = cVar.f10375d;
                    int i7 = iArr[1];
                    int i8 = this.f10341e;
                    rect3.set(i7, splitPadding2 - (i8 / 2), iArr[2], splitPadding2 + (i8 / 2));
                }
            }
            if (i3 == i4) {
                splitPadding2 = iArr2[2] + (this.f10345h.getSplitPadding() / 2);
            } else {
                if (iArr2[2] != iArr2[3]) {
                    return null;
                }
                splitPadding2 = i4 - (this.f10345h.getSplitPadding() / 2);
            }
            Rect rect32 = cVar.f10375d;
            int i72 = iArr[1];
            int i82 = this.f10341e;
            rect32.set(i72, splitPadding2 - (i82 / 2), iArr[2], splitPadding2 + (i82 / 2));
        } else {
            if (iArr2[2] - iArr2[1] > A(20.0f, this.f10344g.getResources())) {
                return null;
            }
            int i9 = iArr[0];
            int i10 = iArr[1];
            if (i9 == i10) {
                int i11 = iArr[2];
                int i12 = iArr[3];
                if (i11 == i12) {
                    splitPadding = (i9 + i12) / 2;
                    Rect rect4 = cVar.f10375d;
                    int i13 = this.f10343f;
                    rect4.set(splitPadding - (i13 / 2), iArr2[1], splitPadding + (i13 / 2), iArr2[2]);
                }
            }
            if (i9 == i10) {
                splitPadding = iArr[2] + (this.f10345h.getSplitPadding() / 2);
            } else {
                if (iArr[2] != iArr[3]) {
                    return null;
                }
                splitPadding = i10 - (this.f10345h.getSplitPadding() / 2);
            }
            Rect rect42 = cVar.f10375d;
            int i132 = this.f10343f;
            rect42.set(splitPadding - (i132 / 2), iArr2[1], splitPadding + (i132 / 2), iArr2[2]);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str, int i3) {
        List l3 = this.f10345h.getAdapter().l();
        if (l3.size() != 2) {
            return;
        }
        int i4 = i3 == 1 ? 1 : i3 == 2 ? 2 : 0;
        C0601d c0601d = (C0601d) l3.get(0);
        C0601d c0601d2 = (C0601d) l3.get(1);
        B1.h.a(this.f10344g).c(str, 2, c0601d.k() + "&&" + c0601d2.k(), i4, (c0601d.u() && c0601d2.u()) ? 2 : (c0601d.u() || c0601d2.u()) ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        SharedPreferences.Editor edit = androidx.preference.j.b(this.f10344g).edit();
        edit.putBoolean("scroll_split_bar_tips_pres", false);
        edit.apply();
    }

    public void A0(MotionEvent motionEvent) {
        this.f10320N = motionEvent;
    }

    public void B() {
        if (!this.f10351n || this.f10321O || this.f10320N == null) {
            return;
        }
        r0(null, this.f10320N.getRawX(), this.f10320N.getRawY(), this.f10318L, this.f10319M, 0, (c) this.f10355r.get(0));
        Log.d(f10305f0, "endScrollOnPause lastReportMoveEvent:" + this.f10320N + ", startX: " + this.f10318L + ", mStartPointY: " + this.f10319M);
    }

    public c C(c cVar) {
        List list;
        if (cVar == null || (list = this.f10355r) == null || !list.contains(cVar)) {
            return null;
        }
        return ((c) this.f10355r.get(1)).equals(cVar) ? (c) this.f10355r.get(0) : ((c) this.f10355r.get(0)).equals(cVar) ? (c) this.f10355r.get(1) : null;
    }

    public void C0(Rect rect) {
        this.f10353p = new Rect(rect);
    }

    public ImageView D(ImageView imageView) {
        List list;
        if (imageView == null || (list = this.f10355r) == null) {
            return null;
        }
        return ((c) this.f10355r.get(1)).f10373b.equals(imageView) ? ((c) this.f10355r.get(0)).h() : ((c) list.get(0)).f10373b.equals(imageView) ? ((c) this.f10355r.get(1)).h() : null;
    }

    public void D0(int i3) {
        if (this.f10355r == null) {
            return;
        }
        if (i3 == 0 && B1.l.O1(this.f10344g) != null && B1.l.O1(this.f10344g).S0()) {
            return;
        }
        if (i3 == 0 && this.f10345h.getPanoramaModeManager().M()) {
            return;
        }
        for (c cVar : this.f10355r) {
            if (cVar.f10372a != null) {
                cVar.f10372a.setVisibility(i3);
                cVar.f10372a.setEnabled(i3 == 0);
                if (cVar.h() != null) {
                    cVar.h().setEnabled(i3 == 0);
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(cVar.f10372a, "Alpha", cVar.f10372a.getAlpha(), i3 == 0 ? 1.0f : 0.0f);
                ofFloat.setDuration(200L);
                ofFloat.start();
            }
        }
    }

    public String E() {
        return this.f10357t;
    }

    public void E0(int i3, int i4) {
        this.f10318L = i3;
        this.f10319M = i4;
    }

    public String F() {
        return this.f10358u;
    }

    public String G() {
        return this.f10359v;
    }

    public List H() {
        return this.f10355r;
    }

    public void H0() {
        if (B1.l.F0(this.f10344g) && !B1.s.w(this.f10344g)) {
            this.f10340d0.q(this.f10344g);
            return;
        }
        C0601d l3 = this.f10345h.getContainerController().l(0);
        boolean w3 = this.f10345h.getAdapter().w();
        if (l3 != null && !l3.a(this.f10345h.getAdapter().t(), w3) && w3) {
            Log.d(f10305f0, "isFillInSplit  return");
            return;
        }
        boolean z3 = androidx.preference.j.b(this.f10344g).getBoolean("scroll_split_bar_tips_pres", true);
        this.f10313G = z3;
        if (z3) {
            this.f10344g.getMainThreadHandler().removeCallbacks(this.f10342e0);
            this.f10344g.getMainThreadHandler().postDelayed(this.f10342e0, 500L);
        }
    }

    public List I() {
        return this.f10352o;
    }

    public int J() {
        List list = this.f10355r;
        if (list == null || list.size() != 1) {
            return 0;
        }
        return ((c) this.f10355r.get(0)).f10374c;
    }

    public int K(int i3) {
        List list = this.f10355r;
        if (list != null && i3 >= 0) {
            if (i3 < list.size()) {
                return ((c) this.f10355r.get(i3)).f10374c;
            }
            return 0;
        }
        Log.d(f10305f0, "getSplitBarOrientationForTips:" + i3);
        return 0;
    }

    public Rect L() {
        return this.f10353p;
    }

    public int N() {
        List<c> list = this.f10355r;
        if (list == null) {
            return 4;
        }
        for (c cVar : list) {
            if (cVar.f10372a != null && cVar.f10372a.isVisibleToUser()) {
                return 0;
            }
        }
        return 4;
    }

    public float O() {
        return this.f10324R;
    }

    public void P() {
        com.coui.appcompat.poplist.f fVar = this.f10347j;
        if (fVar != null) {
            fVar.dismiss();
        }
    }

    public void Q() {
        C0629c c0629c = this.f10322P;
        if (c0629c == null || !c0629c.isShowing()) {
            return;
        }
        this.f10322P.dismiss();
    }

    public void R() {
        SpringAnimation springAnimation = this.f10326T;
        if (springAnimation != null && springAnimation.isRunning()) {
            Log.d(f10305f0, "initDragSplitBarSpringAnimation, SpringAnimation is running");
            return;
        }
        float f3 = this.f10334a0.k() ? this.f10327U : this.f10328V;
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(B1.s.k(0.15f)).setDampingRatio(B1.s.c(0.0f));
        SpringAnimation springAnimation2 = new SpringAnimation(new FloatValueHolder(f3));
        this.f10326T = springAnimation2;
        springAnimation2.setSpring(springForce);
        DynamicAnimation.OnAnimationUpdateListener onAnimationUpdateListener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.C
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f4, float f5) {
                E.this.i0(dynamicAnimation, f4, f5);
            }
        };
        DynamicAnimation.OnAnimationEndListener onAnimationEndListener = new DynamicAnimation.OnAnimationEndListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.D
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z3, float f4, float f5) {
                E.j0(dynamicAnimation, z3, f4, f5);
            }
        };
        this.f10326T.addUpdateListener(onAnimationUpdateListener);
        this.f10326T.addEndListener(onAnimationEndListener);
        this.f10326T.setStartValue(f3);
        this.f10326T.animateToFinalPosition(f3);
        this.f10326T.start();
    }

    public void U(Intent intent) {
        if (intent == null || intent.getExtras() == null || !intent.getExtras().getBoolean("isPsSplitScreenCombination")) {
            return;
        }
        this.f10313G = false;
    }

    public void V() {
        this.f10355r = new ArrayList();
        int i3 = 0;
        while (i3 < this.f10345h.getRectList().size()) {
            int i4 = i3 + 1;
            for (int i5 = i4; i5 < this.f10345h.getRectList().size(); i5++) {
                c v3 = v(this.f10345h.getRectList().get(i3), this.f10345h.getRectList().get(i5));
                if (v3 != null) {
                    Iterator it = this.f10355r.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (((c) it.next()).f10375d.intersect(v3.f10375d)) {
                                break;
                            }
                        } else {
                            this.f10355r.add(v3);
                            break;
                        }
                    }
                }
            }
            i3 = i4;
        }
    }

    public c W(MotionEvent motionEvent) {
        if (motionEvent.getDownTime() == this.f10360w) {
            return this.f10361x;
        }
        for (c cVar : this.f10355r) {
            cVar.f10372a.getBoundsOnScreen(this.f10310D);
            if (this.f10310D.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.f10361x = cVar;
                this.f10360w = motionEvent.getDownTime();
                return cVar;
            }
        }
        this.f10361x = null;
        this.f10360w = motionEvent.getDownTime();
        return null;
    }

    public boolean Z() {
        A1.e eVar = this.f10340d0;
        return eVar != null && eVar.m();
    }

    @Override // com.oplus.pscanvas.canvasmode.canvas.ContainerActivity.h
    public void a(com.coui.appcompat.poplist.f fVar) {
        com.coui.appcompat.poplist.f fVar2 = this.f10347j;
        if (fVar2 == null || fVar == fVar2 || !fVar2.isShowing()) {
            return;
        }
        this.f10347j.dismiss();
    }

    public boolean a0() {
        return this.f10362y;
    }

    public boolean b0() {
        return this.f10351n;
    }

    public boolean e0() {
        List list;
        if (B1.l.N0(this.f10345h) && (list = this.f10355r) != null && list.size() == 1) {
            return this.f10313G;
        }
        return false;
    }

    public boolean f0() {
        return this.f10363z;
    }

    public boolean g0() {
        return this.f10307A;
    }

    public void m0(c cVar, float f3) {
        Context context = this.f10344g;
        if (context == null || this.f10345h == null) {
            return;
        }
        if (!AccessibilityManager.getInstance(context).isEnabled() || this.f10345h.getAutoScale() >= 1.0f) {
            this.f10335b = (int) this.f10344g.getResources().getDimension(t1.d.f13385n);
        } else {
            this.f10335b = (int) this.f10344g.getResources().getDimension(t1.d.f13386o);
        }
        this.f10314H = cVar;
        if (this.f10345h.getContainerController().k() == 2) {
            cVar.f10373b.setImageDrawable(this.f10344g.getResources().getDrawable(cVar.k() ? t1.e.f13405k : t1.e.f13403i));
        } else {
            cVar.f10373b.setImageDrawable(this.f10344g.getResources().getDrawable(cVar.k() ? t1.e.f13405k : t1.e.f13403i));
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        cVar.f10372a.measure(makeMeasureSpec, makeMeasureSpec);
        if (cVar.i() == 0) {
            cVar.f10372a.layout(cVar.f10375d.left - this.f10335b, cVar.f10375d.top - this.f10337c, cVar.f10375d.right + this.f10335b, cVar.f10375d.bottom + this.f10337c);
        } else {
            cVar.f10372a.layout(cVar.f10375d.left - this.f10337c, cVar.f10375d.top - this.f10335b, cVar.f10375d.right + this.f10337c, cVar.f10375d.bottom + this.f10335b);
        }
        cVar.f10372a.setAlpha(f3);
        cVar.f10372a.setFocusable(true);
        cVar.f10372a.setFocusableInTouchMode(true);
    }

    public void n0() {
        if (!B1.l.F0(this.f10344g) || B1.s.w(this.f10344g) || this.f10345h.Q2(this.f10344g) == null || this.f10345h.Q2(this.f10344g).t0() != 3) {
            return;
        }
        Log.d(f10305f0, "notifyMultiFlexibleTaskToCanvasEnd");
        A1.e eVar = this.f10340d0;
        if (eVar != null) {
            eVar.q(this.f10344g);
        }
    }

    public void o0(c cVar) {
        J0(cVar);
    }

    public void p0(c cVar, float f3, float f4, float f5, float f6, boolean z3) {
        Context context = this.f10344g;
        if (context == null) {
            Log.i(f10305f0, "onSplitBarScroll invalid context");
            return;
        }
        ContainerActivity O12 = B1.l.O1(context);
        if (O12 == null || O12.isFinishing()) {
            Log.i(f10305f0, "onSplitBarScroll activity finishing");
            return;
        }
        if (z3 && cVar != this.f10314H) {
            return;
        }
        if (this.f10345h.getContainerController().k() == 3) {
            u0(cVar, f3, f4, f5, f6);
            return;
        }
        if (this.f10345h.getContainerController().k() == 2) {
            if ((B1.l.g0(this.f10345h, this.f10345h.getContainerController().l(0), this.f10344g) & 1) != 0) {
                return;
            }
        }
        boolean z4 = cVar.f10374c == 0;
        ImageView imageView = cVar.f10373b;
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        if (this.f10351n) {
            if (this.f10345h.getContainerController().k() != 2) {
                return;
            }
            if (z4) {
                ContainerView containerView = this.f10345h;
                if (containerView.h2(this.f10352o, f5, containerView.getContainerGroupRect().exactCenterY(), f7, 0.0f, this.f10356s, this.f10357t, this.f10358u, this.f10362y, this.f10363z, this.f10308B, this.f10309C, this.f10353p)) {
                    imageView.setTranslationX(f7 / this.f10345h.getParentScaleX());
                    EffectiveAnimationView effectiveAnimationView = this.f10311E;
                    if (effectiveAnimationView != null) {
                        effectiveAnimationView.setTranslationX(f7 / this.f10345h.getParentScaleX());
                        return;
                    }
                    return;
                }
                return;
            }
            ContainerView containerView2 = this.f10345h;
            if (containerView2.h2(this.f10352o, containerView2.getContainerGroupRect().exactCenterX(), f6, 0.0f, f8, this.f10356s, this.f10357t, this.f10358u, this.f10362y, this.f10363z, this.f10308B, this.f10309C, this.f10353p)) {
                imageView.setTranslationY(f8 / this.f10345h.getParentScaleY());
                EffectiveAnimationView effectiveAnimationView2 = this.f10311E;
                if (effectiveAnimationView2 != null) {
                    effectiveAnimationView2.setTranslationY(f8 / this.f10345h.getParentScaleY());
                    return;
                }
                return;
            }
            return;
        }
        if (!z4 || Math.abs(f7) >= 40.0f) {
            if (z4 || Math.abs(f8) >= 40.0f) {
                ContainerView containerView3 = this.f10345h;
                if (containerView3.f10755S) {
                    return;
                }
                this.f10351n = true;
                this.f10321O = false;
                if (containerView3.getContainerController().k() == 3) {
                    return;
                }
                this.f10356s = B1.l.N0(this.f10345h);
                C0601d l3 = this.f10345h.getContainerController().l(0);
                if (l3 == null) {
                    Log.i(f10305f0, "onSplitBarScroll t0 is null");
                    return;
                }
                C0601d l4 = this.f10345h.getContainerController().l(1);
                if (l4 == null) {
                    Log.i(f10305f0, "onSplitBarScroll t1 is null");
                    return;
                }
                v0(false);
                try {
                    this.f10358u = "";
                    this.f10357t = "";
                    ApplicationInfo applicationInfo = this.f10344g.getPackageManager().getApplicationInfo(l3.k(), 128);
                    ApplicationInfo applicationInfo2 = this.f10344g.getPackageManager().getApplicationInfo(l4.k(), 128);
                    this.f10357t = applicationInfo.loadLabel(this.f10344g.getPackageManager()).toString();
                    this.f10358u = applicationInfo2.loadLabel(this.f10344g.getPackageManager()).toString();
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e(f10305f0, "can't find package exception ");
                }
                this.f10345h.r2();
                this.f10324R = this.f10345h.j1() ? f5 : f6;
                this.f10353p.set(this.f10345h.getSplitBarRegionForTwoSplitLayout());
                B1.n.a().b(this.f10344g).h(this.f10353p, this.f10345h);
                this.f10336b0 = B1.l.x0(l3);
                this.f10338c0 = B1.l.x0(l4);
                this.f10362y = w(l3) && !this.f10336b0;
                this.f10363z = w(l4) && !this.f10338c0;
                this.f10308B = l3.a(this.f10345h.getAdapter().t(), this.f10345h.getAdapter().w()) && !this.f10336b0;
                this.f10309C = l4.a(this.f10345h.getAdapter().t(), this.f10345h.getAdapter().w()) && !this.f10338c0;
                EffectiveAnimationView effectiveAnimationView3 = this.f10311E;
                if (effectiveAnimationView3 != null) {
                    if (z3) {
                        effectiveAnimationView3.setVisibility(0);
                    } else {
                        effectiveAnimationView3.setVisibility(8);
                    }
                }
                B1.l.u1(this.f10345h, 20110, true);
                B1.g.c(this.f10344g, 406);
                this.f10352o = this.f10345h.D2(cVar, f7, f8, this.f10356s, this.f10362y, this.f10363z);
            }
        }
    }

    public void q0(c cVar, MotionEvent motionEvent, MotionEvent motionEvent2) {
        p0(cVar, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent2.getRawX(), motionEvent2.getRawY(), false);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r0(android.view.MotionEvent r23, float r24, float r25, int r26, int r27, int r28, com.oplus.pscanvas.canvasmode.canvas.E.c r29) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.E.r0(android.view.MotionEvent, float, float, int, int, int, com.oplus.pscanvas.canvasmode.canvas.E$c):void");
    }

    public void s0(MotionEvent motionEvent, int i3, int i4) {
        r0(motionEvent, motionEvent.getRawX(), motionEvent.getRawY(), i3, i4, 0, this.f10345h.f10732G.W(motionEvent));
    }

    public void v0(boolean z3) {
        if (!z3) {
            this.f10325S = System.currentTimeMillis();
            return;
        }
        if (this.f10325S != -1) {
            long currentTimeMillis = System.currentTimeMillis() - this.f10325S;
            Log.d(f10305f0, "it takes " + currentTimeMillis + "ms from start scrolling splitBar to mask show");
            this.f10325S = -1L;
        }
    }

    public boolean w(C0601d c0601d) {
        boolean z3 = B1.l.L0(this.f10345h.getContainerController()) && B1.l.f214n.contains(c0601d.k()) && !B1.s.w(this.f10344g);
        Rect rect = new Rect(c0601d.f13810a);
        boolean z4 = rect.width() <= rect.height();
        boolean z5 = (!this.f10345h.j1() || z4) && !(this.f10345h.m1() && z4);
        if (B1.s.w(this.f10344g) && B1.s.B()) {
            return c0601d.D() && !z3;
        }
        if (B1.s.H() && "com.oplus.wpslauncher".equals(c0601d.k()) && J() == 1) {
            return false;
        }
        return (c0601d.D() && !z3 && z5) || B1.s.w(this.f10344g);
    }

    public void w0() {
        if (!B1.l.F0(this.f10344g) || B1.s.w(this.f10344g)) {
            this.f10344g.getMainThreadHandler().removeCallbacks(this.f10342e0);
            this.f10323Q = false;
            EffectiveAnimationView effectiveAnimationView = this.f10311E;
            if (effectiveAnimationView != null) {
                effectiveAnimationView.setVisibility(8);
            }
            ValueAnimator valueAnimator = this.f10312F;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.f10312F.cancel();
        }
    }

    public boolean x(ContainerView containerView, C0601d c0601d) {
        if (c0601d == null) {
            Log.d(f10305f0, "canResizeInThreeSplit, taskData is null");
            return false;
        }
        boolean U02 = containerView.U0(containerView.t0(c0601d), c0601d);
        if (B1.s.H()) {
            if (c0601d.p() == 1) {
                return !U02;
            }
        } else if (!B1.s.w(this.f10344g) && c0601d.p() == 1) {
            Rect rect = new Rect(c0601d.f13810a);
            boolean z3 = rect.width() <= rect.height();
            if ((!this.f10345h.j1() || z3) && (!this.f10345h.m1() || !z3)) {
                return !U02;
            }
        }
        return false;
    }

    public void y() {
        SpringAnimation springAnimation;
        this.f10351n = false;
        if (this.f10345h.getContainerController().k() == 3 && (springAnimation = this.f10326T) != null && springAnimation.isRunning()) {
            this.f10326T.cancel();
        }
        this.f10345h.setIsReparentAnim(false);
        this.f10345h.setIsCancelSplitBarScroll(true);
        this.f10345h.getCanvasMaskListView().k();
        this.f10345h.getCanvasMaskManager().P(0L, new C2.a() { // from class: com.oplus.pscanvas.canvasmode.canvas.z
            @Override // C2.a
            public final Object invoke() {
                p2.q qVar;
                qVar = p2.q.f12810a;
                return qVar;
            }
        });
        this.f10332Z = 0;
        this.f10361x = null;
        this.f10345h.b2();
        this.f10345h.setSplitBarVisibility(0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.flexible.animatingScrollSplitBarAnimation", false);
        B1.l.f(bundle);
    }

    public boolean y0() {
        if (B1.l.F0(this.f10344g) && !B1.s.w(this.f10344g)) {
            return true;
        }
        ValueAnimator valueAnimator = this.f10312F;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f10312F.cancel();
            return true;
        }
        ContainerView containerView = this.f10345h;
        if (containerView == null) {
            return false;
        }
        List<EmbeddedViewDecor> childEmbeddedViewList = containerView.getChildEmbeddedViewList();
        if (childEmbeddedViewList.size() != 2) {
            return false;
        }
        Iterator<EmbeddedViewDecor> it = childEmbeddedViewList.iterator();
        while (it.hasNext()) {
            C0601d taskData = it.next().getTaskData();
            if (taskData == null || taskData.s() <= 0) {
                return false;
            }
        }
        return true;
    }

    public void z(boolean z3) {
        A1.e eVar = this.f10340d0;
        if (eVar != null) {
            eVar.j(z3);
        }
    }
}
