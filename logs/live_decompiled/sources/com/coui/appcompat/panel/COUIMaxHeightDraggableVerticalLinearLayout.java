package com.coui.appcompat.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class COUIMaxHeightDraggableVerticalLinearLayout extends COUIDraggableVerticalLinearLayout {
    private int mLayoutWindowVisibility;

    public COUIMaxHeightDraggableVerticalLinearLayout(Context context) {
        super(context);
    }

    public int getMaxHeight() {
        return COUIPanelMultiWindowUtils.getPanelMaxHeight(getContext(), null);
    }

    public void layoutAtMaxHeight() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = getMaxHeight();
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        if (this.mLayoutWindowVisibility == 8 && i3 == 0) {
            measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
        }
        this.mLayoutWindowVisibility = i3;
        super.onWindowVisibilityChanged(i3);
    }

    public COUIMaxHeightDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public COUIMaxHeightDraggableVerticalLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
