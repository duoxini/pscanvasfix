package X;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static final TextUtils.SimpleStringSplitter f2833a = new TextUtils.SimpleStringSplitter(':');

    public static Set a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (string == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        TextUtils.SimpleStringSplitter simpleStringSplitter = f2833a;
        simpleStringSplitter.setString(string);
        while (simpleStringSplitter.hasNext()) {
            ComponentName unflattenFromString = ComponentName.unflattenFromString(simpleStringSplitter.next());
            if (unflattenFromString != null) {
                hashSet.add(unflattenFromString);
            }
        }
        return hashSet;
    }

    private static boolean b(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled();
    }

    public static boolean c(Context context) {
        return d(context) && b(context);
    }

    private static boolean d(Context context) {
        Set a3 = a(context);
        if (a3 != null && !a3.isEmpty()) {
            Iterator it = a3.iterator();
            while (it.hasNext()) {
                if (TextUtils.equals(((ComponentName) it.next()).getPackageName(), "com.google.android.marvin.talkback")) {
                    return true;
                }
            }
        }
        return false;
    }
}
