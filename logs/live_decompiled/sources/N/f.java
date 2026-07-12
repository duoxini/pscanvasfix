package N;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f1606a = new f();

    private f() {
    }

    public static final List a(Cursor cursor) {
        D2.k.e(cursor, "cursor");
        List<Uri> notificationUris = cursor.getNotificationUris();
        D2.k.b(notificationUris);
        return notificationUris;
    }

    public static final void b(Cursor cursor, ContentResolver contentResolver, List list) {
        D2.k.e(cursor, "cursor");
        D2.k.e(contentResolver, "cr");
        D2.k.e(list, "uris");
        cursor.setNotificationUris(contentResolver, list);
    }
}
