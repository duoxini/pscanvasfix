package com.google.android.material.textview;

import H0.a;
import H0.j;
import R0.b;
import R0.c;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.C0251z;

/* loaded from: classes.dex */
public class MaterialTextView extends C0251z {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void b(Resources.Theme theme, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i3, j.P3);
        int e3 = e(getContext(), obtainStyledAttributes, j.R3, j.S3);
        obtainStyledAttributes.recycle();
        if (e3 >= 0) {
            setLineHeight(e3);
        }
    }

    private static boolean c(Context context) {
        return b.b(context, a.f465F, true);
    }

    private static int d(Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, j.T3, i3, i4);
        int resourceId = obtainStyledAttributes.getResourceId(j.U3, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int e(Context context, TypedArray typedArray, int... iArr) {
        int i3 = -1;
        for (int i4 = 0; i4 < iArr.length && i3 < 0; i4++) {
            i3 = c.c(context, typedArray, iArr[i4], -1);
        }
        return i3;
    }

    private static boolean f(Context context, Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, j.T3, i3, i4);
        int e3 = e(context, obtainStyledAttributes, j.V3, j.W3);
        obtainStyledAttributes.recycle();
        return e3 != -1;
    }

    @Override // androidx.appcompat.widget.C0251z, android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        if (c(context)) {
            b(context.getTheme(), i3);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(V0.a.c(context, attributeSet, i3, i4), attributeSet, i3);
        int d3;
        Context context2 = getContext();
        if (c(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (f(context2, theme, attributeSet, i3, i4) || (d3 = d(theme, attributeSet, i3, i4)) == -1) {
                return;
            }
            b(theme, d3);
        }
    }
}
