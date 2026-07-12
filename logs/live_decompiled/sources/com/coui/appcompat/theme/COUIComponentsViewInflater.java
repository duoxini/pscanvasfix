package com.coui.appcompat.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.l;
import androidx.appcompat.widget.C0251z;
import com.coui.appcompat.textview.COUITextView;

/* loaded from: classes.dex */
public class COUIComponentsViewInflater extends l {
    @Override // androidx.appcompat.app.l
    protected C0251z createTextView(Context context, AttributeSet attributeSet) {
        return new COUITextView(context, attributeSet);
    }
}
