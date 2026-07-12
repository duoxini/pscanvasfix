package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class E {

    /* renamed from: a, reason: collision with root package name */
    private final Map f5703a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set f5704b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f5705c = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    final void a() {
        this.f5705c = true;
        Map map = this.f5703a;
        if (map != null) {
            synchronized (map) {
                try {
                    Iterator it = this.f5703a.values().iterator();
                    while (it.hasNext()) {
                        b(it.next());
                    }
                } finally {
                }
            }
        }
        Set set = this.f5704b;
        if (set != null) {
            synchronized (set) {
                try {
                    Iterator it2 = this.f5704b.iterator();
                    while (it2.hasNext()) {
                        b((Closeable) it2.next());
                    }
                } finally {
                }
            }
        }
        d();
    }

    Object c(String str) {
        Object obj;
        Map map = this.f5703a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            obj = this.f5703a.get(str);
        }
        return obj;
    }

    protected void d() {
    }

    Object e(String str, Object obj) {
        Object obj2;
        synchronized (this.f5703a) {
            try {
                obj2 = this.f5703a.get(str);
                if (obj2 == null) {
                    this.f5703a.put(str, obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj2 != null) {
            obj = obj2;
        }
        if (this.f5705c) {
            b(obj);
        }
        return obj;
    }
}
