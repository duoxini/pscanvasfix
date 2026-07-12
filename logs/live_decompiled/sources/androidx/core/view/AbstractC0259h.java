package androidx.core.view;

import android.view.ViewGroup;

/* renamed from: androidx.core.view.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0259h {

    /* renamed from: androidx.core.view.h$a */
    static class a {
        static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
            marginLayoutParams.resolveLayoutDirection(i3);
        }

        static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
            marginLayoutParams.setLayoutDirection(i3);
        }

        static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
            marginLayoutParams.setMarginEnd(i3);
        }

        static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
            marginLayoutParams.setMarginStart(i3);
        }
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.b(marginLayoutParams);
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return a.c(marginLayoutParams);
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        a.g(marginLayoutParams, i3);
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i3) {
        a.h(marginLayoutParams, i3);
    }
}
