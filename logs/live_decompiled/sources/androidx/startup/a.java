package androidx.startup;

import Q.b;
import Q.c;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f6641d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f6642e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f6645c;

    /* renamed from: b, reason: collision with root package name */
    final Set f6644b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map f6643a = new HashMap();

    a(Context context) {
        this.f6645c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object obj;
        if (R.a.d()) {
            try {
                R.a.a(cls.getSimpleName());
            } catch (Throwable th) {
                R.a.b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f6643a.containsKey(cls)) {
            obj = this.f6643a.get(cls);
        } else {
            set.add(cls);
            try {
                Q.a aVar = (Q.a) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> a3 = aVar.a();
                if (!a3.isEmpty()) {
                    for (Class cls2 : a3) {
                        if (!this.f6643a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                obj = aVar.b(this.f6645c);
                set.remove(cls);
                this.f6643a.put(cls, obj);
            } catch (Throwable th2) {
                throw new c(th2);
            }
        }
        R.a.b();
        return obj;
    }

    public static a e(Context context) {
        if (f6641d == null) {
            synchronized (f6642e) {
                try {
                    if (f6641d == null) {
                        f6641d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f6641d;
    }

    void a() {
        try {
            try {
                R.a.a("Startup");
                b(this.f6645c.getPackageManager().getProviderInfo(new ComponentName(this.f6645c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e3) {
                throw new c(e3);
            }
        } finally {
            R.a.b();
        }
    }

    void b(Bundle bundle) {
        String string = this.f6645c.getString(b.f1886a);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (Q.a.class.isAssignableFrom(cls)) {
                            this.f6644b.add(cls);
                        }
                    }
                }
                Iterator it = this.f6644b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e3) {
                throw new c(e3);
            }
        }
    }

    Object c(Class cls) {
        Object obj;
        synchronized (f6642e) {
            try {
                obj = this.f6643a.get(cls);
                if (obj == null) {
                    obj = d(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f6644b.contains(cls);
    }
}
