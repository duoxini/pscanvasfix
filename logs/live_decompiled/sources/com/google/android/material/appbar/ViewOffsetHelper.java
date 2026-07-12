package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.y;

/* loaded from: classes.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;
    private boolean verticalOffsetEnabled = true;
    private boolean horizontalOffsetEnabled = true;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    void applyOffsets() {
        View view = this.view;
        y.U(view, this.offsetTop - (view.getTop() - this.layoutTop));
        View view2 = this.view;
        y.T(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean z3) {
        this.horizontalOffsetEnabled = z3;
    }

    public boolean setLeftAndRightOffset(int i3) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == i3) {
            return false;
        }
        this.offsetLeft = i3;
        applyOffsets();
        return true;
    }

    public boolean setTopAndBottomOffset(int i3) {
        if (!this.verticalOffsetEnabled || this.offsetTop == i3) {
            return false;
        }
        this.offsetTop = i3;
        applyOffsets();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z3) {
        this.verticalOffsetEnabled = z3;
    }
}
