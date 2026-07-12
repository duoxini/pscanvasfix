package f1;

import android.graphics.PointF;

/* renamed from: f1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0353a {

    /* renamed from: a, reason: collision with root package name */
    private final PointF f11550a;

    /* renamed from: b, reason: collision with root package name */
    private final PointF f11551b;

    /* renamed from: c, reason: collision with root package name */
    private final PointF f11552c;

    public C0353a() {
        this.f11550a = new PointF();
        this.f11551b = new PointF();
        this.f11552c = new PointF();
    }

    public PointF a() {
        return this.f11550a;
    }

    public PointF b() {
        return this.f11551b;
    }

    public PointF c() {
        return this.f11552c;
    }

    public void d(float f3, float f4) {
        this.f11550a.set(f3, f4);
    }

    public void e(float f3, float f4) {
        this.f11551b.set(f3, f4);
    }

    public void f(float f3, float f4) {
        this.f11552c.set(f3, f4);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.f11552c.x), Float.valueOf(this.f11552c.y), Float.valueOf(this.f11550a.x), Float.valueOf(this.f11550a.y), Float.valueOf(this.f11551b.x), Float.valueOf(this.f11551b.y));
    }

    public C0353a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f11550a = pointF;
        this.f11551b = pointF2;
        this.f11552c = pointF3;
    }
}
