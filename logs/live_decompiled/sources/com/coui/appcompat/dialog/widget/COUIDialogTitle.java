package com.coui.appcompat.dialog.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0251z;
import e.j;

/* loaded from: classes.dex */
public class COUIDialogTitle extends C0251z {
    public COUIDialogTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.appcompat.widget.C0251z, android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        int lineCount;
        super.onMeasure(i3, i4);
        Layout layout = getLayout();
        if (layout == null || (lineCount = layout.getLineCount()) <= 0 || layout.getEllipsisCount(lineCount - 1) <= 0) {
            return;
        }
        setSingleLine(false);
        setMaxLines(3);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, j.f11329S2, R.attr.textAppearanceMedium, R.style.TextAppearance.Medium);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f11333T2, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        super.onMeasure(i3, i4);
    }
}
