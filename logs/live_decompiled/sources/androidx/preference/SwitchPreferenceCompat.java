package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: j, reason: collision with root package name */
    private final a f5947j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f5948k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f5949l;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (SwitchPreferenceCompat.this.callChangeListener(Boolean.valueOf(z3))) {
                SwitchPreferenceCompat.this.j(z3);
            } else {
                compoundButton.setChecked(!z3);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5947j = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6118T1, i3, i4);
        m(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6144b2, s.f6121U1));
        l(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6140a2, s.f6124V1));
        q(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6152d2, s.f6130X1));
        p(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6148c2, s.f6133Y1));
        k(androidx.core.content.res.i.b(obtainStyledAttributes, s.f6136Z1, s.f6127W1, false));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(View view) {
        boolean z3 = view instanceof SwitchCompat;
        if (z3) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f5951e);
        }
        if (z3) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f5948k);
            switchCompat.setTextOff(this.f5949l);
            switchCompat.setOnCheckedChangeListener(this.f5947j);
        }
    }

    private void s(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            r(view.findViewById(o.f6048f));
            n(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        r(lVar.b(o.f6048f));
        o(lVar);
    }

    public void p(CharSequence charSequence) {
        this.f5949l = charSequence;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    protected void performClick(View view) {
        super.performClick(view);
        s(view);
    }

    public void q(CharSequence charSequence) {
        this.f5948k = charSequence;
        notifyChanged();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.f6040l);
    }
}
