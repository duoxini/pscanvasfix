package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: androidx.core.view.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0256e {

    /* renamed from: androidx.core.view.e$a */
    static class a {
        static void a(int i3, int i4, int i5, Rect rect, int i6, int i7, Rect rect2, int i8) {
            Gravity.apply(i3, i4, i5, rect, i6, i7, rect2, i8);
        }

        static void b(int i3, int i4, int i5, Rect rect, Rect rect2, int i6) {
            Gravity.apply(i3, i4, i5, rect, rect2, i6);
        }

        static void c(int i3, Rect rect, Rect rect2, int i4) {
            Gravity.applyDisplay(i3, rect, rect2, i4);
        }
    }

    public static void a(int i3, int i4, int i5, Rect rect, Rect rect2, int i6) {
        a.b(i3, i4, i5, rect, rect2, i6);
    }

    public static int b(int i3, int i4) {
        return Gravity.getAbsoluteGravity(i3, i4);
    }
}
