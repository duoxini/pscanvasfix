package N;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.CancellationSignal;
import java.io.File;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1602a = new b();

    private b() {
    }

    public static final boolean a(File file) {
        D2.k.e(file, "file");
        return SQLiteDatabase.deleteDatabase(file);
    }

    public static final boolean b(SQLiteDatabase sQLiteDatabase) {
        D2.k.e(sQLiteDatabase, "sQLiteDatabase");
        return sQLiteDatabase.isWriteAheadLoggingEnabled();
    }

    public static final Cursor c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, CancellationSignal cancellationSignal, SQLiteDatabase.CursorFactory cursorFactory) {
        D2.k.e(sQLiteDatabase, "sQLiteDatabase");
        D2.k.e(str, "sql");
        D2.k.e(strArr, "selectionArgs");
        D2.k.e(cancellationSignal, "cancellationSignal");
        D2.k.e(cursorFactory, "cursorFactory");
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        D2.k.d(rawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
        return rawQueryWithFactory;
    }

    public static final void d(SQLiteOpenHelper sQLiteOpenHelper, boolean z3) {
        D2.k.e(sQLiteOpenHelper, "sQLiteOpenHelper");
        sQLiteOpenHelper.setWriteAheadLoggingEnabled(z3);
    }
}
