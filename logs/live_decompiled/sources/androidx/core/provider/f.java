package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.core.provider.g;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import m.C0455e;

/* loaded from: classes.dex */
abstract class f {

    /* renamed from: a, reason: collision with root package name */
    static final C0455e f4945a = new C0455e(16);

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f4946b = h.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    static final Object f4947c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final m.g f4948d = new m.g();

    class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4949a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f4950b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.e f4951c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4952d;

        a(String str, Context context, androidx.core.provider.e eVar, int i3) {
            this.f4949a = str;
            this.f4950b = context;
            this.f4951c = eVar;
            this.f4952d = i3;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            return f.c(this.f4949a, this.f4950b, this.f4951c, this.f4952d);
        }
    }

    class b implements androidx.core.util.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.a f4953a;

        b(androidx.core.provider.a aVar) {
            this.f4953a = aVar;
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            if (eVar == null) {
                eVar = new e(-3);
            }
            this.f4953a.b(eVar);
        }
    }

    class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4954a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f4955b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ androidx.core.provider.e f4956c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4957d;

        c(String str, Context context, androidx.core.provider.e eVar, int i3) {
            this.f4954a = str;
            this.f4955b = context;
            this.f4956c = eVar;
            this.f4957d = i3;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e call() {
            try {
                return f.c(this.f4954a, this.f4955b, this.f4956c, this.f4957d);
            } catch (Throwable unused) {
                return new e(-3);
            }
        }
    }

    class d implements androidx.core.util.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4958a;

        d(String str) {
            this.f4958a = str;
        }

        @Override // androidx.core.util.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(e eVar) {
            synchronized (f.f4947c) {
                try {
                    m.g gVar = f.f4948d;
                    ArrayList arrayList = (ArrayList) gVar.get(this.f4958a);
                    if (arrayList == null) {
                        return;
                    }
                    gVar.remove(this.f4958a);
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        ((androidx.core.util.a) arrayList.get(i3)).accept(eVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private static String a(androidx.core.provider.e eVar, int i3) {
        return eVar.d() + "-" + i3;
    }

    private static int b(g.a aVar) {
        int i3 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        g.b[] b3 = aVar.b();
        if (b3 != null && b3.length != 0) {
            i3 = 0;
            for (g.b bVar : b3) {
                int b4 = bVar.b();
                if (b4 != 0) {
                    if (b4 < 0) {
                        return -3;
                    }
                    return b4;
                }
            }
        }
        return i3;
    }

    static e c(String str, Context context, androidx.core.provider.e eVar, int i3) {
        C0455e c0455e = f4945a;
        Typeface typeface = (Typeface) c0455e.c(str);
        if (typeface != null) {
            return new e(typeface);
        }
        try {
            g.a e3 = androidx.core.provider.d.e(context, eVar, null);
            int b3 = b(e3);
            if (b3 != 0) {
                return new e(b3);
            }
            Typeface b4 = androidx.core.graphics.d.b(context, null, e3.b(), i3);
            if (b4 == null) {
                return new e(-3);
            }
            c0455e.d(str, b4);
            return new e(b4);
        } catch (PackageManager.NameNotFoundException unused) {
            return new e(-1);
        }
    }

    static Typeface d(Context context, androidx.core.provider.e eVar, int i3, Executor executor, androidx.core.provider.a aVar) {
        String a3 = a(eVar, i3);
        Typeface typeface = (Typeface) f4945a.c(a3);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f4947c) {
            try {
                m.g gVar = f4948d;
                ArrayList arrayList = (ArrayList) gVar.get(a3);
                if (arrayList != null) {
                    arrayList.add(bVar);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar);
                gVar.put(a3, arrayList2);
                c cVar = new c(a3, context, eVar, i3);
                if (executor == null) {
                    executor = f4946b;
                }
                h.b(executor, cVar, new d(a3));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static Typeface e(Context context, androidx.core.provider.e eVar, androidx.core.provider.a aVar, int i3, int i4) {
        String a3 = a(eVar, i3);
        Typeface typeface = (Typeface) f4945a.c(a3);
        if (typeface != null) {
            aVar.b(new e(typeface));
            return typeface;
        }
        if (i4 == -1) {
            e c3 = c(a3, context, eVar, i3);
            aVar.b(c3);
            return c3.f4959a;
        }
        try {
            e eVar2 = (e) h.c(f4946b, new a(a3, context, eVar, i3), i4);
            aVar.b(eVar2);
            return eVar2.f4959a;
        } catch (InterruptedException unused) {
            aVar.b(new e(-3));
            return null;
        }
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        final Typeface f4959a;

        /* renamed from: b, reason: collision with root package name */
        final int f4960b;

        e(int i3) {
            this.f4959a = null;
            this.f4960b = i3;
        }

        boolean a() {
            return this.f4960b == 0;
        }

        e(Typeface typeface) {
            this.f4959a = typeface;
            this.f4960b = 0;
        }
    }
}
