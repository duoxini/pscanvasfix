package J;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q2.AbstractC0544n;

/* loaded from: classes.dex */
public final class d implements N.h, g {

    /* renamed from: e, reason: collision with root package name */
    private final N.h f956e;

    /* renamed from: f, reason: collision with root package name */
    public final C0165c f957f;

    /* renamed from: g, reason: collision with root package name */
    private final a f958g;

    public static final class a implements N.g {

        /* renamed from: e, reason: collision with root package name */
        private final C0165c f959e;

        /* renamed from: J.d$a$a, reason: collision with other inner class name */
        static final class C0016a extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final C0016a f960e = new C0016a();

            C0016a() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final List f(N.g gVar) {
                D2.k.e(gVar, "obj");
                return gVar.n();
            }
        }

        static final class b extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f961e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str) {
                super(1);
                this.f961e = str;
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object f(N.g gVar) {
                D2.k.e(gVar, "db");
                gVar.w(this.f961e);
                return null;
            }
        }

        /* synthetic */ class c extends D2.j implements C2.l {

            /* renamed from: n, reason: collision with root package name */
            public static final c f962n = new c();

            c() {
                super(1, N.g.class, "inTransaction", "inTransaction()Z", 0);
            }

            @Override // C2.l
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Boolean f(N.g gVar) {
                D2.k.e(gVar, "p0");
                return Boolean.valueOf(gVar.W());
            }
        }

        /* renamed from: J.d$a$d, reason: collision with other inner class name */
        static final class C0017d extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final C0017d f963e = new C0017d();

            C0017d() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean f(N.g gVar) {
                D2.k.e(gVar, "db");
                return Boolean.valueOf(gVar.s());
            }
        }

        static final class e extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final e f964e = new e();

            e() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String f(N.g gVar) {
                D2.k.e(gVar, "obj");
                return gVar.d();
            }
        }

        static final class f extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final f f965e = new f();

            f() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object f(N.g gVar) {
                D2.k.e(gVar, "it");
                return null;
            }
        }

        public a(C0165c c0165c) {
            D2.k.e(c0165c, "autoCloser");
            this.f959e = c0165c;
        }

        @Override // N.g
        public N.k C(String str) {
            D2.k.e(str, "sql");
            return new b(str, this.f959e);
        }

        @Override // N.g
        public void D() {
            try {
                this.f959e.j().D();
            } catch (Throwable th) {
                this.f959e.e();
                throw th;
            }
        }

        @Override // N.g
        public Cursor F(N.j jVar) {
            D2.k.e(jVar, "query");
            try {
                return new c(this.f959e.j().F(jVar), this.f959e);
            } catch (Throwable th) {
                this.f959e.e();
                throw th;
            }
        }

        @Override // N.g
        public Cursor U(String str) {
            D2.k.e(str, "query");
            try {
                return new c(this.f959e.j().U(str), this.f959e);
            } catch (Throwable th) {
                this.f959e.e();
                throw th;
            }
        }

        @Override // N.g
        public boolean W() {
            if (this.f959e.h() == null) {
                return false;
            }
            return ((Boolean) this.f959e.g(c.f962n)).booleanValue();
        }

        public final void a() {
            this.f959e.g(f.f965e);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f959e.d();
        }

        @Override // N.g
        public String d() {
            return (String) this.f959e.g(e.f964e);
        }

        @Override // N.g
        public void e() {
            if (this.f959e.h() == null) {
                throw new IllegalStateException("End transaction called but delegateDb is null");
            }
            try {
                N.g h3 = this.f959e.h();
                D2.k.b(h3);
                h3.e();
            } finally {
                this.f959e.e();
            }
        }

        @Override // N.g
        public void f() {
            try {
                this.f959e.j().f();
            } catch (Throwable th) {
                this.f959e.e();
                throw th;
            }
        }

        @Override // N.g
        public boolean isOpen() {
            N.g h3 = this.f959e.h();
            if (h3 == null) {
                return false;
            }
            return h3.isOpen();
        }

        @Override // N.g
        public Cursor m(N.j jVar, CancellationSignal cancellationSignal) {
            D2.k.e(jVar, "query");
            try {
                return new c(this.f959e.j().m(jVar, cancellationSignal), this.f959e);
            } catch (Throwable th) {
                this.f959e.e();
                throw th;
            }
        }

        @Override // N.g
        public List n() {
            return (List) this.f959e.g(C0016a.f960e);
        }

        @Override // N.g
        public boolean s() {
            return ((Boolean) this.f959e.g(C0017d.f963e)).booleanValue();
        }

        @Override // N.g
        public void w(String str) {
            D2.k.e(str, "sql");
            this.f959e.g(new b(str));
        }

        @Override // N.g
        public void z() {
            p2.q qVar;
            N.g h3 = this.f959e.h();
            if (h3 != null) {
                h3.z();
                qVar = p2.q.f12810a;
            } else {
                qVar = null;
            }
            if (qVar == null) {
                throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
            }
        }
    }

    private static final class b implements N.k {

        /* renamed from: e, reason: collision with root package name */
        private final String f966e;

        /* renamed from: f, reason: collision with root package name */
        private final C0165c f967f;

        /* renamed from: g, reason: collision with root package name */
        private final ArrayList f968g;

        static final class a extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final a f969e = new a();

            a() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Long f(N.k kVar) {
                D2.k.e(kVar, "obj");
                return Long.valueOf(kVar.S());
            }
        }

        /* renamed from: J.d$b$b, reason: collision with other inner class name */
        static final class C0018b extends D2.l implements C2.l {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ C2.l f971f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0018b(C2.l lVar) {
                super(1);
                this.f971f = lVar;
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object f(N.g gVar) {
                D2.k.e(gVar, "db");
                N.k C3 = gVar.C(b.this.f966e);
                b.this.c(C3);
                return this.f971f.f(C3);
            }
        }

        static final class c extends D2.l implements C2.l {

            /* renamed from: e, reason: collision with root package name */
            public static final c f972e = new c();

            c() {
                super(1);
            }

            @Override // C2.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Integer f(N.k kVar) {
                D2.k.e(kVar, "obj");
                return Integer.valueOf(kVar.B());
            }
        }

        public b(String str, C0165c c0165c) {
            D2.k.e(str, "sql");
            D2.k.e(c0165c, "autoCloser");
            this.f966e = str;
            this.f967f = c0165c;
            this.f968g = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(N.k kVar) {
            Iterator it = this.f968g.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                it.next();
                int i4 = i3 + 1;
                if (i3 < 0) {
                    AbstractC0544n.p();
                }
                Object obj = this.f968g.get(i3);
                if (obj == null) {
                    kVar.I(i4);
                } else if (obj instanceof Long) {
                    kVar.y(i4, ((Number) obj).longValue());
                } else if (obj instanceof Double) {
                    kVar.J(i4, ((Number) obj).doubleValue());
                } else if (obj instanceof String) {
                    kVar.x(i4, (String) obj);
                } else if (obj instanceof byte[]) {
                    kVar.H(i4, (byte[]) obj);
                }
                i3 = i4;
            }
        }

        private final Object g(C2.l lVar) {
            return this.f967f.g(new C0018b(lVar));
        }

        private final void i(int i3, Object obj) {
            int size;
            int i4 = i3 - 1;
            if (i4 >= this.f968g.size() && (size = this.f968g.size()) <= i4) {
                while (true) {
                    this.f968g.add(null);
                    if (size == i4) {
                        break;
                    } else {
                        size++;
                    }
                }
            }
            this.f968g.set(i4, obj);
        }

        @Override // N.k
        public int B() {
            return ((Number) g(c.f972e)).intValue();
        }

        @Override // N.i
        public void H(int i3, byte[] bArr) {
            D2.k.e(bArr, "value");
            i(i3, bArr);
        }

        @Override // N.i
        public void I(int i3) {
            i(i3, null);
        }

        @Override // N.i
        public void J(int i3, double d3) {
            i(i3, Double.valueOf(d3));
        }

        @Override // N.k
        public long S() {
            return ((Number) g(a.f969e)).longValue();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // N.i
        public void x(int i3, String str) {
            D2.k.e(str, "value");
            i(i3, str);
        }

        @Override // N.i
        public void y(int i3, long j3) {
            i(i3, Long.valueOf(j3));
        }
    }

    private static final class c implements Cursor {

        /* renamed from: e, reason: collision with root package name */
        private final Cursor f973e;

        /* renamed from: f, reason: collision with root package name */
        private final C0165c f974f;

        public c(Cursor cursor, C0165c c0165c) {
            D2.k.e(cursor, "delegate");
            D2.k.e(c0165c, "autoCloser");
            this.f973e = cursor;
            this.f974f = c0165c;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f973e.close();
            this.f974f.e();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
            this.f973e.copyStringToBuffer(i3, charArrayBuffer);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.f973e.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i3) {
            return this.f973e.getBlob(i3);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.f973e.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.f973e.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) {
            return this.f973e.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i3) {
            return this.f973e.getColumnName(i3);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.f973e.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.f973e.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i3) {
            return this.f973e.getDouble(i3);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.f973e.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i3) {
            return this.f973e.getFloat(i3);
        }

        @Override // android.database.Cursor
        public int getInt(int i3) {
            return this.f973e.getInt(i3);
        }

        @Override // android.database.Cursor
        public long getLong(int i3) {
            return this.f973e.getLong(i3);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return N.c.a(this.f973e);
        }

        @Override // android.database.Cursor
        public List getNotificationUris() {
            return N.f.a(this.f973e);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.f973e.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i3) {
            return this.f973e.getShort(i3);
        }

        @Override // android.database.Cursor
        public String getString(int i3) {
            return this.f973e.getString(i3);
        }

        @Override // android.database.Cursor
        public int getType(int i3) {
            return this.f973e.getType(i3);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.f973e.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.f973e.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.f973e.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.f973e.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.f973e.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.f973e.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i3) {
            return this.f973e.isNull(i3);
        }

        @Override // android.database.Cursor
        public boolean move(int i3) {
            return this.f973e.move(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.f973e.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.f973e.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.f973e.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i3) {
            return this.f973e.moveToPosition(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.f973e.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.f973e.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f973e.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.f973e.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.f973e.respond(bundle);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle bundle) {
            D2.k.e(bundle, "extras");
            N.e.a(this.f973e, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.f973e.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver contentResolver, List list) {
            D2.k.e(contentResolver, "cr");
            D2.k.e(list, "uris");
            N.f.b(this.f973e, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.f973e.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f973e.unregisterDataSetObserver(dataSetObserver);
        }
    }

    public d(N.h hVar, C0165c c0165c) {
        D2.k.e(hVar, "delegate");
        D2.k.e(c0165c, "autoCloser");
        this.f956e = hVar;
        this.f957f = c0165c;
        c0165c.k(a());
        this.f958g = new a(c0165c);
    }

    @Override // N.h
    public N.g P() {
        this.f958g.a();
        return this.f958g;
    }

    @Override // J.g
    public N.h a() {
        return this.f956e;
    }

    @Override // N.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f958g.close();
    }

    @Override // N.h
    public String getDatabaseName() {
        return this.f956e.getDatabaseName();
    }

    @Override // N.h
    public void setWriteAheadLoggingEnabled(boolean z3) {
        this.f956e.setWriteAheadLoggingEnabled(z3);
    }
}
