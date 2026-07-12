package com.coui.appcompat.grid;

import Q1.a;
import android.content.Context;

@Deprecated
/* loaded from: classes.dex */
public class COUIPercentUtils {
    private static final int CARD_LIST_FLAG = 2;
    private static final int LARGE_SCRREN_GRID_SIZE = 12;
    private static final int LARGE_SCRREN_WIDTH_LIMIT = 840;
    private static final int MEDIUM_SCRREN_GRID_SIZE = 8;
    private static final int MEDIUM_SCRREN_WIDTH_LIMIT = 600;
    private static final int PADDING_COUNT = 2;
    private static final int PREFERENCE_FLAG = 1;
    private static final int SMALL_SCRREN_GRID_SIZE = 4;
    private static final int SMALL_SCRREN_WIDTH_LIMIT = 480;

    @Deprecated
    public static float calculateWidth(float f3, int i3, int i4, int i5, Context context) {
        if (i3 <= 0 || i3 > i4) {
            return f3;
        }
        boolean z3 = i5 == 1 || i5 == 2;
        return ((((f3 - ((i5 == 2 ? context.getResources().getDimensionPixelOffset(a.f1894d) : context.getResources().getDimensionPixelOffset(a.f1895e)) * 2)) - ((i4 - 1) * context.getResources().getDimensionPixelOffset(a.f1896f))) / i4) * i3) + (context.getResources().getDimensionPixelOffset(a.f1896f) * Math.max(i3 - 1, 0)) + (z3 ? r9 : 0);
    }

    @Deprecated
    public static int getTotalGridSize(Context context) {
        int i3 = context.getResources().getConfiguration().screenWidthDp;
        if (i3 < MEDIUM_SCRREN_WIDTH_LIMIT) {
            return 4;
        }
        if (i3 < LARGE_SCRREN_WIDTH_LIMIT) {
            return 8;
        }
        return i3 > LARGE_SCRREN_WIDTH_LIMIT ? 12 : 4;
    }
}
