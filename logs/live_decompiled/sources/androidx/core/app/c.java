package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;

/* loaded from: classes.dex */
public abstract class c {

    static class a {
        static <T> T a(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    static class b {
        static int a(AppOpsManager appOpsManager, String str, int i3, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i3, str2);
        }

        static String b(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(Context context, int i3, String str, String str2) {
        AppOpsManager c3 = b.c(context);
        int a3 = b.a(c3, str, Binder.getCallingUid(), str2);
        return a3 != 0 ? a3 : b.a(c3, str, i3, b.b(context));
    }

    public static int b(Context context, String str, String str2) {
        return a.c((AppOpsManager) a.a(context, AppOpsManager.class), str, str2);
    }

    public static String c(String str) {
        return a.d(str);
    }
}
