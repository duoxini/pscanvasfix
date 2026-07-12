package m2;

import android.content.Context;
import android.widget.Toast;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static Toast f12459a;

    public static final void a(Context context, String str) {
        D2.k.e(context, "context");
        Toast toast = f12459a;
        if (toast != null) {
            toast.cancel();
        }
        Toast makeText = Toast.makeText(context.getApplicationContext(), str, 0);
        f12459a = makeText;
        if (makeText != null) {
            makeText.show();
        }
    }
}
