package androidx.core.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.f;
import java.io.File;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f4847a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f4848b = new Object();

    /* renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    static class C0062a {
        static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    static class b {
        static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    static class c {
        static File a(Context context) {
            return context.getCodeCacheDir();
        }

        static Drawable b(Context context, int i3) {
            return context.getDrawable(i3);
        }

        static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    static class d {
        static int a(Context context, int i3) {
            return context.getColor(i3);
        }

        static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    static class e {
        static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        static File b(Context context) {
            return context.getDataDir();
        }

        static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public static int a(Context context, String str) {
        androidx.core.util.c.c(str, "permission must be non-null");
        return (androidx.core.os.a.b() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : f.b(context).a() ? 0 : -1;
    }

    public static Context b(Context context) {
        return e.a(context);
    }

    public static int c(Context context, int i3) {
        return d.a(context, i3);
    }

    public static ColorStateList d(Context context, int i3) {
        return androidx.core.content.res.f.e(context.getResources(), i3, context.getTheme());
    }

    public static Drawable e(Context context, int i3) {
        return c.b(context, i3);
    }

    public static File[] f(Context context) {
        return b.a(context);
    }

    public static File[] g(Context context, String str) {
        return b.b(context, str);
    }

    public static boolean h(Context context, Intent[] intentArr, Bundle bundle) {
        C0062a.a(context, intentArr, bundle);
        return true;
    }

    public static void i(Context context, Intent intent, Bundle bundle) {
        C0062a.b(context, intent, bundle);
    }
}
