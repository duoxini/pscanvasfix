package J;

import N.h;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import j.C0399a;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import q2.AbstractC0521D;
import q2.AbstractC0527J;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: o, reason: collision with root package name */
    public static final b f1053o = new b(null);

    /* renamed from: a, reason: collision with root package name */
    protected volatile N.g f1054a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f1055b;

    /* renamed from: c, reason: collision with root package name */
    private Executor f1056c;

    /* renamed from: d, reason: collision with root package name */
    private N.h f1057d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1059f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f1060g;

    /* renamed from: h, reason: collision with root package name */
    protected List f1061h;

    /* renamed from: k, reason: collision with root package name */
    private C0165c f1064k;

    /* renamed from: m, reason: collision with root package name */
    private final Map f1066m;

    /* renamed from: n, reason: collision with root package name */
    private final Map f1067n;

    /* renamed from: e, reason: collision with root package name */
    private final o f1058e = g();

    /* renamed from: i, reason: collision with root package name */
    private Map f1062i = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    private final ReentrantReadWriteLock f1063j = new ReentrantReadWriteLock();

    /* renamed from: l, reason: collision with root package name */
    private final ThreadLocal f1065l = new ThreadLocal();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1068a;

        /* renamed from: b, reason: collision with root package name */
        private final Class f1069b;

        /* renamed from: c, reason: collision with root package name */
        private final String f1070c;

        /* renamed from: d, reason: collision with root package name */
        private final List f1071d;

        /* renamed from: e, reason: collision with root package name */
        private final List f1072e;

        /* renamed from: f, reason: collision with root package name */
        private List f1073f;

        /* renamed from: g, reason: collision with root package name */
        private Executor f1074g;

        /* renamed from: h, reason: collision with root package name */
        private Executor f1075h;

        /* renamed from: i, reason: collision with root package name */
        private h.c f1076i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1077j;

        /* renamed from: k, reason: collision with root package name */
        private c f1078k;

        /* renamed from: l, reason: collision with root package name */
        private Intent f1079l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f1080m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f1081n;

        /* renamed from: o, reason: collision with root package name */
        private long f1082o;

        /* renamed from: p, reason: collision with root package name */
        private TimeUnit f1083p;

        /* renamed from: q, reason: collision with root package name */
        private final d f1084q;

        /* renamed from: r, reason: collision with root package name */
        private Set f1085r;

        /* renamed from: s, reason: collision with root package name */
        private Set f1086s;

        /* renamed from: t, reason: collision with root package name */
        private String f1087t;

        /* renamed from: u, reason: collision with root package name */
        private File f1088u;

        /* renamed from: v, reason: collision with root package name */
        private Callable f1089v;

        public a(Context context, Class cls, String str) {
            D2.k.e(context, "context");
            D2.k.e(cls, "klass");
            this.f1068a = context;
            this.f1069b = cls;
            this.f1070c = str;
            this.f1071d = new ArrayList();
            this.f1072e = new ArrayList();
            this.f1073f = new ArrayList();
            this.f1078k = c.AUTOMATIC;
            this.f1080m = true;
            this.f1082o = -1L;
            this.f1084q = new d();
            this.f1085r = new LinkedHashSet();
        }

        public a a(K.a... aVarArr) {
            D2.k.e(aVarArr, "migrations");
            if (this.f1086s == null) {
                this.f1086s = new HashSet();
            }
            for (K.a aVar : aVarArr) {
                Set set = this.f1086s;
                D2.k.b(set);
                set.add(Integer.valueOf(aVar.f1160a));
                Set set2 = this.f1086s;
                D2.k.b(set2);
                set2.add(Integer.valueOf(aVar.f1161b));
            }
            this.f1084q.b((K.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
            return this;
        }

        public a b() {
            this.f1077j = true;
            return this;
        }

        public u c() {
            Executor executor = this.f1074g;
            if (executor == null && this.f1075h == null) {
                Executor d3 = C0399a.d();
                this.f1075h = d3;
                this.f1074g = d3;
            } else if (executor != null && this.f1075h == null) {
                this.f1075h = executor;
            } else if (executor == null) {
                this.f1074g = this.f1075h;
            }
            Set set = this.f1086s;
            if (set != null) {
                D2.k.b(set);
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    if (this.f1085r.contains(Integer.valueOf(intValue))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + intValue).toString());
                    }
                }
            }
            h.c cVar = this.f1076i;
            if (cVar == null) {
                cVar = new O.f();
            }
            if (cVar != null) {
                if (this.f1082o > 0) {
                    if (this.f1070c == null) {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                    long j3 = this.f1082o;
                    TimeUnit timeUnit = this.f1083p;
                    if (timeUnit == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    Executor executor2 = this.f1074g;
                    if (executor2 == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    cVar = new J.e(cVar, new C0165c(j3, timeUnit, executor2));
                }
                String str = this.f1087t;
                if (str != null || this.f1088u != null || this.f1089v != null) {
                    if (this.f1070c == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                    int i3 = str == null ? 0 : 1;
                    File file = this.f1088u;
                    int i4 = file == null ? 0 : 1;
                    Callable callable = this.f1089v;
                    if (i3 + i4 + (callable != null ? 1 : 0) != 1) {
                        throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                    }
                    cVar = new z(str, file, callable, cVar);
                }
            } else {
                cVar = null;
            }
            h.c cVar2 = cVar;
            if (cVar2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Context context = this.f1068a;
            String str2 = this.f1070c;
            d dVar = this.f1084q;
            List list = this.f1071d;
            boolean z3 = this.f1077j;
            c c3 = this.f1078k.c(context);
            Executor executor3 = this.f1074g;
            if (executor3 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            Executor executor4 = this.f1075h;
            if (executor4 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            J.f fVar = new J.f(context, str2, cVar2, dVar, list, z3, c3, executor3, executor4, this.f1079l, this.f1080m, this.f1081n, this.f1085r, this.f1087t, this.f1088u, this.f1089v, null, this.f1072e, this.f1073f);
            u uVar = (u) t.b(this.f1069b, "_Impl");
            uVar.r(fVar);
            return uVar;
        }

        public a d() {
            this.f1080m = false;
            this.f1081n = true;
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(D2.g gVar) {
            this();
        }

        private b() {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean b(ActivityManager activityManager) {
            return N.c.b(activityManager);
        }

        public final c c(Context context) {
            D2.k.e(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            D2.k.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            return !b((ActivityManager) systemService) ? WRITE_AHEAD_LOGGING : TRUNCATE;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final Map f1094a = new LinkedHashMap();

        private final void a(K.a aVar) {
            int i3 = aVar.f1160a;
            int i4 = aVar.f1161b;
            Map map = this.f1094a;
            Integer valueOf = Integer.valueOf(i3);
            Object obj = map.get(valueOf);
            if (obj == null) {
                obj = new TreeMap();
                map.put(valueOf, obj);
            }
            TreeMap treeMap = (TreeMap) obj;
            if (treeMap.containsKey(Integer.valueOf(i4))) {
                Log.w("ROOM", "Overriding migration " + treeMap.get(Integer.valueOf(i4)) + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i4), aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final java.util.List e(java.util.List r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L63
                goto L7
            L5:
                if (r9 <= r10) goto L63
            L7:
                java.util.Map r0 = r6.f1094a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L5f
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                java.lang.String r4 = "targetVersion"
                if (r8 == 0) goto L44
                int r5 = r9 + 1
                D2.k.d(r3, r4)
                int r4 = r3.intValue()
                if (r5 > r4) goto L26
                if (r4 > r10) goto L26
                goto L4f
            L44:
                D2.k.d(r3, r4)
                int r4 = r3.intValue()
                if (r10 > r4) goto L26
                if (r4 >= r9) goto L26
            L4f:
                java.lang.Object r9 = r0.get(r3)
                D2.k.b(r9)
                r7.add(r9)
                int r9 = r3.intValue()
                r0 = 1
                goto L60
            L5f:
                r0 = 0
            L60:
                if (r0 != 0) goto L0
                return r1
            L63:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: J.u.d.e(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(K.a... aVarArr) {
            D2.k.e(aVarArr, "migrations");
            for (K.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public final boolean c(int i3, int i4) {
            Map f3 = f();
            if (!f3.containsKey(Integer.valueOf(i3))) {
                return false;
            }
            Map map = (Map) f3.get(Integer.valueOf(i3));
            if (map == null) {
                map = AbstractC0521D.g();
            }
            return map.containsKey(Integer.valueOf(i4));
        }

        public List d(int i3, int i4) {
            if (i3 == i4) {
                return AbstractC0544n.j();
            }
            return e(new ArrayList(), i4 > i3, i3, i4);
        }

        public Map f() {
            return this.f1094a;
        }
    }

    public static abstract class e {
    }

    static final class f extends D2.l implements C2.l {
        f() {
            super(1);
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object f(N.g gVar) {
            D2.k.e(gVar, "it");
            u.this.s();
            return null;
        }
    }

    static final class g extends D2.l implements C2.l {
        g() {
            super(1);
        }

        @Override // C2.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object f(N.g gVar) {
            D2.k.e(gVar, "it");
            u.this.t();
            return null;
        }
    }

    public u() {
        Map synchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        D2.k.d(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.f1066m = synchronizedMap;
        this.f1067n = new LinkedHashMap();
    }

    private final Object A(Class cls, N.h hVar) {
        if (cls.isInstance(hVar)) {
            return hVar;
        }
        if (hVar instanceof J.g) {
            return A(cls, ((J.g) hVar).a());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        c();
        N.g P3 = m().P();
        l().t(P3);
        if (P3.s()) {
            P3.D();
        } else {
            P3.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        m().P().e();
        if (q()) {
            return;
        }
        l().l();
    }

    public static /* synthetic */ Cursor y(u uVar, N.j jVar, CancellationSignal cancellationSignal, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
        }
        if ((i3 & 2) != 0) {
            cancellationSignal = null;
        }
        return uVar.x(jVar, cancellationSignal);
    }

    public void c() {
        if (!this.f1059f && v()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void d() {
        if (!q() && this.f1065l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void e() {
        c();
        C0165c c0165c = this.f1064k;
        if (c0165c == null) {
            s();
        } else {
            c0165c.g(new f());
        }
    }

    public N.k f(String str) {
        D2.k.e(str, "sql");
        c();
        d();
        return m().P().C(str);
    }

    protected abstract o g();

    protected abstract N.h h(J.f fVar);

    public void i() {
        C0165c c0165c = this.f1064k;
        if (c0165c == null) {
            t();
        } else {
            c0165c.g(new g());
        }
    }

    public List j(Map map) {
        D2.k.e(map, "autoMigrationSpecs");
        return AbstractC0544n.j();
    }

    public final Lock k() {
        ReentrantReadWriteLock.ReadLock readLock = this.f1063j.readLock();
        D2.k.d(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    public o l() {
        return this.f1058e;
    }

    public N.h m() {
        N.h hVar = this.f1057d;
        if (hVar != null) {
            return hVar;
        }
        D2.k.n("internalOpenHelper");
        return null;
    }

    public Executor n() {
        Executor executor = this.f1055b;
        if (executor != null) {
            return executor;
        }
        D2.k.n("internalQueryExecutor");
        return null;
    }

    public Set o() {
        return AbstractC0527J.d();
    }

    protected Map p() {
        return AbstractC0521D.g();
    }

    public boolean q() {
        return m().P().W();
    }

    public void r(J.f fVar) {
        D2.k.e(fVar, "configuration");
        this.f1057d = h(fVar);
        Set o3 = o();
        BitSet bitSet = new BitSet();
        Iterator it = o3.iterator();
        while (true) {
            int i3 = -1;
            if (it.hasNext()) {
                Class cls = (Class) it.next();
                int size = fVar.f994r.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i4 = size - 1;
                        if (cls.isAssignableFrom(fVar.f994r.get(size).getClass())) {
                            bitSet.set(size);
                            i3 = size;
                            break;
                        } else if (i4 < 0) {
                            break;
                        } else {
                            size = i4;
                        }
                    }
                }
                if (i3 < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + cls.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                this.f1062i.put(cls, fVar.f994r.get(i3));
            } else {
                int size2 = fVar.f994r.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i5 = size2 - 1;
                        if (!bitSet.get(size2)) {
                            throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                        }
                        if (i5 < 0) {
                            break;
                        } else {
                            size2 = i5;
                        }
                    }
                }
                for (K.a aVar : j(this.f1062i)) {
                    if (!fVar.f980d.c(aVar.f1160a, aVar.f1161b)) {
                        fVar.f980d.b(aVar);
                    }
                }
                y yVar = (y) A(y.class, m());
                if (yVar != null) {
                    yVar.g(fVar);
                }
                J.d dVar = (J.d) A(J.d.class, m());
                if (dVar != null) {
                    this.f1064k = dVar.f957f;
                    l().o(dVar.f957f);
                }
                boolean z3 = fVar.f983g == c.WRITE_AHEAD_LOGGING;
                m().setWriteAheadLoggingEnabled(z3);
                this.f1061h = fVar.f981e;
                this.f1055b = fVar.f984h;
                this.f1056c = new C(fVar.f985i);
                this.f1059f = fVar.f982f;
                this.f1060g = z3;
                if (fVar.f986j != null) {
                    if (fVar.f978b == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                    l().p(fVar.f977a, fVar.f978b, fVar.f986j);
                }
                Map p3 = p();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry entry : p3.entrySet()) {
                    Class cls2 = (Class) entry.getKey();
                    for (Class cls3 : (List) entry.getValue()) {
                        int size3 = fVar.f993q.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i6 = size3 - 1;
                                if (cls3.isAssignableFrom(fVar.f993q.get(size3).getClass())) {
                                    bitSet2.set(size3);
                                    break;
                                } else if (i6 < 0) {
                                    break;
                                } else {
                                    size3 = i6;
                                }
                            }
                        }
                        size3 = -1;
                        if (size3 < 0) {
                            throw new IllegalArgumentException(("A required type converter (" + cls3 + ") for " + cls2.getCanonicalName() + " is missing in the database configuration.").toString());
                        }
                        this.f1067n.put(cls3, fVar.f993q.get(size3));
                    }
                }
                int size4 = fVar.f993q.size() - 1;
                if (size4 < 0) {
                    return;
                }
                while (true) {
                    int i7 = size4 - 1;
                    if (!bitSet2.get(size4)) {
                        throw new IllegalArgumentException("Unexpected type converter " + fVar.f993q.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                    if (i7 < 0) {
                        return;
                    } else {
                        size4 = i7;
                    }
                }
            }
        }
    }

    protected void u(N.g gVar) {
        D2.k.e(gVar, "db");
        l().i(gVar);
    }

    public final boolean v() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public boolean w() {
        Boolean bool;
        boolean isOpen;
        C0165c c0165c = this.f1064k;
        if (c0165c != null) {
            isOpen = c0165c.l();
        } else {
            N.g gVar = this.f1054a;
            if (gVar == null) {
                bool = null;
                return D2.k.a(bool, Boolean.TRUE);
            }
            isOpen = gVar.isOpen();
        }
        bool = Boolean.valueOf(isOpen);
        return D2.k.a(bool, Boolean.TRUE);
    }

    public Cursor x(N.j jVar, CancellationSignal cancellationSignal) {
        D2.k.e(jVar, "query");
        c();
        d();
        return cancellationSignal != null ? m().P().m(jVar, cancellationSignal) : m().P().F(jVar);
    }

    public void z() {
        m().P().z();
    }
}
