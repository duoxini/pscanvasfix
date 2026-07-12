package O;

import D2.k;
import N.i;
import android.database.sqlite.SQLiteProgram;

/* loaded from: classes.dex */
public class g implements i {

    /* renamed from: e, reason: collision with root package name */
    private final SQLiteProgram f1719e;

    public g(SQLiteProgram sQLiteProgram) {
        k.e(sQLiteProgram, "delegate");
        this.f1719e = sQLiteProgram;
    }

    @Override // N.i
    public void H(int i3, byte[] bArr) {
        k.e(bArr, "value");
        this.f1719e.bindBlob(i3, bArr);
    }

    @Override // N.i
    public void I(int i3) {
        this.f1719e.bindNull(i3);
    }

    @Override // N.i
    public void J(int i3, double d3) {
        this.f1719e.bindDouble(i3, d3);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1719e.close();
    }

    @Override // N.i
    public void x(int i3, String str) {
        k.e(str, "value");
        this.f1719e.bindString(i3, str);
    }

    @Override // N.i
    public void y(int i3, long j3) {
        this.f1719e.bindLong(i3, j3);
    }
}
