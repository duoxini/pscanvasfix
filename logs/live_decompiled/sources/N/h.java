package N;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public interface h extends Closeable {

    public static abstract class a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0028a f1607b = new C0028a(null);

        /* renamed from: a, reason: collision with root package name */
        public final int f1608a;

        /* renamed from: N.h$a$a, reason: collision with other inner class name */
        public static final class C0028a {
            public /* synthetic */ C0028a(D2.g gVar) {
                this();
            }

            private C0028a() {
            }
        }

        public a(int i3) {
            this.f1608a = i3;
        }

        private final void a(String str) {
            if (K2.e.l(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i3 = 0;
            boolean z3 = false;
            while (i3 <= length) {
                boolean z4 = D2.k.f(str.charAt(!z3 ? i3 : length), 32) <= 0;
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
            if (str.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                N.b.a(new File(str));
            } catch (Exception e3) {
                Log.w("SupportSQLite", "delete failed: ", e3);
            }
        }

        public void b(g gVar) {
            D2.k.e(gVar, "db");
        }

        public void c(g gVar) {
            D2.k.e(gVar, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + gVar + ".path");
            if (!gVar.isOpen()) {
                String d3 = gVar.d();
                if (d3 != null) {
                    a(d3);
                    return;
                }
                return;
            }
            List list = null;
            try {
                try {
                    list = gVar.n();
                } catch (SQLiteException unused) {
                }
                try {
                    gVar.close();
                } catch (IOException unused2) {
                }
                if (list != null) {
                    return;
                }
            } finally {
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Object obj = ((Pair) it.next()).second;
                        D2.k.d(obj, "p.second");
                        a((String) obj);
                    }
                } else {
                    String d4 = gVar.d();
                    if (d4 != null) {
                        a(d4);
                    }
                }
            }
        }

        public abstract void d(g gVar);

        public abstract void e(g gVar, int i3, int i4);

        public void f(g gVar) {
            D2.k.e(gVar, "db");
        }

        public abstract void g(g gVar, int i3, int i4);
    }

    public static final class b {

        /* renamed from: f, reason: collision with root package name */
        public static final C0029b f1609f = new C0029b(null);

        /* renamed from: a, reason: collision with root package name */
        public final Context f1610a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1611b;

        /* renamed from: c, reason: collision with root package name */
        public final a f1612c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f1613d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f1614e;

        public static class a {

            /* renamed from: a, reason: collision with root package name */
            private final Context f1615a;

            /* renamed from: b, reason: collision with root package name */
            private String f1616b;

            /* renamed from: c, reason: collision with root package name */
            private a f1617c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f1618d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f1619e;

            public a(Context context) {
                D2.k.e(context, "context");
                this.f1615a = context;
            }

            public b a() {
                String str;
                a aVar = this.f1617c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f1618d && ((str = this.f1616b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new b(this.f1615a, this.f1616b, aVar, this.f1618d, this.f1619e);
            }

            public a b(a aVar) {
                D2.k.e(aVar, "callback");
                this.f1617c = aVar;
                return this;
            }

            public a c(String str) {
                this.f1616b = str;
                return this;
            }
        }

        /* renamed from: N.h$b$b, reason: collision with other inner class name */
        public static final class C0029b {
            public /* synthetic */ C0029b(D2.g gVar) {
                this();
            }

            public final a a(Context context) {
                D2.k.e(context, "context");
                return new a(context);
            }

            private C0029b() {
            }
        }

        public b(Context context, String str, a aVar, boolean z3, boolean z4) {
            D2.k.e(context, "context");
            D2.k.e(aVar, "callback");
            this.f1610a = context;
            this.f1611b = str;
            this.f1612c = aVar;
            this.f1613d = z3;
            this.f1614e = z4;
        }

        public static final a a(Context context) {
            return f1609f.a(context);
        }
    }

    public interface c {
        h a(b bVar);
    }

    g P();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z3);
}
