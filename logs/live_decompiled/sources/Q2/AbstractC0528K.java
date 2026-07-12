package q2;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.K, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0528K {
    public static Set a(Set set) {
        D2.k.e(set, "builder");
        return ((r2.h) set).b();
    }

    public static Set b() {
        return new r2.h();
    }

    public static Set c(Object obj) {
        Set singleton = Collections.singleton(obj);
        D2.k.d(singleton, "singleton(...)");
        return singleton;
    }
}
