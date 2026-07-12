package Z;

import Z.b;
import android.os.Looper;
import android.util.AndroidRuntimeException;

/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: D, reason: collision with root package name */
    private d f3055D;

    /* renamed from: E, reason: collision with root package name */
    private float f3056E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f3057F;

    public c(B.d dVar) {
        super(dVar);
        this.f3055D = null;
        this.f3056E = Float.MAX_VALUE;
        this.f3057F = false;
    }

    private void A() {
        d dVar = this.f3055D;
        if (dVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double a3 = dVar.a();
        if (a3 > this.f3045j) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (a3 < this.f3046k) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public c B(d dVar) {
        this.f3055D = dVar;
        return this;
    }

    public void C() {
        if (!v()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (!this.f3042g && Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f3044i) {
            this.f3057F = true;
        }
    }

    @Override // Z.b
    void q(float f3) {
    }

    @Override // Z.b
    public void r() {
        A();
        this.f3055D.i(g());
        super.r();
    }

    @Override // Z.b
    boolean t(long j3) {
        if (this.f3057F) {
            float f3 = this.f3056E;
            if (f3 != Float.MAX_VALUE) {
                this.f3055D.f(f3);
                this.f3056E = Float.MAX_VALUE;
            }
            this.f3038c = this.f3055D.a();
            this.f3037b = 0.0f;
            this.f3057F = false;
            return true;
        }
        if (this.f3056E != Float.MAX_VALUE) {
            this.f3055D.a();
            long j4 = j3 / 2;
            b.p j5 = this.f3055D.j(this.f3038c, this.f3037b, j4);
            this.f3055D.f(this.f3056E);
            this.f3056E = Float.MAX_VALUE;
            b.p j6 = this.f3055D.j(j5.f3053a, j5.f3054b, j4);
            this.f3038c = j6.f3053a;
            this.f3037b = j6.f3054b;
        } else {
            b.p j7 = this.f3055D.j(this.f3038c, this.f3037b, j3);
            this.f3038c = j7.f3053a;
            this.f3037b = j7.f3054b;
        }
        float max = Math.max(this.f3038c, this.f3046k);
        this.f3038c = max;
        float min = Math.min(max, this.f3045j);
        this.f3038c = min;
        if (!y(min, this.f3037b)) {
            return false;
        }
        this.f3038c = this.f3055D.a();
        this.f3037b = 0.0f;
        return true;
    }

    public void u(float f3) {
        if (h()) {
            this.f3056E = f3;
            return;
        }
        if (this.f3055D == null) {
            this.f3055D = new d(f3);
        }
        this.f3055D.f(f3);
        r();
    }

    public boolean v() {
        return this.f3055D.f3059b > 0.0d;
    }

    public void w() {
        super.c();
        this.f3056E = Float.MAX_VALUE;
        this.f3037b = 0.0f;
        this.f3057F = false;
    }

    public d x() {
        return this.f3055D;
    }

    boolean y(float f3, float f4) {
        return this.f3055D.c(f3, f4);
    }

    public void z() {
        if (!v()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        c();
        float f3 = this.f3056E;
        if (f3 != Float.MAX_VALUE) {
            this.f3055D.f(f3);
            this.f3056E = Float.MAX_VALUE;
        }
        this.f3038c = this.f3055D.a();
        this.f3037b = 0.0f;
        this.f3057F = false;
    }

    public c(Object obj, B.c cVar) {
        super(obj, cVar);
        this.f3055D = null;
        this.f3056E = Float.MAX_VALUE;
        this.f3057F = false;
    }

    public c(Object obj, B.c cVar, float f3) {
        super(obj, cVar);
        this.f3055D = null;
        this.f3056E = Float.MAX_VALUE;
        this.f3057F = false;
        this.f3055D = new d(f3);
    }
}
