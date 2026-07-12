package K2;

import java.util.Collection;
import java.util.Iterator;
import q2.AbstractC0520C;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class n extends m {
    public static int h(String str, String str2, boolean z3) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "other");
        return z3 ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static String i(char[] cArr) {
        D2.k.e(cArr, "<this>");
        return new String(cArr);
    }

    public static final boolean j(String str, String str2, boolean z3) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "suffix");
        return !z3 ? str.endsWith(str2) : n(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean k(String str, String str2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return j(str, str2, z3);
    }

    public static boolean l(String str, String str2, boolean z3) {
        return str == null ? str2 == null : !z3 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static boolean m(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable y3 = o.y(charSequence);
            if (!(y3 instanceof Collection) || !((Collection) y3).isEmpty()) {
                Iterator it = y3.iterator();
                while (it.hasNext()) {
                    if (!a.c(charSequence.charAt(((AbstractC0520C) it).a()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean n(String str, int i3, String str2, int i4, int i5, boolean z3) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "other");
        return !z3 ? str.regionMatches(i3, str2, i4, i5) : str.regionMatches(z3, i3, str2, i4, i5);
    }

    public static final String o(String str, char c3, char c4, boolean z3) {
        D2.k.e(str, "<this>");
        if (!z3) {
            String replace = str.replace(c3, c4);
            D2.k.d(replace, "replace(...)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (b.d(charAt, c3, z3)) {
                charAt = c4;
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        D2.k.d(sb2, "toString(...)");
        return sb2;
    }

    public static final String p(String str, String str2, String str3, boolean z3) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "oldValue");
        D2.k.e(str3, "newValue");
        int i3 = 0;
        int B3 = o.B(str, str2, 0, z3);
        if (B3 < 0) {
            return str;
        }
        int length = str2.length();
        int b3 = H2.d.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i3, B3);
            sb.append(str3);
            i3 = B3 + length;
            if (B3 >= str.length()) {
                break;
            }
            B3 = o.B(str, str2, B3 + b3, z3);
        } while (B3 > 0);
        sb.append((CharSequence) str, i3, str.length());
        String sb2 = sb.toString();
        D2.k.d(sb2, "toString(...)");
        return sb2;
    }

    public static /* synthetic */ String q(String str, char c3, char c4, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return o(str, c3, c4, z3);
    }

    public static /* synthetic */ String r(String str, String str2, String str3, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        return p(str, str2, str3, z3);
    }

    public static final boolean s(String str, String str2, boolean z3) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "prefix");
        return !z3 ? str.startsWith(str2) : n(str, 0, str2, 0, str2.length(), z3);
    }

    public static /* synthetic */ boolean t(String str, String str2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return s(str, str2, z3);
    }
}
