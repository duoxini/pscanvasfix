package o2;

import D2.k;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* renamed from: o2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0493a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12736a;

    static {
        StringBuilder sb = new StringBuilder("ro.build.version.");
        Charset charset = StandardCharsets.UTF_8;
        k.d(charset, "UTF_8");
        sb.append(new String("oppo".getBytes(), charset));
        sb.append("rom");
        f12736a = sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String a(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = 0
            p2.k$a r2 = p2.C0511k.f12803f     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L39
            java.lang.Class[] r0 = new java.lang.Class[]{r0, r0}     // Catch: java.lang.Throwable -> L39
            java.lang.String r3 = "get"
            r4 = 2
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r4)     // Catch: java.lang.Throwable -> L39
            java.lang.Class[] r0 = (java.lang.Class[]) r0     // Catch: java.lang.Throwable -> L39
            java.lang.reflect.Method r0 = r2.getMethod(r3, r0)     // Catch: java.lang.Throwable -> L39
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6}     // Catch: java.lang.Throwable -> L39
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r4)     // Catch: java.lang.Throwable -> L39
            java.lang.Object r5 = r0.invoke(r2, r5)     // Catch: java.lang.Throwable -> L39
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.String"
            D2.k.c(r5, r0)     // Catch: java.lang.Throwable -> L39
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L39
            p2.q r0 = p2.q.f12810a     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = p2.C0511k.b(r0)     // Catch: java.lang.Throwable -> L36
            goto L45
        L36:
            r0 = move-exception
            r1 = r5
            goto L3a
        L39:
            r0 = move-exception
        L3a:
            p2.k$a r5 = p2.C0511k.f12803f
            java.lang.Object r5 = p2.l.a(r0)
            java.lang.Object r0 = p2.C0511k.b(r5)
            r5 = r1
        L45:
            java.lang.Throwable r0 = p2.C0511k.d(r0)
            if (r0 == 0) goto L4c
            goto L4d
        L4c:
            r6 = r5
        L4d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.AbstractC0493a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static final String b() {
        String a3 = a("ro.build.version.oplusrom", "");
        if (TextUtils.isEmpty(a3)) {
            a3 = a(f12736a, "");
        }
        return a3 == null ? "" : a3;
    }

    public static final boolean c(Context context) {
        if (context == null) {
            return false;
        }
        int i3 = context.getResources().getConfiguration().screenWidthDp;
        int i4 = context.getResources().getConfiguration().screenHeightDp;
        return (i3 > 840 && i4 > 480) || (i4 > 840 && i3 > 600);
    }

    public static final boolean d() {
        return (Resources.getSystem().getConfiguration().uiMode & 48) == 32;
    }

    public static final boolean e(Configuration configuration) {
        return configuration != null && (configuration.uiMode & 48) == 32;
    }

    public static final int f(Context context, float f3) {
        if (context == null) {
            return 0;
        }
        return (int) ((f3 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
