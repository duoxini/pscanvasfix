package o0;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class c extends OverScroller implements o0.b {

    /* renamed from: f, reason: collision with root package name */
    private static final Interpolator f12622f = new a();

    /* renamed from: a, reason: collision with root package name */
    private b f12623a;

    /* renamed from: b, reason: collision with root package name */
    private b f12624b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f12625c;

    /* renamed from: d, reason: collision with root package name */
    private int f12626d;

    /* renamed from: e, reason: collision with root package name */
    private d f12627e;

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float f4 = f3 - 1.0f;
            return (f4 * f4 * f4 * f4 * f4) + 1.0f;
        }
    }

    private static class b {

        /* renamed from: r, reason: collision with root package name */
        private static final float f12628r = (float) (Math.log(0.78d) / Math.log(0.9d));

        /* renamed from: s, reason: collision with root package name */
        private static final float[] f12629s = new float[101];

        /* renamed from: t, reason: collision with root package name */
        private static final float[] f12630t = new float[101];

        /* renamed from: a, reason: collision with root package name */
        private int f12631a;

        /* renamed from: b, reason: collision with root package name */
        private int f12632b;

        /* renamed from: c, reason: collision with root package name */
        private int f12633c;

        /* renamed from: d, reason: collision with root package name */
        private int f12634d;

        /* renamed from: e, reason: collision with root package name */
        private float f12635e;

        /* renamed from: f, reason: collision with root package name */
        private float f12636f;

        /* renamed from: g, reason: collision with root package name */
        private long f12637g;

        /* renamed from: h, reason: collision with root package name */
        private int f12638h;

        /* renamed from: k, reason: collision with root package name */
        private int f12641k;

        /* renamed from: l, reason: collision with root package name */
        private int f12642l;

        /* renamed from: n, reason: collision with root package name */
        private int f12644n;

        /* renamed from: q, reason: collision with root package name */
        private float f12647q;

        /* renamed from: i, reason: collision with root package name */
        private float f12639i = 1.0f;

        /* renamed from: j, reason: collision with root package name */
        private float f12640j = 1.0f;

        /* renamed from: o, reason: collision with root package name */
        private float f12645o = ViewConfiguration.getScrollFriction() * 2.5f;

        /* renamed from: p, reason: collision with root package name */
        private int f12646p = 0;

        /* renamed from: m, reason: collision with root package name */
        private boolean f12643m = true;

        static {
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13 = 0.0f;
            float f14 = 0.0f;
            for (int i3 = 0; i3 < 100; i3++) {
                float f15 = i3 / 100.0f;
                float f16 = 1.0f;
                while (true) {
                    f3 = 2.0f;
                    f4 = ((f16 - f13) / 2.0f) + f13;
                    f5 = 3.0f;
                    f6 = 1.0f - f4;
                    f7 = f4 * 3.0f * f6;
                    f8 = f4 * f4 * f4;
                    float f17 = (((f6 * 0.175f) + (f4 * 0.35000002f)) * f7) + f8;
                    if (Math.abs(f17 - f15) < 1.0E-5d) {
                        break;
                    } else if (f17 > f15) {
                        f16 = f4;
                    } else {
                        f13 = f4;
                    }
                }
                f12629s[i3] = (f7 * ((f6 * 0.5f) + f4)) + f8;
                float f18 = 1.0f;
                while (true) {
                    f9 = ((f18 - f14) / f3) + f14;
                    f10 = 1.0f - f9;
                    f11 = f9 * f5 * f10;
                    f12 = f9 * f9 * f9;
                    float f19 = (((f10 * 0.5f) + f9) * f11) + f12;
                    if (Math.abs(f19 - f15) < 1.0E-5d) {
                        break;
                    }
                    if (f19 > f15) {
                        f18 = f9;
                    } else {
                        f14 = f9;
                    }
                    f3 = 2.0f;
                    f5 = 3.0f;
                }
                f12630t[i3] = (f11 * ((f10 * 0.175f) + (f9 * 0.35000002f))) + f12;
            }
            f12629s[100] = 1.0f;
            f12630t[100] = 1.0f;
        }

        b(Context context) {
            this.f12647q = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private void B(int i3, int i4, int i5) {
            this.f12643m = false;
            this.f12646p = 1;
            this.f12632b = i3;
            this.f12631a = i3;
            this.f12633c = i4;
            int i6 = i3 - i4;
            this.f12636f = p(i6);
            this.f12634d = -i6;
            this.f12644n = Math.abs(i6);
            this.f12638h = (int) (Math.sqrt((i6 * (-2.0f)) / this.f12636f) * 1000.0d);
        }

        private void k(int i3, int i4, int i5) {
            float abs = Math.abs((i5 - i3) / (i4 - i3));
            int i6 = (int) (abs * 100.0f);
            if (i6 >= 100 || i6 < 0) {
                return;
            }
            float f3 = i6 / 100.0f;
            int i7 = i6 + 1;
            float[] fArr = f12630t;
            float f4 = fArr[i6];
            this.f12638h = (int) (this.f12638h * (f4 + (((abs - f3) / ((i7 / 100.0f) - f3)) * (fArr[i7] - f4))));
        }

        private void n(int i3, int i4, int i5) {
            float f3 = (-i5) / this.f12636f;
            float f4 = i5;
            float sqrt = (float) Math.sqrt((((((f4 * f4) / 2.0f) / Math.abs(r1)) + Math.abs(i4 - i3)) * 2.0d) / Math.abs(this.f12636f));
            this.f12637g -= (int) ((sqrt - f3) * 1000.0f);
            this.f12632b = i4;
            this.f12631a = i4;
            this.f12634d = (int) ((-this.f12636f) * sqrt);
        }

        private static float p(int i3) {
            return i3 > 0 ? -2000.0f : 2000.0f;
        }

        private double q(int i3) {
            return Math.log((Math.abs(i3) * 0.35f) / (this.f12645o * this.f12647q));
        }

        private double r(int i3) {
            double q3 = q(i3);
            float f3 = f12628r;
            return this.f12645o * this.f12647q * Math.exp((f3 / (f3 - 1.0d)) * q3);
        }

        private int s(int i3) {
            return (int) (Math.exp(q(i3) / (f12628r - 1.0f)) * 1000.0d);
        }

        private void u() {
            int i3 = this.f12634d;
            float f3 = i3 * i3;
            float abs = f3 / (Math.abs(this.f12636f) * 2.0f);
            float signum = Math.signum(this.f12634d);
            int i4 = this.f12644n;
            if (abs > i4) {
                this.f12636f = ((-signum) * f3) / (i4 * 2.0f);
                abs = i4;
            }
            this.f12644n = (int) abs;
            this.f12646p = 2;
            int i5 = this.f12631a;
            int i6 = this.f12634d;
            if (i6 <= 0) {
                abs = -abs;
            }
            this.f12633c = i5 + ((int) abs);
            this.f12638h = -((int) ((i6 * 1000.0f) / this.f12636f));
        }

        private void y(int i3, int i4, int i5, int i6) {
            if (i3 > i4 && i3 < i5) {
                Log.e("COUILocateOverScroller", "startAfterEdge called from a valid position");
                this.f12643m = true;
                return;
            }
            boolean z3 = i3 > i5;
            int i7 = z3 ? i5 : i4;
            if ((i3 - i7) * i6 >= 0) {
                z(i3, i7, i6);
            } else if (r(i6) > Math.abs(r2)) {
                o(i3, i6, z3 ? i4 : i3, z3 ? i3 : i5, this.f12644n);
            } else {
                B(i3, i7, i6);
            }
        }

        private void z(int i3, int i4, int i5) {
            this.f12636f = p(i5 == 0 ? i3 - i4 : i5);
            n(i3, i4, i5);
            u();
        }

        void A(int i3, int i4, int i5) {
            this.f12643m = false;
            this.f12632b = i3;
            this.f12631a = i3;
            this.f12633c = i3 + i4;
            this.f12637g = AnimationUtils.currentAnimationTimeMillis();
            this.f12638h = i5;
            this.f12636f = 0.0f;
            this.f12634d = 0;
        }

        boolean C() {
            float f3;
            float f4;
            double d3;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f12637g;
            if (currentAnimationTimeMillis == 0) {
                return this.f12638h > 0;
            }
            int i3 = this.f12638h;
            if (currentAnimationTimeMillis > i3) {
                return false;
            }
            int i4 = this.f12646p;
            if (i4 == 0) {
                int i5 = this.f12641k;
                float f5 = currentAnimationTimeMillis / i5;
                int i6 = (int) (f5 * 100.0f);
                if (i6 >= 100 || i6 < 0) {
                    f3 = 1.0f;
                    f4 = 0.0f;
                } else {
                    float f6 = i6 / 100.0f;
                    int i7 = i6 + 1;
                    float[] fArr = f12629s;
                    float f7 = fArr[i6];
                    f4 = (fArr[i7] - f7) / ((i7 / 100.0f) - f6);
                    f3 = f7 + ((f5 - f6) * f4);
                }
                int i8 = this.f12642l;
                this.f12635e = ((f4 * i8) / i5) * 1000.0f;
                d3 = f3 * i8;
            } else if (i4 == 1) {
                float f8 = currentAnimationTimeMillis / i3;
                float f9 = f8 * f8;
                float signum = Math.signum(this.f12634d);
                int i9 = this.f12644n;
                this.f12635e = signum * i9 * 6.0f * ((-f8) + f9);
                d3 = i9 * signum * ((3.0f * f9) - ((2.0f * f8) * f9));
            } else if (i4 != 2) {
                d3 = 0.0d;
            } else {
                float f10 = currentAnimationTimeMillis / 1000.0f;
                int i10 = this.f12634d;
                float f11 = this.f12636f;
                this.f12635e = i10 + (f11 * f10);
                d3 = (i10 * f10) + (((f11 * f10) * f10) / 2.0f);
            }
            this.f12632b = this.f12631a + ((int) Math.round(d3));
            return true;
        }

        void D(float f3) {
            this.f12632b = this.f12631a + Math.round(f3 * (this.f12633c - r0));
        }

        boolean l() {
            int i3 = this.f12646p;
            if (i3 != 0) {
                if (i3 == 1) {
                    return false;
                }
                if (i3 == 2) {
                    this.f12637g += this.f12638h;
                    B(this.f12633c, this.f12631a, 0);
                }
            } else {
                if (this.f12638h >= this.f12641k) {
                    return false;
                }
                int i4 = this.f12633c;
                this.f12632b = i4;
                this.f12631a = i4;
                int i5 = (int) this.f12635e;
                this.f12634d = i5;
                this.f12636f = p(i5);
                this.f12637g += this.f12638h;
                u();
            }
            C();
            return true;
        }

        void m() {
            this.f12632b = this.f12633c;
            this.f12643m = true;
        }

        void o(int i3, int i4, int i5, int i6, int i7) {
            double d3;
            this.f12644n = i7;
            this.f12643m = false;
            float f3 = i4;
            this.f12635e = f3;
            this.f12634d = i4;
            this.f12638h = 0;
            this.f12641k = 0;
            this.f12637g = AnimationUtils.currentAnimationTimeMillis();
            this.f12632b = i3;
            this.f12631a = i3;
            if (i3 > i6 || i3 < i5) {
                y(i3, i5, i6, i4);
                return;
            }
            float f4 = this.f12640j;
            if (f4 != 1.0f) {
                i4 = (int) (f3 * f4);
                float f5 = i4;
                this.f12635e = f5;
                this.f12634d = Math.round(f5 * f4);
            }
            this.f12646p = 0;
            if (i4 != 0) {
                int round = Math.round(s(i4) * this.f12639i);
                this.f12638h = round;
                this.f12641k = round;
                d3 = r(i4);
            } else {
                d3 = 0.0d;
            }
            int signum = (int) (d3 * Math.signum(i4));
            this.f12642l = signum;
            int i8 = i3 + signum;
            this.f12633c = i8;
            if (i8 < i5) {
                k(this.f12631a, i8, i5);
                this.f12633c = i5;
            }
            int i9 = this.f12633c;
            if (i9 > i6) {
                k(this.f12631a, i9, i6);
                this.f12633c = i6;
            }
        }

        void t(int i3, int i4, int i5) {
            if (this.f12646p == 0) {
                this.f12644n = i5;
                this.f12637g = AnimationUtils.currentAnimationTimeMillis();
                y(i3, i4, i4, (int) this.f12635e);
            }
        }

        void v(int i3) {
            this.f12633c = i3;
            this.f12642l = i3 - this.f12631a;
            this.f12643m = false;
        }

        void w(float f3) {
            this.f12645o = f3;
        }

        boolean x(int i3, int i4, int i5) {
            this.f12643m = true;
            this.f12632b = i3;
            this.f12631a = i3;
            this.f12633c = i3;
            this.f12634d = 0;
            this.f12637g = AnimationUtils.currentAnimationTimeMillis();
            this.f12638h = 0;
            if (i3 < i4) {
                B(i3, i4, 0);
            } else if (i3 > i5) {
                B(i3, i5, 0);
            }
            return !this.f12643m;
        }
    }

    public c(Context context) {
        this(context, null);
    }

    @Override // o0.b
    public float a() {
        return this.f12623a.f12635e;
    }

    @Override // android.widget.OverScroller, o0.b
    public void abortAnimation() {
        this.f12623a.m();
        this.f12624b.m();
        this.f12627e.b(false);
    }

    @Override // o0.b
    public int b() {
        return this.f12623a.f12632b;
    }

    @Override // o0.b
    public int c() {
        return this.f12624b.f12633c;
    }

    @Override // android.widget.OverScroller, o0.b
    public boolean computeScrollOffset() {
        if (g()) {
            return false;
        }
        int i3 = this.f12626d;
        if (i3 == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f12623a.f12637g;
            int i4 = this.f12623a.f12638h;
            if (currentAnimationTimeMillis < i4) {
                float interpolation = this.f12625c.getInterpolation(currentAnimationTimeMillis / i4);
                this.f12623a.D(interpolation);
                this.f12624b.D(interpolation);
            } else {
                abortAnimation();
            }
        } else if (i3 == 1) {
            if (!this.f12623a.f12643m && !this.f12623a.C() && !this.f12623a.l()) {
                this.f12623a.m();
            }
            if (!this.f12624b.f12643m && !this.f12624b.C() && !this.f12624b.l()) {
                this.f12624b.m();
            }
        }
        return true;
    }

    @Override // o0.b
    public void d(Interpolator interpolator) {
        if (interpolator == null) {
            this.f12625c = f12622f;
        } else {
            this.f12625c = interpolator;
        }
    }

    @Override // o0.b
    public void e(float f3) {
        this.f12623a.f12635e = f3;
    }

    @Override // o0.b
    public float f() {
        return this.f12624b.f12635e;
    }

    @Override // android.widget.OverScroller, o0.b
    public void fling(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        fling(i3, i4, i5, i6, i7, i8, i9, i10, 0, 0);
    }

    @Override // o0.b
    public boolean g() {
        return this.f12623a.f12643m && this.f12624b.f12643m;
    }

    @Override // android.widget.OverScroller
    public float getCurrVelocity() {
        return (float) Math.hypot(this.f12623a.f12635e, this.f12624b.f12635e);
    }

    @Override // o0.b
    public int h() {
        return this.f12623a.f12633c;
    }

    @Override // o0.b
    public int i() {
        return this.f12624b.f12632b;
    }

    public boolean isScrollingInDirection(float f3, float f4) {
        return !isFinished() && Math.signum(f3) == Math.signum((float) (this.f12623a.f12633c - this.f12623a.f12631a)) && Math.signum(f4) == Math.signum((float) (this.f12624b.f12633c - this.f12624b.f12631a));
    }

    @Override // o0.b
    public void j(float f3) {
        this.f12624b.f12635e = f3;
    }

    public void k(boolean z3) {
        this.f12627e.a(z3);
    }

    public void l(int i3, int i4, int i5, int i6) {
        this.f12626d = 1;
        this.f12623a.o(i3, i5, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, 0);
        this.f12624b.o(i4, i6, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, 0);
        this.f12627e.b(true);
    }

    public void m(float f3) {
        this.f12623a.f12639i = f3;
        this.f12624b.f12639i = f3;
    }

    public void n(float f3) {
        this.f12623a.w(f3);
        this.f12624b.w(f3);
    }

    @Override // android.widget.OverScroller, o0.b
    public void notifyHorizontalEdgeReached(int i3, int i4, int i5) {
        this.f12623a.t(i3, i4, i5);
        springBack(i3, 0, 0, 0, 0, 0);
    }

    @Override // android.widget.OverScroller, o0.b
    public void notifyVerticalEdgeReached(int i3, int i4, int i5) {
        this.f12624b.t(i3, i4, i5);
        springBack(0, i3, 0, 0, 0, 0);
    }

    public void o(float f3) {
        this.f12623a.f12640j = f3;
    }

    public void p(float f3) {
        this.f12624b.f12640j = f3;
    }

    @Override // o0.b
    public void setFinalX(int i3) {
        if (i3 == -1) {
            return;
        }
        this.f12623a.v(i3);
    }

    public void setFinalY(int i3) {
        if (i3 == -1) {
            return;
        }
        this.f12624b.v(i3);
    }

    @Override // android.widget.OverScroller, o0.b
    public boolean springBack(int i3, int i4, int i5, int i6, int i7, int i8) {
        boolean x3 = this.f12623a.x(i3, i5, i6);
        boolean x4 = this.f12624b.x(i4, i7, i8);
        if (x3 || x4) {
            this.f12626d = 1;
        }
        return x3 || x4;
    }

    @Override // android.widget.OverScroller, o0.b
    public void startScroll(int i3, int i4, int i5, int i6) {
        startScroll(i3, i4, i5, i6, 250);
    }

    public c(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f12623a = new b(context);
        this.f12624b = new b(context);
        if (interpolator == null) {
            this.f12625c = f12622f;
        } else {
            this.f12625c = interpolator;
        }
        this.f12627e = new d(false);
    }

    @Override // android.widget.OverScroller, o0.b
    public void fling(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        if (i4 > i10 || i4 < i9) {
            springBack(i3, i4, i7, i8, i9, i10);
        } else {
            l(i3, i4, i5, i6);
        }
    }

    @Override // android.widget.OverScroller, o0.b
    public void startScroll(int i3, int i4, int i5, int i6, int i7) {
        this.f12626d = 0;
        this.f12623a.A(i3, i5, i7);
        this.f12624b.A(i4, i6, i7);
        this.f12627e.b(true);
    }
}
