package f1;

import java.util.List;

/* renamed from: f1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0357e {

    /* renamed from: a, reason: collision with root package name */
    private final List f11577a;

    /* renamed from: b, reason: collision with root package name */
    private final char f11578b;

    /* renamed from: c, reason: collision with root package name */
    private final double f11579c;

    /* renamed from: d, reason: collision with root package name */
    private final double f11580d;

    /* renamed from: e, reason: collision with root package name */
    private final String f11581e;

    /* renamed from: f, reason: collision with root package name */
    private final String f11582f;

    public C0357e(List list, char c3, double d3, double d4, String str, String str2) {
        this.f11577a = list;
        this.f11578b = c3;
        this.f11579c = d3;
        this.f11580d = d4;
        this.f11581e = str;
        this.f11582f = str2;
    }

    public static int c(char c3, String str, String str2) {
        return (((c3 * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List a() {
        return this.f11577a;
    }

    public double b() {
        return this.f11580d;
    }

    public int hashCode() {
        return c(this.f11578b, this.f11582f, this.f11581e);
    }
}
