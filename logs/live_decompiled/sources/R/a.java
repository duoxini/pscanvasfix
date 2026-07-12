package R;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f2023a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f2024b;

    public static void a(String str) {
        b.a(str);
    }

    public static void b() {
        b.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        try {
            if (f2024b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f2024b == null) {
                f2023a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f2024b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f2024b.invoke(null, Long.valueOf(f2023a))).booleanValue();
        } catch (Exception e3) {
            c("isTagEnabled", e3);
            return false;
        }
    }
}
