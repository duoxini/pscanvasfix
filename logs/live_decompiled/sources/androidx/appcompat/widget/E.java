package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.coui.appcompat.panel.COUIViewDragHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.backup.sdk.common.utils.Constants;

/* loaded from: classes.dex */
public abstract class E {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3900a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f3901b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f3902c = new Rect();

    static class a {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        return true;
    }

    static void b(Drawable drawable) {
        drawable.getClass();
    }

    public static Rect c(Drawable drawable) {
        Insets a3 = a.a(drawable);
        return new Rect(a3.left, a3.top, a3.right, a3.bottom);
    }

    public static PorterDuff.Mode d(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case Constants.MessagerConstants.METHOD_ID_UPDATE_PROTECT_TIME /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case COUIViewDragHelper.EDGE_ALL /* 15 */:
                return PorterDuff.Mode.SCREEN;
            case AppBarLayout.LayoutParams.SCROLL_FLAG_SNAP /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
