package O;

import N.k;
import android.database.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
public final class h extends g implements k {

    /* renamed from: f, reason: collision with root package name */
    private final SQLiteStatement f1720f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        D2.k.e(sQLiteStatement, "delegate");
        this.f1720f = sQLiteStatement;
    }

    @Override // N.k
    public int B() {
        return this.f1720f.executeUpdateDelete();
    }

    @Override // N.k
    public long S() {
        return this.f1720f.executeInsert();
    }
}
