package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.c;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class i {

    static class a {
        static boolean a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        static int b(TextView textView) {
            return textView.getMaxLines();
        }

        static int c(TextView textView) {
            return textView.getMinLines();
        }
    }

    static class b {
        static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        static int b(View view) {
            return view.getLayoutDirection();
        }

        static int c(View view) {
            return view.getTextDirection();
        }

        static Locale d(TextView textView) {
            return textView.getTextLocale();
        }

        static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        static void f(TextView textView, int i3, int i4, int i5, int i6) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
        }

        static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        static void h(View view, int i3) {
            view.setTextDirection(i3);
        }
    }

    static class c {
        static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        static void e(TextView textView, int i3) {
            textView.setBreakStrategy(i3);
        }

        static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        static void h(TextView textView, int i3) {
            textView.setHyphenationFrequency(i3);
        }
    }

    static class d {
        static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        static void c(TextView textView, int i3) {
            textView.setFirstBaselineToTopHeight(i3);
        }
    }

    private static class e implements ActionMode.Callback {
        abstract ActionMode.Callback a();
    }

    public static Drawable[] a(TextView textView) {
        return b.a(textView);
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    private static int d(TextDirectionHeuristic textDirectionHeuristic) {
        TextDirectionHeuristic textDirectionHeuristic2;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        if (textDirectionHeuristic == textDirectionHeuristic3 || textDirectionHeuristic == (textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == textDirectionHeuristic2) {
            return 6;
        }
        return textDirectionHeuristic == textDirectionHeuristic3 ? 7 : 1;
    }

    public static c.a e(TextView textView) {
        return new c.a(d.b(textView));
    }

    public static void f(TextView textView, ColorStateList colorStateList) {
        androidx.core.util.h.d(textView);
        c.f(textView, colorStateList);
    }

    public static void g(TextView textView, PorterDuff.Mode mode) {
        androidx.core.util.h.d(textView);
        c.g(textView, mode);
    }

    public static void h(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        b.e(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void i(TextView textView, int i3) {
        androidx.core.util.h.b(i3);
        d.c(textView, i3);
    }

    public static void j(TextView textView, int i3) {
        androidx.core.util.h.b(i3);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i4 = a.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i3 > Math.abs(i4)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i3 - i4);
        }
    }

    public static void k(TextView textView, int i3) {
        androidx.core.util.h.b(i3);
        if (i3 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i3 - r0, 1.0f);
        }
    }

    public static void l(TextView textView, androidx.core.text.c cVar) {
        throw null;
    }

    public static void m(TextView textView, int i3) {
        textView.setTextAppearance(i3);
    }

    public static void n(TextView textView, c.a aVar) {
        b.h(textView, d(aVar.d()));
        textView.getPaint().set(aVar.e());
        c.e(textView, aVar.b());
        c.h(textView, aVar.c());
    }

    public static ActionMode.Callback o(ActionMode.Callback callback) {
        return callback instanceof e ? ((e) callback).a() : callback;
    }

    public static ActionMode.Callback p(TextView textView, ActionMode.Callback callback) {
        return callback;
    }
}
