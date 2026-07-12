package com.google.android.material.snackbar;

import H0.c;
import H0.e;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.y;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* renamed from: e, reason: collision with root package name */
    private TextView f9757e;

    /* renamed from: f, reason: collision with root package name */
    private Button f9758f;

    /* renamed from: g, reason: collision with root package name */
    private int f9759g;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void a(View view, int i3, int i4) {
        if (y.Q(view)) {
            y.y0(view, y.C(view), i3, y.B(view), i4);
        } else {
            view.setPadding(view.getPaddingLeft(), i3, view.getPaddingRight(), i4);
        }
    }

    private boolean b(int i3, int i4, int i5) {
        boolean z3;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f9757e.getPaddingTop() == i4 && this.f9757e.getPaddingBottom() == i5) {
            return z3;
        }
        a(this.f9757e, i4, i5);
        return true;
    }

    public Button getActionView() {
        return this.f9758f;
    }

    public TextView getMessageView() {
        return this.f9757e;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f9757e = (TextView) findViewById(e.f558H);
        this.f9758f = (Button) findViewById(e.f557G);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(c.f523f);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(c.f522e);
        boolean z3 = this.f9757e.getLayout().getLineCount() > 1;
        if (!z3 || this.f9759g <= 0 || this.f9758f.getMeasuredWidth() <= this.f9759g) {
            if (!z3) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!b(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!b(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i3, i4);
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f9759g = i3;
    }
}
