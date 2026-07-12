package E1;

import E1.a;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static Map f373d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final String f374a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f375b;

    /* renamed from: c, reason: collision with root package name */
    private a f376c;

    private c(String str, Context context, a aVar) {
        this.f374a = str;
        this.f375b = context;
        this.f376c = aVar != null ? c(context, aVar) : b(context);
    }

    private a b(Context context) {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            K1.f.f("OTrackContext", new K1.g() { // from class: E1.b
                @Override // K1.g
                public final Object get() {
                    String g3;
                    g3 = c.g();
                    return g3;
                }
            });
            packageInfo = null;
        }
        return packageInfo == null ? a.f362f : new a.b().h(packageInfo.packageName).i(packageInfo.versionName).g(packageInfo.applicationInfo.loadLabel(packageManager).toString()).f();
    }

    private a c(Context context, a aVar) {
        if (TextUtils.isEmpty(aVar.d())) {
            aVar.g(K1.d.e(context));
        }
        if (TextUtils.isEmpty(aVar.e())) {
            aVar.h(K1.d.f(context));
        }
        if (TextUtils.isEmpty(aVar.a())) {
            aVar.f(K1.d.d(context));
        }
        return aVar;
    }

    public static synchronized c d(String str, Context context, a aVar) {
        c e3;
        synchronized (c.class) {
            e3 = e(str);
            if (e3 == null) {
                e3 = new c(str, context, aVar);
                f373d.put(str, e3);
            }
        }
        return e3;
    }

    public static synchronized c e(String str) {
        c cVar;
        synchronized (c.class) {
            cVar = (c) f373d.get(str);
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g() {
        return "createDefaultConfig PackageManager.NameNotFoundException.";
    }

    public a f() {
        if (a.f362f.equals(this.f376c)) {
            this.f376c = b(this.f375b);
        }
        return this.f376c;
    }
}
