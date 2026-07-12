package m2;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public abstract class l {
    public static final void a(Context context, String str) {
        SharedPreferences c3;
        SharedPreferences.Editor edit;
        SharedPreferences.Editor remove;
        if (str == null || (c3 = c(context)) == null || (edit = c3.edit()) == null || (remove = edit.remove(str)) == null) {
            return;
        }
        remove.apply();
    }

    public static final boolean b(Context context, String str, boolean z3) {
        SharedPreferences c3;
        return (context == null || str == null || (c3 = c(context)) == null) ? z3 : c3.getBoolean(str, z3);
    }

    private static final SharedPreferences c(Context context) {
        if (context != null) {
            return context.getSharedPreferences("feedback_sp", 0);
        }
        return null;
    }

    public static final void d(Context context, String str, boolean z3) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putBoolean;
        SharedPreferences c3 = c(context);
        if (c3 == null || (edit = c3.edit()) == null || (putBoolean = edit.putBoolean(str, z3)) == null) {
            return;
        }
        putBoolean.apply();
    }
}
