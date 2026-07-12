package q2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: q2.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0554x extends AbstractC0553w {
    public static final Collection A(Iterable iterable, Collection collection) {
        D2.k.e(iterable, "<this>");
        D2.k.e(collection, "destination");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static int[] B(Collection collection) {
        D2.k.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            iArr[i3] = ((Number) it.next()).intValue();
            i3++;
        }
        return iArr;
    }

    public static List C(Iterable iterable) {
        D2.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return AbstractC0546p.n(D(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return AbstractC0544n.j();
        }
        if (size != 1) {
            return E(collection);
        }
        return AbstractC0544n.d(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List D(Iterable iterable) {
        D2.k.e(iterable, "<this>");
        return iterable instanceof Collection ? E((Collection) iterable) : (List) A(iterable, new ArrayList());
    }

    public static final List E(Collection collection) {
        D2.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static List F(Iterable iterable, Iterable iterable2) {
        D2.k.e(iterable, "<this>");
        D2.k.e(iterable2, "other");
        Iterator it = iterable.iterator();
        Iterator it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(AbstractC0544n.q(iterable, 10), AbstractC0544n.q(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(p2.n.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final Appendable s(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, C2.l lVar) {
        D2.k.e(iterable, "<this>");
        D2.k.e(appendable, "buffer");
        D2.k.e(charSequence, "separator");
        D2.k.e(charSequence2, "prefix");
        D2.k.e(charSequence3, "postfix");
        D2.k.e(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i4 = 0;
        for (Object obj : iterable) {
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

    public static final String u(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, C2.l lVar) {
        D2.k.e(iterable, "<this>");
        D2.k.e(charSequence, "separator");
        D2.k.e(charSequence2, "prefix");
        D2.k.e(charSequence3, "postfix");
        D2.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) s(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i3, charSequence4, lVar)).toString();
        D2.k.d(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ String v(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, C2.l lVar, int i4, Object obj) {
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
        return u(iterable, charSequence, charSequence5, charSequence6, i5, charSequence7, lVar);
    }

    public static Comparable w(Iterable iterable) {
        D2.k.e(iterable, "<this>");
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable) it.next();
        while (it.hasNext()) {
            Comparable comparable2 = (Comparable) it.next();
            if (comparable.compareTo(comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return comparable;
    }

    public static Object x(Iterable iterable) {
        D2.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return y((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object y(List list) {
        D2.k.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static List z(Iterable iterable) {
        D2.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            List D3 = D(iterable);
            AbstractC0544n.r(D3);
            return D3;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return AbstractC0544n.C(iterable);
        }
        Object[] array = collection.toArray(new Comparable[0]);
        AbstractC0541k.o((Comparable[]) array);
        return AbstractC0538h.f(array);
    }
}
