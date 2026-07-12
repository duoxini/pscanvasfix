package O;

import D2.k;
import D2.l;
import N.h;
import O.d;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.File;
import java.util.UUID;
import p2.AbstractC0506f;
import p2.InterfaceC0505e;

/* loaded from: classes.dex */
public final class d implements N.h {

    /* renamed from: l, reason: collision with root package name */
    public static final a f1690l = new a(null);

    /* renamed from: e, reason: collision with root package name */
    private final Context f1691e;

    /* renamed from: f, reason: collision with root package name */
    private final String f1692f;

    /* renamed from: g, reason: collision with root package name */
    private final h.a f1693g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f1694h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f1695i;

    /* renamed from: j, reason: collision with root package name */
    private final InterfaceC0505e f1696j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1697k;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private O.c f1698a;

        public b(O.c cVar) {
            this.f1698a = cVar;
        }

        public final O.c a() {
            return this.f1698a;
        }

        public final void b(O.c cVar) {
            this.f1698a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends SQLiteOpenHelper {

        /* renamed from: l, reason: collision with root package name */
        public static final C0031c f1699l = new C0031c(null);

        /* renamed from: e, reason: collision with root package name */
        private final Context f1700e;

        /* renamed from: f, reason: collision with root package name */
        private final b f1701f;

        /* renamed from: g, reason: collision with root package name */
        private final h.a f1702g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f1703h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f1704i;

        /* renamed from: j, reason: collision with root package name */
        private final P.a f1705j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f1706k;

        private static final class a extends RuntimeException {

            /* renamed from: e, reason: collision with root package name */
            private final b f1707e;

            /* renamed from: f, reason: collision with root package name */
            private final Throwable f1708f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Throwable th) {
                super(th);
                k.e(bVar, "callbackName");
                k.e(th, "cause");
                this.f1707e = bVar;
                this.f1708f = th;
            }

            public final b a() {
                return this.f1707e;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.f1708f;
            }
        }

        public enum b {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* renamed from: O.d$c$c, reason: collision with other inner class name */
        public static final class C0031c {
            public /* synthetic */ C0031c(D2.g gVar) {
                this();
            }

            public final O.c a(b bVar, SQLiteDatabase sQLiteDatabase) {
                k.e(bVar, "refHolder");
                k.e(sQLiteDatabase, "sqLiteDatabase");
                O.c a3 = bVar.a();
                if (a3 != null && a3.c(sQLiteDatabase)) {
                    return a3;
                }
                O.c cVar = new O.c(sQLiteDatabase);
                bVar.b(cVar);
                return cVar;
            }

            private C0031c() {
            }
        }

        /* renamed from: O.d$c$d, reason: collision with other inner class name */
        public /* synthetic */ class C0032d {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f1715a;

            static {
                int[] iArr = new int[b.values().length];
                try {
                    iArr[b.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[b.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[b.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[b.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[b.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f1715a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, String str, final b bVar, final h.a aVar, boolean z3) {
            super(context, str, null, aVar.f1608a, new DatabaseErrorHandler() { // from class: O.e
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    d.c.b(h.a.this, bVar, sQLiteDatabase);
                }
            });
            k.e(context, "context");
            k.e(bVar, "dbRef");
            k.e(aVar, "callback");
            this.f1700e = context;
            this.f1701f = bVar;
            this.f1702g = aVar;
            this.f1703h = z3;
            if (str == null) {
                str = UUID.randomUUID().toString();
                k.d(str, "randomUUID().toString()");
            }
            File cacheDir = context.getCacheDir();
            k.d(cacheDir, "context.cacheDir");
            this.f1705j = new P.a(str, cacheDir, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(h.a aVar, b bVar, SQLiteDatabase sQLiteDatabase) {
            k.e(aVar, "$callback");
            k.e(bVar, "$dbRef");
            C0031c c0031c = f1699l;
            k.d(sQLiteDatabase, "dbObj");
            aVar.c(c0031c.a(bVar, sQLiteDatabase));
        }

        private final SQLiteDatabase i(boolean z3) {
            if (z3) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                k.d(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            k.d(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        private final SQLiteDatabase j(boolean z3) {
            File parentFile;
            String databaseName = getDatabaseName();
            if (databaseName != null && (parentFile = this.f1700e.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return i(z3);
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return this.i(z3);
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof a) {
                        a aVar = th;
                        Throwable cause = aVar.getCause();
                        int i3 = C0032d.f1715a[aVar.a().ordinal()];
                        if (i3 == 1) {
                            throw cause;
                        }
                        if (i3 == 2) {
                            throw cause;
                        }
                        if (i3 == 3) {
                            throw cause;
                        }
                        if (i3 == 4) {
                            throw cause;
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                    } else {
                        if (!(th instanceof SQLiteException)) {
                            throw th;
                        }
                        if (databaseName == null || !this.f1703h) {
                            throw th;
                        }
                    }
                    this.f1700e.deleteDatabase(databaseName);
                    try {
                        return this.i(z3);
                    } catch (a e3) {
                        throw e3.getCause();
                    }
                }
            }
        }

        public final N.g c(boolean z3) {
            try {
                this.f1705j.b((this.f1706k || getDatabaseName() == null) ? false : true);
                this.f1704i = false;
                SQLiteDatabase j3 = j(z3);
                if (!this.f1704i) {
                    O.c g3 = g(j3);
                    this.f1705j.d();
                    return g3;
                }
                close();
                N.g c3 = c(z3);
                this.f1705j.d();
                return c3;
            } catch (Throwable th) {
                this.f1705j.d();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                P.a.c(this.f1705j, false, 1, null);
                super.close();
                this.f1701f.b(null);
                this.f1706k = false;
            } finally {
                this.f1705j.d();
            }
        }

        public final O.c g(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "sqLiteDatabase");
            return f1699l.a(this.f1701f, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "db");
            try {
                this.f1702g.b(g(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.f1702g.d(g(sQLiteDatabase));
            } catch (Throwable th) {
                throw new a(b.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            k.e(sQLiteDatabase, "db");
            this.f1704i = true;
            try {
                this.f1702g.e(g(sQLiteDatabase), i3, i4);
            } catch (Throwable th) {
                throw new a(b.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            k.e(sQLiteDatabase, "db");
            if (!this.f1704i) {
                try {
                    this.f1702g.f(g(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new a(b.ON_OPEN, th);
                }
            }
            this.f1706k = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i3, int i4) {
            k.e(sQLiteDatabase, "sqLiteDatabase");
            this.f1704i = true;
            try {
                this.f1702g.g(g(sQLiteDatabase), i3, i4);
            } catch (Throwable th) {
                throw new a(b.ON_UPGRADE, th);
            }
        }
    }

    /* renamed from: O.d$d, reason: collision with other inner class name */
    static final class C0033d extends l implements C2.a {
        C0033d() {
            super(0);
        }

        @Override // C2.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c invoke() {
            c cVar;
            if (d.this.f1692f == null || !d.this.f1694h) {
                cVar = new c(d.this.f1691e, d.this.f1692f, new b(null), d.this.f1693g, d.this.f1695i);
            } else {
                cVar = new c(d.this.f1691e, new File(N.d.a(d.this.f1691e), d.this.f1692f).getAbsolutePath(), new b(null), d.this.f1693g, d.this.f1695i);
            }
            N.b.d(cVar, d.this.f1697k);
            return cVar;
        }
    }

    public d(Context context, String str, h.a aVar, boolean z3, boolean z4) {
        k.e(context, "context");
        k.e(aVar, "callback");
        this.f1691e = context;
        this.f1692f = str;
        this.f1693g = aVar;
        this.f1694h = z3;
        this.f1695i = z4;
        this.f1696j = AbstractC0506f.a(new C0033d());
    }

    private final c l() {
        return (c) this.f1696j.getValue();
    }

    @Override // N.h
    public N.g P() {
        return l().c(true);
    }

    @Override // N.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f1696j.a()) {
            l().close();
        }
    }

    @Override // N.h
    public String getDatabaseName() {
        return this.f1692f;
    }

    @Override // N.h
    public void setWriteAheadLoggingEnabled(boolean z3) {
        if (this.f1696j.a()) {
            N.b.d(l(), z3);
        }
        this.f1697k = z3;
    }
}
