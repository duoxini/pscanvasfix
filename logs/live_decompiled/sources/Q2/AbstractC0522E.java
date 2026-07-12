package q2;

import java.util.Map;
import java.util.NoSuchElementException;

/* renamed from: q2.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
abstract class AbstractC0522E {
    public static final Object a(Map map, Object obj) {
        D2.k.e(map, "<this>");
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
