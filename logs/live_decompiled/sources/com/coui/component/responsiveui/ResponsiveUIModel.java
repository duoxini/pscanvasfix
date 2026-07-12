package com.coui.component.responsiveui;

import D2.g;
import D2.k;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import com.coui.component.responsiveui.layoutgrid.LayoutGridSystem;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.proxy.ResponsiveUIProxy;
import com.coui.component.responsiveui.status.WindowStatus;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;

/* loaded from: classes.dex */
public final class ResponsiveUIModel {
    public static final Companion Companion = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f9328d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f9329a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutGridWindowSize f9330b;

    /* renamed from: c, reason: collision with root package name */
    private final ResponsiveUIProxy f9331c;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9328d = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("ResponsiveUIModel", 3);
    }

    public ResponsiveUIModel(Context context, LayoutGridWindowSize layoutGridWindowSize) {
        k.e(context, "mContext");
        k.e(layoutGridWindowSize, "mWindowSize");
        this.f9329a = context;
        this.f9330b = layoutGridWindowSize;
        WindowStatus windowStatus = new WindowStatus(context.getResources().getConfiguration().orientation, WindowSizeClass.Companion.calculateFromSize(DpKt.pixel2Dp(this.f9330b.getWidth(), context), DpKt.pixel2Dp(this.f9330b.getHeight(), context)), new LayoutGridWindowSize(this.f9330b));
        LayoutGridSystem layoutGridSystem = new LayoutGridSystem(context, windowStatus.windowSizeClass(), this.f9330b.getWidth());
        if (f9328d) {
            Log.d("ResponsiveUIModel", "[init]: " + windowStatus);
            Log.d("ResponsiveUIModel", "[init]: " + layoutGridSystem);
        }
        this.f9331c = new ResponsiveUIProxy(layoutGridSystem, windowStatus);
    }

    public final int[][] allColumnWidth() {
        return this.f9331c.allColumnWidth();
    }

    public final int[] allMargin() {
        return this.f9331c.allMargin();
    }

    public final int calculateGridWidth(int i3) {
        if (i3 > this.f9331c.columnCount()) {
            if (f9328d) {
                Log.w("ResponsiveUIModel", "calculateGridWidth: requested grid number larger then current grid total number, fill the whole grid");
            }
            i3 = this.f9331c.columnCount();
        }
        return this.f9331c.width((this.f9331c.columnCount() - i3) / 2, (i3 + r0) - 1);
    }

    public final ResponsiveUIModel chooseMargin(MarginType marginType) {
        k.e(marginType, "marginType");
        this.f9331c.chooseMargin(marginType);
        return this;
    }

    public final int columnCount() {
        return this.f9331c.columnCount();
    }

    public final int[] columnWidth() {
        return this.f9331c.columnWidth();
    }

    public final Context getMContext() {
        return this.f9329a;
    }

    public final LayoutGridWindowSize getMWindowSize() {
        return this.f9330b;
    }

    public final IResponsiveUI getResponsiveUI() {
        return this.f9331c;
    }

    public final int gutter() {
        return this.f9331c.gutter();
    }

    public final LayoutGridWindowSize layoutGridWindowSize() {
        return this.f9331c.layoutGridWindowSize();
    }

    public final int layoutGridWindowWidth() {
        return this.f9331c.layoutGridWindowWidth();
    }

    public final int margin() {
        return this.f9331c.margin();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        k.e(configuration, "newConfig");
        this.f9330b.setWidth((int) new Dp(configuration.screenWidthDp).toPixel(this.f9329a));
        this.f9330b.setHeight((int) new Dp(configuration.screenWidthDp).toPixel(this.f9329a));
        this.f9331c.rebuild(this.f9329a, this.f9330b);
    }

    public final ResponsiveUIModel rebuild(LayoutGridWindowSize layoutGridWindowSize) {
        k.e(layoutGridWindowSize, "windowSize");
        this.f9330b = layoutGridWindowSize;
        this.f9331c.rebuild(this.f9329a, layoutGridWindowSize);
        return this;
    }

    public final void setMWindowSize(LayoutGridWindowSize layoutGridWindowSize) {
        k.e(layoutGridWindowSize, "<set-?>");
        this.f9330b = layoutGridWindowSize;
    }

    public final String showLayoutGridInfo() {
        return this.f9331c.showLayoutGridInfo();
    }

    public final String showWindowStatusInfo() {
        return this.f9331c.showWindowStatusInfo();
    }

    public final int width(int i3, int i4) {
        return this.f9331c.width(i3, i4);
    }

    public final int windowOrientation() {
        return this.f9331c.windowOrientation();
    }

    public final WindowSizeClass windowSizeClass() {
        return this.f9331c.windowSizeClass();
    }

    public final ResponsiveUIModel rebuild(float f3, float f4) {
        this.f9330b.setWidth((int) new Dp(f3).toPixel(this.f9329a));
        this.f9330b.setHeight((int) new Dp(f4).toPixel(this.f9329a));
        this.f9331c.rebuild(this.f9329a, this.f9330b);
        return this;
    }

    public final ResponsiveUIModel rebuild(int i3, int i4) {
        this.f9330b.setWidth(i3);
        this.f9330b.setHeight(i4);
        this.f9331c.rebuild(this.f9329a, this.f9330b);
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResponsiveUIModel(Context context, float f3, float f4) {
        this(context, new LayoutGridWindowSize(context, new Dp(f3), new Dp(f4)));
        k.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ResponsiveUIModel(Context context, int i3, int i4) {
        this(context, new LayoutGridWindowSize(i3, i4));
        k.e(context, "context");
    }
}
