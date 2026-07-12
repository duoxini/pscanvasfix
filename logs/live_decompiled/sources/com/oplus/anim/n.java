package com.oplus.anim;

import a1.AbstractC0220B;
import a1.C0221a;
import a1.InterfaceC0223c;
import a1.r;
import a1.t;
import a1.u;
import a1.v;
import a1.z;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import b1.C0292a;
import e1.C0343a;
import e1.C0344b;
import f1.C0356d;
import f1.C0358f;
import i1.C0396c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k1.w;
import m1.AbstractC0462e;
import m1.AbstractC0464g;
import m1.ChoreographerFrameCallbackC0459b;
import n1.C0483b;

/* loaded from: classes.dex */
public class n extends Drawable implements Drawable.Callback, Animatable {

    /* renamed from: A, reason: collision with root package name */
    private boolean f10091A;

    /* renamed from: B, reason: collision with root package name */
    private final Matrix f10092B;

    /* renamed from: C, reason: collision with root package name */
    private Bitmap f10093C;

    /* renamed from: D, reason: collision with root package name */
    private Canvas f10094D;

    /* renamed from: E, reason: collision with root package name */
    private Rect f10095E;

    /* renamed from: F, reason: collision with root package name */
    private RectF f10096F;

    /* renamed from: G, reason: collision with root package name */
    private Paint f10097G;

    /* renamed from: H, reason: collision with root package name */
    private Rect f10098H;

    /* renamed from: I, reason: collision with root package name */
    private Rect f10099I;

    /* renamed from: J, reason: collision with root package name */
    private RectF f10100J;

    /* renamed from: K, reason: collision with root package name */
    private RectF f10101K;

    /* renamed from: L, reason: collision with root package name */
    private Matrix f10102L;

    /* renamed from: M, reason: collision with root package name */
    private Matrix f10103M;

    /* renamed from: N, reason: collision with root package name */
    private boolean f10104N;

    /* renamed from: e, reason: collision with root package name */
    private C0221a f10105e;

    /* renamed from: f, reason: collision with root package name */
    private final ChoreographerFrameCallbackC0459b f10106f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f10107g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f10108h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10109i;

    /* renamed from: j, reason: collision with root package name */
    private c f10110j;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f10111k;

    /* renamed from: l, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f10112l;

    /* renamed from: m, reason: collision with root package name */
    private C0344b f10113m;

    /* renamed from: n, reason: collision with root package name */
    private String f10114n;

    /* renamed from: o, reason: collision with root package name */
    private C0343a f10115o;

    /* renamed from: p, reason: collision with root package name */
    private Map f10116p;

    /* renamed from: q, reason: collision with root package name */
    String f10117q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f10118r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f10119s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f10120t;

    /* renamed from: u, reason: collision with root package name */
    private C0396c f10121u;

    /* renamed from: v, reason: collision with root package name */
    private int f10122v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f10123w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f10124x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f10125y;

    /* renamed from: z, reason: collision with root package name */
    private z f10126z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (n.this.f10121u != null) {
                n.this.f10121u.N(n.this.f10106f.j());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface b {
        void a(C0221a c0221a);
    }

    private enum c {
        NONE,
        PLAY,
        RESUME
    }

    public n() {
        ChoreographerFrameCallbackC0459b choreographerFrameCallbackC0459b = new ChoreographerFrameCallbackC0459b();
        this.f10106f = choreographerFrameCallbackC0459b;
        this.f10107g = true;
        this.f10108h = false;
        this.f10109i = false;
        this.f10110j = c.NONE;
        this.f10111k = new ArrayList();
        a aVar = new a();
        this.f10112l = aVar;
        this.f10119s = false;
        this.f10120t = true;
        this.f10122v = 255;
        this.f10126z = z.AUTOMATIC;
        this.f10091A = false;
        this.f10092B = new Matrix();
        this.f10104N = false;
        choreographerFrameCallbackC0459b.addUpdateListener(aVar);
    }

    private void C(int i3, int i4) {
        Bitmap bitmap = this.f10093C;
        if (bitmap == null || bitmap.getWidth() < i3 || this.f10093C.getHeight() < i4) {
            Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
            this.f10093C = createBitmap;
            this.f10094D.setBitmap(createBitmap);
            this.f10104N = true;
            return;
        }
        if (this.f10093C.getWidth() > i3 || this.f10093C.getHeight() > i4) {
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f10093C, 0, 0, i3, i4);
            this.f10093C = createBitmap2;
            this.f10094D.setBitmap(createBitmap2);
            this.f10104N = true;
        }
    }

    private void D() {
        if (this.f10094D != null) {
            return;
        }
        this.f10094D = new Canvas();
        this.f10101K = new RectF();
        this.f10102L = new Matrix();
        this.f10103M = new Matrix();
        this.f10095E = new Rect();
        this.f10096F = new RectF();
        this.f10097G = new C0292a();
        this.f10098H = new Rect();
        this.f10099I = new Rect();
        this.f10100J = new RectF();
    }

    private Context H() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private C0343a I() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f10115o == null) {
            C0343a c0343a = new C0343a(getCallback(), null);
            this.f10115o = c0343a;
            String str = this.f10117q;
            if (str != null) {
                c0343a.c(str);
            }
        }
        return this.f10115o;
    }

    private C0344b K() {
        C0344b c0344b = this.f10113m;
        if (c0344b != null && !c0344b.b(H())) {
            this.f10113m = null;
        }
        if (this.f10113m == null) {
            this.f10113m = new C0344b(getCallback(), this.f10114n, null, this.f10105e.j());
        }
        return this.f10113m;
    }

    private boolean Y() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        if (((View) callback).getParent() instanceof ViewGroup) {
            return !((ViewGroup) r2).getClipChildren();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(C0358f c0358f, Object obj, C0483b c0483b, C0221a c0221a) {
        q(c0358f, obj, c0483b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(C0221a c0221a) {
        q0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(C0221a c0221a) {
        u0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(int i3, C0221a c0221a) {
        C0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(int i3, C0221a c0221a) {
        H0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(String str, C0221a c0221a) {
        I0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(float f3, C0221a c0221a) {
        J0(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i3, int i4, C0221a c0221a) {
        K0(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(String str, C0221a c0221a) {
        L0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(int i3, C0221a c0221a) {
        M0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(String str, C0221a c0221a) {
        N0(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(float f3, C0221a c0221a) {
        O0(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(float f3, C0221a c0221a) {
        R0(f3);
    }

    private boolean r() {
        return this.f10107g || this.f10108h;
    }

    private void s() {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            return;
        }
        C0396c c0396c = new C0396c(this, w.a(c0221a), c0221a.k(), c0221a);
        this.f10121u = c0396c;
        if (this.f10124x) {
            c0396c.L(true);
        }
        this.f10121u.Q(this.f10120t);
    }

    private void s0(Canvas canvas, C0396c c0396c) {
        if (this.f10105e == null || c0396c == null) {
            return;
        }
        D();
        canvas.getMatrix(this.f10102L);
        canvas.getClipBounds(this.f10095E);
        w(this.f10095E, this.f10096F);
        this.f10102L.mapRect(this.f10096F);
        x(this.f10096F, this.f10095E);
        if (this.f10120t) {
            this.f10101K.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            c0396c.a(this.f10101K, null, false);
        }
        this.f10102L.mapRect(this.f10101K);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        v0(this.f10101K, width, height);
        if (!Y()) {
            RectF rectF = this.f10101K;
            Rect rect = this.f10095E;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.f10101K.width());
        int ceil2 = (int) Math.ceil(this.f10101K.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        C(ceil, ceil2);
        if (this.f10104N) {
            this.f10092B.set(this.f10102L);
            this.f10092B.preScale(width, height);
            Matrix matrix = this.f10092B;
            RectF rectF2 = this.f10101K;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.f10093C.eraseColor(0);
            c0396c.i(this.f10094D, this.f10092B, this.f10122v);
            this.f10102L.invert(this.f10103M);
            this.f10103M.mapRect(this.f10100J, this.f10101K);
            x(this.f10100J, this.f10099I);
        }
        this.f10098H.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.f10093C, this.f10098H, this.f10099I, this.f10097G);
    }

    private void v() {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            return;
        }
        this.f10091A = this.f10126z.a(Build.VERSION.SDK_INT, c0221a.q(), c0221a.m());
    }

    private void v0(RectF rectF, float f3, float f4) {
        rectF.set(rectF.left * f3, rectF.top * f4, rectF.right * f3, rectF.bottom * f4);
    }

    private void w(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void x(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void y(Canvas canvas) {
        C0396c c0396c = this.f10121u;
        C0221a c0221a = this.f10105e;
        if (c0396c == null || c0221a == null) {
            return;
        }
        this.f10092B.reset();
        if (!getBounds().isEmpty()) {
            this.f10092B.preScale(r2.width() / c0221a.b().width(), r2.height() / c0221a.b().height());
            this.f10092B.preTranslate(r2.left, r2.top);
        }
        c0396c.i(canvas, this.f10092B, this.f10122v);
    }

    public boolean A() {
        return this.f10118r;
    }

    public void A0(t tVar) {
        C0343a c0343a = this.f10115o;
        if (c0343a != null) {
            c0343a.d(tVar);
        }
    }

    public void B() {
        this.f10111k.clear();
        this.f10106f.i();
        if (isVisible()) {
            return;
        }
        this.f10110j = c.NONE;
    }

    public void B0(Map map) {
        if (map == this.f10116p) {
            return;
        }
        this.f10116p = map;
        invalidateSelf();
    }

    public void C0(final int i3) {
        if (this.f10105e == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.h
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.f0(i3, c0221a);
                }
            });
        } else {
            this.f10106f.A(i3);
        }
    }

    public void D0(boolean z3) {
        this.f10108h = z3;
    }

    public Bitmap E(String str) {
        C0344b K3 = K();
        if (K3 != null) {
            return K3.a(str);
        }
        return null;
    }

    public void E0(u uVar) {
        C0344b c0344b = this.f10113m;
        if (c0344b != null) {
            c0344b.d(uVar);
        }
    }

    public boolean F() {
        return this.f10120t;
    }

    public void F0(String str) {
        this.f10114n = str;
    }

    public C0221a G() {
        return this.f10105e;
    }

    public void G0(boolean z3) {
        this.f10119s = z3;
    }

    public void H0(final int i3) {
        if (this.f10105e == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.c
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.g0(i3, c0221a);
                }
            });
        } else {
            this.f10106f.B(i3 + 0.99f);
        }
    }

    public void I0(final String str) {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.a
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a2) {
                    n.this.h0(str, c0221a2);
                }
            });
            return;
        }
        f1.h l3 = c0221a.l(str);
        if (l3 != null) {
            H0((int) (l3.f11587b + l3.f11588c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public int J() {
        return (int) this.f10106f.k();
    }

    public void J0(final float f3) {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.f
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a2) {
                    n.this.i0(f3, c0221a2);
                }
            });
        } else {
            this.f10106f.B(AbstractC0464g.i(c0221a.p(), this.f10105e.f(), f3));
        }
    }

    public void K0(final int i3, final int i4) {
        if (this.f10105e == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.d
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.j0(i3, i4, c0221a);
                }
            });
        } else {
            this.f10106f.C(i3, i4 + 0.99f);
        }
    }

    public String L() {
        return this.f10114n;
    }

    public void L0(final String str) {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.j
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a2) {
                    n.this.k0(str, c0221a2);
                }
            });
            return;
        }
        f1.h l3 = c0221a.l(str);
        if (l3 != null) {
            int i3 = (int) l3.f11587b;
            K0(i3, ((int) l3.f11588c) + i3);
        } else {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
    }

    public r M(String str) {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            return null;
        }
        return (r) c0221a.j().get(str);
    }

    public void M0(final int i3) {
        if (this.f10105e == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.l
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.l0(i3, c0221a);
                }
            });
        } else {
            this.f10106f.D(i3);
        }
    }

    public boolean N() {
        return this.f10119s;
    }

    public void N0(final String str) {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.m
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a2) {
                    n.this.m0(str, c0221a2);
                }
            });
            return;
        }
        f1.h l3 = c0221a.l(str);
        if (l3 != null) {
            M0((int) l3.f11587b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public float O() {
        return this.f10106f.m();
    }

    public void O0(final float f3) {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.b
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a2) {
                    n.this.n0(f3, c0221a2);
                }
            });
        } else {
            M0((int) AbstractC0464g.i(c0221a.p(), this.f10105e.f(), f3));
        }
    }

    public float P() {
        return this.f10106f.n();
    }

    public void P0(boolean z3) {
        if (this.f10124x == z3) {
            return;
        }
        this.f10124x = z3;
        C0396c c0396c = this.f10121u;
        if (c0396c != null) {
            c0396c.L(z3);
        }
    }

    public a1.w Q() {
        C0221a c0221a = this.f10105e;
        if (c0221a != null) {
            return c0221a.n();
        }
        return null;
    }

    public void Q0(boolean z3) {
        this.f10123w = z3;
        C0221a c0221a = this.f10105e;
        if (c0221a != null) {
            c0221a.v(z3);
        }
    }

    public float R() {
        return this.f10106f.j();
    }

    public void R0(final float f3) {
        if (this.f10105e == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.e
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.o0(f3, c0221a);
                }
            });
            return;
        }
        v.a("Drawable#setProgress");
        this.f10106f.A(this.f10105e.h(f3));
        v.b("Drawable#setProgress");
    }

    public z S() {
        return this.f10091A ? z.SOFTWARE : z.HARDWARE;
    }

    public void S0(z zVar) {
        this.f10126z = zVar;
        v();
    }

    public int T() {
        return this.f10106f.getRepeatCount();
    }

    public void T0(int i3) {
        this.f10106f.setRepeatCount(i3);
    }

    public int U() {
        return this.f10106f.getRepeatMode();
    }

    public void U0(int i3) {
        this.f10106f.setRepeatMode(i3);
    }

    public float V() {
        return this.f10106f.o();
    }

    public void V0(boolean z3) {
        this.f10109i = z3;
    }

    public AbstractC0220B W() {
        return null;
    }

    public void W0(float f3) {
        this.f10106f.E(f3);
    }

    public Typeface X(C0356d c0356d) {
        Map map = this.f10116p;
        if (map != null) {
            String a3 = c0356d.a();
            if (map.containsKey(a3)) {
                return (Typeface) map.get(a3);
            }
            String b3 = c0356d.b();
            if (map.containsKey(b3)) {
                return (Typeface) map.get(b3);
            }
            String str = c0356d.a() + "-" + c0356d.c();
            if (map.containsKey(str)) {
                return (Typeface) map.get(str);
            }
        }
        C0343a I3 = I();
        if (I3 != null) {
            return I3.b(c0356d);
        }
        return null;
    }

    public void X0(Boolean bool) {
        this.f10107g = bool.booleanValue();
    }

    public void Y0(AbstractC0220B abstractC0220B) {
    }

    public boolean Z() {
        ChoreographerFrameCallbackC0459b choreographerFrameCallbackC0459b = this.f10106f;
        if (choreographerFrameCallbackC0459b == null) {
            return false;
        }
        return choreographerFrameCallbackC0459b.isRunning();
    }

    public void Z0(boolean z3) {
        this.f10106f.F(z3);
    }

    boolean a0() {
        if (isVisible()) {
            return this.f10106f.isRunning();
        }
        c cVar = this.f10110j;
        return cVar == c.PLAY || cVar == c.RESUME;
    }

    public boolean a1() {
        return this.f10116p == null && this.f10105e.c().j() > 0;
    }

    public boolean b0() {
        return this.f10125y;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        v.a("Drawable#draw");
        if (this.f10109i) {
            try {
                if (this.f10091A) {
                    s0(canvas, this.f10121u);
                } else {
                    y(canvas);
                }
            } catch (Throwable th) {
                AbstractC0462e.b("Lottie crashed in draw!", th);
            }
        } else if (this.f10091A) {
            s0(canvas, this.f10121u);
        } else {
            y(canvas);
        }
        this.f10104N = false;
        v.b("Drawable#draw");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f10122v;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            return -1;
        }
        return c0221a.b().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        C0221a c0221a = this.f10105e;
        if (c0221a == null) {
            return -1;
        }
        return c0221a.b().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f10104N) {
            return;
        }
        this.f10104N = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return Z();
    }

    public void p(Animator.AnimatorListener animatorListener) {
        this.f10106f.addListener(animatorListener);
    }

    public void p0() {
        this.f10111k.clear();
        this.f10106f.s();
        if (isVisible()) {
            return;
        }
        this.f10110j = c.NONE;
    }

    public void q(final C0358f c0358f, final Object obj, final C0483b c0483b) {
        C0396c c0396c = this.f10121u;
        if (c0396c == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.g
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.c0(c0358f, obj, c0483b, c0221a);
                }
            });
            return;
        }
        boolean z3 = true;
        if (c0358f == C0358f.f11583c) {
            c0396c.h(obj, c0483b);
        } else if (c0358f.d() != null) {
            c0358f.d().h(obj, c0483b);
        } else {
            List t02 = t0(c0358f);
            for (int i3 = 0; i3 < t02.size(); i3++) {
                ((C0358f) t02.get(i3)).d().h(obj, c0483b);
            }
            z3 = true ^ t02.isEmpty();
        }
        if (z3) {
            invalidateSelf();
            if (obj == InterfaceC0223c.f3182E) {
                R0(R());
            }
        }
    }

    public void q0() {
        if (this.f10121u == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.i
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.d0(c0221a);
                }
            });
            return;
        }
        v();
        if (r() || T() == 0) {
            if (isVisible()) {
                this.f10106f.t();
                this.f10110j = c.NONE;
            } else {
                this.f10110j = c.PLAY;
            }
        }
        if (r()) {
            return;
        }
        C0((int) (V() < 0.0f ? P() : O()));
        this.f10106f.i();
        if (isVisible()) {
            return;
        }
        this.f10110j = c.NONE;
    }

    public void r0() {
        this.f10106f.removeAllListeners();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f10122v = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        AbstractC0462e.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean isVisible = isVisible();
        boolean visible = super.setVisible(z3, z4);
        if (z3) {
            c cVar = this.f10110j;
            if (cVar == c.PLAY) {
                q0();
            } else if (cVar == c.RESUME) {
                u0();
            }
        } else if (this.f10106f.isRunning()) {
            p0();
            this.f10110j = c.RESUME;
        } else if (isVisible) {
            this.f10110j = c.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        q0();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        B();
    }

    public void t() {
        this.f10111k.clear();
        this.f10106f.cancel();
        if (isVisible()) {
            return;
        }
        this.f10110j = c.NONE;
    }

    public List t0(C0358f c0358f) {
        if (this.f10121u == null) {
            AbstractC0462e.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f10121u.b(c0358f, 0, arrayList, new C0358f(new String[0]));
        return arrayList;
    }

    public void u() {
        if (this.f10106f.isRunning()) {
            this.f10106f.cancel();
            if (!isVisible()) {
                this.f10110j = c.NONE;
            }
        }
        this.f10105e = null;
        this.f10121u = null;
        this.f10113m = null;
        this.f10106f.h();
        invalidateSelf();
    }

    public void u0() {
        if (this.f10121u == null) {
            this.f10111k.add(new b() { // from class: com.oplus.anim.k
                @Override // com.oplus.anim.n.b
                public final void a(C0221a c0221a) {
                    n.this.e0(c0221a);
                }
            });
            return;
        }
        v();
        if (r() || T() == 0) {
            if (isVisible()) {
                this.f10106f.x();
                this.f10110j = c.NONE;
            } else {
                this.f10110j = c.RESUME;
            }
        }
        if (r()) {
            return;
        }
        C0((int) (V() < 0.0f ? P() : O()));
        this.f10106f.i();
        if (isVisible()) {
            return;
        }
        this.f10110j = c.NONE;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void w0(boolean z3) {
        this.f10125y = z3;
    }

    public void x0(boolean z3) {
        if (z3 != this.f10120t) {
            this.f10120t = z3;
            C0396c c0396c = this.f10121u;
            if (c0396c != null) {
                c0396c.Q(z3);
            }
            invalidateSelf();
        }
    }

    public boolean y0(C0221a c0221a) {
        if (this.f10105e == c0221a) {
            return false;
        }
        this.f10104N = true;
        u();
        this.f10105e = c0221a;
        s();
        this.f10106f.z(c0221a);
        R0(this.f10106f.getAnimatedFraction());
        Iterator it = new ArrayList(this.f10111k).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.a(c0221a);
            }
            it.remove();
        }
        this.f10111k.clear();
        c0221a.v(this.f10123w);
        v();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void z(boolean z3) {
        if (this.f10118r == z3) {
            return;
        }
        this.f10118r = z3;
        if (this.f10105e != null) {
            s();
        }
    }

    public void z0(String str) {
        this.f10117q = str;
        C0343a I3 = I();
        if (I3 != null) {
            I3.c(str);
        }
    }
}
