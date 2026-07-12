package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
public abstract class b {

    private static class a {
        static Drawable a(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* renamed from: androidx.core.widget.b$b, reason: collision with other inner class name */
    private static class C0075b {
        static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        return a.a(checkedTextView);
    }

    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        C0075b.a(checkedTextView, colorStateList);
    }

    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        C0075b.b(checkedTextView, mode);
    }
}
