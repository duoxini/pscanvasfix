package com.coui.appcompat.panel;

/* loaded from: classes.dex */
public interface COUIPanelPullUpListener {
    void onCancel();

    int onDragging(int i3, int i4);

    void onDraggingPanel();

    void onOffsetChanged(float f3);

    void onReleased(int i3);

    void onReleasedDrag();
}
