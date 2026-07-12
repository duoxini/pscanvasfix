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
public final class WindowWidthSizeClass {
    public static final WindowWidthSizeClass Compact;
    public static final Companion Companion = new Companion(null);
    public static final WindowWidthSizeClass Expanded;
    public static final WindowWidthSizeClass Medium;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f9384b;

    /* renamed from: a, reason: collision with root package name */
    private final String f9385a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WindowWidthSizeClass _hide_fromWidth(float f3) {
            return f3 < Breakpoints.BP_MEDIUM_WINDOW_BASE_WIDTH.getValue() ? WindowWidthSizeClass.Compact : f3 < Breakpoints.BP_EXPANDED_WINDOW_BASE_WIDTH.getValue() ? WindowWidthSizeClass.Medium : WindowWidthSizeClass.Expanded;
        }

        public final WindowWidthSizeClass fromWidth(Dp dp) {
            k.e(dp, "width");
            if (WindowWidthSizeClass.f9384b) {
                Log.d("WindowWidthSizeClass", "[fromWidth] width : " + dp);
            }
            if (dp.getValue() >= 0.0f) {
                return _hide_fromWidth(dp.getValue());
            }
            Log.e("WindowWidthSizeClass", "width :" + dp.getValue() + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
            return WindowWidthSizeClass.Compact;
        }

        private Companion() {
        }

        public final WindowWidthSizeClass fromWidth(Context context, int i3) {
            k.e(context, "context");
            if (WindowWidthSizeClass.f9384b) {
                Log.d("WindowWidthSizeClass", "[fromWidth] width : " + i3 + " pixel");
            }
            if (i3 < 0) {
                Log.e("WindowWidthSizeClass", "width :" + i3 + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
                return WindowWidthSizeClass.Compact;
            }
            return _hide_fromWidth(i3 / context.getResources().getDisplayMetrics().density);
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9384b = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("WindowSizeClass", 3);
        Compact = new WindowWidthSizeClass("Compact");
        Medium = new WindowWidthSizeClass("Medium");
        Expanded = new WindowWidthSizeClass("Expanded");
    }

    private WindowWidthSizeClass(String str) {
        this.f9385a = str;
    }

    public String toString() {
        return this.f9385a + " window base-width";
    }
}
