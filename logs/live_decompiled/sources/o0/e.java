package o0;

import Y.h;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.preference.Preference;
import h0.AbstractC0371a;
import java.lang.reflect.Method;
import y0.j;

/* loaded from: classes.dex */
public class e extends OverScroller implements o0.b {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f12650p;

    /* renamed from: q, reason: collision with root package name */
    private static float f12651q;

    /* renamed from: r, reason: collision with root package name */
    private static float f12652r;

    /* renamed from: a, reason: collision with root package name */
    private c f12653a;

    /* renamed from: b, reason: collision with root package name */
    private c f12654b;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f12655c;

    /* renamed from: d, reason: collision with root package name */
    private int f12656d;

    /* renamed from: e, reason: collision with root package name */
    private Context f12657e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f12658f;

    /* renamed from: g, reason: collision with root package name */
    private int f12659g;

    /* renamed from: h, reason: collision with root package name */
    private long f12660h;

    /* renamed from: i, reason: collision with root package name */
    private float f12661i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12662j;

    /* renamed from: k, reason: collision with root package name */
    private long f12663k;

    /* renamed from: l, reason: collision with root package name */
    private long f12664l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f12665m;

    /* renamed from: n, reason: collision with root package name */
    private d f12666n;

    /* renamed from: o, reason: collision with root package name */
    private final Choreographer.FrameCallback f12667o;

    class a implements Choreographer.FrameCallback {
        a() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j3) {
            if (e.this.f12653a != null) {
                e.this.f12653a.L(j3);
            }
            if (e.this.f12654b != null) {
                e.this.f12654b.L(j3);
            }
            e eVar = e.this;
            eVar.f12663k = eVar.f12664l;
            e.this.f12664l = j3;
            e.this.f12665m = true;
            if (e.this.f12662j) {
                return;
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    static class b implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        private static final float f12669a;

        /* renamed from: b, reason: collision with root package name */
        private static final float f12670b;

        static {
            float a3 = 1.0f / a(1.0f);
            f12669a = a3;
            f12670b = 1.0f - (a3 * a(1.0f));
        }

        b() {
        }

        private static float a(float f3) {
            float f4 = f3 * 8.0f;
            return f4 < 1.0f ? f4 - (1.0f - ((float) Math.exp(-f4))) : 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f4))) * 0.63212055f);
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f3) {
            float a3 = f12669a * a(f3);
            return a3 > 0.0f ? a3 + f12670b : a3;
        }
    }

    static class c {

        /* renamed from: N, reason: collision with root package name */
        private static float f12671N = 1.0f;

        /* renamed from: O, reason: collision with root package name */
        private static double f12672O = 2.5d;

        /* renamed from: P, reason: collision with root package name */
        private static double f12673P = 2.5d;

        /* renamed from: Q, reason: collision with root package name */
        private static float f12674Q = 0.2f;

        /* renamed from: A, reason: collision with root package name */
        private boolean f12675A;

        /* renamed from: B, reason: collision with root package name */
        private boolean f12676B;

        /* renamed from: C, reason: collision with root package name */
        private Choreographer f12677C;

        /* renamed from: D, reason: collision with root package name */
        private double f12678D;

        /* renamed from: E, reason: collision with root package name */
        private int f12679E;

        /* renamed from: F, reason: collision with root package name */
        private int f12680F;

        /* renamed from: G, reason: collision with root package name */
        private int f12681G;

        /* renamed from: H, reason: collision with root package name */
        private int f12682H;

        /* renamed from: I, reason: collision with root package name */
        private int f12683I;

        /* renamed from: J, reason: collision with root package name */
        private boolean f12684J;

        /* renamed from: K, reason: collision with root package name */
        private boolean f12685K;

        /* renamed from: L, reason: collision with root package name */
        private h f12686L;

        /* renamed from: M, reason: collision with root package name */
        private Method f12687M;

        /* renamed from: a, reason: collision with root package name */
        private b f12688a;

        /* renamed from: b, reason: collision with root package name */
        private b f12689b;

        /* renamed from: c, reason: collision with root package name */
        private b f12690c;

        /* renamed from: d, reason: collision with root package name */
        private a f12691d = new a();

        /* renamed from: e, reason: collision with root package name */
        private a f12692e = new a();

        /* renamed from: f, reason: collision with root package name */
        private a f12693f = new a();

        /* renamed from: g, reason: collision with root package name */
        private float f12694g;

        /* renamed from: h, reason: collision with root package name */
        private double f12695h;

        /* renamed from: i, reason: collision with root package name */
        private double f12696i;

        /* renamed from: j, reason: collision with root package name */
        private double f12697j;

        /* renamed from: k, reason: collision with root package name */
        private double f12698k;

        /* renamed from: l, reason: collision with root package name */
        private int f12699l;

        /* renamed from: m, reason: collision with root package name */
        private int f12700m;

        /* renamed from: n, reason: collision with root package name */
        private int f12701n;

        /* renamed from: o, reason: collision with root package name */
        private long f12702o;

        /* renamed from: p, reason: collision with root package name */
        private int f12703p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f12704q;

        /* renamed from: r, reason: collision with root package name */
        private boolean f12705r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f12706s;

        /* renamed from: t, reason: collision with root package name */
        private float f12707t;

        /* renamed from: u, reason: collision with root package name */
        private long f12708u;

        /* renamed from: v, reason: collision with root package name */
        private long f12709v;

        /* renamed from: w, reason: collision with root package name */
        private long f12710w;

        /* renamed from: x, reason: collision with root package name */
        private long f12711x;

        /* renamed from: y, reason: collision with root package name */
        private long f12712y;

        /* renamed from: z, reason: collision with root package name */
        private long f12713z;

        static class a {

            /* renamed from: a, reason: collision with root package name */
            double f12714a;

            /* renamed from: b, reason: collision with root package name */
            double f12715b;

            a() {
            }
        }

        static class b {

            /* renamed from: a, reason: collision with root package name */
            double f12716a;

            /* renamed from: b, reason: collision with root package name */
            double f12717b;

            b(double d3, double d4) {
                this.f12716a = a((float) d3);
                this.f12717b = d((float) d4);
            }

            private float a(float f3) {
                if (f3 == 0.0f) {
                    return 0.0f;
                }
                return 25.0f + ((f3 - 8.0f) * 3.0f);
            }

            private double d(float f3) {
                if (f3 == 0.0f) {
                    return 0.0d;
                }
                return ((f3 - 30.0f) * 3.62f) + 194.0f;
            }

            void b(double d3) {
                this.f12716a = a((float) d3);
            }

            void c(double d3) {
                this.f12717b = d((float) d3);
            }
        }

        c() {
            float f3 = f12674Q;
            this.f12694g = f3;
            this.f12695h = 20.0d;
            this.f12696i = 0.05d;
            this.f12703p = 1;
            this.f12704q = false;
            this.f12707t = 0.83f;
            this.f12689b = new b(f3, 0.0d);
            this.f12690c = new b(12.1899995803833d, 16.0d);
            E(this.f12689b);
            this.f12684J = true;
            int f4 = j.f();
            if (f4 == 2) {
                f12672O = 3.799999952316284d;
                f12673P = 3.4000000953674316d;
            } else if (f4 >= 3) {
                f12672O = 4.5d;
                f12673P = 4.0d;
                f12674Q = 0.24f;
            }
        }

        private boolean B() {
            if (Math.abs(this.f12691d.f12715b) >= 5.0d) {
                return false;
            }
            if (!e.f12650p) {
                return true;
            }
            Log.d("SpringOverScroller", this + " lostVelocity");
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void L(long j3) {
            this.f12712y = this.f12713z;
            this.f12713z = j3;
            this.f12675A = true;
        }

        private void l() {
            if (this.f12705r || this.f12703p != 1) {
                return;
            }
            if (Math.abs(this.f12691d.f12715b) > 4000.0d && Math.abs(this.f12691d.f12715b) < 10000.0d) {
                this.f12688a.f12716a = f12672O;
            } else if (Math.abs(this.f12691d.f12715b) <= 4000.0d) {
                this.f12688a.f12716a = f12673P;
            }
        }

        private void m(float f3) {
            float interpolation = this.f12686L.getInterpolation(f3);
            a aVar = this.f12691d;
            aVar.f12714a = (this.f12683I * interpolation) + this.f12697j;
            aVar.f12715b = ((this.f12686L.b(f3) * this.f12683I) / this.f12681G) * 1000.0f;
            if (e.f12650p) {
                Log.d("SpringOverScroller", " calculateCurStateWithInterpolator fraction:" + f3 + ", ratio: " + interpolation + ", position : " + this.f12691d.f12714a + ", mVelocity: " + this.f12691d.f12715b);
            }
            this.f12703p++;
        }

        private int[] n(double d3, boolean z3) {
            a aVar = this.f12691d;
            int i3 = (int) aVar.f12714a;
            int i4 = (int) aVar.f12715b;
            int i5 = this.f12703p;
            boolean z4 = this.f12684J;
            a aVar2 = this.f12693f;
            aVar2.f12714a = 0.0d;
            aVar2.f12715b = 0.0d;
            float f3 = 1000.0f;
            float unused = e.f12652r = (w() / 1000000.0f) / 1000.0f;
            if (e.f12652r == 0.0f) {
                p();
            }
            if (e.f12650p) {
                Log.d("SpringOverScroller", this + " calculateFinalPosition finalValue " + d3 + " savedPosition " + i3 + " savedVelocity " + i4 + ", mRefreshTime: " + e.f12652r);
            }
            boolean z5 = true;
            this.f12703p = 1;
            boolean z6 = false;
            while (!this.f12684J) {
                double d4 = this.f12691d.f12714a;
                if (z3) {
                    m(((this.f12703p * e.f12652r) * f3) / this.f12681G);
                } else {
                    o();
                }
                double d5 = this.f12691d.f12714a;
                double abs = Math.abs(d5 - d4);
                if (B()) {
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " calculateFinalPosition lostVelocity");
                    }
                    this.f12684J = z5;
                }
                if (abs < this.f12678D) {
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " calculateFinalPosition deltaPosition < " + this.f12678D);
                    }
                    z5 = true;
                    this.f12684J = true;
                } else {
                    z5 = true;
                }
                if (d3 != -1.0d && !z6 && (d4 - d3) * (d5 - d3) <= 0.0d) {
                    this.f12691d.f12714a = d3;
                    if (z3) {
                        this.f12700m = (int) (this.f12703p * e.f12652r * 1000.0f);
                    } else {
                        this.f12679E = (int) (this.f12703p * e.f12652r * 1000.0f);
                    }
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " calculateFinalPosition reaching edge" + d3);
                    }
                    z6 = z5;
                }
                f3 = 1000.0f;
            }
            int i6 = (int) this.f12691d.f12714a;
            int i7 = (int) (this.f12703p * e.f12652r * 1000.0f);
            a aVar3 = this.f12691d;
            aVar3.f12714a = i3;
            aVar3.f12715b = i4;
            this.f12703p = i5;
            a aVar4 = this.f12693f;
            aVar4.f12714a = 0.0d;
            aVar4.f12715b = 0.0d;
            this.f12684J = z4;
            return new int[]{i6, i7};
        }

        private void o() {
            a aVar = this.f12691d;
            double d3 = aVar.f12714a;
            double d4 = aVar.f12715b;
            a aVar2 = this.f12693f;
            double d5 = aVar2.f12714a;
            double d6 = aVar2.f12715b;
            l();
            double d7 = this.f12688a.f12717b * (this.f12698k - d5);
            double d8 = ((e.f12652r * d7) / 2.0d) + d4;
            b bVar = this.f12688a;
            double d9 = (bVar.f12717b * (this.f12698k - (((e.f12652r * d4) / 2.0d) + d3))) - (bVar.f12716a * d8);
            double d10 = ((e.f12652r * d9) / 2.0d) + d4;
            b bVar2 = this.f12688a;
            double d11 = (bVar2.f12717b * (this.f12698k - (((e.f12652r * d8) / 2.0d) + d3))) - (bVar2.f12716a * d10);
            double d12 = (e.f12652r * d10) + d3;
            double d13 = (e.f12652r * d11) + d4;
            b bVar3 = this.f12688a;
            double d14 = (((d8 + d10) * 2.0d) + d4 + d13) * 0.16699999570846558d;
            double d15 = d4 + ((d7 + ((d9 + d11) * 2.0d) + ((bVar3.f12717b * (this.f12698k - d12)) - (bVar3.f12716a * d13))) * 0.16699999570846558d * e.f12652r);
            a aVar3 = this.f12693f;
            aVar3.f12715b = d13;
            aVar3.f12714a = d12;
            a aVar4 = this.f12691d;
            aVar4.f12715b = d15;
            aVar4.f12714a = d3 + (d14 * e.f12652r);
            if (e.f12650p) {
                Log.d("SpringOverScroller", " calculateOnceWithRebound, position : " + this.f12691d.f12714a + ", mVelocity: " + this.f12691d.f12715b + ",mTempState.mPosition:" + this.f12693f.f12714a + ",mTempState.mVelocity:" + this.f12693f.f12715b);
            }
            this.f12703p++;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i3, int i4, int i5, int i6, int i7) {
            if (e.f12650p) {
                Log.d("SpringOverScroller", this + " fling start " + i3 + " min " + i4 + " max " + i5 + " velocity " + i6 + " over " + i7);
            }
            this.f12678D = x(Math.abs(i6));
            this.f12684J = false;
            z(i3, i6);
            this.f12680F = 0;
            this.f12700m = 0;
            this.f12681G = 0;
            this.f12679E = 0;
            this.f12686L = new h(40.0d, 1.15d, i6, 1.0f, 15000.0f, true);
            z(i3, i6);
            float u3 = u(Math.abs(i6));
            float t3 = t(Math.abs(i6));
            double d3 = i6 >= 0 ? i5 : i4;
            int[] n3 = n(d3, false);
            int i8 = n3[0] - i3;
            int i9 = n3[1];
            int i10 = this.f12679E;
            if (i10 == 0) {
                i10 = i9;
            }
            this.f12679E = i10;
            this.f12683I = (int) (i8 * t3);
            this.f12681G = (int) (i9 * u3);
            int[] n4 = n(d3, true);
            this.f12682H = n4[0] - i3;
            int i11 = n4[1];
            this.f12680F = i11;
            int i12 = this.f12700m;
            if (i12 == 0) {
                i12 = i11;
            }
            this.f12700m = i12;
            this.f12685K = i11 == i12;
            if (e.f12650p) {
                Log.d("SpringOverScroller", this + " fling mStartTime " + this.f12708u + " mStart " + this.f12697j + " edge " + d3 + " distanceScale " + t3 + " durationScale " + u3 + " mWithSpring " + this.f12685K + " [ Distance_old " + i8 + " Distance_new " + this.f12682H + " ] [ SplineDuration_old " + i9 + " Duration_old " + this.f12679E + " SplineDuration_new " + this.f12680F + " Duration_new " + this.f12700m + " ]");
            }
            if (this.f12685K) {
                this.f12698k = Math.max(Math.min(r15, i5), i4);
                return;
            }
            this.f12682H = i8;
            this.f12680F = i9;
            this.f12700m = this.f12679E;
            this.f12698k = Math.max(Math.min(r11, i5), i4);
        }

        private float t(float f3) {
            float f4;
            float f5 = 1.0f;
            if (f3 <= 2000.0f) {
                return 1.0f;
            }
            if (f3 <= 6000.0f) {
                f4 = ((f3 - 2000.0f) / 4000.0f) * 0.19999999f;
            } else {
                f5 = 0.8f;
                if (f3 <= 10000.0f) {
                    return 0.8f;
                }
                if (f3 > 20000.0f) {
                    return 0.4f;
                }
                f4 = ((f3 - 10000.0f) / 10000.0f) * 0.4f;
            }
            return f5 - f4;
        }

        private float u(float f3) {
            float f4;
            float f5;
            float f6 = 1.3f;
            if (f3 <= 2000.0f) {
                return 1.3f;
            }
            if (f3 <= 6000.0f) {
                f4 = (f3 - 2000.0f) / 4000.0f;
                f5 = 0.49999994f;
            } else {
                f6 = 0.8f;
                if (f3 <= 10000.0f) {
                    return 0.8f;
                }
                if (f3 > 20000.0f) {
                    return 0.5f;
                }
                f4 = (f3 - 10000.0f) / 10000.0f;
                f5 = 0.3f;
            }
            return f6 - (f4 * f5);
        }

        private long w() {
            try {
                if (this.f12677C == null) {
                    this.f12677C = Choreographer.getInstance();
                }
                if (this.f12687M == null) {
                    Method declaredMethod = Class.forName("android.view.Choreographer").getDeclaredMethod("getFrameIntervalNanos", null);
                    this.f12687M = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                return ((Long) this.f12687M.invoke(this.f12677C, null)).longValue();
            } catch (Exception e3) {
                if (!e.f12650p) {
                    return 0L;
                }
                Log.e("SpringOverScroller", "getFrameIntervalNanos error" + e3);
                return 0L;
            }
        }

        private double x(float f3) {
            double d3 = f3;
            if (d3 <= 5000.0d) {
                return 0.2d;
            }
            return d3 <= 8000.0d ? 0.3d : 0.35d;
        }

        boolean A() {
            return Math.abs(this.f12691d.f12715b) <= this.f12695h && (s(this.f12691d) <= this.f12696i || this.f12688a.f12717b == 0.0d);
        }

        void C(int i3, int i4, int i5) {
            a aVar = this.f12691d;
            aVar.f12714a = i3;
            a aVar2 = this.f12692e;
            aVar2.f12714a = 0.0d;
            aVar2.f12715b = 0.0d;
            a aVar3 = this.f12693f;
            aVar3.f12714a = i4;
            aVar3.f12715b = aVar.f12715b;
        }

        void D() {
            a aVar = this.f12691d;
            double d3 = aVar.f12714a;
            this.f12698k = d3;
            this.f12693f.f12714a = d3;
            aVar.f12715b = 0.0d;
            this.f12705r = false;
            this.f12676B = true;
        }

        void E(b bVar) {
            if (bVar == null) {
                throw new IllegalArgumentException("springConfig is required");
            }
            this.f12688a = bVar;
        }

        void F(double d3, boolean z3) {
            this.f12697j = d3;
            if (!this.f12704q) {
                this.f12692e.f12714a = 0.0d;
                this.f12693f.f12714a = 0.0d;
            }
            this.f12691d.f12714a = d3;
            if (z3) {
                D();
            }
        }

        void G(double d3) {
            if (this.f12698k == d3) {
                return;
            }
            this.f12697j = r();
            this.f12698k = d3;
            this.f12684J = false;
        }

        void H(double d3) {
            if (Math.abs(d3 - this.f12691d.f12715b) < 1.0000000116860974E-7d) {
                return;
            }
            this.f12691d.f12715b = d3;
        }

        boolean I(int i3, int i4, int i5) {
            F(i3, false);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12710w = elapsedRealtime;
            this.f12711x = elapsedRealtime;
            if (i3 <= i5 && i3 >= i4) {
                E(new b(this.f12694g, 0.0d));
                return false;
            }
            if (i3 > i5) {
                G(i5);
            } else if (i3 < i4) {
                G(i4);
            }
            this.f12705r = true;
            this.f12690c.b(e.f12651q);
            this.f12690c.c(this.f12707t * 16.0f);
            E(this.f12690c);
            return true;
        }

        void J(int i3, int i4, int i5, long j3) {
            this.f12699l = i3;
            int i6 = i3 + i4;
            this.f12701n = i6;
            this.f12698k = i6;
            this.f12700m = i5;
            this.f12702o = j3;
            E(this.f12689b);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12710w = elapsedRealtime;
            this.f12711x = elapsedRealtime;
        }

        boolean K() {
            String str;
            p();
            String str2 = "SpringOverScroller";
            if (!this.f12705r) {
                if (A()) {
                    this.f12676B = true;
                }
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float w3 = w();
                if (w3 != 0.0f) {
                    float unused = e.f12652r = Math.min((w3 / 1000.0f) / 1000000.0f, (currentAnimationTimeMillis - this.f12709v) / 1000.0f);
                }
                this.f12709v = currentAnimationTimeMillis;
                double d3 = this.f12691d.f12714a;
                if (!this.f12685K || this.f12705r) {
                    o();
                } else {
                    if (this.f12681G <= 0) {
                        if (e.f12650p) {
                            Log.d("SpringOverScroller", this + " update end : SPLINE OSpring error duration");
                        }
                        return false;
                    }
                    m(Math.max(currentAnimationTimeMillis - this.f12708u, 0.0f) / this.f12681G);
                }
                double d4 = this.f12691d.f12714a;
                double abs = Math.abs(d4 - d3);
                if (!this.f12685K && abs < this.f12678D && e.f12652r != 0.0f) {
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " update end : deltaPosition < 0.2");
                    }
                    return false;
                }
                if (this.f12685K && B()) {
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " update end : lostVelocity when BALLISTIC (or only SPLINE)");
                    }
                    return false;
                }
                double d5 = this.f12698k;
                if ((d3 - d5) * (d4 - d5) <= 0.0d) {
                    this.f12691d.f12714a = d5;
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " update end : reaching final " + this.f12698k);
                    }
                    return false;
                }
                if (Double.isNaN(this.f12691d.f12715b) || Double.isNaN(this.f12691d.f12714a)) {
                    if (e.f12650p) {
                        Log.d("SpringOverScroller", this + " update end : mVelocity or mPosition NaN ");
                    }
                    return false;
                }
                str = "SpringOverScroller";
            } else {
                if (A()) {
                    return false;
                }
                a aVar = this.f12691d;
                double d6 = aVar.f12714a;
                double d7 = aVar.f12715b;
                a aVar2 = this.f12693f;
                double d8 = aVar2.f12714a;
                double d9 = aVar2.f12715b;
                double s3 = s(aVar);
                if (!this.f12706s && s3 < 180.0d) {
                    this.f12706s = true;
                } else if (s3 < 0.25d) {
                    this.f12691d.f12714a = this.f12698k;
                    this.f12706s = false;
                    this.f12705r = false;
                    this.f12676B = true;
                    return false;
                }
                double d10 = d6;
                while (true) {
                    String str3 = str2;
                    double d11 = this.f12688a.f12717b * (this.f12698k - d8);
                    double d12 = ((e.f12652r * d11) / 2.0d) + d7;
                    b bVar = this.f12688a;
                    double d13 = d6;
                    double d14 = (bVar.f12717b * (this.f12698k - (((e.f12652r * d7) / 2.0d) + d10))) - (bVar.f12716a * d12);
                    double d15 = ((e.f12652r * d14) / 2.0d) + d7;
                    str = str3;
                    b bVar2 = this.f12688a;
                    double d16 = (bVar2.f12717b * (this.f12698k - (((e.f12652r * d12) / 2.0d) + d10))) - (bVar2.f12716a * d15);
                    d8 = d10 + (e.f12652r * d15);
                    double d17 = (e.f12652r * d16) + d7;
                    b bVar3 = this.f12688a;
                    double d18 = (((d12 + d15) * 2.0d) + d7 + d17) * 0.16699999570846558d;
                    d10 += d18 * e.f12652r;
                    d7 += (d11 + ((d14 + d16) * 2.0d) + ((bVar3.f12717b * (this.f12698k - d8)) - (bVar3.f12716a * d17))) * 0.16699999570846558d * e.f12652r;
                    a aVar3 = this.f12693f;
                    aVar3.f12715b = d17;
                    aVar3.f12714a = d8;
                    a aVar4 = this.f12691d;
                    aVar4.f12715b = d7;
                    aVar4.f12714a = d10;
                    if (Math.abs(d13 - d10) > 0.20000000298023224d || !this.f12705r || A()) {
                        break;
                    }
                    str2 = str;
                    d6 = d13;
                }
                this.f12703p++;
            }
            if (!e.f12650p) {
                return true;
            }
            Log.d(str, this + " <<< FLING_MODE: update mSplineDuration:" + this.f12680F + " ,elapsedInternalTime:" + (this.f12709v - this.f12708u) + " ,mFinal:" + this.f12698k + " ,position:" + this.f12691d.f12714a + " ,velocity:" + this.f12691d.f12715b + " ,tension: " + this.f12688a.f12717b + " ,friction: " + this.f12688a.f12716a + " ,mOplusCount:" + this.f12703p + " >>> ");
            return true;
        }

        void M(float f3) {
            a aVar = this.f12691d;
            int i3 = this.f12699l;
            aVar.f12714a = i3 + Math.round(f3 * (this.f12701n - i3));
        }

        void p() {
            this.f12711x = SystemClock.elapsedRealtime();
            if (this.f12675A) {
                this.f12675A = false;
                if (e.f12650p) {
                    Log.d("SpringOverScroller", "update if: " + ((this.f12713z - this.f12712y) / 1.0E9f));
                }
                float unused = e.f12652r = Math.max(0.008f, (this.f12713z - this.f12712y) / 1.0E9f);
            } else {
                if (e.f12650p) {
                    Log.d("SpringOverScroller", "update else: " + ((this.f12711x - this.f12710w) / 1000.0f));
                }
                float unused2 = e.f12652r = Math.max(0.008f, (this.f12711x - this.f12710w) / 1000.0f);
            }
            if (e.f12652r > 0.025f) {
                if (e.f12650p) {
                    Log.d("SpringOverScroller", "update: error mRefreshTime = " + e.f12652r);
                }
                float unused3 = e.f12652r = 0.008f;
            }
            if (e.f12650p) {
                Log.d("SpringOverScroller", "update: mRefreshTime = " + e.f12652r + " mLastComputeTime = " + this.f12710w);
            }
            this.f12710w = this.f12711x;
        }

        double r() {
            return this.f12691d.f12714a;
        }

        double s(a aVar) {
            return Math.abs(this.f12698k - aVar.f12714a);
        }

        double v() {
            return this.f12698k;
        }

        double y() {
            return this.f12691d.f12715b;
        }

        void z(int i3, int i4) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f12708u = currentAnimationTimeMillis;
            this.f12709v = currentAnimationTimeMillis;
            this.f12703p = 1;
            f12671N = 1.0f;
            this.f12689b.b(this.f12694g);
            this.f12689b.c(0.0d);
            E(this.f12689b);
            F(i3, true);
            H(i4);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f12710w = elapsedRealtime;
            this.f12711x = elapsedRealtime;
        }
    }

    static {
        f12650p = AbstractC0371a.f11873b || AbstractC0371a.e("SpringOverScroller", 3);
        f12651q = 12.19f;
    }

    public e(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f12656d = 2;
        this.f12658f = true;
        this.f12661i = 1.0f;
        this.f12665m = false;
        this.f12667o = new a();
        this.f12653a = new c();
        this.f12654b = new c();
        if (interpolator == null) {
            this.f12655c = new b();
        } else {
            this.f12655c = interpolator;
        }
        F(0.016f);
        this.f12657e = context;
        this.f12666n = new d(false);
    }

    private void B() {
        this.f12660h = 0L;
        this.f12659g = 0;
        this.f12661i = 1.0f;
    }

    private void F(float f3) {
        f12652r = f3;
    }

    private static synchronized void I(float f3) {
        synchronized (e.class) {
            f12651q = f3;
        }
    }

    private int x(int i3) {
        if (!this.f12658f) {
            return i3;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = this.f12659g;
        if (i4 <= 0) {
            if (i4 != 0) {
                return i3;
            }
            this.f12659g = i4 + 1;
            this.f12660h = currentTimeMillis;
            return i3;
        }
        if (currentTimeMillis - this.f12660h > 500 || i3 < 8000) {
            B();
            return i3;
        }
        this.f12660h = currentTimeMillis;
        int i5 = i4 + 1;
        this.f12659g = i5;
        if (i5 <= 4) {
            return i3;
        }
        float f3 = this.f12661i * 1.4f;
        this.f12661i = f3;
        return Math.max(-70000, Math.min((int) (i3 * f3), 70000));
    }

    void A() {
        if (f12650p) {
            Log.d("SpringOverScroller", "removeChoreographerCallback: remove Callback");
        }
        Choreographer.getInstance().removeFrameCallback(this.f12667o);
    }

    public void C(boolean z3) {
        f12650p = z3;
    }

    public void D(boolean z3) {
        if (this.f12658f == z3) {
            return;
        }
        this.f12658f = z3;
        B();
    }

    public void E(boolean z3) {
        this.f12653a.f12704q = z3;
        this.f12654b.f12704q = z3;
    }

    public void G(float f3) {
        I(f3);
    }

    public void H(float f3) {
        this.f12653a.f12707t = f3;
        this.f12654b.f12707t = f3;
    }

    public void J() {
        A();
        z();
        this.f12662j = false;
        this.f12653a.f12676B = false;
        this.f12654b.f12676B = false;
    }

    @Override // o0.b
    public float a() {
        return (float) this.f12653a.y();
    }

    @Override // android.widget.OverScroller, o0.b
    public void abortAnimation() {
        if (f12650p) {
            Log.d("SpringOverScroller", "abortAnimation", new Throwable());
        }
        this.f12656d = 2;
        this.f12653a.D();
        this.f12654b.D();
        this.f12662j = true;
        this.f12666n.b(false);
    }

    @Override // o0.b
    public final int b() {
        return (int) Math.round(this.f12653a.r());
    }

    @Override // o0.b
    public final int c() {
        return (int) this.f12654b.v();
    }

    @Override // android.widget.OverScroller, o0.b
    public boolean computeScrollOffset() {
        if (g()) {
            this.f12662j = this.f12653a.f12676B && this.f12654b.f12676B;
            return false;
        }
        int i3 = this.f12656d;
        if (i3 == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f12653a.f12702o;
            int i4 = this.f12653a.f12700m;
            if (currentAnimationTimeMillis < i4) {
                float interpolation = this.f12655c.getInterpolation(currentAnimationTimeMillis / i4);
                this.f12653a.M(interpolation);
                this.f12654b.M(interpolation);
            } else {
                this.f12653a.M(1.0f);
                this.f12654b.M(1.0f);
                abortAnimation();
            }
        } else if (i3 == 1 && !this.f12653a.K() && !this.f12654b.K()) {
            abortAnimation();
        }
        return true;
    }

    @Override // o0.b
    public void d(Interpolator interpolator) {
        if (interpolator == null) {
            this.f12655c = new b();
        } else {
            this.f12655c = interpolator;
        }
    }

    @Override // o0.b
    public void e(float f3) {
        this.f12653a.f12691d.f12715b = f3;
    }

    @Override // o0.b
    public float f() {
        return (float) this.f12654b.y();
    }

    @Override // android.widget.OverScroller, o0.b
    public void fling(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        fling(i3, i4, i5, i6, i7, i8, i9, i10);
    }

    @Override // o0.b
    public final boolean g() {
        boolean A3 = this.f12653a.A();
        boolean A4 = this.f12654b.A();
        if (f12650p) {
            Log.d("SpringOverScroller", "scrollX is rest: " + this.f12653a.A() + "  scrollY is rest: " + this.f12654b.A() + "  mMode = " + this.f12656d);
        }
        return A3 && A4 && this.f12656d != 0;
    }

    @Override // android.widget.OverScroller
    public float getCurrVelocity() {
        double y3 = this.f12653a.y();
        double y4 = this.f12654b.y();
        return (int) Math.sqrt((y3 * y3) + (y4 * y4));
    }

    @Override // o0.b
    public final int h() {
        return (int) this.f12653a.v();
    }

    @Override // o0.b
    public final int i() {
        return (int) Math.round(this.f12654b.r());
    }

    public boolean isScrollingInDirection(float f3, float f4) {
        return !isFinished() && Math.signum(f3) == Math.signum((float) ((int) (this.f12653a.f12698k - this.f12653a.f12697j))) && Math.signum(f4) == Math.signum((float) ((int) (this.f12654b.f12698k - this.f12654b.f12697j)));
    }

    @Override // o0.b
    public void j(float f3) {
        this.f12654b.f12691d.f12715b = f3;
    }

    @Override // android.widget.OverScroller, o0.b
    public void notifyHorizontalEdgeReached(int i3, int i4, int i5) {
        this.f12653a.C(i3, i4, i5);
        springBack(i3, 0, 0, i4, 0, 0);
    }

    @Override // android.widget.OverScroller, o0.b
    public void notifyVerticalEdgeReached(int i3, int i4, int i5) {
        this.f12654b.C(i3, i4, i5);
        springBack(0, i3, 0, 0, 0, i4);
    }

    @Override // o0.b
    public void setFinalX(int i3) {
    }

    public void setFinalY(int i3) {
    }

    @Override // android.widget.OverScroller, o0.b
    public boolean springBack(int i3, int i4, int i5, int i6, int i7, int i8) {
        if (f12650p) {
            Log.d("SpringOverScroller", "springBack startX = " + i3 + " startY = " + i4 + " minX = " + i5 + " minY = " + i7 + " maxY = " + i8, new Throwable());
        }
        boolean I3 = this.f12653a.I(i3, i5, i6);
        boolean I4 = this.f12654b.I(i4, i7, i8);
        if (I3 || I4) {
            this.f12656d = 1;
        }
        return I3 || I4;
    }

    @Override // android.widget.OverScroller, o0.b
    public void startScroll(int i3, int i4, int i5, int i6) {
        startScroll(i3, i4, i5, i6, 250);
    }

    public void u() {
        this.f12662j = true;
    }

    public void v(boolean z3) {
        this.f12666n.a(z3);
    }

    public void w(int i3, int i4, int i5, int i6) {
        if (f12650p) {
            Log.d("SpringOverScroller", "fling startX = " + i3 + " startY = " + i4 + " velocityX = " + i5 + " velocityY = " + i6, new Throwable());
        }
        this.f12656d = 1;
        this.f12653a.q(i3, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, x(i5), 0);
        this.f12654b.q(i4, Integer.MIN_VALUE, Preference.DEFAULT_ORDER, x(i6), 0);
        this.f12666n.b(true);
    }

    public boolean y() {
        return this.f12658f;
    }

    void z() {
        if (f12650p) {
            Log.d("SpringOverScroller", "postChoreographerCallback: post Callback");
        }
        Choreographer.getInstance().postFrameCallback(this.f12667o);
    }

    @Override // android.widget.OverScroller, o0.b
    public void fling(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        w(i3, i4, i5, i6);
    }

    @Override // android.widget.OverScroller, o0.b
    public void startScroll(int i3, int i4, int i5, int i6, int i7) {
        if (f12650p) {
            Log.d("SpringOverScroller", "startScroll startX = " + i3 + " startY = " + i4 + " dx = " + i5 + " dy = " + i6 + " duration = " + i7, new Throwable());
        }
        this.f12656d = 0;
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f12653a.J(i3, i5, i7, currentAnimationTimeMillis);
        this.f12654b.J(i4, i6, i7, currentAnimationTimeMillis);
        this.f12666n.b(true);
    }

    public e(Context context) {
        this(context, null);
    }
}
