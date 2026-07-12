package com.coui.component.responsiveui;

import android.content.Context;
import com.coui.component.responsiveui.layoutgrid.ILayoutGrid;
import com.coui.component.responsiveui.status.IWindowStatus;
import com.coui.component.responsiveui.window.LayoutGridWindowSize;

/* loaded from: classes.dex */
public interface IResponsiveUI extends ILayoutGrid, IWindowStatus {
    void onConfigurationChanged(Context context, LayoutGridWindowSize layoutGridWindowSize);

    void rebuild(Context context, LayoutGridWindowSize layoutGridWindowSize);

    String showLayoutGridInfo();

    String showWindowStatusInfo();
}
