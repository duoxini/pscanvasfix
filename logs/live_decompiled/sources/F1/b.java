package F1;

import K1.g;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Uri f427a = Uri.parse("content://com.oplus.atom.db_sys/atom_delegate");

    private static void b(final Context context, final G1.c cVar) {
        if (cVar == null || context == null) {
            K1.f.a("AtomAgent", new g() { // from class: F1.a
                @Override // K1.g
                public final Object get() {
                    String c3;
                    c3 = b.c(G1.c.this, context);
                    return c3;
                }
            });
            return;
        }
        G1.a aVar = (G1.a) cVar;
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Integer.valueOf(aVar.k()));
        contentValues.put("appPackage", K1.d.e(context));
        contentValues.put("logTag", aVar.n());
        contentValues.put("eventID", aVar.l());
        contentValues.put("logMap", aVar.m());
        try {
            context.getContentResolver().insert(f427a, contentValues);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String c(G1.c cVar, Context context) {
        return "AtomAgent add Task error -- bean or context is null--" + cVar + "," + context;
    }

    public static void d(Context context, G1.a aVar) {
        b(context, aVar);
    }
}
