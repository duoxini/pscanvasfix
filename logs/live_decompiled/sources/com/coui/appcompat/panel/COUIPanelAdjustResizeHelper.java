package com.coui.appcompat.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class COUIPanelAdjustResizeHelper {
    private COUIAbsPanelAdjustResizeHelper mAdjustHelper = new COUIPanelAdjustResizeHelperAfterR();

    public void adjustResize(Context context, ViewGroup viewGroup, WindowInsets windowInsets, View view, boolean z3) {
        this.mAdjustHelper.adjustResize(context, viewGroup, windowInsets, view, z3);
    }

    public int getMarginBottomValue() {
        return this.mAdjustHelper.getMarginBottomValue();
    }

    public int getPaddingBottomOffset() {
        return this.mAdjustHelper.getPaddingBottomOffset();
    }

    public float getTranslateOffset() {
        return this.mAdjustHelper.getTranslateOffset();
    }

    public int getWindowType() {
        return this.mAdjustHelper.getWindowType();
    }

    public void recoveryScrollingParentViewPaddingBottom(COUIPanelContentLayout cOUIPanelContentLayout) {
        this.mAdjustHelper.recoveryScrollingParentViewPaddingBottom(cOUIPanelContentLayout);
    }

    public boolean releaseData() {
        return this.mAdjustHelper.releaseData();
    }

    public void resetInnerStatus() {
        this.mAdjustHelper.resetInnerStatus();
    }

    public void setCouiPanelEdgeToEdgeEnable(boolean z3) {
        this.mAdjustHelper.setCouiPanelEdgeToEdgeEnable(z3);
    }

    public void setIgnoreHideKeyboardAnim(boolean z3) {
        this.mAdjustHelper.setIgnoreHideKeyboardAnim(z3);
    }

    public void setWindowType(int i3) {
        this.mAdjustHelper.setWindowType(i3);
    }
}
