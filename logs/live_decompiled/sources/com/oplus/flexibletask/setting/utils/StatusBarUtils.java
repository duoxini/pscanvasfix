package com.oplus.flexibletask.setting.utils;

import android.annotation.NonNull;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Slog;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.android.internal.policy.SystemBarUtils;
import e0.AbstractC0342a;
import t1.AbstractC0589c;

/* loaded from: classes.dex */
public class StatusBarUtils {
    private static final String TAG = "StatusBarUtils";

    public static int getStatusBarHeightForRotation(Context context, int i3) {
        return SystemBarUtils.getStatusBarHeightForRotation(context, i3);
    }

    public static int getStatusBarHeightIgnoringVisibilityCurrent(@NonNull Activity activity) {
        return activity.getWindowManager().getCurrentWindowMetrics().getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.statusBars()).top;
    }

    public static int getStatusBarHeightValue(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Exception e3) {
            Slog.e(TAG, "getStatusBarHeightValue:", e3);
            return 0;
        }
    }

    private static boolean isNightMode(Context context) {
        return AbstractC0342a.a(context);
    }

    public static void setDarkStatusIcon(Activity activity) {
        boolean isNightMode = isNightMode(activity);
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(!isNightMode ? systemUiVisibility | 8208 : systemUiVisibility & (-8209));
    }

    public static void setStatusBarTransparentAndBlackFont(Activity activity) {
        Window window = activity.getWindow();
        window.getDecorView().setSystemUiVisibility(1024);
        window.setStatusBarColor(activity.getResources().getColor(AbstractC0589c.f13369h));
        View decorView = activity.getWindow().getDecorView();
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
    }
}
