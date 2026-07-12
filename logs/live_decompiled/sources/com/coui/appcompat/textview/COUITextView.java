package com.coui.appcompat.textview;

import M1.m;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.appcompat.widget.C0251z;

/* loaded from: classes.dex */
public class COUITextView extends C0251z {

    /* renamed from: e, reason: collision with root package name */
    private final Context f9269e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9270f;

    public COUITextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void b(Resources.Theme theme, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i3, m.f1593z0);
        float f3 = obtainStyledAttributes.getFloat(m.f1510A0, 1.0f);
        if (f3 >= 1.0f) {
            setLineSpacing(0.0f, f3);
        }
        obtainStyledAttributes.recycle();
    }

    private static int c(Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, m.f1512B0, i3, i4);
        int resourceId = obtainStyledAttributes.getResourceId(m.f1514C0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static boolean d(Context context, Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, m.f1512B0, i3, i4);
        float f3 = obtainStyledAttributes.getFloat(m.f1516D0, 1.0f);
        obtainStyledAttributes.recycle();
        return f3 != 1.0f;
    }

    public void setDebug(Boolean bool) {
        this.f9270f = bool.booleanValue();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        b(this.f9269e.getTheme(), i3);
    }

    public COUITextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int c3;
        this.f9270f = false;
        this.f9269e = context;
        if ("debug".equals((String) getTag())) {
            setDebug(Boolean.TRUE);
        }
        if (!d(context, context.getTheme(), attributeSet, i3, -1) && (c3 = c(context.getTheme(), attributeSet, i3, -1)) != -1) {
            b(context.getTheme(), c3);
        }
        if (this.f9270f) {
            int fontMetricsInt = getPaint().getFontMetricsInt(null);
            Log.i("COUITextViewDebug", "textSize: " + getTextSize() + ", lineHeight: " + getLineHeight() + ", fontHeight: " + fontMetricsInt + ", Multiplier: " + getLineSpacingMultiplier());
        }
    }
}
