package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.preference.l;

/* loaded from: classes.dex */
public class COUIPagerFooterPreference extends Preference {

    /* renamed from: e, reason: collision with root package name */
    private boolean f8639e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8640f;

    public COUIPagerFooterPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8639e = true;
        setLayoutResource(W1.e.f2699a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2777X, 0, 0);
        this.f8639e = obtainStyledAttributes.getBoolean(W1.h.f2779Y, this.f8639e);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, W1.h.f2780Z, 0, 0);
        this.f8640f = obtainStyledAttributes2.getBoolean(W1.h.f2794g0, false);
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        if (lVar.itemView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) lVar.itemView.getLayoutParams();
            if (this.f8639e) {
                marginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(W1.c.f2626Q);
            } else {
                marginLayoutParams.bottomMargin = 0;
            }
            lVar.itemView.setLayoutParams(marginLayoutParams);
        }
        if (this.f8640f) {
            j.e(getContext(), lVar);
        }
    }
}
