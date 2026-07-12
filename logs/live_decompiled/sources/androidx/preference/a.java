package androidx.preference;

import android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/* loaded from: classes.dex */
public class a extends f {

    /* renamed from: m, reason: collision with root package name */
    private EditText f5957m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f5958n;

    private EditTextPreference p() {
        return (EditTextPreference) i();
    }

    public static a q(String str) {
        a aVar = new a();
        Bundle bundle = new Bundle(1);
        bundle.putString("key", str);
        aVar.setArguments(bundle);
        return aVar;
    }

    @Override // androidx.preference.f
    protected boolean j() {
        return true;
    }

    @Override // androidx.preference.f
    protected void k(View view) {
        super.k(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.f5957m = editText;
        if (editText == null) {
            throw new IllegalStateException("Dialog view must contain an EditText with id @android:id/edit");
        }
        editText.requestFocus();
        this.f5957m.setText(this.f5958n);
        EditText editText2 = this.f5957m;
        editText2.setSelection(editText2.getText().length());
        p().o();
    }

    @Override // androidx.preference.f
    public void m(boolean z3) {
        if (z3) {
            String obj = this.f5957m.getText().toString();
            EditTextPreference p3 = p();
            if (p3.callChangeListener(obj)) {
                p3.q(obj);
            }
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f5958n = p().p();
        } else {
            this.f5958n = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // androidx.preference.f, androidx.fragment.app.d, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.f5958n);
    }
}
