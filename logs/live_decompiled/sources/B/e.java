package B;

import B.b;
import android.os.Looper;
import android.util.AndroidRuntimeException;

/* loaded from: classes.dex */
public final class e extends b {

    /* renamed from: A, reason: collision with root package name */
    private f f133A;

    /* renamed from: B, reason: collision with root package name */
    private float f134B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f135C;

    public e(d dVar) {
        super(dVar);
        this.f133A = null;
        this.f134B = Float.MAX_VALUE;
        this.f135C = false;
    }

    private void s() {
        f fVar = this.f133A;
        if (fVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double a3 = fVar.a();
        if (a3 > this.f121g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (a3 < this.f122h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // B.b
    void l(float f3) {
    }

    @Override // B.b
    public void m() {
        s();
        this.f133A.g(f());
        super.m();
    }

    @Override // B.b
    boolean o(long j3) {
        if (this.f135C) {
            float f3 = this.f134B;
            if (f3 != Float.MAX_VALUE) {
                this.f133A.e(f3);
                this.f134B = Float.MAX_VALUE;
            }
            this.f116b = this.f133A.a();
            this.f115a = 0.0f;
            this.f135C = false;
            return true;
        }
        if (this.f134B != Float.MAX_VALUE) {
            this.f133A.a();
            long j4 = j3 / 2;
            b.p h3 = this.f133A.h(this.f116b, this.f115a, j4);
            this.f133A.e(this.f134B);
            this.f134B = Float.MAX_VALUE;
            b.p h4 = this.f133A.h(h3.f129a, h3.f130b, j4);
            this.f116b = h4.f129a;
            this.f115a = h4.f130b;
        } else {
            b.p h5 = this.f133A.h(this.f116b, this.f115a, j3);
            this.f116b = h5.f129a;
            this.f115a = h5.f130b;
        }
        float max = Math.max(this.f116b, this.f122h);
        this.f116b = max;
        float min = Math.min(max, this.f121g);
        this.f116b = min;
        if (!r(min, this.f115a)) {
            return false;
        }
        this.f116b = this.f133A.a();
        this.f115a = 0.0f;
        return true;
    }

    public void p(float f3) {
        if (g()) {
            this.f134B = f3;
            return;
        }
        if (this.f133A == null) {
            this.f133A = new f(f3);
        }
        this.f133A.e(f3);
        m();
    }

    public boolean q() {
        return this.f133A.f137b > 0.0d;
    }

    boolean r(float f3, float f4) {
        return this.f133A.c(f3, f4);
    }

    public e t(f fVar) {
        this.f133A = fVar;
        return this;
    }

    public void u() {
        if (!q()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f120f) {
            this.f135C = true;
        }
    }

    public e(Object obj, c cVar) {
        super(obj, cVar);
        this.f133A = null;
        this.f134B = Float.MAX_VALUE;
        this.f135C = false;
    }
}
