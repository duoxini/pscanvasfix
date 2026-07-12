package com.coui.component.responsiveui.window;

import D2.g;
import D2.k;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.breakpoints.Breakpoints;
import com.coui.component.responsiveui.unit.Dp;

/* loaded from: classes.dex */
public final class WindowTotalSizeClass {
    public static final WindowTotalSizeClass Compact;
    public static final Companion Companion = new Companion(null);
    public static final WindowTotalSizeClass Expanded;
    public static final WindowTotalSizeClass ExpandedLandPortrait;
    public static final WindowTotalSizeClass ExpandedPortrait;
    public static final WindowTotalSizeClass MediumLandScape;
    public static final WindowTotalSizeClass MediumPortrait;
    public static final WindowTotalSizeClass MediumSquare;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f9382b;

    /* renamed from: a, reason: collision with root package name */
    private final String f9383a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final WindowTotalSizeClass a(float f3, float f4) {
            WindowWidthSizeClass _hide_fromWidth = WindowWidthSizeClass.Companion._hide_fromWidth(f3);
            if (k.a(_hide_fromWidth, WindowWidthSizeClass.Compact)) {
                return WindowTotalSizeClass.Compact;
            }
            if (k.a(_hide_fromWidth, WindowWidthSizeClass.Medium)) {
                WindowHeightSizeClass _hide_fromHeight = WindowHeightSizeClass.Companion._hide_fromHeight(f4);
                return k.a(_hide_fromHeight, WindowHeightSizeClass.Compact) ? WindowTotalSizeClass.MediumLandScape : k.a(_hide_fromHeight, WindowHeightSizeClass.Medium) ? WindowTotalSizeClass.MediumSquare : WindowTotalSizeClass.MediumPortrait;
            }
            WindowHeightSizeClass _hide_fromHeight2 = WindowHeightSizeClass.Companion._hide_fromHeight(f4);
            if (k.a(_hide_fromHeight2, WindowHeightSizeClass.Compact)) {
                return WindowTotalSizeClass.ExpandedLandPortrait;
            }
            if (!k.a(_hide_fromHeight2, WindowHeightSizeClass.Medium) && b(f3, f4)) {
                return WindowTotalSizeClass.ExpandedPortrait;
            }
            return WindowTotalSizeClass.Expanded;
        }

        private final boolean b(float f3, float f4) {
            return f4 > f3 && f3 < Breakpoints.BP_EXPANDED_WINDOW_MAXIMUM_WIDTH.getValue();
        }

        public final WindowTotalSizeClass fromWidthAndHeight(Dp dp, Dp dp2) {
            k.e(dp, "width");
            k.e(dp2, "height");
            if (WindowTotalSizeClass.f9382b) {
                Log.d("WindowHeightSizeClass", "[fromWidthAndHeight] width : " + dp + ", height : " + dp2);
            }
            if (dp.getValue() >= 0.0f && dp2.getValue() >= 0.0f) {
                return a(dp.getValue(), dp2.getValue());
            }
            Log.e("WindowHeightSizeClass", "width :" + dp.getValue() + " height :" + dp2.getValue() + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
            return WindowTotalSizeClass.Compact;
        }

        private Companion() {
        }

        public final WindowTotalSizeClass fromWidthAndHeight(Context context, int i3, int i4) {
            k.e(context, "context");
            if (WindowTotalSizeClass.f9382b) {
                Log.d("WindowHeightSizeClass", "[fromWidthAndHeight] width : " + i3 + " pixel, height : " + i4 + " pixel");
            }
            if (i3 >= 0 && i4 >= 0) {
                float f3 = context.getResources().getDisplayMetrics().density;
                return a(i3 / f3, i4 / f3);
            }
            Log.e("WindowHeightSizeClass", "width :" + i3 + " height :" + i4 + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
            return WindowTotalSizeClass.Compact;
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9382b = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("WindowSizeClass", 3);
        Compact = new WindowTotalSizeClass("Compact");
        MediumLandScape = new WindowTotalSizeClass("MediumLandScape");
        MediumSquare = new WindowTotalSizeClass("MediumSquare");
        MediumPortrait = new WindowTotalSizeClass("MediumPortrait");
        Expanded = new WindowTotalSizeClass("Expanded");
        ExpandedLandPortrait = new WindowTotalSizeClass("ExpandedLandPortrait");
        ExpandedPortrait = new WindowTotalSizeClass("ExpandedPortrait");
    }

    private WindowTotalSizeClass(String str) {
        this.f9383a = str;
    }

    public String toString() {
        return this.f9383a + " window base-total";
    }
}
