package androidx.core.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class B {

    static class a {
        static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        static void c(ViewGroup viewGroup, boolean z3) {
            viewGroup.setTransitionGroup(z3);
        }
    }

    public static boolean a(ViewGroup viewGroup) {
        return a.b(viewGroup);
    }
}
