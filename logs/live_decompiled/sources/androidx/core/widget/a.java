package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.y;
import com.oplus.flexibletask.setting.utils.OplusSearchHighlightUtils;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: v, reason: collision with root package name */
    private static final int f5177v = ViewConfiguration.getTapTimeout();

    /* renamed from: g, reason: collision with root package name */
    final View f5180g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f5181h;

    /* renamed from: k, reason: collision with root package name */
    private int f5184k;

    /* renamed from: l, reason: collision with root package name */
    private int f5185l;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5189p;

    /* renamed from: q, reason: collision with root package name */
    boolean f5190q;

    /* renamed from: r, reason: collision with root package name */
    boolean f5191r;

    /* renamed from: s, reason: collision with root package name */
    boolean f5192s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5193t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f5194u;

    /* renamed from: e, reason: collision with root package name */
    final C0074a f5178e = new C0074a();

    /* renamed from: f, reason: collision with root package name */
    private final Interpolator f5179f = new AccelerateInterpolator();

    /* renamed from: i, reason: collision with root package name */
    private float[] f5182i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private float[] f5183j = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: m, reason: collision with root package name */
    private float[] f5186m = {0.0f, 0.0f};

    /* renamed from: n, reason: collision with root package name */
    private float[] f5187n = {0.0f, 0.0f};

    /* renamed from: o, reason: collision with root package name */
    private float[] f5188o = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0074a {

        /* renamed from: a, reason: collision with root package name */
        private int f5195a;

        /* renamed from: b, reason: collision with root package name */
        private int f5196b;

        /* renamed from: c, reason: collision with root package name */
        private float f5197c;

        /* renamed from: d, reason: collision with root package name */
        private float f5198d;

        /* renamed from: j, reason: collision with root package name */
        private float f5204j;

        /* renamed from: k, reason: collision with root package name */
        private int f5205k;

        /* renamed from: e, reason: collision with root package name */
        private long f5199e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f5203i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f5200f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f5201g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f5202h = 0;

        C0074a() {
        }

        private float e(long j3) {
            if (j3 < this.f5199e) {
                return 0.0f;
            }
            long j4 = this.f5203i;
            if (j4 < 0 || j3 < j4) {
                return a.e((j3 - r0) / this.f5195a, 0.0f, 1.0f) * 0.5f;
            }
            float f3 = this.f5204j;
            return (1.0f - f3) + (f3 * a.e((j3 - j4) / this.f5205k, 0.0f, 1.0f));
        }

        private float g(float f3) {
            return ((-4.0f) * f3 * f3) + (f3 * 4.0f);
        }

        public void a() {
            if (this.f5200f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g3 = g(e(currentAnimationTimeMillis));
            long j3 = currentAnimationTimeMillis - this.f5200f;
            this.f5200f = currentAnimationTimeMillis;
            float f3 = j3 * g3;
            this.f5201g = (int) (this.f5197c * f3);
            this.f5202h = (int) (f3 * this.f5198d);
        }

        public int b() {
            return this.f5201g;
        }

        public int c() {
            return this.f5202h;
        }

        public int d() {
            float f3 = this.f5197c;
            return (int) (f3 / Math.abs(f3));
        }

        public int f() {
            float f3 = this.f5198d;
            return (int) (f3 / Math.abs(f3));
        }

        public boolean h() {
            return this.f5203i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f5203i + ((long) this.f5205k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5205k = a.f((int) (currentAnimationTimeMillis - this.f5199e), 0, this.f5196b);
            this.f5204j = e(currentAnimationTimeMillis);
            this.f5203i = currentAnimationTimeMillis;
        }

        public void j(int i3) {
            this.f5196b = i3;
        }

        public void k(int i3) {
            this.f5195a = i3;
        }

        public void l(float f3, float f4) {
            this.f5197c = f3;
            this.f5198d = f4;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5199e = currentAnimationTimeMillis;
            this.f5203i = -1L;
            this.f5200f = currentAnimationTimeMillis;
            this.f5204j = 0.5f;
            this.f5201g = 0;
            this.f5202h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f5192s) {
                if (aVar.f5190q) {
                    aVar.f5190q = false;
                    aVar.f5178e.m();
                }
                C0074a c0074a = a.this.f5178e;
                if (c0074a.h() || !a.this.u()) {
                    a.this.f5192s = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f5191r) {
                    aVar2.f5191r = false;
                    aVar2.c();
                }
                c0074a.a();
                a.this.j(c0074a.b(), c0074a.c());
                y.a0(a.this.f5180g, this);
            }
        }
    }

    public a(View view) {
        this.f5180g = view;
        float f3 = Resources.getSystem().getDisplayMetrics().density;
        float f4 = (int) ((1575.0f * f3) + 0.5f);
        o(f4, f4);
        float f5 = (int) ((f3 * 315.0f) + 0.5f);
        p(f5, f5);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f5177v);
        r(OplusSearchHighlightUtils.WAIT_TIME_DEFAULT);
        q(OplusSearchHighlightUtils.WAIT_TIME_DEFAULT);
    }

    private float d(int i3, float f3, float f4, float f5) {
        float h3 = h(this.f5182i[i3], f4, this.f5183j[i3], f3);
        if (h3 == 0.0f) {
            return 0.0f;
        }
        float f6 = this.f5186m[i3];
        float f7 = this.f5187n[i3];
        float f8 = this.f5188o[i3];
        float f9 = f6 * f5;
        return h3 > 0.0f ? e(h3 * f9, f7, f8) : -e((-h3) * f9, f7, f8);
    }

    static float e(float f3, float f4, float f5) {
        return f3 > f5 ? f5 : f3 < f4 ? f4 : f3;
    }

    static int f(int i3, int i4, int i5) {
        return i3 > i5 ? i5 : i3 < i4 ? i4 : i3;
    }

    private float g(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.f5184k;
        if (i3 == 0 || i3 == 1) {
            if (f3 < f4) {
                if (f3 >= 0.0f) {
                    return 1.0f - (f3 / f4);
                }
                if (this.f5192s && i3 == 1) {
                    return 1.0f;
                }
            }
        } else if (i3 == 2 && f3 < 0.0f) {
            return f3 / (-f4);
        }
        return 0.0f;
    }

    private float h(float f3, float f4, float f5, float f6) {
        float interpolation;
        float e3 = e(f3 * f4, 0.0f, f5);
        float g3 = g(f4 - f6, e3) - g(f6, e3);
        if (g3 < 0.0f) {
            interpolation = -this.f5179f.getInterpolation(-g3);
        } else {
            if (g3 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f5179f.getInterpolation(g3);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f5190q) {
            this.f5192s = false;
        } else {
            this.f5178e.i();
        }
    }

    private void v() {
        int i3;
        if (this.f5181h == null) {
            this.f5181h = new b();
        }
        this.f5192s = true;
        this.f5190q = true;
        if (this.f5189p || (i3 = this.f5185l) <= 0) {
            this.f5181h.run();
        } else {
            y.b0(this.f5180g, this.f5181h, i3);
        }
        this.f5189p = true;
    }

    public abstract boolean a(int i3);

    public abstract boolean b(int i3);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f5180g.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i3, int i4);

    public a k(int i3) {
        this.f5185l = i3;
        return this;
    }

    public a l(int i3) {
        this.f5184k = i3;
        return this;
    }

    public a m(boolean z3) {
        if (this.f5193t && !z3) {
            i();
        }
        this.f5193t = z3;
        return this;
    }

    public a n(float f3, float f4) {
        float[] fArr = this.f5183j;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public a o(float f3, float f4) {
        float[] fArr = this.f5188o;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f5193t
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f5191r = r2
            r5.f5189p = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f5180g
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f5180g
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f5178e
            r7.l(r0, r6)
            boolean r6 = r5.f5192s
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f5194u
            if (r6 == 0) goto L61
            boolean r5 = r5.f5192s
            if (r5 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f3, float f4) {
        float[] fArr = this.f5187n;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    public a q(int i3) {
        this.f5178e.j(i3);
        return this;
    }

    public a r(int i3) {
        this.f5178e.k(i3);
        return this;
    }

    public a s(float f3, float f4) {
        float[] fArr = this.f5182i;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public a t(float f3, float f4) {
        float[] fArr = this.f5186m;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    boolean u() {
        C0074a c0074a = this.f5178e;
        int f3 = c0074a.f();
        int d3 = c0074a.d();
        return (f3 != 0 && b(f3)) || (d3 != 0 && a(d3));
    }
}
