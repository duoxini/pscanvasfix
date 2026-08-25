package com.color.pscanvasfix.compat;

/** Pure gate for the verified 260608 panorama-entry gesture. */
public final class PanoramaModeCompat {
    private PanoramaModeCompat() {
    }

    /** 502 keeps layout 3; its wide canvas is produced by equal-width column bounds. */
    public static int to502CanvasLayout(int appCount, int layout) {
        return layout;
    }

    /** Width used by the 502 portrait columns shown two-at-a-time on a landscape screen. */
    public static int equalColumnWidth(int columnHeight) {
        return Math.max(1, Math.round(columnHeight * (2.0f / 3.0f)));
    }

    public static boolean shouldEnterFromPinch(int appCount, int layout) {
        // 260608 keeps n() at 3 after the three-float-window -> 2+1 return.
        return appCount == 3 && layout >= 3 && layout <= 7;
    }

}
