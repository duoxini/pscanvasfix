package q2;

import androidx.preference.Preference;
import java.util.Collections;
import java.util.Map;
import p2.C0510j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.F, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0523F extends AbstractC0522E {
    public static Map b(Map map) {
        D2.k.e(map, "builder");
        return ((r2.d) map).k();
    }

    public static Map c() {
        return new r2.d();
    }

    public static int d(int i3) {
        return i3 < 0 ? i3 : i3 < 3 ? i3 + 1 : i3 < 1073741824 ? (int) ((i3 / 0.75f) + 1.0f) : Preference.DEFAULT_ORDER;
    }

    public static final Map e(C0510j c0510j) {
        D2.k.e(c0510j, "pair");
        Map singletonMap = Collections.singletonMap(c0510j.c(), c0510j.d());
        D2.k.d(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final Map f(Map map) {
        D2.k.e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        D2.k.d(singletonMap, "with(...)");
        return singletonMap;
    }
}
