package com.coui.component.responsiveui.layoutgrid;

import D2.g;
import D2.k;
import H2.d;
import a2.AbstractC0226a;
import android.content.Context;
import android.util.Log;
import com.coui.component.responsiveui.ResponsiveUILog;
import com.coui.component.responsiveui.unit.Dp;
import com.coui.component.responsiveui.unit.DpKt;
import com.coui.component.responsiveui.window.WindowSizeClass;
import com.coui.component.responsiveui.window.WindowTotalSizeClass;

/* loaded from: classes.dex */
public final class LayoutGridSystem implements ILayoutGrid {
    public static final Companion Companion = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final boolean f9336h;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f9337a;

    /* renamed from: b, reason: collision with root package name */
    private int f9338b;

    /* renamed from: c, reason: collision with root package name */
    private int f9339c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutGrid f9340d;

    /* renamed from: e, reason: collision with root package name */
    private MarginType f9341e;

    /* renamed from: f, reason: collision with root package name */
    private IColumnsWidthCalculator f9342f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9343g;

    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    static {
        ResponsiveUILog responsiveUILog = ResponsiveUILog.INSTANCE;
        f9336h = responsiveUILog.getLOG_DEBUG() || responsiveUILog.isLoggable("LayoutGridSystem", 3);
    }

    public LayoutGridSystem(Context context, WindowSizeClass windowSizeClass, int i3) {
        k.e(context, "context");
        k.e(windowSizeClass, "windowSizeClass");
        this.f9337a = new int[MarginType.values().length];
        this.f9341e = MarginType.MARGIN_LARGE;
        this.f9342f = new AccumulationCalculator();
        rebuild(context, windowSizeClass, i3);
    }

    private final LayoutGrid a(Context context, WindowTotalSizeClass windowTotalSizeClass, IColumnsWidthCalculator iColumnsWidthCalculator) {
        int i3 = k.a(windowTotalSizeClass, WindowTotalSizeClass.Compact) ? 4 : k.a(windowTotalSizeClass, WindowTotalSizeClass.MediumLandScape) ? true : k.a(windowTotalSizeClass, WindowTotalSizeClass.MediumPortrait) ? true : k.a(windowTotalSizeClass, WindowTotalSizeClass.MediumSquare) ? true : k.a(windowTotalSizeClass, WindowTotalSizeClass.ExpandedLandPortrait) ? true : k.a(windowTotalSizeClass, WindowTotalSizeClass.ExpandedPortrait) ? 8 : 12;
        MarginType[] values = MarginType.values();
        int length = values.length;
        int[][] iArr = new int[length][];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = new int[i3];
        }
        if (this.f9343g) {
            Dp pixel2Dp = DpKt.pixel2Dp(this.f9339c, context);
            int length2 = values.length;
            Dp[] dpArr = new Dp[length2];
            for (int i5 = 0; i5 < length2; i5++) {
                dpArr[i5] = DpKt.pixel2Dp(this.f9337a[i5], context);
            }
            Dp pixel2Dp2 = DpKt.pixel2Dp(this.f9338b, context);
            Dp[][] dpArr2 = new Dp[length2][];
            for (int i6 = 0; i6 < length2; i6++) {
                dpArr2[i6] = iColumnsWidthCalculator.calculate(pixel2Dp, dpArr[i6], pixel2Dp2, i3);
            }
            for (MarginType marginType : values) {
                for (int i7 = 0; i7 < i3; i7++) {
                    iArr[marginType.ordinal()][i7] = (int) dpArr2[marginType.ordinal()][i7].toPixel(context);
                }
            }
        } else {
            for (MarginType marginType2 : values) {
                iArr[marginType2.ordinal()] = iColumnsWidthCalculator.calculate(this.f9339c, this.f9337a[marginType2.ordinal()], this.f9338b, i3);
            }
        }
        LayoutGrid layoutGrid = new LayoutGrid(i3, iArr, this.f9338b, this.f9337a);
        if (f9336h) {
            Log.d("LayoutGridSystem", "[calculateLayoutGrid] widthSizeClass: " + windowTotalSizeClass + ", layoutGridWindowWidth: " + this.f9339c + ", " + layoutGrid);
        }
        return layoutGrid;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[][] allColumnWidth() {
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getColumnsWidth();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] allMargin() {
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getMargin();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public ILayoutGrid chooseMargin(MarginType marginType) {
        k.e(marginType, "marginType");
        this.f9341e = marginType;
        return this;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int columnCount() {
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getColumnCount();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int[] columnWidth() {
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getColumnsWidth()[this.f9341e.ordinal()];
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int gutter() {
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getGutter();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int layoutGridWindowWidth() {
        return this.f9339c;
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int margin() {
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        return layoutGrid.getMargin()[this.f9341e.ordinal()];
    }

    public final void rebuild(Context context, WindowSizeClass windowSizeClass, int i3) {
        k.e(context, "context");
        k.e(windowSizeClass, "windowSizeClass");
        for (MarginType marginType : MarginType.values()) {
            int[] iArr = this.f9337a;
            int ordinal = marginType.ordinal();
            WindowTotalSizeClass windowTotalSizeClass = windowSizeClass.getWindowTotalSizeClass();
            iArr[ordinal] = k.a(windowTotalSizeClass, WindowTotalSizeClass.Compact) ? context.getResources().getDimensionPixelSize(marginType.resId()[0]) : k.a(windowTotalSizeClass, WindowTotalSizeClass.Expanded) ? context.getResources().getDimensionPixelSize(marginType.resId()[2]) : context.getResources().getDimensionPixelSize(marginType.resId()[1]);
        }
        this.f9338b = k.a(windowSizeClass.getWindowTotalSizeClass(), WindowTotalSizeClass.Expanded) ? context.getResources().getDimensionPixelSize(AbstractC0226a.f3343d) : context.getResources().getDimensionPixelSize(AbstractC0226a.f3342c);
        this.f9339c = i3;
        this.f9340d = a(context, windowSizeClass.getWindowTotalSizeClass(), this.f9342f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("layout-grid width = ");
        sb.append(this.f9339c);
        sb.append(", current margin = ");
        sb.append(margin());
        sb.append(", all margin = ");
        sb.append(allMargin());
        sb.append(", ");
        LayoutGrid layoutGrid = this.f9340d;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        sb.append(layoutGrid);
        return sb.toString();
    }

    @Override // com.coui.component.responsiveui.layoutgrid.ILayoutGrid
    public int width(int i3, int i4) {
        int c3 = d.c(i3, i4);
        int b3 = d.b(i3, i4);
        if (c3 < 0) {
            throw new IllegalArgumentException("column index must not be negative");
        }
        LayoutGrid layoutGrid = this.f9340d;
        LayoutGrid layoutGrid2 = null;
        if (layoutGrid == null) {
            k.n("layoutGrid");
            layoutGrid = null;
        }
        if (b3 >= layoutGrid.getColumnCount()) {
            StringBuilder sb = new StringBuilder();
            sb.append("column index must be less than ");
            LayoutGrid layoutGrid3 = this.f9340d;
            if (layoutGrid3 == null) {
                k.n("layoutGrid");
            } else {
                layoutGrid2 = layoutGrid3;
            }
            sb.append(layoutGrid2.getColumnCount());
            throw new IllegalArgumentException(sb.toString());
        }
        int i5 = b3 - c3;
        LayoutGrid layoutGrid4 = this.f9340d;
        if (layoutGrid4 == null) {
            k.n("layoutGrid");
            layoutGrid4 = null;
        }
        int gutter = i5 * layoutGrid4.getGutter();
        if (c3 <= b3) {
            while (true) {
                LayoutGrid layoutGrid5 = this.f9340d;
                if (layoutGrid5 == null) {
                    k.n("layoutGrid");
                    layoutGrid5 = null;
                }
                gutter += layoutGrid5.getColumnsWidth()[this.f9341e.ordinal()][c3];
                if (c3 == b3) {
                    break;
                }
                c3++;
            }
        }
        return gutter;
    }
}
