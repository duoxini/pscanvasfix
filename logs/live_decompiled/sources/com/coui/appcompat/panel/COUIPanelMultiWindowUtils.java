package com.coui.appcompat.panel;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowInsets;
import i0.AbstractC0393a;
import y0.g;
import y0.j;

/* loaded from: classes.dex */
public class COUIPanelMultiWindowUtils {
    private static final int DEFAULT_MARGIN_TOP = 40;
    private static final float LARGEST_SCREEN_HEIGHT_DP_THRESHOLD = 809.0f;
    private static final int NAV_STATE_SWIPE_SIDE_GESTURE = 3;
    private static final int SETTING_CLOSE_FLAG = 0;
    private static final int SETTING_OPEN_FLAG = 1;
    private static final float SMALLEST_SCREEN_WIDTH_DP_THRESHOLD = 600.0f;
    private static final float TWO_THIRDS = 0.66f;

    public static Activity contextToActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static int dp2px(Context context, int i3) {
        return Double.valueOf((context.getResources().getDisplayMetrics().density * i3) + 0.5d).intValue();
    }

    public static int getCurrentPanelWindowVisibleHeight(Activity activity, Configuration configuration) {
        Rect currentWindowVisibleRect;
        int i3 = (!isInMultiWindowMode(activity) || (currentWindowVisibleRect = getCurrentWindowVisibleRect(activity)) == null) ? 0 : currentWindowVisibleRect.bottom - currentWindowVisibleRect.top;
        return i3 == 0 ? getPanelNormalVisibleHeight(activity, configuration) : i3;
    }

    public static int getCurrentWindowVisibleHeight(Activity activity, Configuration configuration) {
        Rect currentWindowVisibleRect;
        int i3 = (!isInMultiWindowMode(activity) || (currentWindowVisibleRect = getCurrentWindowVisibleRect(activity)) == null) ? 0 : currentWindowVisibleRect.bottom - currentWindowVisibleRect.top;
        return i3 == 0 ? getNormalVisibleHeight(activity, configuration) : i3;
    }

    public static Rect getCurrentWindowVisibleRect(Activity activity) {
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getGlobalVisibleRect(rect);
        return rect;
    }

    public static int getNormalVisibleHeight(Context context, Configuration configuration) {
        int i3 = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int k3 = j.k(context);
        int statusBarHeight = getStatusBarHeight(context);
        if (COUINavigationBarUtil.isNavigationBarShow(context) && (configuration.screenWidthDp >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || isPortrait(configuration))) {
            i3 = COUINavigationBarUtil.getNavigationBarHeight(context);
        }
        return (k3 - statusBarHeight) - i3;
    }

    public static int getPanelMarginBottom(Context context, Configuration configuration) {
        if (context == null || configuration == null) {
            return 0;
        }
        int i3 = configuration.screenWidthDp;
        boolean z3 = (configuration.screenLayout & 15) == 1;
        boolean z4 = configuration.orientation == 2;
        if (i3 >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || (!z3 && z4)) {
            return getStatusBarHeight(context) == 0 ? context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(U1.d.f2380h) : context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(U1.d.f2377e);
        }
        return 0;
    }

    public static int getPanelMaxHeight(Context context, Configuration configuration) {
        int panelNormalVisibleHeight;
        int panelMarginBottom;
        if (context == null) {
            return 0;
        }
        Activity contextToActivity = contextToActivity(context);
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (contextToActivity != null) {
            panelNormalVisibleHeight = getCurrentPanelWindowVisibleHeight(contextToActivity, configuration);
            panelMarginBottom = getPanelMarginBottom(context, configuration);
        } else {
            panelNormalVisibleHeight = getPanelNormalVisibleHeight(context, configuration);
            panelMarginBottom = getPanelMarginBottom(context, configuration);
        }
        return Math.min(panelNormalVisibleHeight - panelMarginBottom, getPanelPercentFrameLayoutMaxHeight(context, context.getResources().getDimensionPixelOffset(U1.d.f2395w)));
    }

    public static int getPanelNormalVisibleHeight(Context context, Configuration configuration) {
        int i3 = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int k3 = j.k(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(U1.d.f2397y);
        if (getStatusBarHeight(context) == 0) {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(U1.d.f2380h);
        }
        boolean isNavigationBarShow = COUINavigationBarUtil.isNavigationBarShow(context);
        boolean z3 = ((configuration.screenLayout & 15) == 2) && (configuration.orientation == 2);
        if (isNavigationBarShow && ((configuration.screenWidthDp >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || isPortrait(configuration)) && isVirtualNavigation(context) && !z3)) {
            i3 = COUINavigationBarUtil.getNavigationBarHeight(context);
        }
        return (k3 - dimensionPixelOffset) - i3;
    }

    public static int getPanelPercentFrameLayoutMaxHeight(Context context, int i3) {
        return i3;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStatusBarHeightAfterR(WindowInsets windowInsets) {
        return Math.abs(windowInsets.getInsets(WindowInsets.Type.statusBars()).bottom - windowInsets.getInsets(WindowInsets.Type.statusBars()).top);
    }

    public static boolean isDisplayInHorizontal(Activity activity) {
        if (activity == null || activity.getResources().getConfiguration().orientation != 2 || !isInMultiWindowMode(activity)) {
            return false;
        }
        View decorView = activity.getWindow().getDecorView();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return ((float) (rect.right - rect.left)) < ((float) j.n(activity)) * TWO_THIRDS;
    }

    public static boolean isDisplayInPrimaryScreen(Activity activity) {
        if (activity == null) {
            return true;
        }
        int statusBarHeight = getStatusBarHeight(activity);
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        return iArr[0] <= statusBarHeight && iArr[1] <= statusBarHeight;
    }

    public static boolean isDisplayInUpperWindow(Activity activity) {
        if (activity == null) {
            return true;
        }
        int[] iArr = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(iArr);
        return iArr[1] <= getStatusBarHeight(activity);
    }

    public static boolean isInMultiWindowMode(Activity activity) {
        return activity != null && activity.isInMultiWindowMode();
    }

    public static boolean isLand(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean isLargeHeightScreen(Context context, Configuration configuration) {
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        return ((float) configuration.screenHeightDp) > LARGEST_SCREEN_HEIGHT_DP_THRESHOLD;
    }

    public static boolean isNormalLandScreen(Context context, Configuration configuration) {
        if (context == null || configuration == null) {
            return false;
        }
        return ((configuration.screenLayout & 15) == 2) && (configuration.orientation == 2);
    }

    public static boolean isNormalScreen(Context context, Configuration configuration) {
        return (context == null || configuration == null || (configuration.screenLayout & 15) != 2) ? false : true;
    }

    public static boolean isPortrait(Context context) {
        return isPortrait(context.getResources().getConfiguration());
    }

    public static boolean isSmallScreen(Context context, Configuration configuration) {
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        return ((float) configuration.screenWidthDp) < SMALLEST_SCREEN_WIDTH_DP_THRESHOLD;
    }

    public static boolean isTaskBarShowInApp(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "enable_launcher_taskbar", 0) == 1;
    }

    public static boolean isVirtualNavigation(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) != 3;
    }

    public static boolean isPortrait(Configuration configuration) {
        return configuration.orientation == 1;
    }

    public static int getStatusBarHeight(WindowInsets windowInsets, Context context) {
        return getStatusBarHeightAfterR(windowInsets);
    }

    public static int getCurrentPanelWindowVisibleHeight(Activity activity, Configuration configuration, WindowInsets windowInsets) {
        int i3;
        if (isInMultiWindowMode(activity)) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(U1.d.f2397y);
            if (getStatusBarHeight(windowInsets, activity) == 0) {
                dimensionPixelOffset = activity.getResources().getDimensionPixelOffset(U1.d.f2380h);
            }
            i3 = (displayMetrics.heightPixels - windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom) - dimensionPixelOffset;
        } else {
            i3 = 0;
        }
        return i3 == 0 ? getPanelNormalVisibleHeight(activity, configuration, windowInsets) : i3;
    }

    @Deprecated
    public static int getPanelMarginBottom(Context context, Configuration configuration, WindowInsets windowInsets, boolean z3) {
        return getPanelMarginBottom(context, configuration, windowInsets, z3, false);
    }

    @Deprecated
    public static int getPanelMaxHeight(Context context, Configuration configuration, WindowInsets windowInsets, boolean z3) {
        return getPanelMaxHeight(context, configuration, windowInsets, z3, false);
    }

    public static int getPanelMarginBottom(Context context, Configuration configuration, WindowInsets windowInsets, boolean z3, boolean z4) {
        if (context == null || configuration == null || z3) {
            return 0;
        }
        int i3 = configuration.screenWidthDp;
        boolean z5 = (configuration.screenLayout & 15) == 1;
        boolean z6 = configuration.orientation == 2;
        if (i3 < SMALLEST_SCREEN_WIDTH_DP_THRESHOLD && (z5 || !z6)) {
            return 0;
        }
        int i4 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        if ((context.getResources().getConfiguration().screenLayout & 48) == 32) {
            return Math.max(0, context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(U1.d.f2378f) - i4);
        }
        int dimensionPixelOffset = context.createConfigurationContext(configuration).getResources().getDimensionPixelOffset(U1.d.f2377e);
        if (z4) {
            return dimensionPixelOffset;
        }
        return Math.max(0, (g.k(context) && AbstractC0393a.a(contextToActivity(context)) && !isVirtualNavigation(context) && isTaskBarShowInApp(context)) ? Math.max(dimensionPixelOffset, i4) : dimensionPixelOffset - i4);
    }

    public static int getPanelMaxHeight(Context context, Configuration configuration, WindowInsets windowInsets, boolean z3, boolean z4) {
        int panelNormalVisibleHeight;
        int panelMarginBottom;
        if (context == null) {
            return 0;
        }
        Activity contextToActivity = contextToActivity(context);
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        if (contextToActivity != null) {
            panelNormalVisibleHeight = getCurrentPanelWindowVisibleHeight(contextToActivity, configuration, windowInsets);
            panelMarginBottom = getPanelMarginBottom(context, configuration, windowInsets, z3, z4);
        } else {
            panelNormalVisibleHeight = getPanelNormalVisibleHeight(context, configuration, windowInsets);
            panelMarginBottom = getPanelMarginBottom(context, configuration, windowInsets, z3, z4);
        }
        return Math.min(panelNormalVisibleHeight - panelMarginBottom, getPanelPercentFrameLayoutMaxHeight(context, context.getResources().getDimensionPixelOffset(U1.d.f2395w)));
    }

    public static int getPanelNormalVisibleHeight(Context context, Configuration configuration, WindowInsets windowInsets) {
        int i3 = 0;
        if (context == null) {
            return 0;
        }
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int k3 = j.k(context);
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(U1.d.f2397y);
        if (getStatusBarHeight(windowInsets, context) == 0) {
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(U1.d.f2380h);
        }
        boolean isNavigationBarShow = COUINavigationBarUtil.isNavigationBarShow(context);
        boolean z3 = ((configuration.screenLayout & 15) == 2) && (configuration.orientation == 2);
        if (isNavigationBarShow && ((configuration.screenWidthDp >= SMALLEST_SCREEN_WIDTH_DP_THRESHOLD || isPortrait(configuration)) && isVirtualNavigation(context) && !z3)) {
            i3 = COUINavigationBarUtil.getNavigationBarHeight(context);
        }
        return (k3 - dimensionPixelOffset) - i3;
    }
}
