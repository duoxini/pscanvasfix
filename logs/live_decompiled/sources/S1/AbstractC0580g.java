package s1;

/* renamed from: s1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0580g {

    /* renamed from: b, reason: collision with root package name */
    public String f13307b;

    /* renamed from: c, reason: collision with root package name */
    public float f13308c;

    /* renamed from: d, reason: collision with root package name */
    float f13309d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13310e = false;

    /* renamed from: a, reason: collision with root package name */
    public int f13306a = 0;

    public AbstractC0580g(String str, float f3) {
        this.f13307b = str;
        this.f13308c = f3;
    }

    public abstract float a(Object obj);

    public abstract void b(Object obj, float f3);

    public AbstractC0580g c(float f3) {
        this.f13309d = f3;
        this.f13310e = true;
        return this;
    }

    public void d(Object obj, float f3) {
        b(obj, f3 * this.f13308c);
    }

    public abstract void e(Object obj);

    public void f(Object obj) {
        if (this.f13310e) {
            return;
        }
        this.f13309d = a(obj);
    }
}
