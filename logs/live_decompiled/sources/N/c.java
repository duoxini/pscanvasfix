package N;

import android.app.ActivityManager;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1603a = new c();

    private c() {
    }

    public static final Uri a(Cursor cursor) {
        D2.k.e(cursor, "cursor");
        Uri notificationUri = cursor.getNotificationUri();
        D2.k.d(notificationUri, "cursor.notificationUri");
        return notificationUri;
    }

    public static final boolean b(ActivityManager activityManager) {
        D2.k.e(activityManager, "activityManager");
        return activityManager.isLowRamDevice();
    }
}
