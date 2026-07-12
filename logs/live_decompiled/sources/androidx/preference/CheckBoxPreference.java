package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: j, reason: collision with root package name */
    private final a f5851j;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (CheckBoxPreference.this.callChangeListener(Boolean.valueOf(z3))) {
                CheckBoxPreference.this.j(z3);
            } else {
                compoundButton.setChecked(!z3);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p(View view) {
        boolean z3 = view instanceof CompoundButton;
        if (z3) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f5951e);
        }
        if (z3) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f5851j);
        }
    }

    private void q(View view) {
        if (((AccessibilityManager) getContext().getSystemService("accessibility")).isEnabled()) {
            p(view.findViewById(R.id.checkbox));
            n(view.findViewById(R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l lVar) {
        super.onBindViewHolder(lVar);
        p(lVar.b(R.id.checkbox));
        o(lVar);
    }

    @Override // androidx.preference.Preference
    protected void performClick(View view) {
        super.performClick(view);
        q(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f5851j = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f6200s, i3, i4);
        m(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6218y, s.f6203t));
        l(androidx.core.content.res.i.f(obtainStyledAttributes, s.f6215x, s.f6206u));
        k(androidx.core.content.res.i.b(obtainStyledAttributes, s.f6212w, s.f6209v, false));
        obtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.i.a(context, m.f6029a, R.attr.checkBoxPreferenceStyle));
    }
}
