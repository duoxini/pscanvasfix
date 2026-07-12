package androidx.window.layout.util;

import D2.k;
import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.J;
import androidx.window.layout.WindowMetrics;

/* loaded from: classes.dex */
public final class ContextCompatHelperApi30 {

    /* renamed from: a, reason: collision with root package name */
    public static final ContextCompatHelperApi30 f7263a = new ContextCompatHelperApi30();

    private ContextCompatHelperApi30() {
    }

    public final J a(Context context) {
        k.e(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        k.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        J v3 = J.v(windowInsets);
        k.d(v3, "toWindowInsetsCompat(platformInsets)");
        return v3;
    }

    public final WindowMetrics b(Context context) {
        k.e(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        J v3 = J.v(windowManager.getCurrentWindowMetrics().getWindowInsets());
        k.d(v3, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        Rect bounds = windowManager.getCurrentWindowMetrics().getBounds();
        k.d(bounds, "wm.currentWindowMetrics.bounds");
        return new WindowMetrics(bounds, v3);
    }
}
