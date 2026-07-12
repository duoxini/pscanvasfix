package H1;

import android.content.Context;
import java.util.UUID;

/* loaded from: classes.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private String f879a;

    /* renamed from: b, reason: collision with root package name */
    private long f880b;

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final r f881a = new r();
    }

    private String a() {
        return UUID.randomUUID().toString();
    }

    private long b(Context context) {
        return I1.c.a(context, "AppExitTime", 0L);
    }

    private String d(Context context) {
        return I1.c.c(context, "AppSessionId", "");
    }

    public static r e() {
        return b.f881a;
    }

    private boolean f(Context context) {
        if (this.f880b == 0) {
            this.f880b = b(context);
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f880b;
        return currentTimeMillis > 0 && currentTimeMillis < 30000;
    }

    private void j(Context context, long j3) {
        I1.c.d(context, "AppExitTime", j3);
    }

    private void k(Context context, String str) {
        I1.c.e(context, "AppSessionId", str);
    }

    public String c(Context context) {
        if (this.f879a == null) {
            i(context);
        }
        return this.f879a;
    }

    public void g(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f880b = currentTimeMillis;
        j(context, currentTimeMillis);
    }

    public void h(Context context) {
        String a3 = a();
        this.f879a = a3;
        k(context, a3);
    }

    public void i(Context context) {
        if (f(context)) {
            this.f879a = d(context);
        } else {
            h(context);
        }
    }

    private r() {
        this.f879a = null;
        this.f880b = 0L;
    }
}
