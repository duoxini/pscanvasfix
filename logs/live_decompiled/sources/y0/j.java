package y0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final EnumC0643a f14497a = EnumC0643a.MID_END;

    /* renamed from: b, reason: collision with root package name */
    private static int f14498b = -1;

    public static float[] a(int i3) {
        return new float[]{((i3 >> 16) & 255) / 255.0f, ((i3 >> 8) & 255) / 255.0f, (i3 & 255) / 255.0f, ((i3 >> 24) & 255) / 255.0f};
    }

    public static boolean b(EnumC0643a enumC0643a) {
        if (f14498b == -1) {
            f14498b = g();
        }
        return f14498b <= enumC0643a.a() && f14498b != -1;
    }

    public static Activity c(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static int d(Context context, float f3) {
        return Math.round(f3 * context.getResources().getDisplayMetrics().density);
    }

    public static int e(MotionEvent motionEvent, int i3) {
        return Math.min(Math.max(0, i3), motionEvent.getPointerCount() - 1);
    }

    public static int f() {
        if (f14498b == -1) {
            f14498b = g();
        }
        return f14498b;
    }

    public static int g() {
        try {
            String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, "persist.sys.oplus.anim_level");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str.trim());
        } catch (Exception e3) {
            AbstractC0371a.c("UIUtil", "getAnimLevelVersion e: " + e3);
            return -1;
        }
    }

    public static ColorStateList h(Context context, int i3) {
        return context.getResources().getColorStateList(i3, context.getTheme());
    }

    public static final float i(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    public static int j(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int k(Context context) {
        return l(context).y;
    }

    public static Point l(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        Point point = new Point();
        if (context != null && (windowManager = (WindowManager) context.getSystemService("window")) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getRealSize(point);
        }
        return point;
    }

    public static int m(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int n(Context context) {
        return l(context).x;
    }

    public static boolean o(View view) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && view.isShown();
    }

    public static int p(Context context, int i3) {
        return Math.round(i3 / context.getResources().getDisplayMetrics().density);
    }

    public static void q(View view, boolean z3) {
        if (view == null) {
            return;
        }
        view.forceHasOverlappingRendering(z3);
    }

    public static void r(View view, int i3, int i4) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (i3 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i4;
                } else if (i3 == 1) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i4;
                } else if (i3 == 2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i4;
                } else if (i3 == 3) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i4;
                } else if (i3 == 4) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(i4);
                } else if (i3 == 5) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(i4);
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }
}
