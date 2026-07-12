package y1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.pscanvas.canvasmode.canvas.mask.CanvasMaskListView;
import com.oplus.pscanvas.canvasmode.canvas.r0;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import q2.AbstractC0544n;
import u1.C0599b;
import u1.C0601d;
import w1.C0622f;
import y1.C0644a;
import y1.n;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: v, reason: collision with root package name */
    public static final a f14544v = new a(null);

    /* renamed from: w, reason: collision with root package name */
    private static final String f14545w = n.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private Context f14546a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f14547b;

    /* renamed from: c, reason: collision with root package name */
    private ContainerView f14548c;

    /* renamed from: d, reason: collision with root package name */
    private CanvasMaskListView f14549d;

    /* renamed from: e, reason: collision with root package name */
    private long f14550e;

    /* renamed from: f, reason: collision with root package name */
    private final Map f14551f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14552g;

    /* renamed from: h, reason: collision with root package name */
    private final List f14553h;

    /* renamed from: i, reason: collision with root package name */
    private int f14554i;

    /* renamed from: j, reason: collision with root package name */
    private int f14555j;

    /* renamed from: k, reason: collision with root package name */
    private int f14556k;

    /* renamed from: l, reason: collision with root package name */
    private int f14557l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f14558m;

    /* renamed from: n, reason: collision with root package name */
    private b f14559n;

    /* renamed from: o, reason: collision with root package name */
    private C0601d f14560o;

    /* renamed from: p, reason: collision with root package name */
    private C0601d f14561p;

    /* renamed from: q, reason: collision with root package name */
    private C0601d f14562q;

    /* renamed from: r, reason: collision with root package name */
    private int f14563r;

    /* renamed from: s, reason: collision with root package name */
    private c f14564s;

    /* renamed from: t, reason: collision with root package name */
    private int f14565t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f14566u;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final String a() {
            return n.f14545w;
        }

        private a() {
        }
    }

    public final class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final long f14567e;

        /* renamed from: f, reason: collision with root package name */
        private final int f14568f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f14569g;

        /* renamed from: h, reason: collision with root package name */
        private final C2.a f14570h;

        /* renamed from: i, reason: collision with root package name */
        private final long f14571i;

        /* renamed from: j, reason: collision with root package name */
        private final C2.a f14572j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ n f14573k;

        public b(n nVar, long j3, int i3, boolean z3, C2.a aVar, long j4, C2.a aVar2) {
            D2.k.e(aVar, "mOnMaskHide");
            this.f14573k = nVar;
            this.f14567e = j3;
            this.f14568f = i3;
            this.f14569g = z3;
            this.f14570h = aVar;
            this.f14571i = j4;
            this.f14572j = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14573k.f14559n = null;
            C2.a aVar = this.f14572j;
            if (aVar != null) {
            }
            this.f14573k.x(this.f14567e, this.f14568f, this.f14569g, this.f14570h, this.f14571i);
        }
    }

    public final class c implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        private final long f14574e;

        /* renamed from: f, reason: collision with root package name */
        private final C2.a f14575f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f14576g;

        static final class a extends D2.l implements C2.a {
            a() {
                super(0);
            }

            public final void a() {
                D2.k.b(c.this.f14575f.invoke());
            }

            @Override // C2.a
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return p2.q.f12810a;
            }
        }

        public c(n nVar, long j3, C2.a aVar) {
            D2.k.e(aVar, "mOnMaskHide");
            this.f14576g = nVar;
            this.f14574e = j3;
            this.f14575f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14576g.f14564s = null;
            this.f14576g.P(this.f14574e, new a());
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f14578a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f14579b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f14580c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ C2.a f14581d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f14582e;

        d(boolean z3, long j3, n nVar, C2.a aVar, long j4) {
            this.f14578a = z3;
            this.f14579b = j3;
            this.f14580c = nVar;
            this.f14581d = aVar;
            this.f14582e = j4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(n nVar) {
            D2.k.e(nVar, "this$0");
            ContainerView containerView = nVar.f14548c;
            D2.k.b(containerView);
            containerView.z2(0L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            D2.k.e(animator, "animation");
            Log.d(n.f14544v.a(), "animOldRectToNewRectEnd onAnimationCancel");
            this.f14581d.invoke();
            ContainerView containerView = this.f14580c.f14548c;
            D2.k.b(containerView);
            containerView.B1();
            CanvasMaskListView canvasMaskListView = this.f14580c.f14549d;
            D2.k.b(canvasMaskListView);
            canvasMaskListView.n(this.f14582e);
            this.f14580c.f14558m = false;
            this.f14580c.a0();
            ContainerView containerView2 = this.f14580c.f14548c;
            D2.k.b(containerView2);
            containerView2.e2();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            D2.k.e(animator, "animation");
            Log.d(n.f14544v.a(), "animOldRectToNewRectEnd onAnimationEnd");
            this.f14581d.invoke();
            ContainerView containerView = this.f14580c.f14548c;
            D2.k.b(containerView);
            containerView.B1();
            CanvasMaskListView canvasMaskListView = this.f14580c.f14549d;
            D2.k.b(canvasMaskListView);
            canvasMaskListView.n(this.f14582e);
            this.f14580c.f14558m = false;
            this.f14580c.a0();
            ContainerView containerView2 = this.f14580c.f14548c;
            D2.k.b(containerView2);
            containerView2.e2();
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.flexible.animatingThreeToTwoAnimation", false);
            bundle.putBoolean("androidx.activity.isInFullScreenAnimation", false);
            this.f14580c.f14565t = 0;
            B1.l.f(bundle);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            D2.k.e(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            D2.k.e(animator, "animation");
            Log.d(n.f14544v.a(), "animOldRectToNewRectEnd onAnimationStart, isRemoveAnim = " + this.f14578a + " maskAlphaDuration=" + this.f14579b + " mMaskAnimationType=" + this.f14580c.f14565t + " mIsMagicWindow=" + this.f14580c.f14552g);
            if (!this.f14578a) {
                ContainerView containerView = this.f14580c.f14548c;
                D2.k.b(containerView);
                containerView.z2(0L);
            } else {
                long j3 = this.f14580c.f14565t == 401 ? 600L : 500L;
                C0644a.ExecutorC0159a executorC0159a = C0644a.a().f14500a;
                final n nVar = this.f14580c;
                executorC0159a.b(new Runnable() { // from class: y1.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.d.b(n.this);
                    }
                }, j3);
            }
        }
    }

    static final class e extends D2.l implements C2.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f14584f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j3) {
            super(0);
            this.f14584f = j3;
        }

        public final void a() {
            ContainerView containerView = n.this.f14548c;
            D2.k.b(containerView);
            containerView.z2(50L);
            CanvasMaskListView canvasMaskListView = n.this.f14549d;
            D2.k.b(canvasMaskListView);
            canvasMaskListView.r(this.f14584f, false);
        }

        @Override // C2.a
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return p2.q.f12810a;
        }
    }

    public static final class f implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f14585a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f14586b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f14587c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f14588d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ C2.a f14589e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ C2.a f14590f;

        static final class a extends D2.l implements C2.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ C2.a f14591e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C2.a aVar) {
                super(0);
                this.f14591e = aVar;
            }

            public final void a() {
                D2.k.b(this.f14591e.invoke());
            }

            @Override // C2.a
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return p2.q.f12810a;
            }
        }

        static final class b extends D2.l implements C2.a {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ C2.a f14592e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(C2.a aVar) {
                super(0);
                this.f14592e = aVar;
            }

            public final void a() {
                D2.k.b(this.f14592e.invoke());
            }

            @Override // C2.a
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return p2.q.f12810a;
            }
        }

        f(long j3, long j4, n nVar, List list, C2.a aVar, C2.a aVar2) {
            this.f14585a = j3;
            this.f14586b = j4;
            this.f14587c = nVar;
            this.f14588d = list;
            this.f14589e = aVar;
            this.f14590f = aVar2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(n nVar, long j3, C2.a aVar) {
            D2.k.e(nVar, "this$0");
            D2.k.e(aVar, "$onMaskHide");
            nVar.P(j3, new a(aVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(n nVar, long j3, C2.a aVar) {
            D2.k.e(nVar, "this$0");
            D2.k.e(aVar, "$onMaskHide");
            nVar.P(j3, new b(aVar));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            D2.k.e(animator, "animation");
            Log.d(n.f14544v.a(), "makeMaskViewSpringBack onAnimationCancel");
            D2.k.b(this.f14589e.invoke());
            C0644a.ExecutorC0159a b3 = C0644a.a().b();
            final n nVar = this.f14587c;
            final long j3 = this.f14586b;
            final C2.a aVar = this.f14590f;
            b3.b(new Runnable() { // from class: y1.q
                @Override // java.lang.Runnable
                public final void run() {
                    n.f.c(n.this, j3, aVar);
                }
            }, 100L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            D2.k.e(animator, "animation");
            ContainerView containerView = this.f14587c.f14548c;
            D2.k.b(containerView);
            boolean z3 = (containerView.f1() || B1.l.P0(this.f14587c.f14548c)) ? false : true;
            a aVar = n.f14544v;
            Log.d(aVar.a(), "makeMaskViewSpringBack onAnimationEnd, hideMaskViewList until window has drawn? " + z3);
            if (this.f14588d.size() == 2) {
                B1.l.u1(this.f14587c.f14548c, 20110, false);
            }
            B1.g.h(this.f14587c.f14546a, 406);
            D2.k.b(this.f14589e.invoke());
            ContainerView containerView2 = this.f14587c.f14548c;
            if (containerView2 != null) {
                containerView2.s2();
            }
            this.f14587c.f14557l = -1;
            this.f14587c.f14563r = -1;
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.flexible.animatingScrollSplitBarAnimation", false);
            B1.l.f(bundle);
            if (z3) {
                Log.d(aVar.a(), "makeMaskViewSpringBack window not redrawn, hideMaskViewList now");
                n nVar = this.f14587c;
                nVar.f14564s = new c(nVar, this.f14586b, this.f14590f);
                C0644a.a().b().b(this.f14587c.f14564s, 1500L);
                return;
            }
            C0644a.ExecutorC0159a b3 = C0644a.a().b();
            final n nVar2 = this.f14587c;
            final long j3 = this.f14586b;
            final C2.a aVar2 = this.f14590f;
            b3.b(new Runnable() { // from class: y1.p
                @Override // java.lang.Runnable
                public final void run() {
                    n.f.d(n.this, j3, aVar2);
                }
            }, 100L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            D2.k.e(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            D2.k.e(animator, "animation");
            Log.d(n.f14544v.a(), "makeMaskViewSpringBack onAnimationStart ,animBackDuration=" + this.f14585a + ", animHideAlphaDuration=" + this.f14586b);
        }
    }

    public static final class g implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C2.a f14594b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f14595c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f14596d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f14597e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f14598f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ C2.a f14599g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f14600h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f14601i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ C2.a f14602j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ int f14603k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f14604l;

        g(C2.a aVar, boolean z3, boolean z4, int i3, long j3, C2.a aVar2, long j4, int i4, C2.a aVar3, int i5, boolean z5) {
            this.f14594b = aVar;
            this.f14595c = z3;
            this.f14596d = z4;
            this.f14597e = i3;
            this.f14598f = j3;
            this.f14599g = aVar2;
            this.f14600h = j4;
            this.f14601i = i4;
            this.f14602j = aVar3;
            this.f14603k = i5;
            this.f14604l = z5;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            D2.k.e(animator, "animation");
            Log.d(n.f14544v.a(), "startAnimOldRectToNewRect onAnimationCancel");
            this.f14594b.invoke();
            this.f14602j.invoke();
            n.this.x(this.f14598f, this.f14597e, this.f14595c, this.f14599g, this.f14600h);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            D2.k.e(animator, "animation");
            B1.l.u1(n.this.f14549d, 20110, false);
            B1.g.h(n.this.f14546a, n.this.f14565t);
            Log.d(n.f14544v.a(), " startAnimOldRectToNewRect onAnimationEnd, isRemoveAnim = " + this.f14595c + "  mChangeRectTaskId = " + n.this.f14554i + ", mHasDrawnTaskId = " + n.this.f14557l);
            ContainerView containerView = n.this.f14548c;
            D2.k.b(containerView);
            containerView.M0(this.f14601i);
            C0622f k3 = C0622f.k(n.this.f14546a);
            ContainerView containerView2 = n.this.f14548c;
            D2.k.b(containerView2);
            int u02 = containerView2.Q2(n.this.f14546a).u0();
            ContainerView containerView3 = n.this.f14548c;
            D2.k.b(containerView3);
            r0 containerController = containerView3.getContainerController();
            ContainerView containerView4 = n.this.f14548c;
            D2.k.b(containerView4);
            k3.D(u02, containerController, containerView4.getPanoramaModeManager().M(), true);
            this.f14594b.invoke();
            n.this.v(this.f14598f, this.f14597e, this.f14595c, this.f14602j, this.f14599g, this.f14600h, this.f14603k, this.f14604l);
            if (n.this.f14565t != 404) {
                n.this.f14565t = 0;
            }
            ContainerView containerView5 = n.this.f14548c;
            D2.k.b(containerView5);
            containerView5.setSplitBarVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            D2.k.e(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ContainerView containerView;
            D2.k.e(animator, "animation");
            B1.l.u1(n.this.f14549d, 20110, true);
            if (n.this.f14565t == 404) {
                this.f14594b.invoke();
            }
            B1.g.c(n.this.f14546a, n.this.f14565t);
            Log.d(n.f14544v.a(), " startAnimOldRectToNewRect onAnimationStart, isRemoveAnim = " + this.f14595c + " mMaskAnimationType=" + n.this.f14565t + " isSystemAnimating=" + this.f14596d);
            if (n.this.f14565t == 401 || n.this.f14565t == 402) {
                ContainerView containerView2 = n.this.f14548c;
                D2.k.b(containerView2);
                containerView2.M0(this.f14597e);
                CanvasMaskListView canvasMaskListView = n.this.f14549d;
                if (canvasMaskListView != null && canvasMaskListView.getChildAt(this.f14597e) != null) {
                    n nVar = n.this;
                    int i3 = this.f14597e;
                    CanvasMaskListView canvasMaskListView2 = nVar.f14549d;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(canvasMaskListView2 != null ? canvasMaskListView2.getChildAt(i3) : null, (Property<View, Float>) View.ALPHA, 0.0f);
                    ofFloat.setDuration(300L);
                    ofFloat.setInterpolator(new Y.e());
                    ofFloat.start();
                }
            }
            boolean z3 = this.f14595c;
            if (z3) {
                n.this.x(this.f14598f, this.f14597e, z3, this.f14599g, this.f14600h);
            }
            ContainerView containerView3 = n.this.f14548c;
            D2.k.b(containerView3);
            containerView3.setSplitBarVisibility(4);
            ContainerView containerView4 = n.this.f14548c;
            if (containerView4 == null || !containerView4.f10742L || (containerView = n.this.f14548c) == null) {
                return;
            }
            containerView.N0();
        }
    }

    public static final class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Rect f14606b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f14607c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f14608d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f14609e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImageView f14610f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ D2.q f14611g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float f14612h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ D2.q f14613i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ float f14614j;

        h(Rect rect, Rect rect2, List list, int i3, ImageView imageView, D2.q qVar, float f3, D2.q qVar2, float f4) {
            this.f14606b = rect;
            this.f14607c = rect2;
            this.f14608d = list;
            this.f14609e = i3;
            this.f14610f = imageView;
            this.f14611g = qVar;
            this.f14612h = f3;
            this.f14613i = qVar2;
            this.f14614j = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            D2.k.e(valueAnimator, "p0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            D2.k.c(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            if (floatValue == 0.0f) {
                return;
            }
            n nVar = n.this;
            Rect rect = this.f14606b;
            Rect rect2 = this.f14607c;
            Rect h3 = ((u) this.f14608d.get(this.f14609e)).h();
            D2.k.d(h3, "getRect(...)");
            nVar.z(floatValue, rect, rect2, h3);
            n.this.F0(this.f14608d, this.f14609e);
            if (!B1.s.w(n.this.f14546a)) {
                ContainerView containerView = n.this.f14548c;
                D2.k.b(containerView);
                if (!containerView.a1()) {
                    return;
                }
            }
            ImageView imageView = this.f14610f;
            if (imageView != null) {
                imageView.setTranslationX(this.f14611g.f336e + (this.f14612h * floatValue));
                this.f14610f.setTranslationY(this.f14613i.f336e + (floatValue * this.f14614j));
            }
        }
    }

    public static final class i implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f14615a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f14616b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f14617c;

        i(View view, n nVar, int i3) {
            this.f14615a = view;
            this.f14616b = nVar;
            this.f14617c = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            D2.k.e(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            D2.k.e(animator, "animation");
            if (this.f14616b.f14565t == 404 || this.f14616b.f14565t == 403) {
                ContainerView containerView = this.f14616b.f14548c;
                D2.k.b(containerView);
                containerView.L0();
            }
            if (this.f14616b.f14565t == 405) {
                ContainerView containerView2 = this.f14616b.f14548c;
                D2.k.b(containerView2);
                containerView2.M0(this.f14617c);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            D2.k.e(animator, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            D2.k.e(animator, "animation");
            this.f14615a.setVisibility(0);
        }
    }

    public n(Context context) {
        D2.k.e(context, "context");
        this.f14546a = context;
        this.f14547b = SystemProperties.getBoolean("persist.sys.assert.panic", false);
        this.f14550e = H();
        this.f14551f = new LinkedHashMap();
        this.f14553h = AbstractC0544n.d("com.jingdong.app.mall");
        this.f14554i = -1;
        this.f14555j = -1;
        this.f14556k = -1;
        this.f14557l = -1;
        this.f14563r = -1;
    }

    private final void A(final C2.a aVar) {
        if (D2.k.a(Looper.myLooper(), Looper.getMainLooper())) {
            aVar.invoke();
        } else {
            C0644a.a().b().execute(new Runnable() { // from class: y1.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.B(C2.a.this);
                }
            });
        }
    }

    private final List A0(boolean z3, View view, ImageView imageView, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, List list, Rect rect, Rect rect2, int i3, int i4, boolean z4) {
        ArrayList arrayList = new ArrayList();
        if (view == null) {
            return arrayList;
        }
        long J3 = J();
        int i5 = this.f14565t;
        if (i5 == 401 || i5 == 402) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "ScaleX", f5, f9);
            ofFloat.setDuration(J3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "ScaleY", f6, f10);
            ofFloat2.setDuration(J3);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "TranslationX", (int) f3, f7);
            ofFloat3.setDuration(J3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "TranslationY", (int) f4, f8);
            ofFloat4.setDuration(J3);
            D2.k.b(ofFloat);
            arrayList.add(ofFloat);
            D2.k.b(ofFloat2);
            arrayList.add(ofFloat2);
            D2.k.b(ofFloat3);
            arrayList.add(ofFloat3);
            D2.k.b(ofFloat4);
            arrayList.add(ofFloat4);
        } else {
            ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
            D2.q qVar = new D2.q();
            D2.q qVar2 = new D2.q();
            ofFloat5.setDuration(J3);
            if (imageView != null) {
                qVar.f336e = imageView.getTranslationX();
                qVar2.f336e = imageView.getTranslationY();
            }
            ofFloat5.addUpdateListener(new h(rect, rect2, list, i3, imageView, qVar, f7, qVar2, f8));
            D2.k.b(ofFloat5);
            arrayList.add(ofFloat5);
        }
        if (z4) {
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
            int i6 = this.f14565t;
            ofFloat6.setDuration((i6 == 401 || i6 == 402 || i6 == 404 || z3) ? 0L : 100L);
            ofFloat6.addListener(new i(view, this, i4));
            D2.k.b(ofFloat6);
            arrayList.add(ofFloat6);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(C2.a aVar) {
        D2.k.e(aVar, "$tmp0");
        aVar.invoke();
    }

    private final Collection B0(ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        ContainerView containerView = this.f14548c;
        if (containerView != null && imageView != null) {
            D2.k.b(containerView);
            if (containerView.f1()) {
                ContainerView containerView2 = this.f14548c;
                D2.k.b(containerView2);
                if (!containerView2.a1() && (B1.s.H() || B1.s.r(this.f14546a))) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "TranslationX", imageView.getTranslationX(), 0.0f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "TranslationY", imageView.getTranslationY(), 0.0f);
                    ofFloat.setDuration(500L);
                    ofFloat2.setDuration(500L);
                    D2.k.b(ofFloat);
                    arrayList.add(ofFloat);
                    D2.k.b(ofFloat2);
                    arrayList.add(ofFloat2);
                    ContainerView containerView3 = this.f14548c;
                    D2.k.b(containerView3);
                    if (containerView3.f10732G.H().size() == 2) {
                        ContainerView containerView4 = this.f14548c;
                        D2.k.b(containerView4);
                        ImageView D3 = containerView4.f10732G.D(imageView);
                        if (D3 != null) {
                            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(D3, "TranslationX", D3.getTranslationX(), 0.0f);
                            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(D3, "TranslationY", D3.getTranslationY(), 0.0f);
                            ofFloat3.setDuration(500L);
                            ofFloat4.setDuration(500L);
                            D2.k.b(ofFloat3);
                            arrayList.add(ofFloat3);
                            D2.k.b(ofFloat4);
                            arrayList.add(ofFloat4);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private final List C0(int i3) {
        ArrayList arrayList = new ArrayList();
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        t o3 = canvasMaskListView.o(i3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o3 != null ? o3.getTextView() : null, "Alpha", 0.0f);
        D2.k.b(ofFloat);
        arrayList.add(ofFloat);
        return arrayList;
    }

    private final long E(boolean z3) {
        if (this.f14565t == 403) {
            return 350L;
        }
        return (z3 && this.f14552g) ? 100L : 300L;
    }

    private final long H() {
        if (this.f14565t != 404 || B1.d.f168d) {
            return B1.s.w(this.f14546a) ? 350L : 400L;
        }
        return 200L;
    }

    private final long J() {
        int i3 = this.f14565t;
        if (i3 != 401) {
            return i3 != 402 ? (i3 == 404 && !B1.d.f168d) ? 400L : 500L : B1.d.f168d ? 350L : 500L;
        }
        return 600L;
    }

    private final ActivityManager.RunningTaskInfo M(int i3) {
        EmbeddedViewDecor q02;
        FlexibleTaskView flexibleTaskView;
        ContainerView containerView = this.f14548c;
        if (containerView == null || i3 < 0 || i3 >= containerView.getChildCount() || (q02 = containerView.q0(i3)) == null || (flexibleTaskView = q02.getFlexibleTaskView()) == null) {
            return null;
        }
        return B1.l.S(flexibleTaskView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(n nVar, C2.a aVar) {
        D2.k.e(nVar, "this$0");
        D2.k.e(aVar, "$onMaskHide");
        CanvasMaskListView canvasMaskListView = nVar.f14549d;
        D2.k.b(canvasMaskListView);
        if (canvasMaskListView.t()) {
            CanvasMaskListView canvasMaskListView2 = nVar.f14549d;
            D2.k.b(canvasMaskListView2);
            canvasMaskListView2.setCanceldHideAnimator(false);
        } else {
            CanvasMaskListView canvasMaskListView3 = nVar.f14549d;
            D2.k.b(canvasMaskListView3);
            canvasMaskListView3.m();
        }
        D2.k.b(aVar.invoke());
        ContainerView containerView = nVar.f14548c;
        D2.k.b(containerView);
        containerView.B1();
        nVar.f14558m = false;
        nVar.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(n nVar, List list, ImageView imageView, long j3, long j4, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(nVar, "this$0");
        D2.k.e(list, "$targetDatas");
        D2.k.e(aVar, "$onMaskShow");
        D2.k.e(aVar2, "$onMaskFull");
        D2.k.e(aVar3, "$onMaskHide");
        nVar.V(list, imageView, j3, j4, aVar, aVar2, aVar3);
    }

    private final boolean W() {
        int i3;
        int D3 = D();
        int F3 = F();
        int L3 = L();
        return (D3 == -1 || D3 == this.f14557l) && (F3 == -1 || L3 == -1 || ((F3 == (i3 = this.f14563r) && L3 == this.f14557l) || (L3 == i3 && F3 == this.f14557l)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(int i3, List list, n nVar) {
        D2.k.e(nVar, "this$0");
        if (i3 != -1 || list == null) {
            CanvasMaskListView canvasMaskListView = nVar.f14549d;
            D2.k.b(canvasMaskListView);
            canvasMaskListView.E(150L, i3);
            return;
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            CanvasMaskListView canvasMaskListView2 = nVar.f14549d;
            D2.k.b(canvasMaskListView2);
            canvasMaskListView2.E(150L, i4);
        }
    }

    private final void b0() {
        C0644a.ExecutorC0159a b3 = C0644a.a().b();
        if (b3.a(this.f14564s)) {
            b3.c(this.f14564s);
        }
        this.f14564s = null;
        g0(-1);
        j0(-1);
        m0(null);
        c0(null);
        l0(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(n nVar, boolean z3, List list, List list2, List list3, long j3, int i3, boolean z4, int i4, C2.a aVar, C2.a aVar2, C2.a aVar3, long j4, int i5) {
        D2.k.e(nVar, "this$0");
        D2.k.e(aVar, "$onMaskShow");
        D2.k.e(aVar2, "$onMaskFull");
        D2.k.e(aVar3, "$onMaskHide");
        nVar.w0(z3, list, list2, list3, j3, i3, z4, i4, aVar, aVar2, aVar3, j4, i5);
    }

    private final List w(boolean z3, Rect rect, Rect rect2, int i3, List list, int i4) {
        View childAt;
        int i5 = rect.left;
        int i6 = rect.top;
        float f3 = rect2.left - i5;
        float f4 = rect2.top - i6;
        float width = (rect2.width() + 0.0f) / rect.width();
        float height = (rect2.height() + 0.0f) / rect.height();
        Rect rect3 = new Rect(rect2.left, rect2.top, rect2.right, rect2.bottom);
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        ListAdapter adapter = canvasMaskListView.getAdapter();
        D2.k.c(adapter, "null cannot be cast to non-null type com.oplus.pscanvas.canvasmode.canvas.adapter.CanvasMaskAdapter");
        u item = ((C0599b) adapter).getItem(i3);
        Rect rect4 = new Rect(item != null ? item.h() : null);
        Log.d(f14545w, "oldRect = " + rect4 + ",newRect = " + rect2 + ",oldScaleX = 1.0,oldScaleY =1.0 mMaskAnimationType:" + this.f14565t + ",oldTranslateX = 0.0,oldTranslateY = 0.0,targetScaleX = " + width + ",targetScaleY = " + height + ",targetTranslateX =" + f3 + ",targetTranslateY = " + f4);
        CanvasMaskListView canvasMaskListView2 = this.f14549d;
        if (canvasMaskListView2 != null) {
            canvasMaskListView2.l();
        }
        CanvasMaskListView canvasMaskListView3 = this.f14549d;
        if (canvasMaskListView3 == null || (childAt = canvasMaskListView3.getChildAt(i3)) == null) {
            return null;
        }
        return A0(z3, childAt, null, 0.0f, 0.0f, 1.0f, 1.0f, f3, f4, width, height, list, rect3, rect4, i3, i4, true);
    }

    private final void w0(boolean z3, List list, List list2, List list3, long j3, int i3, boolean z4, int i4, C2.a aVar, C2.a aVar2, C2.a aVar3, long j4, int i5) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        int count = canvasMaskListView.getAdapter().getCount();
        for (int i6 = 0; i6 < count; i6++) {
            if (i6 == i3) {
                CanvasMaskListView canvasMaskListView2 = this.f14549d;
                D2.k.b(canvasMaskListView2);
                View childAt = canvasMaskListView2.getChildAt(i6);
                if (childAt != null) {
                    childAt.setZ(0.0f);
                }
            } else {
                CanvasMaskListView canvasMaskListView3 = this.f14549d;
                D2.k.b(canvasMaskListView3);
                View childAt2 = canvasMaskListView3.getChildAt(i6);
                if (childAt2 != null) {
                    childAt2.setZ(1.0f);
                }
            }
            if (i5 == -1 || i6 == i5) {
                Rect h3 = ((u) list.get(i6)).h();
                Rect h4 = ((u) list2.get(i6)).h();
                D2.k.b(h3);
                D2.k.b(h4);
                List w3 = w(z3, h3, h4, i6, list2, i5);
                if (w3 != null) {
                    arrayList.addAll(w3);
                } else {
                    Log.w(f14545w, "startAnimOldRectToNewRect animator is null");
                }
            }
        }
        if (list3 != null) {
            arrayList.addAll(list3);
        }
        ActivityManager.RunningTaskInfo M3 = M(i4);
        boolean z5 = M3 != null && M3.getWindowingMode() == 120;
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(new Y.e());
        animatorSet.addListener(new g(aVar, z4, z3, i3, j3, aVar3, j4, i5, aVar2, i4, z5));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(long j3, int i3, boolean z3, C2.a aVar, long j4) {
        if (j3 < 0) {
            return;
        }
        boolean z4 = this.f14565t == 404 && !B1.d.f168d;
        boolean z5 = !this.f14566u && (!z4 || this.f14552g);
        this.f14566u = false;
        long E3 = E(z4);
        if (this.f14565t == 403) {
            this.f14565t = 0;
            Bundle bundle = new Bundle();
            bundle.putBoolean("androidx.activity.inChangeTwoTaskOrientationAnim", false);
            B1.l.f(bundle);
        }
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        canvasMaskListView.q(j3, z4 ? j3 : 300L, z5, new d(z3, j3, this, aVar, j4), i3, E3);
    }

    private final List y(Rect rect, int i3, ImageView imageView, List list) {
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        ListAdapter adapter = canvasMaskListView.getAdapter();
        D2.k.c(adapter, "null cannot be cast to non-null type com.oplus.pscanvas.canvasmode.canvas.adapter.CanvasMaskAdapter");
        if (((C0599b) adapter).getCount() <= i3) {
            return null;
        }
        CanvasMaskListView canvasMaskListView2 = this.f14549d;
        D2.k.b(canvasMaskListView2);
        ListAdapter adapter2 = canvasMaskListView2.getAdapter();
        D2.k.c(adapter2, "null cannot be cast to non-null type com.oplus.pscanvas.canvasmode.canvas.adapter.CanvasMaskAdapter");
        u item = ((C0599b) adapter2).getItem(i3);
        Rect rect2 = new Rect(item != null ? item.h() : null);
        ((u) list.get(i3)).l(item != null ? item.c() : null);
        Rect rect3 = new Rect(rect.left, rect.top, rect.right, rect.bottom);
        int i4 = rect2.left;
        int i5 = rect2.top;
        float f3 = rect.left - i4;
        float f4 = rect.top - i5;
        float width = (rect.width() + 0.0f) / rect2.width();
        float height = (rect.height() + 0.0f) / rect2.height();
        Log.d(f14545w, "animToTargetRect index: " + i3 + ", oldRect = " + rect2 + ",newRect = " + rect + " mMaskAnimationType:" + this.f14565t + ",oldScaleX = 1.0,oldScaleY =1.0,oldTranslateX = 0.0,oldTranslateY = 0.0,targetScaleX = " + width + ",targetScaleY = " + height + ",targetTranslateX =" + f3 + ",targetTranslateY = " + f4);
        CanvasMaskListView canvasMaskListView3 = this.f14549d;
        D2.k.b(canvasMaskListView3);
        return A0(false, canvasMaskListView3.getChildAt(i3), imageView, 0.0f, 0.0f, 1.0f, 1.0f, f3, f4, width, height, list, rect3, rect2, i3, -1, false);
    }

    private final List z0(int i3) {
        ArrayList arrayList = new ArrayList();
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        t o3 = canvasMaskListView.o(i3);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(o3 != null ? o3.getIconView() : null, "Alpha", 0.0f);
        D2.k.b(ofFloat);
        arrayList.add(ofFloat);
        return arrayList;
    }

    public final synchronized C0601d C() {
        return this.f14561p;
    }

    public final synchronized int D() {
        return this.f14554i;
    }

    public final void D0(int i3, float f3) {
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        t o3 = canvasMaskListView.o(i3);
        if (o3 != null) {
            o3.getIconView().setAlpha(f3);
            o3.getCloseOverlayView().setAlpha(f3);
        }
    }

    public final void E0(List list) {
        D2.k.e(list, "targetDatas");
        if (this.f14548c == null) {
            return;
        }
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        int count = canvasMaskListView.getAdapter().getCount();
        for (int i3 = 0; i3 < count; i3++) {
            CanvasMaskListView canvasMaskListView2 = this.f14549d;
            D2.k.b(canvasMaskListView2);
            ListAdapter adapter = canvasMaskListView2.getAdapter();
            D2.k.c(adapter, "null cannot be cast to non-null type com.oplus.pscanvas.canvasmode.canvas.adapter.CanvasMaskAdapter");
            ((C0599b) adapter).b((u) list.get(i3), i3);
        }
    }

    public final synchronized int F() {
        return this.f14555j;
    }

    public final void F0(List list, int i3) {
        D2.k.e(list, "targetDatas");
        if (this.f14548c == null) {
            return;
        }
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        ListAdapter adapter = canvasMaskListView.getAdapter();
        D2.k.c(adapter, "null cannot be cast to non-null type com.oplus.pscanvas.canvasmode.canvas.adapter.CanvasMaskAdapter");
        ((C0599b) adapter).b((u) list.get(i3), i3);
    }

    public final int G() {
        return this.f14557l;
    }

    public final int I() {
        return this.f14565t;
    }

    public final int K() {
        return this.f14563r;
    }

    public final synchronized int L() {
        return this.f14556k;
    }

    public final synchronized C0601d N() {
        return this.f14562q;
    }

    public final synchronized C0601d O() {
        return this.f14560o;
    }

    public final void P(long j3, final C2.a aVar) {
        D2.k.e(aVar, "onMaskHide");
        if (this.f14548c != null && j3 >= 0) {
            A(new e(j3));
            C0644a.a().b().b(new Runnable() { // from class: y1.k
                @Override // java.lang.Runnable
                public final void run() {
                    n.Q(n.this, aVar);
                }
            }, j3);
        }
    }

    public final boolean R() {
        return this.f14558m;
    }

    public final void S(final List list, final ImageView imageView, final long j3, final long j4, final C2.a aVar, final C2.a aVar2, final C2.a aVar3) {
        ObjectAnimator customAlphaAnim;
        ObjectAnimator customAlphaAnim2;
        ObjectAnimator customAlphaAnim3;
        D2.k.e(list, "targetDatas");
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        this.f14558m = true;
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        int count = canvasMaskListView.getAdapter().getCount();
        boolean z3 = false;
        for (int i3 = 0; i3 < count; i3++) {
            CanvasMaskListView canvasMaskListView2 = this.f14549d;
            D2.k.b(canvasMaskListView2);
            t o3 = canvasMaskListView2.o(i3);
            if ((o3 != null && (customAlphaAnim3 = o3.getCustomAlphaAnim()) != null && customAlphaAnim3.isStarted()) || (o3 != null && (customAlphaAnim = o3.getCustomAlphaAnim()) != null && customAlphaAnim.isRunning())) {
                if (o3 != null && (customAlphaAnim2 = o3.getCustomAlphaAnim()) != null) {
                    customAlphaAnim2.end();
                }
                if (o3 != null) {
                    o3.invalidate();
                }
                z3 = true;
            }
        }
        if (z3) {
            this.f14546a.getMainThreadHandler().post(new Runnable() { // from class: y1.i
                @Override // java.lang.Runnable
                public final void run() {
                    n.U(n.this, list, imageView, j3, j4, aVar, aVar2, aVar3);
                }
            });
        } else {
            V(list, imageView, j3, j4, aVar, aVar2, aVar3);
        }
    }

    public final void T(List list, ImageView imageView, long j3, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(list, "targetDatas");
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        S(list, imageView, j3, B1.d.f168d ? 200L : this.f14550e, aVar, aVar2, aVar3);
    }

    public final void V(List list, ImageView imageView, long j3, long j4, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(list, "targetDatas");
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        D2.k.b(aVar.invoke());
        ArrayList arrayList = new ArrayList();
        AnimatorSet animatorSet = new AnimatorSet();
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        int count = canvasMaskListView.getAdapter().getCount();
        for (int i3 = 0; i3 < count; i3++) {
            Rect h3 = ((u) list.get(i3)).h();
            D2.k.b(h3);
            List y3 = y(h3, i3, imageView, list);
            D2.k.b(y3);
            arrayList.addAll(y3);
            int i4 = this.f14565t;
            if (i4 == 401 || i4 == 402) {
                arrayList.addAll(z0(i3));
                arrayList.addAll(C0(i3));
            }
        }
        arrayList.addAll(B0(imageView));
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(j3);
        animatorSet.setInterpolator(new Y.e());
        animatorSet.addListener(new f(j3, j4, this, list, aVar2, aVar3));
        animatorSet.start();
    }

    public final void X(List list) {
        Y(list, -1);
    }

    public final void Y(final List list, final int i3) {
        if (this.f14548c == null) {
            return;
        }
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        canvasMaskListView.s(list);
        ContainerView containerView = this.f14548c;
        D2.k.b(containerView);
        containerView.y1();
        C0644a.a().b().execute(new Runnable() { // from class: y1.m
            @Override // java.lang.Runnable
            public final void run() {
                n.Z(i3, list, this);
            }
        });
    }

    public final void a0() {
        C0644a.ExecutorC0159a b3 = C0644a.a().b();
        if (b3.a(this.f14559n)) {
            b3.c(this.f14559n);
        }
        this.f14559n = null;
        g0(-1);
        j0(-1);
        d0(-1);
        f0(-1);
        k0(-1);
    }

    public final synchronized void c0(C0601d c0601d) {
        this.f14561p = c0601d;
    }

    public final synchronized void d0(int i3) {
        this.f14554i = i3;
    }

    public final void e0(ContainerView containerView) {
        D2.k.e(containerView, "canvas");
        this.f14548c = containerView;
        this.f14549d = (CanvasMaskListView) containerView.getRootView().findViewById(t1.f.f13454n);
    }

    public final synchronized void f0(int i3) {
        this.f14555j = i3;
    }

    public final void g0(int i3) {
        this.f14557l = i3;
    }

    public final void h0(boolean z3) {
        this.f14566u = z3;
    }

    public final void i0(int i3) {
        this.f14565t = i3;
    }

    public final void j0(int i3) {
        this.f14563r = i3;
    }

    public final synchronized void k0(int i3) {
        this.f14556k = i3;
    }

    public final synchronized void l0(C0601d c0601d) {
        this.f14562q = c0601d;
    }

    public final synchronized void m0(C0601d c0601d) {
        this.f14560o = c0601d;
    }

    public final void n0(List list, List list2, List list3, int i3, int i4, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        long H3 = H();
        this.f14550e = H3;
        s0(false, list, list2, list3, H3, H3, i3, -1, false, i4, aVar, aVar2, aVar3);
    }

    public final void o0(List list, List list2, List list3, int i3, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        long j3 = this.f14550e;
        s0(false, list, list2, list3, j3, j3, i3, -1, false, -1, aVar, aVar2, aVar3);
    }

    public final void p0(List list, List list2, List list3, long j3, long j4, int i3, int i4, boolean z3, int i5, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        s0(false, list, list2, list3, j3, j4, i3, i4, z3, i5, aVar, aVar2, aVar3);
    }

    public final void q0(List list, List list2, List list3, long j3, long j4, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        s0(false, list, list2, list3, j3, j4, -1, -1, false, -1, aVar, aVar2, aVar3);
    }

    public final void r0(List list, List list2, List list3, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        o0(list, list2, list3, -1, aVar, aVar2, aVar3);
    }

    public final void s0(final boolean z3, final List list, final List list2, final List list3, long j3, final long j4, final int i3, final int i4, final boolean z4, final int i5, final C2.a aVar, final C2.a aVar2, final C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        if (list == null || list2 == null || list.size() != list2.size() || this.f14549d == null) {
            Log.d(f14545w, "Initialization is not complete, try use it on attach to window or use it after setContainerView()");
            return;
        }
        this.f14558m = true;
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(list.get(i6));
        }
        CanvasMaskListView canvasMaskListView = this.f14549d;
        D2.k.b(canvasMaskListView);
        canvasMaskListView.setIsSystemAnimating(z3);
        CanvasMaskListView canvasMaskListView2 = this.f14549d;
        D2.k.b(canvasMaskListView2);
        final long s3 = canvasMaskListView2.s(arrayList);
        ContainerView containerView = this.f14548c;
        D2.k.b(containerView);
        containerView.z1(i3);
        if (!D2.k.a(Looper.myLooper(), Looper.getMainLooper())) {
            C0644a.a().f14500a.execute(new Runnable() { // from class: y1.j
                @Override // java.lang.Runnable
                public final void run() {
                    n.u0(n.this, z3, list, list2, list3, j4, i4, z4, i5, aVar, aVar2, aVar3, s3, i3);
                }
            });
            return;
        }
        CanvasMaskListView canvasMaskListView3 = this.f14549d;
        D2.k.b(canvasMaskListView3);
        canvasMaskListView3.layoutChildren();
        w0(z3, list, list2, list3, j4, i4, z4, i5, aVar, aVar2, aVar3, s3, i3);
    }

    public final void t0(boolean z3, List list, List list2, List list3, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        long j3 = this.f14550e;
        s0(z3, list, list2, list3, j3, j3, -1, -1, false, -1, aVar, aVar2, aVar3);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(long r17, int r19, boolean r20, C2.a r21, C2.a r22, long r23, int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.n.v(long, int, boolean, C2.a, C2.a, long, int, boolean):void");
    }

    public final void v0(List list, List list2, List list3, int i3, boolean z3, C2.a aVar, C2.a aVar2, C2.a aVar3) {
        D2.k.e(aVar, "onMaskShow");
        D2.k.e(aVar2, "onMaskFull");
        D2.k.e(aVar3, "onMaskHide");
        long j3 = this.f14550e;
        s0(false, list, list2, list3, j3, j3, -1, i3, z3, -1, aVar, aVar2, aVar3);
    }

    public final void x0() {
        if (this.f14559n == null) {
            if (this.f14547b) {
                Log.d(f14545w, "startHideMask return, mHideMask is null");
                return;
            }
            return;
        }
        long j3 = (this.f14565t == 404 && this.f14552g) ? 100L : 0L;
        if (this.f14547b) {
            Log.d(f14545w, "startHideMask, execute duration=" + j3);
        }
        C0644a.ExecutorC0159a b3 = C0644a.a().b();
        if (b3.a(this.f14559n)) {
            b3.c(this.f14559n);
        }
        b3.b(this.f14559n, j3);
        g0(-1);
        j0(-1);
        d0(-1);
        f0(-1);
        k0(-1);
    }

    public final void y0() {
        if (this.f14564s == null) {
            if (this.f14547b) {
                Log.d(f14545w, "startHideMaskViewList return, mHideMaskViewList is null");
                return;
            }
            return;
        }
        if (this.f14547b) {
            Log.d(f14545w, "startHideMaskViewList, execute");
        }
        C0644a.ExecutorC0159a b3 = C0644a.a().b();
        if (b3.a(this.f14564s)) {
            b3.c(this.f14564s);
        }
        b3.execute(this.f14564s);
        g0(-1);
        j0(-1);
        m0(null);
        c0(null);
        l0(null);
    }

    public final Rect z(float f3, Rect rect, Rect rect2, Rect rect3) {
        D2.k.e(rect, "targetRect");
        D2.k.e(rect2, "oldRect");
        D2.k.e(rect3, "realRect");
        rect3.left = rect2.left + ((int) ((rect.left - r1) * f3));
        rect3.right = rect2.right + ((int) ((rect.right - r1) * f3));
        rect3.top = rect2.top + ((int) ((rect.top - r1) * f3));
        rect3.bottom = rect2.bottom + ((int) ((rect.bottom - r1) * f3));
        return rect3;
    }
}
