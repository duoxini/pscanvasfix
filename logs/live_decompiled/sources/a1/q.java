package a1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import f1.C0355c;
import f1.C0356d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import k1.AbstractC0441l;
import m1.AbstractC0462e;
import m1.AbstractC0465h;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f3245a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Set f3246b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f3247c = {80, 75, 3, 4};

    private static boolean A(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    private static Boolean B(U2.d dVar) {
        try {
            U2.d E3 = dVar.E();
            for (byte b3 : f3247c) {
                if (E3.Z() != b3) {
                    return Boolean.FALSE;
                }
            }
            E3.close();
            return Boolean.TRUE;
        } catch (Exception e3) {
            AbstractC0462e.b("Failed to check zip file header", e3);
            return Boolean.FALSE;
        } catch (NoSuchMethodError unused) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map map = f3245a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C0224d D(C0221a c0221a) {
        return new C0224d(c0221a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(String str, AtomicBoolean atomicBoolean, C0221a c0221a) {
        Map map = f3245a;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            J(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C0224d H(WeakReference weakReference, Context context, int i3, String str) {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return v(context, i3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ C0224d I(Context context, String str, String str2) {
        C0224d c3 = v.d(context).c(context, str, str2);
        if (str2 != null && c3.b() != null) {
            C0355c.b().c(str2, (C0221a) c3.b());
        }
        return c3;
    }

    private static void J(boolean z3) {
        ArrayList arrayList = new ArrayList(f3246b);
        if (arrayList.size() <= 0) {
            return;
        }
        androidx.appcompat.app.p.a(arrayList.get(0));
        throw null;
    }

    private static String K(Context context, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append("rawRes");
        sb.append(A(context) ? "_night_" : "_day_");
        sb.append(i3);
        return sb.toString();
    }

    private static com.oplus.anim.o h(final String str, Callable callable) {
        final C0221a a3 = str == null ? null : C0355c.b().a(str);
        if (a3 != null) {
            return new com.oplus.anim.o(new Callable() { // from class: a1.n
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    C0224d D3;
                    D3 = q.D(C0221a.this);
                    return D3;
                }
            });
        }
        if (str != null) {
            Map map = f3245a;
            if (map.containsKey(str)) {
                return (com.oplus.anim.o) map.get(str);
            }
        }
        com.oplus.anim.o oVar = new com.oplus.anim.o(callable);
        if (str != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            oVar.d(new InterfaceC0222b() { // from class: a1.o
                @Override // a1.InterfaceC0222b
                public final void a(Object obj) {
                    q.E(str, atomicBoolean, (C0221a) obj);
                }
            });
            oVar.c(new InterfaceC0222b() { // from class: a1.p
                @Override // a1.InterfaceC0222b
                public final void a(Object obj) {
                    q.C(str, atomicBoolean, (Throwable) obj);
                }
            });
            if (!atomicBoolean.get()) {
                Map map2 = f3245a;
                map2.put(str, oVar);
                if (map2.size() == 1) {
                    J(false);
                }
            }
        }
        return oVar;
    }

    private static r i(C0221a c0221a, String str) {
        for (r rVar : c0221a.j().values()) {
            if (rVar.b().equals(str)) {
                return rVar;
            }
        }
        return null;
    }

    public static com.oplus.anim.o j(Context context, String str) {
        return k(context, str, "asset_" + str);
    }

    public static com.oplus.anim.o k(Context context, final String str, final String str2) {
        final Context applicationContext = context.getApplicationContext();
        return h(str2, new Callable() { // from class: a1.m
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0224d m3;
                m3 = q.m(applicationContext, str, str2);
                return m3;
            }
        });
    }

    public static C0224d l(Context context, String str) {
        return m(context, str, "asset_" + str);
    }

    public static C0224d m(Context context, String str, String str2) {
        try {
            if (!AbstractC0465h.n(str, ".zip") && !AbstractC0465h.n(str, ".lottie")) {
                return o(context.getAssets().open(str), str2);
            }
            return y(context, new ZipInputStream(context.getAssets().open(str)), str2);
        } catch (IOException e3) {
            return new C0224d((Throwable) e3);
        }
    }

    public static com.oplus.anim.o n(final InputStream inputStream, final String str) {
        return h(str, new Callable() { // from class: a1.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0224d o3;
                o3 = q.o(inputStream, str);
                return o3;
            }
        });
    }

    public static C0224d o(InputStream inputStream, String str) {
        return p(inputStream, str, true);
    }

    private static C0224d p(InputStream inputStream, String str, boolean z3) {
        try {
            return q(l1.c.K(U2.g.a(U2.g.c(inputStream))), str);
        } finally {
            if (z3) {
                AbstractC0465h.c(inputStream);
            }
        }
    }

    public static C0224d q(l1.c cVar, String str) {
        return r(cVar, str, true);
    }

    private static C0224d r(l1.c cVar, String str, boolean z3) {
        try {
            try {
                C0221a a3 = AbstractC0441l.a(cVar);
                if (str != null) {
                    C0355c.b().c(str, a3);
                }
                C0224d c0224d = new C0224d(a3);
                if (z3) {
                    AbstractC0465h.c(cVar);
                }
                return c0224d;
            } catch (Exception e3) {
                C0224d c0224d2 = new C0224d((Throwable) e3);
                if (z3) {
                    AbstractC0465h.c(cVar);
                }
                return c0224d2;
            }
        } catch (Throwable th) {
            if (z3) {
                AbstractC0465h.c(cVar);
            }
            throw th;
        }
    }

    public static com.oplus.anim.o s(Context context, int i3) {
        return t(context, i3, K(context, i3));
    }

    public static com.oplus.anim.o t(Context context, final int i3, final String str) {
        final WeakReference weakReference = new WeakReference(context);
        final Context applicationContext = context.getApplicationContext();
        return h(str, new Callable() { // from class: a1.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0224d H3;
                H3 = q.H(weakReference, applicationContext, i3, str);
                return H3;
            }
        });
    }

    public static C0224d u(Context context, int i3) {
        return v(context, i3, K(context, i3));
    }

    public static C0224d v(Context context, int i3, String str) {
        try {
            U2.d a3 = U2.g.a(U2.g.c(context.getResources().openRawResource(i3)));
            return B(a3).booleanValue() ? y(context, new ZipInputStream(a3.Y()), str) : o(a3.Y(), str);
        } catch (Resources.NotFoundException e3) {
            return new C0224d((Throwable) e3);
        }
    }

    public static com.oplus.anim.o w(Context context, String str) {
        return x(context, str, "url_" + str);
    }

    public static com.oplus.anim.o x(final Context context, final String str, final String str2) {
        return h(str2, new Callable() { // from class: a1.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C0224d I3;
                I3 = q.I(context, str, str2);
                return I3;
            }
        });
    }

    public static C0224d y(Context context, ZipInputStream zipInputStream, String str) {
        try {
            return z(context, zipInputStream, str);
        } finally {
            AbstractC0465h.c(zipInputStream);
        }
    }

    private static C0224d z(Context context, ZipInputStream zipInputStream, String str) {
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            C0221a c0221a = null;
            while (nextEntry != null) {
                String name = nextEntry.getName();
                if (name.contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().equalsIgnoreCase("manifest.json")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    c0221a = (C0221a) r(l1.c.K(U2.g.a(U2.g.c(zipInputStream))), null, false).b();
                } else {
                    if (!name.contains(".png") && !name.contains(".webp") && !name.contains(".jpg") && !name.contains(".jpeg")) {
                        if (!name.contains(".ttf") && !name.contains(".otf")) {
                            zipInputStream.closeEntry();
                        }
                        String[] split = name.split("/");
                        String str2 = split[split.length - 1];
                        String str3 = str2.split("\\.")[0];
                        File file = new File(context.getCacheDir(), str2);
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (Throwable th) {
                            AbstractC0462e.d("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                        }
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            }
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            Typeface createFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                AbstractC0462e.c("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            hashMap2.put(str3, createFromFile);
                            fileOutputStream2.close();
                        } catch (Throwable th2) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                    String[] split2 = name.split("/");
                    hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (c0221a == null) {
                return new C0224d((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                r i3 = i(c0221a, (String) entry.getKey());
                if (i3 != null) {
                    i3.f(AbstractC0465h.m((Bitmap) entry.getValue(), i3.e(), i3.c()));
                }
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                boolean z3 = false;
                for (C0356d c0356d : c0221a.g().values()) {
                    if (c0356d.a().equals(entry2.getKey())) {
                        c0356d.e((Typeface) entry2.getValue());
                        z3 = true;
                    }
                }
                if (!z3) {
                    AbstractC0462e.c("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
                }
            }
            if (hashMap.isEmpty()) {
                Iterator it = c0221a.j().entrySet().iterator();
                while (it.hasNext()) {
                    r rVar = (r) ((Map.Entry) it.next()).getValue();
                    if (rVar == null) {
                        return null;
                    }
                    String b3 = rVar.b();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = 160;
                    if (b3.startsWith("data:") && b3.indexOf("base64,") > 0) {
                        try {
                            byte[] decode = Base64.decode(b3.substring(b3.indexOf(44) + 1), 0);
                            rVar.f(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                        } catch (IllegalArgumentException e3) {
                            AbstractC0462e.d("data URL did not have correct base64 format.", e3);
                            return null;
                        }
                    }
                }
            }
            for (Map.Entry entry3 : c0221a.j().entrySet()) {
                if (((r) entry3.getValue()).a() == null) {
                    return new C0224d((Throwable) new IllegalStateException("There is no image for " + ((r) entry3.getValue()).b()));
                }
            }
            if (str != null) {
                C0355c.b().c(str, c0221a);
            }
            return new C0224d(c0221a);
        } catch (IOException e4) {
            return new C0224d((Throwable) e4);
        }
    }
}
