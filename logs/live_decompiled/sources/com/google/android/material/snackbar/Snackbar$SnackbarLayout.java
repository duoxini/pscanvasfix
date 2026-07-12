package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* loaded from: classes.dex */
public final class Snackbar$SnackbarLayout extends BaseTransientBottomBar.b {
    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getLayoutParams().width == -1) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
            }
        }
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
    public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
        super.setBackground(drawable);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
        super.setBackgroundTintList(colorStateList);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
    public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
        super.setBackgroundTintMode(mode);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
    public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.b, android.view.View
    public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }
}
