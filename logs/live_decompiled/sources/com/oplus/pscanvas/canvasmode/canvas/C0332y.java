package com.oplus.pscanvas.canvasmode.canvas;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemProperties;
import android.util.Log;
import android.util.Slog;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.DraggableCanvasViewGroup;
import com.oplus.view.inputmethod.OplusInputMethodManager;
import java.util.List;

/* renamed from: com.oplus.pscanvas.canvasmode.canvas.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0332y {

    /* renamed from: L, reason: collision with root package name */
    public static boolean f10934L;

    /* renamed from: A, reason: collision with root package name */
    private int f10935A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f10936B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f10937C;

    /* renamed from: D, reason: collision with root package name */
    private float f10938D;

    /* renamed from: E, reason: collision with root package name */
    private float f10939E;

    /* renamed from: F, reason: collision with root package name */
    private float f10940F;

    /* renamed from: G, reason: collision with root package name */
    private float f10941G;

    /* renamed from: H, reason: collision with root package name */
    private float f10942H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f10943I;

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f10946a;

    /* renamed from: b, reason: collision with root package name */
    private final ContainerActivity f10947b;

    /* renamed from: c, reason: collision with root package name */
    private x1.r f10948c;

    /* renamed from: e, reason: collision with root package name */
    private Context f10950e;

    /* renamed from: f, reason: collision with root package name */
    private DraggableCanvasViewGroup f10951f;

    /* renamed from: g, reason: collision with root package name */
    private ContainerView f10952g;

    /* renamed from: o, reason: collision with root package name */
    private boolean f10960o;

    /* renamed from: p, reason: collision with root package name */
    private int f10961p;

    /* renamed from: q, reason: collision with root package name */
    private int f10962q;

    /* renamed from: r, reason: collision with root package name */
    private int f10963r;

    /* renamed from: s, reason: collision with root package name */
    private final ScaleGestureDetector f10964s;

    /* renamed from: t, reason: collision with root package name */
    private final e f10965t;

    /* renamed from: u, reason: collision with root package name */
    private A0 f10966u;

    /* renamed from: y, reason: collision with root package name */
    private float f10970y;

    /* renamed from: z, reason: collision with root package name */
    private float f10971z;

    /* renamed from: d, reason: collision with root package name */
    private long f10949d = 0;

    /* renamed from: h, reason: collision with root package name */
    private float f10953h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f10954i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private float[] f10955j = new float[5];

    /* renamed from: k, reason: collision with root package name */
    private float[] f10956k = new float[5];

    /* renamed from: l, reason: collision with root package name */
    private float f10957l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private final int f10958m = 45;

    /* renamed from: n, reason: collision with root package name */
    private int f10959n = -2;

    /* renamed from: v, reason: collision with root package name */
    private final float f10967v = 0.9f;

    /* renamed from: w, reason: collision with root package name */
    private final float f10968w = 1.1f;

    /* renamed from: x, reason: collision with root package name */
    private boolean f10969x = true;

    /* renamed from: J, reason: collision with root package name */
    public boolean f10944J = false;

    /* renamed from: K, reason: collision with root package name */
    public boolean f10945K = false;

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.y$a */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return C0332y.this.M(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return C0332y.this.N(motionEvent);
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.y$b */
    class b implements f {
        b() {
        }

        @Override // com.oplus.pscanvas.canvasmode.canvas.C0332y.f
        public void a(MotionEvent motionEvent, MotionEvent motionEvent2) {
            if (C0332y.this.f10959n != -3) {
                return;
            }
            if (C0332y.this.f10936B) {
                Log.e("CanvasGestureManager", "onScroll end because scaling");
                return;
            }
            Log.d("CanvasGestureManager", "onSplitBarScroll " + motionEvent2);
            E.c W3 = C0332y.this.f10952g.f10732G.W(motionEvent);
            if (W3 == null) {
                Log.d("CanvasGestureManager", "not SplitBar Scroll");
                return;
            }
            if (C0332y.this.f10952g.getAdapter().getCount() != 2) {
                C0332y.this.f10960o = true;
                C0332y.this.f10952g.f10732G.q0(W3, motionEvent, motionEvent2);
                return;
            }
            C0332y.this.f10960o = true;
            if (C0332y.this.f10947b != null && C0332y.this.f10947b.y0() != null) {
                C0332y.this.f10947b.y0().n();
            }
            if (C0332y.this.f10952g.H0()) {
                C0332y.this.f10952g.I0();
            }
            C0332y.this.f10952g.f10732G.Q();
            C0332y.this.f10952g.f10732G.q0(W3, motionEvent, motionEvent2);
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.y$c */
    class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        c() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float f3;
            float f4;
            if (C0332y.this.f10935A < 3) {
                Slog.d("CanvasGestureManager", "onScale return " + C0332y.this.f10935A);
                return false;
            }
            if (C0332y.f10934L && C0332y.this.f10948c != null) {
                C0332y.this.f10948c.f0(scaleGestureDetector, C0332y.this.f10935A);
                return true;
            }
            float[] K3 = C0332y.this.K(scaleGestureDetector.getScaleFactor(), new float[]{C0332y.this.f10951f.getScaleX(), C0332y.this.f10951f.getTranslationX(), C0332y.this.f10951f.getTranslationY()}, new float[]{C0332y.this.f10970y, C0332y.this.f10938D, C0332y.this.f10939E}, new float[]{C0332y.this.f10942H, C0332y.this.f10940F, C0332y.this.f10941G});
            float f5 = K3[0];
            float f6 = K3[1];
            float f7 = K3[2];
            if (C0332y.this.f10966u.M()) {
                if (f5 < C0332y.this.f10970y) {
                    f6 = C0332y.this.f10938D + ((C0332y.this.f10970y - f5) * C0332y.this.f10952g.getRectListUnion().centerX());
                    f7 = C0332y.this.f10939E + ((C0332y.this.f10971z - f5) * C0332y.this.f10952g.getRectListUnion().centerY());
                }
                if (f5 >= C0332y.this.f10970y * 1.1f && !C0332y.this.f10937C) {
                    C0332y.this.c0();
                    C0332y.this.f10937C = true;
                }
            } else {
                if (f5 < C0332y.this.f10942H) {
                    f6 = C0332y.this.f10940F + ((C0332y.this.f10942H - f5) * C0332y.this.f10952g.getRectListUnion().centerX());
                    f7 = C0332y.this.f10941G + ((C0332y.this.f10942H - f5) * C0332y.this.f10952g.getRectListUnion().centerY());
                }
                if (f5 <= C0332y.this.f10970y * 0.9f && !C0332y.this.f10937C) {
                    C0332y.this.c0();
                    C0332y.this.f10937C = true;
                }
            }
            float f8 = f7;
            float f9 = f6;
            if (C0332y.this.f10966u.M() || f5 <= C0332y.this.f10970y * 1.2f) {
                C0332y.this.f10951f.a(C0332y.this.f10970y, C0332y.this.f10971z, f5, f9, f8);
            } else {
                if (Math.abs(C0332y.this.f10942H - C0332y.this.f10970y) < 1.0E-5d) {
                    f3 = C0332y.this.f10952g.getContainerGroupRect().exactCenterX() - ((C0332y.this.f10952g.getRectListUnion().exactCenterX() * C0332y.this.f10970y) * 1.2f);
                    f4 = C0332y.this.f10952g.getContainerGroupRect().exactCenterY() - ((C0332y.this.f10952g.getRectListUnion().exactCenterY() * C0332y.this.f10971z) * 1.2f);
                } else {
                    f3 = C0332y.this.f10938D + (((C0332y.this.f10940F - C0332y.this.f10938D) / (C0332y.this.f10942H - C0332y.this.f10970y)) * C0332y.this.f10970y * 0.2f);
                    f4 = C0332y.this.f10939E + (((C0332y.this.f10941G - C0332y.this.f10939E) / (C0332y.this.f10942H - C0332y.this.f10971z)) * C0332y.this.f10971z * 0.2f);
                }
                C0332y.this.f10951f.a(C0332y.this.f10970y, C0332y.this.f10971z, C0332y.this.f10970y * 1.2f, f3, f4);
            }
            Slog.d("CanvasGestureManager", "ScaleGestureDetector ScaleFactor:" + scaleGestureDetector.getScaleFactor() + " focusX:" + scaleGestureDetector.getFocusX() + " focusY:" + scaleGestureDetector.getFocusY() + " spanX:" + scaleGestureDetector.getCurrentSpanX() + " spanY:" + scaleGestureDetector.getCurrentSpanY());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            if (C0332y.this.f10935A <= 3 || C0332y.this.f10936B || C0332y.this.f10952g.h1() || C0332y.this.f10960o || C0332y.this.f10952g.d1()) {
                Log.i("CanvasGestureManager", "onScaleBegin mPointerCount=" + C0332y.this.f10935A + ",mScaling:" + C0332y.this.f10936B + ",isSwitchToZoomAnim:" + C0332y.this.f10952g.h1() + ",mSplitBarScrollStart:" + C0332y.this.f10960o + ",isSplitDragAnimating:" + C0332y.this.f10952g.d1());
                return false;
            }
            C0332y.this.f10936B = true;
            Log.d("CanvasGestureManager", "onScaleBegin mPointerCount=" + C0332y.this.f10935A);
            if (C0332y.f10934L) {
                if ((C0332y.this.f10948c == null || C0332y.this.f10948c.N()) && scaleGestureDetector.getEventTime() != C0332y.this.f10949d) {
                    C0332y.this.f10948c = new x1.r(C0332y.this.f10950e, C0332y.this.f10952g, C0332y.this.f10951f);
                    C0332y.this.f10948c.J();
                }
                return true;
            }
            if (C0332y.this.f10966u.L()) {
                C0332y.this.f10966u.w();
            }
            B1.l.u1(C0332y.this.f10951f, 20109, true);
            C0332y.this.f10937C = false;
            C0332y c0332y = C0332y.this;
            c0332y.f10970y = c0332y.f10951f.getScaleX();
            C0332y c0332y2 = C0332y.this;
            c0332y2.f10971z = c0332y2.f10951f.getScaleY();
            C0332y c0332y3 = C0332y.this;
            c0332y3.f10938D = c0332y3.f10951f.getTranslationX();
            C0332y c0332y4 = C0332y.this;
            c0332y4.f10939E = c0332y4.f10951f.getTranslationY();
            C0332y.this.f10952g.J0();
            if (C0332y.this.f10966u.M()) {
                C0332y.this.f10966u.D();
                int r3 = B1.l.r(C0332y.this.f10952g.getChildrenPositionOnScreen(), new Point((int) scaleGestureDetector.getFocusX(), (int) scaleGestureDetector.getFocusY()));
                Log.d("CanvasGestureManager", "exit panorama mode, focus=" + r3);
                C0332y.this.f10952g.getContainerController().F(r3);
            }
            float[] C3 = C0332y.this.f10966u.C(C0332y.this.f10970y, C0332y.this.f10971z, C0332y.this.f10938D, C0332y.this.f10939E);
            C0332y.this.f10940F = C3[0];
            C0332y.this.f10941G = C3[1];
            C0332y.this.f10942H = C3[2];
            Log.e("CanvasGestureManager", "mStartScale=" + C0332y.this.f10970y + " mStartTranslationX=" + C0332y.this.f10938D + " mStartTranslationY=" + C0332y.this.f10939E + " mTargetScale=" + C0332y.this.f10942H + " mTargetTranslationX=" + C0332y.this.f10940F + " mTargetTranslationY=" + C0332y.this.f10941G);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            C0332y.this.f10949d = scaleGestureDetector.getEventTime();
            Slog.d("CanvasGestureManager", "ScaleGestureDetector onScaleEnd mPointerCount:" + C0332y.this.f10935A + ",isInProgress:" + scaleGestureDetector.isInProgress());
            if (!C0332y.f10934L || C0332y.this.f10935A >= 3 || C0332y.this.f10948c == null) {
                return;
            }
            C0332y.this.f10948c.g0();
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.y$d */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = C0332y.this.f10952g.getChildEmbeddedViewList().size();
            if (size == 2 || size == 3) {
                for (int i3 = 0; i3 < C0332y.this.f10952g.getChildEmbeddedViewList().size(); i3++) {
                    C0332y.this.f10952g.getChildEmbeddedViewList().get(i3).setEmbeddedViewSnapShot(C0332y.this.f10952g.p0(C0332y.this.f10952g.D0(i3)));
                }
                if (size == 2) {
                    C0332y.this.f10952g.O0();
                }
            }
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.y$e */
    private class e {

        /* renamed from: a, reason: collision with root package name */
        private f f10976a;

        /* renamed from: b, reason: collision with root package name */
        private MotionEvent f10977b;

        /* renamed from: c, reason: collision with root package name */
        private MotionEvent f10978c;

        e(f fVar) {
            this.f10976a = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b(MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f10977b = MotionEvent.obtain(motionEvent);
                return true;
            }
            if (actionMasked == 1) {
                this.f10977b = null;
                this.f10978c = null;
            } else if (actionMasked == 2) {
                if (this.f10977b == null) {
                    return false;
                }
                if (this.f10978c == null) {
                    this.f10978c = MotionEvent.obtain(motionEvent);
                    C0332y.this.f10952g.f10732G.A0(this.f10978c);
                    return true;
                }
                float abs = Math.abs(motionEvent.getRawX() - this.f10978c.getRawX());
                float abs2 = Math.abs(motionEvent.getRawY() - this.f10978c.getRawY());
                if (abs >= 1.0f || abs2 >= 1.0f) {
                    this.f10978c = MotionEvent.obtain(motionEvent);
                    C0332y.this.f10952g.f10732G.A0(this.f10978c);
                    this.f10976a.a(this.f10977b, motionEvent);
                }
                return true;
            }
            return true;
        }
    }

    /* renamed from: com.oplus.pscanvas.canvasmode.canvas.y$f */
    private interface f {
        void a(MotionEvent motionEvent, MotionEvent motionEvent2);
    }

    public C0332y(ContainerActivity containerActivity) {
        this.f10950e = containerActivity;
        this.f10947b = containerActivity;
        f10934L = B1.l.F0(containerActivity);
        this.f10946a = new GestureDetector(this.f10950e, new a());
        this.f10965t = new e(new b());
        Context context = this.f10950e;
        this.f10964s = new ScaleGestureDetector(context, ViewConfiguration.get(context).getScaledTouchSlop() * 2, 0, null, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] K(float f3, float[] fArr, float[] fArr2, float[] fArr3) {
        float f4 = f3 - 1.0f;
        float[] fArr4 = new float[3];
        float f5 = fArr[0];
        float f6 = this.f10970y;
        float b02 = b0(f4, f5, f6, f6 * 0.3f, (1.5f * f6) / this.f10951f.getScaleX());
        fArr4[0] = b02;
        float f7 = fArr3[0];
        float f8 = fArr2[0];
        if (f7 == f8) {
            fArr4[1] = this.f10952g.getContainerGroupRect().exactCenterX() - (this.f10952g.getRectListUnion().exactCenterX() * fArr4[0]);
            fArr4[2] = this.f10952g.getContainerGroupRect().exactCenterY() - (this.f10952g.getRectListUnion().exactCenterY() * fArr4[0]);
        } else {
            float f9 = fArr[1];
            float f10 = fArr[0];
            fArr4[1] = f9 + (((b02 - f10) / (f7 - f8)) * (fArr3[1] - fArr2[1]));
            fArr4[2] = fArr[2] + (((b02 - f10) / (f7 - f8)) * (fArr3[2] - fArr2[2]));
        }
        return fArr4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        this.f10959n = this.f10952g.g0(rawX, rawY);
        Log.d("CanvasGestureManager", "handleDown mDownTarget=" + this.f10959n + " event : " + motionEvent);
        if (motionEvent.isHoverEvent()) {
            Log.d("CanvasGestureManager", "handleDown, hover event");
            return false;
        }
        if (motionEvent.getToolType(0) == 2 && B1.s.o()) {
            Log.d("CanvasGestureManager", "handleDown, pen writing event");
            return false;
        }
        this.f10944J = true;
        if (this.f10947b.f10236R.contains(rawX, rawY)) {
            this.f10959n = -4;
            return false;
        }
        if (this.f10952g.getSplitBarVisibility() == 0 && !this.f10952g.H0() && this.f10952g.f10732G.W(motionEvent) != null && !this.f10952g.f10755S) {
            Log.d("CanvasGestureManager", "pilferPointers because down at splitbar area");
            this.f10947b.w1();
            this.f10959n = -3;
            U();
            this.f10952g.P0();
            return false;
        }
        if (this.f10952g.getInAutoFocusAnimation()) {
            Log.d("CanvasGestureManager", "pilferPointers because inAutoFocusAnimation");
            this.f10947b.w1();
        }
        if (this.f10952g.H1(motionEvent) && !this.f10966u.M()) {
            ContainerActivity containerActivity = this.f10947b;
            if (containerActivity.f10273q && Q(containerActivity.f10282y, rawX, rawY)) {
                Log.d("CanvasGestureManager", "click at system gesture area");
                if (P(motionEvent)) {
                    Log.d("CanvasGestureManager", "isInjectEvent, pilferPointers");
                    this.f10947b.w1();
                    return false;
                }
                this.f10959n = -2;
                this.f10943I = false;
                return true;
            }
            this.f10952g.getContainerController().n();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N(MotionEvent motionEvent) {
        E.c W3;
        motionEvent.getRawX();
        motionEvent.getRawY();
        Log.d("CanvasGestureManager", "handleUp mDownTarget =" + this.f10959n + " event : " + motionEvent);
        if (motionEvent.isHoverEvent()) {
            Log.d("CanvasGestureManager", "handleUp, hover event");
            return false;
        }
        if (motionEvent.getToolType(0) == 2 && B1.s.o()) {
            Log.d("CanvasGestureManager", "handleUp, pen writing event");
            return false;
        }
        if (this.f10952g.getSplitBarVisibility() == 0 && this.f10959n == -3 && (W3 = this.f10952g.f10732G.W(motionEvent)) != null) {
            Log.e("CanvasGestureManager", "onSplitBarClick");
            this.f10952g.f10732G.o0(W3);
            this.f10959n = -2;
            this.f10960o = false;
            this.f10950e.getMainThreadHandler().postDelayed(new Runnable() { // from class: com.oplus.pscanvas.canvasmode.canvas.x
                @Override // java.lang.Runnable
                public final void run() {
                    C0332y.this.S();
                }
            }, 10L);
            return true;
        }
        int i3 = this.f10959n;
        if (i3 >= 0 && i3 != this.f10952g.getContainerController().n() && !this.f10952g.f10755S && !this.f10947b.T0()) {
            if (!this.f10952g.G1(this.f10959n)) {
                this.f10952g.getAdapter().H(this.f10959n);
            } else if (this.f10966u.M()) {
                this.f10952g.getAdapter().H(this.f10959n);
            } else {
                this.f10952g.V(this.f10959n, 1);
            }
        }
        this.f10959n = -2;
        this.f10960o = false;
        this.f10943I = false;
        this.f10944J = false;
        return true;
    }

    public static boolean P(MotionEvent motionEvent) {
        return motionEvent.getEventTime() - motionEvent.getDownTime() == 1;
    }

    private boolean Q(Rect rect, int i3, int i4) {
        return i3 >= rect.left && i3 <= rect.right && i4 >= rect.top && i4 <= rect.bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        this.f10944J = false;
    }

    private void U() {
        if (this.f10952g.k1() || this.f10952g.i1()) {
            C0305a.a().b(new d());
        }
    }

    private boolean X() {
        return (R() || this.f10952g.h1() || Math.min(this.f10951f.getScaleX(), this.f10951f.getScaleY()) > this.f10970y * 0.9f) ? false : true;
    }

    private boolean Y() {
        return this.f10966u.M() && Math.min(this.f10951f.getScaleX(), this.f10951f.getScaleY()) >= this.f10970y * 1.1f;
    }

    private boolean a0(int i3) {
        int b3 = B1.s.b(SystemProperties.getInt("persist.sys.gesture.back", 24), this.f10950e.getResources());
        return i3 <= b3 || i3 > B1.s.j(this.f10950e) - b3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float b0(float r4, float r5, float r6, float r7, float r8) {
        /*
            r3 = this;
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1099956224(0x41900000, float:18.0)
            r2 = 0
            if (r3 <= 0) goto L14
            int r3 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r3 > 0) goto L14
            float r3 = r6 - r5
            float r3 = r3 * r1
            float r6 = r6 - r7
            float r3 = r3 / r6
        L12:
            float r3 = r3 + r0
            goto L23
        L14:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 > 0) goto L22
            int r3 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r3 <= 0) goto L22
            float r3 = r5 - r6
            float r3 = r3 * r1
            float r8 = r8 - r6
            float r3 = r3 / r8
            goto L12
        L22:
            r3 = r2
        L23:
            float r6 = r3 - r2
            float r6 = java.lang.Math.abs(r6)
            double r6 = (double) r6
            r0 = 4532020583610935537(0x3ee4f8b588e368f1, double:1.0E-5)
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            r7 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r6 >= 0) goto L37
            goto L3a
        L37:
            float r3 = r3 + r7
            float r7 = r4 / r3
        L3a:
            float r5 = r5 + r7
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.pscanvas.canvasmode.canvas.C0332y.b0(float, float, float, float, float):float");
    }

    public void J() {
        this.f10959n = -2;
    }

    public x1.r L() {
        return this.f10948c;
    }

    public void O(DraggableCanvasViewGroup draggableCanvasViewGroup, ContainerView containerView, A0 a02) {
        this.f10951f = draggableCanvasViewGroup;
        this.f10952g = containerView;
        this.f10966u = a02;
    }

    public boolean R() {
        if (this.f10952g.getAdapter().getCount() != 2) {
            return false;
        }
        if (!B1.s.H()) {
            Rect rectListUnion = this.f10952g.getRectListUnion();
            Rect containerGroupRect = this.f10952g.getContainerGroupRect();
            rectListUnion.inset(1, 1);
            return containerGroupRect.contains(rectListUnion);
        }
        ContainerView containerView = this.f10952g;
        List z02 = containerView.z0(containerView.getRectList(), this.f10952g.getAdapter().n(), 0);
        if (z02.size() != 2) {
            return false;
        }
        Rect rect = (Rect) z02.get(0);
        rect.union((Rect) z02.get(1));
        Rect containerGroupRect2 = this.f10952g.getContainerGroupRect();
        rect.inset(1, 1);
        return containerGroupRect2.contains(rect);
    }

    public boolean T(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        this.f10935A = motionEvent.getPointerCount();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f10935A > 1) {
            this.f10943I = true;
        }
        Log.d("CanvasGestureManager", "onTouchEventByGesture event " + motionEvent + " mPointerCount:" + this.f10935A);
        if (this.f10946a.onTouchEvent(motionEvent)) {
            if (!B1.s.w(this.f10950e)) {
                motionEvent.setAction(3);
                this.f10964s.onTouchEvent(motionEvent);
            }
            this.f10936B = false;
            return true;
        }
        this.f10965t.b(motionEvent);
        if (!B1.s.w(this.f10950e) && !this.f10960o) {
            this.f10964s.onTouchEvent(motionEvent);
        }
        x1.r rVar = this.f10948c;
        if (rVar != null && rVar.P() && ((motionEvent.getAction() == 1 || motionEvent.getActionMasked() == 6 || motionEvent.getActionMasked() == 2) && this.f10935A < 3)) {
            this.f10948c.g0();
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f10952g.W0()) {
                        int g02 = this.f10952g.g0(rawX, rawY);
                        if (!this.f10952g.h0(rawX, rawY)) {
                            if (this.f10966u.M()) {
                                this.f10952g.getContainerController().F(g02);
                            } else {
                                this.f10952g.R(g02);
                            }
                        }
                    }
                    if (Math.abs(rawX - this.f10961p) > this.f10963r) {
                        this.f10963r = Math.abs(rawX - this.f10961p);
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked != 9) {
                        if (actionMasked == 10) {
                            this.f10952g.M1(motionEvent);
                            if (AccessibilityManager.getInstance(this.f10950e).isEnabled()) {
                                N(motionEvent);
                            }
                        }
                    } else if (AccessibilityManager.getInstance(this.f10950e).isEnabled()) {
                        M(motionEvent);
                    }
                }
            }
            Log.d("CanvasGestureManager", "onTouchEventByGesture click final move " + Math.abs(rawX - this.f10961p) + " temp move " + this.f10963r + " touchInBackArea: " + a0(this.f10961p));
            if (this.f10963r > 0 && a0(this.f10961p)) {
                this.f10936B = false;
                Log.d("CanvasGestureManager", "onTouchEventByGesture click mEndPointX " + rawX + " mStartPointX" + this.f10961p);
                return false;
            }
            if (this.f10936B) {
                this.f10936B = false;
                if (!this.f10966u.M()) {
                    OplusInputMethodManager.getInstance().hideCurrentInputMethod();
                    if (X()) {
                        this.f10966u.z(true);
                    } else {
                        this.f10952g.E1();
                    }
                } else if (Y()) {
                    this.f10966u.A(true);
                    this.f10966u.W("gesture_exit");
                } else {
                    this.f10966u.d0(false);
                    this.f10966u.c0(this.f10950e);
                }
                this.f10959n = -2;
                this.f10943I = false;
                this.f10944J = false;
            } else {
                if (this.f10966u.M() && this.f10952g.isVisibleToUser()) {
                    this.f10966u.c0(this.f10950e);
                }
                this.f10952g.g0(rawX, rawY);
                if (this.f10960o) {
                    this.f10952g.f10732G.s0(motionEvent, this.f10961p, this.f10962q);
                    this.f10960o = false;
                    this.f10959n = -2;
                    this.f10943I = false;
                    this.f10944J = false;
                    return true;
                }
                if (this.f10945K) {
                    V(false);
                    this.f10959n = -2;
                    this.f10943I = false;
                    this.f10944J = false;
                    return false;
                }
                Log.d("CanvasGestureManager", "onTouchEventByGesture mDownTarget =" + this.f10959n);
                if (this.f10959n == -3 && this.f10952g.k1()) {
                    if (this.f10952g.getAnimatorSet() != null && this.f10952g.getAnimatorSet().isRunning()) {
                        this.f10952g.getAnimatorSet().cancel();
                    }
                    ContainerView containerView = this.f10952g;
                    containerView.C1(300, containerView.getOriginalLocations(), this.f10952g.getOriginalLocations());
                    E.c W3 = this.f10952g.f10732G.W(motionEvent);
                    if (W3 != null) {
                        this.f10952g.x1(300, W3.h(), 1.0f);
                    }
                }
                int i3 = this.f10959n;
                if (i3 >= 0 && i3 != this.f10952g.getContainerController().n() && !this.f10943I && !this.f10952g.W0()) {
                    ContainerView containerView2 = this.f10952g;
                    if (!containerView2.f10755S) {
                        if (!containerView2.G1(this.f10959n)) {
                            this.f10952g.getAdapter().H(this.f10959n);
                        } else if (this.f10966u.M()) {
                            this.f10952g.getAdapter().H(this.f10959n);
                        } else {
                            this.f10952g.V(this.f10959n, 1);
                        }
                    }
                }
                this.f10959n = -2;
                this.f10944J = false;
                this.f10943I = false;
            }
        } else {
            this.f10961p = rawX;
            this.f10962q = rawY;
            this.f10963r = 0;
            this.f10952g.f10732G.E0(rawX, rawY);
        }
        return true;
    }

    public void V(boolean z3) {
        this.f10945K = z3;
    }

    public void W(boolean z3) {
        this.f10960o = z3;
    }

    public boolean Z() {
        return this.f10960o;
    }

    public void c0() {
        x1.s.a(this.f10950e, 0, true);
    }
}
