package com.coui.appcompat.dialog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.C0251z;

/* loaded from: classes.dex */
public class COUIAlertDialogMessageView extends C0251z implements ViewTreeObserver.OnGlobalLayoutListener {
    public COUIAlertDialogMessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        setGravity(getLineCount() > 1 ? 8388611 : 17);
    }
}
