package a1;

import android.content.Context;
import android.util.Log;
import j1.C0404b;
import j1.C0409g;
import j1.C0410h;
import j1.InterfaceC0406d;
import j1.InterfaceC0407e;
import java.io.File;
import m1.AbstractC0465h;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3254a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f3255b = true;

    /* renamed from: c, reason: collision with root package name */
    private static String[] f3256c;

    /* renamed from: d, reason: collision with root package name */
    private static long[] f3257d;

    /* renamed from: e, reason: collision with root package name */
    private static int f3258e;

    /* renamed from: f, reason: collision with root package name */
    private static int f3259f;

    /* renamed from: g, reason: collision with root package name */
    private static InterfaceC0407e f3260g;

    /* renamed from: h, reason: collision with root package name */
    private static InterfaceC0406d f3261h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile C0410h f3262i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile C0409g f3263j;

    class a implements InterfaceC0406d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3264a;

        a(Context context) {
            this.f3264a = context;
        }

        @Override // j1.InterfaceC0406d
        public File a() {
            return new File(this.f3264a.getCacheDir(), "anim_network_cache");
        }
    }

    public static void a(String str) {
        if (f3254a) {
            int i3 = f3258e;
            if (i3 == 20) {
                f3259f++;
                return;
            }
            f3256c[i3] = str;
            f3257d[i3] = System.nanoTime();
            androidx.core.os.i.a(str);
            f3258e++;
        }
    }

    public static float b(String str) {
        int i3 = f3259f;
        if (i3 > 0) {
            f3259f = i3 - 1;
            return 0.0f;
        }
        if (!f3254a) {
            return 0.0f;
        }
        int i4 = f3258e - 1;
        f3258e = i4;
        if (i4 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(f3256c[i4])) {
            androidx.core.os.i.b();
            return (System.nanoTime() - f3257d[f3258e]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f3256c[f3258e] + ".");
    }

    public static C0409g c(Context context) {
        if (!f3255b) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        C0409g c0409g = f3263j;
        if (c0409g == null) {
            synchronized (C0409g.class) {
                try {
                    c0409g = f3263j;
                    if (c0409g == null) {
                        InterfaceC0406d interfaceC0406d = f3261h;
                        if (interfaceC0406d == null) {
                            interfaceC0406d = new a(applicationContext);
                        }
                        c0409g = new C0409g(interfaceC0406d);
                        f3263j = c0409g;
                    }
                } finally {
                }
            }
        }
        return c0409g;
    }

    public static C0410h d(Context context) {
        Log.d("LOG_Effective", "networkFetcher : context:" + context + ",callers:" + AbstractC0465h.g());
        C0410h c0410h = f3262i;
        if (c0410h == null) {
            synchronized (C0410h.class) {
                try {
                    c0410h = f3262i;
                    if (c0410h == null) {
                        C0409g c3 = c(context);
                        InterfaceC0407e interfaceC0407e = f3260g;
                        if (interfaceC0407e == null) {
                            interfaceC0407e = new C0404b();
                        }
                        c0410h = new C0410h(c3, interfaceC0407e);
                        f3262i = c0410h;
                    }
                } finally {
                }
            }
        }
        return c0410h;
    }
}
