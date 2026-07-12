package com.coui.component.responsiveui.unit;

import D2.k;
import android.content.Context;

/* loaded from: classes.dex */
public final class DpKt {
    public static final Dp getDp(int i3) {
        return new Dp(i3);
    }

    public static final Dp pixel2Dp(int i3, Context context) {
        k.e(context, "context");
        return new Dp(i3 / context.getResources().getDisplayMetrics().density);
    }
}
