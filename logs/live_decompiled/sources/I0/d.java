package I0;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f921a;

    /* renamed from: b, reason: collision with root package name */
    private long f922b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f923c;

    /* renamed from: d, reason: collision with root package name */
    private int f924d;

    /* renamed from: e, reason: collision with root package name */
    private int f925e;

    public d(long j3, long j4) {
        this.f923c = null;
        this.f924d = 0;
        this.f925e = 1;
        this.f921a = j3;
        this.f922b = j4;
    }

    static d a(ValueAnimator valueAnimator) {
        d dVar = new d(valueAnimator.getStartDelay(), valueAnimator.getDuration(), e(valueAnimator));
        dVar.f924d = valueAnimator.getRepeatCount();
        dVar.f925e = valueAnimator.getRepeatMode();
        return dVar;
    }

    private static TimeInterpolator e(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f915b : interpolator instanceof AccelerateInterpolator ? a.f916c : interpolator instanceof DecelerateInterpolator ? a.f917d : interpolator;
    }

    public long b() {
        return this.f921a;
    }

    public long c() {
        return this.f922b;
    }

    public TimeInterpolator d() {
        TimeInterpolator timeInterpolator = this.f923c;
        return timeInterpolator != null ? timeInterpolator : a.f915b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (b() == dVar.b() && c() == dVar.c() && f() == dVar.f() && g() == dVar.g()) {
            return d().getClass().equals(dVar.d().getClass());
        }
        return false;
    }

    public int f() {
        return this.f924d;
    }

    public int g() {
        return this.f925e;
    }

    public int hashCode() {
        return (((((((((int) (b() ^ (b() >>> 32))) * 31) + ((int) (c() ^ (c() >>> 32)))) * 31) + d().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + b() + " duration: " + c() + " interpolator: " + d().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public d(long j3, long j4, TimeInterpolator timeInterpolator) {
        this.f924d = 0;
        this.f925e = 1;
        this.f921a = j3;
        this.f922b = j4;
        this.f923c = timeInterpolator;
    }
}
