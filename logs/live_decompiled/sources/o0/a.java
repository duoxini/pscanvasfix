package O0;

import R0.b;
import android.content.Context;
import android.graphics.Color;

/* loaded from: classes.dex */
public class a {

    /* renamed from: f, reason: collision with root package name */
    private static final int f1721f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1722a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1723b;

    /* renamed from: c, reason: collision with root package name */
    private final int f1724c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1725d;

    /* renamed from: e, reason: collision with root package name */
    private final float f1726e;

    public a(Context context) {
        this(b.b(context, H0.a.f486r, false), L0.a.b(context, H0.a.f485q, 0), L0.a.b(context, H0.a.f484p, 0), L0.a.b(context, H0.a.f482n, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i3) {
        return androidx.core.graphics.a.n(i3, 255) == this.f1725d;
    }

    public float a(float f3) {
        if (this.f1726e <= 0.0f || f3 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f3 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i3, float f3) {
        int i4;
        float a3 = a(f3);
        int alpha = Color.alpha(i3);
        int h3 = L0.a.h(androidx.core.graphics.a.n(i3, 255), this.f1723b, a3);
        if (a3 > 0.0f && (i4 = this.f1724c) != 0) {
            h3 = L0.a.g(h3, androidx.core.graphics.a.n(i4, f1721f));
        }
        return androidx.core.graphics.a.n(h3, alpha);
    }

    public int c(int i3, float f3) {
        return (this.f1722a && f(i3)) ? b(i3, f3) : i3;
    }

    public int d(float f3) {
        return c(this.f1725d, f3);
    }

    public boolean e() {
        return this.f1722a;
    }

    public a(boolean z3, int i3, int i4, int i5, float f3) {
        this.f1722a = z3;
        this.f1723b = i3;
        this.f1724c = i4;
        this.f1725d = i5;
        this.f1726e = f3;
    }
}
