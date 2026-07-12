package K2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p2.C0510j;
import q2.AbstractC0520C;
import q2.AbstractC0538h;
import q2.AbstractC0544n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class o extends n {

    static final class a extends D2.l implements C2.p {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f1190e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f1191f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, boolean z3) {
            super(2);
            this.f1190e = list;
            this.f1191f = z3;
        }

        public final C0510j a(CharSequence charSequence, int i3) {
            D2.k.e(charSequence, "$this$$receiver");
            C0510j x3 = o.x(charSequence, this.f1190e, i3, this.f1191f, false);
            if (x3 != null) {
                return p2.n.a(x3.c(), Integer.valueOf(((String) x3.d()).length()));
            }
            return null;
        }

        @Override // C2.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    static final class b extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CharSequence f1192e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f1192e = charSequence;
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String f(H2.c cVar) {
            D2.k.e(cVar, "it");
            return o.U(this.f1192e, cVar);
        }
    }

    public static final int A(CharSequence charSequence, char c3, int i3, boolean z3) {
        D2.k.e(charSequence, "<this>");
        return (z3 || !(charSequence instanceof String)) ? G(charSequence, new char[]{c3}, i3, z3) : ((String) charSequence).indexOf(c3, i3);
    }

    public static final int B(CharSequence charSequence, String str, int i3, boolean z3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(str, "string");
        return (z3 || !(charSequence instanceof String)) ? D(charSequence, str, i3, charSequence.length(), z3, false, 16, null) : ((String) charSequence).indexOf(str, i3);
    }

    private static final int C(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3, boolean z4) {
        H2.a cVar = !z4 ? new H2.c(H2.d.b(i3, 0), H2.d.c(i4, charSequence.length())) : H2.d.f(H2.d.c(i3, e.z(charSequence)), H2.d.b(i4, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a3 = cVar.a();
            int b3 = cVar.b();
            int c3 = cVar.c();
            if ((c3 <= 0 || a3 > b3) && (c3 >= 0 || b3 > a3)) {
                return -1;
            }
            while (!n.n((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z3)) {
                if (a3 == b3) {
                    return -1;
                }
                a3 += c3;
            }
            return a3;
        }
        int a4 = cVar.a();
        int b4 = cVar.b();
        int c4 = cVar.c();
        if ((c4 <= 0 || a4 > b4) && (c4 >= 0 || b4 > a4)) {
            return -1;
        }
        while (!Q(charSequence2, 0, charSequence, a4, charSequence2.length(), z3)) {
            if (a4 == b4) {
                return -1;
            }
            a4 += c4;
        }
        return a4;
    }

    static /* synthetic */ int D(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z3, boolean z4, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            z4 = false;
        }
        return C(charSequence, charSequence2, i3, i4, z3, z4);
    }

    public static /* synthetic */ int E(CharSequence charSequence, char c3, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return A(charSequence, c3, i3, z3);
    }

    public static /* synthetic */ int F(CharSequence charSequence, String str, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return B(charSequence, str, i3, z3);
    }

    public static final int G(CharSequence charSequence, char[] cArr, int i3, boolean z3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(cArr, "chars");
        if (!z3 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC0538h.D(cArr), i3);
        }
        AbstractC0520C it = new H2.c(H2.d.b(i3, 0), e.z(charSequence)).iterator();
        while (it.hasNext()) {
            int a3 = it.a();
            char charAt = charSequence.charAt(a3);
            for (char c3 : cArr) {
                if (K2.b.d(c3, charAt, z3)) {
                    return a3;
                }
            }
        }
        return -1;
    }

    public static final int H(CharSequence charSequence, char c3, int i3, boolean z3) {
        D2.k.e(charSequence, "<this>");
        return (z3 || !(charSequence instanceof String)) ? L(charSequence, new char[]{c3}, i3, z3) : ((String) charSequence).lastIndexOf(c3, i3);
    }

    public static final int I(CharSequence charSequence, String str, int i3, boolean z3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(str, "string");
        return (z3 || !(charSequence instanceof String)) ? C(charSequence, str, i3, 0, z3, true) : ((String) charSequence).lastIndexOf(str, i3);
    }

    public static /* synthetic */ int J(CharSequence charSequence, char c3, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = e.z(charSequence);
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return H(charSequence, c3, i3, z3);
    }

    public static /* synthetic */ int K(CharSequence charSequence, String str, int i3, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = e.z(charSequence);
        }
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        return I(charSequence, str, i3, z3);
    }

    public static final int L(CharSequence charSequence, char[] cArr, int i3, boolean z3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(cArr, "chars");
        if (!z3 && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC0538h.D(cArr), i3);
        }
        for (int c3 = H2.d.c(i3, e.z(charSequence)); -1 < c3; c3--) {
            char charAt = charSequence.charAt(c3);
            for (char c4 : cArr) {
                if (K2.b.d(c4, charAt, z3)) {
                    return c3;
                }
            }
        }
        return -1;
    }

    public static final J2.b M(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        return T(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List N(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        return J2.c.d(M(charSequence));
    }

    private static final J2.b O(CharSequence charSequence, String[] strArr, int i3, boolean z3, int i4) {
        R(i4);
        return new d(charSequence, i3, i4, new a(AbstractC0538h.f(strArr), z3));
    }

    static /* synthetic */ J2.b P(CharSequence charSequence, String[] strArr, int i3, boolean z3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            z3 = false;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return O(charSequence, strArr, i3, z3, i4);
    }

    public static final boolean Q(CharSequence charSequence, int i3, CharSequence charSequence2, int i4, int i5, boolean z3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(charSequence2, "other");
        if (i4 < 0 || i3 < 0 || i3 > charSequence.length() - i5 || i4 > charSequence2.length() - i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!K2.b.d(charSequence.charAt(i3 + i6), charSequence2.charAt(i4 + i6), z3)) {
                return false;
            }
        }
        return true;
    }

    public static final void R(int i3) {
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3).toString());
    }

    public static final J2.b S(CharSequence charSequence, String[] strArr, boolean z3, int i3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(strArr, "delimiters");
        return J2.c.c(P(charSequence, strArr, 0, z3, i3, 2, null), new b(charSequence));
    }

    public static /* synthetic */ J2.b T(CharSequence charSequence, String[] strArr, boolean z3, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return S(charSequence, strArr, z3, i3);
    }

    public static final String U(CharSequence charSequence, H2.c cVar) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(cVar, "range");
        return charSequence.subSequence(cVar.h().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static final String V(String str, char c3, String str2) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "missingDelimiterValue");
        int E3 = E(str, c3, 0, false, 6, null);
        if (E3 == -1) {
            return str2;
        }
        String substring = str.substring(E3 + 1, str.length());
        D2.k.d(substring, "substring(...)");
        return substring;
    }

    public static final String W(String str, String str2, String str3) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "delimiter");
        D2.k.e(str3, "missingDelimiterValue");
        int F3 = e.F(str, str2, 0, false, 6, null);
        if (F3 == -1) {
            return str3;
        }
        String substring = str.substring(F3 + str2.length(), str.length());
        D2.k.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String X(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return V(str, c3, str2);
    }

    public static /* synthetic */ String Y(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return W(str, str2, str3);
    }

    public static final String Z(String str, char c3, String str2) {
        D2.k.e(str, "<this>");
        D2.k.e(str2, "missingDelimiterValue");
        int J3 = J(str, c3, 0, false, 6, null);
        if (J3 == -1) {
            return str2;
        }
        String substring = str.substring(J3 + 1, str.length());
        D2.k.d(substring, "substring(...)");
        return substring;
    }

    public static /* synthetic */ String a0(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return Z(str, c3, str2);
    }

    public static CharSequence b0(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length) {
            boolean c3 = K2.a.c(charSequence.charAt(!z3 ? i3 : length));
            if (z3) {
                if (!c3) {
                    break;
                }
                length--;
            } else if (c3) {
                i3++;
            } else {
                z3 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    public static final boolean v(CharSequence charSequence, CharSequence charSequence2, boolean z3) {
        D2.k.e(charSequence, "<this>");
        D2.k.e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (e.F(charSequence, (String) charSequence2, 0, z3, 2, null) < 0) {
                return false;
            }
        } else if (D(charSequence, charSequence2, 0, charSequence.length(), z3, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean w(CharSequence charSequence, CharSequence charSequence2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        return v(charSequence, charSequence2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C0510j x(CharSequence charSequence, Collection collection, int i3, boolean z3, boolean z4) {
        Object obj;
        Object obj2;
        if (!z3 && collection.size() == 1) {
            String str = (String) AbstractC0544n.x(collection);
            int F3 = !z4 ? e.F(charSequence, str, i3, false, 4, null) : e.K(charSequence, str, i3, false, 4, null);
            if (F3 < 0) {
                return null;
            }
            return p2.n.a(Integer.valueOf(F3), str);
        }
        H2.a cVar = !z4 ? new H2.c(H2.d.b(i3, 0), charSequence.length()) : H2.d.f(H2.d.c(i3, e.z(charSequence)), 0);
        if (charSequence instanceof String) {
            int a3 = cVar.a();
            int b3 = cVar.b();
            int c3 = cVar.c();
            if ((c3 > 0 && a3 <= b3) || (c3 < 0 && b3 <= a3)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (n.n(str2, 0, (String) charSequence, a3, str2.length(), z3)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a3 == b3) {
                            break;
                        }
                        a3 += c3;
                    } else {
                        return p2.n.a(Integer.valueOf(a3), str3);
                    }
                }
            }
        } else {
            int a4 = cVar.a();
            int b4 = cVar.b();
            int c4 = cVar.c();
            if ((c4 > 0 && a4 <= b4) || (c4 < 0 && b4 <= a4)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (Q(str4, 0, charSequence, a4, str4.length(), z3)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a4 == b4) {
                            break;
                        }
                        a4 += c4;
                    } else {
                        return p2.n.a(Integer.valueOf(a4), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final H2.c y(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        return new H2.c(0, charSequence.length() - 1);
    }

    public static int z(CharSequence charSequence) {
        D2.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }
}
