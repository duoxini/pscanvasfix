package V;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.oplus.backup.sdk.common.utils.ApplicationFileInfo;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f2526a = Uri.parse("content://com.android.settings.outward.provider/message_entries");

    public static int a(Context context, String str, String str2) {
        return context.getContentResolver().delete(f2526a, "message_id = ? AND package_name = ?", new String[]{str, str2});
    }

    private static ContentValues b(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("message_id", aVar.e());
        contentValues.put(ApplicationFileInfo.PACKAGE_NAME, aVar.f());
        contentValues.put("module", aVar.c());
        contentValues.put("module_res_name", aVar.d());
        contentValues.put("title", aVar.j());
        contentValues.put("title_res_name", aVar.k());
        contentValues.put("display_order", Integer.valueOf(aVar.a()));
        contentValues.put("target_action", aVar.h());
        contentValues.put("target_package_name", aVar.i());
        contentValues.put("entrance_path", aVar.b());
        contentValues.put("recommend", Integer.valueOf(aVar.g()));
        return contentValues;
    }

    public static Uri c(Context context, a aVar) {
        return context.getContentResolver().insert(f2526a, b(aVar));
    }
}
