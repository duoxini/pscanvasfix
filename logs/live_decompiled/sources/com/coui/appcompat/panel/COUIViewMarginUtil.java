package com.coui.appcompat.panel;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class COUIViewMarginUtil {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_SIZE = 4;
    public static final int DIRECTION_TOP = 1;

    public static int getMargin(View view, int i3) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (i3 == 0) {
                    return ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                }
                if (i3 == 1) {
                    return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                }
                if (i3 == 2) {
                    return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                if (i3 != 3) {
                    return 0;
                }
                return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
        return 0;
    }

    public static int[] getMargins(View view) {
        int[] iArr = new int[4];
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                iArr[0] = marginLayoutParams.leftMargin;
                iArr[1] = marginLayoutParams.topMargin;
                iArr[2] = marginLayoutParams.rightMargin;
                iArr[3] = marginLayoutParams.bottomMargin;
            }
        }
        return iArr;
    }

    public static void setMargin(View view, int i3, int i4) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                if (i3 == 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i4;
                } else if (i3 == 1) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i4;
                } else if (i3 == 2) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i4;
                } else if (i3 == 3) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i4;
                }
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public static void setMargins(View view, int[] iArr) {
        if (view == null || iArr == null || iArr.length != 4) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = iArr[0];
            marginLayoutParams.topMargin = iArr[1];
            marginLayoutParams.rightMargin = iArr[2];
            marginLayoutParams.bottomMargin = iArr[3];
            view.setLayoutParams(layoutParams);
        }
    }
}
