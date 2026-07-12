package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;

/* loaded from: classes.dex */
public class COUICustomListSelectedLinearLayout extends COUICardListSelectedItemLayout {

    /* renamed from: H, reason: collision with root package name */
    private boolean f8511H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f8512I;

    /* renamed from: J, reason: collision with root package name */
    private int f8513J;

    /* renamed from: K, reason: collision with root package name */
    private int f8514K;

    public COUICustomListSelectedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8511H = false;
        q(context, attributeSet);
    }

    private int p(TextView textView, int i3, int i4, float[] fArr) {
        if (i4 == 0 || textView == null || textView.getVisibility() != 0 || TextUtils.isEmpty(textView.getText())) {
            return i4;
        }
        int lineCount = textView.getLayout().getLineCount();
        if (i4 != 2) {
            if (i4 != 1) {
                return i4;
            }
            fArr[1] = i3 + r4.getLineBottom(0);
            return i4 - 1;
        }
        fArr[0] = r4.getLineTop(0) + i3;
        int i5 = i4 - 1;
        if (lineCount < 2) {
            return i5;
        }
        fArr[1] = i3 + r4.getLineBottom(1);
        return i4 - 2;
    }

    private void q(Context context, AttributeSet attributeSet) {
        setOrientation(0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2823v);
        this.f8511H = obtainStyledAttributes.getBoolean(W1.h.f2825w, false);
        obtainStyledAttributes.recycle();
        this.f8513J = getContext().getResources().getDimensionPixelSize(W1.c.f2631V);
        this.f8514K = getContext().getResources().getDimensionPixelSize(W1.c.f2628S);
    }

    private boolean r() {
        AppCompatImageView appCompatImageView;
        int i3;
        int i4;
        int i5;
        int i6;
        int p3;
        View findViewById = findViewById(W1.d.f2696x);
        if (findViewById == null || findViewById.getVisibility() != 0 || (appCompatImageView = (AppCompatImageView) findViewById(R.id.icon)) == null) {
            return false;
        }
        boolean z3 = findViewById(W1.d.f2661C) != null;
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.summary);
        if (textView == null || textView.getVisibility() != 0) {
            i3 = 0;
            i4 = 0;
        } else {
            i4 = textView.getLineCount();
            i3 = textView.getMeasuredHeight() + this.f8514K;
        }
        if (textView2 == null || textView2.getVisibility() != 0) {
            i5 = 0;
            i6 = 0;
        } else {
            i6 = textView2.getLineCount();
            i5 = textView2.getMeasuredHeight() + this.f8514K;
        }
        TextView textView3 = (TextView) findViewById(W1.d.f2674b);
        int lineCount = (z3 || textView3 == null || textView3.getVisibility() != 0) ? 0 : textView3.getLineCount();
        if (this.f8512I) {
            p3 = y0.j.p(getContext(), appCompatImageView.getMeasuredHeight());
        } else {
            p3 = y0.j.p(getContext(), appCompatImageView.getDrawable() != null ? appCompatImageView.getDrawable().getIntrinsicHeight() : 0);
        }
        int i7 = i4 + i6 + lineCount;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
        if (i7 > 2) {
            t(layoutParams, i3, i5, findViewById);
        } else {
            s(layoutParams, p3, i7);
        }
        findViewById.setLayoutParams(layoutParams);
        return true;
    }

    private void s(LinearLayout.LayoutParams layoutParams, int i3, int i4) {
        layoutParams.gravity = 16;
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(W1.c.f2611B);
        if (i3 == 24) {
            dimensionPixelSize = i4 <= 1 ? getContext().getResources().getDimensionPixelSize(W1.c.f2643k) : getContext().getResources().getDimensionPixelSize(W1.c.f2642j);
        } else if (i3 == 32) {
            dimensionPixelSize = i4 <= 1 ? getContext().getResources().getDimensionPixelSize(W1.c.f2645m) : getContext().getResources().getDimensionPixelSize(W1.c.f2644l);
        } else if (i3 == 36) {
            dimensionPixelSize = i4 <= 1 ? getContext().getResources().getDimensionPixelSize(W1.c.f2647o) : getContext().getResources().getDimensionPixelSize(W1.c.f2646n);
        } else if (i3 == 50) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(W1.c.f2648p);
        }
        if (layoutParams.topMargin == dimensionPixelSize && layoutParams.bottomMargin == dimensionPixelSize) {
            return;
        }
        layoutParams.topMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize;
    }

    private void t(LinearLayout.LayoutParams layoutParams, int i3, int i4, View view) {
        layoutParams.gravity = 48;
        float[] fArr = new float[2];
        int i5 = this.f8513J;
        int i6 = i5 + i3;
        p((TextView) findViewById(W1.d.f2674b), i3 + i5 + i4, p((TextView) findViewById(R.id.summary), i6, p((TextView) findViewById(R.id.title), i5, 2, fArr), fArr), fArr);
        int max = Math.max((int) (((fArr[0] + fArr[1]) / 2.0f) - (view.getMeasuredHeight() / 2.0f)), getContext().getResources().getDimensionPixelSize(W1.c.f2648p));
        if (layoutParams.topMargin != max) {
            layoutParams.topMargin = max;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (r()) {
            super.onMeasure(i3, i4);
        }
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8511H) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIconMarginDependOnImageView(boolean z3) {
        this.f8512I = z3;
    }
}
