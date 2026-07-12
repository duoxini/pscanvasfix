package i0;

import android.app.Activity;
import android.content.Context;

/* renamed from: i0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0393a {
    public static boolean a(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).isInMultiWindowMode();
        }
        return false;
    }
}
