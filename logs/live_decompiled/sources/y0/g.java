package y0;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import h0.AbstractC0371a;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final String f14487a = "g";

    /* renamed from: b, reason: collision with root package name */
    private static Rect f14488b;

    /* renamed from: c, reason: collision with root package name */
    private static Rect f14489c;

    /* renamed from: g, reason: collision with root package name */
    private static Rect f14493g;

    /* renamed from: d, reason: collision with root package name */
    private static int[] f14490d = new int[2];

    /* renamed from: e, reason: collision with root package name */
    private static int[] f14491e = new int[2];

    /* renamed from: f, reason: collision with root package name */
    private static Point f14492f = new Point();

    /* renamed from: h, reason: collision with root package name */
    private static Rect f14494h = new Rect();

    /* renamed from: i, reason: collision with root package name */
    private static Rect f14495i = new Rect();

    /* renamed from: j, reason: collision with root package name */
    private static int[] f14496j = new int[2];

    public static Point a(Context context, int i3, int i4, boolean z3) {
        int i5;
        if (f14489c == null) {
            Log.e(f14487a, "The AnchorRectInWindow is null");
            return null;
        }
        Point point = new Point();
        int i6 = f14492f.x - (i3 / 2);
        int i7 = j() ? f14492f.y : f14489c.bottom;
        int i8 = j() ? f14492f.y : f14489c.top;
        int b3 = b() - i7;
        Rect rect = f14495i;
        int i9 = rect.top;
        int i10 = rect.bottom;
        if (b3 < i4 + i9 + i10) {
            i7 = (i8 - i4) - i10;
        } else if (i9 + i7 + i4 < b()) {
            i7 += f14495i.top;
        }
        int max = Math.max(c() + f14495i.left, Math.min(i6, (d() - f14495i.right) - i3));
        if (z3 && k(context) && (i5 = f14490d[0]) > 0) {
            max += i5;
        }
        point.set(max, Math.max(e() + f14495i.top, i7));
        return point;
    }

    public static int b() {
        Rect rect = f14488b;
        if (rect == null) {
            AbstractC0371a.c(f14487a, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = f14493g;
        return (rect2 != null ? rect2.bottom : rect.bottom) - f14494h.bottom;
    }

    public static int c() {
        Rect rect = f14488b;
        if (rect == null) {
            AbstractC0371a.c(f14487a, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = f14493g;
        return (rect2 != null ? rect2.left : rect.left) + f14494h.left;
    }

    public static int d() {
        Rect rect = f14488b;
        if (rect == null) {
            AbstractC0371a.c(f14487a, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = f14493g;
        return (rect2 != null ? rect2.right : rect.right) - f14494h.right;
    }

    public static int e() {
        Rect rect = f14488b;
        if (rect == null) {
            AbstractC0371a.c(f14487a, "The sDecorViewRectInWindow is null, must calling init() first");
            return 0;
        }
        Rect rect2 = f14493g;
        return (rect2 != null ? rect2.top : rect.top) + f14494h.top;
    }

    public static int f() {
        if (j()) {
            return f14491e[0] + f14496j[0];
        }
        Rect rect = f14489c;
        if (rect != null) {
            return rect.centerX();
        }
        AbstractC0371a.c(f14487a, "The AnchorRectInWindow is null, must calling init() first");
        return 0;
    }

    public static int g() {
        if (j()) {
            return f14491e[1] + f14496j[1];
        }
        Rect rect = f14489c;
        if (rect != null) {
            return rect.centerY();
        }
        AbstractC0371a.c(f14487a, "The AnchorRectInWindow is null, must calling init() first");
        return 0;
    }

    public static Rect h() {
        return f14488b;
    }

    public static int[] i() {
        return f14490d;
    }

    public static boolean j() {
        int[] iArr = f14491e;
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public static boolean k(Context context) {
        double d3 = context.getResources().getConfiguration().screenWidthDp;
        double n3 = j.n(context) / context.getResources().getDisplayMetrics().density;
        return d3 == Math.floor(n3) || d3 == Math.ceil(n3);
    }

    public static void l(View view) {
        m(view, 0, 0);
    }

    public static void m(View view, int i3, int i4) {
        DisplayCutout displayCutout;
        n();
        if (i3 != 0 || i4 != 0) {
            p(i3, i4);
        }
        int[] iArr = new int[2];
        f14488b = new Rect();
        f14489c = new Rect();
        view.getWindowVisibleDisplayFrame(f14488b);
        view.getGlobalVisibleRect(f14489c);
        Rect rect = new Rect();
        view.getRootView().getGlobalVisibleRect(rect);
        view.getRootView().getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
        Rect rect2 = f14488b;
        rect2.left = Math.max(rect2.left, rect.left);
        Rect rect3 = f14488b;
        rect3.top = Math.max(rect3.top, rect.top);
        Rect rect4 = f14488b;
        rect4.right = Math.min(rect4.right, rect.right);
        Rect rect5 = f14488b;
        rect5.bottom = Math.min(rect5.bottom, rect.bottom);
        view.getRootView().getLocationOnScreen(iArr);
        int i5 = iArr[0];
        int i6 = iArr[1];
        view.getRootView().getLocationInWindow(iArr);
        int i7 = iArr[0];
        int i8 = iArr[1];
        int[] iArr2 = f14490d;
        int i9 = i5 - i7;
        iArr2[0] = i9;
        int i10 = i6 - i8;
        iArr2[1] = i10;
        f14488b.offset(-i9, -i10);
        view.getLocationInWindow(f14496j);
        f14492f.x = f();
        f14492f.y = g();
        if (view.getRootWindowInsets() == null || (displayCutout = view.getRootWindowInsets().getDisplayCutout()) == null) {
            return;
        }
        for (Rect rect6 : displayCutout.getBoundingRects()) {
            int i11 = rect6.top;
            if (i11 == 0) {
                Rect rect7 = f14488b;
                rect7.top = Math.max(rect7.top, rect6.bottom);
            } else {
                int i12 = rect6.bottom;
                Rect rect8 = f14488b;
                int i13 = rect8.bottom;
                if (i12 == i13) {
                    rect8.bottom = Math.min(i13, i11);
                } else {
                    int i14 = rect6.left;
                    if (i14 == 0) {
                        rect8.left = Math.max(rect8.left, rect6.right);
                    } else {
                        int i15 = rect6.right;
                        int i16 = rect8.right;
                        if (i15 == i16) {
                            rect8.right = Math.min(i16, i14);
                        }
                    }
                }
            }
        }
    }

    private static void n() {
        p(0, 0);
        o(null);
        f14494h.set(0, 0, 0, 0);
        f14495i.set(0, 0, 0, 0);
    }

    public static void o(Rect rect) {
        f14493g = rect;
    }

    public static void p(int i3, int i4) {
        int[] iArr = f14491e;
        iArr[0] = i3;
        iArr[1] = i4;
    }
}
