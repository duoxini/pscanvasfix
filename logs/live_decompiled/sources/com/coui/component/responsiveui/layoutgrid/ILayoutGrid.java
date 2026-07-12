package com.coui.component.responsiveui.layoutgrid;

/* loaded from: classes.dex */
public interface ILayoutGrid {
    int[][] allColumnWidth();

    int[] allMargin();

    ILayoutGrid chooseMargin(MarginType marginType);

    int columnCount();

    int[] columnWidth();

    int gutter();

    int layoutGridWindowWidth();

    int margin();

    int width(int i3, int i4);
}
