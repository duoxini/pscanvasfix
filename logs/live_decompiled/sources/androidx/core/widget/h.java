package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes.dex */
public abstract class h {

    static class a {
        static void a(PopupWindow popupWindow, View view, int i3, int i4, int i5) {
            popupWindow.showAsDropDown(view, i3, i4, i5);
        }
    }

    static class b {
        static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        static void c(PopupWindow popupWindow, boolean z3) {
            popupWindow.setOverlapAnchor(z3);
        }

        static void d(PopupWindow popupWindow, int i3) {
            popupWindow.setWindowLayoutType(i3);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z3) {
        b.c(popupWindow, z3);
    }

    public static void b(PopupWindow popupWindow, int i3) {
        b.d(popupWindow, i3);
    }

    public static void c(PopupWindow popupWindow, View view, int i3, int i4, int i5) {
        a.a(popupWindow, view, i3, i4, i5);
    }
}
