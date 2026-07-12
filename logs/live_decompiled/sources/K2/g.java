package K2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.AbstractC0544n;
import q2.AbstractC0554x;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class g extends f {

    static final class a extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1188e = new a();

        a() {
            super(1);
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String f(String str) {
            D2.k.e(str, "line");
            return str;
        }
    }

    static final class b extends D2.l implements C2.l {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f1189e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f1189e = str;
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String f(String str) {
            D2.k.e(str, "line");
            return this.f1189e + str;
        }
    }

    private static final C2.l b(String str) {
        return str.length() == 0 ? a.f1188e : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (!K2.a.c(str.charAt(i3))) {
                break;
            }
            i3++;
        }
        return i3 == -1 ? str.length() : i3;
    }

    public static final String d(String str, String str2) {
        Appendable s3;
        String str3;
        D2.k.e(str, "<this>");
        D2.k.e(str2, "newIndent");
        List N3 = o.N(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : N3) {
            if (!e.m((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(AbstractC0544n.q(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) AbstractC0544n.w(arrayList2);
        int i3 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * N3.size());
        C2.l b3 = b(str2);
        int k3 = AbstractC0544n.k(N3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : N3) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                AbstractC0544n.p();
            }
            String str4 = (String) obj2;
            if ((i3 == 0 || i3 == k3) && e.m(str4)) {
                str4 = null;
            } else {
                String c02 = q.c0(str4, intValue);
                if (c02 != null && (str3 = (String) b3.f(c02)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i3 = i4;
        }
        s3 = AbstractC0554x.s(arrayList3, new StringBuilder(length), (r14 & 2) != 0 ? ", " : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        String sb = ((StringBuilder) s3).toString();
        D2.k.d(sb, "toString(...)");
        return sb;
    }

    public static String e(String str) {
        D2.k.e(str, "<this>");
        return d(str, "");
    }
}
