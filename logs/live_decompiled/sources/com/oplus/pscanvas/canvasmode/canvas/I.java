package com.oplus.pscanvas.canvasmode.canvas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityTaskManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.SurfaceSession;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import androidx.preference.Preference;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import com.oplus.wrapper.view.SurfaceControl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import t1.AbstractC0587a;
import u1.C0601d;

/* loaded from: classes.dex */
public class I {

    /* renamed from: b0, reason: collision with root package name */
    private static final int f10387b0 = Color.parseColor("#1A1A1A");

    /* renamed from: c0, reason: collision with root package name */
    private static final float f10388c0 = SystemProperties.getInt("persist.flexible.shadows.spotAlpha", 22) / 100.0f;

    /* renamed from: d0, reason: collision with root package name */
    private static final float f10389d0 = SystemProperties.getInt("persist.flexible.shadows.spotAlpha_unFocus", 11) / 100.0f;

    /* renamed from: A, reason: collision with root package name */
    private float f10390A;

    /* renamed from: B, reason: collision with root package name */
    private int f10391B;

    /* renamed from: C, reason: collision with root package name */
    private int f10392C;

    /* renamed from: D, reason: collision with root package name */
    private int f10393D;

    /* renamed from: E, reason: collision with root package name */
    private int f10394E;

    /* renamed from: F, reason: collision with root package name */
    private int f10395F;

    /* renamed from: G, reason: collision with root package name */
    private int f10396G;

    /* renamed from: H, reason: collision with root package name */
    private int f10397H;

    /* renamed from: I, reason: collision with root package name */
    private int f10398I;

    /* renamed from: J, reason: collision with root package name */
    private float f10399J;

    /* renamed from: K, reason: collision with root package name */
    private ValueAnimator f10400K;

    /* renamed from: L, reason: collision with root package name */
    private ValueAnimator f10401L;

    /* renamed from: M, reason: collision with root package name */
    private ValueAnimator f10402M;

    /* renamed from: N, reason: collision with root package name */
    private ValueAnimator f10403N;

    /* renamed from: O, reason: collision with root package name */
    private ArrayList f10404O;

    /* renamed from: P, reason: collision with root package name */
    private WindowManager f10405P;

    /* renamed from: Q, reason: collision with root package name */
    private C0601d f10406Q;

    /* renamed from: R, reason: collision with root package name */
    private C0601d f10407R;

    /* renamed from: S, reason: collision with root package name */
    private Y.h f10408S;

    /* renamed from: T, reason: collision with root package name */
    private Y.h f10409T;

    /* renamed from: U, reason: collision with root package name */
    private final PathInterpolator f10410U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f10411V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f10412W;

    /* renamed from: X, reason: collision with root package name */
    private Boolean f10413X;

    /* renamed from: Y, reason: collision with root package name */
    private Boolean f10414Y;

    /* renamed from: Z, reason: collision with root package name */
    private List f10415Z;

    /* renamed from: a, reason: collision with root package name */
    public Boolean f10416a;

    /* renamed from: a0, reason: collision with root package name */
    private AtomicBoolean f10417a0;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f10418b;

    /* renamed from: c, reason: collision with root package name */
    private Context f10419c;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceSession f10420d;

    /* renamed from: e, reason: collision with root package name */
    private ContainerView f10421e;

    /* renamed from: f, reason: collision with root package name */
    private EmbeddedViewDecor f10422f;

    /* renamed from: g, reason: collision with root package name */
    private SurfaceControl f10423g;

    /* renamed from: h, reason: collision with root package name */
    private SurfaceControl f10424h;

    /* renamed from: i, reason: collision with root package name */
    private SurfaceControl f10425i;

    /* renamed from: j, reason: collision with root package name */
    private float f10426j;

    /* renamed from: k, reason: collision with root package name */
    private SurfaceControl f10427k;

    /* renamed from: l, reason: collision with root package name */
    private SurfaceControl f10428l;

    /* renamed from: m, reason: collision with root package name */
    private SurfaceControl f10429m;

    /* renamed from: n, reason: collision with root package name */
    private SurfaceControl f10430n;

    /* renamed from: o, reason: collision with root package name */
    private SurfaceControl f10431o;

    /* renamed from: p, reason: collision with root package name */
    private SurfaceControl f10432p;

    /* renamed from: q, reason: collision with root package name */
    private SurfaceControl f10433q;

    /* renamed from: r, reason: collision with root package name */
    private SurfaceControl f10434r;

    /* renamed from: s, reason: collision with root package name */
    private SurfaceControl f10435s;

    /* renamed from: t, reason: collision with root package name */
    private SurfaceControl.Transaction f10436t;

    /* renamed from: u, reason: collision with root package name */
    private SurfaceControl.Transaction f10437u;

    /* renamed from: v, reason: collision with root package name */
    private Handler f10438v;

    /* renamed from: w, reason: collision with root package name */
    private Rect f10439w;

    /* renamed from: x, reason: collision with root package name */
    private Rect f10440x;

    /* renamed from: y, reason: collision with root package name */
    private Rect f10441y;

    /* renamed from: z, reason: collision with root package name */
    private float f10442z;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                I.this.y0(message.arg1, message.arg2);
                return;
            }
            if (i3 == 1) {
                I.this.f10421e.setIsSwitchToZoomAnim(true);
                I.this.x0(message.arg1, message.arg2);
            } else if (i3 == 2) {
                I.this.z0(message.arg1);
            } else {
                if (i3 != 3) {
                    return;
                }
                I.this.c0("Animation Timeout");
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f10444e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f10445f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f10446g;

        b(List list, int i3, int i4) {
            this.f10444e = list;
            this.f10445f = i3;
            this.f10446g = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            I i3 = I.this;
            i3.f10413X = Boolean.valueOf(i3.k0(this.f10444e, this.f10445f, this.f10446g));
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = I.this.f10404O.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a(floatValue);
            }
            I.this.f10436t.apply();
        }
    }

    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10449a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10450b;

        d(int i3, int i4) {
            this.f10449a = i3;
            this.f10450b = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("CanvasSwitchToZoomAnimationManager", "dim animation cancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("CanvasSwitchToZoomAnimationManager", "dim animation end");
            I.this.f10436t.setAlpha(I.this.f10424h, 1.0f);
            Message obtainMessage = I.this.f10438v.obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = this.f10449a;
            obtainMessage.arg2 = this.f10450b;
            I.this.f10438v.sendMessageDelayed(obtainMessage, 300L);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            B1.l.t1(I.this.f10423g, 20109, true);
            I.this.f10436t.setAlpha(I.this.f10424h, 0.0f);
            Log.d("CanvasSwitchToZoomAnimationManager", "dim animation start");
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = I.this.f10404O.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                if (!jVar.f10469j) {
                    jVar.d(floatValue);
                }
                jVar.c(floatValue);
            }
            I.this.f10436t.apply();
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = I.this.f10404O.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j jVar = (j) it.next();
                if (jVar.f10469j) {
                    jVar.d(floatValue);
                    break;
                }
            }
            I.this.f10436t.apply();
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10454a;

        g(int i3) {
            this.f10454a = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            I.this.s0();
            if (I.this.f10438v.hasMessages(3)) {
                I.this.f10438v.removeMessages(3);
            }
            Log.d("CanvasSwitchToZoomAnimationManager", "Mask animation cancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            EmbeddedViewDecor r02;
            B1.l.t1(I.this.f10423g, 20109, false);
            Iterator it = I.this.f10404O.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j jVar = (j) it.next();
                if (!jVar.f10469j && (r02 = I.this.f10421e.r0(-1, jVar.f10470k)) != null) {
                    r02.g0(0L);
                    r02.setControlBarVisibility(0);
                }
            }
            if (!I.this.f10417a0.get()) {
                for (EmbeddedViewDecor embeddedViewDecor : I.this.f10421e.getChildEmbeddedViewList()) {
                    embeddedViewDecor.setControlBarVisibility(0);
                    android.view.SurfaceControl f02 = I.this.f0(embeddedViewDecor.getFlexibleTaskView());
                    if (I.this.p0(f02)) {
                        I.this.f10417a0.set(true);
                        I.this.f10436t.setAlpha(f02, 1.0f);
                    }
                }
                if (I.this.f10417a0.get()) {
                    I.this.f10415Z.clear();
                }
            }
            I i3 = I.this;
            if (i3.p0(i3.f10425i)) {
                I.this.f10436t.show(I.this.f10425i);
            }
            I i4 = I.this;
            if (i4.p0(i4.f10435s)) {
                I.this.f10436t.setAlpha(I.this.f10435s, 1.0f);
            }
            if (!I.this.f10411V) {
                Log.d("CanvasSwitchToZoomAnimationManager", "Mask animation end switchToZoom.");
                I i5 = I.this;
                i5.B0(i5.f10406Q.s(), I.this.f10439w, I.this.f10442z);
            }
            Message obtainMessage = I.this.f10438v.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = this.f10454a;
            I.this.f10438v.sendMessageDelayed(obtainMessage, I.this.f10411V ? 0L : 300L);
            I.this.f10414Y = Boolean.TRUE;
            if (!I.this.f10417a0.get()) {
                I.this.t0();
            }
            I.this.f10417a0.set(false);
            Log.d("CanvasSwitchToZoomAnimationManager", "Mask animation end");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("CanvasSwitchToZoomAnimationManager", "Mask animation start");
            I i3 = I.this;
            if (i3.p0(i3.f10435s)) {
                I.this.f10436t.setAlpha(I.this.f10435s, 0.0f);
            }
            I i4 = I.this;
            if (i4.p0(i4.f10425i)) {
                I.this.f10436t.setAlpha(I.this.f10425i, 0.0f);
            }
            if (I.this.f10411V) {
                Log.d("CanvasSwitchToZoomAnimationManager", "Mask animation start switchToZoom.");
                I i5 = I.this;
                i5.B0(i5.f10406Q.s(), I.this.f10439w, I.this.f10442z);
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("animatingSwitchToZoom", true);
            bundle.putInt("androidx.flexible.canvasToZoomTaskId", I.this.f10406Q.s());
            B1.l.f(bundle);
            if (this.f10454a == 2) {
                I i6 = I.this;
                if (i6.p0(i6.f10430n)) {
                    I.this.f10436t.setAlpha(I.this.f10430n, 0.0f).apply();
                }
                I.this.A0();
            }
            if (this.f10454a == 3) {
                I.this.f10421e.b2();
                I.this.f10421e.getContainerController().B(I.this.f10406Q);
                I.this.f10421e.getAdapter().H(0);
            }
            for (EmbeddedViewDecor embeddedViewDecor : I.this.f10421e.getChildEmbeddedViewList()) {
                embeddedViewDecor.setControlBarVisibility(4);
                android.view.SurfaceControl f02 = I.this.f0(embeddedViewDecor.getFlexibleTaskView());
                if (I.this.p0(f02)) {
                    I.this.f10436t.setAlpha(f02, 0.0f);
                    if (!f02.equals(I.this.f10425i)) {
                        I.this.f10415Z.add(f02);
                    }
                }
            }
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Iterator it = I.this.f10404O.iterator();
            while (it.hasNext()) {
                ((j) it.next()).f(floatValue);
            }
            I.this.f10436t.apply();
        }
    }

    class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ContainerActivity f10458b;

        i(int i3, ContainerActivity containerActivity) {
            this.f10457a = i3;
            this.f10458b = containerActivity;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            I.this.s0();
            Log.d("CanvasSwitchToZoomAnimationManager", "HideAnimation cancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            I.this.s0();
            if (this.f10457a == 2) {
                I.this.e0(this.f10458b);
                B1.h.a(I.this.f10419c).e("menu_to_zoom");
                B1.l.p1(I.this.f10407R.s());
                if (this.f10458b.t0() == 5 || this.f10458b.t0() == 6) {
                    this.f10458b.C1();
                } else {
                    this.f10458b.L1(true);
                }
            }
            if (I.this.f10438v.hasMessages(3)) {
                I.this.f10438v.removeMessages(3);
            }
            Log.d("CanvasSwitchToZoomAnimationManager", "HideAnimation end");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f10457a == 3) {
                try {
                    ActivityTaskManager.getService().setFocusedTask(I.this.f10406Q.s());
                    Log.d("CanvasSwitchToZoomAnimationManager", "hideAnimation start, set focus to zoom task, taskId : " + I.this.f10406Q.s());
                } catch (Exception unused) {
                    Log.e("CanvasSwitchToZoomAnimationManager", "set focus to zoom task failed");
                }
                B1.h.a(I.this.f10419c).d("menu_to_zoom", I.this.f10421e);
            }
            I i3 = I.this;
            if (i3.p0(i3.f10424h)) {
                I.this.f10436t.setAlpha(I.this.f10424h, 0.0f);
            }
            Log.d("CanvasSwitchToZoomAnimationManager", "HideAnimation start");
        }
    }

    private class j {

        /* renamed from: a, reason: collision with root package name */
        android.view.SurfaceControl f10460a;

        /* renamed from: b, reason: collision with root package name */
        android.view.SurfaceControl f10461b;

        /* renamed from: c, reason: collision with root package name */
        android.view.SurfaceControl f10462c;

        /* renamed from: d, reason: collision with root package name */
        android.view.SurfaceControl f10463d;

        /* renamed from: e, reason: collision with root package name */
        android.view.SurfaceControl f10464e;

        /* renamed from: f, reason: collision with root package name */
        FlexibleTaskView f10465f;

        /* renamed from: g, reason: collision with root package name */
        Rect f10466g = new Rect();

        /* renamed from: h, reason: collision with root package name */
        Rect f10467h = new Rect();

        /* renamed from: i, reason: collision with root package name */
        Rect f10468i = new Rect(0, 0, OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT);

        /* renamed from: j, reason: collision with root package name */
        boolean f10469j;

        /* renamed from: k, reason: collision with root package name */
        C0601d f10470k;

        /* renamed from: l, reason: collision with root package name */
        float f10471l;

        public j(Rect rect, Rect rect2, FlexibleTaskView flexibleTaskView, C0601d c0601d, boolean z3) {
            this.f10471l = 1.0f;
            this.f10466g.set(rect);
            this.f10467h.set(rect2);
            this.f10465f = flexibleTaskView;
            this.f10470k = c0601d;
            this.f10469j = z3;
            if (z3) {
                this.f10471l = B1.l.R(flexibleTaskView);
                I.this.f10398I = this.f10470k.s();
            }
            Log.d("CanvasSwitchToZoomAnimationManager", "initAnimationSources for taskData" + this.f10470k + " mStartFrame: " + this.f10466g + " mTargetFrame: " + this.f10467h + " mInitBounds : " + this.f10468i + ", mTaskAlpha:" + this.f10471l);
            g();
        }

        private void g() {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            SurfaceControl.Transaction transaction2 = new SurfaceControl.Transaction(transaction);
            this.f10460a = B1.l.m(I.this.f10423g, "curWholeSurface", "initCurSurface", false, I.this.f10420d);
            this.f10461b = I.this.f0(this.f10465f);
            transaction.setLayer(this.f10460a, this.f10469j ? Integer.MAX_VALUE : 2147483646);
            Bitmap F02 = I.this.f10421e.F0(I.this.f10421e.getAdapter().getPosition(this.f10470k), this.f10468i);
            Bitmap createScaledBitmap = (F02 == null || (F02.getWidth() == this.f10468i.width() && F02.getHeight() == this.f10468i.height())) ? F02 : Bitmap.createScaledBitmap(F02, this.f10468i.width(), this.f10468i.height(), true);
            if (I.this.f10418b.booleanValue()) {
                android.view.SurfaceControl l3 = B1.l.l(this.f10460a, "dimForBackSurface", "initCurSurface", false, this.f10468i.width(), this.f10468i.height(), I.this.f10420d);
                this.f10462c = l3;
                B1.l.z(l3, transaction, B1.l.V(createScaledBitmap), this.f10468i.width(), this.f10468i.height(), I.this.f10392C, 0);
            } else {
                this.f10462c = B1.l.l(this.f10460a, "dimForBackSurface", "initCurSurface", false, I.this.f10393D, I.this.f10394E, I.this.f10420d);
            }
            this.f10463d = B1.l.l(this.f10462c, "snapShotSurface", "initCurSurface", false, this.f10468i.width(), this.f10468i.height(), I.this.f10420d);
            if (I.this.f10416a.booleanValue()) {
                B1.l.z(this.f10463d, transaction, B1.l.V(F02), this.f10468i.width(), this.f10468i.height(), I.this.f10392C, 0);
            } else {
                B1.l.z(this.f10463d, transaction, F02, this.f10468i.width(), this.f10468i.height(), I.this.f10392C, 0);
            }
            transaction.setLayer(this.f10463d, I.this.f10418b.booleanValue() ? 1 : -1).setScale(this.f10462c, this.f10466g.width() / this.f10468i.width(), this.f10466g.height() / this.f10468i.height());
            this.f10464e = B1.l.l(this.f10460a, "iconSurface", "initCurSurface", false, I.this.f10395F, I.this.f10396G, I.this.f10420d);
            B1.l.z(this.f10464e, transaction, B1.l.j0(I.this.f10419c, B1.l.q0(this.f10470k.k(), this.f10470k.v()), 64, 64), I.this.f10395F, I.this.f10396G, 0, 0);
            transaction.setLayer(this.f10464e, Preference.DEFAULT_ORDER);
            if (this.f10469j) {
                I.this.f10437u.setShadowParams(this.f10462c, 200.0f, 0.0f, 0.0f, I.f10388c0);
                transaction.setMetadata(this.f10462c, 200, 1);
                I.this.f10425i = this.f10461b;
                I.this.f10426j = this.f10471l;
                I.this.f10427k = this.f10460a;
                I.this.f10428l = this.f10462c;
                I.this.f10429m = this.f10464e;
                I.this.f10434r = this.f10463d;
                I.this.f10441y = this.f10468i;
            } else if (I.this.f10421e.getAdapter().getCount() == 2) {
                I.this.f10430n = this.f10461b;
                I.this.f10431o = this.f10460a;
                I.this.f10432p = this.f10462c;
                I.this.f10433q = this.f10464e;
            }
            SurfaceControl.Transaction crop = transaction.setCrop(this.f10460a, new Rect(0, 0, this.f10466g.width(), this.f10466g.height()));
            android.view.SurfaceControl surfaceControl = this.f10460a;
            Rect rect = this.f10466g;
            crop.setPosition(surfaceControl, rect.left, rect.top).setPosition(this.f10464e, ((int) (this.f10466g.width() - I.this.f10395F)) / 2, ((int) (this.f10466g.height() - I.this.f10396G)) / 2).setAlpha(this.f10460a, 1.0f).setAlpha(this.f10463d, 1.0f).setAlpha(this.f10464e, 0.0f);
            transaction2.setSmoothCornerRadius(this.f10460a, I.this.f10399J, 2.0f);
            transaction.apply();
        }

        public void a(float f3) {
            I.this.f10436t.setAlpha(this.f10460a, f3);
        }

        protected void b(float f3) {
            if (!this.f10469j) {
                I.this.f10436t.setAlpha(this.f10464e, f3);
            } else {
                I.this.f10436t.setAlpha(this.f10464e, Math.min(1.0f, f3 * 1.6f));
            }
        }

        public void c(float f3) {
            if (!I.this.f10416a.booleanValue() && !I.this.f10418b.booleanValue()) {
                I.this.f10436t.setBackgroundBlurRadius(this.f10462c, (int) (I.this.f10397H * f3));
            } else if (I.this.f10418b.booleanValue()) {
                I.this.f10436t.setAlpha(this.f10463d, Math.max(0.0f, 1.0f - ((800.0f * f3) / 450.0f)));
            }
            b(f3);
            e(f3);
        }

        public void d(float f3) {
            Rect rect = new Rect();
            rect.set((int) B1.l.p(f3, this.f10467h.left, this.f10466g.left), (int) B1.l.p(f3, this.f10467h.top, this.f10466g.top), (int) B1.l.p(f3, this.f10467h.right, this.f10466g.right), (int) B1.l.p(f3, this.f10467h.bottom, this.f10466g.bottom));
            if (rect.isValid()) {
                I.this.f10436t.setScale(this.f10462c, rect.width() / this.f10468i.width(), rect.height() / this.f10468i.height()).setCrop(this.f10460a, new Rect(0, 0, rect.width(), rect.height())).setPosition(this.f10460a, rect.left, rect.top).setPosition(this.f10464e, ((int) (rect.width() - I.this.f10395F)) / 2, ((int) (rect.height() - I.this.f10396G)) / 2);
            }
        }

        protected void e(float f3) {
            if (this.f10469j) {
                B1.l.x1(I.this.f10436t, this.f10460a, (int) B1.l.p(f3, I.this.f10390A * I.this.f10442z, I.this.f10399J));
            }
        }

        public void f(float f3) {
            float p3 = B1.l.p(f3, 0.0f, 1.0f);
            I.this.f10436t.setAlpha(this.f10462c, p3).setAlpha(this.f10460a, p3);
        }

        public void h() {
            Log.d("CanvasSwitchToZoomAnimationManager", "reset for : " + this.f10470k);
            android.view.SurfaceControl surfaceControl = this.f10462c;
            if (surfaceControl != null) {
                if (surfaceControl.isValid()) {
                    I.this.f10436t.remove(this.f10462c);
                }
                this.f10462c = null;
            }
            android.view.SurfaceControl surfaceControl2 = this.f10463d;
            if (surfaceControl2 != null) {
                if (surfaceControl2.isValid()) {
                    I.this.f10436t.remove(this.f10463d);
                }
                this.f10463d = null;
            }
            android.view.SurfaceControl surfaceControl3 = this.f10464e;
            if (surfaceControl3 != null) {
                if (surfaceControl3.isValid()) {
                    I.this.f10436t.remove(this.f10464e);
                }
                this.f10464e = null;
            }
            android.view.SurfaceControl surfaceControl4 = this.f10460a;
            if (surfaceControl4 != null) {
                if (surfaceControl4.isValid()) {
                    I.this.f10436t.remove(this.f10460a);
                }
                this.f10460a = null;
            }
        }
    }

    public I(Context context, ContainerView containerView, EmbeddedViewDecor embeddedViewDecor) {
        this.f10416a = Boolean.valueOf(SystemProperties.getInt("persist.sys.snapshotblur", 2) == 1);
        this.f10418b = Boolean.valueOf(SystemProperties.getInt("persist.sys.snapshotblur", 2) == 2);
        this.f10426j = 1.0f;
        this.f10408S = new Y.h(0.800000011920929d, 0.2199999988079071d);
        this.f10409T = new Y.h(0.6000000238418579d, 0.0d);
        this.f10410U = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f10411V = false;
        this.f10412W = false;
        this.f10414Y = Boolean.FALSE;
        this.f10415Z = new ArrayList();
        this.f10417a0 = new AtomicBoolean(false);
        this.f10419c = context;
        this.f10421e = containerView;
        this.f10420d = new SurfaceSession();
        this.f10436t = new SurfaceControl.Transaction();
        this.f10437u = new SurfaceControl.Transaction(this.f10436t);
        this.f10397H = B1.s.b(100.0f, context.getResources());
        this.f10422f = embeddedViewDecor;
        this.f10405P = (WindowManager) this.f10419c.getSystemService("window");
        this.f10404O = new ArrayList();
        this.f10438v = new a(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        ContainerActivity O12 = B1.l.O1(this.f10419c);
        if (O12 == null) {
            return;
        }
        O12.Q1();
        C0601d x02 = O12.x0(0);
        if (x02 == null || this.f10406Q != x02) {
            O12.U1(0, true);
        } else {
            O12.U1(1, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i3, Rect rect, float f3) {
        if (p0(this.f10425i)) {
            this.f10436t.setAlpha(this.f10425i, 0.0f);
        }
        this.f10436t.apply();
        boolean Q02 = B1.l.O1(this.f10419c).Q0();
        if (Q02 != this.f10412W) {
            Intent cloneFilter = this.f10406Q.f().cloneFilter();
            cloneFilter.putExtra("androidx.activity.LaunchScenario", 1);
            cloneFilter.putExtra("androidx.activity.LaunchEmbeddedTaskId", this.f10406Q.s());
            if (this.f10406Q.t() != null && !TextUtils.isEmpty(this.f10406Q.t().getPackageName())) {
                B1.l.z1(cloneFilter, this.f10406Q.t());
            }
            Rect rect2 = (Rect) B1.l.o(cloneFilter, -2, 0).getParcelable("androidx.flexible.LaunchBounds", Rect.class);
            Log.d("CanvasSwitchToZoomAnimationManager", " switchToZoom update launch bounds for taskId: " + i3 + ", oldFolded: " + this.f10412W + ", newFolded: " + Q02 + ", oldRect: " + rect + ", newRect: " + rect2);
            rect.set(rect2);
            this.f10412W = Q02;
        }
        Log.d("CanvasSwitchToZoomAnimationManager", "switchToZoom taskId: " + i3 + ", launchBounds: " + rect);
        B1.l.g(i3, rect, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void q0(String str) {
        Log.d("CanvasSwitchToZoomAnimationManager", "cancelAnimationInner, reason: " + str);
        if (!this.f10417a0.get()) {
            t0();
            this.f10417a0.set(true);
        }
        ValueAnimator valueAnimator = this.f10401L;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            Log.d("CanvasSwitchToZoomAnimationManager", "cancelAnimationInner, cancel mMotionAnimator");
            this.f10401L.cancel();
        }
        ValueAnimator valueAnimator2 = this.f10402M;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            Log.d("CanvasSwitchToZoomAnimationManager", "cancelAnimationInner, cancel mNonMotionAnimator");
            this.f10402M.cancel();
        }
        ValueAnimator valueAnimator3 = this.f10403N;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            Log.d("CanvasSwitchToZoomAnimationManager", "cancelAnimationInner, cancel mHideAnimator");
            this.f10403N.cancel();
        }
        if (this.f10438v.hasMessages(3)) {
            this.f10438v.removeMessages(3);
        }
        u0();
        s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0(Activity activity) {
        activity.finish();
        Log.d("CanvasSwitchToZoomAnimationManager", "exit canvas activity finish");
        activity.overridePendingTransition(0, AbstractC0587a.f13360b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.view.SurfaceControl f0(FlexibleTaskView flexibleTaskView) {
        try {
            Field declaredField = flexibleTaskView.getClass().getDeclaredField("mTaskLeash");
            declaredField.setAccessible(true);
            return (android.view.SurfaceControl) declaredField.get(flexibleTaskView);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private Rect h0(EmbeddedViewDecor embeddedViewDecor) {
        Rect rect = new Rect();
        embeddedViewDecor.getBoundsOnScreen(rect);
        return rect;
    }

    private List i0(int i3, int i4) {
        ArrayList arrayList = new ArrayList();
        if (i4 == 2) {
            Rect h02 = h0(this.f10421e.q0(1 - i3));
            if (!h02.isValid()) {
                Log.w("CanvasSwitchToZoomAnimationManager", "initNoMotionAnimSource two-split invalid startRect : " + h02);
                return arrayList;
            }
            arrayList.add(h02);
        } else if (i4 == 3) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (i5 == i3) {
                    arrayList.add(new Rect());
                } else {
                    Rect h03 = h0(this.f10421e.q0(i5));
                    if (!h03.isValid()) {
                        arrayList.clear();
                        Log.w("CanvasSwitchToZoomAnimationManager", "initNoMotionAnimSource three-split invalid startRect : " + h03);
                        return arrayList;
                    }
                    arrayList.add(h03);
                }
            }
        }
        return arrayList;
    }

    private boolean j0(int i3, int i4) {
        m0(i3);
        this.f10413X = Boolean.FALSE;
        List i02 = i0(i3, i4);
        if (i02.isEmpty()) {
            Log.e("CanvasSwitchToZoomAnimationManager", "initNoMotionAnimSource invalid start rect");
            return false;
        }
        Thread thread = new Thread(new b(i02, i3, i4));
        thread.start();
        boolean l02 = l0(i3);
        try {
            thread.join();
            if (l02 && this.f10413X.booleanValue()) {
                if (!this.f10404O.isEmpty()) {
                    return true;
                }
                Log.e("CanvasSwitchToZoomAnimationManager", "initAnimationSources failed.. mAnimationSources is empty.");
                return false;
            }
            Log.e("CanvasSwitchToZoomAnimationManager", "init dim failed..  initToZoomSuccess: " + l02 + " mInitNoMotionSuccess: " + this.f10413X);
            return false;
        } catch (InterruptedException e3) {
            Log.e("CanvasSwitchToZoomAnimationManager", "initNoMotionAnimSource thread execute failed.. " + e3);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k0(List list, int i3, int i4) {
        if (i4 == 2) {
            int i5 = 1 - i3;
            this.f10407R = this.f10421e.getAdapter().getItem(i5);
            j jVar = new j((Rect) list.get(0), new Rect(0, 0, this.f10393D, this.f10394E), this.f10421e.q0(i5).getFlexibleTaskView(), this.f10421e.getAdapter().getItem(i5), false);
            synchronized (this.f10404O) {
                this.f10404O.add(jVar);
            }
            return true;
        }
        if (i4 != 3) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < i4; i6++) {
            if (i6 != i3) {
                arrayList.add(this.f10421e.getContainerController().l(i6));
            }
        }
        this.f10421e.e3(this.f10419c, arrayList, 0);
        List c12 = B1.l.c1(this.f10419c, arrayList, 0, false);
        if (B1.s.J(this.f10419c) && B1.l.u0()) {
            Iterator it = c12.iterator();
            while (it.hasNext()) {
                ((Rect) it.next()).offset(0, B1.l.O1(this.f10419c).G0());
            }
        }
        c12.add(i3, new Rect());
        for (int i7 = 0; i7 < i4; i7++) {
            if (i7 != i3) {
                j jVar2 = new j((Rect) list.get(i7), new Rect((Rect) c12.get(i7)), this.f10421e.q0(i7).getFlexibleTaskView(), this.f10421e.getAdapter().getItem(i7), false);
                synchronized (this.f10404O) {
                    this.f10404O.add(jVar2);
                }
            }
        }
        return true;
    }

    private boolean l0(int i3) {
        C0601d item = this.f10421e.getAdapter().getItem(i3);
        this.f10406Q = item;
        if (item == null || item.s() <= 0) {
            return false;
        }
        this.f10412W = B1.l.O1(this.f10419c).Q0();
        Intent cloneFilter = this.f10406Q.f().cloneFilter();
        cloneFilter.putExtra("androidx.activity.LaunchScenario", 1);
        cloneFilter.putExtra("androidx.activity.LaunchEmbeddedTaskId", this.f10406Q.s());
        if (this.f10406Q.t() != null && !TextUtils.isEmpty(this.f10406Q.t().getPackageName())) {
            B1.l.z1(cloneFilter, this.f10406Q.t());
        }
        Bundle o3 = B1.l.o(cloneFilter, -2, 0);
        this.f10439w = (Rect) o3.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
        this.f10442z = o3.getFloat("androidx.activity.LaunchScale", 1.0f);
        this.f10390A = o3.getInt("androidx.activity.LaunchCornerRadius", 0);
        Rect rect = this.f10439w;
        int i4 = rect.left;
        this.f10440x = new Rect(i4, rect.top, ((int) (rect.width() * this.f10442z)) + i4, this.f10439w.top + ((int) (r5.height() * this.f10442z)));
        EmbeddedViewDecor q02 = this.f10421e.q0(i3);
        j jVar = new j(h0(q02), this.f10440x, q02.getFlexibleTaskView(), this.f10406Q, true);
        synchronized (this.f10404O) {
            this.f10404O.add(jVar);
        }
        return true;
    }

    private void m0(int i3) {
        this.f10394E = this.f10405P.getMaximumWindowMetrics().getBounds().height();
        this.f10393D = this.f10405P.getMaximumWindowMetrics().getBounds().width();
        this.f10435s = B1.l.L(this.f10436t, this.f10422f.getFlexibleTaskView());
        int i4 = this.f10419c.getResources().getConfiguration().uiMode;
        this.f10391B = i4;
        this.f10392C = B1.l.I(i4);
        int i5 = (int) (this.f10419c.getResources().getDisplayMetrics().density * 64.0f);
        this.f10396G = i5;
        this.f10395F = i5;
        android.view.SurfaceControl m3 = B1.l.m(this.f10435s, "wholeSurface", "initWholeSurfaces", false, this.f10420d);
        this.f10423g = m3;
        android.view.SurfaceControl l3 = B1.l.l(m3, "wholeBackSurface", "initWholeSurfaces", false, this.f10393D, this.f10394E, this.f10420d);
        this.f10424h = l3;
        B1.l.z(l3, this.f10436t, null, this.f10393D, this.f10394E, !B1.l.u() ? f10387b0 : 16777215, 0);
        this.f10436t.setLayer(this.f10423g, Preference.DEFAULT_ORDER).setLayer(this.f10424h, 2147483645);
        this.f10436t.setMetadata(this.f10423g, 101, 1);
        this.f10399J = this.f10419c.getResources().getDisplayMetrics().density * 12.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p0(android.view.SurfaceControl surfaceControl) {
        return surfaceControl != null && surfaceControl.isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0() {
        B1.l.h1(this.f10398I, 2205, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        ContainerView containerView = this.f10421e;
        containerView.f10755S = false;
        containerView.setIsSwitchToZoomAnim(false);
        Log.d("CanvasSwitchToZoomAnimationManager", "resetAll caller : " + Debug.getCallers(5));
        ArrayList arrayList = this.f10404O;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).h();
            }
            this.f10404O.clear();
        }
        android.view.SurfaceControl surfaceControl = this.f10424h;
        if (surfaceControl != null) {
            if (surfaceControl.isValid()) {
                this.f10436t.remove(this.f10424h);
            }
            this.f10424h = null;
        }
        android.view.SurfaceControl surfaceControl2 = this.f10423g;
        if (surfaceControl2 != null) {
            if (surfaceControl2.isValid()) {
                this.f10436t.remove(this.f10423g);
            }
            this.f10423g = null;
        }
        this.f10436t.apply();
        this.f10421e.q2(null);
        this.f10425i = null;
        this.f10427k = null;
        this.f10428l = null;
        this.f10429m = null;
        this.f10434r = null;
        this.f10441y = null;
        this.f10430n = null;
        this.f10431o = null;
        this.f10432p = null;
        this.f10433q = null;
        this.f10414Y = Boolean.FALSE;
        this.f10412W = false;
    }

    private void u0() {
        if (p0(this.f10425i)) {
            this.f10436t.show(this.f10425i).setAlpha(this.f10425i, 1.0f);
        }
        if (p0(this.f10430n)) {
            this.f10436t.show(this.f10430n).setAlpha(this.f10430n, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(int i3, int i4) {
        if (this.f10405P != null && j0(i3, i4)) {
            this.f10402M = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f10401L = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f10402M.addUpdateListener(new e());
            this.f10401L.addUpdateListener(new f());
            this.f10401L.setDuration(800L);
            this.f10402M.setDuration(800L);
            this.f10401L.setInterpolator(this.f10408S);
            this.f10402M.setInterpolator(this.f10409T);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(this.f10401L, this.f10402M);
            animatorSet.addListener(new g(i4));
            animatorSet.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i3, int i4) {
        if (this.f10405P != null && j0(i3, i4)) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f10400K = ofFloat;
            ofFloat.addUpdateListener(new c());
            this.f10400K.setDuration(200L);
            this.f10400K.setInterpolator(this.f10410U);
            this.f10400K.addListener(new d(i3, i4));
            this.f10400K.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i3) {
        this.f10414Y = Boolean.FALSE;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f10403N = ofFloat;
        ofFloat.addUpdateListener(new h());
        android.view.SurfaceControl surfaceControl = this.f10430n;
        if (surfaceControl != null && surfaceControl.isValid()) {
            this.f10436t.reparent(this.f10431o, this.f10430n).setAlpha(this.f10430n, 1.0f).setCrop(this.f10432p, new Rect(0, 0, this.f10393D, this.f10394E)).setPosition(this.f10432p, 0.0f, 0.0f).setPosition(this.f10433q, (this.f10393D - this.f10395F) / 2.0f, (this.f10394E - this.f10396G) / 2.0f);
        }
        android.view.SurfaceControl surfaceControl2 = this.f10425i;
        if (surfaceControl2 != null && surfaceControl2.isValid()) {
            SurfaceControl.Transaction position = this.f10436t.setMetadata(this.f10427k, 101, 1).reparent(this.f10427k, this.f10425i).setScale(this.f10428l, this.f10440x.width() / (this.f10441y.width() * this.f10442z), this.f10440x.height() / (this.f10441y.height() * this.f10442z)).setAlpha(this.f10425i, this.f10426j).setCrop(this.f10427k, new Rect(0, 0, this.f10439w.width(), this.f10439w.height())).setPosition(this.f10427k, 0.0f, 0.0f);
            android.view.SurfaceControl surfaceControl3 = this.f10429m;
            float f3 = this.f10442z;
            position.setScale(surfaceControl3, 1.0f / f3, 1.0f / f3).setPosition(this.f10429m, ((this.f10439w.width() * 1.0f) - (this.f10395F / this.f10442z)) / 2.0f, ((this.f10439w.height() * 1.0f) - (this.f10396G / this.f10442z)) / 2.0f).setShadowRadius(this.f10428l, 0.0f);
            this.f10437u.setSmoothCornerRadius(this.f10428l, 0.0f, 2.0f).setSmoothCornerRadius(this.f10427k, 0.0f, 2.0f).setShadowParams(this.f10428l, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        this.f10436t.apply();
        C0305a.a().b(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.H
            @Override // java.lang.Runnable
            public final void run() {
                I.this.r0();
            }
        });
        ContainerActivity O12 = B1.l.O1(this.f10419c);
        this.f10403N.setDuration(450L);
        this.f10403N.setInterpolator(this.f10409T);
        this.f10403N.addListener(new i(i3, O12));
        this.f10403N.start();
    }

    public void c0(final String str) {
        if (Thread.currentThread() == this.f10438v.getLooper().getThread()) {
            q0(str);
        } else {
            this.f10438v.postAtFrontOfQueue(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.G
                @Override // java.lang.Runnable
                public final void run() {
                    I.this.q0(str);
                }
            });
        }
    }

    public Handler g0() {
        return this.f10438v;
    }

    public boolean n0() {
        return this.f10411V;
    }

    public boolean o0() {
        return this.f10414Y.booleanValue();
    }

    public void t0() {
        List list = this.f10415Z;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (android.view.SurfaceControl surfaceControl : this.f10415Z) {
            if (p0(surfaceControl)) {
                this.f10436t.setAlpha(surfaceControl, 1.0f);
            }
        }
        this.f10415Z.clear();
    }

    public void v0(boolean z3) {
        this.f10411V = z3;
    }

    public void w0() {
        this.f10421e.q2(this.f10422f);
    }
}
