package q2;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p2.C0510j;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0524G extends AbstractC0523F {
    public static Map g() {
        C0518A c0518a = C0518A.f13032e;
        D2.k.c(c0518a, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c0518a;
    }

    public static Object h(Map map, Object obj) {
        D2.k.e(map, "<this>");
        return AbstractC0522E.a(map, obj);
    }

    public static final Map i(Map map) {
        D2.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : AbstractC0523F.f(map) : AbstractC0521D.g();
    }

    public static final void j(Map map, Iterable iterable) {
        D2.k.e(map, "<this>");
        D2.k.e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C0510j c0510j = (C0510j) it.next();
            map.put(c0510j.a(), c0510j.b());
        }
    }

    public static Map k(Iterable iterable) {
        D2.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return i(l(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC0521D.g();
        }
        if (size != 1) {
            return l(iterable, new LinkedHashMap(AbstractC0521D.d(collection.size())));
        }
        return AbstractC0523F.e((C0510j) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map l(Iterable iterable, Map map) {
        D2.k.e(iterable, "<this>");
        D2.k.e(map, "destination");
        j(map, iterable);
        return map;
    }

    public static Map m(Map map) {
        D2.k.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? n(map) : AbstractC0523F.f(map) : AbstractC0521D.g();
    }

    public static final Map n(Map map) {
        D2.k.e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
