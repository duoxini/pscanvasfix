package J;

import N.h;
import android.database.Cursor;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class w extends h.a {

    /* renamed from: g, reason: collision with root package name */
    public static final a f1098g = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private f f1099c;

    /* renamed from: d, reason: collision with root package name */
    private final b f1100d;

    /* renamed from: e, reason: collision with root package name */
    private final String f1101e;

    /* renamed from: f, reason: collision with root package name */
    private final String f1102f;

    public static final class a {
        public /* synthetic */ a(D2.g gVar) {
            this();
        }

        public final boolean a(N.g gVar) {
            D2.k.e(gVar, "db");
            Cursor U3 = gVar.U("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z3 = false;
                if (U3.moveToFirst()) {
                    if (U3.getInt(0) == 0) {
                        z3 = true;
                    }
                }
                A2.a.a(U3, null);
                return z3;
            } finally {
            }
        }

        public final boolean b(N.g gVar) {
            D2.k.e(gVar, "db");
            Cursor U3 = gVar.U("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z3 = false;
                if (U3.moveToFirst()) {
                    if (U3.getInt(0) != 0) {
                        z3 = true;
                    }
                }
                A2.a.a(U3, null);
                return z3;
            } finally {
            }
        }

        private a() {
        }
    }

    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f1103a;

        public b(int i3) {
            this.f1103a = i3;
        }

        public abstract void a(N.g gVar);

        public abstract void b(N.g gVar);

        public abstract void c(N.g gVar);

        public abstract void d(N.g gVar);

        public abstract void e(N.g gVar);

        public abstract void f(N.g gVar);

        public abstract c g(N.g gVar);
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1104a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1105b;

        public c(boolean z3, String str) {
            this.f1104a = z3;
            this.f1105b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(f fVar, b bVar, String str, String str2) {
        super(bVar.f1103a);
        D2.k.e(fVar, "configuration");
        D2.k.e(bVar, "delegate");
        D2.k.e(str, "identityHash");
        D2.k.e(str2, "legacyHash");
        this.f1099c = fVar;
        this.f1100d = bVar;
        this.f1101e = str;
        this.f1102f = str2;
    }

    private final void h(N.g gVar) {
        if (!f1098g.b(gVar)) {
            c g3 = this.f1100d.g(gVar);
            if (g3.f1104a) {
                this.f1100d.e(gVar);
                j(gVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g3.f1105b);
            }
        }
        Cursor F3 = gVar.F(new N.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = F3.moveToFirst() ? F3.getString(0) : null;
            A2.a.a(F3, null);
            if (D2.k.a(this.f1101e, string) || D2.k.a(this.f1102f, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f1101e + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                A2.a.a(F3, th);
                throw th2;
            }
        }
    }

    private final void i(N.g gVar) {
        gVar.w("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void j(N.g gVar) {
        i(gVar);
        gVar.w(v.a(this.f1101e));
    }

    @Override // N.h.a
    public void b(N.g gVar) {
        D2.k.e(gVar, "db");
        super.b(gVar);
    }

    @Override // N.h.a
    public void d(N.g gVar) {
        D2.k.e(gVar, "db");
        boolean a3 = f1098g.a(gVar);
        this.f1100d.a(gVar);
        if (!a3) {
            c g3 = this.f1100d.g(gVar);
            if (!g3.f1104a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g3.f1105b);
            }
        }
        j(gVar);
        this.f1100d.c(gVar);
    }

    @Override // N.h.a
    public void e(N.g gVar, int i3, int i4) {
        D2.k.e(gVar, "db");
        g(gVar, i3, i4);
    }

    @Override // N.h.a
    public void f(N.g gVar) {
        D2.k.e(gVar, "db");
        super.f(gVar);
        h(gVar);
        this.f1100d.d(gVar);
        this.f1099c = null;
    }

    @Override // N.h.a
    public void g(N.g gVar, int i3, int i4) {
        List d3;
        D2.k.e(gVar, "db");
        f fVar = this.f1099c;
        if (fVar == null || (d3 = fVar.f980d.d(i3, i4)) == null) {
            f fVar2 = this.f1099c;
            if (fVar2 != null && !fVar2.a(i3, i4)) {
                this.f1100d.b(gVar);
                this.f1100d.a(gVar);
                return;
            }
            throw new IllegalStateException("A migration from " + i3 + " to " + i4 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.f1100d.f(gVar);
        Iterator it = d3.iterator();
        while (it.hasNext()) {
            ((K.a) it.next()).a(gVar);
        }
        c g3 = this.f1100d.g(gVar);
        if (g3.f1104a) {
            this.f1100d.e(gVar);
            j(gVar);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + g3.f1105b);
        }
    }
}
