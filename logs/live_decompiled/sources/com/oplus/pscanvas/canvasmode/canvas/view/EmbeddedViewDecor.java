package com.oplus.pscanvas.canvasmode.canvas.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.app.ActivityTaskManager;
import android.app.OplusActivityTaskManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.window.WindowContainerToken;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.pscanvas.canvasmode.canvas.A0;
import com.oplus.pscanvas.canvasmode.canvas.C0327t;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import u1.C0601d;
import w1.C0622f;

/* loaded from: classes.dex */
public class EmbeddedViewDecor extends RelativeLayout {

    /* renamed from: y, reason: collision with root package name */
    private static Boolean f10858y = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: e, reason: collision with root package name */
    private FlexibleTaskView f10859e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10860f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10861g;

    /* renamed from: h, reason: collision with root package name */
    public C0327t f10862h;

    /* renamed from: i, reason: collision with root package name */
    private C0601d f10863i;

    /* renamed from: j, reason: collision with root package name */
    private WindowContainerToken f10864j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f10865k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10866l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f10867m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f10868n;

    /* renamed from: o, reason: collision with root package name */
    private final List f10869o;

    /* renamed from: p, reason: collision with root package name */
    private Handler f10870p;

    /* renamed from: q, reason: collision with root package name */
    private float f10871q;

    /* renamed from: r, reason: collision with root package name */
    private float f10872r;

    /* renamed from: s, reason: collision with root package name */
    private int f10873s;

    /* renamed from: t, reason: collision with root package name */
    private Bitmap f10874t;

    /* renamed from: u, reason: collision with root package name */
    private Runnable f10875u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f10876v;

    /* renamed from: w, reason: collision with root package name */
    private FlexibleTaskView.Listener f10877w;

    /* renamed from: x, reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f10878x;

    /* JADX INFO: Access modifiers changed from: private */
    class FlexibleTaskViewCallback implements FlexibleTaskView.Listener {
        private int getViewDecorIndex() {
            int indexOf = B1.l.O1(EmbeddedViewDecor.this.getContext()).v0().getChildEmbeddedViewList().indexOf(EmbeddedViewDecor.this);
            if (EmbeddedViewDecor.f10858y.booleanValue()) {
                Log.d("EmbeddedViewDecor", "onTaskReplaced getViewDecorIndex " + indexOf);
            }
            if (indexOf == -1) {
                return 0;
            }
            return indexOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInitialized$0() {
            ((ContainerView) EmbeddedViewDecor.this.getParent()).getContainerController().B(EmbeddedViewDecor.this.f10863i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTaskCreated$1() {
            Rect rect = new Rect(EmbeddedViewDecor.this.getLaunchRect());
            Log.d("EmbeddedViewDecor", "onTaskCreated resize launch bounds to:" + rect);
            EmbeddedViewDecor.this.f10859e.resize(rect);
            B1.l.O1(((RelativeLayout) EmbeddedViewDecor.this).mContext).D1();
            EmbeddedViewDecor.this.f10861g = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTaskRectOrientationChanged$4(ActivityManager.RunningTaskInfo runningTaskInfo, Rect rect) {
            B1.l.O1(EmbeddedViewDecor.this.getContext()).v1(runningTaskInfo, rect);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTaskReplaced$2() {
            if (EmbeddedViewDecor.this.f10868n) {
                Log.d("EmbeddedViewDecor", "onTaskReplaced: gonnaVanish");
                return;
            }
            A0 E02 = B1.l.O1(EmbeddedViewDecor.this.getContext()).E0();
            if (E02 != null && E02.M()) {
                E02.A(false);
            }
            B1.l.O1(EmbeddedViewDecor.this.getContext()).v0().getAdapter().Y(EmbeddedViewDecor.this.f10863i, getViewDecorIndex());
            B1.l.O1(EmbeddedViewDecor.this.getContext()).I1(true);
            B1.l.O1(EmbeddedViewDecor.this.getContext()).v0().getAdapter().J(EmbeddedViewDecor.this.f10863i);
            B1.l.O1(EmbeddedViewDecor.this.getContext()).I1(false);
            C0622f.k(EmbeddedViewDecor.this.getContext()).C(B1.l.O1(EmbeddedViewDecor.this.getContext()).u0(), B1.l.O1(EmbeddedViewDecor.this.getContext()).v0().getContainerController(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onTaskReplaced$3() {
            Rect rect = new Rect(EmbeddedViewDecor.this.getLaunchRect());
            Log.d("EmbeddedViewDecor", "onTaskReplaced resize launch bounds to:" + rect);
            EmbeddedViewDecor.this.f10859e.resize(rect);
        }

        public void onBackPressedOnTaskRoot(int i3) {
            Log.d("EmbeddedViewDecor", "Canvas app onBackPressedOnTaskRoot taskId:" + i3);
        }

        public void onInitialized(boolean z3) {
            Log.d("EmbeddedViewDecor", "onInitialized " + z3);
            if (!z3 && (EmbeddedViewDecor.this.getParent() instanceof ContainerView)) {
                EmbeddedViewDecor.this.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmbeddedViewDecor.FlexibleTaskViewCallback.this.lambda$onInitialized$0();
                    }
                });
            }
            EmbeddedViewDecor.this.f10860f = z3;
        }

        public void onReleased() {
        }

        public void onTaskChanged(int i3, ComponentName componentName, Rect rect) {
            Log.d("EmbeddedViewDecor", "onTaskChanged taskId:" + i3 + " rect:" + rect + " name:" + componentName + " intent:" + EmbeddedViewDecor.this.f10863i.f());
            EmbeddedViewDecor.this.m0(componentName);
            if (componentName != null && componentName.getClassName().equals("com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI")) {
                Log.d("EmbeddedViewDecor", "onTaskChanged return for WECHAT_LIVE_CLASS");
                return;
            }
            if (EmbeddedViewDecor.this.f10863i.s() == i3) {
                Message message = new Message();
                message.what = 1;
                message.obj = new Rect(rect);
                EmbeddedViewDecor.this.f10870p.removeMessages(1);
                EmbeddedViewDecor.this.f10870p.sendMessageDelayed(message, 50L);
            }
        }

        public void onTaskCreated(int i3, ComponentName componentName) {
            Log.d("EmbeddedViewDecor", "onTaskCreated " + i3 + ",name:" + componentName + ",mTaskData:" + EmbeddedViewDecor.this.f10863i);
            EmbeddedViewDecor.this.m0(componentName);
            if (EmbeddedViewDecor.this.f10863i != null) {
                EmbeddedViewDecor.this.f10863i.k0(i3);
            }
            C0622f.k(EmbeddedViewDecor.this.getContext()).C(B1.l.O1(EmbeddedViewDecor.this.getContext()).u0(), B1.l.O1(EmbeddedViewDecor.this.getContext()).v0().getContainerController(), B1.l.O1(EmbeddedViewDecor.this.getContext()).E0().M());
            EmbeddedViewDecor.this.getTaskToken();
            EmbeddedViewDecor.this.e0();
            EmbeddedViewDecor.this.f10870p.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.u
                @Override // java.lang.Runnable
                public final void run() {
                    EmbeddedViewDecor.FlexibleTaskViewCallback.this.lambda$onTaskCreated$1();
                }
            });
        }

        public void onTaskRectOrientationChanged(final ActivityManager.RunningTaskInfo runningTaskInfo, final Rect rect) {
            Log.d("EmbeddedViewDecor", "Canvas app onTaskRectOrientationChanged taskId:" + runningTaskInfo.taskId + ", rect:" + rect);
            EmbeddedViewDecor.this.getContext().getMainThreadHandler().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.w
                @Override // java.lang.Runnable
                public final void run() {
                    EmbeddedViewDecor.FlexibleTaskViewCallback.this.lambda$onTaskRectOrientationChanged$4(runningTaskInfo, rect);
                }
            });
        }

        public void onTaskRemovalStarted(int i3) {
            Log.d("EmbeddedViewDecor", "Canvas app onTaskRemovalStarted taskId:" + i3);
        }

        public void onTaskReplaced(int i3, Intent intent, int i4) {
            Log.d("EmbeddedViewDecor", "Canvas app onTaskReplaced taskId:" + i3 + ", intent:" + intent + ", userId:" + i4);
            if (-1 == i3) {
                return;
            }
            EmbeddedViewDecor.this.l0();
            if (intent != null) {
                intent.putExtra("androidx.flexible.userId", i4);
                B1.l.z1(intent, EmbeddedViewDecor.this.f10863i.t());
            }
            boolean z3 = false;
            int i5 = -2;
            if (B1.s.r(((RelativeLayout) EmbeddedViewDecor.this).mContext) && B1.l.O1(((RelativeLayout) EmbeddedViewDecor.this).mContext).C0() == 1 && E.c0(B1.l.d0(intent), i3)) {
                i5 = 0;
            }
            C0601d n02 = B1.l.n0(EmbeddedViewDecor.this.getContext(), intent, i5);
            if (n02 == null) {
                Log.d("EmbeddedViewDecor", "newTaskData is null");
                return;
            }
            ContainerView containerView = (ContainerView) EmbeddedViewDecor.this.getParent();
            if (!n02.D() || (B1.s.r(((RelativeLayout) EmbeddedViewDecor.this).mContext) && ((containerView.j1() && !n02.I()) || (containerView.m1() && n02.I())))) {
                ((ContainerView) EmbeddedViewDecor.this.getParent()).getContainerController().g();
            }
            n02.m0(EmbeddedViewDecor.this.f10863i.t());
            C0601d c0601d = EmbeddedViewDecor.this.f10863i;
            if (n02.D() && EmbeddedViewDecor.this.f10863i.H()) {
                z3 = true;
            }
            c0601d.b(n02, z3);
            EmbeddedViewDecor.this.f10863i.r0(i4);
            EmbeddedViewDecor.this.f10863i.k0(i3);
            EmbeddedViewDecor.this.f10863i.M(B1.l.X(EmbeddedViewDecor.this.getContext(), intent, i4));
            if (EmbeddedViewDecor.f10858y.booleanValue()) {
                Log.d("EmbeddedViewDecor", "Canvas app onTaskReplaced taskId:" + i3 + ", newTaskData:" + EmbeddedViewDecor.this.f10863i);
            }
            EmbeddedViewDecor.this.getContext().getMainThreadHandler().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.s
                @Override // java.lang.Runnable
                public final void run() {
                    EmbeddedViewDecor.FlexibleTaskViewCallback.this.lambda$onTaskReplaced$2();
                }
            });
            B1.l.w1(B1.l.O1(((RelativeLayout) EmbeddedViewDecor.this).mContext));
            EmbeddedViewDecor.this.f10870p.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.t
                @Override // java.lang.Runnable
                public final void run() {
                    EmbeddedViewDecor.FlexibleTaskViewCallback.this.lambda$onTaskReplaced$3();
                }
            });
        }

        public void onTaskVisibilityChanged(int i3, boolean z3) {
            Log.d("EmbeddedViewDecor", "onTaskVisibilityChanged " + i3 + ", visible: " + z3);
        }

        public void onTaskWindowDraw(int i3, boolean z3) {
            if (EmbeddedViewDecor.f10858y.booleanValue()) {
                Log.d("EmbeddedViewDecor", "onTaskWindowDraw taskId:" + i3);
            }
            EmbeddedViewDecor.this.f10861g = true;
            EmbeddedViewDecor.this.f10867m = z3;
        }

        public void updateTouchRegion(Region region) {
            if (EmbeddedViewDecor.this.getParent() instanceof ContainerView) {
                if (((ContainerView) EmbeddedViewDecor.this.getParent()).Q2(((RelativeLayout) EmbeddedViewDecor.this).mContext).T0()) {
                    region.set(new Region());
                }
                Iterator it = ((ContainerView) EmbeddedViewDecor.this.getParent()).f10732G.H().iterator();
                while (it.hasNext()) {
                    ((E.c) it.next()).g().getBoundsOnScreen(EmbeddedViewDecor.this.f10865k);
                    region.op(EmbeddedViewDecor.this.f10865k, Region.Op.UNION);
                }
            }
        }

        private FlexibleTaskViewCallback() {
        }
    }

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Object obj = message.obj;
                if (obj instanceof Rect) {
                    EmbeddedViewDecor.this.D((Rect) obj);
                }
            }
            super.handleMessage(message);
        }
    }

    class b implements Animator.AnimatorListener {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            EmbeddedViewDecor.this.a0();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (EmbeddedViewDecor.this.f10876v) {
                EmbeddedViewDecor.this.f10876v = false;
                EmbeddedViewDecor.this.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmbeddedViewDecor.b.this.b();
                    }
                });
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            EmbeddedViewDecor.this.f0();
        }
    }

    class d implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f10882e;

        d(int i3) {
            this.f10882e = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ActivityTaskManager.getService().setFocusedTask(this.f10882e);
                EmbeddedViewDecor.this.f10876v = false;
            } catch (RemoteException unused) {
                Log.e("EmbeddedViewDecor", "onFocused: RemoteException");
            }
        }
    }

    public EmbeddedViewDecor(Context context) {
        this(context, null);
    }

    private C2.a A() {
        return new C2.a() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.n
            @Override // C2.a
            public final Object invoke() {
                p2.q qVar;
                qVar = p2.q.f12810a;
                return qVar;
            }
        };
    }

    private C2.a B() {
        return new C2.a() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.p
            @Override // C2.a
            public final Object invoke() {
                p2.q R3;
                R3 = EmbeddedViewDecor.this.R();
                return R3;
            }
        };
    }

    private C2.a C(final C0601d c0601d, final Rect rect, final ContainerView containerView) {
        return new C2.a() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.o
            @Override // C2.a
            public final Object invoke() {
                p2.q S3;
                S3 = EmbeddedViewDecor.this.S(c0601d, containerView, rect);
                return S3;
            }
        };
    }

    private int F(int i3, int i4) {
        if (i3 <= 0) {
            return 0;
        }
        return i3 >= i4 ? i4 : i3;
    }

    private C0601d G(Rect rect, boolean z3, boolean z4, boolean z5) {
        ContainerView containerView = (ContainerView) getParent();
        if (rect == null || rect.isEmpty() || this.f10866l || !isAttachedToWindow()) {
            Log.d("EmbeddedViewDecor", "getTaskDataByRect return, rect: " + rect + ", mIsAnimating: " + this.f10866l + ", isAttachedToWindow(): " + isAttachedToWindow());
            return null;
        }
        boolean z6 = this.f10859e.getHeight() != 0 && Math.abs(((((float) rect.width()) * 1.0f) / ((float) rect.height())) - ((((float) this.f10859e.getWidth()) * 1.0f) / ((float) this.f10859e.getHeight()))) <= 0.01f;
        int i3 = (B1.s.H() || B1.s.w(((RelativeLayout) this).mContext) || (B1.s.r(((RelativeLayout) this).mContext) && z4)) ? -2 : rect.width() > rect.height() ? 0 : 1;
        Intent f3 = this.f10863i.f();
        f3.putExtra("androidx.activity.LaunchEmbeddedTaskId", this.f10863i.s());
        f3.putExtra("androidx.flexible.userId", this.f10863i.v());
        if (B1.s.w(((RelativeLayout) this).mContext)) {
            f3.putExtra("androidx.intent.extra.old.orientation", this.f10863i.j());
        }
        C0601d n02 = B1.l.n0(getContext(), f3, i3);
        if (B1.s.w(((RelativeLayout) this).mContext)) {
            f3.removeExtra("androidx.intent.extra.old.orientation");
        }
        boolean z7 = (n02 == null || this.f10863i.p() == n02.p()) ? false : true;
        if (n02 != null && n02.p() != 1) {
            z5 = false;
        }
        if ((rect.equals(this.f10863i.n()) || (z6 && !z5)) && B1.s.r(((RelativeLayout) this).mContext) && !z3 && !z7) {
            Log.d("EmbeddedViewDecor", "getTaskDataByRect return2, rect: " + rect + ",isSameRatio: " + z6 + "\n,mTaskData: " + this.f10863i + "\n,taskData: " + n02);
            return null;
        }
        if (!z4 && n02 != null) {
            if (n02.p() == 2) {
                if (this.f10863i.n().equals(n02.c())) {
                    n02.f0(rect);
                    this.f10863i.f0(rect);
                }
            } else if (n02.p() == 1 && !B1.s.A(this.f10863i, this.f10859e, containerView)) {
                if (B1.s.r(((RelativeLayout) this).mContext) ? B1.l.H0(this.f10863i, containerView) : this.f10863i.n().equals(n02.i())) {
                    n02.o0(true);
                    this.f10863i.o0(true);
                }
            }
        }
        if (!B1.s.w(((RelativeLayout) this).mContext) || n02 == null || this.f10863i.p() != n02.p() || !B1.l.J0(this.f10863i.j(), n02.j()) || !z6) {
            return n02;
        }
        Log.d("EmbeddedViewDecor", "getTaskDataByRect return mTaskData=" + this.f10863i + ",taskData=" + n02);
        return null;
    }

    private boolean J() {
        if (B1.l.O1(getContext()).P0()) {
            Log.d("EmbeddedViewDecor", "isNeedSkipLayout onLayout return isClickTwoMiniSplit");
            return true;
        }
        if (!B1.l.O1(getContext()).V0()) {
            return false;
        }
        Log.d("EmbeddedViewDecor", "isNeedSkipLayout onLayout return isTaskToFull");
        return true;
    }

    private boolean K(Rect rect, Rect rect2) {
        return Math.abs(rect.left - rect2.left) <= 1 && Math.abs(rect.top - rect2.top) <= 1 && Math.abs(rect.right - rect2.right) <= 1 && Math.abs(rect.bottom - rect2.bottom) <= 1;
    }

    private boolean L(C0601d c0601d, ContainerView containerView) {
        return B1.l.D0(((RelativeLayout) this).mContext, c0601d, containerView.getContainerController().q()) && !B1.s.A(this.f10863i, this.f10859e, containerView) && B1.s.F(this.f10863i.n(), containerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(Pair pair) {
        E((Rect) pair.first, ((Boolean) pair.second).booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p2.q R() {
        this.f10866l = false;
        if (getParent() instanceof ContainerView) {
            ((ContainerView) getParent()).f10755S = false;
        }
        if (!this.f10869o.isEmpty()) {
            final Pair pair = (Pair) this.f10869o.remove(0);
            this.f10870p.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.q
                @Override // java.lang.Runnable
                public final void run() {
                    EmbeddedViewDecor.this.Q(pair);
                }
            });
        }
        return p2.q.f12810a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ p2.q S(C0601d c0601d, ContainerView containerView, Rect rect) {
        if (f10858y.booleanValue()) {
            Log.d("EmbeddedViewDecor", "changeRectMaskShow " + c0601d);
        }
        containerView.L0();
        containerView.b2();
        if (getParent() instanceof ContainerView) {
            ((ContainerView) getParent()).f10755S = true;
        }
        Z(containerView, c0601d, rect, true, false);
        return p2.q.f12810a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(ContainerView containerView, C0601d c0601d, Rect rect, boolean z3) {
        Z(containerView, c0601d, rect, false, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(C0601d c0601d, ContainerView containerView, Rect rect, boolean z3, boolean z4) {
        if (B1.s.D(B1.l.O1(((RelativeLayout) this).mContext).K0()) != B1.s.D(c0601d.w())) {
            Log.d("EmbeddedViewDecor", "notifyUpdateLayout return no valid");
            return;
        }
        if (this.f10868n || c0601d.C()) {
            Log.d("EmbeddedViewDecor", "notifyUpdateLayout return: gonnaVanish");
            return;
        }
        this.f10863i.f0(c0601d.f13810a);
        this.f10863i.W(c0601d.i());
        this.f10863i.X(c0601d.j());
        this.f10863i.s0(c0601d.w());
        this.f10863i.f13805D.set(c0601d.f13805D);
        this.f10863i.f13806E.set(c0601d.f13806E);
        this.f10863i.f13807F.set(c0601d.f13807F);
        this.f10863i.c0(c0601d.l());
        this.f10863i.L(c0601d.d());
        this.f10863i.Q(c0601d.y());
        this.f10863i.U(c0601d.g());
        this.f10863i.V(c0601d.h());
        this.f10863i.g0(c0601d.p());
        boolean D02 = B1.l.D0(((RelativeLayout) this).mContext, c0601d, containerView.getContainerController().q());
        if (B1.s.H() && c0601d.p() == 3 && !D02) {
            this.f10863i.o0(false);
        }
        if (c0601d.p() == 2) {
            if (rect.equals(c0601d.c())) {
                this.f10863i.f0(rect);
            }
        } else if ((c0601d.p() == 1 || L(c0601d, containerView)) && rect.equals(c0601d.i())) {
            this.f10863i.o0(true);
        }
        this.f10863i.l0(true);
        if (z3) {
            this.f10863i.o0(false);
            this.f10863i.d0(false);
            if (this.f10863i.H()) {
                Log.d("EmbeddedViewDecor", "notifyUpdateLayout isUseSteplessAdjustRect resize launch bounds to " + this.f10863i.n());
                this.f10859e.resize(this.f10863i.n());
            } else {
                Log.d("EmbeddedViewDecor", "notifyUpdateLayout resize launch bounds to " + this.f10863i.n());
                this.f10859e.resize(rect);
            }
        }
        if (getParent() instanceof ContainerView) {
            containerView.W2(this.f10863i, 0, z4);
            containerView.getContainerController().G(this.f10863i);
        }
        B1.l.w1(B1.l.O1(((RelativeLayout) this).mContext));
        this.f10862h.K1(this.f10863i);
    }

    private boolean X(C0601d c0601d) {
        ContainerView containerView = (ContainerView) getParent();
        if (containerView.getAdapter().getCount() < 2) {
            Log.d("EmbeddedViewDecor", "needChangeRectAnimation return count");
            return false;
        }
        if (!B1.s.H() && !B1.s.r(((RelativeLayout) this).mContext)) {
            return Y(containerView, c0601d);
        }
        boolean z3 = c0601d.I() != this.f10863i.I();
        boolean M02 = B1.l.M0(this.f10863i.p(), c0601d.p(), this.f10863i.B(), this.f10863i.u() || this.f10863i.n().equals(this.f10863i.i()));
        Log.d("EmbeddedViewDecor", "needChangeRectAnimation isVerticalChange:" + z3 + ",isSmallToLarge:" + M02);
        return z3 || M02;
    }

    private boolean Y(ContainerView containerView, C0601d c0601d) {
        boolean z3 = false;
        if (!B1.s.B() || !B1.s.w(((RelativeLayout) this).mContext)) {
            Log.d("EmbeddedViewDecor", "needChangeRectAnimationOnPhone end");
            return false;
        }
        if (B1.s.D(B1.l.O1(((RelativeLayout) this).mContext).K0()) != B1.s.D(c0601d.w())) {
            Log.d("EmbeddedViewDecor", "needChangeRectAnimationOnPhone not valid");
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < containerView.getAdapter().getCount(); i3++) {
            C0601d item = containerView.getAdapter().getItem(i3);
            if (item == null || item.f() != this.f10863i.f()) {
                arrayList.add(item);
            } else {
                arrayList.add(c0601d);
            }
        }
        int g12 = B1.l.g1(arrayList);
        int w3 = containerView.getContainerController().w();
        if (w3 == 1 && ActivityInfo.isFixedOrientationLandscape(g12)) {
            Log.d("EmbeddedViewDecor", "needChangeRectAnimationOnPhone isFixedOrientationLandscape");
            return false;
        }
        if (w3 == 2 && ActivityInfo.isFixedOrientationPortrait(g12)) {
            Log.d("EmbeddedViewDecor", "needChangeRectAnimationOnPhone isFixedOrientationPortrait");
            return false;
        }
        boolean u3 = c0601d.u();
        boolean G3 = c0601d.G();
        c0601d.o0(this.f10863i.u());
        c0601d.n0(B1.l.w0(((RelativeLayout) this).mContext, arrayList));
        if (c0601d.n().equals(this.f10863i.n()) || (this.f10863i.H() && c0601d.p() == 1)) {
            z3 = true;
        }
        c0601d.o0(u3);
        c0601d.n0(G3);
        Log.d("EmbeddedViewDecor", "needChangeRectAnimationOnPhone isRectEqual:" + z3);
        return !z3;
    }

    private void Z(final ContainerView containerView, final C0601d c0601d, final Rect rect, final boolean z3, final boolean z4) {
        Log.d("EmbeddedViewDecor", "notifyUpdateLayout " + rect + " onlyChangeLaunchRect:" + z4 + " taskData:" + c0601d);
        ((RelativeLayout) this).mContext.getMainThreadHandler().post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.m
            @Override // java.lang.Runnable
            public final void run() {
                EmbeddedViewDecor.this.U(c0601d, containerView, rect, z4, z3);
            }
        });
    }

    private boolean c0(Rect rect, ContainerView containerView) {
        if (rect == null || rect.isEmpty() || this.f10863i == null || !((B1.s.r(((RelativeLayout) this).mContext) || B1.s.H()) && containerView.j1() && B1.s.A(this.f10863i, this.f10859e, containerView) && rect.height() > rect.width())) {
            return false;
        }
        return B1.s.F(rect, containerView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        C0601d c0601d = this.f10863i;
        if (c0601d == null || c0601d.f().getComponent() != null) {
            return;
        }
        try {
            Field declaredField = this.f10859e.getClass().getDeclaredField("mTaskInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.f10859e);
            if (obj instanceof ActivityManager.RunningTaskInfo) {
                ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) obj;
                if (this.f10863i.f().getComponent() == null) {
                    this.f10863i.f().setComponent(runningTaskInfo.baseIntent.getComponent());
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e3) {
            Log.e("EmbeddedViewDecor", "getTaskInfoComponent error " + e3.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        if (!f10858y.booleanValue() || getDisplay() == null || getDisplay().getMode() == null) {
            return;
        }
        Rect rect = new Rect();
        this.f10859e.getBoundsOnScreen(rect);
        boolean z3 = getResources().getConfiguration().orientation == 1;
        Display.Mode mode = getDisplay().getMode();
        int physicalWidth = z3 ? mode.getPhysicalWidth() : mode.getPhysicalHeight();
        int physicalHeight = z3 ? getDisplay().getMode().getPhysicalHeight() : getDisplay().getMode().getPhysicalWidth();
        Rect rect2 = new Rect();
        rect2.left = F(rect.left, physicalWidth);
        rect2.top = F(rect.top, physicalHeight);
        rect2.right = F(rect.right, physicalWidth);
        rect2.bottom = F(rect.bottom, physicalHeight);
        StringBuilder sb = new StringBuilder();
        sb.append("allRect:(" + rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom + ")");
        sb.append("|visRect:(" + rect2.left + "," + rect2.top + "," + rect2.right + "," + rect2.bottom + ")");
        C0601d c0601d = this.f10863i;
        if (c0601d != null) {
            if (c0601d.f() != null && this.f10863i.f().getComponent() != null) {
                sb.append("|pkg:" + this.f10863i.f().getComponent().getPackageName());
            }
            sb.append("|userId:" + this.f10863i.v());
        }
        setContentDescription(sb.toString());
        Log.i("EmbeddedViewDecor", "setFlexibleTaskViewFrame:" + sb.toString() + "--" + this.f10863i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getTaskToken() {
        try {
            Field declaredField = this.f10859e.getClass().getDeclaredField("mTaskToken");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.f10859e);
            if (obj != null) {
                this.f10864j = (WindowContainerToken) obj;
            }
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException e3) {
            Log.e("EmbeddedViewDecor", "getTaskToken error " + e3.getMessage());
        }
    }

    private boolean i0(ContainerView containerView, C0601d c0601d, Rect rect, boolean z3) {
        C0601d c0601d2 = this.f10863i;
        if (c0601d2 == null || (c0601d2.n().equals(rect) && this.f10863i.j() == c0601d.j())) {
            return false;
        }
        String str = "EmbeddedViewDecor";
        Log.d("EmbeddedViewDecor", "startChangeRectAnimation " + this.f10863i + " rect:" + rect);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<Rect> childrenPositionOnScreen = containerView.getChildrenPositionOnScreen();
        ArrayList arrayList3 = new ArrayList();
        int count = containerView.getAdapter().getCount();
        if (childrenPositionOnScreen.size() != count) {
            Log.w("EmbeddedViewDecor", "startChangeRectAnimation error!!");
            return false;
        }
        int n3 = containerView.getContainerController().n();
        int i3 = 0;
        while (i3 < count) {
            C0601d l3 = containerView.getContainerController().l(i3);
            List<Rect> list = childrenPositionOnScreen;
            String str2 = str;
            arrayList.add(new y1.u(childrenPositionOnScreen.get(i3), l3.f(), l3.e(), containerView.p0(containerView.D0(i3))));
            l3.q0(false);
            if (l3.f() == this.f10863i.f()) {
                c0601d.l0(true);
                arrayList3.add(k0(c0601d, rect));
            } else {
                arrayList3.add(l3);
            }
            i3++;
            childrenPositionOnScreen = list;
            str = str2;
        }
        List<Rect> list2 = childrenPositionOnScreen;
        String str3 = str;
        containerView.f3(arrayList3);
        List d12 = B1.l.d1(((RelativeLayout) this).mContext, arrayList3, n3, containerView.getContainerController().q(), containerView.getPanoramaModeManager().M());
        for (int i4 = 0; i4 < count; i4++) {
            C0601d c0601d3 = (C0601d) arrayList3.get(i4);
            arrayList2.add(new y1.u((Rect) d12.get(i4), c0601d3.f(), c0601d3.e(), containerView.p0(containerView.D0(i4))));
        }
        int size = arrayList.size();
        if (size == arrayList2.size()) {
            for (int i5 = 0; i5 < size; i5++) {
                if (K(((y1.u) arrayList.get(i5)).h(), ((y1.u) arrayList2.get(i5)).h())) {
                }
            }
            Log.w(str3, "startChangeRectAnimation isRectEqual");
            return false;
        }
        this.f10866l = true;
        List A12 = containerView.A1(0, list2, d12);
        containerView.getCanvasMaskManager().d0(this.f10863i.s());
        containerView.getCanvasMaskManager().i0(404);
        containerView.getCanvasMaskManager().t0(z3, arrayList, arrayList2, A12, C(c0601d, rect, containerView), A(), B());
        return true;
    }

    private C0601d k0(C0601d c0601d, Rect rect) {
        if (c0601d.p() == 2) {
            if (rect.equals(c0601d.c())) {
                c0601d.f0(rect);
            }
        } else if (c0601d.p() == 1 && rect.equals(c0601d.i())) {
            c0601d.o0(true);
        }
        c0601d.k0(this.f10863i.s());
        return c0601d;
    }

    public void D(Rect rect) {
        if (this.f10868n) {
            Log.d("EmbeddedViewDecor", "changeTaskInfoRect: gonnaVanish");
            return;
        }
        this.f10863i.f().putExtra("ps_config_display_bound", ((RelativeLayout) this).mContext.getResources().getConfiguration().windowConfiguration.getBounds());
        C0601d G3 = G(rect, false, true, false);
        if (G3 == null) {
            Log.d("EmbeddedViewDecor", "changeTaskInfoRect getTaskDataByRect == null, rect=" + rect + ",mTaskData.getRect()=" + this.f10863i);
            return;
        }
        boolean z3 = this.f10863i.I() != G3.I();
        Log.d("EmbeddedViewDecor", "changeTaskInfoRect taskData " + this.f10863i + "\n newTaskData: " + G3 + " \n width:" + this.f10859e.getWidth() + " mIsAnimating:" + this.f10866l + " height:" + this.f10859e.getHeight() + " changeRect:" + rect + "; isVerticalChanged: " + z3);
        if (this.f10863i.C()) {
            Log.i("EmbeddedViewDecor", "changeTaskInfoRect isRemoved");
            return;
        }
        this.f10863i.S(false);
        Rect rect2 = new Rect(this.f10863i.n());
        G3.o0(this.f10863i.u());
        this.f10863i.Q(G3.y());
        this.f10863i.f0(G3.f13810a);
        this.f10863i.L(G3.f13804C);
        this.f10863i.W(G3.i());
        this.f10863i.X(G3.j());
        this.f10863i.s0(G3.w());
        this.f10863i.g0(G3.p());
        C0601d c0601d = this.f10863i;
        c0601d.f13805D = G3.f13805D;
        c0601d.f13806E = G3.f13806E;
        c0601d.f13807F = G3.f13807F;
        c0601d.c0(c0601d.l());
        this.f10863i.U(G3.g());
        this.f10863i.V(G3.h());
        if (G3.p() == 2) {
            if (rect.equals(G3.c())) {
                this.f10863i.f0(rect);
            }
        } else if (G3.p() == 1 && rect.equals(G3.i())) {
            this.f10863i.o0(true);
        }
        if (getParent() instanceof ContainerView) {
            ContainerView containerView = (ContainerView) getParent();
            containerView.W2(this.f10863i, 0, z3);
            if (containerView.getContainerController() != null) {
                containerView.getContainerController().h(this.f10863i);
            }
        }
        if (!this.f10859e.getLaunchBounds().equals(G3.n()) && !this.f10859e.getLaunchBounds().equals(getLaunchRect()) && rect2.equals(this.f10863i.n())) {
            Rect rect3 = new Rect(getLaunchRect());
            this.f10859e.resize(rect3);
            Log.d("EmbeddedViewDecor", "changeTaskInfoRect " + this.f10863i.s() + " resize launch bounds to " + rect3);
        }
        B1.l.w1(B1.l.O1(((RelativeLayout) this).mContext));
        this.f10862h.K1(this.f10863i);
    }

    public void E(final Rect rect, boolean z3) {
        if (this.f10866l) {
            this.f10869o.clear();
            this.f10869o.add(Pair.create(new Rect(rect), Boolean.valueOf(z3)));
            Log.d("EmbeddedViewDecor", "changeTaskOrientation add mPendingChangeTaskOrientationList rect: " + rect);
            return;
        }
        this.f10869o.clear();
        final ContainerView containerView = (ContainerView) getParent();
        final boolean c02 = c0(rect, containerView);
        final C0601d G3 = G(rect, B1.s.H(), false, c02);
        if (G3 == null) {
            Log.d("EmbeddedViewDecor", "changeTaskOrientation return taskData " + this.f10863i);
            return;
        }
        G3.o0(this.f10863i.u());
        if ((G3.p() == 1 || L(G3, containerView)) && rect.equals(G3.i())) {
            G3.o0(true);
        }
        G3.M(this.f10863i.e());
        Log.d("EmbeddedViewDecor", "changeTaskOrientation taskData " + this.f10863i + ",onlyChangeLaunchRect:" + c02 + " newTaskData: " + G3 + " rect:" + rect + " width:" + this.f10859e.getWidth() + " height:" + this.f10859e.getHeight() + ",isSystemAnimating:" + z3);
        if (containerView.f10732G.b0()) {
            Log.d("EmbeddedViewDecor", "changeTaskOrientation splitBar onScrolling, wait scroll end to notifyUpdateLayout.");
            this.f10875u = new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.view.l
                @Override // java.lang.Runnable
                public final void run() {
                    EmbeddedViewDecor.this.T(containerView, G3, rect, c02);
                }
            };
        } else if (!X(G3) || c02) {
            Z(containerView, G3, rect, false, c02);
        } else {
            i0(containerView, G3, rect, z3);
        }
    }

    void H() {
        try {
            if (this.f10864j != null) {
                OplusActivityTaskManager.getInstance().moveTaskToBack(this.f10863i.s(), true);
                return;
            }
            Log.e("EmbeddedViewDecor", "token is null, taskId=" + this.f10863i.s());
        } catch (RemoteException | IllegalArgumentException e3) {
            Log.e("EmbeddedViewDecor", "hideTask " + e3.getMessage());
        }
    }

    public void I() {
        if (this.f10859e != null) {
            Log.d("EmbeddedViewDecor", "hideTaskView, taskData=" + this.f10863i);
            this.f10876v = false;
            this.f10859e.setAlpha(0.0f);
        }
    }

    public boolean M() {
        return this.f10867m;
    }

    public boolean N() {
        Rect launchBounds = this.f10859e.getLaunchBounds();
        if (launchBounds != null && !launchBounds.isEmpty()) {
            if (Math.abs((this.f10859e.getWidth() / launchBounds.width()) - (this.f10859e.getHeight() / launchBounds.height())) >= 0.01f) {
                return false;
            }
        }
        return true;
    }

    public boolean O() {
        return this.f10861g;
    }

    public void V() {
        if (this.f10859e != null) {
            N();
        }
    }

    public void W() {
        if (this.f10859e != null) {
            N();
        }
    }

    public void a0() {
        if (this.f10863i == null || this.f10864j == null || this.f10859e == null || B1.l.O1(((RelativeLayout) this).mContext).t0() != 3 || !this.f10860f) {
            return;
        }
        int s3 = this.f10863i.s();
        if (this.f10859e.isVisibleToUser()) {
            if (f10858y.booleanValue()) {
                Log.d("EmbeddedViewDecor", Log.getStackTraceString(new Throwable("onFocused: setFocusedTask =" + s3)));
            }
            B1.l.Q().execute(new d(s3));
            return;
        }
        if (this.f10859e.getAlpha() == 0.0f) {
            this.f10876v = true;
            Log.d("EmbeddedViewDecor", "onFocused: PendingSetFocus: " + s3);
        }
    }

    public void b0() {
        Runnable runnable = this.f10875u;
        if (runnable != null) {
            runnable.run();
            this.f10875u = null;
        }
    }

    void d0() {
        this.f10859e.setFlexibleFrame();
        f0();
    }

    public void g0(long j3) {
        if (this.f10859e != null) {
            Log.d("EmbeddedViewDecor", "showTaskView, taskData=" + this.f10863i + ", mPendingSetFocus: " + this.f10876v);
            FlexibleTaskView flexibleTaskView = this.f10859e;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(flexibleTaskView, "alpha", flexibleTaskView.getAlpha(), 1.0f);
            ofFloat.setDuration(j3);
            ofFloat.setInterpolator(new Y.d());
            ofFloat.addListener(new b());
            ofFloat.start();
        }
    }

    public C0327t getCanvasControlBarManager() {
        return this.f10862h;
    }

    public Bitmap getEmbeddedViewSnapShot() {
        return this.f10874t;
    }

    C0601d getFlexibleTaskData() {
        return this.f10863i;
    }

    public FlexibleTaskView getFlexibleTaskView() {
        return this.f10859e;
    }

    public boolean getInitialized() {
        return this.f10860f;
    }

    public Rect getLaunchRect() {
        C0601d c0601d = this.f10863i;
        if (c0601d == null) {
            return new Rect();
        }
        Rect n3 = c0601d.n();
        if (this.f10863i.H()) {
            n3.offsetTo(0, 0);
        }
        if (!(getParent() instanceof ContainerView)) {
            return n3;
        }
        if (((ContainerView) getParent()).l1(this)) {
            n3 = this.f10863i.i();
        }
        return (B1.s.H() && this.f10863i.B()) ? this.f10863i.i() : n3;
    }

    public int getLightMode() {
        return this.f10873s;
    }

    public C0601d getTaskData() {
        return this.f10863i;
    }

    public float getViewTranslationX() {
        return this.f10871q;
    }

    public float getViewTranslationY() {
        return this.f10872r;
    }

    public void h0(Rect rect, Rect rect2, C0601d c0601d) {
        C0601d c0601d2;
        this.f10862h.J0(this.f10859e, this, rect, rect2, c0601d);
        if (!f10858y.booleanValue() || (c0601d2 = this.f10863i) == null || c0601d2.f() == null || this.f10863i.f().getComponent() == null) {
            return;
        }
        this.f10862h.u1(this.f10863i.f().getComponent().getPackageName());
    }

    public void j0(C0601d c0601d, Rect rect, float f3) {
        C0601d c0601d2 = this.f10863i;
        if (c0601d2 == null || !c0601d2.equals(c0601d)) {
            this.f10863i = c0601d;
            Intent f4 = c0601d.f();
            if (f4 != null) {
                Log.d("EmbeddedViewDecor", "task init taskData:" + this.f10863i + " rect:" + rect + " mFlexibleTaskView:" + this.f10859e + " context:" + this.f10859e.getContext());
                f4.addFlags(268435456);
                int userId = ((RelativeLayout) this).mContext.getUserId();
                if (this.f10863i.v() > 0) {
                    userId = this.f10863i.v();
                }
                int i3 = userId;
                int s3 = this.f10863i.s();
                if (s3 <= 0) {
                    s3 = -1;
                }
                this.f10859e.init(2, f3, 0.0f, rect, f4, s3, i3);
                if (B1.l.O1(((RelativeLayout) this).mContext).t0() == 4) {
                    setEnforceStart(true);
                }
            }
        }
    }

    public void l0() {
        try {
            Field declaredField = this.f10859e.getClass().getDeclaredField("mTaskInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this.f10859e);
            if (obj instanceof ActivityManager.RunningTaskInfo) {
                ActivityManager.RunningTaskInfo runningTaskInfo = (ActivityManager.RunningTaskInfo) obj;
                if (runningTaskInfo != null) {
                    m0(runningTaskInfo.topActivity);
                } else {
                    Log.d("EmbeddedViewDecor", "updateTopComponent failed null ");
                }
            }
        } catch (Exception e3) {
            Log.e("EmbeddedViewDecor", "updateTopComponent error " + e3.getMessage());
        }
    }

    public void m0(ComponentName componentName) {
        if (this.f10863i == null || componentName == null || B1.l.f213m.contains(componentName.flattenToShortString())) {
            Log.d("EmbeddedViewDecor", "updateTopComponent mTaskData null ");
            return;
        }
        this.f10863i.m0(componentName);
        if (this.f10863i.f() != null) {
            this.f10863i.f().putExtra("key_flexible_top_activity", componentName);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f10878x);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f10878x);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        if (J()) {
            return;
        }
        this.f10859e.layout(0, 0, i5 - i3, i6 - i4);
        Log.d("EmbeddedViewDecor", "onLayout " + i3 + " " + i4 + " " + i5 + " " + i6);
        Rect rect = new Rect(getLaunchRect());
        if (!rect.isValid() || rect.isEmpty()) {
            return;
        }
        h0(new Rect(i3, i4, i5, i6), rect, this.f10863i);
        Log.d("EmbeddedViewDecor", "onLayout resize launch bounds to " + rect);
        this.f10859e.resize(rect);
    }

    public void setControlBarVisibility(int i3) {
        this.f10862h.r1(i3);
    }

    public void setEmbeddedViewSnapShot(Bitmap bitmap) {
        this.f10874t = bitmap;
    }

    public void setEnforceStart(boolean z3) {
        try {
            this.f10859e.getClass().getDeclaredMethod("setEnforceStart", Boolean.TYPE).invoke(this.f10859e, Boolean.valueOf(z3));
        } catch (Exception e3) {
            Log.e("EmbeddedViewDecor", "failed to setEnforceStart :" + e3.getMessage());
        }
    }

    public void setGonnaVanish(boolean z3) {
        this.f10868n = z3;
    }

    public void setHasBeenReplaced(boolean z3) {
        try {
            this.f10859e.getClass().getDeclaredMethod("setHasBeenReplaced", Boolean.TYPE).invoke(this.f10859e, Boolean.valueOf(z3));
        } catch (Exception e3) {
            Log.e("EmbeddedViewDecor", "failed to setHasReplaced :" + e3.getMessage());
        }
    }

    public void setInitialized(boolean z3) {
        this.f10860f = z3;
    }

    public void setLightMode(boolean z3) {
        this.f10873s = z3 ? 1 : 0;
    }

    public void setTaskReparentToFlexibleTaskView(boolean z3) {
        this.f10861g = z3;
    }

    public void setViewTranslationX(float f3) {
        this.f10871q = f3;
    }

    public void setViewTranslationY(float f3) {
        this.f10872r = f3;
    }

    @Override // android.view.View
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(",getTranslationX:");
        sb.append(getTranslationX());
        sb.append(",getTranslationY:");
        sb.append(getTranslationY());
        sb.append(",getScaleX:");
        sb.append(getScaleX());
        sb.append(",getScaleY:");
        sb.append(getScaleY());
        sb.append(",getTaskId:");
        C0601d c0601d = this.f10863i;
        sb.append(c0601d != null ? c0601d.s() : -1);
        return sb.toString();
    }

    public EmbeddedViewDecor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10860f = false;
        this.f10861g = false;
        this.f10864j = null;
        this.f10865k = new Rect();
        this.f10866l = false;
        this.f10867m = false;
        this.f10868n = false;
        this.f10869o = new ArrayList();
        this.f10870p = new a(Looper.getMainLooper());
        this.f10873s = -1;
        this.f10875u = null;
        this.f10876v = false;
        this.f10877w = new FlexibleTaskViewCallback();
        this.f10878x = new c();
        try {
            this.f10859e = new FlexibleTaskView(context);
        } catch (Exception e3) {
            Log.w("EmbeddedViewDecor", "FlexibleTaskView init error " + e3);
        }
        C0327t c0327t = new C0327t(getContext());
        this.f10862h = c0327t;
        c0327t.s1(this);
        FlexibleTaskView flexibleTaskView = this.f10859e;
        if (flexibleTaskView != null) {
            addView(flexibleTaskView);
            Executor Q3 = B1.l.Q();
            this.f10859e.setListener(Q3, this.f10877w);
            this.f10859e.setWorkExecutor(Q3);
        }
    }
}
