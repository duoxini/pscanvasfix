package com.coui.appcompat.edittext;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import e.AbstractC0339a;

/* loaded from: classes.dex */
public class COUICheckBoxPwd extends AppCompatCheckBox {
    public COUICheckBoxPwd(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC0339a.f11100o);
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.appcompat.widget.AppCompatButton";
    }

    public COUICheckBoxPwd(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setStateDescription("");
        if (TextUtils.isEmpty(getContentDescription())) {
            setContentDescription(getContext().getString(S1.e.f2107a));
        }
    }
}
