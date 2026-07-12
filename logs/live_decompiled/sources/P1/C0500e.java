package p1;

/* renamed from: p1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0500e {

    /* renamed from: a, reason: collision with root package name */
    public float f12799a;

    /* renamed from: b, reason: collision with root package name */
    public float f12800b;

    public C0500e() {
        this(0.0f, 0.0f);
    }

    public final C0500e a(C0500e c0500e) {
        this.f12799a += c0500e.f12799a;
        this.f12800b += c0500e.f12800b;
        return this;
    }

    public final C0500e b(float f3) {
        this.f12799a *= f3;
        this.f12800b *= f3;
        return this;
    }

    public final C0500e c() {
        this.f12799a = -this.f12799a;
        this.f12800b = -this.f12800b;
        return this;
    }

    public final C0500e d(float f3, float f4) {
        this.f12799a = f3;
        this.f12800b = f4;
        return this;
    }

    public final C0500e e(C0500e c0500e) {
        this.f12799a = c0500e.f12799a;
        this.f12800b = c0500e.f12800b;
        return this;
    }

    public final void f() {
        this.f12799a = 0.0f;
        this.f12800b = 0.0f;
    }

    public final C0500e g(C0500e c0500e) {
        this.f12799a -= c0500e.f12799a;
        this.f12800b -= c0500e.f12800b;
        return this;
    }

    public final String toString() {
        return "(" + this.f12799a + "," + this.f12800b + ")";
    }

    public C0500e(float f3, float f4) {
        this.f12799a = f3;
        this.f12800b = f4;
    }
}
