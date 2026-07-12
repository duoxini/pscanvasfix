package com.coui.component.responsiveui.proxy;

import D2.g;
import D2.k;
import android.content.Context;
import android.util.Log;
import com.coui.component.responsiveui.IResponsiveUI;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.layoutgrid.ILayoutGrid;
import com.coui.component.responsiveui.layoutgrid.LayoutGridSystem;
import com.coui.component.responsiveui.layoutgrid.MarginType;
import com.coui.component.responsiveui.status.IWindowStatus;
import com.coui.component.responsiveui.status.WindowStatus;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;
import com.coui.component.responsiveui.window.WindowSizeClass;

/* loaded from: classes.dex */
public final class ResponsiveUIProxy implements IResponsiveUI, ILayoutGrid, IWindowStatus {
    public static final Companion Companion = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f9346e;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ LayoutGridSystem f9347a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ WindowStatus f9348b;

    /* renamed from: c, reason: collision with root package name */
    private final WindowStatus f9349c;

    /* renamed from: d, reason: collision with root package name */
    private final LayoutGridSystem f9350d;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9346e = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("ResponsiveUIProxy", 3);
    }

    public ResponsiveUIProxy(LayoutGridSystem layoutGridSystem, WindowStatus windowStatus) {
        k.e(layoutGridSystem, "layoutGridSystem");
        k.e(windowStatus, "windowStatus");
        this.f9347a = layoutGridSystem;
        this.f9348b = windowStatus;
        this.f9349c = windowStatus;
        this.f9350d = layoutGridSystem;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[][] allColumnWidth() {
        return this.f9347a.allColumnWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] allMargin() {
        return this.f9347a.allMargin();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public ILayoutGrid chooseMargin(MarginType marginType) {
        k.e(marginType, "marginType");
        return this.f9347a.chooseMargin(marginType);
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int columnCount() {
        return this.f9347a.columnCount();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] columnWidth() {
        return this.f9347a.columnWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int gutter() {
        return this.f9347a.gutter();
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public LayoutGridWindowSize layoutGridWindowSize() {
        return this.f9348b.layoutGridWindowSize();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int layoutGridWindowWidth() {
        return this.f9347a.layoutGridWindowWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int margin() {
        return this.f9347a.margin();
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public void onConfigurationChanged(Context context, LayoutGridWindowSize layoutGridWindowSize) {
        k.e(context, "context");
        k.e(layoutGridWindowSize, "windowSize");
        rebuild(context, layoutGridWindowSize);
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public void rebuild(Context context, LayoutGridWindowSize layoutGridWindowSize) {
        k.e(context, "context");
        k.e(layoutGridWindowSize, "windowSize");
        WindowStatus windowStatus = this.f9349c;
        windowStatus.setOrientation(context.getResources().getConfiguration().orientation);
        windowStatus.setLayoutGridWindowSize(layoutGridWindowSize);
        windowStatus.setWindowSizeClass(WindowSizeClass.Companion.calculateFromSize(DpKt.pixel2Dp(layoutGridWindowSize.getWidth(), context), DpKt.pixel2Dp(layoutGridWindowSize.getHeight(), context)));
        this.f9350d.rebuild(context, this.f9349c.getWindowSizeClass(), layoutGridWindowSize.getWidth());
        if (f9346e) {
            Log.d("ResponsiveUIProxy", "[rebuild]: " + this.f9349c);
            Log.d("ResponsiveUIProxy", "[rebuild]: " + this.f9350d);
        }
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public String showLayoutGridInfo() {
        return String.valueOf(this.f9350d);
    }

    @Override // com.coui.component.responsiveui.IResponsiveUI
    public String showWindowStatusInfo() {
        return String.valueOf(this.f9349c);
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int width(int i3, int i4) {
        return this.f9347a.width(i3, i4);
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public int windowOrientation() {
        return this.f9348b.windowOrientation();
    }

    @Override // com.coui.component.responsiveui.status.IWindowStatus
    public WindowSizeClass windowSizeClass() {
        return this.f9348b.windowSizeClass();
    }
}
