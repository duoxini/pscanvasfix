package androidx.core.view;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class I {

    static class a {
        static void a(Window window, boolean z3) {
            window.setDecorFitsSystemWindows(z3);
        }
    }

    public static K a(Window window, View view) {
        return new K(window, view);
    }

    public static void b(Window window, boolean z3) {
        a.a(window, z3);
    }
}
