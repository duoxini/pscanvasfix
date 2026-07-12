package com.coui.appcompat.grid;

import a2.AbstractC0226a;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.coui.component.responsiveui.ResponsiveUIModel;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowTotalSizeClass;
import com.coui.component.responsiveui.window.WindowWidthSizeClass;
import f0.AbstractC0349a;
import h0.AbstractC0371a;
import java.util.Arrays;

/* loaded from: classes.dex */
public class COUIResponsiveUtils {
    private static final int AUTO_GRID_NUMBER = -1;
    private static final int CARD_LIST_FLAG = 2;
    private static boolean DEBUG = false;
    private static final int DEFAULT_COLUMNS_FOR_CHILD = 8;
    private static final int DEFAULT_COLUMNS_FOR_COMPAT = 4;
    private static final int DEFAULT_COLUMNS_FOR_EXPANDED = 8;
    private static final int DEFAULT_COLUMNS_FOR_MEDIUM = 6;
    private static final int DEFAULT_FLAG = 0;
    private static final int LARGE_PADDING = 0;
    private static final int LIST_FLAG = 1;
    private static final int MARGIN_LARGE_DP_IN_LARGE_SCREEN = 40;
    private static final int MARGIN_LARGE_DP_IN_NON_LARGE_SCREEN = 24;
    private static final int PADDING_COUNT = 2;
    private static final int PADDING_MODE = 0;
    private static final int REMEASURE_MODE = 1;
    private static final int SMALL_PADDING = 1;
    private static final String TAG = "COUIResponsiveUtils";
    private static int sCouiFoldType;
    private static final Rect sRect = new Rect();
    private static final Point sPoint = new Point();

    static {
        DEBUG = AbstractC0371a.f11873b || AbstractC0371a.e(TAG, 3);
        sCouiFoldType = -1;
    }

    public static void calculatePadding(ResponsiveUIModel responsiveUIModel, int i3, int i4, boolean z3, float[] fArr) {
        int margin = responsiveUIModel.margin();
        int gutter = responsiveUIModel.gutter();
        int columnCount = responsiveUIModel.columnCount();
        int[] columnWidth = responsiveUIModel.columnWidth();
        int i5 = (columnCount - i3) / 2;
        if (z3) {
            margin -= i4;
        }
        float f3 = margin;
        fArr[1] = f3;
        fArr[0] = f3;
        for (int i6 = 0; i6 < i5; i6++) {
            fArr[0] = fArr[0] + columnWidth[i6];
            fArr[1] = fArr[1] + columnWidth[(columnCount - i6) - 1];
        }
        float f4 = i5 * gutter;
        fArr[0] = fArr[0] + f4;
        fArr[1] = fArr[1] + f4;
    }

    public static float calculateWidth(ResponsiveUIModel responsiveUIModel, int i3, int i4, boolean z3) {
        float width = responsiveUIModel.width((responsiveUIModel.columnCount() - i3) / 2, (i3 + r0) - 1);
        if (DEBUG) {
            Log.d(TAG, "calculateWidth: width = " + width);
        }
        if (!z3) {
            i4 = 0;
        }
        return width + (i4 * 2);
    }

    public static int getChildLayerDefaultTypeMargin(Context context, int i3) {
        return (int) ((isLargeScreen(context, i3) ? MARGIN_LARGE_DP_IN_LARGE_SCREEN : MARGIN_LARGE_DP_IN_NON_LARGE_SCREEN) * context.getResources().getDisplayMetrics().density);
    }

    public static int getDefaultGridNumbers(ResponsiveUIModel responsiveUIModel) {
        WindowTotalSizeClass windowTotalSizeClass = responsiveUIModel.windowSizeClass().getWindowTotalSizeClass();
        if (windowTotalSizeClass.equals(WindowTotalSizeClass.Compact)) {
            return 4;
        }
        if (windowTotalSizeClass.equals(WindowTotalSizeClass.Expanded)) {
            return 8;
        }
        return (windowTotalSizeClass.equals(WindowTotalSizeClass.MediumLandScape) || windowTotalSizeClass.equals(WindowTotalSizeClass.MediumPortrait) || windowTotalSizeClass.equals(WindowTotalSizeClass.MediumSquare) || windowTotalSizeClass.equals(WindowTotalSizeClass.ExpandedLandPortrait) || windowTotalSizeClass.equals(WindowTotalSizeClass.ExpandedPortrait)) ? 6 : 4;
    }

    public static int getScreenPhysicalHeight(Activity activity) {
        return activity.getWindowManager().getMaximumWindowMetrics().getBounds().height();
    }

    public static int getScreenPhysicalWidth(Activity activity) {
        return activity.getWindowManager().getMaximumWindowMetrics().getBounds().width();
    }

    @Deprecated
    public static boolean isActivityEmbedded(Context context) {
        return false;
    }

    public static boolean isLargePadWindow(Context context, int i3, int i4) {
        if (sCouiFoldType == -1) {
            sCouiFoldType = AbstractC0349a.a(context) ? 1 : 0;
        }
        return (isLargeScreenDp(i3, i4) || isLargeScreenDp(i4, i3)) && sCouiFoldType != 1;
    }

    @Deprecated
    public static boolean isLargeScreen(Context context, int i3) {
        return WindowWidthSizeClass.Companion.fromWidth(context, i3) == WindowWidthSizeClass.Expanded;
    }

    @Deprecated
    public static boolean isLargeScreenDp(int i3) {
        return WindowWidthSizeClass.Companion.fromWidth(new Dp((float) i3)) == WindowWidthSizeClass.Expanded;
    }

    @Deprecated
    public static boolean isMediumScreen(Context context, int i3) {
        return WindowWidthSizeClass.Companion.fromWidth(context, i3) == WindowWidthSizeClass.Medium;
    }

    @Deprecated
    public static boolean isMediumScreenDp(int i3) {
        return WindowWidthSizeClass.Companion.fromWidth(new Dp((float) i3)) == WindowWidthSizeClass.Medium;
    }

    public static boolean isSmallScreen(Context context, int i3) {
        return WindowWidthSizeClass.Companion.fromWidth(context, i3) == WindowWidthSizeClass.Compact;
    }

    public static boolean isSmallScreenDp(int i3) {
        return WindowWidthSizeClass.Companion.fromWidth(new Dp((float) i3)) == WindowWidthSizeClass.Compact;
    }

    public static void measureChildWithPercent(Context context, View view, int i3, int i4, int i5, int i6, int i7) {
        if (i6 != 0) {
            if (i7 != 0) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = (int) calculateWidth(View.MeasureSpec.getSize(i3), i6, i4, i5, context);
                view.setLayoutParams(layoutParams);
            } else {
                int size = (View.MeasureSpec.getSize(i3) - ((int) calculateWidth(View.MeasureSpec.getSize(i3), i6, i4, i5, context))) / 2;
                if (view.getPaddingLeft() == size && view.getPaddingRight() == size) {
                    return;
                }
                view.setPaddingRelative(size, view.getPaddingTop(), size, view.getPaddingBottom());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x02e3, code lost:
    
        if (r17.getPaddingRight() != r5[1]) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0309 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02be  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int measureLayout(android.view.View r17, int r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.grid.COUIResponsiveUtils.measureLayout(android.view.View, int, int, int, int, int, int, int, int, boolean, boolean):int");
    }

    public static void setDebug(boolean z3) {
        DEBUG = z3;
    }

    public static boolean isLargeScreen(Context context, int i3, int i4) {
        return WindowTotalSizeClass.Companion.fromWidthAndHeight(context, i3, i4) == WindowTotalSizeClass.Expanded;
    }

    public static boolean isLargeScreenDp(int i3, int i4) {
        return WindowTotalSizeClass.Companion.fromWidthAndHeight(new Dp((float) i3), new Dp((float) i4)) == WindowTotalSizeClass.Expanded;
    }

    public static boolean isMediumScreen(Context context, int i3, int i4) {
        WindowTotalSizeClass fromWidthAndHeight = WindowTotalSizeClass.Companion.fromWidthAndHeight(context, i3, i4);
        return fromWidthAndHeight == WindowTotalSizeClass.MediumPortrait || fromWidthAndHeight == WindowTotalSizeClass.MediumLandScape || fromWidthAndHeight == WindowTotalSizeClass.MediumSquare || fromWidthAndHeight == WindowTotalSizeClass.ExpandedPortrait || fromWidthAndHeight == WindowTotalSizeClass.ExpandedLandPortrait;
    }

    @Deprecated
    public static boolean isMediumScreenDp(Context context, int i3) {
        float f3 = i3;
        return WindowSizeClass.Companion.calculateFromSize(new Dp(f3), new Dp(f3)).getWindowWidthSizeClass() == WindowWidthSizeClass.Medium;
    }

    @Deprecated
    public static boolean isSmallScreenDp(Context context, int i3) {
        float f3 = i3;
        return WindowSizeClass.Companion.calculateFromSize(new Dp(f3), new Dp(f3)).getWindowWidthSizeClass() == WindowWidthSizeClass.Compact;
    }

    public static int getChildLayerDefaultTypeMargin(Context context, int i3, int i4) {
        float f3;
        float f4;
        if (isLargeScreen(context, i3, i4)) {
            f3 = context.getResources().getDisplayMetrics().density;
            f4 = 40.0f;
        } else {
            f3 = context.getResources().getDisplayMetrics().density;
            f4 = 24.0f;
        }
        return (int) (f3 * f4);
    }

    @Deprecated
    public static boolean isLargeScreenDp(Context context, int i3) {
        float f3 = i3;
        return WindowSizeClass.Companion.calculateFromSize(new Dp(f3), new Dp(f3)).getWindowWidthSizeClass() == WindowWidthSizeClass.Expanded;
    }

    public static boolean isMediumScreenDp(int i3, int i4) {
        WindowTotalSizeClass fromWidthAndHeight = WindowTotalSizeClass.Companion.fromWidthAndHeight(new Dp(i3), new Dp(i4));
        return fromWidthAndHeight == WindowTotalSizeClass.MediumPortrait || fromWidthAndHeight == WindowTotalSizeClass.MediumLandScape || fromWidthAndHeight == WindowTotalSizeClass.MediumSquare || fromWidthAndHeight == WindowTotalSizeClass.ExpandedPortrait;
    }

    @Deprecated
    public static float calculateWidth(float f3, int i3, int i4, int i5, Context context) {
        return calculateWidth(f3, context instanceof Activity ? getScreenPhysicalHeight((Activity) context) : 0, i3, i4, i5, context);
    }

    public static float calculateWidth(float f3, float f4, int i3, int i4, int i5, Context context) {
        int i6;
        MarginType marginType = i5 == 1 ? MarginType.MARGIN_SMALL : MarginType.MARGIN_LARGE;
        boolean z3 = i4 == 1 || i4 == 2;
        ResponsiveUIModel chooseMargin = new ResponsiveUIModel(context, (int) f3, (int) f4).chooseMargin(marginType);
        int margin = chooseMargin.margin();
        int columnCount = chooseMargin.columnCount();
        if (DEBUG) {
            Log.d(TAG, "calculateWidth: responsiveUIProxy.columnCount() = " + chooseMargin.columnCount() + " gridNumber = " + i3 + " screenSize = " + f3);
        }
        int defaultGridNumbers = i3 == -1 ? getDefaultGridNumbers(chooseMargin) : Math.min(i3, columnCount);
        float calculateGridWidth = chooseMargin.calculateGridWidth(defaultGridNumbers);
        if (DEBUG) {
            Log.d(TAG, "calculateWidth = " + calculateGridWidth + " gridNumber = " + defaultGridNumbers + " getColumnsCount = " + chooseMargin.columnCount() + " width = " + calculateGridWidth + " margin = " + margin + " screenWidth = " + f3 + " columnWidth = " + Arrays.toString(chooseMargin.columnWidth()) + " typeFlag = " + i4 + "isAddPadding = " + z3);
        }
        if (!z3) {
            i6 = 0;
        } else if (i4 == 1) {
            i6 = context.getResources().getDimensionPixelOffset(AbstractC0226a.f3341b);
        } else {
            i6 = context.getResources().getDimensionPixelOffset(AbstractC0226a.f3340a);
        }
        return calculateGridWidth + ((z3 ? i6 : 0) * 2);
    }

    @Deprecated
    public static int measureLayout(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z3, boolean z4) {
        return measureLayout(view, i3, i5, i6, i7, i8, i9, i10, i11, z3, z4);
    }
}
