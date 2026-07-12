package r2;

import D2.k;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c {
    public static final Object[] d(int i3) {
        if (i3 >= 0) {
            return new Object[i3];
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public static final Object[] e(Object[] objArr, int i3) {
        k.e(objArr, "<this>");
        Object[] copyOf = Arrays.copyOf(objArr, i3);
        k.d(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final void f(Object[] objArr, int i3) {
        k.e(objArr, "<this>");
        objArr[i3] = null;
    }

    public static final void g(Object[] objArr, int i3, int i4) {
        k.e(objArr, "<this>");
        while (i3 < i4) {
            f(objArr, i3);
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Object[] objArr, int i3, int i4, List list) {
        if (i4 != list.size()) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!k.a(objArr[i3 + i5], list.get(i5))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(Object[] objArr, int i3, int i4) {
        int i5 = 1;
        for (int i6 = 0; i6 < i4; i6++) {
            Object obj = objArr[i3 + i6];
            i5 = (i5 * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Object[] objArr, int i3, int i4, Collection collection) {
        StringBuilder sb = new StringBuilder((i4 * 3) + 2);
        sb.append("[");
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object obj = objArr[i3 + i5];
            if (obj == collection) {
                sb.append("(this Collection)");
            } else {
                sb.append(obj);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        k.d(sb2, "toString(...)");
        return sb2;
    }
}
