package n0;

import android.text.TextUtils;
import h0.AbstractC0371a;
import java.lang.reflect.InvocationTargetException;
import z0.AbstractC0647b;

/* renamed from: n0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0481a {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f12558a;

    /* renamed from: b, reason: collision with root package name */
    private static Integer f12559b;

    /* renamed from: c, reason: collision with root package name */
    private static Float f12560c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f12561d;

    /* renamed from: e, reason: collision with root package name */
    private static Integer f12562e;

    public static int a() {
        if (f12562e == null) {
            f12562e = Integer.valueOf(AbstractC0647b.c());
        }
        if (!f() || f12562e.intValue() < 37) {
            return f() ? 0 : -1;
        }
        return 1;
    }

    private static int b(String str, int i3) {
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            return !TextUtils.isEmpty(str2) ? Integer.parseInt(str2) : i3;
        } catch (ClassNotFoundException e3) {
            AbstractC0371a.c("RoundCornerUtil", "Class not found:" + e3);
            return i3;
        } catch (IllegalAccessException e4) {
            AbstractC0371a.c("RoundCornerUtil", "Illegal access:" + e4);
            return i3;
        } catch (NoSuchMethodException e5) {
            AbstractC0371a.c("RoundCornerUtil", "Method not found:" + e5);
            return i3;
        } catch (InvocationTargetException e6) {
            AbstractC0371a.c("RoundCornerUtil", "Invocation target exception:" + e6);
            return i3;
        }
    }

    public static boolean c() {
        if (f12562e == null) {
            f12562e = Integer.valueOf(AbstractC0647b.c());
        }
        if (f12562e.intValue() > 34) {
            return true;
        }
        return f12562e.intValue() == 34 && AbstractC0647b.d() >= 12;
    }

    public static boolean d() {
        Boolean bool = f12561d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (f()) {
            if (f12558a == null) {
                f12558a = Integer.valueOf(b("persist.sys.oplus.anim_level", 3));
            }
            if (f12559b == null) {
                f12559b = Integer.valueOf(b("persist.sys.oplus.upgrade_anim_level", 3));
            }
            if (f12560c == null) {
                f12560c = Float.valueOf(b("persist.sys.oplus.default_smooth_weight", 170) / 100.0f);
            }
            f12561d = Boolean.valueOf((f12558a.intValue() < 3 || f12559b.intValue() < 3) && f12560c.floatValue() != 2.0f);
        } else {
            f12561d = Boolean.FALSE;
        }
        return f12561d.booleanValue();
    }

    public static boolean e() {
        if (f12562e == null) {
            f12562e = Integer.valueOf(AbstractC0647b.c());
        }
        if (f12562e.intValue() > 34) {
            return true;
        }
        return f12562e.intValue() == 34 && AbstractC0647b.d() >= 10;
    }

    public static boolean f() {
        if (f12562e == null) {
            f12562e = Integer.valueOf(AbstractC0647b.c());
        }
        return f12562e.intValue() >= 34;
    }

    public static boolean g(boolean z3) {
        return f() && (!z3 || e());
    }
}
