package androidx.core.view;

import android.content.Context;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public abstract class A {

    static class a {
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    static class b {
        static int a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHoverSlop();
        }

        static boolean b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        return a.a(viewConfiguration);
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        return a.b(viewConfiguration);
    }

    public static boolean c(ViewConfiguration viewConfiguration, Context context) {
        return b.b(viewConfiguration);
    }
}
