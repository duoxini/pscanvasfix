package m1;

/* renamed from: m1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0463f {

    /* renamed from: a, reason: collision with root package name */
    private float f12420a;

    /* renamed from: b, reason: collision with root package name */
    private int f12421b;

    public void a(float f3) {
        float f4 = this.f12420a + f3;
        this.f12420a = f4;
        int i3 = this.f12421b + 1;
        this.f12421b = i3;
        if (i3 == Integer.MAX_VALUE) {
            this.f12420a = f4 / 2.0f;
            this.f12421b = i3 / 2;
        }
    }
}
