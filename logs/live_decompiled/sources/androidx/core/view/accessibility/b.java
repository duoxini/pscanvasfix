package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public abstract class b {

    static class a {
        static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        static void b(AccessibilityEvent accessibilityEvent, int i3) {
            accessibilityEvent.setContentChangeTypes(i3);
        }
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        return a.a(accessibilityEvent);
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i3) {
        a.b(accessibilityEvent, i3);
    }
}
