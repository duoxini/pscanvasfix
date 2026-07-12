package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.l;
import com.coui.appcompat.stepper.COUIStepperView;

/* loaded from: classes.dex */
public class COUIStepperPreference extends COUIPreference implements t0.e {

    /* renamed from: e, reason: collision with root package name */
    private COUIStepperView f8693e;

    /* renamed from: f, reason: collision with root package name */
    private t0.e f8694f;

    /* renamed from: g, reason: collision with root package name */
    private int f8695g;

    /* renamed from: h, reason: collision with root package name */
    private int f8696h;

    /* renamed from: i, reason: collision with root package name */
    private int f8697i;

    /* renamed from: j, reason: collision with root package name */
    private int f8698j;

    /* renamed from: k, reason: collision with root package name */
    private int f8699k;

    public COUIStepperPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, W1.a.f2605o);
    }

    @Override // t0.e
    public void a(int i3, int i4) {
        this.f8696h = i3;
        persistInt(i3);
        if (i3 != i4) {
            callChangeListener(Integer.valueOf(i3));
        }
        t0.e eVar = this.f8694f;
        if (eVar != null) {
            eVar.a(i3, i4);
        }
    }

    public void j(int i3) {
        this.f8693e.setCurStep(i3);
    }

    public void k(int i3) {
        this.f8698j = i3;
        this.f8693e.setMaximum(i3);
    }

    public void l(int i3) {
        this.f8699k = i3;
        this.f8693e.setMinimum(i3);
    }

    public void m(int i3) {
        this.f8695g = i3;
        this.f8693e.setUnit(i3);
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        COUIStepperView cOUIStepperView = (COUIStepperView) lVar.b(W1.d.f2665G);
        this.f8693e = cOUIStepperView;
        if (cOUIStepperView != null) {
            k(this.f8698j);
            l(this.f8699k);
            j(this.f8696h);
            m(this.f8695g);
            this.f8693e.setOnStepChangeListener(this);
        }
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        COUIStepperView cOUIStepperView = this.f8693e;
        if (cOUIStepperView != null) {
            cOUIStepperView.z();
        }
    }

    @Override // androidx.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i3) {
        return Integer.valueOf(typedArray.getInt(i3, 0));
    }

    @Override // androidx.preference.Preference
    protected void onSetInitialValue(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        this.f8696h = getPersistedInt(((Integer) obj).intValue());
    }

    public COUIStepperPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, W1.g.f2727m);
    }

    public COUIStepperPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, W1.h.f2762P0, i3, i4);
        this.f8698j = obtainStyledAttributes.getInt(W1.h.f2766R0, 9999);
        this.f8699k = obtainStyledAttributes.getInt(W1.h.f2768S0, -999);
        int i5 = obtainStyledAttributes.getInt(W1.h.f2764Q0, 0);
        this.f8696h = i5;
        this.f8697i = i5;
        this.f8695g = obtainStyledAttributes.getInt(W1.h.f2770T0, 1);
        obtainStyledAttributes.recycle();
    }
}
