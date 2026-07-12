package s1;

/* loaded from: classes.dex */
public class h extends AbstractC0580g {

    /* renamed from: f, reason: collision with root package name */
    float f13311f;

    public h(float f3) {
        this("floatValue", f3);
    }

    @Override // s1.AbstractC0580g
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public float a(k kVar) {
        return this.f13311f;
    }

    @Override // s1.AbstractC0580g
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public void b(k kVar, float f3) {
        this.f13311f = f3;
    }

    @Override // s1.AbstractC0580g
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e(k kVar) {
        d(kVar, kVar.f13334h.f13323a);
    }

    @Override // s1.AbstractC0580g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void f(k kVar) {
        super.f(kVar);
        kVar.f13331e.f12799a = this.f13309d;
    }

    public String toString() {
        return "FloatValueHolder{mValue=" + this.f13311f + ", mPropertyType=" + this.f13306a + ", mPropertyName=" + this.f13307b + ", mValueThreshold=" + this.f13308c + ", mIsStartValueSet=" + this.f13310e + "}@" + hashCode();
    }

    public h(String str, float f3) {
        this(str, f3, 1.0f);
    }

    public h(String str, float f3, float f4) {
        super(str, f4);
        this.f13311f = f3;
    }
}
