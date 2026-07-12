package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.preference.Preference;
import androidx.preference.l;

/* loaded from: classes.dex */
public class COUIBottomPreference extends Preference {

    /* renamed from: e, reason: collision with root package name */
    private int f8469e;

    public COUIBottomPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(W1.e.f2701c);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, W1.h.f2783b, 0, 0);
        this.f8469e = obtainStyledAttributes.getDimensionPixelSize(W1.h.f2785c, getContext().getResources().getDimensionPixelSize(W1.c.f2625P));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        ViewGroup.LayoutParams layoutParams = lVar.itemView.getLayoutParams();
        int i3 = layoutParams.height;
        int i4 = this.f8469e;
        if (i3 != i4) {
            layoutParams.height = i4;
            lVar.itemView.setLayoutParams(layoutParams);
        }
    }
}
