package androidx.core.view.accessibility;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* loaded from: classes.dex */
public abstract class f {

    static class a {
        static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        static void c(AccessibilityRecord accessibilityRecord, int i3) {
            accessibilityRecord.setMaxScrollX(i3);
        }

        static void d(AccessibilityRecord accessibilityRecord, int i3) {
            accessibilityRecord.setMaxScrollY(i3);
        }
    }

    static class b {
        static void a(AccessibilityRecord accessibilityRecord, View view, int i3) {
            accessibilityRecord.setSource(view, i3);
        }
    }

    public static void a(AccessibilityRecord accessibilityRecord, int i3) {
        a.c(accessibilityRecord, i3);
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i3) {
        a.d(accessibilityRecord, i3);
    }

    public static void c(AccessibilityRecord accessibilityRecord, View view, int i3) {
        b.a(accessibilityRecord, view, i3);
    }
}
