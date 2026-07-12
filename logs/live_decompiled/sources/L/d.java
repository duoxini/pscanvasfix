package L;

import D2.g;
import D2.k;
import J.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final b f1193e = new b(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f1194a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1195b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f1196c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f1197d;

    public static final class a {

        /* renamed from: h, reason: collision with root package name */
        public static final C0021a f1198h = new C0021a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f1199a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1200b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f1201c;

        /* renamed from: d, reason: collision with root package name */
        public final int f1202d;

        /* renamed from: e, reason: collision with root package name */
        public final String f1203e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1204f;

        /* renamed from: g, reason: collision with root package name */
        public final int f1205g;

        /* renamed from: L.d$a$a, reason: collision with other inner class name */
        public static final class C0021a {
            public /* synthetic */ C0021a(g gVar) {
                this();
            }

            private final boolean a(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i3 < str.length()) {
                    char charAt = str.charAt(i3);
                    int i6 = i5 + 1;
                    if (i5 == 0 && charAt != '(') {
                        return false;
                    }
                    if (charAt == '(') {
                        i4++;
                    } else if (charAt == ')' && i4 - 1 == 0 && i5 != str.length() - 1) {
                        return false;
                    }
                    i3++;
                    i5 = i6;
                }
                return i4 == 0;
            }

            public final boolean b(String str, String str2) {
                k.e(str, "current");
                if (k.a(str, str2)) {
                    return true;
                }
                if (!a(str)) {
                    return false;
                }
                String substring = str.substring(1, str.length() - 1);
                k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return k.a(K2.e.b0(substring).toString(), str2);
            }

            private C0021a() {
            }
        }

        public a(String str, String str2, boolean z3, int i3, String str3, int i4) {
            k.e(str, "name");
            k.e(str2, "type");
            this.f1199a = str;
            this.f1200b = str2;
            this.f1201c = z3;
            this.f1202d = i3;
            this.f1203e = str3;
            this.f1204f = i4;
            this.f1205g = a(str2);
        }

        private final int a(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            k.d(locale, "US");
            String upperCase = str.toUpperCase(locale);
            k.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (K2.e.w(upperCase, "INT", false, 2, null)) {
                return 3;
            }
            if (K2.e.w(upperCase, "CHAR", false, 2, null) || K2.e.w(upperCase, "CLOB", false, 2, null) || K2.e.w(upperCase, "TEXT", false, 2, null)) {
                return 2;
            }
            if (K2.e.w(upperCase, "BLOB", false, 2, null)) {
                return 5;
            }
            return (K2.e.w(upperCase, "REAL", false, 2, null) || K2.e.w(upperCase, "FLOA", false, 2, null) || K2.e.w(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a) || this.f1202d != ((a) obj).f1202d) {
                return false;
            }
            a aVar = (a) obj;
            if (!k.a(this.f1199a, aVar.f1199a) || this.f1201c != aVar.f1201c) {
                return false;
            }
            if (this.f1204f == 1 && aVar.f1204f == 2 && (str3 = this.f1203e) != null && !f1198h.b(str3, aVar.f1203e)) {
                return false;
            }
            if (this.f1204f == 2 && aVar.f1204f == 1 && (str2 = aVar.f1203e) != null && !f1198h.b(str2, this.f1203e)) {
                return false;
            }
            int i3 = this.f1204f;
            return (i3 == 0 || i3 != aVar.f1204f || ((str = this.f1203e) == null ? aVar.f1203e == null : f1198h.b(str, aVar.f1203e))) && this.f1205g == aVar.f1205g;
        }

        public int hashCode() {
            return (((((this.f1199a.hashCode() * 31) + this.f1205g) * 31) + (this.f1201c ? 1231 : 1237)) * 31) + this.f1202d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Column{name='");
            sb.append(this.f1199a);
            sb.append("', type='");
            sb.append(this.f1200b);
            sb.append("', affinity='");
            sb.append(this.f1205g);
            sb.append("', notNull=");
            sb.append(this.f1201c);
            sb.append(", primaryKeyPosition=");
            sb.append(this.f1202d);
            sb.append(", defaultValue='");
            String str = this.f1203e;
            if (str == null) {
                str = "undefined";
            }
            sb.append(str);
            sb.append("'}");
            return sb.toString();
        }
    }

    public static final class b {
        public /* synthetic */ b(g gVar) {
            this();
        }

        public final d a(N.g gVar, String str) {
            k.e(gVar, "database");
            k.e(str, "tableName");
            return L.e.f(gVar, str);
        }

        private b() {
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f1206a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1207b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1208c;

        /* renamed from: d, reason: collision with root package name */
        public final List f1209d;

        /* renamed from: e, reason: collision with root package name */
        public final List f1210e;

        public c(String str, String str2, String str3, List list, List list2) {
            k.e(str, "referenceTable");
            k.e(str2, "onDelete");
            k.e(str3, "onUpdate");
            k.e(list, "columnNames");
            k.e(list2, "referenceColumnNames");
            this.f1206a = str;
            this.f1207b = str2;
            this.f1208c = str3;
            this.f1209d = list;
            this.f1210e = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (k.a(this.f1206a, cVar.f1206a) && k.a(this.f1207b, cVar.f1207b) && k.a(this.f1208c, cVar.f1208c) && k.a(this.f1209d, cVar.f1209d)) {
                return k.a(this.f1210e, cVar.f1210e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f1206a.hashCode() * 31) + this.f1207b.hashCode()) * 31) + this.f1208c.hashCode()) * 31) + this.f1209d.hashCode()) * 31) + this.f1210e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f1206a + "', onDelete='" + this.f1207b + " +', onUpdate='" + this.f1208c + "', columnNames=" + this.f1209d + ", referenceColumnNames=" + this.f1210e + '}';
        }
    }

    /* renamed from: L.d$d, reason: collision with other inner class name */
    public static final class C0022d implements Comparable {

        /* renamed from: e, reason: collision with root package name */
        private final int f1211e;

        /* renamed from: f, reason: collision with root package name */
        private final int f1212f;

        /* renamed from: g, reason: collision with root package name */
        private final String f1213g;

        /* renamed from: h, reason: collision with root package name */
        private final String f1214h;

        public C0022d(int i3, int i4, String str, String str2) {
            k.e(str, "from");
            k.e(str2, "to");
            this.f1211e = i3;
            this.f1212f = i4;
            this.f1213g = str;
            this.f1214h = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0022d c0022d) {
            k.e(c0022d, "other");
            int i3 = this.f1211e - c0022d.f1211e;
            return i3 == 0 ? this.f1212f - c0022d.f1212f : i3;
        }

        public final String b() {
            return this.f1213g;
        }

        public final int c() {
            return this.f1211e;
        }

        public final String d() {
            return this.f1214h;
        }
    }

    public static final class e {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1215e = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f1216a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1217b;

        /* renamed from: c, reason: collision with root package name */
        public final List f1218c;

        /* renamed from: d, reason: collision with root package name */
        public List f1219d;

        public static final class a {
            public /* synthetic */ a(g gVar) {
                this();
            }

            private a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public e(String str, boolean z3, List list, List list2) {
            k.e(str, "name");
            k.e(list, "columns");
            k.e(list2, "orders");
            this.f1216a = str;
            this.f1217b = z3;
            this.f1218c = list;
            this.f1219d = list2;
            List list3 = list2;
            if (list3.isEmpty()) {
                int size = list.size();
                list3 = new ArrayList(size);
                for (int i3 = 0; i3 < size; i3++) {
                    list3.add(l.ASC.name());
                }
            }
            this.f1219d = (List) list3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.f1217b == eVar.f1217b && k.a(this.f1218c, eVar.f1218c) && k.a(this.f1219d, eVar.f1219d)) {
                return K2.e.t(this.f1216a, "index_", false, 2, null) ? K2.e.t(eVar.f1216a, "index_", false, 2, null) : k.a(this.f1216a, eVar.f1216a);
            }
            return false;
        }

        public int hashCode() {
            return ((((((K2.e.t(this.f1216a, "index_", false, 2, null) ? -1184239155 : this.f1216a.hashCode()) * 31) + (this.f1217b ? 1 : 0)) * 31) + this.f1218c.hashCode()) * 31) + this.f1219d.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f1216a + "', unique=" + this.f1217b + ", columns=" + this.f1218c + ", orders=" + this.f1219d + "'}";
        }
    }

    public d(String str, Map map, Set set, Set set2) {
        k.e(str, "name");
        k.e(map, "columns");
        k.e(set, "foreignKeys");
        this.f1194a = str;
        this.f1195b = map;
        this.f1196c = set;
        this.f1197d = set2;
    }

    public static final d a(N.g gVar, String str) {
        return f1193e.a(gVar, str);
    }

    public boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!k.a(this.f1194a, dVar.f1194a) || !k.a(this.f1195b, dVar.f1195b) || !k.a(this.f1196c, dVar.f1196c)) {
            return false;
        }
        Set set2 = this.f1197d;
        if (set2 == null || (set = dVar.f1197d) == null) {
            return true;
        }
        return k.a(set2, set);
    }

    public int hashCode() {
        return (((this.f1194a.hashCode() * 31) + this.f1195b.hashCode()) * 31) + this.f1196c.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.f1194a + "', columns=" + this.f1195b + ", foreignKeys=" + this.f1196c + ", indices=" + this.f1197d + '}';
    }
}
