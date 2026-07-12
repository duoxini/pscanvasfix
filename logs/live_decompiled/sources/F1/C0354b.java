package f1;

import android.graphics.PointF;

/* renamed from: f1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0354b {

    /* renamed from: a, reason: collision with root package name */
    public String f11553a;

    /* renamed from: b, reason: collision with root package name */
    public String f11554b;

    /* renamed from: c, reason: collision with root package name */
    public float f11555c;

    /* renamed from: d, reason: collision with root package name */
    public a f11556d;

    /* renamed from: e, reason: collision with root package name */
    public int f11557e;

    /* renamed from: f, reason: collision with root package name */
    public float f11558f;

    /* renamed from: g, reason: collision with root package name */
    public float f11559g;

    /* renamed from: h, reason: collision with root package name */
    public int f11560h;

    /* renamed from: i, reason: collision with root package name */
    public int f11561i;

    /* renamed from: j, reason: collision with root package name */
    public float f11562j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11563k;

    /* renamed from: l, reason: collision with root package name */
    public PointF f11564l;

    /* renamed from: m, reason: collision with root package name */
    public PointF f11565m;

    /* renamed from: f1.b$a */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public C0354b(String str, String str2, float f3, a aVar, int i3, float f4, float f5, int i4, int i5, float f6, boolean z3, PointF pointF, PointF pointF2) {
        a(str, str2, f3, aVar, i3, f4, f5, i4, i5, f6, z3, pointF, pointF2);
    }

    public void a(String str, String str2, float f3, a aVar, int i3, float f4, float f5, int i4, int i5, float f6, boolean z3, PointF pointF, PointF pointF2) {
        this.f11553a = str;
        this.f11554b = str2;
        this.f11555c = f3;
        this.f11556d = aVar;
        this.f11557e = i3;
        this.f11558f = f4;
        this.f11559g = f5;
        this.f11560h = i4;
        this.f11561i = i5;
        this.f11562j = f6;
        this.f11563k = z3;
        this.f11564l = pointF;
        this.f11565m = pointF2;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f11553a.hashCode() * 31) + this.f11554b.hashCode()) * 31) + this.f11555c)) * 31) + this.f11556d.ordinal()) * 31) + this.f11557e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f11558f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f11560h;
    }

    public C0354b() {
    }
}
