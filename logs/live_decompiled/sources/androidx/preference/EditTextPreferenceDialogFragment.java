package androidx.preference;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

@Deprecated
/* loaded from: classes.dex */
public class EditTextPreferenceDialogFragment extends PreferenceDialogFragment {

    /* renamed from: m, reason: collision with root package name */
    private EditText f5867m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f5868n;

    @Deprecated
    public EditTextPreferenceDialogFragment() {
    }

    private EditTextPreference h() {
        return (EditTextPreference) a();
    }

    public static EditTextPreferenceDialogFragment i(String str) {
        EditTextPreferenceDialogFragment editTextPreferenceDialogFragment = new EditTextPreferenceDialogFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        editTextPreferenceDialogFragment.setArguments(bundle);
        return editTextPreferenceDialogFragment;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected boolean b() {
        return true;
    }

    @Override // androidx.preference.PreferenceDialogFragment
    protected void c(View view) {
        super.c(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f5867m = editText;
        editText.requestFocus();
        EditText editText2 = this.f5867m;
        if (editText2 == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText2.setText(this.f5868n);
        EditText editText3 = this.f5867m;
        editText3.setSelection(editText3.getText().length());
    }

    @Override // androidx.preference.PreferenceDialogFragment
    public void e(boolean z3) {
        if (z3) {
            String obj = this.f5867m.getText().toString();
            if (h().callChangeListener(obj)) {
                h().q(obj);
            }
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f5868n = h().p();
        } else {
            this.f5868n = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f5868n);
    }
}
