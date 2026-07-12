package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.ActivityTaskManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.SurfaceSession;
import android.view.animation.PathInterpolator;
import androidx.preference.Preference;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import u1.C0600c;
import u1.C0601d;

/* loaded from: classes.dex */
public class x {

    /* renamed from: D, reason: collision with root package name */
    private ValueAnimator f14294D;

    /* renamed from: E, reason: collision with root package name */
    private ValueAnimator f14295E;

    /* renamed from: F, reason: collision with root package name */
    protected ValueAnimator f14296F;

    /* renamed from: G, reason: collision with root package name */
    private SurfaceControl f14297G;

    /* renamed from: I, reason: collision with root package name */
    private C0601d f14299I;

    /* renamed from: J, reason: collision with root package name */
    private Context f14300J;

    /* renamed from: L, reason: collision with root package name */
    private int f14302L;

    /* renamed from: M, reason: collision with root package name */
    private m f14303M;

    /* renamed from: S, reason: collision with root package name */
    private boolean f14309S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f14310T;

    /* renamed from: U, reason: collision with root package name */
    private int f14311U;

    /* renamed from: V, reason: collision with root package name */
    private int f14312V;

    /* renamed from: W, reason: collision with root package name */
    private int f14313W;

    /* renamed from: X, reason: collision with root package name */
    private int f14314X;

    /* renamed from: Y, reason: collision with root package name */
    private Rect f14315Y;

    /* renamed from: Z, reason: collision with root package name */
    private float f14316Z;

    /* renamed from: a, reason: collision with root package name */
    private C0600c f14317a;

    /* renamed from: a0, reason: collision with root package name */
    private float f14318a0;

    /* renamed from: b, reason: collision with root package name */
    private ContainerView f14319b;

    /* renamed from: b0, reason: collision with root package name */
    private Rect f14320b0;

    /* renamed from: c, reason: collision with root package name */
    private EmbeddedViewDecor f14321c;

    /* renamed from: c0, reason: collision with root package name */
    private Rect f14322c0;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceControl.Transaction f14323d;

    /* renamed from: d0, reason: collision with root package name */
    private SurfaceControl f14324d0;

    /* renamed from: e, reason: collision with root package name */
    private int f14325e;

    /* renamed from: e0, reason: collision with root package name */
    private SurfaceControl f14326e0;

    /* renamed from: f, reason: collision with root package name */
    private int f14327f;

    /* renamed from: f0, reason: collision with root package name */
    private SurfaceControl f14328f0;

    /* renamed from: g, reason: collision with root package name */
    private int f14329g;

    /* renamed from: h, reason: collision with root package name */
    private int f14331h;

    /* renamed from: i, reason: collision with root package name */
    private int f14333i;

    /* renamed from: j, reason: collision with root package name */
    private int f14335j;

    /* renamed from: k, reason: collision with root package name */
    private int f14337k;

    /* renamed from: l, reason: collision with root package name */
    private int f14339l;

    /* renamed from: m, reason: collision with root package name */
    private int f14341m;

    /* renamed from: n, reason: collision with root package name */
    private int f14343n;

    /* renamed from: n0, reason: collision with root package name */
    private AnimatorSet f14344n0;

    /* renamed from: o, reason: collision with root package name */
    private int f14345o;

    /* renamed from: o0, reason: collision with root package name */
    private AnimatorSet f14346o0;

    /* renamed from: p, reason: collision with root package name */
    private int f14347p;

    /* renamed from: p0, reason: collision with root package name */
    private AnimatorSet f14348p0;

    /* renamed from: r0, reason: collision with root package name */
    private int[] f14352r0;

    /* renamed from: s, reason: collision with root package name */
    private int f14353s;

    /* renamed from: y0, reason: collision with root package name */
    private static Boolean f14289y0 = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: z0, reason: collision with root package name */
    public static final PathInterpolator f14290z0 = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: A0, reason: collision with root package name */
    public static final Y.e f14288A0 = new Y.e();

    /* renamed from: q, reason: collision with root package name */
    private Rect f14349q = new Rect();

    /* renamed from: r, reason: collision with root package name */
    private Rect f14351r = new Rect();

    /* renamed from: t, reason: collision with root package name */
    private int f14355t = -1;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList f14357u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    private ArrayList f14359v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    private int f14361w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f14363x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f14365y = 0;

    /* renamed from: z, reason: collision with root package name */
    private int f14366z = 0;

    /* renamed from: A, reason: collision with root package name */
    private boolean f14291A = false;

    /* renamed from: B, reason: collision with root package name */
    private boolean f14292B = false;

    /* renamed from: C, reason: collision with root package name */
    private boolean f14293C = false;

    /* renamed from: K, reason: collision with root package name */
    private ArrayList f14301K = new ArrayList();

    /* renamed from: N, reason: collision with root package name */
    private PointF f14304N = new PointF();

    /* renamed from: O, reason: collision with root package name */
    private PointF f14305O = new PointF();

    /* renamed from: P, reason: collision with root package name */
    private PointF f14306P = new PointF();

    /* renamed from: Q, reason: collision with root package name */
    private boolean f14307Q = false;

    /* renamed from: R, reason: collision with root package name */
    private boolean f14308R = false;

    /* renamed from: g0, reason: collision with root package name */
    private Rect f14330g0 = new Rect();

    /* renamed from: h0, reason: collision with root package name */
    private Rect f14332h0 = new Rect();

    /* renamed from: i0, reason: collision with root package name */
    private Rect f14334i0 = new Rect();

    /* renamed from: j0, reason: collision with root package name */
    private Rect f14336j0 = new Rect();

    /* renamed from: k0, reason: collision with root package name */
    private Rect f14338k0 = new Rect();

    /* renamed from: l0, reason: collision with root package name */
    private Rect f14340l0 = new Rect();

    /* renamed from: q0, reason: collision with root package name */
    private boolean f14350q0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private ArrayList f14354s0 = new ArrayList();

    /* renamed from: t0, reason: collision with root package name */
    private ArrayList f14356t0 = new ArrayList();

    /* renamed from: u0, reason: collision with root package name */
    private List f14358u0 = new ArrayList();

    /* renamed from: v0, reason: collision with root package name */
    private Map f14360v0 = new HashMap();

    /* renamed from: w0, reason: collision with root package name */
    private Map f14362w0 = new HashMap();

    /* renamed from: x0, reason: collision with root package name */
    private long f14364x0 = 0;

    /* renamed from: H, reason: collision with root package name */
    private SurfaceSession f14298H = new SurfaceSession();

    /* renamed from: m0, reason: collision with root package name */
    private Handler f14342m0 = new d(Looper.getMainLooper());

    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### startHideAnimation cancel");
            x.this.I0();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### startHideAnimation end");
            x.this.I0();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### startHideAnimation start");
            try {
                ActivityTaskManager.getService().setFocusedTask(x.this.f14299I.s());
            } catch (RemoteException unused) {
                Log.e("ThreeSplitAnimManager", "set focus to zoom task failed");
            }
        }
    }

    class b implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f14368e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f14369f;

        b(boolean z3, List list) {
            this.f14368e = z3;
            this.f14369f = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = x.this;
            xVar.V0(this.f14368e ? xVar.f14346o0 : xVar.f14348p0, this.f14369f, 300, -1, x.f14288A0);
        }
    }

    class c implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f14371a;

        c(int i3) {
            this.f14371a = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("ThreeSplitAnimManager", "startViewToRectAnimation animPolicy=" + this.f14371a + " animation end");
            if (this.f14371a == -1 && !x.this.f14309S) {
                x.this.f14304N.set((x.this.f14340l0.width() * 0.029999971f) / 2.0f, (x.this.f14340l0.height() * 0.029999971f) / 2.0f);
            }
            B1.l.u1(x.this.f14319b, 20109, false);
            if (this.f14371a == 3) {
                x.this.Z0();
                x.this.H0();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("ThreeSplitAnimManager", "startViewToRectAnimation animPolicy=" + this.f14371a + " animation start");
            B1.l.u1(x.this.f14319b, 20109, true);
        }
    }

    class d extends Handler {
        d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 10) {
                x.this.r0(((Integer) message.obj).intValue());
            } else if (i3 == 20) {
                x.this.S0();
            } else {
                if (i3 != 30) {
                    return;
                }
                x.this.q0(((Integer) message.obj).intValue());
            }
        }
    }

    class e implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f14374a;

        e(int i3) {
            this.f14374a = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.f14374a == 0) {
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (x.this.f14303M != null) {
                x.this.f14303M.d(floatValue);
                if (this.f14374a == 14 && x.this.f14363x != 4 && x.this.f14363x != 3) {
                    x.this.f14303M.e(floatValue);
                }
            }
            Iterator it = x.this.f14301K.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                mVar.d(floatValue);
                mVar.e(floatValue);
            }
            x.this.f14323d.apply();
        }
    }

    class f implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f14376a;

        f(int i3) {
            this.f14376a = i3;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### prepareNextAnimation cancel");
            x.this.f14307Q = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### prepareNextAnimation end state=" + this.f14376a + " mCurrentState=" + x.this.f14361w + " mBeforeUpState=" + x.this.f14363x + " cancleCurrentAnimation:" + x.this.f14307Q);
            B1.l.t1(x.this.f14326e0, 20109, false);
            int i3 = this.f14376a;
            if (i3 == 4 || i3 == 3) {
                x xVar = x.this;
                if (xVar.B0(xVar.f14328f0)) {
                    x.this.f14323d.setAlpha(x.this.f14328f0, 1.0f).apply();
                }
            }
            if (x.this.f14307Q) {
                return;
            }
            int i4 = this.f14376a;
            if (i4 != 4 && i4 != 3 && x.this.F0()) {
                if (x.this.f14295E != null && x.this.f14295E.isRunning()) {
                    x.this.f14295E.end();
                }
                x.this.Q0();
            }
            int i5 = this.f14376a;
            if (i5 == 14) {
                x.this.l0();
            } else if (i5 == 4 && x.this.f14361w == 13) {
                x.this.l0();
            } else {
                x xVar2 = x.this;
                xVar2.f14361w--;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f14376a == 0) {
                onAnimationCancel(null);
            }
            Log.d("ThreeSplitAnimManager", "##### prepareNextAnimation start state=" + this.f14376a + " mCurrentState=" + x.this.f14361w);
            B1.l.t1(x.this.f14326e0, 20109, true);
            x xVar = x.this;
            if (xVar.B0(xVar.f14328f0)) {
                x.this.f14323d.setAlpha(x.this.f14328f0, 0.0f).apply();
            }
        }
    }

    class g implements ValueAnimator.AnimatorUpdateListener {
        g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            x.this.f14303M.n(floatValue);
            Iterator it = x.this.f14301K.iterator();
            while (it.hasNext()) {
                ((m) it.next()).n(floatValue);
            }
            x.this.f14323d.apply();
        }
    }

    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### alphaAnimation cancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### alphaAnimation over");
            if (x.this.f14310T) {
                x.this.I0();
                x.this.f14310T = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            x.this.f14303M.m(1.0f);
            Iterator it = x.this.f14301K.iterator();
            while (it.hasNext()) {
                ((m) it.next()).m(1.0f);
            }
            x.this.f14323d.apply();
            Log.d("ThreeSplitAnimManager", "##### alphaAnimation start");
        }
    }

    class i implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f14380e;

        i(List list) {
            this.f14380e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            x xVar = x.this;
            xVar.V0(xVar.f14344n0, this.f14380e, 400, 3, x.f14290z0);
        }
    }

    class j implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f14382a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Rect f14383b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f14384c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Point f14385d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Point f14386e;

        j(Rect rect, Rect rect2, Rect rect3, Point point, Point point2) {
            this.f14382a = rect;
            this.f14383b = rect2;
            this.f14384c = rect3;
            this.f14385d = point;
            this.f14386e = point2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            x xVar = x.this;
            if (xVar.B0(xVar.f14303M.f14402c)) {
                x xVar2 = x.this;
                if (xVar2.B0(xVar2.f14303M.f14400a)) {
                    x xVar3 = x.this;
                    if (xVar3.B0(xVar3.f14303M.f14401b)) {
                        x xVar4 = x.this;
                        if (xVar4.B0(xVar4.f14303M.f14403d)) {
                            x xVar5 = x.this;
                            if (xVar5.B0(xVar5.f14328f0)) {
                                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                float[] fArr = {1.0f, 1.0f};
                                float[] fArr2 = {(this.f14382a.width() * 1.0f) / this.f14383b.width(), (this.f14382a.height() * 1.0f) / this.f14383b.height()};
                                this.f14384c.set(0, 0, (int) (this.f14383b.width() * B1.l.p(floatValue, fArr2[0], fArr[0])), (int) (this.f14383b.height() * B1.l.p(floatValue, fArr2[1], fArr[1])));
                                this.f14385d.set(this.f14386e.x - ((this.f14384c.width() - this.f14383b.width()) / 2), this.f14386e.y);
                                int height = (this.f14384c.height() - ((x.this.f14314X + x.this.f14303M.f14407h) + x.this.f14303M.f14408i)) / 2;
                                int width = (this.f14384c.width() - x.this.f14303M.f14406g) / 2;
                                int i3 = x.this.f14314X + height + x.this.f14303M.f14408i;
                                x.this.f14303M.f14425z = (int) B1.l.p(floatValue, x.this.f14316Z * x.this.f14318a0, x.this.f14300J.getResources().getDisplayMetrics().density * 12.0f);
                                SurfaceControl.Transaction alpha = x.this.f14323d.setScale(x.this.f14303M.f14402c, this.f14384c.width() / x.this.f14303M.f14417r.width(), this.f14384c.height() / x.this.f14303M.f14417r.height()).setCrop(x.this.f14303M.f14400a, this.f14384c).setAlpha(x.this.f14303M.f14400a, 1.0f).setAlpha(x.this.f14303M.f14401b, 0.0f);
                                SurfaceControl surfaceControl = x.this.f14303M.f14400a;
                                Point point = this.f14385d;
                                alpha.setPosition(surfaceControl, point.x, point.y).setPosition(x.this.f14303M.f14403d, ((int) (this.f14384c.width() - x.this.f14313W)) / 2, height).setPosition(x.this.f14328f0, width, i3);
                                B1.l.x1(x.this.f14323d, x.this.f14303M.f14400a, x.this.f14303M.f14425z);
                                x.this.f14323d.apply();
                            }
                        }
                    }
                }
            }
        }
    }

    class k implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Point f14388a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Rect f14389b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f14390c;

        k(Point point, Rect rect, Rect rect2) {
            this.f14388a = point;
            this.f14389b = rect;
            this.f14390c = rect2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            x.this.I0();
            Log.d("ThreeSplitAnimManager", "##### switchToZoomAnimation cancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### switchToZoomAnimation end");
            B1.l.t1(x.this.f14326e0, 20109, false);
            x.this.f14319b.b2();
            x.this.f14319b.getContainerController().B(x.this.f14299I);
            x.this.f14319b.getAdapter().H(0);
            if (x.this.f14308R) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < x.this.f14317a.getCount(); i3++) {
                    arrayList.add(x.this.f14319b.getContainerController().l(i3));
                }
                x.this.f14319b.e3(x.this.f14300J, arrayList, 0);
            }
            for (EmbeddedViewDecor embeddedViewDecor : x.this.f14319b.getChildEmbeddedViewList()) {
                embeddedViewDecor.setControlBarVisibility(0);
                embeddedViewDecor.getFlexibleTaskView().setAlpha(1.0f);
                SurfaceControl m02 = x.this.m0(embeddedViewDecor.getFlexibleTaskView());
                if (x.this.B0(m02)) {
                    x.this.f14323d.setAlpha(m02, 1.0f);
                }
            }
            x.this.f14323d.apply();
            Point point = new Point(this.f14388a.x - ((this.f14389b.width() - this.f14390c.width()) / 2), this.f14388a.y);
            int i4 = point.x;
            Rect rect = new Rect(i4, point.y, x.this.f14322c0.width() + i4, point.y + x.this.f14322c0.height());
            x xVar = x.this;
            xVar.W0(xVar.f14303M.f14420u, rect, x.this.f14318a0);
            Message obtainMessage = x.this.f14342m0.obtainMessage();
            obtainMessage.what = 20;
            x.this.f14342m0.sendMessageDelayed(obtainMessage, 200L);
            B1.h.a(x.this.f14300J).d("drag_to_zoom", x.this.f14319b);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("ThreeSplitAnimManager", "##### switchToZoomAnimation start");
            B1.l.t1(x.this.f14326e0, 20109, true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("animatingSwitchToZoom", true);
            bundle.putInt("androidx.flexible.canvasToZoomTaskId", x.this.f14303M.f14420u);
            B1.l.f(bundle);
            Iterator it = x.this.f14301K.iterator();
            while (it.hasNext()) {
                ((m) it.next()).f();
            }
            x.this.f14323d.apply();
        }
    }

    class l implements ValueAnimator.AnimatorUpdateListener {
        l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            x.this.f14303M.i(floatValue);
            Iterator it = x.this.f14301K.iterator();
            while (it.hasNext()) {
                ((m) it.next()).i(floatValue);
            }
            x.this.f14323d.apply();
        }
    }

    private class m {

        /* renamed from: A, reason: collision with root package name */
        float f14393A;

        /* renamed from: B, reason: collision with root package name */
        float f14394B;

        /* renamed from: a, reason: collision with root package name */
        SurfaceControl f14400a;

        /* renamed from: b, reason: collision with root package name */
        SurfaceControl f14401b;

        /* renamed from: c, reason: collision with root package name */
        SurfaceControl f14402c;

        /* renamed from: d, reason: collision with root package name */
        SurfaceControl f14403d;

        /* renamed from: e, reason: collision with root package name */
        FlexibleTaskView f14404e;

        /* renamed from: f, reason: collision with root package name */
        EmbeddedViewDecor f14405f;

        /* renamed from: s, reason: collision with root package name */
        boolean f14418s;

        /* renamed from: t, reason: collision with root package name */
        C0601d f14419t;

        /* renamed from: u, reason: collision with root package name */
        int f14420u;

        /* renamed from: v, reason: collision with root package name */
        float f14421v;

        /* renamed from: z, reason: collision with root package name */
        float f14425z;

        /* renamed from: g, reason: collision with root package name */
        int f14406g = 0;

        /* renamed from: h, reason: collision with root package name */
        int f14407h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f14408i = 0;

        /* renamed from: j, reason: collision with root package name */
        public Rect f14409j = new Rect();

        /* renamed from: k, reason: collision with root package name */
        public Rect f14410k = new Rect();

        /* renamed from: l, reason: collision with root package name */
        public Rect f14411l = new Rect();

        /* renamed from: m, reason: collision with root package name */
        public Rect f14412m = new Rect();

        /* renamed from: n, reason: collision with root package name */
        public Rect f14413n = new Rect();

        /* renamed from: o, reason: collision with root package name */
        public Point f14414o = new Point();

        /* renamed from: p, reason: collision with root package name */
        public Point f14415p = new Point();

        /* renamed from: q, reason: collision with root package name */
        public Point f14416q = new Point();

        /* renamed from: r, reason: collision with root package name */
        Rect f14417r = new Rect(0, 0, OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT, OplusSearchHighlightUtils.HIGH_LIGHT_TIME_DEFAULT);

        /* renamed from: w, reason: collision with root package name */
        float f14422w = 0.0f;

        /* renamed from: x, reason: collision with root package name */
        float f14423x = 1.0f;

        /* renamed from: y, reason: collision with root package name */
        float f14424y = 40.0f;

        /* renamed from: C, reason: collision with root package name */
        float[] f14395C = {0.0f, 0.0f};

        /* renamed from: D, reason: collision with root package name */
        float[] f14396D = {0.0f, 0.0f};

        /* renamed from: E, reason: collision with root package name */
        float[] f14397E = {1.0f, 1.0f};

        /* renamed from: F, reason: collision with root package name */
        float[] f14398F = {1.0f, 1.0f};

        public m(Rect rect, Rect rect2, EmbeddedViewDecor embeddedViewDecor, boolean z3) {
            this.f14421v = 1.0f;
            this.f14425z = 0.0f;
            this.f14393A = x.this.f14319b.getParentScaleX();
            this.f14394B = x.this.f14319b.getParentScaleY();
            C0601d taskData = embeddedViewDecor.getTaskData();
            this.f14419t = taskData;
            this.f14420u = taskData.s();
            this.f14405f = embeddedViewDecor;
            this.f14409j.set((Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u)));
            this.f14410k.set(rect2);
            this.f14404e = embeddedViewDecor.getFlexibleTaskView();
            this.f14418s = z3;
            this.f14425z = x.this.f14300J.getResources().getDisplayMetrics().density * 12.0f;
            if (z3) {
                this.f14421v = B1.l.R(this.f14404e);
            }
            Log.d("ThreeSplitAnimManager", "AnimationProperty  mInitialRect=" + this.f14409j + " mTargetRect=" + this.f14410k + " mTaskId=" + this.f14420u);
            j();
        }

        private void j() {
            SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
            if (this.f14418s) {
                this.f14400a = B1.l.m(x.this.f14324d0, "toZoomWholeSurface", "initCurSurface", false, x.this.f14298H);
            } else {
                this.f14400a = B1.l.m(x.this.f14326e0, "curWholeSurface", "initCurSurface", false, x.this.f14298H);
            }
            this.f14401b = x.this.m0(this.f14404e);
            Bitmap F02 = x.this.f14319b.F0(x.this.f14319b.getAdapter().getPosition(this.f14419t), this.f14417r);
            SurfaceControl l3 = B1.l.l(this.f14400a, "CUR_DIM", "initCurSurface", false, this.f14417r.width(), this.f14417r.height(), x.this.f14298H);
            this.f14402c = l3;
            B1.l.z(l3, transaction, B1.l.V(F02), this.f14417r.width(), this.f14417r.height(), x.this.f14302L, 0);
            float width = this.f14409j.width() / this.f14417r.width();
            float height = this.f14409j.height() / this.f14417r.height();
            if (this.f14418s) {
                transaction.setLayer(this.f14404e.getSurfaceControl(), 2147483646);
                transaction.setLayer(this.f14400a, Preference.DEFAULT_ORDER).setScale(this.f14402c, width, height);
            } else {
                transaction.setLayer(this.f14400a, 2147483645).setScale(this.f14402c, width, height);
            }
            this.f14403d = B1.l.l(this.f14400a, "ICON", "initCurSurface", false, x.this.f14313W, x.this.f14314X, x.this.f14298H);
            B1.l.z(this.f14403d, transaction, B1.l.j0(x.this.f14300J, B1.l.q0(this.f14419t.k(), this.f14419t.v()), 64, 64), x.this.f14313W, x.this.f14314X, 0, 0);
            if (this.f14418s) {
                x.this.f14297G = this.f14401b;
            }
            Point point = this.f14414o;
            Rect rect = this.f14409j;
            point.set(rect.left, rect.top);
            this.f14411l.set(new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
            Point point2 = this.f14415p;
            Rect rect2 = this.f14410k;
            point2.set(rect2.left, rect2.top);
            this.f14412m.set(new Rect(0, 0, this.f14410k.width(), this.f14410k.height()));
            SurfaceControl.Transaction crop = transaction.setCrop(this.f14400a, new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
            SurfaceControl surfaceControl = this.f14400a;
            Rect rect3 = this.f14409j;
            float width2 = ((int) (this.f14409j.width() - x.this.f14313W)) / 2;
            crop.setPosition(surfaceControl, rect3.left, rect3.right).setPosition(this.f14403d, width2, ((int) (this.f14409j.height() - x.this.f14314X)) / 2).setAlpha(this.f14400a, this.f14422w).setShadowRadius(this.f14400a, this.f14424y).setCornerRadius(this.f14400a, this.f14425z).setLayer(this.f14403d, 2147483646).apply();
            if (this.f14418s) {
                int parseColor = x.this.f14321c.getLightMode() == 0 ? Color.parseColor("#FFF0F8F5") : Color.parseColor("#FF191919");
                int[] iArr = new int[2];
                String string = x.this.f14300J.getString(t1.j.f13637f);
                x xVar = x.this;
                xVar.f14328f0 = B1.l.w(xVar.f14300J, "MotionText", transaction, string, iArr, parseColor, x.this.f14320b0.width());
                this.f14406g = iArr[0];
                this.f14407h = iArr[1];
                this.f14408i = (int) (x.this.f14300J.getResources().getDisplayMetrics().density * 12.0f);
                transaction.setLayer(x.this.f14328f0, Preference.DEFAULT_ORDER).reparent(x.this.f14328f0, this.f14400a).setPosition(x.this.f14328f0, (this.f14410k.width() - this.f14406g) / 2, x.this.f14314X + r1 + this.f14408i).setAlpha(x.this.f14328f0, 0.0f).setPosition(this.f14403d, width2, (this.f14410k.height() - ((x.this.f14314X + this.f14407h) + this.f14408i)) / 2).show(x.this.f14328f0).apply();
            }
        }

        private void k(SurfaceControl surfaceControl) {
            if (surfaceControl == null || !surfaceControl.isValid()) {
                return;
            }
            x.this.f14323d.remove(surfaceControl);
        }

        public void a() {
            this.f14414o.set((int) (x.this.f14306P.x + (((this.f14409j.width() - this.f14411l.width()) * 1.0f) / 2.0f)), (int) x.this.f14306P.y);
            if (x.this.B0(this.f14400a)) {
                SurfaceControl.Transaction transaction = x.this.f14323d;
                SurfaceControl surfaceControl = this.f14400a;
                Point point = this.f14414o;
                transaction.setPosition(surfaceControl, point.x, point.y).apply();
            }
        }

        public void b(int i3) {
            Log.d("ThreeSplitAnimManager", "adjustTargetProperty  state=" + i3 + " mBeforeUpState=" + x.this.f14363x + " mTaskId=" + this.f14420u);
            if (x.this.f14348p0 != null && x.this.f14348p0.isRunning()) {
                Log.d("ThreeSplitAnimManager", "adjustTargetProperty need end mMoveScaleDownAnimatorSet");
                x.this.f14348p0.end();
            }
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            if (i3 == 2) {
                this.f14424y = 0.0f;
                if (this.f14418s) {
                    this.f14412m.set(new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
                    Point point = this.f14415p;
                    Rect rect3 = this.f14409j;
                    point.set(rect3.left, rect3.top);
                } else {
                    rect = new Rect((Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u)));
                    this.f14412m.set(new Rect(0, 0, rect.width(), rect.height()));
                    this.f14415p.set(rect.left, rect.top);
                    rect2 = x.this.o0(this.f14405f);
                }
            } else if (i3 == 4) {
                if (x.this.f14295E != null && x.this.f14295E.isRunning()) {
                    x.this.f14295E.end();
                }
                this.f14422w = 1.0f;
                this.f14423x = 0.0f;
                this.f14424y = 40.0f;
                this.f14412m.set(new Rect(0, 0, this.f14410k.width(), this.f14410k.height()));
                Point point2 = this.f14415p;
                Rect rect4 = this.f14410k;
                point2.set(rect4.left, rect4.top);
                if (!this.f14418s) {
                    rect = (Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u));
                    rect2 = x.this.o0(this.f14405f);
                }
            } else if (i3 == 6) {
                this.f14424y = 0.0f;
                if (this.f14418s) {
                    this.f14412m.set(new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
                    Point point3 = this.f14415p;
                    Rect rect5 = this.f14409j;
                    point3.set(rect5.left, rect5.top);
                } else {
                    rect = new Rect((Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u)));
                    this.f14412m.set(new Rect(0, 0, rect.width(), rect.height()));
                    this.f14415p.set(rect.left, rect.top);
                    rect2 = x.this.o0(this.f14405f);
                }
            } else if (i3 == 8) {
                this.f14424y = 0.0f;
                if (this.f14418s) {
                    this.f14412m.set(new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
                    Point point4 = this.f14415p;
                    Rect rect6 = this.f14409j;
                    point4.set(rect6.left, rect6.top);
                } else {
                    rect = new Rect((Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u)));
                    this.f14412m.set(new Rect(0, 0, rect.width(), rect.height()));
                    this.f14415p.set(rect.left, rect.top);
                    rect2 = x.this.o0(this.f14405f);
                }
            } else if (i3 == 10) {
                this.f14424y = 0.0f;
                if (this.f14418s) {
                    this.f14412m.set(new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
                    Point point5 = this.f14415p;
                    Rect rect7 = this.f14409j;
                    point5.set(rect7.left, rect7.top);
                } else {
                    rect = new Rect((Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u)));
                    this.f14412m.set(new Rect(0, 0, rect.width(), rect.height()));
                    this.f14415p.set(rect.left, rect.top);
                    rect2 = x.this.o0(this.f14405f);
                }
            } else if (i3 == 12) {
                this.f14424y = 0.0f;
                if (this.f14418s) {
                    this.f14412m.set(new Rect(0, 0, this.f14409j.width(), this.f14409j.height()));
                    Point point6 = this.f14415p;
                    Rect rect8 = this.f14409j;
                    point6.set(rect8.left, rect8.top);
                } else {
                    rect = new Rect((Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u)));
                    this.f14412m.set(new Rect(0, 0, rect.width(), rect.height()));
                    this.f14415p.set(rect.left, rect.top);
                    rect2 = x.this.o0(this.f14405f);
                }
            } else if (i3 == 14) {
                rect = (Rect) x.this.f14360v0.get(Integer.valueOf(this.f14420u));
                if (x.this.f14363x == 2 || x.this.f14363x == 1 || x.this.f14363x == 8 || x.this.f14363x == 7 || x.this.f14363x == 6 || x.this.f14363x == 5 || x.this.f14363x == 10 || x.this.f14363x == 9 || x.this.f14363x == 12 || x.this.f14363x == 11) {
                    this.f14412m.set(new Rect(0, 0, rect.width(), rect.height()));
                    this.f14415p.set(rect.left, rect.top);
                }
                rect2 = x.this.o0(this.f14405f);
            }
            this.f14413n.set(this.f14411l);
            this.f14416q.set(this.f14414o);
            this.f14396D[0] = this.f14405f.getTranslationX();
            this.f14396D[1] = this.f14405f.getTranslationY();
            this.f14398F[0] = this.f14405f.getScaleX();
            this.f14398F[1] = this.f14405f.getScaleY();
            this.f14395C[0] = this.f14396D[0] + ((rect.centerX() - rect2.centerX()) / this.f14393A);
            this.f14395C[1] = this.f14396D[1] + ((rect.centerY() - rect2.centerY()) / this.f14394B);
            this.f14397E[0] = (rect.width() * this.f14398F[0]) / rect2.width();
            this.f14397E[1] = (rect.height() * this.f14398F[1]) / rect2.height();
            Log.d("ThreeSplitAnimManager", "adjustTargetProperty  mTmpCurrentTranslation=" + this.f14396D[0] + " mTmpCurrentTranslation=" + this.f14396D[1] + " mTmpCurrentScale=" + this.f14398F[0] + " mTmpCurrentScale=" + this.f14398F[1] + " mTargetTranslation=" + this.f14395C[0] + " mTargetTranslation=" + this.f14395C[1] + " mTargetScale=" + this.f14397E[0] + " mTargetScale=" + this.f14397E[1]);
        }

        public float c() {
            return Math.min(1.0f, Math.max(Math.max(Math.max(Math.max(Math.max((Math.abs(this.f14415p.x - this.f14414o.x) * 2) / x.this.f14311U, (Math.abs(this.f14415p.y - this.f14414o.y) * 2) / x.this.f14311U), (Math.abs(this.f14412m.left - this.f14411l.left) * 2) / x.this.f14311U), (Math.abs(this.f14412m.top - this.f14411l.top) * 2) / x.this.f14311U), (Math.abs(this.f14412m.right - this.f14411l.right) * 2) / x.this.f14311U), (Math.abs(this.f14412m.bottom - this.f14411l.bottom) * 2) / x.this.f14311U));
        }

        public void d(float f3) {
            if (!(this.f14412m.equals(this.f14413n) && this.f14415p.equals(this.f14414o)) && x.this.B0(this.f14402c) && x.this.B0(this.f14400a) && x.this.B0(this.f14401b) && x.this.B0(this.f14403d)) {
                Rect rect = new Rect();
                Point point = new Point();
                rect.set((int) B1.l.p(f3, this.f14412m.left, this.f14413n.left), (int) B1.l.p(f3, this.f14412m.top, this.f14413n.top), (int) B1.l.p(f3, this.f14412m.right, this.f14413n.right), (int) B1.l.p(f3, this.f14412m.bottom, this.f14413n.bottom));
                this.f14411l.set(rect);
                float width = rect.width() / this.f14417r.width();
                float height = rect.height() / this.f14417r.height();
                int width2 = ((int) (rect.width() - x.this.f14313W)) / 2;
                int height2 = ((int) (rect.height() - x.this.f14314X)) / 2;
                point.set((int) B1.l.p(f3, this.f14415p.x, this.f14416q.x), (int) B1.l.p(f3, this.f14415p.y, this.f14416q.y));
                this.f14414o.set(point);
                if (this.f14418s) {
                    height2 = (rect.height() - ((x.this.f14314X + this.f14407h) + this.f14408i)) / 2;
                    if (x.this.f14361w != 14) {
                        this.f14414o.set((int) (x.this.f14306P.x + (((this.f14409j.width() - rect.width()) * 1.0f) / 2.0f)), (int) x.this.f14306P.y);
                    }
                }
                SurfaceControl.Transaction crop = x.this.f14323d.setScale(this.f14402c, width, height).setCrop(this.f14400a, new Rect(0, 0, rect.width(), rect.height()));
                SurfaceControl surfaceControl = this.f14400a;
                Point point2 = this.f14414o;
                crop.setPosition(surfaceControl, point2.x, point2.y).setAlpha(this.f14400a, this.f14422w).setShadowRadius(this.f14400a, this.f14424y).setAlpha(this.f14401b, this.f14423x).setPosition(this.f14403d, width2, height2);
                if (this.f14423x != 0.0f || this.f14404e.getAlpha() == 0.0f) {
                    return;
                }
                this.f14404e.setAlpha(0.0f);
                if (this.f14418s) {
                    return;
                }
                this.f14405f.setControlBarVisibility(4);
            }
        }

        public void e(float f3) {
            if (this.f14405f == null) {
                return;
            }
            float p3 = B1.l.p(f3, this.f14397E[0], this.f14398F[0]);
            float p4 = B1.l.p(f3, this.f14397E[1], this.f14398F[1]);
            float p5 = B1.l.p(f3, this.f14395C[0], this.f14396D[0]);
            float p6 = B1.l.p(f3, this.f14395C[1], this.f14396D[1]);
            if (this.f14397E[0] != this.f14398F[0]) {
                this.f14405f.setScaleX(p3);
            }
            if (this.f14397E[1] != this.f14398F[1]) {
                this.f14405f.setScaleY(p4);
            }
            if (this.f14395C[0] != this.f14396D[0]) {
                this.f14405f.setTranslationX(p5);
            }
            if (this.f14395C[1] != this.f14396D[1]) {
                this.f14405f.setTranslationY(p6);
            }
        }

        public void f() {
            this.f14396D[0] = this.f14405f.getTranslationX();
            this.f14396D[1] = this.f14405f.getTranslationY();
            this.f14398F[0] = this.f14405f.getScaleX();
            this.f14398F[1] = this.f14405f.getScaleY();
            Rect o02 = x.this.o0(this.f14405f);
            this.f14395C[0] = this.f14396D[0] + ((this.f14410k.centerX() - o02.centerX()) / this.f14393A);
            this.f14395C[1] = this.f14396D[1] + ((this.f14410k.centerY() - o02.centerY()) / this.f14394B);
            this.f14397E[0] = (this.f14410k.width() * this.f14398F[0]) / o02.width();
            this.f14397E[1] = (this.f14410k.height() * this.f14398F[1]) / o02.height();
            e(1.0f);
        }

        public Point g() {
            return this.f14414o;
        }

        public float h() {
            return this.f14422w;
        }

        public void i(float f3) {
            float f4 = 1.0f - f3;
            this.f14422w = f4;
            this.f14424y = f4 * 40.0f;
            if (x.this.B0(this.f14400a)) {
                x.this.f14323d.setAlpha(this.f14400a, this.f14422w).setShadowRadius(this.f14400a, this.f14424y);
            }
        }

        public void l() {
            k(this.f14402c);
            k(this.f14403d);
            k(this.f14400a);
            this.f14402c = null;
            this.f14403d = null;
            this.f14400a = null;
        }

        public void m(float f3) {
            this.f14423x = f3;
            if (x.this.B0(this.f14401b)) {
                x.this.f14323d.setAlpha(this.f14401b, this.f14423x);
            }
            if (this.f14423x == 1.0f) {
                this.f14404e.setAlpha(1.0f);
                if (this.f14418s) {
                    return;
                }
                this.f14405f.setControlBarVisibility(0);
            }
        }

        public void n(float f3) {
            this.f14422w = f3;
            if (x.this.B0(this.f14400a)) {
                x.this.f14323d.setAlpha(this.f14400a, this.f14422w);
            }
        }
    }

    public x(Context context, C0600c c0600c, ContainerView containerView) {
        this.f14300J = context;
        this.f14317a = c0600c;
        this.f14319b = containerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B0(SurfaceControl surfaceControl) {
        return surfaceControl != null && surfaceControl.isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        B1.l.h1(this.f14299I.s(), 2205, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean F0() {
        m mVar = this.f14303M;
        if (mVar == null) {
            return false;
        }
        boolean z3 = mVar.h() != 0.0f;
        Iterator it = this.f14301K.iterator();
        while (it.hasNext()) {
            if (((m) it.next()).h() == 0.0f) {
                return false;
            }
        }
        return z3;
    }

    private void G0(float f3, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f14296F = ofFloat;
        ofFloat.setDuration(400L);
        this.f14296F.setInterpolator(new Y.e());
        this.f14296F.addUpdateListener(new e(i3));
        this.f14296F.addListener(new f(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        Log.d("ThreeSplitAnimManager", "resetDragAnimation caller : " + Debug.getCallers(5));
        ValueAnimator valueAnimator = this.f14295E;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14310T = true;
            return;
        }
        ArrayList arrayList = this.f14301K;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((m) it.next()).l();
            }
            this.f14301K.clear();
        }
        m mVar = this.f14303M;
        if (mVar != null) {
            mVar.l();
            this.f14303M = null;
        }
        SurfaceControl surfaceControl = this.f14326e0;
        if (surfaceControl != null) {
            if (surfaceControl.isValid()) {
                this.f14323d.remove(this.f14326e0);
            }
            this.f14326e0 = null;
        }
        SurfaceControl surfaceControl2 = this.f14328f0;
        if (surfaceControl2 != null) {
            if (surfaceControl2.isValid()) {
                this.f14323d.remove(this.f14328f0);
            }
            this.f14328f0 = null;
        }
        this.f14323d.apply();
        this.f14297G = null;
        this.f14324d0 = null;
        this.f14361w = 0;
        H0();
    }

    private void J0() {
        if (this.f14323d == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f14317a.getCount(); i3++) {
            EmbeddedViewDecor q02 = this.f14319b.q0(i3);
            if (q02.getFlexibleTaskView() != null && B0(q02.getFlexibleTaskView().getSurfaceControl())) {
                this.f14323d.setCornerRadius(q02.getFlexibleTaskView().getSurfaceControl(), 0.0f);
                q02.getFlexibleTaskView().surfaceReplaced(this.f14323d);
            }
        }
        this.f14323d.apply();
        this.f14323d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        if (this.f14303M == null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        if (B0(this.f14297G) && B0(this.f14303M.f14400a) && B0(this.f14303M.f14402c) && B0(this.f14303M.f14403d) && B0(this.f14328f0)) {
            float width = (this.f14315Y.width() - this.f14313W) / (this.f14318a0 * 2.0f);
            int height = this.f14315Y.height();
            int i3 = this.f14314X;
            m mVar = this.f14303M;
            float f3 = (height - ((i3 + mVar.f14407h) + mVar.f14408i)) / (this.f14318a0 * 2.0f);
            int width2 = this.f14315Y.width();
            m mVar2 = this.f14303M;
            float f4 = width2 - mVar2.f14406g;
            float f5 = this.f14318a0;
            float f6 = f4 / (2.0f * f5);
            float f7 = ((this.f14314X + mVar2.f14408i) / f5) + f3;
            SurfaceControl.Transaction alpha = this.f14323d.setMetadata(mVar2.f14400a, 101, 1).reparent(this.f14303M.f14400a, this.f14297G).setCrop(this.f14303M.f14400a, new Rect(0, 0, this.f14322c0.width(), this.f14322c0.height())).setPosition(this.f14303M.f14400a, 0.0f, 0.0f).setScale(this.f14303M.f14402c, this.f14315Y.width() / (this.f14303M.f14417r.width() * this.f14318a0), this.f14315Y.height() / (this.f14303M.f14417r.height() * this.f14318a0)).setAlpha(this.f14297G, this.f14303M.f14421v);
            SurfaceControl surfaceControl = this.f14303M.f14403d;
            float f8 = this.f14318a0;
            SurfaceControl.Transaction position = alpha.setScale(surfaceControl, 1.0f / f8, 1.0f / f8).setPosition(this.f14303M.f14403d, width, f3);
            SurfaceControl surfaceControl2 = this.f14328f0;
            float f9 = this.f14318a0;
            position.setScale(surfaceControl2, 1.0f / f9, 1.0f / f9).setPosition(this.f14328f0, f6, f7);
        }
        this.f14323d.apply();
        C0305a.a().b(new Runnable() { // from class: x1.w
            @Override // java.lang.Runnable
            public final void run() {
                x.this.E0();
            }
        });
        this.f14319b.getContainerController().A(this.f14317a.getCount());
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new Y.e());
        ofFloat.addUpdateListener(new l());
        ofFloat.addListener(new a());
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(AnimatorSet animatorSet, List list, int i3, int i4, TimeInterpolator timeInterpolator) {
        animatorSet.playTogether(list);
        animatorSet.setInterpolator(timeInterpolator);
        animatorSet.setDuration(i3);
        animatorSet.addListener(new c(i4));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(int i3, Rect rect, float f3) {
        if (B0(this.f14297G)) {
            this.f14323d.setAlpha(this.f14297G, 0.0f);
        }
        this.f14323d.apply();
        Log.d("ThreeSplitAnimManager", "switchToZoom taskId: " + i3);
        B1.l.g(i3, rect, f3);
    }

    private void X0() {
        if (this.f14303M == null) {
            return;
        }
        Point point = new Point(this.f14303M.g());
        Point point2 = new Point();
        Rect rect = new Rect();
        Rect rect2 = new Rect(this.f14320b0);
        Rect rect3 = new Rect(0, 0, this.f14315Y.width(), this.f14315Y.height());
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new Y.e());
        ofFloat.addUpdateListener(new j(rect3, rect2, rect, point2, point));
        ofFloat.addListener(new k(point, rect3, rect2));
        ofFloat.start();
    }

    private void Y0(int i3) {
        d1(i3);
        a1(i3);
        b1(this.f14354s0, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        boolean z3;
        for (EmbeddedViewDecor embeddedViewDecor : this.f14319b.getChildEmbeddedViewList()) {
            embeddedViewDecor.getFlexibleTaskView().setAlpha(1.0f);
            SurfaceControl m02 = m0(embeddedViewDecor.getFlexibleTaskView());
            if (B0(m02)) {
                this.f14323d.setAlpha(m02, 1.0f);
            }
        }
        this.f14323d.apply();
        List l3 = this.f14317a.l();
        this.f14317a.X(this.f14354s0);
        if (l3.equals(this.f14354s0)) {
            z3 = false;
        } else {
            this.f14317a.N(this.f14354s0);
            this.f14317a.D();
            this.f14317a.E();
            z3 = true;
        }
        this.f14319b.T2();
        C0600c c0600c = this.f14317a;
        int i3 = this.f14355t;
        if (i3 == -1) {
            i3 = this.f14327f;
        }
        c0600c.H(i3);
        this.f14319b.b2();
        this.f14317a.notifyDataSetChanged();
        this.f14319b.setSplitBarVisibility(0);
        this.f14319b.setControlBarVisibility(0);
        this.f14319b.setNeedUpdateFlexibleTaskViewFrameFlag(true);
        if (z3) {
            B1.h.a(this.f14300J).d("drag_swap", this.f14319b);
        }
    }

    private List b0(List list) {
        if (list != null && list.size() != 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.set(i3, c0((Rect) list.get(i3)));
            }
        }
        return list;
    }

    private Rect c0(Rect rect) {
        int[] iArr = this.f14352r0;
        int[] iArr2 = {iArr[0] - rect.left, iArr[1] - rect.top};
        PointF pointF = new PointF(iArr2[0] * 0.029999971f, iArr2[1] * 0.029999971f);
        int i3 = (int) (rect.left + pointF.x);
        rect.left = i3;
        int i4 = (int) (rect.top + pointF.y);
        rect.top = i4;
        rect.right = i3 + ((int) (rect.width() * 0.97f));
        rect.bottom = i4 + ((int) (rect.height() * 0.97f));
        return rect;
    }

    private List h0(EmbeddedViewDecor embeddedViewDecor, Rect rect) {
        Rect o02 = o0(embeddedViewDecor);
        float width = (rect.width() * 1.0f) / o02.width();
        float height = (rect.height() * 1.0f) / o02.height();
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "current view rect: " + o02 + ", target view rect: " + rect);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(embeddedViewDecor, "scaleX", embeddedViewDecor.getScaleX(), embeddedViewDecor.getScaleX() * width);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(embeddedViewDecor, "scaleY", embeddedViewDecor.getScaleY(), embeddedViewDecor.getScaleY() * height);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }

    private List i0(EmbeddedViewDecor embeddedViewDecor, Rect rect) {
        float parentScaleX = this.f14319b.getParentScaleX();
        float parentScaleY = this.f14319b.getParentScaleY();
        Rect o02 = o0(embeddedViewDecor);
        float width = (rect.width() * 1.0f) / o02.width();
        float height = (rect.height() * 1.0f) / o02.height();
        float translationX = embeddedViewDecor.getTranslationX();
        float translationY = embeddedViewDecor.getTranslationY();
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "current view rect: " + o02 + ", target view rect: " + rect);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(embeddedViewDecor, "scaleX", embeddedViewDecor.getScaleX(), embeddedViewDecor.getScaleX() * width);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(embeddedViewDecor, "scaleY", embeddedViewDecor.getScaleY(), embeddedViewDecor.getScaleY() * height);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(embeddedViewDecor, "TranslationX", translationX, ((rect.centerX() - o02.centerX()) / parentScaleX) + translationX);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(embeddedViewDecor, "TranslationY", translationY, ((rect.centerY() - o02.centerY()) / parentScaleY) + translationY);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        return arrayList;
    }

    private void k0() {
        int n3 = this.f14317a.n();
        Rect containerGroupRect = this.f14319b.getContainerGroupRect();
        if (n3 == 5 || n3 == 4) {
            if (this.f14331h != -1) {
                if (this.f14327f > this.f14333i) {
                    Rect rect = this.f14334i0;
                    rect.set(containerGroupRect.left, rect.top, rect.right, rect.bottom);
                } else {
                    Rect rect2 = this.f14334i0;
                    rect2.set(rect2.left, rect2.top, containerGroupRect.right, rect2.bottom);
                }
            }
            Rect rect3 = this.f14336j0;
            rect3.set(containerGroupRect.left, rect3.top, containerGroupRect.right, rect3.bottom);
            return;
        }
        if (n3 == 7 || n3 == 6) {
            if (this.f14331h != -1) {
                if (this.f14327f > this.f14333i) {
                    Rect rect4 = this.f14334i0;
                    rect4.set(rect4.left, containerGroupRect.top, rect4.right, rect4.bottom);
                } else {
                    Rect rect5 = this.f14334i0;
                    rect5.set(rect5.left, rect5.top, rect5.right, containerGroupRect.bottom);
                }
            }
            Rect rect6 = this.f14336j0;
            rect6.set(rect6.left, containerGroupRect.top, rect6.right, containerGroupRect.bottom);
            return;
        }
        if (n3 == 3) {
            if (this.f14349q.height() > this.f14349q.width()) {
                Rect rect7 = this.f14349q;
                rect7.set(rect7.left, containerGroupRect.top, rect7.right, containerGroupRect.bottom);
                Rect rect8 = this.f14351r;
                rect8.set(rect8.left, containerGroupRect.top, rect8.right, containerGroupRect.bottom);
                return;
            }
            Rect rect9 = this.f14349q;
            rect9.set(containerGroupRect.left, rect9.top, containerGroupRect.right, rect9.bottom);
            Rect rect10 = this.f14351r;
            rect10.set(containerGroupRect.left, rect10.top, containerGroupRect.right, rect10.bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        Log.d("ThreeSplitAnimManager", "finishAnimationWhenUp mBeforeUpState=" + this.f14363x + " caller: " + Debug.getCallers(3));
        int i3 = this.f14363x;
        if (i3 == 4 || i3 == 3) {
            X0();
            B1.l.q1();
        } else if (i3 == 2 || i3 == 1 || i3 == 0) {
            Z0();
            I0();
        } else if (i3 == 6 || i3 == 5 || i3 == 8 || i3 == 7 || i3 == 10 || i3 == 9 || i3 == 12 || i3 == 11) {
            Z0();
            I0();
        }
        this.f14364x0 = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SurfaceControl m0(FlexibleTaskView flexibleTaskView) {
        try {
            Field declaredField = flexibleTaskView.getClass().getDeclaredField("mTaskLeash");
            declaredField.setAccessible(true);
            return (SurfaceControl) declaredField.get(flexibleTaskView);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i3) {
        Log.d("ThreeSplitAnimManager", "handleStateChange transfer to:" + i3 + " mCurrentAnimationState:" + this.f14361w);
        int i4 = this.f14361w;
        if (i3 == i4 || i3 == i4 - 1) {
            return;
        }
        if (i3 == 1 && this.f14363x == 0) {
            this.f14361w = i3;
            return;
        }
        this.f14363x = i4;
        if (i3 == 13 && (i4 == 4 || i4 == 3)) {
            this.f14361w = 13;
            if (z0()) {
                return;
            }
            l0();
            return;
        }
        this.f14361w = i3 + 1;
        d0();
        if (this.f14361w == 14) {
            int n3 = this.f14317a.n();
            int i5 = this.f14327f;
            if (n3 == 3 && i5 == 1) {
                i5 = this.f14355t;
            }
            if (this.f14308R && n3 == 3) {
                i5 = 0;
            }
            List d12 = B1.l.d1(this.f14319b.getContext(), this.f14354s0, i5, n3, false);
            this.f14360v0.clear();
            for (int i6 = 0; i6 < this.f14354s0.size(); i6++) {
                if (this.f14354s0.get(i6) != null) {
                    this.f14360v0.put(Integer.valueOf(((C0601d) this.f14354s0.get(i6)).s()), (Rect) d12.get(i6));
                }
            }
        }
        m mVar = this.f14303M;
        if (mVar != null) {
            mVar.b(this.f14361w);
        }
        Iterator it = this.f14301K.iterator();
        while (it.hasNext()) {
            ((m) it.next()).b(this.f14361w);
        }
        m mVar2 = this.f14303M;
        float max = Math.max(0.0f, mVar2 != null ? mVar2.c() : 0.0f);
        Iterator it2 = this.f14301K.iterator();
        while (it2.hasNext()) {
            max = Math.max(max, ((m) it2.next()).c());
        }
        Log.d("ThreeSplitAnimManager", "animationProgress=" + max + " mCurrentAnimationState:" + this.f14361w);
        if (max > 0.0f) {
            G0(max, this.f14361w);
            T0();
            return;
        }
        int i7 = this.f14361w - 1;
        this.f14361w = i7;
        if (i7 != 13 || z0()) {
            return;
        }
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(int i3) {
        int i4;
        Message obtainMessage = this.f14342m0.obtainMessage();
        obtainMessage.what = 30;
        switch (i3) {
            case 1:
                int i5 = this.f14361w;
                if (i5 != 1 && i5 != 2) {
                    obtainMessage.obj = 1;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
            case 2:
                EmbeddedViewDecor embeddedViewDecor = this.f14321c;
                if (B1.l.k(embeddedViewDecor != null ? embeddedViewDecor.getTaskData() : null, null) && (i4 = this.f14361w) != 3 && i4 != 4) {
                    obtainMessage.obj = 3;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
            case 3:
                int i6 = this.f14361w;
                if (i6 != 5 && i6 != 6) {
                    obtainMessage.obj = 5;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
            case 4:
                int i7 = this.f14361w;
                if (i7 != 7 && i7 != 8) {
                    obtainMessage.obj = 7;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
            case 5:
                int i8 = this.f14361w;
                if (i8 != 13 && i8 != 14) {
                    obtainMessage.obj = 13;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
            case 6:
                int i9 = this.f14361w;
                if (i9 != 9 && i9 != 10) {
                    obtainMessage.obj = 9;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
            case 7:
                int i10 = this.f14361w;
                if (i10 != 11 && i10 != 12) {
                    obtainMessage.obj = 11;
                    this.f14342m0.sendMessage(obtainMessage);
                    break;
                }
                break;
        }
    }

    private void t0(int i3, int i4) {
        Log.d("ThreeSplitAnimManager", "handleUpInZoomRegion not staying for enough time, x=" + i3 + " y=" + i4);
        if (this.f14338k0.contains(i3, i4)) {
            c1();
            return;
        }
        if (this.f14334i0.contains(i3, i4)) {
            Y0(0);
            return;
        }
        if (this.f14336j0.contains(i3, i4)) {
            Y0(1);
            return;
        }
        if (this.f14349q.contains(i3, i4)) {
            this.f14353s = this.f14341m;
            Y0(2);
        } else if (this.f14351r.contains(i3, i4)) {
            this.f14353s = this.f14345o;
            Y0(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public Boolean D0() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 3; i3++) {
            if (i3 != this.f14325e) {
                arrayList.add(this.f14319b.getContainerController().l(i3));
            }
        }
        if (this.f14308R) {
            this.f14319b.e3(this.f14300J, arrayList, 0);
        }
        List c12 = B1.l.c1(this.f14300J, arrayList, 0, false);
        if (B1.s.J(this.f14300J) && B1.l.u0()) {
            Iterator it = c12.iterator();
            while (it.hasNext()) {
                ((Rect) it.next()).offset(0, B1.l.O1(this.f14300J).G0());
            }
        }
        if (this.f14308R) {
            this.f14319b.e3(this.f14300J, arrayList, this.f14366z);
        }
        c12.add(this.f14325e, new Rect());
        for (int i4 = 0; i4 < 3; i4++) {
            if (i4 != this.f14325e) {
                EmbeddedViewDecor q02 = this.f14319b.q0(i4);
                Rect rect = new Rect((Rect) c12.get(i4));
                rect.intersect(this.f14330g0);
                this.f14301K.add(new m(o0(q02), rect, q02, false));
            }
        }
        Log.d("ThreeSplitAnimManager", "initNoMotionAnimSource success");
        return Boolean.TRUE;
    }

    private boolean w0() {
        C0601d taskData = this.f14321c.getTaskData();
        if (taskData == null || taskData.f() == null) {
            return false;
        }
        Intent cloneFilter = taskData.f().cloneFilter();
        cloneFilter.putExtra("androidx.activity.LaunchScenario", 1);
        cloneFilter.putExtra("androidx.activity.LaunchEmbeddedTaskId", taskData.s());
        if (taskData.t() != null && !TextUtils.isEmpty(taskData.t().getPackageName())) {
            B1.l.z1(cloneFilter, taskData.t());
        }
        Bundle o3 = B1.l.o(cloneFilter, -2, 0);
        this.f14322c0 = (Rect) o3.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
        this.f14318a0 = o3.getFloat("androidx.activity.LaunchScale", 1.0f);
        Rect rect = this.f14322c0;
        if (rect == null || rect.isEmpty()) {
            float f3 = this.f14300J.getResources().getDisplayMetrics().density;
            this.f14322c0 = new Rect(0, 0, (int) (132.0f * f3 * 2.0f), (int) (f3 * 235.0f * 2.0f));
            Log.w("ThreeSplitAnimManager", "zoomRect is empty, use default value");
        }
        this.f14316Z = o3.getInt("androidx.activity.LaunchCornerRadius", 0);
        Rect rect2 = this.f14322c0;
        int i3 = rect2.left;
        this.f14315Y = new Rect(i3, rect2.top, ((int) (rect2.width() * this.f14318a0)) + i3, this.f14322c0.top + ((int) (r8.height() * this.f14318a0)));
        Rect rect3 = new Rect();
        this.f14320b0 = new Rect(0, 0, this.f14322c0.width() / 2, this.f14322c0.height() / 2);
        int width = (int) (((this.f14338k0.width() * 0.97f) - this.f14320b0.width()) / 2.0f);
        rect3.set(width, 0, this.f14320b0.width() + width, this.f14320b0.height());
        this.f14303M = new m(this.f14338k0, rect3, this.f14321c, true);
        Log.d("ThreeSplitAnimManager", "initToZoomAnimSource success");
        return true;
    }

    public boolean A0() {
        return this.f14321c != null;
    }

    public boolean C0(int i3, List list) {
        if (i3 != 0) {
            return false;
        }
        Rect rect = (Rect) this.f14360v0.get(Integer.valueOf(((C0601d) list.get(this.f14327f)).s()));
        Rect rect2 = (Rect) this.f14360v0.get(Integer.valueOf(((C0601d) list.get(this.f14333i)).s()));
        Rect rect3 = new Rect(0, 0, this.f14311U, this.f14312V);
        if (rect3.contains(rect) && rect3.contains(rect2)) {
            return false;
        }
        this.f14292B = true;
        return true;
    }

    public void H0() {
        Log.d("ThreeSplitAnimManager", "resetAll caller : " + Debug.getCallers(5));
        this.f14291A = false;
        this.f14292B = false;
        this.f14293C = false;
        this.f14309S = false;
        this.f14350q0 = false;
        this.f14336j0 = new Rect();
        this.f14334i0 = new Rect();
        this.f14338k0 = new Rect();
        this.f14349q = new Rect();
        this.f14351r = new Rect();
        this.f14357u.clear();
        this.f14359v.clear();
        this.f14354s0.clear();
        this.f14356t0.clear();
        this.f14358u0.clear();
        this.f14360v0.clear();
        this.f14362w0.clear();
        this.f14331h = -1;
        this.f14325e = -1;
        this.f14353s = -1;
        this.f14355t = -1;
        this.f14337k = -1;
        this.f14339l = -1;
        J0();
        this.f14321c = null;
    }

    public void K0() {
        List<EmbeddedViewDecor> childEmbeddedViewList = this.f14319b.getChildEmbeddedViewList();
        if (childEmbeddedViewList.size() > 0) {
            for (int i3 = 0; i3 < childEmbeddedViewList.size(); i3++) {
                EmbeddedViewDecor embeddedViewDecor = childEmbeddedViewList.get(i3);
                embeddedViewDecor.setPivotX(embeddedViewDecor.getWidth() / 2.0f);
                embeddedViewDecor.setPivotY(embeddedViewDecor.getHeight() / 2.0f);
            }
        }
    }

    public void L0(PointF pointF, C0631a c0631a) {
        this.f14305O.set(pointF);
        float f3 = this.f14340l0.left + (pointF.x - c0631a.f().x);
        float f4 = this.f14340l0.top + (pointF.y - c0631a.f().y);
        PointF pointF2 = this.f14306P;
        PointF pointF3 = this.f14304N;
        pointF2.set(f3 + pointF3.x, f4 + pointF3.y);
        m mVar = this.f14303M;
        if (mVar != null) {
            mVar.a();
        }
    }

    public void M0(List list) {
        boolean z3 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                z3 = true;
                break;
            } else if (!this.f14330g0.contains((Rect) list.get(i3))) {
                break;
            } else {
                i3++;
            }
        }
        this.f14308R = z3;
        Log.d("ThreeSplitAnimManager", "setIsDisplayedInScreen mIsDisplayedInScreen=" + this.f14308R);
    }

    public void N0(EmbeddedViewDecor embeddedViewDecor) {
        this.f14321c = embeddedViewDecor;
    }

    public void O0(int i3, int i4) {
        this.f14311U = i3;
        this.f14312V = i4;
        this.f14352r0 = new int[]{i3 / 2, i4 / 2};
    }

    public void P0(SurfaceControl.Transaction transaction) {
        this.f14323d = transaction;
    }

    public void Q0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f14295E = ofFloat;
        ofFloat.addUpdateListener(new g());
        this.f14295E.setDuration(400L);
        this.f14295E.setInterpolator(new Y.e());
        this.f14295E.addListener(new h());
        this.f14295E.start();
    }

    public void R0(boolean z3) {
        if (this.f14338k0.isEmpty()) {
            return;
        }
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "startBackToPositionAnim noMoveLongPress=" + z3);
        }
        int n3 = this.f14317a.n();
        int i3 = this.f14327f;
        if (n3 == 3 && i3 == 1) {
            if (this.f14355t == -1) {
                if (this.f14317a.u() == 1 || this.f14317a.u() == 0) {
                    this.f14355t = 0;
                } else if (this.f14317a.u() == 2) {
                    this.f14355t = 2;
                }
            }
            this.f14350q0 = true;
            i3 = this.f14355t;
        }
        if (this.f14308R && n3 == 3) {
            i3 = 0;
        }
        List d12 = B1.l.d1(this.f14319b.getContext(), this.f14354s0, i3, n3, false);
        ArrayList arrayList = new ArrayList(i0(this.f14321c, (Rect) d12.get(this.f14327f)));
        if (n3 == 3) {
            arrayList.addAll(i0(this.f14319b.q0(this.f14337k), (Rect) d12.get(this.f14341m)));
            arrayList.addAll(i0(this.f14319b.q0(this.f14339l), (Rect) d12.get(this.f14345o)));
        } else {
            for (int i4 = 0; i4 < this.f14357u.size(); i4++) {
                arrayList.addAll(i0(this.f14319b.q0(((Integer) this.f14357u.get(i4)).intValue()), (Rect) d12.get(((Integer) this.f14359v.get(i4)).intValue())));
            }
        }
        this.f14344n0 = new AnimatorSet();
        this.f14342m0.post(new i(arrayList));
    }

    protected void T0() {
        this.f14307Q = false;
        ValueAnimator clone = this.f14296F.clone();
        this.f14294D = clone;
        this.f14296F = null;
        clone.start();
    }

    public void U0(boolean z3) {
        Log.d("ThreeSplitAnimManager", "startScaleDownAnim hasLongPress=" + z3);
        this.f14309S = z3;
        K0();
        int n3 = this.f14317a.n();
        int i3 = this.f14327f;
        if (n3 == 3 && i3 == 1 && this.f14355t == -1) {
            if (this.f14317a.u() == 1 || this.f14317a.u() == 0) {
                i3 = 0;
            } else if (this.f14317a.u() == 2) {
                i3 = 2;
            }
        }
        if (n3 == 3) {
            if (this.f14308R) {
                i3 = 0;
            } else {
                this.f14355t = i3;
            }
        }
        List b02 = b0(B1.l.d1(this.f14319b.getContext(), this.f14354s0, i3, n3, false));
        if (b02 == null || b02.size() != this.f14317a.getCount()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.addAll(i0(this.f14321c, (Rect) b02.get(this.f14327f)));
        } else {
            arrayList.addAll(h0(this.f14321c, (Rect) b02.get(this.f14327f)));
        }
        if (n3 == 3) {
            arrayList.addAll(i0(this.f14319b.q0(this.f14337k), (Rect) b02.get(this.f14341m)));
            arrayList.addAll(i0(this.f14319b.q0(this.f14339l), (Rect) b02.get(this.f14345o)));
        } else {
            for (int i4 = 0; i4 < this.f14357u.size(); i4++) {
                arrayList.addAll(i0(this.f14319b.q0(((Integer) this.f14357u.get(i4)).intValue()), (Rect) b02.get(((Integer) this.f14359v.get(i4)).intValue())));
            }
        }
        if (z3) {
            this.f14346o0 = new AnimatorSet();
        } else {
            this.f14348p0 = new AnimatorSet();
        }
        this.f14344n0 = new AnimatorSet();
        this.f14342m0.post(new b(z3, arrayList));
    }

    public void a1(int i3) {
        int n3 = this.f14317a.n();
        if (f14289y0.booleanValue()) {
            if (n3 != 3) {
                Log.d("ThreeSplitAnimManager", "updateNextIndex layout=" + n3 + " mSwapIndex=" + this.f14331h + " changePolicy=" + i3 + "  mNextMoveIndex=" + this.f14327f + " mNextSwapIndex=" + this.f14333i);
            } else {
                Log.d("ThreeSplitAnimManager", "updateNextIndex layout=" + n3 + " mLineSwapIndex=" + this.f14353s + " changePolicy=" + i3 + "  mNextFirstLineSwapIndex=" + this.f14341m + " mNextSecondLineSwapIndex=" + this.f14345o);
            }
        }
        if (n3 == 5 || n3 == 7) {
            if (this.f14331h == -1) {
                this.f14327f = 2;
                this.f14359v.clear();
                this.f14359v.add(0);
                this.f14359v.add(1);
            } else if (i3 == 0) {
                int i4 = this.f14327f;
                this.f14327f = this.f14333i;
                this.f14333i = i4;
                this.f14359v.clear();
                this.f14359v.add(Integer.valueOf(this.f14333i));
                this.f14359v.add(2);
            } else if (i3 == 1) {
                this.f14333i--;
                this.f14327f--;
                this.f14359v.clear();
                this.f14359v.add(Integer.valueOf(this.f14333i));
                this.f14359v.add(2);
            }
        } else if (n3 == 4 || n3 == 6) {
            if (this.f14331h == -1) {
                this.f14327f = 0;
                this.f14359v.clear();
                this.f14359v.add(1);
                this.f14359v.add(2);
            } else if (i3 == 0) {
                int i5 = this.f14327f;
                this.f14327f = this.f14333i;
                this.f14333i = i5;
                this.f14359v.clear();
                this.f14359v.add(Integer.valueOf(this.f14333i));
                this.f14359v.add(0);
            } else if (i3 == 1) {
                this.f14333i++;
                this.f14327f++;
                this.f14359v.clear();
                this.f14359v.add(Integer.valueOf(this.f14333i));
                this.f14359v.add(0);
            }
        } else if (n3 == 3) {
            int i6 = this.f14353s;
            if (i6 == this.f14341m) {
                this.f14341m = this.f14327f;
                this.f14293C = false;
            } else {
                this.f14345o = this.f14327f;
                if (!this.f14308R) {
                    if (this.f14355t != 2) {
                        this.f14355t = 2;
                    } else {
                        this.f14355t = 0;
                    }
                }
                if (i6 == 2) {
                    this.f14341m = 1;
                    this.f14345o = 0;
                } else if (i6 == 0) {
                    this.f14341m = 1;
                    this.f14345o = 2;
                }
                this.f14293C = true;
                this.f14350q0 = true;
            }
            this.f14327f = i6;
        }
        if (f14289y0.booleanValue()) {
            if (n3 != 3) {
                Log.d("ThreeSplitAnimManager", "updateNextIndex after layout=" + n3 + " mSwapIndex=" + this.f14331h + "  mNextMoveIndex=" + this.f14327f + " mNextSwapIndex=" + this.f14333i);
                return;
            }
            Log.d("ThreeSplitAnimManager", "updateNextIndex after layout=" + n3 + " mLineLayoutRegionChanged=" + this.f14293C + "  mNextFirstLineSwapIndex=" + this.f14341m + " mNextSecondLineSwapIndex=" + this.f14345o);
        }
    }

    public void b1(List list, int i3) {
        int n3 = this.f14317a.n();
        int i4 = this.f14327f;
        if (n3 == 3 && i4 == 1) {
            i4 = this.f14355t;
        }
        if (this.f14308R && n3 == 3) {
            i4 = 0;
        }
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "updateRegion layout=" + n3 + " focusIndex=" + i4 + " changePolicy=" + i3);
        }
        List b02 = b0(B1.l.d1(this.f14319b.getContext(), list, i4, n3, false));
        this.f14358u0 = b02;
        if (b02 == null || b02.size() != this.f14317a.getCount()) {
            return;
        }
        this.f14360v0.clear();
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (list.get(i5) != null) {
                this.f14360v0.put(Integer.valueOf(((C0601d) list.get(i5)).s()), (Rect) this.f14358u0.get(i5));
            }
        }
        if ((i3 == 1 && !this.f14308R) || ((i3 == 0 && C0(i3, list)) || (i3 == 2 && this.f14293C))) {
            if (f14289y0.booleanValue()) {
                Log.d("ThreeSplitAnimManager", "updateRegion changePolicy=" + i3 + " region changed");
            }
            this.f14356t0.clear();
            this.f14356t0.addAll(list);
            this.f14362w0.clear();
            this.f14362w0.putAll(this.f14360v0);
            this.f14329g = this.f14327f;
            this.f14335j = this.f14333i;
            if (i3 == 2) {
                this.f14343n = this.f14341m;
                this.f14347p = this.f14345o;
            }
        }
        if (n3 == 5 || n3 == 7) {
            if (this.f14331h == -1) {
                if (!this.f14308R) {
                    this.f14338k0.set((Rect) this.f14358u0.get(2));
                    this.f14336j0.set(f0(this.f14358u0, 2));
                }
            } else if (i3 == 0 && C0(i3, list)) {
                this.f14338k0.set((Rect) this.f14358u0.get(this.f14327f));
                this.f14334i0.set((Rect) this.f14358u0.get(this.f14333i));
            } else if (i3 == 1) {
                this.f14338k0.set((Rect) this.f14358u0.get(this.f14327f));
                this.f14334i0.set((Rect) this.f14358u0.get(this.f14333i));
                this.f14336j0.set((Rect) this.f14358u0.get(2));
            }
        } else if (n3 == 4 || n3 == 6) {
            if (this.f14331h == -1) {
                if (!this.f14308R) {
                    this.f14338k0.set((Rect) this.f14358u0.get(0));
                    this.f14336j0.set(f0(this.f14358u0, 0));
                }
            } else if (i3 == 0 && C0(i3, list)) {
                this.f14338k0.set((Rect) this.f14358u0.get(this.f14327f));
                this.f14334i0.set((Rect) this.f14358u0.get(this.f14333i));
            } else if (i3 == 1) {
                this.f14338k0.set((Rect) this.f14358u0.get(this.f14327f));
                this.f14334i0.set((Rect) this.f14358u0.get(this.f14333i));
                this.f14336j0.set((Rect) this.f14358u0.get(0));
            }
        } else if (n3 == 3 && this.f14293C) {
            this.f14338k0.set((Rect) this.f14358u0.get(this.f14327f));
            this.f14349q.set((Rect) this.f14358u0.get(this.f14341m));
            this.f14351r.set((Rect) this.f14358u0.get(this.f14345o));
        }
        if ((i3 != 1 || this.f14308R) && !((i3 == 0 && this.f14292B) || (i3 == 2 && this.f14293C))) {
            return;
        }
        k0();
    }

    public void c1() {
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "updateRegionAndIndex mLayoutOrientationChanged=" + this.f14291A + " mSwapRegionChanged=" + this.f14292B + " mLineLayoutFocusPolicyChang=" + this.f14350q0);
        }
        if ((this.f14291A && !this.f14308R) || this.f14292B || this.f14350q0) {
            this.f14354s0.clear();
            this.f14354s0.addAll(this.f14356t0);
            this.f14360v0.clear();
            this.f14360v0.putAll(this.f14362w0);
            this.f14327f = this.f14329g;
            this.f14333i = this.f14335j;
            if (this.f14350q0) {
                this.f14341m = this.f14343n;
                this.f14345o = this.f14347p;
                return;
            }
            return;
        }
        this.f14354s0.clear();
        for (int i3 = 0; i3 < this.f14317a.getCount(); i3++) {
            this.f14354s0.add(this.f14317a.getItem(i3));
        }
        this.f14317a.M(this.f14366z);
        this.f14317a.E();
        this.f14327f = this.f14325e;
        this.f14333i = this.f14331h;
        int n3 = this.f14317a.n();
        if (n3 == 3) {
            this.f14341m = this.f14337k;
            this.f14345o = this.f14339l;
        }
        int i4 = this.f14327f;
        if (n3 == 3 && i4 == 1) {
            i4 = this.f14355t;
        }
        if (this.f14308R && n3 == 3) {
            i4 = 0;
        }
        List b02 = b0(B1.l.d1(this.f14319b.getContext(), this.f14354s0, i4, n3, false));
        this.f14360v0.clear();
        for (int i5 = 0; i5 < this.f14317a.getCount(); i5++) {
            if (this.f14317a.getItem(i5) != null) {
                this.f14360v0.put(Integer.valueOf(this.f14317a.getItem(i5).s()), (Rect) b02.get(i5));
            }
        }
    }

    public void d0() {
        if (z0()) {
            this.f14294D.cancel();
        }
        this.f14294D = null;
    }

    public void d1(int i3) {
        ArrayList arrayList = new ArrayList(this.f14354s0);
        this.f14354s0.clear();
        int n3 = this.f14317a.n();
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "updateTaskDataListAndLayout layout=" + n3 + " updatePolicy=" + i3);
        }
        if (i3 == 0) {
            if (n3 == 4 || n3 == 6) {
                this.f14354s0.add((C0601d) arrayList.get(0));
                this.f14354s0.add((C0601d) arrayList.get(2));
                this.f14354s0.add((C0601d) arrayList.get(1));
                return;
            } else {
                if (n3 == 5 || n3 == 7) {
                    this.f14354s0.add((C0601d) arrayList.get(1));
                    this.f14354s0.add((C0601d) arrayList.get(0));
                    this.f14354s0.add((C0601d) arrayList.get(2));
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            if (n3 == 4 || n3 == 6) {
                this.f14354s0.add((C0601d) arrayList.get(1));
                this.f14354s0.add((C0601d) arrayList.get(2));
                this.f14354s0.add((C0601d) arrayList.get(0));
                this.f14317a.M(n3 == 4 ? 5 : 7);
            } else if (n3 == 5 || n3 == 7) {
                this.f14354s0.add((C0601d) arrayList.get(2));
                this.f14354s0.add((C0601d) arrayList.get(0));
                this.f14354s0.add((C0601d) arrayList.get(1));
                this.f14317a.M(n3 == 5 ? 4 : 6);
            }
            this.f14317a.E();
            this.f14291A = true;
            return;
        }
        if (i3 == 2) {
            C0601d c0601d = (C0601d) arrayList.get(this.f14327f);
            if (Math.abs(this.f14327f - this.f14353s) == 1) {
                arrayList.set(this.f14327f, (C0601d) arrayList.get(this.f14353s));
                arrayList.set(this.f14353s, c0601d);
                this.f14354s0.addAll(arrayList);
                return;
            }
            int i4 = this.f14327f;
            if (i4 == 0) {
                arrayList.set(i4, (C0601d) arrayList.get(i4 + 1));
                int i5 = this.f14353s;
                arrayList.set(i5 - 1, (C0601d) arrayList.get(i5));
                arrayList.set(this.f14353s, c0601d);
                this.f14354s0.addAll(arrayList);
                return;
            }
            if (i4 == 2) {
                arrayList.set(i4, (C0601d) arrayList.get(i4 - 1));
                int i6 = this.f14353s;
                arrayList.set(i6 + 1, (C0601d) arrayList.get(i6));
                arrayList.set(this.f14353s, c0601d);
                this.f14354s0.addAll(arrayList);
            }
        }
    }

    public void e0(int i3, int i4) {
        int i5;
        if (this.f14332h0.contains(i3, i4)) {
            if (2 != this.f14365y) {
                c1();
            }
            i5 = 2;
        } else if (this.f14334i0.contains(i3, i4)) {
            i5 = 3;
            if (3 == this.f14365y) {
                return;
            } else {
                Y0(0);
            }
        } else if (this.f14336j0.contains(i3, i4)) {
            i5 = 4;
            if (4 == this.f14365y) {
                return;
            } else {
                Y0(1);
            }
        } else if (this.f14349q.contains(i3, i4)) {
            i5 = 6;
            if (6 == this.f14365y) {
                return;
            }
            this.f14353s = this.f14341m;
            Y0(2);
        } else if (!this.f14351r.contains(i3, i4)) {
            int i6 = this.f14365y;
            if (1 == i6) {
                return;
            }
            if (i6 == 7 && this.f14293C) {
                Log.d("ThreeSplitAnimManager", "checkIfNeedAnim should skip state=1 mLastTouchState=" + this.f14365y);
                this.f14365y = 1;
                return;
            }
            if (f14289y0.booleanValue()) {
                Log.d("ThreeSplitAnimManager", "checkIfNeedAnim ORIGINAL state=1 mLastTouchState=" + this.f14365y);
            }
            if (!this.f14338k0.contains(i3, i4)) {
                return;
            }
            if (this.f14365y != 0) {
                c1();
            }
            i5 = 1;
        } else {
            if (7 == this.f14365y) {
                return;
            }
            this.f14353s = this.f14345o;
            Y0(2);
            i5 = 7;
        }
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "checkIfNeedAnim state=" + i5 + " mLastTouchState=" + this.f14365y);
        }
        if (this.f14365y == 0 && i5 != 1) {
            Message obtainMessage = this.f14342m0.obtainMessage();
            obtainMessage.what = 10;
            obtainMessage.obj = 1;
            this.f14342m0.sendMessage(obtainMessage);
        }
        if (i5 != this.f14365y) {
            s.a(this.f14319b.getContext(), 0, true);
        }
        this.f14365y = i5;
        Message obtainMessage2 = this.f14342m0.obtainMessage();
        obtainMessage2.what = 10;
        obtainMessage2.obj = Integer.valueOf(i5);
        if (i5 != 2) {
            this.f14342m0.removeMessages(10);
            this.f14342m0.sendMessage(obtainMessage2);
            this.f14364x0 = 0L;
            return;
        }
        if (f14289y0.booleanValue()) {
            Log.d("ThreeSplitAnimManager", "checkIfNeedAnim state=" + i5 + " , delay 300 for to_zoom");
        }
        if (this.f14364x0 == 0) {
            this.f14364x0 = System.currentTimeMillis();
            this.f14342m0.sendMessageDelayed(obtainMessage2, 250L);
        }
    }

    public Rect f0(List list, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (i4 != i3) {
                arrayList.add((Rect) list.get(i4));
            }
        }
        Rect rect = new Rect((Rect) arrayList.get(0));
        for (int i5 = 1; i5 < arrayList.size(); i5++) {
            Rect rect2 = (Rect) arrayList.get(i5);
            rect.set(Math.min(rect.left, rect2.left), Math.min(rect.top, rect2.top), Math.max(rect.right, rect2.right), Math.max(rect.bottom, rect2.bottom));
        }
        return rect;
    }

    public Rect g0() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.f14317a.getCount(); i3++) {
            EmbeddedViewDecor q02 = this.f14319b.q0(i3);
            if (this.f14321c.getTaskData().s() != q02.getTaskData().s()) {
                arrayList.add(o0(q02));
            }
        }
        Rect rect = new Rect((Rect) arrayList.get(0));
        for (int i4 = 1; i4 < arrayList.size(); i4++) {
            Rect rect2 = (Rect) arrayList.get(i4);
            rect.set(Math.min(rect.left, rect2.left), Math.min(rect.top, rect2.top), Math.max(rect.right, rect2.right), Math.max(rect.bottom, rect2.bottom));
        }
        return rect;
    }

    public void j0() {
        AnimatorSet animatorSet = this.f14346o0;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        Log.d("ThreeSplitAnimManager", "endLongPressAnim need end mLongPressAnimatorSet");
        this.f14346o0.end();
    }

    public int n0(EmbeddedViewDecor embeddedViewDecor) {
        for (int i3 = 0; i3 < this.f14317a.getCount(); i3++) {
            if (embeddedViewDecor.getTaskData().s() == this.f14319b.q0(i3).getTaskData().s()) {
                return i3;
            }
        }
        return -1;
    }

    public Rect o0(EmbeddedViewDecor embeddedViewDecor) {
        Rect rect = new Rect();
        embeddedViewDecor.getBoundsOnScreen(rect);
        return rect;
    }

    public void p0() {
        if (z0()) {
            Log.d("ThreeSplitAnimManager", "onControlBarLongPress return, mCurrentTransferAnimation is running");
        } else {
            U0(true);
        }
    }

    public void s0(boolean z3, C0631a c0631a) {
        if (this.f14342m0.hasMessages(10)) {
            this.f14342m0.removeMessages(10);
            t0((int) c0631a.g().x, (int) c0631a.g().y);
        }
        Message obtainMessage = this.f14342m0.obtainMessage();
        obtainMessage.what = 10;
        obtainMessage.obj = 5;
        this.f14342m0.sendMessage(obtainMessage);
    }

    public void v0() {
        int n3 = this.f14317a.n();
        this.f14366z = n3;
        for (int i3 = 0; i3 < this.f14317a.getCount(); i3++) {
            this.f14354s0.add(this.f14317a.getItem(i3));
        }
        this.f14338k0.set(o0(this.f14321c));
        int n02 = n0(this.f14321c);
        this.f14325e = n02;
        ArrayList arrayList = new ArrayList();
        x0(arrayList);
        if (n3 == 5 || n3 == 7) {
            if (n02 == 2) {
                this.f14336j0.set(g0());
                this.f14357u.add(0);
                this.f14357u.add(1);
                this.f14331h = -1;
            } else {
                int i4 = 1 - n02;
                this.f14334i0.set((Rect) arrayList.get(i4));
                this.f14336j0.set((Rect) arrayList.get(2));
                this.f14357u.add(Integer.valueOf(i4));
                this.f14357u.add(2);
                this.f14331h = i4;
            }
        } else if (n3 == 4 || n3 == 6) {
            if (n02 == 0) {
                this.f14336j0.set(g0());
                this.f14357u.add(1);
                this.f14357u.add(2);
                this.f14331h = -1;
            } else {
                int i5 = 3 - n02;
                this.f14334i0.set((Rect) arrayList.get(i5));
                this.f14336j0.set((Rect) arrayList.get(0));
                this.f14357u.add(Integer.valueOf(i5));
                this.f14357u.add(0);
                this.f14331h = i5;
            }
        } else if (n3 == 3) {
            if (this.f14308R) {
                int i6 = this.f14325e;
                if (i6 == 0) {
                    this.f14349q.set((Rect) arrayList.get(1));
                    this.f14351r.set((Rect) arrayList.get(2));
                    this.f14337k = 1;
                    this.f14339l = 2;
                } else if (i6 == 1) {
                    this.f14349q.set((Rect) arrayList.get(0));
                    this.f14351r.set((Rect) arrayList.get(2));
                    this.f14337k = 0;
                    this.f14339l = 2;
                } else {
                    this.f14349q.set((Rect) arrayList.get(1));
                    this.f14351r.set((Rect) arrayList.get(0));
                    this.f14337k = 1;
                    this.f14339l = 0;
                }
            } else {
                for (int i7 = 0; i7 < this.f14317a.getCount(); i7++) {
                    if (i7 != this.f14325e) {
                        Rect rect = (Rect) arrayList.get(i7);
                        if (this.f14330g0.contains(rect)) {
                            this.f14349q.set(rect);
                            this.f14337k = i7;
                        } else {
                            this.f14351r.set(rect);
                            this.f14339l = i7;
                        }
                    }
                }
            }
            this.f14341m = this.f14337k;
            this.f14345o = this.f14339l;
        }
        this.f14327f = this.f14325e;
        this.f14333i = this.f14331h;
        this.f14359v.addAll(this.f14357u);
        k0();
    }

    public void x0(List list) {
        this.f14299I = this.f14321c.getTaskData();
        Rect rect = this.f14332h0;
        int i3 = this.f14311U;
        rect.set((int) (i3 * 0.08f), (int) ((this.f14312V * 1.0f) / 3.0f), (int) (i3 * 0.92f), (int) (((r3 * 2) * 1.0f) / 3.0f));
        this.f14330g0 = new Rect(0, 0, this.f14311U, this.f14312V);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f14317a.getCount(); i4++) {
            Rect o02 = o0(this.f14319b.q0(i4));
            arrayList.add(o02);
            list.add(o02);
        }
        M0(arrayList);
        List b02 = b0(arrayList);
        this.f14360v0.clear();
        for (int i5 = 0; i5 < this.f14317a.getCount(); i5++) {
            if (this.f14317a.getItem(i5) != null) {
                this.f14360v0.put(Integer.valueOf(this.f14317a.getItem(i5).s()), (Rect) b02.get(i5));
            }
        }
        this.f14340l0.set(this.f14338k0);
        this.f14304N.set(((Rect) b02.get(this.f14325e)).left - this.f14338k0.left, ((Rect) b02.get(this.f14325e)).top - this.f14338k0.top);
    }

    public boolean y0() {
        Log.d("ThreeSplitAnimManager", "initialDragAnimation  start");
        this.f14324d0 = B1.l.L(this.f14323d, this.f14321c.getFlexibleTaskView());
        int i3 = (int) (this.f14300J.getResources().getDisplayMetrics().density * 64.0f);
        this.f14314X = i3;
        this.f14313W = i3;
        SurfaceControl m3 = B1.l.m(this.f14324d0, "wholeSurface", "initWholeSurfaces", false, this.f14298H);
        this.f14326e0 = m3;
        this.f14323d.setMetadata(m3, 101, 1);
        this.f14302L = B1.l.I(this.f14300J.getResources().getConfiguration().uiMode);
        this.f14323d.setLayer(this.f14326e0, 2147483645).apply();
        Future d3 = C0305a.a().d(new Callable() { // from class: x1.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean D02;
                D02 = x.this.D0();
                return D02;
            }
        });
        boolean w02 = w0();
        try {
            boolean booleanValue = ((Boolean) d3.get()).booleanValue();
            if (w02 && booleanValue) {
                return true;
            }
            Log.e("ThreeSplitAnimManager", "initialDragAnimation failed initToZoomSuccess: " + w02 + " initNoMotionSuccess: " + booleanValue);
            return false;
        } catch (InterruptedException | ExecutionException e3) {
            Log.e("ThreeSplitAnimManager", "initialDragAnimation thread execute failed.. " + e3);
            d3.cancel(true);
            return false;
        }
    }

    public boolean z0() {
        ValueAnimator valueAnimator = this.f14294D;
        return valueAnimator != null && (valueAnimator.isStarted() || this.f14294D.isRunning());
    }
}
