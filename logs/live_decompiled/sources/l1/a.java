package L1;

import D2.g;
import D2.k;
import K2.e;
import android.text.TextUtils;
import java.text.Collator;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import u1.C0598a;

/* loaded from: classes.dex */
public final class a implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final b f1220b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    private static final Set f1221c;

    /* renamed from: a, reason: collision with root package name */
    private final Collator f1222a;

    /* renamed from: L1.a$a, reason: collision with other inner class name */
    public static final class C0023a {

        /* renamed from: a, reason: collision with root package name */
        private final String f1223a;

        /* renamed from: b, reason: collision with root package name */
        private char f1224b;

        /* renamed from: c, reason: collision with root package name */
        private char f1225c;

        /* renamed from: d, reason: collision with root package name */
        private final int f1226d;

        public C0023a(C0598a.b bVar) {
            char c3;
            this.f1225c = '#';
            String c4 = bVar != null ? bVar.c() : null;
            c4 = c4 == null ? "" : c4;
            this.f1223a = c4;
            if (c4.length() > 0) {
                int length = c4.length() - 1;
                int i3 = 0;
                boolean z3 = false;
                while (i3 <= length) {
                    boolean z4 = k.f(c4.charAt(!z3 ? i3 : length), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    } else if (z4) {
                        i3++;
                    } else {
                        z3 = true;
                    }
                }
                c3 = b(c4.subSequence(i3, length + 1).toString());
            } else {
                c3 = '0';
            }
            this.f1224b = c3;
            int a3 = a.f1220b.a(c3);
            this.f1226d = a3;
            if (a3 == 1) {
                this.f1225c = Character.toUpperCase(this.f1224b);
            } else {
                if (a3 != 2) {
                    return;
                }
                char charAt = G0.b.d(this.f1224b).charAt(0);
                this.f1224b = charAt;
                this.f1225c = Character.toUpperCase(charAt);
            }
        }

        private final char b(String str) {
            int i3 = 0;
            while (i3 < str.length() - 1 && a.f1221c.contains(Character.valueOf(str.charAt(i3)))) {
                i3++;
            }
            return str.charAt(i3);
        }

        public final char a() {
            return this.f1225c;
        }

        public final String c() {
            return this.f1223a;
        }

        public final int d() {
            return this.f1226d;
        }
    }

    public static final class b {
        public /* synthetic */ b(g gVar) {
            this();
        }

        private final boolean b(char c3) {
            return Character.isLetter(c3);
        }

        private final boolean c(char c3) {
            return Character.isDigit(c3);
        }

        public final int a(char c3) {
            if (k.f(c3, 19968) >= 0 && k.f(c3, 40869) <= 0) {
                return 2;
            }
            if (c(c3)) {
                return 3;
            }
            return b(c3) ? 1 : 4;
        }

        private b() {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f1221c = hashSet;
        hashSet.add((char) 8234);
        hashSet.add((char) 8235);
        hashSet.add((char) 8236);
        hashSet.add((char) 8237);
        hashSet.add((char) 8238);
        hashSet.add((char) 8206);
        hashSet.add((char) 8207);
        hashSet.add((char) 160);
    }

    public a() {
        Collator collator = Collator.getInstance(Locale.CHINA);
        k.d(collator, "getInstance(...)");
        this.f1222a = collator;
    }

    @Override // java.util.Comparator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(C0598a.b bVar, C0598a.b bVar2) {
        int a3;
        int a4;
        C0023a c0023a = new C0023a(bVar);
        C0023a c0023a2 = new C0023a(bVar2);
        if (TextUtils.equals(c0023a.c(), c0023a2.c())) {
            return 0;
        }
        if (c0023a.a() == c0023a2.a()) {
            if (c0023a.d() == c0023a2.d()) {
                return c0023a.d() == 2 ? this.f1222a.compare(c0023a.c(), c0023a2.c()) : e.h(c0023a.c(), c0023a2.c(), true);
            }
            a3 = c0023a.d();
            a4 = c0023a2.d();
        } else {
            if (c0023a.a() == '#') {
                return 1;
            }
            if (c0023a2.a() == '#') {
                return -1;
            }
            a3 = c0023a.a();
            a4 = c0023a2.a();
        }
        return a3 - a4;
    }
}
