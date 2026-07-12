package f0;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.oplus.content.OplusFeatureConfigManager;

/* renamed from: f0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0349a {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return OplusFeatureConfigManager.getInstance().hasFeature("oplus.hardware.type.fold");
        } catch (Error | Exception e3) {
            Log.d("AppFeatureUtil", "Load feature_fold failed : " + e3.getMessage());
            return false;
        }
    }

    public static boolean b(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "oplus_system_folding_mode", 0) == 0;
    }

    public static boolean c(Context context) {
        return a(context) && b(context);
    }
}
