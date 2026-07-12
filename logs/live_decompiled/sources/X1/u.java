package x1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.OplusActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.hardware.HardwareBuffer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.SurfaceSession;
import android.view.ViewRootImpl;
import androidx.preference.Preference;
import com.google.android.collect.Sets;
import com.oplus.flexiblewindow.FlexibleTaskView;
import com.oplus.os.OplusBuild;
import com.oplus.pscanvas.canvasmode.canvas.C0305a;
import com.oplus.pscanvas.canvasmode.canvas.ContainerActivity;
import com.oplus.pscanvas.canvasmode.canvas.E;
import com.oplus.pscanvas.canvasmode.canvas.view.ContainerView;
import com.oplus.pscanvas.canvasmode.canvas.view.EmbeddedViewDecor;
import com.oplus.view.inputmethod.OplusInputMethodManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import t1.AbstractC0587a;
import u1.C0601d;
import x1.C0632b;

/* loaded from: classes.dex */
public class u implements C0632b.d {

    /* renamed from: p0, reason: collision with root package name */
    private static final Boolean f14185p0 = Boolean.valueOf(SystemProperties.getBoolean("persist.sys.assert.panic", false));

    /* renamed from: q0, reason: collision with root package name */
    private static final Set f14186q0 = Sets.newArraySet(new String[]{"com.jingdong.app.mall"});

    /* renamed from: D, reason: collision with root package name */
    private float f14190D;

    /* renamed from: E, reason: collision with root package name */
    private float f14191E;

    /* renamed from: F, reason: collision with root package name */
    private float f14192F;

    /* renamed from: K, reason: collision with root package name */
    private Context f14197K;

    /* renamed from: L, reason: collision with root package name */
    private ContainerView f14198L;

    /* renamed from: M, reason: collision with root package name */
    private EmbeddedViewDecor f14199M;

    /* renamed from: N, reason: collision with root package name */
    private EmbeddedViewDecor f14200N;

    /* renamed from: O, reason: collision with root package name */
    private FlexibleTaskView f14201O;

    /* renamed from: P, reason: collision with root package name */
    private FlexibleTaskView f14202P;

    /* renamed from: R, reason: collision with root package name */
    private ValueAnimator f14204R;

    /* renamed from: S, reason: collision with root package name */
    private ValueAnimator f14205S;

    /* renamed from: T, reason: collision with root package name */
    private SurfaceControl f14206T;

    /* renamed from: U, reason: collision with root package name */
    private SurfaceControl f14207U;

    /* renamed from: V, reason: collision with root package name */
    private SurfaceControl f14208V;

    /* renamed from: W, reason: collision with root package name */
    private SurfaceControl f14209W;

    /* renamed from: X, reason: collision with root package name */
    private SurfaceControl f14210X;

    /* renamed from: Y, reason: collision with root package name */
    private SurfaceControl f14211Y;

    /* renamed from: Z, reason: collision with root package name */
    private SurfaceControl f14212Z;

    /* renamed from: c, reason: collision with root package name */
    private Rect f14217c;

    /* renamed from: c0, reason: collision with root package name */
    private SurfaceControl f14218c0;

    /* renamed from: d, reason: collision with root package name */
    private Rect f14219d;

    /* renamed from: d0, reason: collision with root package name */
    private C0601d f14220d0;

    /* renamed from: e0, reason: collision with root package name */
    private C0601d f14222e0;

    /* renamed from: f, reason: collision with root package name */
    private Rect f14223f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f14225g;

    /* renamed from: g0, reason: collision with root package name */
    private Point f14226g0;

    /* renamed from: h, reason: collision with root package name */
    private Rect f14227h;

    /* renamed from: h0, reason: collision with root package name */
    private ValueAnimator f14228h0;

    /* renamed from: i, reason: collision with root package name */
    private Rect f14229i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f14230i0;

    /* renamed from: l, reason: collision with root package name */
    private int f14235l;

    /* renamed from: m, reason: collision with root package name */
    private int f14237m;

    /* renamed from: m0, reason: collision with root package name */
    private Rect f14238m0;

    /* renamed from: n, reason: collision with root package name */
    private int f14239n;

    /* renamed from: n0, reason: collision with root package name */
    private PointF f14240n0;

    /* renamed from: a, reason: collision with root package name */
    private final SurfaceSession f14213a = new SurfaceSession();

    /* renamed from: b, reason: collision with root package name */
    private final SurfaceControl.Transaction f14215b = new SurfaceControl.Transaction();

    /* renamed from: e, reason: collision with root package name */
    private Boolean f14221e = Boolean.FALSE;

    /* renamed from: j, reason: collision with root package name */
    private Rect f14231j = new Rect();

    /* renamed from: k, reason: collision with root package name */
    private int f14233k = 0;

    /* renamed from: o, reason: collision with root package name */
    private int f14241o = 0;

    /* renamed from: p, reason: collision with root package name */
    private int f14243p = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f14244q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f14245r = Color.rgb(49, 49, 49);

    /* renamed from: s, reason: collision with root package name */
    private float f14246s = 24.0f;

    /* renamed from: t, reason: collision with root package name */
    private int[] f14247t = new int[2];

    /* renamed from: u, reason: collision with root package name */
    private boolean f14248u = false;

    /* renamed from: v, reason: collision with root package name */
    private boolean f14249v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f14250w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f14251x = false;

    /* renamed from: y, reason: collision with root package name */
    private PointF f14252y = new PointF();

    /* renamed from: z, reason: collision with root package name */
    private PointF f14253z = new PointF();

    /* renamed from: A, reason: collision with root package name */
    private PointF f14187A = new PointF();

    /* renamed from: B, reason: collision with root package name */
    private Point f14188B = new Point();

    /* renamed from: C, reason: collision with root package name */
    private PointF f14189C = new PointF();

    /* renamed from: G, reason: collision with root package name */
    private float f14193G = 1.0f;

    /* renamed from: H, reason: collision with root package name */
    private float f14194H = 1.0f;

    /* renamed from: I, reason: collision with root package name */
    private float f14195I = 0.0f;

    /* renamed from: J, reason: collision with root package name */
    private float f14196J = 0.0f;

    /* renamed from: a0, reason: collision with root package name */
    private SurfaceControl f14214a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    private SurfaceControl f14216b0 = null;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f14234k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f14236l0 = false;

    /* renamed from: o0, reason: collision with root package name */
    Callable f14242o0 = new c();

    /* renamed from: j0, reason: collision with root package name */
    private OplusActivityManager f14232j0 = new OplusActivityManager();

    /* renamed from: Q, reason: collision with root package name */
    private C0632b f14203Q = new C0632b(this);

    /* renamed from: f0, reason: collision with root package name */
    private Handler f14224f0 = new b();

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ContainerActivity f14254a;

        a(ContainerActivity containerActivity) {
            this.f14254a = containerActivity;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("SplitStageDragPolicy", "##### dimAnimation cancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("SplitStageDragPolicy", "##### dimAnimation over");
            u.this.P0();
            if (u.this.f14222e0 != null) {
                B1.l.p1(u.this.f14222e0.s());
            }
            if (this.f14254a.t0() == 5 || this.f14254a.t0() == 6) {
                this.f14254a.C1();
            } else {
                this.f14254a.L1(true);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (u.this.f14201O.getAlpha() != 1.0f && u.this.f14202P.getAlpha() != 1.0f) {
                u.this.f14201O.setAlpha(1.0f);
                u.this.f14202P.setAlpha(1.0f);
            }
            Log.d("SplitStageDragPolicy", "##### dimAnimation start");
        }
    }

    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            u.this.X0();
        }
    }

    class c implements Callable {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            u uVar = u.this;
            return Boolean.valueOf(uVar.C0(uVar.x0()[0], u.this.x0()[1], u.this.f14208V, B1.l.q0(u.this.f14222e0.k(), u.this.f14222e0.v()), u.this.f14197K.getResources().getConfiguration().uiMode, u.this.f14222e0));
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f14258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Point f14259b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Point f14260c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f14261d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float[] f14262e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ float[] f14263f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ float[] f14264g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ float[] f14265h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Point f14266i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Point f14267j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Rect f14268k;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ Rect f14269l;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Rect f14270m;

        /* renamed from: n, reason: collision with root package name */
        final /* synthetic */ Rect f14271n;

        d(int i3, Point point, Point point2, float f3, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, Point point3, Point point4, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            this.f14258a = i3;
            this.f14259b = point;
            this.f14260c = point2;
            this.f14261d = f3;
            this.f14262e = fArr;
            this.f14263f = fArr2;
            this.f14264g = fArr3;
            this.f14265h = fArr4;
            this.f14266i = point3;
            this.f14267j = point4;
            this.f14268k = rect;
            this.f14269l = rect2;
            this.f14270m = rect3;
            this.f14271n = rect4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i3;
            int i4;
            float f3;
            float f4;
            float f5;
            if (u.this.f14203Q.x() == 0) {
                Log.d("SplitStageDragPolicy", "Animation already over");
                return;
            }
            if (u.this.f14212Z != null && u.this.f14208V != null && u.this.f14201O.getSurfaceControl() != null && u.this.f14208V != null && u.this.f14206T != null) {
                u uVar = u.this;
                if (uVar.G0(uVar.f14214a0)) {
                    u uVar2 = u.this;
                    if (uVar2.G0(uVar2.f14216b0)) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        if (this.f14258a == 4) {
                            if (u.this.f14228h0 != null && u.this.f14228h0.isRunning()) {
                                u.this.f14228h0.end();
                            }
                            u.this.f14215b.setShadowRadius(u.this.f14206T, 40.0f).setMetadata(u.this.f14206T, 200, 1);
                            u.this.f14215b.setAlpha(u.this.f14206T, 1.0f);
                            u.this.f14215b.setAlpha(u.this.f14208V, 1.0f);
                            u.this.f14215b.setAlpha(u.this.f14216b0, 0.0f);
                            if (B1.s.B()) {
                                u.this.f14199M.setAlpha(0.0f);
                            }
                            if (u.this.f14201O.getAlpha() != 0.0f && u.this.f14202P.getAlpha() != 0.0f) {
                                u.this.f14201O.setAlpha(0.0f);
                                u.this.f14202P.setAlpha(0.0f);
                            }
                        }
                        Point point = this.f14259b;
                        int i5 = point.x;
                        Point point2 = this.f14260c;
                        int i6 = point2.x;
                        float f6 = this.f14261d;
                        int i7 = (int) (((i5 - i6) * (floatValue / f6)) + i6);
                        int i8 = point.y;
                        int i9 = (int) (((i8 - r10) * (floatValue / f6)) + point2.y);
                        u.this.f14203Q.S(i7, i9);
                        u.this.f14200N.setX(i7);
                        u.this.f14200N.setY(i9);
                        u.this.l0();
                        float[] fArr = this.f14262e;
                        float f7 = fArr[0];
                        float[] fArr2 = this.f14263f;
                        float f8 = fArr2[0];
                        float f9 = this.f14261d;
                        float f10 = ((f7 - f8) * (floatValue / f9)) + f8;
                        float f11 = fArr[1];
                        float f12 = fArr2[1];
                        float f13 = ((f11 - f12) * (floatValue / f9)) + f12;
                        u.this.f14203Q.P(new float[]{f10, f13});
                        float[] fArr3 = this.f14264g;
                        float f14 = fArr3[0];
                        float[] fArr4 = this.f14265h;
                        float f15 = fArr4[0];
                        float f16 = this.f14261d;
                        float f17 = ((f14 - f15) * (floatValue / f16)) + f15;
                        float f18 = fArr3[1];
                        float f19 = fArr4[1];
                        float f20 = ((f18 - f19) * (floatValue / f16)) + f19;
                        u.this.f14203Q.Q(new float[]{f17, f20});
                        float[] fArr5 = {(1.0f / f10) / u.this.f14193G, (1.0f / f13) / u.this.f14194H};
                        if (this.f14258a != 8 || u.this.f14203Q.w() == 4 || u.this.f14203Q.w() == 3) {
                            if (B1.s.w(u.this.f14197K) && B1.s.B()) {
                                i3 = (int) (u.this.f14223f.left + (u.this.f14203Q.A().x - u.this.f14240n0.x));
                                i4 = (int) (u.this.f14223f.top + (u.this.f14203Q.A().y - u.this.f14240n0.y));
                            } else {
                                int s02 = u.this.s0();
                                int t02 = u.this.t0();
                                i3 = ((int) (u.this.f14203Q.A().x - (u.this.f14252y.x * f10))) - s02;
                                i4 = ((int) (u.this.f14203Q.A().y - (u.this.f14252y.y * f13))) - t02;
                                u.this.f14203Q.O(i3, i4);
                            }
                            float width = (0.5f - (f10 * 0.5f)) * u.this.f14199M.getWidth();
                            float height = (0.5f - (f13 * 0.5f)) * u.this.f14199M.getHeight();
                            if (!Arrays.equals(this.f14262e, this.f14263f)) {
                                u.this.f14199M.setScaleX(f10);
                                u.this.f14199M.setScaleY(f13);
                            }
                            if (!Arrays.equals(this.f14264g, this.f14265h)) {
                                u.this.f14200N.setScaleX(f17);
                                u.this.f14200N.setScaleY(f20);
                            }
                            if (B1.s.w(u.this.f14197K) && B1.s.B()) {
                                f3 = ((i3 - u.this.f14188B.x) / u.this.f14193G) - width;
                                f4 = i4 - u.this.f14188B.y;
                                f5 = u.this.f14194H;
                            } else {
                                f3 = ((i3 + u.this.f14241o) / u.this.f14193G) - width;
                                f4 = i4 + u.this.f14243p;
                                f5 = u.this.f14194H;
                            }
                            float f21 = (f4 / f5) - height;
                            if (this.f14258a == 4 || u.this.f14203Q.w() == 3) {
                                u.this.f14199M.setX(f3);
                                u.this.f14199M.setY(f21);
                            } else {
                                u.this.f14199M.setTranslationX(u.this.f14199M.getTranslationX() + ((u.this.f14203Q.A().x - u.this.f14189C.x) / u.this.f14193G));
                                u.this.f14199M.setTranslationY(u.this.f14199M.getTranslationY() + ((u.this.f14203Q.A().y - u.this.f14189C.y) / u.this.f14194H));
                            }
                        } else {
                            Point point3 = this.f14266i;
                            int i10 = point3.x;
                            Point point4 = this.f14267j;
                            int i11 = point4.x;
                            float f22 = this.f14261d;
                            int i12 = (int) (((i10 - i11) * (floatValue / f22)) + i11);
                            int i13 = point3.y;
                            int i14 = (int) (((i13 - r11) * (floatValue / f22)) + point4.y);
                            if (B1.s.w(u.this.f14197K) && B1.s.B()) {
                                u.this.f14199M.setX((i12 - u.this.f14188B.x) / u.this.f14193G);
                                u.this.f14199M.setY((i14 - u.this.f14188B.y) / u.this.f14194H);
                            } else {
                                u.this.f14203Q.O(i12, i14);
                                u.this.f14199M.setX(((i12 - u.this.f14188B.x) / u.this.f14193G) - ((0.5f - (f10 * 0.5f)) * u.this.f14199M.getWidth()));
                                u.this.f14199M.setY(((i14 - u.this.f14188B.y) / u.this.f14194H) - ((0.5f - (f13 * 0.5f)) * u.this.f14199M.getHeight()));
                            }
                        }
                        Rect rect = this.f14268k;
                        int i15 = rect.left;
                        Rect rect2 = this.f14269l;
                        int i16 = rect2.left;
                        float f23 = this.f14261d;
                        int i17 = (int) (((i15 - i16) * (floatValue / f23)) + i16);
                        int i18 = rect.top;
                        int i19 = (int) (((i18 - r9) * (floatValue / f23)) + rect2.top);
                        int i20 = rect.right;
                        int i21 = rect2.right;
                        int i22 = rect.bottom;
                        u.this.f14203Q.N(i17, i19, (int) (((i20 - i21) * (floatValue / f23)) + i21), (int) (((i22 - r3) * (floatValue / f23)) + rect2.bottom));
                        Rect y3 = u.this.f14203Q.y();
                        int i23 = (int) ((u.this.f14235l * fArr5[0]) / 2.0f);
                        int i24 = (int) ((u.this.f14237m * fArr5[1]) / 2.0f);
                        int i25 = ((y3.left + y3.right) / 2) - i23;
                        int i26 = ((y3.top + y3.bottom) / 2) - i24;
                        u uVar3 = u.this;
                        if (uVar3.G0(uVar3.f14206T)) {
                            u uVar4 = u.this;
                            if (uVar4.G0(uVar4.f14201O.getSurfaceControl())) {
                                u.this.f14215b.setMatrix(u.this.f14206T, fArr5[0], 0.0f, 0.0f, fArr5[1]).setWindowCrop(u.this.f14201O.getSurfaceControl(), y3).setPosition(u.this.f14206T, i25, i26);
                                Rect rect3 = this.f14270m;
                                int i27 = rect3.left;
                                Rect rect4 = this.f14271n;
                                int i28 = rect4.left;
                                float f24 = this.f14261d;
                                int i29 = (int) (((i27 - i28) * (floatValue / f24)) + i28);
                                int i30 = rect3.top;
                                int i31 = (int) (((i30 - r7) * (floatValue / f24)) + rect4.top);
                                int i32 = rect3.right;
                                int i33 = (int) (((i32 - r9) * (floatValue / f24)) + rect4.right);
                                int i34 = rect3.bottom;
                                int i35 = (int) (((i34 - r3) * (floatValue / f24)) + rect4.bottom);
                                u.this.f14203Q.R(i29, i31, i33, i35);
                                int i36 = ((u.this.f14203Q.B().left + u.this.f14203Q.B().right) - u.this.x0()[0]) / 2;
                                int i37 = ((u.this.f14203Q.B().top + u.this.f14203Q.B().bottom) - u.this.x0()[1]) / 2;
                                int i38 = this.f14258a;
                                if ((i38 == 2 || i38 == 6) && ((u.this.f14203Q.w() == 3 || u.this.f14203Q.w() == 4) && u.this.f14229i.height() < u.this.f14225g.height() / 2 && u.this.f14225g.height() > u.this.f14237m / 2)) {
                                    i37 = 0;
                                }
                                u.this.f14215b.setWindowCrop(u.this.f14212Z, u.this.f14203Q.B()).setWindowCrop(u.this.f14208V, new Rect(i29, i31, i33 - i36, i35 - i37)).setPosition(u.this.f14208V, i36, i37);
                                u.this.f14215b.apply();
                                return;
                            }
                        }
                        Log.w("SplitStageDragPolicy", "onAnimationUpdate: SurfaceControl is not valid, so return");
                        return;
                    }
                }
            }
            Log.w("SplitStageDragPolicy", "Animation leash null ");
        }
    }

    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f14273a;

        e(int i3) {
            this.f14273a = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("SplitStageDragPolicy", "### transferAnimation Cancel:" + this.f14273a);
            u.this.f14248u = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("SplitStageDragPolicy", "[transferAnimation] onAnimationEnd state:" + this.f14273a + " currentAnimationState:" + u.this.f14203Q.x() + " state before up:" + u.this.f14203Q.w() + " cancleCurrentAnimation:" + u.this.f14248u);
            B1.l.t1(u.this.f14201O.getSurfaceControl(), 20109, false);
            if (u.this.f14208V != null && u.this.f14206T != null) {
                u uVar = u.this;
                if (uVar.G0(uVar.f14214a0)) {
                    u uVar2 = u.this;
                    if (uVar2.G0(uVar2.f14216b0)) {
                        if (u.this.f14200N.getVisibility() == 4) {
                            u.this.f14200N.setVisibility(0);
                        }
                        int i3 = this.f14273a;
                        if (i3 == 4 || i3 == 3) {
                            u.this.f14215b.setAlpha(u.this.f14207U, 1.0f).apply();
                        }
                        u.this.f14215b.setAlpha(u.this.f14216b0, 1.0f).apply();
                        if (u.this.f14248u) {
                            return;
                        }
                        int i4 = this.f14273a;
                        if (i4 == 8) {
                            if (u.this.f14203Q.w() == 2 || u.this.f14203Q.w() == 6) {
                                if (u.this.f14228h0 != null && u.this.f14228h0.isRunning()) {
                                    u.this.f14228h0.end();
                                }
                                if (u.this.f14201O.getAlpha() != 1.0f) {
                                    u.this.V0();
                                }
                            } else if (u.this.f14203Q.I()) {
                                if (u.this.f14201O.getAlpha() != 1.0f && u.this.f14202P.getAlpha() != 1.0f) {
                                    u.this.f14201O.setAlpha(1.0f);
                                    u.this.f14202P.setAlpha(1.0f);
                                }
                                u.this.f14215b.setAlpha(u.this.f14214a0, 1.0f);
                                u.this.f14215b.setAlpha(u.this.f14206T, 0.0f).setAlpha(u.this.f14208V, 0.0f).apply();
                            }
                            u.this.q0();
                            return;
                        }
                        if (i4 == 2 || i4 == 6) {
                            if (u.this.f14203Q.w() == 3 || u.this.f14203Q.w() == 4) {
                                if (u.this.f14228h0 != null && u.this.f14228h0.isRunning()) {
                                    u.this.f14228h0.end();
                                }
                                u.this.V0();
                            } else {
                                if (u.this.f14201O.getAlpha() != 1.0f && u.this.f14202P.getAlpha() != 1.0f) {
                                    u.this.f14201O.setAlpha(1.0f);
                                    u.this.f14202P.setAlpha(1.0f);
                                }
                                u.this.f14215b.setAlpha(u.this.f14206T, 0.0f).setAlpha(u.this.f14208V, 0.0f).setAlpha(u.this.f14214a0, 1.0f).apply();
                            }
                        }
                        if (this.f14273a == 4 && u.this.f14203Q.x() == 7) {
                            u.this.q0();
                            return;
                        } else {
                            u.this.f14203Q.M(this.f14273a - 1);
                            return;
                        }
                    }
                }
            }
            Log.d("SplitStageDragPolicy", "onAnimationEnd Animation leash null ");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("SplitStageDragPolicy", "[transferAnimation] onAnimationStart state:" + this.f14273a + " currentDragSurfaceState:" + u.this.f14203Q.x());
            B1.l.t1(u.this.f14201O.getSurfaceControl(), 20109, true);
            int x3 = u.this.f14203Q.x();
            C0632b unused = u.this.f14203Q;
            if (x3 == 0) {
                onAnimationCancel(null);
            }
            if (this.f14273a == 8) {
                u.this.f14203Q.c0(this.f14273a);
                if (u.this.f14203Q.w() == 1 || u.this.f14203Q.w() == 2 || u.this.f14203Q.w() == 5 || u.this.f14203Q.w() == 6) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("androidx.activity.canvasDragZoomAnimationEvent", 2207);
                    B1.l.f(bundle);
                }
            }
            u.this.f14215b.setAlpha(u.this.f14207U, 0.0f).apply();
            int i3 = this.f14273a;
            if ((i3 == 2 || i3 == 6) && (u.this.f14203Q.w() == 3 || u.this.f14203Q.w() == 4)) {
                u.this.f14200N.setVisibility(4);
            }
            if (this.f14273a == 4) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("androidx.activity.canvasDragZoomAnimationEvent", 2206);
                B1.l.f(bundle2);
            }
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f14275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Rect f14276b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Rect f14277c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f14278d;

        f(Rect rect, Rect rect2, Rect rect3, int i3) {
            this.f14275a = rect;
            this.f14276b = rect2;
            this.f14277c = rect3;
            this.f14278d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            Rect rect = this.f14275a;
            int i3 = rect.left;
            Rect rect2 = this.f14276b;
            int i4 = (int) (((i3 - r4) * floatValue) + rect2.left);
            int i5 = rect.top;
            int i6 = (int) (((i5 - r5) * floatValue) + rect2.top);
            int i7 = rect.right;
            int i8 = (int) (((i7 - r6) * floatValue) + rect2.right);
            int i9 = rect.bottom;
            int i10 = (int) (((i9 - r3) * floatValue) + rect2.bottom);
            this.f14277c.set(i4, i6, i8, i10);
            int i11 = (int) ((((i8 - i4) / 2.0f) + i4) - (((u.this.f14235l / u.this.f14203Q.z()[0]) / u.this.f14193G) / 2.0f));
            int i12 = (int) ((((this.f14276b.top + (this.f14278d * floatValue)) + i10) / 2.0f) - (((u.this.f14237m / u.this.f14203Q.z()[1]) / u.this.f14194H) / 2.0f));
            if (u.f14185p0.booleanValue()) {
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue2 == 0.0f || Math.abs(floatValue2 - 0.5f) < 0.02f || floatValue2 == 1.0f) {
                    Log.d("SplitStageDragPolicy", "[cropAnimFrame] p=" + floatValue2 + " changeVisibleCrop=" + this.f14277c + " dragDim=(" + i11 + "," + i12 + ") applyTo taskLeash=" + u.this.f14214a0 + " viewSC=" + u.this.f14201O.getSurfaceControl());
                }
            }
            u uVar = u.this;
            if (uVar.G0(uVar.f14214a0)) {
                u uVar2 = u.this;
                if (uVar2.G0(uVar2.f14206T)) {
                    u uVar3 = u.this;
                    if (uVar3.G0(uVar3.f14201O.getSurfaceControl())) {
                        int p3 = (int) B1.l.p(floatValue, u.this.f14191E * u.this.f14190D, u.this.f14192F);
                        u.this.f14215b.setWindowCrop(u.this.f14214a0, this.f14277c).setWindowCrop(u.this.f14201O.getSurfaceControl(), this.f14277c).setPosition(u.this.f14206T, i11, i12);
                        B1.l.x1(u.this.f14215b, u.this.f14206T, p3).apply();
                    }
                }
            }
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Rect f14280a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Rect f14281b;

        g(Rect rect, Rect rect2) {
            this.f14280a = rect;
            this.f14281b = rect2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("SplitStageDragPolicy", "##### cropAnimation cancel");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Log.d("SplitStageDragPolicy", "##### cropAnimation over");
            B1.l.t1(u.this.f14201O.getSurfaceControl(), 20109, false);
            u uVar = u.this;
            uVar.a1(uVar.f14220d0.s(), this.f14280a, u.this.f14190D);
            if (u.f14185p0.booleanValue()) {
                Log.d("SplitStageDragPolicy", "[cropAnimEnd] finalZoomCrop(passToZoom)=" + this.f14280a + " zoomScale=" + u.this.f14190D + " lastAppliedCrop=" + this.f14281b);
            }
            Message obtainMessage = u.this.f14224f0.obtainMessage();
            obtainMessage.what = 0;
            Handler handler = u.this.f14224f0;
            u uVar2 = u.this;
            handler.sendMessageDelayed(obtainMessage, uVar2.u0(uVar2.f14220d0.k()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Log.d("SplitStageDragPolicy", "##### cropAnimation start");
            B1.l.t1(u.this.f14201O.getSurfaceControl(), 20109, true);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (u.this.f14214a0 == null || u.this.f14206T == null || !u.this.f14206T.isValid()) {
                return;
            }
            float f3 = floatValue * 1.0f;
            u.this.f14215b.setAlpha(u.this.f14206T, f3).setAlpha(u.this.f14208V, f3).apply();
        }
    }

    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Log.d("SplitStageDragPolicy", "##### alphaAnimation cancel");
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        
            if (r3 != 6) goto L14;
         */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onAnimationEnd(android.animation.Animator r3) {
            /*
                r2 = this;
                x1.u r3 = x1.u.this
                boolean r3 = x1.u.r(r3)
                if (r3 == 0) goto L2b
                x1.u r3 = x1.u.this
                x1.b r3 = x1.u.m(r3)
                int r3 = r3.w()
                r0 = 1
                if (r3 == r0) goto L1f
                r1 = 2
                if (r3 != r1) goto L19
                goto L1f
            L19:
                r0 = 5
                if (r3 == r0) goto L1f
                r1 = 6
                if (r3 != r1) goto L20
            L1f:
                r3 = r0
            L20:
                x1.u r0 = x1.u.this
                x1.u.f0(r0, r3)
                x1.u r2 = x1.u.this
                r3 = 0
                x1.u.V(r2, r3)
            L2b:
                java.lang.String r2 = "SplitStageDragPolicy"
                java.lang.String r3 = "##### alphaAnimation over"
                android.util.Log.d(r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: x1.u.i.onAnimationEnd(android.animation.Animator):void");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (u.this.f14201O.getAlpha() != 1.0f && u.this.f14202P.getAlpha() != 1.0f) {
                u.this.f14201O.setAlpha(1.0f);
                u.this.f14202P.setAlpha(1.0f);
            }
            u.this.f14215b.setAlpha(u.this.f14214a0, 1.0f).apply();
            Log.d("SplitStageDragPolicy", "##### alphaAnimation start");
        }
    }

    class j implements ValueAnimator.AnimatorUpdateListener {
        j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (u.this.f14206T == null || !u.this.f14206T.isValid()) {
                return;
            }
            u.this.f14215b.setAlpha(u.this.f14206T, 1.0f - floatValue).setShadowRadius(u.this.f14206T, 40.0f - (floatValue * 40.0f)).apply();
        }
    }

    public u(Context context) {
        this.f14197K = context;
    }

    private void B0(C0631a c0631a) {
        int G02 = B1.l.O1(this.f14197K).G0();
        if (!B1.s.w(this.f14197K)) {
            Rect rect = new Rect(this.f14225g);
            if (rect.top == G02) {
                rect.top = 0;
            }
            c0631a.l(this.f14223f, rect, this.f14198L.j1());
            return;
        }
        Rect maxBounds = this.f14197K.getResources().getConfiguration().windowConfiguration.getMaxBounds();
        if (!this.f14198L.m1()) {
            int width = (int) (maxBounds.width() * 0.4f);
            Rect rect2 = new Rect(0, 0, width, maxBounds.bottom);
            Rect rect3 = new Rect(rect2.right, 0, width + ((int) (maxBounds.width() * 0.2f)), maxBounds.bottom);
            Rect rect4 = new Rect(rect3.right, 0, maxBounds.right, maxBounds.bottom);
            if (this.f14223f.left > this.f14225g.right) {
                c0631a.i(rect4, rect2, rect3);
                return;
            } else {
                c0631a.i(rect2, rect4, rect3);
                return;
            }
        }
        float height = maxBounds.height() - G02;
        Rect rect5 = new Rect(0, 0, maxBounds.right, G02 + ((int) (0.4f * height)));
        int i3 = rect5.bottom;
        Rect rect6 = new Rect(0, i3, maxBounds.right, ((int) (height * 0.2f)) + i3);
        Rect rect7 = new Rect(0, rect6.bottom, maxBounds.right, maxBounds.bottom);
        if (this.f14223f.top < this.f14225g.bottom) {
            c0631a.i(rect5, rect7, rect6);
        } else {
            c0631a.i(rect7, rect5, rect6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C0(int i3, int i4, SurfaceControl surfaceControl, String str, int i5, C0601d c0601d) {
        SurfaceControl.Transaction transaction = new SurfaceControl.Transaction();
        Bitmap O3 = B1.l.O(this.f14197K, str);
        if (O3 == null) {
            Log.e("SplitStageDragPolicy", " initIconDimSurface iconBitmap is null,  packageName: " + str);
            return false;
        }
        ContainerView containerView = this.f14198L;
        Bitmap w02 = containerView.w0(containerView.getAdapter().getPosition(c0601d), new Rect(0, 0, 300, 300));
        if (w02 == null) {
            Log.e("SplitStageDragPolicy", " initIconDimSurface curTaskSnapShot is null  packageName: " + str);
            return false;
        }
        Bitmap W3 = B1.l.W(w02, 25);
        Picture picture = new Picture();
        Canvas beginRecording = picture.beginRecording(i3, i4);
        if (W3 != null) {
            Matrix matrix = new Matrix();
            matrix.postScale(i3 / W3.getWidth(), i4 / W3.getHeight());
            beginRecording.drawBitmap(W3, matrix, null);
            W3.recycle();
            w02.recycle();
        } else if ((i5 & 32) != 0) {
            beginRecording.drawColor(Color.parseColor("#333333"));
        } else {
            beginRecording.drawColor(Color.parseColor("#F0F1F2"));
        }
        int width = O3.getWidth();
        O3.getHeight();
        beginRecording.drawBitmap(O3, (i3 - width) / 2.0f, (i4 - this.f14244q) / 2.0f, (Paint) null);
        O3.recycle();
        picture.endRecording();
        HardwareBuffer hardwareBuffer = Bitmap.createBitmap(picture).getHardwareBuffer();
        if (surfaceControl == null || !surfaceControl.isValid()) {
            return false;
        }
        transaction.setBuffer(surfaceControl, hardwareBuffer);
        transaction.setColorSpace(surfaceControl, ColorSpace.get(ColorSpace.Named.SRGB));
        transaction.setAlpha(surfaceControl, 0.0f);
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
        }
        transaction.apply();
        return true;
    }

    private void D0(SurfaceControl.Transaction transaction) {
        if (this.f14218c0 != null || this.f14199M.N()) {
            return;
        }
        this.f14218c0 = new SurfaceControl.Builder(this.f14213a).setName("Background for MotionView").setLocalOwnerView(this.f14201O).setOpaque(true).setColorLayer().setParent(this.f14201O.getSurfaceControl()).setCallsite("initMotionViewBackground").build();
        transaction.setColor(this.f14218c0, new float[]{Color.red(this.f14245r) / 255.0f, Color.green(this.f14245r) / 255.0f, Color.blue(this.f14245r) / 255.0f}).show(this.f14218c0);
    }

    private boolean E0() {
        if ((this.f14206T != null && this.f14208V != null) || !m0(this.f14215b)) {
            return false;
        }
        k0(this.f14215b, this.f14206T, this.f14223f, this.f14235l, this.f14237m);
        k0(this.f14215b, this.f14208V, this.f14225g, this.f14235l, this.f14237m);
        this.f14198L.setSplitBarVisibility(4);
        D0(this.f14215b);
        this.f14215b.apply();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean G0(SurfaceControl surfaceControl) {
        return surfaceControl != null && surfaceControl.isValid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0() {
        B1.l.h1(this.f14220d0.s(), 2205, null);
    }

    private void M0() {
        int width = (int) (((int) (this.f14196J + (((this.f14199M.getWidth() * this.f14193G) * this.f14203Q.z()[0]) / 2.0f))) - ((this.f14219d.width() / 2) * this.f14190D));
        int i3 = (int) this.f14195I;
        Rect rect = new Rect(this.f14219d);
        rect.offsetTo(width, i3);
        Log.d("SplitStageDragPolicy", "### OnFoldDevice zoomInfo zoomCrop: " + rect + " zoomScale: " + this.f14190D);
        int width2 = (int) (((float) rect.width()) / this.f14193G);
        int height = (int) (((float) rect.height()) / this.f14194H);
        int i4 = ((rect.left + rect.right) - width2) / 2;
        int i5 = ((rect.top + rect.bottom) - height) / 2;
        Rect rect2 = new Rect(i4, i5, width2 + i4, height + i5);
        new Rect();
        Rect y3 = this.f14203Q.y();
        int width3 = (int) (y3.width() / this.f14193G);
        int height2 = (int) (y3.height() / this.f14194H);
        int i6 = y3.top;
        int i7 = ((y3.left + y3.right) / 2) - (width3 / 2);
        Rect rect3 = new Rect(i7, i6, width3 + i7, height2 + i6);
        if (f14185p0.booleanValue()) {
            Log.d("SplitStageDragPolicy", "[cropPrep] mVisible=(" + this.f14196J + "," + this.f14195I + ") motionViewWH=(" + this.f14199M.getWidth() + "," + this.f14199M.getHeight() + ") rootScale=(" + this.f14193G + "," + this.f14194H + ") dragScale=" + Arrays.toString(this.f14203Q.z()) + " zoomRect=" + this.f14219d + " scaleZoomCrop=" + rect2 + " currentDragBounds=" + this.f14203Q.y() + " visibleCrop=" + rect3);
        }
        j0(rect3, rect, this.f14190D);
        W0(rect3, rect, rect2);
    }

    private void N0(C0631a c0631a) {
        this.f14252y.x = c0631a.f().x - this.f14223f.left;
        this.f14252y.y = c0631a.f().y - this.f14223f.top;
    }

    private void O0(SurfaceControl surfaceControl) {
        if (surfaceControl == null || !surfaceControl.isValid()) {
            return;
        }
        this.f14215b.remove(surfaceControl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        O0(this.f14206T);
        this.f14215b.apply();
    }

    private void Q0() {
        if (this.f14198L.getAdapter().l().size() == 2) {
            B1.h.a(this.f14197K.getApplicationContext()).e("drag_to_zoom");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(int i3) {
        ValueAnimator valueAnimator = this.f14228h0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f14236l0 = true;
            return;
        }
        if (i3 == 3) {
            SurfaceControl surfaceControl = this.f14206T;
            if (surfaceControl != null && surfaceControl.isValid()) {
                this.f14215b.setAlpha(this.f14206T, 0.0f).apply();
            }
            SurfaceControl surfaceControl2 = this.f14208V;
            if (surfaceControl2 != null && surfaceControl2.isValid()) {
                this.f14215b.setAlpha(this.f14208V, 0.0f).apply();
            }
        }
        if (this.f14201O.getAlpha() != 1.0f && this.f14202P.getAlpha() != 1.0f) {
            this.f14201O.setAlpha(1.0f);
            this.f14202P.setAlpha(1.0f);
        }
        if (b1(this.f14197K) instanceof ContainerActivity) {
            ((ContainerActivity) b1(this.f14197K)).p0();
        }
        U0();
        if (i3 == 1) {
            this.f14199M.setTranslationX(0.0f);
            this.f14199M.setTranslationY(0.0f);
            this.f14199M.setScaleX(1.0f);
            this.f14199M.setScaleY(1.0f);
            this.f14200N.setTranslationX(0.0f);
            this.f14200N.setTranslationY(0.0f);
            this.f14198L.setSplitBarVisibility(0);
        } else if (i3 == 5) {
            this.f14199M.setScaleX(1.0f);
            this.f14199M.setScaleY(1.0f);
            this.f14198L.setSplitBarVisibility(0);
        }
        this.f14250w = false;
        this.f14203Q.M(0);
        Rect rect = new Rect(this.f14203Q.y());
        rect.inset(-1, -1);
        S0(this.f14201O.getSurfaceControl(), rect);
        T0(this.f14202P.getSurfaceControl());
        Log.d("SplitStageDragPolicy", "resetDragAnimation state: " + i3 + ", resetCrop: " + rect);
    }

    private void S0(SurfaceControl surfaceControl, Rect rect) {
        if (G0(surfaceControl)) {
            this.f14215b.setCornerRadius(surfaceControl, 0.0f).setWindowCrop(surfaceControl, rect).apply();
        }
    }

    private void T0(SurfaceControl surfaceControl) {
        if (G0(surfaceControl)) {
            this.f14215b.setCornerRadius(surfaceControl, 0.0f).apply();
        }
    }

    private void U0() {
        O0(this.f14206T);
        O0(this.f14208V);
        O0(this.f14212Z);
        O0(this.f14218c0);
        this.f14201O.surfaceReplaced(this.f14215b);
        this.f14202P.surfaceReplaced(this.f14215b);
        this.f14233k = 0;
        this.f14206T = null;
        this.f14208V = null;
        this.f14212Z = null;
        this.f14211Y = null;
        this.f14210X = null;
        this.f14209W = null;
        this.f14214a0 = null;
        this.f14216b0 = null;
        this.f14218c0 = null;
        this.f14215b.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0118  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void W0(android.graphics.Rect r19, android.graphics.Rect r20, android.graphics.Rect r21) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.u.W0(android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        int width = this.f14217c.width();
        int height = this.f14217c.height();
        float f3 = this.f14235l;
        float f4 = this.f14190D;
        int i3 = (int) ((width - (f3 / f4)) / 2.0f);
        int i4 = (int) ((height - (this.f14237m / f4)) / 2.0f);
        SurfaceControl surfaceControl = this.f14214a0;
        if (surfaceControl != null && surfaceControl.isValid()) {
            SurfaceControl.Transaction position = this.f14215b.setMetadata(this.f14206T, 101, 1).reparent(this.f14206T, this.f14214a0).setAlpha(this.f14214a0, B1.l.R(this.f14201O)).setPosition(this.f14206T, i3, i4);
            SurfaceControl surfaceControl2 = this.f14206T;
            float f5 = this.f14190D;
            position.setMatrix(surfaceControl2, 1.0f / f5, 0.0f, 0.0f, 1.0f / f5).apply();
        }
        C0305a.a().b(new Runnable() { // from class: x1.t
            @Override // java.lang.Runnable
            public final void run() {
                u.this.H0();
            }
        });
        this.f14198L.getContainerController().A(-1);
        ContainerActivity containerActivity = (ContainerActivity) b1(this.f14197K);
        p0(containerActivity);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new j());
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new Y.e());
        ofFloat.addListener(new a(containerActivity));
        ofFloat.start();
    }

    private void Y0() {
        this.f14248u = false;
        ValueAnimator clone = this.f14205S.clone();
        this.f14204R = clone;
        this.f14205S = null;
        clone.start();
    }

    private void Z0() {
        ContainerActivity containerActivity = (ContainerActivity) b1(this.f14197K);
        if (containerActivity != null) {
            containerActivity.Q1();
            C0601d x02 = containerActivity.x0(0);
            if (x02 == null || x02.s() != this.f14220d0.s()) {
                containerActivity.U1(0, false);
            } else {
                containerActivity.U1(1, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(int i3, Rect rect, float f3) {
        if (G0(this.f14214a0)) {
            this.f14215b.setAlpha(this.f14214a0, 0.0f).apply();
        }
        Log.d("SplitStageDragPolicy", " switchToZoom  taskId: " + i3);
        B1.l.g(i3, rect, f3);
        this.f14217c = rect;
    }

    private Activity b1(Context context) {
        while (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return (Activity) context;
    }

    private void c1(int i3) {
        s.a(this.f14197K, i3, true);
    }

    private void j0(Rect rect, Rect rect2, float f3) {
        if (G0(this.f14214a0) && G0(this.f14206T) && G0(this.f14201O.getSurfaceControl())) {
            this.f14215b.setPosition(this.f14214a0, rect2.left, rect2.top).setMatrix(this.f14214a0, 1.0f, 0.0f, 0.0f, 1.0f).setWindowCrop(this.f14214a0, rect).apply();
        } else {
            Log.d("SplitStageDragPolicy", "##### child surface is invalid");
            R0(3);
        }
    }

    private void k0(SurfaceControl.Transaction transaction, SurfaceControl surfaceControl, Rect rect, int i3, int i4) {
        transaction.setPosition(surfaceControl, (rect.width() - i3) / 2, (rect.height() - i4) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.f14215b.setPosition(this.f14212Z, this.f14200N.getLocationOnScreen()[0], this.f14200N.getLocationOnScreen()[1]);
    }

    private boolean m0(SurfaceControl.Transaction transaction) {
        this.f14209W = r0(transaction);
        this.f14210X = this.f14201O.getSurfaceControl();
        this.f14211Y = this.f14202P.getSurfaceControl();
        if (this.f14214a0 == null) {
            this.f14214a0 = v0(this.f14201O);
        }
        if (this.f14216b0 == null) {
            this.f14216b0 = v0(this.f14202P);
        }
        this.f14212Z = new SurfaceControl.Builder(this.f14213a).setContainerLayer().setParent(this.f14209W).setName("NoMotionTotalLeash").setCallsite("createNoMotionTotalLeash").setHidden(false).build();
        this.f14206T = new SurfaceControl.Builder(this.f14213a).setParent(this.f14201O.getSurfaceControl()).setBufferSize(this.f14235l, this.f14237m).setFormat(2).setName("MotionLeash").setCallsite("createMotionLeash").setHidden(false).build();
        int[] iArr = new int[2];
        this.f14207U = B1.l.w(this.f14197K, "MotionText", transaction, this.f14197K.getString(t1.j.f13637f), iArr, this.f14199M.getLightMode() == 0 ? Color.parseColor("#FFF0F8F5") : Color.parseColor("#FF191919"), this.f14238m0.width());
        int i3 = iArr[0];
        int i4 = iArr[1];
        int i5 = (int) (this.f14197K.getResources().getDisplayMetrics().density * 64.0f);
        int i6 = (int) (this.f14197K.getResources().getDisplayMetrics().density * 12.0f);
        int i7 = i4 + i5 + i6;
        this.f14244q = i7;
        int i8 = (this.f14235l - i3) / 2;
        int i9 = ((this.f14237m - i7) / 2) + i5 + i6;
        this.f14192F = this.f14197K.getResources().getDisplayMetrics().density * 12.0f;
        if (G0(this.f14206T) && G0(this.f14201O.getSurfaceControl()) && G0(this.f14214a0) && G0(this.f14212Z) && G0(this.f14211Y) && G0(this.f14207U)) {
            transaction.setLayer(this.f14206T, 2147483646).setLayer(this.f14207U, Preference.DEFAULT_ORDER).reparent(this.f14207U, this.f14206T).setPosition(this.f14207U, i8, i9).setLayer(this.f14201O.getSurfaceControl(), 1).setCornerRadius(this.f14206T, this.f14192F).setCornerRadius(this.f14201O.getSurfaceControl(), this.f14192F).setAlpha(this.f14206T, 0.0f).setAlpha(this.f14207U, 0.0f).show(this.f14207U).setShadowRadius(this.f14206T, 40.0f).setMetadata(this.f14206T, 200, 1);
            this.f14208V = new SurfaceControl.Builder(this.f14213a).setParent(this.f14212Z).setBufferSize(x0()[0], x0()[1]).setFormat(2).setName("NoMotionLeash").setCallsite("createNoMotionLeash").setHidden(false).build();
            Future d3 = C0305a.a().d(this.f14242o0);
            boolean C02 = C0(this.f14235l, this.f14237m, this.f14206T, B1.l.q0(this.f14220d0.k(), this.f14220d0.v()), this.f14197K.getResources().getConfiguration().uiMode, this.f14220d0);
            try {
                boolean booleanValue = ((Boolean) d3.get()).booleanValue();
                if (C02 && booleanValue) {
                    transaction.setPosition(this.f14212Z, this.f14222e0.n().left, this.f14222e0.n().top).setWindowCrop(this.f14212Z, this.f14222e0.n().width(), this.f14222e0.n().height()).setCornerRadius(this.f14212Z, n0(this.f14197K, 12.0f)).setCornerRadius(this.f14211Y, n0(this.f14197K, 12.0f)).setAlpha(this.f14208V, 0.0f);
                    if (!B1.s.B()) {
                        transaction.setLayer(this.f14211Y, 1);
                    }
                    transaction.setLayer(this.f14212Z, 2).setLayer(this.f14210X, 3);
                    return true;
                }
                Log.e("SplitStageDragPolicy", "init dim failed..  initMotionDim: " + C02 + " initNoMotionDim: " + booleanValue);
                return false;
            } catch (InterruptedException | ExecutionException e3) {
                Log.e("SplitStageDragPolicy", "init no motion dim thread execute failed.. " + e3);
                d3.cancel(true);
            }
        }
        return false;
    }

    public static int n0(Context context, float f3) {
        return Math.round(f3 * context.getResources().getDisplayMetrics().density);
    }

    private void o0() {
        Log.d("SplitStageDragPolicy", "exchangeTwoTaskView ");
        this.f14198L.F2();
    }

    private void p0(Activity activity) {
        activity.finish();
        Log.d("SplitStageDragPolicy", "exit canvas activity finish");
        activity.overridePendingTransition(0, AbstractC0587a.f13360b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        switch (this.f14203Q.w()) {
            case 0:
            case 1:
            case 2:
                Log.d("SplitStageDragPolicy", "### finishAnimationUnCheck NORMAL_STATE");
                this.f14203Q.M(1);
                R0(1);
                break;
            case 3:
            case 4:
                Log.d("SplitStageDragPolicy", "### finishAnimationUnCheck ZOOM_STATE");
                Q0();
                ContainerView containerView = this.f14198L;
                int taskId = b1(this.f14197K).getTaskId();
                C0601d c0601d = this.f14220d0;
                int s3 = c0601d != null ? c0601d.s() : -1;
                C0601d c0601d2 = this.f14222e0;
                containerView.C2(taskId, s3, c0601d2 != null ? c0601d2.s() : -1, true, true);
                this.f14199M.setControlBarVisibility(4);
                Z0();
                Bundle bundle = new Bundle();
                bundle.putInt("androidx.activity.canvasDragZoomAnimationEvent", 2208);
                B1.l.f(bundle);
                M0();
                B1.l.q1();
                break;
            case 5:
            case 6:
                Log.d("SplitStageDragPolicy", "### finishAnimationUnCheck REPLACE_STATE");
                R0(5);
                f(0);
                o0();
                if (B1.l.O1(this.f14197K).S0()) {
                    OplusInputMethodManager.getInstance().hideCurrentInputMethod();
                    break;
                }
                break;
        }
    }

    private SurfaceControl r0(SurfaceControl.Transaction transaction) {
        if (OplusBuild.getOplusOSVERSION() >= 34) {
            return this.f14201O.getViewRootImpl().updateAndGetBoundsLayer(transaction);
        }
        try {
            Object invoke = ViewRootImpl.class.getDeclaredMethod("getBoundsLayer", null).invoke(this.f14201O.getViewRootImpl(), null);
            if (invoke instanceof SurfaceControl) {
                return (SurfaceControl) invoke;
            }
        } catch (IllegalAccessException e3) {
            Log.w("SplitStageDragPolicy", "getBoundsLayer illegal access " + e3);
        } catch (NoSuchMethodException e4) {
            Log.w("SplitStageDragPolicy", "getBoundsLayer no such method " + e4);
        } catch (InvocationTargetException e5) {
            Log.w("SplitStageDragPolicy", "getBoundsLayer invocation target " + e5);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s0() {
        if (this.f14251x) {
            return this.f14223f.left;
        }
        Rect rect = this.f14223f;
        if (rect.right < this.f14225g.left) {
            return rect.left;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t0() {
        if (!this.f14251x) {
            return this.f14223f.top;
        }
        Rect rect = this.f14223f;
        return rect.bottom < this.f14225g.top ? rect.top : B1.l.O1(this.f14197K).G0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long u0(String str) {
        return (B1.d.f168d && f14186q0.contains(str)) ? 800L : 200L;
    }

    private SurfaceControl v0(FlexibleTaskView flexibleTaskView) {
        try {
            Field declaredField = flexibleTaskView.getClass().getDeclaredField("mTaskLeash");
            declaredField.setAccessible(true);
            return (SurfaceControl) declaredField.get(flexibleTaskView);
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private int w0() {
        int height = this.f14198L.getWindowMetricsBounds().height();
        int i3 = this.f14237m;
        if (height == i3) {
            return 0;
        }
        return i3 - height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] x0() {
        return new int[]{(int) Math.max(this.f14235l, this.f14200N.getWidth() * this.f14193G), (int) Math.max(this.f14237m, this.f14200N.getHeight() * this.f14194H)};
    }

    private EmbeddedViewDecor y0() {
        EmbeddedViewDecor q02 = this.f14198L.q0(0);
        return this.f14199M.getTaskData().s() == q02.getTaskData().s() ? this.f14198L.q0(1) : q02;
    }

    public void A0(EmbeddedViewDecor embeddedViewDecor) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        this.f14199M = embeddedViewDecor;
        this.f14198L = (ContainerView) embeddedViewDecor.getParent();
        this.f14200N = y0();
        this.f14199M.getLocationOnScreen(iArr);
        this.f14200N.getLocationOnScreen(iArr2);
        this.f14198L.q0(0).getLocationInWindow(iArr3);
        int i3 = iArr[0];
        this.f14223f = new Rect(i3, iArr[1], this.f14199M.getWidth() + i3, iArr[1] + this.f14199M.getHeight());
        int i4 = iArr2[0];
        this.f14225g = new Rect(i4, iArr2[1], this.f14200N.getWidth() + i4, iArr2[1] + this.f14200N.getHeight());
        this.f14188B = new Point(iArr3[0], iArr3[1]);
        this.f14226g0 = new Point(this.f14200N.getLeft(), this.f14200N.getTop());
        this.f14201O = this.f14199M.getFlexibleTaskView();
        this.f14202P = this.f14200N.getFlexibleTaskView();
        this.f14220d0 = this.f14199M.getTaskData();
        this.f14222e0 = this.f14200N.getTaskData();
        this.f14231j.set(this.f14223f);
        this.f14231j.offsetTo(0, 0);
        this.f14203Q.J(this.f14188B);
        this.f14203Q.T(this.f14198L.getContainerController().n());
        ContainerActivity containerActivity = (ContainerActivity) b1(this.f14197K);
        if (containerActivity != null) {
            this.f14203Q.X(containerActivity.F0());
            this.f14193G = containerActivity.F0().getScaleX();
            this.f14194H = containerActivity.F0().getScaleY();
        }
        this.f14203Q.L(this.f14197K);
    }

    public boolean F0() {
        ValueAnimator valueAnimator = this.f14204R;
        return valueAnimator != null && (valueAnimator.isStarted() || this.f14204R.isRunning());
    }

    public void I0() {
        E e3;
        if (F0()) {
            Log.d("SplitStageDragPolicy", "onControlBarLongPress return, mCurrentTransferAnimation is running");
            return;
        }
        this.f14230i0 = true;
        this.f14203Q.D();
        ContainerView containerView = this.f14198L;
        if (containerView != null && (e3 = containerView.f10732G) != null) {
            e3.Q();
        }
        ContainerView containerView2 = this.f14198L;
        if (containerView2 == null || containerView2.getFlexibleUiManager() == null) {
            return;
        }
        this.f14198L.getFlexibleUiManager().o(203);
    }

    public void J0(C0631a c0631a) {
        if (F0()) {
            Log.d("SplitStageDragPolicy", "onDown animation is running");
            this.f14234k0 = true;
            return;
        }
        this.f14250w = true;
        this.f14235l = c0631a.e();
        this.f14237m = c0631a.d();
        Intent cloneFilter = this.f14220d0.f().cloneFilter();
        cloneFilter.putExtra("androidx.activity.LaunchScenario", 1);
        cloneFilter.putExtra("androidx.activity.LaunchEmbeddedTaskId", this.f14220d0.s());
        if (this.f14220d0.t() != null && !TextUtils.isEmpty(this.f14220d0.t().getPackageName())) {
            B1.l.z1(cloneFilter, this.f14220d0.t());
        }
        Bundle o3 = B1.l.o(cloneFilter, -2, 0);
        this.f14219d = (Rect) o3.getParcelable("androidx.flexible.LaunchBounds", Rect.class);
        this.f14190D = o3.getFloat("androidx.activity.LaunchScale", 1.0f);
        this.f14191E = o3.getInt("androidx.activity.LaunchCornerRadius", 0);
        Rect rect = this.f14219d;
        if (rect == null || rect.isEmpty()) {
            float f3 = this.f14197K.getResources().getDisplayMetrics().density;
            this.f14219d = new Rect(0, 0, (int) (132.0f * f3 * 2.0f), (int) (f3 * 235.0f * 2.0f));
            Log.w("SplitStageDragPolicy", "can't get flexible task bound");
        }
        this.f14221e = Boolean.valueOf(this.f14219d.width() > this.f14219d.height());
        this.f14203Q.a0(this.f14219d);
        this.f14203Q.b0(this.f14190D);
        this.f14203Q.Y(this.f14235l, this.f14237m);
        this.f14227h = new Rect();
        this.f14229i = new Rect();
        this.f14199M.getGlobalVisibleRect(this.f14227h);
        this.f14200N.getGlobalVisibleRect(this.f14229i);
        Rect rect2 = new Rect();
        if (!this.f14221e.booleanValue() || this.f14237m <= this.f14235l || !B1.s.w(this.f14197K) || this.f14219d.width() < this.f14235l * 2) {
            this.f14238m0 = new Rect(0, 0, this.f14219d.width() / 2, this.f14219d.height() / 2);
        } else {
            this.f14238m0 = new Rect(0, 0, (int) (this.f14223f.width() * 0.9f), (int) (((this.f14223f.width() * 0.9f) / this.f14219d.width()) * this.f14219d.height()));
        }
        int width = (this.f14223f.width() - this.f14238m0.width()) / 2;
        rect2.set(width, 0, this.f14238m0.width() + width, this.f14238m0.height());
        B0(c0631a);
        this.f14203Q.U(this.f14223f, this.f14225g, rect2, this.f14227h, this.f14229i);
        boolean m12 = this.f14198L.m1();
        this.f14251x = m12;
        this.f14203Q.Z(m12);
        this.f14253z.set(this.f14199M.getX(), this.f14199M.getY());
        this.f14187A.set(this.f14200N.getX(), this.f14200N.getY());
        this.f14203Q.P(new float[]{1.0f, 1.0f});
        this.f14203Q.Q(new float[]{1.0f, 1.0f});
        this.f14203Q.V(new int[]{0, 0});
        this.f14203Q.W(new int[]{0, 0});
        this.f14203Q.S((int) this.f14200N.getX(), (int) this.f14200N.getY());
        this.f14198L.q0(0).getLocationOnScreen(this.f14247t);
        this.f14249v = false;
        Rect rect3 = this.f14225g;
        int i3 = rect3.left;
        if (i3 < 0) {
            this.f14241o = -i3;
        } else {
            this.f14241o = 0;
        }
        int i4 = rect3.top;
        if (i4 < 0) {
            this.f14243p = -i4;
        } else {
            this.f14243p = 0;
        }
        this.f14214a0 = v0(this.f14201O);
        this.f14216b0 = v0(this.f14202P);
        this.f14239n = w0();
        this.f14230i0 = false;
        this.f14189C.set(c0631a.g().x, c0631a.g().y);
        this.f14203Q.K(this.f14199M, this.f14200N);
        this.f14240n0 = c0631a.f();
        Log.d("SplitStageDragPolicy", "ondown bundle:" + o3);
    }

    public void K0(C0631a c0631a) {
        if (this.f14234k0 || !c0631a.j()) {
            return;
        }
        if (this.f14233k == 0) {
            this.f14233k = 1;
            if (!E0()) {
                this.f14233k = 3;
                return;
            }
            N0(c0631a);
            this.f14233k = 2;
            this.f14198L.I0();
            if (!this.f14230i0) {
                c1(1);
            }
        }
        if (this.f14233k == 2) {
            float f3 = c0631a.g().x;
            float f4 = c0631a.g().y;
            if (Math.abs(f3 - this.f14189C.x) > 3.0f || Math.abs(f4 - this.f14189C.y) > 3.0f) {
                this.f14203Q.E(c0631a);
            }
        }
    }

    public void L0(C0631a c0631a) {
        Log.d("SplitStageDragPolicy", "onUp:" + this.f14249v);
        this.f14234k0 = false;
        this.f14250w = false;
        if (this.f14249v) {
            this.f14203Q.c0(this.f14233k);
            return;
        }
        this.f14249v = true;
        if (c0631a.j() && this.f14233k == 2) {
            this.f14203Q.E(c0631a);
        } else {
            Log.d("SplitStageDragPolicy", "not dragging or not ready");
            this.f14203Q.c0(this.f14233k);
        }
    }

    public void V0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f14228h0 = ofFloat;
        ofFloat.addUpdateListener(new h());
        this.f14228h0.setDuration(400L);
        this.f14228h0.setInterpolator(new Y.e());
        this.f14228h0.addListener(new i());
        this.f14228h0.start();
    }

    @Override // x1.C0632b.d
    public Point a() {
        Point point = new Point();
        if (this.f14251x) {
            point.set(0, (((((int) (((-this.f14247t[1]) + (this.f14198L.getContainerGroupRect().height() / 2)) / this.f14194H)) * 2) - this.f14226g0.y) - this.f14200N.getHeight()) + B1.l.O1(this.f14197K).G0());
        } else {
            point.set(((((int) (((-this.f14247t[0]) + (this.f14198L.getContainerGroupRect().width() / 2)) / this.f14193G)) * 2) - this.f14226g0.x) - this.f14200N.getWidth(), 0);
        }
        return point;
    }

    @Override // x1.C0632b.d
    public void b() {
        if (F0()) {
            return;
        }
        q0();
    }

    @Override // x1.C0632b.d
    public Point c() {
        Point point = new Point();
        if (this.f14198L.getContainerController().k() < 2) {
            return point;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f14198L.getContainerController().l(1));
        arrayList.add(this.f14198L.getContainerController().l(0));
        int u3 = 1 - this.f14198L.getContainerController().u(this.f14220d0);
        if (u3 >= 0 && u3 < this.f14198L.getContainerController().k()) {
            Rect rect = (Rect) B1.l.b1(this.f14197K, arrayList, u3, this.f14198L.getContainerController().q(), false).get(u3);
            point.set(rect.left, rect.top + B1.l.O1(this.f14197K).G0());
        }
        return point;
    }

    @Override // x1.C0632b.d
    public void d(Point point, Point point2, Point point3, Point point4, Rect rect, Rect rect2, Rect rect3, Rect rect4, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float f3, int i3, int i4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f3);
        this.f14205S = ofFloat;
        ofFloat.addUpdateListener(new d(i4, point2, point, f3, fArr2, fArr, fArr4, fArr3, point4, point3, rect2, rect, rect4, rect3));
        this.f14205S.setDuration(i3);
        if (i4 == 8) {
            this.f14205S.setInterpolator(C0632b.f14010O);
        } else {
            this.f14205S.setInterpolator(new Y.e());
        }
        this.f14205S.addListener(new e(i4));
        Y0();
    }

    @Override // x1.C0632b.d
    public void e() {
        if (F0()) {
            this.f14204R.cancel();
        }
        this.f14204R = null;
    }

    @Override // x1.C0632b.d
    public void f(int i3) {
        c1(i3);
    }

    @Override // x1.C0632b.d
    public void g(C0631a c0631a) {
        int i3;
        int i4;
        if (this.f14199M != null) {
            this.f14203Q.v();
            float[] z3 = this.f14203Q.z();
            if (B1.s.w(this.f14197K) && B1.s.B()) {
                i4 = (int) (this.f14223f.left + (this.f14189C.x - c0631a.f().x));
                i3 = (int) (this.f14223f.top + (this.f14189C.y - c0631a.f().y));
            } else {
                int s02 = s0();
                int t02 = t0();
                int i5 = (int) ((c0631a.g().x - (this.f14252y.x * z3[0])) - s02);
                i3 = (int) ((c0631a.g().y - (this.f14252y.y * z3[1])) - t02);
                i4 = i5;
            }
            float f3 = c0631a.g().x;
            float f4 = c0631a.g().y;
            EmbeddedViewDecor embeddedViewDecor = this.f14199M;
            embeddedViewDecor.setTranslationX(embeddedViewDecor.getTranslationX() + ((f3 - this.f14189C.x) / this.f14193G));
            EmbeddedViewDecor embeddedViewDecor2 = this.f14199M;
            embeddedViewDecor2.setTranslationY(embeddedViewDecor2.getTranslationY() + ((f4 - this.f14189C.y) / this.f14194H));
            this.f14189C.set(f3, f4);
            this.f14203Q.O(i4, i3);
            this.f14199M.getLocationOnScreen(new int[2]);
            this.f14196J = r11[0];
            this.f14195I = r11[1];
        }
    }

    @Override // x1.C0632b.d
    public boolean h() {
        if (this.f14198L.getContainerController().k() == 2 || this.f14198L.getContainerController().k() == 3) {
            return (B1.l.g0(this.f14198L, this.f14199M.getTaskData(), this.f14197K) & 4) != 0;
        }
        return false;
    }

    @Override // x1.C0632b.d
    public void i() {
        if (G0(this.f14206T)) {
            this.f14215b.setShadowRadius(this.f14206T, 0.0f).apply();
        }
    }

    @Override // x1.C0632b.d
    public Point j() {
        Point point = new Point();
        PointF pointF = this.f14187A;
        point.set((int) pointF.x, (int) pointF.y);
        return point;
    }

    public boolean z0() {
        C0632b c0632b;
        return this.f14250w || !((c0632b = this.f14203Q) == null || c0632b.x() == 0);
    }
}
