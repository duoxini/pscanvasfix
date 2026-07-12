package q2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import s2.AbstractC0581a;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0546p extends AbstractC0545o {
    public static ArrayList f(Object... objArr) {
        D2.k.e(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new C0536f(objArr, true));
    }

    public static final Collection g(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        return new C0536f(objArr, false);
    }

    public static final int h(List list, Comparable comparable, int i3, int i4) {
        D2.k.e(list, "<this>");
        o(list.size(), i3, i4);
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int a3 = AbstractC0581a.a((Comparable) list.get(i6), comparable);
            if (a3 < 0) {
                i3 = i6 + 1;
            } else {
                if (a3 <= 0) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static /* synthetic */ int i(List list, Comparable comparable, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = list.size();
        }
        return h(list, comparable, i3, i4);
    }

    public static List j() {
        return C0556z.f13051e;
    }

    public static int k(List list) {
        D2.k.e(list, "<this>");
        return list.size() - 1;
    }

    public static List l(Object... objArr) {
        D2.k.e(objArr, "elements");
        return objArr.length > 0 ? AbstractC0538h.f(objArr) : AbstractC0544n.j();
    }

    public static List m(Object... objArr) {
        D2.k.e(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new C0536f(objArr, true));
    }

    public static final List n(List list) {
        D2.k.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : AbstractC0544n.d(list.get(0)) : AbstractC0544n.j();
    }

    private static final void o(int i3, int i4, int i5) {
        if (i4 > i5) {
            throw new IllegalArgumentException("fromIndex (" + i4 + ") is greater than toIndex (" + i5 + ").");
        }
        if (i4 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i4 + ") is less than zero.");
        }
        if (i5 <= i3) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i5 + ") is greater than size (" + i3 + ").");
    }

    public static void p() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
