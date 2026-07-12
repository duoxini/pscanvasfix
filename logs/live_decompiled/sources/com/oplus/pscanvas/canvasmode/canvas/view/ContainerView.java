package com.oplus.pscanvas.canvasmode.canvas.view;

import B.b;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.window.ScreenCapture;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.launcher.graphic.GaussianBlur;
import com.oplus.pscanvas.canvasmode.canvas.A0;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import com.oplus.pscanvas.canvasmode.canvas.C0327t;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.mask.CanvasMaskListView;
import com.oplus.pscanvas.canvasmode.canvas.r0;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.view.inputmethod.OplusInputMethodManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Predicate;
import t1.AbstractC0587a;
import t1.AbstractC0589c;
import u1.C0600c;
import u1.C0601d;
import v1.C0609a;
import w1.C0622f;
import y1.C0644a;

/* loaded from: classes.dex */
public class ContainerView extends ListView {

    /* renamed from: R0, reason: collision with root package name */
    private static final String f10713R0 = "ContainerView";

    /* renamed from: S0, reason: collision with root package name */
    private static long f10714S0 = 0;

    /* renamed from: T0, reason: collision with root package name */
    public static float f10715T0 = 0.75f;

    /* renamed from: U0, reason: collision with root package name */
    public static float f10716U0 = 0.25f;

    /* renamed from: V0, reason: collision with root package name */
    public static final float f10717V0 = s0(0.0f);

    /* renamed from: W0, reason: collision with root package name */
    public static final float f10718W0 = C0(0.15f);

    /* renamed from: X0, reason: collision with root package name */
    private static Boolean f10719X0 = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: A, reason: collision with root package name */
    String f10720A;

    /* renamed from: A0, reason: collision with root package name */
    private float f10721A0;

    /* renamed from: B, reason: collision with root package name */
    private r0 f10722B;

    /* renamed from: B0, reason: collision with root package name */
    private float f10723B0;

    /* renamed from: C, reason: collision with root package name */
    private Rect f10724C;

    /* renamed from: C0, reason: collision with root package name */
    private boolean f10725C0;

    /* renamed from: D, reason: collision with root package name */
    private int f10726D;

    /* renamed from: D0, reason: collision with root package name */
    private boolean f10727D0;

    /* renamed from: E, reason: collision with root package name */
    private boolean f10728E;

    /* renamed from: E0, reason: collision with root package name */
    private Bitmap f10729E0;

    /* renamed from: F, reason: collision with root package name */
    private boolean f10730F;

    /* renamed from: F0, reason: collision with root package name */
    private BitmapDrawable f10731F0;

    /* renamed from: G, reason: collision with root package name */
    public E f10732G;

    /* renamed from: G0, reason: collision with root package name */
    private BitmapDrawable f10733G0;

    /* renamed from: H, reason: collision with root package name */
    private int f10734H;

    /* renamed from: H0, reason: collision with root package name */
    private BitmapDrawable f10735H0;

    /* renamed from: I, reason: collision with root package name */
    private A0 f10736I;

    /* renamed from: I0, reason: collision with root package name */
    private BitmapDrawable f10737I0;

    /* renamed from: J, reason: collision with root package name */
    private y1.n f10738J;

    /* renamed from: J0, reason: collision with root package name */
    private B.e f10739J0;

    /* renamed from: K, reason: collision with root package name */
    private C1.a f10740K;

    /* renamed from: K0, reason: collision with root package name */
    private C0609a f10741K0;

    /* renamed from: L, reason: collision with root package name */
    public boolean f10742L;

    /* renamed from: L0, reason: collision with root package name */
    private boolean f10743L0;

    /* renamed from: M, reason: collision with root package name */
    private boolean f10744M;

    /* renamed from: M0, reason: collision with root package name */
    private boolean f10745M0;

    /* renamed from: N, reason: collision with root package name */
    public boolean f10746N;

    /* renamed from: N0, reason: collision with root package name */
    private String f10747N0;

    /* renamed from: O, reason: collision with root package name */
    int f10748O;

    /* renamed from: O0, reason: collision with root package name */
    private boolean f10749O0;

    /* renamed from: P, reason: collision with root package name */
    public boolean f10750P;

    /* renamed from: P0, reason: collision with root package name */
    Callable f10751P0;

    /* renamed from: Q, reason: collision with root package name */
    private AnimatorSet f10752Q;

    /* renamed from: Q0, reason: collision with root package name */
    Callable f10753Q0;

    /* renamed from: R, reason: collision with root package name */
    private A1.b f10754R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f10755S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f10756T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f10757U;

    /* renamed from: V, reason: collision with root package name */
    private com.coui.appcompat.poplist.k f10758V;

    /* renamed from: W, reason: collision with root package name */
    private int f10759W;

    /* renamed from: a0, reason: collision with root package name */
    private CanvasMaskListView f10760a0;

    /* renamed from: b0, reason: collision with root package name */
    private EmbeddedViewDecor f10761b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f10762c0;

    /* renamed from: d0, reason: collision with root package name */
    private final int f10763d0;

    /* renamed from: e, reason: collision with root package name */
    private final PathInterpolator f10764e;

    /* renamed from: e0, reason: collision with root package name */
    private final float f10765e0;

    /* renamed from: f, reason: collision with root package name */
    private C0600c f10766f;

    /* renamed from: f0, reason: collision with root package name */
    private final float f10767f0;

    /* renamed from: g, reason: collision with root package name */
    private float[] f10768g;

    /* renamed from: g0, reason: collision with root package name */
    private final float f10769g0;

    /* renamed from: h, reason: collision with root package name */
    private int[] f10770h;

    /* renamed from: h0, reason: collision with root package name */
    private final float f10771h0;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10772i;

    /* renamed from: i0, reason: collision with root package name */
    private List f10773i0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10774j;

    /* renamed from: j0, reason: collision with root package name */
    private float f10775j0;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10776k;

    /* renamed from: k0, reason: collision with root package name */
    private AnimatorSet f10777k0;

    /* renamed from: l, reason: collision with root package name */
    private List f10778l;

    /* renamed from: l0, reason: collision with root package name */
    private float f10779l0;

    /* renamed from: m, reason: collision with root package name */
    private Rect f10780m;

    /* renamed from: m0, reason: collision with root package name */
    private float f10781m0;

    /* renamed from: n, reason: collision with root package name */
    private Rect f10782n;

    /* renamed from: n0, reason: collision with root package name */
    private float f10783n0;

    /* renamed from: o, reason: collision with root package name */
    private Rect f10784o;

    /* renamed from: o0, reason: collision with root package name */
    private float f10785o0;

    /* renamed from: p, reason: collision with root package name */
    private int f10786p;

    /* renamed from: p0, reason: collision with root package name */
    private float f10787p0;

    /* renamed from: q, reason: collision with root package name */
    private int f10788q;

    /* renamed from: q0, reason: collision with root package name */
    private float f10789q0;

    /* renamed from: r, reason: collision with root package name */
    private int f10790r;

    /* renamed from: r0, reason: collision with root package name */
    private float f10791r0;

    /* renamed from: s, reason: collision with root package name */
    private int f10792s;

    /* renamed from: s0, reason: collision with root package name */
    private float f10793s0;

    /* renamed from: t, reason: collision with root package name */
    private int f10794t;

    /* renamed from: t0, reason: collision with root package name */
    private int f10795t0;

    /* renamed from: u, reason: collision with root package name */
    String f10796u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f10797u0;

    /* renamed from: v, reason: collision with root package name */
    String f10798v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f10799v0;

    /* renamed from: w, reason: collision with root package name */
    String f10800w;

    /* renamed from: w0, reason: collision with root package name */
    private int f10801w0;

    /* renamed from: x, reason: collision with root package name */
    String f10802x;

    /* renamed from: x0, reason: collision with root package name */
    private int f10803x0;

    /* renamed from: y, reason: collision with root package name */
    String f10804y;

    /* renamed from: y0, reason: collision with root package name */
    private int f10805y0;

    /* renamed from: z, reason: collision with root package name */
    String f10806z;

    /* renamed from: z0, reason: collision with root package name */
    private float f10807z0;

    class a implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10808e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f10809f;

        a(int i3, boolean z3) {
            this.f10808e = i3;
            this.f10809f = z3;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            ContainerView containerView = ContainerView.this;
            containerView.f10755S = false;
            if (containerView.f10754R != null) {
                ContainerView.this.f10754R.O();
            }
            if (this.f10808e >= 0) {
                B1.h.a(ContainerView.this.getContext()).d(this.f10809f ? "drag_enlarge" : "drag_narrow", ContainerView.this);
            }
            return p2.q.f12810a;
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EmbeddedViewDecor f10811a;

        b(ContainerView containerView, EmbeddedViewDecor embeddedViewDecor) {
            this.f10811a = embeddedViewDecor;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            EmbeddedViewDecor embeddedViewDecor = this.f10811a;
            embeddedViewDecor.setViewTranslationX(embeddedViewDecor.getTranslationX());
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EmbeddedViewDecor f10812a;

        c(ContainerView containerView, EmbeddedViewDecor embeddedViewDecor) {
            this.f10812a = embeddedViewDecor;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            EmbeddedViewDecor embeddedViewDecor = this.f10812a;
            embeddedViewDecor.setViewTranslationY(embeddedViewDecor.getTranslationY());
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EmbeddedViewDecor f10813a;

        d(ContainerView containerView, EmbeddedViewDecor embeddedViewDecor) {
            this.f10813a = embeddedViewDecor;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            EmbeddedViewDecor embeddedViewDecor = this.f10813a;
            embeddedViewDecor.setViewTranslationX(embeddedViewDecor.getTranslationX());
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EmbeddedViewDecor f10814a;

        e(ContainerView containerView, EmbeddedViewDecor embeddedViewDecor) {
            this.f10814a = embeddedViewDecor;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            EmbeddedViewDecor embeddedViewDecor = this.f10814a;
            embeddedViewDecor.setViewTranslationY(embeddedViewDecor.getTranslationY());
        }
    }

    class f implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10815e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f10816f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ C0601d f10817g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ContainerActivity f10818h;

        f(int i3, int i4, C0601d c0601d, ContainerActivity containerActivity) {
            this.f10815e = i3;
            this.f10816f = i4;
            this.f10817g = c0601d;
            this.f10818h = containerActivity;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Log.d(ContainerView.f10713R0, "taskToFullMaskShow finish");
            if (this.f10815e == 3) {
                ContainerView.this.K0((this.f10816f + 1) % 3);
                ContainerView.this.K0((this.f10816f + 2) % 3);
            }
            ContainerView.this.b2();
            C0601d c0601d = this.f10817g;
            ContainerView.this.C2(this.f10818h.u0(), -1, c0601d == null ? -1 : c0601d.s(), false, false);
            this.f10818h.W1(this.f10816f, this.f10815e != 2);
            this.f10818h.O1(true);
            if (this.f10815e == 2) {
                ContainerView.this.f10725C0 = true;
            }
            return p2.q.f12810a;
        }
    }

    class g implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10820e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ContainerActivity f10821f;

        g(int i3, ContainerActivity containerActivity) {
            this.f10820e = i3;
            this.f10821f = containerActivity;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Log.d(ContainerView.f10713R0, "taskToFullMaskFull finish ");
            ContainerView.this.f10742L = false;
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.activity.isInFullScreenAnimation", ContainerView.this.f10742L);
            bundle.putInt("androidx.task.skip_persist_snapshot", this.f10820e == 2 ? this.f10821f.getTaskId() : -1);
            B1.l.f(bundle);
            if (this.f10820e == 2) {
                this.f10821f.finish();
                this.f10821f.overridePendingTransition(0, AbstractC0587a.f13360b);
                this.f10821f.C1();
            } else {
                this.f10821f.finish();
                this.f10821f.overridePendingTransition(0, AbstractC0587a.f13360b);
            }
            return p2.q.f12810a;
        }
    }

    class h implements C2.a {
        h() {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Log.d(ContainerView.f10713R0, "taskToFullMaskHide finish");
            ContainerView.this.f10755S = false;
            return p2.q.f12810a;
        }
    }

    class i implements Callable {
        i() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            return B1.l.W(ContainerView.this.D0(0), 25);
        }
    }

    class j implements Callable {
        j() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Bitmap call() {
            return B1.l.W(ContainerView.this.D0(1), 25);
        }
    }

    class k implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f10826a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f10827b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float[] f10828c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float[] f10829d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ A1.b f10830e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f10831f;

        k(ViewGroup viewGroup, int i3, float[] fArr, float[] fArr2, A1.b bVar, boolean z3) {
            this.f10826a = viewGroup;
            this.f10827b = i3;
            this.f10828c = fArr;
            this.f10829d = fArr2;
            this.f10830e = bVar;
            this.f10831f = z3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ContainerView.this.f10750P = false;
            Log.e(ContainerView.f10713R0, "Animation cancel: ");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d(ContainerView.f10713R0, "onAnimationEnd " + this.f10826a);
            if (this.f10827b == 2) {
                B1.l.u1((ViewGroup) ContainerView.this.getParent(), 20109, false);
                ContainerView.this.f10766f.H(ContainerView.this.f10766f.h());
            }
            if (this.f10827b != 3) {
                ContainerView containerView = ContainerView.this;
                if (containerView.Q2(((ListView) containerView).mContext).A0() && ContainerView.this.W(this.f10828c, this.f10829d)) {
                    OplusInputMethodManager.getInstance().hideCurrentInputMethod();
                    Log.d(ContainerView.f10713R0, "startAnimation, hide InputMethod when new translation equals imeOffset");
                }
            }
            ContainerView containerView2 = ContainerView.this;
            containerView2.f10750P = false;
            if (this.f10827b != 4) {
                Iterator<EmbeddedViewDecor> it = containerView2.getChildEmbeddedViewList().iterator();
                while (it.hasNext()) {
                    it.next().d0();
                }
            }
            if (this.f10827b != 3) {
                ContainerView containerView3 = ContainerView.this;
                if (!containerView3.G1(containerView3.f10766f.h())) {
                    FlexibleWindowManager.getInstance().notifyEmbeddedTasksChangeFocus(true, ContainerView.this.f10734H);
                }
            }
            ContainerView.this.o2();
            A1.b bVar = this.f10830e;
            if (bVar != null) {
                ContainerView containerView4 = ContainerView.this;
                if (bVar.x(containerView4.o0(containerView4))) {
                    A1.b bVar2 = this.f10830e;
                    boolean z3 = this.f10827b == 1;
                    ContainerView containerView5 = ContainerView.this;
                    bVar2.h(z3, containerView5, containerView5.f10766f.getCount(), ContainerView.this.f10732G.J());
                }
            }
            if (this.f10831f) {
                ContainerView.this.layoutChildren();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d(ContainerView.f10713R0, "onAnimationStart " + this.f10826a);
            if (this.f10827b != 3) {
                ContainerView containerView = ContainerView.this;
                if (containerView.G1(containerView.f10766f.h())) {
                    FlexibleWindowManager.getInstance().notifyEmbeddedTasksChangeFocus(false, ContainerView.this.f10734H);
                }
            }
        }
    }

    class l implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C0601d f10833e;

        l(C0601d c0601d) {
            this.f10833e = c0601d;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            ContainerView.this.b2();
            ContainerView.this.getContainerController().B(this.f10833e);
            return p2.q.f12810a;
        }
    }

    class m implements C2.a {
        m(ContainerView containerView) {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            return p2.q.f12810a;
        }
    }

    class n implements C2.a {
        n() {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            ContainerView.this.getAdapter().H(0);
            ContainerView.this.setSplitBarVisibility(0);
            ContainerView containerView = ContainerView.this;
            containerView.f10755S = false;
            containerView.f10732G.H0();
            if (ContainerView.this.f10747N0 != null) {
                B1.h.a(((ListView) ContainerView.this).mContext).d(ContainerView.this.f10747N0, ContainerView.this);
                ContainerView.this.f10747N0 = null;
            }
            return p2.q.f12810a;
        }
    }

    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ContainerView.this.Q0();
            int h3 = ContainerView.this.f10766f.h();
            C0601d item = ContainerView.this.f10766f.getItem(0);
            ContainerView.this.f10766f.V(item);
            ContainerView.this.f10766f.U(item);
            ContainerView.this.f10766f.N(ContainerView.this.f10766f.l());
            ContainerView.this.f10778l.clear();
            ContainerView.this.f2();
            ContainerView.this.T2();
            ContainerView.this.f10766f.H(1 - h3);
            ContainerView.this.f10749O0 = true;
            C0622f k3 = C0622f.k(((ListView) ContainerView.this).mContext);
            ContainerView containerView = ContainerView.this;
            k3.D(containerView.Q2(((ListView) containerView).mContext).u0(), ContainerView.this.f10722B, ContainerView.this.f10736I.M(), true);
            B1.h.a(((ListView) ContainerView.this).mContext.getApplicationContext()).d("drag_swap", ContainerView.this);
        }
    }

    class p implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10837e;

        p(int i3) {
            this.f10837e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            B1.l.L1(ContainerView.this.f10766f.getItem(!B1.s.n(this.f10837e) ? 1 : 0).s());
        }
    }

    class q implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f10839a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ E.c f10840b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f10841c;

        q(List list, E.c cVar, int i3) {
            this.f10839a = list;
            this.f10840b = cVar;
            this.f10841c = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(List list, E.c cVar, int i3) {
            ContainerView.this.c2(new SurfaceControl.Transaction());
            ContainerView.this.Q0();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < ContainerView.this.f10766f.getCount(); i4++) {
                arrayList.add(ContainerView.this.f10766f.getItem(i4));
            }
            ContainerView.this.f10766f.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ContainerView.this.f10766f.U((C0601d) arrayList.get(((Integer) it.next()).intValue()));
            }
            ContainerView.this.f10766f.N(ContainerView.this.f10766f.l());
            ContainerView.this.f10766f.D();
            int n3 = ContainerView.this.f10766f.n();
            if (n3 != 4) {
                if (n3 != 5) {
                    if (n3 != 6) {
                        if (n3 == 7 && cVar.k()) {
                            ContainerView.this.f10766f.M(6);
                        }
                    } else if (cVar.k()) {
                        ContainerView.this.f10766f.M(7);
                    }
                } else if (!cVar.k()) {
                    ContainerView.this.f10766f.M(4);
                }
            } else if (!cVar.k()) {
                ContainerView.this.f10766f.M(5);
            }
            ContainerView.this.f10766f.g(i3);
            ContainerView.this.f10766f.E();
            for (EmbeddedViewDecor embeddedViewDecor : ContainerView.this.getChildEmbeddedViewList()) {
                embeddedViewDecor.setTranslationX(0.0f);
                embeddedViewDecor.setTranslationY(0.0f);
                embeddedViewDecor.setZ(0.0f);
            }
            ContainerView.this.T2();
            ContainerView.this.o2();
            ContainerView.this.f10749O0 = true;
            ContainerView.this.setSplitBarVisibility(0);
            ContainerView.this.setControlBarVisibility(0);
            ContainerView containerView = ContainerView.this;
            containerView.f10755S = false;
            C0622f k3 = C0622f.k(((ListView) containerView).mContext);
            ContainerView containerView2 = ContainerView.this;
            k3.D(containerView2.Q2(((ListView) containerView2).mContext).u0(), ContainerView.this.f10722B, ContainerView.this.f10736I.M(), true);
            B1.h.a(((ListView) ContainerView.this).mContext).d("menu_swap", ContainerView.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            B1.l.u1(ContainerView.this.getContainerView(), 20109, false);
            Handler mainThreadHandler = ((ListView) ContainerView.this).mContext.getMainThreadHandler();
            final List list = this.f10839a;
            final E.c cVar = this.f10840b;
            final int i3 = this.f10841c;
            mainThreadHandler.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.j
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerView.q.this.b(list, cVar, i3);
                }
            });
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            B1.l.u1(ContainerView.this.getContainerView(), 20109, true);
            ContainerView.this.setSplitBarVisibility(4);
        }
    }

    class r implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10843e;

        r(int i3) {
            this.f10843e = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3) {
            ContainerView.this.b2();
            ContainerView.this.f10778l.clear();
            ContainerView.this.f10766f.M(i3);
            ContainerView.this.f10766f.notifyDataSetChanged();
        }

        @Override // C2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            Handler mainThreadHandler = ((ListView) ContainerView.this).mContext.getMainThreadHandler();
            final int i3 = this.f10843e;
            mainThreadHandler.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.k
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerView.r.this.c(i3);
                }
            });
            return p2.q.f12810a;
        }
    }

    class s implements C2.a {
        s(ContainerView containerView) {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            return p2.q.f12810a;
        }
    }

    class t implements C2.a {
        t() {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            ContainerView.this.setSplitBarVisibility(0);
            ContainerView containerView = ContainerView.this;
            containerView.f10755S = false;
            containerView.f10756T = false;
            return p2.q.f12810a;
        }
    }

    class u implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10846e;

        u(int i3) {
            this.f10846e = i3;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            if (B1.s.m(this.f10846e)) {
                B1.s.n(this.f10846e);
                boolean n3 = B1.s.n(this.f10846e);
                C0601d l3 = ContainerView.this.f10722B.l(n3 ? 1 : 0);
                int s3 = l3 == null ? -1 : l3.s();
                ContainerView containerView = ContainerView.this;
                containerView.C2(containerView.Q2(((ListView) containerView).mContext).u0(), -1, s3, false, false);
                ContainerView containerView2 = ContainerView.this;
                containerView2.Q2(((ListView) containerView2).mContext).V1(n3 ? 1 : 0);
                ContainerView containerView3 = ContainerView.this;
                containerView3.Q2(((ListView) containerView3).mContext).O1(true);
                ContainerView.this.f10722B.A(-1);
            }
            return p2.q.f12810a;
        }
    }

    class v implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10848e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f10849f;

        v(int i3, int i4) {
            this.f10848e = i3;
            this.f10849f = i4;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            if (B1.s.m(this.f10848e)) {
                Log.d(ContainerView.f10713R0, "scrollSpliteMaskFull finish");
                ContainerView.this.f10742L = false;
                Bundle bundle = new Bundle();
                bundle.putBoolean("androidx.activity.isInFullScreenAnimation", ContainerView.this.f10742L);
                B1.l.f(bundle);
                ContainerView containerView = ContainerView.this;
                containerView.Q2(((ListView) containerView).mContext).finish();
                ContainerView containerView2 = ContainerView.this;
                containerView2.Q2(((ListView) containerView2).mContext).overridePendingTransition(0, AbstractC0587a.f13360b);
                ContainerView containerView3 = ContainerView.this;
                containerView3.Q2(((ListView) containerView3).mContext).C1();
            } else if (this.f10849f >= 0) {
                ContainerView.this.d2();
                if (this.f10849f < ContainerView.this.f10766f.getCount()) {
                    ContainerView containerView4 = ContainerView.this;
                    containerView4.V2(containerView4.f10766f.getItem(this.f10849f), this.f10849f);
                    ContainerView.this.f10766f.H(this.f10849f);
                }
            }
            return p2.q.f12810a;
        }
    }

    class w implements C2.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C0601d f10851e;

        w(C0601d c0601d) {
            this.f10851e = c0601d;
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            ContainerView.this.f10766f.D();
            ContainerView.this.d2();
            C0601d c0601d = this.f10851e;
            if (c0601d != null) {
                ContainerView.this.V2(c0601d, 0);
                ContainerView.this.f10722B.G(this.f10851e);
            }
            ContainerView.this.f10766f.N(ContainerView.this.f10766f.l());
            return p2.q.f12810a;
        }
    }

    class x implements C2.a {
        x() {
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p2.q invoke() {
            ContainerView containerView = ContainerView.this;
            containerView.f10755S = false;
            if (containerView.f10754R != null) {
                ContainerView.this.f10754R.O();
            }
            return p2.q.f12810a;
        }
    }

    public ContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private List B2(View view, Rect rect, Rect rect2, boolean z3, int i3) {
        ObjectAnimator objectAnimator;
        Log.d(f10713R0, "startAnimationForView: covered=" + z3);
        if (i3 == 0) {
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        } else if (i3 == 1) {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        } else if (i3 == 2) {
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(0.0f);
        } else if (i3 == 3) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2.0f);
        } else if (i3 == 4) {
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight());
        }
        float f3 = rect2.left - rect.left;
        float f4 = rect2.top - rect.top;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "TranslationX", view.getTranslationX(), view.getTranslationX() + f3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "TranslationY", view.getTranslationY(), view.getTranslationY() + f4);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "ScaleX", view.getScaleX(), (float) (view.getScaleX() * 0.95d), view.getScaleX());
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "ScaleY", view.getScaleY(), (float) (view.getScaleY() * 0.95d), view.getScaleY());
        if (view instanceof EmbeddedViewDecor) {
            FlexibleTaskView flexibleTaskView = ((EmbeddedViewDecor) view).getFlexibleTaskView();
            objectAnimator = ObjectAnimator.ofFloat(flexibleTaskView, "Alpha", flexibleTaskView.getAlpha(), flexibleTaskView.getAlpha() * 0.2f, flexibleTaskView.getAlpha());
        } else {
            objectAnimator = null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        boolean z4 = Math.abs(f3) > 0.0f || Math.abs(f4) > 0.0f;
        if (z3 && z4) {
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            if (objectAnimator != null) {
                arrayList.add(objectAnimator);
            }
        }
        return arrayList;
    }

    public static float C0(float f3) {
        float pow = (float) Math.pow(6.283185307179586d / (f3 == 0.0f ? 1.0f : f3), 2.0d);
        Log.d(f10713R0, "stiffness response: " + f3 + ", stiffness:" + pow);
        if (pow <= 0.0f) {
            return 1500.0f;
        }
        return pow;
    }

    private void D1(String str) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - f10714S0 < 1500) {
            return;
        }
        f10714S0 = uptimeMillis;
        Log.w(f10713R0, "ContainerViewScrollTrace: " + str, new Throwable("scroll trace"));
    }

    private boolean I1(float[] fArr, float[] fArr2) {
        return ((double) Math.abs(fArr[0] - fArr2[0])) <= 1.0E-4d && Math.abs(fArr[1] - fArr2[1]) <= 1.0f && Math.abs((fArr[2] - fArr2[2]) - ((float) Q2(((ListView) this).mContext).B0())) <= 1.0f;
    }

    private C2.a J2(ContainerActivity containerActivity, int i3, C0601d c0601d, int i4) {
        return new g(i4, containerActivity);
    }

    private C2.a K2() {
        return new h();
    }

    private C2.a L2(ContainerActivity containerActivity, int i3, C0601d c0601d, int i4) {
        return new f(i4, i3, c0601d, containerActivity);
    }

    private void M2() {
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        ArrayList arrayList = new ArrayList();
        if (childEmbeddedViewList.size() == this.f10766f.getCount() && X0(childEmbeddedViewList)) {
            boolean z3 = false;
            for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
                int i4 = 0;
                while (true) {
                    if (i4 >= childEmbeddedViewList.size()) {
                        break;
                    }
                    if (this.f10766f.getItem(i3).equals(childEmbeddedViewList.get(i4).getFlexibleTaskData())) {
                        arrayList.add(childEmbeddedViewList.get(i4));
                        if (i3 != i4) {
                            z3 = true;
                        }
                    } else {
                        i4++;
                    }
                }
                if (i4 >= childEmbeddedViewList.size()) {
                    arrayList.add(new EmbeddedViewDecor(getContext()));
                    z3 = true;
                }
            }
            if (z3 && arrayList.size() == this.f10766f.getCount()) {
                i0(childEmbeddedViewList);
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    ViewGroup.LayoutParams layoutParams = ((EmbeddedViewDecor) arrayList.get(i5)).getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(this.f10766f.getItem(i5).n().width(), this.f10766f.getItem(i5).n().height());
                    }
                    attachViewToParent((View) arrayList.get(i5), i5, layoutParams);
                }
            }
        }
    }

    private void N2() {
        M2();
        int n3 = this.f10766f.n();
        if (n3 < 3) {
            this.f10766f.e();
            n3 = this.f10766f.n();
        }
        int i3 = this.f10766f.j() ? 3 : n3;
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f10766f.getCount(); i4++) {
            arrayList.add(this.f10766f.getItem(i4));
        }
        List M12 = B1.l.M1(arrayList, i3, ((ListView) this).mContext.getResources().getDisplayMetrics().density);
        this.f10778l.addAll(M12);
        for (int i5 = 0; i5 < M12.size(); i5++) {
            Rect rect = (Rect) M12.get(i5);
            this.f10780m.union(rect);
            EmbeddedViewDecor q02 = q0(i5);
            if (q02 != null) {
                q02.j0(this.f10766f.getItem(i5), ((C0601d) arrayList.get(i5)).n(), this.f10794t);
                q02.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
            Log.d(f10713R0, "layoutFlexibleTask " + rect);
        }
    }

    private void O2() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
            arrayList.add(this.f10766f.getItem(i3));
        }
        float f3 = ((ListView) this).mContext.getResources().getDisplayMetrics().density;
        List N12 = B1.l.N1(getContext(), arrayList, this.f10766f.n(), f3);
        boolean[] zArr = {false, false};
        if (B1.s.r(((ListView) this).mContext)) {
            zArr = b1();
        }
        g2(N12, arrayList, f3);
        this.f10778l.clear();
        this.f10778l.addAll(N12);
        this.f10780m.setEmpty();
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        for (int i4 = 0; i4 < childEmbeddedViewList.size(); i4++) {
            EmbeddedViewDecor embeddedViewDecor = childEmbeddedViewList.get(i4);
            Rect rect = (Rect) this.f10778l.get(i4);
            embeddedViewDecor.j0((C0601d) arrayList.get(i4), zArr[i4] ? ((C0601d) arrayList.get(i4)).i() : ((C0601d) arrayList.get(i4)).n(), this.f10792s);
            embeddedViewDecor.layout(rect.left, rect.top, rect.right, rect.bottom);
            this.f10780m.union((Rect) this.f10778l.get(i4));
            Log.d(f10713R0, "layoutFlexibleTask " + rect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        float f3 = this.f10793s0;
        float f4 = f10716U0;
        if (f3 >= f4) {
            float f5 = f10715T0;
            if (f3 <= f5) {
                float f6 = 1.0f - f3;
                this.f10793s0 = f6;
                if (f6 < f4) {
                    this.f10793s0 = f4;
                } else if (f6 > f5) {
                    this.f10793s0 = f5;
                }
            }
        }
    }

    private void R1(List list, List list2, boolean z3) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!list2.contains(list.get(i3))) {
                if (z3 && list.get(i3) != this.f10761b0) {
                    ((EmbeddedViewDecor) list.get(i3)).H();
                }
                removeDetachedView((View) list.get(i3), false);
                final C0601d flexibleTaskData = ((EmbeddedViewDecor) list.get(i3)).getFlexibleTaskData();
                if (flexibleTaskData != null && flexibleTaskData.s() > 0) {
                    final ContainerActivity Q22 = Q2(((ListView) this).mContext);
                    post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ContainerView.t1(C0601d.this, Q22);
                        }
                    });
                }
            }
        }
    }

    private void R2() {
        float f3 = this.f10791r0 / 100.0f;
        float f4 = this.f10781m0;
        this.f10739J0.p(f3 - f4 > 0.0f ? f4 / f3 : 1.0f);
    }

    private void S2() {
        if (this.f10736I.M()) {
            return;
        }
        if (this.f10766f.getCount() == 2) {
            C0601d item = this.f10766f.getItem(0);
            C0601d item2 = this.f10766f.getItem(1);
            if (item == null || item2 == null) {
                return;
            }
            if (item.v() == item2.v() && Objects.equals(item.k(), item2.k()) && B1.l.f214n.contains(item.k()) && !B1.s.w(((ListView) this).mContext)) {
                for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
                    if (embeddedViewDecor.getCanvasControlBarManager() != null) {
                        embeddedViewDecor.getCanvasControlBarManager().r1(8);
                    }
                }
                return;
            }
        }
        for (EmbeddedViewDecor embeddedViewDecor2 : getChildEmbeddedViewList()) {
            if (embeddedViewDecor2.getCanvasControlBarManager() != null) {
                embeddedViewDecor2.getCanvasControlBarManager().r1(0);
            }
        }
    }

    private boolean T0(int i3, int i4, int i5, int i6, E.c cVar) {
        if (i5 != 3) {
            return i5 != 4 ? i5 != 5 ? i5 != 6 ? i5 != 7 ? i3 != i4 : i4 == 2 ? i3 < 2 : i3 == 2 || !(i3 == i4 || cVar.k()) : i4 == 0 ? i3 > 0 : i3 == 0 || !(i3 == i4 || cVar.k()) : i4 == 2 ? i3 < 2 : i3 == 2 || (i3 != i4 && cVar.k()) : i4 == 0 ? i3 > 0 : i3 == 0 || (i3 != i4 && cVar.k());
        }
        if (i4 == 0) {
            if (this.f10732G.H().indexOf(cVar) == 1) {
                return i3 == 2;
            }
        } else if (i4 == 2 && this.f10732G.H().indexOf(cVar) == 0) {
            return i3 == 0;
        }
        return i3 != i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void u1(C0601d c0601d) {
        if (this.f10766f.getCount() == 3) {
            X1(c0601d);
            return;
        }
        if (this.f10766f.getCount() == 2) {
            n0(c0601d);
            if (this.f10747N0 != null) {
                B1.h.a(((ListView) this).mContext).e(this.f10747N0);
                this.f10747N0 = null;
            }
        }
    }

    private void V1() {
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (!(childAt instanceof EmbeddedViewDecor)) {
                hashSet.add(childAt);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            removeViewInLayout((View) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W(float[] fArr, float[] fArr2) {
        fArr2[2] = fArr2[2] + Q2(((ListView) this).mContext).B0();
        return ((double) Math.abs(fArr[0] - fArr2[0])) <= 1.0E-4d && Math.abs(fArr[1] - fArr2[1]) <= 1.0f && Math.abs(fArr[2] - fArr2[2]) <= 1.0f;
    }

    private boolean X0(List list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        Iterator it = list.iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            if (((EmbeddedViewDecor) it.next()).getFlexibleTaskData() == null) {
                z3 = false;
            }
        }
        return z3;
    }

    private C2.a Y1() {
        return new m(this);
    }

    private void Y2(int i3, List list, float f3, float f4) {
        y1.u uVar = (y1.u) list.get(0);
        y1.u uVar2 = (y1.u) list.get(1);
        this.f10760a0.D(200L);
        uVar.n(Z(i3, uVar.h(), f3, f4));
        uVar.k(((ListView) this).mContext.getColor(AbstractC0589c.f13368g));
        uVar2.n(Z(i3, uVar2.h(), f3, f4));
        uVar2.k(((ListView) this).mContext.getColor(AbstractC0589c.f13368g));
    }

    private Rect Z(int i3, Rect rect, float f3, float f4) {
        float[] fArr;
        float[] fArr2;
        int i4;
        if (!j1()) {
            f3 = f4;
        }
        int width = j1() ? this.f10724C.width() : this.f10724C.height();
        if (!B1.s.w(((ListView) this).mContext) && !B1.s.H()) {
            if (i3 == 6 && (fArr2 = this.f10768g) != null && fArr2.length > i3 - 2) {
                float f5 = fArr2[i4];
                this.f10781m0 = (f3 - f5) / (width - f5);
            }
            if (i3 == 1 && (fArr = this.f10768g) != null && fArr.length > 0) {
                float f6 = fArr[0];
                this.f10781m0 = (f6 - f3) / f6;
            }
        }
        if (j1()) {
            rect.top = (int) (rect.top + ((rect.height() - (rect.height() * Y(this.f10781m0))) / 2.0f));
            rect.bottom = (int) (rect.bottom - ((rect.height() - (rect.height() * Y(this.f10781m0))) / 2.0f));
        } else {
            rect.left = (int) (rect.left + ((rect.width() - (rect.width() * Y(this.f10781m0))) / 2.0f));
            rect.right = (int) (rect.right - ((rect.width() - (rect.width() * Y(this.f10781m0))) / 2.0f));
        }
        return rect;
    }

    private C2.a Z1() {
        return new n();
    }

    private void Z2(List list, float f3, float f4, boolean z3, String str, String str2, boolean z4, boolean z5) {
        float[] fArr = this.f10768g;
        if (fArr == null || fArr.length == 0 || list.isEmpty() || list.size() != 2) {
            return;
        }
        int u02 = u0(j1(), f3, f4);
        Y2(u02, list, f3, f4);
        this.f10759W = u02;
    }

    private C2.a a2(C0601d c0601d) {
        return new l(c0601d);
    }

    private boolean[] b1() {
        boolean[] zArr = new boolean[2];
        if (!B1.s.w(getContext()) && !B1.s.H()) {
            C0601d item = this.f10766f.getItem(0);
            C0601d item2 = this.f10766f.getItem(1);
            if (k1() && item != null && item2 != null) {
                if (this.f10766f.n() == 2) {
                    if (!item.I() && item.p() == 1) {
                        zArr[0] = true;
                    }
                    if (!item2.I() && item2.p() == 1) {
                        zArr[1] = true;
                    }
                } else if (this.f10766f.n() == 1) {
                    if (item.I() && item.p() == 1) {
                        zArr[0] = true;
                    }
                    if (item2.I() && item2.p() == 1) {
                        zArr[1] = true;
                    }
                }
                if (item.B()) {
                    zArr[0] = true;
                }
                if (item2.B()) {
                    zArr[1] = true;
                }
            }
        }
        return zArr;
    }

    private void b3(boolean z3) {
        List<C0601d> l3 = this.f10766f.l();
        ArrayList arrayList = new ArrayList();
        for (C0601d c0601d : l3) {
            Intent f3 = c0601d.f();
            f3.putExtra("androidx.activity.LaunchEmbeddedTaskId", c0601d.s());
            f3.putExtra("androidx.flexible.userId", c0601d.v());
            if (z3) {
                f3.putExtra("ps_config_display_bound", ((ListView) this).mContext.getResources().getConfiguration().windowConfiguration.getBounds());
            }
            arrayList.add(f3);
        }
        List o02 = B1.l.o0(getContext(), arrayList, this.f10766f.n());
        if (f10719X0.booleanValue()) {
            Log.d(f10713R0, "updateResizableSplitRect for TaskData:" + o02);
        }
        if (o02 == null) {
            return;
        }
        for (int i3 = 0; i3 < l3.size() && i3 < o02.size(); i3++) {
            C0601d c0601d2 = (C0601d) l3.get(i3);
            C0601d c0601d3 = (C0601d) o02.get(i3);
            c0601d2.g0(c0601d3.p());
            c0601d2.f0(c0601d3.f13810a);
            c0601d2.f13804C.set(c0601d3.f13804C);
            c0601d2.W(c0601d3.i());
            c0601d2.X(c0601d3.j());
            c0601d2.s0(c0601d3.w());
            c0601d2.f13805D = c0601d3.f13805D;
            c0601d2.f13806E = c0601d3.f13806E;
            c0601d2.f13807F = c0601d3.f13807F;
            c0601d2.c0(c0601d3.l());
            c0601d2.U(c0601d3.g());
            c0601d2.V(c0601d3.h());
            if ((B1.s.H() || B1.s.B()) && z3) {
                c0601d2.g0(c0601d3.p());
                c0601d2.R(c0601d3.A());
            }
            r0 r0Var = this.f10722B;
            if (r0Var != null) {
                r0Var.h(c0601d2);
            }
        }
    }

    private C2.a c0() {
        return new s(this);
    }

    private boolean c1(float[] fArr, float[] fArr2) {
        return ((double) Math.abs(fArr[0] - fArr2[0])) <= 1.0E-4d && Math.abs(fArr[1] - fArr2[1]) <= 1.0f && Math.abs(fArr[2] - fArr2[2]) <= 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2(SurfaceControl.Transaction transaction) {
        for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
            if (embeddedViewDecor.getFlexibleTaskView().getSurfaceControl() == null || !embeddedViewDecor.getFlexibleTaskView().getSurfaceControl().isValid()) {
                Log.i(f10713R0, "getFlexibleTaskView().getSurfaceControl()=" + embeddedViewDecor.getFlexibleTaskView().getSurfaceControl());
                return;
            }
            transaction.setCornerRadius(embeddedViewDecor.getFlexibleTaskView().getSurfaceControl(), 0.0f);
            embeddedViewDecor.getFlexibleTaskView().surfaceReplaced(transaction);
        }
        transaction.apply();
    }

    private C2.a d0() {
        return new t();
    }

    private C2.a e0(int i3) {
        return new r(i3);
    }

    private boolean g1(int i3, int i4, int i5) {
        if (i5 == 3) {
            return i4 == 0 ? i3 == 1 : i4 == 2 && i3 == 1;
        }
        if (i5 != 4) {
            if (i5 != 5) {
                if (i5 != 6) {
                    if (i5 != 7) {
                        return false;
                    }
                }
            }
            return i3 + i4 == 1;
        }
        return i3 + i4 == 3;
    }

    private void g2(List list, List list2, float f3) {
        if (list.size() == 2 && list2.size() == 2 && !this.f10724C.isEmpty()) {
            int k02 = B1.l.k0(f3);
            if (this.f10766f.n() == 1 && ((Rect) list.get(0)).width() > this.f10724C.width()) {
                int width = this.f10724C.width();
                Rect rect = (Rect) list.get(0);
                Rect rect2 = (Rect) list.get(1);
                float f4 = width * 1.0f;
                rect.bottom = Math.round((f4 / rect.width()) * rect.height()) + rect.top;
                rect.right = rect.left + width;
                int round = Math.round((f4 / rect2.width()) * rect2.height());
                int i3 = rect.bottom + k02;
                rect2.top = i3;
                rect2.bottom = i3 + round;
                rect2.right = rect2.left + width;
            }
            if (this.f10766f.n() != 2 || ((Rect) list.get(0)).height() <= this.f10724C.height()) {
                return;
            }
            int height = this.f10724C.height();
            Rect rect3 = (Rect) list.get(0);
            Rect rect4 = (Rect) list.get(1);
            float f5 = height * 1.0f;
            rect3.right = rect3.left + Math.round((f5 / rect3.height()) * rect3.width());
            rect3.bottom = rect3.top + height;
            int round2 = Math.round((f5 / rect4.height()) * rect4.width());
            int i4 = rect3.right + k02;
            rect4.left = i4;
            rect4.bottom = rect4.top + height;
            rect4.right = i4 + round2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ContainerView getContainerView() {
        return this;
    }

    private void i0(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                detachViewFromParent((EmbeddedViewDecor) it.next());
            }
        }
    }

    private int l0(int i3, int i4, int i5, E.c cVar) {
        if (i5 != 4) {
            if (i5 != 5) {
                if (i5 != 6) {
                    if (i5 == 7 && i4 == 2) {
                        if (i3 == 0) {
                            return 4;
                        }
                        if (i3 == 1) {
                            return 2;
                        }
                    }
                } else if (i4 == 0) {
                    if (i3 == 1) {
                        return 4;
                    }
                    if (i3 == 2) {
                        return 2;
                    }
                }
            } else if (i4 == 2) {
                if (i3 == 0) {
                    return 3;
                }
                if (i3 == 1) {
                    return 1;
                }
            }
        } else if (i4 == 0) {
            if (i3 == 1) {
                return 3;
            }
            if (i3 == 2) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity o0(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1() {
        this.f10758V.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p1(B.b bVar, float f3, float f4) {
        this.f10738J.D0(this.f10805y0, 1.0f - f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean q1(EmbeddedViewDecor embeddedViewDecor) {
        C0327t canvasControlBarManager = embeddedViewDecor.getCanvasControlBarManager();
        return canvasControlBarManager != null && canvasControlBarManager.Q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1() {
        Log.i(f10713R0, "onConfigurationChanged");
        E e3 = this.f10732G;
        if (e3 != null) {
            e3.H0();
        }
        o2();
        s2();
        A1.b flexibleUiManager = getFlexibleUiManager();
        if (flexibleUiManager == null || !flexibleUiManager.x(o0(this))) {
            return;
        }
        flexibleUiManager.S(this.f10766f.getCount(), this, this.f10732G.J());
    }

    public static float s0(float f3) {
        float f4 = 1.0f - f3;
        Log.d(f10713R0, "dampingRatio bounce: " + f3 + ", dampingRatio " + f4);
        if (f4 <= 0.0f) {
            return 1.0f;
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s1(C0601d c0601d, ContainerActivity containerActivity) {
        Log.d(f10713R0, "removeEmbeddedContainerTask " + c0601d.s());
        FlexibleWindowManager.getInstance().removeEmbeddedContainerTask(c0601d.s(), containerActivity.u0());
    }

    private void setEnFocusStartIfNeeded(List<EmbeddedViewDecor> list) {
        int i3 = this.f10795t0;
        int i4 = Q2(((ListView) this).mContext).getResources().getConfiguration().uiMode;
        if (i3 == i4) {
            return;
        }
        this.f10795t0 = i4;
        if (Q2(((ListView) this).mContext).t0() == 4) {
            for (int i5 = 0; i5 < list.size(); i5++) {
                Log.d(f10713R0, "uiMode change and ActivityState onPause, need focus startActivity");
                list.get(i5).setEnforceStart(true);
            }
        }
    }

    private void setLayerOrder(SurfaceControl.Transaction transaction) {
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        boolean z3 = B1.s.z(0, this);
        boolean z4 = B1.s.z(1, this);
        if (!k1() || (!z3 && !z4)) {
            for (int i3 = 0; i3 < childEmbeddedViewList.size(); i3++) {
                EmbeddedViewDecor embeddedViewDecor = childEmbeddedViewList.get(i3);
                SurfaceControl surfaceControl = embeddedViewDecor.getFlexibleTaskView().getSurfaceControl();
                if (embeddedViewDecor == q0(this.f10766f.h())) {
                    v2(transaction, surfaceControl, 0);
                } else if (g1(i3, this.f10766f.h(), this.f10766f.n())) {
                    v2(transaction, surfaceControl, 1);
                } else if (embeddedViewDecor.getFlexibleTaskView().isZOrderedOnTop()) {
                    v2(transaction, surfaceControl, 2);
                }
            }
            transaction.apply();
            return;
        }
        for (int i4 = 0; i4 < childEmbeddedViewList.size(); i4++) {
            EmbeddedViewDecor embeddedViewDecor2 = childEmbeddedViewList.get(i4);
            SurfaceControl surfaceControl2 = embeddedViewDecor2.getFlexibleTaskView().getSurfaceControl();
            if (embeddedViewDecor2 == q0(this.f10766f.h())) {
                transaction.setLayer(surfaceControl2, 4);
                transaction.setCornerRadius(surfaceControl2, this.f10792s);
                if (B1.s.z(i4, this)) {
                    transaction.setLayer(B1.l.J(embeddedViewDecor2.getFlexibleTaskView()), 3);
                }
            } else {
                transaction.setLayer(surfaceControl2, 2);
                transaction.setCornerRadius(surfaceControl2, this.f10792s);
                if (B1.s.z(i4, this)) {
                    transaction.setLayer(B1.l.J(embeddedViewDecor2.getFlexibleTaskView()), 1);
                }
            }
        }
        transaction.apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t1(final C0601d c0601d, final ContainerActivity containerActivity) {
        C0305a.a().b(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.f
            @Override // java.lang.Runnable
            public final void run() {
                ContainerView.s1(C0601d.this, containerActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v1(int i3, float[] fArr, float[] fArr2) {
        this.f10750P = true;
        this.f10752Q.start();
        if (i3 == 4) {
            ImageView h3 = ((E.c) this.f10732G.H().get(0)).h();
            h3.setTranslationX(h3.getTranslationX() - (fArr[1] - fArr2[1]));
            h3.setTranslationY(h3.getTranslationY() - (fArr[2] - fArr2[2]));
        }
    }

    private void v2(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, int i3) {
        if (surfaceControl != null && surfaceControl.isValid()) {
            transaction.setLayer(surfaceControl, 1 - i3);
            transaction.setCornerRadius(surfaceControl, this.f10792s);
            return;
        }
        Log.i(f10713R0, "surfaceControl=" + surfaceControl);
    }

    private void w1() {
        if (this.f10766f.getCount() < 1) {
            return;
        }
        this.f10778l.clear();
        this.f10780m.setEmpty();
        if (this.f10766f.getCount() == 1) {
            Rect n3 = this.f10766f.getItem(0).n();
            Rect rect = this.f10724C;
            Rect rect2 = new Rect(rect.left, rect.top, n3.width() + this.f10724C.left, n3.height() + this.f10724C.top);
            this.f10778l.add(rect2);
            this.f10780m.union(rect2);
            EmbeddedViewDecor q02 = q0(0);
            if (q02 != null) {
                q02.j0(this.f10766f.getItem(0), n3, this.f10792s);
                q02.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
        if (k1()) {
            O2();
        }
        if (i1()) {
            N2();
        }
    }

    public static float x0(Context context) {
        if (B1.s.H()) {
            return 0.4f;
        }
        if (B1.s.w(context)) {
            return 0.6f;
        }
        B1.s.r(context);
        return 0.2f;
    }

    public static float y0(Context context) {
        if (B1.s.H()) {
            return 0.05f;
        }
        if (B1.s.w(context)) {
            return 0.2f;
        }
        B1.s.r(context);
        return 0.3f;
    }

    public int A0(int i3) {
        return this.f10732G.K(i3);
    }

    public List A1(int i3, List list, List list2) {
        List list3 = list;
        Log.d(f10713R0, "makeTaskViewScaleAnim originalLocations=" + list3 + ", newLocations=" + list2);
        if (list.size() != list2.size() || list.size() != getChildEmbeddedViewList().size()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < getChildEmbeddedViewList().size()) {
            EmbeddedViewDecor embeddedViewDecor = getChildEmbeddedViewList().get(i4);
            embeddedViewDecor.setPivotX(0.0f);
            embeddedViewDecor.setPivotY(0.0f);
            Rect rect = (Rect) list3.get(i4);
            Rect rect2 = (Rect) list2.get(i4);
            float parentScaleX = (rect2.left - rect.left) / getParentScaleX();
            float parentScaleY = (rect2.top - rect.top) / getParentScaleY();
            float width = (rect2.width() * 1.0f) / rect.width();
            float height = (rect2.height() * 1.0f) / rect.height();
            if (Float.isNaN(parentScaleX) || Float.isInfinite(parentScaleX) || Float.isNaN(parentScaleY) || Float.isInfinite(parentScaleY) || Float.isNaN(width) || Float.isInfinite(width) || Float.isNaN(height) || Float.isInfinite(height)) {
                Log.d(f10713R0, "makeTaskViewScaleAnim return getParentScaleX=" + getParentScaleX() + ", getParentScaleY=" + getParentScaleY());
                return null;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.TRANSLATION_X, parentScaleX);
            long j3 = i3;
            ofFloat.setDuration(j3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.TRANSLATION_Y, parentScaleY);
            ofFloat2.setDuration(j3);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.SCALE_X, width);
            ofFloat3.setDuration(j3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.SCALE_Y, height);
            ofFloat4.setDuration(j3);
            ofFloat.addUpdateListener(new d(this, embeddedViewDecor));
            ofFloat2.addUpdateListener(new e(this, embeddedViewDecor));
            arrayList.add(ofFloat);
            arrayList.add(ofFloat2);
            arrayList.add(ofFloat3);
            arrayList.add(ofFloat4);
            i4++;
            list3 = list;
        }
        return arrayList;
    }

    public boolean A2(float f3, float f4, float f5, int i3, final int i4) {
        long j3;
        if (Float.isInfinite(f5) || f5 <= 0.0f) {
            Log.d(f10713R0, "startAnimation isInfinite newScale:" + f5 + ",newTranslationX:" + f3 + ",newTranslationY:" + f4);
            return false;
        }
        if (this.f10745M0) {
            Log.d(f10713R0, "startAnimation mIsToFlexibleAnimating");
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        final float[] fArr = {viewGroup.getScaleX(), viewGroup.getTranslationX(), viewGroup.getTranslationY()};
        final float[] fArr2 = {f5, f3, f4};
        float[] fArr3 = {this.f10723B0, this.f10807z0, this.f10721A0};
        if (c1(fArr, fArr2) && c1(fArr3, fArr2)) {
            Log.d(f10713R0, "startAnimation isSame:" + Arrays.toString(fArr2));
            A1.b.H(0);
            return false;
        }
        AnimatorSet animatorSet = this.f10752Q;
        if (animatorSet != null && ((animatorSet.isRunning() || this.f10752Q.isStarted()) && this.f10750P)) {
            if (this.f10762c0 == 3 && Q2(((ListView) this).mContext).A0()) {
                OplusInputMethodManager.getInstance().hideCurrentInputMethod();
            }
            this.f10752Q.cancel();
        }
        this.f10762c0 = i4;
        boolean z3 = AccessibilityManager.getInstance(((ListView) this).mContext).isEnabled() && !(f5 == viewGroup.getScaleX() && f5 == viewGroup.getScaleY());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, "ScaleX", viewGroup.getScaleX(), f5);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, "ScaleY", viewGroup.getScaleY(), f5);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), (int) f3);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationY", viewGroup.getTranslationY(), (int) f4);
        A1.b flexibleUiManager = getFlexibleUiManager();
        if (i4 == 1) {
            A1.b.H(A1.b.k() + 1);
            if (flexibleUiManager != null) {
                flexibleUiManager.o(203);
            }
        }
        if (flexibleUiManager != null) {
            flexibleUiManager.W();
        }
        String str = f10713R0;
        Log.i(str, "startAnimation " + i4 + " scale:" + f5 + " translationX: " + f3 + " translationY:" + f4 + " scaleChange : " + z3 + " " + Debug.getCallers(10));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f10752Q = animatorSet2;
        animatorSet2.addListener(new k(viewGroup, i4, fArr, fArr2, flexibleUiManager, z3));
        this.f10752Q.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        if (i4 == 2) {
            this.f10752Q.setInterpolator(new PathInterpolator(0.0f, 0.38f, 0.06f, 0.96f));
        } else {
            this.f10752Q.setInterpolator(this.f10764e);
        }
        Log.i(str, "startAnimation isStartThreeSplitNoAnim: " + Q2(((ListView) this).mContext).U0());
        AnimatorSet animatorSet3 = this.f10752Q;
        if (Q2(((ListView) this).mContext).U0()) {
            j3 = 0;
        } else {
            j3 = i3 < 0 ? 450 : i3;
        }
        animatorSet3.setDuration(j3);
        Runnable runnable = new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.d
            @Override // java.lang.Runnable
            public final void run() {
                ContainerView.this.v1(i4, fArr2, fArr);
            }
        };
        if (((ListView) this).mContext.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            ((ListView) this).mContext.getMainThreadHandler().post(runnable);
        }
        this.f10723B0 = f5;
        this.f10807z0 = f3;
        this.f10721A0 = f4;
        return true;
    }

    public float B0(Context context) {
        float f3 = 0.4f;
        if (!B1.s.H()) {
            if (!B1.s.w(context)) {
                B1.s.r(context);
                f3 = 0.2f;
            } else if (B1.s.y(context)) {
                f3 = 0.5f;
            }
        }
        float f4 = (1.0f - f3) * 0.5f;
        f10716U0 = f4;
        f10715T0 = 1.0f - f4;
        return f3;
    }

    public void B1() {
        for (int i3 = 0; i3 < getChildEmbeddedViewList().size(); i3++) {
            q0(i3).W();
        }
    }

    public void C1(int i3, List list, List list2) {
        Log.d(f10713R0, "makeViewScaleAnim originalLocations=" + list + ", newLocations=" + list2);
        if (list.size() == 2 && list2.size() == 2 && getChildEmbeddedViewList().size() == 2) {
            ArrayList arrayList = new ArrayList();
            this.f10777k0 = new AnimatorSet();
            for (int i4 = 0; i4 < getChildEmbeddedViewList().size(); i4++) {
                EmbeddedViewDecor embeddedViewDecor = getChildEmbeddedViewList().get(i4);
                embeddedViewDecor.setPivotX(0.0f);
                embeddedViewDecor.setPivotY(0.0f);
                Rect rect = (Rect) list.get(i4);
                Rect rect2 = (Rect) list2.get(i4);
                float parentScaleX = (rect2.left - rect.left) / getParentScaleX();
                float parentScaleY = (rect2.top - rect.top) / getParentScaleY();
                float width = (rect2.width() * 1.0f) / rect.width();
                float height = (rect2.height() * 1.0f) / rect.height();
                if (Float.isNaN(parentScaleX) || Float.isInfinite(parentScaleX) || Float.isNaN(parentScaleY) || Float.isInfinite(parentScaleY) || Float.isNaN(width) || Float.isInfinite(width) || Float.isNaN(height) || Float.isInfinite(height)) {
                    return;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.TRANSLATION_X, parentScaleX);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.TRANSLATION_Y, parentScaleY);
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.SCALE_X, width);
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(embeddedViewDecor, (Property<EmbeddedViewDecor, Float>) View.SCALE_Y, height);
                ofFloat.addUpdateListener(new b(this, embeddedViewDecor));
                ofFloat2.addUpdateListener(new c(this, embeddedViewDecor));
                arrayList.add(ofFloat);
                arrayList.add(ofFloat2);
                arrayList.add(ofFloat3);
                arrayList.add(ofFloat4);
            }
            this.f10777k0.playTogether(arrayList);
            this.f10777k0.setDuration(i3);
            this.f10777k0.setInterpolator(new Y.e());
            this.f10777k0.start();
        }
    }

    public void C2(int i3, int i4, int i5, boolean z3, boolean z4) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("androidx.activity.LaunchScenario", 1);
            bundle.putFloat("androidx.activity.LaunchScale", 1.0f);
            if (z3) {
                bundle.putBoolean("androidx.flexible.activityNoAnimation", true);
            }
            if (z4) {
                bundle.putBoolean("animatingSwitchToZoom", true);
                if (i4 != -1) {
                    bundle.putInt("toFlexibleTaskId", i4);
                }
            }
            if (i5 != -1) {
                bundle.putInt("toFullScreenTaskId", i5);
            }
            ActivityOptions makeBasic = ActivityOptions.makeBasic();
            makeBasic.setLaunchBounds(new Rect(0, 0, B1.s.j(((ListView) this).mContext), B1.s.h(((ListView) this).mContext)));
            ActivityTaskManager.getService().startActivityFromRecents(i3, FlexibleWindowManager.getInstance().setExtraBundle(makeBasic, bundle));
        } catch (Exception unused) {
            Log.e(f10713R0, "failed to start activity in flexible");
        }
    }

    public Bitmap D0(int i3) {
        return E0(i3, 0.1f);
    }

    public List D2(E.c cVar, float f3, float f4, boolean z3, boolean z4, boolean z5) {
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        this.f10773i0 = childrenPositionOnScreen;
        AnimatorSet animatorSet = this.f10777k0;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f10777k0.cancel();
        }
        if (q0(0) != null) {
            this.f10779l0 = q0(0).getScaleX();
        }
        if (Math.abs(this.f10779l0 - 1.0f) < 1.0E-5d) {
            a0();
        }
        Log.d(f10713R0, "startScrollSplitBar mOriginalLocations=" + this.f10773i0 + ", mScaleProgress=" + this.f10779l0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.flexible.animatingScrollSplitBarAnimation", true);
        B1.l.f(bundle);
        ArrayList arrayList = new ArrayList();
        C0601d item = this.f10766f.getItem(0);
        C0601d item2 = this.f10766f.getItem(1);
        Rect rect = childrenPositionOnScreen.get(0);
        Rect rect2 = childrenPositionOnScreen.get(1);
        Bitmap embeddedViewSnapShot = q0(0).getEmbeddedViewSnapShot();
        Bitmap embeddedViewSnapShot2 = q0(1).getEmbeddedViewSnapShot();
        int lightMode = q0(0).getLightMode();
        int lightMode2 = q0(1).getLightMode();
        arrayList.add(new y1.u(new Rect(rect), item.f(), item.e(), embeddedViewSnapShot, lightMode));
        arrayList.add(new y1.u(new Rect(rect2), item2.f(), item2.e(), embeddedViewSnapShot2, lightMode2));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new y1.u((y1.u) it.next()));
        }
        setIsCancelSplitBarScroll(false);
        this.f10738J.X(arrayList2);
        this.f10804y = null;
        this.f10806z = null;
        return arrayList;
    }

    public Bitmap E0(int i3, float f3) {
        FlexibleTaskView flexibleTaskView;
        SurfaceControl surfaceControl;
        ScreenCapture.ScreenshotHardwareBuffer captureLayers;
        EmbeddedViewDecor q02 = q0(i3);
        if (q02 == null || (flexibleTaskView = q02.getFlexibleTaskView()) == null || (surfaceControl = flexibleTaskView.getSurfaceControl()) == null || (captureLayers = ScreenCapture.captureLayers(new ScreenCapture.LayerCaptureArgs.Builder(surfaceControl).setCaptureSecureLayers(true).setSourceCrop(new Rect(0, 0, q02.getWidth(), q02.getHeight())).setPixelFormat(4).setFrameScale(f3, f3).setAllowProtected(true).build())) == null) {
            return null;
        }
        try {
            return captureLayers.asBitmap();
        } catch (Exception e3) {
            Log.e(f10713R0, "failed to getViewSnapShot from ScreenshotHardwareBuffer" + e3);
            return null;
        }
    }

    public void E1() {
        S(this.f10766f.h(), 450, 2);
    }

    public List E2() {
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        this.f10773i0 = childrenPositionOnScreen;
        AnimatorSet animatorSet = this.f10777k0;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f10777k0.cancel();
        }
        if (q0(0) != null) {
            this.f10779l0 = q0(0).getScaleX();
        }
        if (Math.abs(this.f10779l0 - 1.0f) < 1.0E-5d) {
            a0();
        }
        Log.d(f10713R0, "startScrollSplitBarInThreeSplit mOriginalLocations=" + this.f10773i0 + ", mScaleProgress=" + this.f10779l0);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.flexible.animatingScrollSplitBarAnimation", true);
        B1.l.f(bundle);
        ArrayList arrayList = new ArrayList();
        C0601d item = this.f10766f.getItem(0);
        C0601d item2 = this.f10766f.getItem(1);
        C0601d item3 = this.f10766f.getItem(2);
        Rect rect = childrenPositionOnScreen.get(0);
        Rect rect2 = childrenPositionOnScreen.get(1);
        Rect rect3 = childrenPositionOnScreen.get(2);
        Bitmap embeddedViewSnapShot = q0(0).getEmbeddedViewSnapShot();
        Bitmap embeddedViewSnapShot2 = q0(1).getEmbeddedViewSnapShot();
        Bitmap embeddedViewSnapShot3 = q0(2).getEmbeddedViewSnapShot();
        int lightMode = q0(0).getLightMode();
        int lightMode2 = q0(1).getLightMode();
        int lightMode3 = q0(2).getLightMode();
        arrayList.add(new y1.u(new Rect(rect), item.f(), item.e(), embeddedViewSnapShot, lightMode));
        arrayList.add(new y1.u(new Rect(rect2), item2.f(), item2.e(), embeddedViewSnapShot2, lightMode2));
        arrayList.add(new y1.u(new Rect(rect3), item3.f(), item3.e(), embeddedViewSnapShot3, lightMode3));
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new y1.u((y1.u) it.next()));
        }
        setIsCancelSplitBarScroll(false);
        this.f10738J.X(arrayList2);
        this.f10804y = null;
        this.f10806z = null;
        this.f10720A = null;
        return arrayList;
    }

    public Bitmap F0(int i3, Rect rect) {
        float f3;
        float f4;
        SurfaceControl surfaceControl = q0(i3).getFlexibleTaskView().getSurfaceControl();
        if (surfaceControl != null) {
            if (rect != null) {
                f3 = rect.width() / q0(i3).getWidth();
                f4 = rect.height() / q0(i3).getHeight();
            } else {
                f3 = 1.0f;
                f4 = 1.0f;
            }
            ScreenCapture.ScreenshotHardwareBuffer captureLayers = ScreenCapture.captureLayers(new ScreenCapture.LayerCaptureArgs.Builder(surfaceControl).setCaptureSecureLayers(true).setSourceCrop(new Rect(0, 0, q0(i3).getWidth(), q0(i3).getHeight())).setFrameScale(f3, f4).setAllowProtected(true).setPixelFormat(4).build());
            if (captureLayers != null) {
                try {
                    return captureLayers.asBitmap();
                } catch (Exception e3) {
                    Log.e(f10713R0, "failed to getViewSnapShot from ScreenshotHardwareBuffer" + e3);
                }
            }
        }
        return null;
    }

    public boolean F1() {
        return ((this.f10725C0 && this.f10724C.width() > this.f10724C.height()) || ((B1.s.f244a || this.f10730F || B1.s.f245b >= 3) && this.f10741K0.a(B1.f.a(this.f10722B)))) && B1.s.w(((ListView) this).mContext);
    }

    public void F2() {
        ((ListView) this).mContext.getMainThreadHandler().post(new o());
    }

    public void G0(int i3) {
        A2(this.f10736I.M() ? ((ViewGroup) getParent()).getTranslationX() : this.f10783n0, (this.f10736I.M() ? ((ViewGroup) getParent()).getTranslationY() : this.f10785o0) + i3, this.f10736I.M() ? getParentScaleX() : this.f10787p0, 450, 3);
    }

    public boolean G1(int i3) {
        List a02 = B1.l.a0(((ListView) this).mContext, this.f10778l, this.f10766f.n(), this.f10766f.u(), i3);
        if (a02 == null) {
            return false;
        }
        RectF rectF = (RectF) a02.get(a02.size() - 1);
        ViewGroup viewGroup = (ViewGroup) getParent();
        float[] fArr = {viewGroup.getScaleX(), viewGroup.getTranslationX(), viewGroup.getTranslationY()};
        float[] fArr2 = {rectF.right, rectF.left, rectF.top};
        return (c1(fArr, fArr2) || (I1(fArr, fArr2) && i3 == this.f10766f.h())) ? false : true;
    }

    public void G2(int i3) {
        new Thread(new p(i3)).start();
    }

    public boolean H0() {
        com.coui.appcompat.poplist.k kVar = this.f10758V;
        if (kVar == null) {
            return false;
        }
        return kVar.isShowing();
    }

    public boolean H1(MotionEvent motionEvent) {
        return G1(g0((int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
    }

    public void H2() {
        n1(this.f10766f.h());
    }

    public void I0() {
        if (this.f10758V != null) {
            ((ListView) this).mContext.getMainThreadHandler().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.a
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerView.this.o1();
                }
            });
        }
    }

    public void I2(int i3) {
        n1(i3);
    }

    public void J0() {
        EmbeddedViewDecor q02 = q0(getContainerController().n());
        if (q02 == null || q02.getCanvasControlBarManager() == null) {
            return;
        }
        q02.getCanvasControlBarManager().F0();
        q02.getCanvasControlBarManager().I0();
    }

    public void J1(boolean z3) {
        if (z3) {
            this.f10732G.D0(4);
        } else {
            this.f10732G.D0(0);
        }
    }

    public void K0(int i3) {
        EmbeddedViewDecor q02 = q0(i3);
        if (q02 != null) {
            q02.H();
        }
    }

    public void K1() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
            C0601d item = this.f10766f.getItem(i3);
            if (item != null) {
                arrayList.add(item);
            }
        }
        if (arrayList.size() <= 1) {
            Log.w(f10713R0, " while create shortcut data size is invalid!");
        } else {
            this.f10740K.a(arrayList, 0, this.f10766f.n(), this);
        }
    }

    public void L0() {
        M0(-1);
    }

    public void L1() {
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        if (childEmbeddedViewList == null || childEmbeddedViewList.isEmpty()) {
            return;
        }
        Iterator<EmbeddedViewDecor> it = childEmbeddedViewList.iterator();
        while (it.hasNext()) {
            it.next().b0();
        }
    }

    public void M0(int i3) {
        setIsReparentAnim(false);
        for (int i4 = 0; i4 < getChildEmbeddedViewList().size(); i4++) {
            if (i3 == -1 || i3 == i4) {
                q0(i4).I();
            }
        }
    }

    public void M1(MotionEvent motionEvent) {
        if (10 == motionEvent.getAction()) {
            for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
                if (embeddedViewDecor.getCanvasControlBarManager() != null) {
                    embeddedViewDecor.getCanvasControlBarManager().G0();
                }
            }
        }
    }

    public void N0() {
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        try {
            Iterator<EmbeddedViewDecor> it = childEmbeddedViewList.iterator();
            while (it.hasNext()) {
                SurfaceControl J3 = B1.l.J(it.next().getFlexibleTaskView());
                if (J3 != null && J3.isValid()) {
                    transaction.setAlpha(J3, 0.0f);
                }
            }
            transaction.apply();
            transaction.close();
        } catch (Throwable th) {
            try {
                transaction.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void N1(boolean z3) {
        C0601d item;
        r0 r0Var;
        C0600c c0600c = this.f10766f;
        if (c0600c == null || c0600c.getCount() <= 0 || (item = this.f10766f.getItem(0)) == null) {
            return;
        }
        if (z3) {
            int q3 = (!this.f10724C.isEmpty() || (r0Var = this.f10722B) == null) ? -1 : r0Var.q();
            J0();
            d3(q3);
            setNeedUpdateFlexibleTaskViewFrameFlag(true);
            requestLayout();
        }
        if (this.f10736I.M()) {
            if (this.f10736I.L()) {
                this.f10736I.w();
            }
            this.f10736I.p();
        }
        Log.d(f10713R0, "onWindowMetricsBoundsChanged, new=" + item.w() + " old=" + this.f10724C);
        this.f10724C.set(item.w());
    }

    public void O0() {
        if (this.f10729E0 == null) {
            Bitmap decodeResource = B1.s.w(((ListView) this).mContext) ? BitmapFactory.decodeResource(((ListView) this).mContext.getResources(), t1.e.f13396b) : BitmapFactory.decodeResource(((ListView) this).mContext.getResources(), t1.e.f13397c);
            if (decodeResource == null) {
                Log.e(f10713R0, "initCloseBitmapDrawable fail, closeBitmap is null");
                return;
            }
            this.f10729E0 = decodeResource;
        }
        if (m1()) {
            if (this.f10731F0 == null) {
                this.f10731F0 = new BitmapDrawable(((ListView) this).mContext.getResources(), B1.l.v(this.f10729E0, getCloseRect().width(), getCloseRect().height(), 0.0f));
            }
            if (this.f10733G0 == null) {
                this.f10733G0 = new BitmapDrawable(((ListView) this).mContext.getResources(), B1.l.v(this.f10729E0, getCloseRect().width(), getCloseRect().height(), 180.0f));
                return;
            }
            return;
        }
        if (this.f10735H0 == null) {
            this.f10735H0 = new BitmapDrawable(((ListView) this).mContext.getResources(), B1.l.v(this.f10729E0, getCloseRect().width(), getCloseRect().height(), 270.0f));
        }
        if (this.f10737I0 == null) {
            this.f10737I0 = new BitmapDrawable(((ListView) this).mContext.getResources(), B1.l.v(this.f10729E0, getCloseRect().width(), getCloseRect().height(), 90.0f));
        }
    }

    public void O1(Context context) {
        this.f10788q = (int) context.getResources().getDimension(t1.d.f13392u);
        this.f10790r = (int) context.getResources().getDimension(t1.d.f13390s);
    }

    public List P(List list, int i3, float f3, float f4, float f5, float f6) {
        int i4;
        float f7;
        float height;
        float f8;
        float f9;
        float f10;
        y1.u uVar = (y1.u) list.get(0);
        y1.u uVar2 = (y1.u) list.get(1);
        List I3 = this.f10732G.I();
        if (I3.size() == 2 && (i4 = this.f10786p) != 1 && i4 != 3 && (!Z0(uVar.h()) || !Z0(uVar2.h()))) {
            y1.u uVar3 = (y1.u) I3.get(0);
            y1.u uVar4 = (y1.u) I3.get(1);
            Rect insideScreenRect = getInsideScreenRect();
            Rect rect = new Rect(this.f10724C);
            int J02 = B1.l.O1(((ListView) this).mContext).J0();
            int l02 = B1.l.l0(((ListView) this).mContext);
            if (j1()) {
                float width = rect.width();
                float[] fArr = this.f10768g;
                f9 = width - fArr[fArr.length - 2];
                f8 = (rect.width() - l02) / 2.0f;
                height = 0.0f;
                f7 = 0.0f;
            } else {
                float height2 = rect.height();
                float[] fArr2 = this.f10768g;
                f7 = height2 - fArr2[fArr2.length - 2];
                height = ((rect.height() - J02) - l02) / 2.0f;
                f8 = 0.0f;
                f9 = 0.0f;
            }
            if (Z0(uVar.h())) {
                Rect h3 = uVar2.h();
                if (j1()) {
                    if (uVar4.h().width() <= f8) {
                        float[] fArr3 = this.f10768g;
                        f10 = (f8 - f9) * (1.0f - ((f3 - fArr3[fArr3.length - 2]) / (fArr3[fArr3.length - 1] - fArr3[fArr3.length - 2])));
                    } else {
                        f10 = 0.0f;
                    }
                    int i5 = h3.right;
                    if (i5 > insideScreenRect.right) {
                        int i6 = i5 + ((int) (f5 - f10));
                        h3.right = i6;
                        int i7 = insideScreenRect.right;
                        if (i6 < i7) {
                            h3.right = i7;
                        }
                    }
                } else {
                    if (uVar4.h().height() <= height) {
                        float[] fArr4 = this.f10768g;
                        f10 = (height - f7) * (1.0f - ((f4 - fArr4[fArr4.length - 2]) / (fArr4[fArr4.length - 1] - fArr4[fArr4.length - 2])));
                    } else {
                        f10 = 0.0f;
                    }
                    int i8 = h3.bottom;
                    if (i8 > insideScreenRect.bottom) {
                        int i9 = i8 + ((int) (f6 - f10));
                        h3.bottom = i9;
                        int i10 = insideScreenRect.bottom;
                        if (i9 < i10) {
                            h3.bottom = i10;
                        }
                    }
                }
                uVar2.n(h3);
            } else {
                f10 = 0.0f;
            }
            if (Z0(uVar2.h())) {
                Rect h4 = uVar.h();
                if (j1()) {
                    if (uVar3.h().width() <= f8) {
                        float[] fArr5 = this.f10768g;
                        float f11 = fArr5[1];
                        f10 = (f8 - f9) * (1.0f - ((f3 - f11) / (fArr5[0] - f11)));
                    }
                    int i11 = h4.left;
                    if (i11 < insideScreenRect.left) {
                        int i12 = i11 + ((int) (f5 + f10));
                        h4.left = i12;
                        int i13 = insideScreenRect.left;
                        if (i12 > i13) {
                            h4.left = i13;
                        }
                    }
                } else {
                    if (uVar3.h().height() <= height) {
                        float[] fArr6 = this.f10768g;
                        float f12 = fArr6[1];
                        f10 = (height - f7) * (1.0f - ((f4 - f12) / (fArr6[0] - f12)));
                    }
                    int i14 = h4.top;
                    if (i14 < insideScreenRect.top) {
                        int i15 = i14 + ((int) (f6 + f10));
                        h4.top = i15;
                        int i16 = insideScreenRect.top;
                        if (i15 > i16) {
                            h4.top = i16;
                        }
                    }
                }
                uVar.n(h4);
            }
        }
        return list;
    }

    public void P0() {
        B.e eVar = this.f10739J0;
        if (eVar != null && eVar.g()) {
            Log.d(f10713R0, "spring animation on horizontal is running");
            return;
        }
        B.f fVar = new B.f();
        fVar.f(f10718W0).d(f10717V0);
        B.e eVar2 = new B.e(new B.d(0.0f));
        this.f10739J0 = eVar2;
        eVar2.t(fVar);
        this.f10739J0.b(new b.r() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.i
            @Override // B.b.r
            public final void onAnimationUpdate(B.b bVar, float f3, float f4) {
                ContainerView.this.p1(bVar, f3, f4);
            }
        });
        this.f10739J0.k(0.0f);
        this.f10739J0.p(0.0f);
        this.f10739J0.m();
    }

    public void P1() {
        Iterator<EmbeddedViewDecor> it = getChildEmbeddedViewList().iterator();
        while (it.hasNext()) {
            it.next().getFlexibleTaskView().release();
        }
    }

    public void P2() {
        for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
            try {
                FlexibleTaskView flexibleTaskView = embeddedViewDecor.getFlexibleTaskView();
                Method declaredMethod = flexibleTaskView.getClass().getDeclaredMethod("unregisterTaskOrganizer", null);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(flexibleTaskView, null);
            } catch (Exception unused) {
                Log.e(f10713R0, "failed to unregister task organizer for " + embeddedViewDecor);
            }
        }
    }

    public boolean Q() {
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        if (childEmbeddedViewList.size() == 0) {
            return false;
        }
        Iterator<EmbeddedViewDecor> it = childEmbeddedViewList.iterator();
        while (it.hasNext()) {
            if (!it.next().M()) {
                return false;
            }
        }
        return true;
    }

    public void Q1(int i3) {
        EmbeddedViewDecor q02 = q0(i3);
        if (q02 != null) {
            q02.getFlexibleTaskView().release();
        }
    }

    public ContainerActivity Q2(Context context) {
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (ContainerActivity) context;
    }

    public boolean R(int i3) {
        return T(i3, 450, 0, true);
    }

    public boolean R0() {
        return this.f10776k;
    }

    public boolean S(int i3, int i4, int i5) {
        return T(i3, i4, i5, true);
    }

    public boolean S0(int i3) {
        CanvasMaskListView canvasMaskListView = this.f10760a0;
        if (canvasMaskListView == null) {
            return false;
        }
        return canvasMaskListView.u(i3);
    }

    public void S1() {
        try {
            C0600c c0600c = this.f10766f;
            T1(c0600c.getItem(c0600c.h()));
        } catch (IndexOutOfBoundsException unused) {
            Log.e(f10713R0, "focus is invalid");
        }
    }

    public boolean T(int i3, int i4, int i5, boolean z3) {
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        if (i3 < 0 || i3 >= this.f10766f.getCount() || childrenPositionOnScreen.size() != this.f10766f.getCount()) {
            return false;
        }
        List a02 = B1.l.a0(((ListView) this).mContext, this.f10778l, this.f10766f.n(), this.f10766f.u(), i3);
        if (f10719X0.booleanValue()) {
            Log.d(f10713R0, "autoScale mRectList:" + this.f10778l + ",rectFList:" + a02 + " layoutOrientation:" + this.f10766f.n() + " windowMetric:" + getWindowMetricsBounds() + " focus:" + i3);
        }
        if (a02 == null) {
            Log.w(f10713R0, "autoScale rectFList is null");
            return false;
        }
        RectF rectF = (RectF) a02.get(a02.size() - 1);
        if (this.f10766f.n() == 3) {
            if (i3 == 0) {
                this.f10766f.Q(1);
            } else if (i3 == 2) {
                this.f10766f.Q(2);
            }
        }
        this.f10783n0 = rectF.left;
        this.f10785o0 = rectF.top;
        this.f10787p0 = rectF.right;
        if (z3 && i5 != 2) {
            this.f10766f.H(i3);
        }
        if (Q2(((ListView) this).mContext).K0().contains(childrenPositionOnScreen.get(i3)) && Q2(((ListView) this).mContext).S0() && Q2(((ListView) this).mContext).B0() != 0 && this.f10752Q != null && this.f10750P && this.f10762c0 == 3) {
            Log.d(f10713R0, "autoScale target is inside screen no need to auto scale !");
            return false;
        }
        boolean A22 = A2(rectF.left, rectF.top, rectF.right, i4, i5);
        if (A22 && i5 == 1) {
            FlexibleWindowManager.getInstance().setIsInFocusAnimating(true);
        }
        if (A22) {
            I0();
            J0();
        }
        return A22;
    }

    public void T1(final C0601d c0601d) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            u1(c0601d);
        } else {
            ((ListView) this).mContext.getMainThreadHandler().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.g
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerView.this.u1(c0601d);
                }
            });
        }
        FlexibleWindowManager.getInstance().removeEmbeddedContainerTask(c0601d.s(), Q2(((ListView) this).mContext).u0());
    }

    public void T2() {
        U2(true);
    }

    public boolean U(int i3, boolean z3) {
        return T(i3, 450, 0, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002a, code lost:
    
        if (r3 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (r3 == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean U0(int r4, u1.C0601d r5) {
        /*
            r3 = this;
            r4 = r4 & 2
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L8
            r4 = r1
            goto L9
        L8:
            r4 = r0
        L9:
            boolean r2 = B1.s.H()
            if (r2 == 0) goto L2f
            java.lang.String r2 = "com.oplus.wpslauncher"
            java.lang.String r5 = r5.k()
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L27
            u1.c r3 = r3.getAdapter()
            int r3 = r3.t()
            if (r3 != r1) goto L27
            r3 = r1
            goto L28
        L27:
            r3 = r0
        L28:
            if (r4 != 0) goto L2c
            if (r3 == 0) goto L2d
        L2c:
            r0 = r1
        L2d:
            r4 = r0
            goto L4b
        L2f:
            android.content.Context r2 = r3.mContext
            boolean r2 = B1.s.w(r2)
            if (r2 == 0) goto L38
            goto L4b
        L38:
            android.content.Context r3 = r3.mContext
            B1.q r3 = B1.q.d(r3)
            java.lang.String r5 = r5.k()
            boolean r3 = r3.h(r5)
            if (r4 != 0) goto L2c
            if (r3 == 0) goto L2d
            goto L2c
        L4b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.view.ContainerView.U0(int, u1.d):boolean");
    }

    public void U2(boolean z3) {
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        ArrayList arrayList = new ArrayList();
        if (childEmbeddedViewList.size() == 0 || this.f10746N) {
            return;
        }
        for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
            int i4 = 0;
            while (true) {
                if (i4 >= childEmbeddedViewList.size()) {
                    break;
                }
                if (this.f10766f.getItem(i3).equals(childEmbeddedViewList.get(i4).getFlexibleTaskData())) {
                    if (this.f10774j) {
                        childEmbeddedViewList.get(i4).I();
                    }
                    arrayList.add(childEmbeddedViewList.get(i4));
                } else {
                    i4++;
                }
            }
            if (i4 >= childEmbeddedViewList.size()) {
                EmbeddedViewDecor embeddedViewDecor = new EmbeddedViewDecor(getContext());
                if (this.f10774j) {
                    embeddedViewDecor.I();
                }
                arrayList.add(embeddedViewDecor);
            }
        }
        if (childEmbeddedViewList.equals(arrayList)) {
            setEnFocusStartIfNeeded(arrayList);
            return;
        }
        if (arrayList.size() == this.f10766f.getCount()) {
            i0(childEmbeddedViewList);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                ViewGroup.LayoutParams layoutParams = ((EmbeddedViewDecor) arrayList.get(i5)).getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new AbsListView.LayoutParams(this.f10766f.getItem(i5).n().width(), this.f10766f.getItem(i5).n().height());
                }
                if (childEmbeddedViewList.contains(arrayList.get(i5))) {
                    attachViewToParent((View) arrayList.get(i5), i5, layoutParams);
                } else {
                    boolean[] b12 = b1();
                    if (arrayList.get(i5) != null && !this.f10766f.getItem(i5).equals(((EmbeddedViewDecor) arrayList.get(i5)).getFlexibleTaskData())) {
                        Log.d(f10713R0, "replace startFlexibleTaskViewApp: " + this.f10766f.getItem(i5));
                        Rect rect = new Rect(this.f10766f.getItem(i5).n());
                        if (i5 < 2 && b12[i5]) {
                            rect.set(this.f10766f.getItem(i5).i());
                        }
                        ((EmbeddedViewDecor) arrayList.get(i5)).j0(this.f10766f.getItem(i5), rect, this.f10792s);
                    }
                    addViewInLayout((View) arrayList.get(i5), i5, layoutParams);
                }
            }
        }
        R1(childEmbeddedViewList, arrayList, z3);
    }

    public boolean V(int i3, int i4) {
        return T(i3, 450, i4, true);
    }

    public boolean V0(int i3) {
        return (i3 & 4) != 0;
    }

    public void V2(C0601d c0601d, int i3) {
        W2(c0601d, i3, false);
    }

    public boolean W0() {
        return this.f10744M;
    }

    public void W1(int i3) {
        int i4;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean z3;
        ArrayList arrayList;
        y1.u uVar;
        if (i3 < 0 || i3 >= this.f10766f.getCount()) {
            Log.e(f10713R0, "removeTargetFlexibleTask: focus is invalid");
            return;
        }
        List<EmbeddedViewDecor> childEmbeddedViewList = getChildEmbeddedViewList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        C0601d item = this.f10766f.getItem(i3);
        int i5 = 0;
        while (true) {
            i4 = 1;
            if (i5 >= childEmbeddedViewList.size()) {
                break;
            }
            if (item.equals(childEmbeddedViewList.get(i5).getFlexibleTaskData())) {
                childEmbeddedViewList.get(i5).setGonnaVanish(true);
                break;
            }
            i5++;
        }
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        ArrayList arrayList4 = new ArrayList();
        int k3 = this.f10722B.k();
        if (childrenPositionOnScreen.size() != k3) {
            Log.e(f10713R0, "removeTargetFlexibleTask error!!ContainerAdapter count does not match the size of EmbeddedViewDecor");
            return;
        }
        this.f10755S = true;
        Future c3 = C0644a.a().c(this.f10751P0);
        Future c4 = C0644a.a().c(this.f10753Q0);
        Bitmap W3 = B1.l.W(D0(2), 25);
        try {
            bitmap = (Bitmap) c3.get();
        } catch (InterruptedException | ExecutionException e3) {
            Log.e(f10713R0, "getFirstBitmap thread execute failed.. " + e3);
            c3.cancel(true);
            bitmap = null;
        }
        try {
            bitmap2 = (Bitmap) c4.get();
        } catch (InterruptedException | ExecutionException e4) {
            Log.e(f10713R0, "getSecondBitmap thread execute failed.. " + e4);
            c4.cancel(true);
            bitmap2 = null;
        }
        int i6 = 0;
        while (i6 < k3) {
            C0601d l3 = this.f10722B.l(i6);
            if (i6 != 0) {
                arrayList = arrayList3;
                uVar = i6 == i4 ? i3 == i6 ? new y1.u(childrenPositionOnScreen.get(i6), (Intent) null, bitmap2) : new y1.u(childrenPositionOnScreen.get(i6), l3.f(), l3.e(), bitmap2) : i3 == i6 ? new y1.u(childrenPositionOnScreen.get(i6), (Intent) null, W3) : new y1.u(childrenPositionOnScreen.get(i6), l3.f(), l3.e(), W3);
            } else if (i3 == i6) {
                uVar = new y1.u(childrenPositionOnScreen.get(i6), (Intent) null, bitmap);
                arrayList = arrayList3;
            } else {
                arrayList = arrayList3;
                uVar = new y1.u(childrenPositionOnScreen.get(i6), l3.f(), l3.e(), bitmap);
            }
            arrayList2.add(uVar);
            if (l3 != item) {
                arrayList4.add(l3);
            }
            i6++;
            arrayList3 = arrayList;
            i4 = 1;
        }
        ArrayList arrayList5 = arrayList3;
        e3(((ListView) this).mContext, arrayList4, 0);
        List c12 = B1.l.c1(((ListView) this).mContext, arrayList4, 0, false);
        if (B1.s.J(((ListView) this).mContext) && B1.l.u0()) {
            Iterator it = c12.iterator();
            while (it.hasNext()) {
                ((Rect) it.next()).offset(0, B1.l.O1(((ListView) this).mContext).G0());
            }
        }
        Rect rect = childrenPositionOnScreen.get(i3);
        int centerX = rect.centerX();
        int centerY = rect.centerY();
        c12.add(i3, new Rect(centerX - 50, centerY - 50, centerX + 50, centerY + 50));
        int i7 = 0;
        while (i7 < k3) {
            C0601d l4 = getContainerController().l(i7);
            ArrayList arrayList6 = arrayList5;
            arrayList6.add(i3 == i7 ? new y1.u((Rect) c12.get(i7), null) : new y1.u((Rect) c12.get(i7), l4.f(), l4.e()));
            i7++;
            arrayList5 = arrayList6;
        }
        ArrayList arrayList7 = arrayList5;
        Log.d(f10713R0, "removeTargetFlexibleTask#oldRects: " + arrayList2 + ", targetRects: " + arrayList7 + ", indexToRemove: " + i3);
        this.f10766f.setNotifyOnChange(false);
        this.f10766f.V(item);
        try {
            ActivityTaskManager.getService().setFocusedTask(this.f10766f.getItem(0).s());
            this.f10766f.g(0);
        } catch (RemoteException unused) {
            Log.e(f10713R0, "removeTargetFlexibleTask: ATMS set focus, RemoteException");
        }
        this.f10766f.setNotifyOnChange(true);
        int n3 = this.f10766f.n();
        this.f10766f.e();
        setSplitBarVisibility(4);
        this.f10727D0 = true;
        this.f10738J.i0(401);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.flexible.animatingThreeToTwoAnimation", true);
        B1.l.f(bundle);
        if (n3 == 3 && B1.s.I(((ListView) this).mContext)) {
            z3 = false;
            getCanvasMaskManager().f0(((C0601d) arrayList4.get(0)).s());
            getCanvasMaskManager().k0(((C0601d) arrayList4.get(1)).s());
            this.f10738J.g0(-1);
            this.f10738J.j0(-1);
            this.f10738J.h0(true);
        } else {
            z3 = true;
        }
        this.f10738J.v0(arrayList2, arrayList7, A1(600, childrenPositionOnScreen, c12), i3, z3, a2(item), Y1(), Z1());
    }

    public void W2(C0601d c0601d, int i3, boolean z3) {
        r0 r0Var = this.f10722B;
        if (r0Var != null) {
            r0Var.P(c0601d, i3, z3);
        }
    }

    public void X() {
        if (this.f10748O != -1) {
            if (this.f10736I.M()) {
                this.f10722B.F(this.f10748O);
            } else {
                R(this.f10748O);
            }
        }
    }

    public void X1(C0601d c0601d) {
        W1(this.f10766f.getPosition(c0601d));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0039, code lost:
    
        if (r3 != 14) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void X2(y1.u r1, y1.u r2, int r3, int r4) {
        /*
            r0 = this;
            r0.f10805y0 = r4
            r4 = 0
            r2.l(r4)
            r2 = 1
            if (r3 == r2) goto L61
            r2 = 18
            if (r3 == r2) goto L3c
            r2 = 31
            if (r3 == r2) goto L61
            r2 = 38
            if (r3 == r2) goto L3c
            r2 = 41
            if (r3 == r2) goto L61
            r2 = 45
            if (r3 == r2) goto L3c
            r2 = 51
            if (r3 == r2) goto L61
            r2 = 56
            if (r3 == r2) goto L3c
            r2 = 61
            if (r3 == r2) goto L61
            r2 = 68
            if (r3 == r2) goto L3c
            r2 = 6
            if (r3 == r2) goto L3c
            r2 = 7
            if (r3 == r2) goto L61
            r2 = 13
            if (r3 == r2) goto L3c
            r2 = 14
            if (r3 == r2) goto L61
            goto L85
        L3c:
            boolean r2 = r0.m1()
            if (r2 == 0) goto L51
            android.graphics.drawable.BitmapDrawable r2 = r0.f10733G0
            if (r2 == 0) goto L85
            r3 = 48
            r2.setGravity(r3)
            android.graphics.drawable.BitmapDrawable r2 = r0.f10733G0
            r1.l(r2)
            goto L85
        L51:
            android.graphics.drawable.BitmapDrawable r2 = r0.f10737I0
            if (r2 == 0) goto L85
            r3 = 8388611(0x800003, float:1.1754948E-38)
            r2.setGravity(r3)
            android.graphics.drawable.BitmapDrawable r2 = r0.f10737I0
            r1.l(r2)
            goto L85
        L61:
            boolean r2 = r0.m1()
            if (r2 == 0) goto L76
            android.graphics.drawable.BitmapDrawable r2 = r0.f10731F0
            if (r2 == 0) goto L85
            r3 = 80
            r2.setGravity(r3)
            android.graphics.drawable.BitmapDrawable r2 = r0.f10731F0
            r1.l(r2)
            goto L85
        L76:
            android.graphics.drawable.BitmapDrawable r2 = r0.f10735H0
            if (r2 == 0) goto L85
            r3 = 8388613(0x800005, float:1.175495E-38)
            r2.setGravity(r3)
            android.graphics.drawable.BitmapDrawable r2 = r0.f10735H0
            r1.l(r2)
        L85:
            r0.R2()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.view.ContainerView.X2(y1.u, y1.u, int, int):void");
    }

    public float Y(float f3) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        return (float) ((new DecelerateInterpolator(this.f10789q0).getInterpolation(f3) * (-0.2d)) + 1.0d);
    }

    public boolean Y0() {
        return this.f10727D0;
    }

    public boolean Z0(Rect rect) {
        Rect insideScreenRect = getInsideScreenRect();
        insideScreenRect.set(insideScreenRect.left - 1, insideScreenRect.top - 1, insideScreenRect.right + 1, insideScreenRect.bottom + 1);
        return insideScreenRect.contains(rect);
    }

    public void a0() {
        int h3;
        int height;
        int i3;
        int i4;
        List<Rect> list = this.f10773i0;
        if (list.size() == 2 && (h3 = this.f10766f.h()) >= 0 && h3 <= 1) {
            if (h3 == 0) {
                i4 = j1() ? ((Rect) list.get(h3)).left : ((Rect) list.get(h3)).top;
            } else {
                if (j1()) {
                    height = getWindowMetricsBounds().width();
                    i3 = ((Rect) list.get(h3)).right;
                } else {
                    height = getWindowMetricsBounds().height();
                    i3 = ((Rect) list.get(h3)).bottom;
                }
                i4 = height - i3;
            }
            float f3 = 0.0f;
            for (Rect rect : list) {
                f3 = Math.max(f3, ((r5 - (42 - i4)) * 1.0f) / (j1() ? rect.width() : rect.height()));
            }
            if (f3 <= 0.0f || f3 >= 1.0f) {
                return;
            }
            this.f10775j0 = f3;
            Log.d(f10713R0, "calculateScaleByTranslation index=" + h3 + ", distance=" + i4 + ", mTargetScale=" + this.f10775j0);
        }
    }

    public boolean a1() {
        return this.f10799v0;
    }

    public void a3(float f3) {
        this.f10793s0 = f3;
    }

    public List b0(List list, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Rect((Rect) it.next()));
        }
        if (!Float.isNaN(f4) && !Float.isInfinite(f4)) {
            boolean z3 = getContainerController().q() == 1;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (z3) {
                    int i4 = i3 + 1;
                    if (i4 >= arrayList.size() || ((Rect) arrayList.get(i3)).top >= ((Rect) arrayList.get(i4)).top) {
                        ((Rect) arrayList.get(i3)).bottom = (int) (r2.bottom - ((((Rect) arrayList.get(i3)).height() / f3) * (f3 - f4)));
                    } else {
                        ((Rect) arrayList.get(i3)).top = (int) (r2.top + ((((Rect) arrayList.get(i3)).height() / f3) * (f3 - f4)));
                    }
                    float f5 = f3 - f4;
                    ((Rect) arrayList.get(i3)).left = (int) (r2.left + (((((Rect) arrayList.get(i3)).width() / f3) * f5) / 2.0f));
                    ((Rect) arrayList.get(i3)).right = (int) (r2.right - (((((Rect) arrayList.get(i3)).width() / f3) * f5) / 2.0f));
                } else {
                    int i5 = i3 + 1;
                    if (i5 >= arrayList.size() || ((Rect) arrayList.get(i3)).left >= ((Rect) arrayList.get(i5)).left) {
                        ((Rect) arrayList.get(i3)).right = (int) (r2.right - ((((Rect) arrayList.get(i3)).width() / f3) * (f3 - f4)));
                    } else {
                        ((Rect) arrayList.get(i3)).left = (int) (r2.left + ((((Rect) arrayList.get(i3)).width() / f3) * (f3 - f4)));
                    }
                    float f6 = f3 - f4;
                    ((Rect) arrayList.get(i3)).top = (int) (r2.top + (((((Rect) arrayList.get(i3)).height() / f3) * f6) / 2.0f));
                    ((Rect) arrayList.get(i3)).bottom = (int) (r2.bottom - (((((Rect) arrayList.get(i3)).height() / f3) * f6) / 2.0f));
                }
            }
        }
        return arrayList;
    }

    public void b2() {
        int size = getChildEmbeddedViewList().size();
        for (int i3 = 0; i3 < size; i3++) {
            EmbeddedViewDecor q02 = q0(i3);
            q02.setTranslationX(0.0f);
            q02.setTranslationY(0.0f);
            q02.setScaleX(1.0f);
            q02.setScaleY(1.0f);
        }
    }

    public void c3(boolean z3, int i3) {
        Log.d(f10713R0, "updateResizableSplitRect");
        if (z3 && B1.s.I(((ListView) this).mContext)) {
            this.f10766f.M(0);
        }
        b3(z3);
        this.f10722B.f(this.f10793s0, i3);
        this.f10778l.clear();
        this.f10766f.S(z3);
        this.f10766f.notifyDataSetChanged();
        o2();
        this.f10722B.J();
    }

    public boolean d1() {
        return getChildEmbeddedViewList().stream().anyMatch(new Predicate() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.h
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean q12;
                q12 = ContainerView.q1((EmbeddedViewDecor) obj);
                return q12;
            }
        });
    }

    public void d2() {
        if (getChildEmbeddedViewList().size() == 3) {
            Log.d(f10713R0, "resetAllTaskView");
            b2();
        } else {
            Log.d(f10713R0, "resetTwoTaskView");
            f2();
        }
    }

    public void d3(int i3) {
        Log.d(f10713R0, "updateResizableSplitRectsOnly, useRestoreLayoutOrientation: " + i3);
        b3(true);
        this.f10722B.f(this.f10793s0, i3);
        this.f10778l.clear();
        this.f10766f.notifyDataSetChanged();
        o2();
        this.f10722B.J();
    }

    public boolean e1() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
            C0601d item = this.f10766f.getItem(i3);
            if (item != null) {
                arrayList.add(item);
            }
        }
        if (arrayList.size() > 1) {
            return this.f10740K.k(arrayList);
        }
        Log.w(f10713R0, "isSplitPairExists data size is invalid!");
        return false;
    }

    public void e2() {
        this.f10727D0 = false;
    }

    public void e3(Context context, List list, int i3) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0601d c0601d = (C0601d) it.next();
            Intent f3 = c0601d.f();
            f3.putExtra("androidx.activity.LaunchEmbeddedTaskId", c0601d.s());
            f3.putExtra("androidx.flexible.userId", c0601d.v());
            arrayList.add(f3);
        }
        List o02 = B1.l.o0(context, arrayList, i3);
        for (int i4 = 0; i4 < list.size(); i4++) {
            C0601d c0601d2 = (C0601d) list.get(i4);
            C0601d c0601d3 = (C0601d) o02.get(i4);
            c0601d2.g0(c0601d3.p());
            c0601d2.f0(c0601d3.f13810a);
            c0601d2.f13804C.set(c0601d3.f13804C);
            c0601d2.W(c0601d3.i());
            c0601d2.X(c0601d3.j());
            c0601d2.s0(c0601d3.w());
            c0601d2.f13805D = c0601d3.f13805D;
            c0601d2.f13806E = c0601d3.f13806E;
            c0601d2.f13807F = c0601d3.f13807F;
            c0601d2.c0(c0601d3.l());
            c0601d2.U(c0601d3.g());
            c0601d2.V(c0601d3.h());
            if (B1.s.H()) {
                c0601d2.g0(c0601d3.p());
                c0601d2.R(c0601d3.A());
            }
            r0 r0Var = this.f10722B;
            if (r0Var != null) {
                r0Var.h(c0601d2);
            }
        }
    }

    public void f0(int i3) {
        if (this.f10766f.getCount() != 2) {
            Log.e(f10713R0, "changeTwoTaskOrientation failed, task count must be 2");
            return;
        }
        C0601d item = this.f10766f.getItem(0);
        C0601d item2 = this.f10766f.getItem(1);
        if (item == null || item2 == null) {
            return;
        }
        this.f10722B.g();
        ArrayList arrayList = new ArrayList();
        Bitmap p02 = p0(D0(0));
        Bitmap p03 = p0(D0(1));
        arrayList.add(new y1.u(getChildrenPositionOnScreen().get(0), item.f(), item.e(), p02));
        arrayList.add(new y1.u(getChildrenPositionOnScreen().get(1), item2.f(), item2.e(), p03));
        g3(item, i3);
        g3(item2, i3);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(item);
        arrayList2.add(item2);
        List b12 = B1.l.b1(((ListView) this).mContext, arrayList2, this.f10766f.h(), i3, false);
        ArrayList arrayList3 = new ArrayList();
        List z02 = z0(b12, this.f10766f.n(), this.f10766f.h());
        if (z02 == null) {
            return;
        }
        arrayList3.add(new y1.u((Rect) z02.get(0), item.f(), item.e(), p02));
        arrayList3.add(new y1.u((Rect) z02.get(1), item2.f(), item2.e(), p03));
        B1.l.C(new ArrayList(List.of(((y1.u) arrayList3.get(0)).h(), ((y1.u) arrayList3.get(1)).h())), b12);
        this.f10755S = true;
        this.f10756T = true;
        this.f10738J.i0(403);
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.activity.inChangeTwoTaskOrientationAnim", true);
        B1.l.f(bundle);
        setSplitBarVisibility(4);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < 2; i4++) {
            arrayList4.add(((y1.u) arrayList.get(i4)).h());
            arrayList5.add(((y1.u) arrayList3.get(i4)).h());
        }
        this.f10738J.r0(arrayList, arrayList3, A1(OplusSearchHighlightUtils.WAIT_TIME_DEFAULT, arrayList4, arrayList5), e0(i3), c0(), d0());
    }

    public boolean f1() {
        return this.f10797u0;
    }

    public void f2() {
        for (int i3 = 0; i3 <= 1; i3++) {
            EmbeddedViewDecor q02 = q0(i3);
            q02.setX(0.0f);
            q02.setY(0.0f);
            q02.setTranslationX(0.0f);
            q02.setTranslationY(0.0f);
            q02.setScaleX(1.0f);
            q02.setScaleY(1.0f);
        }
    }

    public void f3(List list) {
        int q3 = this.f10722B.q();
        int t3 = B1.l.t(list, this.f10766f.t(), q3);
        boolean z3 = q3 == 3 || t3 == 3;
        if (B1.s.I(((ListView) this).mContext) && this.f10722B.k() == 3 && z3 && this.f10766f.t() == 2) {
            e3(((ListView) this).mContext, list, t3);
        }
    }

    public int g0(int i3, int i4) {
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        for (int i5 = 0; i5 < childrenPositionOnScreen.size(); i5++) {
            if (childrenPositionOnScreen.get(i5).contains(i3, i4)) {
                return i5;
            }
        }
        return -1;
    }

    public void g3(C0601d c0601d, int i3) {
        int i4 = (i3 == 1 || i3 != 2) ? 0 : 1;
        if (E.d0(c0601d)) {
            Intent f3 = c0601d.f();
            f3.putExtra("androidx.flexible.userId", c0601d.v());
            C0601d n02 = B1.l.n0(((ListView) this).mContext, f3, i4);
            if (n02 != null) {
                c0601d.X(n02.j());
                c0601d.f0(n02.f13810a);
                c0601d.W(n02.i());
            }
        }
    }

    public AnimatorSet getAnimatorSet() {
        return this.f10777k0;
    }

    public float getAutoScale() {
        return this.f10787p0;
    }

    public float getAutoTranslationX() {
        return this.f10783n0;
    }

    public float getAutoTranslationY() {
        return this.f10785o0;
    }

    public CanvasMaskListView getCanvasMaskListView() {
        return this.f10760a0;
    }

    public y1.n getCanvasMaskManager() {
        return this.f10738J;
    }

    public EmbeddedViewDecor getChildEmbeddedViewDecorToZoom() {
        return this.f10761b0;
    }

    public List<EmbeddedViewDecor> getChildEmbeddedViewList() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof EmbeddedViewDecor) {
                arrayList.add((EmbeddedViewDecor) childAt);
            }
        }
        return arrayList;
    }

    public List<Rect> getChildrenPositionOnCanvas() {
        ArrayList arrayList = new ArrayList();
        for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
            arrayList.add(new Rect(embeddedViewDecor.getLeft(), embeddedViewDecor.getTop(), embeddedViewDecor.getRight(), embeddedViewDecor.getBottom()));
        }
        return arrayList;
    }

    public List<Rect> getChildrenPositionOnScreen() {
        ArrayList arrayList = new ArrayList();
        for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
            if (this.f10766f.l().contains(embeddedViewDecor.getFlexibleTaskData())) {
                Rect rect = new Rect();
                embeddedViewDecor.getBoundsInWindow(rect, false);
                arrayList.add(rect);
            }
        }
        return arrayList;
    }

    public Rect getCloseRect() {
        int max = Math.max(this.f10724C.height(), this.f10724C.width()) - Q2(((ListView) this).mContext).G0();
        if (m1()) {
            this.f10782n.set(0, 0, this.f10724C.width(), (int) (max * 0.050000012f));
        } else {
            this.f10782n.set(0, 0, (int) (max * 0.050000012f), this.f10724C.height());
        }
        return this.f10782n;
    }

    public r0 getContainerController() {
        return this.f10722B;
    }

    public Rect getContainerGroupRect() {
        return this.f10724C;
    }

    public int getDragModeType() {
        return this.f10786p;
    }

    public float[] getDragModes() {
        return this.f10768g;
    }

    public int[] getDragTargetAction() {
        return this.f10770h;
    }

    public A1.b getFlexibleUiManager() {
        A1.b bVar = this.f10754R;
        if (bVar != null) {
            return bVar;
        }
        ContainerActivity Q22 = Q2(((ListView) this).mContext);
        if (Q22 == null) {
            return this.f10754R;
        }
        A1.b y02 = Q22.y0();
        this.f10754R = y02;
        return y02;
    }

    public float getFraction() {
        return this.f10781m0;
    }

    public boolean getInAutoFocusAnimation() {
        return this.f10750P;
    }

    public int getIndexToEnlarge() {
        return this.f10803x0;
    }

    public int getIndexToMax() {
        return this.f10801w0;
    }

    public Rect getInsideScreenRect() {
        ContainerActivity Q22 = Q2(((ListView) this).mContext);
        int J02 = Q22.J0();
        Rect D02 = Q22.D0();
        Rect rect = this.f10724C;
        int i3 = rect.left;
        int i4 = rect.top + J02;
        int i5 = rect.right;
        int i6 = rect.bottom;
        int i7 = D02.left;
        if (i7 > 0) {
            i3 += i7;
            i5 += i7;
        }
        return new Rect(i3, i4, i5, i6);
    }

    public boolean getIsFirst() {
        return this.f10772i;
    }

    public int getLastDragMode() {
        return this.f10759W;
    }

    public String getLastFirstText() {
        return this.f10804y;
    }

    public String getLastSecondText() {
        return this.f10806z;
    }

    public String getMaskEnlargeText() {
        return this.f10798v;
    }

    public String getMaskFullText() {
        return this.f10796u;
    }

    public String getMaskNarrowText() {
        return this.f10800w;
    }

    public String getMaskPlusText() {
        return this.f10802x;
    }

    public int getNavigationBarHeight() {
        return this.f10726D;
    }

    public List<Rect> getOriginalLocations() {
        return this.f10773i0;
    }

    public A0 getPanoramaModeManager() {
        return this.f10736I;
    }

    public float getParentScaleX() {
        return ((ViewGroup) getParent()).getScaleX();
    }

    public float getParentScaleY() {
        return ((ViewGroup) getParent()).getScaleY();
    }

    public List<Rect> getRectList() {
        return this.f10778l;
    }

    public Rect getRectListUnion() {
        return this.f10780m;
    }

    public float getScaleProgress() {
        return this.f10779l0;
    }

    public Rect getSplitBarRegionForTwoSplitLayout() {
        Rect rect = new Rect();
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        if (childrenPositionOnScreen != null && childrenPositionOnScreen.size() == 2) {
            if (m1()) {
                rect.set(childrenPositionOnScreen.get(0).left, childrenPositionOnScreen.get(0).bottom, childrenPositionOnScreen.get(0).right, childrenPositionOnScreen.get(1).top);
            } else {
                rect.set(childrenPositionOnScreen.get(0).right, childrenPositionOnScreen.get(0).top, childrenPositionOnScreen.get(1).left, childrenPositionOnScreen.get(0).bottom);
            }
        }
        return rect;
    }

    public int getSplitBarVisibility() {
        return this.f10732G.N();
    }

    public int getSplitPadding() {
        return this.f10766f.getCount() == 2 ? this.f10788q : this.f10790r;
    }

    public float getSplitRatio() {
        return this.f10793s0;
    }

    public float getTargetScale() {
        return this.f10775j0;
    }

    public int getTwoSplitCornerRadius() {
        return this.f10792s;
    }

    public int getType() {
        return this.f10762c0;
    }

    public Rect getWindowMetricsBounds() {
        return this.f10724C;
    }

    public boolean h0(int i3, int i4) {
        return g0(i3, i4) == this.f10766f.h();
    }

    public boolean h1() {
        return this.f10743L0;
    }

    public boolean h2(List list, float f3, float f4, float f5, float f6, boolean z3, String str, String str2, boolean z4, boolean z5, boolean z6, boolean z7, Rect rect) {
        boolean z8;
        CanvasMaskListView canvasMaskListView = this.f10760a0;
        if (canvasMaskListView == null || list == null || !canvasMaskListView.u(list.size()) || list.size() != 2) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        y1.u uVar = (y1.u) list.get(0);
        y1.u uVar2 = (y1.u) list.get(1);
        Rect h3 = uVar.h();
        Rect h4 = uVar2.h();
        int i3 = (int) f5;
        int i4 = (int) f6;
        arrayList.add(new y1.u(new Rect(h3.left, h3.top, h3.right + i3, h3.bottom + i4), uVar.e(), uVar.d(), uVar.b(), uVar.f()));
        arrayList.add(new y1.u(new Rect(h4.left + i3, h4.top + i4, h4.right, h4.bottom), uVar2.e(), uVar2.d(), uVar2.b(), uVar2.f()));
        ((y1.u) arrayList.get(0)).m(1.0f);
        ((y1.u) arrayList.get(1)).m(1.0f);
        for (int i5 = 0; i5 < getChildEmbeddedViewList().size(); i5++) {
            EmbeddedViewDecor embeddedViewDecor = getChildEmbeddedViewList().get(i5);
            if (j1()) {
                if (i5 == 0) {
                    embeddedViewDecor.setPivotX(0.0f);
                    embeddedViewDecor.setScaleX((f5 / ((Rect) this.f10773i0.get(0)).width()) + 1.0f);
                } else {
                    embeddedViewDecor.setPivotX(0.0f);
                    embeddedViewDecor.setScaleX(1.0f - (f5 / ((Rect) this.f10773i0.get(1)).width()));
                    embeddedViewDecor.setTranslationX(f5 / getParentScaleX());
                }
            } else if (m1()) {
                if (i5 == 0) {
                    embeddedViewDecor.setPivotY(0.0f);
                    embeddedViewDecor.setScaleY((f6 / ((Rect) this.f10773i0.get(0)).height()) + 1.0f);
                } else {
                    embeddedViewDecor.setPivotY(0.0f);
                    embeddedViewDecor.setScaleY(1.0f - (f6 / ((Rect) this.f10773i0.get(1)).height()));
                    embeddedViewDecor.setTranslationY(f6 / getParentScaleY());
                }
            }
        }
        B1.m b3 = B1.n.a().b(((ListView) this).mContext);
        if (this.f10732G.f10323Q) {
            Z2(arrayList, f3, f4, z3, str, str2, z4, z5);
            z8 = true;
        } else {
            z8 = true;
            b3.a(arrayList, f3, f4, f5, f6, str, str2, z4, z5, z6, z7, rect, this);
        }
        this.f10738J.E0(arrayList);
        return z8;
    }

    public void h3(int i3) {
        x1.s.a(((ListView) this).mContext, i3, true);
    }

    public boolean i1() {
        C0600c c0600c = this.f10766f;
        return c0600c != null && c0600c.getCount() == 3;
    }

    public void i2(List list, float f3, float f4, E.c cVar) {
        CanvasMaskListView canvasMaskListView = this.f10760a0;
        if (canvasMaskListView == null || list == null || !canvasMaskListView.u(list.size()) || list.size() != 3) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        y1.u uVar = (y1.u) list.get(0);
        y1.u uVar2 = (y1.u) list.get(1);
        y1.u uVar3 = (y1.u) list.get(2);
        Rect h3 = uVar.h();
        Rect h4 = uVar2.h();
        Rect h5 = uVar3.h();
        arrayList.add(new y1.u(new Rect(h3), uVar.e(), uVar.d(), uVar.b(), uVar.f()));
        arrayList.add(new y1.u(new Rect(h4), uVar2.e(), uVar2.d(), uVar2.b(), uVar2.f()));
        arrayList.add(new y1.u(new Rect(h5), uVar3.e(), uVar3.d(), uVar3.b(), uVar3.f()));
        ((y1.u) arrayList.get(0)).m(1.0f);
        ((y1.u) arrayList.get(1)).m(1.0f);
        ((y1.u) arrayList.get(2)).m(1.0f);
        B1.n.a().c("DefaultPolicy").e(arrayList, f3, f4, this, cVar);
        this.f10738J.E0(arrayList);
    }

    public void j0() {
        B.e eVar = this.f10739J0;
        if (eVar == null || !eVar.g()) {
            return;
        }
        this.f10739J0.p(1.0f);
        this.f10739J0.u();
    }

    public boolean j1() {
        return this.f10778l.size() == 2 && Math.abs(((Rect) this.f10778l.get(1)).left - ((Rect) this.f10778l.get(0)).right) <= this.f10788q;
    }

    public C2.a j2(C0601d c0601d) {
        return new w(c0601d);
    }

    public boolean k0(E.c cVar) {
        if (this.f10766f == null || this.f10755S) {
            return false;
        }
        this.f10755S = true;
        List B3 = B1.l.B(this.f10778l, cVar.j());
        List i12 = B1.l.i1(B3);
        ArrayList arrayList = new ArrayList();
        Iterator it = i12.iterator();
        while (it.hasNext()) {
            int indexOf = B3.indexOf((Rect) it.next());
            if (indexOf < 0) {
                Log.e(f10713R0, "exchangeTaskView error, wrong order!");
                return false;
            }
            arrayList.add(Integer.valueOf(indexOf));
        }
        setLayerOrder(new SurfaceControl.Transaction());
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.f10778l.size(); i3++) {
            arrayList2.addAll(B2(q0(i3), (Rect) this.f10778l.get(i3), (Rect) B3.get(i3), T0(i3, this.f10766f.h(), this.f10766f.n(), this.f10766f.u(), cVar), l0(i3, this.f10766f.h(), this.f10766f.n(), cVar)));
        }
        this.f10778l = i12;
        int indexOf2 = arrayList.indexOf(Integer.valueOf(this.f10766f.h()));
        animatorSet.playTogether(arrayList2);
        animatorSet.setInterpolator(this.f10764e);
        animatorSet.setDuration(450L);
        animatorSet.addListener(new q(arrayList, cVar, indexOf2));
        animatorSet.start();
        T(indexOf2, 450, 0, false);
        return true;
    }

    public boolean k1() {
        C0600c c0600c = this.f10766f;
        return c0600c != null && c0600c.getCount() == 2;
    }

    public C2.a k2(int i3, int i4, boolean z3) {
        return new v(i3, i4);
    }

    public boolean l1(EmbeddedViewDecor embeddedViewDecor) {
        int indexOf = getChildEmbeddedViewList().indexOf(embeddedViewDecor);
        if (!k1()) {
            return false;
        }
        if (indexOf == 0 || indexOf == 1) {
            return b1()[indexOf];
        }
        return false;
    }

    public C2.a l2() {
        return new x();
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        if (this.f10766f == null) {
            return;
        }
        if (B1.s.q() && B1.s.t(((ListView) this).mContext)) {
            if (Q2(((ListView) this).mContext).Q0()) {
                Log.d(f10713R0, "skip layoutChildren when config is large on device folded");
                return;
            } else if (Q2(((ListView) this).mContext).I0() != -1) {
                Log.d(f10713R0, "skip layoutChildren when switching to fullscreen on device folded");
                Q2(((ListView) this).mContext).N1(-1);
                return;
            }
        }
        if (this.f10766f.w()) {
            Iterator it = this.f10766f.l().iterator();
            while (it.hasNext()) {
                ((C0601d) it.next()).N(true);
            }
        }
        T2();
        for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
            View view = this.f10766f.getView(i3, q0(i3), this);
            if (((AbsListView.LayoutParams) view.getLayoutParams()) == null) {
                addViewInLayout(view, i3, new AbsListView.LayoutParams(this.f10766f.getItem(i3).n().width(), this.f10766f.getItem(i3).n().height()));
            }
        }
        w1();
        if (i1()) {
            for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
                if (embeddedViewDecor.f10862h.R0()) {
                    embeddedViewDecor.f10862h.q1(embeddedViewDecor.getFlexibleTaskView(), embeddedViewDecor.getLaunchRect(), false, false);
                } else {
                    Log.w(f10713R0, "CanvasControlBarManager have not init yet");
                }
            }
        }
        this.f10732G.V();
        List<E.c> H3 = this.f10732G.H();
        V1();
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-2, -2);
        for (E.c cVar : H3) {
            float f3 = (Q2(((ListView) this).mContext) == null || !Q2(((ListView) this).mContext).S0()) ? 1.0f : 0.0f;
            addViewInLayout(cVar.g(), -1, layoutParams);
            this.f10732G.m0(cVar, f3);
            if (this.f10745M0) {
                setSplitBarVisibility(4);
            }
        }
    }

    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void n1(int i3) {
        ArrayList arrayList;
        int i4;
        List<Rect> list;
        ContainerActivity containerActivity;
        boolean z3;
        final int i5 = i3;
        String str = f10713R0;
        Log.d(str, "flexibleTaskToFullScreen, target=" + i5);
        if (i5 < 0 || i5 >= this.f10766f.getCount()) {
            Log.e(str, "target index is out of range");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ContainerActivity Q22 = Q2(((ListView) this).mContext);
        if (Q22 == null || Q22.isFinishing()) {
            Log.e(str, "ContainerActivity lost or finishing");
            return;
        }
        List<Rect> childrenPositionOnScreen = getChildrenPositionOnScreen();
        int k3 = this.f10722B.k();
        if (childrenPositionOnScreen.size() != k3) {
            Log.e(str, "flexibleTaskToFullScreen error!!ContainerAdapter count does not match the size of EmbeddedViewDecor");
            return;
        }
        if (this.f10738J.R()) {
            Log.w(str, "delay to full when canvas mask animating!!!");
            postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.e
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerView.this.n1(i5);
                }
            }, 200L);
            return;
        }
        boolean z4 = true;
        this.f10742L = true;
        Bundle bundle = new Bundle();
        bundle.putBoolean("androidx.activity.isInFullScreenAnimation", this.f10742L);
        B1.l.f(bundle);
        this.f10755S = true;
        if (this.f10736I.M()) {
            Log.d(str, "flexibleTaskToFullScreen  exitPanoramaMode");
            this.f10736I.A(false);
        }
        for (int i6 = 0; i6 < k3; i6++) {
            C0601d l3 = this.f10722B.l(i6);
            arrayList2.add(new y1.u(childrenPositionOnScreen.get(i6), l3.f(), l3.e(), B1.d.f168d ? null : p0(D0(i6))));
        }
        ArrayList arrayList4 = new ArrayList();
        int j3 = B1.s.j(((ListView) this).mContext);
        int h3 = B1.s.h(((ListView) this).mContext);
        for (int i7 = 0; i7 < k3; i7++) {
            if (i7 == i5) {
                arrayList4.add(new Rect(0, 0, j3, h3));
            } else {
                arrayList4.add(new Rect());
            }
        }
        float width = (j3 * 1.0f) / childrenPositionOnScreen.get(i5).width();
        float height = (h3 * 1.0f) / childrenPositionOnScreen.get(i5).height();
        float f3 = -childrenPositionOnScreen.get(i5).left;
        float f4 = -childrenPositionOnScreen.get(i5).top;
        int i8 = 0;
        while (i8 < k3) {
            if (i5 == i8) {
                containerActivity = Q22;
                list = childrenPositionOnScreen;
                arrayList = arrayList2;
                z3 = z4;
            } else {
                int l12 = B1.l.l1(childrenPositionOnScreen.get(i8), childrenPositionOnScreen.get(i5));
                Rect rect = new Rect(childrenPositionOnScreen.get(i8));
                if (l12 != 0) {
                    arrayList = arrayList2;
                    if (l12 == 1) {
                        i4 = childrenPositionOnScreen.get(i5).top - childrenPositionOnScreen.get(i8).bottom;
                        rect.offset(0, i4);
                    } else if (l12 == 2) {
                        int i9 = childrenPositionOnScreen.get(i8).left - childrenPositionOnScreen.get(i5).right;
                        rect.offset(-i9, 0);
                        i4 = i9;
                    } else if (l12 != 3) {
                        i4 = 0;
                    } else {
                        i4 = childrenPositionOnScreen.get(i5).left - childrenPositionOnScreen.get(i8).right;
                        rect.offset(i4, 0);
                    }
                } else {
                    arrayList = arrayList2;
                    int i10 = childrenPositionOnScreen.get(i8).top - childrenPositionOnScreen.get(i5).bottom;
                    rect.offset(0, -i10);
                    i4 = i10;
                }
                list = childrenPositionOnScreen;
                containerActivity = Q22;
                Rect rect2 = new Rect((int) ((rect.left + f3) * width), (int) ((rect.top + f4) * height), (int) ((rect.right + f3) * width), (int) ((rect.bottom + f4) * height));
                if (l12 != 0) {
                    z3 = true;
                    if (l12 == 1) {
                        rect2.offset(0, -i4);
                    } else if (l12 == 2) {
                        rect2.offset(i4, 0);
                    } else if (l12 == 3) {
                        rect2.offset(-i4, 0);
                    }
                } else {
                    z3 = true;
                    rect2.offset(0, i4);
                }
                ((Rect) arrayList4.get(i8)).set(rect2);
            }
            i8++;
            z4 = z3;
            arrayList2 = arrayList;
            childrenPositionOnScreen = list;
            Q22 = containerActivity;
            i5 = i3;
        }
        ContainerActivity containerActivity2 = Q22;
        List<Rect> list2 = childrenPositionOnScreen;
        ArrayList arrayList5 = arrayList2;
        for (int i11 = 0; i11 < k3; i11++) {
            C0601d l4 = this.f10722B.l(i11);
            arrayList3.add(new y1.u((Rect) arrayList4.get(i11), l4.f(), l4.e(), B1.d.f168d ? null : p0(D0(i11))));
        }
        containerActivity2.J1(0);
        containerActivity2.getWindow().setNavigationBarColor(0);
        setSplitBarVisibility(4);
        this.f10738J.i0(402);
        this.f10738J.q0(arrayList5, arrayList3, A1(B1.d.f168d ? 350 : OplusSearchHighlightUtils.WAIT_TIME_DEFAULT, list2, arrayList4), 200L, -1L, L2(containerActivity2, i3, this.f10766f.getItem(i3), this.f10766f.getCount()), J2(containerActivity2, i3, this.f10766f.getItem(i3), this.f10766f.getCount()), K2());
    }

    public boolean m1() {
        return this.f10778l.size() == 2 && Math.abs(((Rect) this.f10778l.get(1)).top - ((Rect) this.f10778l.get(0)).bottom) <= this.f10788q;
    }

    public C2.a m2(int i3, boolean z3) {
        return new a(i3, z3);
    }

    public void n0(C0601d c0601d) {
        int position = this.f10766f.getPosition(c0601d);
        if (position < 0 || position >= this.f10766f.getCount() || this.f10766f.getCount() != 2) {
            return;
        }
        n1(1 - position);
    }

    public C2.a n2(int i3, int i4, boolean z3) {
        return new u(i3);
    }

    public void o2() {
        A1.b flexibleUiManager = getFlexibleUiManager();
        if (flexibleUiManager == null) {
            Log.e(f10713R0, "setBounds null");
            return;
        }
        Rect[] l3 = flexibleUiManager.l();
        for (int i3 = 0; i3 < this.f10766f.getCount(); i3++) {
            Rect rect = new Rect();
            EmbeddedViewDecor q02 = q0(i3);
            if (q02 != null) {
                q02.getBoundsOnScreen(rect);
                l3[i3] = rect;
            }
        }
        flexibleUiManager.I(this.f10766f.getCount());
    }

    public void offsetChildrenTopAndBottom(int i3) {
        if (i3 != 0) {
            View childAt = getChildAt(0);
            D1("offsetChildrenTopAndBottom offset=" + i3 + " firstVisiblePosition=" + getFirstVisiblePosition() + " child0Top=" + (childAt != null ? childAt.getTop() : Integer.MIN_VALUE) + " scroll=(" + getScrollX() + "," + getScrollY() + ")");
        }
        super.offsetChildrenTopAndBottom(i3);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f10749O0 = true;
        if (this.f10766f == null) {
            return;
        }
        getContext().getMainThreadHandler().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.c
            @Override // java.lang.Runnable
            public final void run() {
                ContainerView.this.r1();
            }
        });
    }

    @Override // android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        int action = dragEvent.getAction();
        if (action == 1) {
            this.f10744M = true;
            if (getContainerController() != null) {
                this.f10748O = getContainerController().n();
            }
        } else if (action == 4) {
            this.f10744M = false;
        }
        return true;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 7 || motionEvent.getAction() == 9 || motionEvent.getAction() == 8) {
            return false;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        Rect rect = this.f10784o;
        boolean z4 = (rect.left == i3 && rect.top == i4 && rect.right == i5 && rect.bottom == i6) ? false : true;
        rect.set(i3, i4, i5, i6);
        if (z4) {
            I0();
        }
        super.onLayout(z3, i3, i4, i5, i6);
        for (EmbeddedViewDecor embeddedViewDecor : getChildEmbeddedViewList()) {
            embeddedViewDecor.setViewTranslationX(0.0f);
            embeddedViewDecor.setViewTranslationY(0.0f);
        }
        int h3 = this.f10766f.h() > 0 ? this.f10766f.h() : 0;
        if (this.f10766f.u() == 0 && this.f10766f.n() == 3) {
            if (h3 == 2) {
                this.f10766f.Q(2);
            } else {
                this.f10766f.Q(1);
            }
        }
        S2();
        if (this.f10736I.M()) {
            this.f10736I.p();
            if (Q2(((ListView) this).mContext).f10256h0) {
                this.f10736I.f0(((ListView) this).mContext);
                Q2(((ListView) this).mContext).f10256h0 = false;
            }
        } else {
            T(h3, 0, 0, true);
        }
        for (int i7 = 0; i7 < this.f10722B.k(); i7++) {
            Log.d(f10713R0, "onLayout: " + z4 + " " + this.f10722B.l(i7));
        }
        if (this.f10732G.y0()) {
            this.f10732G.H0();
        }
        if (this.f10749O0) {
            s2();
            this.f10749O0 = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        ((ViewGroup.MarginLayoutParams) getLayoutParams()).topMargin = Q2(getContext()).G0();
        if (Q2(getContext()).D0().left > 0) {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).leftMargin = Math.abs(Q2(getContext()).D0().width());
        } else {
            ((ViewGroup.MarginLayoutParams) getLayoutParams()).leftMargin = 0;
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i4));
        if (this.f10766f.getCount() > 0 && this.f10724C.isEmpty()) {
            this.f10724C.set(this.f10766f.getItem(0).w());
        }
        if (this.f10772i) {
            this.f10772i = false;
            ?? r3 = this;
            while (r3.getParent() != null && (r3.getParent() instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) r3.getParent();
                viewGroup.setClipChildren(false);
                r3 = viewGroup;
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public Bitmap p0(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return GaussianBlur.getInstance().generateGaussianBitmap(bitmap.copy(Bitmap.Config.RGB_565, true), 25.0f, true);
    }

    public void p2(y1.n nVar, CanvasMaskListView canvasMaskListView) {
        this.f10738J = nVar;
        this.f10760a0 = canvasMaskListView;
    }

    public EmbeddedViewDecor q0(int i3) {
        int i4 = -1;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if ((childAt instanceof EmbeddedViewDecor) && (i4 = i4 + 1) == i3) {
                return (EmbeddedViewDecor) childAt;
            }
        }
        return null;
    }

    public EmbeddedViewDecor q2(EmbeddedViewDecor embeddedViewDecor) {
        this.f10761b0 = embeddedViewDecor;
        return embeddedViewDecor;
    }

    public EmbeddedViewDecor r0(int i3, C0601d c0601d) {
        if (c0601d == null) {
            return q0(i3);
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if (childAt instanceof EmbeddedViewDecor) {
                EmbeddedViewDecor embeddedViewDecor = (EmbeddedViewDecor) childAt;
                if (embeddedViewDecor.getTaskData().equals(c0601d)) {
                    return embeddedViewDecor;
                }
            }
        }
        return null;
    }

    public void r2() {
        if (B1.s.w(((ListView) this).mContext)) {
            this.f10791r0 = 30.0f;
        } else {
            this.f10791r0 = 40.0f;
        }
    }

    public void s2() {
        Iterator<EmbeddedViewDecor> it = getChildEmbeddedViewList().iterator();
        while (it.hasNext()) {
            it.next().d0();
        }
    }

    public void setAdapter(C0600c c0600c) {
        this.f10766f = c0600c;
        super.setAdapter((ListAdapter) c0600c);
        this.f10766f.notifyDataSetChanged();
    }

    public void setAnimatorSet(AnimatorSet animatorSet) {
        this.f10777k0 = animatorSet;
    }

    public void setConfigHelper(C0609a c0609a) {
        this.f10741K0 = c0609a;
    }

    public void setContainerController(r0 r0Var) {
        this.f10722B = r0Var;
    }

    public void setControlBarVisibility(int i3) {
        Iterator<EmbeddedViewDecor> it = getChildEmbeddedViewList().iterator();
        while (it.hasNext()) {
            it.next().setControlBarVisibility(i3);
        }
    }

    public void setCurrentPopWindow(com.coui.appcompat.poplist.k kVar) {
        this.f10758V = kVar;
    }

    public void setDragModeType(int i3) {
        this.f10786p = i3;
    }

    public void setDragModes(float[] fArr) {
        this.f10768g = fArr;
    }

    public void setDragTargetAction(int[] iArr) {
        this.f10770h = iArr;
    }

    public void setDuringTransform(boolean z3) {
        this.f10755S = z3;
    }

    public void setFraction(float f3) {
        this.f10781m0 = f3;
    }

    public void setIndexToEnlarge(int i3) {
        this.f10803x0 = i3;
    }

    public void setIndexToMax(int i3) {
        this.f10801w0 = i3;
    }

    public void setIsCancelSplitBarScroll(boolean z3) {
        this.f10776k = z3;
    }

    public void setIsGestureNavMode(boolean z3) {
        if (this.f10728E != z3) {
            this.f10728E = z3;
            requestLayout();
        }
    }

    public void setIsRebound(boolean z3) {
        this.f10799v0 = z3;
    }

    public void setIsReparentAnim(boolean z3) {
        Log.d(f10713R0, " setIsReparentAnim " + z3);
        this.f10774j = z3;
    }

    public void setIsSpringBack(boolean z3) {
        this.f10797u0 = z3;
    }

    public void setIsSwitchToZoomAnim(boolean z3) {
        this.f10743L0 = z3;
    }

    public void setIsToFlexibleAnimating(boolean z3) {
        this.f10745M0 = z3;
    }

    public void setLastDragMode(int i3) {
        this.f10759W = i3;
    }

    public void setLastFirstText(String str) {
        this.f10804y = str;
    }

    public void setLastSecondText(String str) {
        this.f10806z = str;
    }

    public void setMaskScaleInParameter(float f3) {
        this.f10789q0 = f3;
    }

    public void setMenuAction(String str) {
        this.f10747N0 = str;
    }

    public void setNeedUpdateFlexibleTaskViewFrameFlag(boolean z3) {
        this.f10749O0 = z3;
    }

    public void setOriginalLocations(List<Rect> list) {
        this.f10773i0 = list;
    }

    public void setPanoramaModeController(A0 a02) {
        this.f10736I = a02;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public void setSelection(int i3) {
    }

    public void setSplitBarVisibility(int i3) {
        this.f10732G.D0(i3);
    }

    public void setTargetScale(float f3) {
        this.f10775j0 = f3;
    }

    public int t0(C0601d c0601d) {
        return B1.l.g0(this, c0601d, ((ListView) this).mContext);
    }

    public void t2() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if (childAt instanceof EmbeddedViewDecor) {
                ((EmbeddedViewDecor) childAt).setInitialized(false);
            }
        }
    }

    @Override // android.view.View
    public String toString() {
        return super.toString() + ",getTranslationX():" + getTranslationX() + ",getTranslationY():" + getTranslationY() + ",getScaleX():" + getScaleX() + ",getScaleY():" + getScaleY();
    }

    public int u0(boolean z3, float f3, float f4) {
        int i3 = 0;
        switch (this.f10786p) {
            case 2:
                i3 = 6;
                break;
            case 3:
                i3 = 13;
                break;
            case 4:
                i3 = 30;
                break;
            case 5:
                i3 = 40;
                break;
            case 6:
                i3 = 50;
                break;
            case 7:
                i3 = 60;
                break;
        }
        int binarySearch = z3 ? Arrays.binarySearch(this.f10768g, f3) : Arrays.binarySearch(this.f10768g, f4);
        return (binarySearch < 0 ? -binarySearch : binarySearch + 1) + i3;
    }

    public void u2() {
        int i3 = this.f10803x0;
        if (i3 >= 0 && i3 <= 1) {
            if (this.f10766f.getItem(i3) != null) {
                this.f10766f.getItem(this.f10803x0).T(true);
            }
            if (this.f10766f.getItem(1 - this.f10803x0) != null) {
                this.f10766f.getItem(1 - this.f10803x0).T(true);
            }
        }
        int i4 = this.f10801w0;
        if (i4 < 0 || i4 > 1 || this.f10766f.getItem(i4) == null) {
            return;
        }
        this.f10766f.getItem(this.f10801w0).T(true);
    }

    public int v0(float f3) {
        if (this.f10768g == null) {
            Log.d(f10713R0, "getDragModeInThreeSplit mDragModes is null");
        }
        int binarySearch = Arrays.binarySearch(this.f10768g, f3);
        return (binarySearch < 0 ? -binarySearch : binarySearch + 1) + 100;
    }

    public Bitmap w0(int i3, Rect rect) {
        EmbeddedViewDecor q02;
        SurfaceControl surfaceControl;
        if (rect == null || rect.isEmpty() || (q02 = q0(i3)) == null) {
            return null;
        }
        int width = q02.getWidth();
        int height = q02.getHeight();
        if (width == 0 || height == 0 || q02.getFlexibleTaskView() == null || (surfaceControl = q02.getFlexibleTaskView().getSurfaceControl()) == null) {
            return null;
        }
        ScreenCapture.ScreenshotHardwareBuffer captureLayers = ScreenCapture.captureLayers(new ScreenCapture.LayerCaptureArgs.Builder(surfaceControl).setCaptureSecureLayers(true).setSourceCrop(new Rect(0, 0, width, height)).setPixelFormat(4).setFrameScale(rect.width() / width, rect.height() / height).setAllowProtected(true).build());
        if (captureLayers == null) {
            return null;
        }
        try {
            return captureLayers.asBitmap();
        } catch (Exception e3) {
            Log.e(f10713R0, "failed to getViewSnapShot from ScreenshotHardwareBuffer" + e3);
            return null;
        }
    }

    public void w2(int i3, boolean z3) {
        this.f10726D = i3;
        if (z3) {
            N1(true);
        }
    }

    public void x1(int i3, View view, float f3) {
        if (Float.isNaN(f3) || Float.isInfinite(f3)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, f3);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, f3);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(i3);
        animatorSet.setInterpolator(new Y.e());
        ((ListView) this).mContext.getMainThreadHandler().post(new y1.h(animatorSet));
    }

    public void x2(int i3, int i4) {
        EmbeddedViewDecor q02 = q0(i3);
        if (q02 == null || q02.getFlexibleTaskView() == null) {
            return;
        }
        q02.getFlexibleTaskView().setVisibility(i4);
    }

    public void y1() {
        z1(-1);
    }

    public boolean y2() {
        if (B1.l.N0(this) && this.f10766f.w()) {
            return true;
        }
        C0601d item = this.f10766f.getItem(this.f10766f.h());
        if (item != null && j1() && this.f10766f.w()) {
            return (item.n().equals(item.f13818i) || item.n().equals(item.f13810a)) ? false : true;
        }
        if (item == null || !m1() || B1.l.N0(this)) {
            return false;
        }
        return !item.y() && ActivityInfo.isFixedOrientationLandscape(item.j());
    }

    public List z0(List list, int i3, int i4) {
        List a02 = B1.l.a0(((ListView) this).mContext, list, i3, this.f10766f.u(), i4);
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < list.size(); i5++) {
            arrayList.add(new Rect((int) ((RectF) a02.get(i5)).left, (int) ((RectF) a02.get(i5)).top, (int) ((RectF) a02.get(i5)).right, (int) ((RectF) a02.get(i5)).bottom));
        }
        return arrayList;
    }

    public void z1(int i3) {
        setIsReparentAnim(true);
        for (int i4 = 0; i4 < getChildEmbeddedViewList().size(); i4++) {
            if (i3 == -1 || i3 == i4) {
                q0(i4).V();
            }
        }
    }

    public void z2(long j3) {
        for (int i3 = 0; i3 < getChildEmbeddedViewList().size(); i3++) {
            q0(i3).g0(j3);
        }
    }

    public ContainerView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ContainerView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f10764e = new Y.e();
        this.f10772i = true;
        this.f10774j = false;
        this.f10776k = false;
        this.f10778l = new ArrayList();
        this.f10780m = new Rect();
        this.f10782n = new Rect();
        this.f10784o = new Rect();
        this.f10724C = new Rect();
        this.f10734H = -1;
        this.f10742L = false;
        this.f10744M = false;
        this.f10746N = false;
        this.f10748O = -1;
        this.f10762c0 = -1;
        this.f10763d0 = 1;
        this.f10765e0 = 40.0f;
        this.f10767f0 = 0.8f;
        this.f10769g0 = 0.8f;
        this.f10771h0 = 0.1f;
        this.f10773i0 = new ArrayList();
        this.f10775j0 = 0.95f;
        this.f10781m0 = 0.0f;
        this.f10783n0 = 0.0f;
        this.f10785o0 = 0.0f;
        this.f10787p0 = 1.0f;
        this.f10789q0 = 2.0f;
        this.f10791r0 = 30.0f;
        this.f10793s0 = 0.0f;
        this.f10797u0 = false;
        this.f10799v0 = false;
        this.f10801w0 = -1;
        this.f10803x0 = -1;
        this.f10805y0 = -1;
        this.f10725C0 = false;
        this.f10727D0 = false;
        this.f10743L0 = false;
        this.f10751P0 = new i();
        this.f10753Q0 = new j();
        setClipChildren(false);
        this.f10788q = (int) context.getResources().getDimension(t1.d.f13392u);
        this.f10790r = (int) context.getResources().getDimension(t1.d.f13390s);
        this.f10792s = (int) context.getResources().getDimension(t1.d.f13391t);
        this.f10794t = (int) context.getResources().getDimension(t1.d.f13389r);
        this.f10796u = ((ListView) this).mContext.getResources().getString(t1.j.f13628a0);
        this.f10798v = ((ListView) this).mContext.getResources().getString(t1.j.f13626Z);
        this.f10800w = ((ListView) this).mContext.getResources().getString(t1.j.f13630b0);
        this.f10802x = ((ListView) this).mContext.getResources().getString(t1.j.f13641h);
        this.f10732G = new E(((ListView) this).mContext, this);
        Activity o02 = o0(this);
        if (o02 != null) {
            this.f10734H = o02.getTaskId();
        }
        this.f10740K = new C1.a(context);
        this.f10755S = false;
        this.f10730F = B1.s.K(((ListView) this).mContext);
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter2() {
        return this.f10766f;
    }
}
