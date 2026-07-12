package com.google.android.material.internal;

import L0.a;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.Window;
import androidx.core.view.I;
import androidx.core.view.K;

/* loaded from: classes.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(Window window, boolean z3) {
        applyEdgeToEdge(window, z3, null, null);
    }

    @TargetApi(21)
    private static int getNavigationBarColor(Context context, boolean z3) {
        if (z3) {
            return 0;
        }
        return a.b(context, R.attr.navigationBarColor, -16777216);
    }

    @TargetApi(21)
    private static int getStatusBarColor(Context context, boolean z3) {
        if (z3) {
            return 0;
        }
        return a.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean isUsingLightSystemBar(int i3, boolean z3) {
        return a.f(i3) || (i3 == 0 && z3);
    }

    public static void applyEdgeToEdge(Window window, boolean z3, Integer num, Integer num2) {
        boolean z4 = num == null || num.intValue() == 0;
        boolean z5 = num2 == null || num2.intValue() == 0;
        if (z4 || z5) {
            int b3 = a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z4) {
                num = Integer.valueOf(b3);
            }
            if (z5) {
                num2 = Integer.valueOf(b3);
            }
        }
        I.b(window, !z3);
        int statusBarColor = getStatusBarColor(window.getContext(), z3);
        int navigationBarColor = getNavigationBarColor(window.getContext(), z3);
        window.setStatusBarColor(statusBarColor);
        window.setNavigationBarColor(navigationBarColor);
        boolean isUsingLightSystemBar = isUsingLightSystemBar(statusBarColor, a.f(num.intValue()));
        boolean isUsingLightSystemBar2 = isUsingLightSystemBar(navigationBarColor, a.f(num2.intValue()));
        K a3 = I.a(window, window.getDecorView());
        if (a3 != null) {
            a3.b(isUsingLightSystemBar);
            a3.a(isUsingLightSystemBar2);
        }
    }
}
