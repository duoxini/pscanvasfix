package t0;

import java.util.Observable;

/* loaded from: classes.dex */
public class d extends Observable {

    /* renamed from: a, reason: collision with root package name */
    private int f13356a;

    /* renamed from: b, reason: collision with root package name */
    private int f13357b = 9999;

    /* renamed from: c, reason: collision with root package name */
    private int f13358c = -999;

    public int a() {
        return this.f13357b;
    }

    public int b() {
        return this.f13358c;
    }

    public int c() {
        return this.f13356a;
    }

    public void d(int i3) {
        if (i3 < this.f13358c) {
            throw new IllegalArgumentException("maximum cannot be smaller than mMini");
        }
        if (i3 > 9999) {
            throw new IllegalArgumentException("maximum cannot be bigger than '9999'");
        }
        this.f13357b = i3;
        if (this.f13356a > i3) {
            f(i3);
        }
    }

    public void e(int i3) {
        if (i3 > this.f13357b) {
            throw new IllegalArgumentException("minimum cannot be bigger than mMini");
        }
        if (i3 < -999) {
            throw new IllegalArgumentException("minimum cannot be smaller than '-999'");
        }
        this.f13358c = i3;
        if (this.f13356a < i3) {
            f(i3);
        }
    }

    public void f(int i3) {
        int min = Math.min(Math.max(i3, b()), a());
        int i4 = this.f13356a;
        this.f13356a = min;
        setChanged();
        notifyObservers(Integer.valueOf(i4));
    }
}
