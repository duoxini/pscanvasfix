package com.coui.appcompat.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.l;
import com.coui.appcompat.checkbox.COUICheckBox;

/* loaded from: classes.dex */
public class COUICheckBoxPreferenceCategory extends COUIPreferenceCategory {

    /* renamed from: I, reason: collision with root package name */
    private int f8484I;

    public COUICheckBoxPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8484I = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2809o, 0, 0);
        this.f8484I = obtainStyledAttributes.getInteger(W1.h.f2811p, this.f8484I);
        obtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.preference.COUIPreferenceCategory, androidx.preference.PreferenceCategory, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        B(W1.e.f2702d);
        super.onBindViewHolder(lVar);
        COUICheckBox cOUICheckBox = (COUICheckBox) x().findViewById(R.id.checkbox);
        if (cOUICheckBox != null) {
            int i3 = this.f8484I;
            if (i3 != 0) {
                cOUICheckBox.setState(i3);
            }
            cOUICheckBox.setVisibility(0);
        }
    }
}
