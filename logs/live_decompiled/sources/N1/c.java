package n1;

import a1.C0221a;
import android.graphics.PointF;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final C0221a f12573a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12574b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12575c;

    /* renamed from: d, reason: collision with root package name */
    public final Interpolator f12576d;

    /* renamed from: e, reason: collision with root package name */
    public final Interpolator f12577e;

    /* renamed from: f, reason: collision with root package name */
    public final Interpolator f12578f;

    /* renamed from: g, reason: collision with root package name */
    public final float f12579g;

    /* renamed from: h, reason: collision with root package name */
    public Float f12580h;

    /* renamed from: i, reason: collision with root package name */
    private float f12581i;

    /* renamed from: j, reason: collision with root package name */
    private float f12582j;

    /* renamed from: k, reason: collision with root package name */
    private int f12583k;

    /* renamed from: l, reason: collision with root package name */
    private int f12584l;

    /* renamed from: m, reason: collision with root package name */
    private float f12585m;

    /* renamed from: n, reason: collision with root package name */
    private float f12586n;

    /* renamed from: o, reason: collision with root package name */
    public PointF f12587o;

    /* renamed from: p, reason: collision with root package name */
    public PointF f12588p;

    public c(C0221a c0221a, Object obj, Object obj2, Interpolator interpolator, float f3, Float f4) {
        this.f12581i = -3987645.8f;
        this.f12582j = -3987645.8f;
        this.f12583k = 784923401;
        this.f12584l = 784923401;
        this.f12585m = Float.MIN_VALUE;
        this.f12586n = Float.MIN_VALUE;
        this.f12587o = null;
        this.f12588p = null;
        this.f12573a = c0221a;
        this.f12574b = obj;
        this.f12575c = obj2;
        this.f12576d = interpolator;
        this.f12577e = null;
        this.f12578f = null;
        this.f12579g = f3;
        this.f12580h = f4;
    }

    public boolean a(float f3) {
        return f3 >= f() && f3 < c();
    }

    public c b(Object obj, Object obj2) {
        return new c(obj, obj2);
    }

    public float c() {
        if (this.f12573a == null) {
            return 1.0f;
        }
        if (this.f12586n == Float.MIN_VALUE) {
            if (this.f12580h == null) {
                this.f12586n = 1.0f;
            } else {
                this.f12586n = f() + ((this.f12580h.floatValue() - this.f12579g) / this.f12573a.e());
            }
        }
        return this.f12586n;
    }

    public float d() {
        if (this.f12582j == -3987645.8f) {
            this.f12582j = ((Float) this.f12575c).floatValue();
        }
        return this.f12582j;
    }

    public int e() {
        if (this.f12584l == 784923401) {
            this.f12584l = ((Integer) this.f12575c).intValue();
        }
        return this.f12584l;
    }

    public float f() {
        C0221a c0221a = this.f12573a;
        if (c0221a == null) {
            return 0.0f;
        }
        if (this.f12585m == Float.MIN_VALUE) {
            this.f12585m = (this.f12579g - c0221a.p()) / this.f12573a.e();
        }
        return this.f12585m;
    }

    public float g() {
        if (this.f12581i == -3987645.8f) {
            this.f12581i = ((Float) this.f12574b).floatValue();
        }
        return this.f12581i;
    }

    public int h() {
        if (this.f12583k == 784923401) {
            this.f12583k = ((Integer) this.f12574b).intValue();
        }
        return this.f12583k;
    }

    public boolean i() {
        return this.f12576d == null && this.f12577e == null && this.f12578f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f12574b + ", endValue=" + this.f12575c + ", startFrame=" + this.f12579g + ", endFrame=" + this.f12580h + ", interpolator=" + this.f12576d + '}';
    }

    public c(C0221a c0221a, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f3, Float f4) {
        this.f12581i = -3987645.8f;
        this.f12582j = -3987645.8f;
        this.f12583k = 784923401;
        this.f12584l = 784923401;
        this.f12585m = Float.MIN_VALUE;
        this.f12586n = Float.MIN_VALUE;
        this.f12587o = null;
        this.f12588p = null;
        this.f12573a = c0221a;
        this.f12574b = obj;
        this.f12575c = obj2;
        this.f12576d = null;
        this.f12577e = interpolator;
        this.f12578f = interpolator2;
        this.f12579g = f3;
        this.f12580h = f4;
    }

    protected c(C0221a c0221a, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f3, Float f4) {
        this.f12581i = -3987645.8f;
        this.f12582j = -3987645.8f;
        this.f12583k = 784923401;
        this.f12584l = 784923401;
        this.f12585m = Float.MIN_VALUE;
        this.f12586n = Float.MIN_VALUE;
        this.f12587o = null;
        this.f12588p = null;
        this.f12573a = c0221a;
        this.f12574b = obj;
        this.f12575c = obj2;
        this.f12576d = interpolator;
        this.f12577e = interpolator2;
        this.f12578f = interpolator3;
        this.f12579g = f3;
        this.f12580h = f4;
    }

    public c(Object obj) {
        this.f12581i = -3987645.8f;
        this.f12582j = -3987645.8f;
        this.f12583k = 784923401;
        this.f12584l = 784923401;
        this.f12585m = Float.MIN_VALUE;
        this.f12586n = Float.MIN_VALUE;
        this.f12587o = null;
        this.f12588p = null;
        this.f12573a = null;
        this.f12574b = obj;
        this.f12575c = obj;
        this.f12576d = null;
        this.f12577e = null;
        this.f12578f = null;
        this.f12579g = Float.MIN_VALUE;
        this.f12580h = Float.valueOf(Float.MAX_VALUE);
    }

    private c(Object obj, Object obj2) {
        this.f12581i = -3987645.8f;
        this.f12582j = -3987645.8f;
        this.f12583k = 784923401;
        this.f12584l = 784923401;
        this.f12585m = Float.MIN_VALUE;
        this.f12586n = Float.MIN_VALUE;
        this.f12587o = null;
        this.f12588p = null;
        this.f12573a = null;
        this.f12574b = obj;
        this.f12575c = obj2;
        this.f12576d = null;
        this.f12577e = null;
        this.f12578f = null;
        this.f12579g = Float.MIN_VALUE;
        this.f12580h = Float.valueOf(Float.MAX_VALUE);
    }
}
