package com.coui.appcompat.panel;

import U1.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class IgnoreWindowInsetsFrameLayout extends FrameLayout {
    private boolean mCouiPanelEdgeToEdgeEnable;
    private boolean mIsIgnoreWindowInsetsBottom;
    private boolean mIsIgnoreWindowInsetsLeft;
    private boolean mIsIgnoreWindowInsetsRight;
    private boolean mIsIgnoreWindowInsetsTop;
    private int mWindowInsetsBottomOffset;
    private int mWindowInsetsLeftOffset;
    private int mWindowInsetsRightOffset;
    private int mWindowInsetsTopOffset;

    public IgnoreWindowInsetsFrameLayout(Context context) {
        super(context);
        this.mIsIgnoreWindowInsetsLeft = true;
        this.mIsIgnoreWindowInsetsTop = true;
        this.mIsIgnoreWindowInsetsRight = true;
        this.mIsIgnoreWindowInsetsBottom = true;
    }

    private void initAttr(AttributeSet attributeSet) {
        if (getContext() != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, i.f2448r);
            this.mIsIgnoreWindowInsetsLeft = obtainStyledAttributes.getBoolean(i.f2450t, true);
            this.mIsIgnoreWindowInsetsTop = obtainStyledAttributes.getBoolean(i.f2452v, true);
            this.mIsIgnoreWindowInsetsRight = obtainStyledAttributes.getBoolean(i.f2451u, true);
            this.mIsIgnoreWindowInsetsBottom = obtainStyledAttributes.getBoolean(i.f2449s, true);
            obtainStyledAttributes.recycle();
            if (COUINavigationBarUtil.isGestureNavigation(getContext())) {
                return;
            }
            this.mIsIgnoreWindowInsetsBottom = false;
            setFitsSystemWindows(false);
            setClipToPadding(true);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int max;
        int i3 = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        int max2 = this.mIsIgnoreWindowInsetsLeft ? 0 : Math.max(0, windowInsets.getSystemWindowInsetLeft() + this.mWindowInsetsLeftOffset);
        int max3 = this.mIsIgnoreWindowInsetsTop ? 0 : Math.max(0, windowInsets.getSystemWindowInsetTop() + this.mWindowInsetsTopOffset);
        int max4 = this.mIsIgnoreWindowInsetsRight ? 0 : Math.max(0, windowInsets.getSystemWindowInsetRight() + this.mWindowInsetsRightOffset);
        if (this.mIsIgnoreWindowInsetsBottom) {
            max = 0;
        } else {
            if (this.mCouiPanelEdgeToEdgeEnable) {
                i3 = 0;
            }
            max = Math.max(0, i3 + this.mWindowInsetsBottomOffset);
        }
        setPadding(max2, max3, max4, max);
        this.mWindowInsetsLeftOffset = 0;
        this.mWindowInsetsTopOffset = 0;
        this.mWindowInsetsRightOffset = 0;
        this.mWindowInsetsBottomOffset = 0;
        return windowInsets.consumeSystemWindowInsets();
    }

    void setCouiPanelEdgeToEdgeEnable(boolean z3) {
        this.mCouiPanelEdgeToEdgeEnable = z3;
    }

    public void setIgnoreWindowInsetsBottom(boolean z3) {
        this.mIsIgnoreWindowInsetsBottom = z3;
    }

    public void setIgnoreWindowInsetsLeft(boolean z3) {
        this.mIsIgnoreWindowInsetsLeft = z3;
    }

    public void setIgnoreWindowInsetsRight(boolean z3) {
        this.mIsIgnoreWindowInsetsRight = z3;
    }

    public void setIgnoreWindowInsetsTop(boolean z3) {
        this.mIsIgnoreWindowInsetsTop = z3;
    }

    public void setWindowInsetsBottomOffset(int i3) {
        this.mWindowInsetsBottomOffset = i3;
    }

    public void setWindowInsetsLeftOffset(int i3) {
        this.mWindowInsetsLeftOffset = i3;
    }

    public void setWindowInsetsRightOffset(int i3) {
        this.mWindowInsetsRightOffset = i3;
    }

    public void setWindowInsetsTopOffset(int i3) {
        this.mWindowInsetsTopOffset = i3;
    }

    public IgnoreWindowInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsIgnoreWindowInsetsLeft = true;
        this.mIsIgnoreWindowInsetsTop = true;
        this.mIsIgnoreWindowInsetsRight = true;
        this.mIsIgnoreWindowInsetsBottom = true;
        initAttr(attributeSet);
    }

    public IgnoreWindowInsetsFrameLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mIsIgnoreWindowInsetsLeft = true;
        this.mIsIgnoreWindowInsetsTop = true;
        this.mIsIgnoreWindowInsetsRight = true;
        this.mIsIgnoreWindowInsetsBottom = true;
        initAttr(attributeSet);
    }
}
