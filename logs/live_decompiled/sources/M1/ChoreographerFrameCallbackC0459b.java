package m1;

import a1.C0221a;
import a1.v;
import android.view.Choreographer;
import com.oplus.wrapper.os.Trace;

/* renamed from: m1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class ChoreographerFrameCallbackC0459b extends AbstractC0458a implements Choreographer.FrameCallback {

    /* renamed from: h, reason: collision with root package name */
    private String f12406h;

    /* renamed from: q, reason: collision with root package name */
    private C0221a f12415q;

    /* renamed from: i, reason: collision with root package name */
    private float f12407i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12408j = false;

    /* renamed from: k, reason: collision with root package name */
    private long f12409k = 0;

    /* renamed from: l, reason: collision with root package name */
    private float f12410l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f12411m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private int f12412n = 0;

    /* renamed from: o, reason: collision with root package name */
    private float f12413o = -2.14748365E9f;

    /* renamed from: p, reason: collision with root package name */
    private float f12414p = 2.14748365E9f;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f12416r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12417s = false;

    public ChoreographerFrameCallbackC0459b() {
        this.f12406h = "";
        this.f12406h = AbstractC0465h.g();
    }

    private void G() {
        if (this.f12415q == null) {
            return;
        }
        float f3 = this.f12411m;
        if (f3 < this.f12413o || f3 > this.f12414p) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f12413o), Float.valueOf(this.f12414p), Float.valueOf(this.f12411m)));
        }
    }

    private float l() {
        C0221a c0221a = this.f12415q;
        if (c0221a == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / c0221a.i()) / Math.abs(this.f12407i);
    }

    private boolean p() {
        return o() < 0.0f;
    }

    private void q() {
        if (this.f12406h.isEmpty()) {
            return;
        }
        try {
            Trace.asyncTraceEnd(Trace.TRACE_TAG_VIEW, "lottie_animator", System.identityHashCode(this));
        } catch (Error | Exception unused) {
        }
    }

    private void r() {
        if (this.f12406h.isEmpty()) {
            return;
        }
        try {
            long j3 = Trace.TRACE_TAG_VIEW;
            Trace.traceBegin(j3, "AnimatorStart " + this.f12406h);
            Trace.traceEnd(j3);
            Trace.asyncTraceBegin(j3, "lottie_animator", System.identityHashCode(this));
        } catch (Error | Exception unused) {
        }
    }

    public void A(float f3) {
        if (this.f12410l == f3) {
            return;
        }
        float b3 = AbstractC0464g.b(f3, n(), m());
        this.f12410l = b3;
        if (this.f12417s) {
            b3 = (float) Math.floor(b3);
        }
        this.f12411m = b3;
        this.f12409k = 0L;
        g();
    }

    public void B(float f3) {
        C(this.f12413o, f3);
    }

    public void C(float f3, float f4) {
        if (f3 > f4) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f3), Float.valueOf(f4)));
        }
        C0221a c0221a = this.f12415q;
        float p3 = c0221a == null ? -3.4028235E38f : c0221a.p();
        C0221a c0221a2 = this.f12415q;
        float f5 = c0221a2 == null ? Float.MAX_VALUE : c0221a2.f();
        float b3 = AbstractC0464g.b(f3, p3, f5);
        float b4 = AbstractC0464g.b(f4, p3, f5);
        if (b3 == this.f12413o && b4 == this.f12414p) {
            return;
        }
        this.f12413o = b3;
        this.f12414p = b4;
        A((int) AbstractC0464g.b(this.f12411m, b3, b4));
    }

    public void D(int i3) {
        C(i3, (int) this.f12414p);
    }

    public void E(float f3) {
        this.f12407i = f3;
    }

    public void F(boolean z3) {
        this.f12417s = z3;
    }

    @Override // m1.AbstractC0458a
    void a() {
        super.a();
        b(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        q();
        a();
        v();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        u();
        if (this.f12415q == null || !isRunning()) {
            return;
        }
        v.a("LottieValueAnimator#doFrame");
        float l3 = (this.f12409k != 0 ? j3 - r1 : 0L) / l();
        float f3 = this.f12410l;
        if (p()) {
            l3 = -l3;
        }
        float f4 = f3 + l3;
        boolean d3 = AbstractC0464g.d(f4, n(), m());
        float f5 = this.f12410l;
        float b3 = AbstractC0464g.b(f4, n(), m());
        this.f12410l = b3;
        if (this.f12417s) {
            b3 = (float) Math.floor(b3);
        }
        this.f12411m = b3;
        this.f12409k = j3;
        if (!this.f12417s || this.f12410l != f5) {
            g();
        }
        if (!d3) {
            if (getRepeatCount() == -1 || this.f12412n < getRepeatCount()) {
                r();
                d();
                this.f12412n++;
                if (getRepeatMode() == 2) {
                    this.f12408j = !this.f12408j;
                    y();
                } else {
                    float m3 = p() ? m() : n();
                    this.f12410l = m3;
                    this.f12411m = m3;
                }
                this.f12409k = j3;
            } else {
                float n3 = this.f12407i < 0.0f ? n() : m();
                this.f12410l = n3;
                this.f12411m = n3;
                v();
                q();
                b(p());
            }
        }
        G();
        v.b("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float n3;
        float m3;
        float n4;
        if (this.f12415q == null) {
            return 0.0f;
        }
        if (p()) {
            n3 = m() - this.f12411m;
            m3 = m();
            n4 = n();
        } else {
            n3 = this.f12411m - n();
            m3 = m();
            n4 = n();
        }
        return n3 / (m3 - n4);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(j());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        C0221a c0221a = this.f12415q;
        if (c0221a == null) {
            return 0L;
        }
        return (long) c0221a.d();
    }

    public void h() {
        this.f12415q = null;
        this.f12413o = -2.14748365E9f;
        this.f12414p = 2.14748365E9f;
    }

    public void i() {
        v();
        q();
        b(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f12416r;
    }

    public float j() {
        C0221a c0221a = this.f12415q;
        if (c0221a == null) {
            return 0.0f;
        }
        return (this.f12411m - c0221a.p()) / (this.f12415q.f() - this.f12415q.p());
    }

    public float k() {
        return this.f12411m;
    }

    public float m() {
        C0221a c0221a = this.f12415q;
        if (c0221a == null) {
            return 0.0f;
        }
        float f3 = this.f12414p;
        return f3 == 2.14748365E9f ? c0221a.f() : f3;
    }

    public float n() {
        C0221a c0221a = this.f12415q;
        if (c0221a == null) {
            return 0.0f;
        }
        float f3 = this.f12413o;
        return f3 == -2.14748365E9f ? c0221a.p() : f3;
    }

    public float o() {
        return this.f12407i;
    }

    public void s() {
        v();
        q();
        c();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i3) {
        super.setRepeatMode(i3);
        if (i3 == 2 || !this.f12408j) {
            return;
        }
        this.f12408j = false;
        y();
    }

    public void t() {
        this.f12416r = true;
        r();
        f(p());
        A((int) (p() ? m() : n()));
        this.f12409k = 0L;
        this.f12412n = 0;
        u();
    }

    protected void u() {
        if (isRunning()) {
            w(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void v() {
        w(true);
    }

    protected void w(boolean z3) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z3) {
            this.f12416r = false;
        }
    }

    public void x() {
        this.f12416r = true;
        u();
        this.f12409k = 0L;
        if (p() && k() == n()) {
            A(m());
        } else if (!p() && k() == m()) {
            A(n());
        }
        r();
        e();
    }

    public void y() {
        E(-o());
    }

    public void z(C0221a c0221a) {
        boolean z3 = this.f12415q == null;
        this.f12415q = c0221a;
        if (z3) {
            C(Math.max(this.f12413o, c0221a.p()), Math.min(this.f12414p, c0221a.f()));
        } else {
            C((int) c0221a.p(), (int) c0221a.f());
        }
        float f3 = this.f12411m;
        this.f12411m = 0.0f;
        this.f12410l = 0.0f;
        A((int) f3);
        g();
    }
}
