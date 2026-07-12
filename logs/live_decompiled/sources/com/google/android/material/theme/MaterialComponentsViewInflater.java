package com.google.android.material.theme;

import K0.a;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.l;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.C0230d;
import androidx.appcompat.widget.C0251z;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.h;
import com.google.android.material.textview.MaterialTextView;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends l {
    @Override // androidx.appcompat.app.l
    protected C0230d createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new h(context, attributeSet);
    }

    @Override // androidx.appcompat.app.l
    protected AppCompatButton createButton(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.l
    protected AppCompatCheckBox createCheckBox(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.l
    protected AppCompatRadioButton createRadioButton(Context context, AttributeSet attributeSet) {
        return new Q0.a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.l
    protected C0251z createTextView(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
