package a1;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private final int f3248a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3249b;

    /* renamed from: c, reason: collision with root package name */
    private final String f3250c;

    /* renamed from: d, reason: collision with root package name */
    private final String f3251d;

    /* renamed from: e, reason: collision with root package name */
    private final String f3252e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f3253f;

    public r(int i3, int i4, String str, String str2, String str3) {
        this.f3248a = i3;
        this.f3249b = i4;
        this.f3250c = str;
        this.f3251d = str2;
        this.f3252e = str3;
    }

    public Bitmap a() {
        return this.f3253f;
    }

    public String b() {
        return this.f3251d;
    }

    public int c() {
        return this.f3249b;
    }

    public String d() {
        return this.f3250c;
    }

    public int e() {
        return this.f3248a;
    }

    public void f(Bitmap bitmap) {
        this.f3253f = bitmap;
    }
}
