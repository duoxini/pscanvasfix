package B1;

import android.content.Context;

/* loaded from: classes.dex */
public class n {

    /* renamed from: d, reason: collision with root package name */
    private static volatile n f227d;

    /* renamed from: a, reason: collision with root package name */
    private final e f228a = new e();

    /* renamed from: b, reason: collision with root package name */
    private final r f229b = new r();

    /* renamed from: c, reason: collision with root package name */
    private final o f230c = new o();

    public static n a() {
        if (f227d == null) {
            synchronized (n.class) {
                try {
                    if (f227d == null) {
                        f227d = new n();
                    }
                } finally {
                }
            }
        }
        return f227d;
    }

    public m b(Context context) {
        return s.r(context) ? this.f228a : s.H() ? this.f229b : s.w(context) ? this.f230c : this.f228a;
    }

    public m c(String str) {
        return "DefaultPolicy".equals(str) ? this.f228a : "TabletPolicy".equals(str) ? this.f229b : "PhonePolicy".equals(str) ? this.f230c : this.f228a;
    }
}
