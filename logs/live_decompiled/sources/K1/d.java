package K1;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f1168a = new HashMap();

    public static String c(Context context) {
        Application application = (Application) context.getApplicationContext();
        Map map = f1168a;
        String str = (String) map.get(application);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = null;
        try {
            str2 = String.valueOf(context.getPackageManager().getApplicationInfo(e(context), 128).metaData.get("AppCode"));
            if (TextUtils.isEmpty(str2)) {
                f.b("ApkInfoUtil", new g() { // from class: K1.b
                    @Override // K1.g
                    public final Object get() {
                        String g3;
                        g3 = d.g();
                        return g3;
                    }
                });
            } else {
                map.put(application, str2);
            }
        } catch (Exception e3) {
            f.b("ApkInfoUtil", new E1.h(e3));
            e3.printStackTrace();
        }
        return str2;
    }

    public static String d(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e3) {
            f.b("ApkInfoUtil", new E1.h(e3));
            return "0";
        }
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e3) {
            f.b("ApkInfoUtil", new E1.h(e3));
            return "0";
        }
    }

    public static String f(Context context) {
        String str = "0";
        try {
            final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return "0";
            }
            String str2 = packageInfo.versionName;
            if (str2 == null) {
                return "0";
            }
            try {
                f.c("ApkInfoUtil", new g() { // from class: K1.c
                    @Override // K1.g
                    public final Object get() {
                        String h3;
                        h3 = d.h(packageInfo);
                        return h3;
                    }
                });
                return str2;
            } catch (Exception e3) {
                e = e3;
                str = str2;
                f.b("ApkInfoUtil", new E1.h(e));
                return str;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g() {
        return "AppCode not set. please read the document of OplusTrack SDK.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String h(PackageInfo packageInfo) {
        return "versionName=" + packageInfo.versionName;
    }

    public static void i(Context context, String str) {
        f1168a.put((Application) context.getApplicationContext(), str);
    }
}
