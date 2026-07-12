package com.coui.component.responsiveui.layoutgrid;

import D2.k;
import K2.e;
import java.util.Arrays;
import q2.AbstractC0538h;

/* loaded from: classes.dex */
final class LayoutGrid {

    /* renamed from: a, reason: collision with root package name */
    private int f9332a;

    /* renamed from: b, reason: collision with root package name */
    private int[][] f9333b;

    /* renamed from: c, reason: collision with root package name */
    private int f9334c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f9335d;

    public LayoutGrid(int i3, int[][] iArr, int i4, int[] iArr2) {
        k.e(iArr, "columnsWidth");
        k.e(iArr2, "margin");
        this.f9332a = i3;
        this.f9333b = iArr;
        this.f9334c = i4;
        this.f9335d = iArr2;
    }

    public static /* synthetic */ LayoutGrid copy$default(LayoutGrid layoutGrid, int i3, int[][] iArr, int i4, int[] iArr2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = layoutGrid.f9332a;
        }
        if ((i5 & 2) != 0) {
            iArr = layoutGrid.f9333b;
        }
        if ((i5 & 4) != 0) {
            i4 = layoutGrid.f9334c;
        }
        if ((i5 & 8) != 0) {
            iArr2 = layoutGrid.f9335d;
        }
        return layoutGrid.copy(i3, iArr, i4, iArr2);
    }

    public final int component1() {
        return this.f9332a;
    }

    public final int[][] component2() {
        return this.f9333b;
    }

    public final int component3() {
        return this.f9334c;
    }

    public final int[] component4() {
        return this.f9335d;
    }

    public final LayoutGrid copy(int i3, int[][] iArr, int i4, int[] iArr2) {
        k.e(iArr, "columnsWidth");
        k.e(iArr2, "margin");
        return new LayoutGrid(i3, iArr, i4, iArr2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!k.a(LayoutGrid.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        k.c(obj, "null cannot be cast to non-null type com.coui.component.responsiveui.layoutgrid.LayoutGrid");
        LayoutGrid layoutGrid = (LayoutGrid) obj;
        return this.f9332a == layoutGrid.f9332a && AbstractC0538h.d(this.f9333b, layoutGrid.f9333b) && this.f9334c == layoutGrid.f9334c && Arrays.equals(this.f9335d, layoutGrid.f9335d);
    }

    public final int getColumnCount() {
        return this.f9332a;
    }

    public final int[][] getColumnsWidth() {
        return this.f9333b;
    }

    public final int getGutter() {
        return this.f9334c;
    }

    public final int[] getMargin() {
        return this.f9335d;
    }

    public int hashCode() {
        return (((((this.f9332a * 31) + AbstractC0538h.b(this.f9333b)) * 31) + this.f9334c) * 31) + Arrays.hashCode(this.f9335d);
    }

    public final void setColumnCount(int i3) {
        this.f9332a = i3;
    }

    public final void setColumnsWidth(int[][] iArr) {
        k.e(iArr, "<set-?>");
        this.f9333b = iArr;
    }

    public final void setGutter(int i3) {
        this.f9334c = i3;
    }

    public final void setMargin(int[] iArr) {
        k.e(iArr, "<set-?>");
        this.f9335d = iArr;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[LayoutGrid] columnCount = " + this.f9332a + ", ");
        stringBuffer.append("gutter = " + this.f9334c + ", ");
        stringBuffer.append("margins = " + AbstractC0538h.e(this.f9335d) + ", ");
        stringBuffer.append("columnWidth = [");
        for (int[] iArr : this.f9333b) {
            stringBuffer.append(AbstractC0538h.e(iArr).toString());
            stringBuffer.append(", ");
        }
        k.d(stringBuffer, "value");
        stringBuffer.delete(e.z(stringBuffer) - 1, e.z(stringBuffer) + 1);
        stringBuffer.append("]");
        String stringBuffer2 = stringBuffer.toString();
        k.d(stringBuffer2, "value.toString()");
        return stringBuffer2;
    }
}
