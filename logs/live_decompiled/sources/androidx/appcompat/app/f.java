package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.n;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import m.C0452b;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: e, reason: collision with root package name */
    static n.a f3531e = new n.a(new n.b());

    /* renamed from: f, reason: collision with root package name */
    private static int f3532f = -100;

    /* renamed from: g, reason: collision with root package name */
    private static androidx.core.os.f f3533g = null;

    /* renamed from: h, reason: collision with root package name */
    private static androidx.core.os.f f3534h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Boolean f3535i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f3536j = false;

    /* renamed from: k, reason: collision with root package name */
    private static final C0452b f3537k = new C0452b();

    /* renamed from: l, reason: collision with root package name */
    private static final Object f3538l = new Object();

    /* renamed from: m, reason: collision with root package name */
    private static final Object f3539m = new Object();

    static class a {
        static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    static class b {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    f() {
    }

    static void C(f fVar) {
        synchronized (f3538l) {
            D(fVar);
        }
    }

    private static void D(f fVar) {
        synchronized (f3538l) {
            try {
                Iterator it = f3537k.iterator();
                while (it.hasNext()) {
                    f fVar2 = (f) ((WeakReference) it.next()).get();
                    if (fVar2 == fVar || fVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void N(final Context context) {
        if (s(context)) {
            if (androidx.core.os.a.b()) {
                if (f3536j) {
                    return;
                }
                f3531e.execute(new Runnable() { // from class: androidx.appcompat.app.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.t(context);
                    }
                });
                return;
            }
            synchronized (f3539m) {
                try {
                    androidx.core.os.f fVar = f3533g;
                    if (fVar == null) {
                        if (f3534h == null) {
                            f3534h = androidx.core.os.f.b(n.b(context));
                        }
                        if (f3534h.d()) {
                        } else {
                            f3533g = f3534h;
                        }
                    } else if (!fVar.equals(f3534h)) {
                        androidx.core.os.f fVar2 = f3533g;
                        f3534h = fVar2;
                        n.a(context, fVar2.e());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    static void b(f fVar) {
        synchronized (f3538l) {
            D(fVar);
            f3537k.add(new WeakReference(fVar));
        }
    }

    public static f f(Activity activity, d dVar) {
        return new g(activity, dVar);
    }

    public static f g(Dialog dialog, d dVar) {
        return new g(dialog, dVar);
    }

    public static androidx.core.os.f i() {
        if (androidx.core.os.a.b()) {
            Object n3 = n();
            if (n3 != null) {
                return androidx.core.os.f.f(b.a(n3));
            }
        } else {
            androidx.core.os.f fVar = f3533g;
            if (fVar != null) {
                return fVar;
            }
        }
        return androidx.core.os.f.c();
    }

    public static int k() {
        return f3532f;
    }

    static Object n() {
        Context j3;
        Iterator it = f3537k.iterator();
        while (it.hasNext()) {
            f fVar = (f) ((WeakReference) it.next()).get();
            if (fVar != null && (j3 = fVar.j()) != null) {
                return j3.getSystemService("locale");
            }
        }
        return null;
    }

    static boolean s(Context context) {
        if (f3535i == null) {
            try {
                Bundle bundle = AppLocalesMetadataHolderService.a(context).metaData;
                if (bundle != null) {
                    f3535i = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f3535i = Boolean.FALSE;
            }
        }
        return f3535i.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Context context) {
        n.c(context);
        f3536j = true;
    }

    public abstract void A();

    public abstract void B();

    public abstract boolean E(int i3);

    public abstract void F(int i3);

    public abstract void G(View view);

    public abstract void H(View view, ViewGroup.LayoutParams layoutParams);

    public void I(OnBackInvokedDispatcher onBackInvokedDispatcher) {
    }

    public abstract void J(Toolbar toolbar);

    public abstract void K(int i3);

    public abstract void L(CharSequence charSequence);

    public abstract androidx.appcompat.view.b M(b.a aVar);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public void d(Context context) {
    }

    public Context e(Context context) {
        d(context);
        return context;
    }

    public abstract View h(int i3);

    public abstract Context j();

    public abstract androidx.appcompat.app.b l();

    public abstract int m();

    public abstract MenuInflater o();

    public abstract androidx.appcompat.app.a p();

    public abstract void q();

    public abstract void r();

    public abstract void u(Configuration configuration);

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z(Bundle bundle);
}
