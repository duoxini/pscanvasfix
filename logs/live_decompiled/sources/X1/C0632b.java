package x1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.util.Log;
import android.util.TypedValue;
import android.view.animation.PathInterpolator;
import com.oplus.pscanvas.canvasmode.canvas.view.DraggableCanvasViewGroup;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: x1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0632b {

    /* renamed from: M, reason: collision with root package name */
    private static final String f14008M = "b";

    /* renamed from: N, reason: collision with root package name */
    private static final Boolean f14009N = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: O, reason: collision with root package name */
    public static final PathInterpolator f14010O = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: A, reason: collision with root package name */
    private EmbeddedViewDecor f14011A;

    /* renamed from: B, reason: collision with root package name */
    private Context f14012B;

    /* renamed from: C, reason: collision with root package name */
    private AnimatorSet f14013C;

    /* renamed from: d, reason: collision with root package name */
    private int f14026d;

    /* renamed from: e, reason: collision with root package name */
    private int f14027e;

    /* renamed from: f, reason: collision with root package name */
    private int f14028f;

    /* renamed from: g, reason: collision with root package name */
    private float f14029g;

    /* renamed from: w, reason: collision with root package name */
    private d f14045w;

    /* renamed from: x, reason: collision with root package name */
    private DraggableCanvasViewGroup f14046x;

    /* renamed from: z, reason: collision with root package name */
    private EmbeddedViewDecor f14048z;

    /* renamed from: a, reason: collision with root package name */
    private int f14023a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f14024b = 0;

    /* renamed from: h, reason: collision with root package name */
    private float[] f14030h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private float[] f14031i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private Rect f14032j = new Rect();

    /* renamed from: k, reason: collision with root package name */
    private Rect f14033k = new Rect();

    /* renamed from: l, reason: collision with root package name */
    private Rect f14034l = new Rect();

    /* renamed from: m, reason: collision with root package name */
    private Rect f14035m = new Rect();

    /* renamed from: n, reason: collision with root package name */
    private Rect f14036n = new Rect();

    /* renamed from: o, reason: collision with root package name */
    private Rect f14037o = new Rect();

    /* renamed from: p, reason: collision with root package name */
    private Rect f14038p = new Rect();

    /* renamed from: q, reason: collision with root package name */
    private Rect f14039q = new Rect();

    /* renamed from: r, reason: collision with root package name */
    private Point f14040r = new Point();

    /* renamed from: s, reason: collision with root package name */
    private Point f14041s = new Point();

    /* renamed from: t, reason: collision with root package name */
    private Point f14042t = new Point();

    /* renamed from: u, reason: collision with root package name */
    private PointF f14043u = new PointF();

    /* renamed from: v, reason: collision with root package name */
    private boolean f14044v = false;

    /* renamed from: D, reason: collision with root package name */
    private float[] f14014D = {1.0f, 1.0f};

    /* renamed from: E, reason: collision with root package name */
    private float[] f14015E = {1.0f, 1.0f};

    /* renamed from: F, reason: collision with root package name */
    private int[] f14016F = {0, 0};

    /* renamed from: G, reason: collision with root package name */
    private int[] f14017G = {0, 0};

    /* renamed from: H, reason: collision with root package name */
    private float[] f14018H = {0.0f, 0.0f};

    /* renamed from: I, reason: collision with root package name */
    private float[] f14019I = {0.0f, 0.0f};

    /* renamed from: J, reason: collision with root package name */
    private int[] f14020J = new int[2];

    /* renamed from: K, reason: collision with root package name */
    private int[] f14021K = new int[2];

    /* renamed from: L, reason: collision with root package name */
    public long f14022L = 0;

    /* renamed from: y, reason: collision with root package name */
    private Handler f14047y = new a();

    /* renamed from: c, reason: collision with root package name */
    private int f14025c = ActivityManager.getCurrentUser();

    /* renamed from: x1.b$a */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 0) {
                C0632b.this.F((C0631a) message.obj);
                return;
            }
            if (i3 == 1) {
                C0632b.this.C(((Integer) message.obj).intValue());
            } else if (i3 == 2 || i3 == 3) {
                C0632b.this.d0();
            }
        }
    }

    /* renamed from: x1.b$b, reason: collision with other inner class name */
    class C0156b implements Animator.AnimatorListener {
        C0156b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C0632b.this.f14020J[0] = (int) (C0632b.this.f14048z.getTranslationX() - C0632b.this.f14034l.left);
            C0632b.this.f14020J[1] = (int) (C0632b.this.f14048z.getTranslationY() - C0632b.this.f14034l.top);
            C0632b.this.f14021K[0] = (int) (C0632b.this.f14011A.getTranslationX() - C0632b.this.f14035m.left);
            C0632b.this.f14021K[1] = (int) (C0632b.this.f14011A.getTranslationY() - C0632b.this.f14035m.top);
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "handleControlBarLongPress animation Cancel");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0632b c0632b = C0632b.this;
            c0632b.f14030h = (float[]) c0632b.f14014D.clone();
            C0632b c0632b2 = C0632b.this;
            c0632b2.f14031i = (float[]) c0632b2.f14015E.clone();
            C0632b c0632b3 = C0632b.this;
            c0632b3.f14020J = (int[]) c0632b3.f14016F.clone();
            C0632b c0632b4 = C0632b.this;
            c0632b4.f14021K = (int[]) c0632b4.f14017G.clone();
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "handleControlBarLongPress animation End");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "handleControlBarLongPress animation repeat");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "handleControlBarLongPress animation start");
            }
        }
    }

    /* renamed from: x1.b$c */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "startChildViewsEnlargeAnimation, onAnimationCancel");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "startChildViewsEnlargeAnimation, onAnimationEnd");
            }
            B1.l.u1(C0632b.this.f14048z, 20109, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "startChildViewsEnlargeAnimation, onAnimationRepeat");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (C0632b.f14009N.booleanValue()) {
                Log.d(C0632b.f14008M, "startChildViewsEnlargeAnimation, onAnimationStart");
            }
            B1.l.u1(C0632b.this.f14048z, 20109, true);
        }
    }

    /* renamed from: x1.b$d */
    public interface d {
        Point a();

        void b();

        Point c();

        void d(Point point, Point point2, Point point3, Point point4, Rect rect, Rect rect2, Rect rect3, Rect rect4, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float f3, int i3, int i4);

        void e();

        void f(int i3);

        void g(C0631a c0631a);

        boolean h();

        void i();

        Point j();
    }

    public C0632b(d dVar) {
        this.f14045w = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0495  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(int r31) {
        /*
            Method dump skipped, instructions count: 1208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.C0632b.C(int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(C0631a c0631a) {
        int i3;
        int i4;
        Message obtainMessage = this.f14047y.obtainMessage();
        obtainMessage.what = 1;
        int h3 = c0631a.h();
        if (h3 == 0) {
            int i5 = this.f14023a;
            if (i5 == 1 || i5 == 2) {
                return;
            }
            obtainMessage.obj = 1;
            this.f14047y.sendMessage(obtainMessage);
            return;
        }
        if (h3 == 1) {
            int i6 = this.f14023a;
            if (i6 == 5 || i6 == 6) {
                return;
            }
            obtainMessage.obj = 5;
            this.f14047y.sendMessage(obtainMessage);
            return;
        }
        if (h3 != 2) {
            if (h3 != 3 || (i4 = this.f14023a) == 7 || i4 == 8) {
                return;
            }
            obtainMessage.obj = 7;
            this.f14047y.sendMessage(obtainMessage);
            return;
        }
        d dVar = this.f14045w;
        if (dVar == null || dVar.h()) {
            return;
        }
        EmbeddedViewDecor embeddedViewDecor = this.f14048z;
        if (!B1.l.k(embeddedViewDecor != null ? embeddedViewDecor.getTaskData() : null, null) || (i3 = this.f14023a) == 3 || i3 == 4) {
            return;
        }
        obtainMessage.obj = 3;
        this.f14047y.sendMessage(obtainMessage);
    }

    private void G() {
        this.f14018H[0] = this.f14048z.getTranslationX();
        this.f14018H[1] = this.f14048z.getTranslationY();
        this.f14019I[0] = this.f14011A.getTranslationX();
        this.f14019I[1] = this.f14011A.getTranslationY();
        if (this.f14044v) {
            int[] iArr = this.f14016F;
            iArr[0] = 0;
            this.f14017G[0] = 0;
            if (this.f14034l.top < this.f14035m.top) {
                iArr[1] = u(7.0f);
                this.f14017G[1] = -u(7.0f);
            } else {
                iArr[1] = -u(7.0f);
                this.f14017G[1] = u(7.0f);
            }
            this.f14014D[0] = ((this.f14048z.getWidth() - u(28.0f)) * 1.0f) / this.f14048z.getWidth();
            this.f14014D[1] = ((this.f14048z.getHeight() - u(14.0f)) * 1.0f) / this.f14048z.getHeight();
            this.f14015E[0] = ((this.f14011A.getWidth() - u(28.0f)) * 1.0f) / this.f14011A.getWidth();
            this.f14015E[1] = ((this.f14011A.getHeight() - u(14.0f)) * 1.0f) / this.f14011A.getHeight();
        } else {
            int[] iArr2 = this.f14016F;
            iArr2[1] = 0;
            this.f14017G[1] = 0;
            if (this.f14034l.left < this.f14035m.left) {
                iArr2[0] = u(7.0f);
                this.f14017G[0] = -u(7.0f);
            } else {
                iArr2[0] = -u(7.0f);
                this.f14017G[0] = u(7.0f);
            }
            this.f14014D[0] = ((this.f14048z.getWidth() - u(14.0f)) * 1.0f) / this.f14048z.getWidth();
            this.f14014D[1] = ((this.f14048z.getHeight() - u(28.0f)) * 1.0f) / this.f14048z.getHeight();
            this.f14015E[0] = ((this.f14011A.getWidth() - u(14.0f)) * 1.0f) / this.f14011A.getWidth();
            this.f14015E[1] = ((this.f14011A.getHeight() - u(28.0f)) * 1.0f) / this.f14011A.getHeight();
        }
        if (f14009N.booleanValue()) {
            Log.d(f14008M, "initChildViewScale mTwoSplitIsHorizontal = " + this.f14044v + " mMotionViewPositionOffset = " + Arrays.toString(this.f14016F) + " mNonMotionViewPositionOffset = " + Arrays.toString(this.f14017G) + "mMotionViewScale = " + Arrays.toString(this.f14014D) + " mNonMotionViewScale = " + Arrays.toString(this.f14015E));
        }
    }

    private int s(Rect rect, Rect rect2) {
        int i3 = rect.left - rect2.left;
        if (i3 <= 0) {
            i3 = -i3;
        }
        int i4 = rect.top - rect2.top;
        if (i4 <= 0) {
            i4 = -i4;
        }
        if (i3 <= i4) {
            i3 = i4;
        }
        int i5 = rect.right - rect2.right;
        if (i5 <= 0) {
            i5 = -i5;
        }
        if (i3 <= i5) {
            i3 = i5;
        }
        int i6 = rect.bottom - rect2.bottom;
        if (i6 <= 0) {
            i6 = -i6;
        }
        return i3 > i6 ? i3 : i6;
    }

    private List t(boolean z3, int i3) {
        ArrayList arrayList = new ArrayList();
        EmbeddedViewDecor embeddedViewDecor = this.f14048z;
        if (embeddedViewDecor != null && this.f14011A != null) {
            if (z3) {
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor, "scaleX", embeddedViewDecor.getScaleX(), 1.0f));
                EmbeddedViewDecor embeddedViewDecor2 = this.f14048z;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor2, "scaleY", embeddedViewDecor2.getScaleY(), 1.0f));
                EmbeddedViewDecor embeddedViewDecor3 = this.f14011A;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor3, "scaleX", embeddedViewDecor3.getScaleX(), 1.0f));
                EmbeddedViewDecor embeddedViewDecor4 = this.f14011A;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor4, "scaleY", embeddedViewDecor4.getScaleY(), 1.0f));
                if (i3 == 0) {
                    EmbeddedViewDecor embeddedViewDecor5 = this.f14048z;
                    arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor5, "translationX", embeddedViewDecor5.getTranslationX(), this.f14018H[0]));
                    EmbeddedViewDecor embeddedViewDecor6 = this.f14048z;
                    arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor6, "translationY", embeddedViewDecor6.getTranslationY(), this.f14018H[1]));
                    EmbeddedViewDecor embeddedViewDecor7 = this.f14011A;
                    arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor7, "translationX", embeddedViewDecor7.getTranslationX(), this.f14019I[0]));
                    EmbeddedViewDecor embeddedViewDecor8 = this.f14011A;
                    arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor8, "translationY", embeddedViewDecor8.getTranslationY(), this.f14019I[1]));
                }
            } else {
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor, "scaleX", embeddedViewDecor.getScaleX(), this.f14014D[0]));
                EmbeddedViewDecor embeddedViewDecor9 = this.f14048z;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor9, "scaleY", embeddedViewDecor9.getScaleY(), this.f14014D[1]));
                EmbeddedViewDecor embeddedViewDecor10 = this.f14011A;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor10, "scaleX", embeddedViewDecor10.getScaleX(), this.f14015E[0]));
                EmbeddedViewDecor embeddedViewDecor11 = this.f14011A;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor11, "scaleY", embeddedViewDecor11.getScaleY(), this.f14015E[1]));
                EmbeddedViewDecor embeddedViewDecor12 = this.f14048z;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor12, "translationX", embeddedViewDecor12.getTranslationX(), this.f14048z.getTranslationX() + this.f14016F[0]));
                EmbeddedViewDecor embeddedViewDecor13 = this.f14048z;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor13, "translationY", embeddedViewDecor13.getTranslationY(), this.f14048z.getTranslationY() + this.f14016F[1]));
                EmbeddedViewDecor embeddedViewDecor14 = this.f14011A;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor14, "translationX", embeddedViewDecor14.getTranslationX(), this.f14011A.getTranslationX() + this.f14017G[0]));
                EmbeddedViewDecor embeddedViewDecor15 = this.f14011A;
                arrayList.add(ObjectAnimator.ofFloat(embeddedViewDecor15, "translationY", embeddedViewDecor15.getTranslationY(), this.f14011A.getTranslationY() + this.f14017G[1]));
            }
        }
        return arrayList;
    }

    public PointF A() {
        return this.f14043u;
    }

    public Rect B() {
        return this.f14037o;
    }

    public void D() {
        List t3 = t(false, -1);
        AnimatorSet animatorSet = this.f14013C;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f14013C.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f14013C = animatorSet2;
        animatorSet2.setInterpolator(new Y.e());
        this.f14013C.playTogether(t3);
        this.f14013C.setDuration(300L);
        this.f14013C.addListener(new C0156b());
        Message obtainMessage = this.f14047y.obtainMessage();
        obtainMessage.what = 2;
        this.f14047y.sendMessage(obtainMessage);
    }

    public void E(C0631a c0631a) {
        this.f14043u.set(c0631a.g());
        this.f14045w.g(c0631a);
        if (c0631a.h() == 3) {
            this.f14047y.removeMessages(0);
            this.f14022L = 0L;
        }
        Message obtainMessage = this.f14047y.obtainMessage();
        obtainMessage.what = 0;
        obtainMessage.obj = c0631a;
        if (c0631a.h() != 2) {
            this.f14022L = 0L;
            this.f14047y.removeMessages(0);
            this.f14047y.sendMessage(obtainMessage);
            return;
        }
        if (f14009N.booleanValue()) {
            Log.d(f14008M, "handleTouchState state=" + c0631a.h() + " , mLastToZoomTime " + this.f14022L);
        }
        if (this.f14022L == 0) {
            this.f14022L = System.currentTimeMillis();
            this.f14047y.sendMessageDelayed(obtainMessage, 250L);
        }
    }

    public void H() {
        EmbeddedViewDecor embeddedViewDecor = this.f14048z;
        if (embeddedViewDecor == null || this.f14011A == null) {
            return;
        }
        embeddedViewDecor.setPivotX(embeddedViewDecor.getWidth() / 2.0f);
        this.f14048z.setPivotY(r0.getHeight() / 2.0f);
        this.f14011A.setPivotX(r0.getWidth() / 2.0f);
        this.f14011A.setPivotY(r3.getHeight() / 2.0f);
    }

    public boolean I() {
        int i3 = this.f14024b;
        return i3 == 2 || i3 == 6 || i3 == 1 || i3 == 5;
    }

    public void J(Point point) {
        this.f14042t = point;
    }

    public void K(EmbeddedViewDecor embeddedViewDecor, EmbeddedViewDecor embeddedViewDecor2) {
        this.f14048z = embeddedViewDecor;
        this.f14011A = embeddedViewDecor2;
        G();
        H();
    }

    public void L(Context context) {
        this.f14012B = context;
    }

    public void M(int i3) {
        Log.d(f14008M, "### transferAnimation normal end to:" + i3);
        this.f14023a = i3;
    }

    public void N(int i3, int i4, int i5, int i6) {
        this.f14036n.set(i3, i4, i5, i6);
    }

    public void O(int i3, int i4) {
        this.f14041s.set(i3, i4);
    }

    public void P(float[] fArr) {
        this.f14030h = fArr;
    }

    public void Q(float[] fArr) {
        this.f14031i = fArr;
    }

    public void R(int i3, int i4, int i5, int i6) {
        this.f14037o.set(i3, i4, i5, i6);
    }

    public void S(int i3, int i4) {
        this.f14040r.set(i3, i4);
    }

    public void T(int i3) {
        this.f14026d = i3;
    }

    public void U(Rect rect, Rect rect2, Rect rect3, Rect rect4, Rect rect5) {
        this.f14034l.set(rect);
        this.f14035m.set(rect2);
        this.f14036n.set(0, 0, this.f14034l.width(), this.f14034l.height());
        this.f14036n.inset(1, 1);
        this.f14037o.set(0, 0, this.f14035m.width(), this.f14035m.height());
        this.f14033k.set(rect3);
        this.f14038p.set(rect4);
        this.f14039q.set(rect5);
    }

    public void V(int[] iArr) {
        this.f14020J = iArr;
    }

    public void W(int[] iArr) {
        this.f14021K = iArr;
    }

    public void X(DraggableCanvasViewGroup draggableCanvasViewGroup) {
        this.f14046x = draggableCanvasViewGroup;
    }

    public void Y(int i3, int i4) {
        this.f14027e = i3;
        this.f14028f = i4;
    }

    public void Z(boolean z3) {
        this.f14044v = z3;
    }

    public void a0(Rect rect) {
        this.f14032j.set(rect);
    }

    public void b0(float f3) {
        this.f14029g = f3;
    }

    public void c0(int i3) {
        if (this.f14047y.hasMessages(2)) {
            this.f14047y.removeMessages(2);
            if (f14009N.booleanValue()) {
                Log.d(f14008M, "startChildViewsEnlargeAnimation, removeMessages: MSG_HANDLE_LONG_PRESS");
            }
        }
        AnimatorSet animatorSet = this.f14013C;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f14013C = null;
            if (f14009N.booleanValue()) {
                Log.d(f14008M, "startChildViewsEnlargeAnimation, cancel mChildViewsScaleAnimatorSet");
            }
        }
        if (Math.abs(this.f14048z.getScaleX() - 1.0f) >= 1.0E-5d) {
            List t3 = t(true, i3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f14013C = animatorSet2;
            animatorSet2.setInterpolator(f14010O);
            this.f14013C.playTogether(t3);
            this.f14013C.setDuration(400L);
            this.f14013C.addListener(new c());
            Message obtainMessage = this.f14047y.obtainMessage();
            obtainMessage.what = 3;
            this.f14047y.sendMessage(obtainMessage);
        }
    }

    public void d0() {
        AnimatorSet animatorSet = this.f14013C;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public int u(float f3) {
        return (int) TypedValue.applyDimension(1, f3, this.f14012B.getResources().getDisplayMetrics());
    }

    public void v() {
        AnimatorSet animatorSet = this.f14013C;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.f14013C.end();
    }

    public int w() {
        return this.f14024b;
    }

    public int x() {
        return this.f14023a;
    }

    public Rect y() {
        return this.f14036n;
    }

    public float[] z() {
        return this.f14030h;
    }
}
