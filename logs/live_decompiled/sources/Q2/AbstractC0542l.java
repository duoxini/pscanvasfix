package q2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0542l extends AbstractC0541k {
    public static final String A(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, C2.l lVar) {
        D2.k.e(objArr, "<this>");
        D2.k.e(charSequence, "separator");
        D2.k.e(charSequence2, "prefix");
        D2.k.e(charSequence3, "postfix");
        D2.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) z(objArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i3, charSequence4, lVar)).toString();
        D2.k.d(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String B(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, C2.l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i4 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i4 & 4) == 0 ? charSequence3 : "";
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        int i5 = i3;
        if ((i4 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i4 & 32) != 0) {
            lVar = null;
        }
        return A(objArr, charSequence, charSequence5, charSequence6, i5, charSequence7, lVar);
    }

    public static final int C(int[] iArr, int i3) {
        D2.k.e(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i4 = length - 1;
                if (i3 == iArr[length]) {
                    return length;
                }
                if (i4 < 0) {
                    break;
                }
                length = i4;
            }
        }
        return -1;
    }

    public static char D(char[] cArr) {
        D2.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object E(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        if (objArr.length == 1) {
            return objArr[0];
        }
        return null;
    }

    public static final List F(Object[] objArr, int i3) {
        D2.k.e(objArr, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
        }
        if (i3 == 0) {
            return AbstractC0544n.j();
        }
        int length = objArr.length;
        if (i3 >= length) {
            return AbstractC0538h.G(objArr);
        }
        if (i3 == 1) {
            return AbstractC0544n.d(objArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = length - i3; i4 < length; i4++) {
            arrayList.add(objArr[i4]);
        }
        return arrayList;
    }

    public static List G(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? AbstractC0538h.H(objArr) : AbstractC0544n.d(objArr[0]) : AbstractC0544n.j();
    }

    public static List H(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        return new ArrayList(AbstractC0546p.g(objArr));
    }

    public static final boolean p(int[] iArr, int i3) {
        D2.k.e(iArr, "<this>");
        return x(iArr, i3) >= 0;
    }

    public static boolean q(Object[] objArr, Object obj) {
        D2.k.e(objArr, "<this>");
        return y(objArr, obj) >= 0;
    }

    public static List r(Object[] objArr, int i3) {
        D2.k.e(objArr, "<this>");
        if (i3 >= 0) {
            return F(objArr, H2.d.b(objArr.length - i3, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i3 + " is less than zero.").toString());
    }

    public static List s(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        return (List) t(objArr, new ArrayList());
    }

    public static final Collection t(Object[] objArr, Collection collection) {
        D2.k.e(objArr, "<this>");
        D2.k.e(collection, "destination");
        for (Object obj : objArr) {
            if (obj != null) {
                collection.add(obj);
            }
        }
        return collection;
    }

    public static int u(int[] iArr) {
        D2.k.e(iArr, "<this>");
        return iArr.length - 1;
    }

    public static int v(Object[] objArr) {
        D2.k.e(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Object w(Object[] objArr, int i3) {
        D2.k.e(objArr, "<this>");
        if (i3 < 0 || i3 > AbstractC0538h.v(objArr)) {
            return null;
        }
        return objArr[i3];
    }

    public static final int x(int[] iArr, int i3) {
        D2.k.e(iArr, "<this>");
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i3 == iArr[i4]) {
                return i4;
            }
        }
        return -1;
    }

    public static final int y(Object[] objArr, Object obj) {
        D2.k.e(objArr, "<this>");
        int i3 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i3 < length) {
                if (objArr[i3] == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i3 < length2) {
            if (D2.k.a(obj, objArr[i3])) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static final Appendable z(Object[] objArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, C2.l lVar) {
        D2.k.e(objArr, "<this>");
        D2.k.e(appendable, "buffer");
        D2.k.e(charSequence, "separator");
        D2.k.e(charSequence2, "prefix");
        D2.k.e(charSequence3, "postfix");
        D2.k.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i4 = 0;
        for (Object obj : objArr) {
            i4++;
            if (i4 > 1) {
                appendable.append(charSequence);
            }
            if (i3 >= 0 && i4 > i3) {
                break;
            }
            K2.e.a(appendable, obj, lVar);
        }
        if (i3 >= 0 && i4 > i3) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }
}
