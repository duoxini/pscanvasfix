package O;

import C2.r;
import D2.k;
import D2.l;
import N.j;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.os.CancellationSignal;
import java.util.List;

/* loaded from: classes.dex */
public final class c implements N.g {

    /* renamed from: g, reason: collision with root package name */
    public static final a f1684g = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private static final String[] f1685h = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: i, reason: collision with root package name */
    private static final String[] f1686i = new String[0];

    /* renamed from: e, reason: collision with root package name */
    private final SQLiteDatabase f1687e;

    /* renamed from: f, reason: collision with root package name */
    private final List f1688f;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        private a() {
        }
    }

    static final class b extends l implements r {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ j f1689e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j jVar) {
            super(4);
            this.f1689e = jVar;
        }

        @Override // C2.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SQLiteCursor e(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            j jVar = this.f1689e;
            k.b(sQLiteQuery);
            jVar.b(new g(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public c(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "delegate");
        this.f1687e = sQLiteDatabase;
        this.f1688f = sQLiteDatabase.getAttachedDbs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor g(r rVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        k.e(rVar, "$tmp0");
        return (Cursor) rVar.e(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cursor i(j jVar, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        k.e(jVar, "$query");
        k.b(sQLiteQuery);
        jVar.b(new g(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    @Override // N.g
    public N.k C(String str) {
        k.e(str, "sql");
        SQLiteStatement compileStatement = this.f1687e.compileStatement(str);
        k.d(compileStatement, "delegate.compileStatement(sql)");
        return new h(compileStatement);
    }

    @Override // N.g
    public void D() {
        this.f1687e.beginTransactionNonExclusive();
    }

    @Override // N.g
    public Cursor F(j jVar) {
        k.e(jVar, "query");
        final b bVar = new b(jVar);
        Cursor rawQueryWithFactory = this.f1687e.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: O.b
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Cursor g3;
                g3 = c.g(r.this, sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
                return g3;
            }
        }, jVar.a(), f1686i, null);
        k.d(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    @Override // N.g
    public Cursor U(String str) {
        k.e(str, "query");
        return F(new N.a(str));
    }

    @Override // N.g
    public boolean W() {
        return this.f1687e.inTransaction();
    }

    public final boolean c(SQLiteDatabase sQLiteDatabase) {
        k.e(sQLiteDatabase, "sqLiteDatabase");
        return k.a(this.f1687e, sQLiteDatabase);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1687e.close();
    }

    @Override // N.g
    public String d() {
        return this.f1687e.getPath();
    }

    @Override // N.g
    public void e() {
        this.f1687e.endTransaction();
    }

    @Override // N.g
    public void f() {
        this.f1687e.beginTransaction();
    }

    @Override // N.g
    public boolean isOpen() {
        return this.f1687e.isOpen();
    }

    @Override // N.g
    public Cursor m(final j jVar, CancellationSignal cancellationSignal) {
        k.e(jVar, "query");
        SQLiteDatabase sQLiteDatabase = this.f1687e;
        String a3 = jVar.a();
        String[] strArr = f1686i;
        k.b(cancellationSignal);
        return N.b.c(sQLiteDatabase, a3, strArr, null, cancellationSignal, new SQLiteDatabase.CursorFactory() { // from class: O.a
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public final Cursor newCursor(SQLiteDatabase sQLiteDatabase2, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                Cursor i3;
                i3 = c.i(j.this, sQLiteDatabase2, sQLiteCursorDriver, str, sQLiteQuery);
                return i3;
            }
        });
    }

    @Override // N.g
    public List n() {
        return this.f1688f;
    }

    @Override // N.g
    public boolean s() {
        return N.b.b(this.f1687e);
    }

    @Override // N.g
    public void w(String str) {
        k.e(str, "sql");
        this.f1687e.execSQL(str);
    }

    @Override // N.g
    public void z() {
        this.f1687e.setTransactionSuccessful();
    }
}
