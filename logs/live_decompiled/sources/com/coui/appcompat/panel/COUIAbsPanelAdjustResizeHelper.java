package com.coui.appcompat.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class COUIAbsPanelAdjustResizeHelper {
    private boolean mCouiPanelEdgeToEdgeEnable;

    protected COUIAbsPanelAdjustResizeHelper() {
    }

    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z3) {
    }

    public int getMarginBottomValue() {
        return -1;
    }

    public int getPaddingBottomOffset() {
        return -1;
    }

    public float getTranslateOffset() {
        return -1.0f;
    }

    public int getWindowType() {
        return -1;
    }

    public boolean isCouiPanelEdgeToEdgeEnable() {
        return this.mCouiPanelEdgeToEdgeEnable;
    }

    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
    }

    public boolean releaseData() {
        return false;
    }

    public void resetInnerStatus() {
    }

    public void setCouiPanelEdgeToEdgeEnable(boolean z3) {
        this.mCouiPanelEdgeToEdgeEnable = z3;
    }

    public void setIgnoreHideKeyboardAnim(boolean z3) {
    }

    public void setWindowType(int i3) {
    }
}
