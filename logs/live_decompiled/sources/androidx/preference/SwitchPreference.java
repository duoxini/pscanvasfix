package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: j, reason: collision with root package name */
    private final a f5943j;

    /* renamed from: k, reason: collision with root package name */
    private CharSequence f5944k;

    /* renamed from: l, reason: collision with root package name */
    private CharSequence f5945l;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (SwitchPreference.this.callChangeListener(Boolean.valueOf(z3))) {
                SwitchPreference.this.j(z3);
            } else {
                compoundButton.setChecked(!z3);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5943j = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6085I1, i3, i4);
        m(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6109Q1, s.f6088J1));
        l(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6106P1, s.f6091K1));
        q(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6115S1, s.f6097M1));
        p(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6112R1, s.f6100N1));
        k(androidx.core.content.res.i.b(obtainStyledAttributes, s.f6103O1, s.f6094L1, false));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void r(View view) {
        boolean z3 = view instanceof Switch;
        if (z3) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f5951e);
        }
        if (z3) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.f5944k);
            r4.setTextOff(this.f5945l);
            r4.setOnCheckedChangeListener(this.f5943j);
        }
    }

    private void s(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            r(view.findViewById(R.id.switch_widget));
            n(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        r(lVar.b(R.id.switch_widget));
        o(lVar);
    }

    public void p(CharSequence charSequence) {
        this.f5945l = charSequence;
        notifyChanged();
    }

    @Override // androidx.preference.Preference
    protected void performClick(View view) {
        super.performClick(view);
        s(view);
    }

    public void q(CharSequence charSequence) {
        this.f5944k = charSequence;
        notifyChanged();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6041m, R.attr.switchPreferenceStyle));
    }
}
