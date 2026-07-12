package com.coui.component.responsiveui.breakpoints;

import com.coui.component.responsiveui.unit.Dp;

/* loaded from: classes.dex */
public final class Breakpoints {
    public static final Breakpoints INSTANCE = new Breakpoints();
    public static final Dp BP_MEDIUM_WINDOW_BASE_WIDTH = new Dp(600);
    public static final Dp BP_EXPANDED_WINDOW_BASE_WIDTH = new Dp(840);
    public static final Dp BP_MEDIUM_WINDOW_BASE_HEIGHT = new Dp(480);
    public static final Dp BP_EXPANDED_WINDOW_BASE_HEIGHT = new Dp(900);
    public static final Dp BP_EXPANDED_WINDOW_MAXIMUM_WIDTH = new Dp(960);

    private Breakpoints() {
    }

    public String toString() {
        return "BreakPoints Base-Width (" + BP_MEDIUM_WINDOW_BASE_WIDTH + ", " + BP_EXPANDED_WINDOW_BASE_WIDTH + "), Base-Height (" + BP_MEDIUM_WINDOW_BASE_HEIGHT + ", " + BP_EXPANDED_WINDOW_BASE_HEIGHT + "), Limited-Width (" + BP_EXPANDED_WINDOW_MAXIMUM_WIDTH + ')';
    }
}
