package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.core.graphics.drawable.a$a, reason: collision with other inner class name */
    static class C0065a {
        static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i3) {
            return drawableContainerState.getChild(i3);
        }

        static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        static void e(Drawable drawable, boolean z3) {
            drawable.setAutoMirrored(z3);
        }
    }

    static class b {
        static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        static void e(Drawable drawable, float f3, float f4) {
            drawable.setHotspot(f3, f4);
        }

        static void f(Drawable drawable, int i3, int i4, int i5, int i6) {
            drawable.setHotspotBounds(i3, i4, i5, i6);
        }

        static void g(Drawable drawable, int i3) {
            drawable.setTint(i3);
        }

        static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    static class c {
        static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        static boolean b(Drawable drawable, int i3) {
            return drawable.setLayoutDirection(i3);
        }
    }

    public static void a(Drawable drawable) {
        drawable.clearColorFilter();
    }

    public static int b(Drawable drawable) {
        return c.a(drawable);
    }

    public static boolean c(Drawable drawable) {
        return C0065a.d(drawable);
    }

    public static void d(Drawable drawable, boolean z3) {
        C0065a.e(drawable, z3);
    }

    public static void e(Drawable drawable, float f3, float f4) {
        b.e(drawable, f3, f4);
    }

    public static void f(Drawable drawable, int i3, int i4, int i5, int i6) {
        b.f(drawable, i3, i4, i5, i6);
    }

    public static boolean g(Drawable drawable, int i3) {
        return c.b(drawable, i3);
    }

    public static void h(Drawable drawable, int i3) {
        b.g(drawable, i3);
    }

    public static void i(Drawable drawable, ColorStateList colorStateList) {
        b.h(drawable, colorStateList);
    }

    public static void j(Drawable drawable, PorterDuff.Mode mode) {
        b.i(drawable, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Drawable k(Drawable drawable) {
        return drawable instanceof androidx.core.graphics.drawable.b ? ((androidx.core.graphics.drawable.b) drawable).a() : drawable;
    }

    public static Drawable l(Drawable drawable) {
        return drawable;
    }
}
