package n1;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private float f12589a;

    /* renamed from: b, reason: collision with root package name */
    private float f12590b;

    public d(float f3, float f4) {
        this.f12589a = f3;
        this.f12590b = f4;
    }

    public boolean a(float f3, float f4) {
        return this.f12589a == f3 && this.f12590b == f4;
    }

    public float b() {
        return this.f12589a;
    }

    public float c() {
        return this.f12590b;
    }

    public void d(float f3, float f4) {
        this.f12589a = f3;
        this.f12590b = f4;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}
