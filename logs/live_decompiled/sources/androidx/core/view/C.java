package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class C {

    static class a {
        static boolean a(ViewParent viewParent, View view, float f3, float f4, boolean z3) {
            return viewParent.onNestedFling(view, f3, f4, z3);
        }

        static boolean b(ViewParent viewParent, View view, float f3, float f4) {
            return viewParent.onNestedPreFling(view, f3, f4);
        }

        static void c(ViewParent viewParent, View view, int i3, int i4, int[] iArr) {
            viewParent.onNestedPreScroll(view, i3, i4, iArr);
        }

        static void d(ViewParent viewParent, View view, int i3, int i4, int i5, int i6) {
            viewParent.onNestedScroll(view, i3, i4, i5, i6);
        }

        static void e(ViewParent viewParent, View view, View view2, int i3) {
            viewParent.onNestedScrollAccepted(view, view2, i3);
        }

        static boolean f(ViewParent viewParent, View view, View view2, int i3) {
            return viewParent.onStartNestedScroll(view, view2, i3);
        }

        static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f3, float f4, boolean z3) {
        try {
            return a.a(viewParent, view, f3, f4, z3);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e3);
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f3, float f4) {
        try {
            return a.b(viewParent, view, f3, f4);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e3);
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i3, int i4, int[] iArr, int i5) {
        if (viewParent instanceof q) {
            ((q) viewParent).j(view, i3, i4, iArr, i5);
            return;
        }
        if (i5 == 0) {
            try {
                a.c(viewParent, view, i3, i4, iArr);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e3);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i3, int i4, int i5, int i6, int i7, int[] iArr) {
        if (viewParent instanceof r) {
            ((r) viewParent).m(view, i3, i4, i5, i6, i7, iArr);
            return;
        }
        iArr[0] = iArr[0] + i5;
        iArr[1] = iArr[1] + i6;
        if (viewParent instanceof q) {
            ((q) viewParent).n(view, i3, i4, i5, i6, i7);
            return;
        }
        if (i7 == 0) {
            try {
                a.d(viewParent, view, i3, i4, i5, i6);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e3);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i3, int i4) {
        if (viewParent instanceof q) {
            ((q) viewParent).h(view, view2, i3, i4);
            return;
        }
        if (i4 == 0) {
            try {
                a.e(viewParent, view, view2, i3);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e3);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i3, int i4) {
        if (viewParent instanceof q) {
            return ((q) viewParent).o(view, view2, i3, i4);
        }
        if (i4 != 0) {
            return false;
        }
        try {
            return a.f(viewParent, view, view2, i3);
        } catch (AbstractMethodError e3) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e3);
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i3) {
        if (viewParent instanceof q) {
            ((q) viewParent).i(view, i3);
            return;
        }
        if (i3 == 0) {
            try {
                a.g(viewParent, view);
            } catch (AbstractMethodError e3) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e3);
            }
        }
    }
}
