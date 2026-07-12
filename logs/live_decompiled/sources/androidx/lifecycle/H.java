package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap f5723a = new HashMap();

    public final void a() {
        Iterator it = this.f5723a.values().iterator();
        while (it.hasNext()) {
            ((E) it.next()).a();
        }
        this.f5723a.clear();
    }

    final E b(String str) {
        return (E) this.f5723a.get(str);
    }

    Set c() {
        return new HashSet(this.f5723a.keySet());
    }

    final void d(String str, E e3) {
        E e4 = (E) this.f5723a.put(str, e3);
        if (e4 != null) {
            e4.d();
        }
    }
}
