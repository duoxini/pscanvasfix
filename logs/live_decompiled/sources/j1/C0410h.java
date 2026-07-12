package j1;

import a1.C0221a;
import a1.C0224d;
import a1.q;
import android.content.Context;
import android.util.Pair;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import m1.AbstractC0462e;
import m1.AbstractC0465h;

/* renamed from: j1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0410h {

    /* renamed from: a, reason: collision with root package name */
    private final C0409g f12156a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0407e f12157b;

    public C0410h(C0409g c0409g, InterfaceC0407e interfaceC0407e) {
        this.f12156a = c0409g;
        this.f12157b = interfaceC0407e;
    }

    private C0221a a(Context context, String str, String str2) {
        C0409g c0409g;
        Pair a3;
        if (str2 == null || (c0409g = this.f12156a) == null || (a3 = c0409g.a(str)) == null) {
            return null;
        }
        EnumC0408f enumC0408f = (EnumC0408f) a3.first;
        InputStream inputStream = (InputStream) a3.second;
        C0224d y3 = enumC0408f == EnumC0408f.ZIP ? q.y(context, new ZipInputStream(inputStream), str2) : q.o(inputStream, str2);
        if (y3.b() != null) {
            return (C0221a) y3.b();
        }
        return null;
    }

    private C0224d b(Context context, String str, String str2) {
        AbstractC0462e.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                InterfaceC0405c a3 = this.f12157b.a(str);
                if (!a3.V()) {
                    C0224d c0224d = new C0224d((Throwable) new IllegalArgumentException(a3.R()));
                    try {
                        a3.close();
                    } catch (IOException e3) {
                        AbstractC0462e.d("EffectiveFetchResult close failed ", e3);
                    }
                    return c0224d;
                }
                C0224d d3 = d(context, str, a3.h(), a3.M(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(d3.b() != null);
                AbstractC0462e.a(sb.toString());
                try {
                    a3.close();
                } catch (IOException e4) {
                    AbstractC0462e.d("EffectiveFetchResult close failed ", e4);
                }
                return d3;
            } catch (Exception e5) {
                C0224d c0224d2 = new C0224d((Throwable) e5);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e6) {
                        AbstractC0462e.d("EffectiveFetchResult close failed ", e6);
                    }
                }
                return c0224d2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e7) {
                    AbstractC0462e.d("EffectiveFetchResult close failed ", e7);
                }
            }
            throw th;
        }
    }

    private C0224d d(Context context, String str, InputStream inputStream, String str2, String str3) {
        C0224d f3;
        EnumC0408f enumC0408f;
        C0409g c0409g;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || AbstractC0465h.n(str.split("\\?")[0], ".lottie")) {
            AbstractC0462e.a("Handling zip response.");
            EnumC0408f enumC0408f2 = EnumC0408f.ZIP;
            f3 = f(context, str, inputStream, str3);
            enumC0408f = enumC0408f2;
        } else {
            AbstractC0462e.a("Received json response.");
            enumC0408f = EnumC0408f.JSON;
            f3 = e(str, inputStream, str3);
        }
        if (str3 != null && f3.b() != null && (c0409g = this.f12156a) != null) {
            c0409g.e(str, enumC0408f);
        }
        return f3;
    }

    private C0224d e(String str, InputStream inputStream, String str2) {
        C0409g c0409g;
        return (str2 == null || (c0409g = this.f12156a) == null) ? q.o(inputStream, null) : q.o(new FileInputStream(c0409g.f(str, inputStream, EnumC0408f.JSON).getAbsolutePath()), str);
    }

    private C0224d f(Context context, String str, InputStream inputStream, String str2) {
        C0409g c0409g;
        return (str2 == null || (c0409g = this.f12156a) == null) ? q.y(context, new ZipInputStream(inputStream), null) : q.y(context, new ZipInputStream(new FileInputStream(c0409g.f(str, inputStream, EnumC0408f.ZIP))), str);
    }

    public C0224d c(Context context, String str, String str2) {
        C0221a a3 = a(context, str, str2);
        if (a3 != null) {
            return new C0224d(a3);
        }
        AbstractC0462e.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }
}
