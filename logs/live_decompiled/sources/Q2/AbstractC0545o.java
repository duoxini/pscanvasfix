package q2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import r2.C0570b;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0545o {
    public static List a(List list) {
        D2.k.e(list, "builder");
        return ((C0570b) list).i();
    }

    public static final Object[] b(Object[] objArr, boolean z3) {
        D2.k.e(objArr, "<this>");
        if (z3 && D2.k.a(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        D2.k.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static List c() {
        return new C0570b();
    }

    public static List d(Object obj) {
        List singletonList = Collections.singletonList(obj);
        D2.k.d(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static Object[] e(int i3, Object[] objArr) {
        D2.k.e(objArr, "array");
        if (i3 < objArr.length) {
            objArr[i3] = null;
        }
        return objArr;
    }
}
