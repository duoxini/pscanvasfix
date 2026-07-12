package f1;

import m1.AbstractC0465h;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f11586a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11587b;

    /* renamed from: c, reason: collision with root package name */
    public final float f11588c;

    public h(String str, float f3, float f4) {
        this.f11586a = str;
        this.f11588c = f4;
        this.f11587b = f3;
    }

    public boolean a(String str) {
        if (this.f11586a.equalsIgnoreCase(str)) {
            return true;
        }
        if (AbstractC0465h.n(this.f11586a, "\r")) {
            String str2 = this.f11586a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
