package e0;

import android.content.Context;
import android.view.View;

/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0342a {
    public static boolean a(Context context) {
        return 32 == (context.getResources().getConfiguration().uiMode & 48);
    }

    public static void b(View view, boolean z3) {
        view.setForceDarkAllowed(z3);
    }
}
