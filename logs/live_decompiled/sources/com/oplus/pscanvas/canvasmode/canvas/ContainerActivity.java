package com.oplus.pscanvas.canvasmode.canvas;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.ActivityTaskManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import androidx.preference.Preference;
import com.android.internal.policy.SystemBarUtils;
import com.android.internal.util.ConcurrentUtils;
import com.oplus.app.OplusAppEnterInfo;
import com.oplus.app.OplusAppExitInfo;
import com.oplus.app.OplusAppSwitchConfig;
import com.oplus.app.OplusAppSwitchManager;
import com.oplus.content.OplusFeatureConfigManager;
import com.oplus.flexiblewindow.FlexibleWindowManager;
import com.oplus.pscanvas.OplusPsCanvasApp;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.mask.CanvasMaskListView;
import com.oplus.pscanvas.canvasmode.canvas.t0;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.DraggableCanvasViewGroup;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import com.oplus.splitscreen.OplusSplitScreenManager;
import com.oplus.view.inputmethod.OplusInputMethodManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import t1.AbstractC0589c;
import u1.C0599b;
import u1.C0600c;
import u1.C0601d;
import v1.C0609a;
import w1.C0622f;
import x0.C0629c;

/* loaded from: classes.dex */
public class ContainerActivity extends Activity {

    /* renamed from: r0, reason: collision with root package name */
    private static final String f10218r0 = "ContainerActivity";

    /* renamed from: C, reason: collision with root package name */
    private A1.b f10221C;

    /* renamed from: D, reason: collision with root package name */
    private int f10222D;

    /* renamed from: E, reason: collision with root package name */
    private i f10223E;

    /* renamed from: F, reason: collision with root package name */
    private int f10224F;

    /* renamed from: I, reason: collision with root package name */
    private Runnable f10227I;

    /* renamed from: J, reason: collision with root package name */
    private Runnable f10228J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f10229K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f10230L;

    /* renamed from: M, reason: collision with root package name */
    private int f10231M;

    /* renamed from: Q, reason: collision with root package name */
    private B1.b f10235Q;

    /* renamed from: S, reason: collision with root package name */
    private int f10237S;

    /* renamed from: W, reason: collision with root package name */
    private D0 f10241W;

    /* renamed from: e, reason: collision with root package name */
    private l f10249e;

    /* renamed from: f, reason: collision with root package name */
    private k f10251f;

    /* renamed from: h, reason: collision with root package name */
    private DraggableCanvasViewGroup f10255h;

    /* renamed from: i, reason: collision with root package name */
    private t0 f10257i;

    /* renamed from: i0, reason: collision with root package name */
    private DeviceStateManager f10258i0;

    /* renamed from: m, reason: collision with root package name */
    private r0 f10265m;

    /* renamed from: m0, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f10266m0;

    /* renamed from: n, reason: collision with root package name */
    private FlexibleWindowManager f10267n;

    /* renamed from: o, reason: collision with root package name */
    private EmbeddedWindowCallback f10269o;

    /* renamed from: p, reason: collision with root package name */
    private C0332y f10271p;

    /* renamed from: q, reason: collision with root package name */
    boolean f10273q;

    /* renamed from: r, reason: collision with root package name */
    private A0 f10275r;

    /* renamed from: s, reason: collision with root package name */
    private y1.n f10276s;

    /* renamed from: v, reason: collision with root package name */
    private ContainerView f10279v;

    /* renamed from: w, reason: collision with root package name */
    private RelativeLayout f10280w;

    /* renamed from: x, reason: collision with root package name */
    private CanvasMaskListView f10281x;

    /* renamed from: y, reason: collision with root package name */
    Rect f10282y;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10253g = false;

    /* renamed from: j, reason: collision with root package name */
    private final HashMap f10259j = new HashMap();

    /* renamed from: k, reason: collision with root package name */
    private final HashMap f10261k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private Rect f10263l = new Rect();

    /* renamed from: t, reason: collision with root package name */
    private int f10277t = 0;

    /* renamed from: u, reason: collision with root package name */
    private List f10278u = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    private boolean f10283z = false;

    /* renamed from: A, reason: collision with root package name */
    private boolean f10219A = false;

    /* renamed from: B, reason: collision with root package name */
    private boolean f10220B = false;

    /* renamed from: G, reason: collision with root package name */
    private Rect f10225G = new Rect();

    /* renamed from: H, reason: collision with root package name */
    private final Object f10226H = new Object();

    /* renamed from: N, reason: collision with root package name */
    private boolean f10232N = false;

    /* renamed from: O, reason: collision with root package name */
    private boolean f10233O = false;

    /* renamed from: P, reason: collision with root package name */
    private int f10234P = 0;

    /* renamed from: R, reason: collision with root package name */
    public Rect f10236R = new Rect();

    /* renamed from: T, reason: collision with root package name */
    private int f10238T = -1;

    /* renamed from: U, reason: collision with root package name */
    private int f10239U = -1;

    /* renamed from: V, reason: collision with root package name */
    private int f10240V = -1;

    /* renamed from: X, reason: collision with root package name */
    private boolean f10242X = false;

    /* renamed from: Y, reason: collision with root package name */
    private int f10243Y = 0;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f10244Z = false;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f10245a0 = false;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f10246b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f10247c0 = false;

    /* renamed from: d0, reason: collision with root package name */
    private int f10248d0 = Color.parseColor("#1A1A1A");

    /* renamed from: e0, reason: collision with root package name */
    private int f10250e0 = Color.parseColor("#1A1A1A");

    /* renamed from: f0, reason: collision with root package name */
    private boolean f10252f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    private int f10254g0 = 0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f10256h0 = false;

    /* renamed from: j0, reason: collision with root package name */
    private final List f10260j0 = new ArrayList();

    /* renamed from: k0, reason: collision with root package name */
    private boolean f10262k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f10264l0 = false;

    /* renamed from: n0, reason: collision with root package name */
    private final Handler f10268n0 = new a(this, Looper.getMainLooper());

    /* renamed from: o0, reason: collision with root package name */
    private DeviceStateManager.DeviceStateCallback f10270o0 = new b();

    /* renamed from: p0, reason: collision with root package name */
    private OplusAppSwitchManager.OnAppSwitchObserver f10272p0 = new c();

    /* renamed from: q0, reason: collision with root package name */
    private final t0.c f10274q0 = new f();

    /* JADX INFO: Access modifiers changed from: private */
    class EmbeddedWindowCallback implements FlexibleWindowManager.IEmbeddedWindowCallback {
        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$adjustFlexiblePositionForIme$0(boolean z3, int i3) {
            boolean z4 = ((ViewGroup) ContainerActivity.this.f10279v.getParent()).getTranslationY() == 0.0f && z3 && ContainerActivity.this.f10244Z;
            Log.d(ContainerActivity.f10218r0, "adjustFlexiblePositionForIme ime visible: " + z3 + " mLatestImeVisible: " + ContainerActivity.this.f10244Z + " offset: " + i3 + " mContainerView: " + ContainerActivity.this.f10279v + " mLatestOffset: " + ContainerActivity.this.f10243Y + " forceUpdate : " + z4);
            if (ContainerActivity.this.f10244Z == z3 && ContainerActivity.this.f10243Y == i3 && !z4) {
                return;
            }
            ContainerActivity.this.f10244Z = z3;
            ContainerActivity.this.f10242X = z3;
            if (ContainerActivity.this.f10279v != null) {
                ContainerActivity.this.f10279v.J1(ContainerActivity.this.f10242X);
            }
            if (z3) {
                ContainerActivity.this.f10243Y = i3;
            } else {
                ContainerActivity.this.f10243Y = 0;
            }
            ContainerActivity.this.f10268n0.removeMessages(1);
            ContainerActivity.this.E1(z3, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$autoScaleToOriginPosition$6() {
            if (ContainerActivity.this.f10279v != null) {
                Log.d(ContainerActivity.f10218r0, "drop result is false, autoScaleToOriginPosition");
                ContainerActivity.this.f10279v.X();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyCanvasTaskEvent$9(int i3, Bundle bundle) {
            EmbeddedViewDecor r02;
            C0601d q02 = ContainerActivity.this.q0(i3);
            int i4 = bundle.getInt("androidx.activity.TaskEvent", -1);
            if (i4 == 8) {
                ContainerActivity.this.f10238T = i3;
            }
            if (i4 == 7 && ContainerActivity.this.f10279v.f10732G != null) {
                ContainerActivity.this.f10279v.f10732G.n0();
                return;
            }
            if (i4 == 0) {
                if (ContainerActivity.this.f10271p.f10944J) {
                    ContainerActivity.this.f10271p.V(true);
                }
                int position = ContainerActivity.this.f10279v.getAdapter().getPosition(q02);
                if (ContainerActivity.this.f10275r.M()) {
                    ContainerActivity.this.f10279v.getContainerController().F(position);
                    return;
                } else {
                    ContainerActivity.this.f10279v.R(position);
                    return;
                }
            }
            if (i4 != 4 || !ContainerActivity.this.f10276s.R()) {
                if (ContainerActivity.this.f10279v == null || (r02 = ContainerActivity.this.f10279v.r0(ContainerActivity.this.f10279v.getAdapter().h(), q02)) == null) {
                    return;
                }
                r02.f10862h.k1(bundle);
                return;
            }
            Log.d(ContainerActivity.f10218r0, "notifyCanvasTaskEvent containerTask is in CanvasMaskManager Animating " + i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyCanvasUpdateControlBar$8(ActivityManager.RunningTaskInfo runningTaskInfo, boolean z3) {
            EmbeddedViewDecor r02;
            C0601d r03 = ContainerActivity.this.r0(runningTaskInfo, true);
            Log.d(ContainerActivity.f10218r0, "notifyCanvasUpdateControlBar   taskData= " + r03);
            if (ContainerActivity.this.f10279v == null || ContainerActivity.this.f10279v.getAdapter() == null || r03 == null || (r02 = ContainerActivity.this.f10279v.r0(ContainerActivity.this.f10279v.getAdapter().h(), r03)) == null) {
                return;
            }
            r02.f10862h.q1(r02.getFlexibleTaskView(), r02.getLaunchRect(), true, z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyFlexibleTaskVanish$5(ActivityManager.RunningTaskInfo runningTaskInfo) {
            Log.d(ContainerActivity.f10218r0, "cavasapp notifyFlexibleTaskVanish taskid: " + runningTaskInfo.taskId + " mState=" + ContainerActivity.this.f10237S);
            if (ContainerActivity.this.f10265m == null || ContainerActivity.this.isFinishing() || ContainerActivity.this.f10237S == 5) {
                return;
            }
            Bundle c02 = B1.l.c0(runningTaskInfo);
            if (c02 != null && c02.getInt("androidx.activity.PrevTaskId", -1) != -1) {
                Log.d(ContainerActivity.f10218r0, "cavasapp notifyFlexibleTaskVanish HasPrevTask taskid: " + runningTaskInfo.taskId);
                ContainerActivity.this.H1(true);
                ContainerActivity.this.B1();
                return;
            }
            if (ContainerActivity.this.f10279v != null) {
                ContainerActivity.this.f10279v.f10732G.w0();
                C0601d r02 = ContainerActivity.this.r0(runningTaskInfo, false);
                if (r02 == null) {
                    Log.w(ContainerActivity.f10218r0, "vanish can't find task:" + runningTaskInfo);
                    return;
                }
                if (ContainerActivity.this.f10279v.k1() && !ContainerActivity.this.f10279v.f10742L && ContainerActivity.this.f10237S < 5) {
                    ContainerActivity.this.f10279v.n0(r02);
                    B1.h.a(ContainerActivity.this).e("app_exit");
                } else if (ContainerActivity.this.f10279v.i1()) {
                    if (ContainerActivity.this.f10275r.L()) {
                        ContainerActivity.this.f10275r.w();
                    }
                    if (ContainerActivity.this.f10275r.M()) {
                        ContainerActivity.this.f10275r.A(false);
                    }
                    r02.S(true);
                    ContainerActivity.this.f10279v.T1(r02);
                } else if (!ContainerActivity.this.f10279v.k1()) {
                    Log.w(ContainerActivity.f10218r0, "finish canvas as it's not a normal split.");
                    ContainerActivity.this.finish();
                }
            }
            ContainerActivity.this.l0("FlexibleTaskVanish");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$notifyTaskToFullScreen$7(C0601d c0601d) {
            if (c0601d != null) {
                ContainerActivity.this.f10279v.n1(ContainerActivity.this.f10279v.getAdapter().getPosition(c0601d));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onRecentsAnimationExecuting$4(boolean z3) {
            ContainerActivity.this.f10257i.l(z3);
            Log.d(ContainerActivity.f10218r0, "onRecentsAnimationExecuting " + z3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startReplaceSplitWhenNormalSplit$2() {
            ContainerActivity.this.f10229K = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startReplaceSplitWhenNormalSplit$3(int i3, int i4, int i5, Intent intent) {
            if (ContainerActivity.this.isFinishing()) {
                Log.w(ContainerActivity.f10218r0, "startReplaceSplitWhenNormalSplit activity is finishing");
                return;
            }
            Log.d(ContainerActivity.f10218r0, "startReplaceSplitWhenNormalSplit taskId:" + i3 + " index:" + i4 + " userId:" + i5 + " intent:" + intent);
            ContainerActivity.this.f10229K = true;
            ContainerActivity.this.getMainThreadHandler().postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.g0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$startReplaceSplitWhenNormalSplit$2();
                }
            }, 500L);
            ContainerActivity.this.L0();
            if (ContainerActivity.this.f10275r.M()) {
                ContainerActivity.this.f10275r.A(false);
                ContainerActivity.this.f10279v.getContainerController().N(1);
            }
            String str = (String) intent.getExtra("androidx.flexible.replaceIntent");
            if (str != null && i4 < 0) {
                int k3 = ContainerActivity.this.f10265m.k();
                for (int i6 = 0; i6 < k3; i6++) {
                    Intent f3 = ContainerActivity.this.f10265m.l(i6).f();
                    ComponentName N3 = B1.l.N(ContainerActivity.this, f3);
                    if (N3 != null && N3.toShortString().equals(str) && i5 == ContainerActivity.this.f10265m.l(i6).v()) {
                        Log.d(ContainerActivity.f10218r0, "startReplaceSplitWhenNormalSplit realIndex index " + i6 + " current:" + f3);
                        i4 = i6;
                    }
                }
            }
            ContainerActivity.this.f10279v.q0(i4).setHasBeenReplaced(true);
            ContainerActivity.this.Z1(i3, intent, i5, i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$startThreeSplitFromNormalSplit$1(int i3, Intent intent) {
            if (ContainerActivity.this.isFinishing()) {
                Log.w(ContainerActivity.f10218r0, "startThreeSplitFromNormalSplit activity is finishing");
                return;
            }
            Log.d(ContainerActivity.f10218r0, "startThreeSplitFromNormalSplit userId:" + i3 + " intent:" + intent);
            ContainerActivity.this.f10221C.n();
            ContainerActivity.this.L0();
            if (ContainerActivity.this.f10275r.M()) {
                ContainerActivity.this.f10275r.A(false);
            }
            if (ContainerActivity.this.f10279v.f10732G.b0() || ContainerActivity.this.f10271p.Z()) {
                Log.d(ContainerActivity.f10218r0, "startThreeSplitFromNormalSplit cancelSplitBarScroll");
                ContainerActivity.this.f10279v.f10732G.y();
                ContainerActivity.this.f10271p.W(false);
            }
            ContainerActivity.this.h0(intent, i3, true);
        }

        public void adjustFlexiblePositionForIme(final boolean z3, final int i3) {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.l0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$adjustFlexiblePositionForIme$0(z3, i3);
                }
            });
        }

        public void autoScaleToOriginPosition() {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.f0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$autoScaleToOriginPosition$6();
                }
            });
        }

        public void notifyCanvasContainerReleaseTasks() {
            if (ContainerActivity.this.f10279v != null) {
                Log.d(ContainerActivity.f10218r0, "notifyCanvasContainerReleaseTasks");
                ContainerActivity.this.f10279v.P1();
            }
        }

        public void notifyCanvasTaskEvent(final int i3, final Bundle bundle) {
            Log.d(ContainerActivity.f10218r0, "notifyCanvasTaskEvent taskId=" + i3 + " bundle " + bundle);
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.m0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$notifyCanvasTaskEvent$9(i3, bundle);
                }
            });
        }

        public void notifyCanvasUpdateControlBar(final ActivityManager.RunningTaskInfo runningTaskInfo, final boolean z3) {
            Log.d(ContainerActivity.f10218r0, "notifyCanvasUpdateControlBar   taskInfo=" + runningTaskInfo + " light " + z3);
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.h0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$notifyCanvasUpdateControlBar$8(runningTaskInfo, z3);
                }
            });
        }

        public void notifyDragStart() {
            Log.d(ContainerActivity.f10218r0, "notifyDragStart ");
            if (ContainerActivity.this.f10279v != null) {
                ContainerActivity.this.f10279v.I0();
                ContainerActivity.this.f10279v.J0();
            }
        }

        public void notifyFlexibleTaskVanish(int i3) {
            throw new UnsupportedOperationException("deprecated");
        }

        public void notifyTaskRectOrientationChange(ActivityManager.RunningTaskInfo runningTaskInfo, Rect rect) {
            throw new UnsupportedOperationException("deprecated");
        }

        public void notifyTaskToFullScreen(int i3) {
            Log.d(ContainerActivity.f10218r0, "notifyTaskToFullScreen   taskId=" + i3);
            final C0601d r02 = ContainerActivity.this.r0(B1.l.E(i3), false);
            if (ContainerActivity.this.f10279v == null || ContainerActivity.this.f10279v.f10742L) {
                return;
            }
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.i0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$notifyTaskToFullScreen$7(r02);
                }
            });
        }

        public void notifyWindowStateHasDrawn(ActivityManager.RunningTaskInfo runningTaskInfo) {
            if (runningTaskInfo == null) {
                return;
            }
            Log.d(ContainerActivity.f10218r0, "notifyWindowStateHasDrawn, taskInfo: " + runningTaskInfo.getWindowingMode() + " taskInfo:" + runningTaskInfo);
            y1.n canvasMaskManager = ContainerActivity.this.f10279v.getCanvasMaskManager();
            canvasMaskManager.j0(ContainerActivity.this.f10279v.getCanvasMaskManager().G());
            canvasMaskManager.g0(runningTaskInfo.taskId);
            int i3 = runningTaskInfo.taskId;
            if (i3 != -1) {
                if (i3 == canvasMaskManager.D()) {
                    ContainerActivity.this.f10279v.getCanvasMaskManager().d0(-1);
                    ContainerActivity.this.f10279v.getCanvasMaskManager().x0();
                    return;
                }
                int F3 = canvasMaskManager.F();
                int L3 = canvasMaskManager.L();
                int i4 = runningTaskInfo.taskId;
                int K3 = canvasMaskManager.K();
                if ((F3 == K3 && L3 == i4) || (L3 == K3 && F3 == i4)) {
                    Log.d(ContainerActivity.f10218r0, "notifyWindowStateHasDrawn OrientationChangeTask window has drawn, startHideMask");
                    ContainerActivity.this.f10279v.getCanvasMaskManager().f0(-1);
                    ContainerActivity.this.f10279v.getCanvasMaskManager().k0(-1);
                    canvasMaskManager.x0();
                    return;
                }
            }
            if (ContainerActivity.this.f10279v != null) {
                int i5 = runningTaskInfo.taskId;
                C0601d O3 = canvasMaskManager.O();
                C0601d C3 = canvasMaskManager.C();
                C0601d N3 = canvasMaskManager.N();
                if (ContainerActivity.this.f10279v.f1() || O3 == null || C3 == null) {
                    return;
                }
                if (ContainerActivity.this.f10279v.i1() && N3 == null) {
                    return;
                }
                int s3 = O3.s();
                int s4 = C3.s();
                int s5 = N3 != null ? N3.s() : -1;
                int K4 = canvasMaskManager.K();
                boolean z3 = false;
                boolean z4 = ContainerActivity.this.f10279v.getIndexToMax() == -1 && ContainerActivity.this.f10279v.k1() && i5 != -1 && (K4 != -1 || O3.B() || C3.B()) && (((s3 == K4 || O3.B()) && s4 == i5) || C3.B() || ((s3 == i5 || O3.B()) && (s4 == K4 || C3.B())));
                boolean z5 = B1.s.B() && ContainerActivity.this.f10279v.k1() && ContainerActivity.this.f10279v.getIndexToMax() != -1 && i5 != -1 && ((ContainerActivity.this.f10279v.getIndexToMax() == 0 && s3 == i5) || O3.B() || ((ContainerActivity.this.f10279v.getIndexToMax() == 1 && s4 == i5) || C3.B()));
                if (ContainerActivity.this.f10279v.i1() && ContainerActivity.this.f10279v.getIndexToMax() >= 0 && ContainerActivity.this.f10279v.getIndexToMax() <= 2 && i5 != -1 && ((ContainerActivity.this.f10279v.getIndexToMax() == 0 && s3 == i5) || ((ContainerActivity.this.f10279v.getIndexToMax() == 1 && s4 == i5) || (ContainerActivity.this.f10279v.getIndexToMax() == 2 && s5 == i5)))) {
                    z3 = true;
                }
                if (z4 || z5 || z3) {
                    Log.d(ContainerActivity.f10218r0, "window has drawn and startHideMaskViewList, hasDrawnInSteplessAdjust: " + z4 + ", hasDrawnInPs: " + z5 + ", hasDrawnInThreeSplit: " + z3);
                    canvasMaskManager.y0();
                }
            }
        }

        public void onCanvasPositionChanged() {
            if (ContainerActivity.this.f10279v != null) {
                ContainerActivity.this.f10279v.s2();
            }
        }

        public void onRecentsAnimationExecuting(final boolean z3, int i3) {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.d0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$onRecentsAnimationExecuting$4(z3);
                }
            });
        }

        public void startReplaceSplitWhenNormalSplit(final int i3, final Intent intent, final int i4, final int i5) {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.e0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$startReplaceSplitWhenNormalSplit$3(i3, i5, i4, intent);
                }
            });
        }

        public void startThreeSplitFromNormalSplit(final Intent intent, final int i3) {
            ContainerActivity.this.F1();
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.j0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$startThreeSplitFromNormalSplit$1(i3, intent);
                }
            });
        }

        private EmbeddedWindowCallback() {
        }

        public void notifyFlexibleTaskVanish(final ActivityManager.RunningTaskInfo runningTaskInfo) {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.k0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.EmbeddedWindowCallback.this.lambda$notifyFlexibleTaskVanish$5(runningTaskInfo);
                }
            });
        }
    }

    class a extends Handler {
        a(ContainerActivity containerActivity, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
                return;
            }
            Object obj = message.obj;
            if (obj != null) {
                ((j) obj).c();
            }
        }
    }

    class b implements DeviceStateManager.DeviceStateCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            ContainerActivity.this.M0();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(WeakReference weakReference, Bitmap bitmap) {
            ContainerActivity containerActivity = (ContainerActivity) weakReference.get();
            if (containerActivity != null && !containerActivity.isFinishing() && !containerActivity.isDestroyed()) {
                containerActivity.i1(bitmap);
            } else if (bitmap != null) {
                bitmap.recycle();
            }
        }

        public void onDeviceStateChanged(DeviceState deviceState) {
            int identifier = deviceState.getIdentifier();
            ContainerActivity containerActivity = ContainerActivity.this;
            boolean z3 = !containerActivity.R0(containerActivity.f10239U) && ContainerActivity.this.R0(identifier);
            String str = ContainerActivity.f10218r0;
            StringBuilder sb = new StringBuilder();
            sb.append("onStateChanged, isFolded=");
            sb.append(z3);
            sb.append(", device state from ");
            ContainerActivity containerActivity2 = ContainerActivity.this;
            sb.append(containerActivity2.n0(containerActivity2.f10239U));
            sb.append(" to ");
            sb.append(ContainerActivity.this.n0(identifier));
            Log.d(str, sb.toString());
            if (B1.s.p()) {
                Log.d(ContainerActivity.f10218r0, "onStateChanged, return on flip device");
                return;
            }
            if (z3) {
                if (ContainerActivity.this.f10239U == 2 && identifier == 0) {
                    ContainerActivity.this.l0("onDeviceStateChanged");
                }
                if (ContainerActivity.this.f10239U == -1 && ContainerActivity.this.f10265m != null && ContainerActivity.this.f10265m.k() != 3) {
                    Log.d(ContainerActivity.f10218r0, "onStateChanged, return since canvas created in folded state");
                    ContainerActivity.this.f10239U = identifier;
                    return;
                } else {
                    Log.d(ContainerActivity.f10218r0, "onStateChanged, finish activity");
                    Handler handler = ContainerActivity.this.f10268n0;
                    final ContainerActivity containerActivity3 = ContainerActivity.this;
                    handler.postAtFrontOfQueue(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.Y
                        @Override // java.lang.Runnable
                        public final void run() {
                            ContainerActivity.this.finish();
                        }
                    });
                }
            } else {
                ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.Z
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerActivity.b.this.c();
                    }
                });
                if (ContainerActivity.this.f10279v.k1() && ContainerActivity.this.f10239U != -1) {
                    Log.d(ContainerActivity.f10218r0, "set mResetLayoutOrientation to true");
                    ContainerActivity.this.f10220B = true;
                    if (identifier > 1) {
                        ContainerActivity.this.f10234P = 0;
                    }
                    if (ContainerActivity.this.f10265m != null) {
                        ContainerActivity.this.f10265m.g();
                    }
                }
                final Bitmap s02 = B1.l.s0();
                final WeakReference weakReference = new WeakReference(ContainerActivity.this);
                ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.a0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerActivity.b.d(weakReference, s02);
                    }
                });
            }
            ContainerActivity.this.f10239U = identifier;
            ContainerActivity.this.f10219A = z3;
            B1.h.a(ContainerActivity.this).f(ContainerActivity.this.f10219A ? 1 : 0);
        }
    }

    class c implements OplusAppSwitchManager.OnAppSwitchObserver {

        class a implements Runnable {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ OplusAppEnterInfo f10286e;

            a(c cVar, OplusAppEnterInfo oplusAppEnterInfo) {
                this.f10286e = oplusAppEnterInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (B1.l.f217q) {
                    try {
                        if (!B1.l.f217q.containsKey(this.f10286e.targetName)) {
                            B1.l.O0(this.f10286e.targetName);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3) {
            if (ContainerActivity.this.f10276s.R() && ContainerActivity.this.f10279v.Y0()) {
                Log.d(ContainerActivity.f10218r0, "mAutoScaleFromAppEnter return as is in mIsThreeToTwoAnimation");
            } else {
                ContainerActivity.this.f10279v.R(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(OplusAppEnterInfo oplusAppEnterInfo) {
            if (oplusAppEnterInfo == null) {
                return;
            }
            Log.d(ContainerActivity.f10218r0, "onAppEnter " + oplusAppEnterInfo);
            final int i3 = -1;
            if (oplusAppEnterInfo.windowMode == 100) {
                ContainerActivity.this.f10279v.getAdapter().H(-1);
            }
            if (ContainerActivity.this.f10283z) {
                int i4 = 0;
                if (ContainerActivity.this.f10246b0) {
                    ContainerActivity.this.H1(false);
                    Log.d(ContainerActivity.f10218r0, "onAppEnter IgnoreFocusChangeFromAppEnter return");
                    return;
                }
                int i5 = oplusAppEnterInfo.extension.getInt("taskId");
                if (oplusAppEnterInfo.targetName != null) {
                    C0305a.a().b(new a(this, oplusAppEnterInfo));
                }
                while (true) {
                    if (i4 >= ContainerActivity.this.f10279v.getContainerController().k()) {
                        break;
                    }
                    C0601d l3 = ContainerActivity.this.f10279v.getContainerController().l(i4);
                    int s3 = l3.s();
                    if (((l3.v() == 0 && !oplusAppEnterInfo.multiApp) || (l3.v() != 0 && oplusAppEnterInfo.multiApp)) && i5 == s3) {
                        i3 = i4;
                        break;
                    }
                    i4++;
                }
                if (ContainerActivity.this.f10279v.f10755S || ((ContainerActivity.this.f10271p.f10944J && !ContainerActivity.this.f10279v.getAdapter().x()) || ContainerActivity.this.f10279v.f10750P || ContainerActivity.this.f10229K)) {
                    if (!ContainerActivity.this.f10279v.f10750P || ContainerActivity.this.f10229K || i3 < 0 || i3 == ContainerActivity.this.f10279v.getContainerController().n()) {
                        return;
                    }
                    Log.d(ContainerActivity.f10218r0, "onAppEnter setFocusIndex target : " + i3);
                    ContainerActivity.this.f10279v.getAdapter().H(i3);
                    return;
                }
                if (i3 < 0 || ContainerActivity.this.f10275r.M()) {
                    return;
                }
                Log.d(ContainerActivity.f10218r0, "onAppEnter autoScale to " + i3);
                if (ContainerActivity.this.f10279v.getContainerController().n() != i3 || ContainerActivity.this.f10279v.getAdapter().x()) {
                    ContainerActivity.this.f10228J = new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.c0
                        @Override // java.lang.Runnable
                        public final void run() {
                            ContainerActivity.c.this.c(i3);
                        }
                    };
                    ContainerActivity.this.f10268n0.postDelayed(ContainerActivity.this.f10228J, 100L);
                }
            }
        }

        public void onActivityEnter(OplusAppEnterInfo oplusAppEnterInfo) {
        }

        public void onActivityExit(OplusAppExitInfo oplusAppExitInfo) {
        }

        public void onAppEnter(final OplusAppEnterInfo oplusAppEnterInfo) {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.b0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.c.this.d(oplusAppEnterInfo);
                }
            });
        }

        public void onAppExit(OplusAppExitInfo oplusAppExitInfo) {
        }
    }

    class d implements C0600c.a {
        d() {
        }

        @Override // u1.C0600c.a
        public void a(int i3, C0601d c0601d) {
            EmbeddedViewDecor r02 = ContainerActivity.this.f10279v.r0(i3, c0601d);
            if (r02 == null || ContainerActivity.this.f10245a0) {
                return;
            }
            r02.a0();
            r02.f10862h.J1();
        }

        @Override // u1.C0600c.a
        public void b(int i3) {
            EmbeddedViewDecor q02 = ContainerActivity.this.f10279v.q0(i3);
            if (q02 != null) {
                q02.f10862h.m1();
            }
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!ContainerActivity.this.f10279v.Q()) {
                return false;
            }
            ContainerActivity.this.f10279v.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    class f implements t0.c {
        f() {
        }

        @Override // com.oplus.pscanvas.canvasmode.canvas.t0.c
        public void a(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (ContainerActivity.this.f10255h == null || ContainerActivity.this.f10279v == null) {
                Log.e(ContainerActivity.f10218r0, "RootView is null!");
                return;
            }
            if (ContainerActivity.this.f10279v.f10732G != null && ContainerActivity.this.f10279v.f10732G.e0()) {
                Log.i(ContainerActivity.f10218r0, "onTouchEvent isNeedWaitScrollTips");
                return;
            }
            if (ContainerActivity.this.f10221C != null) {
                ContainerActivity.this.f10221C.m(motionEvent);
            }
            if (ContainerActivity.this.f10232N && (actionMasked != 0 || ((ContainerActivity.this.f10279v.h0((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && ContainerActivity.this.f10279v.f10732G.W(motionEvent) == null) || ContainerActivity.this.f10267n.isClickAtPocketStudioArea(ContainerActivity.this.getDisplay().getDisplayId(), (int) motionEvent.getRawX(), (int) motionEvent.getRawY())))) {
                ContainerActivity.this.f10271p.T(motionEvent);
            } else {
                Log.e(ContainerActivity.f10218r0, "not click at PocketStudio, ignored");
                ContainerActivity.this.f10271p.J();
            }
        }
    }

    class g implements Runnable {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f10290e;

        g(List list) {
            this.f10290e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ContainerActivity.this.f10232N) {
                try {
                    Iterator it = this.f10290e.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        ActivityTaskManager.getService().setFocusedTask(intValue);
                        Log.d(ContainerActivity.f10218r0, "manually set focus taskId : " + intValue);
                    }
                } catch (Exception unused) {
                    Log.e(ContainerActivity.f10218r0, "set focus task failed");
                }
            }
        }
    }

    public interface h {
        void a(com.coui.appcompat.poplist.f fVar);
    }

    private class i extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (!"android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(intent.getAction()) || (stringExtra = intent.getStringExtra("reason")) == null) {
                return;
            }
            if (stringExtra.equals("homekey")) {
                ContainerActivity.this.s1();
            } else if (stringExtra.equals("recentapps")) {
                ContainerActivity.this.r1();
            }
        }

        private i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class j {

        /* renamed from: a, reason: collision with root package name */
        private boolean f10293a;

        /* renamed from: b, reason: collision with root package name */
        public int f10294b;

        public j(boolean z3, int i3) {
            this.f10294b = i3;
            this.f10293a = z3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (ContainerActivity.this.f10265m == null || ContainerActivity.this.isFinishing() || ContainerActivity.this.f10279v == null) {
                return;
            }
            ContainerActivity.this.f10279v.I0();
            if (!this.f10293a) {
                if (ContainerActivity.this.f10275r.M()) {
                    ContainerActivity.this.f10275r.z(true);
                    return;
                } else {
                    ContainerActivity.this.f10279v.U(ContainerActivity.this.f10265m.n(), false);
                    return;
                }
            }
            boolean inAutoFocusAnimation = ContainerActivity.this.f10279v.getInAutoFocusAnimation();
            int type = ContainerActivity.this.f10279v.getType();
            if (!inAutoFocusAnimation || type == 3) {
                ContainerActivity.this.f10279v.G0(this.f10294b);
            } else {
                Log.d(ContainerActivity.f10218r0, "ImeTranslationRunnable run return");
                ContainerActivity.this.E1(this.f10293a, this.f10294b);
            }
        }

        public void c() {
            ContainerActivity.this.runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.p0
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.j.this.b();
                }
            });
        }
    }

    private class k extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private final Context f10296a;

        public k(Context context, Handler handler) {
            super(handler);
            this.f10296a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            ContainerActivity.this.f10253g = Settings.Secure.getIntForUser(this.f10296a.getContentResolver(), "one_handed_mode_activated", 0, this.f10296a.getUserId()) == 1;
            if (ContainerActivity.this.f10253g) {
                ContainerActivity.this.v0().getAdapter().H(0);
            }
            Log.d(ContainerActivity.f10218r0, "onChange isOneHandedModeActivated=" + ContainerActivity.this.f10253g);
        }
    }

    private class l extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        private final Context f10298a;

        public l(Context context, Handler handler) {
            super(handler);
            this.f10298a = context;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z3) {
            ContainerActivity.this.u1(this.f10298a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1() {
        C0332y c0332y = this.f10271p;
        if (c0332y == null || c0332y.L() == null) {
            return;
        }
        this.f10271p.L().k0(2);
    }

    private int H0(int i3, Intent intent) {
        int intExtra = intent.getIntExtra("androidx.activity.LaunchEmbeddedTaskId", -1);
        if (i3 > 0) {
            return i3;
        }
        if (intExtra > 0) {
            return intExtra;
        }
        return -1;
    }

    private void K1(Rect rect, boolean z3) {
        int height = rect.height();
        int i3 = Settings.Global.getInt(getContentResolver(), "oplus_system_folding_mode", 1);
        Log.d(f10218r0, "[setNavigationBarHeight]fold state: " + i3 + ", navRect=" + rect + ", oldNavigationBarHeight=" + this.f10224F + ", newHeight=" + height);
        if (this.f10219A || this.f10233O) {
            return;
        }
        this.f10224F = height;
        this.f10225G = rect;
        j0();
        n1(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        getWindow().setStatusBarColor(0);
        getWindow().setFlags(1024, 1024);
        getWindow().getDecorView().setSystemUiVisibility(!B1.s.v(getResources().getConfiguration()) ? 14084 : 5892);
        this.f10254g0 = 0;
        getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
    }

    private void M1(C0601d c0601d, boolean[] zArr, int i3, List list, int[] iArr) {
        if (c0601d.p() == 1 || B1.s.w(this) || (c0601d.p() != 1 && list.size() == 2)) {
            if (zArr != null && zArr.length > i3) {
                c0601d.o0(zArr[i3]);
                c0601d.T(true);
            } else if (list.size() == 2 && Objects.equals(B1.l.d0((Intent) list.get(0)), B1.l.d0((Intent) list.get(1))) && iArr[0] == iArr[1]) {
                c0601d.o0(false);
            } else {
                c0601d.o0(c0601d.x());
            }
        }
    }

    private void O0() {
        setContentView(t1.h.f13477j);
        this.f10255h = (DraggableCanvasViewGroup) findViewById(t1.f.f13459s);
        this.f10279v = (ContainerView) findViewById(t1.f.f13461u);
        this.f10280w = (RelativeLayout) findViewById(t1.f.f13460t);
        this.f10281x = (CanvasMaskListView) findViewById(t1.f.f13454n);
        this.f10265m = new r0();
        this.f10276s = new y1.n(this);
        C0599b c0599b = new C0599b(this, 0, new ArrayList());
        CanvasMaskListView canvasMaskListView = this.f10281x;
        if (canvasMaskListView != null) {
            canvasMaskListView.setAdapter(c0599b);
        }
        ContainerView containerView = this.f10279v;
        if (containerView != null) {
            this.f10265m.E(this, containerView);
            this.f10265m.L(B1.s.i(getResources().getConfiguration()));
            this.f10276s.e0(this.f10279v);
            this.f10279v.f10732G.U(getIntent());
            this.f10279v.setContainerController(this.f10265m);
            this.f10279v.setConfigHelper(new C0609a(getApplicationContext()));
            this.f10279v.p2(this.f10276s, this.f10281x);
            this.f10279v.B0(this);
        }
    }

    private void P1() {
        if (B1.l.u()) {
            i1(null);
        } else {
            k0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R0(int i3) {
        return i3 == 0 || i3 == 1 || i3 == 100;
    }

    private boolean R1(Context context) {
        return B1.s.w(context) || B1.l.u0();
    }

    private void S1() {
        getWindow().getDecorView().setSystemUiVisibility(5888);
        getWindow().setFlags(Integer.MIN_VALUE, Integer.MIN_VALUE);
        getWindow().setStatusBarColor(this.f10250e0);
        this.f10254g0 = SystemBarUtils.getStatusBarHeight(this);
        getWindow().getInsetsController().show(WindowInsets.Type.statusBars());
    }

    private boolean T1(Bundle bundle) {
        String str;
        final C0601d c0601d;
        C0601d c0601d2;
        List list;
        String str2;
        int i3;
        if (bundle == null) {
            Log.d(f10218r0, "bundle is null");
            return false;
        }
        final ArrayList parcelableArrayList = bundle.getParcelableArrayList("androidx.flexible.intentList", Intent.class);
        int[] intArray = bundle.getIntArray("androidx.flexible.taskIdList");
        final int[] intArray2 = bundle.getIntArray("androidx.flexible.userIdList");
        if (parcelableArrayList == null || intArray == null || intArray2 == null) {
            return false;
        }
        int i4 = bundle.getInt("androidx.flexible.focusIndex");
        int i5 = bundle.getInt("androidx.flexible.layoutOrientation", 0);
        int i6 = bundle.getInt("lineLayoutFocusSide", 0);
        if (i5 == 3 && i4 == 1 && (i6 == 1 || i6 == 2)) {
            this.f10265m.N(i6);
        }
        float f3 = bundle.getFloat("androidx.flexible.SplitRatio", 0.0f);
        this.f10234P = i5;
        Log.d(f10218r0, "startFlexibleTaskBundle taskId:" + Arrays.toString(intArray) + " userId:" + Arrays.toString(intArray2) + " intent list:" + parcelableArrayList + " focus:" + i4 + " layoutOrientation:" + i5 + " splitRatio:" + f3);
        if (parcelableArrayList.size() <= 0 || intArray.length < parcelableArrayList.size() || intArray2.length < parcelableArrayList.size()) {
            return false;
        }
        boolean[] booleanArray = (!B1.s.w(this) || B1.s.B()) ? bundle.getBooleanArray("androidx.flexible.useMaxLayoutArray") : new boolean[]{false, false};
        int i7 = (!B1.s.H() || this.f10265m.w() == bundle.getInt("androidx.flexible.screenOrientationForShortCut", 0)) ? i5 : 0;
        int i8 = 0;
        while (true) {
            str = "androidx.activity.LaunchEmbeddedTaskId";
            if (i8 >= parcelableArrayList.size()) {
                break;
            }
            Intent intent = (Intent) parcelableArrayList.get(i8);
            intent.putExtra("androidx.activity.LaunchEmbeddedTaskId", H0(intArray[i8], intent));
            intent.putExtra("androidx.flexible.userId", intArray2[i8]);
            i8++;
        }
        List o02 = B1.l.o0(this, parcelableArrayList, i7);
        if (o02 == null || (o02.size() != parcelableArrayList.size() && o02.size() <= 1)) {
            Log.d(f10218r0, "some app not support pocketstudio " + o02);
            s0();
            return false;
        }
        C0601d c0601d3 = null;
        int i9 = 0;
        while (i9 < o02.size()) {
            C0601d c0601d4 = (C0601d) o02.get(i9);
            if (c0601d4 != null) {
                c0601d4.k0(((Intent) parcelableArrayList.get(i9)).getIntExtra(str, -1));
                c0601d4.r0(intArray2[i9]);
                c0601d = c0601d4;
                final int i10 = i9;
                c0601d2 = c0601d3;
                list = o02;
                str2 = str;
                C0305a.a().b(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.M
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerActivity.this.h1(c0601d, parcelableArrayList, i10, intArray2);
                    }
                });
                M1(c0601d, booleanArray, i10, parcelableArrayList, intArray2);
                i3 = i10;
            } else {
                c0601d = c0601d4;
                c0601d2 = c0601d3;
                list = o02;
                str2 = str;
                i3 = i9;
            }
            c0601d3 = i3 == i4 ? c0601d : c0601d2;
            i9 = i3 + 1;
            o02 = list;
            str = str2;
        }
        C0601d c0601d5 = c0601d3;
        List list2 = o02;
        this.f10265m.e(list2, f3, i7);
        this.f10265m.I(i7);
        this.f10265m.O(list2.size() == 3);
        Rect bounds = getResources().getConfiguration().windowConfiguration.getBounds();
        int height = bounds.height() - ((C0601d) list2.get(0)).w().height();
        if (B1.s.w(this) && bounds.width() > bounds.height()) {
            height = bounds.width() - ((C0601d) list2.get(0)).w().width();
        }
        this.f10279v.w2(height, false);
        if (c0601d5 != null) {
            this.f10265m.G(c0601d5);
        } else {
            this.f10265m.F(i4);
        }
        B1.h.a(this).i();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W0() {
        this.f10229K = false;
        this.f10230L = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X0() {
        t0 t0Var = this.f10257i;
        if (t0Var != null) {
            t0Var.g();
        }
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.p();
        }
    }

    private boolean X1(C0601d c0601d) {
        if (c0601d != null) {
            return c0601d.f() == null || c0601d.f().getComponent() == null || !getPackageName().equals(c0601d.f().getComponent().getPackageName()) || c0601d.f().getComponent().getClassName() == null || !ContainerActivity.class.getName().equals(c0601d.f().getComponent().getClassName());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y0() {
        if (this.f10275r.M() && this.f10271p.R()) {
            this.f10275r.A(false);
        }
    }

    private void Y1() {
        ContainerView containerView;
        if (getDisplayId() != 0) {
            return;
        }
        for (ContainerActivity containerActivity : OplusPsCanvasApp.f10166e) {
            if (containerActivity != this && (containerView = containerActivity.f10279v) != null) {
                containerView.P2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z0() {
        this.f10279v.f10755S = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a1() {
        this.f10279v.getViewTreeObserver().removeOnPreDrawListener(this.f10266m0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b1() {
        int i3 = this.f10237S;
        if (i3 == 5 || i3 == 6 || isFinishing()) {
            return;
        }
        this.f10241W.o();
    }

    private void b2() {
        int i3;
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation != 3) {
                        i3 = 0;
                        Rect rect = this.f10263l;
                        int i4 = rect.left;
                        int o02 = rect.bottom - o0(i3, getResources());
                        Rect rect2 = this.f10263l;
                        this.f10282y = new Rect(i4, o02, rect2.right, rect2.bottom);
                    }
                }
            }
            i3 = 24;
            Rect rect3 = this.f10263l;
            int i42 = rect3.left;
            int o022 = rect3.bottom - o0(i3, getResources());
            Rect rect22 = this.f10263l;
            this.f10282y = new Rect(i42, o022, rect22.right, rect22.bottom);
        }
        i3 = 22;
        Rect rect32 = this.f10263l;
        int i422 = rect32.left;
        int o0222 = rect32.bottom - o0(i3, getResources());
        Rect rect222 = this.f10263l;
        this.f10282y = new Rect(i422, o0222, rect222.right, rect222.bottom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1() {
        if (D0.k() >= B1.q.d(this).c()) {
            this.f10268n0.postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.N
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.this.b1();
                }
            }, 500L);
        }
    }

    private void c2(int i3) {
        if (i3 == 2) {
            M0();
        } else {
            S1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d1(int i3, Intent intent, Intent intent2) {
        if (isFinishing()) {
            Log.w(f10218r0, "startThreeSplitFromNormalSplit activity is finishing");
            return;
        }
        Log.d(f10218r0, "startThreeSplitFromNormalSplit userId:" + i3 + " intent:" + intent);
        this.f10221C.n();
        L0();
        if (this.f10275r.M()) {
            this.f10275r.A(false);
        }
        h0(intent2, i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e1() {
        this.f10283z = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WindowInsets f1(View view, WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.ime());
        getWindow().getDecorView().onApplyWindowInsets(windowInsets);
        m1(insets.toRect().height());
        Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars());
        if (l1(getResources().getDisplayMetrics().density, insetsIgnoringVisibility.toRect(), this.f10225G)) {
            K1(insetsIgnoringVisibility.toRect(), true);
        }
        return windowInsets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(List list, int i3) {
        z1(list, i3);
        C1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0(Intent intent, int i3, boolean z3) {
        if (intent != null) {
            intent.putExtra("androidx.flexible.userId", i3);
        }
        C0601d n02 = B1.l.n0(this, intent, -2);
        if (!X1(n02)) {
            Log.e(f10218r0, "addFlexibleTask invalid intent:" + intent);
            return;
        }
        for (int i4 = 0; i4 < this.f10279v.getContainerController().k(); i4++) {
            try {
                C0601d l3 = this.f10279v.getContainerController().l(i4);
                Rect rect = this.f10279v.getRectList().get(i4);
                if (l3.p() == 1) {
                    boolean x3 = l3.x();
                    if (!l3.i().isEmpty() && Math.abs(((rect.width() * 1.0f) / l3.i().width()) - ((rect.height() * 1.0f) / l3.i().height())) < 0.01f && x3) {
                        l3.o0(true);
                    }
                }
            } catch (IndexOutOfBoundsException unused) {
                Log.e(f10218r0, "addFlexibleTask: index " + i4 + " is out of range");
                return;
            }
        }
        this.f10229K = true;
        this.f10230L = z3;
        getMainThreadHandler().postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.X
            @Override // java.lang.Runnable
            public final void run() {
                ContainerActivity.this.W0();
            }
        }, 500L);
        if (n02 != null && this.f10265m != null) {
            n02.r0(i3);
            n02.k0(intent.getIntExtra("androidx.activity.LaunchEmbeddedTaskId", -1));
            n02.M(B1.l.X(this, intent, i3));
            n02.o0(n02.x());
            this.f10265m.d(n02);
            B1();
            this.f10265m.G(n02);
            C0622f.k(this).C(u0(), this.f10265m, this.f10275r.M());
        }
        B1.l.w1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(C0601d c0601d, List list, int i3, int[] iArr) {
        c0601d.M(B1.l.X(this, (Intent) list.get(i3), iArr[i3]));
    }

    private ViewTreeObserver.OnPreDrawListener i0(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int i3 = bundle.getInt("startCanvasFrom", 0);
        if (i3 != 1 && i3 != 3) {
            return null;
        }
        e eVar = new e();
        this.f10279v.getViewTreeObserver().addOnPreDrawListener(eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(Bitmap bitmap) {
        if (bitmap == null) {
            bitmap = (Bitmap) B1.l.f207g.get();
        }
        if (bitmap == null || bitmap.isRecycled()) {
            Log.w(f10218r0, "Bitmap invalid, using previous operation");
            k0();
            return;
        }
        try {
            getWindow().setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
            j0();
        } catch (Exception e3) {
            Log.e(f10218r0, "Bitmap background failed, fallback to previous operation", e3);
            k0();
        }
    }

    private void j0() {
        boolean z02 = B1.l.z0(getApplicationContext());
        if (B1.s.w(getApplicationContext())) {
            if (z02) {
                getWindow().setNavigationBarColor(0);
                return;
            }
            Rect rect = this.f10225G;
            if (rect.bottom > 0 || rect.right > 0 || rect.left > 0) {
                getWindow().setNavigationBarColor(this.f10248d0);
                return;
            }
            return;
        }
        if (B1.s.H()) {
            if (z02) {
                getWindow().setNavigationBarColor(0);
                return;
            } else {
                getWindow().setNavigationBarColor(this.f10248d0);
                return;
            }
        }
        if (this.f10224F < o0(20.0f, getResources())) {
            getWindow().setNavigationBarColor(0);
        } else {
            getWindow().setNavigationBarColor(this.f10248d0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1() {
        try {
            new EmbeddedViewDecor(this);
            new C0629c(this);
        } catch (Exception e3) {
            Log.w(f10218r0, "loadView error " + e3);
        }
    }

    private void k0() {
        getWindow().setBackgroundDrawableResource(AbstractC0589c.f13364c);
        j0();
    }

    private void k1() {
        List m02 = m0();
        if (!m02.isEmpty()) {
            this.f10268n0.postDelayed(new g(m02), 500L);
            return;
        }
        if (this.f10240V >= 0) {
            this.f10279v.getAdapter().H(this.f10240V);
            Log.d(f10218r0, "manuallySetFocusIfNeed setFocusIndex : " + this.f10240V);
            this.f10240V = -1;
        }
    }

    private boolean l1(float f3, Rect rect, Rect rect2) {
        boolean A02 = B1.l.A0(f3, rect);
        boolean z3 = rect2 != null && B1.l.A0(f3, rect2);
        if (A02 && z3) {
            return false;
        }
        if (A02 != z3) {
            return true;
        }
        return rect2 == null || !rect2.equals(rect);
    }

    private List m0() {
        ArrayList arrayList = new ArrayList();
        int k3 = this.f10265m.k();
        for (int i3 = 0; i3 < k3; i3++) {
            C0601d l3 = this.f10265m.l(i3);
            String k4 = l3.k();
            if (k4 != null && B1.l.f212l.contains(k4)) {
                int s3 = l3.s();
                if (s3 > 0) {
                    arrayList.add(Integer.valueOf(s3));
                }
                this.f10240V = i3;
            }
        }
        return arrayList;
    }

    private void m1(int i3) {
        if (i3 > 0) {
            if (!this.f10242X) {
                this.f10242X = true;
                this.f10279v.J1(true);
            }
        } else if (this.f10242X) {
            this.f10242X = false;
            this.f10279v.J1(false);
            this.f10243Y = 0;
        }
        boolean z3 = this.f10244Z;
        boolean z4 = this.f10242X;
        if (z3 != z4) {
            this.f10244Z = z4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n0(int i3) {
        if (i3 == 0) {
            return "DEVICE_STATE_CLOSE";
        }
        if (i3 == 1) {
            return "DEVICE_STATE_TENT";
        }
        if (i3 == 2) {
            return "DEVICE_STATE_HALF_OPENED";
        }
        if (i3 == 3) {
            return "DEVICE_STATE_OPEN";
        }
        switch (i3) {
            case 99:
                return "DEVICE_STATE_OPEN_ALL";
            case 100:
                return "DEVICE_STATE_CLOSE_ALL";
            case 101:
                return "DEVICE_STATE_SUB_SCREEN_OPEN_ONLY";
            default:
                return Integer.toString(i3);
        }
    }

    private void n1(boolean z3) {
        this.f10279v.w2(this.f10224F, z3);
        this.f10281x.setNavigationBarHeight(this.f10224F);
    }

    private int o0(float f3, Resources resources) {
        return (int) TypedValue.applyDimension(1, f3, resources.getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0601d q0(int i3) {
        if (this.f10265m == null) {
            return null;
        }
        for (int i4 = 0; i4 < this.f10265m.k(); i4++) {
            if (this.f10265m.l(i4).s() == i3) {
                return this.f10265m.l(i4);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0601d r0(ActivityManager.RunningTaskInfo runningTaskInfo, boolean z3) {
        Bundle c02;
        int i3;
        if (runningTaskInfo == null || this.f10265m == null) {
            return null;
        }
        for (int i4 = 0; i4 < this.f10265m.k(); i4++) {
            C0601d l3 = this.f10265m.l(i4);
            if (B1.l.f201a.booleanValue()) {
                Log.d(f10218r0, "findTargetTaskData by id TaskData: " + l3);
            }
            if (l3 == null) {
                return null;
            }
            if (l3.s() == runningTaskInfo.taskId) {
                return l3;
            }
        }
        for (int i5 = 0; i5 < this.f10265m.k(); i5++) {
            C0601d l4 = this.f10265m.l(i5);
            if (B1.l.f201a.booleanValue()) {
                Log.d(f10218r0, "findTargetTaskData by component TaskData: " + l4);
            }
            if (l4 == null) {
                return null;
            }
            Intent f3 = l4.f();
            if ((f3.filterEquals(runningTaskInfo.baseIntent) || !(f3.getComponent() == null || runningTaskInfo.baseIntent == null || !f3.getComponent().equals(runningTaskInfo.baseIntent.getComponent()))) && l4.v() == runningTaskInfo.userId) {
                Log.d(f10218r0, "findTargetTaskData by component");
                return l4;
            }
            if (z3 && (c02 = B1.l.c0(runningTaskInfo)) != null && (i3 = c02.getInt("androidx.activity.PrevTaskId", -1)) != -1 && l4.s() == i3) {
                Log.d(f10218r0, "findTargetTaskData by prevTaskId taskId: " + runningTaskInfo.taskId + " prevTaskId: " + i3);
                return l4;
            }
        }
        Log.d(f10218r0, "findTargetTaskData by component INVALID_TASK_ID");
        return q0(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1() {
        Log.d(f10218r0, "onHomeKeyLongPressed");
        this.f10279v.f10732G.P();
        this.f10279v.f10732G.Q();
        this.f10279v.J0();
        L0();
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.n();
        }
        if (this.f10275r.J()) {
            this.f10275r.V();
        }
        E e3 = this.f10279v.f10732G;
        if (e3 != null) {
            e3.z(true);
        }
        B1.h.a(this).e("nav_home");
    }

    private void s0() {
        Log.e(f10218r0, "can't enter split because of count is less 2");
        finish();
        if (this.f10265m != null) {
            ArrayList arrayList = new ArrayList();
            int k3 = this.f10265m.k();
            for (int i3 = 0; i3 < k3; i3++) {
                arrayList.add(this.f10265m.l(i3));
            }
            A1(arrayList, u0());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1() {
        Log.d(f10218r0, "onHomeKeyPressed");
        this.f10279v.f10732G.P();
        this.f10279v.J0();
        this.f10279v.f10732G.Q();
        L0();
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.n();
        }
        if (this.f10275r.J()) {
            this.f10275r.V();
        }
        E e3 = this.f10279v.f10732G;
        if (e3 != null) {
            e3.z(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(Context context) {
        this.f10236R.set(B1.l.j1(Settings.Secure.getString(context.getContentResolver(), "sidebar_scene_region")));
        Log.d(f10218r0, "sidebar region Change: " + this.f10236R);
    }

    private void z1(List list, int i3) {
        if (list == null) {
            return;
        }
        Log.d(f10218r0, "releaseTaskData removeEmbeddedContainerTask:" + list);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FlexibleWindowManager.getInstance().removeEmbeddedContainerTask(((C0601d) it.next()).s(), i3);
        }
    }

    public boolean A0() {
        return this.f10244Z;
    }

    public void A1(final List list, final int i3) {
        C0305a.a().b(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.L
            @Override // java.lang.Runnable
            public final void run() {
                ContainerActivity.this.g1(list, i3);
            }
        });
    }

    public int B0() {
        return this.f10243Y;
    }

    public void B1() {
        if (this.f10268n0.hasCallbacks(this.f10228J)) {
            Log.d(f10218r0, "removeAutoScaleCallback");
            this.f10268n0.removeCallbacks(this.f10228J);
        }
    }

    public int C0() {
        r0 r0Var = this.f10265m;
        if (r0Var == null) {
            return 0;
        }
        return r0Var.q();
    }

    public void C1() {
        try {
            ActivityTaskManager.getService().removeTask(u0());
        } catch (RemoteException unused) {
            Log.e(f10218r0, "remove canvas task failed");
        }
    }

    public Rect D0() {
        return this.f10225G;
    }

    public void D1() {
        if (this.f10265m == null) {
            return;
        }
        C0622f.k(this).D(u0(), this.f10265m, this.f10275r.M(), true);
    }

    public A0 E0() {
        return this.f10275r;
    }

    public void E1(boolean z3, int i3) {
        if (this.f10268n0.hasMessages(1)) {
            return;
        }
        this.f10268n0.obtainMessage(1, new j(z3, i3)).sendToTarget();
    }

    public DraggableCanvasViewGroup F0() {
        return this.f10255h;
    }

    public int G0() {
        return this.f10254g0;
    }

    public void G1(boolean z3) {
        this.f10262k0 = z3;
    }

    public void H1(boolean z3) {
        this.f10246b0 = z3;
    }

    public int I0() {
        return this.f10238T;
    }

    public void I1(boolean z3) {
        this.f10245a0 = z3;
    }

    public int J0() {
        if ((!B1.s.H() || B1.l.u0()) && !B1.s.r(this.f10279v.getContext())) {
            return this.f10254g0;
        }
        return 0;
    }

    public void J1(int i3) {
        this.f10248d0 = i3;
    }

    public Rect K0() {
        return this.f10263l;
    }

    public void L0() {
        EmbeddedViewDecor q02;
        r0 r0Var = this.f10265m;
        if (r0Var == null || (q02 = this.f10279v.q0(r0Var.n())) == null) {
            return;
        }
        q02.f10862h.I0();
    }

    public void L1(boolean z3) {
        this.f10247c0 = z3;
    }

    public boolean N0() {
        C0332y c0332y = this.f10271p;
        if (c0332y == null || c0332y.L() == null) {
            return false;
        }
        return this.f10271p.L().P();
    }

    public void N1(int i3) {
        this.f10238T = i3;
    }

    public void O1(boolean z3) {
        this.f10264l0 = z3;
    }

    public boolean P0() {
        return this.f10262k0;
    }

    public boolean Q0() {
        return this.f10219A;
    }

    public void Q1() {
        this.f10233O = true;
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setNavigationBarColor(0);
        if (B1.l.v0(this)) {
            return;
        }
        getWindow().getInsetsController().setSystemBarsAppearance(16, 16);
    }

    public boolean S0() {
        return this.f10242X;
    }

    public boolean T0() {
        return this.f10253g;
    }

    public boolean U0() {
        return this.f10230L;
    }

    public void U1(int i3, boolean z3) {
        if (isFinishing()) {
            return;
        }
        this.f10279v.f10746N = true;
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.W();
        }
        C0601d l3 = this.f10265m.l(i3);
        if (l3 != null) {
            int k3 = this.f10265m.k();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < k3; i4++) {
                arrayList.add(this.f10265m.l(i4));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                this.f10279v.Q1(i5);
            }
            z1(arrayList, u0());
            this.f10279v.getAdapter().setNotifyOnChange(false);
            this.f10279v.getAdapter().clear();
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("androidx.flexible.activityNoAnimation", true);
                bundle.putBoolean("androidx.launch.fullscreen.zoom", true);
                bundle.putBoolean("androidx.task.TranslucentSplitTask", true);
                bundle.putBoolean("android.activity.avoidMoveToFront", true);
                ActivityOptions makeCustomAnimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), 0, 0);
                if (z3) {
                    bundle.putBoolean("androidx.flexible.launchTaskToFullFloat", true);
                    bundle.putInt("androidx.flexible.canvasToZoomTaskId", getTaskId());
                } else {
                    bundle.putBoolean("androidx.flexible.launchTaskToFullDrag", true);
                }
                bundle.putInt("androidx.activity.LaunchScenario", 0);
                ActivityTaskManager.getService().startActivityFromRecents(l3.s(), FlexibleWindowManager.getInstance().setExtraBundle(makeCustomAnimation, bundle));
            } catch (Exception unused) {
                Log.e(f10218r0, "make the focus flexible app to full screen error, taskId: " + l3.s());
            }
        }
    }

    public boolean V0() {
        return this.f10264l0;
    }

    public void V1(int i3) {
        W1(i3, false);
    }

    public void W1(int i3, boolean z3) {
        C0601d l3;
        if (isFinishing()) {
            return;
        }
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.W();
        }
        r0 r0Var = this.f10265m;
        if (r0Var == null || (l3 = r0Var.l(i3)) == null) {
            return;
        }
        int k3 = this.f10265m.k();
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < k3; i4++) {
            C0601d l4 = this.f10265m.l(i4);
            if (!z3 || i4 == i3) {
                arrayList.add(l4);
            }
        }
        z1(arrayList, u0());
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            int u3 = this.f10265m.u((C0601d) arrayList.get(i5));
            this.f10279v.Q1(u3);
            this.f10279v.x2(u3, 4);
        }
        if (z3) {
            this.f10265m.B(l3);
            this.f10279v.U2(false);
        } else {
            this.f10279v.K0(1 - i3);
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("androidx.activity.LaunchScenario", 0);
            bundle.putBoolean("androidx.flexible.activityNoAnimation", true);
            bundle.putBoolean("androidx.task.TranslucentSplitTask", true);
            bundle.putString("androidx.activity.startReason", "startTargetActivityAsFullScreen");
            ActivityTaskManager.getService().startActivityFromRecents(l3.s(), FlexibleWindowManager.getInstance().setExtraBundle(ActivityOptions.makeCustomAnimation(getApplicationContext(), 0, 0), bundle));
        } catch (Exception unused) {
            Log.e(f10218r0, "make the focus flexible app to full screen error, taskId: " + l3.s());
        }
    }

    public void Z1(int i3, Intent intent, int i4, int i5) {
        a2(i3, intent, i4, i5, false);
    }

    public void a2(int i3, Intent intent, int i4, int i5, boolean z3) {
        C0601d c0601d = new C0601d();
        c0601d.O(intent);
        int i6 = (this.f10279v.k1() && this.f10265m.q() == 1 && B1.s.r(this) && E.d0(c0601d) && OplusSplitScreenManager.getInstance().getSplitScreenState(intent) == 1001) ? 0 : -2;
        if (intent != null) {
            intent.putExtra("androidx.flexible.userId", i4);
        }
        C0601d n02 = B1.l.n0(this, intent, i6);
        if (!X1(n02)) {
            Log.e(f10218r0, "updateFlexibleTask invalid intent:" + intent);
            return;
        }
        if (n02 != null && this.f10265m != null) {
            n02.r0(i4);
            n02.k0(i3);
            n02.M(B1.l.X(this, intent, i4));
            n02.o0(z3 ? this.f10265m.l(i5).u() : n02.x());
            if (this.f10265m.l(i5) != null) {
                String k3 = this.f10265m.l(i5).k();
                if (k3 != null && k3.equals(n02.k()) && this.f10265m.l(i5).v() == i4) {
                    n02.o0(this.f10265m.l(i5).u());
                }
                r0 r0Var = this.f10265m;
                if (r0Var != null) {
                    if (!z3) {
                        r0Var.g();
                    } else if (r0Var.l(i5).H()) {
                        n02.q0(true);
                        n02.j0(this.f10265m.l(i5).r());
                    }
                }
            }
            this.f10265m.P(n02, i5, true);
            this.f10265m.G(n02);
        }
        this.f10279v.setNeedUpdateFlexibleTaskViewFrameFlag(true);
        C0622f.k(this).C(u0(), this.f10265m, this.f10275r.M());
        B1.l.w1(this);
    }

    public void l0(String str) {
        EmbeddedViewDecor childEmbeddedViewDecorToZoom = this.f10279v.getChildEmbeddedViewDecorToZoom();
        if (childEmbeddedViewDecorToZoom != null) {
            childEmbeddedViewDecorToZoom.f10862h.k0(str);
        }
    }

    public void o1(boolean z3) {
        this.f10281x.setIsPanoramaMode(z3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10268n0.post(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.O
            @Override // java.lang.Runnable
            public final void run() {
                ContainerActivity.this.X0();
            }
        });
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        r0 r0Var;
        super.onConfigurationChanged(configuration);
        if (B1.l.f201a.booleanValue()) {
            Log.d(f10218r0, "onConfigurationChanged " + configuration);
        }
        if (B1.s.i(configuration) != this.f10265m.w()) {
            this.f10252f0 = true;
        }
        if (this.f10252f0) {
            this.f10281x.r(0L, false);
        }
        if (!(B1.s.i(configuration) == this.f10265m.w() && this.f10231M == configuration.densityDpi) && R1(this)) {
            c2(B1.s.i(configuration));
        } else if (B1.s.r(this)) {
            M0();
        }
        if (this.f10265m.w() == 2) {
            this.f10265m.C();
        } else {
            this.f10265m.D();
        }
        this.f10265m.L(B1.s.i(configuration));
        E e3 = this.f10279v.f10732G;
        if (e3 != null) {
            e3.w0();
        }
        if (this.f10219A) {
            Log.d(f10218r0, "onConfigurationChanged return when fold change to close");
            return;
        }
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.p();
        }
        ContainerView containerView = this.f10279v;
        if (containerView == null) {
            return;
        }
        E e4 = containerView.f10732G;
        if (e4 != null) {
            e4.P();
        }
        L0();
        this.f10279v.J0();
        this.f10279v.f10732G.Q();
        boolean z3 = this.f10231M != configuration.densityDpi;
        if (configuration.windowConfiguration.getBounds().height() != this.f10263l.height() || configuration.windowConfiguration.getBounds().width() != this.f10263l.width() || z3) {
            if (z3) {
                ContainerView containerView2 = this.f10279v;
                containerView2.O1(containerView2.getContext());
            }
            if (this.f10243Y >= 0 || !this.f10279v.f10750P) {
                Log.d(f10218r0, "onConfigurationChanged hideCurrentInputMethod !");
                OplusInputMethodManager.getInstance().hideCurrentInputMethod();
            }
            A1.b bVar2 = this.f10221C;
            if (bVar2 != null) {
                bVar2.n();
            }
            if (getWindow().getDecorView().getRootWindowInsets() != null) {
                Rect rect = getWindow().getDecorView().getRootWindowInsets().getInsets(WindowInsets.Type.navigationBars()).toRect();
                if (B1.l.A0(getResources().getDisplayMetrics().density, rect)) {
                    rect.set(0, 0, 0, 0);
                }
                K1(rect, false);
            }
            if (this.f10220B && B1.s.r(this) && this.f10279v.k1() && (!configuration.windowConfiguration.getBounds().equals(this.f10263l) || this.f10252f0)) {
                this.f10265m.I(this.f10234P);
                this.f10220B = false;
                Log.d(f10218r0, "onConfigurationChanged set mResetLayoutOrientation to false");
            }
            C0601d o3 = this.f10279v.getContainerController().o();
            this.f10279v.c3(this.f10252f0, -1);
            this.f10279v.N1(false);
            if (this.f10252f0 && (r0Var = this.f10265m) != null) {
                r0Var.G(o3);
                this.f10279v.f10755S = true;
                getMainThreadHandler().postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.Q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerActivity.this.Z0();
                    }
                }, 800L);
                getMainThreadHandler().postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.S
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerActivity.this.Y0();
                    }
                }, 200L);
            }
            b2();
        }
        if (B1.l.f201a.booleanValue()) {
            Log.d(f10218r0, "onConfigChange " + configuration.windowConfiguration.getBounds() + " windowBound:" + this.f10263l + " density:" + this.f10231M + " " + configuration.densityDpi);
        }
        this.f10263l.set(configuration.windowConfiguration.getBounds());
        if (this.f10263l.width() > this.f10263l.height()) {
            B1.h.a(this).g(true);
        } else {
            B1.h.a(this).g(false);
        }
        this.f10231M = configuration.densityDpi;
        if (this.f10252f0 && this.f10275r.M() && B1.s.H()) {
            this.f10256h0 = true;
        } else {
            this.f10256h0 = false;
            this.f10275r.S(configuration);
        }
        this.f10252f0 = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = f10218r0;
        Log.d(str, "onCreate: isLightOS=" + B1.d.f168d);
        com.coui.appcompat.theme.a.h().a(this);
        this.f10237S = 1;
        Object[] objArr = 0;
        if (this.f10219A) {
            if (C0622f.k(this).n(u0())) {
                finish();
            } else {
                Log.d(str, "fold close remove canvas");
                A1(null, u0());
            }
        }
        if (R1(this)) {
            c2(B1.s.i(getResources().getConfiguration()));
        } else {
            getWindow().setFlags(1024, 1024);
            getWindow().getDecorView().setSystemUiVisibility(!B1.s.v(getResources().getConfiguration()) ? 14084 : 5892);
        }
        requestWindowFeature(1);
        getWindow().addFlags(32);
        getWindow().getAttributes().layoutInDisplayCutoutMode = 3;
        C0305a.a().b(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.T
            @Override // java.lang.Runnable
            public final void run() {
                ContainerActivity.this.j1();
            }
        });
        O0();
        this.f10249e = new l(this, new Handler());
        this.f10251f = new k(this, new Handler());
        this.f10271p = new C0332y(this);
        this.f10275r = new A0(this.f10255h, this.f10279v, this, this.f10268n0);
        this.f10221C = new A1.b(this);
        this.f10271p.O(this.f10255h, this.f10279v, this.f10275r);
        this.f10279v.setPanoramaModeController(this.f10275r);
        if (C0622f.k(this).B(u0(), this.f10265m, this.f10279v, bundle, this)) {
            Object[] objArr2 = bundle == null || B1.s.e(this) > bundle.getInt("SMALLEST_SW_DP", Preference.DEFAULT_ORDER);
            int i3 = Settings.Global.getInt(getContentResolver(), "oplus_system_folding_mode", 1);
            if (objArr2 != false && i3 == 1 && B1.s.r(this) && this.f10279v.k1()) {
                this.f10265m.I(0);
                this.f10265m.i();
            }
            B1.h.a(this).i();
        } else if (T1(getIntent().getExtras())) {
            C0622f.k(this).C(u0(), this.f10265m, this.f10275r.M());
            ViewTreeObserver.OnPreDrawListener i02 = i0(getIntent().getExtras());
            this.f10266m0 = i02;
            if (i02 != null) {
                this.f10268n0.postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.U
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContainerActivity.this.a1();
                    }
                }, 1300L);
            }
        } else {
            Log.e(str, "start canvas activity failed");
            if (!isFinishing()) {
                s0();
            }
        }
        B1.l.w1(this);
        this.f10257i = new t0(this);
        this.f10263l.set(getResources().getConfiguration().windowConfiguration.getBounds());
        this.f10231M = getResources().getConfiguration().densityDpi;
        this.f10267n = FlexibleWindowManager.getInstance();
        this.f10269o = new EmbeddedWindowCallback();
        b2();
        this.f10223E = new i();
        this.f10279v.getAdapter().B(new d());
        P1();
        y1();
        this.f10241W = new D0(this);
        C0305a.a().b(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.V
            @Override // java.lang.Runnable
            public final void run() {
                ContainerActivity.this.c1();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Bitmap bitmap;
        this.f10232N = false;
        this.f10237S = 6;
        OplusPsCanvasApp.f10166e.remove(this);
        super.onDestroy();
        for (C0601d c0601d : this.f10279v.getAdapter().l()) {
            if ((c0601d.e() instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) c0601d.e()).getBitmap()) != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                c0601d.M(null);
            }
        }
        B1.l.q1();
        this.f10259j.clear();
        this.f10261k.clear();
        this.f10279v.getAdapter().W();
        this.f10265m = null;
        this.f10279v.I0();
        C0622f.k(getApplicationContext()).e();
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.G();
            this.f10221C = null;
        }
        DeviceStateManager deviceStateManager = this.f10258i0;
        if (deviceStateManager != null) {
            deviceStateManager.unregisterCallback(this.f10270o0);
            this.f10258i0 = null;
        }
        this.f10241W = null;
        if (this.f10247c0) {
            this.f10247c0 = false;
        }
        this.f10238T = -1;
        Log.d(f10218r0, "onDestroy");
    }

    @Override // android.app.Activity
    protected void onNewIntent(final Intent intent) {
        r0 r0Var;
        if (intent.getExtras() == null) {
            return;
        }
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("androidx.activity.AddIntentToSplit", false)) {
            final Intent intent2 = (Intent) intent.getExtras().getParcelable("androidx.activity.NewReplacingIntent", Intent.class);
            final int i3 = intent.getExtras().getInt("androidx.activity.NewReplacingUserId", -1);
            F1();
            runOnUiThread(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.K
                @Override // java.lang.Runnable
                public final void run() {
                    ContainerActivity.this.d1(i3, intent, intent2);
                }
            });
        } else if (intent.getBooleanExtra("androidx.activity.NewCanvasIntentFlag", false)) {
            int i4 = intent.getExtras().getInt("androidx.activity.ReplacedTaskId", -1);
            Intent intent3 = (Intent) intent.getExtras().getParcelable("androidx.activity.NewReplacingIntent", Intent.class);
            int i5 = intent.getExtras().getInt("androidx.activity.NewReplacingUserId", -1);
            if (i4 != -1 && intent3 != null && i5 != -1 && (r0Var = this.f10265m) != null) {
                int v3 = r0Var.v(i4);
                if (v3 == -1) {
                    v3 = this.f10265m.n();
                }
                a2(-1, intent3, i5, v3, true);
            }
        }
        Log.d(f10218r0, "onNewIntent");
    }

    @Override // android.app.Activity
    protected void onPause() {
        this.f10232N = false;
        this.f10237S = 4;
        super.onPause();
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.W();
            this.f10221C.n();
        }
        this.f10279v.f10732G.Q();
        unregisterReceiver(this.f10223E);
        C0622f.k(this).D(u0(), this.f10265m, this.f10275r.M(), true);
        this.f10268n0.removeCallbacks(this.f10227I);
        H1(false);
        B1();
        this.f10283z = false;
        this.f10279v.I0();
        this.f10279v.f10732G.P();
        L0();
        this.f10279v.J0();
        if (this.f10275r.J()) {
            this.f10275r.V();
        }
        this.f10279v.f10732G.B();
        if (this.f10271p.L() != null) {
            this.f10271p.L().t0();
        }
        Log.d(f10218r0, "onPause");
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Log.d(f10218r0, "onRestart");
        A1.b bVar = this.f10221C;
        if (bVar != null) {
            bVar.p();
        }
        B1.h.a(this).i();
        P1();
        if (getWindowManager().getMaximumWindowMetrics().getBounds().equals(this.f10263l)) {
            return;
        }
        List<C0601d> l3 = this.f10279v.getAdapter().l();
        ArrayList arrayList = new ArrayList();
        for (C0601d c0601d : l3) {
            Intent f3 = c0601d.f();
            f3.putExtra("androidx.activity.LaunchEmbeddedTaskId", c0601d.s());
            f3.putExtra("androidx.flexible.userId", c0601d.v());
            arrayList.add(f3);
        }
        List o02 = B1.l.o0(this, arrayList, this.f10265m.q());
        if (o02 == null) {
            return;
        }
        for (int i3 = 0; i3 < o02.size(); i3++) {
            ((C0601d) l3.get(i3)).f0(((C0601d) o02.get(i3)).f13810a);
            ((C0601d) l3.get(i3)).W(((C0601d) o02.get(i3)).i());
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.f10232N = true;
        this.f10237S = 3;
        this.f10221C.P();
        Y1();
        OplusPsCanvasApp.f10166e.add(this);
        super.onResume();
        if (this.f10275r.M()) {
            this.f10275r.c0(this);
        }
        k1();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
        registerReceiver(this.f10223E, intentFilter, 4);
        Runnable runnable = new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.P
            @Override // java.lang.Runnable
            public final void run() {
                ContainerActivity.this.e1();
            }
        };
        this.f10227I = runnable;
        this.f10268n0.postDelayed(runnable, 1000L);
        r0 r0Var = this.f10265m;
        r0Var.A(r0Var.k());
        this.f10257i.l(false);
        Log.d(f10218r0, "onResume");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f10279v.getAdapter().z()) {
            bundle.putFloat("SPLIT_RATIO", this.f10279v.getSplitRatio());
        }
        bundle.putInt("SMALLEST_SW_DP", B1.s.e(this));
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f10237S = 2;
        B1.b bVar = this.f10235Q;
        if (bVar == null) {
            this.f10235Q = new B1.b(this);
        } else {
            bVar.n();
        }
        this.f10235Q.m();
        if (B1.s.q()) {
            if (B1.s.t(this)) {
                B1.h.a(this).f(0);
            } else {
                B1.h.a(this).f(1);
            }
        }
        if (this.f10263l.width() > this.f10263l.height()) {
            B1.h.a(this).g(true);
        } else {
            B1.h.a(this).g(false);
        }
        this.f10257i.f();
        this.f10257i.m(this.f10274q0);
        this.f10257i.k();
        int i3 = Settings.Secure.getInt(getContentResolver(), "hide_navigationbar_enable", 0);
        boolean z3 = i3 == 2 || i3 == 3;
        this.f10273q = z3;
        this.f10279v.setIsGestureNavMode(z3);
        this.f10281x.setIsGestureNavMode(this.f10273q);
        this.f10281x.r(0L, false);
        OplusAppSwitchManager.getInstance().registerAppSwitchObserver(this, this.f10272p0, (OplusAppSwitchConfig) null);
        getContentResolver().registerContentObserver(Settings.Secure.getUriFor("sidebar_scene_region"), true, this.f10249e);
        getContentResolver().registerContentObserver(Settings.Secure.getUriFor("one_handed_mode_activated"), true, this.f10251f, getUserId());
        u1(this);
        this.f10241W.n();
        getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.oplus.pscanvas.canvasmode.canvas.W
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets f12;
                f12 = ContainerActivity.this.f1(view, windowInsets);
                return f12;
            }
        });
        this.f10267n.registerEmbeddedWindowContainerCallback(this.f10269o, u0());
        Log.d(f10218r0, "onStart ");
    }

    @Override // android.app.Activity
    protected void onStop() {
        this.f10232N = false;
        this.f10237S = 5;
        Iterator<EmbeddedViewDecor> it = this.f10279v.getChildEmbeddedViewList().iterator();
        while (it.hasNext()) {
            it.next().setTaskReparentToFlexibleTaskView(false);
        }
        Set set = OplusPsCanvasApp.f10166e;
        set.remove(this);
        if (set.size() == 0) {
            this.f10265m.A(-1);
        }
        super.onStop();
        this.f10235Q.o();
        this.f10267n.unregisterEmbeddedWindowContainerCallback(this.f10269o, u0());
        if (this.f10275r.L()) {
            this.f10275r.w();
        }
        this.f10275r.x();
        A1.b.H(0);
        this.f10257i.i();
        this.f10257i.e();
        this.f10279v.I0();
        OplusAppSwitchManager.getInstance().unregisterAppSwitchObserver(this, this.f10272p0);
        getContentResolver().unregisterContentObserver(this.f10249e);
        getContentResolver().unregisterContentObserver(this.f10251f);
        this.f10241W.j();
        E e3 = this.f10279v.f10732G;
        if (e3 != null) {
            e3.z(false);
        }
        this.f10241W.p();
        if (this.f10247c0) {
            this.f10247c0 = false;
            C1();
        }
        this.f10279v.t2();
        Log.d(f10218r0, "onStop");
        getWindow().getDecorView().setOnApplyWindowInsetsListener(null);
        this.f10262k0 = false;
        this.f10264l0 = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        ContainerView containerView;
        int h3;
        super.onWindowFocusChanged(z3);
        if (!z3 || (containerView = this.f10279v) == null || containerView.getAdapter() == null || (h3 = this.f10279v.getAdapter().h()) < 0 || h3 >= this.f10279v.getAdapter().getCount()) {
            return;
        }
        Log.d(f10218r0, "onWindowFocusChanged: set focus to inner on container gain focus.");
        this.f10279v.getAdapter().H(h3);
    }

    public void p0() {
        this.f10233O = false;
    }

    public void p1(float f3) {
        this.f10281x.setPanoramaScaleRatio(f3);
    }

    public ArrayMap q1() {
        return this.f10235Q.l();
    }

    public int t0() {
        return this.f10237S;
    }

    public void t1(com.coui.appcompat.poplist.f fVar, h hVar) {
        for (h hVar2 : this.f10260j0) {
            if (hVar2 != hVar) {
                hVar2.a(fVar);
            }
        }
    }

    public int u0() {
        if (this.f10222D <= 0) {
            this.f10222D = getTaskId();
        }
        return this.f10222D;
    }

    public ContainerView v0() {
        return this.f10279v;
    }

    public void v1(ActivityManager.RunningTaskInfo runningTaskInfo, Rect rect) {
        ContainerView containerView;
        EmbeddedViewDecor embeddedViewDecor;
        if (isFinishing() || this.f10265m == null || (containerView = this.f10279v) == null) {
            Log.w(f10218r0, "onTaskRectOrientationChanged return mContainerController " + this.f10265m + ",mContainerView" + this.f10279v);
            return;
        }
        if (containerView.f10756T) {
            Log.w(f10218r0, "onTaskRectOrientationChanged return on changingTwoTaskOrientation.");
            return;
        }
        x1.r L3 = this.f10271p.L();
        if (L3 != null && L3.O()) {
            Log.w(f10218r0, "onTaskRectOrientationChanged return on splitScreenToFlexibleTask ani.");
            return;
        }
        C0601d r02 = r0(runningTaskInfo, false);
        if (r02 == null) {
            Log.w(f10218r0, "onTaskRectOrientationChanged can't find task");
            return;
        }
        List<EmbeddedViewDecor> childEmbeddedViewList = this.f10279v.getChildEmbeddedViewList();
        Log.d(f10218r0, "onTaskRectOrientationChanged taskId:" + runningTaskInfo.taskId + " intent:" + runningTaskInfo.baseIntent + " rect:" + rect + " embeddedViewDecorList:" + childEmbeddedViewList);
        Iterator<EmbeddedViewDecor> it = childEmbeddedViewList.iterator();
        while (true) {
            if (!it.hasNext()) {
                embeddedViewDecor = null;
                break;
            } else {
                embeddedViewDecor = it.next();
                if (embeddedViewDecor.getTaskData() == r02) {
                    break;
                }
            }
        }
        if (embeddedViewDecor == null) {
            Log.w(f10218r0, "onTaskRectOrientationChanged targetEmbeddedViewDecor null");
            return;
        }
        embeddedViewDecor.m0(runningTaskInfo.topActivity);
        Bundle c02 = B1.l.c0(runningTaskInfo);
        embeddedViewDecor.E(rect, c02 != null ? c02.getBoolean("key_skip_task_rect_orientation") : false);
    }

    public RelativeLayout w0() {
        return this.f10280w;
    }

    public void w1() {
        this.f10257i.j();
    }

    public C0601d x0(int i3) {
        r0 r0Var = this.f10265m;
        if (r0Var == null) {
            return null;
        }
        return r0Var.l(i3);
    }

    public void x1(h hVar) {
        if (this.f10260j0.contains(hVar)) {
            return;
        }
        this.f10260j0.add(hVar);
    }

    public A1.b y0() {
        return this.f10221C;
    }

    public void y1() {
        this.f10258i0 = (DeviceStateManager) getSystemService("device_state");
        boolean hasFeature = OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.fold");
        if (this.f10258i0 == null || !hasFeature || B1.s.p()) {
            return;
        }
        this.f10258i0.registerCallback(ConcurrentUtils.DIRECT_EXECUTOR, this.f10270o0);
    }

    public ArrayList z0() {
        return this.f10235Q.i();
    }
}
