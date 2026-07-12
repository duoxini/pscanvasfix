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
public final class WindowHeightSizeClass {
    public static final WindowHeightSizeClass Compact;
    public static final Companion Companion = new Companion(null);
    public static final WindowHeightSizeClass Expanded;
    public static final WindowHeightSizeClass Medium;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f9377b;

    /* renamed from: a, reason: collision with root package name */
    private final String f9378a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final WindowHeightSizeClass _hide_fromHeight(float f3) {
            return f3 < Breakpoints.BP_MEDIUM_WINDOW_BASE_HEIGHT.getValue() ? WindowHeightSizeClass.Compact : f3 < Breakpoints.BP_EXPANDED_WINDOW_BASE_HEIGHT.getValue() ? WindowHeightSizeClass.Medium : WindowHeightSizeClass.Expanded;
        }

        public final WindowHeightSizeClass fromHeight(Dp dp) {
            k.e(dp, "height");
            if (WindowHeightSizeClass.f9377b) {
                Log.d("WindowHeightSizeClass", "[fromHeight] height : " + dp);
            }
            if (dp.getValue() >= 0.0f) {
                return _hide_fromHeight(dp.getValue());
            }
            Log.e("WindowHeightSizeClass", "height :" + dp.getValue() + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
            return WindowHeightSizeClass.Compact;
        }

        private Companion() {
        }

        public final WindowHeightSizeClass fromHeight(Context context, int i3) {
            k.e(context, "context");
            if (WindowHeightSizeClass.f9377b) {
                Log.d("WindowHeightSizeClass", "[fromHeight] height : " + i3 + " pixel");
            }
            if (i3 < 0) {
                Log.e("WindowHeightSizeClass", "height :" + i3 + " and Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
                return WindowHeightSizeClass.Compact;
            }
            return _hide_fromHeight(i3 / context.getResources().getDisplayMetrics().density);
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9377b = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("WindowSizeClass", 3);
        Compact = new WindowHeightSizeClass("Compact");
        Medium = new WindowHeightSizeClass("Medium");
        Expanded = new WindowHeightSizeClass("Expanded");
    }

    private WindowHeightSizeClass(String str) {
        this.f9378a = str;
    }

    public String toString() {
        return this.f9378a + " window base-height";
    }
}
