package N;

import android.database.Cursor;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f1605a = new e();

    private e() {
    }

    public static final void a(Cursor cursor, Bundle bundle) {
        D2.k.e(cursor, "cursor");
        D2.k.e(bundle, "extras");
        cursor.setExtras(bundle);
    }
}
