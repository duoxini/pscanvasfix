package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.l;

/* loaded from: classes.dex */
public class COUISlideSelectPreference extends COUIPreference {

    /* renamed from: e, reason: collision with root package name */
    private int f8680e;

    /* renamed from: f, reason: collision with root package name */
    Context f8681f;

    /* renamed from: g, reason: collision with root package name */
    CharSequence f8682g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f8683h;

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2602l);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        View b3 = lVar.b(W1.d.f2685m);
        if (b3 != null) {
            b3.setTag(new Object());
            int i3 = this.f8680e;
            if (i3 == 1) {
                b3.setClickable(false);
            } else if (i3 == 2) {
                b3.setClickable(true);
            }
        }
        View b4 = lVar.b(W1.d.f2689q);
        if (b4 == null || !(b4 instanceof TextView)) {
            return;
        }
        this.f8683h = (TextView) b4;
        CharSequence charSequence = this.f8682g;
        if (TextUtils.isEmpty(charSequence)) {
            this.f8683h.setVisibility(8);
        } else {
            this.f8683h.setText(charSequence);
            this.f8683h.setVisibility(0);
        }
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2725k);
    }

    public COUISlideSelectPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3);
        this.f8680e = 0;
        this.f8681f = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2758N0, i3, i4);
        this.f8682g = obtainStyledAttributes.getText(W1.h.f2760O0);
        obtainStyledAttributes.recycle();
    }
}
