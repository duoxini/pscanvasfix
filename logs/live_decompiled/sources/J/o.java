package J;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import q2.AbstractC0521D;
import q2.AbstractC0527J;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public class o {

    /* renamed from: q, reason: collision with root package name */
    public static final a f1004q = new a(null);

    /* renamed from: r, reason: collision with root package name */
    private static final String[] f1005r = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a, reason: collision with root package name */
    private final u f1006a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f1007b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f1008c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f1009d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f1010e;

    /* renamed from: f, reason: collision with root package name */
    private C0165c f1011f;

    /* renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f1012g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f1013h;

    /* renamed from: i, reason: collision with root package name */
    private volatile N.k f1014i;

    /* renamed from: j, reason: collision with root package name */
    private final b f1015j;

    /* renamed from: k, reason: collision with root package name */
    private final m f1016k;

    /* renamed from: l, reason: collision with root package name */
    private final k.b f1017l;

    /* renamed from: m, reason: collision with root package name */
    private r f1018m;

    /* renamed from: n, reason: collision with root package name */
    private final Object f1019n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f1020o;

    /* renamed from: p, reason: collision with root package name */
    public final Runnable f1021p;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final void a(N.g gVar) {
            D2.k.e(gVar, "database");
            if (gVar.s()) {
                gVar.D();
            } else {
                gVar.f();
            }
        }

        public final String b(String str, String str2) {
            D2.k.e(str, "tableName");
            D2.k.e(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: e, reason: collision with root package name */
        public static final a f1022e = new a(null);

        /* renamed from: a, reason: collision with root package name */
        private final long[] f1023a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f1024b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f1025c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1026d;

        public static final class a {
            public /* synthetic */ a(D2.g gVar) {
                this();
            }

            private a() {
            }
        }

        public b(int i3) {
            this.f1023a = new long[i3];
            this.f1024b = new boolean[i3];
            this.f1025c = new int[i3];
        }

        public final int[] a() {
            synchronized (this) {
                try {
                    if (!this.f1026d) {
                        return null;
                    }
                    long[] jArr = this.f1023a;
                    int length = jArr.length;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        int i5 = i4 + 1;
                        int i6 = 1;
                        boolean z3 = jArr[i3] > 0;
                        boolean[] zArr = this.f1024b;
                        if (z3 != zArr[i4]) {
                            int[] iArr = this.f1025c;
                            if (!z3) {
                                i6 = 2;
                            }
                            iArr[i4] = i6;
                        } else {
                            this.f1025c[i4] = 0;
                        }
                        zArr[i4] = z3;
                        i3++;
                        i4 = i5;
                    }
                    this.f1026d = false;
                    return (int[]) this.f1025c.clone();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean b(int... iArr) {
            boolean z3;
            D2.k.e(iArr, "tableIds");
            synchronized (this) {
                try {
                    z3 = false;
                    for (int i3 : iArr) {
                        long[] jArr = this.f1023a;
                        long j3 = jArr[i3];
                        jArr[i3] = 1 + j3;
                        if (j3 == 0) {
                            this.f1026d = true;
                            z3 = true;
                        }
                    }
                    p2.q qVar = p2.q.f12810a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z3;
        }

        public final boolean c(int... iArr) {
            boolean z3;
            D2.k.e(iArr, "tableIds");
            synchronized (this) {
                try {
                    z3 = false;
                    for (int i3 : iArr) {
                        long[] jArr = this.f1023a;
                        long j3 = jArr[i3];
                        jArr[i3] = j3 - 1;
                        if (j3 == 1) {
                            this.f1026d = true;
                            z3 = true;
                        }
                    }
                    p2.q qVar = p2.q.f12810a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return z3;
        }

        public final void d() {
            synchronized (this) {
                Arrays.fill(this.f1024b, false);
                this.f1026d = true;
                p2.q qVar = p2.q.f12810a;
            }
        }
    }

    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        private final String[] f1027a;

        public c(String[] strArr) {
            D2.k.e(strArr, "tables");
            this.f1027a = strArr;
        }

        public final String[] a() {
            return this.f1027a;
        }

        public abstract boolean b();

        public abstract void c(Set set);
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final c f1028a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f1029b;

        /* renamed from: c, reason: collision with root package name */
        private final String[] f1030c;

        /* renamed from: d, reason: collision with root package name */
        private final Set f1031d;

        public d(c cVar, int[] iArr, String[] strArr) {
            D2.k.e(cVar, "observer");
            D2.k.e(iArr, "tableIds");
            D2.k.e(strArr, "tableNames");
            this.f1028a = cVar;
            this.f1029b = iArr;
            this.f1030c = strArr;
            this.f1031d = !(strArr.length == 0) ? AbstractC0527J.c(strArr[0]) : AbstractC0527J.d();
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        public final int[] a() {
            return this.f1029b;
        }

        public final void b(Set set) {
            Set d3;
            D2.k.e(set, "invalidatedTablesIds");
            int[] iArr = this.f1029b;
            int length = iArr.length;
            if (length != 0) {
                int i3 = 0;
                if (length != 1) {
                    Set b3 = AbstractC0527J.b();
                    int[] iArr2 = this.f1029b;
                    int length2 = iArr2.length;
                    int i4 = 0;
                    while (i3 < length2) {
                        int i5 = i4 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i3]))) {
                            b3.add(this.f1030c[i4]);
                        }
                        i3++;
                        i4 = i5;
                    }
                    d3 = AbstractC0527J.a(b3);
                } else {
                    d3 = set.contains(Integer.valueOf(iArr[0])) ? this.f1031d : AbstractC0527J.d();
                }
            } else {
                d3 = AbstractC0527J.d();
            }
            if (d3.isEmpty()) {
                return;
            }
            this.f1028a.c(d3);
        }

        public final void c(String[] strArr) {
            Set d3;
            D2.k.e(strArr, "tables");
            int length = this.f1030c.length;
            if (length == 0) {
                d3 = AbstractC0527J.d();
            } else if (length == 1) {
                int length2 = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        d3 = AbstractC0527J.d();
                        break;
                    } else {
                        if (K2.e.l(strArr[i3], this.f1030c[0], true)) {
                            d3 = this.f1031d;
                            break;
                        }
                        i3++;
                    }
                }
            } else {
                Set b3 = AbstractC0527J.b();
                for (String str : strArr) {
                    for (String str2 : this.f1030c) {
                        if (K2.e.l(str2, str, true)) {
                            b3.add(str2);
                        }
                    }
                }
                d3 = AbstractC0527J.a(b3);
            }
            if (d3.isEmpty()) {
                return;
            }
            this.f1028a.c(d3);
        }
    }

    public static final class e implements Runnable {
        e() {
        }

        private final Set a() {
            o oVar = o.this;
            Set b3 = AbstractC0527J.b();
            Cursor y3 = u.y(oVar.e(), new N.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null, 2, null);
            while (y3.moveToNext()) {
                try {
                    b3.add(Integer.valueOf(y3.getInt(0)));
                } finally {
                }
            }
            p2.q qVar = p2.q.f12810a;
            A2.a.a(y3, null);
            Set a3 = AbstractC0527J.a(b3);
            if (!a3.isEmpty()) {
                if (o.this.d() == null) {
                    throw new IllegalStateException("Required value was null.");
                }
                N.k d3 = o.this.d();
                if (d3 == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                d3.B();
            }
            return a3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        
            if (r0 != null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
        
            r0.e();
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00c4, code lost:
        
            if (r2.isEmpty() != false) goto L59;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
        
            r0 = r4.f1032e.f();
            r4 = r4.f1032e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00ce, code lost:
        
            monitor-enter(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
        
            r4 = r4.f().iterator();
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00db, code lost:
        
            if (r4.hasNext() == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00dd, code lost:
        
            ((J.o.d) ((java.util.Map.Entry) r4.next()).getValue()).b(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ef, code lost:
        
            r4 = p2.q.f12810a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
        
            monitor-exit(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
        
            r4 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00f4, code lost:
        
            throw r4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00f5, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00a6, code lost:
        
            if (r0 == null) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00bd, code lost:
        
            if (r0 == null) goto L44;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 261
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: J.o.e.run():void");
        }
    }

    public o(u uVar, Map map, Map map2, String... strArr) {
        String str;
        D2.k.e(uVar, "database");
        D2.k.e(map, "shadowTablesMap");
        D2.k.e(map2, "viewTables");
        D2.k.e(strArr, "tableNames");
        this.f1006a = uVar;
        this.f1007b = map;
        this.f1008c = map2;
        this.f1012g = new AtomicBoolean(false);
        this.f1015j = new b(strArr.length);
        this.f1016k = new m(uVar);
        this.f1017l = new k.b();
        this.f1019n = new Object();
        this.f1020o = new Object();
        this.f1009d = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str2 = strArr[i3];
            Locale locale = Locale.US;
            D2.k.d(locale, "US");
            String lowerCase = str2.toLowerCase(locale);
            D2.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.f1009d.put(lowerCase, Integer.valueOf(i3));
            String str3 = (String) this.f1007b.get(strArr[i3]);
            if (str3 != null) {
                D2.k.d(locale, "US");
                str = str3.toLowerCase(locale);
                D2.k.d(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i3] = lowerCase;
        }
        this.f1010e = strArr2;
        for (Map.Entry entry : this.f1007b.entrySet()) {
            String str4 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            D2.k.d(locale2, "US");
            String lowerCase2 = str4.toLowerCase(locale2);
            D2.k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.f1009d.containsKey(lowerCase2)) {
                String str5 = (String) entry.getKey();
                D2.k.d(locale2, "US");
                String lowerCase3 = str5.toLowerCase(locale2);
                D2.k.d(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map map3 = this.f1009d;
                map3.put(lowerCase3, AbstractC0521D.h(map3, lowerCase2));
            }
        }
        this.f1021p = new e();
    }

    private final String[] n(String[] strArr) {
        Set b3 = AbstractC0527J.b();
        for (String str : strArr) {
            Map map = this.f1008c;
            Locale locale = Locale.US;
            D2.k.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            D2.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map map2 = this.f1008c;
                D2.k.d(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                D2.k.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Object obj = map2.get(lowerCase2);
                D2.k.b(obj);
                b3.addAll((Collection) obj);
            } else {
                b3.add(str);
            }
        }
        Object[] array = AbstractC0527J.a(b3).toArray(new String[0]);
        D2.k.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    private final void q(N.g gVar, int i3) {
        gVar.w("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i3 + ", 0)");
        String str = this.f1010e[i3];
        for (String str2 : f1005r) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + f1004q.b(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = " + i3 + " AND invalidated = 0; END";
            D2.k.d(str3, "StringBuilder().apply(builderAction).toString()");
            gVar.w(str3);
        }
    }

    private final void r(N.g gVar, int i3) {
        String str = this.f1010e[i3];
        for (String str2 : f1005r) {
            String str3 = "DROP TRIGGER IF EXISTS " + f1004q.b(str, str2);
            D2.k.d(str3, "StringBuilder().apply(builderAction).toString()");
            gVar.w(str3);
        }
    }

    public void b(c cVar) {
        d dVar;
        D2.k.e(cVar, "observer");
        String[] n3 = n(cVar.a());
        ArrayList arrayList = new ArrayList(n3.length);
        for (String str : n3) {
            Map map = this.f1009d;
            Locale locale = Locale.US;
            D2.k.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            D2.k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = (Integer) map.get(lowerCase);
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
            arrayList.add(num);
        }
        int[] B3 = AbstractC0544n.B(arrayList);
        d dVar2 = new d(cVar, B3, n3);
        synchronized (this.f1017l) {
            dVar = (d) this.f1017l.g(cVar, dVar2);
        }
        if (dVar == null && this.f1015j.b(Arrays.copyOf(B3, B3.length))) {
            s();
        }
    }

    public final boolean c() {
        if (!this.f1006a.w()) {
            return false;
        }
        if (!this.f1013h) {
            this.f1006a.m().P();
        }
        if (this.f1013h) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final N.k d() {
        return this.f1014i;
    }

    public final u e() {
        return this.f1006a;
    }

    public final k.b f() {
        return this.f1017l;
    }

    public final AtomicBoolean g() {
        return this.f1012g;
    }

    public final Map h() {
        return this.f1009d;
    }

    public final void i(N.g gVar) {
        D2.k.e(gVar, "database");
        synchronized (this.f1020o) {
            if (this.f1013h) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            gVar.w("PRAGMA temp_store = MEMORY;");
            gVar.w("PRAGMA recursive_triggers='ON';");
            gVar.w("CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            t(gVar);
            this.f1014i = gVar.C("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1");
            this.f1013h = true;
            p2.q qVar = p2.q.f12810a;
        }
    }

    public final void j(String... strArr) {
        D2.k.e(strArr, "tables");
        synchronized (this.f1017l) {
            try {
                for (Map.Entry entry : this.f1017l) {
                    D2.k.d(entry, "(observer, wrapper)");
                    c cVar = (c) entry.getKey();
                    d dVar = (d) entry.getValue();
                    if (!cVar.b()) {
                        dVar.c(strArr);
                    }
                }
                p2.q qVar = p2.q.f12810a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        synchronized (this.f1020o) {
            this.f1013h = false;
            this.f1015j.d();
            p2.q qVar = p2.q.f12810a;
        }
    }

    public void l() {
        if (this.f1012g.compareAndSet(false, true)) {
            C0165c c0165c = this.f1011f;
            if (c0165c != null) {
                c0165c.j();
            }
            this.f1006a.n().execute(this.f1021p);
        }
    }

    public void m(c cVar) {
        d dVar;
        D2.k.e(cVar, "observer");
        synchronized (this.f1017l) {
            dVar = (d) this.f1017l.h(cVar);
        }
        if (dVar != null) {
            b bVar = this.f1015j;
            int[] a3 = dVar.a();
            if (bVar.c(Arrays.copyOf(a3, a3.length))) {
                s();
            }
        }
    }

    public final void o(C0165c c0165c) {
        D2.k.e(c0165c, "autoCloser");
        this.f1011f = c0165c;
        c0165c.m(new Runnable() { // from class: J.n
            @Override // java.lang.Runnable
            public final void run() {
                o.this.k();
            }
        });
    }

    public final void p(Context context, String str, Intent intent) {
        D2.k.e(context, "context");
        D2.k.e(str, "name");
        D2.k.e(intent, "serviceIntent");
        this.f1018m = new r(context, str, intent, this, this.f1006a.n());
    }

    public final void s() {
        if (this.f1006a.w()) {
            t(this.f1006a.m().P());
        }
    }

    public final void t(N.g gVar) {
        D2.k.e(gVar, "database");
        if (gVar.W()) {
            return;
        }
        try {
            Lock k3 = this.f1006a.k();
            k3.lock();
            try {
                synchronized (this.f1019n) {
                    int[] a3 = this.f1015j.a();
                    if (a3 == null) {
                        return;
                    }
                    f1004q.a(gVar);
                    try {
                        int length = a3.length;
                        int i3 = 0;
                        int i4 = 0;
                        while (i3 < length) {
                            int i5 = a3[i3];
                            int i6 = i4 + 1;
                            if (i5 == 1) {
                                q(gVar, i4);
                            } else if (i5 == 2) {
                                r(gVar, i4);
                            }
                            i3++;
                            i4 = i6;
                        }
                        gVar.z();
                        gVar.e();
                        p2.q qVar = p2.q.f12810a;
                    } catch (Throwable th) {
                        gVar.e();
                        throw th;
                    }
                }
            } finally {
                k3.unlock();
            }
        } catch (SQLiteException e3) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
        } catch (IllegalStateException e4) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e4);
        }
    }
}
