package s;

import android.view.View;

/* renamed from: s.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0571a {
    public static String a(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }
}
