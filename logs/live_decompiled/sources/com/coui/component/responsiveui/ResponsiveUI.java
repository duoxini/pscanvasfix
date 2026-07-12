package com.coui.component.responsiveui;

import D2.g;
import D2.k;
import android.content.Context;
import android.util.Log;
import com.coui.component.responsiveui.layoutgrid.LayoutGridSystem;
import com.coui.component.responsiveui.proxy.ResponsiveUIProxy;
import com.coui.component.responsiveui.status.WindowStatus;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;

/* loaded from: classes.dex */
public final class ResponsiveUI {
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f9315a;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final IResponsiveUI getInstance(Context context, LayoutGridWindowSize layoutGridWindowSize) {
            k.e(context, "context");
            k.e(layoutGridWindowSize, "windowSize");
            WindowStatus windowStatus = new WindowStatus(context.getResources().getConfiguration().orientation, WindowSizeClass.Companion.calculateFromSize(DpKt.pixel2Dp(layoutGridWindowSize.getWidth(), context), DpKt.pixel2Dp(layoutGridWindowSize.getHeight(), context)), new LayoutGridWindowSize(layoutGridWindowSize));
            LayoutGridSystem layoutGridSystem = new LayoutGridSystem(context, windowStatus.windowSizeClass(), layoutGridWindowSize.getWidth());
            if (ResponsiveUI.f9315a) {
                Log.d("ResponsiveUI", "[init]: " + windowStatus);
                Log.d("ResponsiveUI", "[init]: " + layoutGridSystem);
            }
            return new ResponsiveUIProxy(layoutGridSystem, windowStatus);
        }

        private Companion() {
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9315a = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("ResponsiveUI", 3);
    }
}
